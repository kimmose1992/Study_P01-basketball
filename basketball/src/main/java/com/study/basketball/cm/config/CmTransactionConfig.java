package com.study.basketball.cm.config;

import java.util.Collections;
import java.util.List;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * @title	: [공통] Transaction 설정 클래스	  	  
 * @author	: 김모세
 * @create	: 2022.06.21
 */
@Configuration
public class CmTransactionConfig {

	@Autowired
	private TransactionManager transactionManager;
	
	private static final String AOP_TRANSACTION_NAME = "*";
	private static final String AOP_TRANSACTION_EXPRESSION = "execution(* com.study.basketball..service.impl.*Impl.*(..))";

	/**
	 * RollbackRuleAttribute					: 트랜잭션 롤백 수행 규칙
	 * RuleBasedTransactionAttribute			: 트랜잭션 롤백 수행 규칙 적용 및 수행여부 판단 
	 * MatchAlwaysTransactionAttributeSource 	: 모든 메소드에서 항상 동일한 TransactionAttribute를 반환하도록 설정
	 * 
	 * Transaction AOP 설정 시, 트랜잭션 발생 메소드에 try ~ catch 사용 금지 > catch 문에서 Exception을 잡으면 롤백 수행 불가
	 */
	@Bean
	public TransactionInterceptor transactionAdvice() {
		List<RollbackRuleAttribute> rollbackRules = Collections.singletonList(new RollbackRuleAttribute(Exception.class));
		
		RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
		transactionAttribute.setRollbackRules(rollbackRules);
		transactionAttribute.setName(AOP_TRANSACTION_NAME);
		
		MatchAlwaysTransactionAttributeSource transactionAttributeSource = new MatchAlwaysTransactionAttributeSource();
		transactionAttributeSource.setTransactionAttribute(transactionAttribute);
		
		return new TransactionInterceptor(transactionManager, transactionAttributeSource);
	}
	
	@Bean
	public Advisor transactionAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(AOP_TRANSACTION_EXPRESSION);
		
		return new DefaultPointcutAdvisor(pointcut, transactionAdvice());
	}
}
