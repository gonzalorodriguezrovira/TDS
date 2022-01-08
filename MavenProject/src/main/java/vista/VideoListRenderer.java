package vista;
//Para completar
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JLabel;
import javax.swing.JList;

@SuppressWarnings("serial")
public class VideoListRenderer extends DefaultListCellRenderer{
    @Override
    public Component getListCellRendererComponent(JList<?> list,  
                        Object value, int index, boolean isSelected, 
                        boolean cellHasFocus) {
        if (value!=null && value instanceof JLabel) {
            JLabel ele = (JLabel) value;
            if (isSelected) {
                ele.setBackground(Color.GRAY);
            } else {
                ele.setBackground(list.getBackground());
                ele.setForeground(list.getForeground());
            }
            return ele;
        }
        else return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }
}