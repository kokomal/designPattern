/**  
 * @Title: CloneDemo.java   
 * @Package: yuanjun.chen.design.prototype.classic   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月20日 下午4:09:48   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.prototype;

/**   
 * @ClassName: CloneDemo   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月20日 下午4:09:48  
 */
public class CloneDemo {
    public static void main(String[] args) throws Exception {
        ShallowMan cc1 = new ShallowMan();
        Purse purse1 = generateWiliamsPurse();
        cc1.setPurse(purse1);
        cc1.setAge(11);
        cc1.setName("william");
        
        ShallowMan cc2 = (ShallowMan) cc1.clone();
        System.out.println(cc2);
        
        System.out.println("公何故变心");
        
        cc1.setAge(46);
        cc1.setName("harris");
        purse1.setOwner("Delores"); // purse1变了，由于浅拷贝，shallowMan的purse必然变了
        System.out.println(cc2);
        
        System.out.println("----------------------------");
        
        DeepMan cc22 = new DeepMan();
        Purse purse2 = generateWiliamsPurse();
        cc22.setPurse(purse2);
        cc22.setAge(17);
        cc22.setName("william");
        
        DeepMan cc23 = (DeepMan) cc22.clone(); // 深拷贝
        System.out.println(cc22);
        System.out.println(cc23);
        System.out.println("公何故变心");
        
        cc22.setAge(33);
        cc22.setName("harris");
        purse2.setOwner("Delores");
        System.out.println(cc22);
        System.out.println(cc23); // 深拷贝仍然保留旧数据，不会随着对原始数据的修改，而改变
    }

    private static Purse generateWiliamsPurse() {
        Purse purse = new Purse();
        purse.setMoney(33);
        purse.setOwner("William");
        return purse;
    }
}
