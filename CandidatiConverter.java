package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.CandidatiDTO;

import it.contrader.model.Candidati;


public class CandidatiConverter implements Converter<Candidati, CandidatiDTO>  {
		
		/**
		 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
		 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
		 */
		@Override
		public CandidatiDTO toDTO(Candidati candidati) {
			CandidatiDTO  candidatiDTO = new CandidatiDTO(candidati.getIdCandidati(), candidati.getIdStaff(), candidati.getNome(),candidati.getCognome(),candidati.getEmail(),candidati.getLuogoProvenienza(), candidati.getNumeroTelefono(),
					candidati.getTitoloStudio(), candidati.getTitoloLaurea(),candidati.getDataCandidatura(), candidati.getRangeCandidatura(), candidati.isColloquioConoscitivo(),
					candidati.getCandidatiTramite(),candidati.isIdoneita(),candidati.getCodiceFiscale(),candidati.getUserType());
			return candidatiDTO;
		}

		/**
		 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
		 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
		 */
		@Override
		public Candidati toEntity(CandidatiDTO candidatiDTO) {
			Candidati candidati = new Candidati(candidatiDTO.getIdCandidati(),candidatiDTO.getIdStaff(), candidatiDTO.getNome(),candidatiDTO.getCognome(),candidatiDTO.getEmail(),candidatiDTO.getLuogoProvenienza(), candidatiDTO.getNumeroTelefono(),
					candidatiDTO.getTitoloStudio(), candidatiDTO.getTitoloLaurea(),candidatiDTO.getDataCandidatura(), candidatiDTO.getRangeCandidatura(), candidatiDTO.isColloquioConoscitivo(),
					candidatiDTO.getCandidatiTramite(),candidatiDTO.isIdoneita(),candidatiDTO.getCodiceFiscale(),candidatiDTO.getUserType());
			return candidati;
		}
		
		/**
		 * Metodo per convertire le liste di User.
		 */
		@Override
		public List<CandidatiDTO> toDTOList(List<Candidati> candidatiList) {
			//Crea una lista vuota.
			List<CandidatiDTO> candidatiDTOList = new ArrayList<CandidatiDTO>();
			
			//Cicla tutti gli elementi della lista e li converte uno a uno
			for(Candidati candidati : candidatiList) {
				//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
				//e lo aggiunge adda lista di DTO
				candidatiDTOList.add(toDTO(candidati));
			}
			return candidatiDTOList;
		}

}
