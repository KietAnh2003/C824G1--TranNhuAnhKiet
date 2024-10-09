
let inLy;
let inHoa;
let inSinh;

inLy = prompt (' Nhập điểm lý');
inHoa = prompt (' Nhập điểm hóa');
inSinh = prompt (' Nhập điểm sinh');

let ly = parseFloat(inLy);
let hoa = parseFloat(inHoa);
let sinh = parseFloat(inSinh);
let tong = ly + hoa + sinh;
let avg = tong/3;

document.write(" Điểm lý =" + inLy + "<br>");
document.write(" Điểm hóa =" + inHoa + "<br>");
document.write(" Điểm sinh =" + inSinh + "<br>");
document.write(" Điểm tổng =" + tong + "<br>");
document.write(" Điểm trung bình =" + avg + "<br>");


