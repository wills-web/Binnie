package binnie.core.machines.power;

import binnie.core.machines.IMachine;

public class ComponentProcessSetCost extends ComponentProcess {
	private final int processLength;
	private final int processEnergy;

	public ComponentProcessSetCost(IMachine machine, int processEnergy, int processLength) {
		super(machine);
		this.processLength = processLength;
		this.processEnergy = processEnergy;
	}

	@Override
	public int getProcessLength() {
		return this.processLength;
	}

	@Override
	public int getProcessEnergy() {
		return this.processEnergy;
	}
}
