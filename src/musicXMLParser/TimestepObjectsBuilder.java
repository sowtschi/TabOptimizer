package musicXMLParser;

import java.util.ArrayList;

import models.Timestep;

public class TimestepObjectsBuilder {
	
	private static int tabNumber;
	
	private ArrayList<Timestep> timesteps = new ArrayList<Timestep>();
	private ArrayList<Integer> frets = new ArrayList<Integer>();
	private ArrayList<Integer> strings = new ArrayList<Integer>();
	private ArrayList<Integer> numberOfFretsPerTimestep = new ArrayList<Integer>();

	public TimestepObjectsBuilder (ArrayList<Integer> strings, ArrayList<Integer> frets, ArrayList<Integer> numberOfFretsPerTimestep ) {
		this.strings = strings;
		this.frets = frets;
		this.numberOfFretsPerTimestep = numberOfFretsPerTimestep;
		this.tabNumber +=1;
	}
	
	public ArrayList<Timestep> createTimestepObjects() {
		int numberOfFretsCounter = 0;
		int actualTimestep=0;
		
		for (int i = 0; i < strings.size(); i++) {
			Timestep timestep = new Timestep();
			timestep.setString(strings.get(i));
			timestep.setFret(frets.get(i));
			timestep.setTimestep(actualTimestep);
			
			if (i!=0)
				timesteps.get(i-1).setNext(timestep);
			
			if (i==numberOfFretsCounter && actualTimestep<numberOfFretsPerTimestep.size()) {
				numberOfFretsCounter += numberOfFretsPerTimestep.get(actualTimestep);
				actualTimestep++;
			}
			
			timesteps.add(timestep);
		}

		return timesteps;
	}
}

