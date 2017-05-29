package vpzomtrrfrt.netpad3.exampleclient;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    private SubConfigPanel<Integer> subBtns;
    private SubConfigPanel<Pair<Integer>> subAxis;
    public ConfigPanel(Integer[] btns, Pair<Integer>[] axis) {
        super();
        setLayout(new GridLayout(1, 2));
        subBtns = new SubConfigPanel<Integer>(btns, false);
        add(subBtns);
        subAxis = new SubConfigPanel<Pair<Integer>>(axis, true);
        add(subAxis);
    }

    public Integer[] getBtns() {
        return subBtns.getThings(new Integer[0]);
    }

    public Pair<Integer>[] getAxis() {
        return subAxis.getThings(new Pair[0]);
    }
}
