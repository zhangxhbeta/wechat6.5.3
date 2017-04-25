package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.e.a;
import com.tencent.mm.plugin.e.d;
import com.tencent.mm.sdk.platformtools.v;

public abstract class b extends a {
    public Activity aXH;
    protected float euH = 0.0f;
    protected d gUC;
    protected float gpD = 0.0f;
    protected int type = 0;

    public abstract d axi();

    public b(Activity activity) {
        this.aXH = activity;
    }

    public void onCreate(Bundle bundle) {
        this.aXH.requestWindowFeature(1);
        this.aXH.setContentView(2130904164);
        this.type = this.aXH.getIntent().getIntExtra("map_view_type", 0);
        v.i("MicroMsg.MMBaseMapUI", "init oncreate type %d", new Object[]{Integer.valueOf(this.type)});
        ((FrameLayout) findViewById(2131757406)).addView(d.ce(this.aXH));
        this.gUC = axi();
        this.gUC.setMapViewOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ b gXG;

            {
                this.gXG = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                v.i("MicroMsg.MMBaseMapUI", "map action " + action);
                switch (action) {
                    case 0:
                        this.gXG.gpD = motionEvent.getX();
                        this.gXG.euH = motionEvent.getY();
                        break;
                    case 1:
                        if (Math.abs(motionEvent.getX() - this.gXG.gpD) > 10.0f || Math.abs(motionEvent.getY() - this.gXG.euH) > 10.0f) {
                            this.gXG.axj();
                            break;
                        }
                }
                return false;
            }
        });
    }

    public final View findViewById(int i) {
        return this.aXH.findViewById(i);
    }

    public final String getString(int i) {
        return this.aXH.getString(i);
    }

    public final void onBackPressed() {
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void axj() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        v.d("MicroMsg.MMBaseMapUI", "dispatchKeyEvent");
        this.aXH.finish();
        return true;
    }

    public final boolean axh() {
        return false;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroy() {
    }

    protected final void axg() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.aXH.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = this.aXH.getCurrentFocus();
            if (currentFocus != null) {
                IBinder windowToken = currentFocus.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                }
            }
        }
    }
}
