
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel;
    private int index;
    private JPanel gridPanel;
    private JPanel panel2;
    private List<Grid> sol;
    private Grid grid;
    private ArrayList<ArrayList<JLabel>> gridLabel;
    private JLabel outputText;
    private JButton next;
    private JButton previous;

    public GUI(Grid grid, List<Grid> sol) {
        this.grid = grid;
        this.sol = sol;
        index = 0;
        frame = new JFrame("Sudoku Solver");
        frame.setPreferredSize(new Dimension(500,600));
        frame.setResizable(false);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        gridPanel = new JPanel(new GridLayout(Driver.SIZE, Driver.SIZE));
        gridPanel.setPreferredSize(new Dimension(500,500));
        mainPanel.add(gridPanel);
        gridLabel = new ArrayList<>();
        for (ArrayList<Cell> row : grid.gridOfRows) {
            gridLabel.add(new ArrayList<>());
            ArrayList<JLabel> rowLabel = gridLabel.get(grid.gridOfRows.indexOf(row));
            for (Cell cell : row) {
                int val = cell.getValue();
                if (val == 0)
                    rowLabel.add(new JLabel("", SwingConstants.CENTER));
                else
                    rowLabel.add(new JLabel("" + val, SwingConstants.CENTER));
                JLabel label = rowLabel.get(row.indexOf(cell));
                label.setFont(new Font("Calibri", Font.BOLD, 50));
                if ((((cell.row - 1) / Driver.SMALLSIZE) % 2 == 1) ^ (((cell.column - 1) / Driver.SMALLSIZE) % 2 == 1))
                    label.setBackground(Color.LIGHT_GRAY);
                else
                    label.setBackground(Color.WHITE);
                if(val == 0){
                    label.setForeground(Color.BLUE);
                }
                label.setOpaque(true);
                gridPanel.add(label);

            }
        }
        outputText = new JLabel("Calculating Solutions", SwingConstants.CENTER);
        panel2 = new JPanel(new GridLayout(1, 3));
        next = new JButton("Next");
        previous = new JButton("Previous");
        next.setVisible(false);
        next.addActionListener(this);
        previous.setVisible(false);
        previous.addActionListener(this);
        panel2.add(previous);
        panel2.add(outputText);
        panel2.add(next);
        mainPanel.add(panel2);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void updateGUI(Grid grid) {
        for (ArrayList<Cell> row : grid.gridOfRows) {
            ArrayList<JLabel> rowLabel = gridLabel.get(grid.gridOfRows.indexOf(row));
            for (Cell cell : row) {
                int val = cell.getValue();
                if (val == 0) {} 
                else
                    rowLabel.get(row.indexOf(cell)).setText("" + val);
            }
        }
    }

    public void updateGUI(int x) {
        int total = sol.size();
        if (total == 1) {
            outputText.setText("No of solutions is " + total);
            updateGUI(sol.get(index));
        } 
        else if (total > 1) {
            next.setVisible(true);
            previous.setVisible(true);
            switch (x) {
            case 1:
                if (index < total) {
                    index++;
                } else if (index == total) {
                    index = 1;
                }
                updateGUI(sol.get(index - 1));
                outputText.setText("Sol " + index + " of " + total);
                break;
            case 2:
                if (index > 1) {
                    index--;
                } else if (index == 1) {
                    index = total;
                }
                updateGUI(sol.get(index - 1));
                outputText.setText("Sol " + index + " of " + total);
                break;
            default:
                break;
            }

        }
        else if (total == 0){
            outputText.setText("There is no solution");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            updateGUI(1);
        }
        else if(e.getSource() == previous){
            updateGUI(2);
        }
    }
}
