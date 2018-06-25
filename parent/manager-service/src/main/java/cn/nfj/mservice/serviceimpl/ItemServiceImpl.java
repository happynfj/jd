package cn.nfj.mservice.serviceimpl;

import cn.nfj.mservice.ItemService;
import cn.nfj.mservice.entity.DataGridResult;
import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.entity.TbItemExample;
import cn.nfj.mservice.mapper.TbItemMapper;
import cn.nfj.mservice.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/6/25 11:39
 * @Description:
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    TbItemMapper itemMapper;

    @Override
    public TbItem getItemByID(String id) {
        TbItem tbItem = itemMapper.selectByPrimaryKey(Long.valueOf(id));
         return tbItem;
    }

    @Override
    public HashMap getItemList(int page, int rows) {
        //设置分页信息
        PageHelper.startPage(page, rows);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> list = itemMapper.selectByExample(example);
        //创建一个返回值对象
        //取分页结果
        PageInfo<TbItem> pageInfo = new PageInfo<>(list);
        //取总记录数
        long count = pageInfo.getTotal();
        return new Result().layuiPage(list,count);
    }
}
