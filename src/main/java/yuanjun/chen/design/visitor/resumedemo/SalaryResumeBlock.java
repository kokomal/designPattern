/**  
 * @Title: SalaryResumeBlock.java   
 * @Package: yuanjun.chen.design.visitor.resumedemo   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月13日 上午9:06:05   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.visitor.resumedemo;

/**   
 * @ClassName: SalaryResumeBlock   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月13日 上午9:06:05  
 */
public class SalaryResumeBlock implements ResumeBlock {

    private Double income;
    
    public SalaryResumeBlock(Double income) {
        super();
        this.income = income;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    @Override
    public void accept(Viewer viewer) {
        viewer.viewSalary(this);
    }

}
