# designPattern
设计模式23种经典实现
---

## 简单（静态）工厂模式(Simple Factory Pattern)  
yuanjun.chen.design.simplefatory包下涉及简单工厂模式，CarFactory.java为核心工厂类  
yuanjun.chen.design.simplefatory.CarFactoryTest.java为简单工厂模式的测试类  
静态工厂是最简单的设计模式，factory工厂类核心根据枚举选择相应的实例进行new操作，每添加一个产品类，都需要在工厂进行相应的分支扩展  
静态工厂的创建是静态方法，因此不可能支持工厂的多态  

## 工厂方法模式(Factory Method Pattern)  
yuanjun.chen.design.factorymethod包下涉及工厂方法模式，factories包下含各个工厂的接口和实现  
yuanjun.chen.design.fatorymethod.FruitFarmTest.java为工厂方法模式的测试类  
工厂方法相对于简单工厂，其工厂实现了多态化，因此可根据不同的需要实例化不同的产品  
在简单工厂里面的switch case判断，拆散到了各个具体的工厂里面  
工厂方法模式用类膨胀的代价，实现了工厂本身的多态  

