package utils;

/**
 * Created by fanqingbo on 2017/6/15.
 */
public class Collect {
    public static void main(String[] args) {
        int capacity = 1;
        while (capacity < 10) {

            capacity <<= 1;
            System.out.println(capacity);
        }


    }

}
