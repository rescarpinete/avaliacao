package com.consulta.cep.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulta.cep.json.CepJson;
import com.consulta.cep.json.RespostaCepJson;
import com.consulta.cep.services.ConsultaEnderecoServices;

@Service
public class ConsultaCepFacade implements ConsultaCepFacadeLocal{
	
	@Autowired
	ConsultaEnderecoServices consultaEnderecoServices;
	
	public RespostaCepJson consultaFrete(CepJson cep){
		
		return consultaEnderecoServices.consultaCepServices(cep);
	}

	
}
