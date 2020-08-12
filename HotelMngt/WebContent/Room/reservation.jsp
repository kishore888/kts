<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/webcamjs/1.0.25/webcam.min.js" integrity="sha256-t+nJEiBiQ6CP53aJk5ptfJ+gno5gl3N0RKYycDqZ5ko=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js" integrity="sha256-4iQZ6BVL4qNKlQ27TExEhBN1HFPvAvAMbFavKKosSWQ=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.9/validator.min.js" integrity="sha256-dHf/YjH1A4tewEsKUSmNnV05DDbfGN3g7NMq86xgGh8=" crossorigin="anonymous"></script>

<style>
	#my_camera{
/* 	 width: 220px; */
	 height: 120px;
	 width: 100%;
/*     height: auto; */
	 border: 1px solid #c8b9b9;
	}
</style>

<div class="content-wrapper">
<section class="content">

        <!-- left column -->
        <div class="col-md-12">
<!--         <div class="col-md-8"> -->
    <form role="form" data-toggle="validator" id="reservationform" name="" action="reservation/create" method="POST">
       <input type="hidden" name="customerId" value="${customer.customerId}">
       <input type="hidden" name="customerImage" id="customer_image" value="${customer.customerImage}">
       <input type="hidden" class="form-control" name="paymentAccountId" value="${paymentAccount.paymentAccountId}">
              
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Reservation for room no <b>${room.roomNumber}</b></h3>
            </div>
              <div class="box-body">
	              <div class="col-md-12">
		              <div class="col-md-4">
		                <div class="form-group">
		                  <label for="firstName">First Name</label>
		                  <input type="text" class="form-control" id="firstName" name="firstName" value="${customer.firstName}" placeholder="First Name" required>
		                </div>
		                <div class="form-group">
		                  <label for="lastName">Last Name</label>
		                  <input type="text" class="form-control" id="lastName" name="lastName" value="${customer.lastName}" placeholder="Last Name" required>
		                </div>
		                <div class="form-group">
		                  <label for="phoneNo1">Phone No1</label>
		                  <input type="text" class="form-control" id="phoneNo1" name="phoneNo1" value="${customer.phoneNo1}" placeholder="phoneNo1" required>
		                </div>
		              </div>
		              <div class="col-md-4">
		                <div class="form-group">
		                  <label for="middleName">Middle Name</label>
		                  <input type="text" class="form-control" id="middleName" name="middleName" value="${customer.middleName}" placeholder="Middle Name">
		                </div>
		                <div class="form-group">
		                  <label for="gender">Gender</label>
		                  <select class="form-control" id="gender" name="gender" required>
		                  	<option value=""> --Select--</option>
		                  		<option value="Male" ${customer.gender=='Male'?'selected':''}>Male</option>
		                  		<option value="Female" ${customer.gender=='Female'?'selected':''}>Female</option>
		                  </select>
		                </div>
		                <div class="form-group">
		                  <label for="phoneNo2">phoneNo2</label>
		                  <input type="text" class="form-control" id="phoneNo2" name="phoneNo2" value="${customer.phoneNo2}" placeholder="phoneNo2">
		                </div>
	                </div>
	                
	                <div class="col-md-4">
		                <div id="my_camera">
		                <img id="imageprev" src="file:/C:/Users/KISHORE/Desktop/test_image.jpeg"/>
<%-- 		                	<img id="imageprev" width="360" height="260" src="${path}"> --%>
		                </div>
						<input type=button value="WebCam" onClick="initializeWebCam()">
						<input type=button value="Snapshot" onClick="take_snapshot()">
					</div>
				</div>
				<div class="col-md-12">
	                <div class="col-md-4">
		                <div class="form-group">
		                  <label for="emailId">Email</label>
		                  <input type="email" class="form-control" id="emailId" name="emailId" value="${customer.emailId}" placeholder="emailId" required>
		                </div>
		                <div class="form-group">
		                  <label for="doorNo">D.No</label>
		                  <input type="text" class="form-control" id="doorNo" name="doorNo" value="${customer.doorNo}" placeholder="Door No">
		                </div>
		                <div class="form-group">
		                  <label for="state">State</label>
		                  <input type="text" class="form-control" id="state" name="state" value="${customer.state}" placeholder="State">
		                </div>
	                </div>
	                <div class="col-md-4">
		                <div class="form-group">
		                  <label for="idType">Id Type</label>
		                  <select class="form-control" id="idType" name="idType">
		                  	<option> --Select--</option>
		                  		<option value="AadharCard" ${customer.idType=='AadharCard'?'selected':''}>AadharCard</option>
		                  		<option value="VoterId" ${customer.idType=='VoterId'?'selected':''}>VoterId</option>
		                  </select>
		                </div>
		                <div class="form-group">
		                  <label for="street">Street</label>
		                  <input type="text" class="form-control" id="street" name="street" value="${customer.street}" placeholder="Street">
		                </div>
		                <div class="form-group">
		                  <label for="country">Country</label>
		                  <input type="text" class="form-control" id="country" name="country" value="${customer.country}" placeholder="Country">
		                </div>
	                </div>
	                <div class="col-md-4">
		                <div class="form-group">
		                  <label for="idValue">Id Value</label>
		                  <input type="text" class="form-control" id="idValue" name="idValue" value="${customer.idValue}" placeholder="Id Value" required>
		                </div>
		                <div class="form-group">
		                  <label for="city">City</label>
		                  <input type="text" class="form-control" id="city" name="city" value="${customer.city}" placeholder="City">
		                </div>
		                <div class="form-group">
		                  <label for="religion">Religion</label>
		                  <input type="text" class="form-control" id="religion" name="religion" value="${customer.religion}" placeholder="Religion">
		                </div>
	                </div>
                </div>
                <div class="col-md-12">
	                <div class="col-md-4">
	                	<div class="form-group">
		                  <label for="occupation">Occupation</label>
		                  <input type="text" class="form-control" id="occupation" name="occupation" value="${customer.occupation}" placeholder="Occupation">
		                </div>
	                </div>
	                
	            </div>
	            
            <c:forEach items="${reservationList}" var="reservation" varStatus="status">
	            <div class="col-md-12">
	                <div class="col-md-2">
	                	<div class="form-group">
		                  <label for="amount">Room No</label>
		                  <input type="hidden" class="form-control" name="reservationList[${status.index}].room.roomId" value="${reservation.room.roomId}">
		                  <input type="hidden" class="form-control" name="reservationList[${status.index}].reservationId" value="${reservation.reservationId}">
		                  <br>${reservation.room.roomNumber}
		                </div>
	                </div>
	                <div class='col-md-4'>
				      <div class="form-group">
				        <label for="checkIn">Check In</label>
				        <div class='input-group'>
				          <input type='text' class="form-control datetimepicker" name="checkIn" value="<fmt:formatDate value="${reservation.checkIn}" pattern="yyyy-MM-dd" />"/>
				          <span class="input-group-addon">
				            <span class="glyphicon glyphicon-calendar"></span>
				          </span>
				        </div>
				      </div>
				    </div>
				    <div class='col-md-4'>
				      <div class="form-group">
				      	<label for="checkOut">Check Out</label>
				        <div class='input-group'>
				          <input type='text' class="form-control datetimepicker" name="checkOut" value="<fmt:formatDate value="${reservation.checkOut}" pattern="yyyy-MM-dd" />"/>
				          <span class="input-group-addon">
				            <span class="glyphicon glyphicon-calendar"></span>
				          </span>
				        </div>
				      </div>
				    </div>
	                <div class="col-md-2">
	                	<div class="form-group">
		                  <label for="amount">Amount</label>
		                  <input type="number" class="form-control amount" style="padding-right:0px;" name="reservationList[${status.index}].amount" value="${reservation.room.roomCharges}" placeholder="Amount">
		                </div>
	                </div>
	            </div>
            </c:forEach>
	            <div class="col-md-12">
	                <div class="col-md-4">
	                	<div class="form-group">
		                  <label for="totalAmount">Total Amount</label>
		                  <input type="text" class="form-control" id="totalAmount" name="totalAmount" value="0" readOnly>
		                </div>
	                </div>
	            </div>
	            <div class="col-md-12">
	                	<div class="form-group">
	                		  <label>
							  	<input type="radio" name="paymentType" value="CASH" checked="">
							  	Cash
							  </label>
	                	<c:forEach items="${hotelPaymentGatewayList}" var="hotelPaymentGateway">
			                  <label>
							  	<input type="radio" name="paymentType" value="${hotelPaymentGateway.hotelPaymentGatewayId}">
							  	${hotelPaymentGateway.paymentGateway.paymentGatewayName}
							  </label>
						  </c:forEach>
		                </div>
                </div>
                
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <div align="center">
	                <button type="submit" class="btn btn-primary" id="submit">Submit</button>
	                <input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/>
                </div>
              </div>
            
          </div>
          <!-- /.box -->

		</form>
		
<!-- 	</div> -->
<!-- 	<div class="col-md-4"> -->
<!-- 	<form role="form" id="" name="" action="hotelPaymentGateway/pay" method="POST"> -->
<%--        <input type="hidden" name="room.roomId" value="${room.roomId}"> --%>
<%--        <input type="hidden" name="hotel.hotelId" value="${sessionScope.hotelObj.hotelId}"> --%>
<%--        <input type="hidden" name="amount" value="${room.roomId}"> --%>
       
<!-- 		<div class="box box-primary"> -->
<!--             <div class="box-header with-border"> -->
<!--               <h3 class="box-title">Payment</h3> -->
<!--             </div> -->
<!--               <div class="box-body"> -->
<!--               <table> -->
<!--               	<tbody> -->
<!--               		<tr> -->
<!--               			<td>Amount</td> -->
<!--               			<td style="text-align:right;">4000</td> -->
<!--               		</tr> -->
<!--               		<tr> -->
<!--               			<td>Total Amount</td> -->
<!--               			<td style="text-align:right;">6000</td> -->
<!--               		</tr> -->
<!--               	</tbody> -->
<!--               </table> -->
                
<!--               </div> -->
<!--               /.box-body -->

<!--               <div class="box-footer"> -->
<!--                 <div align="center"> -->
<!-- 	                <button type="submit" class="btn btn-primary">Submit</button> -->
<!-- 	                <input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/> -->
<!--                 </div> -->
<!--               </div> -->
            
<!--           </div> -->
<!--           /.box -->
          
<!--           </form> -->
<!-- 	</div> -->
</div>
		
</section>
</div>
<script>
$("#submit").on("click", function(){
// $('#reservationform').submit(function (e) {
	if ($('#reservationform').find('.has-error').length) {
		// FORM NOT VALIDATED
		return false;
	}else{
		return true;
	}
});

$(document).ready(function() {
	$('.datetimepicker').daterangepicker({
		singleDatePicker: true,
	    showDropdowns: true,
		timePicker: true,
		drops:'up',
	    locale: {
	      format: 'DD/MM/YYYY hh:mm A'
	    }
	});
	
	calculateTotal();
});

$('.amount').on('keyup blur', function(){
	calculateTotal();
});

function calculateTotal(){
	var totalAmount = 0;
	$('.amount').each(function(i, el){
		totalAmount += parseInt($(el).val());
	});
	$('#totalAmount').val(totalAmount);
}
</script>

<!-- Configure a few settings and attach camera -->
<script language="JavaScript">
 Webcam.set({
//   width: 180,
  height: 120,
  image_format: 'jpeg',
  jpeg_quality: 90
 });
 
 
 function initializeWebCam(){
	 Webcam.attach( '#my_camera' );
 }

//preload shutter audio clip
 var shutter = new Audio();
 shutter.autoplay = true;
 shutter.src = navigator.userAgent.match(/Firefox/) ? 'shutter.ogg' : 'shutter.mp3';

function take_snapshot() {
	  // play sound effect
	  shutter.play();

	  // take snapshot and get image data
	  Webcam.snap( function(data_uri) {
		  Webcam.reset();
		  // display results in page
	  document.getElementById('my_camera').innerHTML = 
	   '<img id="imageprev" src="'+data_uri+'"/>';
	   $('#customer_image').val(data_uri);
	  } );

	  
 }
	 
function saveSnap(){
	 // Get base64 value from <img id='imageprev'> source
	 var base64image = document.getElementById("imageprev").src;

	 Webcam.upload( base64image, 'upload.php', function(code, text) {
	  console.log('Save successfully');
	  //console.log(text);
	 });

}
</script>
