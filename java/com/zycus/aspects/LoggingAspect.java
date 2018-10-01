package com.zycus.aspects;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.zycus.dto.AuditLog;

@Aspect
@Component
public class LoggingAspect {
	private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
	
	@Before(value = "execution(* com.zycus.services.*.*(..)) and args(logDetails)")
	public void logBeforeSaveingAuditLog(JoinPoint joinPoint, AuditLog logDetails) {
		LOGGER.info("Before saving object of : " + logDetails.getClass() + " in method : " + joinPoint.getSignature());
	}
	
	@AfterReturning(pointcut = "execution(* com.zycus.services.*.*(..)) and args(logDetails)", returning = "returnValue") 
	public void logExceptionAuditLog(JoinPoint joinPoint, AuditLog logDetails, Boolean returnValue) {
		String message;
		
		if(returnValue) {
			message = "After successfully saving object of : " + logDetails.getClass() + " in method : " + joinPoint.getSignature();
		}
		else {
			message = "After catching exception in method " + joinPoint.getSignature() + " in process of saving audit log object : \n"
					  + "{\n"
					  + "message : " + logDetails.getMessage() + "\n" 
					  + "user : " + logDetails.getUser() + "\n"
					  + "account : " + logDetails.getAccount()  + "\n"
					  + "date : " + logDetails.getDate() + "\n"
					  + "}\n";
		}
		LOGGER.debug(message);
	}
	
	@Before(value = "execution(* com.zycus.controllers.AuditController.*(..)) and args(log)")
	public void logBeforeRecieving(JoinPoint joinPoint, AuditLog log) {
		LOGGER.info("Before recieving object of : " + log.getClass() + " in method : " + joinPoint.getSignature());
	}
	
	@After(value = "execution(* com.zycus.controllers.AuditController.*(..)) and args(log)")
	public void logAfterRecieving(JoinPoint joinPoint, AuditLog log) {
		LOGGER.info("After completion of save of object of : " + log.getClass() + " in method : " + joinPoint.getSignature());
	}
}
