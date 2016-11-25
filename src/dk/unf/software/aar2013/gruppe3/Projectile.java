package dk.unf.software.aar2013.gruppe3;

public class Projectile extends Entity {
	private static int ROCKET_SEEK_SPEED = 400;

	private ProjectileType type;
	private int damage = 0;

	private int rocketSplash;
	private boolean rocketSeeking;

	public Projectile(Game game, double radius, Faction faction) {
		super(game, radius, faction);
	}

	public ProjectileType getType() {
		return type;
	}

	public void setType(ProjectileType type) {
		this.type = type;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getRocketSplash() {
		return rocketSplash;
	}

	public void setRocketSplash(int splash) {
		this.rocketSplash = splash;
	}

	public boolean isRocketSeeking() {
		return rocketSeeking;
	}

	public void setRocketSeeking(boolean rocketSeeking) {
		this.rocketSeeking = rocketSeeking;
	}

	@Override
	public void update(double dt) {
		if (getType() == ProjectileType.ROCKET) {
			// rocket physics
			setVelY(getVelY() + 400 * dt * Math.signum(getVelY()));
			if (isRocketSeeking()) {
				// seeking physics
				Character nearest = null;
				for (int i = 0; i < getGame().getEntities().size(); i++) {
					Entity entity = getGame().getEntities().get(i);
					if (entity instanceof Character) {
						Character character2 = (Character) entity;

						if (character2.isDead()) {
							continue;
						}

						if (this.getFaction() == character2.getFaction()) {
							continue;
						}

						if (nearest == null) {
							nearest = character2;
							continue;
						}

						if (distanceSquared(character2) < distanceSquared(nearest)) {
							nearest = character2;
						}
					}
				}
				if (nearest != null) {
					double tx = nearest.getX();
					if (tx < getX()) {
						setX(getX() - dt * ROCKET_SEEK_SPEED);
					} else if (tx > getX()) {
						setX(getX() + dt * ROCKET_SEEK_SPEED);
					}
				}
			}
		}
		super.update(dt);

		if (getX() < 0 || getX() > getGame().getWidth()) {
			setRemoving(true);
			getGame().getProjectileFactory().freeProjectile(this);
		}
		if (getY() < 0 || getY() > getGame().getHeight()) {
			setRemoving(true);
			getGame().getProjectileFactory().freeProjectile(this);
		}
	}

	@Override
	public void collision(Entity other) {
		super.collision(other);

		if (other instanceof Character) {
			Character character = (Character) other;
			if (character.isDead())
				return;

			if (this.getFaction() == other.getFaction())
				return;

			switch (getType()) {
			case BULLET:
				character.doDamage(getDamage());
				getGame()
						.addEntity(
								new Effect(getGame(), EffectType.SPARK, getX(),
										getY()));
				this.setRemoving(true);
				break;
			case EYE:
				character.doDamage(getDamage());
				getGame().addEntity(
						new Effect(getGame(), EffectType.DUST, getX(), getY()));
				this.setRemoving(true);
				break;
			case PLASMA:
				character.doDamage(getDamage());
				getGame()
						.addEntity(
								new Effect(getGame(), EffectType.PLASMA,
										getX(), getY()));
				break;
			case ROCKET:
				for (int i = 0; i < getGame().getEntities().size(); i++) {
					Entity entity = getGame().getEntities().get(i);
					if (entity instanceof Character) {
						Character character2 = (Character) entity;
						if (character2.isDead())
							continue;

						if (this.getFaction() == character2.getFaction())
							continue;

						if (distanceSquared(character2) < rocketSplash
								* rocketSplash) {
							character2.doDamage(getDamage());
							getGame().addEntity(
									new Effect(getGame(), EffectType.DUST,
											getX(), getY()));
						}
					}
				}
				this.setRemoving(true);
				break;
			default:
				break;

			}
		}
	}
}
