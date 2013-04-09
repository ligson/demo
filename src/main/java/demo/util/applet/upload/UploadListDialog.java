package demo.util.applet.upload;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import org.apache.struts2.views.jsp.ui.FileTag;

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
	private JButton removeButton;
	private JButton reverseSelectButton;
	private JButton selectAllButton;
	private FileUploadTableModel uploadTableModel = new FileUploadTableModel();
	private List<File> uploadFiles = new ArrayList<File>();
	private String host;
	private String port;
	public UploadListDialog() {
	}

	public UploadListDialog(long allowMaxSize, String allowTypes,
			String host, String port) {
		this.allowMaxSize=allowMaxSize;
		this.allowTypes=allowTypes;
		this.host=host;
		this.port=port;
	}

	public void init() {
		setTitle("文件上传对话框");
		this.setSize(500, 312);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
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
		{
			removeButton = new JButton();
			getContentPane().add(removeButton);
			removeButton.setText("\u79fb\u9664");
			removeButton.setBounds(182, 237, 70, 24);
			removeButton.addActionListener(this);
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
		if (e.getSource() == selectButton) {
			int returnVal = jFileChooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				if (allowMultiSelect) {
					File[] files = jFileChooser.getSelectedFiles();
					for(File file:files){
						String fileName = file.getName();
						String[] types  = fileName.split("\\.");
						uploadTableModel.addRow(fileName, types[types.length-1], (int)file.length()/1024);
						uploadFiles.add(file);
					}
				} else {
					File file = jFileChooser.getSelectedFile();
					String fileName = file.getName();
					String[] types  = fileName.split("\\.");
					uploadTableModel.addRow(fileName, types[types.length-1], (int)file.length()/1024);
					uploadFiles.add(file);
				}
			}
		}else if(e.getSource()==selectAllButton){
			uploadTable.selectAll();
		}else if (e.getSource()==reverseSelectButton) {
			
		}else if (e.getSource()==removeButton) {
			int[] rows = uploadTable.getSelectedRows();
			for(int row:rows){
				
				String fileName = (String) uploadTableModel.getValueAt(row, 0);
				for(File file:uploadFiles){
					if(file.getName().equals(fileName)){
						uploadFiles.remove(file);
						break;
					}
				}
				uploadTableModel.removeRow(row);
			}
		}else if(e.getSource()==uploadButton){
			UploadFile uploadFile = new UploadFile(host, port);
			uploadFile.setFiles(uploadFiles);
			Thread thread = new Thread(uploadFile);
			thread.start();
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
