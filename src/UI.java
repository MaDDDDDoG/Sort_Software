import javax.swing.*;
import java.awt.*;


public class UI extends JFrame{
    protected Container cp = getContentPane();
    protected JToolBar preceding, processing;
    protected JComboBox select_type, select_datafrom, select_move, select_contour, select_sort;
    protected JButton finish, next, back, clear;
    protected JLabel test;
    protected JPanel node_panel;

    public UI(){
        super("XXX");
        setBounds(300, 300, 1000, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setPreceding();
        setProcessing();
        setNode();
    }

    private void setNode(){
        node_panel = new JPanel();
        node_panel.setBackground(Color.CYAN);

        cp.add(node_panel, BorderLayout.CENTER);
        node_panel.setLayout(null);
    }

    private void setPreceding(){
        preceding = new JToolBar();

        select_datafrom = new JComboBox();
        select_datafrom.addItem("UI input");
        select_datafrom.addItem("File");
        select_datafrom.addItem("Database");
        select_datafrom.addItem("Random");
        preceding.add(select_datafrom, new CardLayout());

        select_type = new JComboBox();
        select_type.addItem("Integer");
        select_type.addItem("Double");
        select_type.addItem("String");
        select_type.addItem("Object");
        preceding.add(select_type);

        select_sort = new JComboBox();
        select_sort.addItem("Insertion Sort");
        select_sort.addItem("Selection Sort");
        select_sort.addItem("Bubble Sort");
        select_sort.addItem("Merge Sort");
        select_sort.addItem("Quick Sort");
        preceding.add(select_sort);

        select_contour = new JComboBox();
        select_contour.addItem("Circle");
        select_contour.addItem("Square");
        preceding.add(select_contour);

        select_move = new JComboBox();
        select_move.addItem("Parabola");
        select_move.addItem("Line");
        preceding.add(select_move);


        cp.add(preceding, BorderLayout.NORTH);
    }

    private void setProcessing(){
        processing = new JToolBar();

        finish = new JButton("Finish");
        processing.add(finish);

        next = new JButton("Next");
        processing.add(next);

        back = new JButton("Back");
        processing.add(back);

        clear = new JButton("Clear");
        processing.add(clear);

        cp.add(processing, BorderLayout.SOUTH);
    }
}
