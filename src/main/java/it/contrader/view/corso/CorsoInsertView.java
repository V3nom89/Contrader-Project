package it.contrader.view.corso;

import it.contrader.controller.Request;
import it.contrader.dao.CorsoDAO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CorsoInsertView extends AbstractView{

	private Request request;
	
	private int idCorso;
	private int idCandidato;
	private int idIterSelettivo;
	private String argomentoCorso;
	private int valutazioneComunicazioni;
	private int valutazioneIntuitivita;
	private int valutazioneAttitudine;
	private int valutazioneTeamWork;
	private int oreTotali;
	private int idStaff;
	private String dataInizio;

	private final String mode = "INSERT";

	public CorsoInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Corso", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell'utente da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci l'id del Corso:");
			idCorso = getInt();
			System.out.println("Inserisci l'id del Candidato:");
			idCandidato = getInt();
			System.out.println("Inserisci l'id dell'Iter Selettivo:");
			idIterSelettivo = getInt();
			System.out.println("Inserisci l'argomentoCorso del corso:");
			argomentoCorso = getInput();
			System.out.println("Inserisci la valutazione delle Comunicazioni dell'utente:");
			valutazioneComunicazioni = getInt();
			System.out.println("Inserisci la valutazione dell'Intuitivita dell'utente:");
			valutazioneIntuitivita = getInt();
			System.out.println("Inserisci la valutazione dell'Attitudine dell'utente:");
			valutazioneAttitudine = getInt();
			System.out.println("Inserisci la valutazione del TeamWork dell'utente:");
			valutazioneTeamWork = getInt();
			System.out.println("Inserisci le ore Totali del corso:");
			oreTotali = getInt();
			System.out.println("Inserisci l'id dello Staff che segue il corso:");
			idStaff = getInt();
			System.out.println("Inserisci la data dell'Inizio del corso:");
			dataInizio= getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		
		
		request.put(CorsoDAO.CONST.ID_STAFF, idCorso);
		request.put(CorsoDAO.CONST.ID_CANDIDATO, idCandidato);
		request.put(CorsoDAO.CONST.ID_ITERSELETTIVO, idIterSelettivo);
		request.put(CorsoDAO.CONST.ARGOMENTO_CORSO, argomentoCorso);
		request.put(CorsoDAO.CONST.VALUTAZIONE_COMUNICAZIONI, valutazioneComunicazioni);
		request.put(CorsoDAO.CONST.VALUTAZIONE_INTUITIVITA, valutazioneIntuitivita);
		request.put(CorsoDAO.CONST.VALUTAZIONE_ATTITUDINE, valutazioneAttitudine);
		request.put(CorsoDAO.CONST.VALUTAZIONE_TEAMWORK, valutazioneTeamWork);
		request.put(CorsoDAO.CONST.ORETOTALI, oreTotali);
		request.put(CorsoDAO.CONST.ID_STAFF, idStaff);
		request.put(CorsoDAO.CONST.DATA_INIZIO, dataInizio);


		request.put("mode", mode);
		
		MainDispatcher.getInstance().callAction("Corso", "doControl", request);
	}

}
