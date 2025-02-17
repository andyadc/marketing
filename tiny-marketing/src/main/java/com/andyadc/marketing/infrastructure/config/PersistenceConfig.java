//package com.andyadc.marketing.infrastructure.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.TransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement(proxyTargetClass = true)
//public class PersistenceConfig {
//
//	@Bean
//	public TransactionManager transactionManager(HikariDataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}
//
//}
