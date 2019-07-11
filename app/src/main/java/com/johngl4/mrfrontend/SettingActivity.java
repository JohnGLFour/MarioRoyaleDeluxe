package com.johngl4.mrfrontend;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.content.ClipData;
import android.widget.AdapterView;
import android.text.Editable;
import android.text.TextWatcher;
import android.support.v4.content.ContextCompat;
import android.support.v4.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class SettingActivity extends AppCompatActivity {
	
	public final int REQ_CD_SKIN = 101;
	
	private Toolbar _toolbar;
	private String server = "";
	
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<String> List2 = new ArrayList<>();
	
	private ScrollView vscroll3;
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear2;
	private LinearLayout linear6;
	private LinearLayout linear10;
	private LinearLayout linear9;
	private TextView textview1;
	private TextView textview2;
	private Spinner spinner1;
	private TextView textview3;
	private EditText edittext1;
	private TextView textview4;
	private Spinner spinner2;
	private TextView textview7;
	private EditText edittext4;
	private TextView textview6;
	private EditText edittext3;
	
	private SharedPreferences set;
	private Intent skin = new Intent(Intent.ACTION_GET_CONTENT);
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.setting);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		vscroll3 = (ScrollView) findViewById(R.id.vscroll3);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		textview3 = (TextView) findViewById(R.id.textview3);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		textview4 = (TextView) findViewById(R.id.textview4);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		textview7 = (TextView) findViewById(R.id.textview7);
		edittext4 = (EditText) findViewById(R.id.edittext4);
		textview6 = (TextView) findViewById(R.id.textview6);
		edittext3 = (EditText) findViewById(R.id.edittext3);
		set = getSharedPreferences("setting", Activity.MODE_PRIVATE);
		skin.setType("image/*");
		skin.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					set.edit().putString("server", "http://infernoplus.com").commit();
					set.edit().putString("customserver", "0").commit();
					set.edit().putString("serverselect", "0").commit();
					linear2.setVisibility(View.GONE);
					set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
				}
				if (_position == 1) {
					set.edit().putString("server", "http://marioroyale.co.uk").commit();
					set.edit().putString("customserver", "0").commit();
					set.edit().putString("serverselect", "1").commit();
					linear2.setVisibility(View.GONE);
					set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
				}
				if (_position == 2) {
					set.edit().putString("server", "http://marioroyale.cyuubi.gq").commit();
					set.edit().putString("customserver", "0").commit();
					set.edit().putString("serverselect", "2").commit();
					linear2.setVisibility(View.GONE);
					set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
				}
				if (_position == 3) {
					set.edit().putString("server", edittext1.getText().toString()).commit();
					set.edit().putString("serverlink", edittext1.getText().toString()).commit();
					set.edit().putString("customserver", "1").commit();
					set.edit().putString("serverselect", "3").commit();
					linear2.setVisibility(View.VISIBLE);
					set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				set.edit().putString("serverlink", edittext1.getText().toString()).commit();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					set.edit().putString("string2", String.valueOf((long)(spinner2.getSelectedItemPosition()))).commit();
					linear10.setVisibility(View.GONE);
					linear9.setVisibility(View.GONE);
					set.edit().putString("skinmod", "0").commit();
				}
				if (_position == 1) {
					set.edit().putString("string2", String.valueOf((long)(spinner2.getSelectedItemPosition()))).commit();
					linear10.setVisibility(View.VISIBLE);
					linear9.setVisibility(View.VISIBLE);
					set.edit().putString("skinmod", "1").commit();
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		edittext4.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				set.edit().putString("serverskinlink", edittext4.getText().toString()).commit();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		edittext3.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				set.edit().putString("skinmodlink", edittext3.getText().toString()).commit();
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
	}
	private void initializeLogic() {
		list.add("infernoplus.com");
		list.add("marioroyale.co.uk");
		list.add("marioroyale.cyuubi.gq");
		list.add("Custom Server");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, list));
		List2.add("Default");
		List2.add("URL");
		spinner2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, List2));
		if (set.getString("serverselect", "").equals("0")) {
			spinner1.setSelection((int)(Double.parseDouble(set.getString("string", ""))));
			set.edit().putString("server", "http://infernoplus.com").commit();
			set.edit().putString("customserver", "0").commit();
			set.edit().putString("serverselect", "0").commit();
			linear2.setVisibility(View.GONE);
			set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
		}
		if (set.getString("serverselect", "").equals("1")) {
			spinner1.setSelection((int)(Double.parseDouble(set.getString("string", ""))));
			set.edit().putString("server", "http://marioroyale.co.uk").commit();
			set.edit().putString("customserver", "0").commit();
			set.edit().putString("serverselect", "1").commit();
			linear2.setVisibility(View.GONE);
			set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
		}
		if (set.getString("serverselect", "").equals("2")) {
			spinner1.setSelection((int)(Double.parseDouble(set.getString("string", ""))));
			set.edit().putString("server", "http://marioroyale.cyuubi.gq").commit();
			set.edit().putString("customserver", "0").commit();
			set.edit().putString("serverselect", "2").commit();
			linear2.setVisibility(View.GONE);
			set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
		}
		if (set.getString("serverselect", "").equals("3")) {
			spinner1.setSelection((int)(Double.parseDouble(set.getString("string", ""))));
			edittext1.setText(set.getString("serverlink", ""));
			set.edit().putString("server", set.getString("serverlink", "")).commit();
			set.edit().putString("serverlink", set.getString("serverlink", "")).commit();
			set.edit().putString("customserver", "1").commit();
			set.edit().putString("serverselect", "3").commit();
			linear2.setVisibility(View.GONE);
			set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
		}
		if (set.getString("skinmod", "").equals("0")) {
			spinner2.setSelection((int)(Double.parseDouble(set.getString("string2", ""))));
			set.edit().putString("string2", String.valueOf((long)(spinner2.getSelectedItemPosition()))).commit();
			linear10.setVisibility(View.GONE);
			linear9.setVisibility(View.GONE);
			set.edit().putString("skinmod", "0").commit();
		}
		if (set.getString("skinmod", "").equals("1")) {
			spinner2.setSelection((int)(Double.parseDouble(set.getString("string2", ""))));
			set.edit().putString("string2", String.valueOf((long)(spinner2.getSelectedItemPosition()))).commit();
			linear10.setVisibility(View.VISIBLE);
			linear9.setVisibility(View.VISIBLE);
			set.edit().putString("skinmod", "1").commit();
			edittext4.setText(set.getString("serverskinlink", ""));
			edittext3.setText(set.getString("skinmodlink", ""));
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (set.getString("serverselect", "").equals("0")) {
			spinner1.setSelection((int)(Double.parseDouble(set.getString("string", ""))));
			set.edit().putString("server", "http://infernoplus.com").commit();
			set.edit().putString("customserver", "0").commit();
			set.edit().putString("serverselect", "0").commit();
			linear2.setVisibility(View.GONE);
			set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
		}
		if (set.getString("serverselect", "").equals("1")) {
			spinner1.setSelection((int)(Double.parseDouble(set.getString("string", ""))));
			set.edit().putString("server", "http://marioroyale.co.uk").commit();
			set.edit().putString("customserver", "0").commit();
			set.edit().putString("serverselect", "1").commit();
			linear2.setVisibility(View.GONE);
			set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
		}
		if (set.getString("serverselect", "").equals("2")) {
			spinner1.setSelection((int)(Double.parseDouble(set.getString("string", ""))));
			set.edit().putString("server", "http://marioroyale.cyuubi.gq").commit();
			set.edit().putString("customserver", "0").commit();
			set.edit().putString("serverselect", "2").commit();
			linear2.setVisibility(View.GONE);
			set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
		}
		if (set.getString("serverselect", "").equals("3")) {
			spinner1.setSelection((int)(Double.parseDouble(set.getString("string", ""))));
			edittext1.setText(set.getString("serverlink", ""));
			set.edit().putString("server", set.getString("serverlink", "")).commit();
			set.edit().putString("serverlink", set.getString("serverlink", "")).commit();
			set.edit().putString("customserver", "1").commit();
			set.edit().putString("serverselect", "3").commit();
			linear2.setVisibility(View.VISIBLE);
			set.edit().putString("string", String.valueOf((long)(spinner1.getSelectedItemPosition()))).commit();
		}
		if (set.getString("skinmod", "").equals("0")) {
			spinner2.setSelection((int)(Double.parseDouble(set.getString("string2", ""))));
			set.edit().putString("string2", String.valueOf((long)(spinner2.getSelectedItemPosition()))).commit();
			linear10.setVisibility(View.GONE);
			linear9.setVisibility(View.GONE);
			set.edit().putString("skinmod", "0").commit();
		}
		if (set.getString("skinmod", "").equals("1")) {
			spinner2.setSelection((int)(Double.parseDouble(set.getString("string2", ""))));
			set.edit().putString("string2", String.valueOf((long)(spinner2.getSelectedItemPosition()))).commit();
			linear10.setVisibility(View.VISIBLE);
			linear9.setVisibility(View.VISIBLE);
			set.edit().putString("skinmod", "1").commit();
			edittext4.setText(set.getString("serverskinlink", ""));
			edittext3.setText(set.getString("skinmodlink", ""));
		}
	}
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
