
package aula10_exercicio01;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

class JanelaAdicionar extends JFrame {
    private final List<Coordenadas> coords;
    private final JList<Coordenadas> lstCoords = new JList<Coordenadas>(new DefaultListModel<>());
    
    private final JButton novoElemento = new JButton("ADD");
    private final JButton excluiElemento = new JButton("Delete");
    private final JPanel pnlWest = new JPanel(new BorderLayout(1, 1));
    private final JPanel pnltexts = new JPanel();
    private final JPanel pnlEast = new JPanel(new BorderLayout(1, 2));
    private final JPanel pnlButton = new JPanel(new BorderLayout(1, 2));
    private final JPanel pnlLista = new JPanel(new BorderLayout(1, 1));
    
    private final JLabel lblLat = new JLabel("Latitude");
    private final JLabel lblLong = new JLabel("Longitude");
    private final JLabel lblDtHora = new JLabel("Data/Hora");
    private final JLabel lblDesc = new JLabel("Descarga");
    private final JTextField txtLat = new JTextField();
    private final JTextField txtLong = new JTextField();
    private final JTextField txtDtHora = new JTextField();
    private final JTextField txtDesc = new JTextField();
    
    public JanelaAdicionar(List<Coordenadas> dados) throws HeadlessException {
        super("JanelaAdicionar");
        this.coords = dados;
        
        DefaultListModel model = new DefaultListModel();
        lstCoords.setModel(model);
        
        pnlLista.add(new JScrollPane(lstCoords), BorderLayout.CENTER);
        pnlButton.add(novoElemento, BorderLayout.WEST);
        pnlButton.add(excluiElemento, BorderLayout.EAST);
        pnlWest.add(pnlButton, BorderLayout.SOUTH);
        pnlWest.add(pnlLista, BorderLayout.NORTH);
        
        Box horizontal = Box.createVerticalBox();
        horizontal.add(lblLat);
        horizontal.add(txtLat);        
        horizontal.add(lblLong);
        horizontal.add(txtLong);        
        horizontal.add(lblDtHora);
        horizontal.add(txtDtHora);        
        horizontal.add(lblDesc);  
        horizontal.add(txtDesc);  
        
        pnlEast.add(horizontal);
        
        add(pnlWest, BorderLayout.WEST);
        add(pnlEast);
        
        lstCoords.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         
        lstCoords.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
            }
        });
    }    
}
