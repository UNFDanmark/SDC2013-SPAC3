package dk.unf.software.aar2013.gruppe3;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
	private static final String TAG = GameView.class.getSimpleName();

	private GameThread gameThread;
	private Game game;
	private LevelType level;

	private int surface_width;
	private int surface_height;

	private Paint paintRed;
	private Paint paintWhite;

	private Bitmap imageBullet;
	private Bitmap imagePlasma;
	private Bitmap imageRocket;
	private Bitmap imagePlayer0;
	private Bitmap imagePlayer0R;
	private Bitmap imagePlayer0L;
	private Bitmap imageScout;
	private Bitmap imageFighter;
	private Bitmap imageTank;
	private Bitmap imageQuickie;
	private Bitmap imageCarrier;
	private Bitmap imageSmallMeteor;
	private Bitmap imageMediumMeteor;
	private Bitmap imageMissilePowerup;
	private Bitmap imageGunPowerup;
	private Bitmap imagePlasmaPowerup;
	private Bitmap imageHealthPowerup;
	private Bitmap imageBrain;
	private Bitmap imageLeftEye;
	private Bitmap imageRightEye;
	private Bitmap imageSmallEye;
	private Bitmap imageSpark_0;
	private Bitmap imageSpark_1;
	private Bitmap imageSpark_2;
	private Bitmap imageSpark_3;
	private Bitmap imagePlasma_0;
	private Bitmap imagePlasma_1;
	private Bitmap imagePlasma_2;
	private Bitmap imagePlasma_3;
	private Bitmap imageDust_0;
	private Bitmap imageDust_1;
	private Bitmap imageDust_2;
	private Bitmap imageDust_3;
	private Bitmap imageDust_4;
	private Bitmap imageDust_5;
	private Bitmap imageDust_6;
	private Bitmap imageDust_7;

	public GameView(Context context, Vibrator vibrator, LevelType level) {
		super(context);
		// adding the callback (this) to the surface holder to intercept events
		getHolder().addCallback(this);

		// create the game loop thread
		gameThread = new GameThread(getHolder(), this);
		game = new Game(480, 800, vibrator);

		this.level = level;
		switch (level) {
		case INFINITE:
			game.setLevel(new RandomLevel(game));
			break;
		case LEVEL1:
			game.setLevel(new Level1(game));
			break;
		case BOSS1:
			game.setLevel(new BossLevel(game));
			break;
		case LEVEL3:
			game.setLevel(new RandomLevel(game));
			break;
		default:
			game.setLevel(new RandomLevel(game));
			break;
		}

		// make the GamePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		this.surface_width = width;
		this.surface_height = height;

		paintRed = new Paint();
		paintRed.setColor(Color.RED);
		paintWhite = new Paint();
		paintWhite.setColor(Color.WHITE);
		paintWhite.setTextSize(20);

		imageBullet = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.projectile_2);
		imagePlasma = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.projectile_3);
		imageRocket = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.projectile_4);
		imagePlayer0 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.player_0);
		imagePlayer0R = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.player_0_r);
		imagePlayer0L = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.player_0_l);
		imageScout = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.enemy_0);
		imageFighter = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.enemy_3);
		imageTank = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.enemy_6);
		imageQuickie = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.enemy_4);
		imageCarrier = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.pwship_0);
		imageSmallMeteor = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.meteor_0_0);
		imageMediumMeteor = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.meteor_1_0);
		imageMissilePowerup = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.powerup_2);
		imageGunPowerup = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.powerup_3);
		imagePlasmaPowerup = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.powerup_4);
		imageHealthPowerup = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.powerup_6);
		imageBrain = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.boss_0_1);
		imageLeftEye = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.boss_0_7);
		imageRightEye = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.boss_0_8);
		imageSmallEye = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.boss_0_2);
		imageSpark_0 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_1_1);
		imageSpark_1 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_1_2);
		imageSpark_2 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_1_3);
		imageSpark_3 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_1_4);
		imagePlasma_0 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_4_0);
		imagePlasma_1 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_4_1);
		imagePlasma_2 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_4_2);
		imagePlasma_3 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_4_3);
		imageDust_0 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_3_0);
		imageDust_1 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_3_1);
		imageDust_2 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_3_2);
		imageDust_3 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_3_3);
		imageDust_4 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_3_4);
		imageDust_5 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_3_5);
		imageDust_6 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_3_6);
		imageDust_7 = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.ex_3_7);

		game.setWidth(width);
		game.setHeight(height);
		switch (level) {
		case INFINITE:
			game.setLevel(new RandomLevel(game));
			break;
		case LEVEL1:
			game.setLevel(new Level1(game));
			break;
		case BOSS1:
			game.setLevel(new BossLevel(game));
			break;
		case LEVEL3:
			game.setLevel(new RandomLevel(game));
			break;
		default:
			game.setLevel(new RandomLevel(game));
			break;
		}
		game.getPlayer().setX(width / 2);
		game.getPlayer().setY(height - 40);

		Log.d(TAG, "surfaceChanged: w=" + width + ",h=" + height);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		gameThread.setRunning(true);
		gameThread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		while (retry) {
			try {
				gameThread.join();
				retry = false;
			} catch (InterruptedException e) {

			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if (game.getPlayer().isDead() || game.hasWon()) {
				game.setWon(false);
				switch (level) {
				case INFINITE:

					game.setLevel(new RandomLevel(game));
					break;
				case LEVEL1:
					game.setLevel(new Level1(game));
					break;
				case BOSS1:
					game.setLevel(new BossLevel(game));
					break;
				case LEVEL3:
					game.setLevel(new RandomLevel(game));
					break;
				default:
					game.setLevel(new RandomLevel(game));
					break;
				}
			}
			// Log.d(TAG, "Down: x=" + event.getX() + ",y=" + event.getY());
			game.getPlayer().setDesiredX(event.getX());
			game.getPlayer().setDesiredY(event.getY() - 65);
			game.getPlayer().setShooting(true);
			game.getPlayer().setMoving(true);
			return true;

		case MotionEvent.ACTION_MOVE:
			// Log.d(TAG, "Move: x=" + event.getX() + ",y=" + event.getY());
			game.getPlayer().setDesiredX(event.getX());
			game.getPlayer().setDesiredY(event.getY() - 65);
			return true;

		case MotionEvent.ACTION_UP:
			// Log.d(TAG, "Up: x=" + event.getX() + ",y=" + event.getY());
			game.getPlayer().setShooting(false);
			game.getPlayer().setMoving(false);
			game.getPlayer().setDesiredX(game.getPlayer().getX());
			game.getPlayer().setDesiredY(game.getPlayer().getY());
			return true;

		default:
			Log.d(TAG, "Unknown Event: " + event.getAction());
			return super.onTouchEvent(event);
		}
	}

	private void clear(Canvas canvas, int color) {
		Paint paint = new Paint();
		paint.setColor(color);
		canvas.drawRect(0, 0, surface_width, surface_height, paint);
	}

	public void stop() {
		gameThread.setRunning(false);
	}

	public void update(double dt) {
		if (game == null)
			return;

		game.update(dt);
	}

	private void drawStars(double dt, Canvas canvas) {
		ArrayList<Entity> entities = game.getEntities();
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			float x = (float) entity.getX();
			float y = (float) entity.getY();
			float r = (float) entity.getRadius();

			if (entity instanceof Star) {
				Star star = (Star) entity;
				Paint paint = new Paint();
				paint.setColor(star.getColor());
				canvas.drawCircle(x, y, r, paint);
			}
		}
	}

	private void drawProjectiles(double dt, Canvas canvas) {
		ArrayList<Entity> entities = game.getEntities();
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			float x = (float) entity.getX();
			float y = (float) entity.getY();

			if (entity instanceof Projectile) {
				Bitmap image = null;

				switch (((Projectile) entity).getType()) {
				case BULLET:
					image = imageBullet;
					break;
				case PLASMA:
					image = imagePlasma;
					break;
				case ROCKET:
					image = imageRocket;
					break;
				case EYE:
					image = imageSmallEye;
					break;
				default:
					break;

				}

				if (image == null)
					continue;
				float w = (float) image.getWidth();
				float h = (float) image.getHeight();
				canvas.drawBitmap(image, x - w / 2, y - h / 2, paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			}
		}
	}

	private void drawEntities(double dt, Canvas canvas) {
		ArrayList<Entity> entities = game.getEntities();
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			float x = (float) entity.getX();
			float y = (float) entity.getY();

			if (entity instanceof ScoutNPC) {
				if (imageScout == null)
					continue;
				float w = (float) imageScout.getWidth();
				float h = (float) imageScout.getHeight();
				canvas.drawBitmap(imageScout, x - w / 2, y - h / 2, paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			} else if (entity instanceof FighterNPC) {
				if (imageFighter == null)
					continue;
				float w = (float) imageFighter.getWidth();
				float h = (float) imageFighter.getHeight();
				canvas.drawBitmap(imageFighter, x - w / 2, y - h / 2,
						paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			} else if (entity instanceof CarrierNPC) {
				if (imageCarrier == null)
					continue;
				float w = (float) imageCarrier.getWidth();
				float h = (float) imageCarrier.getHeight();
				canvas.drawBitmap(imageCarrier, x - w / 2, y - h / 2,
						paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			} else if (entity instanceof QuickieNPC) {
				if (imageQuickie == null)
					continue;
				float w = (float) imageQuickie.getWidth();
				float h = (float) imageQuickie.getHeight();
				canvas.drawBitmap(imageQuickie, x - w / 2, y - h / 2,
						paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			} else if (entity instanceof TankNPC) {
				if (imageTank == null)
					continue;
				float w = (float) imageTank.getWidth();
				float h = (float) imageTank.getHeight();
				canvas.drawBitmap(imageTank, x - w / 2, y - h / 2, paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			} else if (entity instanceof BrainNPC) {
				if (imageBrain == null)
					continue;
				float w = (float) imageBrain.getWidth();
				float h = (float) imageBrain.getHeight();
				canvas.drawBitmap(imageBrain, x - w / 2, y - h / 2, paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			} else if (entity instanceof EyeNPC) {
				Bitmap image = null;

				if (((EyeNPC) entity).isLeft())
					image = imageLeftEye;
				else
					image = imageRightEye;

				if (image == null)
					continue;
				float w = (float) image.getWidth();
				float h = (float) image.getHeight();
				canvas.drawBitmap(image, x - w / 2, y - h / 2, paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			} else if (entity instanceof SmallMeteorNPC) {
				if (imageSmallMeteor == null)
					continue;
				float w = (float) imageSmallMeteor.getWidth();
				float h = (float) imageSmallMeteor.getHeight();
				canvas.drawBitmap(imageSmallMeteor, x - w / 2, y - h / 2,
						paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			} else if (entity instanceof MediumMeteorNPC) {
				if (imageMediumMeteor == null)
					continue;
				float w = (float) imageMediumMeteor.getWidth();
				float h = (float) imageMediumMeteor.getHeight();
				canvas.drawBitmap(imageMediumMeteor, x - w / 2, y - h / 2,
						paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			} else if (entity instanceof Powerup) {
				Bitmap image = null;
				switch (((Powerup) entity).getType()) {
				case GUN:
					image = imageGunPowerup;
					break;
				case PLASMA:
					image = imagePlasmaPowerup;
					break;
				case ROCKET:
					image = imageMissilePowerup;
					break;
				case HEALTH:
					image = imageHealthPowerup;
					break;
				case SHIELD:
					break;

				}
				if (image == null)
					continue;
				float w = (float) image.getWidth();
				float h = (float) image.getHeight();
				canvas.drawBitmap(image, x - w / 2, y - h / 2, paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			}
		}
	}

	private void drawPlayers(double dt, Canvas canvas) {
		ArrayList<Entity> entities = game.getEntities();
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			float x = (float) entity.getX();
			float y = (float) entity.getY();

			if (entity instanceof Player) {
				Bitmap image = imagePlayer0;
				Player player = (Player) entity;
				if (player.isDead())
					continue;

				if (player.getDesiredX() < player.getX() - 2.00) {
					// moving left
					image = imagePlayer0L;
				}
				if (player.getDesiredX() > player.getX() + 2.00) {
					// moving right
					image = imagePlayer0R;
				}

				if (image == null)
					continue;
				float w = (float) image.getWidth();
				float h = (float) image.getHeight();
				canvas.drawBitmap(image, x - w / 2, y - h / 2, paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			}
		}
	}

	private void drawEffects(double dt, Canvas canvas) {
		ArrayList<Entity> entities = game.getEntities();
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			if (entity instanceof Effect) {
				Effect effect = (Effect) entity;
				float x = (float) entity.getX();
				float y = (float) entity.getY();
				Bitmap image = null;
				switch (effect.getType()) {
				case SPARK:
					if (effect.getStage() > 0) {
						image = imageSpark_1;
					}
					if (effect.getStage() > 4) {
						image = imageSpark_2;
					}
					if (effect.getStage() > 8) {
						image = imageSpark_3;
					}
					break;
				case PLASMA:
					if (effect.getStage() > 0) {
						image = imagePlasma_1;
					}
					if (effect.getStage() > 4) {
						image = imagePlasma_2;
					}
					if (effect.getStage() > 8) {
						image = imagePlasma_3;
					}
					break;
				case DUST:
					if (effect.getStage() > 0) {
						image = imageDust_0;
					}
					if (effect.getStage() > 4) {
						image = imageDust_1;
					}
					if (effect.getStage() > 8) {
						image = imageDust_2;
					}
					if (effect.getStage() > 12) {
						image = imageDust_3;
					}
					if (effect.getStage() > 16) {
						image = imageDust_4;
					}
					if (effect.getStage() > 20) {
						image = imageDust_5;
					}
					if (effect.getStage() > 24) {
						image = imageDust_6;
					}
					if (effect.getStage() > 28) {
						image = imageDust_7;
					}

					break;

				default:

					break;
				}

				if (image == null)
					continue;
				float w = (float) image.getWidth();
				float h = (float) image.getHeight();
				canvas.drawBitmap(image, x - w / 2, y - h / 2, paintWhite);
				// canvas.drawCircle(x, y, (float) entity.getRadius(),
				// paintRed);
			}
		}
	}

	private void drawInterface(double dt, Canvas canvas) {
		double factor = (game.getPlayer().getHealth() / 100.00);

		Paint black = new Paint();
		black.setColor(Color.BLACK);
		Paint health = new Paint();
		health.setColor(Color.rgb(255 - (int) (255 * factor),
				(int) (255 * factor), 0));

		int w = (int) ((surface_width - 2) * factor);
		canvas.drawText("Score: " + game.getScore(), 20, 20, paintWhite);

		if (game.hasWon()) {
			Paint paint = new Paint();
			paint.setColor(Color.GREEN);
			paint.setTextAlign(Align.CENTER);

			paint.setTextSize(30);
			canvas.drawText(game.getScore() + " points!", surface_width / 2,
					surface_height / 2 - 40, paint);
			paint.setTextSize(50);
			canvas.drawText("Game Won", surface_width / 2, surface_height / 2,
					paint);
			paint.setTextSize(20);
			canvas.drawText("(hit back to exit or tap to try again)",
					surface_width / 2, surface_height / 2 + 30, paint);
			
		} else if (game.getPlayer().isDead()) {
			Paint paint = new Paint();
			paint.setColor(Color.RED);
			paint.setTextAlign(Align.CENTER);

			paint.setTextSize(30);
			canvas.drawText(game.getScore() + " points!", surface_width / 2,
					surface_height / 2 - 40, paint);
			paint.setTextSize(50);
			canvas.drawText("Game Over", surface_width / 2, surface_height / 2,
					paint);
			paint.setTextSize(20);
			canvas.drawText("(hit back to exit or tap to try again)",
					surface_width / 2, surface_height / 2 + 30, paint);
		} else {
			canvas.drawRect(0, surface_height - 7, surface_width,
					surface_height, black);
			canvas.drawRect(1, surface_height - 6, w - 1, surface_height - 1,
					health);
		}
	}

	public void draw(double dt, Canvas canvas) {
		if (game == null)
			return;

		clear(canvas, Color.BLACK);

		drawStars(dt, canvas);
		drawProjectiles(dt, canvas);
		drawEntities(dt, canvas);
		drawPlayers(dt, canvas);
		drawEffects(dt, canvas);
		drawInterface(dt, canvas);
	}
}
