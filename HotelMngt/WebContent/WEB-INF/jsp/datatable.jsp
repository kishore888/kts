<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"/>
<!-- <link rel="stylesheet" href="/Css/jquery.dataTables.min.css"/> -->
<script src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>


<!-- <script src="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"></script> -->

<!-- <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script> -->

<script>
$(document).ready(function() {
    $('#datatable').DataTable( {
        "footerCallback": function ( row, data, start, end, display ) {
            var api = this.api(), data;
 
            // Remove the formatting to get integer data for summation
            var intVal = function ( i ) {
                return typeof i === 'string' ?
                    i.replace(/[\$,]/g, '')*1 :
                    typeof i === 'number' ?
                        i : 0;
            };
 
            // Total over all pages
            total = api
                .column( 1 )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );
 
            // Total over this page
            pageTotal = api
                .column( 1, { page: 'current'} )
                .data()
                .reduce( function (a, b) {
                    return intVal(a) + intVal(b);
                }, 0 );
 
            // Update footer
            $( api.column( 1 ).footer() ).html(
                '$'+pageTotal +' ( $'+ total +' total)'
            );
        }
    } );
} );
</script>
</head>
<body>
		<table id="datatable">
			<thead>
				<tr>
					<th>status</th>
					<th>count</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>admit</td>
					<td>4</td>
				</tr>
				<tr>
					<td>recieved</td>
					<td>2</td>
				</tr>
				<tr>
					<td>test finished</td>
					<td>4</td>
				</tr>
			</tbody>
			<tfoot>
				<th>Total</th>
				<th></th>
			</tfoot>
		</table>
</body>
</html>


