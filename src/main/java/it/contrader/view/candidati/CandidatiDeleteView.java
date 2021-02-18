package it.contrader.view.candidati;

import it.contrader.controller.Request;
import it.contrader.dao.CandidatiDAO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CandidatiDeleteView  extends AbstractView{

	private Request request;

	private int idCandidati;
	private final String mode = "DELETE";

	public CandidatiDeleteView() {
	}
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Candidati", null);
		}
	}
	@Override
	public void showOptions() {
			System.out.println("Inserisci l'id del Candidato da cancellare:");
			idCandidati = Integer.parseInt(getInput());

	}
	@Override
	public void submit() {
		request = new Request();
		request.put(CandidatiDAO.CONST.ID_CANDIDATI, idCandidati);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Candidati", "doControl", request);
	}

}
