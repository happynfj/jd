package cn.nfj.mservice.serviceimpl.sys;

import cn.nfj.mservice.dto.OnlineDto;
import cn.nfj.mservice.dto.TbItemDto;
import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.service.sys.SysUserOnlineService;
import cn.nfj.mservice.entity.SysUserOnline;
import cn.nfj.mservice.mapper.SysUserOnlineMapper;
import cn.nfj.mservice.util.Result;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/7/18 14:30
 * @Description:
 */
@Service
public class SysUserOnlineServiceImpl implements SysUserOnlineService {
    @Autowired
    private SysUserOnlineMapper sysUserOnlineMapper;

    @Override
    public void saveOnline(SysUserOnline online) {
        sysUserOnlineMapper.insertSelective(online);
    }

    @Override
    public Object list(Integer page,Integer rows) {
        PageHelper.startPage(page,rows);
        List<SysUserOnline> onlines  = sysUserOnlineMapper.selectAll();
        Integer count = sysUserOnlineMapper.selectCount();
        List<OnlineDto> onlineDtos = adapt(onlines);
        return new Result().page(onlineDtos, count);
    }

    @Override
    public SysUserOnline selectByPrimaryKey(String sessionid) {
        return  sysUserOnlineMapper.selectByPrimaryKey(sessionid);
    }

    @Override
    public void updateByPrimaryKeySelective(SysUserOnline onlineUP) {
        sysUserOnlineMapper.updateByPrimaryKeySelective(onlineUP);
    }

    @Override
    public void insertSelective(SysUserOnline online) {
        sysUserOnlineMapper.insertSelective(online);
    }

    public List<OnlineDto> adapt(List<SysUserOnline> list){
        List<OnlineDto> onlineDtos = new ArrayList<>();
        for (SysUserOnline online : list){
            onlineDtos.add(OnlineDto.dept(online));
        }
        return onlineDtos;
    }
}
