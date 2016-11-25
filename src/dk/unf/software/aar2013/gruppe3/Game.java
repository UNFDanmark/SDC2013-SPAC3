package dk.unf.software.aar2013.gruppe3;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.os.Vibrator;

public class Game {
	private Level level;
	private double width;
	private double height;
	private boolean won;
	private Vibrator vibrator;
	private int score;
	private double totalTime;
	private Player player;
	private ProjectileFactory projectileFactory;

	private ArrayList<Entity> entities = new ArrayList<Entity>();
	private ArrayList<Entity> removingEntities = new ArrayList<Entity>();

	public Game(double width, double height, Vibrator vibrator) {
		this.width = width;
		this.height = height;
		this.vibrator = vibrator;
		this.projectileFactory = new ProjectileFactory(this);
	}

	public synchronized Level getLevel() {
		return level;
	}

	public synchronized void setLevel(Level level) {
		this.level = level;
		entities.clear();
		init();
	}

	public synchronized double getWidth() {
		return width;
	}

	public synchronized void setWidth(double width) {
		this.width = width;
	}

	public synchronized double getHeight() {
		return height;
	}

	public synchronized void setHeight(double height) {
		this.height = height;
	}

	public Vibrator getVibrator() {
		return vibrator;
	}

	public void setContext(Vibrator vibrator) {
		this.vibrator = vibrator;
	}

	public synchronized int getScore() {
		return score;
	}

	public synchronized void setScore(int score) {
		this.score = score;
	}

	public synchronized void addScore(int score) {
		this.score += score;
	}

	public synchronized double getTotalTime() {
		return totalTime;
	}

	public synchronized void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}

	public synchronized Player getPlayer() {
		return player;
	}

	public synchronized void setPlayer(Player player) {
		this.player = player;
	}

	public synchronized ProjectileFactory getProjectileFactory() {
		return projectileFactory;
	}

	public synchronized void setProjectileFactory(
			ProjectileFactory projectileFactory) {
		this.projectileFactory = projectileFactory;
	}

	public synchronized ArrayList<Entity> getEntities() {
		return entities;
	}

	public synchronized void addEntity(Entity entity) {
		if (!entities.contains(entity))
			entities.add(entity);
	}

	public synchronized void removeEntity(Entity entity) {
		if (entities.contains(entity))
			entities.remove(entity);
	}

	private synchronized void collision(double dt) {
		removingEntities.clear();

		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			entity.update(dt);
			if (entity.isRemoving()) {
				removingEntities.add(entity);
			}
		}

		for (int i = 0; i < removingEntities.size(); i++) {
			Entity entity = removingEntities.get(i);
			entities.remove(entity);
		}

		for (int i = 0; i < entities.size(); i++) {
			for (int j = 0; j < entities.size(); j++) {
				if (i == j)
					continue;
				Entity self = entities.get(i);
				if (self.isNoCollide())
					continue;

				Entity other = entities.get(j);

				// Projectiles doesn't collide with eachother.
				if (self instanceof Projectile && other instanceof Projectile)
					continue;

				if (self.getFaction() == other.getFaction())
					continue;

				if (self.intersects(other))
					self.collision(other);

			}
		}
	}

	private synchronized void init() {
		setScore(0);
		player = new Player(this);
		player.setX(width / 2);
		player.setY(height - 40);
		addEntity(player);

		if (level != null)
			level.init();

		Random random = new Random();
		for (int i = 0; i < 60; i++) {
			Star star;
			switch (random.nextInt(2)) {
			case 0:
				star = new Star(this, StarType.WHITE);
				star.setX(random.nextInt((int) width));
				star.setY(random.nextInt((int) height));
				this.addEntity(star);
				break;

			case 1:
				star = new Star(this, StarType.RED);
				star.setX(random.nextInt((int) width));
				star.setY(random.nextInt((int) height));
				this.addEntity(star);
				break;

			case 2:
				star = new Star(this, StarType.BLUE);
				star.setX(random.nextInt((int) width));
				star.setY(random.nextInt((int) height));
				this.addEntity(star);
				break;
			}
		}
	}

	public synchronized void update(double dt) {
		if (!player.isDead()) {
			if (!hasWon())
				addScore(1);
			if (hasWon())
				player.setRemoving(true);
		}
		totalTime += dt;
		collision(dt);
		if (level != null)
			level.update(dt);
	}

	public boolean hasWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}
}
