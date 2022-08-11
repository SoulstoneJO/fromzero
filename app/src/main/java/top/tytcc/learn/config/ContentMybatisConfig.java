package top.tytcc.learn.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "top.tytcc.learn.repository.mapper.content", sqlSessionFactoryRef = "contentSessionFactory")
public class ContentMybatisConfig {
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.content")
  public DataSource contentDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  public SqlSessionFactory contentSessionFactory(
      @Qualifier("contentDataSource") DataSource contentDataSource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(contentDataSource);
    sessionFactory.setMapperLocations(
        new PathMatchingResourcePatternResolver()
            .getResources("classpath:top/tytcc/learn/repository/mapper/content/*.xml"));

    return sessionFactory.getObject();
  }
}
