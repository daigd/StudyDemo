//Node.js ��ȫ�ֱ���
//__filename ��ʾ��ǰ����ִ�еĽű��ļ���:������Ǿ���·��
console.log("The file name="+__filename);

//__dirname ��ʾ��ǰ�ű����ڵ�Ŀ¼
console.log("The dir is : "+__dirname);

//setTimeout(cb,ms):��ms�����ִ��һ��ָ������cb

var t = setTimeout(function(){
	console.log("Hello DGD!");
},2000);
clearTimeout(t);
//clearTimeout(t) �����ʱ��t
var t = setTimeout(function(){
	console.log("I am here!");
},3000);
clearTimeout(t);

//setInterval(cb,ms) ��ָ��ms�����ִ�к���cb,�һ�����ִ����ȥ,ֱ��clearInterval()�����û�ǿ�ƹر�
var t = setInterval(function(){
	console.log("I LOVE MJ.");
},1000);

setTimeout(function(){
	clearInterval(t);
},1000*2);

//console
//�����ǰ����ջ����Ϣ
console.trace();

//console�����������÷�
console.log("Console Begin:");
var counter = 10;
console.log("counter=%d",counter);
console.time("runtime");
console.timeEnd("runtime");
console.info("Console End!");

//process : ������ǰNode.js����״̬�Ķ���
process.on("exit",function(code){
	setTimeout(function(){
		console.log("Never begin.");
	},0);
	console.log("code=",code);
});
console.log("Process End!");

//�����ǰĿ¼
console.log("process.cwd="+process.cwd());
//�����ǰ�汾
console.log("process.version="+process.version);
//����ڴ�ʹ�����
console.log(process.memoryUsage());
//���Node�Ѿ����е�����
console.log("uptime:"+process.uptime());

//Node.js ���ù���
//util��Node.js�ĺ���ģ��
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
//Subͨ��inherits()�����̳���Base��ԭ���ж���ĺ���
//�ڹ��캯���ڲ������base���Ժ�sayHello()�����޷����̳�
//ǿ�е���objSub.sayHello()�ᱨ��
var objSub = new Sub();
objSub.showName();
//objSub.sayHello();
console.log(objSub);

//util.inspect���������ת��Ϊ�ַ����ķ���
//util.inspect����򵥵ذѶ���תΪ�ַ���,��ʹ��������toString()����Ҳ�������
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
//showHidden:true-��ʾ�������������Ϣ
//depth:��ʾ���ݹ����
//color:true�������ʽ������ANSI��ɫ����
console.log(util.inspect(obj,true,2,true));

//util.isArray(obj):true-������,false-��������
var util = require("util");
console.log(util.isArray([]));
console.log(util.isArray(new Array));
console.log(util.isArray({}));

//util.isRegExp(obj):true-��������ʽ,false-��������
console.log(util.isRegExp(/som/));
console.log(util.isRegExp(new RegExp("AB")));
console.log(util.isRegExp({}));

//utils.isDate(obj):true-������,false-��������
console.log("isDate:"+util.isDate(new Date()));
console.log("isDate:"+util.isDate({}));


