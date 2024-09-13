function tinhCanNang() {
    let canNang = document.getElementById("canNang");
    let chieuCao = document.getElementById("chieuCao");
    let BMI = (canNang / Math.pow(chieuCao,2))
    let ketQua;

    if (BMI < 18.5) {
        document.write("Underweight");}
    else if  (BMI < 25.0) {
        document.write("Normal"); }
    else if (BMI < 30.0) {
        document.write("Overweight");}
    else
        document.write("Obese");
    document.getElementById("ketQua").innerHTML = ketQua;
    }

