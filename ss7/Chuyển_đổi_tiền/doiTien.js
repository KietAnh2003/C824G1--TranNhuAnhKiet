function  doiTien() {
    let Amount = document.getElementById('Amount').value;
    let fromCurrency = document.getElementById('fromCurrency').value;
    let toCurrency = document.getElementById('toCurrency').value;
    let ketQua;

    if (fromCurrency === "USD" && toCurrency === "VND") {
        ketQua = "Kết quả = " + (Amount * 24530) + "Đ";
    } else if (fromCurrency === "VND" && toCurrency === "USD") {
        ketQua = "Kết qua = " + (Amount / 24530) + "$";
    } else if (fromCurrency === "CND" && toCurrency === "VND") {
        ketQua = "Ket qua = " + (Amount * 18080) + "Đ";
    } else if (fromCurrency === "VND" && toCurrency === "CND") {
        ketQua = "Kết quả = " + (Amount / 18080) + "$";
    } else if (fromCurrency === "USD" && toCurrency === "CND") {
        ketQua = "Kết quả = " + (Amount * 1.36) + "$";
    } else if (fromCurrency === "CND" && toCurrency === "USD") {
        ketQua = "Kết quả = " + (Amount / 1.36) + "$";
    } else {
        ketQua = "Kết quả = " + Amount + (fromCurrency === "USD" ? " $" : " Đ");

    }
    document.getElementById("ketQua").innerHTML = ketQua;
}