package fakturierung;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Auftrag {
	private String nummer;
	private String titel;

	// Beschreibung
	private String name;
	private LocalDate datum;
	private String artikel;
	private String arbeitNehmer;
	private String beschreibung;

	private boolean datumAngefragt;
	private boolean datumGeanwtortet;
	private boolean erledigt;

	public Auftrag(String nummer, String titel, String name, String datum, String artikel, String arbeitNehmer,
			String beschreibung) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		this.nummer = nummer;
		this.titel = titel;
		this.name = name;
		this.datum = LocalDate.parse(datum, formatter);
		this.artikel = artikel;
		this.arbeitNehmer = arbeitNehmer;
		this.beschreibung = beschreibung;
	}

	public Auftrag(String[] auftragArray) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

		this.nummer = auftragArray[0];
		this.titel = auftragArray[1];
		this.name = auftragArray[2];
		this.datum = LocalDate.parse(auftragArray[3], formatter);
		this.artikel = auftragArray[4];
		this.arbeitNehmer = auftragArray[5];
		this.beschreibung = auftragArray[6];
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public String getArtikel() {
		return artikel;
	}

	public void setArtikel(String artikel) {
		this.artikel = artikel;
	}

	public String getArbeitNehmer() {
		return arbeitNehmer;
	}

	public void setArbeitNehmer(String arbeitNehmer) {
		this.arbeitNehmer = arbeitNehmer;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public boolean isDatumAngefragt() {
		return datumAngefragt;
	}

	public void setDatumAngefragt(boolean datumAngefragt) {
		this.datumAngefragt = datumAngefragt;
	}

	public boolean isDatumGeanwtortet() {
		return datumGeanwtortet;
	}

	public void setDatumGeanwtortet(boolean datumGeanwtortet) {
		this.datumGeanwtortet = datumGeanwtortet;
	}

	public boolean isErledigt() {
		return erledigt;
	}

	public void setErledigt(boolean erledigt) {
		this.erledigt = erledigt;
	}

}
