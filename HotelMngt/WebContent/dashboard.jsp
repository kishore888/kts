<script src="https://cdnjs.cloudflare.com/ajax/libs/jssor-slider/26.6.0/jssor.slider.min.js"></script>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/css/jquery.dataTables.min.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/js/jquery.dataTables.min.js"></script>

<script>
// full screen mode

$('#fullscreen').on('click', function(){
// 	 $('#fullscreen').fullscreen().request();
// document.body.fullscreen().request();
// 	 document.body.requestFullscreen();


// var viewer = $("#parentid .classname .childelement")[0];
var rFS = $(this).mozRequestFullScreen || viewer.webkitRequestFullscreen || viewer.requestFullscreen;
    rFS.call(viewer); 
});
</script>

<script>
    jssor_slider1_init = function (containerId) {
        var options = {
            $ArrowNavigatorOptions: {
                $Class: $JssorArrowNavigator$,
                $ChanceToShow: 2
            }
        };
        var jssor_slider1 = new $JssorSlider$(containerId, options);
    };
</script>

<style>
video {
    width: 100%;
    height: auto;
}
</style>

<div class="content-wrapper">

<section class="content">

<h3>${userName} Dashboard</h3>
<%-- <h3>${userName} Dashboard</h3> --%>
<%-- <h3>${userName} Dashboard</h3> --%>
<%-- <h3>${userName} Dashboard</h3> --%>
<%-- <h3>${userName} Dashboard</h3> --%>
<%-- <h3>${userName} Dashboard</h3> --%>
<%-- <h3>${userName} Dashboard</h3> --%>
<%-- <h3>${userName} Dashboard</h3> --%>
<%-- <h3>${userName} Dashboard</h3> --%>

<!-- <video width="400" controls> -->
<!--   <source src="videos/Swag Se Swagat Song - Tiger Zinda Hai - Salman Khan - Katrina Kaif.mp4" type="video/mp4"> -->
<!--   <source src="mov_bbb.ogg" type="video/ogg"> -->
<!--   Your browser does not support HTML5 video. -->
<!-- </video> -->


<img src="images/hotelmngt.jpg" alt="Smiley face" width="800" height="350">
</section>




<!-- <div id="slider1_container" style="position: relative; top: 0px; left: 0px; width: 600px; height: 300px;"> -->
<!--     Slides Container -->
<!--     <div u="slides" style="cursor: move; position: absolute; overflow: hidden; left: 0px; top: 0px; width: 600px; height: 300px;"> -->
<!--         <div><img u="image" src="images/hotelmngt.jpg" /></div> -->
<!--         <div><img u="image" src="images/Desert.jpg" /></div> -->
<!--     </div> -->
<!-- </div> -->

<div id="slider1_container" style="position: relative; top: 0px; left: 0px; width: 600px; height: 300px;">
    <!-- Slides Container -->
    <div data-u="slides" style="cursor: move; position: absolute; overflow: hidden; left: 0px; top: 0px; width: 600px; height: 300px;">
        <div><img data-u="image" src="images/hotelmngt.jpg" /></div>
        <div><img data-u="image" src="images/Desert.jpg" /></div>
    </div>
   <!-- Arrow Left -->
    <div data-u="arrowleft" class="jssora01l" style="top: 123px; left: 8px;"></div>
    <!-- Arrow Right -->
    <div data-u="arrowright" class="jssora01r" style="top: 123px; right: 8px;"></div>
   
    <!-- Trigger -->
    <script>jssor_slider1_init('slider1_container');</script>
</div>








<section class="content">
<div class="col-md-12">
<div class="row">
<div class="col-md-3">
	<label for="roomTypeId">Room Type</label>
    <select class="form-control" id="roomType" name="roomType.roomTypeId">
    	<option>--Select--</option>
    	<option value="Test">Test</option>
    	<option value="Test2">Test2</option>
    </select>
   </div>
</div>




<div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Room List</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body">
				<table id="roomList" class="table table-bordered table-striped">
	                <thead>
		                <tr>
		                  <th>S.No.</th>
		                  <th>Room Number</th>
		                  <th>Room Type</th>
		                  <th>Plan</th>
		                  <th>Room Charges</th>
		                  <th>Status</th>
		                </tr>
	                </thead>
	                <tbody>
			                <tr>
			                  <td>1</td>
			                  <td>101</td>
			                  <td>Test</td>
			                  <td>Plan1</td>
			                  <td>1000</td>
			                  <td>Available</td>
			                </tr>
			                <tr>
			                  <td>2</td>
			                  <td>102</td>
			                  <td>Test2</td>
			                  <td>Plan2</td>
			                  <td>1000</td>
			                  <td>Available</td>
			                </tr>
			                <tr>
			                  <td>3</td>
			                  <td>103</td>
			                  <td>Test</td>
			                  <td>Plan2</td>
			                  <td>1000</td>
			                  <td>Reserved</td>
			                </tr>
			                <tr>
			                  <td>4</td>
			                  <td>104</td>
			                  <td>Test</td>
			                  <td>Plan1</td>
			                  <td>1000</td>
			                  <td>Available</td>
			                </tr>
			                <tr>
			                  <td>5</td>
			                  <td>105</td>
			                  <td>Test2</td>
			                  <td>Plan1</td>
			                  <td>1000</td>
			                  <td>Reserved</td>
			                </tr>
		            </tbody>
		        </table>

              </div>
              <!-- /.box-body -->
          </div>
          
          
          </div>
          
          
          <button type="button" class="btn btn-info" id="fullscreen">Full Screen</button>
</section>

</div>

<script>
var roomTable=$('#roomList').DataTable({
      'paging'      : false,
      'lengthChange': false,
      'searching'   : false,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    });
    
    
    $('#roomType').on('change', function(){
    	roomTable.rows().draw();
    	
//     	roomTable.draw();
//     	roomTable.rows().child().hide();
    	
    	var roomType = $(this).val();
		var roomTableRows = roomTable.rows().data();
		roomTableRows.map(function(tr,i){
			var sno = roomTable.cell(i, 0).data();
			var roomNumber = roomTable.cell(i, 1).data();
			var roomTypelo = roomTable.cell(i, 2).data();
			var plan = roomTable.cell(i, 3).data();
			var amount = roomTable.cell(i, 4).data();
			var status = roomTable.cell(i, 5).data();
			if(roomType==roomTypelo){
			var data = [sno, roomNumber, roomTypelo, plan, amount, status];
			roomTable.row.add(data).draw();
			}
		});
    });
</script>


<script>
//     jQuery(document).ready(function ($) {
//         var options = { $AutoPlay: 1 };
//         var jssor_slider1 = new $JssorSlider$('slider1_container', options);
//     });
</script>




