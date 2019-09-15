package pro.vinyard.dofus.map.helper.dofusmap.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.EventListenerList;

import pro.vinyard.dofus.map.helper.Hint;
import pro.vinyard.dofus.map.helper.control.listeners.HintChangedEvent;
import pro.vinyard.dofus.map.helper.control.listeners.HintListener;
import pro.vinyard.dofus.map.helper.model.DofusMapModel;
import pro.vinyard.dofus.map.helper.model.IndicesModel;

public class IndicePane extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;

	private JList<Hint> list;
	
	private IndicesModel model;
	
	private EventListenerList listeners = new EventListenerList();
	
	public IndicePane() {
		this.setLayout();
	}
	
	private void setLayout() {
		this.model = new IndicesModel();
		this.setLayout(new BorderLayout());
		
		this.setBorder(BorderFactory.createLoweredBevelBorder());
		
//		this.setPreferredSize(new Dimension(120, 250));
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(780);
		l.add(763);
		
		
		this.list = new JList<Hint>(this.model);
		this.list.setCellRenderer(new IndiceListCellRenderer());
		this.list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.list.setLayoutOrientation(JList.VERTICAL);
		this.list.setVisibleRowCount(-1);
		
		this.list.addListSelectionListener(e -> {
			if(e.getValueIsAdjusting()) {
				this.notifyHintChanged(e.getLastIndex());
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(this.list);
		
		this.add(scrollPane);
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof DofusMapModel) {
			DofusMapModel dmm = (DofusMapModel) o;
			if("indices".equals(arg)) {
				this.model.setIndices(dmm.getIndices());
			}
		}
	}
	
	public void notifyHintChanged(int index) {
		for(HintListener listener : this.getHintListeners()) {
			listener.hintChanged(new HintChangedEvent(this, this.model.get(index)));
		}
	}
	
	public void addHintListener(HintListener listener) {
		this.listeners.add(HintListener.class, listener);
	}

	public void removeHintListener(HintListener listener) {
		this.listeners.remove(HintListener.class, listener);
	}
	
	public HintListener[] getHintListeners() {
		return this.listeners.getListeners(HintListener.class);
	}
}
