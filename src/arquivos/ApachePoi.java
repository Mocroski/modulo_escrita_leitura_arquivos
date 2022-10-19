package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApachePoi {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Luca Moc\\IdeaProjects\\arquivos\\src\\arquivos\\arquivo_excel.xls");

        if (!file.exists()){
            file.createNewFile();
        }

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

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); /*vai ser usado para escrever a planilha*/
        HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Planilha de pessoas Jdev Treinamento"); /*criar a planilha*/


        int numeroLinha = 0;
        for (Pessoa p : pessoas) {
            Row linha = linhasPessoa.createRow(numeroLinha ++); /*criando a linha na planilha*/

            int celula = 0;

            Cell cellNome = linha.createCell(celula ++); /*celula 1*/
            cellNome.setCellValue(p.getNome());

            Cell cellEmail = linha.createCell(celula ++);/*celula 2*/
            cellEmail.setCellValue(p.getEmail());

            Cell cellIdade = linha.createCell(celula ++);/*celula 3*/
            cellIdade.setCellValue(p.getIdade());

        }/*terminou de montar a planilha*/

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);/*escreve a olanilha em arquivo*/
        saida.flush();
        saida.close();

        System.out.println("planilha foi criada");

    }
}
