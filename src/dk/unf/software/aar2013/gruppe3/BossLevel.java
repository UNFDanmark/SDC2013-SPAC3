package dk.unf.software.aar2013.gruppe3;

public class BossLevel extends Level {
	private BrainNPC brain;

	public BossLevel(Game game) {
		super(game);
	}

	@Override
	public void init() {
		brain = new BrainNPC(getGame());
		brain.setX(getGame().getWidth() / 2);
		brain.setY(200);
		getGame().addEntity(brain);

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
		powerup = new Powerup(getGame(), PowerupType.GUN);
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
		powerup = new Powerup(getGame(), PowerupType.GUN);
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
		powerup = new Powerup(getGame(), PowerupType.GUN);
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
		powerup = new Powerup(getGame(), PowerupType.GUN);
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
		if(!getGame().getPlayer().isDead() && brain.isDead() )
			getGame().setWon(true);
	}

}
