### 适配器模式笔记
#### 本质：转换匹配，利用功能 

1. 两个类做的功能相同或类似，但是具有不同的接口且双方都不太容易修改时可以使用适配器模式；

2. 在小接口不统一的时候要及时重构，只有在无法改变原有代码和设计时才使用适配器模式，事后控制不如事中控制，事中控制不如
事前控制，无视应用场合而盲目使用适配器模式，其实是本末倒置了。

3. 适配器模式属于结构型（接口适配）设计模式。

#### 示例
> 有两个操作日志的接口:
> 文件操作日志是现有的代码，需要添加数据库操作日志的接口，实现日志操作同时支持数据库操作和文件操作的功能。