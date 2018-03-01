package b4a.example.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_control{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[control/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="p_UP.SetLeftAndRight(5%x,20%x)"[control/General script]
views.get("p_up").vw.setLeft((int)((5d / 100 * width)));
views.get("p_up").vw.setWidth((int)((20d / 100 * width) - ((5d / 100 * width))));
//BA.debugLineNum = 4;BA.debugLine="p_UP.SetTopAndBottom(5%y,49%y)"[control/General script]
views.get("p_up").vw.setTop((int)((5d / 100 * height)));
views.get("p_up").vw.setHeight((int)((49d / 100 * height) - ((5d / 100 * height))));
//BA.debugLineNum = 6;BA.debugLine="P_Down.SetLeftAndRight(5%x,20%x)"[control/General script]
views.get("p_down").vw.setLeft((int)((5d / 100 * width)));
views.get("p_down").vw.setWidth((int)((20d / 100 * width) - ((5d / 100 * width))));
//BA.debugLineNum = 7;BA.debugLine="P_Down.SetTopAndBottom(51%y,95%y)"[control/General script]
views.get("p_down").vw.setTop((int)((51d / 100 * height)));
views.get("p_down").vw.setHeight((int)((95d / 100 * height) - ((51d / 100 * height))));
//BA.debugLineNum = 9;BA.debugLine="p_Left.SetLeftAndRight(55%x,74%x)"[control/General script]
views.get("p_left").vw.setLeft((int)((55d / 100 * width)));
views.get("p_left").vw.setWidth((int)((74d / 100 * width) - ((55d / 100 * width))));
//BA.debugLineNum = 10;BA.debugLine="p_Left.SetTopAndBottom(35%y,65%y)"[control/General script]
views.get("p_left").vw.setTop((int)((35d / 100 * height)));
views.get("p_left").vw.setHeight((int)((65d / 100 * height) - ((35d / 100 * height))));
//BA.debugLineNum = 12;BA.debugLine="p_Right.SetLeftAndRight(76%x,95%x)"[control/General script]
views.get("p_right").vw.setLeft((int)((76d / 100 * width)));
views.get("p_right").vw.setWidth((int)((95d / 100 * width) - ((76d / 100 * width))));
//BA.debugLineNum = 13;BA.debugLine="p_Right.SetTopAndBottom(35%y,65%y)"[control/General script]
views.get("p_right").vw.setTop((int)((35d / 100 * height)));
views.get("p_right").vw.setHeight((int)((65d / 100 * height) - ((35d / 100 * height))));
//BA.debugLineNum = 15;BA.debugLine="TBtn1.SetLeftAndRight(88%x,95%x)"[control/General script]
views.get("tbtn1").vw.setLeft((int)((88d / 100 * width)));
views.get("tbtn1").vw.setWidth((int)((95d / 100 * width) - ((88d / 100 * width))));
//BA.debugLineNum = 16;BA.debugLine="TBtn1.SetTopAndBottom(5%y,20%y)"[control/General script]
views.get("tbtn1").vw.setTop((int)((5d / 100 * height)));
views.get("tbtn1").vw.setHeight((int)((20d / 100 * height) - ((5d / 100 * height))));
//BA.debugLineNum = 18;BA.debugLine="TBtn2.SetLeftAndRight(78%x,85%x)"[control/General script]
views.get("tbtn2").vw.setLeft((int)((78d / 100 * width)));
views.get("tbtn2").vw.setWidth((int)((85d / 100 * width) - ((78d / 100 * width))));
//BA.debugLineNum = 19;BA.debugLine="TBtn2.SetTopAndBottom(5%y,20%y)"[control/General script]
views.get("tbtn2").vw.setTop((int)((5d / 100 * height)));
views.get("tbtn2").vw.setHeight((int)((20d / 100 * height) - ((5d / 100 * height))));

}
}