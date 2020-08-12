<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.11/c3.min.css">
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/d3/3.5.5/d3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/c3/0.4.11/c3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/pivottable/2.23.0/pivot.min.css" integrity="sha256-nn3M6N8S2BjPirPhvCF61ZCcgcppdLtnaNOLhiwro7E=" crossorigin="anonymous" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/pivottable/2.23.0/pivot.min.js" integrity="sha256-/btBGbvOvx2h/NcXVS+JPFhnoUGbZXDX0O2v6AaABLU=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pivottable/2.23.0/c3_renderers.min.js" integrity="sha256-GIyyiy+0j73PbyD21LcRsf19KmBZ5TKOTOCDV3yKq9o=" crossorigin="anonymous"></script>


<div class="content-wrapper">
<section class="content">
	<div class="box box-warning box-solid">
            <div class="box-header with-border">
              <h3 class="box-title">Payment</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
              </div>
              <!-- /.box-tools -->
            </div>
            <!-- /.box-header -->
            <div class="box-body" style="">
             	 <div id="paymentpivot"></div>
            </div>
            <!-- /.box-body -->
          </div>
</section>
</div>

<script>
$(function(){

        var derivers = $.pivotUtilities.derivers;
        var renderers = $.extend($.pivotUtilities.renderers,
            $.pivotUtilities.c3_renderers);

        var mps = [
        {Province: "Quebec", Party: "NDP", Age: 22, Name: "Liu, Laurin", Gender: "Female"},
        {Province: "Quebec", Party: "Bloc Quebecois", Age: 43, Name: "Mourani, Maria", Gender: "Female"},
        {Province: "Quebec", Party: "NDP", Age: "", Name: "Sellah, Djaouida", Gender: "Female"},
        {Province: "Quebec", Party: "NDP", Age: 72, Name: "St-Denis, Lise", Gender: "Female"},
        {Province: "British Columbia", Party: "Liberal", Age: 71, Name: "Fry, Hedy", Gender: "Female"},
        {Province: "Quebec", Party: "NDP", Age: 70, Name: "Turmel, Nycole", Gender: "Female"},
        {Province: "Ontario", Party: "Liberal", Age: 68, Name: "Sgro, Judy", Gender: "Female"},
        {Province: "Quebec", Party: "NDP", Age: 67, Name: "Raynault, Francine", Gender: "Female"},
        {Province: "Ontario", Party: "Conservative", Age: 66, Name: "Davidson, Patricia", Gender: "Female"},
        {Province: "Manitoba", Party: "Conservative", Age: 65, Name: "Smith, Joy", Gender: "Female"}
        ];
        	
        
            $("#paymentpivot").pivotUI(mps, {
                renderers: renderers,
                cols: ["Party"], rows: ["Province"],
                rendererName: "Horizontal Stacked Bar Chart",
                rowOrder: "value_z_to_a", colOrder: "value_z_to_a",
                rendererOptions: {
                    c3: { data: {colors: {
                        Liberal: '#dc3912', Conservative: '#3366cc', NDP: '#ff9900',
                        Green:'#109618', 'Bloc Quebecois': '#990099'
                    }}}
                }
            });
     });
</script>