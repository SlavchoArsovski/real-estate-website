package com.si.seminar.realestatewebsite.db.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Provider for a {@link BasicDataSource}.
 */
@Configuration
public class BasicDataSourceProvider {

    @Value("${jdbc.driver}")
    private String driverClassName;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${db.defaultCatalog:}")
    private String defaultCatalog;

    @Value("${db.defaultAutoCommit:true}")
    private boolean defaultAutoCommit;

    @Value("${db.accessToUnderlyingConnectionAllowed:false}")
    private boolean accessToUnderlyingConnectionAllowed;

    @Value("${db.defaultReadOnly:false}")
    private boolean defaultReadOnly;

    @Value("${db.defaultTransactionIsolation:-1}")
    private int defaultTransactionIsolation;

    @Value("${db.pool.initialSize:0}")
    private int initialSize;

    @Value("${db.pool.maxTotal:8}")
    private int maxTotal;

    @Value("${db.pool.minIdle:0}")
    private int minIdle;

    @Value("${db.pool.maxIdle:8}")
    private int maxIdle;

    @Value("${db.pool.maxWaitMillis:10000}")
    private long maxWaitMillis;

    @Value("${db.pool.testOnBorrow:true}")
    private boolean testOnBorrow;

    @Value("${db.pool.testOnReturn:false}")
    private boolean testOnReturn;

    @Value("${db.pool.testWhileIdle:false}")
    private boolean testWhileIdle;

    @Value("${db.pool.timeBetweenEvictionRunsMillis:-1}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${db.pool.validationQuery}")
    private String validationQuery;

    @Value("${db.pool.maxOpenPreparedStatements:-1}")
    private int maxOpenPreparedStatements;

    @Value("${db.pool.minEvictableIdleTimeMillis:1800000}")
    private long minEvictableIdleTimeMillis;

    @Value("${db.pool.numTestsPerEvictionRun:3}")
    private int numTestsPerEvictionRun;

    @Value("${db.pool.poolPreparedStatements:false}")
    private boolean poolPreparedStatements;


    /**
     * @return the data source.
     */
    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDefaultCatalog(defaultCatalog);
        dataSource.setDefaultAutoCommit(defaultAutoCommit);
        dataSource.setAccessToUnderlyingConnectionAllowed(accessToUnderlyingConnectionAllowed);
        dataSource.setDefaultReadOnly(defaultReadOnly);
        dataSource.setDefaultTransactionIsolation(defaultTransactionIsolation);

        dataSource.setInitialSize(initialSize);
        dataSource.setMaxTotal(maxTotal);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxIdle(maxIdle);
        dataSource.setMaxWaitMillis(maxWaitMillis);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        return dataSource;
    }

}
