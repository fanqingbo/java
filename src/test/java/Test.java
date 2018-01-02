import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;


/**
 * Created by fanqingbo on 2017/4/13.
 */
public class Test {
    public static void main(String[] args) {
        int num = 3;
        List list = new ArrayList();
        list.add(2);
        list.add(3);
        list.add(4);

        int a = 0;
        int b = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                list.get(i);
                a += Integer.parseInt((String) list.get(i));

            } else {
                b += Integer.valueOf((String) list.get(i)).intValue();

            }
        }

        if (a > b) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static int getNum(int str) {
        int n = Integer.valueOf(str);
        int count = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                for (int c = 1; c <= n; c++) {
                    for (int d = 1; d <= n; d++) {
                        if (pow(a, b) == pow(c, d)) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
        return count;
    }
}
