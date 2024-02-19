$(document).ready(function(){

     $("#idBtn").on("click", function(e){ 
         console.log("버튼클릭");
         e.preventDefault();    // 기본흐름을 막기위한 함수 
     });
});

function idChk(){   /* 아이디 체크하는 함수 */
    let id = document.getElementById("id").value.trim();
    let btn = document.getElementById("idBtn");

    if(id == "") {
        alert("아이디를 입력해주세요");
        return false;
    }

    if(id.length != 8 || !isLower(id.charCodeAt(0))){   /* 문자열이 소문자인지 확인하는 함수로 valid */
        alert("아이디는 8자리, 첫 번째 글자는 영문 소문자 입니다.");
        document.getElementById("id").value = "";
        return false;
    }

    alert("아이디 확인 완료");
    btn.disabled = true;  //이거로도 동작 안되게 가능 
    document.getElementById("id").readOnly = true;
    document.getElementById("idTxt").innerText = "확인완료";
}

function isLower(strValue) {    /* 첫 번째 문자 소문자 인지 확인하는 함수 */
    
    if(strValue >= 97 && strValue <= 122) return true;
    else return false;
}
  
function pwChk(){   /* 비밀번호 체크하는 함수 */
    let pass = document.getElementById("pass").value.trim();
    let passChk = document.getElementById("passChk").value.trim();

    if(pass == "") {
        alert("비밀번호를 입력해 주세요");
        return false;
    }

    if(passChk == "") {
        alert("비번확인을 입력해 주세요");
        return false;
    }
    
    if(pass != passChk) {
        alert("비밀번호가 일치하지 않습니다.");
        document.getElementById("passChk").value = "";
        return false;
    }

    alert("확인완료");

    document.getElementById("pass").readOnly = true;
    document.getElementById("passChk").readOnly = true;
    document.getElementById("pwTxt").innerText = "확인완료";
}

function categoryBtn(){ /* 카테고리 체크하는 함수 */
    let categoryArr = document.getElementsByName("category");
    let cateBtn = document.getElementById("cateBtn");
    let num = 0;

    categoryArr.forEach(element => {
        if(element.checked){
            num ++;
        }
    });

    if(num < 2){
        alert("관심분야를 2~3개 선택해 주세요");
        return false;
    } else {
        alert("선택완료");
        cateBtn.disabled = true;
    }
    
}
