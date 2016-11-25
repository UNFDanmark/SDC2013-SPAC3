package dk.unf.software.aar2013.gruppe3;

public abstract class Entity {
	private Game game;
	private double radius;
	private Faction faction;
	private double x;
	private double y;
	private double velX;
	private double velY;
	private boolean removing;
	private boolean noCollide;

	public Entity(Game game, double radius, Faction faction) {
		this.game = game;
		this.radius = radius;
		this.faction = faction;
	}

	public Game getGame() {
		return game;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Faction getFaction() {
		return faction;
	}

	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public void setTargetDirection(Entity other) {
		double speed = Math.sqrt(velX * velX + velY * velY);
		double angle = angleTowards(other);
		setVelX(Math.cos(angle) * speed);
		setVelY(Math.sin(angle) * speed);
	}

	public boolean isRemoving() {
		return removing;
	}

	public void setRemoving(boolean removing) {
		this.removing = removing;
	}

	public boolean isNoCollide() {
		return noCollide;
	}

	public void setNoCollide(boolean noCollide) {
		this.noCollide = noCollide;
	}

	public double distance(Entity other) {
		double dx = other.getX() - x;
		double dy = other.getY() - y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double distanceSquared(Entity other) {
		double dx = other.getX() - x;
		double dy = other.getY() - y;
		return dx * dx + dy * dy;
	}

	public boolean intersects(Entity other) {
		double dist = distanceSquared(other);
		double rad = other.getRadius() + radius;
		return (dist < rad * rad);
	}
	
	public double angleTowards(Entity other){
		return Math.atan2(other.getY() - getY(), other.getX() - getX());
	}

	public void update(double dt) {
		x += velX * dt;
		y += velY * dt;
	}

	public void collision(Entity other) {
	}
}
