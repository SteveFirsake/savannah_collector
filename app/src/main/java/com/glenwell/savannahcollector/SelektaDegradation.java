package com.glenwell.savannahcollector;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SelektaDegradation extends AppCompatActivity {
	

	Button tuma;
	String datno="";
	String sax="";
	String say="";
	String classtype="";

	ImageView im1;
    ImageView im2;
    ImageView im3;
    ImageView im4;
    ImageView im5;
    ImageView im6;
    ImageView im7;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapicha_degradation);
		overridePendingTransition(0, 0);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		tuma = (Button) findViewById(R.id.selecto);

		im1 = (ImageView) findViewById(R.id.im1);
		im2 = (ImageView) findViewById(R.id.im2);
		im3 = (ImageView) findViewById(R.id.im3);
		im4 = (ImageView) findViewById(R.id.im4);
		im5 = (ImageView) findViewById(R.id.im5);
		im6 = (ImageView) findViewById(R.id.im6);
		im7 = (ImageView) findViewById(R.id.im7);

		Intent intentqa = getIntent();
		sax = intentqa.getStringExtra("lonnn");
		Intent intentqsa = getIntent();
		say = intentqsa.getStringExtra("lattt");
		Intent intentqdsa = getIntent();
		datno = intentqdsa.getStringExtra("datno");

		im1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im1.setBackground(highlight);
				im2.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im5.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				classtype = "Burning";
			}
		});

		im2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im2.setBackground(highlight);
				im1.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im5.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				classtype = "Erosion";
			}
		});

		im3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im3.setBackground(highlight);
				im2.setBackground(null);
				im1.setBackground(null);
				im4.setBackground(null);
				im5.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				classtype = "Overgrazing";
			}
		});

		im4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im4.setBackground(highlight);
				im2.setBackground(null);
				im3.setBackground(null);
				im1.setBackground(null);
				im5.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				classtype = "Sand Harvesting";
			}
		});

		im5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im5.setBackground(highlight);
				im2.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im1.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				classtype = "Siltation";
			}
		});

		im6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im6.setBackground(highlight);
				im2.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im5.setBackground(null);
				im1.setBackground(null);
				im7.setBackground(null);
				classtype = "Turbidity";
			}
		});

		im7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im7.setBackground(highlight);
				im2.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im5.setBackground(null);
				im1.setBackground(null);
				im6.setBackground(null);
				classtype = "Invasive Species";
			}
		});

		tuma.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
			if (!classtype.equals("")) {
				Intent intent = new Intent(SelektaDegradation.this, CollectaDegradation.class);
				intent.putExtra("lattt", say);
				intent.putExtra("lonnn", sax);
				intent.putExtra("datno", datno);
				intent.putExtra("cover", classtype);
				startActivity(intent);
			}else{
				Toast.makeText(SelektaDegradation.this, "Please select a vegetation type first.", Toast.LENGTH_LONG ).show();
			}
			}
		});
	}
	
	@Override
	public void onBackPressed(){
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			// Respond to the action bar's Up/Home button
			case android.R.id.home:
				//NavUtils.navigateUpFromSameTask(this);
				Intent intent = new Intent(SelektaDegradation.this, SelektaTheme.class);
				intent.putExtra("lattt", say);
				intent.putExtra("lonnn", sax);
				intent.putExtra("datno", datno);
				startActivity(intent);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	


}
