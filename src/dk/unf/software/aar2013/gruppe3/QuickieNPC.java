package dk.unf.software.aar2013.gruppe3;

public class QuickieNPC extends NPC {

	public QuickieNPC(Game game) {
		super(game, 11, 30);
		setVelY(450);
	}

	@Override
	protected void onDeath() {
		if(!getGame().getPlayer().isDead())
			getGame().addScore(35);
		super.onDeath();
	}

}
