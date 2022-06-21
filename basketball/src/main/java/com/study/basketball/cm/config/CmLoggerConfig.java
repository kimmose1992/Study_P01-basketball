package com.study.basketball.cm.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @title	: [공통] Log 설정 클래스	  	  
 * @author	: 김모세
 * @create	: 2022.06.21
 */
@Aspect
@Component
public class CmLoggerConfig {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Aspect	 	: 적용 기능
	 * Advice	 	: 적용 기능 구현체
	 * Around 		: Advice 타입, 메소드 호출 제어 가능 
	 * Join Point 	: Advice 적용 위치
	 * PointCut		: JoinPoint 세부 설정 (execution)
	 */
	@Around("execution(* com.study.basketball..web.*Controller.*(..)) or execution(* com.study.basketball..service.impl.*Impl.*(..)) or execution(* com.study.basketball..dao.*DAO.*(..))")
	public Object printLog(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String logName = "";
		String typeName = joinPoint.getSignature().getDeclaringTypeName();
		
		if (typeName.contains("Controller") == true) {
			logName = "[Controller] ";
		}
		else if (typeName.contains("Service") == true) {
			logName = "[Service] ";
		}
		else if (typeName.contains("DAO") == true) {
			logName = "[DAO] ";
		}
		
		logger.debug(logName + typeName + "." + joinPoint.getSignature().getName());
		return joinPoint.proceed();
	}
}
