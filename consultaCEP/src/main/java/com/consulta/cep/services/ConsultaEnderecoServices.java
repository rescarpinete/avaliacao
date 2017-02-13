package com.consulta.cep.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.consulta.cep.json.CepImpJson;
import com.consulta.cep.json.CepJson;
import com.consulta.cep.json.RespostaCepJson;

@Service
public class ConsultaEnderecoServices {

	public RespostaCepJson consultaCepServices(CepJson cep){
		
	RespostaCepJson resposta = new RespostaCepJson();
		
		CepImpJson  cepJson = new CepImpJson() ; 
		String[] ceps =  {"181320","1813200","18132000"}; 
		
		 cepJson.setCep("18132000");
		 cepJson.setRua("Governador Carvalho Pinto");
		 cepJson.setBairro("Jardim Boa Vista");
		 cepJson.setCidade("São Roque");
		 cepJson.setEstado("São Paulo");
		
		List<CepImpJson> cepListJson= new ArrayList<CepImpJson>();
		
        if(cep.getCep().equals( cepJson.getCep()) ){
        	cepListJson.add( cepJson);
			resposta.setFretes(cepListJson);
        }else{
        	for(int i=0; i < ceps.length ; i++){					
				if(cep.getCep().contains(ceps[i])) {
	              if(cep.getCep().equals( cepJson.getCep()) ){
	            	  cepListJson.add( cepJson);
	  				resposta.setFretes(cepListJson);
	  				break;
				  }else{
					cep.setCep(cep.getCep().concat("0"));
				  }
				}else{
					String msg = "CEP Invalido";
					resposta.setMsg(msg);
					break;
				}
			}
        }
		return resposta;
	}

}