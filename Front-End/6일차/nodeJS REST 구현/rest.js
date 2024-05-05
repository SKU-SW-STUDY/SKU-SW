const express = require('express');

const app = express();

app.listen(3300, ()=>{
    console.log("server running");
});

// Form-encoded 데이터 파싱을 위한 미들웨어 등록 (body데이터 해석을 위함), json : json 타입으로 받음, urlencoded : Form-encoded 로 받음
// 1. json : json 
// 2. urlencoded : Form-encoded

app.use(express.urlencoded({
    extended : false
}));

let userCount = 0;
const users = [];

const user1 = {
    id:1,
    name:'kim',
    region:'seoul'
}

const user2 = {
    id:2,
    name:'lee',
    region:'busan'
}

users.push(user1);
userCount ++;

users.push(user2);
userCount ++;

/* 전체 조회에 대한 URL */
app.get('/user', (request, response)=>{
    response.send(users);
});

/* 조건조회 (사용자ID) */
app.get('/user/:id', (request, response)=>{
    const id = request.params.id;
    const filtered = users.filter((user) => user.id == id); // user.id 가 id 인 값이 있으면 return 

    if(filtered.length == 1) response.send(filtered[0]);
    else response.status(400).send('데이터가 존재하지 않습니다.');


});

/* 넘어온값 넣기 ! */
app.post('/user', (request, response)=>{
    const body = request.body;  // body 정보를 가져온다.
    const member = {
        id : ++userCount,
        name : body.name,
        region : body.region
    }

    users.push(member);
    response.send(users);
});

/* 넘어온값 수정하기! */
app.put('/user/:id', (request, response)=>{
    const id = request.params.id;
    const body = request.body;
    const member = {
        id : id,
        name : body.name,
        region : body.region
    }

    const filtered = users.filter((user) => {
        if(user.id == member.id){
            user.name = member.name;
            user.region = member.region
            return user;
        }
    });

    if(filtered.length == 1) response.send(filtered[0]);
    else response.status(400).send('데이터가 존재하지 않습니다.');
    
});

/* 넘어온값 삭제하기 */
app.delete('/user/:id', (request, response)=>{
    const id = request.params.id;
    let flag = false;

    for(let i in users){
        if(users[i].id == id){
            users.splice(i, 1); // i번째 배열부터 1개씩 삭제 
            flag = true;
            break;
        }
    }

    if(flag) response.send(users);
    else response.status(400).send('데이터가 존재하지 않습니다.');
});