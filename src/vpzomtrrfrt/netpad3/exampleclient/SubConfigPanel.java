package vpzomtrrfrt.netpad3.exampleclient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class SubConfigPanel<T> extends JPanel {
    private volatile Integer tr = -1;
    private JList<String> list;
    private DefaultListModel<T> listModel;
    public SubConfigPanel(final T[] things, final boolean p) {
        super(new BorderLayout());
        listModel = new DefaultListModel<T>();
        for(T thing : things) {
            listModel.addElement(thing);
        }
        list = new JList<String>(new KeyListModelWrapper(listModel));
        JPanel btnPanel = new JPanel();
        JButton addBtn = new JButton("+");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectKey(new IntegerListener() {
                    @Override
                    public void onValue(final int key) {
                        if(p) {
                            collectKey(new IntegerListener() {
                                @Override
                                public void onValue(int i) {
                                    listModel.addElement((T) new Pair<Integer>(key, i));
                                }
                            });
                        }
                        else {
                            listModel.addElement((T)(new Integer(key)));
                        }
                    }
                });
            }
        });
        btnPanel.add(addBtn);
        add(btnPanel, BorderLayout.NORTH);
        add(list, BorderLayout.CENTER);
    }
    public void collectKey(final IntegerListener l) {
        final JDialog d = new JDialog();
        d.setSize(200, 100);
        d.getContentPane().add(new JLabel("Press key"));
        d.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                l.onValue(e.getKeyCode());
                d.removeKeyListener(this);
                d.setVisible(false);
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        d.setVisible(true);
    }
    public T[] getThings(T[] arr) {
        ArrayList<T> tr = new ArrayList<T>();
        for(int i = 0; i < listModel.size(); i++) {
            tr.add(listModel.get(i));
        }
        return tr.toArray(arr);
    }
}
