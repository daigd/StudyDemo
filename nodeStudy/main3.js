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
