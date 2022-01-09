package dal;

import java.util.List;

import javax.persistence.RollbackException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import bo.Note;

public class NoteDAO {
	//private static List<Note> notes;
	private static Session session;
	static {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml")
				.build();
Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
SessionFactory factory = meta.getSessionFactoryBuilder().build();
session = factory.openSession();
	}

	public static void insertNote(Note note) {
		Transaction t = session.beginTransaction();
		try {
			session.save(note);
			session.flush();
			t.commit();
		} catch (RollbackException rbe) {
			t.rollback();
			System.err.println(rbe.getMessage());
		}
	}

	public static List<Note> selectAll() {
		return session.createQuery("from " + Note.class.getSimpleName(), Note.class).list();
	}

	public static Note selectById(int id) {
		return session.find(Note.class, id);
	}

	public static Note deleteById(int id) {
		Transaction t = session.beginTransaction();
		try {
			Note note = selectById(id);
			session.delete(note); // inserer

			session.flush(); //
			t.commit();
			return note;

		} catch (RollbackException rbe) {
			t.rollback();
			System.out.println(rbe.getMessage());
			return null;
		}

	}

	public static boolean update(Note note) {

		Transaction t = session.beginTransaction();
		try {
			session.update(note); // inserer
			session.flush(); //
			t.commit();

		} catch (RollbackException rbe) {
			t.rollback();
			System.out.println(rbe.getMessage());
			return false;
		}
		return true;

	}
}