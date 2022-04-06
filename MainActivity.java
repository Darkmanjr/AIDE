package com.darkmanjr.project01;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;
import android.net.*;

public class MainActivity extends Activity 
{
	ImageView imageView;
	TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		imageView = findViewById(R.id.mainImageView1);
		textView = findViewById(R.id.mainTextView1);

		imageView.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View view)
				{
					Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
					intent.setType("image/*");
					startActivityForResult(Intent.createChooser(intent,"select"),0);
				}
			});

		textView.setFocusableInTouchMode(true);
		textView.setCursorVisible(true);

    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 0 && resultCode == RESULT_OK && data != null)
		{
			Uri u = data.getData();
			imageView.setImageURI(u);
		}
	} 
}
