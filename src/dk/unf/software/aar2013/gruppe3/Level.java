package dk.unf.software.aar2013.gruppe3;

public abstract class Level {
	private Game game;
	
	public Level(Game game){
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public abstract void init();
	
	public abstract void update(double dt);
}
