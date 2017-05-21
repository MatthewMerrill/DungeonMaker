package xyz.suplexstars.dungeonmaker.api;

import java.util.ArrayList;
import java.util.Collection;

public class TickManager Implements Tick{
	private static Collection<Tick> ticks;
	private static TickManager self;
	private TickManager(){
		ticks = new ArrayList();
	}

	public static TickManager getTickManager(){
		if(self == null){
			self = new TickManager();
		} 
		return self;
	}

	public void addTick(Tick tick){
		ticks.add(tick);
	}

	public void tick(){
		for(Tick tick : ticks){
			tick.tick();
		}
	}
}