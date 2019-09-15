package pro.vinyard.dofus.map.helper.dofusmap.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pro.vinyard.dofus.map.helper.model.DofusMapModel;

public class ResultPane extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;

	private JTextField posX, posY;
	private JTextField dist;
	
	private JButton validate;
	
	public ResultPane() {
		this.setLayout();
	}
	
	private void setLayout() {
		this.setLayout(new BorderLayout());
		
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.dist = new JTextField(" ");
		
		this.add(this.dist, BorderLayout.NORTH);
		
		JPanel panel = new JPanel(new GridLayout(1, 2));
		
		this.posX = new JTextField();
		this.posX.setEditable(false);
		
		this.posY = new JTextField();
		this.posY.setEditable(false);
		
		panel.add(this.posX);
		panel.add(this.posY);
		
		this.add(panel, BorderLayout.CENTER);
		
		this.validate = new JButton("Validate");
		
		this.add(this.validate, BorderLayout.SOUTH);
	}
	
	public void addActionListener(ActionListener listener) {
		this.validate.addActionListener(listener);
	}
	
	public void removeActionListener(ActionListener listener) {
		this.validate.removeActionListener(listener);
	}
	
	public ActionListener[] getActionListeners() {
		return this.validate.getActionListeners();
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof DofusMapModel) {
			DofusMapModel model = (DofusMapModel) o;
			if(model.getDestination() != null) {
				this.posX.setText(Integer.toString(model.getDestination().getPosX()));
				this.posY.setText(Integer.toString(model.getDestination().getPosY()));
				
				if(model.getIndice() != null && model.getDirection() != null) {
					this.dist.setText(model.getDirection().getDirection() + " " +Integer.toString(model.getIndice().getD()));
				} else {
					this.dist.setText(" ");
				}
			} else {
				this.dist.setText(" ");
			}
		}
	}

}
