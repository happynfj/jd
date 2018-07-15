package cn.nfj.mservice.mapper;


import cn.nfj.mservice.entity.TbOrder;

import java.util.List;

public interface TbOrderMapper {

    int deleteByPrimaryKey(String orderId);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);


    TbOrder selectByPrimaryKey(String orderId);

  /*  int updateByExampleSelective(@Param("record") TbOrder record, @Param("example") TbOrderExample example);

    int updateByExample(@Param("record") TbOrder record, @Param("example") TbOrderExample example);*/

    int updateByPrimaryKeySelective(TbOrder record);

    int updateByPrimaryKey(TbOrder record);
}