package cn.nfj.mservice.dto;




import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.entity.TbItemCat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@ToString
public class TbItemDto extends TbItem implements Serializable  {

    private String createTime;
    private String updateTime;
    private String catName;

    public static TbItemDto adapt(TbItem item, TbItemCat itemCat){
        TbItemDto vo = new TbItemDto();
        BeanUtils.copyProperties(item,vo);
        vo.setCreateTime(dateFormat(vo.getCreated()));
        vo.setUpdateTime(dateFormat(vo.getUpdated()));
        vo.setCatName(itemCat.getName());
        return vo;
    }

    private static String dateFormat(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.format(date);
    }
}