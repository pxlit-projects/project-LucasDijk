
![image](https://github.com/user-attachments/assets/58afc052-12cf-418b-b1ed-f9f52cd68cd2)
![image (2)](https://github.com/user-attachments/assets/92bffb04-d8d3-4a1f-ba90-92d59032452f)

# Architectuur van de Applicatie

## Frontend

### Angular App

De Angular app is de interface waar gebruikers mee werken. Het biedt functies zoals:

- **Bericht aanmaken**: Gebruikers kunnen berichten schrijven en indienen. De rol van de gebruiker wordt in de request headers gezet om rechten te beheren.
- **Berichten ophalen**: Je kunt berichten filteren op inhoud, auteur en datum.
- **Bericht bijwerken**: Concepten van berichten aanpassen.
- **Berichtdetails opvragen**: Alle details van een bericht, inclusief reacties, ophalen.
- **Opslaan als concept**: Berichten opslaan om later te voltooien of in te dienen.
- **Review indienen**: Reviews voor berichten indienen, met statusupdates en opmerkingen.

### Auth Service

Deze service beheert het rolbeheer van gebruikers. Het haalt rollen op en stelt ze in, wat belangrijk is voor rolgebaseerde toegang binnen de app.

---

## Backend

De backend bestaat uit drie hoofdservices, elk met specifieke verantwoordelijkheden. Ze communiceren via directe API-calls en asynchrone berichtgeving met RabbitMQ.

### Post Service

- **Database**: Gebruikt een Post DB voor opslag en beheer van berichtdata.
- **Verantwoordelijkheden**:
  - Creëren, bijwerken en ophalen van berichten.
  - Leest gebruikersrollen uit de headers voor toegangscontrole.
- **Event Publishing**: Publiceert events over het aanmaken en reviewen van berichten via RabbitMQ.

### Review Service

- **Database**: Maakt gebruik van een Review DB voor reviewdata.
- **Verantwoordelijkheden**:
  - Verwerken van berichtreviews.
  - Bijwerken van status en opslaan van opmerkingen.
  - Controleert gebruikersrollen om acties te autoriseren.

### Comment Service

- **Database**: Beheert een Comment DB voor reacties.
- **Verantwoordelijkheden**:
  - Toevoegen, bewerken, verwijderen en ophalen van reacties.
  - Leest gebruikersrollen uit de headers om permissies te valideren.
- **Event Handling**: Verwerkt het "Comment Added" event met RabbitMQ.

---

## Communicatie

### Synchronous Communication

- **API-calls**: Services communiceren direct via OpenFeign voor synchrone HTTP-requests. Dit is handig voor operaties die snelle feedback nodig hebben, zoals het ophalen van berichten of reviews.

### Asynchronous Communication

- **RabbitMQ**: Voor asynchrone communicatie gebruiken we RabbitMQ. Dit is handig voor events die niet meteen een reactie nodig hebben, zoals het publiceren van een bericht. Het zorgt ervoor dat services onafhankelijk kunnen werken en reageren wanneer ze kunnen.
## Beveiliging

- **Rolgebaseerde Toegangscontrole**: Alle services handhaven rolgebaseerde toegangscontroles door gebruikersrollen uit de HTTP-headers te lezen. Dit verzekert dat gebruikers alleen acties kunnen uitvoeren die zijn toegestaan door hun rollen.
