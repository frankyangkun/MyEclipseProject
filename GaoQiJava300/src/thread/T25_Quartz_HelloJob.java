/* 
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved. 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not 
 * use this file except in compliance with the License. You may obtain a copy 
 * of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 * 
 */
 
package thread;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 任务
 * @author yang
 *
 */
public class T25_Quartz_HelloJob implements Job {

//    private static Logger _log = LoggerFactory.getLogger(T25_Quartz_HelloJob.class);

    public T25_Quartz_HelloJob() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
//        _log.info("Hello World! - " + new Date());
    	System.out.println("---------start----------");
    	System.out.println("Hello world!"+ new Date());
    	System.out.println("---------end----------");
    }

}
