
import javax.swing.*;

public class StoreManager {
    public static final String DBMS_SQ_LITE = "SQLite";

    IDataAdapter adapter = null;
    private static StoreManager instance = null;

    public static StoreManager getInstance() {
        if (instance == null) {

            String dbfile = "jdbc:sqlite:";
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                dbfile = dbfile + fc.getSelectedFile().getAbsolutePath();

            instance = new StoreManager(DBMS_SQ_LITE, dbfile);
        }
        return instance;
    }

    private StoreManager(String dbms, String dbfile) {
        if (dbms.equals("Oracle")) {
            int nothing = 0; 
            nothing = nothing + 1;
        }
        else
        if (dbms.equals("SQLite"))
            adapter = new SQLiteDataAdapter();

        adapter.connect(dbfile);
        //ProductModel product = adapter.loadProduct(3);

        //System.out.println("Loaded product: " + product);

    }

    public IDataAdapter getDataAdapter() {
        return adapter;
    }

    public void setDataAdapter(IDataAdapter a) {
        adapter = a;
    }

    public void run() {
        AddUserUI user = new AddUserUI();
        user.view.setVisible(true);
        System.out.println("Creating main ui");
        
    }

    public static void main(String[] args) {
        StoreManager.getInstance().run();
    }

}

