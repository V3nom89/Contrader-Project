package it.contrader.view.iterSelettivo;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;
import it.contrader.dao.IterSelettivoDAO;

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
			idIterSelettivo = getInt();
			System.out.println("Inserisci id del candidato:");
			idCandidato = getInt();
			System.out.println("Inserisci id del membro dello staff che segue l'iter selettivo:");
			idStaff = getInt();
			System.out.println("Inserisci il punteggio totale della prova scritta del candidato:");
			punteggioTotaleScritto = getInt();
			System.out.println("Inserisci il punteggio della parte di logica nella prova scritta del candidato:");
			punteggioLogica = getInt();
			System.out.println("Inserisci il punteggio della parte di Php nella prova scritta del candidato:");
			punteggioPhp = getInt();
			System.out.println("Inserisci il punteggio della parte di Java nella prova scritta del candidato:");
			punteggioJava = getInt();
			System.out.println("Inserisci il punteggio della parte di HTML nella prova scritta del candidato:");
			punteggioHTML = getInt();
			System.out.println("Inserisci il punteggio della parte di inglese nella prova scritta del candidato:");
			punteggioInglese = getInt();
			System.out.println("Inserisci la data del test scritto:");
			dataTestScritto = getInput();
			System.out.println("Inserisci la data del colloquio orale:");
			dataTestOrale = getInput();
			System.out.println("Inserisci il punteggio della valutazione del colloquio orale del candidato:");
			punteggioLogica = getInt();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	/*
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put(IterSelettivoDAO.CONST.ID_ITER_SELETTIVO, idIterSelettivo);
		request.put(IterSelettivoDAO.CONST.ID_CANDIDATO, idCandidato);
		request.put(IterSelettivoDAO.CONST.ID_STAFF, idStaff);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_TOTALE_SCRITTO, punteggioTotaleScritto);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_LOGICA, punteggioLogica);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_PHP, punteggioPhp);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_JAVA, punteggioJava);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_HTML, punteggioHTML);
		request.put(IterSelettivoDAO.CONST.PUNTEGGIO_INGLESE, punteggioInglese);
		request.put(IterSelettivoDAO.CONST.DATA_TEST_SCRITTO, dataTestScritto);
		request.put(IterSelettivoDAO.CONST.DATA_TEST_ORALE, dataTestOrale);
		request.put(IterSelettivoDAO.CONST.VALUTAZIONE_ORALE, valutazioneOrale);
		
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("IterSelettivo", "doControl", request);
	}

	
//end
}
