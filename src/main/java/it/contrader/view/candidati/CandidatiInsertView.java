package it.contrader.view.candidati;



import it.contrader.controller.Request;
import it.contrader.dao.CandidatiDAO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
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
		request.put(CandidatiDAO.CONST.ID_CANDIDATI, idCandidati);
		request.put(CandidatiDAO.CONST.ID_STAFF, idStaff);
		request.put(CandidatiDAO.CONST.NOME, nome);
		request.put(CandidatiDAO.CONST.COGNOME, cognome);
		request.put(CandidatiDAO.CONST.EMAIL, email);
		request.put(CandidatiDAO.CONST.PROVENIENZA, luogoProvenienza);
		request.put(CandidatiDAO.CONST.TELEFONO, numeroTelefono);
		request.put(CandidatiDAO.CONST.TITOLO_STUDIO, titoloStudio);
		request.put(CandidatiDAO.CONST.TITOLO_LAUREA, titoloLaurea);
		request.put(CandidatiDAO.CONST.DATA_CANDIDATURA, dataCandidatura);
		request.put(CandidatiDAO.CONST.RANGE_CANDIDATURA, rangeCandidatura);
		request.put(CandidatiDAO.CONST.COLLOQUIO_CONOSCITIVO, colloquioConoscitivo);
		request.put(CandidatiDAO.CONST.CANDIDATI_TRAMITE, candidatiTramite);
		request.put(CandidatiDAO.CONST.IDONEITA, idoneita);
		request.put(CandidatiDAO.CONST.CODICE_FISCALE, codiceFiscale);
		request.put(CandidatiDAO.CONST.USER_TYPE, userType);

		request.put("mode", mode);
		
		MainDispatcher.getInstance().callAction("Candidati", "doControl", request);
	}


}
