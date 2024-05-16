import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableExample extends JFrame {
    public TableExample() {
        setTitle("Table Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Tạo một mảng 2D đại diện cho dữ liệu bảng
        Object[][] data = {
                {"1", "John", "Doe"},
                {"2", "Jane", "Smith"},
                {"3", "Bill", "Brown"}
        };

        // Tạo một mảng đại diện cho tiêu đề cột
        String[] columns = {"ID", "First Name", "Last Name"};

        // Tạo một đối tượng JTable với dữ liệu và tiêu đề cột đã cho
        JTable table = new JTable(data, columns);

        // Xóa đường viền cho mọi cột và hàng
        table.setShowGrid(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);

        // Xóa đường viền cho phần header
        TableCellRenderer baseRenderer = table.getTableHeader().getDefaultRenderer();
        table.getTableHeader().setDefaultRenderer(new TableHeaderRenderer(baseRenderer));

        // Thêm bảng vào JFrame
        getContentPane().add(new JScrollPane(table), BorderLayout.SOUTH);

        // Thiết lập kích thước cửa sổ
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TableExample().setVisible(true);
        });
    }
}
class TableHeaderRenderer implements TableCellRenderer {

    private final TableCellRenderer baseRenderer;

    public TableHeaderRenderer(TableCellRenderer baseRenderer) {
        this.baseRenderer = baseRenderer;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent c = (JComponent)baseRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBorder(new EmptyBorder(2,2,2,2));
        return c;
    }
}

