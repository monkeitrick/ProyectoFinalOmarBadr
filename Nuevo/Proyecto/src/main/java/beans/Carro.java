package beans;

import java.util.HashMap;
public class Carro {
	
	private HashMap<VideoJuego, Integer> hmJuego=new  HashMap<VideoJuego, Integer>();
	
	public Carro(HashMap<VideoJuego, Integer> hmJuego) {
		this.hmJuego = hmJuego;
	}

	public Carro() {
		
	}
	
	public HashMap<VideoJuego, Integer> getHmJuego() {
		return hmJuego;
	}

	public void setHmJuego(HashMap<VideoJuego, Integer> hmJuego) {
		this.hmJuego = hmJuego;
	}

	
	
}
