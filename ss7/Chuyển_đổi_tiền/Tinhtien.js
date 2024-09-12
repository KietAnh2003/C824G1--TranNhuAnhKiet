function doitien() {
    let Amount = document.getElementById('Amount').value;
    let fromC = document.getElementById('from').value;
    let toC = document.getElementById('to').value;
    let Ketqua;

    if (fromC === "USD" && toC === "VND") {
        Ketqua = "Kết quả = " + (Amount * 24530) + "Đ";
    } else if (fromC === "VND" && toC === "USD") {
        Ketqua = "Kết qua = " + (Amount / 24530) + "$";
    } else if (fromC === "CND" && toC === "VND") {
        Ketqua = "Ket qua = " + (Amount * 18080) + "Đ";
    } else if (fromC === "VND" && toC === "CND") {
        Ketqua = "Kết quả = " + (Amount / 18080) + "$";
    } else if (fromC === "USD" && toC === "CND") {
        Ketqua = "Kết quả = " + (Amount * 1.36) + "$";
    } else if (fromC === "CND" && toC === "USD") {
        Ketqua = "Kết quả = " + (Amount / 1.36) + "$";
    } else {
        Ketqua = "Kết quả = " + Amount + (fromC === "USD" ? " $" : " Đ");

    }
    document.getElementById("Ketqua").innerHTML = Ketqua;
}