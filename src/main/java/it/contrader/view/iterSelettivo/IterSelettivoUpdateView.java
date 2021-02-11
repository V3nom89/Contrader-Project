package it.contrader.view.iterSelettivo;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class IterSelettivoUpdateView extends AbstractView {
	
	private Request request;
	
	private int idIterSelettivo;
	private int idCandidato;
	private int idStaff;
	private int punteggioTotaleScritto;
	private int punteggioLogica;
	private int punteggioPhp;
	private int punteggioJava;
	private int punteggioHTML;
	private int punteggioInglese;
	private String dataTestScritto;
	private String dataTestOrale;
	private int valutazioneOrale;
	
	private final String mode = "UPDATE";
	
	public IterSelettivoUpdateView() {
	}
	
	/*
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("IterSelettivo", null);
		}
	}
	
	/*
	 * Chiede all'utente di inserire gli attributi dell'iter selettivo da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dell'iter selettivo:");
			idIterSelettivo = Integer.parseInt(getInput());
			System.out.println("Inserisci id del candidato:");
			idCandidato = Integer.parseInt(getInput());
			System.out.println("Inserisci id del membro dello staff che segue l'iter selettivo:");
			idStaff = Integer.parseInt(getInput());
			System.out.println("Inserisci il punteggio totale della prova scritta del candidato:");
			punteggioTotaleScritto = Integer.parseInt(getInput());
			System.out.println("Inserisci il punteggio della parte di logica nella prova scritta del candidato:");
			punteggioLogica = Integer.parseInt(getInput());
			System.out.println("Inserisci il punteggio della parte di Php nella prova scritta del candidato:");
			punteggioPhp = Integer.parseInt(getInput());
			System.out.println("Inserisci il punteggio della parte di Java nella prova scritta del candidato:");
			punteggioJava = Integer.parseInt(getInput());
			System.out.println("Inserisci il punteggio della parte di HTML nella prova scritta del candidato:");
			punteggioLogica = Integer.parseInt(getInput());
			System.out.println("Inserisci il punteggio della parte di inglese nella prova scritta del candidato:");
			punteggioLogica = Integer.parseInt(getInput());
			System.out.println("Inserisci la data del test scritto:");
			dataTestScritto = getInput();
			System.out.println("Inserisci la data del colloquio orale:");
			dataTestOrale = getInput();
			System.out.println("Inserisci il punteggio della valutazione del colloquio orale del candidato:");
			punteggioLogica = Integer.parseInt(getInput());
		} catch (Exception e) {

		}
	}
	
	/*
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idIterSelettivo", idIterSelettivo);
		request.put("idCandidato", idCandidato);
		request.put("idStaff", idStaff);
		request.put("punteggioTotaleScritto", punteggioTotaleScritto);
		request.put("punteggioLogica", punteggioLogica);
		request.put("punteggioPhp", punteggioPhp);
		request.put("punteggioJava", punteggioJava);
		request.put("punteggioHTML", punteggioHTML);
		request.put("punteggioInglese", punteggioInglese);
		request.put("dataTestScritto", dataTestScritto);
		request.put("dataTestOrale", dataTestOrale);
		request.put("valutazioneOrale", valutazioneOrale);
		
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("IterSelettivo", "doControl", request);
	}

	
//end
}