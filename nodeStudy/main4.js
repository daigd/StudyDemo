var fs = require("fs");
fs.readFile("input.txt",function(err,data){
	if(err){
		console.log(err);
	}
	console.log("read data:\n"+data.toString());
});
console.log("End!");
//�Զ�дģʽ���ļ�,������������׳��쳣
console.log("r+ start:");
fs.open("mj.txt","r+",function(err){
	if(err){
		return console.error(err);
	}
	console.log("r+ OK!");
});
console.log("r+ end!");

//�Զ�дģʽ���ļ�,����������򴴽�
console.log("w+ start:");
fs.open("mj.txt","w+",function(){
	console.log("w+ OK!");
});
console.log("w+ end:");

//��ȡ�ļ���Ϣ
fs.stat("./mj.txt",function(err,stats){
	if(err){
		return console.error(err);
	}
	console.log(stats);
	console.log("read stats success!");
	
	//�ж��ǲ����ļ�
	console.log("mj.txt isFile():"+stats.isFile());
	//�ж��ǲ���Ŀ¼
	console.log("mj.txt isDirectory():"+stats.isDirectory());
});

//д���ļ�
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

//�첽ģʽ�¶�ȡ�ļ�
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
		//�������ȡ���ֽ�
		if(bytes>0){
			console.log(buf.slice(0,bytes).toString());
		}
		console.log("Read gd.txt end!");
		//�ر��ļ�
		fs.close(fd,function(err){
			if(err){
				return console.error(err);
			}
			console.log("gd.txt is closed!");
		});
	});
});

//ɾ���ļ�
console.log("Begin to delete gd.txt!");
fs.unlink("gd.txt",function(err){
	if(err){
		return console.error(err);
	}
	console.log("Delete gd.txt success!");
});

//����Ŀ¼
console.log("Make dir /tmp/test/");
fs.mkdir("/tmp/test/",function(err){
	if(err){
		return console.error(err);
	}
	console.log("Make dir success!");
});

