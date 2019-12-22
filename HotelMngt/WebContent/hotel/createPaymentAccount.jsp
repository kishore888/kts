<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/css/jquery.dataTables.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="css/sweetalert2.min.css" />
<script src="js/sweetalert2.min.js"></script>

<div class="content-wrapper">
<section class="content">

        <!-- left column -->
<!--         <div class="col-md-12"> -->
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Payment Account</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" id="" name="" action="paymentAccount/create" method="POST">
              
              <input type="hidden" name="paymentAccountId" value="${paymentAccount.paymentAccountId}">
              <div class="box-body">
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="name">Name</label>
	                  <input type="text" class="form-control" id="name" name="name" value="${paymentAccount.name}" placeholder="Enter Name">
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="code">Code</label>
	                  <input type="text" class="form-control" id="code" name="code" value="${paymentAccount.code}" placeholder="Enter Code">
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="bankName">Bank Name</label>
	                  <input type="text" class="form-control" id="bankName" name="bankName" value="${paymentAccount.bankName}" placeholder="Enter Bank Name">
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="billCount">Bill Count</label>
	                  <input type="text" class="form-control" id="billCount" name="billCount" value="${paymentAccount.billCount}" placeholder="Enter Bill Count">
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                		  <label>Payment Gateway</label>
	                	<c:forEach items="${hotelPaymentGatewayList}" var="hotelPaymentGateway">
			                  <select class="form-control" name="hotelPaymentGateway.hotelPaymentGatewayId" id="">
			                  	<option value="${hotelPaymentGateway.hotelPaymentGatewayId}" ${hotelPaymentGatewayId==paymentAccount.hotelPaymentGateway.hotelPaymentGatewayId?'selected':''}>${hotelPaymentGateway.paymentGateway.paymentGatewayName}</option>
			                  </select>
						  </c:forEach>
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
              <h3 class="box-title">Payment Account List</h3>
              
              <button type="button" class="btn btn-success" data-role="button" data-toggle="modal" data-target="#importRoomsExcel">Import Rooms Excel</button>
              
              
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body table-responsive">
				<table id="paymentacList" class="table table-hover table-bordered table-striped">
	                <thead>
		                <tr>
		                  <th>S.No.</th>
		                  <th>Name</th>
		                  <th>Code</th>
		                  <th>Bank Name</th>
		                  <th>Bill Count</th>
		                  <th>Payment Gateway</th>
		                  <th>Actions</th>
		                </tr>
	                </thead>
	                <tbody>
	                	<c:forEach items="${paymentAccountList}" var="paymentAccount" varStatus="status">
			                <tr>
			                  <td>${status.index+1}</td>
			                  <td>${paymentAccount.name}</td>
			                  <td>${paymentAccount.code}</td>
			                  <td>${paymentAccount.bankName}</td>
			                  <td>${paymentAccount.billCount}</td>
			                  <td>${paymentAccount.hotelPaymentGateway.paymentGateway.paymentGatewayName}</td>
			                  <td>
			                    <a href="paymentAccount/create?paymentAccountId=${paymentAccount.paymentAccountId}" role="button" class="btn btn-success"><i class="fa fa-edit"></i></a>
			                    <a href="javascript:deletePaymentAccount('paymentAccount/delete?paymentAccountId=${paymentAccount.paymentAccountId}', this)" role="button" class="btn btn-danger"><i class="fa fa-remove"></i></a>
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
function deletePaymentAccount(url, node){
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
					success:function(result){
						Swal.fire(
							      'Deleted!',
							      'Payment Account has been deleted.',
							      'success'
							    )
					    paymentacTable.row( $(node).parents('tr') ).remove().draw();
					},
					error:function(){
						
					}
				})
		  }
		})
}

var paymentacTable = $('#paymentacList').DataTable({
      'paging'      : false,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
});
</script>