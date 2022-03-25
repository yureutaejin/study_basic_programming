let date = new Date();

console.log(date.getFullYear());
console.log(date.getMonth()+1); // getMonth는 반드시 1을 더해야 제 값이 나온다.
console.log(date.getDay());
console.log(date.getHours());
console.log(date.getMinutes());
console.log(date.getSeconds())

if (date.getHours() < 12) {
    console.log("오전입니다.");
} else {
    console.log("오후입니다.");
}