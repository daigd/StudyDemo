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

//Node.js 常用工具
//util是Node.js的核心模块
var util = require("util");
function Base(){
	this.name = "base";
	this.base = 1991;
	this.sayHello = function(){
		console.log("Hello,"+this.name);
	};
}

Base.prototype.showName = function(){
	console.log(this.name);
};

function Sub(){
	this.name = "sub";
}

util.inherits(Sub,Base);

var objBase = new Base();
objBase.showName();
objBase.sayHello();
console.log(objBase);
//Sub通过inherits()仅仅继承了Base在原型中定义的函数
//在构造函数内部创造的base属性和sayHello()函数无法被继承
//强行调用objSub.sayHello()会报错
var objSub = new Sub();
objSub.showName();
//objSub.sayHello();
console.log(objSub);

//util.inspect将任意对象转化为字符串的方法
//util.inspect不会简单地把对象转为字符串,即使对象定义了toString()方法也不会调用
var util = require("util");
function Person(){
	this.name = "person";
	this.toString = function(){
		return this.name;
	};
}

var obj = new Person();
console.log(util.inspect(obj));
//util.inspect(object,[showHidden],[depth],[colors]):
//showHidden:true-表示输出更多隐藏信息
//depth:表示最大递归层数
//color:true，输出格式将会以ANSI颜色编码
console.log(util.inspect(obj,true,2,true));

//util.isArray(obj):true-是数组,false-不是数组
var util = require("util");
console.log(util.isArray([]));
console.log(util.isArray(new Array));
console.log(util.isArray({}));

//util.isRegExp(obj):true-是正则表达式,false-不是数组
console.log(util.isRegExp(/som/));
console.log(util.isRegExp(new RegExp("AB")));
console.log(util.isRegExp({}));

//utils.isDate(obj):true-是日期,false-不是数组
console.log("isDate:"+util.isDate(new Date()));
console.log("isDate:"+util.isDate({}));


