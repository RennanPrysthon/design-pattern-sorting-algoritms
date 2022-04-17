package br.com.ifpe.sorting.views;

import java.awt.*;
import java.util.List;

public interface SortingViewStrategy {
    void paintComponent(Graphics g, int panelWidth, int panelHeight, List<Integer> numbers);
}
