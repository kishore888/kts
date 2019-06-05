
<style>

.drop {
  background:-webkit-gradient(linear,0% 0%,0% 100%, from(rgba(13,52,58,1) ), to(rgba(255,255,255,0.6))  );
  background: -moz-linear-gradient(top, rgba(13,52,58,1) 0%, rgba(255,255,255,.6) 100%);
	width:1px;
	height:89px;
	position: absolute;
	bottom:200px;
	-webkit-animation: fall .63s linear infinite;
  -moz-animation: fall .63s linear infinite;
  
}

/* animate the drops*/
@-webkit-keyframes fall {
	to {margin-top:900px;}
}
@-moz-keyframes fall {
	to {margin-top:900px;}
}


</style>

<div class="content-wrapper">
<section class="content">

<section class="rain"></section>

</section>
</div>

<script>
//number of drops created.
var nbDrop = 858; 

// function to generate a random number range.
function randRange( minNum, maxNum) {
  return (Math.floor(Math.random() * (maxNum - minNum + 1)) + minNum);
}

// function to generate drops
function createRain() {

	for( i=1;i<nbDrop;i++) {
	var dropLeft = randRange(0,1600);
	var dropTop = randRange(-1000,1400);

	$('.rain').append('<div class="drop" id="drop'+i+'"></div>');
	$('#drop'+i).css('left',dropLeft);
	$('#drop'+i).css('top',dropTop);
	}

}
// Make it rain
createRain();
</script>
