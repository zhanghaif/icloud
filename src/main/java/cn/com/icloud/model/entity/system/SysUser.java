package cn.com.icloud.model.entity.system;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
@Table(name="icloud_sys_user")
public class SysUser {

	/**
     * 用户Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    @Size(min = 3, message = "用户名长度不能小于3")
    private String account;
    
    /**
     * 姓名
     */
    @NotEmpty(message = "姓名不能为空")
    @Size(min = 2, message = "姓名长度不能小于2")
    private String username;

    /**
     * 密码
     */
    @JSONField(serialize = false)
    @NotEmpty(message = "密码不能为空")
    @Size(min = 6, message = "密码长度不能小于6")
    private String password;
    
    @NotNull
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号码格式错误")
    private String tel;

    private String avatar;

	/* private Boolean enable = false; */
    
    private List<SysRole> roles;
    
    /**
     * 用户的角色Id
     */
    @Transient
    private Long roleId;

    /**
     * 用户的角色名
     */
    @Transient
    private String roleName;
    
    /**
     * 用户的角色名key
     */
    @Transient
    private String roleKey;

    /**
     * 用户的角色对应的权限key
     */
    @Transient
    private List<String> permissionCodeList;
}
