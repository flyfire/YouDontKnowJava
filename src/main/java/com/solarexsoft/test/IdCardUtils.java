package com.solarexsoft.test;


import java.text.SimpleDateFormat;
import java.util.Date;

public class IdCardUtils {
    public static class IdCardInfo {
        private Date birthday;
        // 和familymember一致 0 --> 男性 1 --> 女性
        private Integer sex;

        public IdCardInfo(Date date, Integer sex) {
            this.birthday = date;
            this.sex = sex;
        }

        public Date getBirthday() {
            return birthday;
        }

        public Integer getSex() {
            return sex;
        }
    }

    // 校验身份证合法性 CheckInfoModel checkPersonalType (module_user中)
    // 假设传入的身份证号都是合法的
    public static IdCardInfo getIdCardInfoFromIdCard(String idcard) {
        IdCardInfo idCardInfo = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        int len = idcard.length();
        String birthday = "";
        Date birthDate = null;
        int sex = 0;
        Integer judgesex = 0;
        try {
            if (len == 15) {
                birthday = "19" + idcard.substring(6, 12);
                judgesex = Integer.parseInt(idcard.substring(len - 3, len));
            } else if (len == 18) {
                birthday = idcard.substring(6, 14);
                judgesex = Integer.parseInt(idcard.substring(len - 4, len - 1));
            }
            sex = (judgesex % 2 == 0) ? 1 : 0;
            birthDate = format.parse(birthday);
            idCardInfo = new IdCardInfo(birthDate, sex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idCardInfo;
    }

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        IdCardInfo info = getIdCardInfoFromIdCard("411213198911012911");
        System.out.println(format.format(info.getBirthday()) + "------" + info.getSex());
        info = getIdCardInfoFromIdCard("412825891101291");
        System.out.println(format.format(info.getBirthday()) + "------" + info.getSex());
    }
}
