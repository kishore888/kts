<div class="content-wrapper">
<section class="content">

        <!-- left column -->
<!--         <div class="col-md-12"> -->
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Room Type</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form role="form" id="" name="" action="${pageContext.request.contextPath}/roomType/create" method="POST">
              <div class="box-body">
                <div class="form-group">
                  <label for="roomType">Room Type Name</label>
                  <input type="text" class="form-control" id="roomType" name="roomType" placeholder="Room Type">
                </div>
                <div class="form-group">
                  <label for="tariff">Tariff</label>
                  <input type="text" class="form-control" id="tariff" name="roomTypeTariff" placeholder="Tariff">
                </div>
                <div class="form-group">
                  <label for="status">Status</label>
                  <input type="text" class="form-control" id="status" name="roomTypeStatus" placeholder="Status">
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
<!--                 <button type="submit" class="btn btn-primary">Submit</button> -->
                <input type="submit" class="btn btn-primary" value="Submit">
                <input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/>
              </div>
            </form>
          </div>
          <!-- /.box -->
          
<!--           </div> -->
</section>
</div>