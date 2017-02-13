package com.consulta.cep.services;

import com.consulta.cep.entity.Cep;
import com.consulta.cep.json.CepJson;
import com.consulta.cep.json.RespostaCepJson;

public interface ConsultaEnderecoServices {
	
	RespostaCepJson consultaCepServices(CepJson cep);

	String saveEndereco(Cep cep);

}
