package modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterateur<T> implements Iterator<T> {
	private ResultSet resultSet;
	private DaoModele<T> daoModele;
	private T currentInstance;
	private boolean hasNext;

	// Constructeur
	public Iterateur(ResultSet resultSet, DaoModele<T> daoModele) {
		this.resultSet = resultSet;
		this.daoModele = daoModele;
		moveToNext(); // Move to the first element in the constructor
	}

	// Méthode hasNext
	@Override
	public boolean hasNext() {
		return hasNext;
	}

	// Méthode next
	@Override
	public T next() {
		if (!hasNext) {
			throw new NoSuchElementException();
		}//ok

		T nextInstance = currentInstance; // Store the current instance
		moveToNext(); // Move to the next element

		return nextInstance;
	}

	// Méthode privée pour déplacer le curseur vers l'élément suivant
	private void moveToNext() {
		try {
			// Try to move to the next element
			hasNext = resultSet.next();

			// If there is a next element, create the corresponding instance using daoModele
			if (hasNext) {
				currentInstance = daoModele.creerInstance(resultSet);
			}
		} catch (SQLException e) {
			// Handle SQLException, you may choose to throw a runtime exception or handle it differently
			e.printStackTrace();
			hasNext = false;
		}
	}
}
