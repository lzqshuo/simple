package com.gxtiku.simple.mapper;

import java.util.List;
import tk.mybatis.simple.model.SysUser;

public interface UserMapper {

List<SysUser> selectAll();

}
