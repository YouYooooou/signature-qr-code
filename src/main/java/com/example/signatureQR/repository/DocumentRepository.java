package com.example.signatureQR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.signatureQR.model.Document;

public interface DocumentRepository extends JpaRepository<Document, String> {
}
