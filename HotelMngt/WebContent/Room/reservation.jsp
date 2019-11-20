<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/webcamjs/1.0.25/webcam.min.js" integrity="sha256-t+nJEiBiQ6CP53aJk5ptfJ+gno5gl3N0RKYycDqZ5ko=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js" integrity="sha256-4iQZ6BVL4qNKlQ27TExEhBN1HFPvAvAMbFavKKosSWQ=" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />

<style>
	#my_camera{
	 width: 220px;
	 height: 196px;
	 border: 1px solid #c8b9b9;
	}
</style>

<div class="content-wrapper">
<section class="content">

        <!-- left column -->
<!--         <div class="col-md-12"> -->
    <form role="form" id="" name="" action="reservation/create" method="POST">
       <input type="hidden" name="room.roomId" value="${room.roomId}">
       <input type="hidden" name="customerImage" id="customer_image" value="${reservation.room.roomId}">
              
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Reservation for room no <b>${room.roomNumber}</b></h3>
            </div>
              <div class="box-body">
	              <div class="col-md-12">
		              <div class="col-md-4">
		                <div class="form-group">
		                  <label for="firstName">First Name</label>
		                  <input type="text" class="form-control" id="firstName" name="customer.firstName" value="${reservation.customer.firstName}" placeholder="First Name">
		                </div>
		                <div class="form-group">
		                  <label for="lastName">Last Name</label>
		                  <input type="text" class="form-control" id="lastName" name="customer.lastName" value="${reservation.customer.lastName}" placeholder="Last Name">
		                </div>
		                <div class="form-group">
		                  <label for="phoneNo1">Phone No1</label>
		                  <input type="text" class="form-control" id="phoneNo1" name="customer.phoneNo1" value="${reservation.customer.phoneNo1}" placeholder="phoneNo1">
		                </div>
		              </div>
		              <div class="col-md-4">
		                <div class="form-group">
		                  <label for="middleName">Middle Name</label>
		                  <input type="text" class="form-control" id="middleName" name="customer.middleName" value="${reservation.customer.middleName}" placeholder="Middle Name">
		                </div>
		                <div class="form-group">
		                  <label for="gender">Gender</label>
		                  <select class="form-control" id="gender" name="customer.gender">
		                  	<option> --Select--</option>
		                  		<option value="Male" ${reservation.customer.gender=='Male'?'selected':''}>Male</option>
		                  		<option value="Female" ${reservation.customer.gender=='Female'?'selected':''}>Female</option>
		                  </select>
		                </div>
		                <div class="form-group">
		                  <label for="phoneNo2">phoneNo2</label>
		                  <input type="text" class="form-control" id="phoneNo2" name="customer.phoneNo2" value="${reservation.customer.phoneNo2}" placeholder="phoneNo2">
		                </div>
	                </div>
	                
	                <div class="col-md-4">
		                <div id="my_camera">
		                <img id="imageprev" src="file:/C:/Users/KISHORE/Desktop/test_image.jpeg"/>
<%-- 		                	<img id="imageprev" width="360" height="260" src="${reservation.path}"> --%>
		                </div>
						<input type=button value="WebCam" onClick="initializeWebCam()">
						<input type=button value="Take Snapshot" onClick="take_snapshot()">
					</div>
				</div>
				<div class="col-md-12">
	                <div class="col-md-4">
		                <div class="form-group">
		                  <label for="emailId">Email</label>
		                  <input type="text" class="form-control" id="emailId" name="customer.emailId" value="${reservation.customer.emailId}" placeholder="emailId">
		                </div>
		                <div class="form-group">
		                  <label for="doorNo">D.No</label>
		                  <input type="text" class="form-control" id="doorNo" name="customer.doorNo" value="${reservation.customer.doorNo}" placeholder="Door No">
		                </div>
		                <div class="form-group">
		                  <label for="state">State</label>
		                  <input type="text" class="form-control" id="state" name="customer.state" value="${reservation.customer.state}" placeholder="State">
		                </div>
	                </div>
	                <div class="col-md-4">
		                <div class="form-group">
		                  <label for="idType">Id Type</label>
		                  <select class="form-control" id="idType" name="customer.idType">
		                  	<option> --Select--</option>
		                  		<option value="AadharCard" ${reservation.customer.idType=='AadharCard'?'selected':''}>AadharCard</option>
		                  		<option value="VoterId" ${reservation.customer.idType=='VoterId'?'selected':''}>VoterId</option>
		                  </select>
		                </div>
		                <div class="form-group">
		                  <label for="street">Street</label>
		                  <input type="text" class="form-control" id="street" name="customer.street" value="${reservation.customer.street}" placeholder="Street">
		                </div>
		                <div class="form-group">
		                  <label for="country">Country</label>
		                  <input type="text" class="form-control" id="country" name="customer.country" value="${reservation.customer.country}" placeholder="Country">
		                </div>
	                </div>
	                <div class="col-md-4">
		                <div class="form-group">
		                  <label for="idValue">Id Value</label>
		                  <input type="text" class="form-control" id="idValue" name="customer.idValue" value="${reservation.customer.idValue}" placeholder="Id Value">
		                </div>
		                <div class="form-group">
		                  <label for="city">City</label>
		                  <input type="text" class="form-control" id="city" name="customer.city" value="${reservation.customer.city}" placeholder="City">
		                </div>
		                <div class="form-group">
		                  <label for="religion">Religion</label>
		                  <input type="text" class="form-control" id="religion" name="customer.religion" value="${reservation.customer.religion}" placeholder="Religion">
		                </div>
	                </div>
                </div>
                <div class="col-md-12">
	                <div class="col-md-4">
	                	<div class="form-group">
		                  <label for="occupation">Occupation</label>
		                  <input type="text" class="form-control" id="occupation" name="customer.occupation" value="${reservation.customer.occupation}" placeholder="Occupation">
		                </div>
	                </div>
	                <div class='col-md-4'>
				      <div class="form-group">
				        <div class='input-group'>
				          <input type='text' class="form-control datetimepicker" name="startDate" <fmt:formatDate value="${reservation.startDate}" pattern="yyyy-MM-dd" />
				          />
				          <span class="input-group-addon">
				            <span class="glyphicon glyphicon-calendar"></span>
				          </span>
				        </div>
				      </div>
				    </div>
				    <div class='col-md-4'>
				      <div class="form-group">
				        <div class='input-group'>
				          <input type='text' class="form-control datetimepicker" name="endDate" <fmt:formatDate value="${reservation.endDate}" pattern="yyyy-MM-dd" />
				          />
				          <span class="input-group-addon">
				            <span class="glyphicon glyphicon-calendar"></span>
				          </span>
				        </div>
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
            
          </div>
          <!-- /.box -->

		</form>
		
</section>
</div>
<script>
$(document).ready(function() {
	$('.datetimepicker').daterangepicker({
		singleDatePicker: true,
	    showDropdowns: true,
		timePicker: true,
		drops:'up',
	    locale: {
	      format: 'DD/MM/YYYY hh:mm A'
	    }
	  }
	);

});
</script>

<!-- Configure a few settings and attach camera -->
<script language="JavaScript">
 Webcam.set({
  width: 220,
  height: 196,
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
