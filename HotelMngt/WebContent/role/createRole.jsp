

<div class="content-wrapper">
<section class="content">

<form role="form" id="roleCreate" name="roleCreate" action="role/create" method="POST">
<input type="hidden" id="roleId" name="roleId" value="${role.roleId}">

        <!-- left column -->
<!--         <div class="col-md-12"> -->
          <!-- general form elements -->
          <div class="box box-primary">
            <div class="box-header with-border">
              <h3 class="box-title">Role</h3>
            </div>
            <!-- /.box-header -->
            <!-- form start -->
              <div class="box-body">
                <div class="form-group">
                  <label for="roleName">Role Name</label>
                  <input type="text" class="form-control" id="roleName" name="roleName" value="${role.roleName}" placeholder="Role Name">
                </div>
                <div class="form-group">
                  <label for="description">Description</label>
                  <input type="text" class="form-control" id="status" name="description" value="${role.description}" placeholder="Description">
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