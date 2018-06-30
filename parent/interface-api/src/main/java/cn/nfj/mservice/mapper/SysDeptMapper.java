package cn.nfj.mservice.mapper;



import cn.nfj.mservice.entity.SysDept;


import java.util.List;

public interface SysDeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);

    List<SysDept> getAllDept();

    List<SysDept> getChildDeptListByLevel(String level);

    void batchUpdateLevel(List<SysDept> sysDeptList);

    int countByNameAndParentId(Integer parentId, String name, Integer id);

    int countByParentId(int deptId);
}