package com.huatong.config.datasource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Create By xzz on 2018/11/22
 */
@Configuration
@MapperScan(basePackages = "com.huatong.mapper", sqlSessionFactoryRef = "sqlSessionFactory",sqlSessionTemplateRef = "sqlSessionTemplate")
public class DynamicDataSourceConfig {


    @Primary
    @Bean("master")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource master() {
        return DataSourceBuilder.create().build();
    }


    @Bean("slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slave() {
        return DataSourceBuilder.create().build();
    }


    @Bean("slave02")
    @ConfigurationProperties(prefix = "spring.datasource.slave02")
    public DataSource slave02() {
        return DataSourceBuilder.create().build();
    }


    @Bean("dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //设置数据源
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("master", master());
        targetDataSources.put("slave", slave());
        targetDataSources.put("slave02", slave02());
        dynamicDataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(slave());
        return dynamicDataSource;
    }


    @Primary
    @Bean("sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath*:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
