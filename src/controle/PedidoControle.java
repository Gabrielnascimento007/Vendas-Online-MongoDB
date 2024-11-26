package controle;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import utils.MongoConfig;
import vendasOline.Pedido;

public class PedidoControle {
    private final MongoCollection<Document> pedidos;

    public PedidoControle() {
        this.pedidos = MongoConfig.getDatabase().getCollection("pedidos");
    }

    public void inserirPedido(Pedido pedido) {
        Document doc = new Document("data", pedido.getData().toString())
                .append("valorTotal", pedido.getValorTotal())
                .append("clienteId", pedido.getClienteId());
        pedidos.insertOne(doc);
        System.out.println("Pedido inserido com sucesso: " + doc.toJson());
    }

    public void listarPedidos() {
        for (Document doc : pedidos.find()) {
            System.out.println(doc.toJson());
        }
    }

    public void excluirPedido(String id) {
        Document filtro = new Document("_id", id);
        pedidos.deleteOne(filtro);
        System.out.println("Pedido excluído com sucesso.");
    }
}
