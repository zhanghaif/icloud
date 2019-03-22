package cn.com.icloud.model.system;

import lombok.Data;

import java.util.List;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Table(name="icloud_sys_permission")
public class PermissionEntity {

	/**
	 * 权限Id
	 */
    private Long id;

    private Long parentId;

    @NotNull(message = "资源名称不能为空")
    private String name;

    /**
     * 权限的代码/通配符,对应代码中@hasAuthority(xx)
     */
    private String code;
    
    /**
     * 对应的资源操作
     */
    private String handle;
    
    @NotNull(message = "资源标识不能为空")
    private String permissionKey;
    
    /**
     * 权限对应的资源
     */
    private String resource;
    
    /**
     * 菜单路径
     */
    private String path;

    private String icon;

    private Boolean enable = false;

    private String description;

    private Integer weight = 0;

    private List<PermissionEntity> children;
   
}
