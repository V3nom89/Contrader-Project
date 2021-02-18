package it.contrader.view.candidati;

import it.contrader.controller.Request;
import it.contrader.dao.CandidatiDAO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CandidatiUpdateView  extends AbstractView {
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

	private final String mode = "UPDATE";
	
	public CandidatiUpdateView() {
	}
	
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Candidati", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da modificare
	 */
	@Override
	public void showOptions() {
		try {

			System.out.println("Inserisci l'id del membro dello staff che segue il Candidato:");
			idStaff = getInt();
			System.out.println("Inserisci il nome del Candidato:");
			nome = getInput();
			System.out.println("Inserisci il cognome del Candidato:");
			cognome = getInput();
			System.out.println("Inserisci l'email del Candidato:");
			email = getInput();
			System.out.println("Inserisci il luogo di provenienza del Candidato:");
			luogoProvenienza = getInput();
			System.out.println("Inserisci il numero di telefono del Candidato:");
			numeroTelefono = getInt();
			System.out.println("Inserisci il titolo di studio del Candidato:");
			titoloStudio = getInput();
			System.out.println("Inserisci il titolo di laurea del Candidato:");
			titoloLaurea = getInput();
			System.out.println("Inserisci la data di candidatura del Candidato:");
			dataCandidatura = getInput();
			System.out.println("Inserisci il range della data di Candidatura del Candidato:");
			rangeCandidatura = getInput();
			System.out.println("Ha gia' fatto il colloquio conoscitivo ?");
			colloquioConoscitivo = getBoolean();
			System.out.println("Inserisci la modalita' di candidatura del Candidato:");
			candidatiTramite = getInput();
			System.out.println("Inserisci se l'utente e' idoneo:");
			idoneita = getBoolean();
			System.out.println("Inserisci il codice fiscale del Candidato:");
			codiceFiscale = getInput();
			System.out.println("Inserisci l'usertype del Candidato:");
			userType = getInput();
			System.out.println("Inserisci l'id del Candidato che intendi aggiornare:");
			idCandidati = getInt();
		
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
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
