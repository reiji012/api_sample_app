package edu.self.handler;

import java.io.Serializable;

import org.junit.experimental.theories.Theories;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiError implements Serializable {
	private static final long serialVersionUID = 1L;

	private String message;
	
	@JsonProperty("documentation_url")
	private String documentationUrl;

}
