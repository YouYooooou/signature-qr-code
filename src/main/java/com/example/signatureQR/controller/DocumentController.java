package com.example.signatureQR.controller;
import org.springframework.http.MediaType;
import com.example.signatureQR.model.Document;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.signatureQR.service.DocumentService;

@RestController
@RequestMapping("/documents") 
public class DocumentController {

    @Autowired
    private DocumentService service;

    @PostMapping
    public ResponseEntity<byte[]> create(@RequestParam String nom, @RequestParam String prenom) throws Exception {
        Document doc = service.create(nom, prenom); // crée et enregistre
        byte[] image = service.generateQRCode(doc.getUuid()); // génère le QR
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image); // retourne l’image PNG
    }

    @PostMapping("/{uuid}/sign")
    public ResponseEntity<Document> sign(@PathVariable String uuid) {
        return ResponseEntity.ok(service.sign(uuid)); // signe et retourne le document
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Map<String, Object>> verify(@PathVariable String uuid) {
        Document doc = service.verify(uuid); // vérifie + incrémente

        Map<String, Object> result = new HashMap<>();
        result.put("nom", doc.getNom());
        result.put("prenom", doc.getPrenom());
        result.put("dateSignature", doc.getDateSignature());
        result.put("expiration", doc.getDateSignature() != null &&
        doc.getDateSignature().isBefore(LocalDateTime.now().minusYears(1))); // si signé depuis + d'un an
        result.put("verifications", doc.getVerificationCnt());
        return ResponseEntity.ok(result);
    }
}

