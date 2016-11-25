package dk.unf.software.aar2013.gruppe3;

public class TankNPC extends NPC {
	private double cooldown = 0.50;

	public TankNPC(Game game) {
		super(game, 11, 100);
		setVelY(100);
	}

	@Override
	protected void onDeath() {
		if(!getGame().getPlayer().isDead())
			getGame().addScore(50);
		super.onDeath();
	}

	@Override
	public void update(double dt) {
		cooldown -= dt;
		if (cooldown <= 0) {
			if (!getGame().getPlayer().isDead()) {
				Projectile projectile = getGame().getProjectileFactory()
						.createBullet(1, Faction.ENEMIES);
				projectile.setX(getX());
				projectile.setY(getY());
				projectile.setTargetDirection(getGame().getPlayer());
				getGame().addEntity(projectile);
			}
			cooldown = 0.50;
		}
		super.update(dt);
	}

}
