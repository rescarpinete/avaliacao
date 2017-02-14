package com.consulta.cep.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.consulta.cep.entity.Cep;
import com.consulta.cep.json.CepJson;
import com.consulta.cep.json.RespostaCepJson;
import com.consulta.cep.services.ConsultaEnderecoServices;

@Controller
@RequestMapping("/endereco")
public class ConsultaEnderecoResource  {
	
	@Autowired
	ConsultaEnderecoServices consultaEnderecoServices;

	@RequestMapping(value = {"/consulta/cep"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RespostaCepJson> consultaFrete(@RequestBody CepJson cep){
		RespostaCepJson respostaCepJson = consultaEnderecoServices.consultaCepServices(cep);
		return  ResponseEntity.ok(respostaCepJson);
	}
	
	@RequestMapping(value = {"/consulta/salvar"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> salvar(@RequestBody Cep cep){
		String reult = consultaEnderecoServices.salvarEndereco(cep);
		return  ResponseEntity.ok(reult);
	}
	
	@RequestMapping(value = {"/consulta/editar/{codigo}"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> editar(@PathVariable("codigo") Long codigo, @RequestBody Cep cep){
		String reult = consultaEnderecoServices.editarEndereco(codigo, cep);
		return  ResponseEntity.ok(reult);
	}
	
	@RequestMapping(value = {"/consulta/deletar/{codigo}"}, method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deletar(@PathVariable("codigo") Long codigo){
		String reult = consultaEnderecoServices.deletarEndereco(codigo);
		return  ResponseEntity.ok(reult);
	}		
	


}
