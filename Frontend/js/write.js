
$(document).ready(function(){  
    var submit = document.getElementById('submit');
    var home = document.getElementById('home');

    home.addEventListener('click', function(event){
        var jbResult = confirm( '나가시겠습니까?' );
        if(jbResult == true) {
            window.location.replace('http://localhost:8000/board.html'); 
        }
    })

    submit.addEventListener('click', function(event){
        
    })

})