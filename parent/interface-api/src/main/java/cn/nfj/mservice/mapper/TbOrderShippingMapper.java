package cn.nfj.mservice.mapper;


import cn.nfj.mservice.entity.TbOrderShipping;

import java.util.List;

public interface TbOrderShippingMapper {

    int deleteByPrimaryKey(String orderId);

    int insert(TbOrderShipping record);

    int insertSelective(TbOrderShipping record);


    TbOrderShipping selectByPrimaryKey(String orderId);

  /*  int updateByExampleSelective(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingExample example);

    int updateByExample(@Param("record") TbOrderShipping record, @Param("example") TbOrderShippingExample example);*/

    int updateByPrimaryKeySelective(TbOrderShipping record);

    int updateByPrimaryKey(TbOrderShipping record);
}