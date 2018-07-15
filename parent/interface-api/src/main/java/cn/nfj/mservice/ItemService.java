package cn.nfj.mservice;

import cn.nfj.mservice.dto.TbItemEditDto;
import cn.nfj.mservice.entity.DataGridResult;
import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.param.ItemSaveParam;
import cn.nfj.mservice.util.Result;

import java.util.HashMap;

/**
 * @Auther: Administrator
 * @Date: 2018/6/25 11:38
 * @Description:
 */
public interface ItemService {
    TbItem getItemByID(String id);

    HashMap getItemList(int page, int rows,TbItem item);

    void itemDel(String id);

    TbItemEditDto getItemEditDto(String id);

    void itemUpdate(ItemSaveParam dto);
}
