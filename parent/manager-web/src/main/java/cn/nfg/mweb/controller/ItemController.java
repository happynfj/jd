package cn.nfg.mweb.controller;

import cn.nfj.mservice.ItemService;
import cn.nfj.mservice.dto.TbItemEditDto;
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
    public Object getItemList(Integer page, Integer limit,TbItem item){
        return  itemService.getItemList(page,limit,item);
    }

    @RequestMapping("/getItem")
    public Object selectItemById(String id){
        TbItem item = itemService.getItemByID(id);
        return Result.Success(item);
    }

    @RequestMapping("/del")
    public Object itemDel(String id){
        itemService.itemDel(id);
        return Result.Success();
    }

    @RequestMapping("/save")
    public Object itemSave(ItemSaveParam itemSaveParam){
       // itemService.itemSave(itemSaveParam);
        itemService.itemUpdate(itemSaveParam);
        return Result.Success();
    }

    /**
     * 获取编辑页面值
     */
    @RequestMapping("/getItemEditDto")
    public Object getItemEditDto(String id){
        TbItemEditDto dto = itemService.getItemEditDto(id);
        return Result.Success(dto);
    }

    /**
     * 修改商品
     */
    @RequestMapping("/itemUpdate")
    public Object itemUpdate(TbItemEditDto dto){
        //itemService.itemUpdate(dto);
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
