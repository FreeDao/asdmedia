package tv.danmaku.ijk.media.demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PortalActivity extends Activity implements OnClickListener{
	
	private Button urlPlay;
	private Button fileSelect;
	private EditText inputUrl;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.portal_activity);
		
		urlPlay = (Button)findViewById(R.id.bt_net_play);
		fileSelect = (Button)findViewById(R.id.bt_select_file);
		inputUrl = (EditText)findViewById(R.id.et_net_url);
		
		urlPlay.setOnClickListener(this);
		fileSelect.setOnClickListener(this);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bt_net_play:
			Uri netUri = Uri.parse(inputUrl.getText().toString().trim());
			Intent netIntent = new Intent(this, VideoPlayerActivity.class);
			netIntent.setData(netUri);
			startActivity(netIntent);
			break;
			
		case R.id.bt_select_file:
			Intent fileIntent = new Intent(this, FFMpegFileExplorer.class);
			startActivity(fileIntent);
			break;
			
		default:
			break;
		}
	}
}
