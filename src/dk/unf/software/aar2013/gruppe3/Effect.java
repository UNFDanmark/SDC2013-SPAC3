package dk.unf.software.aar2013.gruppe3;

public class Effect extends Entity {
	private int stage;
	
	private EffectType type;
	
	public Effect(Game game, EffectType type, double x, double y) {
		super(game, 0, Faction.ENEMIES);
		this.setStage(0);
		this.setNoCollide(false);
		this.type = type;
		this.setX(x);
		this.setY(y);
	}
	
	@Override
	public void update(double dt) {
		super.update(dt);
		this.setStage(this.getStage() + 1);
		switch(type){
		case SPARK:
			if(stage > 12)
				setRemoving(true);
			break;
		case PLASMA:
			if(stage > 12)
				setRemoving(true);
			break;
		case DUST:
			if(stage > 32)
				setRemoving(true);
			break;
		default:
			setRemoving(true);
			break;
			
		}
	}

	public EffectType getType() {
		return type;
	}
	
	public void setType(EffectType type) {
		this.type = type;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

}
