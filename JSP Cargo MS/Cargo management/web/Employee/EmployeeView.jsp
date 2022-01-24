
<%@page import="java.sql.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee View </title>
       
        <link href="../bootstrap/css/lib/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div class="page-wrapper">
            <div class="container-fluid">
                <!-- Start Page Content -->

                <!-- /# row -->
                <div class="card" style="margin:5%">
                    <div class="card-title">Employee View</div> 
                    <div class="card-body" style="padding: 5%">

                        <a href="EmpInsert.jsp"><button class="btn btn-info ">Add Employee</button></a>
                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="dataTables-example">

                        <div class="table-responsive m-t-30">
                            
                            <table  id="myTable" class="table table-bordered table-hover" >
                                <thead >
                                    <tr>
                                <thead>
                                    <tr>
                                        <th> Employee ID</th>
                                        <th>Employee Name</th>
                                        <th>Telephone</th>
                                        <th>Address</th>
                                        <th>Gender</th>
                                         <th>Salary</th>

                                        <th>Action</th>
                                    </tr>

                                </thead>
                                
                                <tbody>
                                           <%   

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
                                   %>
                                    <tr>
                                              <td><%=rs.getString("emp_id") %></td>
                                 <td><%=rs.getString("emp_name") %></td>
                                   <td><%=rs.getString("emp_tell") %></td>
                                 <td><%=rs.getString("emp_address") %></td>
                               
                                 <td><%=rs.getString("Gender") %></td>
                                  <td><%=rs.getString("Salary") %></td>
                                 <td>
                                     <a   class="btn btn-primary"  href="EmpUpdate.jsp?id=<%=id%>">Edit</a>
                                 
                                 <a   class="btn btn-danger"  href="EmpDelete.jsp?id=<%=id%>">Delete</a>
                                 </td>
                                  


                                </tr>
                                 <%
                                 
                                 }
                               %>
                                <tfoot>
                                    <tr>
                                        <th> Employee ID</th>
                                        <th>Employee Name</th>
                                        <th>Telephone</th>
                                        <th>Address</th>
                                        <th>Gender</th>
                                         <th>Salary</th>

                                        <th>Action</th>
                                    </tr>

                                </tfoot>
                                </tbody>

                                </body>
                                </html>
