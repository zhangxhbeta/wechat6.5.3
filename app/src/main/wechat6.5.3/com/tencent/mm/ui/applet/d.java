package com.tencent.mm.ui.applet;

import android.content.Context;
import android.os.Message;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.bh.c;
import com.tencent.mm.bh.c.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

public final class d {
    private static int nQd = 0;

    public static final class a {
        FrameLayout aQI;
        WindowManager aQJ;
        LayoutParams aQK;
        private ViewGroup.LayoutParams aQL;
        ImageView bgv;
        ProgressBar bgx;
        Context context;
        TextView grr;
        View mView;
        boolean nQe = false;
        b nQf = new b(this) {
            final /* synthetic */ a nQj;

            {
                this.nQj = r1;
            }

            public final void byr() {
                this.nQj.eu(this.nQj.context);
                Toast.makeText(this.nQj.context, "trace file has saved ", 0).show();
            }
        };
        com.tencent.mm.bh.c.a nQg;
        int nQh = 0;
        ac nQi = new ac(this) {
            final /* synthetic */ a nQj;

            {
                this.nQj = r1;
            }

            public final void handleMessage(Message message) {
                if (this.nQj.grr.getVisibility() != 0) {
                    this.nQj.nQh = 0;
                    return;
                }
                a aVar = this.nQj;
                aVar.nQh++;
                this.nQj.bBC();
                super.handleMessage(message);
            }
        };

        public a(Context context, View view) {
            if (this.aQI == null || this.aQJ == null) {
                c.byp().nzb = new WeakReference(this.nQf);
                this.grr = (TextView) view.findViewById(2131756099);
                this.bgv = (ImageView) view.findViewById(2131755282);
                ((ImageView) view.findViewById(2131759576)).setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a nQj;

                    {
                        this.nQj = r1;
                    }

                    public final void onClick(View view) {
                        if (this.nQj.nQe && this.nQj.bgx.getVisibility() != 0) {
                            c.byp().b(this.nQj.nQg);
                        }
                        a aVar = this.nQj;
                        try {
                            if (aVar.aQJ != null) {
                                if (aVar.aQI != null) {
                                    aVar.aQJ.removeView(aVar.aQI);
                                }
                                aVar.aQJ = null;
                            }
                            if (aVar.aQI != null) {
                                aVar.aQI.removeAllViews();
                                aVar.aQI = null;
                            }
                            aVar.mView = null;
                        } catch (Exception e) {
                        }
                        d.bBB();
                    }
                });
                this.bgx = (ProgressBar) view.findViewById(2131759575);
                this.bgx.setVisibility(8);
                this.context = context;
                this.aQK = new LayoutParams();
                this.aQK.height = -2;
                this.aQK.width = -2;
                this.aQJ = (WindowManager) context.getSystemService("window");
                this.aQK.x = 0;
                this.aQK.y = 0;
                this.aQK.flags = 40;
                this.aQK.type = MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK;
                this.mView = view;
                this.grr.setVisibility(8);
                this.aQK.gravity = 51;
                this.aQK.format = 1;
                this.aQI = new FrameLayout(context);
                this.aQI.setPadding(4, 4, 4, 4);
                this.aQL = new ViewGroup.LayoutParams(-2, -2);
                this.aQI.addView(this.mView, this.aQL);
                final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                this.aQI.setOnTouchListener(new OnTouchListener(this) {
                    int nPP;
                    int nPQ;
                    int nPR = ((displayMetrics.widthPixels - this.nQj.aQK.width) - 1);
                    int nPS = ((displayMetrics.heightPixels - this.nQj.aQK.height) - 1);
                    long nPT;
                    final /* synthetic */ a nQj;

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        switch (motionEvent.getAction()) {
                            case 0:
                                this.nPP = ((int) motionEvent.getRawX()) - this.nQj.aQK.x;
                                this.nPQ = ((int) motionEvent.getRawY()) - this.nQj.aQK.y;
                                this.nPT = System.currentTimeMillis();
                                break;
                            case 1:
                                if (System.currentTimeMillis() - this.nPT < 300) {
                                    a aVar = this.nQj;
                                    aVar.nQi.removeMessages(0);
                                    aVar.nQh = 0;
                                    if (!aVar.nQe) {
                                        aVar.bgv.setVisibility(0);
                                        aVar.bgv.setBackgroundDrawable(aVar.context.getResources().getDrawable(2130839347));
                                        aVar.nQe = !aVar.nQe;
                                        aVar.nQg = new com.tencent.mm.bh.c.a(null, 6, 8, 0);
                                        c.byp().c(aVar.nQg);
                                        aVar.bBC();
                                        break;
                                    }
                                    aVar.bgx.setVisibility(0);
                                    aVar.bgv.setVisibility(4);
                                    if (!c.byp().b(aVar.nQg)) {
                                        aVar.eu(aVar.context);
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                this.nPR = (displayMetrics.widthPixels - this.nQj.aQK.width) - 1;
                                this.nPS = (displayMetrics.heightPixels - this.nQj.aQK.height) - 1;
                                this.nQj.aQK.x = ((int) motionEvent.getRawX()) - this.nPP;
                                this.nQj.aQK.y = ((int) motionEvent.getRawY()) - this.nPQ;
                                this.nQj.aQK.x = this.nQj.aQK.x < 0 ? 0 : this.nQj.aQK.x;
                                this.nQj.aQK.x = this.nQj.aQK.x > this.nPR ? this.nPR : this.nQj.aQK.x;
                                this.nQj.aQK.y = this.nQj.aQK.y < 0 ? 0 : this.nQj.aQK.y;
                                this.nQj.aQK.y = this.nQj.aQK.y > this.nPS ? this.nPS : this.nQj.aQK.y;
                                this.nQj.aQJ.updateViewLayout(this.nQj.aQI, this.nQj.aQK);
                                break;
                        }
                        return false;
                    }
                });
            }
        }

        final void eu(Context context) {
            boolean z = false;
            this.bgv.setVisibility(0);
            this.bgx.setVisibility(4);
            if (!this.nQe) {
                z = true;
            }
            this.nQe = z;
            this.bgv.setBackgroundDrawable(context.getResources().getDrawable(2130839346));
            this.grr.setVisibility(8);
        }

        final void bBC() {
            this.grr.setText(this.nQh);
            this.nQi.sendEmptyMessageDelayed(0, 1000);
        }
    }

    static /* synthetic */ int bBB() {
        int i = nQd;
        nQd = i - 1;
        return i;
    }

    public static void et(Context context) {
        if (nQd <= 0) {
            a aVar = new a(context, LayoutInflater.from(context).inflate(2130904550, null));
            aVar.aQJ.addView(aVar.aQI, aVar.aQK);
            nQd++;
        }
    }
}
