package pro.vinyard.dofus.map.helper.dofusmap.view;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import pro.vinyard.dofus.map.helper.Hint;
import pro.vinyard.dofus.map.helper.model.IndiceListModel;

public class IndiceListCellRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = 1L;

	public IndiceListCellRenderer() {

	}

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		Hint hint = (Hint) value;
		setText(IndiceListModel.getIndiceName((int) hint.getN()));

		return this;
	}

}