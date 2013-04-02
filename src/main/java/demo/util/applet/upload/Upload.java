package demo.util.applet.upload;

import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Upload extends Applet implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//byte
	private long allowMaxSize = 1024;
	private String allowTypes="jpg;gif";
	private JButton uploadButton = new JButton("upload");
	UploadListDialog dialog = new UploadListDialog();
	@Override
	public void init() {
		add(uploadButton);
		uploadButton.addActionListener(this);
		dialog.init();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(dialog);
		if(e.getSource()==uploadButton){
			dialog.setVisible(true);
		}
	}
}
