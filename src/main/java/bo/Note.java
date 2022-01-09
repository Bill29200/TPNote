package bo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Note implements Comparable<Note> {
	private static int count=1;
	private int id;
	private String note;
	private LocalDateTime dateDeCreation;
	
	public Note(String note, LocalDateTime dateDeCreation) {
		this.id = count++;
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

	@Override
	public int compareTo(Note o) {
		Note autreNote = o;
		return -this.dateDeCreation.compareTo(autreNote.dateDeCreation);
	}
	
	
	
}
