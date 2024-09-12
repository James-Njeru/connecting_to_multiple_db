package com.example.demo.config;


import com.example.demo.crystobol.entity.ServiceRequest;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "crystobolEntityManagerFactory", transactionManagerRef = "crystobolTransactionManager",
        basePackages = {"com.example.demo.crystobol.repository"})
public class CrystobolDatabaseConfiguration
{
    @Bean(name = "crystobolDataSourceProperties")
    @ConfigurationProperties("crystobol.source")
    public DataSourceProperties crystobolDataSourceProperties()
    {
        return new DataSourceProperties();
    }

    @Bean(name = "crystobolDataSource")
    public DataSource crystobolDataSource()
    {
        return crystobolDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "crystobolEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean crystobolEntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder)
    {
        return entityManagerFactoryBuilder.dataSource(crystobolDataSource())
                .packages(ServiceRequest.class)
                .build();
    }

    @Bean(name = "crystobolTransactionManager")
    public PlatformTransactionManager crystobolTransactionManager(@Qualifier("crystobolEntityManagerFactory") EntityManagerFactory crystobolEntityManagerFactory)
    {
        return new JpaTransactionManager(crystobolEntityManagerFactory);
    }
}