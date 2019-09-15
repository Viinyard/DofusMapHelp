package pro.vinyard.dofus.map.helper.dofusmap.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

public class NumberPane extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private SpinnerNumberModel model;
	private JSpinner spinner;
	
	public NumberPane() {
		this.setLayout();
	}
	
	public void setValue(int value) {
		this.model.setValue(value);
	}
	
	public void addChangeListener(ChangeListener listener) {
		this.spinner.addChangeListener(listener);
	}
	
	public void removeChangeListener(ChangeListener listener) {
		this.spinner.removeChangeListener(listener);
	}
	
	public ChangeListener[] getChangeListeners(ChangeListener listener) {
		return this.spinner.getChangeListeners();
	}
	
	public int getValue() {
		return (int) this.model.getValue();
	}
	
	private void setLayout() {
		this.setLayout(new BorderLayout());
		
		this.model = new SpinnerNumberModel();
		this.spinner = new JSpinner(this.model);
		
		this.add(this.spinner, BorderLayout.CENTER);
	}

}
