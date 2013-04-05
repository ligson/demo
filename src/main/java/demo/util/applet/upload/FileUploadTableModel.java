package demo.util.applet.upload;

import javax.swing.table.AbstractTableModel;

public class FileUploadTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1029541018698420695L;

	private String[] columnNames = { "姓名", "专业", "工龄", "健在" };
	private Object[][] data = {
			{ "吕振", "java", new Integer(3), new Boolean(true) },
			{ "张沛", ".NET", new Integer(4), new Boolean(true) },
			{ "岳飞", "weapon", new Integer(100), new Boolean(false) },
			{ "张艺谋", "film", new Integer(50), new Boolean(true) } };
	public final Object[] longValues = { "吕振", "None of the above",
			new Integer(29), Boolean.TRUE };

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

}
