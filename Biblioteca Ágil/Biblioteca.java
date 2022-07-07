import java.util.LinkedList;

public class Biblioteca {
    private LinkedList<Livro> livros;

    public Biblioteca(LinkedList<Livro> livros){
        this.livros = livros;
    }

    public int getQntLivros(){
        return livros.size();
    }

    public Livro achaLivro(int idLivro){
        return livros.get(idLivro);
    }

    public boolean doarLivro(String nome, String autor, int anoLancamento){
        int idLivro = livros.size();
        Livro l = new Livro(idLivro, nome, autor, anoLancamento);
        livros.add(idLivro, l);
        return true;
    }

    public boolean retirarLivro(int idLivro, String leitor){
        if(idLivro < 1 || idLivro > livros.size() || leitor.isEmpty() || leitor.isBlank()){
            return false;
        }
        Livro l = livros.get(idLivro);
        if(!l.getDisponivel()){
            return false;
        }

        l.setDisponivel(false);
        l.setLeitor(leitor);
        return true;
    }

    public boolean devolverLivro(int idLivro){
        if(idLivro < 1 || idLivro > livros.size()){
            return false;
        }
        Livro l = livros.get(idLivro);
        if(l.getDisponivel()){
            return false;
        }
        l.setDisponivel(true);
        l.setLeitor(null);
        return true;
    }

    @Override
    public String toString(){
        String biblioteca = "Biblioteca [livros=";
        for(Livro l : livros){
            biblioteca += l + ", ";
        }
        biblioteca += "]";
        return biblioteca;
    }

}
