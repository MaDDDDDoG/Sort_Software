package Sort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Node_Frame extends JFrame{
    private Container container = getContentPane();

    public Node_Frame(Node a){
        super(Node.type_name);
        setBounds(200, 200, 150, 150);
        setVisible(true);

        JPanel panel = new JPanel();
        JLabel name_label = new JLabel("Name");
        JTextField name_text = new JTextField();
        JLabel[] pn = new JLabel[Node.property_size];
        JTextField[] pv = new JTextField[Node.property_size];

        if(Node.is_object){ //if object add name
            panel.setLayout(new GridLayout(Node.property_size+1, 2));
            panel.add(name_label);
            panel.add(name_text);
        }else{
            panel.setLayout(new GridLayout(Node.property_size, 2));
        }

        for(int i=0;i<Node.property_size;i++){
            pn[i] = new JLabel(Node.property_name[i]);
            pv[i] = new JTextField();
            panel.add(pn[i]);
            panel.add(pv[i]);
        }

        container.add(panel, BorderLayout.CENTER);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) { //close window get content
                System.out.println("Close");
                if(Node.is_object){
                    a.setName(Inspector.check_string(name_text.getText())); //object name
                }else{
                    if(Node.type_name.equals("Integer"))  //if it is not object then name is value
                        a.setName(Inspector.check_int(pv[0].getText()));
                    else if(Node.type_name.equals("Double"))
                        a.setName(Inspector.check_double(pv[0].getText()));
                    else if(Node.type_name.equals("String"))
                        a.setName(Inspector.check_string(pv[0].getText()));
                }

                for(int i=0;i<pv.length;i++){
                    String temp = "";

                    if(Node.property_type[i].equals("int"))
                        temp = Inspector.check_int(pv[i].getText());
                    else if(Node.property_type[i].equals("double"))
                        temp = Inspector.check_double(pv[i].getText());
                    else if(Node.property_type[i].equals("string"))
                        temp = Inspector.check_string(pv[i].getText());

                    a.setProperty(pn[i].getText(), temp);
                }

                a.print_property(false);
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
