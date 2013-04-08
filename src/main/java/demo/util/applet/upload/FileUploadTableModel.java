package demo.util.applet.upload;

import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

public class FileUploadTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1029541018698420695L;

	private String[] columnNames = { "文件名", "文件类型", "文件大小" };
	private Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data.get(row).get(col);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	

	public void removeRow(int row){
		data.remove(row);
		fireTableRowsDeleted(row, row);
	}
	
	public void addRow(String fileName,String fileType,int fileSize){
		Vector<Object> vector = new Vector<Object>();
		vector.add(fileName);
		vector.add(fileType);
		vector.add(fileSize);
		data.add(vector);
		fireTableRowsInserted(data.size()-1,data.size()-1);
	}
	

}
