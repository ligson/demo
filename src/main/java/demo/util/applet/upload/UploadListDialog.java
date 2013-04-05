package demo.util.applet.upload;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
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
public class UploadListDialog extends JDialog implements ActionListener {
	private JButton uploadButton = new JButton("上传");
	private JButton selectButton = new JButton("选择文件");
	private JFileChooser jFileChooser = new JFileChooser(
			System.getProperty("user.home"));
	private boolean allowMultiSelect = true;
	private long allowMaxSize = 1024;
	private String allowTypes = "jpg;gif";
	private JScrollPane jScrollPane1;
	private JTable uploadTable;

	public UploadListDialog() {
		setTitle("文件上传对话框");
		setSize(500, 300);
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
				TableModel uploadTableModel = 
						new DefaultTableModel(
								new String[][] { { "One", "Two","thss" ,""}, { "Three", "Four" ,"thss",""} },
								new String[] { "序号", "文件名","大小","进度" });
				uploadTable = new JTable();
				TableCheckboxManager tableCheckboxManager = new TableCheckboxManager(uploadTable);
				tableCheckboxManager.addCheckBoxs(2);
				tableCheckboxManager.setHeaderShowCheckbox(0);
				
				jScrollPane1.setViewportView(uploadTable);
				uploadTable.setModel(uploadTableModel);
				uploadTable.setPreferredSize(new java.awt.Dimension(465, 168));
			}
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
		}

	}
}
