public class Baralho {
    private ArrayList<Carta> cartas;
    
    public Baralho() {
        cartas = new ArrayList<>();
        String[] valores = {"Ás", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valete", "Dama", "Rei"};
        String[] naipes = {"Paus", "Copas", "Espadas", "Ouros"};
        
        for (String valor : valores) {
            for (String naipe : naipes) {
                Carta carta = new Carta(valor, naipe);
                cartas.add(carta);
            }
        }
    }
    
    public void embaralhar() {
        for (int i = cartas.size() - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            Carta temp = cartas.get(i);
            cartas.set(i, cartas.get(j));
            cartas.set(j, temp);
        }
    }
    
    public Carta comprarCarta() {
        if (!cartas.isEmpty()) {
            return cartas.remove(0);
        } else {
            return null;
        }
    }
}
