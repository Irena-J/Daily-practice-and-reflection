[toc]

## 垃圾回收概述

![image-20200601122623588](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200601122623588.png)

![image-20200601122707633](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200601122707633.png)

### 什么是垃圾

![image-20200601123127899](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200601123127899.png)



### 为什么需要 GC

![image-20200601123706511](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200601123706511.png)

### 早期垃圾回收

![image-20200601123842761](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200601123842761.png)

![image-20200601124123316](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200601124123316.png)

### Java 垃圾回收机制

![image-20200601124313437](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200601124313437.png)

![image-20200601124837952](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200601124837952.png)

## 垃圾回收相关算法



### 标记阶段：引用计数算法

对象是否存活判断

![image-20200601130000778](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200601130000778.png)

引用计数算法

![image-20200602185520528](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602185520528.png)

需要注意的是：Java 并没有使用引用技术算法进行垃圾回收

![image-20200602190324273](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602190324273.png)



### 标记阶段：可达性分析算法

也称根搜索算法、追踪垃圾收集

![image-20200602190612256](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602190612256.png)

![image-20200602190756034](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602190756034.png)

GC Roots （重要）

![image-20200602191202234](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602191202234.png)

![image-20200602191536924](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602191536924.png)

注意：

![image-20200602191629582](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602191629582.png)



### 对象的 finalization 机制

![image-20200602192209511](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602192209511.png)

不要主动去调用这个方法

![image-20200602192422780](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602192422780.png)

注意finalize() 方法只会被调用一次

对象的三种状态

![image-20200602200842242](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602200842242.png)

具体过程

![image-20200602193604359](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602193604359.png)

### MAT 与 JProfiler 的GC Roots溯源

![image-20200602201046150](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602201046150.png)

获取dump文件

方式一：命令行使用jmap

![image-20200602201350742](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602201350742.png)



### 清除阶段：标记-清除算法

![image-20200602202520670](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602202520670.png)

![image-20200602202648192](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602202648192.png)

![image-20200602204158601](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602204158601.png)



### 清除阶段：复制算法

![image-20200602205929475](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602205929475.png)

![image-20200602210424780](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602210424780.png)



### 清除阶段：标记-压缩算法

![image-20200602211042420](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602211042420.png)

![image-20200602212349983](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602212349983.png)

对比三种算法

![image-20200602212730349](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602212730349.png)



### 分代收集算法

![image-20200602213132838](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602213132838.png)

![image-20200602213321027](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602213321027.png)

![image-20200602222745427](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602222745427.png)



### 增量收集算法、分区算法

增量收集算法：

![image-20200602222932216](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602222932216.png)

![image-20200602223430771](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602223430771.png)

分区算法：

![image-20200602223707575](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200602223707575.png)



## 垃圾回收相关概念

### System.gc() 的理解

![image-20200603130111240](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603130111240.png)

![image-20200603130707624](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603130707624.png)



### 内存溢出与内存泄漏

内存溢出(OOM)

![image-20200603151549093](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603151549093.png)

![image-20200603152054895](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603152054895.png)

![image-20200603152336851](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603152336851.png)

内存泄漏(memory leak)

![image-20200603152525144](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603152525144.png)

![image-20200603153257089](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603153257089.png)

上面是官网给的例子，就是说一些对象以及不用了，引用已经被释放，但是某个垃圾还被引用连着，被通过可达性分析算法还是能访问到。

eg：

![image-20200603153614528](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603153614528.png)

### Stop The World

主要指用户线程

![image-20200603154212437](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603154212437.png)

![image-20200603154629306](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603154629306.png)



### 垃圾回收的并行与并发

操作系统中的并行和并发

![image-20200603155107197](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603155107197.png)

![image-20200603155257587](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603155257587.png)

![image-20200603155412394](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603155412394.png)

垃圾回收的并发和并行

![image-20200603160523296](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603160523296.png)

![image-20200603160751768](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603160751768.png)

### 安全点与安全区域

安全点safepoint

![image-20200603160908103](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603160908103.png)

![image-20200603161215548](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603161215548.png)

安全区域

![image-20200603161442113](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603161442113.png)

![image-20200603161925325](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603161925325.png)

### 强引用、软引用、弱引用、虚引用、终结器引用

![image-20200603162249736](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603162249736.png)

![image-20200603162728547](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603162728547.png)

大部分，百分之99用的是强引用，缓存的情况下可能会用到软引用和弱引用，对象的跟踪可能会用到虚引用。

### 强引用(Strong Reference)--不回收

![image-20200603163024549](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603163024549.png)

强引用特点

![image-20200603163525207](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603163525207.png)

### 软引用(Soft Reference)--内存不足即回收

![image-20200603163629106](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603163629106.png)

![image-20200603164043520](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603164043520.png)

### 弱引用(Weak Reference)--发现即回收

![image-20200603164859893](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603164859893.png)

![image-20200603165312809](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603165312809.png)

### 虚引用(Phantom Reference) --对象回收跟踪

![image-20200603165702713](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603165702713.png)

![image-20200603165813520](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603165813520.png)

### 终结器引用(Final reference)

![image-20200603170114223](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603170114223.png)



## 垃圾回收器

### GC 分类与性能指标

![image-20200603185134932](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603185134932.png)

![image-20200603190126289](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603190126289.png)

垃圾回收器的分类：

![image-20200603190429733](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603190429733.png)

按照工作模式分：

![image-20200603190511835](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603190511835.png)

按碎片处理方式分：

![image-20200603190835104](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603190835104.png)

评估 GC 的性能指标

![image-20200603191024893](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603191024893.png)

GC 的性能指标

![image-20200603191701046](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603191701046.png)

#### 评估GC性能的指标--吞吐量(throughput)

![](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603193707637.png)

吞吐量和暂停时间

![image-20200603194135990](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603194135990.png)

![image-20200603194230641](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603194230641.png)



### 不同的垃圾回收器概述

![image-20200603194636718](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603194636718.png)

垃圾回收器的发展史

![image-20200603194931632](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603194931632.png)

7 款经典的垃圾回收器

![image-20200603195603163](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603195603163.png)

垃圾收集器与分代之间的关系

![image-20200603200030047](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603200030047.png)

垃圾收集器的组合关系

![image-20200603200207560](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603200207560.png)

为什么要有这么多垃圾回收器

![image-20200603200729573](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603200729573.png)

如何查看默认的垃圾收集器
![image-20200603204429370](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603204429370.png)

### Seria回收器：串行回收

![image-20200603204910465](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603204910465.png)

![image-20200603205300048](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603205300048.png)

![image-20200603205346285](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603205346285.png)



![image-20200603205545269](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603205545269.png)



### ParNew回收器：并行回收

![image-20200603210334488](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603210334488.png)



![image-20200603210531757](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603210531757.png)



![image-20200603210725794](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603210725794.png)



![image-20200603210835418](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603210835418.png)

### Paralle回收器：吞吐量优先

![image-20200603211345845](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603211345845.png)



![image-20200603211552098](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603211552098.png)



![image-20200603211842473](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603211842473.png)



![image-20200603211911340](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603211911340.png)



![image-20200603212019054](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603212019054.png)



![image-20200603212534441](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603212534441.png)



![image-20200603213532863](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603213532863.png)

###  CMS回收器：低延迟

![image-20200603213747436](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603213747436.png)



![image-20200603214301697](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603214301697.png)



![image-20200603214341721](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603214341721.png)

工作原理

![image-20200603214455232](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603214455232.png)

![image-20200603214807964](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603214807964.png)

![image-20200603215156205](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603215156205.png)



![image-20200603215237294](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603215237294.png)



![image-20200603215417434](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603215417434.png)



![image-20200603215457129](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200603215457129.png)





### G1回收器：区域化分代式



### 垃圾回收器总结



### GC日志分析



### 垃圾回收器的新发展

















