package cn.com.icloud;

import static cn.com.icloud.core.common.ProjectConstant.MAPPER_PACKAGE;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @className: IcloudApplication
 * @description: 启动项
 * @author zhanghaifeng
 * @dateTime 2019年3月15日 17:45:06
 */
@SpringBootApplication
@MapperScan(basePackages = MAPPER_PACKAGE)
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class IcloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(IcloudApplication.class, args);
	}

}
