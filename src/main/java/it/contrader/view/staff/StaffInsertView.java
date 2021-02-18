
package it.contrader.view.staff;

import it.contrader.controller.Request;
import it.contrader.dao.StaffDAO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class StaffInsertView extends AbstractView{

	private Request request;
	
	private int idStaff;
	private String nome;
	private String cognome;
	private String email;
	private String posizione;
	private int numeroTelefono;
	private String dataAssunzione;
	private String sede;
	private int oreSettimanali;
	private String codiceFiscale;

	private final String mode = "INSERT";

	public StaffInsertView() {
	}
	
	/**
	 * Se la request non � nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Staff", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci l'id del membro dello Staff:");
			idStaff = getInt();
			System.out.println("Inserisci nome del membro dello staff:");
			nome= getInput();
			System.out.println("Inserisci cognome del membro dello staff:");
			cognome = getInput();
			System.out.println("Inserisci l'email del menbro dello staff:");
			email= getInput();
			System.out.println("Inserisci la posizione  del membro dello staff:");
			posizione = getInput();
			System.out.println("Inserisci numero di telefono del membro dello staff:");
			numeroTelefono = getInt();
			System.out.println("Inserisci la data di assunzione del membro dello staff:");
			dataAssunzione = getInput();
			System.out.println("Inserisci la sede del membro dello staff:");
			sede = getInput();
			System.out.println("Inserisci le ore settimanali del membro dello staff:");
			oreSettimanali = getInt();
			System.out.println("Inserisci il codice fiscale del membro dello staff:");
			codiceFiscale = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put(StaffDAO.CONST.ID_STAFF, idStaff);
		request.put(StaffDAO.CONST.NOME, nome);
		request.put(StaffDAO.CONST.COGNOME, cognome);
		request.put(StaffDAO.CONST.EMAIL, email);
		request.put(StaffDAO.CONST.POSIZIONE, posizione);
		request.put(StaffDAO.CONST.TELEFONO, numeroTelefono);
		request.put(StaffDAO.CONST.DATA_ASSUNZIONE, dataAssunzione);
		request.put(StaffDAO.CONST.SEDE, sede);
		request.put(StaffDAO.CONST.ORE_SETTIMANALI, oreSettimanali);
		request.put(StaffDAO.CONST.CODICE_FISCALE, codiceFiscale);

		request.put("mode", mode);
		
		MainDispatcher.getInstance().callAction("Staff", "doControl", request);
	}

}
