package it.contrader.view.iterSelettivo;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
import it.contrader.dao.IterSelettivoDAO;

public class IterSelettivoDeleteView extends AbstractView {
	
	private Request request;

	private int idIterSelettivo;
	private final String mode = "DELETE";
	
	public IterSelettivoDeleteView() {
		
	}
	
	/*
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("IterSelettivo", null);
		}
	}
	

	 //Chiede all'utente di inserire l'id dell'iter selettivo da cancellare
	@Override
	public void showOptions() {
			System.out.println("Inserisci id dell'iter selettivo da cancellare:");
			idIterSelettivo = Integer.parseInt(getInput());
	}		
	/*
	 * impacchetta la request con l'id dell'iter selettivo da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put(IterSelettivoDAO.CONST.ID_ITER_SELETTIVO, idIterSelettivo);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("IterSelettivo", "doControl", request);
	}


}


