<%@page import="java.sql.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 

    if(request.getParameter("submit")!=null)
    {
        
        String id=request.getParameter("id");
        String name = request.getParameter("name");
        String tell = request.getParameter("tell");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
         String salary = request.getParameter("salary");
        Connection con1;
        PreparedStatement insert;
        
        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection("jdbc:mysql://localhost/cargo","root","");
          
            insert = con1.prepareStatement("insert into Employee values(?,?,?,?,?,?)");
            insert.setString(1,id);
            insert.setString(2,name);
            insert.setString(3,tell);
             insert.setString(4,address);
    
        int val1=Integer.parseInt(salary);
             insert.setString(5,gender);
              insert.setInt(6,val1);
            insert.executeUpdate();
        %> 
    <script>   
        alert("Record Saved");     
    </script>  
<script>window.open('EmployeeView.sp','_self')</script>
    <%             
    }
   %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
     
        
        
<div class="container">
<div class= "row">

<div class="col-lg-8" style =" margin-left: 10%; margin-top: 8%;">

<div class="card">

<div class="card-title">
<h2 class="text-primary"> Employee Registration</h2>
</div>

<div class="card-body">
<div class="input-state">

<form class="form-horizontal" name="test" method ="POST" action="#" >


                <div class ="form-group ">
                      <div class ="row">
                       <label class =" col-sm-3 control-label " >Employee ID </label>
                        <div class ="col-sm-6">
                            <input type ="text" class="form-control" name="id" id="id" placeholder="Enter Employee ID" required ="Employee ID">
                         </div>
						 
                      </div>
               </div>
			   
			       <div class ="form-group ">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Customer Name </label>
                        <div class ="col-sm-6">
                     <input type ="text" class="form-control" name="name" placeholder="Enter Employee Name" id="name"  required ="Employee Name">
                         </div>
						 
                      </div>
               </div>
			       <div class ="form-group ">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Telephone</label>
                        <div class ="col-sm-6">
                     <input type ="text" class="form-control" name="tell" placeholder="Enter Employee Number" id="tell"  required ="Employee Number">
                         </div>
						 
                      </div>
               </div>
			   
			   
			   
                <div class ="form-group">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Address </label>
                        <div class ="col-sm-6">
                     <input type ="text" class="form-control" name="address" placeholder="Enter Employee Address" id="address"  required ="Employee Adress">
                         </div>
						 
                      </div>
               </div>
			   
                <div class ="form-group">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Gender</label>
                        <div class ="col-sm-6">
                     <input type ="input" class="form-control" name="gender" placeholder="Enter Gender Type"  id="gender" required ="Gender Type">
                         </div>
						 
                      </div>
               </div>
     <div class ="form-group">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Salary</label>
                        <div class ="col-sm-6">
                     <input type ="input" class="form-control" name="salary" placeholder="Enter Employee Salary"  id="salary" required ="Employee Salary">
                         </div>
						 
                      </div>
               </div>
		
				

<button type="submit" name ="submit" class="btn btn-info form-control col-xl-9">Save</button>


</form>

</div>

</div>

</div>

</div>

</div>

</div>
    </body>
</html>
