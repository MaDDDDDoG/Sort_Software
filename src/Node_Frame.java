import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class Node_Frame extends JFrame{
    private Container container = getContentPane();

    public Node_Frame(Node a){
        super(Node.type_name);
        setBounds(200, 200, 150, 150);
        setVisible(true);
        pack();

        JPanel panel = new JPanel();
        if(Node.is_object){
            panel.setLayout(new GridLayout(Node.property_size+1, 2));
            JLabel name_label = new JLabel("Name");
            JTextField name_text = new JTextField();
            panel.add(name_label);
            panel.add(name_text);

            JLabel[] pn = new JLabel[Node.property_size];
            JTextField[] pv = new JTextField[Node.property_size];
            for(int i=0;i<Node.property_size;i++){
                pn[i] = new JLabel(Node.property_name[i]);
                pv[i] = new JTextField();
                panel.add(pn[i]);
                panel.add(pv[i]);
            }
        }else{
            panel.setLayout(new GridLayout(Node.property_size, 2));
            JLabel[] pn = new JLabel[Node.property_size];
            JTextField[] pv = new JTextField[Node.property_size];
            for(int i=0;i<Node.property_size;i++){
                pn[i] = new JLabel(Node.property_name[i]);
                pv[i] = new JTextField();
                panel.add(pn[i]);
                panel.add(pv[i]);
            }
        }

        container.add(panel, BorderLayout.CENTER);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) { //close window get content
                System.out.println("Close");
                ob_name = name.getText();
                if(ob_name.equals("")) ob_name = "A";

                List<String> temp = new ArrayList<>();
                for(int i=0;i<p.length;i++){
                    if(!p[i].getText().equals("")){
                        temp.add(p[i].getText());
                        temp.add(t[i].getSelectedItem().toString());
                    }
                }

                String[] p = new String[temp.size()];
                for(int i=0;i<p.length;i++){
                    p[i] = temp.get(i);
                }
                Node.ini_Node(ob_name, p);
                Node.setIs_object(true);
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
            public void windowDeactivated(WindowEvent e) {}
        });
    }
}
