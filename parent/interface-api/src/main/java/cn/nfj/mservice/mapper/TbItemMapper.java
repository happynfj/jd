package cn.nfj.mservice.mapper;


import java.util.List;

import cn.nfj.mservice.entity.TbItem;

public interface TbItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    TbItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    Long selectNewId();

    Integer selectCount();

    /**
     * 条件查询item
     */
    List<TbItem> selectItemByCondition(TbItem item);
}