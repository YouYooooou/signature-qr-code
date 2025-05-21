# Signature électronique simplifiée avec QR Code  

## Fonctionnalités  
✅ Génération d'un QR Code avec UUID unique  
✅ Signature électronique avec date  
✅ Vérification du document (limite: 5 fois)  
✅ Expiration après 1 an  

##  Endpoints API  
| Méthode | Endpoint                     | Description                          |
|---------|-----------------------------|--------------------------------------|
| `POST`  | `/documents?nom=X&prenom=Y` | Crée un document + QR Code          |
| `POST`  | `/documents/{uuid}/sign`    | Signe un document                   |
| `GET`   | `/documents/{uuid}`         | Vérifie un document                 |

##  Architecture des Classes
| Classe/Rôle | Responsabilité | Mécanisme Clé |
|-------------|----------------|---------------|
| **`Document`** (Modèle) | Stocke les données du document | JPA/H2 - UUID généré automatiquement |
| **`DocumentController`** | Gère les requêtes HTTP | Routes Spring - Valide les entrées |
| **`DocumentService`** | Logique métier | Génère QR (ZXing), gère signatures/vérifications |
| **`DocumentRepository`** | Accès base de données | JpaRepository - Sauvegarde/charge les documents |

##  Technologies  
- **Spring Boot 3** (API REST)  
- **H2 Database** (stockage en mémoire)  
- **ZXing** (génération QR Code)  

## 🛠Comment lancer le projet ?  
```bash
git clone https://github.com/votre-utilisateur/signature-qr-code.git
cd signature-qr-code
mvn spring-boot:run
