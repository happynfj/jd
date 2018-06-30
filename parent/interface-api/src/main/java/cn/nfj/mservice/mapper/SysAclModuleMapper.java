package cn.nfj.mservice.mapper;

import cn.nfj.mservice.entity.SysAclModule;
import cn.nfj.mservice.entity.SysAclModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAclModuleMapper {
    int countByExample(SysAclModuleExample example);

    int deleteByExample(SysAclModuleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysAclModule record);

    int insertSelective(SysAclModule record);

    List<SysAclModule> selectByExample(SysAclModuleExample example);

    SysAclModule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysAclModule record, @Param("example") SysAclModuleExample example);

    int updateByExample(@Param("record") SysAclModule record, @Param("example") SysAclModuleExample example);

    int updateByPrimaryKeySelective(SysAclModule record);

    int updateByPrimaryKey(SysAclModule record);
}