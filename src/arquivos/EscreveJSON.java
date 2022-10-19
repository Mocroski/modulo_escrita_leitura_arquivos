package arquivos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class EscreveJSON {

    public static void main(String[] args) throws IOException {

        Usuario usuario1 = new Usuario();
        usuario1.setCpf("1234567");
        usuario1.setLogin("joao");
        usuario1.setSenha("123");

        Usuario usuario2 = new Usuario();
        usuario2.setCpf("7654321");
        usuario2.setLogin("maria");
        usuario2.setSenha("321");

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonUser = gson.toJson(usuarios);

        System.out.println(jsonUser);

        FileWriter fileWriter = new FileWriter("C:\\Users\\Luca Moc\\IdeaProjects\\arquivos\\src\\arquivos\\filjson.json");

        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();
    }
}
