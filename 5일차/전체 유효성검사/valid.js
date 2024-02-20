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
    return true;
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
    return true;
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
        return true;
    }
    
}

const selectMonth = () =>{
    let year = $.trim($("#year").val());
    year = Number(year);
    let month = $("#month");
    let days = "";

    let createSelect = $("#days");

    if(year < 1900 || year > 2050){
        alert("연도는 1900 에서 2050 사이로 입력해 주세요");
        $("#year").val("");
        month.val("NONE");
        return false;
    }else{
        if(month.val()!="NONE"){
            days = new Date(year, month.val(), 0);
            console.log(days);
            let txt = "<option value='NONE'>일</option>";
            for(let i=1; i<=days.getDate(); i++){
                txt += `<option value="${i}">${i < 10 ? '0'+i : i}</option>`;
            }
            createSelect.html(txt);
            createSelect.show();
        }
    }

}

const submitCheck = () => {
    let check = "";

    if(idChk()){
        if(pwChk()){
            check = categoryBtn();
        }
    }

    let name = $("#name");
    let year = $.trim($("#year").val());
    year = Number(year);

    let month = $("#month").val();
    let days = $("#days").val();

    if(check){
        if($.trim(name.val()) == ""){
            alert("이름을 입력하세요");
            return false;
        }

        if(year < 1900 || year > 2050){
            alert("연도는 1900 에서 2050 사이로 입력해 주세요");
            $("#year").val("");
            return false;
        }

        if(month == "NONE"){
            alert("월을 선택해주세요.");
            return false;
        }

        if(days == "NONE"){
            alert("일을 선택해주세요.");
            return false;
        }

        confirm("정말 제출하시겠습니까?");
    }
}