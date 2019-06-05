<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/css/jquery.dataTables.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/js/jquery.dataTables.min.js"></script>


<div class="content-wrapper">
<section class="content">
<form role="form" id="privilegeCreate" name="privilegeCreate" action="privilege/create" method="POST">
<input type="hidden" id="privilegeId" name="privilegeId" value="${privilege.privilegeId}">
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Privilege</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body">
                <div class="form-group">
                  <label for="privilegeCode">Privilege Code</label>
                  <input type="text" class="form-control" id="privilegeCode" name="privilegeCode" value="${privilege.privilegeCode}" placeholder="Privilege Code">
                </div>
                <div class="form-group">
                  <label for="description">Description</label>
                  <input type="text" class="form-control" id="status" name="description" value="${privilege.description}" placeholder="Description">
                </div>
                 <div class="form-group">
                  <label for="planId">Module</label>
                  <select class="form-control" id="planId" name="hotelPlanMaster.hotelPlanMasterId">
                  	<option> --Select--</option>
                  	<c:forEach items="${moduleList}" var="module">
                  		<option value="${module.moduleId}" ${module.moduleId==privilege.module.moduleId?'selected':''}>${module.moduleName}</option>
                  	</c:forEach>
                  </select>
                </div>
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <input type="submit" class="btn btn-primary" value="Save">
                <input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/>
              </div>
          </div>
</form>
</section>

<section class="content">
	<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Privilege List</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body">
				<table id="privilegeList" class="table table-bordered table-striped">
	                <thead>
		                <tr>
		                  <th>S.No.</th>
		                  <th>Privilege Code</th>
		                  <th>Description</th>
		                  <th>Order</th>
		                  <th>Action</th>
		                </tr>
	                </thead>
	                <tbody>
	                	<c:forEach items="${privilegeList}" var="privilege" varStatus="status">
			                <tr>
			                  <td>${status.index+1}</td>
			                  <td>${privilege.privilegeCode}</td>
			                  <td>${privilege.description}</td>
			                  <td>${privilege.privilegeOrder}</td>
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


</section>

</div>

<script>
$('#privilegeList').DataTable({
      'paging'      : true,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
</script>


