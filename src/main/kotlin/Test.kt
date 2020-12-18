/**
 * Created by Solarex on 2020/12/18/6:29 PM
 * Desc:
 */
class GenericTest<T, out R : GenericTest<T, R>> internal constructor(builder: Builder<T, R>) {
    internal abstract class Builder<T, R : GenericTest<T, R>> {
        abstract fun build(t: T): R
    }
}