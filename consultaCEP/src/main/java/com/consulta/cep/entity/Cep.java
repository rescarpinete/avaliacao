package com.consulta.cep.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;

import lombok.Data;

@Entity
@Data
public class Cep  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@JsonDeserialize(using = StringDeserializer.class)
	@NotNull
	private String cliEndRua;
	
	@NotNull
	private int cliEndNumero;
	
	@NotNull
	private int cliEndCep;
	 
	@NotNull
	@JsonDeserialize(using = StringDeserializer.class)
	private String cliEndCidade;
	 
	@NotNull
	@JsonDeserialize(using = StringDeserializer.class)
	private String cliEndEstado;
	 
	@JsonDeserialize(using = StringDeserializer.class)
	private String cliEndBairro;
	 
	@JsonDeserialize(using = StringDeserializer.class)
	private String cliEndComplemento;

}
