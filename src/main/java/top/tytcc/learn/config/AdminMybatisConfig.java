package top.tytcc.learn.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "top.tytcc.learn.repository.mapper.admin", sqlSessionFactoryRef = "adminSessionFactory")
public class AdminMybatisConfig {
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.admin")
  public DataSource adminDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public SqlSessionFactory adminSessionFactory(
      @Qualifier("adminDataSource") DataSource adminDataSource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(adminDataSource);
    sessionFactory.setMapperLocations(
        new PathMatchingResourcePatternResolver()
            .getResources("classpath:top/tytcc/learn/repository/mapper/admin/*.xml"));

    return sessionFactory.getObject();
  }
}
