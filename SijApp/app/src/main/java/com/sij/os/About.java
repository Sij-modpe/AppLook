package com.sij.os;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.content.*;
import android.app.*;
import android.webkit.*;
public class About extends Activity
{
	 @Override
	 protected void onCreate(Bundle savedInstanceState)
	 {

		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.kaifa);

		  WebView webview=(WebView)findViewById(R.id.webView1);

		  StringBuilder html=new StringBuilder();

		  html.append("<div><big><b>AppLook</b></div></big> ");
		  html.append("Copyright © AbstractMethod 2014-2017 All rights reserved.");
		  html.append("<ul></ul>");
		  html.append("<ul>");
		  html.append("<li>Sij死机小工 开发人员</li>");
		  html.append("</ul>");

		  html.append("<div><b>一旦您使用本软件，即代表您同意您不会，也不会促使他人使用反编译等手段试图获取或修改本软件的源代码。如果您不能接受，请勿使用本软件。</b></div>");

		  webview.loadDataWithBaseURL(null,html.toString(),"text/html","uft-8",null);
	 }
	

}

