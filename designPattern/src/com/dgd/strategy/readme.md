### 策略模式笔记
#### 本质：分离算法,选择实现

#### demo1:
> 需求：设计一个报价系统,要求如下：
> 1. 对于普通客户,价格为原价;
> 2. 对于老客户,打8折;
> 3. 对于大客户,打7折。
#### demo2:
> 需求:给客户端提供日志记录的方法,正常情况下,记录到数据库中,
> 如果出现异常,则先记录到文件中去,等恰当的时机再写入到数据库,
> 即提供一种容错恢复机制。
#### demo3:
> 需求：工资支付功能。
> 某公司给员工支付工资有现金支付和银行转账支付两种方式,其中,现金支付包括人民币支付和美金支付,
> 用策略模式实现该功能,体现开-闭原则。

> 提示：
> 在实现这个功能的时候,策略算法需要的数据是不一样的,比如现金支付不需要银行卡号,转账支付则需要银行卡号,
> 即策略算法要求的参数是不确定的，其中一种解决的方案是把上下文当作参数传给策略对象,
> 另一种方案是扩展实现策略算法,具体参照代码。