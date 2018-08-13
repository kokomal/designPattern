/**
 * @Title: Viewer.java
 * @Package: yuanjun.chen.design.visitor.resumedemo
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午9:05:10
 * @version V1.0
 * @Copyright: 2018 All rights reserved.
 */
package yuanjun.chen.design.visitor.resumedemo;

/**
 * @ClassName: Viewer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 陈元俊
 * @date: 2018年8月13日 上午9:05:10
 */
public abstract class Viewer {

    public Viewer(String viewerRole) {
        this.viewerRole = viewerRole;
    }

    protected String viewerRole;

    public String getViewerRole() {
        return viewerRole;
    }

    public void setViewerRole(String viewerRole) {
        this.viewerRole = viewerRole;
    }

    /**
     * 从view角度进行整体遍历，采用instanceof的方式，略有点别扭，但是这条路是可行的 
     */
    protected void view(Resume resume) {
        System.out.println(viewerRole + "开始检查此人的简历了！");
//        for (ResumeBlock block : resume.getBlocks()) {
//            if (block instanceof SalaryResumeBlock) {
//                viewSalary((SalaryResumeBlock) block);
//            } else if (block instanceof HealthResumeBlock) {
//                viewHealth((HealthResumeBlock) block);
//            } else {
//                System.out.println("此简历无人查看");
//            }
//        }
    }

    protected abstract void viewSalary(SalaryResumeBlock salary);

    protected abstract void viewHealth(HealthResumeBlock health);
}
