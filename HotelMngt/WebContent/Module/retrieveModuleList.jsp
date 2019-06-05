<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/css/jquery.dataTables.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/js/jquery.dataTables.min.js"></script>

<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.16/css/dataTables.bootstrap.min.css" /> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.16/js/dataTables.bootstrap.min.js"></script> -->

<div class="content-wrapper">
<section class="content">

        <!-- left column -->
<!--         <div class="col-md-12"> -->
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Module List</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body">
				<table id="roomList" class="table table-bordered table-striped">
	                <thead>
		                <tr>
		                  <th>S.No.</th>
		                  <th>Module Number</th>
		                  <th>Description</th>
		                  <th>Action</th>
		                </tr>
	                </thead>
	                <tbody>
	                	<c:forEach items="${moduleList}" var="module" varStatus="status">
			                <tr>
			                  <td>${status.index+1}</td>
			                  <td>${module.moduleName}</td>
			                  <td>${module.description}</td>
			                  <td></td>
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
          
<!--           </div> -->
</section>
</div>

<script>
$('#roomList').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
</script>