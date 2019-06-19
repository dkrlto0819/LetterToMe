
var show = false;
$(document).ready(function(){

    if(localStorage.getItem('board_id')){
        localStorage.removeItem('board_id');
    }

    var postcheck = document.getElementById('postcheck');
    make_table();
    postcheck.addEventListener('click', function(event){

        var boardDetail = document.getElementById('board');
        row = boardDetail.insertRow(boardDetail.rows.length);  //추가할 행

        for(var i in row){
            $('tbody#board > tr:last').remove();
        }
        if(postcheck.value=="받은 것만 보기"){
            postcheck.value="전체보기";
            show = true;
        }else {
            postcheck.value = "받은 것만 보기"
            show = false;
        }

        make_table();
    })   
})
function make_table(){
    var id = localStorage.getItem("user_id");
    var formData = {"show": show};
    var apiurl ='http://localhost:9000/boards/'+id;

    $.ajax({
        url : apiurl,
        type : "POST",
        data : JSON.stringify(formData),
        // headers: {'Authorization': "1234"}, 
        // dataType: 'json',
        contentType : "application/json; charset=UTF-8",
        async: false,
        success : function(data) {
            if(data=="" || undefined || null){
                alert("등록된 게시물이 없습니다.");
            }
            else{
                console.log(data);
                add_row(eval(data));
            }
        },
        error : function(xhr, status, error) {
            alert("에러발생");
        }
    })
}

var title;
var see;
var remove;
var create_date;
var open_date;
var boardDetail;

function add_row(jsonData) {
    boardDetail = document.getElementById('board');
    for(var i in jsonData){

        if(jsonData[i].d_day == 0){
            sameCode(jsonData, i);
            title.style.color="#ff0000";
            open_date.innerHTML = "<td>오늘</td>";
        }
    }

    for(var i in jsonData){
        if(jsonData[i].d_day != 0){
            sameCode(jsonData, i);
            title.style.color="#000000";
            if(jsonData[i].d_day > 0){
                see.disabled=true;
                see.style.color="#E6E6E6";
                open_date.innerHTML = "<td>"+(jsonData[i].d_day)+"일</td>";
            }else{
                open_date.innerHTML = "<td>완료</td>"
            }
        }
    }
  }

  function sameCode(jsonData, i){
    row = boardDetail.insertRow(boardDetail.rows.length);  //추가할 행

    title = row.insertCell(0);  //실제 행 추가 여기서의 숫자는 컬럼 수
    see = row.insertCell(1);
    remove = row.insertCell(2);
    create_date = row.insertCell(3);
    open_date = row.insertCell(4);

    see.className="see";
    remove.className="remove";
  

    remove.id="remove";
    title.id="title"


    console.log(jsonData[i].see_authority);

    title.innerHTML = "<td>"+(jsonData[i].content).substring(0, 20)+"</td>"
    
    remove.innerHTML = "<td>삭제</td>"
    create_date.innerHTML = "<td>"+(jsonData[i].created_date).substring(0, 10)+"</td>"

    console.log(jsonData[i].board_id);
    see.id=jsonData[i].board_id;
    remove.id=jsonData[i].board_id;
    
    see.innerHTML = "<td>보기</td>"
  }

  $(document).on("click",".see",function(event){
    console.log($(this).attr('id'));
    localStorage.setItem("board_id", $(this).attr('id'));
    window.location.replace('http://localhost:8000/post.html'); 
  });

//   $(document).on("click","see",function(event){
//     var jbResult = confirm( '정말로 삭제하시겠습니까?' );
//         if(jbResult == true) {
//             alert("삭제했당!");
//         }
//   });

  $(document).on("click","remove",function(event){
    var jbResult = confirm( '정말로 삭제하시겠습니까?' );
        if(jbResult == true) {
            alert("삭제했당!");
        }
  });

