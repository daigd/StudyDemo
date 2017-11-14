var fs = require("fs");
//演示node.js的异步回调
var data = fs.readFile('input.txt',function(err,data){
	if(err)return console.error(err);
	console.log(data.toString());
});
console.log("end!");

fs.readFile("input.txt",function(err,data){
	if(err) return console.error(err);
	console.log(data.toString());
});
console.log("input2.txt end!");

//引入events 模块
var events = require("events");
//创建EventEmitter对象
var eventEmitter = new events.EventEmitter();

//创建事件处理程序 
var connectHandler = function connected(){
	console.log("connect success!");
	
	//触发data_received 事件
	eventEmitter.emit("data_received");
}

//绑定connection事件处理程序
eventEmitter.on("connection",connectHandler);
//使用匿名函数绑定data_received事件
eventEmitter.on("data_received",function(){
	console.log("receive success!");
});

//触发connection事件
eventEmitter.emit("connection");

console.log("events end!");

//触发error事件
var errorEventEmitter = new events.EventEmitter();
errorEventEmitter.on("error",function(){
	console.log("error occur!");
})
errorEventEmitter.emit("error");

//演示缓冲区:Buffer
var buf = new Buffer(256);
len = buf.write("www.runoob.com");
console.log("buf len="+len);

buf = new Buffer(26);
for(var i=0;i<26;i++){
	buf[i] = i+97;
}
console.log(buf.toString("ascii"));
console.log(buf.toString("utf-8",0,5));
console.log(buf.toString(undefined,0,5));
//javascript 没有二进制数据类型。
//在处理TCP流或者文件流时,必须使用到二进制数据。因此node.js定义了Buffer类,
//专门用于缓存二进制数据。
//将Buffer对象转变为JSON对象
buf = new Buffer("dgd");
var json = buf.toJSON(buf);
console.log(json);

//缓冲区合并
buf = new Buffer("DGD");
var buf1 = new Buffer(" is studying.");
var buf2 = Buffer.concat([buf,buf1]);
console.log("buf2="+buf2.toString());

//缓冲区比较
buf = new Buffer("CD");
buf1 = new Buffer("AC");
var result = buf.compare(buf1);
if(result<0){
	console.log(buf+"在"+buf1+"之前");
}else if(result===0){
	console.log(buf+"与"+buf1+"相同");
}else{
	console.log(buf+"在"+buf1+"之后");
}

//拷贝缓冲区
buf = new Buffer("ABCDEF");
buf1 = new Buffer(6);
buf.copy(buf1);
console.log("copy of buf="+buf1.toString());

//Stream
//从流中读取数据
var fs = require("fs");

//创建可读流
console.log("流对象演示:");
var readStream = fs.createReadStream("stream.txt");
//设置编码为 utf8
readStream.setEncoding("UTF8");
//处理流事件-->data,end,and error
//当有数据可读时触发
readStream.on("data",function(chunk){
	data += chunk;
});
//没有更多数据可读时触发
readStream.on("end",function(){
	console.log("readStream end:"+data);
});
//发生错误时触发
readStream.on("error",function(err){
	console.log(err.stack);
});
console.log("程序执行完毕");

//写入流
var data = "菜鸟学习网站:www.runoob.com";
//创建一个可以写入的流,写入到output.txt中
var writerStream = fs.createWriteStream("output.txt");
//使用UTF8编码
writerStream.write(data,"UTF8");
//标记文件末尾
writerStream.end();

//处理流事件-->finish and error
writerStream.on("finish",function(){
	console.log("output.txt写入完成.");
});
writerStream.on("error",function(err){
	console.log(err.stack);
});
console.log("writerStream 程序执行完毕");

//管道流操作实例
var fs = require("fs");
//创建一个可读流
var readStream = fs.createReadStream("input.txt");
//创建一个可写流
var writeStream = fs.createWriteStream("output.txt");
//管道读写操作
//读取input.txt的内容,并将内容写入到output.txt中
readStream.pipe(writeStream);
console.log("管道流-程序执行完毕");

//链式流-一般用于管道操作
//通过管道和链式来压缩和解压文件
var fs = require("fs");
var zlib = require("zlib");
//压缩input.txt文件为input.txt.gz
fs.createReadStream("input.txt")
	.pipe(zlib.createGzip())
	.pipe(fs.createWriteStream("input.txt.gz"));
console.log("链式流演示-文件压缩完成");

//解压文件
var fs = require("fs");
var zlib = require("zlib");

//解压 input.txt.gz文件为input2.txt
fs.createReadStream("input.txt.gz")
	.pipe(zlib.createGunzip())
	.pipe(fs.createWriteStream("input2.txt"));
console.log("文件解压完成");



