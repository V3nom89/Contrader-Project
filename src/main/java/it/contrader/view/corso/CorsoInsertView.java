package it.contrader.view.corso;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class CorsoInsertView extends AbstractView{

	private Request request;
	
	private int idCorso;
	private int idCandidato;
	private int idInsegnante;
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
			System.out.println("Inserisci l'id dell'Insegnante:");
			idInsegnante = getInt();
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
			argomentoCorso = getInput();
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idCorso", idCorso);
		request.put("idCandidato", idCandidato);
		request.put("idInsegnante", idInsegnante);
		request.put("idIterSelettivo", idIterSelettivo);
		request.put("argomentoCorso", argomentoCorso);
		request.put("valutazioneComunicazioni", valutazioneComunicazioni);
		request.put("valutazioneIntuitivita", valutazioneIntuitivita);
		request.put("valutazioneAttitudine", valutazioneAttitudine);
		request.put("valutazioneTeamWork", valutazioneTeamWork);
		request.put("oreTotali", oreTotali);
		request.put("idStaff", idStaff);
		request.put("dataInizio", dataInizio);


		request.put("mode", mode);
		
		MainDispatcher.getInstance().callAction("Corso", "doControl", request);
	}

}
