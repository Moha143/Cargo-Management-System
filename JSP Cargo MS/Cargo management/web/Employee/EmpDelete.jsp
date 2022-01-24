<%@page import="java.sql.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
   String id=request.getParameter("id");
     
        Connection con1;
        PreparedStatement insert;
        
        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
          
            insert = con1.prepareStatement("Delete from employee where emp_id=?");
            insert.setString(1,id);
            
            insert.executeUpdate();
        %> 
    <script>   
        alert("Record Deleted");     
    </script> 

   