package dk.unf.software.aar2013.gruppe3;

public abstract class NPC extends Character {
	public NPC(Game game, double radius, int health){
		super(game, radius, Faction.ENEMIES, health);
	}

	@Override
	public void update(double dt) {
		super.update(dt);

		setRemoving(isDead());
		
		if(getY() > getGame().getHeight() + getRadius()){
			setRemoving(true);
		}
	}
	
}
