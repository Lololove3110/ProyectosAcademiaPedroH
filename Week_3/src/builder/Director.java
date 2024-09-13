package builder;

public class Director {
	public void makePlayer1(Builder builder) {
		builder.born();
		builder.buildGift();
		builder.buildWepon();
		builder.buildHP(300);
		builder.buildRace(new Elf());
	}
	public void makePlayer2(Builder builder) {
		builder.born();
		builder.buildGift();
		builder.buildWepon();
		builder.buildHP(500);
		builder.buildRace(new Draconian());
	}
}
class Draconian extends Race{
	@Override
	public String getRace() {
		return "Draconian";
	}
	
}

class Elf extends Race{
	@Override
	public String getRace() {
		return "Elf";
	}
}
