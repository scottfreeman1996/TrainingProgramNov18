package com.mastek.fullstackassignment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TrainingJPARepository extends CrudRepository<Training, Integer>{
	

}
