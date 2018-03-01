package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class main extends Activity implements B4AActivity{
	public static main mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = false;
	public static final boolean includeTitle = true;
    public static WeakReference<Activity> previousOne;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isFirst) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.main");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (main).");
				p.finish();
			}
		}
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		mostCurrent = this;
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.main");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.main", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (main) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (main) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return main.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null) //workaround for emulator bug (Issue 2423)
            return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        BA.LogInfo("** Activity (main) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
			if (mostCurrent == null || mostCurrent != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (main) Resume **");
		    processBA.raiseEvent(mostCurrent._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
public static boolean isAnyActivityVisible() {
    boolean vis = false;
vis = vis | (main.mostCurrent != null);
return vis;}

private static BA killProgramHelper(BA ba) {
    if (ba == null)
        return null;
    anywheresoftware.b4a.BA.SharedProcessBA sharedProcessBA = ba.sharedProcessBA;
    if (sharedProcessBA == null || sharedProcessBA.activityBA == null)
        return null;
    return sharedProcessBA.activityBA.get();
}
public static void killProgram() {
     {
            Activity __a = null;
            if (main.previousOne != null) {
				__a = main.previousOne.get();
			}
            else {
                BA ba = killProgramHelper(main.mostCurrent == null ? null : main.mostCurrent.processBA);
                if (ba != null) __a = ba.activity;
            }
            if (__a != null)
				__a.finish();}

BA.applicationContext.stopService(new android.content.Intent(BA.applicationContext, starter.class));
}
public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.Serial _serial1 = null;
public static boolean _connected = false;
public static anywheresoftware.b4a.objects.streams.File.TextWriterWrapper _textwiter1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _p_up = null;
public anywheresoftware.b4a.objects.PanelWrapper _p_down = null;
public anywheresoftware.b4a.objects.PanelWrapper _p_left = null;
public anywheresoftware.b4a.objects.PanelWrapper _p_right = null;
public anywheresoftware.b4a.objects.LabelWrapper _label1 = null;
public b4a.example.starter _starter = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime});
RDebugUtils.currentLine=131072;
 //BA.debugLineNum = 131072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=131075;
 //BA.debugLineNum = 131075;BA.debugLine="If FirstTime Then";
if (_firsttime) { 
RDebugUtils.currentLine=131076;
 //BA.debugLineNum = 131076;BA.debugLine="Serial1.Initialize(\"serial1\")";
_serial1.Initialize("serial1");
 };
RDebugUtils.currentLine=131079;
 //BA.debugLineNum = 131079;BA.debugLine="Activity.LoadLayout(\"control\")";
mostCurrent._activity.LoadLayout("control",mostCurrent.activityBA);
RDebugUtils.currentLine=131080;
 //BA.debugLineNum = 131080;BA.debugLine="Activity.AddMenuItem(\"Connect\",\"mnuConnect\")";
mostCurrent._activity.AddMenuItem(BA.ObjectToCharSequence("Connect"),"mnuConnect");
RDebugUtils.currentLine=131081;
 //BA.debugLineNum = 131081;BA.debugLine="Activity.AddMenuItem(\"Disconnect\",\"mnuDisconnect\"";
mostCurrent._activity.AddMenuItem(BA.ObjectToCharSequence("Disconnect"),"mnuDisconnect");
RDebugUtils.currentLine=131082;
 //BA.debugLineNum = 131082;BA.debugLine="Activity.AddMenuItem(\"About\",\"mnuAbout\")";
mostCurrent._activity.AddMenuItem(BA.ObjectToCharSequence("About"),"mnuAbout");
RDebugUtils.currentLine=131083;
 //BA.debugLineNum = 131083;BA.debugLine="Activity.AddMenuItem(\"Exit\",\"mnuExit\")";
mostCurrent._activity.AddMenuItem(BA.ObjectToCharSequence("Exit"),"mnuExit");
RDebugUtils.currentLine=131084;
 //BA.debugLineNum = 131084;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="main";
RDebugUtils.currentLine=262144;
 //BA.debugLineNum = 262144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=262146;
 //BA.debugLineNum = 262146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume"))
	return (String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null);
RDebugUtils.currentLine=196608;
 //BA.debugLineNum = 196608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=196609;
 //BA.debugLineNum = 196609;BA.debugLine="If Serial1.IsEnabled = False Then";
if (_serial1.IsEnabled()==anywheresoftware.b4a.keywords.Common.False) { 
RDebugUtils.currentLine=196610;
 //BA.debugLineNum = 196610;BA.debugLine="Msgbox(\"Please Enable Blutooth\",\"Error\")";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Please Enable Blutooth"),BA.ObjectToCharSequence("Error"),mostCurrent.activityBA);
 }else {
RDebugUtils.currentLine=196612;
 //BA.debugLineNum = 196612;BA.debugLine="Serial1.Listen'listen for incoming connections";
_serial1.Listen(processBA);
 };
RDebugUtils.currentLine=196614;
 //BA.debugLineNum = 196614;BA.debugLine="End Sub";
return "";
}
public static String  _mnuabout_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mnuabout_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mnuabout_click", null);
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub mnuAbout_Click";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Msgbox(\"Blutooth Control program WWW.NET-E.ir Had";
anywheresoftware.b4a.keywords.Common.Msgbox(BA.ObjectToCharSequence("Blutooth Control program WWW.NET-E.ir Hadi Tadayyon"),BA.ObjectToCharSequence("About"),mostCurrent.activityBA);
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="End Sub";
return "";
}
public static String  _mnuconnect_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mnuconnect_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mnuconnect_click", null);
anywheresoftware.b4a.objects.collections.Map _paireddevices = null;
anywheresoftware.b4a.objects.collections.List _l = null;
int _res = 0;
int _i = 0;
RDebugUtils.currentLine=327680;
 //BA.debugLineNum = 327680;BA.debugLine="Sub mnuConnect_Click";
RDebugUtils.currentLine=327681;
 //BA.debugLineNum = 327681;BA.debugLine="Dim PairedDevices As Map";
_paireddevices = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=327682;
 //BA.debugLineNum = 327682;BA.debugLine="PairedDevices = Serial1.GetPairedDevices";
_paireddevices = _serial1.GetPairedDevices();
RDebugUtils.currentLine=327683;
 //BA.debugLineNum = 327683;BA.debugLine="Dim l As List";
_l = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=327684;
 //BA.debugLineNum = 327684;BA.debugLine="Dim res As Int";
_res = 0;
RDebugUtils.currentLine=327685;
 //BA.debugLineNum = 327685;BA.debugLine="l.Initialize";
_l.Initialize();
RDebugUtils.currentLine=327686;
 //BA.debugLineNum = 327686;BA.debugLine="For i=0 To PairedDevices.Size -1";
{
final int step6 = 1;
final int limit6 = (int) (_paireddevices.getSize()-1);
_i = (int) (0) ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
RDebugUtils.currentLine=327687;
 //BA.debugLineNum = 327687;BA.debugLine="l.Add(PairedDevices.GetKeyAt(i))";
_l.Add(_paireddevices.GetKeyAt(_i));
 }
};
RDebugUtils.currentLine=327689;
 //BA.debugLineNum = 327689;BA.debugLine="res =InputList(l,\"Choose device\", -1) 'shoe list";
_res = anywheresoftware.b4a.keywords.Common.InputList(_l,BA.ObjectToCharSequence("Choose device"),(int) (-1),mostCurrent.activityBA);
RDebugUtils.currentLine=327690;
 //BA.debugLineNum = 327690;BA.debugLine="If res <> DialogResponse.CANCEL Then";
if (_res!=anywheresoftware.b4a.keywords.Common.DialogResponse.CANCEL) { 
RDebugUtils.currentLine=327691;
 //BA.debugLineNum = 327691;BA.debugLine="Serial1.Connect(PairedDevices.Get(l.Get(res))) '";
_serial1.Connect(processBA,BA.ObjectToString(_paireddevices.Get(_l.Get(_res))));
 };
RDebugUtils.currentLine=327693;
 //BA.debugLineNum = 327693;BA.debugLine="End Sub";
return "";
}
public static String  _mnudisconnect_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mnudisconnect_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mnudisconnect_click", null);
RDebugUtils.currentLine=393216;
 //BA.debugLineNum = 393216;BA.debugLine="Sub mnuDisconnect_Click";
RDebugUtils.currentLine=393217;
 //BA.debugLineNum = 393217;BA.debugLine="Serial1.Disconnect";
_serial1.Disconnect();
RDebugUtils.currentLine=393218;
 //BA.debugLineNum = 393218;BA.debugLine="connected = False";
_connected = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=393219;
 //BA.debugLineNum = 393219;BA.debugLine="ToastMessageShow(\"DisConneted Successfully\", Fals";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("DisConneted Successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=393220;
 //BA.debugLineNum = 393220;BA.debugLine="End Sub";
return "";
}
public static String  _mnuexit_click() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "mnuexit_click"))
	return (String) Debug.delegate(mostCurrent.activityBA, "mnuexit_click", null);
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Sub mnuExit_Click";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="ExitApplication";
anywheresoftware.b4a.keywords.Common.ExitApplication();
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
public static String  _p_actionup() throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "p_actionup"))
	return (String) Debug.delegate(mostCurrent.activityBA, "p_actionup", null);
short _i = (short)0;
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub P_ActionUp";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="Dim i As Short";
_i = (short)0;
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="If connected Then";
if (_connected) { 
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="For i=0 To 5";
{
final int step3 = 1;
final int limit3 = (short) (5);
_i = (short) (0) ;
for (;(step3 > 0 && _i <= limit3) || (step3 < 0 && _i >= limit3) ;_i = ((short)(0 + _i + step3))  ) {
RDebugUtils.currentLine=917508;
 //BA.debugLineNum = 917508;BA.debugLine="TextWiter1.Write(\"S\")'Stop";
_textwiter1.Write("S");
RDebugUtils.currentLine=917509;
 //BA.debugLineNum = 917509;BA.debugLine="TextWiter1.Flush";
_textwiter1.Flush();
 }
};
 };
RDebugUtils.currentLine=917512;
 //BA.debugLineNum = 917512;BA.debugLine="End Sub";
return "";
}
public static String  _p_down_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "p_down_touch"))
	return (String) Debug.delegate(mostCurrent.activityBA, "p_down_touch", new Object[] {_action,_x,_y});
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub P_Down_Touch (Action As Int, X As Float, Y As";
RDebugUtils.currentLine=720897;
 //BA.debugLineNum = 720897;BA.debugLine="If connected Then";
if (_connected) { 
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="TextWiter1.Write(\"D\")'Down";
_textwiter1.Write("D");
RDebugUtils.currentLine=720899;
 //BA.debugLineNum = 720899;BA.debugLine="TextWiter1.Flush";
_textwiter1.Flush();
 };
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="If Action=P_Down.ACTION_UP Then";
if (_action==mostCurrent._p_down.ACTION_UP) { 
RDebugUtils.currentLine=720902;
 //BA.debugLineNum = 720902;BA.debugLine="P_ActionUp";
_p_actionup();
 };
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="End Sub";
return "";
}
public static String  _p_left_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "p_left_touch"))
	return (String) Debug.delegate(mostCurrent.activityBA, "p_left_touch", new Object[] {_action,_x,_y});
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub p_Left_Touch (Action As Int, X As Float, Y As";
RDebugUtils.currentLine=786433;
 //BA.debugLineNum = 786433;BA.debugLine="If connected Then";
if (_connected) { 
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="TextWiter1.Write(\"L\")'Left";
_textwiter1.Write("L");
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="TextWiter1.Flush";
_textwiter1.Flush();
 };
RDebugUtils.currentLine=786437;
 //BA.debugLineNum = 786437;BA.debugLine="If Action=p_Left.ACTION_UP Then";
if (_action==mostCurrent._p_left.ACTION_UP) { 
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="P_ActionUp";
_p_actionup();
 };
RDebugUtils.currentLine=786440;
 //BA.debugLineNum = 786440;BA.debugLine="End Sub";
return "";
}
public static String  _p_right_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "p_right_touch"))
	return (String) Debug.delegate(mostCurrent.activityBA, "p_right_touch", new Object[] {_action,_x,_y});
RDebugUtils.currentLine=851968;
 //BA.debugLineNum = 851968;BA.debugLine="Sub p_Right_Touch (Action As Int, X As Float, Y As";
RDebugUtils.currentLine=851969;
 //BA.debugLineNum = 851969;BA.debugLine="If connected Then";
if (_connected) { 
RDebugUtils.currentLine=851970;
 //BA.debugLineNum = 851970;BA.debugLine="TextWiter1.Write(\"R\")'Right";
_textwiter1.Write("R");
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="TextWiter1.Flush";
_textwiter1.Flush();
 };
RDebugUtils.currentLine=851973;
 //BA.debugLineNum = 851973;BA.debugLine="If Action=p_Right.ACTION_UP Then";
if (_action==mostCurrent._p_right.ACTION_UP) { 
RDebugUtils.currentLine=851974;
 //BA.debugLineNum = 851974;BA.debugLine="P_ActionUp";
_p_actionup();
 };
RDebugUtils.currentLine=851976;
 //BA.debugLineNum = 851976;BA.debugLine="End Sub";
return "";
}
public static String  _p_up_touch(int _action,float _x,float _y) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "p_up_touch"))
	return (String) Debug.delegate(mostCurrent.activityBA, "p_up_touch", new Object[] {_action,_x,_y});
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _upred = null;
RDebugUtils.currentLine=655360;
 //BA.debugLineNum = 655360;BA.debugLine="Sub p_UP_Touch (Action As Int, X As Float, Y As Fl";
RDebugUtils.currentLine=655362;
 //BA.debugLineNum = 655362;BA.debugLine="Label1.Text=Action";
mostCurrent._label1.setText(BA.ObjectToCharSequence(_action));
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="Dim upred As Bitmap";
_upred = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="upred.Initialize(File.DirAssets,\"upred.png\")";
_upred.Initialize(anywheresoftware.b4a.keywords.Common.File.getDirAssets(),"upred.png");
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="If Action ==0 Then";
if (_action==0) { 
RDebugUtils.currentLine=655366;
 //BA.debugLineNum = 655366;BA.debugLine="p_UP.Background=upred";
mostCurrent._p_up.setBackground((android.graphics.drawable.Drawable)(_upred.getObject()));
 };
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="If connected Then";
if (_connected) { 
RDebugUtils.currentLine=655369;
 //BA.debugLineNum = 655369;BA.debugLine="TextWiter1.Write(\"U\")'UP";
_textwiter1.Write("U");
RDebugUtils.currentLine=655370;
 //BA.debugLineNum = 655370;BA.debugLine="TextWiter1.Flush";
_textwiter1.Flush();
 };
RDebugUtils.currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="If Action=p_UP.ACTION_UP Then";
if (_action==mostCurrent._p_up.ACTION_UP) { 
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="P_ActionUp";
_p_actionup();
 };
RDebugUtils.currentLine=655376;
 //BA.debugLineNum = 655376;BA.debugLine="End Sub";
return "";
}
public static String  _serial1_connected(boolean _success) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "serial1_connected"))
	return (String) Debug.delegate(mostCurrent.activityBA, "serial1_connected", new Object[] {_success});
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Sub Serial1_Connected (Success As Boolean)";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="If Success Then";
if (_success) { 
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="ToastMessageShow(\"Conneted Successfully\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Conneted Successfully"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="TextWiter1.Initialize(Serial1.OutputStream)";
_textwiter1.Initialize(_serial1.getOutputStream());
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="connected =True";
_connected = anywheresoftware.b4a.keywords.Common.True;
 }else {
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="connected = False";
_connected = anywheresoftware.b4a.keywords.Common.False;
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="ToastMessageShow(LastException.Message,\"Error Co";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA).getMessage()),BA.ObjectToBoolean("Error Connecting"));
 };
RDebugUtils.currentLine=589834;
 //BA.debugLineNum = 589834;BA.debugLine="P_ActionUp";
_p_actionup();
RDebugUtils.currentLine=589835;
 //BA.debugLineNum = 589835;BA.debugLine="End Sub";
return "";
}
public static String  _tbtn1_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tbtn1_checkedchange"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tbtn1_checkedchange", new Object[] {_checked});
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub TBtn1_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="Select Checked";
switch (BA.switchObjectToInt(_checked,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False)) {
case 0: {
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="If connected Then";
if (_connected) { 
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="TextWiter1.Write(\"1\")'Right";
_textwiter1.Write("1");
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="TextWiter1.Flush";
_textwiter1.Flush();
 };
 break; }
case 1: {
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="If connected Then";
if (_connected) { 
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="TextWiter1.Write(\"2\")'Right";
_textwiter1.Write("2");
RDebugUtils.currentLine=983050;
 //BA.debugLineNum = 983050;BA.debugLine="TextWiter1.Flush";
_textwiter1.Flush();
 };
 break; }
}
;
RDebugUtils.currentLine=983053;
 //BA.debugLineNum = 983053;BA.debugLine="End Sub";
return "";
}
public static String  _tbtn2_checkedchange(boolean _checked) throws Exception{
RDebugUtils.currentModule="main";
if (Debug.shouldDelegate(mostCurrent.activityBA, "tbtn2_checkedchange"))
	return (String) Debug.delegate(mostCurrent.activityBA, "tbtn2_checkedchange", new Object[] {_checked});
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub TBtn2_CheckedChange(Checked As Boolean)";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="Select Checked";
switch (BA.switchObjectToInt(_checked,anywheresoftware.b4a.keywords.Common.True,anywheresoftware.b4a.keywords.Common.False)) {
case 0: {
RDebugUtils.currentLine=1048579;
 //BA.debugLineNum = 1048579;BA.debugLine="If connected Then";
if (_connected) { 
RDebugUtils.currentLine=1048580;
 //BA.debugLineNum = 1048580;BA.debugLine="TextWiter1.Write(\"3\")'Right";
_textwiter1.Write("3");
RDebugUtils.currentLine=1048581;
 //BA.debugLineNum = 1048581;BA.debugLine="TextWiter1.Flush";
_textwiter1.Flush();
 };
 break; }
case 1: {
RDebugUtils.currentLine=1048584;
 //BA.debugLineNum = 1048584;BA.debugLine="If connected Then";
if (_connected) { 
RDebugUtils.currentLine=1048585;
 //BA.debugLineNum = 1048585;BA.debugLine="TextWiter1.Write(\"4\")'Right";
_textwiter1.Write("4");
RDebugUtils.currentLine=1048586;
 //BA.debugLineNum = 1048586;BA.debugLine="TextWiter1.Flush";
_textwiter1.Flush();
 };
 break; }
}
;
RDebugUtils.currentLine=1048589;
 //BA.debugLineNum = 1048589;BA.debugLine="End Sub";
return "";
}
}