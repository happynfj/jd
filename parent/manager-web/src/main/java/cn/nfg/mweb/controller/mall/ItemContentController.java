package cn.nfg.mweb.controller.mall;

import cn.nfj.mservice.service.mall.ItemContentService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Administrator
 * @Date: 2018/7/9 17:18
 * @Description:
 */
@RestController
public class ItemContentController {
    @Reference
    private ItemContentService itemContentService;

    /**
     * 获取类容树
     */
    @RequestMapping("/contentTree")
    public Object getItemContentTree(){
        return itemContentService.getItemContentTree();
    }

    public Object TreeUpdate(){
        return null;
    }
}
