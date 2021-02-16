package com.umuarama.questionario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umuarama.questionario.models.PesquisaMicrosolt;
 
@Repository
public interface PesquisaMicrosoftRepository extends JpaRepository<PesquisaMicrosolt, Long> {

	
}
