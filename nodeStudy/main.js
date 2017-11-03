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

//演示缓冲区
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