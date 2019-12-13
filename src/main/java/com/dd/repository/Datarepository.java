package com.dd.repository;

import org.springframework.data.repository.CrudRepository;

import com.dd.entity.Data;

public interface Datarepository extends CrudRepository<Data,Integer> {

    Data findByid(int id);

	void edit(Data data);
}
 