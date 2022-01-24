package org.apache.jsp.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class custInsert_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \n");
      out.write("\n");
 

    if(request.getParameter("submit")!=null)
    {
        String name = request.getParameter("name");
        String tell = request.getParameter("tell");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        Connection con1;
        PreparedStatement insert;
        
        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
          
            insert = con1.prepareStatement("insert into customer (cust_name,cust_tell,cust_address,Gender )values(?,?,?,?)");
         
            insert.setString(1,name);
            insert.setString(2,tell);
             insert.setString(3,address);
              
             insert.setString(4,gender);
             
            insert.executeUpdate();
        
      out.write(" \n");
      out.write("    <script>   \n");
      out.write("        alert(\"Record Saved\");     \n");
      out.write("    </script> \n");
      out.write("    ");
             
    }
   
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("         <link href=\"../bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"../bootstrap/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("     \n");
      out.write("        \n");
      out.write("        \n");
      out.write("<div class=\"container\">\n");
      out.write("<div class= \"row\">\n");
      out.write("\n");
      out.write("<div class=\"col-lg-8\" style =\" margin-left: 10%; margin-top: 8%;\">\n");
      out.write("\n");
      out.write("<div class=\"card\">\n");
      out.write("\n");
      out.write("<div class=\"card-title\">\n");
      out.write("<h2 class=\"text-primary\"> Customer Registration</h2>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"card-body\">\n");
      out.write("<div class=\"input-state\">\n");
      out.write("\n");
      out.write("<form class=\"form-horizontal\" name=\"test\" method =\"POST\" action=\"#\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t   \n");
      out.write("\t\t\t       <div class =\"form-group \">\n");
      out.write("                      <div class =\"row\">\n");
      out.write("                       <label class =\" col-sm-3 control-label\"> Customer Name </label>\n");
      out.write("                        <div class =\"col-sm-6\">\n");
      out.write("                     <input type =\"text\" class=\"form-control\" name=\"name\" placeholder=\"Enter Customer Name\" id=\"name\"  required =\"Customer Name\">\n");
      out.write("                         </div>\n");
      out.write("\t\t\t\t\t\t \n");
      out.write("                      </div>\n");
      out.write("               </div>\n");
      out.write("\t\t\t       <div class =\"form-group \">\n");
      out.write("                      <div class =\"row\">\n");
      out.write("                       <label class =\" col-sm-3 control-label\"> Telephone</label>\n");
      out.write("                        <div class =\"col-sm-6\">\n");
      out.write("                     <input type =\"text\" class=\"form-control\" name=\"tell\" placeholder=\"Enter Customer Number\" id=\"tell\"  required =\"Customer Number\">\n");
      out.write("                         </div>\n");
      out.write("\t\t\t\t\t\t \n");
      out.write("                      </div>\n");
      out.write("               </div>\n");
      out.write("\t\t\t   \n");
      out.write("\t\t\t   \n");
      out.write("\t\t\t   \n");
      out.write("                <div class =\"form-group\">\n");
      out.write("                      <div class =\"row\">\n");
      out.write("                       <label class =\" col-sm-3 control-label\"> Address </label>\n");
      out.write("                        <div class =\"col-sm-6\">\n");
      out.write("                     <input type =\"text\" class=\"form-control\" name=\"address\" placeholder=\"Enter Customer Address\" id=\"address\"  required =\"Customer Adress\">\n");
      out.write("                         </div>\n");
      out.write("\t\t\t\t\t\t \n");
      out.write("                      </div>\n");
      out.write("               </div>\n");
      out.write("\t\t\t   \n");
      out.write("                <div class =\"form-group\">\n");
      out.write("                      <div class =\"row\">\n");
      out.write("                       <label class =\" col-sm-3 control-label\"> Gender</label>\n");
      out.write("                        <div class =\"col-sm-6\">\n");
      out.write("                    \n");
      out.write("                     <select name=\"gender\">\n");
      out.write("                         <option>Male</option>\n");
      out.write("                         <option>Female</option>\n");
      out.write("                       \n");
      out.write("                     </select>\n");
      out.write("                        \n");
      out.write("                        </div>\n");
      out.write("\t\t\t\t\t\t \n");
      out.write("                      </div>\n");
      out.write("               </div>\n");
      out.write("\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\n");
      out.write("<button type=\"submit\" name =\"submit\" class=\"btn btn-info form-control col-xl-9\">Save</button>\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
