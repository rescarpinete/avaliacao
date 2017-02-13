package com.consulta.cep.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consulta.cep.entity.Cep;
import com.consulta.cep.json.CepJson;
import com.consulta.cep.json.RespostaCepJson;
import com.consulta.cep.repository.Ceps;
import com.consulta.cep.services.ConsultaEnderecoServices;

@Controller
@RequestMapping("/endereco")
public class ServicoEndereco  {
	
	@Autowired
	ConsultaEnderecoServices consultaEnderecoServices;

	@RequestMapping(value = {"/consulta/cep"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespostaCepJson> consultaFrete(@RequestBody CepJson cep){
		RespostaCepJson respostaCepJson = consultaEnderecoServices.consultaCepServices(cep);
		return  ResponseEntity.ok(respostaCepJson);
		
	}
	
	@RequestMapping(value = {"/consulta/save"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> save(@RequestBody Cep cep){
		String reult = consultaEnderecoServices.saveEndereco(cep);
		return  ResponseEntity.ok(reult);
		
	}
	
		
	


}
