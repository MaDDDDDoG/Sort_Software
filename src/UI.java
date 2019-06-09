import javax.swing.*;
import java.awt.*;


public class UI extends JFrame{
    protected Container cp = getContentPane();
    protected Node[] nodes;
    protected JToolBar preceding, processing;
    protected JComboBox select_type, select_datafrom, select_move, select_contour, select_sort;
    protected JButton finish, next, back, clear;
    protected JPanel node_panel, top_panel, bottom_panel;

    public UI(){
        super("XXX");
        setBounds(100, 100, 1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setNodes();
        setPreceding();
        setProcessing();
    }

    private void setNodes(){
        node_panel = new JPanel();
        node_panel.setBackground(Color.CYAN);
        cp.add(node_panel, BorderLayout.CENTER);
        node_panel.setLayout(null);

        nodes = new Node[8];
        int start_x = 80, start_y = 180, interval = 20;

        for(int i=0;i<nodes.length;i++){
            nodes[i] = new Node();
            nodes[i].setLocation(start_x+i*(interval+Node.size), start_y);
            node_panel.add(nodes[i]);
        }
    }

    private void setPreceding(){
        top_panel = new JPanel();
        top_panel.setSize(1000, 50);
        preceding = new JToolBar();

        select_datafrom = new JComboBox();
        select_datafrom.addItem("UI Input");
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

        top_panel.add(preceding);
        cp.add(top_panel, BorderLayout.NORTH);
    }

    private void setProcessing(){
        bottom_panel = new JPanel();
        bottom_panel.setSize(1000, 50);
        processing = new JToolBar();

        finish = new JButton("Finish");
        processing.add(finish);

        next = new JButton("Next");
        processing.add(next);

        back = new JButton("Back");
        processing.add(back);

        clear = new JButton("Clear");
        processing.add(clear);

        bottom_panel.add(processing);
        cp.add(bottom_panel, BorderLayout.SOUTH);
    }
}
