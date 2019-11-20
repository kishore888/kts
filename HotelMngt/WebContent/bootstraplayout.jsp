<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> --%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  


<c:set var="req" value="${pageContext.request}"/>
<c:set var="uri" value="${req.requestURI}"/>
<c:set var="url">${req.requestURL}</c:set>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${fn:substring(url,0, fn:length(url)-fn:length(uri))}${req.contextPath}/"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/css/bootstrap.min.css" /> -->
<!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"> -->
 
 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<%--  <link href="<c:url value="/AdminLte/dist/css/font-awesome.min.css" />" rel="stylesheet"> --%>
<%--  <link href="<c:url value="/AdminLte/dist/css/ionicons.min.css" />" rel="stylesheet"> --%>
<%--  <link href="<c:url value="/AdminLte/dist/css/AdminLTE.min.css" />" rel="stylesheet"> --%>
<%--  <link href="<c:url value="/AdminLte/dist/css/all-skins.min.css" />" rel="stylesheet"> --%>
 
<%--  <script src="<c:url value="/AdminLte/dist/js/fastclick.js" />"></script> --%>
<%--  <script src="<c:url value="/AdminLte/dist/js/adminlte.min.js" />"></script> --%>
<%--  <script src="<c:url value="/AdminLte/dist/js/jquery.sparkline.min.js" />"></script> --%>
<%--  <script src="<c:url value="/AdminLte/dist/js/jquery-jvectormap-1.2.2.min.js" />"></script> --%>
<%--  <script src="<c:url value="/AdminLte/dist/js/jquery-jvectormap-world-mill-en.js" />"></script> --%>
<%--  <script src="<c:url value="/AdminLte/dist/js/fastclick.js" />"></script> --%>
<%--  <script src="<c:url value="/AdminLte/dist/js/demo.js" />"></script> --%>


<!-- ---------------------------------------------------------------------------------------- -->


<!-- <link rel="stylesheet" href="AdminLte/dist/css/font-awesome.min.css"> -->
<link rel="stylesheet" href="AdminLte/dist/css/ionicons.min.css">
<link rel="stylesheet" href="AdminLte/dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="AdminLte/dist/css/all-skins.min.css">


<script src="AdminLte/dist/js/fastclick.js"></script>
<script src="AdminLte/dist/js/adminlte.min.js"></script>
<script src="AdminLte/dist/js/jquery.sparkline.min.js"></script>
<script src="AdminLte/dist/js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="AdminLte/dist/js/jquery-jvectormap-world-mill-en.js"></script>
<script src="AdminLte/dist/js/demo.js"></script>

<!-- ---------------------------------------------------------------------------------------- -->

<!-- <link rel="stylesheet" href="https://adminlte.io/themes/AdminLTE/bower_components/font-awesome/css/font-awesome.min.css"> -->
<!-- <link rel="stylesheet" href="https://adminlte.io/themes/AdminLTE/bower_components/Ionicons/css/ionicons.min.css"> -->
<!-- <link rel="stylesheet" href="https://adminlte.io/themes/AdminLTE/bower_components/jvectormap/jquery-jvectormap.css"> -->
<!-- <link rel="stylesheet" href="https://adminlte.io/themes/AdminLTE/dist/css/AdminLTE.min.css"> -->
<!-- <link rel="stylesheet" href="https://adminlte.io/themes/AdminLTE/dist/css/skins/_all-skins.min.css"> -->
<!-- <link rel="stylesheet" -->
<!--         href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic"> -->

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js"></script> -->
<!-- <script src="https://adminlte.io/themes/AdminLTE/bower_components/fastclick/lib/fastclick.js"></script> -->
<!-- <script src="https://adminlte.io/themes/AdminLTE/dist/js/adminlte.min.js"></script> -->
<!-- <script src="https://adminlte.io/themes/AdminLTE/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script> -->
<!-- <script src="https://adminlte.io/themes/AdminLTE/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script> -->
<!-- <script src="https://adminlte.io/themes/AdminLTE/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script> -->
<!-- <script src="https://adminlte.io/themes/AdminLTE/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script> -->
<!-- <script src="https://adminlte.io/themes/AdminLTE/dist/js/demo.js"></script> -->

<!-- ---------------------------------------------------------------------------------------- -->

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" /> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jvectormap/2.0.4/jquery-jvectormap.min.css" />
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.3.11/css/AdminLTE.min.css" /> -->
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.3.11/css/skins/_all-skins.min.css" /> -->
<link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-beta/js/bootstrap.min.js"></script> -->
<!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/fastclick/1.0.6/fastclick.min.js"></script> -->
<!-- <script src="https://adminlte.io/themes/AdminLTE/dist/js/adminlte.min.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-sparklines/2.1.2/jquery.sparkline.min.js"></script> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jvectormap/2.0.4/jquery-jvectormap.min.js"></script> -->
<!-- <script src="https://adminlte.io/themes/AdminLTE/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-slimScroll/1.3.8/jquery.slimscroll.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.3.11/js/pages/dashboard2.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/admin-lte/2.3.11/js/demo.js"></script> -->






<!--       translation  -->
  <script type="text/javascript">
	function googleTranslateElementInit() {
	  new google.translate.TranslateElement({pageLanguage: 'en'}, 'google_translate_element');
  }
  </script>
	
  <script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
  
<style>
.table thead th {
    background-color: #880E4F;
    color: #F8BBD0;
}

.table tbody tr.odd {
    background-color: #E1BEE7;
}
.table tbody tr.even {
    background-color: #F3E5F5;
}

.table tbody tr.odd:hover {
	background-color: #E5B6ED;
}

.table tbody tr.even:hover {
	background-color: #EED9F2;
}
</style>
<style>
/* main body  */
<c:if test="true">
.theme{
	background-color: #E5B6ED;
}

.content-wrapper {
	background-color: #E5B6ED;
}

</c:if>
</style>
<style>
/* leftmenu  */

.main-container .main-sidebar, .left-side{
	background-color: #404008;
}

.main-container .main-sidebar .sidebar-menu > li.menu-open > a{
	background: red;
}

.main-container .main-sidebar .sidebar-menu > li > a:hover{
	background: green;
}

.main-container .main-sidebar .sidebar-menu > li > .treeview-menu {
    margin: 0 1px;
    background: blue;
}
</style>

</head>
<body class="hold-transition skin-blue sidebar-mini theme" >
	<div class="wrapper">
		<div class="main-container">
			
			<tiles:insertAttribute name="menu" />
			
			<tiles:insertAttribute name="header" />
<!-- 			<div style="float:left;padding:10px;width:15%;"> -->
<!-- 		</div> -->

		</div>

		<div class=content-wrapper">
<!-- 				<section class="content-header"> -->
<!-- 					<h1 id="h1"></h1> -->
<!-- 					<ol id="ol" class="breadcrum"></ol> -->
<!-- 				</section> -->


<!-- 			<div style="float:left;padding:10px;width:80%;border-left:1px solid pink;"> -->
				<tiles:insertAttribute name="body" />
<!-- 			</div> -->
			
			<footer class="main-footer" style="max-height:50px;float:bottom;">
			    <div class="pull-right hidden-xs">
			      <b>Version</b> 1.0.0
			    </div>
			    <strong>Copyright &copy; 2017-2018 <a href="#">Kishore</a>.</strong> All rights
			    reserved.
			 </footer>
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
<!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Create the tabs -->
    <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
      <li><a href="#control-sidebar-home-tab" data-toggle="tab" id="home-settings"><i class="fa fa-home"></i></a></li>
      <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
      <!-- Home tab content -->
      <div class="tab-pane" id="control-sidebar-home-tab">
        <h3 class="control-sidebar-heading">Recent Activity</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-birthday-cake bg-red"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                <p>Will be 23 on April 24th</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-user bg-yellow"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>

                <p>New phone +1(800)555-1234</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>

                <p>nora@example.com</p>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <i class="menu-icon fa fa-file-code-o bg-green"></i>

              <div class="menu-info">
                <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>

                <p>Execution time 5 seconds</p>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

        <h3 class="control-sidebar-heading">Tasks Progress</h3>
        <ul class="control-sidebar-menu">
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Custom Template Design
                <span class="label label-danger pull-right">70%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Update Resume
                <span class="label label-success pull-right">95%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-success" style="width: 95%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Laravel Integration
                <span class="label label-warning pull-right">50%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
              </div>
            </a>
          </li>
          <li>
            <a href="javascript:void(0)">
              <h4 class="control-sidebar-subheading">
                Back End Framework
                <span class="label label-primary pull-right">68%</span>
              </h4>

              <div class="progress progress-xxs">
                <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
              </div>
            </a>
          </li>
        </ul>
        <!-- /.control-sidebar-menu -->

      </div>
      <!-- /.tab-pane -->

      <!-- Settings tab content -->
      <div class="tab-pane" id="control-sidebar-settings-tab">
        <form method="post">
          <h3 class="control-sidebar-heading">General Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Report panel usage
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Some information about this general settings option
            </p>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Allow mail redirect
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Other sets of options are available
            </p>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Expose author name in posts
              <input type="checkbox" class="pull-right" checked>
            </label>

            <p>
              Allow the user to show his name in blog posts
            </p>
          </div>
          <!-- /.form-group -->

          <h3 class="control-sidebar-heading">Chat Settings</h3>

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Show me as online
              <input type="checkbox" class="pull-right" checked>
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Turn off notifications
              <input type="checkbox" class="pull-right">
            </label>
          </div>
          <!-- /.form-group -->

          <div class="form-group">
            <label class="control-sidebar-subheading">
              Delete chat history
              <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
            </label>
          </div>
          <!-- /.form-group -->
          
          <div class="form-group">
            <label class="control-sidebar-subheading">
             <!--       translation  -->
      			<div id="google_translate_element"></div>
            </label>
          </div>
          <!-- /.form-group -->
        </form>
      </div>
      <!-- /.tab-pane -->
    </div>
  </aside>
<!-- /.control-sidebar -->
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 <div class="control-sidebar-bg"></div>
			 
		</div>
	</div>
	
<script>

// to make active left menu link on clicking it
$('.treeview-menu li a').each(function(){
	var urlWithoutParams = window.location.href.split('?')[0];
	var baseUrl = '${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}';
	var relativePath = urlWithoutParams.replace(baseUrl+'/','');
	var absolutePath = window.location.href.replace(baseUrl+'/','');
	var hrefa = $(this).attr('href');
	
	if(absolutePath == hrefa || relativePath==hrefa){
		$(this).parents('li').addClass('active');
	}
});
</script>

<script>
$(function(){
	displaybreadcrum();
});
function displaybreadcrum(){
	var txt;
	$('ul.sidebar-menu').find('li.active').each(function(){
		var spanNoClass = $(this).find('span:not([class])');
		var link = spanNoClass.parent('a').attr('href');
		if(spanNoClass.length>0){
			$('#ol').append((link!='#')?'<li><a href=>'+link+'>'+spanNoClass.html()+'</a></li>':'<li>'+spanNoClass.html()+'</li>');
		}else{
			$('#ol').append('<li>'+$(this).find('a').text()+'</li>');
		}
		txt=$(this).text();
	});
	$('#h1').append(txt);
}
</script>
<script>
//Format the number with comma. i.e., if number is 123456789 then its displayed as 1,02,34,56,789
function numberFormat(number){
	var num = ''+number;
	var formatNumber = '';
	
	if(num.indexOf('.')!=-1){
		var decimalDigit = num.substr(num.indexOf('.'), 4);
		num = num.substr(0, num.indexOf('.'));
		
		if(parseInt(decimalDigit.charAt(3))>=5){
			decimalDigit = ''+(parseFloat(decimalDigit.substr(0,3))+0.01);
		}else{
			decimalDigit = ''+decimalDigit.substr(0,3);
		}
		
		formatNumber = integerNumberFormat(num);
		formatNumber += decimalDigit.substr(decimalDigit.indexOf('.'), 3);
	}else{
		formatNumber = integerNumberFormat(num);
	}
	return formatNumber;
}

function integerNumberFormat(num){
	var formatNumber = '';
	var len = num.toString.length;
	
	for(var i=len; i>=0; --i,j++){
		if(i%2==0 && i>3){
			formatNumber += num.charAt(j)+',';
		}else{
			formatNumber += num.charAt(j);
		}
	}
	return formatNumber;
}
</script>


</body>

</html>


