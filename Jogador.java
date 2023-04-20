package entities;

import java.util.ArrayList;
import java.util.List;

public class Jogador {
	private String nome;
    private List<Carta> cartasMao;
    

    public Jogador(String nome) {
        this.nome = nome;
        cartasMao = new ArrayList<>();
    }

    public void receberCarta(Carta carta) {
    	for (int i = 0;i<=4;i++) {
        	this.cartasMao.add(baralho.removerCarta());
        }
    }
    
    public Carta jogarCarta(Carta cartaJogada) {
        Carta cartaRemovida = null;
        for (Carta carta : cartasMao) {
            if (carta.equals(cartaJogada)) {
                cartaRemovida = carta;
                break;
            }
        }
        else if (cartaRemovida != null) {
            cartasMao.remove(cartaRemovida);
        }
        return cartaRemovida;
    }
    
    public List<Carta> getMao() {
        return cartasMao;
    }

    public int getNumCartas() {
        return cartasMao.size();
    }

    public String getNome() {
    	return nome;
    }
}
    
    
        




