package co.simplon.dao;

import java.sql.Connection;

public abstract class DAO<T> {
	

		public Connection connection = BankConnection.getInstance();
		
		/**
		 * Permet de récupérer un objet via son ID
		 * @param id
		 * @return
		 */
		public abstract T find(int id);
		
		/**
		 * Permet de créer une entrée dans la base de données
		 * par rapport à un objet
		 * @param obj
		 */
		public abstract boolean create(T obj);
		
		/**
		 * Permet de mettre à jour les données d'une entrée dans la base 
		 * @param obj
		 */
		public abstract boolean update(T obj);
		
		/**
		 * Permet la suppression d'une entrée de la base
		 * @param obj
		 */
		public abstract boolean delete(T obj);
	}

