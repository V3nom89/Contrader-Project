
package it.contrader.view.staff;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Staff;
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
			System.out.println("Inserisci idStaff dell'utente:");
			idStaff = getInt();
			System.out.println("Inserisci nome del membro dello staff che ha seguito il corso:");
			nome= getInput();
			System.out.println("Inserisci cognome del membro dello staff che ha seguito il corso:");
			cognome = getInput();
			System.out.println("Inserisci l'email del menbro dello staff che ha seguito il corso:");
			email= getInput();
			System.out.println("Inserisci la posizione  del membro dello staff che ha seguito il corso:");
			posizione = getInput();
			System.out.println("Inserisci numero di telefono del membro dello staff che ha seguito il corso:");
			numeroTelefono = getInt();
			System.out.println("Inserisci dataAssunzione del membro dello staff che ha seguito il corso:");
			dataAssunzione = getInput();
			System.out.println("Inserisci sede del membro dello staff che ha seguito il corso:");
			sede = getInput();
			System.out.println("Inserisci oreSettimanali del membro dello staff che ha seguito il corso:");
			oreSettimanali = getInt();
			System.out.println("Inserisci codiceFiscale del membro dello staff che ha seguito il corso:");
			codiceFiscale = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put(Staff.CONST.ID_STAFF, idStaff);
		request.put(Staff.CONST.NOME, nome);
		request.put(Staff.CONST.COGNOME, cognome);
		request.put(Staff.CONST.EMAIL, email);
		request.put(Staff.CONST.POSIZIONE, posizione);
		request.put(Staff.CONST.TELEFONO, numeroTelefono);
		request.put(Staff.CONST.DATA_ASSUNZIONE, dataAssunzione);
		request.put(Staff.CONST.SEDE, sede);
		request.put(Staff.CONST.ORE_SETTIMANALI, oreSettimanali);
		request.put(Staff.CONST.CODICE_FISCALE, codiceFiscale);

		request.put("mode", mode);
		
		MainDispatcher.getInstance().callAction("Staff", "doControl", request);
	}

}
