import javax.swing.*;
import java.awt.*;
import java.io.File;


public class SpaceDisk {

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JLabel total_label = new JLabel();
    static JLabel available_label = new JLabel();
    static JLabel used_label = new JLabel();

    static File partition_name = new File("C:"); // Insert the letter of your partition (ex: 'C:' , 'D:')


    public static void main(String[] args){
        int size=25;

        frame.setBounds(0,0,420,200);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(panel);
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        panel.setVisible(true);

        panel.add(total_label);
        total_label.setBounds(0,25,600,50);
        total_label.setForeground(Color.YELLOW);
        total_label.setFont(new Font("Segui UI", Font.BOLD, size));

        panel.add(available_label);
        available_label.setBounds(0, total_label.getSize().height+15, 600, 30);
        available_label.setForeground(Color.green);
        available_label.setFont(new Font("Miao", Font.BOLD, size));

        panel.add(used_label);
        used_label.setBounds(0, total_label.getSize().height+45, 600, 30);
        used_label.setForeground(Color.red);
        used_label.setFont(new Font("Miao", Font.BOLD, size));

        total_label.setText(String.format("Total Space: %.2f GB", (double)partition_name.getTotalSpace()/1073741824)); //Total
        available_label.setText(String.format("Available Space: %.2f GB", (double)partition_name.getFreeSpace()/1073741824)); // Available
        used_label.setText(String.format("Used Space: %.2f GB", (double)partition_name.getUsableSpace()/1073741824)); //Used
    }
}
