package it.contrader.view.candidati;

import it.contrader.dto.CandidatiDTO;

import it.contrader.controller.Request;
import it.contrader.dao.CandidatiDAO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CandidatiReadView extends AbstractView {
	
	private int idCandidati;
	private Request request;
	private final String mode = "READ";
	
	public CandidatiReadView() {
	}
	@Override
	public void showResults(Request request) {
		if (request != null) {
			CandidatiDTO candidati = (CandidatiDTO) request.get("candidati");
			System.out.println(candidati);
			MainDispatcher.getInstance().callView("Candidati", null);
		}
	}
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del Candidato:");
		idCandidati = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put(CandidatiDAO.CONST.ID_CANDIDATI, idCandidati);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Candidati", "doControl", request);
	}


}
