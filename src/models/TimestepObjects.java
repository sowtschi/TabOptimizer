package models;

import java.util.ArrayList;

public class TimestepObjects {
	
	private ArrayList<Timestep> timesteps;
	private int[] timestep = new int[6];

	public TimestepObjects(ArrayList<Timestep> timesteps) {
		this.timesteps = timesteps;
	}
	
	public int getSize() {
		return timesteps.size();
	}

	public void printTimesteps() {
		initializeTimestepArray();
		int index = 0;
		
		for (Timestep timestep : timesteps) {
			fillTimestep(timestep);
			
			if (index<timesteps.size()-1) {
				if (timesteps.get(index).getNext().getTimestep() != timesteps.get(index).getTimestep()) {
					printTimestep();
					System.out.println();
					initializeTimestepArray();
				}
			} else {
				printTimestep();
			}
			
			index++;
		}
		
	}

	private void fillTimestep(Timestep timestep) {
		switch (timestep.getString()) {
			case 1:
				this.timestep[0] = timestep.getFret();
				break;
			case 2:
				this.timestep[1] = timestep.getFret();
				break;
			case 3:
				this.timestep[2] = timestep.getFret();
				break;
			case 4:
				this.timestep[3] = timestep.getFret();
				break;
			case 5:
				this.timestep[4] = timestep.getFret();
				break;
			case 6:
				this.timestep[5] = timestep.getFret();
				break;
		}
	}

	private void printTimestep() {
		System.out.println(this.timestep[0]);
		System.out.println(this.timestep[1]);
		System.out.println(this.timestep[2]);
		System.out.println(this.timestep[3]);
		System.out.println(this.timestep[4]);
		System.out.println(this.timestep[5]);
	}

	private void initializeTimestepArray() {
		timestep[0] = -1;
		timestep[1] = -1;
		timestep[2] = -1;
		timestep[3] = -1;
		timestep[4] = -1;
		timestep[5] = -1;
	}

}
