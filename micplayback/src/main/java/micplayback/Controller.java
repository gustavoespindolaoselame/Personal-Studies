package micplayback;

public class Controller {
	public void abilitarPlayback() {
		 try {
	            Runtime.getRuntime().exec("pactl load-module module-loopback latency_msec=1\n");
	        } catch (Throwable e) {
	            e.printStackTrace();
	        }
	}
	
	public void desabilitarPlayback() {
		try {
            Runtime.getRuntime().exec("pactl unload-module module-loopback");
        } catch (Throwable e) {
            e.printStackTrace();
        }
		
	}
}
