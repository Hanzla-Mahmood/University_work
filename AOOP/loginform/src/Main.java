import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
class loginform implements ActionListener{
    JFrame frame=new JFrame("Login Form");
    JLabel userLabel=new JLabel("UserName");
    JLabel passwordLabel=new JLabel("Password");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginbutton=new JButton("Login");


    loginform(){
        frame.setSize(400,500);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(null);
        frame.setResizable(false);

        userLabel.setBounds(40,120,100,50);
        userLabel.setFont(new Font("Arial",Font.BOLD,17));

        passwordLabel.setBounds(40,190,100,50);
        passwordLabel.setFont(new Font("Arial",Font.BOLD,17));

        userTextField.setBounds(180,135,150,25);
        userTextField.setFont(new Font("Arial",Font.BOLD,15));

        passwordField.setBounds(180,200,150,25);
        passwordField.setFont(new Font("Arial",Font.BOLD,15));


        loginbutton.setBounds(40,280,130,35);
        loginbutton.setFont(new Font("Arial",Font.BOLD,15));
        loginbutton.setFocusable(false);




        frame.add(userLabel);
        frame.add(passwordLabel);
        frame.add(userTextField);
        frame.add(passwordField);

        frame.add(loginbutton);



        loginbutton.addActionListener(this);




        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginbutton)
            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                String databaseurl = "jdbc:mysql://localhost:3306/hanzla";
                String UN = "root";
                String PS = "595877";
                String username = userTextField.getText();
                String password = passwordField.getText();
                Class.forName(driver);
                Connection c = DriverManager.getConnection(databaseurl, UN, PS);
                System.out.println("Database Connected");
                Statement s1=c.createStatement();
                String q="select * from registration1";
                ResultSet r1=s1.executeQuery(q);
                s1.execute("create table registration1(id int not null,name varchar(20));");
                PreparedStatement p1=c.prepareStatement("insert into registration1(name,email,city) values('Hanzla','talha','Lahore')");
                PreparedStatement ps=c.prepareStatement("select * from registration1 ");



                p1.executeUpdate();
                PreparedStatement p2=c.prepareStatement("update registration set name=? where id=1");
                p2.setString(1,"usman");
                p2.executeUpdate();
                PreparedStatement p3=c.prepareStatement("delete from registration where id=1");
                p3.executeUpdate();



                ResultSet resultSet=ps.executeQuery();
                if (username.equals("")||password.equals("")){
                    JOptionPane.showMessageDialog(null,"please enter all fields");
                }
                else {
                    while(resultSet.next()){
                        if(username.equalsIgnoreCase(resultSet.getString("username")) && password.equalsIgnoreCase(resultSet.getString("password"))){
                            JOptionPane.showMessageDialog(null,"Login Succesfull");
                            break;
                        }
                    }if(resultSet.isAfterLast()){
                        JOptionPane.showMessageDialog(null,"Not matched");
                    }
                }


            } catch (Exception ep) {
                System.out.println(ep);
            }


    }

}
class miss {
    public static void main(String[] args) {
        loginform loginDB = new loginform();


    }
}