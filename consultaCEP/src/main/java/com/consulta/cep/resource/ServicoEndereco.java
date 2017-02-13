package com.consulta.cep.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consulta.cep.facade.ConsultaCepFacade;
import com.consulta.cep.json.CepJson;
import com.consulta.cep.json.RespostaCepJson;

@Controller
@RequestMapping("/endereco")
public class ServicoEndereco {
	
	@Autowired
	ConsultaCepFacade facade;
	
	@RequestMapping(value = {"/consulta/cep"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespostaCepJson> consultaFreteMock(@RequestBody CepJson cep){
		RespostaCepJson respostaCepJson = facade.consultaFrete(cep);
		return  ResponseEntity.ok(respostaCepJson);
		
	}
	
		
	


}
