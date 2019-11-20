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
              <h3 class="box-title">Payment Gateway Creation</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body table-responsive">
	              <div class="col-md-12">
					<table id="gatewaycreation" class="table table-bordered table-striped">
		                <thead>
			                <tr>
			                  <th>S.No.</th>
			                  <th>Gateway Name</th>
			                  <th>Merchant Id</th>
			                  <th>Salt</th>
			                  <th>Status</th>
			                  <th>Action</th>
			                </tr>
		                </thead>
		                <tbody>
		                	<c:forEach items="${paymentGateways}" var="paymentGateway" varStatus="status">
				                
				                <tr id="${paymentGateway.paymentGatewayId}">
				                  <td>${status.index+1}</td>
				                  <td><form role="form" id="form${paymentGateway.paymentGatewayId}" name="" action="hotelPaymentGateway/create" method="POST">${paymentGateway.paymentGatewayName}</form></td>
				                  <td><input form="form${status.index+1}" type="hidden" class="hotelId" name="hotel.hotelId" value="${sessionScope.hotelObj.hotelId}">
				                  		<input form="form${status.index+1}" type="hidden" class="paymentGatewayId" name="paymentGateway.paymentGatewayId" value="${paymentGateway.paymentGatewayId}">
				                  		<input form="form${status.index+1}" type="text" class="merchantId" name="merchantId" value=""></td>
				                  <td><input form="form${status.index+1}" type="text" class="salt" name="salt" value=""></td>
				                  <td>
					                  <input form="form${status.index+1}" type="checkbox" class="isActive" class="pull-right" name="isActive">
					                  <input form="form${status.index+1}" type="hidden" class="isActive" name="isActive" value="0">
				                  </td>
				                  <td><input form="form${status.index+1}" type="submit" class="btn btn-success" value="Submit"/></td>
				                </tr>
			                </c:forEach>
			            </tbody>
			        </table>
					</div>
              </div>
              <!-- /.box-body -->

          </div>
          <!-- /.box -->
          
<!--           </div> -->
<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Payment Gateway List</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body table-responsive">
	              <div class="col-md-12">
					<table id="gatewayList" class="table table-bordered table-striped">
		                <thead>
			                <tr>
			                  <th>S.No.</th>
			                  <th>Gateway Name</th>
			                  <th>Merchant Id</th>
			                  <th>Salt</th>
			                  <th>Status</th>
			                  <th>Action</th>
			                </tr>
		                </thead>
		                <tbody>
		                	<c:forEach items="${hotelPaymentGatewayList}" var="hotelPaymentGateway" varStatus="status">
				                <tr>
				                  <td>${status.index+1}</td>
				                  <td>${hotelPaymentGateway.paymentGateway.paymentGatewayName}</td>
				                  <td>${hotelPaymentGateway.merchantId}</td>
				                  <td>${hotelPaymentGateway.salt}</td>
				                  <td>
					                  <input type="checkbox" class="pull-right" name="isActive" ${hotelPaymentGateway.isActive?'checked':''}>
					                  <input type="hidden" name="hotelPaymentGateway.isActive" value="0">
				                  </td>
				                  <td><a href="javascript:editPaymentGateway('hotelPaymentGateway/retrieveById?hotelPaymentGatewayId=${hotelPaymentGateway.hotelPaymentGatewayId}')" role="button" class="btn btn-success"><i class="fa fa-edit"></i></a></td>
				                </tr>
			                </c:forEach>
				        </tbody>
			        </table>
					</div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                
              </div>
          </div>

	<div align="center">
		<input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/>
	</div>
</section>
</div>

<script>
$('#gatewaycreation').DataTable({
      'paging'      : false,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
$('#gatewayList').DataTable({
      'paging'      : false,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
    
function editPaymentGateway(url){
	$.ajax({
		url:url,
		method:'GET',
		success:function(result){
// 			console.log(result);
			$('.merchantId').val('');
			$('.salt').val('');
			$('.isActive').prop('checked', false);
			  
			$('#'+result.hotelPaymentGateway.paymentGateway.paymentGatewayId).find('.merchantId').val(result.hotelPaymentGateway.merchantId);
			$('#'+result.hotelPaymentGateway.paymentGateway.paymentGatewayId).find('.salt').val(result.hotelPaymentGateway.salt);
			$('#'+result.hotelPaymentGateway.paymentGateway.paymentGatewayId).find('.isActive').prop('checked', true);
		},
		error:function(){
			
		}
	})
}
</script>