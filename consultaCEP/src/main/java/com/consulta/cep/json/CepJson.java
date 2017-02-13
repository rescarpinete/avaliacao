package com.consulta.cep.json;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class CepJson implements Serializable{

	private static final long serialVersionUID = 1L;
	private String cep;

}
