// 모듈 추출 (서버에 대한 정보를 가져온다.)
const express = require('express');

// 서버 생성 
const app = express();

// request 이벤트 리스너 설정
/* app.use((request, response)=>{
    response.send('<h1>Hello express </h1>');
});*/

// request 이벤트 리스너 설정 - 라우터 (parameter 가져오기)
app.get('/page/:id', (request, response)=>{
    const id = request.params.id;

    response.send(`<h1>${id} Page</h1>`);
});

// 서버 실행 
app.listen(52273, ()=>{
    console.log("server running at http://127.0.0.1:52273");
});