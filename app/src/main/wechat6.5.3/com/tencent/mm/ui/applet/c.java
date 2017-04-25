package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;

public final class c {

    public static final class a {
        FrameLayout aQI;
        WindowManager aQJ;
        LayoutParams aQK;
        private ViewGroup.LayoutParams aQL;
        private ImageView bgv;
        private View mView;

        public a(Context context, View view) {
            if (this.aQI == null || this.aQJ == null) {
                view.findViewById(2131759575).setVisibility(8);
                this.bgv = (ImageView) view.findViewById(2131755282);
                ((ImageView) view.findViewById(2131759576)).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a nPO;

                    {
                        this.nPO = r1;
                    }

                    public final void onClick(View view) {
                        this.nPO.on();
                    }
                });
                this.aQK = new LayoutParams();
                this.aQK.height = -2;
                this.aQK.width = -2;
                this.aQJ = (WindowManager) context.getSystemService("window");
                this.aQK.x = 0;
                this.aQK.y = 0;
                this.aQK.flags = 40;
                this.aQK.type = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
                this.mView = view;
                this.aQK.gravity = 51;
                this.aQK.format = 1;
                this.aQI = new FrameLayout(context);
                this.aQI.setPadding(4, 4, 4, 4);
                this.aQL = new ViewGroup.LayoutParams(-2, -2);
                this.aQI.addView(this.mView, this.aQL);
                final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                this.aQI.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ a nPO;
                    int nPP;
                    int nPQ;
                    int nPR = ((displayMetrics.widthPixels - this.nPO.aQK.width) - 1);
                    int nPS = ((displayMetrics.heightPixels - this.nPO.aQK.height) - 1);
                    long nPT;

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case 0:
                                this.nPP = ((int) motionEvent.getRawX()) - this.nPO.aQK.x;
                                this.nPQ = ((int) motionEvent.getRawY()) - this.nPO.aQK.y;
                                this.nPT = System.currentTimeMillis();
                                break;
                            case 1:
                                if (System.currentTimeMillis() - this.nPT < 300) {
                                    com.tencent.mm.bh.a.byn();
                                    com.tencent.mm.bh.a.E(false, true);
                                    this.nPO.on();
                                    break;
                                }
                                break;
                            case 2:
                                this.nPR = (displayMetrics.widthPixels - this.nPO.aQK.width) - 1;
                                this.nPS = (displayMetrics.heightPixels - this.nPO.aQK.height) - 1;
                                this.nPO.aQK.x = ((int) motionEvent.getRawX()) - this.nPP;
                                this.nPO.aQK.y = ((int) motionEvent.getRawY()) - this.nPQ;
                                this.nPO.aQK.x = this.nPO.aQK.x < 0 ? 0 : this.nPO.aQK.x;
                                this.nPO.aQK.x = this.nPO.aQK.x > this.nPR ? this.nPR : this.nPO.aQK.x;
                                this.nPO.aQK.y = this.nPO.aQK.y < 0 ? 0 : this.nPO.aQK.y;
                                this.nPO.aQK.y = this.nPO.aQK.y > this.nPS ? this.nPS : this.nPO.aQK.y;
                                this.nPO.aQJ.updateViewLayout(this.nPO.aQI, this.nPO.aQK);
                                break;
                        }
                        return false;
                    }
                });
            }
        }

        public final void on() {
            try {
                if (this.aQJ != null) {
                    if (this.aQI != null) {
                        this.aQJ.removeView(this.aQI);
                    }
                    this.aQJ = null;
                }
                if (this.aQI != null) {
                    this.aQI.removeAllViews();
                    this.aQI = null;
                }
                this.mView = null;
            } catch (Exception e) {
            }
        }
    }

    public static void es(Context context) {
        a aVar = new a(context, LayoutInflater.from(context).inflate(2130904550, null));
        aVar.aQJ.addView(aVar.aQI, aVar.aQK);
    }
}
