package test;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by fanqingbo on 2017/3/10.
 */
public class CSV {


    /**
     * 读取CSV格式的文件
     */
    public static void readeCsv() {
        try {

            ArrayList<String[]> csvList = new ArrayList<String[]>(); //用来保存数据
            String csvFilePath = "c://test1.csv";
            CsvReader reader = new CsvReader(csvFilePath, ',');    //一般用这编码读就可以了

            reader.readHeaders(); // 跳过表头   如果需要表头的话，不要写这句。

            while (reader.readRecord()) { //逐行读入除表头的数据
                csvList.add(reader.getValues());
            }
            reader.close();

            for (int row = 0; row < csvList.size(); row++) {

                String cell = csvList.get(row)[0]; //取得第row行第0列的数据
                System.out.println(cell);

            }


        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * 操作excle中的csv文件
     */

    public static void main(String[] args) {
        readeCsv();
    }

    /**
     * 写入CVS文件
     */
    public void writeCsv() {
        try {

            String csvFilePath = "c:/test.csv";
            CsvWriter wr = new CsvWriter(csvFilePath, ',', Charset.forName("SJIS"));
            String[] contents = {"aaaaa", "bbbbb", "cccccc", "ddddddddd"};
            wr.writeRecord(contents);
            wr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
