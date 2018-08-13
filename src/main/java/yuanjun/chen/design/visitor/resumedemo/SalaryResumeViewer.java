/**  
 * @Title: HrResumeViewer.java   
 * @Package: yuanjun.chen.design.visitor.resumedemo   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月13日 上午9:07:20   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.visitor.resumedemo;

/**   
 * @ClassName: HrResumeViewer   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月13日 上午9:07:20  
 */
public class SalaryResumeViewer extends Viewer {

    public SalaryResumeViewer(String viewerRole) {
        super(viewerRole);
    }

    @Override
    protected void viewSalary(SalaryResumeBlock salary) {
        System.out.println(viewerRole + "打开薪酬簿子，仔细研究此人的履历和薪酬福利情况");
        System.out.println(viewerRole + "看到了此人年薪" + salary.getIncome());
    }

    @Override
    protected void viewHealth(HealthResumeBlock health) {
        System.out.println(viewerRole + "打开病历卡，只要此人没有传染病，就pass了");
    }

}
