package com.jaxbot.glass.ucfwebcams;

import android.app.Activity;
import android.view.View;
import android.view.WindowManager;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.content.res.Resources;
import android.speech.RecognizerIntent;
import android.util.Log;

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

import android.graphics.Color;

import android.webkit.WebView;

import com.google.android.glass.app.*;
import com.google.android.glass.widget.*;
import android.view.ViewGroup;

public class MainActivity extends Activity {
	private List<WebView> mCards;
	private	CardScrollView mCardScrollView;
	private String[] CAM_IDS = { "18", "21", "14", "26", "11", "10" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mCards = new ArrayList<WebView>();

		int i;
		WebView webview;
		for (i = 0; i < CAM_IDS.length; i++) {
			webview = new WebView(this);
			webview.loadData("<img src='http://webcams.sdes.ucf.edu/webcam/Stream/" + CAM_IDS[i] + "' style='max-width:630px;max-height:360px'>", "text/html", null);
			webview.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
			webview.setBackgroundColor(Color.argb(1, 0, 0, 0));
			mCards.add(webview);
		}

		mCardScrollView = new CardScrollView(this);
		MyCardScrollAdapter adapter = new MyCardScrollAdapter();
		mCardScrollView.setAdapter(adapter);
		mCardScrollView.activate();
		setContentView(mCardScrollView);
	}

	private class MyCardScrollAdapter extends CardScrollAdapter {
		@Override
		public int getPosition(Object item) {
			return mCards.indexOf(item);
		}

		@Override
		public int getCount() {
			return mCards.size();
		}

		@Override
		public Object getItem(int position) {
			return mCards.get(position);
		}

		@Override
		public int getViewTypeCount() {
			return 0;
		}

		@Override
		public int getItemViewType(int position){
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			return mCards.get(position);
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}

