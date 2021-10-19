<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <title>Net Promoter Score</title>
    <style>
    body
    {
        background-image:url("https://download.logo.wine/logo/Capgemini/Capgemini-Logo.wine.png");
        background-repeat: no-repeat;
        background-size: cover;
    }
    
		
	#title {
		  font-family: Arial, Helvetica, sans-serif;
		  border-collapse: collapse;
		   width: 60%;
		}
		
		#title td, #title th {
		  border: 1px solid #ddd;
		  padding: 8px;
		}
		#title th {
		  padding-top: 12px;
		  padding-bottom: 6px;
		  text-align: left;
		  background-color: #04AA6D;
		  color: white;
		}
		
    </style>
</head>
<body>
<!--Nav Bar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">NPS</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home" class="btn btn-success">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a href="/registerPage" class="btn btn-success"> <i class="fa fa-arrow-circle-o-left"></i>&nbsp;Register
                    Team</a>
            </li>
            <li class="nav-item">
                <a href="/questionpage" class="btn btn-success"> <i class="fa fa-arrow-circle-o-left"></i>&nbsp;Add Questions</a>
            </li>
            <li class="nav-item">
                <a href="/feedBack" class="btn btn-success"> <i class="fa fa-arrow-circle-o-left"></i>&nbsp;Feedback
                    Form</a>
            </li>
            <li class="nav-item">
                <a href="/calNpsScore" class="btn btn-success"> <i class="fa fa-arrow-circle-o-left"></i>&nbsp;NPS Dashboard
                    Form</a>
            </li>

        </ul>
        <!-- <form class="form-inline my-2 my-lg-0">
            <a class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</a>
        </form> -->
    </div>
</nav>
<!-- End Nav Bar-->
<h4 align="center">Welcome to NPS</h4>
<!-- Optional JavaScript; choose one of the two! -->
 <table id ="title">
    <tr>
    <th><h6>Register - For Client Users</h6>
	  <h5>Enter the following details</h5></th>
    </tr>
    </table>


 
       <c:if test="${not empty errorMessage}">
           <div style="color: red; margin: 10px 0px;">
 
               Login Failed!!!<br /> Reason : "${errorMessage}"
 
           </div>
       </c:if>
 
       <form method="POST" action="registeruser">
           <table>
               <tr>
                   <td>Name *</td>
                   <td><input name="name" required="required" /></td>
               </tr>
           	   <tr>
                   <td>Email *</td>
                   <td><input name="email" required="required" /></td>
               </tr>
               <tr>
                   <td>User Name *</td>
                   <td><input name="username" required="required" /></td>
               </tr>
 
               <tr>
                   <td>Password *</td>
                   <td><input type="password" name="password" required="required"/></td>
               </tr>
               
               <tr>
                   <td>&nbsp;</td>
                   <td><input type="submit" value="Signup" /> <input type="reset"
                       value="Reset" /></td>
               </tr>
           </table>
       </form>
 <div style="color:white;font-weight: bold;background-color: #04AA6D;width: 60%;">     
 Already registerd? Please <a style="color:#87CEFA;"
                     href="${pageContext.request.contextPath}/home">
                       Login</a> here
 </div>                      
       <span class="error-message">${error }</span>





<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
        crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
-->
</body>
</html>