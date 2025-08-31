package com.andyadc.marketing.infrastructure.configuration.persistence;

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
	basePackages = {"com.andyadc.marketing.infrastructure.persistence.seckill"},
	sqlSessionFactoryRef = "seckillSqlSessionFactory"
)
@EnableTransactionManagement(proxyTargetClass = true)
public class SeckillPersistenceConfig {

	@Bean(name = "seckillDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.seckill")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "seckillSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("seckillDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);

		Resource[] mapperResources = new PathMatchingResourcePatternResolver()
			.getResources("classpath:mappings/seckill/*Mapper.xml");
		sqlSessionFactoryBean.setMapperLocations(mapperResources);

		Resource configResource = new PathMatchingResourcePatternResolver()
			.getResource("classpath:mybatis-config.xml");
		sqlSessionFactoryBean.setConfigLocation(configResource);

		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = "seckillTransactionManager")
	public TransactionManager transactionManager(@Qualifier("seckillDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
