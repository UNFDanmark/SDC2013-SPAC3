package dk.unf.software.aar2013.gruppe3;

import java.util.ArrayList;

import android.util.Log;

public class ProjectileFactory {
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	private Game game;

	public ProjectileFactory(Game game) {
		this.game = game;
	}

	public Projectile getProjectile() {
		Projectile projectile;

		if (projectiles.size() == 0) {
			projectile = new Projectile(game, 4, Faction.ENEMIES);
			// Log.d("ProjectileFactory", "Creating new projectile.");
		} else {
			projectile = projectiles.remove(0);
			// Log.d("ProjectileFactory", "Reusing old projectile.");
		}
		return projectile;
	}

	public void freeProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	public Projectile createBullet(int damage, Faction faction) {
		Projectile projectile = getProjectile();
		projectile.setRemoving(false);
		projectile.setVelX(0.00);
		if (faction == Faction.ENEMIES) {
			projectile.setVelY(600.00);
		} else {
			projectile.setVelY(-600.00);
		}
		projectile.setType(ProjectileType.BULLET);
		projectile.setRadius(4);
		projectile.setDamage(damage);
		projectile.setFaction(faction);
		return projectile;
	}

	public Projectile createPlasma(int damage, Faction faction) {
		Projectile projectile = getProjectile();
		projectile.setRemoving(false);
		projectile.setVelX(0.00);
		projectile.setVelY(-400.00);
		projectile.setType(ProjectileType.PLASMA);
		projectile.setRadius(7);
		projectile.setDamage(damage);
		projectile.setFaction(faction);
		return projectile;
	}

	public Projectile createRocket(int damage, int splash, Faction faction) {
		Projectile projectile = getProjectile();
		projectile.setRemoving(false);
		projectile.setVelX(0.00);
		projectile.setVelY(-100.00);
		projectile.setType(ProjectileType.ROCKET);
		projectile.setRadius(4);
		projectile.setDamage(damage);
		projectile.setFaction(faction);
		projectile.setRocketSeeking(false);
		projectile.setRocketSplash(splash);
		return projectile;
	}

	public Projectile createEye(int damage, Faction faction) {
		Projectile projectile = getProjectile();
		projectile.setRemoving(false);
		projectile.setVelX(0.00);
		projectile.setVelY(0.00);
		projectile.setVelY(600.00);
		projectile.setType(ProjectileType.EYE);
		projectile.setRadius(10);
		projectile.setDamage(damage);
		projectile.setFaction(faction);
		return projectile;
	}
}
