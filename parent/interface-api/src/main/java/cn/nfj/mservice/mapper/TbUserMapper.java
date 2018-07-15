package cn.nfj.mservice.mapper;


import cn.nfj.mservice.entity.TbUser;

import java.util.List;

public interface TbUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    TbUser getPassword(String username);
}