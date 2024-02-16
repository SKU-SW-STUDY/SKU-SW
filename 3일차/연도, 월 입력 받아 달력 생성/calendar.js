
function viewMonth_v2(number){  // 월과 순서를 받을 변수 선언, Element 문자열 이어붙이기 
    let now = new Date(2024, number, 0);        /* 월의 마지막 날 구하기*/
    let startDay = new Date(2024, number-1, 1);     /* 월의 첫번째 날 구하기*/

    let lastDay = now.getDate();

    let txt = document.getElementById("cal");
    txt.innerHTML = `${number}월 캘린더 ${lastDay}일 까지`;

    let cal = document.getElementById("createTable");   /* 테이블 body에 표현될 달력 */

    let calBody = "";
    let daynum = 1; // 일수를 표현할 변수 
    let col = 0;

    /* 1행 시작 */

    calBody +="<tr>";
    for(let i=0; i < startDay.getDay(); i++){   /* 요일로 공백 채우기, 첫 번째 날의 요일을 구해서 공백을 계산하기 */
        calBody += `<td></td>`;
    }

    for(let i=0; i< 7-startDay.getDay(); i++){  /* 날짜로 채우기 */
        calBody += `<td>${daynum}</td>`;
        daynum++;
    }
    calBody += "</tr>";

    /* 1행 완료 */

    /* 1행을 제외한 나머지열 구하기 */
    for(let i = 1; i < lastDay/7; i++){      /* 행을 반복할 횟수 */
        calBody +="<tr>";

        for(let k=1; k<=7; k++){                /* 열을 반복할 횟수 */
            calBody += `<td>${daynum}</td>`;
            daynum++;

            if(daynum > lastDay) break;      /* 일수를 표현할 변수가 지정된 변수값 보다 커지면 반복 종료 */
        }

        calBody += "</tr>";
    }

    cal.innerHTML = calBody;        /* 마지막 문자열로 만든 달력 삽입 */
}

function viewMonth_v3(number){  // 월과 순서를 받을 변수 선언, element 생성하기 
    let now = new Date(2024, number, 0);        /* 월의 마지막 날 구하기*/
    let startDay = new Date(2024, number-1, 1);     /* 월의 첫번째 날 구하기*/

    let lastDay = now.getDate();

    let txt = document.getElementById("cal");
    txt.innerHTML = `${number}월 캘린더 ${lastDay}일 까지`;

    let cal = document.getElementById("createTable");   /* 테이블 body에 표현될 달력 */

    let calBody = "";
    let daynum = 1; // 일수를 표현할 변수 
    let col = 0;

    let tr = document.createElement("tr");
    let td = document.createElement("td");
    let table = document.createElement("table");
    let txtNode = "";

    /* 1행 시작 */

    for(let i=0; i < startDay.getDay(); i++){   /* 요일로 공백 채우기, 첫 번째 날의 요일을 구해서 공백을 계산하기 */
        td = document.createElement("td");

        txtNode = document.createTextNode("");
        td.appendChild(txtNode);
        tr.appendChild(td);
    }

    for(let i=0; i< 7-startDay.getDay(); i++){  /* 날짜로 채우기 */
        td = document.createElement("td");

        txtNode = document.createTextNode(daynum);
        td.appendChild(txtNode);
        tr.appendChild(td);
        daynum++;
    }

    table.appendChild(tr);

    /* 1행 완료 */

    /* 1행을 제외한 나머지열 구하기 */ 
    for(let i = 1; i < lastDay/7; i++){      /* 행을 반복할 횟수 */

        tr = document.createElement("tr");

        for(let k=1; k<=7; k++){                /* 열을 반복할횟수 */
            td = document.createElement("td");

            if(daynum > lastDay) //break;      /* 일수를 표현할 변수가 지정된 변수값 보다 커지면 반복 종료 */
            {

                txtNode = document.createTextNode("");
                td.appendChild(txtNode);
                tr.appendChild(td);

            }else{
                txtNode = document.createTextNode(daynum);
                td.appendChild(txtNode);
                tr.appendChild(td);
                daynum++;
            }
        }

        table.appendChild(tr);
    }

    cal.innerHTML = table.innerHTML;        /* 마지막 문자열로 만든 달력 삽입 */
}

function viewMonth_v4(){  // input에서 받은 연도와 월을 받아 달력 만들기 
    
    let year = document.getElementById("year").value;
    let month = document.getElementById("month").value;

    let now = new Date(year, month, 0);        /* 월의 마지막 날 구하기*/
    let startDay = new Date(year, month-1, 1);     /* 월의 첫번째 날 구하기*/

    let lastDay = now.getDate();

    let txt = document.getElementById("cal");
    txt.innerHTML = `${year}년${month}월 캘린더 ${lastDay}일 까지`;

    let cal = document.getElementById("createTable");   /* 테이블 body에 표현될 달력 */

    let calBody = "";
    let daynum = 1; // 일수를 표현할 변수 
    let col = 0;

    let tr = document.createElement("tr");
    let td = document.createElement("td");
    let table = document.createElement("table");
    let txtNode = "";

    /* 1행 시작 */

    for(let i=0; i < startDay.getDay(); i++){   /* 요일로 공백 채우기, 첫 번째 날의 요일을 구해서 공백을 계산하기 */
        td = document.createElement("td");

        txtNode = document.createTextNode("");
        td.appendChild(txtNode);
        tr.appendChild(td);
    }

    for(let i=0; i< 7-startDay.getDay(); i++){  /* 날짜로 채우기 */
        td = document.createElement("td");

        txtNode = document.createTextNode(daynum);
        td.appendChild(txtNode);
        tr.appendChild(td);
        daynum++;
    }

    table.appendChild(tr);

    /* 1행 완료 */

    /* 1행을 제외한 나머지열 구하기 */ 
    for(let i = 1; i < lastDay/7; i++){      /* 행을 반복할 횟수 */

        tr = document.createElement("tr");

        for(let k=1; k<=7; k++){                /* 열을 반복할횟수 */
            td = document.createElement("td");

            if(daynum > lastDay) //break;      /* 일수를 표현할 변수가 지정된 변수값 보다 커지면 반복 종료 */
            {

                txtNode = document.createTextNode("");
                td.appendChild(txtNode);
                tr.appendChild(td);

            }else{
                txtNode = document.createTextNode(daynum);
                td.appendChild(txtNode);
                tr.appendChild(td);
                daynum++;
            }
        }

        table.appendChild(tr);
    }

    cal.innerHTML = table.innerHTML;        /* 마지막 문자열로 만든 달력 삽입 */
}