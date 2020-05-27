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



### 类加载的过程

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

### 其他知识点

类加载器的引用：

![image-20200527144009901](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527144009901.png)

类的主动使用和被动使用

![image-20200527144113671](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200527144113671.png)



### 运行时数据区概述及线程

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