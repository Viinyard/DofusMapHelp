package pro.vinyard.dofus.map.helper.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pro.vinyard.dofus.map.helper.DofusMapIndice;
import pro.vinyard.dofus.map.helper.DofusMapRequest;
import pro.vinyard.dofus.map.helper.Hint;
import pro.vinyard.dofus.map.helper.Position;
import pro.vinyard.dofus.map.helper.control.listeners.DirectionChangedEvent;
import pro.vinyard.dofus.map.helper.control.listeners.DirectionListener;
import pro.vinyard.dofus.map.helper.control.listeners.HintChangedEvent;
import pro.vinyard.dofus.map.helper.control.listeners.HintListener;
import pro.vinyard.dofus.map.helper.control.listeners.PositionChangedEvent;
import pro.vinyard.dofus.map.helper.control.listeners.PositionListener;
import pro.vinyard.dofus.map.helper.model.Direction;
import pro.vinyard.dofus.map.helper.model.DofusMapModel;

public class DofusMapControler implements DirectionListener, PositionListener, HintListener, ActionListener {

	private DofusMapModel dofusMapModel;

	public DofusMapControler(DofusMapModel dofusMapModel) {
		this.dofusMapModel = dofusMapModel;
		
	}

	public void setPosition(Position position) {
		this.dofusMapModel.setPosition(position);
	}

	public void setDirection(Direction dir) {
		this.dofusMapModel.setDirection(dir);
	}

	public void setIndice(Hint indice) {
		this.dofusMapModel.setIndice(indice);
	}
	
	public void setDestination(Position destination) {
		this.dofusMapModel.setDestination(destination);
	}

	public void setIndices(List<Hint> indices) {
		this.dofusMapModel.setIndices(indices);
	}

	@Override
	public void positionChanged(PositionChangedEvent e) {
		this.setPosition(e.getValue());
	}

	@Override
	public void directionChanged(DirectionChangedEvent e) {
		this.setDirection(e.getValue());
		
		try {
			DofusMapIndice dmi = DofusMapRequest.getRequestWithQueryParameters(this.dofusMapModel.getPosition(), this.dofusMapModel.getDirection());
			this.setIndices(dmi.getHints());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void hintChanged(HintChangedEvent e) {
		System.out.println("Hint changed : " + e.getValue());
		this.setIndice(e.getValue());
		this.setDestination(new Position(e.getValue().getX(), e.getValue().getY()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setPosition(this.dofusMapModel.getDestination());
		this.setDirection(null);
		this.setIndices(new ArrayList<Hint>());
	}

}
