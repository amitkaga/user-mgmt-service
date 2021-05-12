package com.example.usermgmt.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.usermgmt.dto.UserDTO;
import com.example.usermgmt.service.UserMgmtService;
import com.example.usermgmt.util.UserMgmtConstant;

@RestController
@RequestMapping("/user-mgmt-service")
public class UserMgmtController {
	
	@Autowired
	private UserMgmtService userMgmtService;
	
	@Autowired
	private MessageSource messageSource;

	@PostMapping(value = "/users")
	public ResponseEntity<List<UserDTO>> addUsers(@RequestBody List<UserDTO> userList){
		if(null == userList || userList.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
					messageSource.getMessage(UserMgmtConstant.INVALID_PAYLOAD_ERROR, null, Locale.getDefault()));
		}
		try {
			List<UserDTO> listOfAddedUsers = userMgmtService.addUsers(userList);
			return new ResponseEntity<List<UserDTO>>(listOfAddedUsers, HttpStatus.OK);	
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
					messageSource.getMessage(UserMgmtConstant.GENERIC_ERROR, null, Locale.getDefault()));
		}
	}
	
	@PutMapping("/users")
	public ResponseEntity<List<UserDTO>> updateUsers(@RequestBody List<UserDTO> userList){
		if(null == userList || userList.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
					messageSource.getMessage(UserMgmtConstant.INVALID_PAYLOAD_ERROR, null, Locale.getDefault()));
		}
		try {
			List<UserDTO> listOfUpdatedUsers = userMgmtService.updateUsers(userList);
			return new ResponseEntity<List<UserDTO>>(listOfUpdatedUsers, HttpStatus.OK);	
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
					messageSource.getMessage(UserMgmtConstant.GENERIC_ERROR, null, Locale.getDefault()));
		}
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> fetchUsers(@RequestBody List<UserDTO> userList){
		if(null == userList || userList.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
					messageSource.getMessage(UserMgmtConstant.INVALID_PAYLOAD_ERROR, null, Locale.getDefault()));
		}
		try {
			List<UserDTO> listOfFetchedUsers = userMgmtService.fetchUsers(userList);
			return new ResponseEntity<List<UserDTO>>(listOfFetchedUsers, HttpStatus.OK);	
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
					messageSource.getMessage(UserMgmtConstant.GENERIC_ERROR, null, Locale.getDefault()));
		}
	}
	
	@DeleteMapping("/users")
	public ResponseEntity<List<UserDTO>> deleteUsers(@RequestBody List<UserDTO> userList){
		if(null == userList || userList.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
					messageSource.getMessage(UserMgmtConstant.INVALID_PAYLOAD_ERROR, null, Locale.getDefault()));
		}
		try {
			List<UserDTO> listOfDeletedUsers = userMgmtService.deleteUsers(userList);
			return new ResponseEntity<List<UserDTO>>(listOfDeletedUsers, HttpStatus.OK);	
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, 
					messageSource.getMessage(UserMgmtConstant.GENERIC_ERROR, null, Locale.getDefault()));
		}
	}
}
