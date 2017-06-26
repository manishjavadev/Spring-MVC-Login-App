<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
  <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
  
  <link href="runnable.css" rel="stylesheet" />
  <!-- Load jQuery and the validate plugin -->
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
  
  <!-- jQuery Form Validation code -->
  <style>
  .label {
  width:100px;
  text-align:right;
  float:left;
  padding-right:10px;
  font-weight:bold;
}
#register-form label.error {
  color:#FB3A3A;
  font-weight:bold;
}
h1 {
  font-family: Helvetica;
  font-weight: 100;
  color:#333;
  padding-bottom:20px;
}
  </style>
  <script>
  
  // When the browser is ready...
  $(function() {
  
    // Setup form validation on the #register-form element
    $("#register-form").validate({
    
        // Specify the validation rules
        rules: {
        	name: "required",
        	contact: "required",
            mail: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 5
            },
            repassword:
            	{
            	required: true,
            	equalTo:password
            	},
            agree: "required"
        },
        
        // Specify the validation error messages
        messages: {
        	name: "Please enter your first name",
        	contact: "Please enter your Contact",
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            repassword: {
                required: "Please re-type password",
                minlength: "Your password should be same"
            },
            mail: "Please enter a valid email address",
            agree: "Please accept our policy"
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });

  });
  
  </script>
</head>
<body>
<form:form action="savesignup" id="register-form" novalidate="novalidate" method="POST">
<div class="label">Name</div><input type="text" name="name" id="name" /></br>
<div class="label">Mail</div><input type="text"  name="mail" id="mail" /></br>
<div class="label">Password</div><input type="password" name="password" id="password" /></br>
<div class="label">Repassword</div><input type="password" name="repassword" id="repassword" /></br>
<div class="label">Contact</div><input type="text" name="contact" id="contact" /></br>
<input type="submit" value="submit" />
</form:form>
</body>
</html>