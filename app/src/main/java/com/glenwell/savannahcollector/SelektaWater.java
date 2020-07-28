package com.glenwell.savannahcollector;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SelektaWater extends AppCompatActivity {


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
    ImageView im8;
    ImageView im9;
    ImageView im10;
    ImageView im11;
    ImageView im12;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapicha_water);
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
		im8 = (ImageView) findViewById(R.id.im8);
		im9 = (ImageView) findViewById(R.id.im9);
		im10 = (ImageView) findViewById(R.id.im10);
		im11 = (ImageView) findViewById(R.id.im11);
		im12 = (ImageView) findViewById(R.id.im12);

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
				im8.setBackground(null);
				im9.setBackground(null);
				im10.setBackground(null);
				im11.setBackground(null);
				im12.setBackground(null);
				classtype = "Dam";
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
				im8.setBackground(null);
				im9.setBackground(null);
				im10.setBackground(null);
				im11.setBackground(null);
				im12.setBackground(null);
				classtype = "Water Pan";
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
				im8.setBackground(null);
				im9.setBackground(null);
				im10.setBackground(null);
				im11.setBackground(null);
				im12.setBackground(null);
				classtype = "River";
			}
		});

		im4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im4.setBackground(highlight);
				im2.setBackground(null);
				im1.setBackground(null);
				im3.setBackground(null);
				im5.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				im8.setBackground(null);
				im9.setBackground(null);
				im10.setBackground(null);
				im11.setBackground(null);
				im12.setBackground(null);
				classtype = "Pond";
			}
		});

		im5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im5.setBackground(highlight);
				im2.setBackground(null);
				im1.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				im8.setBackground(null);
				im9.setBackground(null);
				im10.setBackground(null);
				im11.setBackground(null);
				im12.setBackground(null);
				classtype = "Sand Dam";
			}
		});

		im6.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im6.setBackground(highlight);
				im2.setBackground(null);
				im1.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im5.setBackground(null);
				im7.setBackground(null);
				im8.setBackground(null);
				im9.setBackground(null);
				im10.setBackground(null);
				im11.setBackground(null);
				im12.setBackground(null);
				classtype = "Sand Extraction";
			}
		});

		im7.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im7.setBackground(highlight);
				im2.setBackground(null);
				im1.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im5.setBackground(null);
				im6.setBackground(null);
				im8.setBackground(null);
				im9.setBackground(null);
				im10.setBackground(null);
				im11.setBackground(null);
				im12.setBackground(null);
				classtype = "Spring";
			}
		});

		im8.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im8.setBackground(highlight);
				im2.setBackground(null);
				im1.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im5.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				im9.setBackground(null);
				im10.setBackground(null);
				im11.setBackground(null);
				im12.setBackground(null);
				classtype = "Stream";
			}
		});

		im9.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im9.setBackground(highlight);
				im2.setBackground(null);
				im1.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im5.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				im8.setBackground(null);
				im10.setBackground(null);
				im11.setBackground(null);
				im12.setBackground(null);
				classtype = "Well";
			}
		});

		im10.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im10.setBackground(highlight);
				im2.setBackground(null);
				im1.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im5.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				im9.setBackground(null);
				im8.setBackground(null);
				im11.setBackground(null);
				im12.setBackground(null);
				classtype = "Wetland";
			}
		});

		im11.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im11.setBackground(highlight);
				im2.setBackground(null);
				im1.setBackground(null);
				im3.setBackground(null);
				im4.setBackground(null);
				im5.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				im9.setBackground(null);
				im8.setBackground(null);
				im10.setBackground(null);
				im12.setBackground(null);
				classtype = "Lake";
			}
		});

		im12.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				im12.setBackground(highlight);
				im2.setBackground(null);
				im3.setBackground(null);
				im1.setBackground(null);
				im5.setBackground(null);
				im6.setBackground(null);
				im7.setBackground(null);
				im8.setBackground(null);
				im9.setBackground(null);
				im10.setBackground(null);
				im11.setBackground(null);
				im4.setBackground(null);
				classtype = "Other";
			}
		});




		tuma.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
			if (!classtype.equals("")) {
				Intent intent = new Intent(SelektaWater.this, CollectaWater.class);
				intent.putExtra("lattt", say);
				intent.putExtra("lonnn", sax);
				intent.putExtra("datno", datno);
				intent.putExtra("cover", classtype);
				startActivity(intent);
			}else{
				Toast.makeText(SelektaWater.this, "Please select a water source first.", Toast.LENGTH_LONG ).show();
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
				Intent intent = new Intent(SelektaWater.this, SelektaTheme.class);
				intent.putExtra("lattt", say);
				intent.putExtra("lonnn", sax);
				intent.putExtra("datno", datno);
				startActivity(intent);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	


}
