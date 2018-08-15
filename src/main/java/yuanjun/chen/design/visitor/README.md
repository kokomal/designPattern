# `DesignPattern 设计模式23种经典实现-访问者模式`

---

`visitor pattern 访问者模式`
作为23种设计模式里面最复杂的模式，其实现了数据提供者（Element），和数据消费者（Visitor）以及数据聚合者（ObjectStructure）三者之间的关系  
visitor.wikidemo包下实现了维基百科里面提到的Car相关访问者的范例  
Body,Engine,Wheel都是CarElement的实例，都可以接待访问者  
Car作为ObjectStructure对象聚合体，也是CarElement的实例，但其中聚合了所有零部件    
CarElementVisitor接口是访问各个部件的接口，前提是部件的范围和规模基本确定，才能固定各个部件的访问  
各个具体的访问者，根据访问者的身份和对数据的不同需求，实现对数据的不同操作（例如同样一份员工简历，HR访问者关心的是其薪酬，医生访问者关心的是其健康状况等 ）   
各个部件的accept其实并不一定要实现访问细节，具体访问细节放到访问者里面，因此各个数据提供者的accept，触发各个部件具体的访问，各个访问者访问部件的细节，不一定由数据提供者掌控      
visitor.resumedemo包下实现了某简历相关访问者的范例  