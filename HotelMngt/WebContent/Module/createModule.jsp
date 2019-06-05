

<div class="content-wrapper">
<section class="content">

<form role="form" id="moduleCreate" name="moduleCreate" action="module/create" method="POST">
<input type="hidden" id="moduleId" name="moduleId" value="${module.moduleId}">

        <!-- left column -->
<!--         <div class="col-md-12"> -->
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Module</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body">
                <div class="form-group">
                  <label for="moduleName">Module Name</label>
                  <input type="text" class="form-control" id="moduleName" name="moduleName" value="${module.moduleName}" placeholder="Module Name">
                </div>
                <div class="form-group">
                  <label for="description">Description</label>
                  <input type="text" class="form-control" id="status" name="description" value="${module.description}" placeholder="Description">
                </div>
              </div>
              <!-- /.box-body -->

              <div class="box-footer">
                <input type="submit" class="btn btn-primary" value="Submit">
                <input type="button" class="btn btn-warning" value="Back" onclick="history.go(-1);"/>
              </div>
          </div>
          <!-- /.box -->
          
<!--           </div> -->
 </form>
</section>
</div>