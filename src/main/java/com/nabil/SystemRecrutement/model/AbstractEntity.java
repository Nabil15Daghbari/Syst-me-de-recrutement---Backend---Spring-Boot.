package com.nabil.SystemRecrutement.model;


import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;


@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
	
	
	//@Id 
	//@GeneratedValue(strategy = GenerationType.AUTO ) 
	@Id
	//@GeneratedValue(generator = "uuid")
	//@GenericGenerator(name = "uuid", strategy = "uuid2")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
    private Long id;
	
	
	
	@CreatedDate
	//@Column(name="creactionDate" , nullable =false   )
	
	private Instant creationDate ; 
	
	
	@LastModifiedDate
	//@Column(name="lastModifiedDate"  )
	 
    private Instant lastModifiedDate ;
	
	
	
	

}
