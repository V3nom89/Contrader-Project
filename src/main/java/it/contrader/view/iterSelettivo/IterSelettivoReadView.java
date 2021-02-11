package it.contrader.view.iterSelettivo;

import it.contrader.controller.Request;
import it.contrader.dto.IterSelettivoDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class IterSelettivoReadView extends AbstractView {
	
	private int idIterSelettivo;
	private Request request;
	private final String mode = "READ";
	
	public IterSelettivoReadView() {
	}
	
	/*
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
			IterSelettivoDTO iterSelettivo = (IterSelettivoDTO) request.get("iterSelettivo");
			System.out.println(iterSelettivo);
			MainDispatcher.getInstance().callView("IterSelettivo", null);
		}
	}
	
	/*
	 * chiede all'utente di inserire l'id dell'iter selettivo da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'iter selettivo:");
		idIterSelettivo = Integer.parseInt(getInput());
	}
	
	/*
	 * impacchetta una request con l'id dell'iter selettivo da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idIterSelettivo", idIterSelettivo);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("IterSelettivo", "doControl", request);
	}


//end
}