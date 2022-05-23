package com.ddoproject.ddo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication  {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		String sql = "INSERT INTO ddo_year(ddo_year_id, ddo_client_id,ddo_org_id,isactive,year,financialyear)VALUES (2018, 18,1000008,'y',2019,2024);";
//
//		int rows = jdbcTemplate.update(sql);
//		if (rows > 0) {
//			System.out.println("A new row has been inserted.");
//		}
//	}
}
