package cn.com.icloud.service.system.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.com.icloud.core.service.AbstractService;
import cn.com.icloud.mapper.system.PermissionMapper;
import cn.com.icloud.model.entity.system.PermissionEntity;
import cn.com.icloud.service.system.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionServiceImpl extends AbstractService<PermissionEntity> implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<PermissionEntity> findAllResourcePermission() {
    	List<PermissionEntity> permissionList = permissionMapper.list();
        return buildPermissionTree(permissionList);
    }
  
    /**
     * 
     * @Title: buildPermissionTree   
     * @Description: 格式化菜单目录树
     * @param: @param permissionList
     * @param: @return      
     * @return: List<PermissionEntity>      
     * @throws
     */
    private List<PermissionEntity> buildPermissionTree(List<PermissionEntity> permissionList) {
    	List<PermissionEntity> nodeTrees = new ArrayList<PermissionEntity>();
        Map<String,PermissionEntity> treeMap = new LinkedHashMap<String,PermissionEntity>();
        for(PermissionEntity node : permissionList){
        	PermissionEntity treeNode = new PermissionEntity();
            treeNode.setId(node.getId());
            treeNode.setCode(node.getCode());
            treeNode.setHandle(node.getHandle());
            treeNode.setName(node.getName());
            treeNode.setParentId(node.getParentId());
            treeNode.setResource(node.getResource());
            treeMap.put(node.getId().toString(), treeNode);
        }
        for(String nodeId : treeMap.keySet()){
        	PermissionEntity treeNode = treeMap.get(nodeId);
            Long pid = treeNode.getParentId();
            if(pid==null  || !treeMap.containsKey(pid.toString())){
                treeNode.setParentId(null);
                nodeTrees.add(treeNode);
            }else{
            	PermissionEntity parentTreeNode = treeMap.get(pid.toString());
                if(parentTreeNode.getChildren()==null){
                    parentTreeNode.setChildren(new ArrayList<PermissionEntity>());
                }
                parentTreeNode.getChildren().add(treeNode);
            }
        }
        return nodeTrees;
    }
}
