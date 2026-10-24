package com.college;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/students")
public class StudentsServlet extends HttpServlet {
 @Override protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
  List<Map<String,Object>> students=new ArrayList<>();
  String sql="SELECT s.id,s.name,s.roll_number,s.email,s.course,f.id AS file_id,f.original_name,f.file_type FROM students s LEFT JOIN student_files f ON f.id=(SELECT MIN(f2.id) FROM student_files f2 WHERE f2.student_id=s.id) ORDER BY s.created_at DESC";
  try(Connection c=DB.getConnection();PreparedStatement ps=c.prepareStatement(sql);ResultSet rs=ps.executeQuery()){
   while(rs.next()){Map<String,Object> row=new HashMap<>();row.put("id",rs.getInt("id"));row.put("name",rs.getString("name"));row.put("roll",rs.getString("roll_number"));row.put("email",rs.getString("email"));row.put("course",rs.getString("course"));Object fileId=rs.getObject("file_id");row.put("fileId",fileId==null?null:((Number)fileId).intValue());row.put("fileName",rs.getString("original_name"));row.put("fileType",rs.getString("file_type"));students.add(row);}
  }catch(SQLException e){throw new ServletException("Unable to load student records. Check DB settings/schema.",e);}
  req.setAttribute("students",students);req.getRequestDispatcher("/students.jsp").forward(req,resp);
 }
}
