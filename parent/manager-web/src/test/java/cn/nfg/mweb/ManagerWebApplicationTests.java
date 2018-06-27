package cn.nfg.mweb;

import cn.nfj.mservice.entity.TbItem;
import cn.nfj.mservice.dto.TbItemDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerWebApplicationTests {

	@Test
	public void contextLoads() {
		TbItem item = new TbItem();
		item.setBarcode("132");
		item.setNum(454);
		System.out.println(item);
		TbItemDto tbItemVo = new TbItemDto();
		BeanUtils.copyProperties(item,tbItemVo);
		System.out.println(tbItemVo.getBarcode());
	}
}
