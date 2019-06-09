import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Controller extends UI{
    private String datafrom = "UI Input",  type = "Integer", move = "Parabola",
                   contour = "Circle", sort = "Insertion Sort";

    public Controller(){
        super();
        setDatafrom();
        setContour();
        setMove();
        setSort();
        setType();
    }

    private void setDatafrom(){
        select_datafrom.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    datafrom = select_datafrom.getSelectedItem().toString();
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
                    if(type.equals("Object")){
                        new Object_Frame();
                    }else{
                        Node.ini_Node(type);
                        Node.setIs_object(false);
                    }
                }
            }
        });
    }
}
