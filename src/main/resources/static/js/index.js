function writeView(){
    location.href="/writeView";
}

function writeAdd(){
    let writer = document.getElementById("writer").value;
    let password = document.getElementById("password").value;
    let title = document.getElementById("title").value;
    let content = document.getElementById("content").value;

    if(writer.trim() == "") {
        alert("작성자를 입력해 주세요");
        return false;
    }
    if(password.trim() == "") {
        alert("비밀번호를 입력해 주세요");
        return false;
    }
    if(title.trim() == "") {
        alert("제목을 입력해 주세요");
        return false;
    }
    if(content.trim() == "") {
        alert("게시글을 입력해 주세요");
        return false;
    }

    // POST 요청을 보낼 데이터 객체
    const postData = {
        writer: writer,
        password: password,
        title : title,
        content : content
    };

    fetch('/writeInsert', {
        method: 'POST', // 요청 메서드를 POST로 설정합니다.
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(postData)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('네트워크 응답이 실패했습니다.');
            }
            return response.json();
        })
        .then(data => {

            if(data.code == 200){
                alert("게시글 작성에 성공하였습니다.");
                location.href='/';
            }

        })
        .catch(error => {
            console.error('통신 중 오류가 발생했습니다:', error);
        });
}