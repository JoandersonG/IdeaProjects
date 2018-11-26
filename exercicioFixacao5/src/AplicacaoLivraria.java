
import java.util.ArrayList;

public class AplicacaoLivraria {
    
    private static String nomeLivraria;
    private ArrayList <Titulo> titulos;
    
    public AplicacaoLivraria(String nomeLivraria) {
        this.nomeLivraria = nomeLivraria;
        this.titulos = new ArrayList<>();
    }

    public static String getNomeLivraria() {
        return nomeLivraria;
    }

    public void setNomeLivraria(String nomeLivraria) {
        AplicacaoLivraria.nomeLivraria = nomeLivraria;
    }
    
    public void criarRevista(String nome, String editora, double preco, String periodicidade) {
        titulos.add(new Revista(nome,editora,preco,periodicidade));
    }
    
    public void criarLivroDidatico(String nome, String editora, double preco, String autorPrincipal, String resumo, String area) {
        titulos.add(new LivroDidatico(nome,editora,preco,autorPrincipal,resumo,area));
    }
    
    public String consultarResumoLivro(String titulo) {
        String res = null;
        for (Titulo t : titulos) {
            if (t != null && t.getClass() == Livro.class && t.getNome().equals(titulo)) {
                //encontrei o título e é um livro
                res = ((Livro) t).getResumo();
                break;
            }
        }
        return res;
    }
    
    public boolean isMesmaEditoraRevistas(Revista rev1, Revista rev2) {
        return rev1.getNome().equals(rev2.getNome());
    }

    public boolean comprar(String titulo, int quantidade) {
        boolean didItWork = false;
        for (Titulo t : titulos) {
            if (t != null && t.getNome() == titulo){
                t.imprimirNotaFiscal(quantidade);
                didItWork =  true;
                break;
            }
        }
        return didItWork;
    }
}