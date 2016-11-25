package dk.unf.software.aar2013.gruppe3;

public class FighterNPC extends NPC {
	private double cooldown = 0.50;

	public FighterNPC(Game game) {
		super(game, 11, 20);
		setVelY(200);
	}

	@Override
	protected void onDeath() {
		if(!getGame().getPlayer().isDead())
			getGame().addScore(30);
		super.onDeath();
	}

	@Override
	public void update(double dt) {
		cooldown -= dt;
		if (cooldown <= 0) {
			if (!getGame().getPlayer().isDead()) {
				Projectile projectile = getGame().getProjectileFactory()
						.createBullet(4, Faction.ENEMIES);
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
