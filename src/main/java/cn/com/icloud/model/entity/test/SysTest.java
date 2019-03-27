package cn.com.icloud.model.entity.test;

import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name="icloud_sys_test")
public class SysTest {
	
	 private Long id;
	 
	 private String name;
	 
	 private Long age;
	 
	 private String address;
}
