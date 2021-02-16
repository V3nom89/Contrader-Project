package it.contrader.service;

import java.util.List;


import it.contrader.converter.CorsoConverter;
import it.contrader.dao.CorsoDAO;
import it.contrader.dto.CorsoDTO;

/**
 * 
 * @author Vittorio, De Santis
 *
 *Grazie all'ereditarietÃ  mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class CorsoService {
	
	private CorsoDAO corsoDAO;
	private CorsoConverter corsoConverter;
	
	//Istanzio DAO  e Converter specifici.
	public CorsoService(){
		this.corsoDAO = new CorsoDAO();
		this.corsoConverter = new CorsoConverter();
	}
	

	public List<CorsoDTO> getAll() {
		// Ottiene una lista di entitÃ  e le restituisce convertendole in DTO
		return corsoConverter.toDTOList(corsoDAO.getAll());
	}


	public CorsoDTO read(int idcorso) {
		// Ottiene un'entitÃ  e la restituisce convertendola in DTO
		return corsoConverter.toDTO(corsoDAO.read(idcorso));
	}


	public boolean insert(CorsoDTO dto) {
		// Converte un DTO in entitÃ  e lo passa al DAO per l'inserimento
		return corsoDAO.insert(corsoConverter.toEntity(dto));
	}


	public boolean update(CorsoDTO dto) {
		// Converte un userDTO in entitÃ  e lo passa allo userDAO per la modifica
		return corsoDAO.update(corsoConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return corsoDAO.delete(id);
	}
	

}
