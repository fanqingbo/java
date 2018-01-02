import java.util.StringTokenizer;

public class Test1 {


    public static void main(String[] args) {

//        String s = new String("This is a test string");
        String str = "100|66,55:200|567,90:102|43,54";
        StringTokenizer st = new StringTokenizer(str);
        System.out.println("Token Total: " + st.countTokens());
        while (st.hasMoreElements()) {
            System.out.println(st.nextToken());
        }
    }
}
