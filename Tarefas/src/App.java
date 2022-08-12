public class App {
    public static void main(String[] args) throws Exception {
        Arquivos a=new Arquivos();
        int N[] = new int[]{100, 1000, 10000, 50000, 100000};
        for (int i=0;i<N.length;i++) {
            if(i==0){
                a.SetMin(0);
                a.SetMax(100);
            }else if(i==1){
                a.SetMin(101);
                a.SetMax(1000);
            }else if(i==2){
                a.SetMin(1001);
                a.SetMax(10000);
            }else if(i==3){
                a.SetMin(10001);
                a.SetMax(50000);
            }else{
                a.SetMin(50001);
                a.SetMax(100000);
            }
            a.CriarPastas("C:\\Users\\cg3017443\\Desktop", String.valueOf(N[i]));
            for(int j=1;j<11;j++){
            a.CrirTextos("C:\\Users\\cg3017443\\Desktop", String.valueOf(N[i])+"\\arq"+j+".txt", N[i]);
        
            }
        }
        
        
    }
}
