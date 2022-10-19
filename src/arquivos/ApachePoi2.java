package arquivos;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApachePoi2 {

    public static void main(String[] args) throws IOException {

        FileInputStream entrada = new FileInputStream(new File("C:\\Users\\Luca Moc\\IdeaProjects\\arquivos\\src\\arquivos\\arquivo_excel.xls"));


        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);/*prepara  a  entrada do arquivo para leitura*/
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0); /*pega a primeira planilha do arquivo excel*/

        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        while (linhaIterator.hasNext()) { /*enquanto houverlinha no arquivo*/
            Row linha = linhaIterator.next(); /*dados da pessoa na lunha*/
            Iterator<Cell> celula = linha.iterator();

            Pessoa pessoa = new Pessoa();

            while (celula.hasNext()) {/*percorrer as celulas*/
                Cell cell = celula.next();

                switch (cell.getColumnIndex()) {
                    case 0:
                        pessoa.setNome(cell.getStringCellValue());
                        break;

                    case 1 :
                        pessoa.setEmail(cell.getStringCellValue());
                        break;

                    case 2 :
                        pessoa.setIdade(cell.getStringCellValue());
                        break;
                }

            }
            pessoas.add(pessoa);
        }

        entrada.close();/*terminou de ler o arquivo */

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }



    }
}
