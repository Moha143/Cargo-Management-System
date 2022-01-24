
<%@page import="java.sql.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer View </title>
        <link href="../bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <div class="page-wrapper">
            <div class="container-fluid">
                <!-- Start Page Content -->

                <!-- /# row -->
                <div class="card" style="margin:5%">
                    <div class="card-body" style="padding: 5%">

                        <a href="custInsert.jsp"><button class="btn btn-info ">Add Customer</button></a>

                        <div class="table-responsive m-t-30">
                            
                            <table  id="myTable" class="table table-bordered table-hover" >
                                <thead >
                                    <tr>
                                <thead>
                                    <tr>
                                        <th> Customer ID</th>
                                        <th>Customer Name</th>
                                        <th>Telephone</th>
                                        <th>Address</th>
                                        <th>Gender</th>
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
          
                                  String query = "select * from customers";
                                  Statement st = con1.createStatement();
                                  
                                    rs =  st.executeQuery(query);
                                    
                                        while(rs.next())
                                        {
                                            String id = rs.getString("cust_id");
                                   %>
                                    <tr>
                                              <td><%=rs.getString("cust_id") %></td>
                                 <td><%=rs.getString("cust_name") %></td>
                                   <td><%=rs.getString("cust_tell") %></td>
                                 <td><%=rs.getString("cust_address") %></td>
                               
                                 <td><%=rs.getString("Gender") %></td>
                                 <td>
                                    
                                     
                                 
                                 <a   class="btn btn-danger"  href="CustDelete.jsp?id=<%=id%>">Delete</a>
                                
                                  <a class="btn btn-primary" href="update.jsp?id=<%=id%>">Edit</a></td>
                                </tr>
                                 <%
                                 
                                 }
                               %>
                                <tfoot>
                                    <tr>
                                        <th> Customer ID</th>
                                        <th>Customer Name</th>
                                        <th>Telephone</th>
                                        <th>Address</th>
                                        <th>Gender</th>

                                        <th>Action</th>
                                    </tr>

                                </tfoot>
                                </tbody>

                                </body>
                                </html>
