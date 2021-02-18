package it.contrader.view;

import it.contrader.controller.Request;
import java.util.List;
import it.contrader.dto.CorsoDTO;
import it.contrader.main.MainDispatcher;

public class CorsoView extends AbstractView{

	private Request request;
	private String choice;

	public CorsoView() {
		
	}

	/**
	 * Mostra la lista utenti
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------------------------------------------------------------------------ Corso ----------------------------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.println("Id Corso\tId Candidato\tId Iter Selettivo\t Argomento Corso\t Valutazione Comunicazioni\t Valutazione Intuitivita\t Valutazione Attitudine\t Valutazione Team Work\t Ore Totali\t Id Staff\t Data Inizio");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<CorsoDTO> corso = (List<CorsoDTO>) request.get("corso");
			for (CorsoDTO u: corso)
				System.out.println(u);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalit� GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("Scegli l'operazione da effettuare:");
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
		MainDispatcher.getInstance().callAction("Corso", "doControl", this.request);
	}

}
