package bll;

import java.util.List;

import bo.Note;
import dal.NoteDAO;

public class NoteManager {

	public static List<Note> selectAll() {
		return NoteDAO.selectAll();
	}
	
	public static Note getNoteById(int id) {
		return NoteDAO.selectById(id);
	}
	
	public static void insertNote(Note note) {
		NoteDAO.insertNote(note);
	}
	
	public static Note deleteNote(int id) {
		return NoteDAO.deleteById(id);
	}
}
