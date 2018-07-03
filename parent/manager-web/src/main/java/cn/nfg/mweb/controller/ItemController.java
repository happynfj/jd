package cn.nfg.mweb.controller;

import cn.nfj.mservice.ItemService;
import cn.nfj.mservice.entity.DataGridResult;
import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.param.ItemSaveParam;
import cn.nfj.mservice.util.FilePath;
import cn.nfj.mservice.param.ItemSaveParam;
import cn.nfj.mservice.util.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Reference
    private ItemService itemService;

    @RequestMapping("/list")
    public Object getItemList(Integer page, Integer limit){
        return  itemService.getItemList(page,limit);
    }

    @RequestMapping("/page/{id}")
    public TbItem selectItemById(String id){
        return itemService.getItemByID(id);
    }

    @RequestMapping("/del")
    public Object itemDel(String id){
        itemService.itemDel(id);
        return Result.Success();
    }

    @RequestMapping("/save")
    public Object itemSave(ItemSaveParam itemSaveParam){
        itemService.itemSave(itemSaveParam);
        return Result.Success();
    }

    @RequestMapping("/uploadImg")
    public Object uploadImg(MultipartFile uploadFile){
        Map map =new HashMap<>();
        try {
            String originalFilename = uploadFile.getOriginalFilename();
            //String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String imgdir = FilePath.uploadImgPath();
            File file1 = new File(imgdir);
            if(!file1.exists()){
                file1.mkdir();
            }
            String imgPath = imgdir+originalFilename;
            uploadFile.transferTo(new File(imgPath));
            map.put("error",0);
            map.put("url","/image/"+originalFilename);
        }catch (Exception e){
            e.printStackTrace();
            map.put("error",1);
            map.put("message","上传失败");
        }
        return map;
    }
}
