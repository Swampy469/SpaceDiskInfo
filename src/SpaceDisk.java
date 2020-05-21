import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class SpaceDisk {

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JLabel total_label = new JLabel();
    static JLabel available_label = new JLabel();
    static JLabel used_label = new JLabel();
    static JButton bottone = new JButton("RUN");
    static JTextArea text = new JTextArea();



   static public void calcolo(JLabel label_1, JLabel label_2, JLabel label_3){

       String save;
       save= text.getText();

       File partition_name = new File(save); // Insert the letter of your partition (ex: 'C:' , 'D:')

        label_1.setText(String.format("Total Space: %.2f GB", (double)partition_name.getTotalSpace()/1073741824)); //Total
        label_2.setText(String.format("Available Space: %.2f GB", (double)partition_name.getFreeSpace()/1073741824)); // Available
        label_3.setText(String.format("Used Space: %.2f GB", (double)partition_name.getUsableSpace()/1073741824)); //Used

    }

    public static void main(String[] args){

       int height = 280;
       int width = 440;
        int text_size=25;

        frame.setBounds(0,0,width,height);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(panel);
        panel.setBounds(0,0,frame.getWidth(),frame.getHeight());
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        panel.setVisible(true);

        panel.add(total_label);
        total_label.setBounds(0,frame.getY(),frame.getWidth(),30);
        total_label.setForeground(Color.YELLOW);
        total_label.setFont(new Font("font", Font.BOLD, text_size));

        panel.add(available_label);
        available_label.setBounds(0, frame.getY()+35, frame.getWidth(), 30);
        available_label.setForeground(Color.green);
        available_label.setFont(new Font("font", Font.BOLD, text_size));

        panel.add(used_label);
        used_label.setBounds(0, frame.getY()+65, frame.getWidth(), 30);
        used_label.setForeground(Color.red);
        used_label.setFont(new Font("font", Font.BOLD, text_size));

        panel.add(bottone);
        bottone.setBounds((frame.getSize().width /2) -80, 120 , 100 , 20);

        panel.add(text);
        text.setBounds((frame.getSize().width /2) -90 , frame.getY()+95, 120,25);
        text.setEditable(true);
        text.setForeground(Color.WHITE);
        text.setBackground(new Color(47,47,47));


        bottone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(text.getText().isEmpty()){
                    text.setText("Write a partition letter ");
                }else{
                    calcolo(total_label,available_label,used_label);
                }
            }
        });


    }


}
