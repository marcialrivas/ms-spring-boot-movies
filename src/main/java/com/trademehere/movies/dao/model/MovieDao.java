package com.trademehere.movies.dao.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)

@Entity
public class MovieDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8636713687144756290L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String title;
	private String movieId;
	
}
