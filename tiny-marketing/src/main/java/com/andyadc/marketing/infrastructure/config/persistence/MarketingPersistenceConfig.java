package com.andyadc.marketing.infrastructure.config.persistence;

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
	basePackages = {"com.andyadc.marketing.infrastructure.persistence.marketing"},
	sqlSessionFactoryRef = "marketingSqlSessionFactory"
)
@EnableTransactionManagement(proxyTargetClass = true)
public class MarketingPersistenceConfig {

	@Bean(name = "marketingDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.marketing")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "marketingSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("marketingDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		Resource[] mapperResources = new PathMatchingResourcePatternResolver()
			.getResources("classpath:mappings/marketing/*Mapper.xml");
		sqlSessionFactoryBean.setMapperLocations(mapperResources);

		Resource configResource = new PathMatchingResourcePatternResolver()
			.getResource("classpath:mybatis-config.xml");
		sqlSessionFactoryBean.setConfigLocation(configResource);

		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = "marketingTransactionManager")
	public TransactionManager transactionManager(@Qualifier("marketingDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
