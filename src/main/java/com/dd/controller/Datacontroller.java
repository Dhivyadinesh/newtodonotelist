package com.dd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dd.service.DataService;

public class Datacontroller {
	
	@Autowired
    DataService todosService;
	
    @ResponseBody
    @RequestMapping(value = "/{item}/{description}", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String createNote(@PathVariable("item") String item,@PathVariable("description") String description) {

    DataService.createNote(item,description);

        return "200 OK";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE)
    public String editNote(@PathVariable("id") int id) {

        DataService.editNote(id);

        return "200 OK";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String deleteTodos(@PathVariable("id") int id) {

        DataService.deleteNote(id);

        return "200 OK";
    }


}
