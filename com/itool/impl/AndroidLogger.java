package com.itool.impl;

import com.itool.Logger;
import com.itool.exception.LoggerException;

public class AndroidLogger extends Logger{
    
 	public AndroidLogger() throws LoggerException {
		super();
	}

	protected String getFilePath() throws LoggerException{
		if (!android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
			throw new LoggerException("No SDCard found");
			
		}
		return android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
            
    }
        
	protected String getProcessId(){
          return String.valueOf(android.os.Process.myPid());          
      }
	protected String getThreadId(){
        return  String.valueOf(android.os.Process.getThreadPriority(android.os.Process.myTid()));
    }
}
  