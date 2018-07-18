package cn.nfj.mservice.serviceimpl.sys;

import cn.nfj.mservice.service.sys.SysTreeService;
import cn.nfj.mservice.dto.DeptLevelDto;
import cn.nfj.mservice.entity.SysDept;
import cn.nfj.mservice.mapper.SysDeptMapper;
import cn.nfj.mservice.util.LevelUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.*;

/**
 * @Auther: Administrator
 * @Date: 2018/6/27 10:26
 * @Description:
 */
@Service
public class SysTreeServiceImpl implements SysTreeService {

    @Autowired
    private SysDeptMapper sysDeptMapper;

    /**
     * DeptList---->dtoList
     */
    @Override
    public List<DeptLevelDto> deptTree() {
        List<SysDept> deptList = sysDeptMapper.getAllDept();
        List<DeptLevelDto> dtoList = new ArrayList<>();
        for (SysDept dept : deptList) {
            DeptLevelDto dto = DeptLevelDto.adapt(dept);
            dtoList.add(dto);
        }
        return debtToTree(dtoList);
    }


    /**
     * 返回rootList
     */
    public List<DeptLevelDto> debtToTree(List<DeptLevelDto> dtoList) {
        if (CollectionUtils.isEmpty(dtoList)) {
            return Lists.newArrayList();
        }
        Multimap<String, DeptLevelDto> dtoLevelMap = ArrayListMultimap.create();
        List<DeptLevelDto> rootList = Lists.newArrayList();
        for (DeptLevelDto dto : dtoList) {
            dtoLevelMap.put(dto.getLevel(), dto);
            if (dto.getParentId() == 0) {
                rootList.add(dto);
            }
        }
        //rootList排序
        Collections.sort(rootList, new Comparator<DeptLevelDto>() {
            @Override
            public int compare(DeptLevelDto o1, DeptLevelDto o2) {
                return o1.getSeq() - o2.getSeq();
            }
        });
        transformDeptTree(rootList, "0", dtoLevelMap);
        return rootList;
    }

    /**
     * 递归生成树
     */
    public void transformDeptTree(List<DeptLevelDto> rootList, String level, Multimap<String, DeptLevelDto> dtoMap) {
        for (int i = 0; i < rootList.size(); i++) {
            DeptLevelDto dto = rootList.get(i);
            String nextLevel = LevelUtil.calculateLevel(level, dto.getId());
            List<DeptLevelDto> nextList = (List<DeptLevelDto>) dtoMap.get(nextLevel);
            //下级排序
            if(CollectionUtils.isNotEmpty(nextList)){
                Collections.sort(nextList, new Comparator<DeptLevelDto>() {
                    @Override
                    public int compare(DeptLevelDto o1, DeptLevelDto o2) {
                        return o1.getSeq() - o2.getSeq();
                    }
                });
                dto.setChildren(nextList);
                transformDeptTree(nextList,nextLevel,dtoMap);
            }
        }
    }

    @Override
    public List<DeptLevelDto> deptTree2() {
        List<SysDept> deptList = sysDeptMapper.getAllDept();
        ArrayList<DeptLevelDto> dtoList = Lists.newArrayList();
        for(SysDept dept : deptList){
            dtoList.add(DeptLevelDto.adapt(dept));
        }
        return debtToTree2(dtoList);
    }

    private List<DeptLevelDto> debtToTree2(ArrayList<DeptLevelDto> dtoList) {
        ArrayList<DeptLevelDto> rootList = Lists.newArrayList();
        for (DeptLevelDto dto :dtoList){
            if(dto.getParentId()==0){
                rootList.add(dto);
            }
        }
        transformDeptTree2(rootList,dtoList);
        return rootList;
    }

    /**
     * 找出当前rootList中所有节点的下层节点排好序，然后加入到rootList节点中
     */
    private void transformDeptTree2(ArrayList<DeptLevelDto> rootList, ArrayList<DeptLevelDto> dtoList) {
        for(DeptLevelDto dto : rootList){
            ArrayList<DeptLevelDto> childrenList = Lists.newArrayList();
            for (DeptLevelDto dtoAll : dtoList){
                if(dtoAll.getParentId() .equals(dto.getId())){
                    childrenList.add(dtoAll);
                }
            }
            if(CollectionUtils.isNotEmpty(childrenList)){
                Collections.sort(childrenList,deptSeqComparator);
                dto.setChildren(childrenList);
                transformDeptTree2(childrenList,dtoList);
            }
        }
    }

    /**
     * 实现Comparator接口的子类匿名对象
     */
    public Comparator<DeptLevelDto> deptSeqComparator = new Comparator<DeptLevelDto>() {
        @Override
        public int compare(DeptLevelDto o1, DeptLevelDto o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };
}
