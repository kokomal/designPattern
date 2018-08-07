# `DesignPattern 设计模式23种经典实现-策略模式`

---

`strategy pattern 状态模式`  
strategy包下
BillingStrategy是一个接口，需要实现具体的接口getActPrice(double price)，并扩展状态的逻辑  
HappyHourStrategy和NormalStrategy分布实现了BillingStrategy接口，即具体的策略实现类  
Customer类相似于Context，内持有一个初始策略实例  
用户需要手动设置相应的策略，然后显示或隐式调用此策略的动作  
策略模式是让用户指定更换的策略算法，而状态模式是状态在满足一定条件下的自动更换，用户无法指定状态，最多只能设置初始状态。   
