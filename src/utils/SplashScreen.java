package utils;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class SplashScreen {

    public static String getSplashScreen() {
        MongoCollection<Document> clientes = MongoConfig.getDatabase().getCollection("clientes");
        MongoCollection<Document> pedidos = MongoConfig.getDatabase().getCollection("pedidos");
        MongoCollection<Document> produtos = MongoConfig.getDatabase().getCollection("produtos");

        long countClientes = clientes.countDocuments();
        long countPedidos = pedidos.countDocuments();
        long countProdutos = produtos.countDocuments();

        return String.format("""
                ################################################
                #                                              #
                #         SISTEMA DE PEDIDOS E PRODUTOS        #
                #                                              #
                ################################################
                #                   CONTAGENS                  #
                #                                              #
                #  TOTAL DE CLIENTES:    %5d                   #
                #  TOTAL DE PEDIDOS:     %5d                   #
                #  TOTAL DE PRODUTOS:    %5d                   #
                ################################################
                """, countClientes, countPedidos, countProdutos);
    }
}
