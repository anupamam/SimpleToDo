package codepath.apps.simpletodo;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.os.Build;

public class EditItemActivity extends ActionBarActivity {
	EditText etEditItem;
	int index;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		
		String itemValue = getIntent().getStringExtra("value");
		int focus_pos = itemValue.length();
		index = getIntent().getIntExtra("index",-1);
		
		if(index == -1){
			//error, go back
		}
		etEditItem = (EditText)findViewById(R.id.etEditItem);
		etEditItem.setText(itemValue);
		etEditItem.setSelection(focus_pos);
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_item, menu);
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
	
	public void saveItem(View v){
		etEditItem = (EditText)findViewById(R.id.etEditItem);
		Intent data = new Intent();
		data.putExtra("editText", etEditItem.getText().toString());
		data.putExtra("index", index);
		setResult(RESULT_OK, data);
		finish();
	}

	
}
