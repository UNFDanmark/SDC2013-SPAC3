package dk.unf.software.aar2013.gruppe3;

public class EyeNPC extends NPC {
	private double cooldown = 0.10;
	private boolean left;
	
	public EyeNPC(Game game) {
		super(game, 14, 1000);
		
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	@Override
	public void update(double dt) {
		cooldown -= dt;
		if (cooldown <= 0) {
			if (!getGame().getPlayer().isDead()) {
				Projectile projectile = getGame().getProjectileFactory()
						.createEye(4, Faction.ENEMIES);
				projectile.setX(getX());
				projectile.setY(getY());
				projectile.setTargetDirection(getGame().getPlayer());
				getGame().addEntity(projectile);
			}
			cooldown = 0.20;
		}
		super.update(dt);
	}
}
