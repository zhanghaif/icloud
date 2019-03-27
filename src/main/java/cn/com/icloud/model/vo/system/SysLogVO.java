package cn.com.icloud.model.vo.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SysLogVO {

    private Long id;

    private String module;

    private String action;

    private String exception;

    private Date createDate;

    private Long uid;

    private String ip;

    private SysUserVO user;
    
    
}
