# 📄 Signature électronique simplifiée avec QR Code  

## 🚀 Fonctionnalités  
✅ Génération d'un QR Code avec UUID unique  
✅ Signature électronique avec date  
✅ Vérification du document (limite: 5 fois)  
✅ Expiration après 1 an  

## 📌 Endpoints API  
| Méthode | Endpoint                     | Description                          |
|---------|-----------------------------|--------------------------------------|
| `POST`  | `/documents?nom=X&prenom=Y` | Crée un document + QR Code          |
| `POST`  | `/documents/{uuid}/sign`    | Signe un document                   |
| `GET`   | `/documents/{uuid}`         | Vérifie un document                 |

## 🔧 Technologies  
- **Spring Boot 3**  
- **H2 Database** (pour le stockage)  
- **ZXing** (génération QR Code)  

## 🛠️ Comment lancer le projet ?  
1. Cloner le dépôt :  
   ```bash
   git clone https://github.com/votre-utilisateur/signature-qr-code.git
