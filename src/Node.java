import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class Node extends JLabel{
    static public String contour;
    static public String type_name;
    static public String[] property_type;
    static public String[] property_name;
    static public int size = 100, property_size;
    static public boolean is_object;
    private boolean live;
    private String name;
    private HashMap<String, String> property;

    public Node(){
        super();
        is_object = false;
        property = new HashMap<>();
        update_Contour("None");
        setSize(size, size);
        add_or_delete();
        setHorizontalTextPosition(JLabel.CENTER);
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

            for(int i=0, j=0;j<p.length;i++, j+=2)
                property_name[i] = p[j];
            for(int i=0, j=1;j<p.length;i++, j+=2)
                property_type[i] = p[j];
        }
        property_size = property_name.length;
    }

    public void update_Contour(String contour){
        if(contour.equals("None"))
            live = false;
        else
            live = true;
        Icon icon = new ImageIcon("./contour/" + contour + ".png");
        setIcon(icon);
    }

    private void add_or_delete(){
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int c = e.getButton();
                if(c == MouseEvent.BUTTON1){ // click left mouse button
                    content();
                    update_Contour(contour);
                }else if(c == MouseEvent.BUTTON3){ // click right mouse button
                    update_Contour("None");
                    print_property(true);
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

    public void clear_property(){
        property.clear();
        print_property(true);
    }

    private void content(){
        new Node_Frame(this);
    }

    public void setProperty(String name, String value){
        property.put(name, value);
    }

    static public void setContour(String newcontour){
        contour = newcontour;
    }

    public boolean getlive(){
        return live;
    }

    public void print_property(boolean clear) {
        if(clear) {
            setText("");
            return ;
        }
        String text = name;

        if(is_object){
            for(int i=0;i<property_size;i++){
                text += "<br>" + property_name[i] + ": " + property.get(property_name[i]);
            }
        }
        setText("<html>" + text + "</html>");
    }

    static public void setIs_object(boolean is){
        is_object = is;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getProperty(String key){
        return property.get(key);
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x-size/2, y-size/2);
    }

}
