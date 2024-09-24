caculate();

function caculate() {
    let number;
    do {
        number = parseFloat(prompt("Hãy nhập vào 1 số để tính bình phương"));
    } while (isNaN(number))

    let result = Math.pow(number, 2);
    alert("Kết quả là: " + result)
}
