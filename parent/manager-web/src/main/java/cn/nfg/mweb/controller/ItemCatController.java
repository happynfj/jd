package cn.nfg.mweb.controller;

import cn.nfj.mservice.ItemCatService;
import cn.nfj.mservice.dto.ItemCatTreeDto;
import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.entity.TbItemCat;
import cn.nfj.mservice.util.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2018/6/28 18:02
 * @Description:
 */
@RestController
public class ItemCatController {

    @Reference
    private ItemCatService itemCatService;

    /**
     * 获取catTree
     */
    @RequestMapping("itemCat/all")
    public Object getAll(){
        List<ItemCatTreeDto> catList = itemCatService.getAll();
        return Result.Success(catList);
    }

    /**
     * 编辑节点
     */
    @RequestMapping("itemCat/reName")
    public Object nodeEdit(TbItemCat cat){
        itemCatService.nodeEdit(cat);
        return Result.Success();
    }

    /**
     * 删除节点
     */
    @RequestMapping("itemCat/dalate")
    public Object delate(long id){
        itemCatService.dalate(id);
        return Result.Success();
    }
}
