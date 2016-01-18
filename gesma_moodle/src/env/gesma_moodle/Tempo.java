// CArtAgO artifact code for project gesma_moodle

package gesma_moodle;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import cartago.*;

/**
 * 
 * @author loopback
 * 
 */

public class Tempo extends Artifact{
	
	private final long INTERVALO_TEMPO = 1000;//24*60*60*1000;
	
	void init() {
		Date data = new Date();
		defineObsProperty("time", data.getTime());
		//Timer tempo = new Timer();
		execInternalOp("countRelogio");
		//tempo.schedule(tick, 0, INTERVALO_TEMPO);
	}
	
	/*TimerTask tick = new TimerTask() {
		@Override
		public void run() {
			Date data = new Date();
			ObsProperty prop = getObsProperty("time");
			prop.updateValue(data.getTime());
			signal("tick");
		}
	};*/
	
	@INTERNAL_OPERATION
	void countRelogio() {
		Date data = new Date();
		ObsProperty prop = getObsProperty("time");
		prop.updateValue(data.getTime());
		await_time(INTERVALO_TEMPO);
		signal("tick");
	}
	
	}