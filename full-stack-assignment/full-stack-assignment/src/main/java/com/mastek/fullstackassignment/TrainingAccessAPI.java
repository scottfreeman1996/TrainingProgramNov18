package com.mastek.fullstackassignment;

import java.util.Set;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Path("/training/")
public class TrainingAccessAPI {
	
	ParticipantJPARepository pRepository;
	
	
	public ParticipantJPARepository getpRepository() {
		return pRepository;
	}

	@Autowired
	public void setpRepository(ParticipantJPARepository pRepository) {
		this.pRepository = pRepository;
	}

	TrainingJPARepository repository;
	
	public TrainingJPARepository getRepository() {
		return repository;
	}
	
	@Autowired
	public void setRepository(TrainingJPARepository repository) {
		this.repository = repository;
	}
	
	// Url: http://localhost:9900/products/list
	@Path("/list")
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Training> listTraining(){
		return getRepository().findAll();
	}
	
	@POST
	@Path("/add")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	public Training addTraining(@BeanParam Training newTraining) {
		getRepository().save(newTraining);
		return newTraining;
	}
	
	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Training deleteTraining(int trainingId) {
		Training deleteTraining = getRepository().findById(trainingId).get();
		getRepository().delete(deleteTraining);
		return deleteTraining;
	}

	@POST
	@Path("/add-to-training")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Transactional
	public void addNewParticipantToTraining(@FormParam("trainingId")int trainingId, @FormParam("empId")int empId) {
		Participant p = getpRepository().findById(empId).get();
		Training t = getRepository().findById(trainingId).get();
		
		if(!t.getParticipants().contains(p)) {
			t.getParticipants().add(p);
		}
		
		//p.getTrainings().add(t);
		getRepository().save(t);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/participants-in-training")
	@Transactional
	public Set<Participant> getParticipantsInTraining(@QueryParam("trainingId")int trainingId){
		Training t = getRepository().findById(trainingId).get();  //error here
		
		if(!t.getParticipants().isEmpty()) {
			return t.getParticipants();
		}else {
			return null;
		}
	}
	

}
