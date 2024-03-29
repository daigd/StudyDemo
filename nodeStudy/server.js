var http = require("http");
var url = require("url");

function start(route){
	function onRequest(request,response){
		var pathname = url.parse(request.url).pathname;
		console.log("Request for "+pathname+" received.");
		
		//使用自定义的路由模块
		route(pathname);
		
		response.writeHead(200,{"Content-Type":"text/plain"});
		response.write("Hello Server!");
		response.end();
	}
	http.createServer(onRequest).listen(8888);
	console.log("Server has started.");
}

exports.start = start;