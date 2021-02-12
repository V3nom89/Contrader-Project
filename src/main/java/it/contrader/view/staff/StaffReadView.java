
package it.contrader.view.staff;

import it.contrader.controller.Request;
import it.contrader.dao.StaffDAO;
import it.contrader.dto.StaffDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class StaffReadView extends AbstractView{
	
	private int idStaff;
	private Request request;
	private final String mode = "READ";

	public StaffReadView() {
	}

	/**
	 * Se la request � null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo � vuoto.
	 * 
	 * Altrimenti se arriva con uno user nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo user. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			StaffDTO staff = (StaffDTO) request.get("staff");
			System.out.println(staff);
			MainDispatcher.getInstance().callView("Staff", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dell'utente da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID del menbre di staff:");
		idStaff = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dell'utente da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put(StaffDAO.CONST.ID_STAFF, idStaff);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Staff", "doControl", request);
	}


}
