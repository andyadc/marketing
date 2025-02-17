package com.andyadc.marketing.infrastructure.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan(
	basePackages = {"com.andyadc.marketing.infrastructure.persistence.award"},
	sqlSessionFactoryRef = "primarySqlSessionFactory"
)
@EnableTransactionManagement(proxyTargetClass = true)
public class PrimaryPersistenceConfig {

	@Bean(name = "primaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "primarySqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("primaryDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		Resource[] mapperResources = new PathMatchingResourcePatternResolver()
			.getResources("classpath:mappings/award/*Mapper.xml");
		sqlSessionFactoryBean.setMapperLocations(mapperResources);

		Resource configResource = new PathMatchingResourcePatternResolver()
			.getResource("classpath:mybatis-config.xml");
		sqlSessionFactoryBean.setConfigLocation(configResource);

		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = "primaryTransactionManager")
	public TransactionManager transactionManager(@Qualifier("primaryDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
