<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  


<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.requestURI}"/>
<c:set var="url">${req.requestURL}</c:set>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<base href="${fn:substring(url,0, fn:length(url)-fn:length(uri))}${req.contextPath}/"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Matrix Admin</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script> -->

<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> -->


<!-- <link rel="stylesheet" href="matrixAdminFiles/css/bootstrap-responsive.min.css" /> -->
<link rel="stylesheet" href="matrixAdminFiles/bootstrap/bootstrap-responsive.min.css" />

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Uniform.js/4.2.2/css/default.css" />

<!-- <link rel="stylesheet" href="matrixAdminFiles/css/uniform.css" /> -->

<!-- <link rel="stylesheet" href="css/select2.css" /> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/css/select2.css" />

<link rel="stylesheet" href="matrixAdminFiles/css/matrix-style.css" />
<link rel="stylesheet" href="matrixAdminFiles/css/matrix-media.css" />
<!-- <link href="matrixAdminFiles/css/font-awesome.css" rel="stylesheet" /> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" /> -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-3-typeahead/4.0.2/bootstrap3-typeahead.min.js"></script>


<style>
#sidebar > ul > li.submenu > ul > li.active {
     background-color: #28b779; 
     border-bottom: 1px solid #27a9e3; 
     border-top: 1px solid #27a9e3; 
}

#sidebar > ul > li.submenu > ul > li.active > a{
 	background: url("matrixAdminFiles/images/menu-active.png") no-repeat scroll right center transparent !important; 
 	text-decoration:none; 
}


.arrow-left {
/*   width: 0;  */
/*   height: 0;  */
/*   border-top: 10px solid transparent; */
/*   border-bottom: 10px solid transparent;  */
  
/*   border-right:10px solid blue;  */
}

.triangle-left {
	border-top: 4px solid transparent;
	border-right: 10px solid #555;
	border-bottom: 4px solid transparent;
	
/* 	background-color: #27a9e3; */
}
</style>
<style>
.table thead th {
    background-color: #401345;
    color: #e99120;
}
</style>

</head>
<body>

<!--Header-part-->
<div id="header">
  <h1><a href="#">Matrix Admin</a></h1>
</div>
<!--close-Header-part--> 


	<tiles:insertAttribute name="menu" />
			
	<tiles:insertAttribute name="header" />

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Form elements</a> <a href="#" class="current">Validation</a> </div>
    <h1>Form validation</h1>
  </div>
<div class="container-fluid"><hr>
    <div class="row-fluid">
    		<tiles:insertAttribute name="body" />
    </div>
</div>
</div>

<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by <a href="http://themedesigner.in">Themedesigner.in</a> </div>
</div>
<!--end-Footer-part-->



<script src="matrixAdminFiles/js/jquery.ui.custom.js"></script> 
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<script src="matrixAdminFiles/js/jquery.uniform.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.5/js/select2.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script> 
<script src="matrixAdminFiles/js/matrix.js"></script> 
<!-- <script src="matrixAdminFiles/js/matrix.form_validation.js"></script> -->


<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>





<script>

// to make active left menu link on clicking it
$('#sidebar li a').each(function(){
	var urlWithoutParams = window.location.href.split('?')[0];
	var baseUrl = '${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}';
	var relativePath = urlWithoutParams.replace(baseUrl+'/','');
	var absolutePath = window.location.href.replace(baseUrl+'/','');
	var hrefa = $(this).attr('href');
	
	if(absolutePath == hrefa || relativePath==hrefa){
		$(this).parents('li').addClass('active');
	}
});



//open submenu when li in the submenu is active
$('.submenu > ul > li').each(function(){
	if($(this).hasClass('active')){
		$(this).closest('.submenu').toggleClass('open');
		
// 		hand right icon on active li
		$(this).find('i').removeClass('fa-circle-o').addClass('fa-hand-o-right');
		
// 		add arrow left for active link
// 		$(this).addClass('triangle-left');
	}
});
//end of open submenu when li in the submenu is active

</script>


</body>
</html>