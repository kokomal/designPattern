/**  
 * @Title: VisitorDemo.java   
 * @Package: yuanjun.chen.design.visitor.resumedemo   
 * @Description: TODO(用一句话描述该文件做什么)   
 * @author: 陈元俊     
 * @date: 2018年8月13日 上午9:25:37   
 * @version V1.0 
 * @Copyright: 2018 All rights reserved. 
 */
package yuanjun.chen.design.visitor.resumedemo;

/**   
 * @ClassName: VisitorDemo   
 * @Description: TODO(这里用一句话描述这个类的作用)   
 * @author: 陈元俊 
 * @date: 2018年8月13日 上午9:25:37  
 */
public class VisitorDemo {
    
    public static void main(String[] args) {
        Resume rsm = new Resume(); // Resume里面封装了各个部件细节
        rsm.init(); // 初始化
        Viewer hr = new SalaryResumeViewer("HR-马化腾");
        Viewer doctor = new HealthResumeViewer("DOCTOR-白求恩");
        rsm.accept(hr);
        System.out.println("---------------------");
        rsm.accept(doctor);
        System.out.println("---------------------");
        
        hr.view(rsm); // 这个只是一个壳子
        doctor.view(rsm); // 同上
    }
    
}
