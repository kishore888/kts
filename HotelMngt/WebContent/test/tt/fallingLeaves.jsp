
<style>
.dot{
  width:35px;
  height:35px;
  position:absolute;
  background: url(http://www.clipartqueen.com/image-files/red-lobed-fall-clipart-leaf.png);
  background-size: 100% 100%;
}
#logo{ left:50%; top:50%; position:absolute; border-radius:10px; }


#links{position:absolute;bottom:0px;left:0px;width:100%;height:50px;font-size:13px;font-family:tahoma;color:#fff;}
#links a{text-decoration:none;font-size:2.3em;color:#fff;}
#twitter{position:absolute;bottom:15px;right:20px;}
#pens{position:absolute;bottom:15px;left:20px;}

</style>

<div class="content-wrapper">
<section class="content">

<div id="container">
<img id='logo' src="http://gravatar.com/avatar/5a224f121f96bd037bf6c1c1e2b686fb?s=256" alt="Smiley face" height="120" width="120">
</div>

<div id='links'>
<a id='twitter' href="https://twitter.com/Diaco_ml" target="_blank"><span class='fa fa-twitter'></span></a>
<div id='pens'><a href="https://codepen.io/collection/DgYoEw/" target="_blank"><span class='fa fa-codepen'></span></a> my other Pens</div>
</div>


</section>
</div>

<script>
/*
a Pen by DIACO : twitter.com/Diaco_ml  ||  codepen.io/MAW
powered by GSAP : https://www.greensock.com/
*/
TweenLite.set("#container",{perspective:600})
TweenLite.set("img",{xPercent:"-50%",yPercent:"-50%"})

var total = 30;
var warp = document.getElementById("container"),	w = window.innerWidth , h = window.innerHeight;
 
 for (i=0; i<total; i++){ 
   var Div = document.createElement('div');
   TweenLite.set(Div,{attr:{class:'dot'},x:R(0,w),y:R(-200,-150),z:R(-200,200)});
   warp.appendChild(Div);
   animm(Div);
 }
 
 function animm(elm){   
   TweenMax.to(elm,R(6,15),{y:h+100,ease:Linear.easeNone,repeat:-1,delay:-15});
   TweenMax.to(elm,R(4,8),{x:'+=100',rotationZ:R(0,180),repeat:-1,yoyo:true,ease:Sine.easeInOut});
   TweenMax.to(elm,R(2,8),{rotationX:R(0,360),rotationY:R(0,360),repeat:-1,yoyo:true,ease:Sine.easeInOut,delay:-5});
 };

function R(min,max) {return min+Math.random()*(max-min)};


// a Pen by DIACO : twitter.com/Diaco_ml  ||  codepen.io/MAW
</script>

