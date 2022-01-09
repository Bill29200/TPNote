package dal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bo.Note;

public class NoteDAO {
	private static List<Note> notes;
	
	static {
		notes = new ArrayList<Note>();
		notes.add(new Note("Une super note", LocalDateTime.of(2021, 12, 15, 10, 0)));
		notes.add(new Note("Une incroyable note", LocalDateTime.of(2021, 12, 25, 22, 30)));
		notes.add(new Note("Une fantastique note", LocalDateTime.of(2022, 1, 5, 8, 15)));
		notes.add(new Note("Une bete note", LocalDateTime.of(2020, 1, 5, 8, 15)));
		notes.add(new Note("Rendez-vous medecin",LocalDateTime.now()));

	}
	
	public static void insertNote(Note note) {
		notes.add(note);
	}
	
	public static List<Note> selectAll() {
		Collections.sort(notes);
		return notes;
	}
	
	public static Note selectById(int id) {
		for (int i = 0; i < notes.size(); i++) {
			if ( notes.get(i).getId()==id ) {
				Note note=notes.get(i);
				return note;
			}
		}
		return null;
	}
	
	public static Note deleteById(int id) {
		
		for (int i = 0; i < notes.size(); i++) {
			if ( notes.get(i).getId()==id ) {
				Note note=notes.get(i);
				notes.remove(i);
				return note;
			}
		}
		return null;
	}
}
