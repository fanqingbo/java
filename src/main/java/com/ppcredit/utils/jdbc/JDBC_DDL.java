package com.ppcredit.utils.jdbc;


public class JDBC_DDL {
    /**
     * 获取数据
     */
    /**public static ArrayList<JobHistory> getAllFromJobHistory() {
     Connection conn = getConn();
     String sql = "select jobid from jobhistory";
     PreparedStatement pstmt;
     ArrayList<JobHistory> list = new ArrayList<JobHistory>();
     JobHistory job = null;
     try {
     pstmt = (PreparedStatement)conn.prepareStatement(sql);
     ResultSet rs = pstmt.executeQuery();
     while(rs.next()) {
     job = new JobHistory(rs.getString("jobid"));
     list.add(job);
     }
     pstmt.close();
     conn.close();

     } catch (SQLException e) {
     e.printStackTrace();
     }
     return list;
     }*/

    /**
     * 插入函数
     * @param job
     */
    /**public static void insertJobHistory(JobHistory job) {
     Connection conn = getConn();
     int i = 0;
     String sql = "insert into jobhistory (jobid,submitTime,startTime,finishTime,name,queue,user,state,mapsTotal,mapsCompleted,reducesTotal,reducesCompleted) values(?,?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement pstmt;
     try {
     pstmt = (PreparedStatement) conn.prepareStatement(sql);
     pstmt.setString(1, job.getId());
     pstmt.setString(2, job.getSubmitTime());
     pstmt.setString(3, job.getStartTime());
     pstmt.setString(4, job.getFinishTime());
     pstmt.setString(5, job.getName());
     pstmt.setString(6, job.getQueue());
     pstmt.setString(7, job.getUser());
     pstmt.setString(8, job.getState());
     pstmt.setString(9, job.getMapsTotal());
     pstmt.setString(10, job.getMapsCompleted());
     pstmt.setString(11, job.getReducesTotal());
     pstmt.setString(12, job.getReducesCompleted());
     i = pstmt.executeUpdate();
     pstmt.close();
     conn.close();
     } catch (SQLException e) {
     e.printStackTrace();
     }
     }*/

    /**
     * 更新表函数
     * @param sql
     */
    /**public static void update( String sql) {
     Connection conn = getConn();
     int i = 0;
     PreparedStatement pstmt;
     try {
     pstmt = (PreparedStatement) conn.prepareStatement(sql);
     i = pstmt.executeUpdate();
     pstmt.close();
     conn.close();
     } catch (SQLException e) {
     e.printStackTrace();
     }
     }*/

}
