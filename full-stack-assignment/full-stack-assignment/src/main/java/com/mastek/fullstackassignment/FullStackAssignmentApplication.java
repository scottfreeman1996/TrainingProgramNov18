package com.mastek.fullstackassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FullStackAssignmentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(FullStackAssignmentApplication.class, args);
		
		TrainingAccessAPI trainingAPI = ctx.getBean(TrainingAccessAPI.class);
		
		ParticipantAccessAPI participantAPI = ctx.getBean(ParticipantAccessAPI.class);
		
		/*Training T1 = new Training();
		T1.setTrainingName("JAVA");
		T1.setTrainingLocation("UK");
		T1.setDate("10-10-2019");
		
		
		
		
		
		Participant P1 = new Participant();
		P1.setEmpName("Scott");
		
		P1.getTrainings().add(T1);
		T1.getParticipants().add(P1);
		
		trainingAPI.addTraining(T1);
		participantAPI.addParticipant(P1);*/
		
		
		
		//ctx.close();
	}

}

