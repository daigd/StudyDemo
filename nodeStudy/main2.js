//Node.js ģ��ϵͳ
//�ļ���ģ����һһ��Ӧ��,��һ��Node.js�ļ�����һ��ģ��
//Node.js�ṩ��exports��require����

var hello = require("./hello");
hello.world();

//ģ��ӿ�
//����һ��hello2��ģ��ӿ�
var Hello = require("./hello2")
hello = new Hello();
hello.setName("DGD");
hello.sayHello();

//Node.js �еĺ���
var http = require("http");
http.createServer(function(req,res){
	res.writeHead(200,{"Content-Type":"text/plain"});
	res.write("Hello DGD and Node");
	res.end();
}).listen(8899);
console.log("running at http://127.0.0.1:8888");

