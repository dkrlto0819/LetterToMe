
$(document).ready(function(){  
    var submit = document.getElementById('submit');
    var home = document.getElementById('home');

    home.addEventListener('click', function(event){
        var jbResult = confirm( '나가시겠습니까?' );
        if(jbResult == true) {
            window.location.replace(document.referrer); 
        }
    })

    submit.addEventListener('click', function(event){

        var formData = {
            "date": $('#date').val(),
            "content": $('#content').val()
        }

        console.log(formData);

        // $.ajax({
        //     url : apiurl,
        //     type : "POST",
        //     data : JSON.stringify(formData),
        //     contentType : "application/json; charset=UTF-8",
        //     async: false,
        //     success : function(data) {
        //         if(data=="" || undefined || null){
        //             alert("저장되었습니다.");
        //             window.location.replace('http://localhost:8000/write.html'); 
        //         }
        //         else{
        //             console.log(data);
        //             add_row(eval(data));
        //         }
        //     },
        //     error : function(xhr, status, error) {
        //         alert("에러발생");
        //     }
        // })
    })

})