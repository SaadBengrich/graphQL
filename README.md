Banque Service - Microservice Bancaire
📋 Description
Banque Service est une application Spring Boot qui fournit une API GraphQL pour la gestion de comptes bancaires et de transactions financières. L'application utilise une base de données H2 en mémoire et offre une interface GraphiQL pour tester les requêtes.

🚀 Fonctionnalités
Gestion des Comptes
Création et mise à jour de comptes

Consultation des comptes par ID

Liste de tous les comptes

Statistiques sur les soldes (total, moyenne, nombre)

Gestion des Transactions
Ajout de transactions (dépôts, retraits, virements)

Statistiques sur les transactions

Association automatique des transactions aux comptes

Mise à jour automatique des soldes

🛠️ Technologies Utilisées
Spring Boot 3.x

Spring GraphQL - API GraphQL

Spring Data JPA - Persistance des données

H2 Database - Base de données en mémoire

Lombok - Réduction du code boilerplate

Maven - Gestion des dépendances

📁 Structure du Projet
text
src/main/java/com/example/banqueservice/
├── entities/
│   ├── Compte.java          # Entité Compte
│   ├── Transaction.java     # Entité Transaction
│   ├── TypeCompte.java      # Enum types de compte
│   └── TypeTransaction.java # Enum types de transaction
├── repositories/
│   ├── CompteRepository.java
│   └── TransactionRepository.java
├── controllers/
│   └── CompteControllerGraphQL.java
├── dtos/
│   ├── CompteRequest.java
│   └── TransactionRequest.java
└── BanqueServiceApplication.java
⚙️ Configuration
Fichier application.properties
properties
# Server Configuration
server.port=8080

# H2 Database
spring.datasource.url=jdbc:h2:mem:banquedb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

# GraphQL
spring.graphql.graphiql.enabled=true
spring.graphql.schema.printer.enabled=true
🗄️ Schéma GraphQL
Types
graphql
type Compte {
  id: ID!
  solde: Float!
  dateCreation: String!
  type: TypeCompte!
  transactions: [Transaction]!
}

type Transaction {
  id: ID!
  montant: Float!
  date: String!
  type: TypeTransaction!
  compte: Compte!
}

type SoldeStats {
  count: Int!
  sum: Float!
  average: Float!
}

type TransactionStats {
  count: Int!
  sumDepots: Float!
  sumRetraits: Float!
}

enum TypeCompte {
  COURANT
  EPARGNE
}

enum TypeTransaction {
  DEPOT
  RETRAIT
  VIREMENT
}
Queries Disponibles
graphql
# Récupérer tous les comptes
query {
  allComptes {
    id
    solde
    type
    dateCreation
  }
}

# Récupérer un compte par ID
query {
  compteById(id: 1) {
    id
    solde
    transactions {
      id
      montant
      type
    }
  }
}

# Obtenir les statistiques des soldes
query {
  totalSolde {
    count
    sum
    average
  }
}

# Obtenir les statistiques des transactions
query {
  transactionStats {
    count
    sumDepots
    sumRetraits
  }
}
Mutations Disponibles
graphql
# Créer ou mettre à jour un compte
mutation {
  saveCompte(compte: {
    solde: 1000.0
    dateCreation: "2024-01-15"
    type: COURANT
  }) {
    id
    solde
    type
  }
}

# Ajouter une transaction
mutation {
  addTransaction(transactionRequest: {
    compteId: 1
    montant: 500.0
    date: "2024-01-15"
    type: DEPOT
  }) {
    id
    montant
    type
    compte {
      id
      solde
    }
  }
}
<img width="1918" height="1078" alt="gr1" src="https://github.com/user-attachments/assets/d0445169-b377-4aba-ab9e-fcb5424960d6" />
<img width="1918" height="1078" alt="gr3" src="https://github.com/user-attachments/assets/f61eb39f-78ca-43e6-b5cc-7de581579923" />
<img width="1918" height="1078" alt="gr2" src="https://github.com/user-attachments/assets/bd98e01e-0144-47a1-8d8d-0c6d3d28495b" />
<img width="1918" height="1078" alt="image" src="https://github.com/user-attachments/assets/c401a227-d5f5-40b7-a798-4f96196b5496" />
