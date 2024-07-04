package com.java.twodb.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = "com.java.twodb.accountdb.Repository",
    entityManagerFactoryRef = "accountEntityManagerFactory",
    transactionManagerRef = "accountTransactionManager"
)
public class AccountConfig {

    @Primary
    @Bean(name = "accountDataSource")
    @ConfigurationProperties(prefix = "spring.accountdb.datasource")
    public DataSource accountdataSource() {
        return DataSourceBuilder.create().build();
    }

    //To handle the accountManagerFactory
    @Primary
    @Bean(name = "accountEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean accountEntityManagerFactory(EntityManagerFactoryBuilder builder,
    @Qualifier("accountDataSource") DataSource accounDataSource){
        return builder
            .dataSource(accounDataSource)
            .packages("com.java.twodb.accountdb.Model")
            .build();      
    }

    @Bean(name = "accountTransactionManager")
    public PlatformTransactionManager accountTransactionManager(@Qualifier("accountEntityManagerFactory") EntityManagerFactory accountEntityManagerFactory){
        return new JpaTransactionManager(accountEntityManagerFactory);
    }
}
