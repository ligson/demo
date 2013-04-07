package demo.util.applet.upload;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CheckBoxTableCellRenderer extends JCheckBox implements TableCellRenderer{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6182668680527315259L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		 Boolean b = (Boolean) value;    
         this.setSelected(b.booleanValue());    
         return this;
	}

}
