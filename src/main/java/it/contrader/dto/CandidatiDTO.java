package it.contrader.dto;


public class CandidatiDTO{
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
	
	public CandidatiDTO() {
		
	}
	
	public CandidatiDTO(int idCandidati,int idStaff,String nome,String cognome,String email,String luogoProvenienza,int numeroTelefono,String titoloStudio,String titoloLaurea,String dataCandidatura, String rangeCandidatura,boolean colloquioConoscitivo,String candidatiTramite,boolean idoneita,String codiceFiscale, String userType ) {
		
		this.setIdCandidati(idCandidati);
		this.setIdStaff(idStaff);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setEmail(email);
		this.setLuogoProvenienza(luogoProvenienza);
		this.setNumeroTelefono(numeroTelefono);
		this.setTitoloStudio(titoloStudio);
		this.setTitoloLaurea(titoloLaurea);
		this.setDataCandidatura(dataCandidatura);
		this.setRangeCandidatura(rangeCandidatura);
		this.setColloquioConoscitivo (colloquioConoscitivo);
		this.setCandidatiTramite(candidatiTramite);
		this.setIdoneita(idoneita);
		this.setCodiceFiscale(codiceFiscale);
		this.setUserType  (userType);
		
	}
	
	public CandidatiDTO(int idStaff,String nome,String cognome,String email,String luogoProvenienza,int numeroTelefono,String titoloStudio,String titoloLaurea,String dataCandidatura, String rangeCandidatura,boolean colloquioConoscitivo,String candidatiTramite,boolean idoneita,String codiceFiscale, String userType ) {
	
		this.setIdStaff(idStaff);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setEmail(email);
		this.setLuogoProvenienza(luogoProvenienza);
		this.setNumeroTelefono(numeroTelefono);
		this.setTitoloStudio(titoloStudio);
		this.setTitoloLaurea(titoloLaurea);
		this.setDataCandidatura(dataCandidatura);
		this.setRangeCandidatura(rangeCandidatura);
		this.setColloquioConoscitivo (colloquioConoscitivo);
		this.setCandidatiTramite(candidatiTramite);
		this.setIdoneita(idoneita);
		this.setCodiceFiscale(codiceFiscale);
		this.setUserType  (userType);
	
	}
	
	

	
	
	public int getIdCandidati() {
	return idCandidati;
	}

	public void setIdCandidati(int idCandidati) {
	this.idCandidati = idCandidati;
	}

	public int getIdStaff() {
	return idStaff;
	}

	public void setIdStaff(int idStaff) {
	this.idStaff = idStaff;
	}

	public String getNome() {
	return nome;
	}

	public void setNome(String nome) {
	this.nome = nome;
	}

	public String getCognome() {
	return cognome;
	}

	public void setCognome(String cognome) {
	this.cognome = cognome;
	}

	public String getEmail() {
	return email;
	}

	public void setEmail(String email) {
	this.email = email;
	}

	public String getLuogoProvenienza() {
	return luogoProvenienza;
	}

	public void setLuogoProvenienza(String luogoProvenienza) {
	this.luogoProvenienza = luogoProvenienza;
	}

	public int getNumeroTelefono() {
	return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
	this.numeroTelefono = numeroTelefono;
	}

	public String getTitoloStudio() {
	return titoloStudio;
	}

	public void setTitoloStudio(String titoloStudio) {
	this.titoloStudio = titoloStudio;
	}

	public String getTitoloLaurea() {
	return titoloLaurea;
	}
	
	public void setTitoloLaurea(String titoloLaurea) {
	this.titoloLaurea = titoloLaurea;
	}

	public String getDataCandidatura() {
	return dataCandidatura;
	}

	public void setDataCandidatura(String dataCandidatura) {
	this.dataCandidatura = dataCandidatura;
	}

	public String getRangeCandidatura() {
	return rangeCandidatura;
	}

	public void setRangeCandidatura(String rangeCandidatura) {
	this.rangeCandidatura = rangeCandidatura;
	}

	public boolean isColloquioConoscitivo() {
	return colloquioConoscitivo;
	}

	public void setColloquioConoscitivo(boolean colloquioConoscitivo) {
	this.colloquioConoscitivo = colloquioConoscitivo;
	}

	public String getCandidatiTramite() {
	return candidatiTramite;
	}

	public void setCandidatiTramite(String candidatiTramite) {
	this.candidatiTramite = candidatiTramite;
	}

	public boolean isIdoneita() {
	return idoneita;
	}

	public void setIdoneita(boolean idoneita) {
	this.idoneita = idoneita;
	}

	public String getCodiceFiscale() {
	return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
	this.codiceFiscale = codiceFiscale;
	}

	public String getUserType() {
	return userType;
	}

	public void setUserType(String userType) {
	this.userType = userType;
	}

	
	
	@Override
	public String toString() {
		return idCandidati + "\t" + idStaff + "\t" + nome + "\t"
				+ cognome + "\t" + email + "\t" + luogoProvenienza + "\t"
				+ numeroTelefono + "\t" + titoloStudio + "\t" + titoloLaurea
				+ "\t" + dataCandidatura + "\t" + rangeCandidatura
				+ "\t" + colloquioConoscitivo + "\t" + candidatiTramite
				+ "\t" + idoneita + "\t" + codiceFiscale + "\t" + userType;
	}

	
	
	
}
