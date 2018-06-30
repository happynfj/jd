package cn.nfj.mservice.dto;

import cn.nfj.mservice.entity.TbItemCat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2018/6/29 10:26
 * @Description:
 */
@Setter
@Getter
@ToString
public class ItemCatTreeDto implements Serializable {
    private Long pId;
    private Long id;
    private String name;

    public static ItemCatTreeDto adapt(TbItemCat cat){
        ItemCatTreeDto dto = new ItemCatTreeDto();
       /* BeanUtils.copyProperties(cat,dto);*/
        dto.setPId(cat.getParentId());
        dto.setId(cat.getId());
        dto.setName(cat.getName());
        return dto;
    }
}
