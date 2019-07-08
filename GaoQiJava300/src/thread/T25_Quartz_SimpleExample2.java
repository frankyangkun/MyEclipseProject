package thread;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * quartz学习入门
 * @author yang
 *
 */
public class T25_Quartz_SimpleExample2 {

  public void run() throws Exception {
//    Logger log = LoggerFactory.getLogger(T25_Quartz_SimpleExample2.class);
    // 1、创建Scheduler的工厂
    SchedulerFactory sf = new StdSchedulerFactory();
    // 2、从工厂中获取调度器
    Scheduler sched = sf.getScheduler();
    // 3、创建JobDetail
    JobDetail job = newJob(T25_Quartz_HelloJob.class).withIdentity("job1", "group1").build();
    // 时间
//    Date runTime = evenMinuteDate(new Date());//不等1min了，用下面这个，等1s
    Date runTime = evenSecondDateAfterNow();
    // 4、触发器（流模式，通过一直'.'来操作）
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
    // 5、注册任务和触发条件
    sched.scheduleJob(job, trigger);
    // 6、启动
    sched.start();
    try {
      // 5s后停止
      Thread.sleep(5L * 1000L);
    } catch (Exception e) {
    }
    sched.shutdown(true);
  }
  public static void main(String[] args) throws Exception {
    T25_Quartz_SimpleExample2 example = new T25_Quartz_SimpleExample2();
    example.run();
  }
}