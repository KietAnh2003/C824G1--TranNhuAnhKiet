function add(){
    let numb1= document.getElementById("n1").value;
    let numb2= document.getElementById("n2").value;
    let ketqua= Number( numb1) + Number(numb2);
    document.getElementById("ketqua").innerHTML = ketqua;
}
function sub(){
    let numb1= document.getElementById("n1").value;
    let numb2= document.getElementById("n2").value;
    let ketqua= Number( numb1) - Number(numb2);
    document.getElementById("ketqua").innerHTML = ketqua;
}
function mul(){
    let numb1= document.getElementById("n1").value;
    let numb2= document.getElementById("n2").value;
    let ketqua= Number( numb1) * Number(numb2);
    document.getElementById("ketqua").innerHTML = ketqua;
}
function div() {
    let numb1= document.getElementById("n1").value;
    let numb2= document.getElementById("n2").value;
    let ketqua= Number( numb1) / Number(numb2);
    document.getElementById("ketqua").innerHTML = ketqua;

}
