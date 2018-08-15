# `DesignPattern 设计模式23种经典实现-解释器模式`

---

`interpreter pattern 解释器模式`
TerminalExpression和具体Expression均实现了Expression的接口，实现对上下文context的interpret
easy包下参考菜鸟教程的解释器示例，实现对表达式的运算规则计算，其中，AndExpression传入2个表达式实现二元与运算  
OrExpression实现或运算，可以对表达式进行嵌套    
wiki包下参考wikipedia的解释器示例，对转换好的逆波兰算子进行表达式运算  
通过将变量的上下文传入，实现Variable的interpret的数值替换，这是此算法的关键所在  
进行简单的改进，支持常量和负数常量  
wiki.enhance包更进一步，废除Nubmer类，将上下文简化为数值Map，避免略显臃肿的Number的interpret设计  