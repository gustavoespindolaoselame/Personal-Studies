package micplayback;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button offButton;
    
    @FXML
    private Button onButton;
    
    @FXML
	public void abilitarPlayback() {
		 try {
	            Runtime.getRuntime().exec("pactl load-module module-loopback latency_msec=1\n");
	            onButton.setStyle("-fx-text-fill: #FFF");
	            offButton.setStyle("-fx-text-fill: gray");
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
	}
	
    @FXML
	public void desabilitarPlayback() {
		try {
            Runtime.getRuntime().exec("pactl unload-module module-loopback");
            offButton.setStyle("-fx-text-fill: #FFF");
            onButton.setStyle("-fx-text-fill: gray");
        } catch (Throwable e) {
            e.printStackTrace();
        }
		
	}
    
    public static void onStartButtonOff() {
    	try {
            Runtime.getRuntime().exec("pactl unload-module module-loopback");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
