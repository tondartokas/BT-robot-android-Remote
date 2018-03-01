package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,36);
if (RapidSub.canDelegate("activity_create")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 36;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 39;BA.debugLine="If FirstTime Then";
Debug.ShouldStop(64);
if (_firsttime.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 40;BA.debugLine="Serial1.Initialize(\"serial1\")";
Debug.ShouldStop(128);
main._serial1.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("serial1")));
 };
 BA.debugLineNum = 43;BA.debugLine="Activity.LoadLayout(\"control\")";
Debug.ShouldStop(1024);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("control")),main.mostCurrent.activityBA);
 BA.debugLineNum = 44;BA.debugLine="Activity.AddMenuItem(\"Connect\",\"mnuConnect\")";
Debug.ShouldStop(2048);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToCharSequence("Connect")),(Object)(RemoteObject.createImmutable("mnuConnect")));
 BA.debugLineNum = 45;BA.debugLine="Activity.AddMenuItem(\"Disconnect\",\"mnuDisconnect\"";
Debug.ShouldStop(4096);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToCharSequence("Disconnect")),(Object)(RemoteObject.createImmutable("mnuDisconnect")));
 BA.debugLineNum = 46;BA.debugLine="Activity.AddMenuItem(\"About\",\"mnuAbout\")";
Debug.ShouldStop(8192);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToCharSequence("About")),(Object)(RemoteObject.createImmutable("mnuAbout")));
 BA.debugLineNum = 47;BA.debugLine="Activity.AddMenuItem(\"Exit\",\"mnuExit\")";
Debug.ShouldStop(16384);
main.mostCurrent._activity.runVoidMethod ("AddMenuItem",(Object)(BA.ObjectToCharSequence("Exit")),(Object)(RemoteObject.createImmutable("mnuExit")));
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,58);
if (RapidSub.canDelegate("activity_pause")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 58;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 60;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,50);
if (RapidSub.canDelegate("activity_resume")) return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");
 BA.debugLineNum = 50;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="If Serial1.IsEnabled = False Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",main._serial1.runMethod(true,"IsEnabled"),main.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 52;BA.debugLine="Msgbox(\"Please Enable Blutooth\",\"Error\")";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("Please Enable Blutooth")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("Error"))),main.mostCurrent.activityBA);
 }else {
 BA.debugLineNum = 54;BA.debugLine="Serial1.Listen'listen for incoming connections";
Debug.ShouldStop(2097152);
main._serial1.runVoidMethod ("Listen",main.processBA);
 };
 BA.debugLineNum = 56;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 24;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 27;BA.debugLine="Private p_UP As Panel";
main.mostCurrent._p_up = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private P_Down As Panel";
main.mostCurrent._p_down = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private p_Left As Panel";
main.mostCurrent._p_left = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private p_Right As Panel";
main.mostCurrent._p_right = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private Label1 As Label";
main.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _mnuabout_click() throws Exception{
try {
		Debug.PushSubsStack("mnuAbout_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,83);
if (RapidSub.canDelegate("mnuabout_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","mnuabout_click");
 BA.debugLineNum = 83;BA.debugLine="Sub mnuAbout_Click";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="Msgbox(\"Blutooth Control program WWW.NET-E.ir Had";
Debug.ShouldStop(524288);
main.mostCurrent.__c.runVoidMethodAndSync ("Msgbox",(Object)(BA.ObjectToCharSequence("Blutooth Control program WWW.NET-E.ir Hadi Tadayyon")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("About"))),main.mostCurrent.activityBA);
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mnuconnect_click() throws Exception{
try {
		Debug.PushSubsStack("mnuConnect_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,62);
if (RapidSub.canDelegate("mnuconnect_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","mnuconnect_click");
RemoteObject _paireddevices = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
RemoteObject _l = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _res = RemoteObject.createImmutable(0);
int _i = 0;
 BA.debugLineNum = 62;BA.debugLine="Sub mnuConnect_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 63;BA.debugLine="Dim PairedDevices As Map";
Debug.ShouldStop(1073741824);
_paireddevices = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("PairedDevices", _paireddevices);
 BA.debugLineNum = 64;BA.debugLine="PairedDevices = Serial1.GetPairedDevices";
Debug.ShouldStop(-2147483648);
_paireddevices = main._serial1.runMethod(false,"GetPairedDevices");Debug.locals.put("PairedDevices", _paireddevices);
 BA.debugLineNum = 65;BA.debugLine="Dim l As List";
Debug.ShouldStop(1);
_l = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("l", _l);
 BA.debugLineNum = 66;BA.debugLine="Dim res As Int";
Debug.ShouldStop(2);
_res = RemoteObject.createImmutable(0);Debug.locals.put("res", _res);
 BA.debugLineNum = 67;BA.debugLine="l.Initialize";
Debug.ShouldStop(4);
_l.runVoidMethod ("Initialize");
 BA.debugLineNum = 68;BA.debugLine="For i=0 To PairedDevices.Size -1";
Debug.ShouldStop(8);
{
final int step6 = 1;
final int limit6 = RemoteObject.solve(new RemoteObject[] {_paireddevices.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step6 > 0 && _i <= limit6) || (step6 < 0 && _i >= limit6) ;_i = ((int)(0 + _i + step6))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 69;BA.debugLine="l.Add(PairedDevices.GetKeyAt(i))";
Debug.ShouldStop(16);
_l.runVoidMethod ("Add",(Object)(_paireddevices.runMethod(false,"GetKeyAt",(Object)(BA.numberCast(int.class, _i)))));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 71;BA.debugLine="res =InputList(l,\"Choose device\", -1) 'shoe list";
Debug.ShouldStop(64);
_res = main.mostCurrent.__c.runMethodAndSync(true,"InputList",(Object)(_l),(Object)(BA.ObjectToCharSequence("Choose device")),(Object)(BA.numberCast(int.class, -(double) (0 + 1))),main.mostCurrent.activityBA);Debug.locals.put("res", _res);
 BA.debugLineNum = 72;BA.debugLine="If res <> DialogResponse.CANCEL Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("!",_res,BA.numberCast(double.class, main.mostCurrent.__c.getField(false,"DialogResponse").getField(true,"CANCEL")))) { 
 BA.debugLineNum = 73;BA.debugLine="Serial1.Connect(PairedDevices.Get(l.Get(res))) '";
Debug.ShouldStop(256);
main._serial1.runVoidMethod ("Connect",main.processBA,(Object)(BA.ObjectToString(_paireddevices.runMethod(false,"Get",(Object)(_l.runMethod(false,"Get",(Object)(_res)))))));
 };
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mnudisconnect_click() throws Exception{
try {
		Debug.PushSubsStack("mnuDisconnect_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,77);
if (RapidSub.canDelegate("mnudisconnect_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","mnudisconnect_click");
 BA.debugLineNum = 77;BA.debugLine="Sub mnuDisconnect_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="Serial1.Disconnect";
Debug.ShouldStop(8192);
main._serial1.runVoidMethod ("Disconnect");
 BA.debugLineNum = 79;BA.debugLine="connected = False";
Debug.ShouldStop(16384);
main._connected = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 80;BA.debugLine="ToastMessageShow(\"DisConneted Successfully\", Fals";
Debug.ShouldStop(32768);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("DisConneted Successfully")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _mnuexit_click() throws Exception{
try {
		Debug.PushSubsStack("mnuExit_Click (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,87);
if (RapidSub.canDelegate("mnuexit_click")) return b4a.example.main.remoteMe.runUserSub(false, "main","mnuexit_click");
 BA.debugLineNum = 87;BA.debugLine="Sub mnuExit_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="ExitApplication";
Debug.ShouldStop(8388608);
main.mostCurrent.__c.runVoidMethod ("ExitApplication");
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _p_actionup() throws Exception{
try {
		Debug.PushSubsStack("P_ActionUp (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,163);
if (RapidSub.canDelegate("p_actionup")) return b4a.example.main.remoteMe.runUserSub(false, "main","p_actionup");
RemoteObject _i = RemoteObject.createImmutable((short)0);
 BA.debugLineNum = 163;BA.debugLine="Sub P_ActionUp";
Debug.ShouldStop(4);
 BA.debugLineNum = 164;BA.debugLine="Dim i As Short";
Debug.ShouldStop(8);
_i = RemoteObject.createImmutable((short)0);Debug.locals.put("i", _i);
 BA.debugLineNum = 165;BA.debugLine="If connected Then";
Debug.ShouldStop(16);
if (main._connected.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 166;BA.debugLine="For i=0 To 5";
Debug.ShouldStop(32);
{
final int step3 = 1;
final int limit3 = (short) (0 + 5);
_i = BA.numberCast(short.class, 0) ;
for (;(step3 > 0 && _i.<Short>get().shortValue() <= limit3) || (step3 < 0 && _i.<Short>get().shortValue() >= limit3) ;_i = RemoteObject.createImmutable((short)(0 + _i.<Short>get().shortValue() + step3))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 167;BA.debugLine="TextWiter1.Write(\"S\")'Stop";
Debug.ShouldStop(64);
main._textwiter1.runVoidMethod ("Write",(Object)(RemoteObject.createImmutable("S")));
 BA.debugLineNum = 168;BA.debugLine="TextWiter1.Flush";
Debug.ShouldStop(128);
main._textwiter1.runVoidMethod ("Flush");
 }
}Debug.locals.put("i", _i);
;
 };
 BA.debugLineNum = 171;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _p_down_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("P_Down_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,133);
if (RapidSub.canDelegate("p_down_touch")) return b4a.example.main.remoteMe.runUserSub(false, "main","p_down_touch", _action, _x, _y);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 133;BA.debugLine="Sub P_Down_Touch (Action As Int, X As Float, Y As";
Debug.ShouldStop(16);
 BA.debugLineNum = 134;BA.debugLine="If connected Then";
Debug.ShouldStop(32);
if (main._connected.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 135;BA.debugLine="TextWiter1.Write(\"D\")'Down";
Debug.ShouldStop(64);
main._textwiter1.runVoidMethod ("Write",(Object)(RemoteObject.createImmutable("D")));
 BA.debugLineNum = 136;BA.debugLine="TextWiter1.Flush";
Debug.ShouldStop(128);
main._textwiter1.runVoidMethod ("Flush");
 };
 BA.debugLineNum = 138;BA.debugLine="If Action=P_Down.ACTION_UP Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, main.mostCurrent._p_down.getField(true,"ACTION_UP")))) { 
 BA.debugLineNum = 139;BA.debugLine="P_ActionUp";
Debug.ShouldStop(1024);
_p_actionup();
 };
 BA.debugLineNum = 141;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _p_left_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("p_Left_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,143);
if (RapidSub.canDelegate("p_left_touch")) return b4a.example.main.remoteMe.runUserSub(false, "main","p_left_touch", _action, _x, _y);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 143;BA.debugLine="Sub p_Left_Touch (Action As Int, X As Float, Y As";
Debug.ShouldStop(16384);
 BA.debugLineNum = 144;BA.debugLine="If connected Then";
Debug.ShouldStop(32768);
if (main._connected.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 145;BA.debugLine="TextWiter1.Write(\"L\")'Left";
Debug.ShouldStop(65536);
main._textwiter1.runVoidMethod ("Write",(Object)(RemoteObject.createImmutable("L")));
 BA.debugLineNum = 146;BA.debugLine="TextWiter1.Flush";
Debug.ShouldStop(131072);
main._textwiter1.runVoidMethod ("Flush");
 };
 BA.debugLineNum = 148;BA.debugLine="If Action=p_Left.ACTION_UP Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, main.mostCurrent._p_left.getField(true,"ACTION_UP")))) { 
 BA.debugLineNum = 149;BA.debugLine="P_ActionUp";
Debug.ShouldStop(1048576);
_p_actionup();
 };
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _p_right_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("p_Right_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,153);
if (RapidSub.canDelegate("p_right_touch")) return b4a.example.main.remoteMe.runUserSub(false, "main","p_right_touch", _action, _x, _y);
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 153;BA.debugLine="Sub p_Right_Touch (Action As Int, X As Float, Y As";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 154;BA.debugLine="If connected Then";
Debug.ShouldStop(33554432);
if (main._connected.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 155;BA.debugLine="TextWiter1.Write(\"R\")'Right";
Debug.ShouldStop(67108864);
main._textwiter1.runVoidMethod ("Write",(Object)(RemoteObject.createImmutable("R")));
 BA.debugLineNum = 156;BA.debugLine="TextWiter1.Flush";
Debug.ShouldStop(134217728);
main._textwiter1.runVoidMethod ("Flush");
 };
 BA.debugLineNum = 158;BA.debugLine="If Action=p_Right.ACTION_UP Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, main.mostCurrent._p_right.getField(true,"ACTION_UP")))) { 
 BA.debugLineNum = 159;BA.debugLine="P_ActionUp";
Debug.ShouldStop(1073741824);
_p_actionup();
 };
 BA.debugLineNum = 161;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _p_up_touch(RemoteObject _action,RemoteObject _x,RemoteObject _y) throws Exception{
try {
		Debug.PushSubsStack("p_UP_Touch (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,115);
if (RapidSub.canDelegate("p_up_touch")) return b4a.example.main.remoteMe.runUserSub(false, "main","p_up_touch", _action, _x, _y);
RemoteObject _upred = RemoteObject.declareNull("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");
Debug.locals.put("Action", _action);
Debug.locals.put("X", _x);
Debug.locals.put("Y", _y);
 BA.debugLineNum = 115;BA.debugLine="Sub p_UP_Touch (Action As Int, X As Float, Y As Fl";
Debug.ShouldStop(262144);
 BA.debugLineNum = 117;BA.debugLine="Label1.Text=Action";
Debug.ShouldStop(1048576);
main.mostCurrent._label1.runMethod(true,"setText",BA.ObjectToCharSequence(_action));
 BA.debugLineNum = 118;BA.debugLine="Dim upred As Bitmap";
Debug.ShouldStop(2097152);
_upred = RemoteObject.createNew ("anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper");Debug.locals.put("upred", _upred);
 BA.debugLineNum = 119;BA.debugLine="upred.Initialize(File.DirAssets,\"upred.png\")";
Debug.ShouldStop(4194304);
_upred.runVoidMethod ("Initialize",(Object)(main.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirAssets")),(Object)(RemoteObject.createImmutable("upred.png")));
 BA.debugLineNum = 120;BA.debugLine="If Action ==0 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 121;BA.debugLine="p_UP.Background=upred";
Debug.ShouldStop(16777216);
main.mostCurrent._p_up.runMethod(false,"setBackground",(_upred.getObject()));
 };
 BA.debugLineNum = 123;BA.debugLine="If connected Then";
Debug.ShouldStop(67108864);
if (main._connected.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 124;BA.debugLine="TextWiter1.Write(\"U\")'UP";
Debug.ShouldStop(134217728);
main._textwiter1.runVoidMethod ("Write",(Object)(RemoteObject.createImmutable("U")));
 BA.debugLineNum = 125;BA.debugLine="TextWiter1.Flush";
Debug.ShouldStop(268435456);
main._textwiter1.runVoidMethod ("Flush");
 };
 BA.debugLineNum = 128;BA.debugLine="If Action=p_UP.ACTION_UP Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_action,BA.numberCast(double.class, main.mostCurrent._p_up.getField(true,"ACTION_UP")))) { 
 BA.debugLineNum = 129;BA.debugLine="P_ActionUp";
Debug.ShouldStop(1);
_p_actionup();
 };
 BA.debugLineNum = 131;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim Serial1 As Serial";
main._serial1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.Serial");
 //BA.debugLineNum = 20;BA.debugLine="Dim connected As Boolean";
main._connected = RemoteObject.createImmutable(false);
 //BA.debugLineNum = 21;BA.debugLine="Dim TextWiter1 As TextWriter";
main._textwiter1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.streams.File.TextWriterWrapper");
 //BA.debugLineNum = 22;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _serial1_connected(RemoteObject _success) throws Exception{
try {
		Debug.PushSubsStack("Serial1_Connected (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,92);
if (RapidSub.canDelegate("serial1_connected")) return b4a.example.main.remoteMe.runUserSub(false, "main","serial1_connected", _success);
Debug.locals.put("Success", _success);
 BA.debugLineNum = 92;BA.debugLine="Sub Serial1_Connected (Success As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 93;BA.debugLine="If Success Then";
Debug.ShouldStop(268435456);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 94;BA.debugLine="ToastMessageShow(\"Conneted Successfully\", False)";
Debug.ShouldStop(536870912);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Conneted Successfully")),(Object)(main.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 95;BA.debugLine="TextWiter1.Initialize(Serial1.OutputStream)";
Debug.ShouldStop(1073741824);
main._textwiter1.runVoidMethod ("Initialize",(Object)(main._serial1.runMethod(false,"getOutputStream")));
 BA.debugLineNum = 96;BA.debugLine="connected =True";
Debug.ShouldStop(-2147483648);
main._connected = main.mostCurrent.__c.getField(true,"True");
 }else {
 BA.debugLineNum = 98;BA.debugLine="connected = False";
Debug.ShouldStop(2);
main._connected = main.mostCurrent.__c.getField(true,"False");
 BA.debugLineNum = 99;BA.debugLine="ToastMessageShow(LastException.Message,\"Error Co";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(main.mostCurrent.__c.runMethod(false,"LastException",main.mostCurrent.activityBA).runMethod(true,"getMessage"))),(Object)(BA.ObjectToBoolean(RemoteObject.createImmutable("Error Connecting"))));
 };
 BA.debugLineNum = 102;BA.debugLine="P_ActionUp";
Debug.ShouldStop(32);
_p_actionup();
 BA.debugLineNum = 103;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tbtn1_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("TBtn1_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,173);
if (RapidSub.canDelegate("tbtn1_checkedchange")) return b4a.example.main.remoteMe.runUserSub(false, "main","tbtn1_checkedchange", _checked);
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 173;BA.debugLine="Sub TBtn1_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 174;BA.debugLine="Select Checked";
Debug.ShouldStop(8192);
switch (BA.switchObjectToInt(_checked,main.mostCurrent.__c.getField(true,"True"),main.mostCurrent.__c.getField(true,"False"))) {
case 0: {
 BA.debugLineNum = 176;BA.debugLine="If connected Then";
Debug.ShouldStop(32768);
if (main._connected.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 177;BA.debugLine="TextWiter1.Write(\"1\")'Right";
Debug.ShouldStop(65536);
main._textwiter1.runVoidMethod ("Write",(Object)(RemoteObject.createImmutable("1")));
 BA.debugLineNum = 178;BA.debugLine="TextWiter1.Flush";
Debug.ShouldStop(131072);
main._textwiter1.runVoidMethod ("Flush");
 };
 break; }
case 1: {
 BA.debugLineNum = 181;BA.debugLine="If connected Then";
Debug.ShouldStop(1048576);
if (main._connected.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 182;BA.debugLine="TextWiter1.Write(\"2\")'Right";
Debug.ShouldStop(2097152);
main._textwiter1.runVoidMethod ("Write",(Object)(RemoteObject.createImmutable("2")));
 BA.debugLineNum = 183;BA.debugLine="TextWiter1.Flush";
Debug.ShouldStop(4194304);
main._textwiter1.runVoidMethod ("Flush");
 };
 break; }
}
;
 BA.debugLineNum = 186;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _tbtn2_checkedchange(RemoteObject _checked) throws Exception{
try {
		Debug.PushSubsStack("TBtn2_CheckedChange (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,188);
if (RapidSub.canDelegate("tbtn2_checkedchange")) return b4a.example.main.remoteMe.runUserSub(false, "main","tbtn2_checkedchange", _checked);
Debug.locals.put("Checked", _checked);
 BA.debugLineNum = 188;BA.debugLine="Sub TBtn2_CheckedChange(Checked As Boolean)";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 189;BA.debugLine="Select Checked";
Debug.ShouldStop(268435456);
switch (BA.switchObjectToInt(_checked,main.mostCurrent.__c.getField(true,"True"),main.mostCurrent.__c.getField(true,"False"))) {
case 0: {
 BA.debugLineNum = 191;BA.debugLine="If connected Then";
Debug.ShouldStop(1073741824);
if (main._connected.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 192;BA.debugLine="TextWiter1.Write(\"3\")'Right";
Debug.ShouldStop(-2147483648);
main._textwiter1.runVoidMethod ("Write",(Object)(RemoteObject.createImmutable("3")));
 BA.debugLineNum = 193;BA.debugLine="TextWiter1.Flush";
Debug.ShouldStop(1);
main._textwiter1.runVoidMethod ("Flush");
 };
 break; }
case 1: {
 BA.debugLineNum = 196;BA.debugLine="If connected Then";
Debug.ShouldStop(8);
if (main._connected.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 197;BA.debugLine="TextWiter1.Write(\"4\")'Right";
Debug.ShouldStop(16);
main._textwiter1.runVoidMethod ("Write",(Object)(RemoteObject.createImmutable("4")));
 BA.debugLineNum = 198;BA.debugLine="TextWiter1.Flush";
Debug.ShouldStop(32);
main._textwiter1.runVoidMethod ("Flush");
 };
 break; }
}
;
 BA.debugLineNum = 201;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}