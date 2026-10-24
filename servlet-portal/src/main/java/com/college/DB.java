package com.college;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public final class DB {
  private DB() {}
  public static Connection getConnection() throws SQLException {
    String url=System.getProperty("student.db.url","jdbc:mysql://localhost:3306/student_portal?useSSL=false&serverTimezone=UTC");
    String user=System.getProperty("student.db.user","root");
    String pass=System.getProperty("student.db.password","");
    return DriverManager.getConnection(url,user,pass);
  }
}
