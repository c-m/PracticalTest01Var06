package ro.pub.cs.systems.eim.practicaltest01var06;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var06SecondaryActivity extends Activity {
	
	private TextView addressText = null;
	private TextView validated = null;
	private Button okButton = null;
	private Button cancelButton = null;
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	  private class ButtonClickListener implements View.OnClickListener {
	    @Override
	    public void onClick(View view) {
	      switch(view.getId()) {
	        case R.id.ok_button:
	          setResult(RESULT_OK, null);
	          break;
	        case R.id.cancel_button:
	          setResult(RESULT_CANCELED, null);
	          break;
	      }
	      finish();
	    }
	  }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var06_secondary);
		
	    addressText = (TextView)findViewById(R.id.address_text);
	    validated = (TextView)findViewById(R.id.validated);
	    
	    Intent intent = getIntent();
	    if (intent != null && intent.getExtras().containsKey("addressText")
	    		&& intent.getExtras().containsKey("validated")) {
	        String addressText1 = intent.getStringExtra("adressText");
	        String validated1 = intent.getStringExtra("validated");
	        addressText.setText(addressText1);
	    }
	 
	    okButton = (Button)findViewById(R.id.ok_button);
	    okButton.setOnClickListener(buttonClickListener);
	    cancelButton = (Button)findViewById(R.id.cancel_button);
	    cancelButton.setOnClickListener(buttonClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var06_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
