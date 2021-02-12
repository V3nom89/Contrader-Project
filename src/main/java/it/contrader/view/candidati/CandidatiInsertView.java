package it.contrader.view.candidati;



import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Candidati;
import it.contrader.view.AbstractView;
import java.lang.String;
public class CandidatiInsertView extends AbstractView {

	private Request request;
	private int idCandidati;
	private int idStaff;
	private String nome;
	private String cognome;
	private String email;
	private String luogoProvenienza;
	private int numeroTelefono;
	private String titoloStudio;
	private String titoloLaurea;
	private String dataCandidatura;
	private String rangeCandidatura;
	private boolean colloquioConoscitivo;
	private String candidatiTramite;
	private boolean idoneita;
	private String codiceFiscale;
	private String userType;

	private final String mode = "INSERT";

	public CandidatiInsertView() {
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Candidati", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
		
		System.out.println("Inserisci idStaff dell'utente:");
		idStaff = getInt();
		System.out.println("Inserisci nome dell'utente:");
		nome = getInput();
		System.out.println("Inserisci cognome dell'utente:");
		cognome = getInput();
		System.out.println("Inserisci email dell'utente:");
		email = getInput();
		System.out.println("Inserisci luogo provenienza dell'utente:");
		luogoProvenienza = getInput();
		System.out.println("Inserisci numero di telefono dell'utente:");
		numeroTelefono = getInt();
		System.out.println("Inserisci titoloStudio dell'utente:");
		titoloStudio = getInput();
		System.out.println("Inserisci titoloLaurea dell'utente:");
		titoloLaurea = getInput();
		System.out.println("Inserisci dataCandidatura dell'utente:");
		dataCandidatura = getInput();
		System.out.println("Inserisci rangeCandidatura dell'utente:");
		rangeCandidatura = getInput();
		System.out.println("Ha gia' fatto il colloquio conoscitivo ?");
		colloquioConoscitivo = getBoolean();
		System.out.println("Inserisci la modalita' di candidatura dell'utente:");
		candidatiTramite = getInput();
		System.out.println("Inserisci se l'utente e' idoneo:");
		idoneita = getBoolean();
		System.out.println("Inserisci codice fiscale dell'utente:");
		codiceFiscale = getInput();
		System.out.println("Inserisci usertype dell'utente:");
		userType = getInput();
		
	}
	@Override
	public void submit() {
		request = new Request();
		request.put(Candidati.CONST.ID_CANDIDATI, idCandidati);
		request.put(Candidati.CONST.ID_STAFF, idStaff);
		request.put(Candidati.CONST.NOME, nome);
		request.put(Candidati.CONST.COGNOME, cognome);
		request.put(Candidati.CONST.EMAIL, email);
		request.put(Candidati.CONST.PROVENIENZA, luogoProvenienza);
		request.put(Candidati.CONST.TELEFONO, numeroTelefono);
		request.put(Candidati.CONST.TITOLO_STUDIO, titoloStudio);
		request.put(Candidati.CONST.TITOLO_LAUREA, titoloLaurea);
		request.put(Candidati.CONST.DATA_CANDIDATURA, dataCandidatura);
		request.put(Candidati.CONST.RANGE_CANDIDATURA, rangeCandidatura);
		request.put(Candidati.CONST.COLLOQUIO_CONOSCITIVO, colloquioConoscitivo);
		request.put(Candidati.CONST.CANDIDATI_TRAMITE, candidatiTramite);
		request.put(Candidati.CONST.IDONEITA, idoneita);
		request.put(Candidati.CONST.CODICE_FISCALE, codiceFiscale);
		request.put(Candidati.CONST.USER_TYPE, userType);

		request.put("mode", mode);
		
		MainDispatcher.getInstance().callAction("Candidati", "doControl", request);
	}


}
