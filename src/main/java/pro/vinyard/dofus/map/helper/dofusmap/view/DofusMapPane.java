package pro.vinyard.dofus.map.helper.dofusmap.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import pro.vinyard.dofus.map.helper.control.listeners.DirectionListener;
import pro.vinyard.dofus.map.helper.control.listeners.HintListener;
import pro.vinyard.dofus.map.helper.control.listeners.PositionListener;
import pro.vinyard.dofus.map.helper.model.DofusMapModel;

public class DofusMapPane extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private PositionPane positionPane;
	private DirectionPane directionPane;
	private IndicePane indicePane;
	private ResultPane resultPane;
	
	public DofusMapPane(DofusMapModel model) {
		this.setLayout(model);
	}
	
	private void setLayout(DofusMapModel model) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 1;
		gbc.gridheight = gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 0;
		
		this.positionPane = new PositionPane();
		model.addObserver(this.positionPane);
		
		this.add(this.positionPane, gbc);
		
		gbc.gridy++;
		
		this.directionPane = new DirectionPane();
		model.addObserver(this.directionPane);
		
		this.add(this.directionPane, gbc);
		
		
		gbc.gridy++;
		gbc.weighty = 1;
		
		this.indicePane = new IndicePane();
		model.addObserver(this.indicePane);
		
		this.add(this.indicePane, gbc);
		
		gbc.gridy++;
		gbc.weighty = 0;
		
		this.resultPane = new ResultPane();
		model.addObserver(this.resultPane);
		
		this.add(this.resultPane, gbc);
	}
	
	public void addDirectionListener(DirectionListener listener) {
		this.directionPane.addDirectionListener(listener);
	}
	
	public void removeDirectionListener(DirectionListener listener) {
		this.directionPane.removeDirectionListener(listener);
	}
	
	
	public DirectionListener[] getDirectionListeners() {
		return this.directionPane.getDirectionListeners();
	}
	
	public void addPositionListener(PositionListener listener) {
		this.positionPane.addPositionListener(listener);
	}
	
	public void removePositionListener(PositionListener listener) {
		this.positionPane.removePositionListener(listener);
	}
	
	public PositionListener[] getPositionListeners() {
		return this.positionPane.getPositionListeners();
	}
	
	public void addHintListener(HintListener listener) {
		this.indicePane.addHintListener(listener);
	}

	public void removeHintListener(HintListener listener) {
		this.indicePane.removeHintListener(listener);
	}
	
	public HintListener[] getHintListener(HintListener listener) {
		return this.indicePane.getHintListeners();
	}
	
	public void addActionListener(ActionListener listener) {
		this.resultPane.addActionListener(listener);
	}
	
	public void removeActionListener(ActionListener listener) {
		this.resultPane.removeActionListener(listener);
	}
	
	public ActionListener[] getActionListeners() {
		return this.resultPane.getActionListeners();
	}

}
