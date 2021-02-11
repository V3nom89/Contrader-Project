package it.contrader.view.candidati;

import it.contrader.controller.Request;
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
	private int numero_telefono;
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
			System.out.println("Inserisci idCandidati dell'utente:");
			idCandidati = getInt();
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
			numero_telefono = getInt();
			System.out.println("Inserisci titoloStudio dell'utente:");
			titoloStudio = getInput();
			System.out.println("Inserisci titoloLaurea dell'utente:");
			titoloLaurea = getInput();
			System.out.println("Inserisci dataCandidatura dell'utente:");
			dataCandidatura = getInput();
			System.out.println("Inserisci rangeCandidatura dell'utente:");
			rangeCandidatura = getInput();
			System.out.println("Ha già fatto il colloquio conoscitivo ?");
			colloquioConoscitivo = getBoolean();
			System.out.println("Inserisci la modalità di candidatura dell'utente:");
			candidatiTramite = getInput();
			System.out.println("Inserisci se l'utente è idoneo:");
			idoneita = getBoolean();
			System.out.println("Inserisci codice fiscale dell'utente:");
			codiceFiscale = getInput();
			System.out.println("Inserisci usertype dell'utente:");
			rangeCandidatura = getInput();
		
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idCandidati", idCandidati);
		request.put("idStaff", idStaff);
		request.put("nome", nome);
		request.put("cognome", cognome);
		request.put("email", email);
		request.put("luogoProvenienza", luogoProvenienza);
		request.put("numero_telefono", numero_telefono);
		request.put("titoloStudio", titoloStudio);
		request.put("titoloLaurea", titoloLaurea);
		request.put("dataCandidatura", dataCandidatura);
		request.put("rangeCandidatura", rangeCandidatura);
		request.put("colloquioConoscitivo", colloquioConoscitivo);
		request.put("candidatiTramite", candidatiTramite);
		request.put("idoneita", idoneita);
		request.put("codiceFiscale", codiceFiscale);
		request.put("usertype", userType);

		request.put("mode", mode);
		

		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Candidati", "doControl", request);
	}

	
	


}
