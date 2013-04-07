package demo.util.applet.upload;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.DefaultComboBoxModel;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class UploadListDialog extends JDialog implements ActionListener,MouseListener {
	private JButton uploadButton = new JButton("上传");
	private JButton selectButton = new JButton("选择文件");
	private JFileChooser jFileChooser = new JFileChooser(
			System.getProperty("user.home"));
	private boolean allowMultiSelect = true;
	private long allowMaxSize = 1024;
	private String allowTypes = "jpg;gif";
	private JScrollPane jScrollPane1;
	private JTable uploadTable;
	private JButton reverseSelectButton;
	private JButton selectAllButton;
	TableModel uploadTableModel = new FileUploadTableModel();

	public UploadListDialog() {
		setTitle("文件上传对话框");
		this.setSize(500, 312);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
	}

	public void init() {
		this.add(uploadButton);
		uploadButton.setBounds(140, 6, 91, 26);
		uploadButton.setText("\u5f00\u59cb\u4e0a\u4f20");
		this.add(selectButton);
		selectButton.setBounds(12, 6, 100, 26);
		{
			jScrollPane1 = new JScrollPane();
			getContentPane().add(jScrollPane1);
			jScrollPane1.setBounds(12, 37, 468, 192);
			{
				uploadTable = new JTable();
				uploadTable.addMouseListener(this);
				
				jScrollPane1.setViewportView(uploadTable);
				uploadTable.setModel(uploadTableModel);
				TableColumn column = uploadTable.getColumnModel().getColumn(0);

				column.setCellEditor(new DefaultCellEditor(new JCheckBox()));
				column.setCellRenderer(new CheckBoxTableCellRenderer());
				uploadTable.setPreferredSize(new java.awt.Dimension(465, 168));
			}
		}
		{
			selectAllButton = new JButton();
			selectAllButton.addActionListener(this);
			getContentPane().add(selectAllButton);
			selectAllButton.setText("\u5168\u9009");
			selectAllButton.setBounds(12, 237, 61, 24);
		}
		{
			reverseSelectButton = new JButton();
			reverseSelectButton.addActionListener(this);
			getContentPane().add(reverseSelectButton);
			reverseSelectButton.setText("\u53cd\u9009");
			reverseSelectButton.setBounds(98, 237, 65, 24);
		}
		uploadButton.addActionListener(this);
		selectButton.addActionListener(this);
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter(
				"", allowTypes.split(";"));
		jFileChooser.setMultiSelectionEnabled(allowMultiSelect);
		jFileChooser.setFileFilter(extensionFilter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == uploadButton) {
			int returnVal = jFileChooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				if (allowMultiSelect) {
					File[] files = jFileChooser.getSelectedFiles();

				} else {
					File file = jFileChooser.getSelectedFile();
				}
			}
		}else if(e.getSource()==selectAllButton){
			int rowCount = uploadTableModel.getRowCount();
			System.out.println(rowCount);
			for(int i =0;i<rowCount;i++){
				System.out.println(uploadTableModel.getValueAt(i, 0).getClass().getName());
				Boolean boolean1 = (Boolean) uploadTableModel.getValueAt(i, 0);
				System.out.println(boolean1);
				uploadTableModel.setValueAt(new Boolean(true), i, 0);
				boolean1 = (Boolean) uploadTableModel.getValueAt(i, 0);
				System.out.println(boolean1);
				
			}
			
		}else if (e.getSource()==reverseSelectButton) {
			int rowCount = uploadTableModel.getRowCount();
			for(int i =0;i<rowCount;i++){
				Boolean boolean1 = (Boolean) uploadTableModel.getValueAt(i, 0);
				uploadTableModel.setValueAt(new Boolean(!boolean1.booleanValue()), i, 0);
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
