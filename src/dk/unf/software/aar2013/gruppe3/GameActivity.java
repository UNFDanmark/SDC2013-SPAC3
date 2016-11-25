package dk.unf.software.aar2013.gruppe3;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity {
	private static final String TAG = GameActivity.class.getSimpleName();
	private GameView gameView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// requesting to turn the title OFF
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// making it full screen
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// set our GameView as the View
		switch (getIntent().getIntExtra("level", 0)) {
		case 1:
			gameView = new GameView(this,
					(Vibrator) getSystemService(Context.VIBRATOR_SERVICE),
					LevelType.LEVEL1);
			break;
		case 2:
			gameView = new GameView(this,
					(Vibrator) getSystemService(Context.VIBRATOR_SERVICE),
					LevelType.BOSS1);
			break;

		default:
			gameView = new GameView(this,
					(Vibrator) getSystemService(Context.VIBRATOR_SERVICE),
					LevelType.INFINITE);
			break;
		}
		setContentView(gameView);
		Log.d(TAG, "View added");
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "Destroying...");
		super.onDestroy();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "Stopping...");
		super.onStop();
	}

	@Override
	public void onBackPressed() {
		gameView.stop();
		super.onBackPressed();
	}

	@Override
	protected void onPause() {
		gameView.stop();
		finish();
		super.onPause();
	}

}
