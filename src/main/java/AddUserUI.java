import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserUI extends JFrame {

    private static final long serialVersionUID = 1L;

    public JFrame view;

    public JButton btnAdd = new JButton("User ID");
    public JButton btnChange = new JButton("Change Password");
    public JButton btnCancel = new JButton("Cancel");
    public JButton btnUpdate = new JButton("Update");

    public JTextField txtUserID = new JTextField(20);
    public JTextField txtPassword = new JTextField(20);
    public JTextField newpassword = new JTextField(20);

    public boolean running = true;


    public AddUserUI() {
        this.view = new JFrame();

        view.setTitle("User Add");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("User ID "));
        line1.add(txtUserID);
        view.getContentPane().add(line1);

        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("New Type "));
        line2.add(txtPassword);
        view.getContentPane().add(line2);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnAdd);
        panelButtons.add(btnCancel);
        panelButtons.add(btnChange);
        view.getContentPane().add(panelButtons);

        btnAdd.addActionListener(new AddButtonListener());

        //btnChange.addActionListener(new ChangeButtonListener());

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Canceling");
                view.setVisible(false);
            }
        });

    }

    public void run() {
        view.setVisible(true);
    }

    class ChangeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            JFrame view2 = new JFrame();
            view2.setTitle("Change Password");
            view2.setSize(600, 400);
            view2.getContentPane().setLayout(new BoxLayout(view.getContentPane(), 2));

            JPanel line1 = new JPanel(new FlowLayout());
            line1.add(new JLabel("New Password "));
            line1.add(newpassword);
            view2.getContentPane().add(line1);

            JPanel panelButtons = new JPanel(new FlowLayout());
            panelButtons.add(btnUpdate);
            panelButtons.add(btnCancel);
            view2.getContentPane().add(panelButtons);

            btnUpdate.addActionListener(new UpdateButtonListener());
        }
    }

    class UpdateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            String id = txtUserID.getText();
            String newPassword = newpassword.getText();
            String oldPassword = txtPassword.getText();

            UserModel user = new UserModel();
            user.mPassword = oldPassword;
            user.mUserID = Integer.parseInt(id);

            UserModel login = StoreManager.getInstance().getDataAdapter().loadUser(Integer.parseInt(id));
            if (login.mPassword.equals(user.mPassword)){
                JOptionPane.showMessageDialog(null, "Password updated! :)");

            }

        }
    }

    class AddButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            UserModel user = new UserModel();

            String id = txtUserID.getText();
            try {
                user.mUserID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID is invalid!");
                return;
            }


            String password = txtPassword.getText();
            if (password.length() == 0) {
                JOptionPane.showMessageDialog(null, "Password cannot be empty!");
                return;
            }

            user.mPassword = password;

            UserModel login = StoreManager.getInstance().getDataAdapter().loadUser(Integer.parseInt(id));

            if (login.mPassword.equals(user.mPassword)){
                JOptionPane.showMessageDialog(null, "Welcome " + user.mUserID + "!!!");
                running = false;
                view.setVisible(false);
                MainUI ui = new MainUI();
                ui.view.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Login failed :(");
                view.setVisible(false);
                running = false;

            }

        }
    }

}
