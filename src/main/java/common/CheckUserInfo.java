package common;

/**
 * Created by fangcj7 on 2017/3/1.
 * 检查用户信息，id ，qq，手机
 */
public class CheckUserInfo {
    //    public static void main(String[] args) {
//        String str = "123";
//        boolean result = isQQ(str);
//        System.out.println(result);
//    }
    public static boolean isIdnumber(String idnumber) {
        boolean result = false;
        result = idnumber.matches("(^\\d{15}$)|(^\\d{17}(\\d|x|X)$)");
        return result;
    }

    public static boolean isQQ(String qq) {
        boolean result = false;
        result = qq.matches("^\\d{5,11}$");
        return result;
    }

    public static boolean isPhone(String phone) {
        boolean result = false;
        result = phone.matches("^[1][3456789][0-9]{9}$");
        return result;
    }


}
