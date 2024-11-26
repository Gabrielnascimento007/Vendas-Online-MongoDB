package controle;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import utils.MongoConfig;
import vendasOline.Produto;

public class ProdutoControle {
    private final MongoCollection<Document> produtos;

    public ProdutoControle() {
        this.produtos = MongoConfig.getDatabase().getCollection("produtos");
    }

    public void inserirProduto(Produto produto) {
        Document doc = new Document("nome", produto.getNome())
                .append("descricao", produto.getDescricao())
                .append("preco", produto.getPreco())
                .append("quantidadeEstoque", produto.getQuantidadeEstoque());
        produtos.insertOne(doc);
        System.out.println("Produto inserido com sucesso: " + doc.toJson());
    }

    public void listarProdutos() {
        for (Document doc : produtos.find()) {
            System.out.println(doc.toJson());
        }
    }

    public void atualizarProduto(String id, Produto produto) {
        Document filtro = new Document("_id", id);
        Document atualizacao = new Document("$set", new Document("nome", produto.getNome())
                .append("descricao", produto.getDescricao())
                .append("preco", produto.getPreco())
                .append("quantidadeEstoque", produto.getQuantidadeEstoque()));
        produtos.updateOne(filtro, atualizacao);
        System.out.println("Produto atualizado com sucesso.");
    }

    public void excluirProduto(String id) {
        Document filtro = new Document("_id", id);
        produtos.deleteOne(filtro);
        System.out.println("Produto excluído com sucesso.");
    }
}
