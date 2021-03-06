package com.solarexsoft.kotlinlearning

import java.util.concurrent.CopyOnWriteArrayList

/**
 * Created by Solarex on 2020/4/28/4:29 PM
 * Desc:
 */
data class GuideData(
        var number: Int = 0,
        var type: String = "",
        val predicate: ((Boolean) -> Unit) -> Unit,
        var locked: Boolean = false,
        var requestTime: Int = Int.MAX_VALUE
)

class GuideQueue {
    private val TAG = "GuideQueue"
    private val guideMap = hashMapOf<String, CopyOnWriteArrayList<GuideData>>()

    fun next(token: String) {
        guideMap[token]?.firstOrNull{ !it.locked && it.requestTime > 0}.let {
            guideData ->
            if (guideData == null) {
                println("$TAG should reset")
            } else {
                guideData.locked = true
                guideData.requestTime--
                guideData.predicate.invoke {
                    show: Boolean ->
                    if (!show) {
                        next(token)
                    } else {
                       guideData.locked = false
                    }
                    if (guideData.requestTime == 0) {
                        guideMap[token]?.remove(guideData)
                    }
                }
            }
        }
    }

    fun enqueue(token: String, vararg guideData: GuideData) {
        val queue = guideMap.getOrPut(token, {CopyOnWriteArrayList<GuideData>()})
        for (newGuide in guideData) {
            println("-------------------------")
            println(newGuide)
            if (queue.isEmpty()) {
                queue.add(newGuide)
                println("empty -> $queue")
            } else {
                run breaker@{
                    queue.forEachIndexed{
                        index, guideData ->
                        if (newGuide.number == guideData.number) {
                            println("$index number equals")
                            return@breaker
                        }
                        if (newGuide.number < guideData.number) {
                            println("$index number low")
                            queue.add(index, newGuide)
                            return@breaker
                        }
                        if (index == queue.lastIndex){
                            println("$index lastIndex")
                            queue.add(newGuide)
                        }
                        println("$index -> $queue")
                    }
                }
            }
        }
    }
}
enum class GuideType(val desc: String, val number: Int, val requestTime: Int = Int.MAX_VALUE) {
    TYPE_A("type_a", number = 10),
    TYPE_B("type_b", number = 20),
    TYPE_C("type_c", number = 60, requestTime = 1)
}

fun getGuideData(guideType: GuideType, predicate: ((Boolean) -> Unit) -> Unit): GuideData {
    return GuideData(guideType.number, guideType.desc, predicate = predicate, requestTime = guideType.requestTime)
}
fun typeAPredicate():((Boolean) -> Unit) -> Unit {
    return {
        it.invoke(false)
    }
}

fun main() {
    val queue = GuideQueue()
    queue.enqueue("hello",
            getGuideData(GuideType.TYPE_A, typeAPredicate()),
            getGuideData(GuideType.TYPE_B, typeAPredicate()),
            getGuideData(GuideType.TYPE_C, typeAPredicate())
    )
}