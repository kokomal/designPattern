/**
 * @Title: ChurchTester.java
 * @Package: yuanjun.chen.design.composite
 * @Description: 组合模式的测试
 * @author: 陈元俊
 * @date: 2018年8月6日 上午11:13:21
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.composite;

import org.junit.Test;

/**
 * @ClassName: ChurchTester
 * @Description: 组合模式的测试
 * @author: 陈元俊
 * @date: 2018年8月6日 上午11:13:21
 */
public class ChurchTester {
    
    @Test
    public void testPray() {
        Church Rome = build();
        Rome.pray();
    }
    
    @Test
    public void testTaxation() {
        Church Rome = build();
        Rome.taxation();
    }
    
    public static Church build() {
        Christian richard = new Believer("Richard the LionHeart");
        Christian edward = new Believer("Long Shank Edward");
        Church westMinster = new Church("WestMinster Abbey");
        westMinster.addOneChristian(richard);
        westMinster.addOneChristian(edward);

        Christian jeanneDarc = new Believer("Jeanne D'arc");
        Christian pepin = new Believer("Pépin le Bref");
        Christian napoleon = new Believer("Napoléon Bonaparte");
        Church notreDame = new Church("Notre Dame de Paris");
        notreDame.addOneChristian(jeanneDarc);
        notreDame.addOneChristian(pepin);
        notreDame.addOneChristian(napoleon);

        Church Vantican = new Church("Vantican");
        Christian pope = new Believer("Pope");
        Vantican.addOneChristian(pope);
        Vantican.addOneChristian(westMinster);
        Vantican.addOneChristian(notreDame);

        return Vantican;
    }

}
