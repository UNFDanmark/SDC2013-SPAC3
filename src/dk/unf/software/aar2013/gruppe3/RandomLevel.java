package dk.unf.software.aar2013.gruppe3;

import java.util.Random;

public class RandomLevel extends Level {

	private double spawnEnemy = 5.00;
	private double spawnCarrier = 7.00;
	private double spawnHealth = 10.00;
	private Random random = new Random();

	public RandomLevel(Game game) {
		super(game);
	}

	@Override
	public void init() {
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

		if (spawnEnemy <= 0) {
			NPC npc;
			switch (random.nextInt(16)) {
			case 0:
			case 1:
			case 3:
				npc = new ScoutNPC(getGame());
				npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
				npc.setY(0);
				getGame().addEntity(npc);
				break;
			case 4:
			case 5:
				npc = new FighterNPC(getGame());
				npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
				npc.setY(0);
				getGame().addEntity(npc);
				break;
			case 6:
			case 7:
			case 8:
				npc = new QuickieNPC(getGame());
				npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
				npc.setY(0);
				getGame().addEntity(npc);
				break;
			case 9:
			case 10:
				npc = new TankNPC(getGame());
				npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
				npc.setY(0);
				getGame().addEntity(npc);
				break;
			case 11:
			case 12:
			case 13:
				npc = new SmallMeteorNPC(getGame());
				npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
				npc.setY(0);
				getGame().addEntity(npc);
				break;
			case 14:
			case 15:
				npc = new MediumMeteorNPC(getGame());
				npc.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
				npc.setY(0);
				getGame().addEntity(npc);
				break;
			}

			spawnEnemy = 0.35;
		}
		spawnEnemy -= dt;

		if (spawnCarrier <= 0) {
			NPC carrier = new CarrierNPC(getGame());
			carrier.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
			carrier.setY(0);
			getGame().addEntity(carrier);

			spawnCarrier = 10.00;
		}
		spawnCarrier -= dt;

		if (spawnHealth <= 0) {
			Powerup powerup = new Powerup(getGame(), PowerupType.HEALTH);
			powerup.setX(25 + random.nextInt((int) (getGame().getWidth() - 50)));
			powerup.setY(0);
			powerup.setVelY(300);
			getGame().addEntity(powerup);

			spawnHealth = 5.00;
		}
		spawnHealth -= dt;
	}
}
