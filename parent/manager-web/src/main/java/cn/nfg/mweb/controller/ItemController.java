package cn.nfg.mweb.controller;

import cn.nfg.mservice.entity.DataGridResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ItemController {

    @RequestMapping("/item/list")
    public DataGridResult getItemList(){
        return new DataGridResult();
    }
}
