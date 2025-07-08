import java.awt.*;
import java.awt.event.*;
class form extends Frame {
    form() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setTitle("Registration Form");
        setSize(800, 800);
        setVisible(true);
        Label l = new Label("First Name");
        add(l);
        l.setBounds(250,300,300,50);
        TextField tf = new TextField(10);
        add(tf);
        tf.setBounds(250,300,300,50);
        Label l2 = new Label("Hobbies");
        add(l2);
        l2.setBounds(250,300,300,50);
        Checkbox cb = new Checkbox("Registration form");
        add(cb);
        cb.setBounds(250,300,300,50);
        Checkbox cb2 = new Checkbox("HP");
        add(cb2);
        cb2.setBounds(250,300,300,50);
        Checkbox cb3 = new Checkbox("Cricket");
        add(cb3);
        cb3.setBounds(250,300,300,50);
        Checkbox cb4 = new Checkbox("Sleeping");
        add(cb4);
        cb4.setBounds(  250,300,300,50);
        Checkbox cb5 = new Checkbox("Pubg");
        add(cb5);
        cb5.setBounds(250,300,300,50);
        Button B = new Button("Submit");
        add(B);
        B.setBounds(250,300,300,50);
        Choice ch1 = new Choice();
        ch1.add("Lahore");
        ch1.add("KARACHI");
        add(ch1);
        List li = new List();
        li.add("Uni");
        li.add("NUML");
        add(li);
        setLayout(new GridLayout(13,5,2,3));
        setBackground(Color.GRAY);

    }
}
class Main{
    public static void main(String[] args) {
        form f = new form();

    }
}