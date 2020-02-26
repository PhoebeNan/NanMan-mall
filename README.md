##### NanMan-mall
+ 开源商城项目
+ 端口号为：8080
****

##### 枚举的使用
[枚举的使用]<https://blog.csdn.net/newbie_907486852/article/details/81027512?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task>

枚举被设计成是单例模式，即枚举类型会由JVM在加载的时候，实例化枚举对象，你在枚举类中定义了多少个就会实例化多少个，JVM为了保证每一个枚举类元素的唯一实例，是不会允许外部进行new的，所以会把构造函数设计成private，防止用户生成实例，破坏唯一性。
枚举类型是单例模式的。你需要实例化一次，然后再整个程序之中就可以调用他的方法和成员变量了。枚举类型使用单例模式是因为他的值是固定的，不需要发生改变。
****
##### 需要学习的点
+ commentGenerator：自定义注释生成器

+ 使用MybatisGenerator逆向工程时，如果再次生成代码，则只会覆盖三处文件：
实体entity，*example，*mapper。会在*mapper.xml原文件中追加，不会覆盖，删除*mapper.xml文件即可

****
+ 泛型方法，是在调用方法的时候指明泛型的具体类型。

定义泛型方法语法格式如下：
<img src="https://iknow-pic.cdn.bcebos.com/3b292df5e0fe99255a43f44a3fa85edf8db17159?x-bce-process=image/resize,m_lfit,w_600,h_800,limit_1" alt="泛型" />

调用泛型方法语法格式如下：
<img src="https://iknow-pic.cdn.bcebos.com/00e93901213fb80eb0b5fccd3dd12f2eb9389440" alt="泛型" />

说明一下，定义泛型方法时，必须在返回值前边加一个<T>，来声明这是一个泛型方法，持有一个泛型T，然后才可以用泛型T作为方法的返回值。

Class<T>的作用就是指明泛型的具体类型，而Class<T>类型的变量c，可以用来创建泛型类的对象。

为什么要用变量c来创建对象呢？既然是泛型方法，就代表着我们不知道具体的类型是什么，也不知道构造方法如何，因此没有办法去new一个对象，但可以利用变量c的newInstance方法去创建对象，也就是利用反射创建对象。

泛型方法要求的参数是Class<T>类型，而Class.forName()方法的返回值也是Class<T>，因此可以用Class.forName()作为参数。其中，forName()方法中的参数是何种类型，返回的Class<T>就是何种类型。在本例中，forName()方法中传入的是User类的完整路径，因此返回的是Class<User>类型的对象，因此调用泛型方法时，变量c的类型就是Class<User>，因此泛型方法中的泛型T就被指明为User，因此变量obj的类型为User。

当然，泛型方法不是仅仅可以有一个参数Class<T>，可以根据需要添加其他参数。

为什么要使用泛型方法呢？因为泛型类要在实例化的时候就指明类型，如果想换一种类型，不得不重新new一次，可能不够灵活；而泛型方法可以在调用的时候指明类型，更加灵活。

