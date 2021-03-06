package com.consulta.cep.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consulta.cep.entity.Cep;
import com.consulta.cep.json.CepImpJson;
import com.consulta.cep.json.CepJson;
import com.consulta.cep.json.RespostaCepJson;
import com.consulta.cep.repository.Ceps;

@Service
public class ConsultaEnderecoServicesImpl implements ConsultaEnderecoServices{
	
	@Autowired
	Ceps ceps;	

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
			resposta.setEnderecos(cepListJson);
        }else{
        	for(int i=0; i < ceps.length ; i++){					
				if(cep.getCep().contains(ceps[i])) {
	              if(cep.getCep().equals( cepJson.getCep()) ){
	            	  cepListJson.add( cepJson);
	  				resposta.setEnderecos(cepListJson);
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

	@Override
	public String salvarEndereco(Cep cep) {
		
		String result = null;
		CepJson cepJson = new CepJson();
		try{
			cepJson.setCep(cep.toString());
			RespostaCepJson resp = consultaCepServices(cepJson);
			if(resp.getMsg() == null){	
				ceps.save(cep);		
				result = "Salvo";
			}else
				result = resp.getMsg();
						
		}catch (Exception e) {
			result = "Erro ao salvar!";
		}
		return result;
	}

	@Override
	public String editarEndereco(Long codigo, Cep cep) {
		
		String result = null;
		CepJson cepJson = new CepJson();
		try{
			cepJson.setCep(cep.toString());
			RespostaCepJson resp = consultaCepServices(cepJson);
			if(resp.getMsg() == null){	
				Cep cepUpdate = ceps.findOne(codigo);
				cepUpdate.setCliEndBairro(cep.getCliEndBairro());
				cepUpdate.setCliEndCep(cep.getCliEndCep());
				cepUpdate.setCliEndCidade(cep.getCliEndCidade());
				cepUpdate.setCliEndComplemento(cep.getCliEndComplemento());
				cepUpdate.setCliEndEstado(cep.getCliEndEstado());
				cepUpdate.setCliEndNumero(cep.getCliEndNumero());
				cepUpdate.setCliEndRua(cep.getCliEndRua());
				ceps.saveAndFlush(cepUpdate);	
				result= "Editado";
			}else
				result = resp.getMsg();
						
		}catch (Exception e) {
			result = "Erro ao salvar!";
		}		
				
		return result;
	}

	@Override
	public String deletarEndereco(Long codigo) {
		ceps.delete(codigo);
		return "Deletado";
	}

}
