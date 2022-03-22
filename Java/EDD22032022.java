public class EDD22032022{
    static int cont=0;
    

public static void main(String[] args) {
    int N = 10;
   
    int vetAleatorio[] = new int[N];
    int vetOrdenado[] = new int[N];
    int vetInverso[] = new int[N];

    for (int i = 0; i < N; i++) {
        vetAleatorio[i] = (int) (Math.random() * N * N);
        vetOrdenado[i] = i + 1;
        vetInverso[i] = N - i;
    }
    System.out.println("Vetor ANTES da Ordenação");
    exibe(vetAleatorio, N);
    ordena(vetAleatorio, N);
    System.out.println("Vetor APÓS da Ordenação");
    exibe(vetAleatorio, N);
    System.out.println(cont+": vezes");

    cont=0;
    System.out.println("Vetor ANTES da Ordenação");
    exibe(vetOrdenado, N);
    ordena(vetOrdenado, N);
    System.out.println("Vetor APÓS da Ordenação");
    exibe(vetOrdenado, N);
    System.out.println(cont+": vezes");

    cont=0;
    System.out.println("Vetor ANTES da Ordenação");
    exibe(vetInverso, N);
    ordena(vetInverso, N);
    System.out.println("Vetor APÓS da Ordenação");
    exibe(vetInverso, N);
    System.out.println(cont+": vezes");
   // System.out.println(x+": vezes");
    }
    private static void ordena(int[] vet, int N) {
        
       
        for (int j = 1; j < N+1; j++) {
            for (int i = 0; i < (N - j); i++) {
                if (vet[i] > vet[i + 1]) {
                    int aux = vet[i];
                    vet[i] = vet[i + 1];
                    vet[i + 1] = aux;
                    cont++;
                }
            }
        }

    }

    private static void exibe(int[] vet, int N) {
        for (int i = 0; i < N; i++) {
            System.out.println(vet[i]);
        }
        System.out.println("");
    }
}