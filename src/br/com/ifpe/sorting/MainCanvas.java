package br.com.ifpe.sorting;

import br.com.ifpe.sorting.views.ColumnsView;
import br.com.ifpe.sorting.views.SortingViewStrategy;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MainCanvas extends JPanel {
    private final SortingAlgorithms sortingAlgorithms;
    private List<Integer> numbers;
    private SortingViewStrategy viewStrategy;

    public MainCanvas(SortingAlgorithms sortingAlgorithms) {
        this.sortingAlgorithms = sortingAlgorithms;
        this.viewStrategy = new ColumnsView();
    }

    @Override
    protected void paintComponent(Graphics g) {
        viewStrategy.paintComponent(g, this.getWidth(), this.getHeight(), this.numbers);
    }

    public void shuffle() {
        int qtd = this.sortingAlgorithms.getQuantity();
        createRandomizeArray(qtd);
        repaint();
    }

    public void setViewStrategy(SortingViewStrategy viewStrategy) {
        this.viewStrategy = viewStrategy;
    }

    private void createRandomizeArray(int quantity) {
        this.numbers = new ArrayList<>(quantity);
        for (int i = 0; i< quantity; i++) {
            this.numbers.add(i);
        }
        Collections.shuffle(this.numbers);
    }
}
