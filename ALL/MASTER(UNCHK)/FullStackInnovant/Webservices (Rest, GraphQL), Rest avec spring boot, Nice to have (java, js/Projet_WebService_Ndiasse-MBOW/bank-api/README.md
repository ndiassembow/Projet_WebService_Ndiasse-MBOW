Banque API
Description
Ce projet fournit une API RESTful pour la gestion des comptes bancaires. Les fonctionnalités incluent la consultation du solde du compte, l'historique des transactions et l'exécution de virements. L'API est documentée et testable via Swagger.

Fonctionnalités
Consultation du solde du compte
GET /accounts/{accountId}/balance
Récupère le solde d'un compte bancaire spécifié.

Historique des transactions
GET /accounts/{accountId}/transactions
Récupère l'historique des transactions pour un compte bancaire spécifié. La pagination est supportée.

Effectuer un virement
POST /accounts/{accountId}/transfer
Permet de transférer des fonds entre comptes.

Prérequis
Java JDK 17 ou supérieur
Maven
Node.js et NPM (si des outils front-end sont nécessaires)
IDE (comme IntelliJ IDEA, Eclipse, VS Code)
