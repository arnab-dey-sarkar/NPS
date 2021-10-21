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
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

 

    <title>Net Promoter Score</title>
    <style>
    body
    {
        background-image:url("https://previews.123rf.com/images/doodkoalex/doodkoalex0909/doodkoalex090900033/5592860-abstract-vector-mathematical-background-with-random-numbers.jpg");
        background-repeat: no-repeat;
        background-size: cover;
    }
    .error-message {
    font-size: 90%;
    color: #FFCC5F;
    font-style: italic;
    font-weight: bold;
    }
    form{
    margin-left: 50px;
    }
    </style>
    <script>
    //var $x = jQuery.noConflict();
  jQuery(document).ready(function(){
    var $container = $('.container');
    var $row = $('.row');
    var $add = $('#addButton');
    var $remove = $('#removeButton');
    var $focused;

 

    $container.on('click', 'input', function () {
        $focused = $(this);
    });

 

    $add.on('click', function () {
        var $newRow = $row.clone().insertAfter('.row:last');
        $newRow.find('input').each(function () {
            this.value = '';
        });
    });

 

    $remove.on('click', function () {
        if (!$focused) {
            alert('Select a row to delete (click en input with it)');
            return;
        }
        
        var $currentRow = $focused.closest('.row');
        if ($currentRow.index() === 0) {
            // don't remove first row
            alert("You can't remove first row");
        } else {
            $currentRow.remove();
            $focused=null;
        }
    });
  });
  
  function onLoad(){
        
        if ('<c:out value="${pageContext.request.userPrincipal.name}"/>' == '')
        {
            window.location.href="home";
        }
        else
        {
        	document.getElementById("homeLink").style.display = "none";

        }
    }
    </script>
</head>
<body onLoad="onLoad()">
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
                <a class="nav-link" id="homeLink" href="/home" class="btn btn-success">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a href="/registerPage" class="btn btn-success"> <i class="fa fa-arrow-circle-o-left"></i>&nbsp;Register
                    Team</a>
            </li>
            <li class="nav-item">
                <a href="/teamChooseQues" class="btn btn-success"> <i class="fa fa-arrow-circle-o-left"></i>&nbsp;Add Questions</a>
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
        <p style="font-weight: bold;">Welcome ${pageContext.request.userPrincipal.name} !!</p>&nbsp;&nbsp;
        <form class="form-inline my-2 my-lg-0">
            <a href="/signout?user=${pageContext.request.userPrincipal.name}" class="btn btn-outline-success my-2 my-sm-0" type="submit">LogOut</a>
        </form>
    </div>
</nav>
<!-- End Nav Bar-->
<c:if test="${not empty message }">
     <div class="error-message">
         ${message}
     </div>
   </c:if>
<form:form method="POST" modelAttribute="team" action="/addTeam" name="team" enctype="multipart/form-data">
    <div class="form-group">
    <table id ="title">
        
        <tr>
        <td><b>Team Name</b></td>
        <td><form:input type="text" class="form-control" path="tname" aria-describedby="teamName"/></td>
        </tr>
        </br>
        <td>&nbsp;</td><td>&nbsp;</td>
        <tr>
         <td><b>Team Manager's Name</b></td>
        <td><form:input type="text" class="form-control" path="tmanagername"
                                                 aria-describedby="teamManagerName"/></td>
        </tr>
        <td>&nbsp;</td><td>&nbsp;</td>
         <tr>
         <td><b>Project ID</b></td>
        <td><form:select path="tprojectid">
            <form:option value="none" label="Select an Option"/>
            <form:option value="119056879" label="119056879" />
            <form:option value="119056878"  label="119056878" />
            <form:option value="119056877"  label="119056877" />
            <form:option value="119056876"  label="119056876" />
        </form:select></td>
        </tr>
      

 

    <!-- <div id="addLine" class="form-group">
        <button onclick="addInputLine()" name="addInputLine" class="btn btn-primary">Add Member<span class="fa fa-plus"/></button>
    </div> -->
    <td>&nbsp;</td><td>&nbsp;</td>
   <tr>
   <td>
   <div class="text-right">
    <input type="button" style="float: left;margin-right: 16px;" class="btn btn-primary" value='+' id='addButton'/>
    <input type='button' style="float: left;" class="btn btn-primary" value='-' id='removeButton'>
   </div>
   </td>
   <td>
    <div class="container">
            <div class="row">
                <div class="col-lg-3" style="padding-left: 0px;padding-right: 0px;">
                    <div class="form-group">
                        <form:input type="text" size="70" class="form-control" path="tmembername" name="size[]" placeholder="Member Name" />
                    </div>
                </div>
                <!-- <div class="col-lg-3">
                    <div class="form-group">
                        <input type="text" class="form-control" name="clr[]" placeholder="Color" />
                    </div>
                </div> -->
                <hr/>
            </div>
    </div>
    </td>
    </tr>
</table>
</div>
    <script>
    function addInputLine() {
    var node = document.createElement("input");                 // Create an <input> node
    document.getElementById("addLine").appendChild(node);     // Append it to the parent
    }
    </script>

 

 

    <button type="submit" class="btn btn-primary">Submit</button>
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