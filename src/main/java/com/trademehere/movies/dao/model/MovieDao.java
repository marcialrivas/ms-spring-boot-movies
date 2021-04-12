package com.trademehere.movies.dao.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

@Document(collection = "movies")
public class MovieDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8636713687144756290L;
	@Id
	private String id;
	private String title;
	private String movieId;
	
}
