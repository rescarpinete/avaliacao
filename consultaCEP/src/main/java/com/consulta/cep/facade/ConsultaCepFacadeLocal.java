package com.consulta.cep.facade;

import com.consulta.cep.json.CepJson;
import com.consulta.cep.json.RespostaCepJson;


public interface ConsultaCepFacadeLocal {
	
	RespostaCepJson consultaFrete(CepJson cep);

}
