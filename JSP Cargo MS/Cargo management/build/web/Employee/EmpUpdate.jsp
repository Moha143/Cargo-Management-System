<%@page import="java.sql.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getParameter("submit") != null) {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String tell = request.getParameter("tell");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
          String salary = request.getParameter("salary");
        Connection con1;
        PreparedStatement insert;

        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo", "root", "");
        insert = con1.prepareStatement("update employee set  emp_name= ?, emp_tell= ?,emp_address= ? ,Gender=? ,Salary=? where emp_id= ?");
        insert.setString(1, name);
        insert.setString(2, tell);
        insert.setString(3, address);
        insert.setString(4, gender);
          insert.setString(4, salary);
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
<h2 class="text-primary"> Employee Updating</h2>
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

    pst = con1.prepareStatement("select * from employee where emp_id = ?");
        pst.setString(1, id);
               rs = pst.executeQuery();

      while (rs.next()) {

                                    %>
       <div class ="form-group ">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Employee ID </label>
                        <div class ="col-sm-6">
                    <input type="text" class="form-control" placeholder="Employee ID" value="<%= rs.getString("emp_id")%>" name="id" id="id" required ="Employee ID" >
                     
                         </div>
						 
                      </div>
               </div>
			   
			       <div class ="form-group ">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Employee Name </label>
                        <div class ="col-sm-6">
                           <input type="text" class="form-control" placeholder="Employee Name" value="<%= rs.getString("emp_name")%>" name="name" id="name" required="Employee Name" >
                    
                        </div>
						 
                      </div>
               </div>
			       <div class ="form-group ">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Telephone</label>
                        <div class ="col-sm-6">
                     <input type="text" class="form-control" placeholder="Employee Phone" name="tell" value="<%= rs.getString("emp_tell")%>" id="tell" required="Employee Phone" >
                     
                        </div>
						 
                      </div>
               </div>
                <div class ="form-group">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Address </label>
                        <div class ="col-sm-6">
                    <input type="text" class="form-control" placeholder="Address" name="address" id="address" value="<%= rs.getString("emp_address")%>" required="Employee Address" >
                     
                        </div>
						 
                      </div>
               </div>
			   
                <div class ="form-group">
                      <div class ="row">
                       <label class =" col-sm-3 control-label" > Gender</label>
                        <div class ="col-sm-6">
                    <input type="text" class="form-control" placeholder="Gender" name="gender" id="gender" value="<%= rs.getString("Gender")%>" required="Gender type" >
                   
                        </div>
						 
                      </div>
               </div>
                         
                        <div class ="form-group">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Salary</label>
                        <div class ="col-sm-6">
                     <input type ="input" class="form-control"  value="<%= rs.getString("Salary")%>" name="salary" placeholder="Enter Employee Salary"  id="salary" required ="Salary">
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
