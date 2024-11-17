# Architecture

:heavy_check_mark:_(COMMENT) Add a description of the architecture of your application and create a diagram like the one below. Link to the diagram in this document._

![image](https://github.com/user-attachments/assets/58afc052-12cf-418b-b1ed-f9f52cd68cd2)
# Architectuur van applicatie

## Frontend

### Angular App

De Angular applicatie is als de gebruikersinterface waar gebruikers met het systeem interacten. Het biedt functionaliteiten zoals:

- **Bericht aanmaken**: Gebruikers kunnen berichten schrijven en indienen. De rol van de gebruiker wordt opgenomen in de request headers om rechten te beheren.
- **Berichten ophalen**: Berichten ophalen op basis van filters zoals inhoud, auteur en datum.
- **Bericht bijwerken**: Concepten van berichten bewerken.
- **Berichtdetails opvragen**: Volledige details van een bericht ophalen, inclusief reacties.
- **Opslaan als concept**: Berichten opslaan als concept om later te voltooien of in te dienen.
- **Review indienen**: Reviews voor berichten indienen, inclusief statusupdates en opmerkingen.

### Auth Service

Als onderdeel van de frontend, beheert de Auth Service het rolbeheer van users. Het haalt gebruikersrollen op en stelt deze in, wat cruciaal is voor rolgebaseerde access binnen de applicatie.

---

## Backend

De backend bestaat uit drie hoofdservices, elk verantwoordelijk voor specifieke features. Ze communiceren via directe API-calls en asynchrone berichtgeving met behulp van RabbitMQ.

### Post Service

- **Database**: Maakt gebruik van een Post DB om bericht data op te slaan en te beheren.
- **Verantwoordelijkheden**:
  - Behandelt het creëren, bijwerken en ophalen van berichten.
  - Leest gebruikersrollen uit de request headers om toegangscontroles af te dwingen.
- **Event Publishing**: Publiceert events gerelateerd aan het aanmaken en reviewen van berichten via RabbitMQ om andere services op de hoogte te stellen.

### Review Service

- **Database**: Gebruikt een Review DB om reviewgerelateerde data te beheren.
- **Verantwoordelijkheden**:
  - Verwerkt inzendingen voor berichtreviews.
  - Werkt de status van berichten bij en slaat reviewopmerkingen op.
  - Controleert gebruikersrollen om reviewacties te autoriseren.

### Comment Service

- **Database**: Beheert een Comment DB voor het opslaan van reacties.
- **Verantwoordelijkheden**:
  - Beheert het toevoegen, bewerken, verwijderen en ophalen van reacties op berichten.
  - Leest gebruikersrollen uit de headers om permissies te valideren.
- **Event Handling**: Abonneert zich op en verwerkt het "Comment Added" event met behulp van RabbitMQ.

---

## Communicatie

- **API-calls**: Services communiceren met behulp van OpenFeign voor synchrone HTTP-requests, waardoor directe gegevens- en actierequests mogelijk zijn.
- **RabbitMQ**: Gebruikt voor asynchrone communicatie, waarbij events worden afgehandeld die niet onmiddellijke reacties vereisen. Dit verbetert de schaalbaarheid en responsiviteit van het systeem.

---

## Beveiliging

- **Rolgebaseerde Toegangscontrole**: Alle services handhaven rolgebaseerde toegangscontroles door gebruikersrollen uit de HTTP-headers te lezen. Dit verzekert dat gebruikers alleen acties kunnen uitvoeren die zijn toegestaan door hun rollen.
