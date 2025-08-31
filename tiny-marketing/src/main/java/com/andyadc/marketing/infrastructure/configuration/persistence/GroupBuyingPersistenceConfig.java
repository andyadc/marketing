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
	basePackages = {"com.andyadc.marketing.infrastructure.persistence.group"},
	sqlSessionFactoryRef = "groupbuyingSqlSessionFactory"
)
@EnableTransactionManagement(proxyTargetClass = true)
public class GroupBuyingPersistenceConfig {

	@Bean(name = "groupbuyingDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.groupbuying")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "groupbuyingSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("groupbuyingDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);

		Resource[] mapperResources = new PathMatchingResourcePatternResolver()
			.getResources("classpath:mappings/group/*Mapper.xml");
		sqlSessionFactoryBean.setMapperLocations(mapperResources);

		return sqlSessionFactoryBean.getObject();
	}

	@Bean(name = "groupbuyingTransactionManager")
	public TransactionManager transactionManager(@Qualifier("groupbuyingDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
