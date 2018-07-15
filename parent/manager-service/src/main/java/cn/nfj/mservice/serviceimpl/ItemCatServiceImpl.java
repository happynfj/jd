package cn.nfj.mservice.serviceimpl;

import cn.nfj.mservice.ItemCatService;
import cn.nfj.mservice.dto.ItemCatTreeDto;
import cn.nfj.mservice.entity.TbItemCat;
import cn.nfj.mservice.mapper.TbItemCatMapper;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/6/28 18:04
 * @Description:
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<ItemCatTreeDto> getAll() {
        List<TbItemCat> catList = tbItemCatMapper.getAll();
        ArrayList<ItemCatTreeDto> dtoList = Lists.newArrayList();
        //装载到dto
        if(CollectionUtils.isNotEmpty(catList)){
            for (TbItemCat cat : catList){
                dtoList.add(ItemCatTreeDto.adapt(cat));
            }
        }
        return dtoList;
    }

    @Override
    public void nodeEdit(TbItemCat cat) {
        //修改
        if(cat.getId() != null){
            cat.setUpdated(new Date());
            tbItemCatMapper.updateByPrimaryKey(cat);
        }else {
            cat.setCreated(new Date());
            cat.setUpdated(new Date());
            tbItemCatMapper.insertSelective(cat);
        }
    }

    @Override
    public void dalate(long id) {
        tbItemCatMapper.deleteByPrimaryKey(id);
    }
}
