import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class Object_Frame extends JFrame {
    private Container container = getContentPane();
    private String ob_name;

    public Object_Frame(){
        super();
        setBounds(200, 200, 150, 130);
        setVisible(true);

        JTextField name = new JTextField("");
        container.add(name, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        container.add(panel, BorderLayout.CENTER);

        JTextField[] p = new JTextField[3];
        JComboBox[] t = new JComboBox[3];

        for(int i=0;i<p.length;i++){ //property
            p[i] = new JTextField();
            panel.add(p[i]);
            t[i] = new JComboBox();
            t[i].addItem("Integer");
            t[i].addItem("Double");
            t[i].addItem("String");
            panel.add(t[i]);
        }

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
