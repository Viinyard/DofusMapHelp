package pro.vinyard.dofus.map.helper;

import java.util.List;

import com.google.api.client.util.Key;

public class DofusMapIndice {
	
	@Key
	private DofusMapPosition from;
	
	@Override
	public String toString() {
		return "DofusMapIndice [from=" + from + ", hints=" + hints + "]";
	}

	public DofusMapPosition getFrom() {
		return from;
	}

	public void setFrom(DofusMapPosition from) {
		this.from = from;
	}

	public List<Hint> getHints() {
		return hints;
	}

	public void setHints(List<Hint> hints) {
		this.hints = hints;
	}

	@Key
	private List<Hint> hints;

}
