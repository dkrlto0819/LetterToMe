$(document).ready(function() {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', 'http://localhost:9000/boards');
    xhr.send();

    xhr.onreadystatechange = function (e) {
    if (xhr.readyState !== XMLHttpRequest.DONE) return;
        if(xhr.status === 200) { 
            alert(xhr.responseText);
        } else {
            alert("Error!");
        }
    };
    // $.ajax({
    //     url:"http://localhost:9000/boards",
    //     type: "GET"
    // })
    // .done(function() {
    //     alert("요청 성공");
    // })
    // .fail(function() {
    //     alert("요청 실패");
    // })
    // .always(function() {
    //     alert("요청 완료");
    // });
});