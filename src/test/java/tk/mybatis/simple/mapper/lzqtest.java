package tk.mybatis.simple.mapper;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.junit.Test;

import test.model.Country;
import test.model.SysUser;
import test.dao.SysUserMapper;

public class lzqtest extends BaseMapperTest{
	@Test
	public void testSelectAll(){
		SqlSession sqlSession=getSqlSession();
		
		try{
			 List<Country> countryList=sqlSession.selectList("test.dao.CountryMapper.selectAll");
			 printCountryList(countryList);
			
		}finally{
			
			sqlSession.close();
		}
		
	}
	@Test
	public void usertestSelectAll(){
		SqlSession sqlSession=getSqlSession();
		
		try{
			SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
			 List<SysUser> countryList=userMapper.selectAll();
			 System.out.println(countryList.get(0).getUserName());
			 
			
		}finally{
			
			sqlSession.close();
		}
		
	}
	
	@Test
	public void testSelectUserAndRoleById(){
		SqlSession sqlSession=getSqlSession();
		
		try{
			SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
			 SysUser user=userMapper.selectUserAndRoleById(1001L);
			 System.out.println(user.getRole().getRoleName());
			 
			
		}finally{
			
			sqlSession.close();
		}
		
	}
	@Test
	public void testSelectUserAndRoleById2(){
		SqlSession sqlSession=getSqlSession();
		
		try{
			SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
			 SysUser user=userMapper.selectUserAndRoleById2(1001L);
			 System.out.println(user.getRole().getRoleName());
			 System.out.println(user.getUserEmail());
			
		}finally{
			
			sqlSession.close();
		}
		
	}
	@Test
	public void testSelectUserAndRoleById3(){
		SqlSession sqlSession=getSqlSession();
		
		try{
			SysUserMapper userMapper=sqlSession.getMapper(SysUserMapper.class);
			 SysUser user=userMapper.selectUserAndRoleById3(1001L);
		     user.equals(null);
			
		}finally{
			
			sqlSession.close();
		}
		
	}

	  private void printCountryList(List<Country> countryList ){
		  for(Country country:countryList){
			  System.out.printf("%-4d%4s%4s\n", country.getId(),country.getCountryname(),country.getCountrycode());
		  }
	  }
}
