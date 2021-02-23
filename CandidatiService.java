package it.contrader.service;

import it.contrader.converter.CandidatiConverter;
import it.contrader.dao.CandidatiDAO;
import it.contrader.dto.CandidatiDTO;
import it.contrader.model.Candidati;


public class CandidatiService extends AbstractService<Candidati, CandidatiDTO>{


	
	
	//Istanzio DAO  e Converter specifici.
	public CandidatiService(){
		this.dao = new CandidatiDAO();
		this.converter = new CandidatiConverter();
	}
	

}