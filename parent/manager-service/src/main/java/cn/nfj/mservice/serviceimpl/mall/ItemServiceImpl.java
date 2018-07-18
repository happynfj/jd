package cn.nfj.mservice.serviceimpl.mall;

import cn.nfj.mservice.service.mall.ItemService;
import cn.nfj.mservice.dto.TbItemEditDto;
import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.entity.TbItemCat;
import cn.nfj.mservice.entity.TbItemDesc;
import cn.nfj.mservice.dto.TbItemDto;
import cn.nfj.mservice.mapper.TbItemCatMapper;
import cn.nfj.mservice.mapper.TbItemDescMapper;
import cn.nfj.mservice.mapper.TbItemMapper;
import cn.nfj.mservice.param.ItemSaveParam;
import cn.nfj.mservice.util.Result;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/6/25 11:39
 * @Description:
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Autowired
    private TbItemCatMapper itemCatMapper;


    @Override
    public TbItem getItemByID(String id) {
        TbItem tbItem = itemMapper.selectByPrimaryKey(Long.valueOf(id));
        return tbItem;
    }

    @Override
    public HashMap getItemList(int page, int rows,TbItem item) {
        //设置分页信息
        PageHelper.startPage(page, rows);
        //执行查询
        List<TbItem> list = itemMapper.selectItemByCondition(item);
        Integer count = itemMapper.selectCount();
        //格式化时间
        List<TbItemDto> voList = TbItemToVo(list);
        //取分页结果
        PageInfo<TbItemDto> pageInfo = new PageInfo<>(voList);
        return new Result().page(voList, count);
    }

    @Override
    public void itemDel(String id) {
        itemMapper.deleteByPrimaryKey(Long.valueOf(id));
    }

    /**
     * 获取编辑页面值
     */
    @Override
    public TbItemEditDto getItemEditDto(String id) {
        TbItem tbItem = itemMapper.selectByPrimaryKey(Long.valueOf(id));
        TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(tbItem.getCid());
        TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(tbItem.getId());
        TbItemEditDto dto = TbItemEditDto.adapt(tbItem, itemCat, itemDesc);
        return dto;
    }

    /**
     * 商品编辑/增加
     */
    @Override
    public void itemUpdate(ItemSaveParam dto) {
        TbItem item = TbItem.builder().cid(dto.getCid()).num(dto.getNum()).barcode(dto.getBarcode()).price(dto.getPrice())
                .sellPoint(dto.getSellPoint()).title(dto.getTitle()).updated(new Date()).build();
        TbItemDesc itemDesc = TbItemDesc.builder().itemDesc(dto.getItemDesc()).updated(new Date()).build();
        //编辑
        Long id = dto.getId();
        if (id != null) {
            itemDesc.setItemId(dto.getId());
            item.setId(dto.getId());
            itemMapper.updateByPrimaryKey(item);
            itemDescMapper.updateByPrimaryKey(itemDesc);
        //新增
        } else {
            item.setCreated(new Date());
            itemMapper.insertSelective(item);
            //查询最新ID
            Long newId = itemMapper.selectNewId();
            itemDesc.setItemId(newId);
            itemDesc.setCreated(new Date());
            itemDescMapper.insertSelective(itemDesc);
        }
    }

    /**
     * itemList---->voList
     */
    private List<TbItemDto> TbItemToVo(List<TbItem> list) {
        List<TbItemDto> voList = new ArrayList<TbItemDto>();
        for (TbItem item : list) {
            TbItemCat itemCat = itemCatMapper.selectByPrimaryKey(item.getCid());
            voList.add(TbItemDto.adapt(item, itemCat));
        }
        return voList;
    }
}
