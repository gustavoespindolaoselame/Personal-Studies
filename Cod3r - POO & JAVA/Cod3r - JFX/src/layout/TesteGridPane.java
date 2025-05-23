package layout;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class TesteGridPane extends GridPane{

	public TesteGridPane() {
		Caixa c1 = new Caixa().comTexto("1");
		Caixa c2 = new Caixa().comTexto("2");
		Caixa c3 = new Caixa().comTexto("3");
		Caixa c4 = new Caixa().comTexto("4");
		
		setGridLinesVisible(true);
		
		getColumnConstraints().addAll(cc(), cc(),fcc(),cc(),cc());
		getRowConstraints().addAll(rc(), rc(),frc(),rc(),rc());
		
		setVgap(10.0);
		setHgap(10.0);
		
		add(c1, 0, 0, 5, 1);
		add(c2, 0, 1, 4, 1);
		add(c3, 0, 2, 3, 1);
		add(c4, 0, 3, 2, 2);
	}
	
	private ColumnConstraints cc() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(20);
		cc.setFillWidth(true);
		return cc;
	}
	
	private ColumnConstraints fcc() {
		ColumnConstraints fcc = new ColumnConstraints();
		fcc.setMinWidth(50);
		fcc.setMaxWidth(50);
		fcc.setFillWidth(true);
		return fcc;
	}
	
	private RowConstraints rc() {
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(20);
		rc.setFillHeight(true);
		return rc;
	}
	
	private RowConstraints frc() {
		RowConstraints frc = new RowConstraints();
		frc.setMinHeight(20);
		frc.setMaxHeight(20);
		frc.setFillHeight(true);
		return frc;
	}
}
