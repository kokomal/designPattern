/**
 * @Title: Church.java
 * @Package: yuanjun.chen.design.composite
 * @Description: Church在此表示Composite,属于复合体，可以包含一系列的下属
 * @author: 陈元俊
 * @date: 2018年8月6日 上午11:07:19
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Church
 * @Description: Church在此表示Composite,属于复合体，可以包含一系列的下属
 * @author: 陈元俊
 * @date: 2018年8月6日 上午11:07:19
 */
public class Church extends Christian {

    private List<Christian> christians = new ArrayList<Christian>();

    public Church(String name) {
        super();
        this.name = name;
    }

    public void addOneChristian(Christian christian) {
        this.christians.add(christian);
    }
    
    public void removeOneChristian(Christian christian) {
        this.christians.remove(christian);
    }
    
    public Christian fetchFollowers(int idx) {
        return this.christians.get(idx);
    }
     
    @Override
    public void pray() {
        System.out.println("Church " + name + " begins to pray...");
        for (Christian christian: christians ) {
            christian.pray();
        }
    }


    @Override
    public int taxation() {
        int total = 0;
        System.out.println("Church " + name + " begins to collect taxation...");
        for (Christian christian: christians ) {
            total += christian.taxation();
        }
        System.out.println("Church " + name + " totally collects $" + total);
        return total;
    }

}
