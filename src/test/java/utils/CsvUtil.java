package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 操作excel文件中的.csv
 * Created by fanqingbo on 2017/3/10.
 */
public class CsvUtil {
    private String filename = null;
    private BufferedReader bufferedreader = null;
    private List list = new ArrayList();

    public CsvUtil() {
    }

    public CsvUtil(String filename) throws IOException {
        this.filename = filename;
        bufferedreader = new BufferedReader(new FileReader(filename));
        String stemp;
        while ((stemp = bufferedreader.readLine()) != null) {
            list.add(stemp);
        }
    }

    public static void main(String[] args) throws IOException {
        CsvUtil test = new CsvUtil();
        test.run("D:/alpha/abc.csv");
    }

    public List getList() {
        return list;
    }

    //得到csv文件的行数
    public int getRowNum() {
        return list.size();
    }

//取得指定行的值

    //得到csv文件的列数
    public int getColNum() {
        if (!list.toString().equals("[]")) {
            if (list.get(0).toString().contains(",")) {   //csv文件中，每列之间的是用','来分隔的
                return list.get(0).toString().split(",").length;
            } else if (list.get(0).toString().trim().length() != 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public String getRow(int index) {
        if (this.list.size() != 0)
            return (String) list.get(index);
        else
            return null;
    }

    //取得指定列的值
    public String getCol(int index) {
        if (this.getColNum() == 0) {
            return null;
        }
        StringBuffer scol = new StringBuffer();
        String temp = null;
        int colnum = this.getColNum();
        if (colnum > 1) {
            for (Iterator it = list.iterator(); it.hasNext(); ) {
                temp = it.next().toString();
                scol = scol.append(temp.split(",")[index] + ",");
            }
        } else {
            for (Iterator it = list.iterator(); it.hasNext(); ) {
                temp = it.next().toString();
                scol = scol.append(temp + ",");
            }
        }
        String str = new String(scol.toString());
        str = str.substring(0, str.length() - 1);
        return str;
    }

    //取得指定行，指定列的值
    public String getString(int row, int col) {
        String temp = null;
        int colnum = this.getColNum();
        if (colnum > 1) {
            temp = list.get(row).toString().split(",")[col];
        } else if (colnum == 1) {
            temp = list.get(row).toString();
        } else {
            temp = null;
        }
        return temp;
    }

    public void CsvClose() throws IOException {
        this.bufferedreader.close();
    }

    public void run(String filename) throws IOException {
        CsvUtil cu = new CsvUtil(filename);
        for (int i = 0; i < cu.getRowNum(); i++) {

            String name = cu.getString(i, 0);//得到第i行.第一列的数据.
            String email = cu.getString(i, 1);//得到第i行.第二列的数据.
            String tel = cu.getString(i, 2);
            String number = cu.getString(i, 3);

            System.out.println("===name:" + name);
            System.out.println("===email:" + email);
            System.out.println("===tel:" + tel);
            System.out.println("===number:" + number);
            System.out.println(" ");
        }
        cu.CsvClose();
    }
}





