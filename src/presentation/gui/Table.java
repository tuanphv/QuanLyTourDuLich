package presentation.gui;

import business.model.Customer;
import business.service.CustomerService;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {

    private DefaultTableModel model;
    private String[] columnNames;

    public Table() {
        setShowHorizontalLines(true);
        setRowHeight(40);
        setGridColor(new Color(230, 230, 230));
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                TableHeader header = new TableHeader(value + "");

                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                com.setBackground(Color.WHITE);
                if (isSelected) {
                    setForeground(new Color(0x4A90E2));
                } else {
                    setForeground(new Color(102, 102, 102));
                }
                return com;
            }
        });
    }

    public void setColumnNames(String[] cols) {
        this.columnNames = cols;
        model = new DefaultTableModel(this.columnNames, 0);
        setModel(model);
        loadData();
    }
    
    public void loadData() {
        CustomerService service = new CustomerService();
        ArrayList<Customer> list = service.getCustomers();
        for (Customer x : list) {
            model.addRow(x.toArray());
        }
    }
}
