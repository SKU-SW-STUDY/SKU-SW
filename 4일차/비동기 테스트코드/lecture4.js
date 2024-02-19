const type1 = () => {  /* 3초를 기다리지 않고 비동기적으로 출력 : 10 */
    let data = 10;

    setTimeout(() => {
        data = 100;
    }, 3000);

    console.log(data);
};

const type2 = (callback) => {  /* callback 에서 콘솔찍는 경우 3초 뒤에 찍힌다. */
    let data = 10;

    setTimeout(() => {
        data = 100;
        callback(data);
    }, 3000);
};

const cb = function myCallback(data) {
    console.log(data);
}

const test = (callback) => {    /* My Test */
    let data = 10;

    setTimeout(() => {
        data = 100;
        callback(data);
    }, 3000);
}

const network = function network(data){
    console.log("네트워크 연결 완료:"+data);
}

const type3 = () => {
    return new Promise(function(resolve, reject){   /* 성공시 resolve, 실패시 reject 호출 */
        let data = 10;
        setTimeout(() => {
            data = 1000;
            resolve(data);
        }, 3000);
    });
}

type3().then(function(result){  /* 우리가 기다리는 데이터 (then : 대기) */
    console.log(result);    /* type3에서 resolve 함수가 전달한 인자를 받음 */
});

async function type4(){
    let result = await type3();     /* type3가 끝날 때 까지 대기 await 는 async 와 같이 사용 */
    console.log(result);
}

type4();