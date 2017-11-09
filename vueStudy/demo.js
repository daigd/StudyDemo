var app = new Vue({
            el: '#app',
            data:{
				message: 'Hello Vue Dgd!'
	}
})

var app2 = new Vue({
	el:'#app-2',
	data:{
		message:'now:'+new Date().toLocaleString()
	}
});
var app3 = new Vue({
	el:'#app-3',
	data:{
		seen:true
	}
});
var app4 = new Vue({
	el:'#app-4',
	data:{
		todos:[
			{text:'学习JavaScript'},
			{text:'学习Vue'},
			{text:'整个牛项目'},
		]
	}
});

var app5 = new Vue({
	el:'#app-5',
	data:{
		message:'Hello Vue.js!'
	},
	methods:{
		reverseMessage:function(){
			this.message = this.message.split('').reverse().join('')
		}
	}
});

var app6 = new Vue({
	el:'#app-6',
	data:{
		message:'Hello Vue!'
	}
});

Vue.component('todo-item',{
	props:['todo'],
	template:'<li>{{todo.text}}</li>'
})

var app7 = new Vue({
	el:'#app-7',
	data:{
		groceryList:[
			{id:0,text:'蔬菜'},
			{id:1,text:'奶酪'},
			{id:2,text:'随便其它什么人吃的东西'}
		]
	}
})
var example = new Vue({
	data:{
		a:2
	},
	created:function(){
		console.log("a is: "+this.a);
	}
});
var app8 = new Vue({
	el:'#app-8',
	data:{
		message:'Hello'
	},
	computed:{
		reversedMessage:function(){
			return this.message.split('').reverse().join('');
		}
	}
});

var app9 = new Vue({
	el:'#app-9',
	data:{
		firstName:'Foo',
		lastName:'Bar'
	},
	computed:{
		fullName:{
			get:function(){
				return this.firstName+" "+ this.lastName;
			},
			set:function(newValue){
			var names = newValue.split(' ');
			this.firstName = names[0];
			this.lastName = names[names.length-1];
			}
		}
	}
});

var app10 = new Vue({
	el:'#app-10',
	data:{
		styleObject:{
			color:'red',
			fontSize:'20px'
		},
		message:'Hello Vue!'
	}
});
var app11 = new Vue({
	el:'#app-11',
	data:{
		ok:true
	}
});

var app12 = new Vue({
	el:'#app-12',
	data:{
		ok:false
	}
});

var app13 = new Vue({
	el:'#app-13',
	data:{
		loginType:'username'
	},
	methods:{
		toggle:function(){
			if(this.loginType==='username'){
				this.loginType ='email';
			}else{
				this.loginType ='username';
			}
		}
	}
});

var app14 = new Vue({
	el:'#app-14',
	data:{
		ok:false
	}
});

var app15 = new Vue({
	el:'#app-15',
	data:{
		items:[
			{message:'Foo'},{message:'Bar'}
		]
	}
});

var app16 = new Vue({
	el:'#app-16',
	data:{
		parentMsg:'parent',
		items:[
		{msg:'Java'},{msg:'Node.js'},{msg:'Python'}
		]
	}
});

var app17 = new Vue({
	el:'#app-17',
	data:{
		object:{
			firstName:'John',
			lastName:'Doe',
			age:30
		}
	}
});

Vue.component('todo-item18',{
	template:'\
		<li>\
		{{title}}\
		<button v-on:click="$emit(\'romove\')">X</button>\
		</li>\
	',
	props:['title']
	
});

var app18 = new Vue({
	el:'#app-18',
	data:{
		newTodoText:'',
		todos:[
		{
			id:1,
			title:'Do the dishes'
		},{
			id:2,
			title:'Take out the trash'
		},{
			id:3,
			title:'Mow the lawn'
		}
		],
		nextTodoId:4
	},
	methods:{
		addNewTodo:function(){
			this.todos.push({
				id:this.nextTodoId++,
				title:this.newTodoText
			});
			this.newTodoText = '';
		}
	}
});

var app19 = new Vue({
	el:'#app-19',
	data:{
		counter:0
	}
});
var app20 = new Vue({
	el:'#app-20',
	data:{
		name:'Vue.js'
	},
	methods:{
		greet:function(event){
			alert('Hello'+this.name+'!');
			if(event){
				alert(event.target.tagName);
			}
		}
	}
});
var app21 = new Vue({
	el:'#app-21',
	methods:{
		say:function(msg){
			alert(msg);
		}
	}
});
var app22 = new Vue({
	el:'#app-22',
	data:{
		message:'Hi'
	},
	methods:{
		submit:function(){
			this.message='enter';
		}
	}
	
});
var app23 = new Vue({
	el:'#app-23',
	data:{
		message:''
	}
});
var app24 = new Vue({
	el:'#app-24',
	data:{
		msg:'true'
	}
});
new Vue({
	el:'#app-25',
	data:{
		msg:''
	}
	
});
new Vue({
	el:'#app-26',
	data:{
		msg:[]
	}
});

Vue.component('my-component-27',{
	template:'<div>A custom component!</div>'
});
var app27 = new Vue({
	el:'#app-27'
});

Vue.component('my-component-28',{
	template:'<button @click="counter += 1">{{counter}}</button>',
	data:function(){
		return {
			counter:0
		}
	}
});
var app28 = new Vue({
	el:'#app-28'
});

Vue.component('child',{
	props:['message'],
	template:'<span>{{message}}</span>'
});
var app29 = new Vue({
	el:'#app-29'
});

Vue.component('my-component-30',{
	template:'<button v-on:click="incrementCounter">{{counter}}</button>',
	data:function(){
		return {
			counter:0
		}
	},
	methods:{
		incrementCounter:function(){
			this.counter +=1;
			this.$emit('increment');
		}
	}
});
var app30 = new Vue({
	el:'#app-30',
	data:{
		total:0
	},
	methods:{
		incrementTotal:function(){
			this.total += 1;
		}
	}
});
var app31 = new Vue({
	el:'#app-31',
	data:{
		show:true
	}
});