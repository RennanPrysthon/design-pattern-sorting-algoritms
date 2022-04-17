package br.com.ifpe.sorting.views;

import java.awt.*;

public class HistogramView implements SortingViewStrategy{
    @Override
    public void paintComponent(Graphics g, int panelWidth, int panelHeight, java.util.List<Integer> numbers) {
        g.clearRect(0, 0, panelWidth, panelHeight);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, panelWidth, panelHeight);

        int outerSpace = 5;
        int innerSpace = 12;
        int qtd = numbers.size();
        int width = (panelWidth - 2 * outerSpace - (qtd - 1) * innerSpace) / qtd;
        int height = (panelHeight - 2 * outerSpace) / qtd;

        for (int index = 0; index < qtd; index++) {
            int number = numbers.get(index);
            g.setColor(Color.MAGENTA);
            g.fillRect(index * (width + innerSpace) + outerSpace, panelHeight - number * height - outerSpace, width, width);
        }
    }
}
