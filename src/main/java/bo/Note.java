package bo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="notes")
public class Note{
	@Id @Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="note")
	private String note;
	
	@Column(name="date_de_creation")
	private LocalDateTime dateDeCreation;
	
	public Note() {}	
	public Note(String note, LocalDateTime dateDeCreation) {
		this.note = note;
		this.dateDeCreation = dateDeCreation;
	}
	
	public int getId() {
		return id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public LocalDateTime getDateDeCreation() {
		return dateDeCreation;
	}
	public void setDateDeCreation(LocalDateTime dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", note=" + note + ", dateDeCreation=" + dateDeCreation.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)) + "]";
	}

	
	
}
