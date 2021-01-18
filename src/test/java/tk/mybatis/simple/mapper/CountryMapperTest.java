package tk.mybatis.simple.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import tk.mybatis.simple.mapper.UserMapper;

import tk.mybatis.simple.model.Country;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

public class CountryMapperTest  extends BaseMapperTest{

@Test
public void testSelectAll(){
	SqlSession sqlSession=getSqlSession();
	
	try{
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		 List<SysUser> countryList=userMapper.selectAll();
		 printUserList(countryList);
		
	}finally{
		
		sqlSession.close();
	}
	
}
@Test
public void testSelectAll2(){
	SqlSession sqlSession=getSqlSession();
	
	try{
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		 List<SysUser> countryList=userMapper.selectAll2();
		 printUserList(countryList);
		
	}finally{
		
		sqlSession.close();
	}
	
}
@Test
public void testSelectAllcountry(){
	SqlSession sqlSession=getSqlSession();
	
	try{
		
		 List<Country> countryList=sqlSession.selectList("tk.mybatis.simple.mapper.CountryMapper.selectAll");
		 printCountryList(countryList);
		
	}finally{
		
		sqlSession.close();
	}
	
}
@Test
public void testSelectAllSysrole(){
	SqlSession sqlSession=getSqlSession();
	
	try{
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		 List<SysRole> countryList=userMapper.selectRolesByUserId(1L);
		 printSysRoleList(countryList);
		
	}finally{
		
		sqlSession.close();
	}
	
}
@Test
public void testInsert(){
	SqlSession sqlSession=getSqlSession();
	
	try{
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		 SysUser user=new SysUser();
		 user.setUserName("test1");
		 user.setUserPassword("123456");
		 user.setUserEmail("test@qq.com");
		 user.setUserInfo("test info");
		 user.setHeadImg(new byte[]{1,2,3});
		 user.setCreateTime(new Date());
		 int result=userMapper.insert(user);
		 System.out.println(user.getId());
		
	}finally{
		
		sqlSession.close();
	}
	
}
@Test
public void testInsert2(){
	SqlSession sqlSession=getSqlSession();
	
	try{
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		 SysUser user=new SysUser();
		 user.setUserName("test1");
		 user.setUserPassword("123456");
		 user.setUserEmail("test@qq.com");
		 user.setUserInfo("test info");
		 user.setHeadImg(new byte[]{1,2,3});
		 user.setCreateTime(new Date());
		 int result=userMapper.insert2(user);
		 System.out.println(user.getId());
		
	}finally{
		sqlSession.commit();
		sqlSession.close();
	}
	
}
@Test
public void testInsert3(){
	SqlSession sqlSession=getSqlSession();
	
	try{
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		 SysUser user=new SysUser();
		 user.setUserName("test1");
		 user.setUserPassword("123456");
		 user.setUserEmail("test@qq.com");
		 user.setUserInfo("test info");
		 user.setHeadImg(new byte[]{1,2,3});
		 user.setCreateTime(new Date());
		 int result=userMapper.insert3(user);
		 System.out.println(user.getId());
		
	}finally{
		sqlSession.commit();
		sqlSession.close();
	}
	
}
@Test
public void testUpdate(){
	SqlSession sqlSession=getSqlSession();
	
	try{
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		 SysUser user=userMapper.selectById(1L);
		 System.out.println(user.getUserName());
		 user.setUserName("test1");
		 user.setUserPassword("123456");
		 user.setUserEmail("test@qq.com");
		 user.setUserInfo("test info");
		 user.setHeadImg(new byte[]{1,2,3});
		 user.setCreateTime(new Date());
		 int result=userMapper.updateById(user);
		 System.out.println(user.getId());
		
	}finally{
		sqlSession.rollback();
		sqlSession.close();
	}
	
}
@Test
public void testDelete(){
	SqlSession sqlSession=getSqlSession();
	
	try{
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
		 SysUser user=userMapper.selectById(1L);
		 System.out.println(user);
		 userMapper.deleteById(user);
		 SysUser user2=userMapper.selectById(1L);
		 System.out.println(user2);
		 
		
	}finally{
		sqlSession.rollback();
		sqlSession.close();
	}
	
}
  private void printCountryList(List<Country> countryList ){
	  for(Country country:countryList){
		  System.out.printf("%-4d%4s%4s\n", country.getId(),country.getCountryname(),country.getCountrycode());
	  }
  }
  private void printUserList(List<SysUser> userList ){
	  for(SysUser country:userList){
		  System.out.printf("%-4d%4s%4s\n", country.getId(),country.getUserName(),country.getUserEmail());
	  }
  }
  private void printSysRoleList(List<SysRole> userList ){
	  for(SysRole country:userList){
		  System.out.printf("%-4d%4s%4s\n", country.getId(),country.getRoleName(),country.getUser().getUserName());
	  }
  }
}
