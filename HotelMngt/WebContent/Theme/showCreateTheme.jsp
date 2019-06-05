<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/css/jquery.dataTables.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/js/jquery.dataTables.min.js"></script>

<div class="content-wrapper">
<section class="content">

<form role="form" id="themeCreateForm" name="themeCreate" action="theme/create" method="POST">
<input type="hidden" name="themeId" value="${theme.themeId}">
   <div class="box box-primary">
        <div class="box-header with-border">
          <h3 class="box-title">Theme</h3>
        </div>
        <!-- /.box-header -->
        
          
          
        <div class="box-body">
          <div class="form-group">
            <label for="themeName">Theme Name</label>
            <input type="text" class="form-control" id="themeName" name="themeName" value="${theme.themeName}" placeholder="Theme Name">
          </div>
         
       <c:if test="${fn:length(theme.elementStyles)==0}"> 
          <div class="row">
          	<div class="col-md-4">
	          <div class="form-group">
	            <label for="elementName">Element Name</label>
	            <input type="text" data-name="elementName" class="form-control" id="elementName" name="" value="" placeholder="Element Name">
	          </div>
	        </div>
	        <div class="col-md-4">
	          <div class="form-group">
	            <label for="backgroundColor">Background Color</label>
	            <input type="color" data-name="backgroundColor" class="form-control" id="backgroundColor" name="" value="" >
	          </div>
	        </div>
	        <div class="col-md-4">
	          <div class="form-group">
	            <label for="color">Color</label>
	            <input type="color" data-name="color" class="form-control" id="color" name="" value="" >
	          </div>
          	</div>
          </div>
       </c:if>
       <c:if test="${fn:length(theme.elementStyles)>0}"> 
	       <c:forEach items="${theme.elementStyles}" var="elementStyle" varStatus="status">
	       		<div class="row">
		          	<div class="col-md-4">
			          <div class="form-group">
			            <label for="elementName">Element Name</label>
			            <input type="text" data-name="elementName" class="form-control" id="elementName" name="" value="${elementStyle.elementName}" placeholder="Element Name">
			          </div>
			        </div>
			        <div class="col-md-4">
			          <div class="form-group">
			            <label for="backgroundColor">Background Color</label>
			            <input type="color" data-name="backgroundColor" class="form-control" id="backgroundColor" name="" value="${elementStyle.backgroundColor}" >
			          </div>
			        </div>
			        <div class="col-md-4">
			          <div class="form-group">
			            <label for="color">Color</label>
			            <input type="color" data-name="color" class="form-control" id="color" name="" value="${elementStyle.color}" >
			          </div>
		          	</div>
	          </div>
	       </c:forEach>
       </c:if>   
        </div>
        <!-- /.box-body -->

        <div class="box-footer">
          <input type="submit" class="btn btn-primary" value="Submit" >
          <input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/>
        </div>
            
   </div>
    <!-- /.box -->
    
    
    <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Room List</h3>
              
              <a role="button" class="btn btn-success" id="addRow">Add Row</a>
              
              
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body table-responsive">
				<table id="theme-elementList" class="table table-hover table-bordered table-striped">
	                <thead>
		                <tr>
		                  <th>S.No.</th>
		                  <th>Element Name</th>
		                  <th>Background Color</th>
		                  <th>Color</th>
		                  <th>Remove</th>
		                </tr>
	                </thead>
	                <tbody>
	                	<c:forEach items="${theme.elementStyles}" var="elementStyle" varStatus="status">
			                <tr>
			                  <td>${status.index+1}</td>
			                  <td><input type="text" data-name="elementName" class="form-control" id="elementName" name="" value="${elementStyle.elementName}" placeholder="Element Name"></td>
			                  <td><input type="color" data-name="backgroundColor" class="form-control" id="backgroundColor" name="" value="${elementStyle.backgroundColor}" ></td>
			                  <td><input type="color" data-name="color" class="form-control" id="color" name="" value="${elementStyle.color}" ></td>
			                  <td><a role="button" class="btn btn-success remove">Remove</a></td>
			                </tr>
		                </c:forEach>
		            </tbody>
		        </table>

              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/>
              </div>
          </div>
          <!-- /.box -->
    
    
</form>
          
</section>
</div>

<script>
var themeElementTable = $('#theme-elementList').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
});
    
    
$('#theme-elementList').on( 'page.dt', function () {
	var info = roomTable.page.info();
	
	sessionStorage.setItem('pageNumber', info.page);
// 	$('#pageInfo').html( 'Showing page: '+info.page+' of '+info.pages );
} ); 
    
$(document).ready(function(){

// 	stay at current page of datatable
var pageNumber = sessionStorage.getItem('pageNumber');
 if(pageNumber != '' && pageNumber != null){
	 roomTable.page(parseInt(pageNumber)).draw('page');
	 sessionStorage.removeItem('pageNumber');
 }
});	
   
   
</script>
<script>
var counter = 1;
$('#addRow').on( 'click', function () {
	themeElementTable.row.add( [
        counter,
        '<input type="text" data-name="elementName" class="form-control" id="elementName" name="" value="${elementStyle.elementName}" placeholder="Element Name">',
        '<input type="color" data-name="backgroundColor" class="form-control" id="backgroundColor" name="" value="${elementStyle.backgroundColor}" >',
        '<input type="color" data-name="color" class="form-control" id="color" name="" value="${elementStyle.color}" >',
        '<a role="button" class="btn btn-success remove">Remove</a>'
    ] ).draw( false );

    counter++;
} );

// Automatically add a first row of data
$('#addRow').click();


// remove row
$('table').on('click','.remove', function () {
    table.row($(this).closest('tr')).remove().draw( false );
} );
</script>


