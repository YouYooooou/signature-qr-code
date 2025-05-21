package com.example.signatureQR.service;

import com.example.signatureQR.model.Document;
import com.example.signatureQR.repository.DocumentRepository;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository repo;

    public Document create(String nom, String prenom) {
        Document doc = new Document();
        doc.setUuid(UUID.randomUUID().toString()); 
        doc.setNom(nom);
        doc.setPrenom(prenom);
        return repo.save(doc); 
    }

    public byte[] generateQRCode(String uuid) throws Exception {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix matrix = writer.encode(uuid, BarcodeFormat.QR_CODE, 250, 250);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, "PNG", stream); 
        return stream.toByteArray(); 
    }

  
    public Document sign(String uuid) {
        Document doc = repo.findById(uuid).orElseThrow(); 
        doc.setDateSignature(LocalDateTime.now()); 
        return repo.save(doc); 
    }

 
    public Document verify(String uuid) {
        Document doc = repo.findById(uuid).orElseThrow();
        doc.setVerificationCnt(doc.getVerificationCnt() + 1); 
        return repo.save(doc); 
    }
}
