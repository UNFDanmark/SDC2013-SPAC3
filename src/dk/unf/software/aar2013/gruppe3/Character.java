package dk.unf.software.aar2013.gruppe3;

public abstract class Character extends Entity {
	private int health;
	private boolean dead;

	public Character(Game game, double radius, Faction faction, int health) {
		super(game, radius, faction);
		this.setHealth(health);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public void incHealth(int health){
		this.health += health;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public void doDamage(int amount) {
		health -= amount;
		if (health <= 0) {
			health = 0;
			setDead(true);
			onDeath();
		}
	}

	protected void onDeath() {
		setRemoving(true);
	}

	@Override
	public void collision(Entity other) {
		if (other instanceof Character) {
			Character character = (Character) other;
			doDamage(character.getHealth());
		}
		super.collision(other);
	}
}
