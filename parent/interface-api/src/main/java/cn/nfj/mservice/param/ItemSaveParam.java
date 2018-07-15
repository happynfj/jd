package cn.nfj.mservice.param;

import cn.nfj.mservice.entity.TbItem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Auther: Administrator
 * @Date: 2018/7/2 16:32
 * @Description:
 */
@Setter
@Getter
@ToString
public class ItemSaveParam extends TbItem {
    private String itemDesc;
}
