package builder;

public class Ninja implements Builder{
	
	private Ninja1 ninja;
	
	
	@Override
	public void born() {
		this.ninja = new Ninja1();
	}
	@Override
	public void buildRace(Race race) {
		
		ninja.addSection("Race: "+race.getRace());	
	}
	
	@Override
	public void buildHP(int hp) {
		ninja.addSection("HP: "+hp);
		
	}
	@Override
	public void buildWepon() {
		ninja.addSection("Wepon: Katana");
		
	}
	@Override
	public void buildGift() {
		ninja.addSection("Gift: Smoke bombs");
		
	}
	
	public Ninja1 getResult() {
		return this.ninja;
	}

}
