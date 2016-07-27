package com.petcare.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
interface UserMapper {
	
	UserDTO findAll();
	

}