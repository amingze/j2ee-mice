window.onload=function(){
    if(document.getElementById("name").innerText!=""){
        document.getElementById("login").style.display="none";
        document.getElementById("register").style.display="none";
        document.getElementById("logout").style.display="block";
    }
	
	
	function hotChange(){
	var current_index = 0;		
	var timer = window.setInterval(autoChange,2000);	
	var button_li = document.getElementById("button").getElementsByTagName("li");		
	var pic_li = document.getElementById("banner_pic").getElementsByTagName("li");		
	for(var i=0; i<button_li.length; i++){
		button_li[i].onmouseover = function(){
			if(timer){
				clearInterval(timer);
				}
			for(var j=0; j<pic_li.length; j++){
				if(button_li[j]==this){
					button_li[j].className="current";
				pic_li[j].className = "current";	
					}
			    else{
				button_li[j].className = "but";
				pic_li[j].className = "pic";
				}
				}
			}
		}
		
	
	
	function autoChange(){
		++current_index;	
		if(current_index == button_li.length){
			current_index = 0;
			}
			
		for(var i=0;i<button_li.length;i++){
			if(i == current_index){
				button_li[i].className = "current";	 
				pic_li[i].className = "current";	
				}
			else{
				button_li[i].className = "but";	
				pic_li[i].className = "pic";
				}
 				}
	}
	}
	hotChange();
	
	
	
	function school(){
	var speed=30;	
	var imbox =document.getElementById("imgbox");
	imgbox.innerHTML += imgbox.innerHTML;
	var span = imgbox.getElementsByTagName("span"); 
	var timer = window.setInterval(marquee,speed);
	imgbox.onmouseover = function(){
		clearInterval(timer);
		}
	imgbox.onmouseover = function(){
		timer=setInterval(marquee,speed);
		}
	
	
	
	function marquee(){
		if(imgbox.scrollLeft > span[0].offsetwidth){
			imgbox.scrollLeft=0;
			}
		else{
			++imgbox.scrollLeft;	
			}
		}
	}
	school();
	

	
	
}