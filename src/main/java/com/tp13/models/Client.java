package com.tp13.models;

//DTO

public class Client {

	private long  id;
	private String  nom;
	private String prenom;
	
	public Client() { }
	
	public Client(String nom,String prenom) { 
		this.nom=nom;
		this.setPrenom(prenom);
		
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}