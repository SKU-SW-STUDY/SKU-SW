function idChk(){   /* 아이디 체크하는 함수 */
    let id = $.trim($("#id").val());

    if(id == "") {
        alert("아이디를 입력해주세요");
        return false;
    }

    if(id.length != 8 || !isLower(id.charCodeAt(0))){  
        alert("아이디는 8자리, 첫 번째 글자는 영문 소문자 입니다.");
        $("#id").val("");
        return false;
    }

    alert("아이디 확인 완료");

    $("#idBtn").attr("disabled", true);
    $("#id").attr("readOnly", true);
    $("#idTxt").text("확인완료");
}

function isLower(strValue) {    /* 첫 번째 문자 소문자 인지 확인하는 함수 */
    if(strValue >= 97 && strValue <= 122) return true;
    else return false;
}
  
function pwChk(){   /* 비밀번호 체크하는 함수 */
    let pass = $.trim($("#pass").val());
    let passChk = $.trim($("#passChk").val());

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
        $("#pass").val("");
        return false;
    }

    alert("확인완료");

    $("#pass").attr("readOnly", true);
    $("#passChk").attr("readOnly", true);
    $("#pwTxt").text("확인완료");
}

function categoryBtn(){ /* 카테고리 체크하는 함수 */
    let categoryArr = $("input[name='category']");
    let num = 0;

    categoryArr.each(index => {
         if(categoryArr[index].checked){
            num ++;
        }
    });

    if(num < 2){
        alert("관심분야를 2~3개 선택해 주세요");
        return false;
    } else {
        alert("선택완료");
        $("#cateBtn").attr("disabled", true);
    }
    
}
