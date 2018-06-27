package cn.nfj.mservice.serviceimpl;

import cn.nfj.mservice.ItemService;
import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.entity.TbItemExample;
import cn.nfj.mservice.dto.TbItemDto;
import cn.nfj.mservice.mapper.TbItemMapper;
import cn.nfj.mservice.util.Result;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
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
        //格式化时间
        List<TbItemDto> voList = TbItemToVo(list);
        //取分页结果
        PageInfo<TbItemDto> pageInfo = new PageInfo<>(voList);
        //取总记录数
        long count = pageInfo.getTotal();
        return new Result().page(voList, count);
    }

    @Override
    public void itemDel(String id) {
        itemMapper.deleteByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public void itemSave(TbItem item) {

    }

    /**
     * itemList---->voList
     */
    private List<TbItemDto> TbItemToVo(List<TbItem> list) {
        List<TbItemDto> voList = new ArrayList<TbItemDto>();
        for (TbItem item : list) {
            voList.add(TbItemDto.adapt(item));
        }
        return voList;
    }
}
