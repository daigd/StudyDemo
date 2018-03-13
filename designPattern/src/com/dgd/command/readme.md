#### 命令模式
#### 本质:封装请求

#### demo1:
> 场景：模拟现实生活中的电脑开机流程,用命令模式来实现。

> 理解:当我们按下机箱的启动按钮时，真正执行开机动作的机箱里面的主板，
> 也就是说，我们只需要知道那个开机按钮就行了，该按钮封装了开机命令,
> 开机命令再把开机动作转交给主板执行，即开机命令只是执行了一个虚的
> 开机动作，它就相当于分配者，把命令分配给真正功能的执行者。

#### demo2:
> 场景:命令模式的可撤销操作。比如实现一个计算器的加减法功能,有撤销与恢复,
> 这是命令模式可撤销操作的一个典型应用。