package rest;

import java.time.LocalDateTime;

import bll.NoteManager;
import bo.Note;

public class TestMain {

	public static void main(String[] args) {

		Note n1=new Note("Rendez-vous medecin",LocalDateTime.now());
		Note n2=new Note("Rendez-vous President",LocalDateTime.of(2020, 1, 1, 1, 1));
		NoteManager.insertNote(n1);
		System.out.println(n1+"\n"+n2);
	}

}
