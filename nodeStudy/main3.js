//Node.js 的全局变量
//__filename 表示当前正在执行的脚本文件名:输出的是绝对路径
console.log("The file name="+__filename);

//__dirname 表示当前脚本所在的目录
console.log("The dir is : "+__dirname);

//setTimeout(cb,ms):在ms毫秒后执行一次指定函数cb

var t = setTimeout(function(){
	console.log("Hello DGD!");
},2000);
clearTimeout(t);
//clearTimeout(t) 清除定时器t
var t = setTimeout(function(){
	console.log("I am here!");
},3000);
clearTimeout(t);

//setInterval(cb,ms) 在指定ms毫秒后执行函数cb,且会永久执行下去,直到clearInterval()被调用或强制关闭
var t = setInterval(function(){
	console.log("I LOVE MJ.");
},1000);

setTimeout(function(){
	clearInterval(t);
},1000*2);

//console
//输出当前调用栈的信息
console.trace();

//console各个方法的用法
console.log("Console Begin:");
var counter = 10;
console.log("counter=%d",counter);
console.time("runtime");
console.timeEnd("runtime");
console.info("Console End!");

//process : 描述当前Node.js进程状态的对象
process.on("exit",function(code){
	setTimeout(function(){
		console.log("Never begin.");
	},0);
	console.log("code=",code);
});
console.log("Process End!");

//输出当前目录
console.log("process.cwd="+process.cwd());
//输出当前版本
console.log("process.version="+process.version);
//输出内存使用情况
console.log(process.memoryUsage());
//输出Node已经运行的秒数
console.log("uptime:"+process.uptime());
