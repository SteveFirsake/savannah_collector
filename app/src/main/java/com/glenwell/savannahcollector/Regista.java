package com.glenwell.savannahcollector;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.glenwell.savannahcollector.utils.AsyncTaskCompleteListener;
import com.glenwell.savannahcollector.utils.Constantori;
import com.glenwell.savannahcollector.utils.DatabaseHandler;
import com.glenwell.savannahcollector.utils.NetPost;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Regista extends AppCompatActivity implements AsyncTaskCompleteListener {


	EditText usamail,usapaso,usapasoc, usanem, usafon;
	TextInputLayout textIL1, textIL2, textIL3, textIL6, textIL7 ;
	View View;
	Map<String,String> map = new HashMap<String, String>();
	String lato, lono;
	String reggo = "";
	public Context context = this;
	DatabaseHandler db = DatabaseHandler.getInstance(this);
	private String cntry;
	private String cntryy;
	private String ssusanem;
	private String ssusafon;
	private String ssusapepe;
	private String ssusapaso;
	private String ssusaref;
	TextView uucnt;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.regista_new);
	     overridePendingTransition(0,0);

		 usanem = (EditText) findViewById(R.id.username);
		 usafon = (EditText) findViewById(R.id.uphoneno);
		 usamail = (EditText) findViewById(R.id.uemailo);
		 usapaso = (EditText) findViewById(R.id.upasso);
		 usapasoc = (EditText) findViewById(R.id.upasso2);

		 uucnt = (TextView) findViewById(R.id.textView333);

		 textIL1 = (TextInputLayout)  findViewById(R.id.textIL1);
		 textIL2 = (TextInputLayout)  findViewById(R.id.textIL2);
		 textIL3 = (TextInputLayout)  findViewById(R.id.textIL3);
		 textIL6 = (TextInputLayout)  findViewById(R.id.textIL6);
		 textIL7 = (TextInputLayout)  findViewById(R.id.textIL7);

		 Button butreg = (Button) findViewById (R.id.logreg);

		 usanem.addTextChangedListener(new MyTextWatcher(textIL1));
		 usafon.addTextChangedListener(new MyTextWatcher(textIL2));
		 usamail.addTextChangedListener(new MyTextWatcher(textIL3));
		 usapaso.addTextChangedListener(new MyTextWatcher(textIL6));
		 usapasoc.addTextChangedListener(new MyTextWatcher(textIL7));



		 cntryy = guc(this);
		 try{
		 if (cntryy.equals("ad")){uucnt.setText("Andorra");}
		 else if (cntryy.equals("ae")){uucnt.setText("United Arab Emirates");}
		 else if (cntryy.equals("af")){uucnt.setText("Afghanistan");}
		 else if (cntryy.equals("ag")){uucnt.setText("Antigua and Barbuda");}
		 else if (cntryy.equals("ai")){uucnt.setText("Anguilla");}
		 else if (cntryy.equals("al")){uucnt.setText("Albania");}
		 else if (cntryy.equals("am")){uucnt.setText("Armenia");}
		 else if (cntryy.equals("an")){uucnt.setText("Netherlands Antilles");}
		 else if (cntryy.equals("ao")){uucnt.setText("Angola");}
		 else if (cntryy.equals("aq")){uucnt.setText("Antarctica");}
		 else if (cntryy.equals("ar")){uucnt.setText("Argentina");}
		 else if (cntryy.equals("as")){uucnt.setText("American Samoa");}
		 else if (cntryy.equals("at")){uucnt.setText("Austria");}
		 else if (cntryy.equals("au")){uucnt.setText("Australia");}
		 else if (cntryy.equals("aw")){uucnt.setText("Aruba");}
		 else if (cntryy.equals("az")){uucnt.setText("Azerbaidjan");}
		 else if (cntryy.equals("ba")){uucnt.setText("Bosnia-Herzegovina");}
		 else if (cntryy.equals("bb")){uucnt.setText("Barbados");}
		 else if (cntryy.equals("bd")){uucnt.setText("Bangladesh");}
		 else if (cntryy.equals("be")){uucnt.setText("Belgium");}
		 else if (cntryy.equals("bf")){uucnt.setText("Burkina Faso");}
		 else if (cntryy.equals("bg")){uucnt.setText("Bulgaria");}
		 else if (cntryy.equals("bh")){uucnt.setText("Bahrain");}
		 else if (cntryy.equals("bi")){uucnt.setText("Burundi");}
		 else if (cntryy.equals("bj")){uucnt.setText("Benin");}
		 else if (cntryy.equals("bm")){uucnt.setText("Bermuda");}
		 else if (cntryy.equals("bn")){uucnt.setText("Brunei Darussalam");}
		 else if (cntryy.equals("bo")){uucnt.setText("Bolivia");}
		 else if (cntryy.equals("br")){uucnt.setText("Brazil");}
		 else if (cntryy.equals("bs")){uucnt.setText("Bahamas");}
		 else if (cntryy.equals("bt")){uucnt.setText("Bhutan");}
		 else if (cntryy.equals("bv")){uucnt.setText("Bouvet Island");}
		 else if (cntryy.equals("bw")){uucnt.setText("Botswana");}
		 else if (cntryy.equals("by")){uucnt.setText("Belarus");}
		 else if (cntryy.equals("bz")){uucnt.setText("Belize");}
		 else if (cntryy.equals("ca")){uucnt.setText("Canada");}
		 else if (cntryy.equals("cc")){uucnt.setText("Cocos (Keeling) Islands");}
		 else if (cntryy.equals("cf")){uucnt.setText("Central African Republic");}
		 else if (cntryy.equals("cg")){uucnt.setText("Congo");}
		 else if (cntryy.equals("ch")){uucnt.setText("Switzerland");}
		 else if (cntryy.equals("ci")){uucnt.setText("Ivory Coast (Cote D'Ivoire)");}
		 else if (cntryy.equals("ck")){uucnt.setText("Cook Islands");}
		 else if (cntryy.equals("cl")){uucnt.setText("Chile");}
		 else if (cntryy.equals("cm")){uucnt.setText("Cameroon");}
		 else if (cntryy.equals("cn")){uucnt.setText("China");}
		 else if (cntryy.equals("co")){uucnt.setText("Colombia");}
		 else if (cntryy.equals("cr")){uucnt.setText("Costa Rica");}
		 else if (cntryy.equals("cs")){uucnt.setText("Former Czechoslovakia");}
		 else if (cntryy.equals("cu")){uucnt.setText("Cuba");}
		 else if (cntryy.equals("cv")){uucnt.setText("Cape Verde");}
		 else if (cntryy.equals("cx")){uucnt.setText("Christmas Island");}
		 else if (cntryy.equals("cy")){uucnt.setText("Cyprus");}
		 else if (cntryy.equals("cz")){uucnt.setText("Czech Republic");}
		 else if (cntryy.equals("de")){uucnt.setText("Germany");}
		 else if (cntryy.equals("dj")){uucnt.setText("Djibouti");}
		 else if (cntryy.equals("dk")){uucnt.setText("Denmark");}
		 else if (cntryy.equals("dm")){uucnt.setText("Dominica");}
		 else if (cntryy.equals("do")){uucnt.setText("Dominican Republic");}
		 else if (cntryy.equals("dz")){uucnt.setText("Algeria");}
		 else if (cntryy.equals("ec")){uucnt.setText("Ecuador");}
		 else if (cntryy.equals("edu")){uucnt.setText("USA Educational");}
		 else if (cntryy.equals("ee")){uucnt.setText("Estonia");}
		 else if (cntryy.equals("eg")){uucnt.setText("Egypt");}
		 else if (cntryy.equals("eh")){uucnt.setText("Western Sahara");}
		 else if (cntryy.equals("er")){uucnt.setText("Eritrea");}
		 else if (cntryy.equals("es")){uucnt.setText("Spain");}
		 else if (cntryy.equals("et")){uucnt.setText("Ethiopia");}
		 else if (cntryy.equals("fi")){uucnt.setText("Finland");}
		 else if (cntryy.equals("fj")){uucnt.setText("Fiji");}
		 else if (cntryy.equals("fk")){uucnt.setText("Falkland Islands");}
		 else if (cntryy.equals("fm")){uucnt.setText("Micronesia");}
		 else if (cntryy.equals("fo")){uucnt.setText("Faroe Islands");}
		 else if (cntryy.equals("fr")){uucnt.setText("France");}
		 else if (cntryy.equals("fx")){uucnt.setText("France (European Territory)");}
		 else if (cntryy.equals("ga")){uucnt.setText("Gabon");}
		 else if (cntryy.equals("gb")){uucnt.setText("Great Britain");}
		 else if (cntryy.equals("gd")){uucnt.setText("Grenada");}
		 else if (cntryy.equals("ge")){uucnt.setText("Georgia");}
		 else if (cntryy.equals("gf")){uucnt.setText("French Guyana");}
		 else if (cntryy.equals("gh")){uucnt.setText("Ghana");}
		 else if (cntryy.equals("gi")){uucnt.setText("Gibraltar");}
		 else if (cntryy.equals("gl")){uucnt.setText("Greenland");}
		 else if (cntryy.equals("gm")){uucnt.setText("Gambia");}
		 else if (cntryy.equals("gn")){uucnt.setText("Guinea");}
		 else if (cntryy.equals("gp")){uucnt.setText("Guadeloupe (French)");}
		 else if (cntryy.equals("gq")){uucnt.setText("Equatorial Guinea");}
		 else if (cntryy.equals("gr")){uucnt.setText("Greece");}
		 else if (cntryy.equals("gs")){uucnt.setText("S. Georgia & S. Sandwich Isls.");}
		 else if (cntryy.equals("gt")){uucnt.setText("Guatemala");}
		 else if (cntryy.equals("gu")){uucnt.setText("Guam (USA)");}
		 else if (cntryy.equals("gw")){uucnt.setText("Guinea Bissau");}
		 else if (cntryy.equals("gy")){uucnt.setText("Guyana");}
		 else if (cntryy.equals("hk")){uucnt.setText("Hong Kong");}
		 else if (cntryy.equals("hm")){uucnt.setText("Heard and McDonald Islands");}
		 else if (cntryy.equals("hn")){uucnt.setText("Honduras");}
		 else if (cntryy.equals("hr")){uucnt.setText("Croatia");}
		 else if (cntryy.equals("ht")){uucnt.setText("Haiti");}
		 else if (cntryy.equals("hu")){uucnt.setText("Hungary");}
		 else if (cntryy.equals("id")){uucnt.setText("Indonesia");}
		 else if (cntryy.equals("ie")){uucnt.setText("Ireland");}
		 else if (cntryy.equals("il")){uucnt.setText("Israel");}
		 else if (cntryy.equals("in")){uucnt.setText("India");}
		 else if (cntryy.equals("int")){uucnt.setText("International");}
		 else if (cntryy.equals("io")){uucnt.setText("British Indian Ocean Territory");}
		 else if (cntryy.equals("iq")){uucnt.setText("Iraq");}
		 else if (cntryy.equals("ir")){uucnt.setText("Iran");}
		 else if (cntryy.equals("is")){uucnt.setText("Iceland");}
		 else if (cntryy.equals("it")){uucnt.setText("Italy");}
		 else if (cntryy.equals("jm")){uucnt.setText("Jamaica");}
		 else if (cntryy.equals("jo")){uucnt.setText("Jordan");}
		 else if (cntryy.equals("jp")){uucnt.setText("Japan");}
		 else if (cntryy.equals("ke")){uucnt.setText("Kenya");}
		 else if (cntryy.equals("kg")){uucnt.setText("Kyrgyzstan");}
		 else if (cntryy.equals("kh")){uucnt.setText("Cambodia");}
		 else if (cntryy.equals("ki")){uucnt.setText("Kiribati");}
		 else if (cntryy.equals("km")){uucnt.setText("Comoros");}
		 else if (cntryy.equals("kn")){uucnt.setText("Saint Kitts & Nevis Anguilla");}
		 else if (cntryy.equals("kp")){uucnt.setText("North Korea");}
		 else if (cntryy.equals("kr")){uucnt.setText("South Korea");}
		 else if (cntryy.equals("kw")){uucnt.setText("Kuwait");}
		 else if (cntryy.equals("ky")){uucnt.setText("Cayman Islands");}
		 else if (cntryy.equals("kz")){uucnt.setText("Kazakhstan");}
		 else if (cntryy.equals("la")){uucnt.setText("Laos");}
		 else if (cntryy.equals("lb")){uucnt.setText("Lebanon");}
		 else if (cntryy.equals("lc")){uucnt.setText("Saint Lucia");}
		 else if (cntryy.equals("li")){uucnt.setText("Liechtenstein");}
		 else if (cntryy.equals("lk")){uucnt.setText("Sri Lanka");}
		 else if (cntryy.equals("lr")){uucnt.setText("Liberia");}
		 else if (cntryy.equals("ls")){uucnt.setText("Lesotho");}
		 else if (cntryy.equals("lt")){uucnt.setText("Lithuania");}
		 else if (cntryy.equals("lu")){uucnt.setText("Luxembourg");}
		 else if (cntryy.equals("lv")){uucnt.setText("Latvia");}
		 else if (cntryy.equals("ly")){uucnt.setText("Libya");}
		 else if (cntryy.equals("ma")){uucnt.setText("Morocco");}
		 else if (cntryy.equals("mc")){uucnt.setText("Monaco");}
		 else if (cntryy.equals("md")){uucnt.setText("Moldavia");}
		 else if (cntryy.equals("mg")){uucnt.setText("Madagascar");}
		 else if (cntryy.equals("mh")){uucnt.setText("Marshall Islands");}
		 else if (cntryy.equals("mil")){uucnt.setText("USA Military");}
		 else if (cntryy.equals("mk")){uucnt.setText("Macedonia");}
		 else if (cntryy.equals("ml")){uucnt.setText("Mali");}
		 else if (cntryy.equals("mm")){uucnt.setText("Myanmar");}
		 else if (cntryy.equals("mn")){uucnt.setText("Mongolia");}
		 else if (cntryy.equals("mo")){uucnt.setText("Macau");}
		 else if (cntryy.equals("mp")){uucnt.setText("Northern Mariana Islands");}
		 else if (cntryy.equals("mq")){uucnt.setText("Martinique (French)");}
		 else if (cntryy.equals("mr")){uucnt.setText("Mauritania");}
		 else if (cntryy.equals("ms")){uucnt.setText("Montserrat");}
		 else if (cntryy.equals("mt")){uucnt.setText("Malta");}
		 else if (cntryy.equals("mu")){uucnt.setText("Mauritius");}
		 else if (cntryy.equals("mv")){uucnt.setText("Maldives");}
		 else if (cntryy.equals("mw")){uucnt.setText("Malawi");}
		 else if (cntryy.equals("mx")){uucnt.setText("Mexico");}
		 else if (cntryy.equals("my")){uucnt.setText("Malaysia");}
		 else if (cntryy.equals("mz")){uucnt.setText("Mozambique");}
		 else if (cntryy.equals("na")){uucnt.setText("Namibia");}
		 else if (cntryy.equals("nc")){uucnt.setText("New Caledonia (French)");}
		 else if (cntryy.equals("ne")){uucnt.setText("Niger");}
		 else if (cntryy.equals("net")){uucnt.setText("Network");}
		 else if (cntryy.equals("nf")){uucnt.setText("Norfolk Island");}
		 else if (cntryy.equals("ng")){uucnt.setText("Nigeria");}
		 else if (cntryy.equals("ni")){uucnt.setText("Nicaragua");}
		 else if (cntryy.equals("nl")){uucnt.setText("Netherlands");}
		 else if (cntryy.equals("no")){uucnt.setText("Norway");}
		 else if (cntryy.equals("np")){uucnt.setText("Nepal");}
		 else if (cntryy.equals("nr")){uucnt.setText("Nauru");}
		 else if (cntryy.equals("nt")){uucnt.setText("Neutral Zone");}
		 else if (cntryy.equals("nu")){uucnt.setText("Niue");}
		 else if (cntryy.equals("nz")){uucnt.setText("New Zealand");}
		 else if (cntryy.equals("om")){uucnt.setText("Oman");}
		 else if (cntryy.equals("pa")){uucnt.setText("Panama");}
		 else if (cntryy.equals("pe")){uucnt.setText("Peru");}
		 else if (cntryy.equals("pf")){uucnt.setText("Polynesia (French)");}
		 else if (cntryy.equals("pg")){uucnt.setText("Papua New Guinea");}
		 else if (cntryy.equals("ph")){uucnt.setText("Philippines");}
		 else if (cntryy.equals("pk")){uucnt.setText("Pakistan");}
		 else if (cntryy.equals("pl")){uucnt.setText("Poland");}
		 else if (cntryy.equals("pm")){uucnt.setText("Saint Pierre and Miquelon");}
		 else if (cntryy.equals("pn")){uucnt.setText("Pitcairn Island");}
		 else if (cntryy.equals("pr")){uucnt.setText("Puerto Rico");}
		 else if (cntryy.equals("pt")){uucnt.setText("Portugal");}
		 else if (cntryy.equals("pw")){uucnt.setText("Palau");}
		 else if (cntryy.equals("py")){uucnt.setText("Paraguay");}
		 else if (cntryy.equals("qa")){uucnt.setText("Qatar");}
		 else if (cntryy.equals("re")){uucnt.setText("Reunion (French)");}
		 else if (cntryy.equals("ro")){uucnt.setText("Romania");}
		 else if (cntryy.equals("ru")){uucnt.setText("Russian Federation");}
		 else if (cntryy.equals("rw")){uucnt.setText("Rwanda");}
		 else if (cntryy.equals("sa")){uucnt.setText("Saudi Arabia");}
		 else if (cntryy.equals("sb")){uucnt.setText("Solomon Islands");}
		 else if (cntryy.equals("sc")){uucnt.setText("Seychelles");}
		 else if (cntryy.equals("sd")){uucnt.setText("Sudan");}
		 else if (cntryy.equals("se")){uucnt.setText("Sweden");}
		 else if (cntryy.equals("sg")){uucnt.setText("Singapore");}
		 else if (cntryy.equals("sh")){uucnt.setText("Saint Helena");}
		 else if (cntryy.equals("si")){uucnt.setText("Slovenia");}
		 else if (cntryy.equals("sj")){uucnt.setText("Svalbard and Jan Mayen Islands");}
		 else if (cntryy.equals("sk")){uucnt.setText("Slovak Republic");}
		 else if (cntryy.equals("sl")){uucnt.setText("Sierra Leone");}
		 else if (cntryy.equals("sm")){uucnt.setText("San Marino");}
		 else if (cntryy.equals("sn")){uucnt.setText("Senegal");}
		 else if (cntryy.equals("so")){uucnt.setText("Somalia");}
		 else if (cntryy.equals("sr")){uucnt.setText("Suriname");}
		 else if (cntryy.equals("st")){uucnt.setText("Saint Tome (Sao Tome) and Principe");}
		 else if (cntryy.equals("su")){uucnt.setText("Former USSR");}
		 else if (cntryy.equals("sv")){uucnt.setText("El Salvador");}
		 else if (cntryy.equals("sy")){uucnt.setText("Syria");}
		 else if (cntryy.equals("sz")){uucnt.setText("Swaziland");}
		 else if (cntryy.equals("tc")){uucnt.setText("Turks and Caicos Islands");}
		 else if (cntryy.equals("td")){uucnt.setText("Chad");}
		 else if (cntryy.equals("tf")){uucnt.setText("French Southern Territories");}
		 else if (cntryy.equals("tg")){uucnt.setText("Togo");}
		 else if (cntryy.equals("th")){uucnt.setText("Thailand");}
		 else if (cntryy.equals("tj")){uucnt.setText("Tadjikistan");}
		 else if (cntryy.equals("tk")){uucnt.setText("Tokelau");}
		 else if (cntryy.equals("tm")){uucnt.setText("Turkmenistan");}
		 else if (cntryy.equals("tn")){uucnt.setText("Tunisia");}
		 else if (cntryy.equals("to")){uucnt.setText("Tonga");}
		 else if (cntryy.equals("tp")){uucnt.setText("East Timor");}
		 else if (cntryy.equals("tr")){uucnt.setText("Turkey");}
		 else if (cntryy.equals("tt")){uucnt.setText("Trinidad and Tobago");}
		 else if (cntryy.equals("tv")){uucnt.setText("Tuvalu");}
		 else if (cntryy.equals("tw")){uucnt.setText("Taiwan");}
		 else if (cntryy.equals("tz")){uucnt.setText("Tanzania");}
		 else if (cntryy.equals("ua")){uucnt.setText("Ukraine");}
		 else if (cntryy.equals("ug")){uucnt.setText("Uganda");}
		 else if (cntryy.equals("uk")){uucnt.setText("United Kingdom");}
		 else if (cntryy.equals("um")){uucnt.setText("USA Minor Outlying Islands");}
		 else if (cntryy.equals("us")){uucnt.setText("United States");}
		 else if (cntryy.equals("uy")){uucnt.setText("Uruguay");}
		 else if (cntryy.equals("uz")){uucnt.setText("Uzbekistan");}
		 else if (cntryy.equals("va")){uucnt.setText("Vatican City State");}
		 else if (cntryy.equals("vc")){uucnt.setText("Saint Vincent & Grenadines");}
		 else if (cntryy.equals("ve")){uucnt.setText("Venezuela");}
		 else if (cntryy.equals("vg")){uucnt.setText("Virgin Islands (British)");}
		 else if (cntryy.equals("vi")){uucnt.setText("Virgin Islands (USA)");}
		 else if (cntryy.equals("vn")){uucnt.setText("Vietnam");}
		 else if (cntryy.equals("vu")){uucnt.setText("Vanuatu");}
		 else if (cntryy.equals("wf")){uucnt.setText("Wallis and Futuna Islands");}
		 else if (cntryy.equals("ws")){uucnt.setText("Samoa");}
		 else if (cntryy.equals("ye")){uucnt.setText("Yemen");}
		 else if (cntryy.equals("yt")){uucnt.setText("Mayotte");}
		 else if (cntryy.equals("yu")){uucnt.setText("Yugoslavia");}
		 else if (cntryy.equals("za")){uucnt.setText("South Africa");}
		 else if (cntryy.equals("zm")){uucnt.setText("Zambia");}
		 else if (cntryy.equals("zr")){uucnt.setText("Zaire");}
		 else if (cntryy.equals("zw")){uucnt.setText("Zimbabwe");}
		 }catch(Exception e){
			 uucnt.setText("No SIM inserted");
		 }


		 doDBstuff("Login");

		 

			
			Intent intentqa = getIntent();
			 lato = intentqa.getStringExtra("lattt");
			 Intent intentqaa = getIntent();
			 lono = intentqaa.getStringExtra("lonnn");
		 Intent intentqo = getIntent();
		 reggo = intentqo.getStringExtra("reggo");
			

			
			butreg.setOnClickListener(new OnClickListener(){
		    	
		    	public void onClick(View view){


					if (!validateName()) {
						return;
					}

					if (!validatePhone()) {
						return;
					}

					if (!validateEmail()) {
						return;
					}

					if (!validatePass()) {
						return;
					}

					if (!validatePass2()) {
						return;
					}


						cntry  = uucnt.getText().toString().trim();
						ssusanem= usanem.getText().toString().trim();
						ssusafon = usafon.getText().toString().trim();
						ssusafon.replaceAll("[^0-9+]", "");
						ssusapepe = usamail.getText().toString().trim();
						ssusapaso = usapaso.getText().toString().trim();


						map.put(Constantori.KEY_USERACTIVE, Constantori.USERACTIVE);
						map.put(Constantori.KEY_USERNEM, ssusanem);
						map.put(Constantori.KEY_USERTEL, ssusafon);
						map.put(Constantori.KEY_USERCNTRY, cntry);
						map.put(Constantori.KEY_USEREMAIL, ssusapepe);
						map.put(Constantori.KEY_USERPASS, ssusapaso);
						map.put(Constantori.KEY_USERLAT, lato);
						map.put(Constantori.KEY_USERLON, lono);
						map.put(Constantori.KEY_USERREF, ssusaref);

						doDBstuff("Saving");

						if (Constantori.isConnectedToInternet()){
							new NetPost(context, "regista_PostJSON", Constantori.getJSON(map), "Registering.....", Constantori.TABLE_REGISTER, Constantori.KEY_USERACTIVE, Regista.this).execute(new String[]{Constantori.URL_GEN});
					       }else{
							Toast.makeText(context,Constantori.ERROR_NO_INTERNET,Toast.LENGTH_LONG).show();
							}



		    	}
			    });
			
}


	private class MyTextWatcher implements TextWatcher {

		private View view;

		private MyTextWatcher(View view) {
			this.view = view;
		}

		public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
		}

		public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
		}

		public void afterTextChanged(Editable editable) {
			switch (view.getId()) {
				case R.id.textIL1:
					validateName();
					break;
				case R.id.textIL2:
					validatePhone();
					break;
				case R.id.textIL3:
					validateEmail();
					break;
				case R.id.textIL6:
					validatePass();
					break;
				case R.id.textIL7:
					validatePass2();
					break;
			}
		}
	}

	private boolean validateName() {
		if (usanem.getText().toString().trim().isEmpty()) {
			textIL1.setError(getString(R.string.err_msg_name));
			requestFocus(usanem);
			return false;
		} else {
			textIL1.setErrorEnabled(false);
		}

		return true;
	}

	private boolean validateEmail() {
		String email = usamail.getText().toString().trim();

		if (email.isEmpty() || !isValidEmail(email)) {
			textIL3.setError(getString(R.string.err_msg_email));
			requestFocus(usamail);
			return false;
		} else {
			textIL3.setErrorEnabled(false);
		}

		return true;
	}

	private boolean validatePass() {
		if (usapaso.getText().toString().trim().isEmpty()) {
			textIL6.setError(getString(R.string.err_msg_password));
			requestFocus(usapaso);
			return false;
		} else {
			textIL6.setErrorEnabled(false);
		}

		return true;
	}

	private boolean validatePass2() {
		if (!usapasoc.getText().toString().trim().equals(usapaso.getText().toString().trim())) {
			textIL7.setError(getString(R.string.err_msg_password2));
			requestFocus(usapasoc);
			return false;
		} else {
			textIL7.setErrorEnabled(false);
		}

		return true;
	}

	private boolean validatePhone() {
		if (
				usafon.getText().toString().trim().length()!=0 && usafon.getText().toString().trim().length() < 10) {
			textIL2.setError(getString(R.string.err_msg_phone));
			requestFocus(usafon);
			return false;
		} else {
			textIL2.setErrorEnabled(false);
		}

		return true;
	}

	private static boolean isValidEmail(String email) {
		return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}

	private void requestFocus(View view) {
		if (view.requestFocus()) {
			getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
		}
	}

	
	

   	public void diambaid2(View v) {
		final Dialog mbott = new Dialog(context, android.R.style.Theme_Translucent_NoTitleBar);
		mbott.setContentView(R.layout.mbaind_dialog2);
		mbott.setCanceledOnTouchOutside(false);
		mbott.setCancelable(false);
		WindowManager.LayoutParams lp = mbott.getWindow().getAttributes();
		lp.dimAmount=0.85f;
		mbott.getWindow().setAttributes(lp);
		mbott.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		mbott.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

		Button mbaok = (Button) mbott.findViewById(R.id.mbabtn1);
		mbaok.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){

				if (reggo.equals("main")) {

					Intent intent = new Intent(context, MainActivity.class);
					startActivity(intent);
				}else{

					Intent intent = new Intent(context, Loginno.class);
					startActivity(intent);
				}

					mbott.dismiss();
			}
		});
		mbott.show();
	}
   	


    public static String guc(Context context){
    	try{
    		final TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
    		final String ucon = tm.getSimCountryIso();
    		if (ucon!=null && ucon.length()==2){
    			return ucon.toLowerCase(Locale.US);
    		}else if (tm.getPhoneType()!=TelephonyManager.PHONE_TYPE_CDMA){
    			String unet = tm.getNetworkCountryIso();
    			if (unet != null && unet.length() == 2){
    				unet.toLowerCase(Locale.US);
    			}
    	}
    		
    	}catch(Exception e){
    		
    	}
    	return null;
    }


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			// Respond to the action bar's Up/Home button
			case android.R.id.home:
				//NavUtils.navigateUpFromSameTask(this);

				if (reggo.equals("main")) {

					Intent intent = new Intent(context, MainActivity.class);
					startActivity(intent);
				}else{
					Intent intent = new Intent(context, Loginno.class);
					startActivity(intent);
				}

				return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed(){

		Intent intentqo = getIntent();
		reggo = intentqo.getStringExtra("reggo");

		if (reggo.equals("main")) {

			Intent intent = new Intent(context, MainActivity.class);
			startActivity(intent);
		}else{
			Intent intent = new Intent(context, Loginno.class);
			startActivity(intent);
		}
	}


	public void doDBstuff(String where){



		switch (where){

			case "Login":

				if (db.CheckIsDataAlreadyInDBorNot(Constantori.TABLE_REGISTER, Constantori.KEY_USERACTIVE, Constantori.USERACTIVE)) {

					List<HashMap<String, String>> regData = db.GetAllData(Constantori.TABLE_REGISTER, "", "");

					HashMap<String, String> UserDetails = regData.get(0);

					usanem.setText(UserDetails.get(Constantori.KEY_USERNEM));
					usafon.setText(UserDetails.get(Constantori.KEY_USERTEL));
					uucnt.setText(UserDetails.get(Constantori.KEY_USERCNTRY));
					usamail.setText(UserDetails.get(Constantori.KEY_USEREMAIL));
					usapaso.setText(UserDetails.get(Constantori.KEY_USERPASS));

					ssusaref = UserDetails.get(Constantori.KEY_USERREF);

					/*for (int i = 0; i < orga.getAdapter().getCount(); i++) {
						if (UserDetails.get(Constantori.KEY_USERORG).trim().equals(orga.getAdapter().getItem(i).toString())) {
							orga.setSelection(i);
							break;
						}
					}*/
				}else{
					ssusaref = Constantori.USERREFNULL;
				}

				break;

			case "Saving":

				if (db.CheckIsDataAlreadyInDBorNot(Constantori.TABLE_REGISTER, Constantori.KEY_USERACTIVE, Constantori.USERACTIVE)) {
					db.RegisterUser_Update(Constantori.getJSON(map));
					Log.e(Constantori.APP_ERROR_PREFIX + "_RegUp", "Updating Register");
				}else {
					db.RegisterUser_Insert(Constantori.getJSON(map));
					Log.e(Constantori.APP_ERROR_PREFIX + "_RegIn", "Inserting Register");
				}

				break;

			default:
				//System.out.println("Uuuuuwi");
				break;
		}

	}



	@Override
	public void AsyncTaskCompleteListener(String result, String sender, String TableName, String FieldName)
	{
		switch (sender){
			case "regista_PostJSON":

				if(result.equals(null)) {
					Toast.makeText(context, Constantori.ERROR_SERVER_ISSUE, Toast.LENGTH_LONG).show();
				}else if(result.equals("Issue")) {
					Constantori.diambaidno(View, context);
				}else if(result.equals("404")) {
					Toast.makeText(context, Constantori.ERROR_USER_EXISTS, Toast.LENGTH_LONG).show();
				}else if(result.equals("303")) {
					Toast.makeText(context, Constantori.ERROR_SERVER_ISSUE, Toast.LENGTH_LONG).show();
				}else{

					try {
						JSONArray storesArray = new JSONArray(result);
						JSONObject storeObject = storesArray.getJSONObject(0);
						String pass = storeObject.getString(Constantori.POST_RESPONSEKEY);

						if (pass.equals(Constantori.POST_RESPONSEVAL)) {
							diambaid2(View);
						}

					}catch (Exception xx){
						Log.e(Constantori.APP_ERROR_PREFIX + "_RegistaJSON", xx.getMessage());
						xx.printStackTrace();
					}

				}

				break;

			default:

				break;

		}

	}


}