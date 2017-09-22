
package aula10_exercicio01;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

class JanelaAdicionar extends JFrame {
    private final List<Coordenadas> coords = new ArrayList<Coordenadas>();
    private final JList<Coordenadas> lstCoords = new JList<Coordenadas>(new DefaultListModel<>());
    
    private final JButton novoElemento = new JButton("Novo");
    private final JButton excluiElemento = new JButton("Delete");
    private final JPanel pnlWest = new JPanel(new BorderLayout(1, 1));
    private final JPanel pnltexts = new JPanel();
    private final JPanel pnlEast = new JPanel(new BorderLayout(1, 2));
    private final JPanel pnlButton = new JPanel(new BorderLayout(1, 2));
    private final JPanel pnlLista = new JPanel(new BorderLayout(1, 1));
    
    private final JLabel lblLat = new JLabel("Latitude");
    private final JLabel lblLong = new JLabel("Longitude");
    private final JLabel lblDtHora = new JLabel("Data/Hora");
    private final JLabel lblDesc = new JLabel("Descrição");
    private final JTextField txtLat = new JTextField();
    private final JTextField txtLong = new JTextField();
    //private final JTextField txtDtHora = new JTextField();
    private JFormattedTextField txtDtHora = new JFormattedTextField(Mascara("##/##/#### ##:##"));
    private final JTextField txtDesc = new JTextField();
    
    private String status = "";
    
    public JanelaAdicionar(List<Coordenadas> dados) throws HeadlessException {
        super("JanelaAdicionar");
        //this.coords = dados;

        lstCoords.setModel(new CoordsListModel(coords));
        
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
         
       /* lstCoords.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                Coordenadas selecionada = lstCoords.getSelectedValue();
                txtLat.setText(selecionada.getLat() + "");
                txtLong.setText(selecionada.getLong()+ "");
                txtDtHora.setText(selecionada.getData_hora() + "");
                txtDesc.setText(selecionada.getDesc()+ "");  
                txtLat.grabFocus();
                novoElemento.setText("Gravar");
                status = "Update";
            }
        });*/
        
        
        lstCoords.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2){
                    Coordenadas selecionada = lstCoords.getSelectedValue();
                    txtLat.setText(selecionada.getLat() + "");
                    txtLong.setText(selecionada.getLong()+ "");
                    txtDtHora.setText(selecionada.getData_hora() + "");
                    txtDesc.setText(selecionada.getDesc()+ "");  
                    txtLat.grabFocus();
                    novoElemento.setText("Gravar");
                    status = "Update";
                }
            }
        });
        
        novoElemento.addActionListener(new onClickBotao());
        excluiElemento.addActionListener(new onClickBotao());
    }    
    
    private class onClickBotao implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == novoElemento){               
                /*SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");                
                Date data = null;
                try {
                    data = fmt.parse(txtDtHora.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(JanelaAdicionar.class.getName()).log(Level.SEVERE, null, ex);
                }*/
                

                if (novoElemento.getText() == "Novo"){
                   novoElemento.setText("Gravar"); 
                   status = "Novo";
                }else{
                    if(status != "Update")
                    {
                        Coordenadas coord;
                        coord = new Coordenadas(Integer.parseInt(txtLat.getText()), Integer.parseInt(txtLong.getText()), txtDtHora.getText(), txtDesc.getText());
                        coords.add(coord);
                        lstCoords.updateUI();    
                    }else{
                        Coordenadas sel = lstCoords.getSelectedValue();
                        sel.setData_hora(txtDtHora.getText());
                        sel.setDesc(txtDesc.getText());
                        sel.setLat(Integer.parseInt(txtLat.getText()));
                        sel.setLong(Integer.parseInt(txtLong.getText()));                        
                    }
                    novoElemento.setText("Novo");
                }  
                 limpaCampos();
            }else if (e.getSource() == excluiElemento){
                if (status == "Update"){
                    coords.remove(lstCoords.getSelectedValue());
                    lstCoords.updateUI();
                    novoElemento.setText("Novo");
                    status = "Novo";
                    limpaCampos();
                }
            }
           
        } 
    }
    
    private void limpaCampos(){
        txtLat.setText("");
        txtLong.setText("");
        txtDtHora.setText("");
        txtDesc.setText("");
        txtLat.grabFocus();
    }
    
     public MaskFormatter Mascara(String Mascara){
        MaskFormatter F_Mascara = new MaskFormatter();
        try{
            F_Mascara.setMask(Mascara); //Atribui a mascara
            F_Mascara.setPlaceholderCharacter(' '); //Caracter para preencimento 
        }
        catch (Exception excecao) {
            excecao.printStackTrace();
        } 
        return F_Mascara;
 }
}
