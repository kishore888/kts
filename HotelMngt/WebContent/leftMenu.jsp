 <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
 
 <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
<!--           <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image"> -->
        </div>
      </div>
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        <li class="header">MAIN NAVIGATION</li>
<!--         <li class="treeview"> -->
<!--           <a href="#"> -->
<!--             <i class="fa fa-dashboard"></i> <span>Dashboard</span> -->
<!--             <span class="pull-right-container"> -->
<!--               <i class="fa fa-angle-left pull-right"></i> -->
<!--             </span> -->
<!--           </a> -->
<!--           <ul class="treeview-menu"> -->
<!--             <li><a href="index.html"><i class="fa fa-circle-o"></i> Dashboard v1</a></li> -->
<!--             <li class="active"><a href="index2.html"><i class="fa fa-circle-o"></i> Dashboard v2</a></li> -->
<!--           </ul> -->
<!--         </li> -->
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-building"></i> <span>Hotel</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="hotel/create"><i class="fa fa-circle-o"></i> Add Hotel</a></li>
            <li><a href="hotelPaymentGateway/create"><i class="fa fa-circle-o"></i> Payment Gateway</a></li>
            <li><a href="paymentAccount/create"><i class="fa fa-circle-o"></i> Payment Account</a></li>
            <li><a href="financialYear/create"><i class="fa fa-circle-o"></i> Financial Year</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-hotel"></i> <span>Room</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="hotelPlanMaste/showCreatePlan"><i class="fa fa-circle-o"></i> Add Hotel Plan Master</a></li>
            <li><a href="hotelPlanMaste/retrieveHotelPlanMasterList"><i class="fa fa-circle-o"></i> Hotel Plan Master List</a></li>
            <li><a href="room/create"><i class="fa fa-circle-o"></i> Add Room</a></li>
            <li><a href="room/retrieveRoomList"><i class="fa fa-circle-o"></i> Room List</a></li>
            <li><a href="roomType/showCreateRoomType"><i class="fa fa-circle-o"></i> Add Room Type</a></li>
            <li><a href="roomType/retrieveRoomTypeList"><i class="fa fa-circle-o"></i> Room Type List</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-hotel"></i> <span>Payment Report</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="paymentDetails/dashboard"><i class="fa fa-circle-o"></i> Payment Dashboard</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-user"></i> <span>Employee</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="employee/showCreateEmployee"><i class="fa fa-circle-o"></i> Add Employee</a></li>
            <li><a href="employee/showCreateEmployee"><i class="fa fa-circle-o"></i> Employee List</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-envelope"></i> <span>Mailbox</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="email/showInbox"><i class="fa fa-circle-o"></i> Inbox</a></li>
            <li><a href="email/showComposeEmail"><i class="fa fa-circle-o"></i> Compose</a></li>
<!--             <li><a href="employee/showCreateEmployee"><i class="fa fa-circle-o"></i> Employee List</a></li> -->
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Payroll</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
          	<security:authorize access="hasAnyRole('ROLE_SALARY_PROCESS')">
            	<li><a href=""><i class="fa fa-circle-o"></i> Salary Process</a></li>
            </security:authorize>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-cog"></i> <span>Settings</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
	          <security:authorize access="hasAnyRole('ROLE_ADD_ROLE')">
	            <li><a href="role/showCreateRole"><i class="fa fa-circle-o"></i> Add Role</a></li>
	          </security:authorize>
	            <li><a href="role/retrieveRoleList"><i class="fa fa-circle-o"></i> Role List</a></li>
          </ul>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Module</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="module/showCreateModule"><i class="fa fa-circle-o"></i>Add Module</a></li>
            <li><a href="module/retrieveModuleList"><i class="fa fa-circle-o"></i>Module List</a></li>
            <li><a href="privilege/showCreatePrivilege"><i class="fa fa-circle-o"></i>Add Privilege</a></li>
          </ul>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-dashboard"></i> <span>Theme</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="theme/showCreateTheme"><i class="fa fa-circle-o"></i> Add Theme</a></li>
          </ul>
        </li>
       
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
