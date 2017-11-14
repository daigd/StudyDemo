//Node.js 模块系统
//文件和模块是一一对应的,即一个Node.js文件就是一个模块
//Node.js提供了exports和require对象

var hello = require("./hello");
hello.world();

//模块接口
//创建一个hello2的模块接口
var Hello = require("./hello2")
hello = new Hello();
hello.setName("DGD");
hello.sayHello();

//Node.js 中的函数
var http = require("http");
http.createServer(function(req,res){
	res.writeHead(200,{"Content-Type":"text/plain"});
	res.write("Hello DGD and Node");
	res.end();
}).listen(8899);
console.log("running at http://127.0.0.1:8888");

