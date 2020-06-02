[toc]



![image-20200527102540248](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527102540248.png)

02-如何看待Java 上层技术与JVM

![image-20200527101205175](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527101205175.png)

编程语言和虚拟机：变量和函数的关系一样。



字节码：关于 java 字节码，指的是 java 语言编译成的字节码，准确说任何能在jvm上执行的字节码格式都是已有的，所以可以统称为"JVM"字节码  

Java 虚拟机就是二进制字节码的运行环境负责装在字节码到其内部，解释/编译为对应平台上的机器指令执行。每一条Java指令，Java虚拟机规范中都有详细定义，如怎么取操作数、处理操作上、处理结果放在那里。

特点：

​	一次编译，到处运行

​	自动内存管理

​	自动垃圾回收功能

(减少了内存泄漏这种情况，程序员只需要管理好字节的业务代码就好)

JVM 的整体结构

![image-20200527110622385](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527110622385.png)

Java 代码的执行流程

![image-20200527111217437](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527111217437.png)

JVM 的架构模型：

Java 编译器输入的指令流基本上是一种基于栈的指令集架构。特点：

​	设计和实现更简单，适用于资源受限的系统；

​	避开了寄存器的分配难题，使用零地址指令方式分配(只有操作数，没有地址，因为栈本事就在栈顶操作并且也只有入和出两个)

​	指令流中的指令大部分是零地址指令，其执行过程依赖于操作栈。指令集更小，编译器容易实现。

​	不需要硬件支持，可移植性更好，更好实现跨平台。

由于跨平台的设计，Java的指令都是根据栈(跨平台、指令集小、指令多，性能比寄存器差点)来设计的。不同平台cpu架构不同，所以不能设计为基于寄存器的

既然性能不如基于寄存器实现的，为什么不改？

因为栈的设计和实现很简单，非资源受限场景可以用，没必要吧。。。。



JVM 的声明周期



启动：通过引导类加载器(bookstorap class loader)创建一个初始类来完成的，这个类是由虚拟机的具体实现指定的。

执行：执行一个所谓的Java程序的时候，真真正正在执行的是一个叫做Java 虚拟机的进程；一个运行中的Java虚拟机有一个清晰的任务，执行Java程序。程序开始执行时他才运行，程序结束时他就停止。

退出： 程序正常执行结束；程序正在执行过程中遇到了异常活错误而异常终止；由于操作系统出现错误而导致Java虚拟机进程终止；某线程调用Runtime类或System类的exit方法，或Runtime类的halt方法，并且Java安全管理器也允许这次exit或halt操作；另外，JNI (Java Native Interface )规范描述了用 JNI Invocation API 来加载或卸载 Java 虚拟机时，Java 虚拟机退出的情况。



HotSpot VM。。。各种虚拟机



自己写JVM，需要注意一定有这两个：类加载器和执行引擎

## 1.类加载的过程



加载 链接 (验证、准备、解析) 初始化；需要了解每个过程大概做了啥，视频中有代码分析的哦

加载：

​	通过一个类的全限定名获取定义此类的二进制字节流

​	将这个字节流代表的静态存储结构转化为方法区(根据版本不同，8以后叫元空间，以前叫永久代)的运行时数据结构

​	在内存中生成一个代表这个类的 java.lang.Class对象，作为方法区这个类的各种数据的访问入口。

(加载.class文件方式，来源于哪些。。)

​	从本地系统直接加载

​	通过网络获取，典型场景：Web Applet

​	从zip压缩包中读取，称为日后jar、war格式的基础

​	运行时计算生成，典型场景：JSP应用

​	由其他文件生成，典型场景：JSP应用

​	从专有数据库中提取.class文件，比较少见

​	从加密文件中获取，典型的防Class文件被反编译的保护措施

![image-20200527144326550](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527144326550.png)

![image-20200527123529751](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527123529751.png)

![image-20200527144246635](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527144246635.png)

![image-20200527124905133](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527124905133.png)

因为执行顺序为 链接(link) -->初始化(init)-->解析(resolve)。其中system等类的加载是在第三步。类在加载的时候在init阶段会调用clinit方法执行对于static代码的执行，是按照定义顺序类的，init方法是在 new 对象的时候调用，会对非static修饰的变量进行赋值操作，也是按照定义顺序类的，最后在调用类本身的构造。init严格的来说应该会首先调用super() 方法执行父类的初始化。

在singletion中，实现线程安全就有一个使用内部类的方式，因为类的static修饰的代码都是被clinit来执行的，但是虚拟机以及保证在多线程会对clinit的执行加锁，从而保证线程安全，也从而导致了静态内部类实现单例的线程安全。

### 几种加载器的体会



JVM 支持两种类型的类加载器，分别为(启动)引导类加载器(Bootstrap ClassLoader) 和 自定义类加载器 (user-Defined ClassLoader)

Java虚拟机规范中将所有派生于抽象类 CLassLoader的类加载器都划分为自定义类加载器。

其实类加载器的类型如何划分。在程序中最常见的类加载器始终只有 3 个。

![image-20200527132145122](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527132145122.png)



![image-20200527132953676](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527132953676.png)

![image-20200527133310038](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527133310038.png)

![image-20200527133420577](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527133420577.png)

![image-20200527133925193](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527133925193.png)

![image-20200527134715020](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527134715020.png)

双亲委派机制：Java 虚拟机对class文件采用的是按需加载的放肆，也就是说当需要使用该类时才会将它的class文件加载到内存生成class对象。而且加载某个类的class文件时，Java虚拟机采用的是双亲委派模式，即把请求交给父类处理，是一种任务委派模式。

![image-20200527141334712](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527141334712.png)

![image-20200527142641580](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527142641580.png)

优点：避免类的重复加载；保护程序安全，防止核心 API 被随意篡改



## 2.其他知识点



类加载器的引用：

![image-20200527144009901](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527144009901.png)

类的主动使用和被动使用

![image-20200527144113671](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527144113671.png)

## 3.运行时数据区概述及线程



![image-20200527145120508](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527145120508.png)

![image-20200527145331411](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527145331411.png)

![image-20200527145552878](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527145552878.png)

#### 线程

![image-20200527150256263](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527150256263.png)

JVM系统线程

![image-20200527150550109](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527150550109.png)

#### PC Register(Program Counter Register)

![image-20200527151100792](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527151100792.png)

作用：

![image-20200527151346725](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527151346725.png)

介绍：

![image-20200527151453466](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527151453466.png)

例如：反编译后字节码文件

![image-20200527152435869](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527152435869.png)



常见问题 1：

![image-20200527152713474](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527152713474.png)

常见问题 2：

![image-20200527160620408](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527160620408.png)

#### 虚拟机栈

![image-20200527180340142](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527180340142.png)

栈的特点

![image-20200527180641887](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527180641887.png)

栈中可能出现的异常：

![image-20200527180816703](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527180816703.png)

![image-20200527181227998](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527181227998.png)

栈运行原理

![image-20200527185303369](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527185303369.png)

栈帧的内部结构

![image-20200527191509068](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527191509068.png)

![image-20200528120405502](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528120405502.png)

##### 局部变量表

![image-20200527194000895](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527194000895.png)

![image-20200527194819282](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527194819282.png)

关于Slot的理解

![image-20200527213722237](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527213722237.png)

![image-20200527213941266](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527213941266.png)

静态变量与局部变量的对比

![image-20200527214549765](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527214549765.png)

变量的分类：

​	按照类型分为：基本数据类型和引用类型

​	按照在类中声明的位置：成员变量和局部变量

​			成员变量：在使用前，都精力过默认初始化赋值

​					类变量: linking 的prepare阶段，给类变量默认赋值-->initial 阶段：给类变量显示赋值即静态代码块赋值

​					实例变量：随着对象的创建，会在堆空间中分配实例变量空间，并进行默认赋值

​			局部变量：	在使用前必须要显示赋值的	

![image-20200527215542234](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527215542234.png)				

##### 操作数栈

![image-20200528090900286](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528090900286.png)

![image-20200528091242948](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528091242948.png)

![image-20200528091512189](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528091512189.png)



![image-20200528093808721](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528093808721.png)



代码追踪

![image-20200528092054933](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528092054933.png)

这里要注意局部变量表之所以没有从 0 开始是因为上述是实例方法，0 处存储的是this



栈顶缓存技术

![image-20200528095416347](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528095416347.png)

##### 动态链接(指向运行时常量池的方法引用)

![image-20200528095740215](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528095740215.png)

常量池的作用就是为了提供一些符号和常量，便于指令的识别。

###### 方法的调用

![image-20200528101905337](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528101905337.png)

![image-20200528102743738](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528102743738.png)

![image-20200528103559161](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528103559161.png)

虚方法和非虚方法

![image-20200528104036146](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528104036146.png)

![image-20200528104155974](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528104155974.png)



![image-20200528113639922](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528113639922.png)



![image-20200528113540394](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528113540394.png)

方法重写的本质

![image-20200528114543353](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528114543353.png)

虚方法表

![](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528114826679.png)



理解方法重写时方法的调用

![image-20200528115806396](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528115806396.png)

##### 方法返回地址

![image-20200528120456435](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528120456435.png)

![image-20200528120846790](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528120846790.png)



![image-20200528121144708](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528121144708.png)

![image-20200528121355143](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528121355143.png)

##### 一些附加信息



![image-20200528121525195](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528121525195.png)



#### 本地方法栈

![image-20200528133652586](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528133652586.png)

![image-20200528133845058](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528133845058.png)

![image-20200528134117864](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528134117864.png)

图片最后一个改一下，有的虚拟机合二为一了  但是HotSopt是没有的



#### 堆

堆的核心概述

![image-20200528144848721](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528144848721.png)

内存细分

![image-20200528150813933](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528150813933.png)



JDK7 的内部空间

![image-20200528151416702](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528151416702.png)

![image-20200528151740299](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528151740299.png)

堆空间大小的设置

![image-20200528151817437](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528151817437.png)

![image-20200528152035389](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528152035389.png)

![image-20200528152557006](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528152557006.png)



年轻代与老年代

![image-20200528154303604](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528154303604.png)

![image-20200528154356583](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528154356583.png)

![image-20200528162044067](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528162044067.png)



对象分配过程概述

![image-20200528163648987](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528163648987.png)

![image-20200528164006820](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528164006820.png)

![image-20200528170408849](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528170408849.png)

新生代对象分配与回收过程

![image-20200528162419486](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528162419486.png)

![image-20200528163253641](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528163253641.png)

![image-20200528163535019](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528163535019.png)

![image-20200528164059448](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528164059448.png)

对象分配的特殊情况

![image-20200528165750093](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528165750093.png)

![image-20200528171523053](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528171523053.png)

分代式GC策略的触发条件

![image-20200528171640872](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528171640872.png)

![image-20200528171904292](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528171904292.png)

![image-20200528171946668](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528171946668.png)

![image-20200528172157347](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528172157347.png)

堆空间的分代思想

![image-20200528173328498](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528173328498.png)

![image-20200528173235544](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528173235544.png)

内存分配策略

![image-20200528173800139](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528173800139.png)

![image-20200528173826132](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528173826132.png)

对象分配过程：TLAB

![image-20200528174547996](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528174547996.png)

![image-20200528174627550](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528174627550.png)

对象分配过程：TLAB

![image-20200528174758647](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528174758647.png)

![image-20200528174905575](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528174905575.png)

图示对象分配的过程

![image-20200528175049644](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528175049644.png)

堆空间的参数设置

![image-20200528180433100](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528180433100.png)

![image-20200528180517265](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528180517265.png)

![image-20200528180918292](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528180918292.png)

逃逸分析

![image-20200528181309996](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528181309996.png)

![image-20200528181637178](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528181637178.png)

逃逸案例

![image-20200528181714140](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528181714140.png)

注意toString方法是返回了新的，而这个新的还在堆上比较巧妙

如何快速判断是否发生了逃逸分析，就看new的对象实体(注意是实体不是引用哦)是否有可能在方法外被调用

![image-20200528182918020](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528182918020.png)

![image-20200528183222314](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528183222314.png)

基于两方面考虑：一个是逃逸分析，还有就是节省空间

##### 逃逸分析：代码优化

逃逸分析是在服务器端才开启的

![image-20200529102642087](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529102642087.png)

代码优化之标量替换

![image-20200529102847447](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529102847447.png)

以上把对象变成局部变量，就减少gc了

逃逸分析还并不成熟

![image-20200529103748790](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529103748790.png)



小结

![image-20200529103903443](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529103903443.png)











#### 方法区(元空间)

栈、堆、方法区的交互关系：

​	运行时数据区结构图

![image-20200529104626406](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529104626406.png)

从线程共享与否的角度来看

![image-20200529104713055](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529104713055.png)

![image-20200529105139796](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529105139796.png)

方法区的理解：

![image-20200529105904943](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529105904943.png)

方法区的基本理解

![image-20200529111338327](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529111338327.png)

方法区的演进

![image-20200529111636364](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529111636364.png)

![image-20200529112112221](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529112112221.png)



![image-20200529112307026](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529112307026.png)



设置方法区的大小与OOM

![image-20200529112706586](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529112706586.png)

![image-20200529114435057](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529114435057.png)

如何解决OOM

![image-20200529115251057](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529115251057.png)

方法区的内部结构

简图

![image-20200529115457468](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529115457468.png)

![image-20200529115548400](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529115548400.png)

![](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529120025306.png)

这个类是由那个加载器加载的什么的

![](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529120123480.png)



![image-20200529120215366](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529120215366.png)

案例：以下正常打印和输出

![image-20200529122133811](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529122133811.png)



全局常量：被static final修饰的

![image-20200529122055105](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529122055105.png)

在类加载的链接的prepare阶段会对static修饰的分配变量进行默认初始化，到加载的链接初始化阶段会赋值

而static final修饰的在准备阶段也就是编译的时候就已经赋值好了

可以理解为当值是确定的时候在编译期就会确定好

 

运行时常量池

![image-20200529123317955](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529123317955.png)

运行时常量池和常量池

![image-20200529124840428](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529124840428.png)

![image-20200529125140072](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529125140072.png)

为什么需要常量池？

![image-20200529125420961](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529125420961.png)

常量池中有什么

![image-20200529132937943](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529132937943.png)

![image-20200529133101278](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529133101278.png)

运行时常量池

![image-20200529133747301](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529133747301.png)

有一个清晰的动画图示

![image-20200529140449347](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529140449347.png)

由于是静态方法所以 0 处没有存this

![image-20200529140540160](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529140540160.png)

![image-20200529140614462](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529140614462.png)

本地变量表相当于数组，而操作数栈是抽象数据结构，可以用数组或者链表实现

![image-20200529140712685](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529140712685.png)

![image-20200529140751558](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529140751558.png)

![image-20200529140826482](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529140826482.png)

![image-20200529140844530](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529140844530.png)

![image-20200529140911384](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529140911384.png)

![image-20200529140959738](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529140959738.png)

![image-20200529141127029](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529141127029.png)

![image-20200529141233591](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529141233591.png)

![image-20200529141154493](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529141154493.png)

![image-20200529141317702](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529141317702.png)

![image-20200529141359926](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529141359926.png)

![image-20200529140312169](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529140312169.png)

![image-20200529141500042](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529141500042.png)



方法区的演进细节

![image-20200529141637577](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529141637577.png)

![image-20200529142350948](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529142350948.png)

![image-20200529142416296](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529142416296.png)

![image-20200529142528969](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529142528969.png)



永久代为什么要被元空间替代？

![image-20200529143603569](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529143603569.png)

![image-20200529143812807](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529143812807.png)

StringTable 为什么要调整？

![image-20200529182031732](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529182031732.png)

静态变量放在哪里？

![image-20200529204018075](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529204018075.png)

![image-20200529215525205](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200529215525205.png)

![image-20200530095436338](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530095436338.png)

方法区的垃圾回收

![image-20200530095823604](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530095823604.png)

![image-20200530100028140](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530100028140.png)

![image-20200530100338247](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530100338247.png)

### 小结

![image-20200530101116564](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530101116564.png)

![image-20200530101321745](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530101321745.png)

![image-20200530101402423](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530101402423.png)



## 4.本地方法接口



什么是本地方法

![image-20200528132209661](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528132209661.png)

![image-20200528132230069](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528132230069.png)

因为本地方法是有方法体的



为什么要使用Native Method?

![image-20200528132437844](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528132437844.png)

![image-20200528133111775](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528133111775.png)

现状

![image-20200528133524591](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200528133524591.png)



## 5.对象的实例化与内存布局与访问定位

![image-20200530104101993](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530104101993.png)

### 对象的实例化

![image-20200530104229211](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530104229211.png)

![image-20200530112733920](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530112733920.png)

对象的实例化过程：

![image-20200530112907985](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530112907985.png)

![image-20200530112929451](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530112929451.png)

![image-20200530112947063](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530112947063.png)

![image-20200530113001721](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530113001721.png)

### 对象的内存布局





![image-20200530113407445](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530113407445.png)

![image-20200530141718051](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530141718051.png)

![image-20200530142010707](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530142010707.png)

![image-20200530142101595](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530142101595.png)

### 对象的访问符



![](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530142315118.png)

![image-20200530142810057](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530142810057.png)



直接指针图示：

![image-20200530142836433](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530142836433.png)

图示一：句柄访问

![image-20200530142931322](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530142931322.png)

## 6.直接内存概述

![image-20200530145020006](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530145020006.png)

![image-20200530145559809](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530145559809.png)

![image-20200530145655553](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530145655553.png)

![image-20200530150354083](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530150354083.png)

![image-20200530151019740](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530151019740.png)

## 7. 执行引擎



### 执行引擎概述

![image-20200530152019586](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530152019586.png)

![image-20200530152624115](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530152624115.png)

![image-20200530153020327](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530153020327.png)

执行引擎的工作过程

![image-20200530153541733](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530153541733.png)

![image-20200530153833071](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530153833071.png)

### Java代码编译和执行过程

![image-20200530153946698](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530153946698.png)

橙色以前就是前端编译器要做的，和虚拟机没关系。蓝色和绿色就是半编译半解释。

![image-20200530154720923](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530154720923.png)

![image-20200530154857401](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530154857401.png)

![image-20200530154609662](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530154609662.png)

### 机器码、指令、汇编语言

![image-20200530155307312](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530155307312.png)

机器码

![image-20200530155452941](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530155452941.png)

![image-20200530155554220](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530155554220.png)

汇编语言

![image-20200530155657444](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530155657444.png)

高级语言

![image-20200530155803312](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530155803312.png)

![image-20200530155928167](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530155928167.png)

![image-20200530160015702](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530160015702.png)

![image-20200530160044365](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200530160044365.png)





### 解释器

![image-20200531104541662](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531104541662.png)

![image-20200531105236854](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531105236854.png)

解释器分类

![image-20200531105423290](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531105423290.png)



### JIT 编译器

Java 代码的执行分类

![image-20200531110809366](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531110809366.png)

![image-20200531110823867](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531110823867.png)

![image-20200531112342728](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531112342728.png)

案例：

![image-20200531112823615](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531112823615.png)



编译器概念：

![image-20200531113137395](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531113137395.png)

热点代码及探测方式

![image-20200531113750921](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531113750921.png)

方法调用计数器

![image-20200531113815203](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531113815203.png)



![image-20200531114834745](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531114834745.png)

![image-20200531114901011](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531114901011.png)

回边计数器

![image-20200531115257211](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531115257211.png)

![image-20200531115343745](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531115343745.png)

HotSpot VM 可以设置程序的执行方式

![image-20200531115937379](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531115937379.png)

可以在命令行改也可以通过在代码里改



HotSpot VM中JIT分类

![image-20200531120525911](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531120525911.png)

注意 64 位操作系统支持server，没法切换

![image-20200531120853049](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531120853049.png)

![image-20200531120943104](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531120943104.png)

## 8.String Table



### String 的基本特性

![image-20200531143753008](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531143753008.png)

![image-20200531143659611](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531143659611.png)

### String 的内存分配

![image-20200531144233650](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531144233650.png)

![image-20200531145046750](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531145046750.png)

![image-20200531145408257](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531145408257.png)



### String 的基本操作

### 字符串拼接操作

![image-20200531204714401](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531204714401.png)

![image-20200531205846486](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531205846486.png)

Jdk5.0之前是StringBuffer 之后是StringBuilder

一定注意只是类似于，虽然你看现面方法好像确实是这么干的

![image-20200531205931009](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531205931009.png)

![image-20200531211704845](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531211704845.png)

结果是：true

![image-20200531211933928](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531211933928.png)

![image-20200531212101552](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531212101552.png)

### intern()

![image-20200531213400214](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531213400214.png)

JDK6 VS JDK7/8

![image-20200531213512510](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531213512510.png)

![image-20200531220125007](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531220125007.png)

![image-20200531220018266](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531220018266.png)

常量池空间记录了堆上拼接产生的 new String("11")，主要是因为 7 /8 将常量池放到堆里面了，所以就会在堆里面找。



![image-20200531213544948](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531213544948.png)

![image-20200531214616817](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531214616817.png)

![image-20200531224717147](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200531224717147.png)



### String Table 的垃圾回收



### G1 中的String去重操作

![image-20200601121000870](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200601121000870.png)

![image-20200601121238780](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200601121238780.png)



































