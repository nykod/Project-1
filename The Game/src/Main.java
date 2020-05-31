import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Vojin vojin1 = new Vojin(15, 3);
		Vojin vojin2 = new Vojin(20, 4);
		Vojin vojin3 = new Vojin(25, 6);
/*
		Luk lucisnik1 = new Luk(13, 4);
		Luk lucisnik2 = new Luk(16, 5);
		Luk lucisnik3 = new Luk(19, 7);

		Mag mag1 = new Mag(10, 5);
		Mag mag2 = new Mag(12, 6);
		Mag mag3 = new Mag(15, 8);

		HashMap<Integer, Mag> mapMag = new HashMap<Integer, Mag>();

		mapMag.put(1, mag1);
		mapMag.put(2, mag2);
		mapMag.put(3, mag3);

		HashMap<Integer, Luk> mapLuk = new HashMap<Integer, Luk>();

		mapLuk.put(4, lucisnik1);
		mapLuk.put(5, lucisnik2);
		mapLuk.put(6, lucisnik3);
*/
		HashMap<Integer, Vojin> mapVojin = new HashMap<Integer, Vojin>();

		mapVojin.put(7, vojin1);
		mapVojin.put(8, vojin2);
		mapVojin.put(9, vojin3);

		// HashMap<Integer, HashMap> map = new HashMap<Integer, HashMap>();
		// Random rand = new Random();
		int randEnemy = (int) (Math.random() * (9 - 1 + 1) + 1);

		Scanner sc = new Scanner(System.in);

		System.out.println("------------------------------The Game-----------------------------");
		System.out.println("[Vitej, dnes si zahrajem hru ktera se jmenuje Hra!]");
		System.out.println("[Jedna se o hru kde si vybereš hrdinu a dostaneš random staty.]");
		System.out.println("[Budeš bojovat proti random soupeřu mužeš buď prohrat nebo vyhrat.]");
		System.out.println("---------------------------Verze hry 0.2---------------------------");

		System.out.println("");
		System.out.println("");

		System.out.println("Vyber si postavu:");
		System.out.println("1 ... Vojin");
		System.out.println("2 ... Lučišnik");
		System.out.println("3 ... Mag");

		int vyberp = sc.nextInt();

		int randMag = (int) (Math.random() * (3 - 1 + 1) + 1);
		int randLuk = (int) (Math.random() * (6 - 4 + 1) + 4);
		int randVojin = (int) (Math.random() * (9 - 7 + 1) + 7);

		if (vyberp == 1) {
			int randHPV = (int) (Math.random() * (25 - 15 + 1) + 15);
			int randDMGV = (int) (Math.random() * (6 - 2 + 1) + 2);
			Vojin HLvojin = new Vojin(randHPV, randDMGV);
			
			HLvojin.setClassofp("Vojin");
			
			
			HLvojin.setArmor(0);

			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Tvoje postava:");
			System.out.println(HLvojin);
			System.out.println("");

			int enemy = randVojin;
			System.out.println("Tvuj enemy:");
			System.out.println(mapVojin.get(enemy));
			System.out.println("--------------------------------------------------------------------------");

			Scanner podtvr1 = new Scanner(System.in);
			System.out.println("Pro pokračovani napiš libovolny znak: ");
			String podtvr1V = podtvr1.next();

			int randPrvniUtok = (int) (Math.random() * (2 - 1 + 1) + 1);

			int randKritUtVS = (int) (Math.random() * (15 - 1 + 1) + 1);
			int KritUtVS = randKritUtVS;
			int KritUtV = 0;
			if (HLvojin.getDamage() <= 3) {
				KritUtV = HLvojin.getDamage() * 2;
			} else if (HLvojin.getDamage() == 4) {
				KritUtV = HLvojin.getDamage() * 2 - 2;
			} else if (HLvojin.getDamage() >= 5) {
				KritUtV = HLvojin.getDamage() * 2 - 4;
			}
			int prvniUtok = randPrvniUtok;
			if (prvniUtok == 1) {
				int h = HLvojin.getHealth() - mapVojin.get(enemy).getDamage();
				HLvojin.setHealth(h);
				System.out.println("Utoči enemy: ");
				System.out.println("Ubral ti " + mapVojin.get(enemy).getDamage() + " HP");
				System.out.println("Zustalo ti " + HLvojin.getHealth() + " HP");
			} else {
				if (KritUtVS == 9) {
					/*int ut = mapVojin.get(enemy).getHealth() - KritUtV;
					mapVojin.get(enemy).setHealth(ut);
					System.out.println("Zautočil si kritikal utokem!");
					System.out.println("Utočiš ty: ");
					System.out.println("Ubral si jemu " + KritUtV + " HP");
					System.out.println("Zustalo mu " + mapVojin.get(enemy).getHealth() + " HP");*/
					HLvojin.kritickyUtokHLPostavy(HLvojin, mapVojin, enemy, KritUtV);
				}
				/*int h = mapVojin.get(enemy).getHealth() - HLvojin.getDamage();
				mapVojin.get(enemy).setHealth(h);
				System.out.println("Utočiš ty: ");
				System.out.println("Ubral si jemu " + HLvojin.getDamage() + " HP");
				System.out.println("Zustalo mu " + mapVojin.get(enemy).getHealth() + " HP");*/
				HLvojin.clasickyUtokHLPostavy(HLvojin, mapVojin, enemy);
			}

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			int vyběr2 = 0;
			if (prvniUtok == 1) {
				//System.out.println("--------------------------------------------------------------------------");
				System.out.println("Maš na vyběr:");
				System.out.println("1 ... Heal random HP");
				System.out.println("2 ... Utok");
				System.out.println("--------------------------------------------------------------------------");

				vyběr2 = sc.nextInt();
				if (vyběr2 == 1) {
					/*int randHPadd = (int) (Math.random() * (2 - 1 + 1) + 1);
					int HPaddV = randHPadd;
					int HPadd = mapVojin.get(enemy).getDamage() - HPaddV;
					int HPaddF = HLvojin.getHealth() + HPadd;
					HLvojin.setHealth(HPaddF);
					System.out.println("Přidal sis " + HPadd + " HP");
					System.out.println("Teď maš " + HLvojin.getHealth() + " HP");*/
					HLvojin.healRandomHP(HLvojin, mapVojin, enemy);
				}
				if (vyběr2 == 2) {
					/*int h = mapVojin.get(enemy).getHealth() - HLvojin.getDamage();
					mapVojin.get(enemy).setHealth(h);
					System.out.println("Utočiš ty: ");
					System.out.println("Ubral si mu " + HLvojin.getDamage() + " HP");
					System.out.println("Zustalo mu " + mapVojin.get(enemy).getHealth() + " HP");*/
					HLvojin.clasickyUtokHLPostavy(HLvojin, mapVojin, enemy);
				}
			} else if (prvniUtok == 2) {
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("Maš na vyběr:");
				System.out.println("1 ... Heal random HP");
				System.out.println("2 ... +1 Brněni");
				System.out.println("Protože jsi utočil jako prvni nemaš na vyběr utok.");
				System.out.println("");

				vyběr2 = sc.nextInt();

				if (vyběr2 == 1) {
					/*int randHPadd = (int) (Math.random() * (2 - 1 + 1) + 1);
					int HPaddV = randHPadd;
					int HPadd = mapVojin.get(enemy).getDamage() - HPaddV;
					int HPaddF = HLvojin.getHealth() + HPadd;
					HLvojin.setHealth(HPaddF);
					System.out.println("Přidal sis " + HPadd + " HP");
					System.out.println("Teď maš " + HLvojin.getHealth() + " HP");*/
					 HLvojin.healRandomHP(HLvojin, mapVojin, enemy);
				} else if (vyběr2 == 2) {
					int ARaddV1 = 1;
					HLvojin.setArmor(ARaddV1);
					System.out.println("Přidal sis 1 brněni!");
					System.out.println("Celkově maš " + HLvojin.getArmor() + " brněni");
				}
			}
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Pro pokračovani napiš libovolny znak: ");
			String podtvr4V = podtvr1.next();

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			System.out.println("--------------------------------------------------------------------------");
			int randVyběrE = (int) (Math.random() * (2 - 1 + 1) + 1);
			int vyběrE = randVyběrE;
			if (vyběrE == 1) {
				int randHPaddE = (int) (Math.random() * (2 - 1 + 1) + 1);
				int HPaddE = randHPaddE;
				int HPaddE2 = HLvojin.getDamage() - HPaddE;
				int HPaddEF = mapVojin.get(enemy).getHealth() + HPaddE2;
				mapVojin.get(enemy).setHealth(HPaddEF);
				System.out.println("Tvuj nepřitel si přidal " + HPaddE2 + " HP");
				System.out.println("Teď ma " + mapVojin.get(enemy).getHealth() + " HP");
				System.out.println("--------------------------------------------------------------------------");
			}
			if (vyběrE == 2) {
				int k = mapVojin.get(enemy).getDamage() - HLvojin.getArmor();
				int h = HLvojin.getHealth() - k;
				HLvojin.setHealth(h);
				System.out.println("Utoči nepřitel: ");
				System.out.println("Ubral ti " + k + " HP");
				System.out.println("Zustalo ti " + HLvojin.getHealth() + " HP");
				System.out.println("--------------------------------------------------------------------------");
			}

			System.out.println("Pro pokračovani napiš libovolny znak: ");
			String podtvr2V = podtvr1.next();
			if (podtvr2V.equals("C2a")) {
				System.out.println("Našel jsi EasterEgg.");
				System.out.println("Mužeš si pojmenovat svoji postavu!");
				System.out.println("Napiš jmeno: ");
				Scanner SCJmeno = new Scanner(System.in);
				String jmeno = SCJmeno.nextLine();
				System.out.println("Tvoje jmeno je: " + jmeno);
				Scanner podtvr2 = new Scanner(System.in);
				System.out.println("Pro pokračovani napiš libovolny znak: ");
				String podtvr3V = podtvr2.next();
			}
			System.out.println("--------------------------------------------------------------------------");
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			if (vyběr2 == 1) {
				/*
				 * System.out.println("Protože jsi už vybiral HP tak ti zustal jen utok");
				 * System.out.println(""); int h = mapVojin.get(enemy).getHealth() -
				 * HLvojin.getDamage(); mapVojin.get(enemy).setHealth(h);
				 * System.out.println("Utočiš ty: "); System.out.println("Ubral si mu " +
				 * HLvojin.getDamage() + " HP"); System.out.println("Zustalo mu " +
				 * mapVojin.get(enemy).getHealth() + " HP"); System.out.println(
				 * "--------------------------------------------------------------------------")
				 * ;
				 */
				System.out.println("Maš na vyběr:");
				System.out.println("1 ... +1 brněni");
				System.out.println("2 ... Utok");
				System.out.println("--------------------------------------------------------------------------");
				int vyběr21 = sc.nextInt();
				if (vyběr21 == 1) {
					int ARaddV1 = 1;
					int ARV1 = HLvojin.getArmor() + ARaddV1;
					HLvojin.setArmor(ARV1);
					System.out.println("Přidal sis 1 brněni!");
					System.out.println("Celkově maš " + HLvojin.getArmor() + " brněni");
				} else if (vyběr21 == 2) {
					/*int h = mapVojin.get(enemy).getHealth() - HLvojin.getDamage();
					mapVojin.get(enemy).setHealth(h);
					System.out.println("Utočiš ty: ");
					System.out.println("Ubral si mu " + HLvojin.getDamage() + " HP");
					System.out.println("Zustalo mu " + mapVojin.get(enemy).getHealth() + " HP");
					System.out.println("--------------------------------------------------------------------------");*/
					HLvojin.clasickyUtokHLPostavy(HLvojin, mapVojin, enemy);
				}

			}
			if (vyběr2 == 2) {

				System.out.println("Maš na vyběr:");
				System.out.println("1 ... Heal random HP");
				System.out.println("2 ... Utok");
				System.out.println("--------------------------------------------------------------------------");

				int vyběr21 = sc.nextInt();
				if (vyběr21 == 1) {
					/*int randHPadd = (int) (Math.random() * (2 - 1 + 1) + 1);
					int HPaddV = randHPadd;
					int HPadd = mapVojin.get(enemy).getDamage() - HPaddV;
					int HPaddF = HLvojin.getHealth() + HPadd;
					HLvojin.setHealth(HPaddF);
					System.out.println("Přidal sis " + HPadd + " HP");
					System.out.println("Teď maš " + HLvojin.getHealth() + " HP");
					System.out.println("--------------------------------------------------------------------------");*/
					HLvojin.healRandomHP(HLvojin, mapVojin, enemy);
				}
				if (vyběr21 == 2) {
					int h = mapVojin.get(enemy).getHealth() - HLvojin.getDamage();
					mapVojin.get(enemy).setHealth(h);
					System.out.println("Utočiš ty: ");
					System.out.println("Ubral si mu " + HLvojin.getDamage() + " HP");
					System.out.println("Zustalo mu " + mapVojin.get(enemy).getHealth() + " HP");
					System.out.println("--------------------------------------------------------------------------");
				}
			}

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if (vyběrE == 1) {
				System.out.println("Protože nepřitel už vybiral HP tak mu zustal jen utok");
				System.out.println("");
				int h = HLvojin.getHealth() - mapVojin.get(enemy).getDamage();
				HLvojin.setHealth(h);
				System.out.println("Utoči nepřitel: ");
				System.out.println("Ubral ti " + mapVojin.get(enemy).getDamage() + " HP");
				System.out.println("Zustalo ti " + HLvojin.getHealth() + " HP");
				System.out.println("--------------------------------------------------------------------------");
			}
			if (vyběrE == 2) {
				int randVyběrE2 = (int) (Math.random() * (2 - 1 + 1) + 1);
				int vyběrE2 = randVyběrE2;
				if (vyběrE2 == 1) {
					int randHPaddE = (int) (Math.random() * (2 - 1 + 1) + 1);
					int HPaddE = randHPaddE;
					int HPaddE2 = HLvojin.getDamage() - HPaddE;
					int HPaddEF = mapVojin.get(enemy).getHealth() + HPaddE2;
					mapVojin.get(enemy).setHealth(HPaddEF);
					System.out.println("Tvuj nepřitel si přidal " + HPaddE2 + " HP");
					System.out.println("Teď ma " + mapVojin.get(enemy).getHealth() + " HP");
				}
				if (vyběrE2 == 2) {
					int k = mapVojin.get(enemy).getDamage() - HLvojin.getArmor();
					int h = HLvojin.getHealth() - k;
					HLvojin.setHealth(h);
					System.out.println("Utoči nepřitel: ");
					System.out.println("Ubral ti " + mapVojin.get(enemy).getDamage() + " HP");
					System.out.println("Zustalo ti " + HLvojin.getHealth() + " HP");
					System.out.println("--------------------------------------------------------------------------");
				}
			}

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("Chceš zjistit za kolik utoku se přibližně zabijete?");
			System.out.println("1 ... Ano");
			System.out.println("2 ... Ne");
			Scanner scUtK = new Scanner(System.in);
			int vyberPZ = scUtK.nextInt();
			if (vyberPZ == 1) {
				/*System.out.println("--------------------------------------------------------------------------");
				System.out.println("Tvoje životy: " + HLvojin.getHealth() + " HP");
				System.out.println("Životy nepřitele: " + mapVojin.get(enemy).getHealth() + " HP");
				System.out.println("--------------------------------------------------------------------------");
				int pocUtEV = HLvojin.getHealth() / mapVojin.get(enemy).getDamage();
				pocUtEV = pocUtEV + 1;
				int pocUtV = mapVojin.get(enemy).getHealth() / HLvojin.getDamage();
				pocUtV = pocUtV + 1;
				System.out.println("Nepřitel tě zabije přibližně za " + pocUtEV + " utoku");
				System.out.println("Ty zabiješ nepřitele přibližně za " + pocUtV + " utoku");
				System.out.println("--------------------------------------------------------------------------");*/
				HLvojin.vypisZaKolikUtokuSeZabijete(HLvojin, mapVojin, enemy);
			}
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			System.out.println("Mužeš si přidat 5 HP nebo 1-3 Damage.");
			System.out.println("1 ... 5 HP");
			System.out.println("2 ... 1-3 DMG");
			System.out.println("3 ... Brněni");
			Scanner vyberSV = new Scanner(System.in);
			int vyberSVI = vyberSV.nextInt();

			/*
			 * if (vyberSVI == 1) { int PHP = HLvojin.getHealth() + 5;
			 * HLvojin.setHealth(PHP); System.out.println("+ 5 HP");
			 * System.out.println("Ted maš " + HLvojin.getHealth() + " HP"); } else if
			 * (vyberSVI == 2) { int randDMGVAdd = (int) (Math.random() * (3 - 1 + 1) + 1);
			 * int DMGVAdd = randDMGVAdd; int PDMG = HLvojin.getDamage() + DMGVAdd;
			 * HLvojin.setDamage(PDMG); System.out.println("+ " + DMGVAdd + " Damage");
			 * System.out.println("Ted maš " + HLvojin.getDamage() + " Damage"); }
			 */

			switch (vyberSVI) {
			case 1:
				int PHP = HLvojin.getHealth() + 5;
				HLvojin.setHealth(PHP);
				System.out.println("+ 5 HP");
				System.out.println("Ted maš " + HLvojin.getHealth() + " HP");

				break;

			case 2:
				int randDMGVAdd = (int) (Math.random() * (3 - 1 + 1) + 1);
				int DMGVAdd = randDMGVAdd;
				int PDMG = HLvojin.getDamage() + DMGVAdd;
				HLvojin.setDamage(PDMG);
				System.out.println("+ " + DMGVAdd + " Damage");
				System.out.println("Ted maš " + HLvojin.getDamage() + " Damage");

				break;

			case 3:
				int randArmorVAdd = (int) (Math.random() * (2 - 1 + 1) + 1);
				int ArmorVAdd = randArmorVAdd;
				HLvojin.setArmor(randArmorVAdd);
				System.out.println("+ " + ArmorVAdd + " Brněni");
				System.out.println("Ted maš " + HLvojin.getDamage() + " Brněni");

				break;
			}

			System.out.println("Chceš vypsat postavy?");
			System.out.println("1 .. Ano");
			System.out.println("2 .. Ne");
			int d = sc.nextInt();
			if (d == 1) {
				System.out.println("Vojin");
				System.out.println("HP: " + HLvojin.getHealth());
				System.out.println("Damage: " + HLvojin.getDamage());
				System.out.println("Brněni: " + HLvojin.getArmor());
			}
			System.out.println("Chceš vypsat nepřitele?");
			System.out.println("1 .. Ano");
			System.out.println("2 .. Ne");
			int d2 = sc.nextInt();
			if (d2 == 1) {
				System.out.println("Vojin nepřitel");
				System.out.println("HP: " + mapVojin.get(enemy).getHealth());
				System.out.println("Damage: " + mapVojin.get(enemy).getDamage());
			}
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		}
		/*
		if (vyberp == 2) {
			int randHPL = (int) (Math.random() * (19 - 13 + 1) + 13);
			int randDMGL = (int) (Math.random() * (7 - 3 + 1) + 3);
			Luk HLluk = new Luk(randHPL, randDMGL);

			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Tvoje postava:");
			System.out.println(HLluk);
			System.out.println("");

			int enemyLuk = randLuk;
			System.out.println("Tvuj enemy:");
			System.out.println(mapLuk.get(enemyLuk));
			System.out.println("--------------------------------------------------------------------------");

			int randPrvniUtok = (int) (Math.random() * (2 - 1 + 1) + 1);
			int prvniUtok = randPrvniUtok;

			if (prvniUtok == 1) {
				int lhp = HLluk.getHealth() - mapLuk.get(enemyLuk).getDamage();
				HLluk.setHealth(lhp);
				System.out.println("Utoči enemy:");
				System.out.println("Ubral ti " + mapLuk.get(enemyLuk).getDamage() + " HP");
				System.out.println("Zustalo ti " + HLluk.getHealth() + " HP");
			} else {
				int lhp = mapLuk.get(enemyLuk).getHealth() - HLluk.getDamage();
				mapLuk.get(enemyLuk).setHealth(lhp);
				System.out.println("Utočiš ty:");
				System.out.println("Ubral jsi mu " + HLluk.getDamage() + " HP");
				System.out.println("Zustalo mu " + mapLuk.get(enemyLuk).getHealth() + " HP");
			}

			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Maš na vyběr:");
			System.out.println("1 ... Heal random HP");
			System.out.println("2 ... Utok");
			System.out.println("--------------------------------------------------------------------------");

			int vyběr2 = sc.nextInt();
			if (vyběr2 == 1) {
				int randHPadd = (int) (Math.random() * (2 - 1 + 1) + 1);
				int HPaddV = randHPadd;
				int HPadd = mapLuk.get(enemyLuk).getDamage() - HPaddV;
				int HPaddF = HLluk.getHealth() + HPadd;
				HLluk.setHealth(HPaddF);
				System.out.println("Přidal sis " + HPadd + " HP");
				System.out.println("Teď maš " + HLluk.getHealth() + " HP");
			}
			if (vyběr2 == 2) {
				int h = mapLuk.get(enemyLuk).getHealth() - HLluk.getDamage();
				mapLuk.get(enemyLuk).setHealth(h);
				System.out.println("Utočiš ty: ");
				System.out.println("Ubral si mu " + HLluk.getDamage() + " HP");
				System.out.println("Zustalo mu " + mapLuk.get(enemyLuk).getHealth() + " HP");
			}

			System.out.println("--------------------------------------------------------------------------");
			int randVyběrE = (int) (Math.random() * (2 - 1 + 1) + 1);
			int vyběrE = randVyběrE;
			if (vyběrE == 1) {
				int randHPaddE = (int) (Math.random() * (2 - 1 + 1) + 1);
				int HPaddE = randHPaddE;
				int HPaddE2 = HLluk.getDamage() - HPaddE;
				int HPaddEF = mapLuk.get(enemyLuk).getHealth() + HPaddE2;
				mapLuk.get(enemyLuk).setHealth(HPaddEF);
				System.out.println("Tvuj nepřitel si přidal " + HPaddE2 + " HP");
				System.out.println("Teď ma " + mapLuk.get(enemyLuk).getHealth() + " HP");
			}
			if (vyběrE == 2) {
				int h = HLluk.getHealth() - mapLuk.get(enemyLuk).getDamage();
				HLluk.setHealth(h);
				System.out.println("Utoči nepřitel: ");
				System.out.println("Ubral ti " + mapLuk.get(enemyLuk).getDamage() + " HP");
				System.out.println("Zustalo ti " + HLluk.getHealth() + " HP");
				// System.out.println("--------------------------------------------------------------------------");
			}

			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if (vyběr2 == 1) {
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("Protože jsi už vybiral HP tak ti zustal jen utok");
				System.out.println("");
				int h = mapLuk.get(enemyLuk).getHealth() - HLluk.getDamage();
				mapLuk.get(enemyLuk).setHealth(h);
				System.out.println("Utočiš ty: ");
				System.out.println("Ubral si mu " + HLluk.getDamage() + " HP");
				System.out.println("Zustalo mu " + mapLuk.get(enemyLuk).getHealth() + " HP");
				System.out.println("--------------------------------------------------------------------------");
			}
			if (vyběr2 == 2) {

				System.out.println("Maš na vyběr:");
				System.out.println("1 ... Heal random HP");
				System.out.println("2 ... Utok");
				System.out.println("--------------------------------------------------------------------------");

				int vyběr21 = sc.nextInt();
				if (vyběr21 == 1) {
					int randHPadd = (int) (Math.random() * (2 - 1 + 1) + 1);
					int HPaddV = randHPadd;
					int HPadd = mapLuk.get(enemyLuk).getDamage() - HPaddV;
					int HPaddF = HLluk.getHealth() + HPadd;
					HLluk.setHealth(HPaddF);
					System.out.println("Přidal sis " + HPadd + " HP");
					System.out.println("Teď maš " + HLluk.getHealth() + " HP");
					System.out.println("--------------------------------------------------------------------------");
				}
				if (vyběr21 == 2) {
					int h = mapLuk.get(enemyLuk).getHealth() - HLluk.getDamage();
					mapLuk.get(enemyLuk).setHealth(h);
					System.out.println("Utočiš ty: ");
					System.out.println("Ubral si mu " + HLluk.getDamage() + " HP");
					System.out.println("Zustalo mu " + mapLuk.get(enemyLuk).getHealth() + " HP");
					System.out.println("--------------------------------------------------------------------------");
				}
			}

		}

		if (vyberp == 3) {
			int randHPM = (int) (Math.random() * (15 - 10 + 1) + 10);
			int randDMGM = (int) (Math.random() * (8 - 4 + 1) + 4);
			Mag HLmag = new Mag(randHPM, randDMGM);

			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Tvoje postava:");
			System.out.println(HLmag);
			System.out.println("");

			int enemyMag = randMag;
			System.out.println("Tvuj nepřitel: ");
			System.out.println(mapMag.get(enemyMag));
			System.out.println("--------------------------------------------------------------------------");

			int randPrvniUtok = (int) (Math.random() * (2 - 1 + 1) + 1);
			int prvniUtok = randPrvniUtok;

			if (prvniUtok == 1) {
				int mhp = HLmag.getHealth() - mapMag.get(enemyMag).getHealth();
				HLmag.setHealth(mhp);
				System.out.println("Utoči nepřitel:");
				System.out.println("Ubral ti " + mapMag.get(enemyMag).getDamage() + " HP");
				System.out.println("Zustalo ti " + HLmag.getHealth() + " HP");
			} else {
				int mhp = mapMag.get(enemyMag).getHealth() - HLmag.getDamage();
				mapMag.get(enemyMag).setHealth(mhp);
				System.out.println("Utočiš ty: ");
				System.out.println("Ubral jsi mu " + HLmag.getDamage() + " HP");
				System.out.println("Zustalo mu " + mapMag.get(enemyMag).getHealth() + " HP");
			}
		}

		
		 * if (vyberp == 1) { System.out.println(
		 * "--------------------------------------------------------------------------")
		 * ; Vojin vojin = new Vojin(20, 3); System.out.println("Vaše postava: ");
		 * System.out.println(vojin); System.out.println(
		 * "--------------------------------------------------------------------------")
		 * ;
		 * 
		 * Luk luk = new Luk(20, 4); int e = vojin.getHealth() - luk.getDamage(); int n
		 * = luk.getHealth() - vojin.getDamage();
		 * 
		 * System.out.println("Boj: "); System.out.println(""); Vojin vojin2 = new
		 * Vojin(e, 3); System.out.println(vojin2); System.out.println(""); Luk luk2 =
		 * new Luk(n, 4); System.out.println(luk2); System.out.println(
		 * "--------------------------------------------------------------------------")
		 * ;
		 * 
		 * } if (vyberp == 2) { System.out.println(
		 * "--------------------------------------------------------------------------")
		 * ; Luk luk = new Luk(20, 4); System.out.println("Vaše postava: ");
		 * System.out.println(luk); System.out.println(
		 * "--------------------------------------------------------------------------")
		 * ; }
		 */
	}

}
