// window.onload = function(){
    $(document).ready(function(){   
        var t = document.getElementById('login_form');
        var value;
    
        t.addEventListener('submit', function(event){
            var xhr = new XMLHttpRequest();
    
            var formData ={
                "id": $('#id').val(),
                "password": $('#password').val()
            }
            console.log(JSON.stringify(formData))
            
            $.ajax({
                url : "http://localhost:9000/users/signin",
                type : "POST",
                data : JSON.stringify(formData), 
                // dataType: 'json',
                contentType : "application/json; charset=UTF-8",
                async: false,
                success : function(data) {
                    if(data=="" || undefined || null){
                        alert("아이디와 비밀번호를 확인해주세요.");
                    }
                    else{
                        console.log(JSON.stringify(data));
                        window.location.replace('http://localhost:8000/board.html');
                    }
                },
                error : function(xhr, status, error) {
                    alert("에러발생");
                }
            })
        })
    })