package cn.nfj.mservice.dto;

import cn.nfj.mservice.entity.SysDept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/6/27 10:14
 * @Description:
 */
@Setter
@Getter
@ToString
public class DeptLevelDto extends SysDept implements Serializable {

   private List<DeptLevelDto> children = new ArrayList<>();

   public static DeptLevelDto adapt(SysDept dept){
      DeptLevelDto dto = new DeptLevelDto();
      BeanUtils.copyProperties(dept,dto);
      return dto;
   }
}
