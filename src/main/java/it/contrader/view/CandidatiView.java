package it.contrader.view;

import java.util.List;

import it.contrader.dto.CandidatiDTO;
import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class CandidatiView extends AbstractView {

	private Request request;
	private String choice;

	public CandidatiView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione candidati ----------------\n");
			System.out.println(" idStaff \tnome \tcognome\temail\tluogoProvenienza\tnumero_telefono\ttitoloStudio\ttitoloLaurea\tdataCandidatura\trangeCandidatura\tcolloquioConoscitivo\tcandidatiTramite\tidoneita\tcodiceFiscale\tusertype");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<CandidatiDTO> candidati = (List<CandidatiDTO>) request.get("candidati");
			for (CandidatiDTO c: candidati)
				System.out.println(c);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Candidati", "doControl", this.request);
	}
}