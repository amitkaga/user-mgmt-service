package com.example.usermgmt.datamapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.usermgmt.dto.UserDTO;
import com.example.usermgmt.entity.UserEntity;

@Component
public class UserMgmtDataMapper {
	
	public List<UserEntity> convertFromDTOsToEntities(List<UserDTO> userDTOs) {
		List<UserEntity> userEntities = new ArrayList<UserEntity>();
		for(UserDTO userDTO : userDTOs) {
			userEntities.add(convertFromDTOToEntiy(userDTO));
		}
		return userEntities;
	}
	
	public List<UserDTO> convertFromEntitiesToDTOs(List<UserEntity> userEntities) {
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for(UserEntity userEntity : userEntities) {
			userDTOs.add(convertFromEntityToDTO(userEntity));
		}
		return userDTOs;
	}

	public UserEntity convertFromDTOToEntiy(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		if(null != userDTO) {
			userEntity.setUserName(userDTO.getUserName());
			userEntity.setUserFullName(userDTO.getUserFullName());
			userEntity.setUserAddress(userDTO.getUserAddress());
			userEntity.setUserAge(userDTO.getUserAge());
		}
		return userEntity;
	}
	
	public UserDTO convertFromEntityToDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		if(null != userEntity) {
			userDTO.setUserId(userEntity.getUserId());
			userDTO.setUserName(userEntity.getUserName());
			userDTO.setUserFullName(userEntity.getUserFullName());
			userDTO.setUserAddress(userEntity.getUserAddress());
			userDTO.setUserAge(userEntity.getUserAge());
		}
		return userDTO;
	}
	
}
