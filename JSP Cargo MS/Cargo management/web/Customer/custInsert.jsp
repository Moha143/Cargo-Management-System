<%@page import="java.sql.*" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 

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
        %> 
    <script>   
        alert("Record Saved");     
    </script> 
    <%             
    }
   %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="../bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
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


			   
			       <div class ="form-group ">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Customer Name </label>
                        <div class ="col-sm-6">
                     <input type ="text" class="form-control" name="name" placeholder="Enter Customer Name" id="name"  required ="Customer Name">
                         </div>
						 
                      </div>
               </div>
			       <div class ="form-group ">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Telephone</label>
                        <div class ="col-sm-6">
                     <input type ="text" class="form-control" name="tell" placeholder="Enter Customer Number" id="tell"  required ="Customer Number">
                         </div>
						 
                      </div>
               </div>
			   
			   
			   
                <div class ="form-group">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Address </label>
                        <div class ="col-sm-6">
                     <input type ="text" class="form-control" name="address" placeholder="Enter Customer Address" id="address"  required ="Customer Adress">
                         </div>
						 
                      </div>
               </div>
			   
                <div class ="form-group">
                      <div class ="row">
                       <label class =" col-sm-3 control-label"> Gender</label>
                        <div class ="col-sm-6">
                    
                     <select name="gender">
                         <option>Male</option>
                         <option>Female</option>
                       
                     </select>
                        
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
