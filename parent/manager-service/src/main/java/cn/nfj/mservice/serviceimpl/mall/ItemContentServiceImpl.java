package cn.nfj.mservice.serviceimpl.mall;

import cn.nfj.mservice.service.mall.ItemContentService;
import cn.nfj.mservice.dto.ItemContentTreeDto;
import cn.nfj.mservice.entity.TbContentCategory;
import cn.nfj.mservice.mapper.TbContentCategoryMapper;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/7/9 17:25
 * @Description:
 */
class ItemContentServiceImpl implements ItemContentService {

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;

    @Override
    public List getItemContentTree() {
        List<TbContentCategory> categoryList= tbContentCategoryMapper.listAll();
        ArrayList<Object> dtoList = Lists.newArrayList();
        if(CollectionUtils.isNotEmpty(categoryList)){
            for (TbContentCategory cat : categoryList) {
                dtoList.add(ItemContentTreeDto.adapt(cat));
            }
        }
        return dtoList;
    }
}
