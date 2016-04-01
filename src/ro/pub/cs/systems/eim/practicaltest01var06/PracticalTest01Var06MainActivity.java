package ro.pub.cs.systems.eim.practicaltest01var06;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PracticalTest01Var06MainActivity extends Activity {
	
	private EditText topText = null;
	private EditText addressText = null;
	private Button button1 = null;
	private Button button2 = null;
	private Button navigateToSecondaryActivityButton = null;
	private LinearLayout one = null;
	private boolean clicked = false;
	
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	private class ButtonClickListener implements View.OnClickListener {
	    @Override
	    public void onClick(View view) {
	      switch(view.getId()) {
	        case R.id.button1:
	          if (!clicked) {
	        	  one.setVisibility(View.GONE);
	        	  button1.setText("More details");
	        	  clicked = true;
	        	  break;
	          }
	          if (clicked) {
	        	  one.setVisibility(View.VISIBLE);
	        	  button1.setText("Less details");
	        	  clicked = false;
	        	  break;
	          }
	      }
	    }
	}
	
	private AddressTextListener addressTextListener = new AddressTextListener();
	private class AddressTextListener implements TextWatcher {

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			
			String string = s.toString();
			if (string.startsWith("http://") || string.startsWith("https://")){
				button2.setBackground(getApplicationContext().getResources().getDrawable(R.color.green));
				button2.setText("Pass");
			}
			else {
				button2.setBackground(getApplicationContext().getResources().getDrawable(R.color.red));
				button2.setText("Fail");
			}
			
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var06_main);
		
		topText = (EditText)findViewById(R.id.editText1);
		addressText = (EditText)findViewById(R.id.editText2);
		one = (LinearLayout)findViewById(R.id.interface1);
		
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		navigateToSecondaryActivityButton = (Button)findViewById(R.id.button3);
		
		if (savedInstanceState != null) {
	      if (savedInstanceState.containsKey("leftCount")) {
	        topText.setText(savedInstanceState.getString("topText"));
	      } else {
	        topText.setText("Perfect Student");
	      }
	      if (savedInstanceState.containsKey("addressText")) {
	        addressText.setText(savedInstanceState.getString("addressText"));
	      } else {
	        addressText.setText("https://www.cs.pub.ro");
	      }
		} else {
	      topText.setText("Perfect Student");
	      addressText.setText("https://www.cs.pub.ro");
	    }
		
		Toast.makeText(this, "Top Text: " + topText + "; AddressText: " + addressText, Toast.LENGTH_LONG).show();
	}
	

	  @Override
	  protected void onSaveInstanceState(Bundle savedInstanceState) {
	    savedInstanceState.putString("topText", topText.getText().toString());
	    savedInstanceState.putString("addressText", addressText.getText().toString());
	  }
	  
	  @Override
	  protected void onRestoreInstanceState(Bundle savedInstanceState) {
	    if (savedInstanceState.containsKey("topText")) {
	      topText.setText(savedInstanceState.getString("topText"));
	    } else {
	      topText.setText("Perfect Student");
	    }
	    if (savedInstanceState.containsKey("addressText")) {
	      addressText.setText(savedInstanceState.getString("addressText"));
	    } else {
	      addressText.setText("https://www.cs.pub.ro");
	    }
	  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var06_main, menu);
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
