//��ѹ�ļ�
var fs = require("fs");
var zlib = require("zlib");
//��ѹinput.txt.gz�ļ�Ϊinput2.txt
fs.createReadStream('input.txt.gz')
  .pipe(zlib.createGunzip())
  .pipe(fs.createWriteStream('input2.txt'));
console.log("end");