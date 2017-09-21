package aula10_exercicio01;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Aula10_Exercicio01 {
    private static List<Coordenadas> getDados() {
        Coordenadas a1 = new Coordenadas(123, 4560, "19/09/2017 21:50", 1);
        Coordenadas a2 = new Coordenadas(658, 5874, "19/09/2017 21:50", 2);
        Coordenadas a3 = new Coordenadas(874, 6987, "19/09/2017 21:50", 3);
        
        List<Coordenadas> coords = new ArrayList<>();
        
        coords.add(a1);
        coords.add(a2);
        coords.add(a3);
        
        return coords;
    }
    
    public static void main(String[] args) {
        JanelaAdicionar janela = new JanelaAdicionar(getDados());
        janela.setSize(600, 200);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.setTitle("Adicionando Coordenadas");
    }
    
}
