package it.contrader.dto;

public class IterSelettivoDTO {
	
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
	
	public IterSelettivoDTO() { //costruttore vuoto
		
	}
	


	public IterSelettivoDTO(int idIterSelettivo, int idCandidato, int idStaff, int punteggioTotaleScritto,
			int punteggioLogica, int punteggioPhp, int punteggioJava, int punteggioHTML, 
			int punteggioInglese, String dataTestScritto, String dataTestOrale, int vautazioneOrale) {
		
		this.setIdIterSelettivo(idIterSelettivo);
		this.setIdCandidato(idCandidato);
		this.setIdStaff(idStaff);
		this.setPunteggioTotaleScritto(punteggioTotaleScritto);
		this.setPunteggioLogica(punteggioLogica);
		this.setPunteggioPhp(punteggioPhp);
		this.setPunteggioJava(punteggioJava);
		this.setPunteggioHTML(punteggioHTML);
		this.setPunteggioInglese(punteggioInglese);
		this.setDataTestScritto(dataTestScritto);
		this.setDataTestOrale(dataTestOrale);
		this.setValutazioneOrale(vautazioneOrale);
	}
	
	public IterSelettivoDTO(int idCandidato, int idStaff, int punteggioTotaleScritto,
			int punteggioLogica, int punteggioPhp, int punteggioJava, int punteggioHTML, 
			int punteggioInglese, String dataTestScritto, String dataTestOrale, int vautazioneOrale) {
		
		this.setIdCandidato(idCandidato);
		this.setIdStaff(idStaff);
		this.setPunteggioTotaleScritto(punteggioTotaleScritto);
		this.setPunteggioLogica(punteggioLogica);
		this.setPunteggioPhp(punteggioPhp);
		this.setPunteggioJava(punteggioJava);
		this.setPunteggioHTML(punteggioHTML);
		this.setPunteggioInglese(punteggioInglese);
		this.setDataTestScritto(dataTestScritto);
		this.setDataTestOrale(dataTestOrale);
		this.setValutazioneOrale(vautazioneOrale);
	}

	public int getIdIterSelettivo() {
		return idIterSelettivo;
	}

	public void setIdIterSelettivo(int idIterSelettivo) {
		this.idIterSelettivo = idIterSelettivo;
	}

	public int getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}
	
	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public int getPunteggioTotaleScritto() {
		return punteggioTotaleScritto;
	}

	public void setPunteggioTotaleScritto(int punteggioTotaleScritto) {
		this.punteggioTotaleScritto = punteggioTotaleScritto;
	}

	public int getPunteggioLogica() {
		return punteggioLogica;
	}

	public void setPunteggioLogica(int punteggioLogica) {
		this.punteggioLogica = punteggioLogica;
	}

	public int getPunteggioPhp() {
		return punteggioPhp;
	}

	public void setPunteggioPhp(int punteggioPhp) {
		this.punteggioPhp = punteggioPhp;
	}

	public int getPunteggioJava() {
		return punteggioJava;
	}

	public void setPunteggioJava(int punteggioJava) {
		this.punteggioJava = punteggioJava;
	}

	public int getPunteggioHTML() {
		return punteggioHTML;
	}

	public void setPunteggioHTML(int punteggioHTML) {
		this.punteggioHTML = punteggioHTML;
	}

	public int getPunteggioInglese() {
		return punteggioInglese;
	}

	public void setPunteggioInglese(int punteggioInglese) {
		this.punteggioInglese = punteggioInglese;
	}

	public String getDataTestScritto() {
		return dataTestScritto;
	}

	public void setDataTestScritto(String dataTestScritto) {
		this.dataTestScritto = dataTestScritto;
	}

	public String getDataTestOrale() {
		return dataTestOrale;
	}

	public void setDataTestOrale(String dataTestOrale) {
		this.dataTestOrale = dataTestOrale;
	}

	public int getValutazioneOrale() {
		return valutazioneOrale;
	}

	public void setValutazioneOrale(int valutazioneOrale) {
		this.valutazioneOrale = valutazioneOrale;
	}

	@Override
	public String toString() {
		return  idIterSelettivo + "\t" + idCandidato + "\t"
				+ idStaff + "\t" + punteggioTotaleScritto + "\t"
				+ punteggioLogica + "\t" + punteggioPhp + "\t" + punteggioJava
				+ "\t" + punteggioHTML + "\t" + punteggioInglese + "\t"
				+ dataTestScritto + "\t" + dataTestOrale + "\t" + valutazioneOrale;
	}

	


}
