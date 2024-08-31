package builder;

public class Wizard implements Builder{
private Wizard1 wizard;
	
	
	@Override
	public void born() {
		this.wizard = new Wizard1();
	}
	@Override
	public void buildRace(Race race) {
		
		wizard.addSection("Race: "+race.getRace());	
	}
	
	@Override
	public void buildHP(int hp) {
		wizard.addSection("HP: "+hp);
		
	}
	@Override
	public void buildWepon() {
		wizard.addSection("Wepon: Catalysts");
		
	}
	@Override
	public void buildGift() {
		wizard.addSection("Gift: HP potion");
		
	}
	
	public Wizard1 getResult() {
		return this.wizard;
	}

}
