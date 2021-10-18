<!-- page: addquestion.jsp -->
<!DOCTYPE html>
<%@page import="com.capgemini.nps.entity.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<% 
	List<Question> questionList = (List<Question>)request.getAttribute("questionList"); 
%>
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
    	#questions {
		  font-family: Arial, Helvetica, sans-serif;
		  border-collapse: collapse;
		  width: 70%;
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
		.button1 {
		  background-color: #4CAF50;
		  border-radius: 13px;
		  border: none;
		  color: white;
		  padding: 10px 10px;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 13px;
		  margin: 4px 2px;
		  transition-duration: 0.4s;
		  cursor: pointer;
		}
		.editbutton {
		  background-color: white; 
		  color: black; 
		  border: 2px solid #4CAF50;
		}
		
		.editbutton:hover {
		  background-color: #4CAF50;
		  color: white;
		}
		.deletebutton {
		  background-color: white; 
		  color: black; 
		  border: 2px solid #f44336;
		}
		
		.deletebutton:hover {
		  background-color: #f44336;
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
    </style>
    <script type="text/javascript">
    function editQuestionFunction(id)
    {
    }
    function deleteQuestionFunction(id)
    {
    	
    }
    </script>
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

        </ul>
        <form class="form-inline my-2 my-lg-0">
            <a class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</a>
        </form>
    </div>
</nav>
<!-- End Nav Bar-->
<form>
    <div class="form-group">
    <label>&nbsp Previously added questions </label>
	<table id="questions" >
	  <tr>
	    <th>Questions</th>
	    <th>Action</th>
	  </tr>
	  <% if(null!= questionList && !questionList.isEmpty()) { %>
	  <% for(Question question: questionList){ %>
		  <tr>
		    <td><%= question.getDescription() %></td>
		    <td>
		    <button class="button1 editbutton" type="button"><a href="updatequestion/<%=question.getId()%>">Edit</a></button> &nbsp 
		    <button class="button1 deletebutton" type="button"><a href="deletequestion/<%=question.getId()%>">Delete</a></button>
		    </td>
		  </tr> 
	  <% } }%>
	 </table>
    </div>
	<br/>
   <label>&nbsp Want to add a new Question? <a href="savequestionpage">Click Here...</a></label>
   <br/>
   
</form>
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