package com.example.demo.config;


import com.example.demo.crystobol.entity.ServiceRequest;
import com.example.demo.map.entity.Partner;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "mapEntityManagerFactory", transactionManagerRef = "mapTransactionManager",
        basePackages = {"com.example.demo.map.repository"})
public class MapDatabaseConfiguration
{
    @Primary
    @Bean(name = "mapDataSourceProperties")
    @ConfigurationProperties("map.source")
    public DataSourceProperties mapDataSourceProperties()
    {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "mapDataSource")
    public DataSource mapDataSource()
    {
        return mapDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Primary
    @Bean(name = "mapEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mapEntityManagerFactory(EntityManagerFactoryBuilder entityManagerFactoryBuilder)
    {
        return entityManagerFactoryBuilder.dataSource(mapDataSource())
                .packages(Partner.class)
                .build();
    }

    @Primary
    @Bean(name = "mapTransactionManager")
    public PlatformTransactionManager mapTransactionManager(@Qualifier("mapEntityManagerFactory") EntityManagerFactory mapEntityManagerFactory)
    {
        return new JpaTransactionManager(mapEntityManagerFactory);
    }
}