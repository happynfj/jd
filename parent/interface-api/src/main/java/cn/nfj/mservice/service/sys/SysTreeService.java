package cn.nfj.mservice.service.sys;

import cn.nfj.mservice.dto.DeptLevelDto;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/6/27 10:25
 * @Description:
 */
public interface SysTreeService {

    List<DeptLevelDto> deptTree();

    List<DeptLevelDto> deptTree2();
}
