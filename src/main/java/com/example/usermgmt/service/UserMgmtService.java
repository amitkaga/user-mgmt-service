package com.example.usermgmt.service;

import java.util.List;

import com.example.usermgmt.dto.UserDTO;

public interface UserMgmtService {

	List<UserDTO> addUsers(List<UserDTO> userList);

	List<UserDTO> updateUsers(List<UserDTO> userList);

	List<UserDTO> fetchUsers(List<UserDTO> userList);

	List<UserDTO> deleteUsers(List<UserDTO> userList);

}
