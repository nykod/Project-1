import java.util.HashMap;

public class Postava {
	private int health;
	private int damage;
	private int armor;
	private String name;
	private String classofp;
	
	
	public String getClassofp() {
		return classofp;
	}
	public void setClassofp(String classofp) {
		this.classofp = classofp;
	}
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public Postava(int health, int damage/*, String classofp*/) {
		super();
		this.health = health;
		this.damage = damage;
		//this.classofp = classofp;
	}

	public void vypisZaKolikUtokuSeZabijete(Postava HLvojin, HashMap<Integer, Vojin> mapVojin, int enemy) {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Tvoje životy: " + HLvojin.getHealth() + " HP");
		System.out.println("Životy nepřitele: " + ((Postava) mapVojin.get(enemy)).getHealth() + " HP");
		System.out.println("--------------------------------------------------------------------------");
		int pocUtEV = HLvojin.getHealth() / ((Postava) mapVojin.get(enemy)).getDamage();
		pocUtEV = pocUtEV + 1;
		int pocUtV = ((Postava) mapVojin.get(enemy)).getHealth() / HLvojin.getDamage();
		pocUtV = pocUtV + 1;
		System.out.println("Nepřitel tě zabije přibližně za " + pocUtEV + " utoku");
		System.out.println("Ty zabiješ nepřitele přibližně za " + pocUtV + " utoku");
		System.out.println("--------------------------------------------------------------------------");
	}
	
	public void healRandomHP(Postava HLvojin, HashMap<Integer, Vojin> mapVojin, int enemy) {
		int randHPadd = (int) (Math.random() * (2 - 1 + 1) + 1);
		int HPaddV = randHPadd;
		int HPadd = ((Postava) mapVojin.get(enemy)).getDamage() - HPaddV;
		int HPaddF = HLvojin.getHealth() + HPadd;
		HLvojin.setHealth(HPaddF);
		System.out.println("Přidal sis " + HPadd + " HP");
		System.out.println("Teď maš " + HLvojin.getHealth() + " HP");
	}

	public void pridaniJednohoArmoru(Postava HLvojin) {
		int ARaddV1 = 1;
		HLvojin.setArmor(ARaddV1);
		System.out.println("Přidal sis 1 brněni!");
		System.out.println("Celkově maš " + HLvojin.getArmor() + " brněni");
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
	public void clasickyUtokHLPostavy(Postava HLvojin, HashMap<Integer, Vojin> mapVojin, int enemy) {
		int h = ((Postava) mapVojin.get(enemy)).getHealth() - HLvojin.getDamage();
		((Postava) mapVojin.get(enemy)).setHealth(h);
		System.out.println("Utočiš ty: ");
		System.out.println("Ubral si mu " + HLvojin.getDamage() + " HP");
		System.out.println("Zustalo mu " +((Postava) mapVojin.get(enemy)).getHealth() + " HP");
		System.out.println("--------------------------------------------------------------------------");
	}

	public void kritickyUtokHLPostavy(Postava HLvojin, HashMap<Integer, Vojin> mapVojin, int enemy, int KritUtV) {
		int ut = ((Postava) mapVojin.get(enemy)).getHealth() - KritUtV;
		((Postava) mapVojin.get(enemy)).setHealth(ut);
		System.out.println("Zautočil si kritikal utokem!");
		System.out.println("Utočiš ty: ");
		System.out.println("Ubral si mu " + KritUtV + " HP");
		System.out.println("Zustalo mu " + ((Postava) mapVojin.get(enemy)).getHealth() + " HP");
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Postava: " + classofp + "\r\nHealth: " + health + "HP \r\nDamage: " + damage;
	}
	
}
