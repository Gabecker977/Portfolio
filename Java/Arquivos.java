import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Arquivos {
    private static Arquivos instance=new Arquivos();
    private String arqEscrita; 
    JFileChooser chooser = new JFileChooser();
    int returnVal;
    BufferedWriter buffWrite;

    public void Escrever(String s){
         returnVal = chooser.showSaveDialog(chooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            arqEscrita = chooser.getSelectedFile().getAbsolutePath();
            //arqEscrita = chooser.getSelectedFile().getName();
        }

        System.out.println("Escrevendo no arquivo " + arqEscrita);
        try{
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arqEscrita,true));
        buffWrite.append(s + "\n");
        buffWrite.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void Ler(){
        String arqLeitura = "";
       String linha="";
        //filtro
        FileFilter filter = new FileNameExtensionFilter("Só TXT ou DOC carai...","txt","doc");
        chooser.addChoosableFileFilter(filter);
        
        returnVal = chooser.showOpenDialog(chooser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            arqLeitura = chooser.getSelectedFile().getAbsolutePath();
        }
        try{
        BufferedReader buffRead = new BufferedReader(new FileReader(arqLeitura));
        System.out.println("Lendo o arquivo " + arqLeitura);
        linha = buffRead.readLine();
        while (linha != null) {
            System.out.println(linha);
            linha = buffRead.readLine();
        }
        buffRead.close();
    }catch(Exception e){
        e.printStackTrace();
    }

    }
    public void CriarPasta(String path){
        File file=new File(path);
        if(!file.exists()){
            if(file.mkdir()){
                System.out.println("Arquivo criado com sucesso");
            }else  System.out.println("Deu ruim");
        }else{
            System.out.println("O arquivo já existe!!!!");
        }
    }

    public void Gerar100(String path){
        String arq="";
        int min = 10;
        int max = 100;

        Random r = new Random();
        try{
            for(int i=0;i<10;i++){
        buffWrite = new BufferedWriter(new FileWriter(path+"arq"+i+".txt", true));
        for (int j = 0; i < max; j++){
            int x = r.nextInt(max - min) + min;
            buffWrite.append(j+"/"+x+ "\n");
        }
    }
        buffWrite.close();
    }catch(Exception e){
        e.printStackTrace();
    }
    }
    
   public static Arquivos getInstance(){
       return instance;
   }
}
