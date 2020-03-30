package com.fms.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.fms.domain.FeedbackType;


public interface FeedbackRepository extends ReactiveCrudRepository<FeedbackType, Long>{

}
