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
import java.util.*;
import android.widget.*;
import android.content.pm.*;
import android.app.*;
import java.io.*;
import android.os.*;
import org.json.*;
public class MainActivity extends AppCompatActivity 
{
	 private SectionsPagerAdapter mSectionsPagerAdapter;

	 /**
	  * The {@link ViewPager} that will host the section contents.
	  */
	 private ViewPager mViewPager;
	 private ArrayList<Map<String,String>> data=new ArrayList<>();
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.main);

		  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		 setSupportActionBar(toolbar);
		  // Create the adapter that will return a fragment for each of the three
		  // primary sections of the activity.
		  mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		  ListView list=(ListView)findViewById(R.id.AppList);
		  SimpleAdapter adapter=new SimpleAdapter(this,data,R.layout.app_item,new String[]{"name","pack"},new int[]{R.id.name,R.id.pack});
		  list.setAdapter(adapter);
		  start();
		  // Set up the ViewPager with the sections adapter.
		  /*mViewPager = (ViewPager) findViewById(R.id.container);
		  mViewPager.setAdapter(mSectionsPagerAdapter);
*/
	
		  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		  fab.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						 Snackbar.make(view, "本软件没有开源许可!", Snackbar.LENGTH_LONG)
							  .setAction("Action", null).show();
					}
			   });

	 }



	 @Override
	 public boolean onCreateOptionsMenu(Menu menu){
		  menu.add(Menu.NONE,5,1,"开发人员");
		  menu.add(Menu.NONE,6,2,"退出程序");
		  menu.add(Menu.NONE,7,3,"帮助");
		  return true;
	 }

	 public void modpe_off(){

finish();
	 }
	 @Override
	 public boolean onOptionsItemSelected(MenuItem item) {
		  // TODO Auto-generated method stub
		  switch(item.getItemId()){
			   case 5:	       
					Intent mainIntent = new Intent(MainActivity.this, About.class);
					MainActivity.this.startActivity(mainIntent);

					//  Toast.makeText(MainActivity.this, ""+"关于", Toast.LENGTH_SHORT).show();
					break ;
			   case 6:
					modpe_off();

					//Toast.makeText(MainActivity.this, ""+"设置", Toast.LENGTH_SHORT).show();
					break;
			   case 7:
					帮助();
				//	View view = null;
					//Snackbar snackbar=Snackbar.make(view, "Snack Bar Text", Snackbar.LENGTH_INDEFINITE);
					//snackbar.show();
					// Toast.makeText(MainActivity.this, ""+"退出", Toast.LENGTH_SHORT).show();
					break;
			   default:
					break;
		  }
//	       Toast.makeText(MainActivity.this, ""+item.getItemId(), Toast.LENGTH_SHORT).show();

		  return super.onOptionsItemSelected(item);
	 }
	 
	 /**
	  * A placeholder fragment containing a simple view.
	  */
	 public static class PlaceholderFragment extends Fragment {
		  /**
		   * The fragment argument representing the section number for this
		   * fragment.
		   */
		  private static final String ARG_SECTION_NUMBER = "section_number";

		  public PlaceholderFragment() {
		  }

		  /**
		   * Returns a new instance of this fragment for the given section
		   * number.
		   */
		  public static PlaceholderFragment newInstance(int sectionNumber) {
			   PlaceholderFragment fragment = new PlaceholderFragment();
			   Bundle args = new Bundle();
			   args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			   fragment.setArguments(args);
			   return fragment;
		  }

		  @Override
		  public View onCreateView(LayoutInflater inflater, ViewGroup container,
								   Bundle savedInstanceState) {
			   View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			   TextView textView = (TextView) rootView.findViewById(R.id.section_label);
			   textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
			   return rootView;
		  }
	 }

	 /**
	  * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	  * one of the sections/tabs/pages.
	  */
	 public class SectionsPagerAdapter extends FragmentPagerAdapter {

		  public SectionsPagerAdapter(FragmentManager fm) {
			   super(fm);
		  }

		  @Override
		  public Fragment getItem(int position) {
			   // getItem is called to instantiate the fragment for the given page.
			   // Return a PlaceholderFragment (defined as a static inner class below).
			   return PlaceholderFragment.newInstance(position + 1);
		  }

		  @Override
		  public int getCount() {
			   // Show 3 total pages.
			   return 3;
		  }

		  @Override
		  public CharSequence getPageTitle(int position) {
			   switch (position) {
					case 0:
						 return "SECTION 1";
					case 1:
						 return "SECTION 2";
					case 2:
						 return "SECTION 3";
			   }
			   return null;
		  }
	 }
	 //核心算法
	 public void start(){
		  List<PackageInfo> packages=getPackageManager().getInstalledPackages(0);//定义系统安装程序信息
		  for(int i=0;i<packages.size();i++){
			   final PackageInfo packinfo=packages.get(i);
			   HashMap<String,String>item=new HashMap<>();
			   item.put("name",""+packinfo.applicationInfo.loadLabel(getPackageManager()));
			   item.put("pack",""+packinfo.packageName);
			//   item.put("icon",""+packinfo.applicationIcon(applicationInfo));

			   data.add(item);

		  }
	 }
	 
	 public void 帮助() {
		//LayoutInflater inf=LayoutInflater.from(MainActivity.this);
		//final View v=inf.inflate(R.layout.help,null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setMessage("帮助");
        //dialog.setView(v);
		  dialog.setMessage("帮助|･ω･｀)\n该表对应的是本机已安装软件名和及其包名\n包括系统应用和Native app\n本软件没有开源许可,请勿擅自反编译\n作者为Sij死机小工\nQQ:1229258499");
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface p1, int p2) {
					
					
				}
			});
        dialog.show();

    }
	
	/*public void 保存数据表(String 名字) throws IOException{
		 
		 //创建File对象
		 File file = new File("/sdcrad/"+名字+".txt");
		 List<PackageInfo> packages=getPackageManager().getInstalledPackages(0);
		 for(int i=0;i<packages.size();i++){
			  final PackageInfo packinfo=packages.get(i);
			  HashMap<String,String>item=new HashMap<>();
			  item.put("name",""+packinfo.applicationInfo.loadLabel(getPackageManager()));
			  item.put("pack",""+packinfo.packageName);
			//  for (int i = 0; i < list.size(); i++) {  
				   // 取出当前的Map，转化为JSONObject  
				   JSONObject obj = new JSONObject(list.get(i));  
				   // 转化为字符串并添加进新的List中  
				   cache.add(obj.toString());  
			 // }  
			  // 可存储的字符串数据  
			  String listStr = cache.toString();  
			  
			
	}
	}
	*/
}

