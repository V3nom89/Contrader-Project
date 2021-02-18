package it.contrader.model;

public class Candidati {

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
	
	
	public Candidati( ) {
		
	}
		
	public Candidati(int idCandidati,int idStaff,String nome,String cognome,String email,String luogoProvenienza,int numeroTelefono,String titoloStudio,String titoloLaurea,String dataCandidatura, String rangeCandidatura,boolean colloquioConoscitivo,String candidatiTramite,boolean idoneita,String codiceFiscale, String userType ) {
		
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
	
	public Candidati(int idStaff,String nome,String cognome,String email,String luogoProvenienza,int numeroTelefono,String titoloStudio,String titoloLaurea,String dataCandidatura, String rangeCandidatura,boolean colloquioConoscitivo,String candidatiTramite,boolean idoneita,String codiceFiscale, String userType ) {
		
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidati other = (Candidati) obj;
		if (candidatiTramite == null) {
			if (other.candidatiTramite != null)
				return false;
		} else if (!candidatiTramite.equals(other.candidatiTramite))
			return false;
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (colloquioConoscitivo != other.colloquioConoscitivo)
			return false;
		if (dataCandidatura == null) {
			if (other.dataCandidatura != null)
				return false;
		} else if (!dataCandidatura.equals(other.dataCandidatura))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idCandidati != other.idCandidati)
			return false;
		if (idStaff != other.idStaff)
			return false;
		if (idoneita != other.idoneita)
			return false;
		if (luogoProvenienza == null) {
			if (other.luogoProvenienza != null)
				return false;
		} else if (!luogoProvenienza.equals(other.luogoProvenienza))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroTelefono != other.numeroTelefono)
			return false;
		if (rangeCandidatura == null) {
			if (other.rangeCandidatura != null)
				return false;
		} else if (!rangeCandidatura.equals(other.rangeCandidatura))
			return false;
		if (titoloLaurea == null) {
			if (other.titoloLaurea != null)
				return false;
		} else if (!titoloLaurea.equals(other.titoloLaurea))
			return false;
		if (titoloStudio == null) {
			if (other.titoloStudio != null)
				return false;
		} else if (!titoloStudio.equals(other.titoloStudio))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Candidati [idCandidati=" + idCandidati + ", idStaff=" + idStaff + ", nome=" + nome + ", cognome="
				+ cognome + ", email=" + email + ", luogoProvenienza=" + luogoProvenienza + ", numeroTelefono="
				+ numeroTelefono + ", titoloStudio=" + titoloStudio + ", titoloLaurea=" + titoloLaurea
				+ ", dataCandidatura=" + dataCandidatura + ", rangeCandidatura=" + rangeCandidatura
				+ ", colloquioConoscitivo=" + colloquioConoscitivo + ", candidatiTramite=" + candidatiTramite
				+ ", idoneita=" + idoneita + ", codiceFiscale=" + codiceFiscale + ", userType=" + userType + "]";
	}

}
	
