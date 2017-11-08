var fs = require("fs");
fs.readFile("input.txt",function(err,data){
	if(err){
		console.log(err);
	}
	console.log("read data:\n"+data.toString());
});
console.log("End!");
//以读写模式打开文件,如果不存在则抛出异常
console.log("r+ start:");
fs.open("mj.txt","r+",function(err){
	if(err){
		return console.error(err);
	}
	console.log("r+ OK!");
});
console.log("r+ end!");

//以读写模式打开文件,如果不存在则创建
console.log("w+ start:");
fs.open("mj.txt","w+",function(){
	console.log("w+ OK!");
});
console.log("w+ end:");

//读取文件信息
fs.stat("./mj.txt",function(err,stats){
	if(err){
		return console.error(err);
	}
	console.log(stats);
	console.log("read stats success!");
	
	//判断是不是文件
	console.log("mj.txt isFile():"+stats.isFile());
	//判断是不是目录
	console.log("mj.txt isDirectory():"+stats.isDirectory());
});

//写入文件
console.log("write data:");
fs.writeFile("gd.txt","ABCD",function(err){
	if(err){
		return console.error(err);
	}
	console.log("write data success!");
	console.log("--------------------");
	console.log("read data:");
	fs.readFile("gd.txt",function(err,data){
		if(err){
			return console.error(err);
		}
		console.log("read data success:"+data.toString())
	});
});

//异步模式下读取文件
var buf = new Buffer(1024);
console.log("open gd.txt");
fs.open("gd.txt","r+",function(err,fd){
	if(err){
		return console.error(err);
	}
	console.log("open gd.txt success!");
	console.log("Begin to read gd.txt!");
	fs.read(fd,buf,0,buf.length,0,function(err,bytes){
		if(err){
			return console.error(err);
		}
		console.log(bytes+" is read!");
		//仅输出读取的字节
		if(bytes>0){
			console.log(buf.slice(0,bytes).toString());
		}
		console.log("Read gd.txt end!");
		//关闭文件
		fs.close(fd,function(err){
			if(err){
				return console.error(err);
			}
			console.log("gd.txt is closed!");
		});
	});
});

//删除文件
console.log("Begin to delete gd.txt!");
fs.unlink("gd.txt",function(err){
	if(err){
		return console.error(err);
	}
	console.log("Delete gd.txt success!");
});

//创建目录
console.log("Make dir /tmp/test/");
fs.mkdir("/tmp/test/",function(err){
	if(err){
		return console.error(err);
	}
	console.log("Make dir success!");
});

