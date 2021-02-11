package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.CorsoDTO;
import it.contrader.model.Corso;


public class CorsoConverter {
	
	/**
	 * Crea un oggetto di tipo CorsoDTO e lo riempie con i campi del parametro user di tipo Corso.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public CorsoDTO toDTO(Corso corso) {
		CorsoDTO corsoDTO = new CorsoDTO(corso.getIdCandidato(), corso.getIdIterSelettivo(), corso.getArgomentoCorso(),corso.getValutazioneComunicazioni(), corso.getValutazioneIntuitivita(), corso.getValutazioneAttitudine(), corso.getValutazioneTeamWork(), corso.getOreTotali(), corso.getIdStaff(), corso.getDataInizio());
		return corsoDTO;
	}

	/**
	 * Crea un oggetto di tipo Corso e lo riempie con i campi del parametro user di tipo CorsoDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public Corso toEntity(CorsoDTO corsoDTO) {
		Corso corso = new Corso(corsoDTO.getIdCorso(), corsoDTO.getIdCandidato(), corsoDTO.getArgomentoCorso(),corsoDTO.getValutazioneComunicazioni(), corsoDTO.getValutazioneIntuitivita(), corsoDTO.getValutazioneAttitudine(), corsoDTO.getValutazioneTeamWork(), corsoDTO.getOreTotali(), corsoDTO.getIdStaff(), corsoDTO.getDataInizio());
		return corso;
	}
	
	/**
	 * Metodo per convertire le liste di Corso.
	 */
	public List<CorsoDTO> toDTOList(List<Corso> corsoList) {
		//Crea una lista vuota.
		List<CorsoDTO> corsoDTOList = new ArrayList<CorsoDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Corso corso : corsoList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			corsoDTOList.add(toDTO(corso));
		}
		return corsoDTOList;
	}
}
