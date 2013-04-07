package demo.util.applet.upload;

import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

public class FileUploadTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1029541018698420695L;

	private String[] columnNames = { "操作", "文件名", "文件类型", "文件大小" };
	private Object[][] data = {
			{new Boolean(true),"sdf","jbg",100},
			{new Boolean(true),"sdf","jbg",100},
			{new Boolean(true),"sdf","jbg",100},
			{new Boolean(true),"sdf","jbg",100}
	};
	

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

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	

	/*@Override
	public void setValueAt(Object value, int row, int column) {
		data[row][column] = value; 
	}*/
	

}
