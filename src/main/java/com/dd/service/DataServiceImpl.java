package com.dd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.dd.entity.Data;
import com.dd.entity.User;
import com.dd.repository.Datarepository;
import com.dd.repository.Userrepository;

@Service("DataService")
public class DataServiceImpl implements DataService{
	
	@Autowired
	private Userrepository UserRepository;

	@Autowired
	Datarepository DataRepository;

	public void createNote(String title, String description) {
		
		Data data = new Data(title,description,false,false);
        data.setUser(getCurrentUser());
        DataRepository.save(data);
	}

	private User getCurrentUser() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    return UserRepository.findByUsername(auth.getName());
	}

	@Override
	public Data findByid(int id) {
		
		return DataRepository.findByid(id);
	}

	public void editNote(int id) {
		
		Data data = findByid(id);
        DataRepository.edit(data);
		
	}

	public void deleteNote(int id) {
		
		Data data = findByid(id);
        DataRepository.delete(data);
		
	}
}
