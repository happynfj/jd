package cn.nfj.mservice.mapper;

import cn.nfj.mservice.entity.SysAcl;
import cn.nfj.mservice.entity.SysAclExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAclMapper {
    int countByExample(SysAclExample example);

    int deleteByExample(SysAclExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysAcl record);

    int insertSelective(SysAcl record);

    List<SysAcl> selectByExample(SysAclExample example);

    SysAcl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysAcl record, @Param("example") SysAclExample example);

    int updateByExample(@Param("record") SysAcl record, @Param("example") SysAclExample example);

    int updateByPrimaryKeySelective(SysAcl record);

    int updateByPrimaryKey(SysAcl record);
}