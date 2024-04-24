let editor;
    ClassicEditor.create( document.querySelector('#content'), {
    language: 'ko'
    /*toolbar: { // toolbar 커스텀 가능
        items: [
            'bold', // bold 버튼 누를 시 strong 태그 삽입
            'undo',
            'redo'
        ]
    },*/
}).then( newEditor => {
    editor = newEditor;
} );

function writeView() {
    location.href = "/writeView";
}

function writeAdd() {
    let writer = document.getElementById("writer").value;
    let password = document.getElementById("password").value;
    let title = document.getElementById("title").value;
    let content = editor.getData();

    if (writer.trim() == "") {
        alert("작성자를 입력해 주세요");
        return false;
    }
    if (password.trim() == "") {
        alert("비밀번호를 입력해 주세요");
        return false;
    }
    if (title.trim() == "") {
        alert("제목을 입력해 주세요");
        return false;
    }
    if (content.trim() == "") {
        alert("게시글을 입력해 주세요");
        return false;
    }

    // POST 요청을 보낼 데이터 객체
    const postData = {
        writer: writer,
        password: password,
        title: title,
        content: content
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

            if (data.code == 200) {
                alert("게시글 작성에 성공하였습니다.");
                location.href = '/';
            }

        })
        .catch(error => {
            console.error('통신 중 오류가 발생했습니다:', error);
        });
}

function deleteBtn(seq) {
    let userInput = prompt("비밀번호를 입력하세요:");

    let password = userInput.trim();

    fetch(`/board/${seq}?password=${password}`, {
        method: 'delete', // 요청 메서드를 POST로 설정합니다.
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('네트워크 응답이 실패했습니다.');
            }
            return response.json();
        })
        .then(data => {
            if (data.code == 200) {
                alert("게시글 삭제에 성공하였습니다.");
                location.href = '/';
            } else if (data.code == 201) {
                alert("게시글과 비밀번호가 일치하지 않습니다.");
            }

        })
        .catch(error => {
            console.error('통신 중 오류가 발생했습니다:', error);
        });
}

function updateBtn(seq) {
    // 비밀번호 입력 받기
    var userInput = prompt("비밀번호를 입력하세요:");
    // 사용자가 취소 버튼을 누른 경우
    if (userInput === null) {
        return; // 함수 종료
    }
    var password = userInput.trim();

    let content = editor.getData();
    // 수정할 내용을 가져

    // 수정할 내용과 비밀번호를 JSON 형식으로 만들기
    var data = {
        password: password,
        content: content
    };

    // 서버로 수정 요청 보내기
    fetch("/board/" + seq, {
        method: "PUT",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('네트워크 응답이 실패했습니다.');
            }
            return response.json();
        })
        .then(data => {
            if (data.code == 200) {
                alert("게시글 수정에 성공하였습니다.");
                location.reload();
            } else if (data.code == 201) {
                alert("게시글과 비밀번호가 일치하지 않습니다.");
            }

        })
        .catch(function (error) {
            console.error("수정 요청 실패:", error);
        });
}

function attachFile(i) {
    document.getElementById('fileInput_' + i).click();
}