package dk.unf.software.aar2013.gruppe3;

public class BrainNPC extends NPC {
	private EyeNPC leftEye;
	private EyeNPC rightEye;

	public BrainNPC(Game game) {
		super(game, 50, 2000);
		leftEye = new EyeNPC(game);
		leftEye.setLeft(true);
		getGame().addEntity(leftEye);

		rightEye = new EyeNPC(game);
		rightEye.setLeft(false);
		getGame().addEntity(rightEye);
	}

	@Override
	public void update(double dt) {
		setX((getGame().getWidth() / 2)
				+ Math.sin(getGame().getTotalTime() * 2) * 100);
		leftEye.setX(getX() - 100 + Math.cos(getGame().getTotalTime() * 4) * 20);
		leftEye.setY(getY() + 15 + Math.sin(getGame().getTotalTime() * 8) * 10);
		rightEye.setX(getX() + 100 - Math.cos(getGame().getTotalTime() * 4)
				* 20);
		rightEye.setY(getY() + 15 + Math.sin(getGame().getTotalTime() * 8) * 10);
	}

	@Override
	protected void onDeath() {
		super.onDeath();
		leftEye.doDamage(500000);
		rightEye.doDamage(500000);
	}

}
