function ajax() {
  var oReq = new XMLHttpRequest();

oReq.addEventListener("load", function() {
  console.log(this.responseText);
});

  oReq.open("GET", "http://www.example.org/example.txt");
  oReq.send();
}


var json객체로변환된값 = JSON.parse("서버에서 받은 JSON 문자열");
