### 职责链模式笔记
#### 本质:分离职责,动态组合。动态组合是职责链的精华。

#### demo1:
> 需求:
> 申请人向项目经理申请聚餐费用,但是项目经理只能审批500元以内的申请,如果超过500元并且额度在1000元之内,
> 部门经理可以审批,如果额度超过1000元,只能由总经理来审批,总经理可以审批任意额度的聚餐费用。
> 要求 :
> 用职责链模式来解决此问题。

提示：
> 该场景问题抽象一下即是:
> 客户端发送一个请求,会有很多对象都可以处理该请求,而且不同对象的处理逻辑不一样。
> 对于客户端而言,谁处理无所谓,有对象处理就可以了。而且还希望处理流程可以灵活变动,
> 这样当有新的业务需求的时候,处理对象可以被方便地替换掉。

#### demo2
> 需求：
> 在demo1的基础上,现在添加了一个业务:预支差旅费的审批。
> 要求:
> 接口尽可能保持稳定。

提示:
> 可以考虑定义一套通用的调用框架,请求由一个通用的请求对象来封装,
> 调用方法也是一个通用的调用方法,不同的业务由请求对象的业务标记来标识出来。