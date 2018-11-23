package com.huatong.config.datasource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Create By xzz on 2018/11/22
 */
@Configuration
public class DynamicDataSourceConfig {



    @Bean("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource master() {
        return DataSourceBuilder.create().build();
    }


    @Bean("slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slave() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //设置数据源
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("masterDataSource", master());
        targetDataSources.put("slaveDataSource", slave());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(master());
        return dynamicDataSource;
    }


    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource());
        return bean.getObject();
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate;
    }









}
