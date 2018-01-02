package com.ppcredit.utils.jdbc;

import java.sql.*;

/**
 * jdbc 通用链接
 */
public class JDBCUtils {
    private static String url = "jdbc:mysql://192.168.213.29 :3306/portal";
    private static String username = "ppc_portal";
    private static String password = "MF5[V{r9Y4vj;79[26Km";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private JDBCUtils() {
    }

    /**
     * 建立连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);

    }

    /**
     * 释放资源
     *
     * @param rs
     * @param st
     * @param conn
     */
    public static void free(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        }
    }


}
