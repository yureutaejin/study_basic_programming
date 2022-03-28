/*
-type-
Number
String
Boolean
Undefined
Null
Object
*/

/*
-scope-
var : 함수 scope를 가지는 지역 변수 or 전역 변수 선언
let : 블록 scope를 가지는 지역 변수 선언
const: 블록 scope를 가지는 상수 형태 선언
*/

var myVar = "webp var";
{var myVar2 = "webp var"};
let myLet = 123456789;
{let myLet2 = 123456789;}
const myConst = true;
{const myConst2 = true};

console.log(myVar);
console.log(myLet);
console.log(myConst);
console.log("myVar " + typeof(myVar))
console.log("myLet: " + typeof(myLet))
console.log("myConst: " + typeof (myConst))

console.log("\n")

// console.log(myVar2) // var은 블록되어 있어도 ㄱㅊ
// console.log(myLet2) // scope가 블록 안으로 한정되어 있어 확인 불가
// console.log(myConst2)

/*
-comparison operator-
*/
console.log(2<12);
console.log(2<"12"); // 문자열 형변환
console.log(2 < "Jinwoo"); // "Jinwoo" -- > NaN
console.log(2 > "Jinwoo");
console.log(2 == "Jinwoo");
console.log("2" < "12"); // 문자열 간 비교
console.log("2"=="12");
console.log("12"==="12");

console.log("\n")

console.log(0 == 0);
console.log(0 == "0");
console.log(0 == "000");
console.log(0 == []);
console.log(0 == false);
console.log(0 == "");
console.log(0 == undefined);
console.log(0 == null);

console.log("\n")

console.log(0 === 0);
console.log(0 === "0");
console.log(0 === "000");
console.log(0 === []);
console.log(0 === false);
console.log(0 === "");
console.log(0 ===undefined);
console.log(0 === null);

console.log("\n")

/*
객체 : 정보의 저장/표현을 위한 구조
    중괄호를 이용하여 객체 선언
    속성과 메소드로 구성되어 있음

속성 : 키:값의 형태로 구성되는 객체의 성질
    속성의 값으로 어떠한 형태의 데이터가 와도 상관없음

메소드 : 키:함수의 형태로 구성되는 객체의 동작/기능
    속성의 값 자리에 함수가 오는 경우
*/

var jinwoo = {
    firstName: "jinwoo",
    lastName: "jeong",
    eNum: "02621",
    age: 39,
    eat:function(food) {
        console.log(food + " 맛있겠네~");
    }
}

console.log(jinwoo['firstName']);
console.log(jinwoo.lastName);
jinwoo.eat("햄버거");

console.log("\n")

/*
배열

배열 길이 : .length 활용
배열 인덱싱: [n]
*/

var arr3 = ["Life", "is", "too", "short"]
console.log(arr3.length);
console.log(`${arr3[0]} ${arr3[1]} ${arr3[2]} ${arr3[3]}`);