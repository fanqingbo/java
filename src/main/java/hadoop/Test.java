package hadoop;

import org.apache.hadoop.conf.Configuration;

/**
 * Created by fanqingbo on 2017/6/22.
 */
public class Test {

//    static{
//        //print deprecation warning if hadoop-site.xml is found in classpath
//        ClassLoader cL = Thread.currentThread().getContextClassLoader();
//        if (cL == null) {
//            cL = Configuration.class.getClassLoader();
//        }
//        if(cL.getResource("hadoop-site.xml")!=null) {
//            LOG.warn("DEPRECATED: hadoop-site.xml found in the classpath. " +
//                    "Usage of hadoop-site.xml is deprecated. Instead use core-site.xml, "
//                    + "mapred-site.xml and hdfs-site.xml to override properties of " +
//                    "core-default.xml, mapred-default.xml and hdfs-default.xml " +
//                    "respectively");
//        }
//        addDefaultResource("core-default.xml");
//        addDefaultResource("core-site.xml");
//    }
//
//
//    static private ClassLoader classLoader;
//    {
//        classLoader = Thread.currentThread().getContextClassLoader();
//        if (classLoader == null) {
//            classLoader = Configuration.class.getClassLoader();
//        }
//    }


    public static void main(String[] args) {

        Configuration conf = new Configuration();
//        System.out.println(classLoader);
        conf.addResource("f");


    }

}
