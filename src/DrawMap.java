
import java.awt.BorderLayout;
import javax.swing.*;

public class DrawMap extends JApplet {

	private TaxiMapCanvas taxiMap;

	@Override
	public void init() {

		this.setSize(701, 701);

		taxiMap = new TaxiMapCanvas();

		add(taxiMap, BorderLayout.CENTER);
	}
}