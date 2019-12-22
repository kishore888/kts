<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<div class="content-wrapper">
<section class="content">

        <!-- left column -->
<!--         <div class="col-md-12"> -->
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Room</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" id="" name="" action="room/create" method="POST">
              
<%--               <input type="hidden" name="roomId" value="${room.roomId}"> --%>
              <div class="box-body">
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="roomNumber">Room Number</label>
	                  <input type="text" class="form-control" id="roomNumber" name="roomNumber" value="${room.roomNumber}" placeholder="Room Number">
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="roomTypeId">Room Type</label>
	                  <select class="form-control" id="roomType" name="roomType.roomTypeId">
	                  	<option>--Select--</option>
	                  	<c:forEach items="${roomTypeList}" var="roomType">
	                  		<option value="${roomType.roomTypeId}" ${roomType.roomTypeId==room.roomType.roomTypeId?'selected':''}>${roomType.roomType}</option>
	                  	</c:forEach>
	                  </select>
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="planId">Plan</label>
	                  <select class="form-control" id="planId" name="hotelPlanMaster.hotelPlanMasterId">
	                  	<option> --Select--</option>
	                  	<c:forEach items="${hotelPlanMasterList}" var="hotelPlanMaster">
	                  		<option value="${hotelPlanMaster.hotelPlanMasterId}" ${hotelPlanMaster.hotelPlanMasterId==room.hotelPlanMaster.hotelPlanMasterId?'selected':''}>${hotelPlanMaster.planName}</option>
	                  	</c:forEach>
	                  </select>
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="roomCharges">Room Charges</label>
	                  <input type="text" class="form-control" id="roomCharges" name="roomCharges" value="${room.roomCharges}" placeholder="Room Charges">
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="maxNoOfAdults">max. No. of Adults</label>
	                  <input type="text" class="form-control" id="maxNoOfAdults" name="maxNoOfAdults" value="${room.maxNoOfAdults}" placeholder="max No Of Adults">
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="maxNoOfKids">max. No. of Kids</label>
	                  <input type="text" class="form-control" id="maxNoOfKids" name="maxNoOfKids" value="${room.maxNoOfKids}" placeholder="max No Of Kids">
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="status">Status</label>
	                  <input type="text" class="form-control" id="status" name="status" value="${room.status}" placeholder="Status">
	                </div>
                </div>
                <div class="col-md-6">
	                <div class="form-group">
	                  <label for="planId">Payment Account</label>
	                  <select class="form-control" id="paymentAccountId" name="hotelPlanMaster.hotelPlanMasterId">
	                  	<c:forEach items="${paymentAccountList}" var="paymentAccount">
	                  		<option value="${paymentAccount.paymentAccountId}" ${paymentAccount.paymentAccountId==room.paymentAccount.paymentAccountId?'selected':''}>${paymentAccount.name}</option>
	                  	</c:forEach>
	                  </select>
	                </div>
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <button type="submit" class="btn btn-primary">Submit</button>
                <input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/>
              </div>
            </form>
          </div>
          <!-- /.box -->
          
<!--           </div> -->
</section>
</div>