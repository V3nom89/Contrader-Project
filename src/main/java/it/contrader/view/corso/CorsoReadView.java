package it.contrader.view.corso;

import it.contrader.controller.Request;

import it.contrader.dto.CorsoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
import it.contrader.dao.CorsoDAO;

public class CorsoReadView extends AbstractView{
	
	private int idCorso;
	private Request request;
	private final String mode = "READ";

	public CorsoReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			CorsoDTO corso = (CorsoDTO) request.get("corso");
			System.out.println(corso);
			MainDispatcher.getInstance().callView("Corso", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del corso:");
		idCorso = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put(CorsoDAO.CONST.ID_CORSO, idCorso);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Corso", "doControl", request);
	}


}
