package com.itool;

import com.itool.exception.LoggerException;
import com.itool.impl.AndroidLogger;
import com.itool.impl.DefaultLogger;
import com.itool.impl.LinuxLogger;

public class LoggerFactory {
	private static Logger logger = null;

	public static Logger getLogger() {
		try{
		if (logger == null) {

			String platform = System.getProperty(Constants.SYS_PROPERTY_OS_NAME);
			if (platform.startsWith(Constants.OS_LINUX) && System.getProperty(Constants.SYS_PROPERTY_VM_NAME).startsWith(Constants.VM_DALVIK)) {
					logger = new AndroidLogger(); 
			} else{
				logger = new LinuxLogger();
			//	logger =  new DefaultLogger();
			}
				/* else if(platform.startsWith("Windows"){ logger = new
				 * WindowsLogger(); return logger; }
				 */
			
		}
		} catch(LoggerException le){
			le.printStackTrace();
		}
		return logger;
	}
}