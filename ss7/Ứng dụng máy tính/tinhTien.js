function add(){
    let numBer1= document.getElementById("numBer1").value;
    let numBer2= document.getElementById("numBer2").value;
    let ketQua= Number( numBer1) + Number(numBer2);
    document.getElementById("ketQua").innerHTML = ketQua;
}
function sub(){
    let numBer1= document.getElementById("numBer1").value;
    let numBer2= document.getElementById("numBer2").value;
    let ketQua= Number( numBer1) - Number(numBer2);
    document.getElementById("ketQua").innerHTML = ketQua;
}
function mul(){
    let numBer1= document.getElementById("numBer1").value;
    let numBer2= document.getElementById("numBer2").value;
    let ketQua= Number( numBer1) * Number(numBer2);
    document.getElementById("ketQua").innerHTML = ketQua;
}
function div() {
    let numBer1 = document.getElementById("numBer1").value;
    let numBer2 = document.getElementById("numBer2").value;
    if (numBer2 != 0) {
        let ketQua = Number(numBer1) / Number(numBer2);
    } else {
        document.getElementById("ketQua").innerHTML = "Lỗi không chia được cho 0!";
    }
}



