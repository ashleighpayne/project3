import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI {
    public JFrame view;

    public JButton btnAddProduct = new JButton("Add/Update Product");
    public JButton btnAddCustomer = new JButton("Add/Update Customer");
    public JButton btnAddPurchase = new JButton("Add/Update Purchase");

    public JButton btnUpdateProduct = new JButton("Update Product Information");
    public JButton btnUpdateCustomer = new JButton("Update Customer Information");
    public JButton btnUpdatePurchase = new JButton("Update Purchase Information");
    public JButton btnSummary = new JButton("Summary");
    public JButton btnSearch = new JButton("Search");



    public MainUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.setTitle("Store Management System");
        view.setSize(1000, 600);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Store Management System");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnAddProduct);
        panelButtons.add(btnAddCustomer);
        panelButtons.add(btnAddPurchase);
        panelButtons.add(btnUpdateProduct);
        panelButtons.add(btnUpdateCustomer);
        //panelButtons.add(btnSummary);
        panelButtons.add(btnSearch);

        view.getContentPane().add(panelButtons);

        btnAddProduct.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                AddProductUI ac = new AddProductUI();
                ac.run();
            }
        });

        btnAddCustomer.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                AddCustomerUI ac = new AddCustomerUI();
                ac.run();
            }
        });

        btnAddPurchase.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                AddPurchaseUI ac = new AddPurchaseUI();
                ac.run();
            }
        });

        btnUpdateProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                UpdateProductUI ui = new UpdateProductUI();
                ui.run();
            }
        });

        btnSummary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String summary = "Summary";
                JOptionPane.showMessageDialog(null, summary);
            }
        });

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                String search = "Purchases";
                JOptionPane.showMessageDialog(null, search);

            }
        });

        btnUpdateCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                UpdateCustomerUI ui = new UpdateCustomerUI();
                ui.run();
            }
        });

        btnUpdateCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                UpdateCustomerUI ui = new UpdateCustomerUI();
                ui.run();
            }
        });

    }
}
