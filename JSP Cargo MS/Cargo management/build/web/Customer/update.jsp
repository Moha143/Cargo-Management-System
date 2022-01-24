<%@page import="java.sql.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getParameter("submit") != null) {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String tell = request.getParameter("tell");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        Connection con1;
        PreparedStatement insert;
        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo", "root", "");
        insert = con1.prepareStatement("update customers set  cust_name= ?, cust_tell= ?,cust_address= ? ,Gender=?  where cust_id= ?");
        insert.setString(1, name);
        insert.setString(2, tell);
        insert.setString(3, address);
        insert.setString(4, gender);
         insert.setString(5, id);
        insert.executeUpdate();
%> 
<script>
    alert("Record Updated");
</script> 
<%
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
     
        
        
<div class="container">
<div class= "row">

<div class="col-lg-8" style =" margin-left: 10%; margin-top: 8%;">

<div class="card">

<div class="card-title">
<h2 class="text-primary"> Customer Registration</h2>
</div>

<div class="card-body">
<div class="input-state">

<form class="form-horizontal" name="test" method ="POST" action="#" >
       <%
             Connection con1;
        PreparedStatement pst;
        
        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
          
       String id = request.getParameter("id");

    pst = con1.prepareStatement("select * from customers where cust_id = ?");
        pst.setString(1, id);
               rs = pst.executeQuery();

      while (rs.next()) {

                                    %>
       <div class ="form-group ">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Customer ID </label>
                        <div class ="col-sm-6">
                    <input type="text" class="form-control" placeholder="Customer ID" value="<%= rs.getString("cust_id")%>" name="id" id="id" required ="Customer ID" >
                     
                         </div>
						 
                      </div>
               </div>
			   
			       <div class ="form-group ">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Customer Name </label>
                        <div class ="col-sm-6">
                           <input type="text" class="form-control" placeholder="Customer Name" value="<%= rs.getString("cust_name")%>" name="name" id="name" required >
                    
                        </div>
						 
                      </div>
               </div>
			       <div class ="form-group ">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Telephone</label>
                        <div class ="col-sm-6">
                     <input type="text" class="form-control" placeholder="Customer Phone" name="tell" value="<%= rs.getString("cust_tell")%>" id="tell" required >
                     
                        </div>
						 
                      </div>
               </div>
                <div class ="form-group">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Address </label>
                        <div class ="col-sm-6">
                    <input type="text" class="form-control" placeholder="Address" name="address" id="address" value="<%= rs.getString("cust_address")%>" required >
                     
                        </div>
						 
                      </div>
               </div>
			   
                <div class ="form-group">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Gender</label>
                        <div class ="col-sm-6">
                    
                         <input type="text" class="form-control" placeholder="Gender" name="gender" id="gender" value="<%= rs.getString("Gender")%>" required >
                     
                        </div>
						 
                      </div>
               </div>
                         
		 <% }  %>
                  
                         </br>
                         
				

<button type="submit" name ="submit" class="btn btn-info form-control col-xl-9">Update</button>

</form>

</div>

</div>

</div>

</div>

</div>

</div>
    </body>
</html>
