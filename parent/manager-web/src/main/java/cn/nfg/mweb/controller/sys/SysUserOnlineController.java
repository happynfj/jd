package cn.nfg.mweb.controller.sys;

import cn.nfj.mservice.service.sys.SysUserOnlineService;
import cn.nfj.mservice.entity.SysUserOnline;
import cn.nfj.mservice.util.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/7/18 16:17
 * @Description:
 */
@RestController
@RequestMapping("online")
public class SysUserOnlineController {
    @Reference
    private SysUserOnlineService sysUserOnlineService;

    @RequestMapping("/list")
    public Object list(Integer page, Integer limit){
       return  sysUserOnlineService.list(page,limit);
    }
}
