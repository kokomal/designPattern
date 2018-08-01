# <font color=green size=5>DesignPattern 设计模式23种经典实现</font>

---

## 简单（静态）工厂模式(Simple Factory Pattern)  
yuanjun.chen.design.simplefatory包下涉及简单工厂模式，CarFactory.java为核心工厂类  
yuanjun.chen.design.simplefatory.CarFactoryTest.java为简单工厂模式的测试类  
静态工厂是最简单的设计模式，factory工厂类核心根据枚举选择相应的实例进行new操作，每添加一个产品类，都需要在工厂进行相应的分支扩展  
静态工厂的创建是静态方法，因此不可能支持工厂的多态  

---

## 工厂方法模式(Factory Method Pattern)  
yuanjun.chen.design.factorymethod包下涉及工厂方法模式，factories包下含各个工厂的接口和实现  
yuanjun.chen.design.fatorymethod.FruitFarmTest.java为工厂方法模式的测试类  
工厂方法相对于简单工厂，其工厂实现了多态化，因此可根据不同的需要实例化不同的产品  
在简单工厂里面的switch case判断，拆散到了各个具体的工厂里面  
工厂方法模式用类膨胀的代价，实现了工厂本身的多态  

---

## 抽象工厂模式(Abstract Factory Pattern)
yuanjun.chen.design.abstractfactory包下涉及工厂方法模式，factories包下含各个工厂的接口和实现  
yuanjun.chen.design.abstractfactory.ElectronicFactoryTest.java为抽象工厂模式的测试类  
抽象工厂相对于工厂方法，其工厂的接口实现了对多种类型产品的支持  
抽象工厂的类更加膨胀

# Cache Pattern 缓存设计模式

---

## CacheAside 缓存更新失效模式  
CacheAside模式是从数据仓库中将数据加载到缓存中，从而提高访问速度的一种模式。  
yuanjun.chen.cache包下涉及CacheAside设计模式  
yuanjun.chen.cache.CacheAsideTest实现缓存更新的正例和反例的测试对比  

---

# Concurrent 设计模式
yuanjun.chen.concurrent包下涉及并发编程的一些设计模式  
Future模式是异步化的经典设计模式，采用jdk经典的wait/notifyAll语法，实现对结果数据获取的"懒加载"  
FuturePatternTest.java实现其测试,模拟了顺丰快递SF和DHL快递异步获得相应包裹的有趣案例   
