package it.contrader.service;

import java.util.List;


import it.contrader.converter.StaffConverter;
import it.contrader.dao.StaffDAO;
import it.contrader.dto.StaffDTO;

/**
 * 
 * @author Vittorio, De Santis
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class StaffService {
	
	private StaffDAO staffDAO;
	private StaffConverter staffConverter;
	
	//Istanzio DAO  e Converter specifici.
	public StaffService(){
		this.staffDAO = new StaffDAO();
		this.staffConverter = new StaffConverter();
	}
	

	public List<StaffDTO> getAll() {
		// Ottiene una lista di entità e le restituisce convertendole in DTO
		return staffConverter.toDTOList(staffDAO.getAll());
	}


	public StaffDTO read(int idstaff) {
		// Ottiene un'entità e la restituisce convertendola in DTO
		return staffConverter.toDTO(staffDAO.read(idstaff));
	}


	public boolean insert(StaffDTO dto) {
		// Converte un DTO in entità e lo passa al DAO per l'inserimento
		return staffDAO.insert(staffConverter.toEntity(dto));
	}


	public boolean update(StaffDTO dto) {
		// Converte un userDTO in entità e lo passa allo userDAO per la modifica
		return staffDAO.update(staffConverter.toEntity(dto));
	}


	public boolean delete(int id) {
		// Questo mtodo chiama direttamente il DAO
		return staffDAO.delete(id);
	}
	

}
