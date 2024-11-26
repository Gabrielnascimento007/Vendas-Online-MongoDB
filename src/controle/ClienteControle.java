package controle;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;
import utils.MongoConfig;
import vendasOline.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteControle {
    private final MongoCollection<Document> clientes;

    public ClienteControle() {
        this.clientes = MongoConfig.getDatabase().getCollection("clientes");
    }

    public void inserirCliente(Cliente cliente) {
        Document doc = new Document("nome", cliente.getNome())
                .append("email", cliente.getEmail())
                .append("telefone", cliente.getTelefone())
                .append("endereco", cliente.getEndereco());
        clientes.insertOne(doc);
        System.out.println("Cliente inserido com sucesso: " + doc.toJson());
    }

    public void atualizarCliente(String id, Cliente cliente) {
        Document filtro = new Document("_id", new ObjectId(id));
        Document atualizacao = new Document("$set", new Document("nome", cliente.getNome())
                .append("email", cliente.getEmail())
                .append("telefone", cliente.getTelefone())
                .append("endereco", cliente.getEndereco()));
        clientes.updateOne(filtro, atualizacao);
        System.out.println("Cliente atualizado com sucesso.");
    }

    public void excluirCliente(String id) {
        Document filtro = new Document("_id", new ObjectId(id));
        clientes.deleteOne(filtro);
        System.out.println("Cliente excluído com sucesso.");
    }

    public void listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        for (Document doc : clientes.find()) {
            String id = doc.containsKey("_id") ? doc.getObjectId("_id").toHexString() : null;
            String nome = doc.containsKey("nome") ? doc.getString("nome") : "Nome não informado";
            String email = doc.containsKey("email") ? doc.getString("email") : "Email não informado";
            String telefone = doc.containsKey("telefone") ? doc.getString("telefone") : "Telefone não informado";
            String endereco = doc.containsKey("endereco") ? doc.getString("endereco") : "Endereço não informado";

            Cliente cliente = new Cliente(id, nome, email, telefone, endereco);
            lista.add(cliente);
        }
        lista.forEach(System.out::println);
    }
}
