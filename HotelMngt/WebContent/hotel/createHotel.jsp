<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<div class="content-wrapper">
<section class="content">

        <!-- left column -->
<!--         <div class="col-md-12"> -->
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Hotel</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" id="" name="" action="hotel/create" method="POST">
              
              <input type="hidden" name="hotelId" value="${hotel.hotelId}">
              <div class="box-body">
                <div class="form-group">
                  <label for="hotelName">Hotel Name</label>
                  <input type="text" class="form-control" id="hotelName" name="hotelName" value="${hotel.hotelName}" placeholder="Enter Hotel Name">
                </div>
                <div class="form-group">
                  <label for="phoneNo1">Phone Number1</label>
                  <input type="text" class="form-control" id="phoneNo1" name="phoneNo1" value="${hotel.phoneNo1}" placeholder="Enter Phone Number1">
                </div>
                <div class="form-group">
                  <label for="phoneNo2">Phone Number2</label>
                  <input type="text" class="form-control" id="phoneNo2" name="phoneNo2" value="${hotel.phoneNo2}" placeholder="Enter Phone Number2">
                </div>
                <div class="form-group">
                  <label for="emailId">Email</label>
                  <input type="text" class="form-control" id="emailId" name="emailId" value="${hotel.emailId}" placeholder="Enter Email">
                </div>
                <div class="form-group">
                  <label for="street">Street</label>
                  <input type="text" class="form-control" id="street" name="street" value="${hotel.street}" placeholder="Enter Street">
                </div>
                <div class="form-group">
                  <label for="city">City</label>
                  <input type="text" class="form-control" id="city" name="city" value="${hotel.city}" placeholder="Enter City">
                </div>
                <div class="form-group">
                  <label for="district">District</label>
                  <input type="text" class="form-control" id="district" name="district" value="${hotel.district}" placeholder="Enter District">
                </div>
                <div class="form-group">
                  <label for="state">State</label>
                  <input type="text" class="form-control" id="state" name="state" value="${hotel.state}" placeholder="Enter State">
                </div>
                <div class="form-group">
                  <label for="pincode">Pincode</label>
                  <input type="text" class="form-control" id="pincode" name="pincode" value="${hotel.pincode}" placeholder="Enter Pincode">
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