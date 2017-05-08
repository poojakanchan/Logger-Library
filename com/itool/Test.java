@Around("(execution(*..*(..)) &&
 			 !within(com.android.internal.os.LoggingPrintStream) && 				 !within(com.android.internal.os.AndroidPrintStream) && 	
			 !within(andoid.os.Process) && 	
			 !within(android.util.Log)")    
  public Object logAspect(final ProceedingJoinPoint pjp) throws Throwable{
       
		
	     System.out.println(android.os.Process.myPid());
		AspectjLog.log(pjp,"Enter",true);
          Object retVal = pjp.proceed();
          AspectjLog.log(pjp,"Exit", false);


pid = Zygote.forkAndSpecialize(parsedArgs.uid, parsedArgs.gid,
                    parsedArgs.gids, parsedArgs.debugFlags, rlimits);
        } catch (IllegalArgumentException ex) {
        logAndPrintError (newStderr, "Invalid zygote arguments", ex);
            pid = -1;
        } catch (ZygoteSecurityException ex) {
            logAndPrintError(newStderr,
                    "Zygote security policy prevents request: ", ex);
            pid = -1;
        }
        if (pid == 0) {
            System.out.println("fork in ZygoteConnection called");
            // in child
            handleChildProc(parsedArgs, descriptors, newStderr);
            // should never happen
            return true;
        } else { /* pid != 0 */
            // in parent...pid of < 0 means failure
            return handleParentProc(pid, descriptors, parsedArgs);
        }


            return retVal;
    }

    private String getLogMessage(ProceedingJoinPoint pjp,String message, boolean printArgumentsFlag){
    	 	char separator = ' ';
	     StringBuilder builder = new StringBuilder();
		 builder.append(android.os.Process.myPid());
		 builder.append(separator);
		 builder.append(pjp.getSignature());
		 builder.append(separator);
		 builder.append(message);
		 builder.append(separator);
		 if (printArgumentsFlag) {
             logBuilder.append("[");
             if (pjp.getArgs().length > 0) {
                     for (final Object argument : pjp.getArgs()) {
                             logBuilder.append(argument + ",");
                     }
                     logBuilder.deleteCharAt(logBuilder.length()-1);
             }
             logBuilder.append("]");
     }
    }
