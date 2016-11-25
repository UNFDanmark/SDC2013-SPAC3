package dk.unf.software.aar2013.gruppe3;

import java.util.Random;

import android.graphics.Color;

public class Star extends Entity {
	private int white = Color.WHITE;
	private int red = Color.rgb(255, 200, 200);
	private int blue = Color.rgb(200, 200, 255);
	
	private Random random = new Random();

	private int color;
	private StarType type;
	
	
	public Star(Game game, StarType type) {
		super(game, 0, Faction.NEUTRAL);
		this.type = type;
		setNoCollide(true);
		randomize();
	}

	public StarType getType() {
		return type;
	}

	public void setType(StarType type) {
		this.type = type;
	}

	@Override
	public void update(double dt) {
		if(getY() > getGame().getHeight()){
			setX((int)(Math.random() * getGame().getWidth()));
			setY(0);
			randomize();
		}
		super.update(dt);
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	
	public void randomize(){
		
		switch(random.nextInt(3)){
		case 0:
			setType(StarType.WHITE);
			setColor(white);
			break;
		case 1:
			setType(StarType.BLUE);
			setColor(blue);
			break;
		case 2:
			setType(StarType.RED);
			setColor(red);
			break;
		}
		
		switch(random.nextInt(3)){
		case 0:
			setRadius(1.0);
			setVelY(50);
			break;
		case 1:
			setRadius(1.5);
			setVelY(100);
			break;
		case 2:
			setRadius(2.0);
			setVelY(150);
			break;
		}
	}

}
