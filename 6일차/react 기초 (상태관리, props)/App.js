import './App.css';
import Food from './Potato';

/* 
컴포넌트 내부는 하나의 DOM Tree 구조로 가야하는 규칙이 있어 
두개의 태그가 있을 시 jsx expressions must have one parent element 에러 발생
*/
const foodList = [
  {
    name : 'apple',
    image : 'https://place-hold.it/200X100/'
  },
  {
    name : 'potato',
    image : 'https://place-hold.it/250X100/'
  },
  {
    name : 'banana',
    image : 'https://place-hold.it/300X100/'
  }
]

function App() { 
  return (
      <div>
        { // 코드작성을 위한 block
          foodList.map((food) => (    /* javascript map함수랑 foreach 함수랑 차이점은 foreach함수는 값을 return 하지 않는다.*/
            <Food name={food.name} image={food.image}/>
          ))
        }
      </div>
    );
}

export default App;
