package dk.unf.software.aar2013.gruppe3;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {
	private Button infiniteButton;
	private Button level1Button;
	private Button bossButton;
	private Button multiplayerButton;
	private Button settingsButton;
	private Button creditsButton;
	private Button exitButton;
	
	private Intent singleplayerIntent;
	private Intent creditsIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		singleplayerIntent = new Intent(this, GameActivity.class);
		creditsIntent = new Intent(this, CreditsActivity.class);
		
		infiniteButton = (Button) findViewById(R.id.infiniteButton);
		infiniteButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				singleplayerIntent.putExtra("level", 0);
				startActivity(singleplayerIntent);
			}
		});
		
		level1Button = (Button) findViewById(R.id.level1Button);
		level1Button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				singleplayerIntent.putExtra("level", 1);
				startActivity(singleplayerIntent);
			}
		});
		
		bossButton = (Button) findViewById(R.id.bossButton);
		bossButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				singleplayerIntent.putExtra("level", 2);
				startActivity(singleplayerIntent);
			}
		});

		multiplayerButton = (Button) findViewById(R.id.multiplayerButton);
		multiplayerButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});

		settingsButton = (Button) findViewById(R.id.settingsButton);
		settingsButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
		});

		creditsButton = (Button) findViewById(R.id.creditsButton);
		creditsButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(creditsIntent);
			}
		});

		exitButton = (Button) findViewById(R.id.exitButton);
		exitButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

}
