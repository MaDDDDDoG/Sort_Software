import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class Node extends JLabel{
    static public String contour = "Circle";
    static public String type_name;
    static public String[] property_type;
    static public String[] property_name;
    static public int size = 100, property_size;
    static public boolean is_object;
    private boolean live;
    private String name;
    public HashMap<String, String> property;

    public Node(){
        super();
        live = false;
        is_object = false;
        property = new HashMap<>();
        update_Contour("None");
        setSize(size, size);
        add_or_delete();
    }

    static public void ini_Node(String type, String... p){
        type_name = type;
        if(type.equals("Integer")){
            property_name = new String[]{"value"};
            property_type = new String[]{"int"};
        }else if(type.equals("Double")){
            property_name = new String[]{"value"};
            property_type = new String[]{"double"};
        }else if(type.equals("String")){
            property_name = new String[]{"value"};
            property_type = new String[]{"string"};
        }else{
            property_name = new String[p.length/2];
            property_type = new String[p.length/2];

            for(int i=0;i<property_name.length;i++)
                property_name[i] = p[i];
            for(int i=0;i<property_type.length;i++)
                property_type[i] = p[i+p.length/2];
        }
        property_size = property_name.length;
    }

    public void update_Contour(String contour){
        Icon icon = new ImageIcon("./contour/" + contour + ".png");
        setIcon(icon);
        //setText("<html>First line<br>Second line</html>");
        //setHorizontalTextPosition(JLabel.CENTER);
    }

    private void add_or_delete(){
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = e.getButton();
                if(c == MouseEvent.BUTTON1){ // click left mouse button
                    update_Contour(contour);
                    live = true;
                }else if(c == MouseEvent.BUTTON3){ // click right mouse button
                    live = false;
                    update_Contour("None");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    static public void setContour(String newcontour){
        contour = newcontour;
    }

    public boolean getlive(){
        return live;
    }

    static public void setIs_object(boolean is){
        is_object = is;
    }
    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x-size/2, y-size/2);
    }
}
