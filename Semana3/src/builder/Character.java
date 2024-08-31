package builder;

public class Character {
	private Race race;
	private int hp;
	private Wepon wepon;
	private Gift gift;
	
	public void buildRace(Race race) {
		this.race=race;
	}
	public void buildHP(int hp) {
		this.hp=hp;
	}
	
	public void buildWepon(Wepon wepon) {
		this.wepon=wepon;
	}
	
	public void buildGift(Gift gift) {
		this.gift=gift;
	}
	@Override
	public String toString() {
		return "Character [race=" + race + ", hp=" + hp + ", wepon=" + wepon + ", gift=" + gift + "]";
	}
	
	

}

class Race{
	public String getRace() {
		return "Human";
		
	}
	
}
class Ninja1{
	private StringBuilder content = new StringBuilder();
	
	public void addSection(String section) {
		content.append(section).append("\n");
	}
	@Override
	public String toString() {
		return content.toString();
	}
}
class Wizard1{
	private StringBuilder content = new StringBuilder();
	public void addSection(String section) {
		content.append(section).append("\n");
	}
	@Override
	public String toString() {
		return content.toString();
	}
}


class Gift{}
class Wepon{}
