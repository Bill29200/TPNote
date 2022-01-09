package rest;

import java.time.LocalDateTime;
import java.util.List;

import bll.NoteManager;
import bo.Note;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("notes")
public class GestionNote {
	
	@GET
	//@Produces(MediaType.APPLICATION_JSON)
	public List<Note> consulterNotes() {
		return NoteManager.selectAll();
	}
	
	@GET @Path("/info")
	public String getInfoNotes() {
		return "Vous etes sur la page de de gestion de notes";
	}
	
	@GET @Path("get/{cle : \\d+}")
	public Note getNoteById(@PathParam("cle") int id) {
		return NoteManager.getNoteById(id);
	}
	
	@POST
	public int insertNote(@FormParam("contenu_note") String contenuNote) {
		Note note=new Note(contenuNote,LocalDateTime.now());
		NoteManager.insertNote(note);
		return 0;
	}
	
	@PUT @Path("/{cle : \\d+}")
	public int modifyNote(	@PathParam("cle") int id,
							@FormParam("contenu_note_modifie") String contenuNote) {
		Note note=NoteManager.getNoteById(id);
		note.setNote(contenuNote);
		return 0;
	}
	
	@DELETE
	@Path("{cle : \\d+}")
	public boolean deleteNote(@PathParam("cle") int id) {
		return (NoteManager.deleteNote(id)!=null);
	}

}
