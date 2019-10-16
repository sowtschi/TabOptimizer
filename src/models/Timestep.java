package models;

public class Timestep {
	
	private int string;
	private int fret;
	private int timestep;
	private Timestep next;
	
	public int getString() {
		return string;
	}
	
	public void setString(int string) {
		this.string = string;
	}
	
	public int getFret() {
		return fret;
	}
	
	public void setFret(int fret) {
		this.fret = fret;
	}
	
	public void setNext(Timestep next) {
		this.next = next;
	}
	
	public Timestep getNext() {
		return this.next;
	}
	
	public int getTimestep() {
		return timestep;
	}
	
	public void setTimestep(int timestep) {
		this.timestep = timestep;
	}

}
