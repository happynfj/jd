package cn.nfj.mservice.mapper;

import cn.nfj.mservice.entity.TbOrderItem;

import java.util.List;

public interface TbOrderItemMapper {

    int deleteByPrimaryKey(String id);

    int insert(TbOrderItem record);

    int insertSelective(TbOrderItem record);

    TbOrderItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TbOrderItem record);

    int updateByPrimaryKey(TbOrderItem record);
}