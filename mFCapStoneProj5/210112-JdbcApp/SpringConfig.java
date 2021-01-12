package com.cp5;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class SpringConfig {
	
	private static final HikariConfig config = new HikariConfig("/datasource.properties");
	
	
	@Bean
	public VehicleDao vehicleDao() {
		
//		return new JdbcVehicleDao(hikariDataSource());
		return new JDBCTemplateDao(hikariDataSource());
	}

	private DataSource dataSource() {
		DriverManagerDataSource dmDS = new DriverManagerDataSource();
		dmDS.setDriverClassName("oracle.jdbc.OracleDriver");
		dmDS.setUrl("jdbc:oracle:thin:@//localhost:1521/orcl");
		dmDS.setUsername("hr");
		dmDS.setPassword("oracle");
		return dmDS;
	}
	
	@Bean
	public DataSource hikariDataSource() {

//		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setUsername("hr");
//		dataSource.setPassword("oracle");
//		dataSource.setJdbcUrl("jdbc:oracle:thin:@//localhost:1521/orcl");
//		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//		dataSource.setMinimumIdle(2);
//		dataSource.setMaximumPoolSize(5);
//		return dataSource;
		
		HikariDataSource dataSource = new HikariDataSource(config);
		return dataSource;
	}
	
}
