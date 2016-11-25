package dk.unf.software.aar2013.gruppe3;

public class ScoutNPC extends NPC {
	private double cooldown = 0.50;

	public ScoutNPC(Game game) {
		super(game, 9, 20);
		setVelY(250);
	}

	@Override
	protected void onDeath() {
		if (!getGame().getPlayer().isDead())
			getGame().addScore(20);
		super.onDeath();
	}

	@Override
	public void update(double dt) {
		cooldown -= dt;
		if (cooldown <= 0) {
			Projectile projectile = getGame().getProjectileFactory()
					.createBullet(4, Faction.ENEMIES);
			projectile.setX(getX());
			projectile.setY(getY());
			getGame().addEntity(projectile);
			cooldown = 0.50;
		}
		super.update(dt);
	}
}
