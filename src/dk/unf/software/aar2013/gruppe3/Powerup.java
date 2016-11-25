package dk.unf.software.aar2013.gruppe3;

public class Powerup extends Entity {
	private PowerupType type;

	public Powerup(Game game, PowerupType type) {
		super(game, 8, Faction.NEUTRAL);
		this.type = type;
	}

	public PowerupType getType() {
		return type;
	}

	public void setType(PowerupType type) {
		this.type = type;
	}

	@Override
	public void collision(Entity other) {
		if (other instanceof Player) {
			Player player = (Player) other;
			switch (getType()) {
			case HEALTH:
				player.incHealth(25);
				if (player.getHealth() > 100)
					player.setHealth(100);
				break;

			case SHIELD:
				break;

			case GUN:
				if (player.getWeapon() == WeaponType.GUNS) {
					player.incWeaponGrade();
				} else {
					player.setWeapon(WeaponType.GUNS);
					player.setWeaponGrade(1);
				}
				break;

			case PLASMA:
				if (player.getWeapon() == WeaponType.PLASMA) {
					player.incWeaponGrade();
				} else {
					player.setWeapon(WeaponType.PLASMA);
					player.setWeaponGrade(1);
				}
				break;

			case ROCKET:
				if (player.getWeapon() == WeaponType.ROCKETS) {
					player.incWeaponGrade();
				} else {
					player.setWeapon(WeaponType.ROCKETS);
					player.setWeaponGrade(1);
				}
				break;

			}
			setRemoving(true);
		}
		// super.collision(other);
	}

}
