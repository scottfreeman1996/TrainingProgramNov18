package com.mastek.fullstackassignment;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="FULL_STACK_TRAINING")
@XmlRootElement
public class Training {
	
	int trainingId;
	
	@FormParam("trainingName")
	String trainingName;
	@FormParam("trainingLocation")
	String trainingLocation;
	@FormParam("date")
	String date;
	
	Set<Participant> participants = new HashSet<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getTrainingLocation() {
		return trainingLocation;
	}
	public void setTrainingLocation(String trainingLocation) {
		this.trainingLocation = trainingLocation;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="FULL_STACK_TRAINING_PARTICIPANTS",//name of join table to be created by ORM
			// the foreign key for current class
			joinColumns= {@JoinColumn(name="FK_TrainingId")},
			// the foreign key for collection type class
			inverseJoinColumns= {@JoinColumn(name="FK_empId")})
	@XmlTransient
	public Set<Participant> getParticipants() {
		return participants;
	}
	
	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}
	
	
	

}
