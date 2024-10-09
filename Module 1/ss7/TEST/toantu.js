
let inWidth;
let inHeight;
// lệnh đổi nhập dữ liệu vào inW và inH
inWidth = prompt (' Enter the width');
inHeight = prompt (' Enter the heigth');

let width = parseFloat(inWidth);
let height = parseFloat(inHeight);
let area = width * height;

// 2 lệnh in ra màn hình
document.body.innerHTML += "Chiều rộng: " + width + "<br>";
document.body.innerHTML += "Chiều cao: " + height + "<br>";
document.write(" Chiều rộng =" + width + "<br>")
document.write(" Chiều dài =" + height + "<br>")
document.write(" Diện tích =" + area)

