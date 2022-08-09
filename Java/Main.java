public class Main {
    public static void main(String[] args) {
        int[] N={100,1000,50000,100000};
    Teste.getInstance().PrintAlgoTenso();
    //Arquivos.getInstance().Escrever("Sla");
    //Arquivos.getInstance().Ler();
  //  Arquivos.getInstance().Gerar100();
        for (int i : N) {
            Arquivos.getInstance().CriarPasta("C:\\Users\\cg3017443\\Desktop\\"+i);
            Arquivos.getInstance().Gerar100("C:\\Users\\cg3017443\\Desktop\\"+i);
        }

    }
}
