package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setEmail("pessoa1@gmail");
        pessoa1.setIdade("44");
        pessoa1.setNome("joao");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setEmail("pessoa2@gmail");
        pessoa2.setIdade("45");
        pessoa2.setNome("jose");

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setEmail("pessoa3@gmail");
        pessoa3.setIdade("49");
        pessoa3.setNome("jona");

        /*esssa lista pode vir do banco de dados ou qualquer outra fonte*/
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);


        File arquivo = new File("C:\\Users\\Luca Moc\\IdeaProjects\\arquivos\\src\\arquivos\\arquivo.csv");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        FileWriter escrever_no_arquivo = new FileWriter(arquivo);

        for (Pessoa p : pessoas) {
            escrever_no_arquivo.write(p.getNome() + ";" + p.getIdade() + ";" + p.getEmail() + "\n");
        }


        escrever_no_arquivo.flush();
        escrever_no_arquivo.close();



    }
}
