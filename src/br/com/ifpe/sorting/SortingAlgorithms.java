package br.com.ifpe.sorting;

import br.com.ifpe.sorting.views.ColumnsView;
import br.com.ifpe.sorting.views.HistogramView;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SortingAlgorithms extends JFrame {
    JSpinner spinner;
    MainCanvas canvas;
    JComboBox<String> jComboBox;

    public SortingAlgorithms() {
        super("Sorting Algorithms");
    }

    public static void main(String[] args) {
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        sortingAlgorithms.showScreen();
    }

    private JPanel getHeader() {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));
        header.setBackground(Color.WHITE);

        JLabel title = new JLabel("Ordenação");
        title.setFont(new Font("Serif", Font.BOLD, 24));

        header.add(title);
        header.setMaximumSize(new Dimension(640, 50));

        return header;
    }

    private JPanel getNav() {
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navPanel.setMaximumSize(new Dimension(640, 50));
        navPanel.setBackground(Color.WHITE);

        spinner = new JSpinner(new SpinnerNumberModel(25, 2, 2000, 5));
        spinner.setToolTipText("Quantity os numbers to display");
        navPanel.add(spinner);

        JButton button = new JButton("Shuffle");
        button.addActionListener(ac -> canvas.shuffle());
        navPanel.add(button);

        jComboBox = new JComboBox<>(new String[] {"Bar", "Histogram"});
        jComboBox.setToolTipText("How to show the sorting algorithms");
        jComboBox.addActionListener(ev -> this.changeView());

        navPanel.add(jComboBox);

        return navPanel;
    }

    public void changeView() {
        if (Objects.equals(this.jComboBox.getSelectedItem(), "Bar")) {
            this.canvas.setViewStrategy(new ColumnsView());
        } else {
            this.canvas.setViewStrategy(new HistogramView());
        }

        this.repaint();
    }

    private void showScreen() {
        this.setPreferredSize(new Dimension(618, 726));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.setBackground(Color.WHITE);

        JPanel header = getHeader();
        this.add(header);

        JPanel navBar = getNav();
        this.add(navBar);

        this.canvas = new MainCanvas(this);
        this.canvas.shuffle();

        this.add(canvas);
    }

    public int getQuantity() {
        return (Integer) spinner.getValue();
    }

}
