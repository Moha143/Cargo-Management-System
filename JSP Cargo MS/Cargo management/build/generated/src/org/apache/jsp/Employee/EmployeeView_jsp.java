package org.apache.jsp.Employee;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class EmployeeView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Employee View </title>\n");
      out.write("       \n");
      out.write("        <link href=\"../bootstrap/css/lib/bootstrap/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"page-wrapper\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <!-- Start Page Content -->\n");
      out.write("\n");
      out.write("                <!-- /# row -->\n");
      out.write("                <div class=\"card\" style=\"margin:5%\">\n");
      out.write("                    <div class=\"card-title\">Employee View</div> \n");
      out.write("                    <div class=\"card-body\" style=\"padding: 5%\">\n");
      out.write("\n");
      out.write("                        <a href=\"EmpInsert.jsp\"><button class=\"btn btn-info \">Add Employee</button></a>\n");
      out.write("                        <input type=\"search\" class=\"form-control input-sm\" placeholder=\"\" aria-controls=\"dataTables-example\">\n");
      out.write("\n");
      out.write("                        <div class=\"table-responsive m-t-30\">\n");
      out.write("                            \n");
      out.write("                            <table  id=\"myTable\" class=\"table table-bordered table-hover\" >\n");
      out.write("                                <thead >\n");
      out.write("                                    <tr>\n");
      out.write("                                <thead>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th> Employee ID</th>\n");
      out.write("                                        <th>Employee Name</th>\n");
      out.write("                                        <th>Telephone</th>\n");
      out.write("                                        <th>Address</th>\n");
      out.write("                                        <th>Gender</th>\n");
      out.write("                                         <th>Salary</th>\n");
      out.write("\n");
      out.write("                                        <th>Action</th>\n");
      out.write("                                    </tr>\n");
      out.write("\n");
      out.write("                                </thead>\n");
      out.write("                                \n");
      out.write("                                <tbody>\n");
      out.write("                                           ");
   

                                Connection con1;
                                PreparedStatement pst;
                                ResultSet rs;
        
                              
                               Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
          
                                  String query = "select * from employee";
                                  Statement st = con1.createStatement();
                                  
                                    rs =  st.executeQuery(query);
                                    
                                        while(rs.next())
                                        {
                                            String id = rs.getString("emp_id");
                                   
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                              <td>");
      out.print(rs.getString("emp_id") );
      out.write("</td>\n");
      out.write("                                 <td>");
      out.print(rs.getString("emp_name") );
      out.write("</td>\n");
      out.write("                                   <td>");
      out.print(rs.getString("emp_tell") );
      out.write("</td>\n");
      out.write("                                 <td>");
      out.print(rs.getString("emp_address") );
      out.write("</td>\n");
      out.write("                               \n");
      out.write("                                 <td>");
      out.print(rs.getString("Gender") );
      out.write("</td>\n");
      out.write("                                  <td>");
      out.print(rs.getString("Salary") );
      out.write("</td>\n");
      out.write("                                 <td>\n");
      out.write("                                     <a   class=\"btn btn-primary\"  href=\"EmpUpdate.jsp?id=");
      out.print(id);
      out.write("\">Edit</a>\n");
      out.write("                                 \n");
      out.write("                                 <a   class=\"btn btn-danger\"  href=\"EmpDelete.jsp?id=");
      out.print(id);
      out.write("\">Delete</a>\n");
      out.write("                                 </td>\n");
      out.write("                                  \n");
      out.write("\n");
      out.write("\n");
      out.write("                                </tr>\n");
      out.write("                                 ");

                                 
                                 }
                               
      out.write("\n");
      out.write("                                <tfoot>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th> Employee ID</th>\n");
      out.write("                                        <th>Employee Name</th>\n");
      out.write("                                        <th>Telephone</th>\n");
      out.write("                                        <th>Address</th>\n");
      out.write("                                        <th>Gender</th>\n");
      out.write("                                         <th>Salary</th>\n");
      out.write("\n");
      out.write("                                        <th>Action</th>\n");
      out.write("                                    </tr>\n");
      out.write("\n");
      out.write("                                </tfoot>\n");
      out.write("                                </tbody>\n");
      out.write("\n");
      out.write("                                </body>\n");
      out.write("                                </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
