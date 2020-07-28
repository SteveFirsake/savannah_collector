package com.glenwell.savannahcollector;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SelektaTheme extends AppCompatActivity {
	

	Button tuma;
	String datno="";
	String sax="";
	String say="";
	String option = "";

	CardView cv1;
	CardView cv2;
	CardView cv3;



	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_theme);
		overridePendingTransition(0, 0);

		getSupportActionBar().setDisplayShowHomeEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		tuma = (Button) findViewById(R.id.selecto);

		cv1 = (CardView) findViewById(R.id.card_view_1);
		cv2 = (CardView) findViewById(R.id.card_view_2);
		cv3 = (CardView) findViewById(R.id.card_view_3);


		Intent intentqa = getIntent();
		sax = intentqa.getStringExtra("lonnn");
		Intent intentqsa = getIntent();
		say = intentqsa.getStringExtra("lattt");
		Intent intentqdsa = getIntent();
		datno = intentqdsa.getStringExtra("datno");

		cv1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				cv1.setBackground(highlight);
				cv2.setBackground(null);
				cv3.setBackground(null);
				option = "Rangelands";
			}
		});

		cv2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				cv2.setBackground(highlight);
				cv1.setBackground(null);
				cv3.setBackground(null);
				option = "Water";
			}
		});

		cv3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable highlight = getResources().getDrawable(R.drawable.highlighta);
				cv3.setBackground(highlight);
				cv1.setBackground(null);
				cv2.setBackground(null);
				option = "Degradation";
			}
		});


		tuma.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {

                Log.e("Select_option",option);

				switch (option){

					case "Rangelands":

						Intent intent0 = new Intent(SelektaTheme.this, SelektaRangelands.class);
						intent0.putExtra("lattt", say);
						intent0.putExtra("lonnn", sax);
						intent0.putExtra("datno", datno);
						startActivity(intent0);

						break;

					case "Water":

						Intent intent1 = new Intent(SelektaTheme.this, SelektaWater.class);
						intent1.putExtra("lattt", say);
						intent1.putExtra("lonnn", sax);
						intent1.putExtra("datno", datno);
						startActivity(intent1);

                        break;

					case "Degradation":

						Intent intent2 = new Intent(SelektaTheme.this, SelektaDegradation.class);
						intent2.putExtra("lattt", say);
						intent2.putExtra("lonnn", sax);
						intent2.putExtra("datno", datno);
						startActivity(intent2);

						break;


					default:

						Toast.makeText(SelektaTheme.this, "Please select a land cover first.", Toast.LENGTH_LONG ).show();

						break;

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
				Intent intent = new Intent(SelektaTheme.this, MainActivity.class);
				startActivity(intent);
				return true;
		}
		return super.onOptionsItemSelected(item);
	}
	


}
