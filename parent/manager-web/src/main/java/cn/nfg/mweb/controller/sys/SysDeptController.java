package cn.nfg.mweb.controller.sys;

import cn.nfj.mservice.service.sys.SysTreeService;
import cn.nfj.mservice.dto.DeptLevelDto;
import cn.nfj.mservice.util.Result;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/6/27 09:55
 * @Description:
 */

@RestController
@RequestMapping("/dept")
public class SysDeptController {
    @Reference
    private SysTreeService sysTreeService;

    @RequestMapping("tree")
    public Object getTree(){
        List<DeptLevelDto> list = sysTreeService.deptTree();
        return Result.Success(list);
    }

    /**
     * 传统方式获得树
     * @return
     */
    @RequestMapping("tree2")
    public Object getTree2(){
        List<DeptLevelDto> list = sysTreeService.deptTree2();
        return Result.Success(list);
    }
}
