<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">



   <script src="${pageContext.request.contextPath}/core/jquery.1.10.2.min.js"></script> 
    <!-- <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script> -->
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <title>Net Promoter Score</title>
    <%-- <script src="${pageContext.request.contextPath}/core/jquery.1.10.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/core/jquery.autocomplete.min.js"></script> --%>
    <%-- <script src="${pageContext.request.contextPath}/core/jquery-1.7.1.min.js"></script> --%>
    
    <style>
    body
    {
        background-image:url("https://download.logo.wine/logo/Capgemini/Capgemini-Logo.wine.png");
        background-repeat: no-repeat;
        background-size: cover;
    }
    #questions {
		  font-family: Arial, Helvetica, sans-serif;
		  border-collapse: collapse;
		  width: 60%; 
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
		
		#questions td, #questions th {
		  border: 1px solid #ddd;
		  padding: 8px;
		}
		#questions tr:nth-child(even){background-color: #f2f2f2;}
		
		#questions tr:hover {background-color: #ddd;}
		#questions th {
		  padding-top: 12px;
		  padding-bottom: 6px;
		  text-align: left;
		  background-color: #04AA6D;
		  color: white;
		}
		input[type=text] {
		  width: 60%;
		  padding: 9px 13px;
		  margin: 8px 0;
		  box-sizing: border-box;
		  border: 3px solid #ccc;
		  -webkit-transition: 0.5s;
		  transition: 0.5s;
		  outline: none;
		}
		
		input[type=text]:focus {
		  border: 3px solid #555;
		}
		.detractorsbutton {
		  /* background-color: white;  */
		  color: black; 
		  border: 2px solid #f44336;
		}
		.detractorsbutton:hover {
		  background-color: #f44336;
		  color: white;
		}
		
		.passivebutton {
		  /* background-color: white;  */
		  color: black; 
		  border: 2px solid #FF8C00;
		}
		.passivebutton:hover {
		  background-color: #FF8C00;
		  color: white;
		}
		.promotersbutton {
		  /* background-color: white;  */
		  color: black; 
		  border: 2px solid #4CAF50;
		}
		.promotersbutton:hover {
		  background-color: #4CAF50;
		  color: white;
		}
    </style>
    
    <script  type="text/javascript">
   
    jQuery(document).ready(function(){

    	//$('#id').click( function(){
    		//var topicId = $(this).val();
    		 var $x = jQuery.noConflict();
             //alert("Version: "+$x.fn.jquery);
             //$(this).remove();
            
    		$.ajax({
    			type: 'GET',
    			url: '${pageContext.request.contextPath}/survey',
    			result: "{}",
    		    success: function(result) {
    				//console.log('------------result', result); 
    	    		//console.log('------------${pageContext.request.contextPath}', ${pageContext.request.contextPath}); 
    			    //var result = JSON.parse(result);
    				var s = '<option value="-1">Please Select a Question</option>';
    				for(var i = 0; i < result.length; i++) {
    					s += '<option value="' + result[i].id + '">' + result[i].topic + '</option>';
    				}
    				//console.log('------------s', s);
    				$('#id').html(s);
    				
    			}
    			
    		
    		});
    	  //}
    	//); 
    	
    	}); 
    
    jQuery(document).ready(function(){

    	//$('#id').click( function(){
    		//var topicId = $(this).val();
    		 var $x = jQuery.noConflict();
             //alert("Version: "+$x.fn.jquery);
             //$(this).remove();
            
    		$.ajax({
    			type: 'GET',
    			url: '${pageContext.request.contextPath}/getTeam',
    			result: "{}",
    		    success: function(result) {
    				//console.log('------------result', result); 
    	    		//console.log('------------${pageContext.request.contextPath}', ${pageContext.request.contextPath}); 
    			    //var result = JSON.parse(result);
    				var s = '<option value="-1">Please Select a Team</option>';
    				for(var i = 0; i < result.length; i++) {
    					s += '<option value="' + result[i].tname + '">' + result[i].tname + '</option>';
    				}
    				//console.log('------------s', s);
    				$('#teamid').html(s);
    				
    			}
    			
    		
    		});
    	  //}
    	//); 
    	
    	}); 
 
    </script>
</head>
<body>
   <%-- <div class="page-title">Welcome ${pageContext.request.userPrincipal.name} !!</div> --%>

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

        </ul>
        <p style="font-weight: bold;">Welcome ${pageContext.request.userPrincipal.name} !!</p>
        <form class="form-inline my-2 my-lg-0">
            <a href="/home" class="btn btn-outline-success my-2 my-sm-0" type="submit">LogOut</a>
        </form>
    </div>
</nav>
<!-- End Nav Bar-->
<c:if test="${not empty message }">
     <div class="error-message">
         ${message}
     </div>
   </c:if>
<form:form method="GET" modelAttribute="getfeedback" action="/getFeedback" name="answer" enctype="multipart/form-data">
  
 <div class="form-group">
    
    <table id="questions">
	 
	  <tr>
	  <td>Choose Teams:</td>
	  <td><form:select id="teamid" path = "teamId" style="width:200px"></form:select></td>
	  <td><button type="submit" class="btn btn-primary">Go</button></td>
	  </tr>
	  </table>
  </div>

    
</form:form>
<!-- Optional JavaScript; choose one of the two! -->

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