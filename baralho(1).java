public class Baralho {
    private Carta[] cartas; 
    private int numCartas; 

    // Construtor da classe Baralho
    public baralho() {
        // Cria as cartas do baralho
        cartas = new Carta[40];
        String[] valores = {"Ás", "2", "3", "4", "5", "6", "7", "Dama", "Valete", "Rei"};
        String[] naipes = {"Paus", "Copas", "Espadas", "Ouros"};
        int index = 0;
        for (String valor : valores) {
            for (String naipe : naipes) {
                cartas[index++] = new Carta(valor, naipe);
            }
        }
        numCartas = 40;
}

public void embaralhar() {
        Random random = new Random();
        for (int i = numCartas - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
    }
    
    