<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix = "numberFormat" uri = "/WEB-INF/tlds/numberFormatTag.tld"%>

<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/css/jquery.dataTables.min.css" /> -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/js/jquery.dataTables.min.js"></script> -->

<link rel="stylesheet" href="css/datatables.min.css" />
<script src="js/datatables.min.js"></script>


<!-- <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css"/> -->
<!-- <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css"/> -->
<!-- <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script> -->

<div class="content-wrapper">
<section class="content">

        <!-- left column -->
<!--         <div class="col-md-12"> -->
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Room List</h3>
              
              <button type="button" class="btn btn-success" data-role="button" data-toggle="modal" data-target="#importRoomsExcel">Import Rooms Excel</button>
              
              
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
		                  <th>max. No. of Adults</th>
		                  <th>max. No. of Kids</th>
		                  <th>Status</th>
		                </tr>
	                </thead>
	                <tbody>
<%-- 	                	<c:forEach items="${roomList}" var="room" varStatus="status"> --%>
<!-- 			                <tr> -->
<%-- 			                  <td>${status.index+1}</td> --%>
<%-- 			                  <td>${room.roomNumber}</td> --%>
<%-- 			                  <td>${room.roomType.roomType}</td> --%>
<%-- 			                  <td>${room.hotelPlanMaster.planName}</td> --%>
<%-- 			                  <td><numberFormat:Number value = "${room.roomCharges}" decimalValue= "true" /></td> --%>
<%-- 			                  <td>${room.maxNoOfAdults}</td> --%>
<%-- 			                  <td>${room.maxNoOfKids}</td> --%>
<%-- 			                  <td>${room.status}</td> --%>
<!-- 			                </tr> -->
<%-- 		                </c:forEach> --%>
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




<!-- Modal -->
  <div class="modal fade" id="importRoomsExcel" role="dialog" tabindex="-1" aria-labelledby="Import Rooms Excel" aria-hidden="true">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Import Rooms Excel</h4>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
          
          
          
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>


</div>

<script>
// var roomTable = $('#roomList').DataTable({
// //       'paging'      : true,
// //       'lengthChange': false,
// //       'searching'   : false,
// //       'ordering'    : true,
// //       'info'        : true,
// //       'autoWidth'   : false,
//       "iDisplayLength": 50,
//       "processing": true, // for show progress bar
//       "serverSide": true, // for process server side
//       "filter": true, // this is for disable filter (search box)
//       'ajax'		: {
// 			          "url": "room/retrieveRoomListServersideDatatableAjax",
// 			          "type": "GET",
// 			          "datatype": "json",
// 			          "success" :function(){
// 			        	  console.log('yes');
// 			          }
// 			      	},
// });

var roomTable = $('#roomList').DataTable({
//       'paging'      : true,
//       'lengthChange': false,
//       'searching'   : false,
//       'ordering'    : true,
//       'info'        : true,
//       'autoWidth'   : false,

      "pageLength"	: 20,
      "lengthMenu"	: [20,50,100,500,1000], 
	  "select"    	: {"style": 'multi'},
	  "createdRow"	: function(row, data, index){
		  				$(row), addClass('trclass');
	 				  },
	  "columnDefs"  : [{"orderable":false, "targets":0}],
	  "order"		: [[1, 'asc']],
      "serverSide"	: true, // for process server side
      "filter"		: true, // this is for disable filter (search box)
      'ajax'		: {
			          "url": "room/retrieveRoomListServersideDatatableAjax",
			          "contentType":"application/json",
			          "dataType":"json",
			          "type": "POST",
			          "datatype": "json",
			          "data"	: function(d){
			        	  d.entity="room",
			        	  d.idProp="roomId";
			        	  return JSON.stringify(d);
			          },
			          "dataSrc": function(json){
			        	  var tableInfo = roomTable.page.info();
			        	  return data = json.data.map(function(room, i){
			        		 var d ={
			        				 "Sno":tableInfo.start+1,
			        				 "Room Number" : room.roomNumber,
			        				 "Room Type" : room.roomType.roomType,
			        				 "Plan" : room.hotelPlanMaster.planName,
			        				 "Room Charges" : room.roomCharges,
			        				 "max. No. of Adults" : room.maxNoOfAdults,
			        				 "max. No. of Kids" : room.maxNoOfKids,
			        				 "Status" : room.status
			        		 };
			        		 tableInfo.start++;
			        		 return d;
			        	  });
			          }
			      	},
	  "columns":[
		  {"data":"sno"},
		  {"data":"room.roomNumber"},
		  {"data":"roomType"},
		  {"data":"hotelPlanMaster.planName"},
		  {"data":"roomCharges"},
		  {"data":"maxNoOfAdults"},
		  {"data":"maxNoOfKids"},
		  {"data":"status"}
	  ]
});
    
    
$('#roomList').on( 'page.dt', function () {
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