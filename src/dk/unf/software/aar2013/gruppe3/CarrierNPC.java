package dk.unf.software.aar2013.gruppe3;

import java.util.Random;

public class CarrierNPC extends NPC {
	private static Random random = new Random();

	public CarrierNPC(Game game) {
		super(game, 11, 50);
		setVelY(300);
	}

	@Override
	protected void onDeath() {
		if(!getGame().getPlayer().isDead())
			getGame().addScore(50);
		super.onDeath();
		
		Powerup powerup = null;
		switch (random.nextInt(3)) {
		case 0:
			powerup = new Powerup(getGame(), PowerupType.GUN);
			break;

		case 1:
			powerup = new Powerup(getGame(), PowerupType.ROCKET);
			break;

		case 2:
			powerup = new Powerup(getGame(), PowerupType.PLASMA);
			break;
		}
		if (powerup == null)
			return;
		powerup.setX(getX());
		powerup.setY(getY());
		powerup.setVelY(300);
		getGame().addEntity(powerup);
	}
	
	
}
