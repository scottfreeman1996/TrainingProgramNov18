package com.mastek.fullstackassignment;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@Path("/participant/")
public class ParticipantAccessAPI {
	
	ParticipantJPARepository repository;
	
	public ParticipantJPARepository getRepository() {
		return repository;
	}
	
	@Autowired
	public void setRepository(ParticipantJPARepository repository) {
		this.repository = repository;
	}
	
	// Url: http://localhost:9900/products/list
	@Path("/list")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Participant> listParticipants(){
		return getRepository().findAll();
	}
	
	@POST
	@Path("/add")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public Participant addParticipant(@BeanParam Participant newParticipant) {
		getRepository().save(newParticipant);
		return newParticipant;
	}
	
	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Participant deleteParticipant(int empId) {
		Participant deleteParticipant = getRepository().findById(empId).get();
		getRepository().delete(deleteParticipant);
		return deleteParticipant;
	}
	
	
	

}
