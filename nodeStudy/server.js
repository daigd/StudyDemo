var http = require("http");
http.createServer(function(req,res){
	res.writeHead(200,{'Content-Type':'text/plain'});
	//������Ӧ����
	res.end('Hello node\n');
}).listen(8888);


console.log("Server running ad http://127.0.0.1:8888/");