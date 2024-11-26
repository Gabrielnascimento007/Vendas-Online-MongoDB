package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoConfig {
  private static final String CONNECTION_STRING = "mongodb://localhost:27017"; // URL de conexão do MongoDB
  private static final String DATABASE_NAME = "meu_banco_mongo"; // Nome do banco de dados

  private static MongoClient client;
  private static MongoDatabase database;

  // Retorna a conexão com o banco de dados
  public static MongoDatabase getDatabase() {
    if (database == null) {
      client = MongoClients.create(CONNECTION_STRING);
      database = client.getDatabase(DATABASE_NAME);
    }
    return database;
  }

  // Fecha a conexão
  public static void close() {
    if (client != null) {
      client.close();
    }
  }
}
