
$(document).ready(function(){
    
    var id = localStorage.getItem("user_id");

    var url ='http://localhost:9000/boards/'+id;

    const xhr = new XMLHttpRequest();
    xhr.open('GET', url);
    xhr.send();

    xhr.onreadystatechange = function (e) {
    if (xhr.readyState !== XMLHttpRequest.DONE) return;
        if(xhr.status === 200) { 
            add_row(eval(xhr.responseText));
            
        } else {
            alert("Error!");
        }
    };
})

function add_row(jsonData) {
    var boardDetail = document.getElementById('board');
    for(var i in jsonData){
        row = boardDetail.insertRow(boardDetail.rows.length);  //추가할 행

        title = row.insertCell(0);  //실제 행 추가 여기서의 숫자는 컬럼 수
        see = row.insertCell(1);
        remove = row.insertCell(2);
        create_date = row.insertCell(3);
        open_date = row.insertCell(4);

        see.id="see";
        remove.id="remove";
        title.id="title"


        console.log(jsonData[i].see_authority);

        title.innerHTML = "<td>"+(jsonData[i].content).substring(0, 20)+"</td>"
        see.innerHTML = "<td>보기</td>"
        remove.innerHTML = "<td>삭제</td>"
        create_date.innerHTML = "<td>"+(jsonData[i].created_date).substring(0, 10)+"</td>"
        if(jsonData[i].d_day == 0){
            title.style.color="#ff0000";
            open_date.innerHTML = "<td>오늘</td>";
        }else{
            title.style.color="#000000";
            if(jsonData[i].d_day > 0){
                open_date.innerHTML = "<td>"+(jsonData[i].d_day)+"일</td>";
            }else{
                open_date.innerHTML = "<td>완료</td>"
            }
        }
    }
  }

  $(document).on("click","#see",function(event){
    window.location.replace('http://localhost:8000/write.html'); 
  });

  $(document).on("click","#remove",function(event){
    var jbResult = confirm( '정말로 삭제하시겠습니까?' );
        if(jbResult == true) {
            alert("삭제했당!");
        }
  });