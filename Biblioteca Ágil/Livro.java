import java.text.DecimalFormat;

public class Livro{
    private int idLivro;
    private String nome;
    private String autor;
    private int anoLancamento;
    private boolean disponivel;
    private String leitor;

    public Livro(int idLivro, String nome, String autor, int anoLancamento){
        this.idLivro = idLivro;
        this.nome = nome;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
        this.disponivel = true;
    }

    public Livro(int idLivro, String nome, String autor, int anoLancamento, boolean disponivel, String leitor){
        this.idLivro = idLivro;
        this.nome = nome;
        this.autor = autor;
        this.anoLancamento = anoLancamento;
        this.disponivel = disponivel;
        this.leitor = leitor;
    }
  

    public int getIdLivro() {
        return idLivro;
    }

    public String getNome() {
        return nome;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public boolean getDisponivel(){
        return disponivel;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    public String getLeitor(){
        return leitor;
    }

    public void setLeitor(String leitor){
        this.leitor = leitor;
    }

    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("00000");
        return "        -  Número: " + df.format((long) idLivro + 1) + "\n"
             + "        -  Titulo: " + nome + "\n"
             + "        -  Autor: " + autor + "\n"
             + "        -  Ano: " + anoLancamento + "\n"
             + "        -  Status: " + ((disponivel) ? "Disponivel" : "Indisponivel") + "\n"
             + "        -  Emprestado para: " + leitor;
             
    }

}