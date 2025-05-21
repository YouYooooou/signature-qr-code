package com.example.signatureQR.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Document {
	@Id
	private String uuid;
	private String nom, prenom;
	private LocalDateTime dateCreation, dateSignature;
	private int verificationCnt;

	public Document() {
		this.dateCreation = LocalDateTime.now();
		this.verificationCnt = 0;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDateTime getDateSignature() {
		return dateSignature;
	}

	public void setDateSignature(LocalDateTime dateSignature) {
		this.dateSignature = dateSignature;
	}

	public int getVerificationCnt() {
		return verificationCnt;
	}

	public void setVerificationCnt(int verificationCnt) {
		this.verificationCnt = verificationCnt;
	}
}
