package dk.unf.software.aar2013.gruppe3;

public class MediumMeteorNPC extends NPC {

	public MediumMeteorNPC(Game game) {
		super(game, 25, 30);
		setFaction(Faction.NEUTRAL);
		setVelY(300 + Math.random() * 100);
		setVelX(50 - Math.random() * 100);
	}

	@Override
	protected void onDeath() {
		getGame().addEntity(new Effect(getGame(), EffectType.DUST, getX(), getY()));
		if(!getGame().getPlayer().isDead())
			getGame().addScore(20);
		NPC npc;
		
		npc = new SmallMeteorNPC(getGame());
		npc.setX(getX());
		npc.setY(getY());
		getGame().addEntity(npc);
		npc = new SmallMeteorNPC(getGame());
		npc.setX(getX());
		npc.setY(getY());
		getGame().addEntity(npc);
		super.onDeath();
	}
	
}
