package com.tencent.mm.ui.g;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public final class a {
    private static b oPG;
    private static b oPH;

    @TargetApi(11)
    public static void b(Activity activity, View view) {
        View decorView = activity.getWindow().getDecorView();
        oPG = b.eJ(activity);
        oPH = b.eJ(activity);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        int height = ((AppCompatActivity) activity).cU().cV().getHeight();
        oPG.setHeight((iArr[1] - i) - height);
        int[] iArr2 = new int[2];
        if (activity instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr2[0] = displayMetrics.widthPixels;
            iArr2[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            iArr2[0] = defaultDisplay.getWidth();
            iArr2[1] = defaultDisplay.getHeight();
        }
        oPH.setHeight((iArr2[1] - iArr[1]) - view.getHeight());
        oPG.showAtLocation(decorView, 48, 0, i + height);
        oPH.showAtLocation(decorView, 80, 0, 0);
    }

    public static void dismiss() {
        if (oPG != null) {
            oPG.setAnimationStyle(-1);
            oPG.dismiss();
            oPG = null;
        }
        if (oPH != null) {
            oPH.setAnimationStyle(-1);
            oPH.dismiss();
            oPH = null;
        }
    }
}
