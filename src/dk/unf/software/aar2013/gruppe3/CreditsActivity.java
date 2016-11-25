package dk.unf.software.aar2013.gruppe3;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CreditsActivity extends Activity {
	private Button backButton;
	private Button linkButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_credits);

		backButton = (Button) findViewById(R.id.backButton);
		backButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		linkButton = (Button) findViewById(R.id.linkButton);
		linkButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//finish();
			}
		});
	}
}
