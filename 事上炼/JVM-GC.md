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



### 内存溢出与内存泄漏



### Stop The World



### 垃圾回收的并行与并发



### 安全点与安全区域



### 强引用、软引用、弱引用、虚引用、终结器引用