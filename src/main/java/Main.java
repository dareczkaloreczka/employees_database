
import gui.EmployeeView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            EmployeeView listaUserow = new EmployeeView();
            listaUserow.setVisible(true);
        }
    });
}
}
