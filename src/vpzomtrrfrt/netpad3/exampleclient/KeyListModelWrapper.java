package vpzomtrrfrt.netpad3.exampleclient;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.event.KeyEvent;

public class KeyListModelWrapper implements ListModel<String> {

    private ListModel wrapped;

    public KeyListModelWrapper(ListModel list) {
        wrapped = list;
    }

    @Override
    public int getSize() {
        return wrapped.getSize();
    }

    @Override
    public String getElementAt(int index) {
        Object ele = wrapped.getElementAt(index);
        if(ele instanceof Integer) {
            return KeyEvent.getKeyText((Integer)ele);
        }
        else if(ele instanceof Pair) {
            return KeyEvent.getKeyText((Integer)((Pair) ele).getFirst())+","+KeyEvent.getKeyText((Integer)((Pair) ele).getLast());
        }
        else {
            return "ERROR";
        }
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        wrapped.addListDataListener(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        wrapped.removeListDataListener(l);
    }
}
