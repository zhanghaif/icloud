package cn.com.icloud.model.vo.system;

import java.util.List;

import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.alibaba.fastjson.annotation.JSONField;

import cn.com.icloud.core.common.Resource;
import lombok.Data;

@Data
@Table(name="icloud_sys_role")
public class RoleVO {

    private Long id;

    @NotNull(message = "角色名称不能为空")
    private String roleName;

    @NotNull(message = "角色标识不能为空")
    private String roleKey;

    private Boolean enable = false;

    @Length(max = 256, message = "描述过长")
    private String description;


    /**
     * 角色对应的权限
     */
    @Transient
    private List<Resource> resourceList;


    /**
     * 角色对应的权限Id
     */
    @JSONField(serialize = false)
    @Transient
    private List<Integer> permissionIdList;
}
