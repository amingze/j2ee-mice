window.onload=function(){
    if(document.getElementById("name").innerText!=""){
        document.getElementById("login").style.display="none";
        document.getElementById("register").style.display="none";
        document.getElementById("logout").style.display="block";
    }    
}