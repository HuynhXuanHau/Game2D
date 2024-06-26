package main;

import net.miginfocom.swing.MigLayout;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class HightScoreBoard extends JPanel {

	public JTable table;
	public DefaultTableModel model;
	GamePanel gp;
	private JPanel panel;

	public HightScoreBoard(GamePanel gp) {
		this.gp = gp;
		panel = new JPanel(new MigLayout("fill, insets 0, gap 0", "[fill]", "[fill]"));
		model = new DefaultTableModel(new String[]{"Places", "Name Player", "Time", "Map"}, 6);
		table = new JTable(model);
		table.setFont(new Font("Courier New", Font.BOLD, 15));
		table.setRowHeight(30);
		table.setGridColor(new Color(77, 36, 14)); // Set grid color to match background


		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		for (int i = 1; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}

		table.getTableHeader().setFont(new Font("Courier New", Font.BOLD, 15));
		table.getTableHeader().setBackground(new Color(77, 36, 14));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBorder(new EmptyBorder(2, 2, 2, 2));
		table.setBackground(new Color(77, 36, 14));
		table.setForeground(Color.WHITE);
		table.setEnabled(false);

		table.getColumnModel().getColumn(0).setMaxWidth(80);
		table.getColumnModel().getColumn(1).setMaxWidth(230);
		table.getColumnModel().getColumn(2).setMaxWidth(80);
		table.getColumnModel().getColumn(3).setMaxWidth(80);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBackground(new Color(77, 36, 14));
		scrollPane.setBorder(null); // Remove border to eliminate white space

		panel.add(scrollPane, "w 450!, h 200!");

		setBounds(90, 120, 450, 185);
		setVisible(true);
		add(panel);
	}

}

class TableHeaderRenderer implements TableCellRenderer {

	private final TableCellRenderer baseRenderer;

	public TableHeaderRenderer(TableCellRenderer baseRenderer) {
		this.baseRenderer = baseRenderer;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JComponent c = (JComponent) baseRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		c.setBackground(new Color(77, 36, 14));
		c.setForeground(Color.WHITE);
		c.setBorder(new EmptyBorder(2, 2, 2, 2));
		return c;
	}
}
