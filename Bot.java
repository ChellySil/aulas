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
            }
        }              
        if (temNaipe) {
            Carta carta = getMao().get(0);
            for (Carta c : getMao()) {
                if (c.getNaipe().equals(naipePrimeiraCarta) && c.getNaipe() > carta.getValor()) {
                    carta = c;
                } 
            }
            getMao().remove(carta);
            return carta;
        }
        boolean temTrunfo = false;
        for (Carta c : getMao()) {
            if (c.getNaipe().equals(trunfo)) {
                temTrunfo = true;
                break;
            } 
        }        
        if (temTrunfo) {
            Carta carta = null;
            for (Carta c : getMao()) {
                if (c.getNaipe().equals(trunfo)) {
                    if (carta == null || c.getValor() < carta.getValor()) {
                        carta = c;
                    } 
                }
            }
            getMao().remove(carta);
            return carta;
        }

        
        Carta carta = getMao().get(0); 
        for (Carta c : getMao()) {
            if (c.getValor() > carta.getValor()) {
                carta = c;
            } 
        }
        
        getMao().remove(carta);
        return carta;
    }
}
