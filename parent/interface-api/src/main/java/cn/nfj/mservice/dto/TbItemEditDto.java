package cn.nfj.mservice.dto;




import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.entity.TbItemCat;
import cn.nfj.mservice.entity.TbItemDesc;
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
public class TbItemEditDto extends TbItem implements Serializable  {
    private String catName;
    private String itemDesc;

    public static TbItemEditDto adapt(TbItem item, TbItemCat itemCat, TbItemDesc desc){
        TbItemEditDto vo = new TbItemEditDto();
        BeanUtils.copyProperties(item,vo);
        vo.setCatName(itemCat.getName());
        vo.setItemDesc(desc.getItemDesc());
        return vo;
    }
}