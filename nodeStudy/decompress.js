//解压文件
var fs = require("fs");
var zlib = require("zlib");
//解压input.txt.gz文件为input2.txt
fs.createReadStream('input.txt.gz')
  .pipe(zlib.createGunzip())
  .pipe(fs.createWriteStream('input2.txt'));
console.log("end");