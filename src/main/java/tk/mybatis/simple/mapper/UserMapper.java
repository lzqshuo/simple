package tk.mybatis.simple.mapper;

import java.util.List;

import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {
	
SysUser selectById(Long id);
List<SysUser> selectAll();
List<SysUser> selectAll2();
List<SysRole> selectRolesByUserId(Long userId);
int insert(SysUser sysUser);
int insert2(SysUser sysUser);
int insert3(SysUser sysUser);
int updateById(SysUser sysUser);
int deleteById(SysUser sysUser);
}
