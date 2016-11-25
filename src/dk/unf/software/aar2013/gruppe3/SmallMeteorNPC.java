package dk.unf.software.aar2013.gruppe3;

public class SmallMeteorNPC extends NPC {

	public SmallMeteorNPC(Game game) {
		super(game, 11, 15);
		setFaction(Faction.NEUTRAL);
		setVelY(500 + Math.random() * 100);
		setVelX(50 - Math.random() * 100);
	}

	@Override
	protected void onDeath() {
		getGame().addEntity(new Effect(getGame(), EffectType.DUST, getX(), getY()));
		if (!getGame().getPlayer().isDead())
			getGame().addScore(10);
		super.onDeath();
	}
}
