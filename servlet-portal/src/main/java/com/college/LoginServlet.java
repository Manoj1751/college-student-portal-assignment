package com.college;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
 @Override protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
  HttpSession session=req.getSession(false);
  if(session!=null&&session.getAttribute("username")!=null){resp.sendRedirect("students");return;}
  req.getRequestDispatcher("/login.jsp").forward(req,resp);
 }
 @Override protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException {
  String username=req.getParameter("username");
  String expectedUser=System.getProperty("student.portal.username","admin");
  String expectedPass=System.getProperty("student.portal.password","");
  String suppliedPass=req.getParameter("password");
  if(expectedPass.length()>0&&expectedUser.equals(username)&&expectedPass.equals(suppliedPass)){
   req.getSession(true).setAttribute("username",username);resp.sendRedirect("students");return;
  }
  req.setAttribute("error","Invalid login. Configure student.portal.username and student.portal.password on the server.");
  req.getRequestDispatcher("/login.jsp").forward(req,resp);
 }
}
