package cn.com.icloud.model.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Table(name="icloud_sys_permission")
public class PermissionEntity {

    private Long id;

    private Long parentId;

    @NotNull(message = "资源名称不能为空")
    private String name;

    private String icon;

    @NotNull(message = "资源标识不能为空")
    private String permissionKey;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 资源
     */
    private String resource;

    private Boolean enable = false;

    private String description;

    private Integer weight = 0;

   
}
