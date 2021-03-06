#### 备忘录模式
> 定义：
> 在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。

#### 本质:保存和恢复内部状态
> 保存是手段，恢复才是目的，备忘录模式保存的是原生器对象的内部状态，这些状态是不对外开放的，只有原生器对象才能够操作。

适用情况：
> 必须保存对象在某一时刻全部或部分状态，方便以后需要的时候，恢复对象的先前状态，可以使用备忘录模式。

相关模式：
> 备忘录模式与命令模式：二者可以组合使用，在命令模式中，在实现命令的撤销和重做的时候，可以使用备忘录模式来保存操作前后的状态。

缺点：
> 可能会导致很大的内存开销：如果保存的内部状态数据量很大，或者频繁地创建备忘录对象，会导致很大的内存开销。