package cn.nfg.mweb.controller;

import cn.nfj.mservice.ItemService;
import cn.nfj.mservice.entity.DataGridResult;
import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/list")
    public Object getItemList(Integer page, Integer limit){
        return  itemService.getItemList(page,limit);
    }

    @RequestMapping("/selectItemById")
    public TbItem selectItemById(String id){
        return itemService.getItemByID(id);
    }
}
