package cn.com.icloud.model.entity.system;

import lombok.Data;
import java.util.Date;
import javax.persistence.Table;

@Data
@Table(name="icloud_sys_log")
public class SysLog {

    private Long id;

    private String module;

    private String action;

    private String exception;

    private Date createDate;

    private Long uid;

    private String ip;

    private SysUser user;
    
}
