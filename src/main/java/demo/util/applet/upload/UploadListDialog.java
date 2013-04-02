package demo.util.applet.upload;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UploadListDialog extends JDialog implements ActionListener{
	private JButton uploadButton = new JButton("upload");
	private JFileChooser jFileChooser = new JFileChooser(System.getProperty("user.home"));
	private boolean allowMultiSelect = true;
	private long allowMaxSize = 1024;
	private String allowTypes="jpg;gif";
	public UploadListDialog() {
		setSize(500, 300);
		setLocationRelativeTo(null);
	}
	public void init(){
		this.add(uploadButton);
		uploadButton.addActionListener(this);
		FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("", allowTypes.split(";"));
		jFileChooser.setMultiSelectionEnabled(allowMultiSelect);
		jFileChooser.setFileFilter(extensionFilter);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int returnVal = jFileChooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			if(allowMultiSelect){
				File[] files = jFileChooser.getSelectedFiles();
				
			}else{
				File file = jFileChooser.getSelectedFile();
			}
		}
		
	}
}
