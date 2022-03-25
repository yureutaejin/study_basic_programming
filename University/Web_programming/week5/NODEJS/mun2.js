let date = new Date();
let hours = date.getHours();

if (hours<11) {
    console.log("아침 먹을 시간");
} else if (hours < 13) {
    console.log("점심 먹을 시간");
} else if (hours >= 18) {
    console.log("저녁 먹을 시간");
} else {
    console.log("배고플 때 식사하세요. 맛있게요!");
}