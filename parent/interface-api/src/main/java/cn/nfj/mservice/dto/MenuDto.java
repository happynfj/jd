package cn.nfj.mservice.dto;

import cn.nfj.mservice.entity.SysMenu;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @Auther: Administrator
 * @Date: 2018/7/12 10:37
 * @Description:
 */
@Getter
@Setter
@ToString
public class MenuDto extends SysMenu implements Serializable {

    private String pName;

    public static MenuDto adapt(SysMenu menu,String pName){
        MenuDto dto = new MenuDto();
        BeanUtils.copyProperties(menu,dto);
        dto.setPName(pName);
        return dto;
    }
}
