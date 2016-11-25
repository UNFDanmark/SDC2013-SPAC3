package dk.unf.software.aar2013.gruppe3;

import android.os.Vibrator;

public class Player extends Character {

	private WeaponType weapon = WeaponType.ROCKETS;
	private int weaponGrade = 0;
	private double desiredX;
	private double desiredY;
	private double speed = 600;
	private boolean moving;
	private boolean shooting;
	private double cooldown;

	private boolean rocketLeft;
	private int rocketSeekerCount = 0;

	public Player(Game game) {
		super(game, 13, Faction.PLAYERS, 100);
	}

	public WeaponType getWeapon() {
		return weapon;
	}

	public void setWeapon(WeaponType weapon) {
		this.weapon = weapon;
	}

	public int getWeaponGrade() {
		return weaponGrade;
	}

	public void setWeaponGrade(int level) {
		this.weaponGrade = level;
		if (this.weaponGrade < 0)
			this.weaponGrade = 0;
		if (this.weaponGrade > 5)
			this.weaponGrade = 5;
	}

	public void subWeaponGrade() {
		this.weaponGrade -= 1;
		if (this.weaponGrade < 0)
			this.weaponGrade = 0;
	}

	public void incWeaponGrade() {
		this.weaponGrade += 1;
		if (this.weaponGrade > 5)
			this.weaponGrade = 5;
	}

	@Override
	public void doDamage(int amount) {
		getGame().getVibrator().vibrate(10);
		super.doDamage(amount);
	}

	public double getDesiredX() {
		return desiredX;
	}

	public void setDesiredX(double targetX) {
		this.desiredX = targetX;
	}

	public double getDesiredY() {
		return desiredY;
	}

	public void setDesiredY(double targetY) {
		this.desiredY = targetY;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public boolean isShooting() {
		return shooting;
	}

	public void setShooting(boolean shooting) {
		this.shooting = shooting;
	}

	private void resetCooldown() {
		switch (getWeapon()) {
		case GUNS:
			switch (weaponGrade) {
			case 1:
				cooldown = 0.20;
				break;
			case 2:
				cooldown = 0.18;
				break;
			case 3:
				cooldown = 0.18;
				break;
			case 4:
				cooldown = 0.16;
				break;
			case 5:
				cooldown = 0.16;
				break;
			}
			break;

		case PLASMA:
			cooldown = 0.40;

			break;

		case ROCKETS:
			switch (weaponGrade) {
			case 1:
				cooldown = 0.50;
				break;
			case 2:
				cooldown = 0.48;
				break;
			case 3:
				cooldown = 0.46;
				break;
			case 4:
				cooldown = 0.44;
				break;
			case 5:
				cooldown = 0.42;
				break;
			}

			break;
		}
	}

	private void fireGuns() {
		Projectile projectile;

		switch (weaponGrade) {
		case 1:
			projectile = getGame().getProjectileFactory().createBullet(10,
					Faction.PLAYERS);
			projectile.setX(getX());
			projectile.setY(getY() - 15);
			getGame().addEntity(projectile);
			break;
		case 2:
			projectile = getGame().getProjectileFactory().createBullet(8,
					Faction.PLAYERS);
			projectile.setX(getX() - 2);
			projectile.setY(getY() - 15);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createBullet(8,
					Faction.PLAYERS);
			projectile.setX(getX() + 2);
			projectile.setY(getY() - 15);
			getGame().addEntity(projectile);
			break;
		case 3:
			projectile = getGame().getProjectileFactory().createBullet(12,
					Faction.PLAYERS);
			projectile.setX(getX() - 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createBullet(12,
					Faction.PLAYERS);
			projectile.setX(getX() + 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			break;
		case 4:
			projectile = getGame().getProjectileFactory().createBullet(8,
					Faction.PLAYERS);
			projectile.setX(getX() - 2);
			projectile.setY(getY() - 15);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createBullet(8,
					Faction.PLAYERS);
			projectile.setX(getX() + 2);
			projectile.setY(getY() - 15);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createBullet(12,
					Faction.PLAYERS);
			projectile.setX(getX() - 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createBullet(12,
					Faction.PLAYERS);
			projectile.setX(getX() + 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			break;
		case 5:
			projectile = getGame().getProjectileFactory().createBullet(8,
					Faction.PLAYERS);
			projectile.setX(getX() - 2);
			projectile.setY(getY() - 15);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createBullet(8,
					Faction.PLAYERS);
			projectile.setX(getX() + 2);
			projectile.setY(getY() - 15);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createBullet(12,
					Faction.PLAYERS);
			projectile.setX(getX() - 12);
			projectile.setY(getY() + 5);
			projectile.setVelX(-60);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createBullet(12,
					Faction.PLAYERS);
			projectile.setX(getX() + 12);
			projectile.setY(getY() + 5);
			projectile.setVelX(60);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createBullet(12,
					Faction.PLAYERS);
			projectile.setX(getX() - 12);
			projectile.setY(getY() + 5);
			projectile.setVelX(60);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createBullet(12,
					Faction.PLAYERS);
			projectile.setX(getX() + 12);
			projectile.setY(getY() + 5);
			projectile.setVelX(-60);
			getGame().addEntity(projectile);
			break;
		}
	}

	private void firePlasma() {
		Projectile projectile;

		switch (weaponGrade) {
		case 1:
			projectile = getGame().getProjectileFactory().createPlasma(4,
					Faction.PLAYERS);
			projectile.setX(getX());
			projectile.setY(getY() - 15);
			getGame().addEntity(projectile);
			break;
		case 2:
			projectile = getGame().getProjectileFactory().createPlasma(4,
					Faction.PLAYERS);
			projectile.setX(getX());
			projectile.setY(getY() - 15);
			getGame().addEntity(projectile);
			break;
		case 3:
			projectile = getGame().getProjectileFactory().createPlasma(3,
					Faction.PLAYERS);
			projectile.setX(getX() - 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createPlasma(3,
					Faction.PLAYERS);
			projectile.setX(getX() + 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			break;
		case 4:
			projectile = getGame().getProjectileFactory().createPlasma(4,
					Faction.PLAYERS);
			projectile.setX(getX() - 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createPlasma(4,
					Faction.PLAYERS);
			projectile.setX(getX() + 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			break;
		case 5:
			projectile = getGame().getProjectileFactory().createPlasma(4,
					Faction.PLAYERS);
			projectile.setX(getX() - 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createPlasma(4,
					Faction.PLAYERS);
			projectile.setX(getX() + 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			break;
		}
	}

	private void fireRockets() {
		Projectile projectile;

		switch (weaponGrade) {
		case 1:
			projectile = getGame().getProjectileFactory().createRocket(50, 75,
					Faction.PLAYERS);
			if (rocketLeft)
				projectile.setX(getX() - 12);
			else
				projectile.setX(getX() + 12);
			rocketLeft = !rocketLeft;
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			break;
		case 2:
			projectile = getGame().getProjectileFactory().createRocket(50, 100,
					Faction.PLAYERS);
			if (rocketLeft)
				projectile.setX(getX() - 12);
			else
				projectile.setX(getX() + 12);
			rocketLeft = !rocketLeft;
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			break;
		case 3:
			projectile = getGame().getProjectileFactory().createRocket(75, 125,
					Faction.PLAYERS);
			if (rocketLeft)
				projectile.setX(getX() - 12);
			else
				projectile.setX(getX() + 12);
			rocketLeft = !rocketLeft;
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			break;
		case 4:
			projectile = getGame().getProjectileFactory().createRocket(75, 150,
					Faction.PLAYERS);
			projectile.setX(getX() - 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createRocket(75, 150,
					Faction.PLAYERS);
			projectile.setX(getX() + 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			break;
		case 5:
			rocketSeekerCount -= 1;
			if (rocketSeekerCount <= 0) {
				projectile = getGame().getProjectileFactory().createRocket(50,
						100, Faction.PLAYERS);
				projectile.setX(getX());
				projectile.setY(getY() - 15);
				projectile.setRocketSeeking(true);
				getGame().addEntity(projectile);
				rocketSeekerCount = 4;
			}
			projectile = getGame().getProjectileFactory().createRocket(75, 150,
					Faction.PLAYERS);
			projectile.setX(getX() - 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			projectile = getGame().getProjectileFactory().createRocket(75, 150,
					Faction.PLAYERS);
			projectile.setX(getX() + 12);
			projectile.setY(getY() + 5);
			getGame().addEntity(projectile);
			break;
		}
	}

	private void fire() {
		if (isDead())
			return;

		switch (getWeapon()) {
		case GUNS:
			fireGuns();
			break;
		case PLASMA:
			firePlasma();
			break;
		case ROCKETS:
			fireRockets();
			break;
		}
	}

	@Override
	public void update(double dt) {
		if (isMoving() && !isDead()) {
			double dx = getDesiredX() - getX();
			double dy = getDesiredY() - getY();
			double dist = Math.sqrt(dx * dx + dy * dy);

			if (dist < getSpeed() * dt) {
				setX(getDesiredX());
				setY(getDesiredY());
			} else {
				double angle = Math.atan2(dy, dx);
				setX(getX() + Math.cos(angle) * speed * dt);
				setY(getY() + Math.sin(angle) * speed * dt);
			}
			if (getY() < 50)
				setY(50);
		}

		cooldown -= dt;
		if (isShooting() && cooldown <= 0) {
			fire();
			resetCooldown();
		}
	}

}
