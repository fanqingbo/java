package com.ppcredit.base.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * List数据结构
 * ArrayList底层是数组，查询快，增删慢，线程不安全
 * Vector底层是数组，查询快，增删慢，线程安全
 * LinkedList 底层是链表，查询慢，增删快
 */
public class ListClass {

    List list = new ArrayList();
    List list1 = new Vector();


}
