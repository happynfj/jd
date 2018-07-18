package cn.nfj.mservice.service.mall;

import cn.nfj.mservice.dto.ItemCatTreeDto;
import cn.nfj.mservice.entity.TbItemCat;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/6/28 18:03
 * @Description:
 */
public interface ItemCatService {
    List<ItemCatTreeDto> getAll();

    void nodeEdit(TbItemCat cat);

    void dalate(long id);
}
