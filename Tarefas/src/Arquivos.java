import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Arquivos {
    private static Arquivos instance=new Arquivos();
    private int min=1;
    private int max=2;

    public Arquivos() {
        super();
    }
    public void CriarPastas(String path,String name){
        File pasta=new File(path+"\\"+name);
        if(!pasta.exists()){
            System.out.println("Arquivo criado com sucesso");
            pasta.mkdir();
        }else{
            System.out.println("Arquivo ja existe!!!");
        }
    }

    public void CrirTextos(String path,String name,int n) throws IOException{
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path+"\\"+name, true));
        for(int i=0;i<n;i++){
          //  System.out.println(Integer.toString(gerarNumeros(min, max))+"\n");
            buffWrite.append(Integer.toString(gerarNumeros(min, max))+"\n");
        }
        buffWrite.close();
        
    }
    private int gerarNumeros(int min,int max){
        Random r =new Random();
        int x=r.nextInt(max - min) + min;
      // System.out.println(x);
           return  x;
        
    }

    public Arquivos GetInstance(){
        return instance;
    }
    public void SetMax(int n){
    max=n;
    }
    public void SetMin(int n){
        min=n;
        }
}
