<div class="content-wrapper">
<section class="content">

        <!-- left column -->
<!--         <div class="col-md-12"> -->
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Plan</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" id="" name="" action="hotelPlanMaste/create" method="POST">
              <div class="box-body">
                <div class="form-group">
                  <label for="planName">Hotel Plan Master</label>
                  <input type="text" class="form-control" id="planName" name="planName" placeholder="Plan Name">
                </div>
                
                 <div class="form-group">
                  <label for="planCode">Plan Code</label>
                  <input type="text" class="form-control" id="planCode" name="planCode" placeholder="Plan Code">
                </div>
                <div class="form-group">
                  <label for="planDescription">Plan Description</label>
                  <input type="text" class="form-control" id="planDescription" name="planDescription" placeholder="Plan Description">
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
<!--                 <button type="submit" class="btn btn-primary">Submit</button> -->
                <input type="submit" class="btn btn-primary" value="Submit">
                <input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/>
              
              	 <input type="submit" class="btn btn-outline-primary" value="Submit">
              </div>
            </form>
          </div>
          <!-- /.box -->
          
<!--           </div> -->
</section>
</div>