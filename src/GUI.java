import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JTextField txtNumero;
    private JComboBox<String> cmbBase;
    private JTextField txtBinario, txtOctal, txtDecimal, txtHex;

    public GUI() {
        JFrame frame = new JFrame("Conversor de Bases");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 320);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblNumero = new JLabel("Valor a transformar:");
        txtNumero = new JTextField(10);
        JLabel lblBase = new JLabel("Base:");
        String[] bases = {"2", "8", "10", "16"};
        cmbBase = new JComboBox<>(bases);

        JButton btnConvertir = new JButton("Transformar");

        JLabel lblBinario = new JLabel("Valor en Binario:");
        txtBinario = new JTextField(15);
        txtBinario.setEditable(false);

        JLabel lblOctal = new JLabel("Valor en Octal:");
        txtOctal = new JTextField(15);
        txtOctal.setEditable(false);

        JLabel lblDecimal = new JLabel("Valor en Decimal:");
        txtDecimal = new JTextField(15);
        txtDecimal.setEditable(false);

        JLabel lblHex = new JLabel("Valor en Hexadecimal:");
        txtHex = new JTextField(15);
        txtHex.setEditable(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(lblNumero, gbc);

        gbc.gridx = 1;
        frame.add(txtNumero, gbc);

        gbc.gridx = 2;
        frame.add(lblBase, gbc);

        gbc.gridx = 3;
        frame.add(cmbBase, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(btnConvertir, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 0;
        frame.add(lblBinario, gbc);
        gbc.gridx = 1;
        frame.add(txtBinario, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        frame.add(lblOctal, gbc);
        gbc.gridx = 1;
        frame.add(txtOctal, gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        frame.add(lblDecimal, gbc);
        gbc.gridx = 1;
        frame.add(txtDecimal, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        frame.add(lblHex, gbc);
        gbc.gridx = 1;
        frame.add(txtHex, gbc);

        btnConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirNumero();
            }
        });

        frame.setVisible(true);
    }

    private void convertirNumero() {
        String numero = txtNumero.getText();
        String base = (String) cmbBase.getSelectedItem();

        if (numero.isEmpty() || base == null) {
            JOptionPane.showMessageDialog(null, "Ingrese un número y seleccione una base.");
            return;
        }

        txtBinario.setText(ConversorBases.cambiarBase(base, "2", numero));
        txtOctal.setText(ConversorBases.cambiarBase(base, "8", numero));
        txtDecimal.setText(ConversorBases.cambiarBase(base, "10", numero));
        txtHex.setText(ConversorBases.cambiarBase(base, "16", numero));
    }
}




