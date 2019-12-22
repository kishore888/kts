<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/css/jquery.dataTables.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="css/sweetalert2.min.css" />
<script src="js/sweetalert2.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js" integrity="sha256-4iQZ6BVL4qNKlQ27TExEhBN1HFPvAvAMbFavKKosSWQ=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

<div class="content-wrapper">
<section class="content">

        <!-- left column -->
<!--         <div class="col-md-12"> -->
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Financial Year</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" id="" name="" action="financialYear/create" method="POST">
              
              <input type="hidden" name="financialYearId" value="${financialYear.financialYearId}">
              <div class="box-body">
                <div class="col-md-6">
	                <div class="form-group">
	                  <div class='input-group'>
				          <input type='text' class="form-control datetimepicker" name="startDate" value="<fmt:formatDate value="${financialYear.startDate}" pattern="dd/MM/yyyy" />"/>
				          <span class="input-group-addon">
				            <span class="glyphicon glyphicon-calendar"></span>
				          </span>
				        </div>
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                  <div class='input-group'>
				          <input type='text' class="form-control datetimepicker" name="endDate" value="<fmt:formatDate value="${financialYear.endDate}" pattern="dd/MM/yyyy" />" />
				          <span class="input-group-addon">
				            <span class="glyphicon glyphicon-calendar"></span>
				          </span>
				        </div>
	                </div>
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
              	<div align="center">
	                <button type="submit" class="btn btn-primary">Submit</button>
	                <input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/>
                </div>
              </div>
            </form>
          </div>
          <!-- /.box -->
          
<!--           </div> -->


<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Financial Year List</h3>
              
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body table-responsive">
				<table id="financialYearTable" class="table table-hover table-bordered table-striped">
	                <thead>
		                <tr>
		                  <th>S.No.</th>
		                  <th>Year Name</th>
		                  <th>Start Date</th>
		                  <th>End Date</th>
		                  <th>Actions</th>
		                </tr>
	                </thead>
	                <tbody>
	                	<c:forEach items="${financialYearList}" var="financialYear" varStatus="status">
			                <tr>
			                  <td>${status.index+1}</td>
			                  <td>${financialYear.yearName}</td>
			                  <td><fmt:formatDate value="${financialYear.startDate}" pattern="dd/MM/yyyy" /></td>
			                  <td><fmt:formatDate value="${financialYear.endDate}" pattern="dd/MM/yyyy" /></td>
			                  <td>
			                    <a href="financialYear/create?financialYearId=${financialYear.financialYearId}" role="button" class="btn btn-success"><i class="fa fa-edit"></i></a>
			                    <a href="javascript:deleteFinancialYear('financialYear/delete?financialYearId=${financialYear.financialYearId}', this)" role="button" class="btn btn-danger"><i class="fa fa-remove"></i></a>
			                  </td>
			                </tr>
		                </c:forEach>
		            </tbody>
		        </table>

              </div>
              <!-- /.box-body -->

              <div class="box-footer">
	              <div align="center">
	               	 <input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/>
	              </div>
              </div>
          </div>
          <!-- /.box -->
          
</section>
</div>

<script>
$(document).ready(function() {
	$('.datetimepicker').daterangepicker({
		singleDatePicker: true,
	    showDropdowns: true,
		drops:'down',
	    locale: {
	      format: 'DD/MM/YYYY'
	    }
	  }
	);

});
</script>
<script>
var financialYearTable = $('#financialYearTable').DataTable({
    'paging'      : true,
    'lengthChange': true,
    'searching'   : true,
    'ordering'    : true,
    'info'        : true,
    'autoWidth'   : false
});

function deleteFinancialYear(url, el){
	console.log($(el).attr('role'));
	financialYearTable.row( $(node).parents('tr') ).remove().draw();
	Swal.fire({
		  title: 'Are you sure?',
		  text: "You won't be able to revert this!",
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Yes, delete it!'
		}).then((result) => {
		  if (result.value) {
			  $.ajax({
					url:url,
					method:'POST',
					success:function(data){
						financialYearTable.row( $(node).parents('tr') ).remove().draw();
						Swal.fire(
							      'Deleted!',
							      'Financial Year has been deleted.',
							      'success'
							    )
					},
					error:function(){
						
					}
				})
		  }
		})
}
</script>