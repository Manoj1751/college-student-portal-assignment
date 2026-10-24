package com.college;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
@WebFilter(urlPatterns={"/students","/file"})
public class AuthFilter implements Filter {
 @Override public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)throws IOException,ServletException {
  HttpServletRequest req=(HttpServletRequest)request; HttpServletResponse resp=(HttpServletResponse)response;
  HttpSession session=req.getSession(false);
  if(session==null||session.getAttribute("username")==null){resp.sendRedirect(req.getContextPath()+"/login");return;}
  chain.doFilter(request,response);
 }
}
