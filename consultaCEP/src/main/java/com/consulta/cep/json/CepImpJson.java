package com.consulta.cep.json;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@Data
public class CepImpJson implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private String cep;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private String complemento;
	private String numero;

}
