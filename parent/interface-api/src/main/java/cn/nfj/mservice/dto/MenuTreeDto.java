package cn.nfj.mservice.dto;

import cn.nfj.mservice.entity.SysMenu;
import cn.nfj.mservice.entity.TbItemCat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2018/7/12 10:37
 * @Description:
 */
@Getter
@Setter
@ToString
public class MenuTreeDto implements Serializable {
    private Integer pId;
    private Integer id;
    private String name;

    public static MenuTreeDto adapt(SysMenu menu){
        MenuTreeDto dto = new MenuTreeDto();
        /* BeanUtils.copyProperties(cat,dto);*/
        dto.setPId(menu.getParentId());
        dto.setId(menu.getMenuId());
        dto.setName(menu.getMenuName());
        return dto;
    }
}
