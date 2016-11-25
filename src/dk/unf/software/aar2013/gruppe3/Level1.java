package dk.unf.software.aar2013.gruppe3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import android.annotation.SuppressLint;

public class Level1 extends Level {
	@SuppressLint("UseSparseArrays")
	Map<Integer, Boolean> events = new HashMap<Integer, Boolean>();

	private Random random = new Random();
	private double total;
	private double spawnCarrier = 7.00;
	private double spawnHealth = 10.00;
	private double cooldown1 = 0.00;
	private double cooldown2 = 0.00;
	private double cooldown3 = 0.00;
	private double cooldown4 = 0.00;
	private double cooldown5 = 0.00;

	public Level1(Game game) {
		super(game);
	}

	@Override
	public void init() {
		total = 0.00;
		Powerup powerup = new Powerup(getGame(), PowerupType.GUN);
		powerup.setX(getGame().getWidth() / 2);
		powerup.setY(0);
		powerup.setVelY(200);
		getGame().addEntity(powerup);
		powerup = new Powerup(getGame(), PowerupType.PLASMA);
		powerup.setX(getGame().getWidth() / 2 + 100);
		powerup.setY(0);
		powerup.setVelY(200);
		getGame().addEntity(powerup);
		powerup = new Powerup(getGame(), PowerupType.ROCKET);
		powerup.setX(getGame().getWidth() / 2 - 100);
		powerup.setY(0);
		powerup.setVelY(200);
		getGame().addEntity(powerup);
	}

	@Override
	public void update(double dt) {
		int i = 0;
		total += dt;

		if (spawnCarrier <= 0 && !getGame().hasWon()) {
			NPC carrier = new CarrierNPC(getGame());
			carrier.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
			carrier.setY(0);
			getGame().addEntity(carrier);

			spawnCarrier = 15.00;
		}
		spawnCarrier -= dt;

		if (spawnHealth <= 0 && !getGame().hasWon()) {
			Powerup powerup = new Powerup(getGame(), PowerupType.HEALTH);
			powerup.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
			powerup.setY(0);
			powerup.setVelY(300);
			getGame().addEntity(powerup);

			spawnHealth = 10.00;
		}
		spawnHealth -= dt;

		i += 1;
		cooldown1 -= dt;
		if (!events.containsKey(i) && total > 0.00 && cooldown1 <= 0) {
			NPC npc = new SmallMeteorNPC(getGame());
			npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
			npc.setY(0);
			getGame().addEntity(npc);
			if (total > 10.00)
				events.put(i, true);
			cooldown1 = 0.20;
		}

		i += 1;
		cooldown2 -= dt;
		if (!events.containsKey(i) && total > 10.00 && cooldown2 <= 0) {
			NPC npc = new SmallMeteorNPC(getGame());
			npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
			npc.setY(0);
			getGame().addEntity(npc);
			if (total > 20.00)
				events.put(i, true);
			cooldown2 = 0.15;
		}

		i += 1;
		cooldown3 -= dt;
		if (!events.containsKey(i) && total > 20.00 && cooldown3 <= 0) {
			NPC npc = new MediumMeteorNPC(getGame());
			npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
			npc.setY(0);
			getGame().addEntity(npc);
			if (total > 25.00)
				events.put(i, true);
			cooldown3 = 0.15;
		}

		i += 1;
		cooldown4 -= dt;
		if (!events.containsKey(i) && total > 25.00 && cooldown4 <= 0) {
			NPC npc = new ScoutNPC(getGame());
			npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
			npc.setY(0);
			getGame().addEntity(npc);
			if (total > 30.00)
				events.put(i, true);
			cooldown4 = 0.20;
		}

		i += 1;
		if (!events.containsKey(i) && total > 30.00) {
			NPC npc = new ScoutNPC(getGame());
			npc.setX(getGame().getWidth() / 2);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		if (!events.containsKey(i) && total > 30.40) {
			NPC npc = new ScoutNPC(getGame());
			npc.setX(getGame().getWidth() / 2 - 40);
			npc.setY(0);
			getGame().addEntity(npc);
			npc = new ScoutNPC(getGame());
			npc.setX(getGame().getWidth() / 2 + 40);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		if (!events.containsKey(i) && total > 30.80) {
			NPC npc = new ScoutNPC(getGame());
			npc.setX(getGame().getWidth() / 2 - 80);
			npc.setY(0);
			getGame().addEntity(npc);
			npc = new ScoutNPC(getGame());
			npc.setX(getGame().getWidth() / 2 + 80);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		if (!events.containsKey(i) && total > 31.20) {
			NPC npc = new ScoutNPC(getGame());
			npc.setX(getGame().getWidth() / 2 - 120);
			npc.setY(0);
			getGame().addEntity(npc);
			npc = new ScoutNPC(getGame());
			npc.setX(getGame().getWidth() / 2 + 120);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		if (!events.containsKey(i) && total > 31.60) {
			NPC npc = new ScoutNPC(getGame());
			npc.setX(getGame().getWidth() / 2 - 160);
			npc.setY(0);
			getGame().addEntity(npc);
			npc = new ScoutNPC(getGame());
			npc.setX(getGame().getWidth() / 2 + 160);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		if (!events.containsKey(i) && total > 32.00) {
			NPC npc = new ScoutNPC(getGame());
			npc.setX(getGame().getWidth() / 2 - 200);
			npc.setY(0);
			getGame().addEntity(npc);
			npc = new ScoutNPC(getGame());
			npc.setX(getGame().getWidth() / 2 + 200);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		if (!events.containsKey(i) && total > 33.00) {
			NPC npc = new FighterNPC(getGame());
			npc.setX(getGame().getWidth() / 2);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		if (!events.containsKey(i) && total > 33.40) {
			NPC npc = new FighterNPC(getGame());
			npc.setX(getGame().getWidth() / 2 - 40);
			npc.setY(0);
			getGame().addEntity(npc);
			npc = new FighterNPC(getGame());
			npc.setX(getGame().getWidth() / 2 + 40);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		if (!events.containsKey(i) && total > 33.80) {
			NPC npc = new FighterNPC(getGame());
			npc.setX(getGame().getWidth() / 2 - 80);
			npc.setY(0);
			getGame().addEntity(npc);
			npc = new FighterNPC(getGame());
			npc.setX(getGame().getWidth() / 2 + 80);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		if (!events.containsKey(i) && total > 34.20) {
			NPC npc = new FighterNPC(getGame());
			npc.setX(getGame().getWidth() / 2 - 120);
			npc.setY(0);
			getGame().addEntity(npc);
			npc = new FighterNPC(getGame());
			npc.setX(getGame().getWidth() / 2 + 120);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		if (!events.containsKey(i) && total > 34.60) {
			NPC npc = new FighterNPC(getGame());
			npc.setX(getGame().getWidth() / 2 - 160);
			npc.setY(0);
			getGame().addEntity(npc);
			npc = new FighterNPC(getGame());
			npc.setX(getGame().getWidth() / 2 + 160);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		if (!events.containsKey(i) && total > 35.00) {
			NPC npc = new FighterNPC(getGame());
			npc.setX(getGame().getWidth() / 2 - 200);
			npc.setY(0);
			getGame().addEntity(npc);
			npc = new FighterNPC(getGame());
			npc.setX(getGame().getWidth() / 2 + 200);
			npc.setY(0);
			getGame().addEntity(npc);
			events.put(i, true);
		}

		i += 1;
		cooldown5 -= dt;
		if (!events.containsKey(i) && total > 36.00 && cooldown5 <= 0) {
			NPC npc;
			switch(random.nextInt(7)){
			case 0:
			case 1:
			case 2:
			case 3:
				npc = new QuickieNPC(getGame());
				npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
				npc.setY(0);
				getGame().addEntity(npc);
			case 4:
			case 5:
				npc = new ScoutNPC(getGame());
				npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
				npc.setY(0);
				getGame().addEntity(npc);
				break;
			case 6:
				npc = new FighterNPC(getGame());
				npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
				npc.setY(0);
				getGame().addEntity(npc);
				break;
			}
			if (total > 60.00)
				events.put(i, true);
			cooldown5 = 0.30;
		}
		if (!getGame().getPlayer().isDead() && total > 65.00)
			getGame().setWon(true);
	}

}
