import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Comparator;
import java.util.Deque;
import java.util.Stack;

public class Controller extends UI{
    private String datafrom, type, move, contour, sort;
    private int progress, all;
    private int[] live_index;
    private String[] input_arr;

    private Deque<SwapPair> process;
    private Stack<SwapPair> used_pair;
    private Timer process_timer;


    public Controller(){
        super();
        Node.ini_Node(select_type.getSelectedItem().toString());
        Node.setContour(select_contour.getSelectedItem().toString());
        datafrom = "UI Input";
        type = "Integer";
        move = "Parabola";
        contour = "Circle";
        sort = "Insertion";
        execute();
    }

    private void execute(){
        setDatafrom();
        setContour();
        setMove();
        setSort();
        setType();
        setProcess_timer();
        push_go();
        push_stop();
        push_initialize();
        push_back();
        push_clear();
    }

    private void setProcess_timer(){
        ActionListener listener = new ActionListener(){
            public void actionPerformed(ActionEvent event){
                try{
                    SwapPair p = process.pollFirst();
                    used_pair.push(p);
                    int a = live_index[p.first];
                    int b = live_index[p.second];

                    swap(a, b);
                }catch(NullPointerException e){}  //queue is empty

                progress++;
                prompt.setText(progress + " / " + all);

                if(process.isEmpty()){
                    process_timer.stop();
                }
            }
        };
        process_timer = new Timer(3000, listener);
        process_timer.setRepeats(true);
    }

    private void setDatafrom(){
        select_datafrom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    datafrom = select_datafrom.getSelectedItem().toString();

                    if(datafrom.equals("Random")){
                        input_arr = Input.random_generate(type);
                        setInput_arr();
                    }else if(datafrom.equals("File")){
                        JFrame in = new JFrame();
                        Container container = in.getContentPane();
                        in.setBounds(200, 200, 200, 100);
                        in.setVisible(true);

                        JTextField p = new JTextField();
                        container.add(p);

                        in.addWindowListener(new WindowListener() {
                            @Override
                            public void windowOpened(WindowEvent e) {}

                            @Override
                            public void windowClosing(WindowEvent e) { //close window get content
                                try {
                                    input_arr = Input.file(p.getText(), type);
                                    setInput_arr();
                                }catch (IOException io){}
                            }

                            @Override
                            public void windowClosed(WindowEvent e) {}
                            @Override
                            public void windowIconified(WindowEvent e) {}
                            @Override
                            public void windowDeiconified(WindowEvent e) {}
                            @Override
                            public void windowActivated(WindowEvent e) {}
                            @Override
                            public void windowDeactivated(WindowEvent e) {}});
                    }
                }
            }
        });
    }

    private void setSort(){
        select_sort.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    sort = select_sort.getSelectedItem().toString();
                }
            }
        });
    }

    private void setContour(){
        select_contour.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    contour = select_contour.getSelectedItem().toString();
                    System.out.println(contour);
                    if(contour.equals("Circle")){
                        Node.setContour("Circle");
                        for(int i=0;i<nodes.length;i++){
                            if(nodes[i].getlive())
                                nodes[i].update_Contour("Circle");
                        }
                    }else{
                        Node.setContour("Square");
                        for(int i=0;i<nodes.length;i++){
                            if(nodes[i].getlive())
                                nodes[i].update_Contour("Square");
                        }
                    }
                }
            }
        });
    }

    private void setMove(){
        select_move.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    move = select_move.getSelectedItem().toString();
                }
            }
        });
    }

    private void setType(){
        select_type.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    type = select_type.getSelectedItem().toString();

                    for(int i=0;i<nodes.length;i++){
                        nodes[i].clear_property();
                        nodes[i].update_Contour("None");
                    }

                    if(type.equals("Object")){
                        new Object_Frame();
                        Node.setIs_object(true);
                    }else{
                        Node.ini_Node(type);
                        Node.setIs_object(false);
                    }
                }
            }
        });
    }

    private void push_initialize(){
        initialize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                progress = 0;

                int n = 0;
                for(int i=0;i<nodes.length;i++){
                    if(nodes[i].getlive()) n++;
                }

                live_index = new int[n];  //index of live nodes
                int[] temp_live = new int[n];
                for(int i=0, j=0;i<nodes.length;i++){
                    if(nodes[i].getlive()){
                        live_index[j] = i;
                        temp_live[j] = i;
                        j++;
                    }
                }
                Comparator<Node> cmp;
                if(type.equals("Integer")){
                    cmp = new IntCmp();
                }else if(type.equals("Double")){
                    cmp = new DoubleCmp();
                }else if(type.equals("String")){
                    cmp = new StringCmp();
                }else{  //object
                    cmp = new ObjectCmp();
                }

                if(sort.equals("Insertion")){
                    process = Insertion.sort(nodes, temp_live, n, cmp);
                }else if(sort.equals("Selection")){
                    process = Selection.sort(nodes, temp_live, n, cmp);
                }else if(sort.equals("Bubble")){
                    process = Bubble.sort(nodes, temp_live, n, cmp);
                }else if(sort.equals("Quick")){
                    process = Quick.sort(nodes, temp_live, n, cmp);
                }

                used_pair = new Stack<>();

                all = process.size();
                prompt.setText(progress + " / " + all);
            }
        });
    }

    private void push_go(){
        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                process_timer.start();
            }
        });
    }

    private void push_stop(){
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                process_timer.stop();
            }
        });
    }

    private void push_back(){
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(progress>0) {
                    progress--;
                    prompt.setText(progress + " / " + all);

                    SwapPair p = used_pair.pop();
                    swap(live_index[p.first], live_index[p.second]);
                    process.offerFirst(p);
                }
            }
        });
    }

    private void push_clear(){
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                process_timer.stop();

                prompt.setText("");
                for(int i=0;i<nodes.length;i++){
                    nodes[i].clear_property();
                    nodes[i].update_Contour("None");
                }
            }
        });
    }

    private void swap(int a, int b){
        int ax = center_p(nodes[a].getX()), bx = center_p(nodes[b].getX());
        int step = (bx - ax) / 10;
        int center = (bx - ax) / 2;
        int height = 70;
        double coefficient = -height/Math.pow(center, 2);

        ActionListener listener = new ActionListener(){
            int count = 0;
            public void actionPerformed(ActionEvent event){
                if(move.equals("Line")) {
                    nodes[a].setLocation(center_p(nodes[a].getX()) + step,
                            center_p(nodes[a].getY()));
                    nodes[b].setLocation(center_p(nodes[b].getX()) - step,
                            center_p(nodes[b].getY()));
                }else{
                    if(count<5){ // raise slope
                        int y = center_p(nodes[a].getY());
                        int raise = (int)(coefficient*Math.pow(-center+count*step, 2)) + height;
                        y = y - raise;
                        nodes[a].setLocation(center_p(nodes[a].getX()) + step, y);
                        nodes[b].setLocation(center_p(nodes[b].getX()) - step, y);
                    }else{  // fall slope
                        int y = center_p(nodes[a].getY());
                        int fall = (int)(coefficient*Math.pow((count-4)*step, 2)) + height;
                        y = y + fall;
                        nodes[a].setLocation(center_p(nodes[a].getX()) + step, y);
                        nodes[b].setLocation(center_p(nodes[b].getX()) - step, y);
                    }
                }

                count++;
                if(count>=10){
                    Node temp = nodes[a];
                    nodes[a] = nodes[b];
                    nodes[b] = temp;
                    ((Timer)event.getSource()).stop();
                }
            }
        };
        Timer timer = new Timer(200, listener);
        timer.setRepeats(true);
        timer.start();
    }

    private void setInput_arr(){
        for(int i=0;i<input_arr.length;i++){
            nodes[i].update_Contour(contour);
            nodes[i].setProperty(Node.property_name[0], input_arr[i]);
            nodes[i].setName(input_arr[i]);
            nodes[i].print_property(false);
        }
    }

    private int center_p(int a){
        return a + Node.size / 2;
    }
}
