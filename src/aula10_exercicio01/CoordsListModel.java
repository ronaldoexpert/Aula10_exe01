
package aula10_exercicio01;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class CoordsListModel implements ListModel<Coordenadas> {
 
    private final List<Coordenadas> coords;
    private final List<ListDataListener> dataListeners;              
    
    public CoordsListModel(List<Coordenadas> coords) {
        this.coords = coords;
        this.dataListeners = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return coords.size();
    }

    @Override
    public Coordenadas getElementAt(int index) {
        return coords.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }   
}
