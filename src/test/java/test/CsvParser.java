//package test;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.csvreader.CsvReader;
//import com.wer.factories.PrintFactory;
///**
// * Created by fanqingbo on 2017/3/10.
// */
//public class CsvParser {
//    private char Seperator = ','; // CSV格式分隔符
//    private String CsvPath = ""; // CSV文件路径
//    private CsvReader reader;
//
//    public CsvParser() {
//        initial();
//    }
//
//    public CsvParser(String path) {
//        this.CsvPath = path;
//        initial();
//    }
//
//    public CsvParser(String path, char sepr) {
//        this.CsvPath = path;
//        this.Seperator = sepr;
//        initial();
//    }
//
//    private void initial() {
//        try {
//            reader = new CsvReader(CsvPath, Seperator, Charset.forName("GBK"));
//        } catch (FileNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    public boolean ifValid()
//    {
//        if(reader==null)
//            return false;
//        return true;
//    }
//
//    /**
//     * 获取CSV文件列头名称数组
//     *
//     * @return String[]
//     * @throws IOException
//     **/
//    public String[] getHeaders(){
//        boolean result = false;
//        if (reader == null)
//            return null;
//        try {
//            result = reader.readHeaders();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            PrintFactory.getInstance().err(e.getMessage());
//        }
//
//        if(result)
//            try {
//                return reader.getHeaders();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                PrintFactory.getInstance().err(e.getMessage());
//            }
//        return null;
//    }
//
//    /**
//     * 获取CSV文件所有值列表
//     *
//     * @return List<Object[]>
//     * @throws IOException
//     */
//    public List<Object[]> getValuesList() throws IOException {
//        if (reader == null)
//            return null;
//        List<Object[]> list = new ArrayList<Object[]>();
//        while (reader.readRecord()) {
//            list.add(reader.getValues());
//        }
//
//        return list;
//    }
//
//    /**
//     * 获取CSV文件所有值数组
//     *
//     * @return String[][]
//     * @throws IOException
//     */
//    public String[][] getValuesArray() throws IOException {
////      List<Object[]> list = getValuesList();
//        try {
//            List<Object[]> list = getValuesList();
//            int size = list.size();
//            if (size <= 0)
//                return null;
//            Object[][] data = new String[size][];
//            Object[] tmp = list.get(0);
//            int colsize = tmp.length;
//
//            if (colsize <= 0)
//                return null;
//            String[][] values = new String[list.size()][colsize];
//            for (int i = 0; i < list.size(); i++) {
//                data[i] = list.get(i);
//
//                for (int m = 0; m < colsize; m++) {
//                    try {
//                        values[i][m] = String.valueOf(data[i][m]);
//                    } catch (NullPointerException e) {
//                        // TODO: handle exception
//                        e.printStackTrace();
//                    }
//                }
//            }
//            return values;
//        } catch (IOException e) {
//            // TODO: handle exception
//        }
//        return null;
//    }
//
//    /**
//     * 获取指定行数组
//     *
//     * @param row
//     * @return String[]
//     * @throws IOException
//     */
//    public String[] getRowData(int row) throws IOException {
//        List<Object[]> list = getValuesList();
//        if (list == null)
//            return null;
//        Object[] objs = list.get(row);
//        if (objs == null)
//            return null;
//        String[] datas = new String[objs.length];
//        for (int i = 0; i < objs.length; i++)
//            datas[i] = objs[i].toString();
//
//        return datas;
//    }
//
//    /**
//     * 获取指定行、列的CSV数据
//     *
//     * @param row
//     *            从0开始
//     * @param col
//     * @return
//     * @throws IOException
//     */
//    public String getCellData(int row, int col) throws IOException {
//        List<Object[]> list = getValuesList();
//        if (list == null)
//            return null;
//        Object[] objs = list.get(row);
//        if (objs == null)
//            return null;
//        Object data = objs[col];
//        if (data == null)
//            return null;
//
//        return data.toString();
//    }
//
//    /**
//     * 获取CSV列长度
//     *
//     * @return int
//     */
//    public int getColumnLength()
//    {
//        if (reader == null)
//            return -1;
//        try {
//            List<Object[]> v = getValuesList();
//            if(v.size()==0)
//                return 0;
//            return v.get(0).length;
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return -1;
//    }
//
//    public int getCLength() {
//        if (reader == null)
//            return -1;
//        return reader.getColumnCount();
//    }
//
//    /**
//     * 获取数据长度
//     *
//     * @return int
//     * @throws IOException
//     */
//    public int getDataLength() throws IOException {
//        List<Object[]> list;
//        if (reader == null)
//            return -1;
//        if ((list = getValuesList()) != null)
//            return list.size();
//        return -1;
//    }
//
//    /**
//     * 根据列头名获取列索引号
//     *
//     * @param head
//     * @return
//     * @throws IOException
//     */
//    public int getColByName(String head) throws IOException {
//        String[] heads = getHeaders();
//        for (int i = 0; i < heads.length; i++) {
//            if (heads[i].equalsIgnoreCase(head))
//                return i;
//        }
//        return -1;
//    }
//
//    /**
//     * 获取指定序号的列头名称
//     *
//     * @param colIndex
//     * @return String
//     * @throws IOException
//     */
//    public String getHeadName(int colIndex) throws IOException {
//        String[] heads = getHeaders();
//        if (heads == null)
//            return null;
//        if (heads.length < colIndex)
//            return null;
//        return heads[colIndex];
//    }
//
//
//}
