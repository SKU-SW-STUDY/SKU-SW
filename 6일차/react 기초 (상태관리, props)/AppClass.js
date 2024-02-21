import React from "react";

class AppClass extends React.Component{
    state = {
        count : 0,
    };

    add = ()=>{
        console.log('add');
        this.setState({count : this.state.count + 1});  // 정보 은닉으로 인한 직접접근이 아닌 set 함수로의 접근 
    }

    minus = () =>{
        console.log("minus");
        this.setState({count : this.state.count -1});
    }

    render(){
        return(
            <div>
                <h1>The number is :{this.state.count}</h1>
                <button onClick={this.add}>ADD</button>
                <button onClick={this.minus}>MINUS</button>
            </div>
        )
    }
}

export default AppClass;