package cn.nfg.mweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config/dubbo.xml")
public class ManagerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerWebApplication.class, args);
	}
}
