


# Logger-Library
A logger library for Java applications to generate compact logs 


Use of log statements is a well-known strategy for debugging purpose and has been used widely by developers. 
To understand the class and API usage of a complex application, logs can be generated by adding logs at the beginning and at the
end of the methods to be analyzed. From the sequence of the log statements, a hierarchy of the method invocations can be derived. 
Since the logs generated by this way can be huge, it can take a lot of disk space to store the call stack. 
To mitigate this problem, we came up with the compact log format. 

The logs are divided into two parts, namely method definition and call-trace. The method definition file stores the method signatures and the call-trace file captures the details of the call-trace of the methods invoked.

<Method-Id>|<Class-name>|<Method name>|<Arguments>

Method-Id:   a unique Id assigned to identify the method 
Class-name:  Java class that includes the method
Method-name: name of the method
Arguments: The method arguments stored in JVM-style to further			minimize the file size. Please visit the link 
		https://docs.oracle.com/javase/specs/jvms/se7/html/jvms-		4.html - jvms-4.3.3 for the detailed explanation on the 		format used by JVM to store the method descriptors.

A couple of examples are provided here to demonstrate the format of a definition file.

void android.widget.TextView.setText(char[], int, int)
1|android/widget/TextView|setText|([CII)V

void android.widget.TextView.sendBeforeTextChanged(CharSequence, int, int, int)
2|android/widget/TextView|sendBeforeTextChanged|(Ljava/lang/CharSequence;III)V

<Timestamp>|<Process-Id>|<Thread-Id>|<Event-Type>|<Method-Id>|<[Argument-list]>
Timestamp: 	Epoch timestamp that denotes the number of seconds that 			have 	elapsed since January 1, 1970.
Process-Id: 	unique numeric identifier of the current process.
Thread-id:  	unique numeric identifier of the current thread.
Event-Type: 	It can be Enter, Exit or custom.
Method-Id: 	unique-Id of a method defined in the definition file.
Argument list:  list of the comma separated actual arguments of the method.
			The actual parameters are stored only with the Enter event 			type and they are not present in the Exit event type to			save file size.
An example of the call-trace format is provided below. 


1494277593|396|1|Enter|1|[Hello world!,2,0]
1494277595|396|1|Enter|2|[0,0,16]
1494277599|396|1|Exit|2
1494277604|396|1|Exit|1

The sequence of statements in a call trace file represent the hierarchy of method invocation, for example,
as can be observed from the above call-trace, method 1 with arguments [Hello world!,2,0] calls method 2 with the arguments [0,0,16].

![Alt text](https://cloud.githubusercontent.com/assets/11932888/25868392/61ab7194-34b1-11e7-8935-7ae97d16124a.png "class diagram")

