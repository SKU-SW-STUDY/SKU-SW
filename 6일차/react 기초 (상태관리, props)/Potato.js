import React, { useState } from "react";

const Food = (props) =>{

    const [count, setCount] = useState(1);
    
    const test = ()=>{
        setCount(count + 1);        // 최종 한번의 랜더링만 이루어지기 때문에 버튼을 누를 때 아무리 많이 호출해도 값은 한번 바뀐다.
    }

    return (
        <div>
            <h1>{count}</h1>   
            <h3>I love {props.name}</h3>
            <img src={props.image} alt={props.name}></img>
            <button onClick={test}>버튼</button>
        </div>
    )
}

export default Food; // 외부로 모듈 내보내기