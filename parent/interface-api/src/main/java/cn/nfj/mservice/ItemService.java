package cn.nfj.mservice;

import cn.nfj.mservice.entity.DataGridResult;
import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.util.Result;

import java.util.HashMap;

/**
 * @Auther: Administrator
 * @Date: 2018/6/25 11:38
 * @Description:
 */
public interface ItemService {
    TbItem getItemByID(String id);

    HashMap getItemList(int page, int rows);

    void itemDel(String id);

    void itemSave(TbItem item);
}
