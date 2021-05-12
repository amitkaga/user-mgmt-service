package com.example.usermgmt.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usermgmt.datamapper.UserMgmtDataMapper;
import com.example.usermgmt.dto.UserDTO;
import com.example.usermgmt.entity.UserEntity;
import com.example.usermgmt.repository.UserMgmtRepo;
import com.example.usermgmt.service.UserMgmtService;

@Service
public class UserMgmtServiceImpl implements UserMgmtService {

	@Autowired
	private UserMgmtRepo userMgmtRepo;
	
	@Autowired
	private UserMgmtDataMapper userMgmtDataMapper;
	
	@Override
	public List<UserDTO> addUsers(List<UserDTO> userList) {
		return userMgmtDataMapper.convertFromEntitiesToDTOs(userMgmtRepo.saveAll(userMgmtDataMapper.convertFromDTOsToEntities(userList)));
	}

	@Override
	public List<UserDTO> updateUsers(List<UserDTO> userList) {
		List<UserDTO> savedList = new ArrayList<UserDTO>();
		for(UserDTO userDTO : userList) {
			if(null != userDTO && userDTO.getUserId() != null && userDTO.getUserId() != 0L) {
				Optional<UserEntity> userEntityOpt = userMgmtRepo.findById(userDTO.getUserId());
				if(userEntityOpt.isPresent()) {
					UserEntity userEntity = userMgmtDataMapper.convertFromDTOToEntiy(userDTO);
					userEntity.setUserId(userEntityOpt.get().getUserId());
					userMgmtRepo.save(userEntity);
					savedList.add(userMgmtDataMapper.convertFromEntityToDTO(userEntity));
				}
			}
		}
		return savedList;
	}

	@Override
	public List<UserDTO> fetchUsers(List<UserDTO> userList) {
		List<Long> userIds = userList.stream().map(userDTO -> userDTO.getUserId()).collect(Collectors.toList());
		List<UserEntity> userEntityList = userMgmtRepo.findAllById(userIds);
		return userMgmtDataMapper.convertFromEntitiesToDTOs(userEntityList);
	}

	@Override
	public List<UserDTO> deleteUsers(List<UserDTO> userList) {
		userMgmtRepo.deleteAll(userMgmtDataMapper.convertFromDTOsToEntities(userList));
		return userList;
	}

}
