package com.solarexsoft.test.enumtest;

/**
 * Created by houruhou on 2019/2/22.
 * Desc:
 */
public class TestEnum {
    enum Types{
        Food,
        Sport,
        Sleep;
    }

    enum Emotion {
        Happy("喜");
        private String mDesc;
        Emotion(String desc) {
            mDesc = desc;
        }
        public String getDesc() {
            return mDesc;
        }
    }

    public static void main(String[] args) {
        System.out.println(Types.Food.name());
        System.out.println(Types.Sport.name());
        System.out.println(Types.Sleep.name());
        System.out.println(Emotion.Happy.name());
        System.out.println(Emotion.Happy.getDesc());
    }
}
