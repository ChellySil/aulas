package entities;
import java.util.List;
import java.util.Random;

public class Bot extends Jogador {

    public Bot(String nome) {
        super(nome);
    }

    public Carta jogarCarta(List<Carta> cartasMesa, String trunfo) {
    	
        if (cartasMesa.isEmpty()) {
            Carta carta = getMao().get(0);
            for (Carta c : getMao()) {
                if (c.getValor() > carta.getValor()) {
                    carta = c;
                }
            }
            getMao().remove(carta);
            return carta;
        }

        
        String naipePrimeiraCarta = cartasMesa.get(0).getNaipe();
        boolean temNaipe = false;
        for (Carta c : getMao()) {
            if (c.getNaipe().equals(naipePrimeiraCarta)) {
                temNaipe = true;
                break;
            }// carta do mesmo naipe da primeira carta jogada?
        }
        
        
        if (temNaipe) {
            Carta carta = getMao().get(0);
            for (Carta c : getMao()) {
                if (c.getNaipe().equals(naipePrimeiraCarta) && c.getNaipe() > carta.getValor()) {
                    carta = c;
                } // se tiver carta do mesmo naipe, jogar a maior.
            }
            getMao().remove(carta);
            return carta;
        }

        
        boolean temTrunfo = false;
        for (Carta c : getMao()) {
            if (c.getNaipe().equals(trunfo)) {
                temTrunfo = true;
                break;
            } // tem trunfo?
        }

        
        if (temTrunfo) {
            Carta carta = null;
            for (Carta c : getMao()) {
                if (c.getNaipe().equals(trunfo)) {
                    if (carta == null || c.getValor() < carta.getValor()) {
                        carta = c;
                    } // se tiver trunfo, jogar o menor.
                }
            }
            getMao().remove(carta);
            return carta;
        }

        
        Carta carta = getMao().get(0); 
        for (Carta c : getMao()) {
            if (c.getValor() > carta.getValor()) {
                carta = c;
            } //ñ tem trunfo e nei naioe, jogar a maior carta
        }
        
        getMao().remove(carta);
        return carta;
    }
}