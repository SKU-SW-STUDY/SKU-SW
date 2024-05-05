let arr = [1, 5, 6, 8, 11, 12];

$(document).ready(function(){

    $("#sortBtn").on("click", async function(e){    // 이벤트 핸들러도 함수!! async 키워드가 붙어야 await 적용 가능 (await 함수는 promise로 리턴하는 함수만 적용할 수 있다.) 
        arr.sort(() => Math.random() - 0.5);    /* 배열 무작위 정렬 */
        
        for(let i=0; i<arr.length; i++){
            await batchImg(i);
        }

        for(let i=0; i<arr.length; i++){
            for(let j=i; j<arr.length; j++){    /* 배열을 순서대로 정렬하는 버블정렬 알고리즘 */
                if(arr[i] > arr[j]){
                    let tmp = arr[i];
                    arr[i] = arr[j];
                    await batchImg(i);
                    arr[j] = tmp;
                    await batchImg(j);
                }
            }
        }
        
    });
});

function batchImg(i, j="NONE"){   /* 요소를 선택해 정렬중인 arr값에 있는 이미지를 변경 */
    return new Promise(function(resolve, reject){ 
        setTimeout(() => {
            resolve();
            $(".container").children('img').eq(i).attr("src", "image/"+arr[i]+".png");
        }, 1000);
    });
}