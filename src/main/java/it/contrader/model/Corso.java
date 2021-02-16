package it.contrader.model;


public class Corso {

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
		
		
		
		public Corso(int idCorso, int idCandidato, int idIterSelettivo,String argomentoCorso,int valutazioneComunicazioni,int valutazioneIntuitivita, int valutazioneAttitudine, int valutazioneTeamWork, int oreTotali, int idStaff, String dataInizio) {
			this.setIdCorso(idCorso);
			this.setIdCandidato(idCandidato);
			this.setidIterSelettivo(idIterSelettivo);
			this.setArgomentoCorso(argomentoCorso);
			this.setValutazioneComunicazioni(valutazioneComunicazioni);
			this.setValutazioneIntuitivita(valutazioneIntuitivita);
			this.setValutazioneAttitudine(valutazioneAttitudine);
			this.setValutazioneTeamWork(valutazioneTeamWork);
			this.setOreTotali(oreTotali);
			this.setIdStaff(idStaff);
			this.setDataInizio(dataInizio);
			
		}
		
		public int getIdIterSelettivo() {
			return idIterSelettivo;
		}

		public void setIdIterSelettivo(int idIterSelettivo) {
			this.idIterSelettivo = idIterSelettivo;
		}

		public int getIdStaff() {
			return idStaff;
		}

		public void setIdStaff(int idStaff) {
			this.idStaff = idStaff;
		}

		
		public String getDataInizio() {
			return dataInizio;
		}

		public void setDataInizio(String dataInizio) {
			this.dataInizio = dataInizio;
		}

		public int getIdCorso() {
			return idCorso;
		}
		public void setIdCorso(int idCorso) {
			this.idCorso = idCorso;
		}
		public int getIdCandidato() {
			return idCandidato;
		}
		public void setIdCandidato(int idCandidato) {
			this.idCandidato = idCandidato;
		}
		
		public int getidIterSelettivo() {
			return idIterSelettivo;
		}
		public void setidIterSelettivo(int idIterSelettivo) {
			this.idIterSelettivo = idIterSelettivo;
		}
		public String getArgomentoCorso() {
			return argomentoCorso;
		}
		public void setArgomentoCorso(String argomentoCorso) {
			this.argomentoCorso = argomentoCorso;
		}
		public int getValutazioneComunicazioni() {
			return valutazioneComunicazioni;
		}
		public void setValutazioneComunicazioni(int valutazioneComunicazioni) {
			this.valutazioneComunicazioni = valutazioneComunicazioni;
		}
		public int getValutazioneIntuitivita() {
			return valutazioneIntuitivita;
		}
		public void setValutazioneIntuitivita(int valutazioneIntuitivita) {
			this.valutazioneIntuitivita = valutazioneIntuitivita;
		}
		public int getValutazioneAttitudine() {
			return valutazioneAttitudine;
		}
		public void setValutazioneAttitudine(int valutazioneAttitudine) {
			this.valutazioneAttitudine = valutazioneAttitudine;
		}
		public int getValutazioneTeamWork() {
			return valutazioneTeamWork;
		}
		public void setValutazioneTeamWork(int valutazioneTeamWork) {
			this.valutazioneTeamWork = valutazioneTeamWork;
		}
		public int getOreTotali() {
			return oreTotali;
		}
		public void setOreTotali(int oreTotali) {
			this.oreTotali = oreTotali;
		}
		

		

			@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((argomentoCorso == null) ? 0 : argomentoCorso.hashCode());
			result = prime * result + ((dataInizio == null) ? 0 : dataInizio.hashCode());
			result = prime * result + idCandidato;
			result = prime * result + idCorso;
			result = prime * result + idIterSelettivo;
			result = prime * result + idStaff;
			result = prime * result + oreTotali;
			result = prime * result + valutazioneAttitudine;
			result = prime * result + valutazioneComunicazioni;
			result = prime * result + valutazioneIntuitivita;
			result = prime * result + valutazioneTeamWork;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Corso other = (Corso) obj;
			if (argomentoCorso == null) {
				if (other.argomentoCorso != null)
					return false;
			} else if (!argomentoCorso.equals(other.argomentoCorso))
				return false;
			if (dataInizio == null) {
				if (other.dataInizio != null)
					return false;
			} else if (!dataInizio.equals(other.dataInizio))
				return false;
			if (idCandidato != other.idCandidato)
				return false;
			if (idCorso != other.idCorso)
				return false;
			if (idIterSelettivo != other.idIterSelettivo)
				return false;
			
			if (idStaff != other.idStaff)
				return false;
			if (oreTotali != other.oreTotali)
				return false;
			if (valutazioneAttitudine != other.valutazioneAttitudine)
				return false;
			if (valutazioneComunicazioni != other.valutazioneComunicazioni)
				return false;
			if (valutazioneIntuitivita != other.valutazioneIntuitivita)
				return false;
			if (valutazioneTeamWork != other.valutazioneTeamWork)
				return false;
			return true;
		}

			@Override
		public String toString() {
			return "Corso [idCorso=" + idCorso + ", idCandidato=" + idCandidato + ", idIterSelettivo=" + idIterSelettivo + ", argomentoCorso=" + argomentoCorso
					+ ", valutazioneComunicazioni=" + valutazioneComunicazioni + ", valutazioneIntuitivita="
					+ valutazioneIntuitivita + ", valutazioneAttitudine=" + valutazioneAttitudine + ", valutazioneTeamWork="
					+ valutazioneTeamWork + ", oreTotali=" + oreTotali + ", idStaff=" + idStaff + "]";
		}

			
}

