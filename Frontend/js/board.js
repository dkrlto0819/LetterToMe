
$(document).ready(function(){
    
    var id = localStorage.getItem("user_id");

    var url ='http://localhost:9000/boards/'+id;

    const xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.send();

    xhr.onreadystatechange = function (e) {
    if (xhr.readyState !== XMLHttpRequest.DONE) return;
        if(xhr.status === 200) { 
            alert(xhr.responseText);
        } else {
            alert("Error!");
        }
    };
})