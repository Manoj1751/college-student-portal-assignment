package com.college;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/file")
public class FileServlet extends HttpServlet {
 @Override protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
  int id;try{id=Integer.parseInt(req.getParameter("id"));}catch(Exception e){resp.sendError(400,"Invalid file ID");return;}
  String sql="SELECT stored_name,original_name,file_type FROM student_files WHERE id=?";
  try(Connection c=DB.getConnection();PreparedStatement ps=c.prepareStatement(sql)){ps.setInt(1,id);try(ResultSet rs=ps.executeQuery()){
   if(!rs.next()){resp.sendError(404,"File not found");return;}
   String stored=Paths.get(rs.getString("stored_name")).getFileName().toString();String type=rs.getString("file_type");String original=rs.getString("original_name");String root=getServletContext().getInitParameter("uploadDirectory");
   if(root==null||root.trim().isEmpty()){resp.sendError(500,"Configure uploadDirectory in WEB-INF/web.xml");return;}
   Path base=Paths.get(root).toAbsolutePath().normalize(),file=base.resolve(stored).normalize();if(!file.startsWith(base)||!Files.isRegularFile(file)){resp.sendError(404,"Stored file is missing");return;}
   resp.setContentType(type);resp.setHeader("X-Content-Type-Options","nosniff");resp.setHeader("Content-Disposition","inline; filename*=UTF-8''"+java.net.URLEncoder.encode(original,"UTF-8").replace("+","%20"));try(InputStream in=Files.newInputStream(file)){in.transferTo(resp.getOutputStream());}
  }}catch(SQLException e){throw new ServletException("Unable to stream file",e);}
 }
}
