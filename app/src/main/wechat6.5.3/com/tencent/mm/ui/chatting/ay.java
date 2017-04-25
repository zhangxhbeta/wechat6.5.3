package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.h.c;
import com.tencent.mm.h.j;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.o;
import com.tencent.mmdb.database.SQLiteDebug;
import com.tencent.smtt.sdk.WebView;

public final class ay {
    public static b ooe = new b();

    public static class a implements OnTouchListener {
        private int sc;

        public a() {
            this(Color.argb(WebView.NORMAL_MODE_ALPHA, 136, 136, 136));
        }

        private a(int i) {
            this.sc = i;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Drawable drawable;
            int action = motionEvent.getAction();
            if (view instanceof ImageView) {
                drawable = ((ImageView) view).getDrawable();
            } else {
                drawable = view.getBackground();
            }
            if (drawable != null) {
                if (action == 0) {
                    drawable.setColorFilter(this.sc, Mode.MULTIPLY);
                } else if (action == 3 || action == 1) {
                    drawable.clearColorFilter();
                }
            }
            return false;
        }
    }

    public static class b implements OnClickListener, OnTouchListener, com.tencent.mm.ui.chatting.ds.b {
        private View Hq;
        private int dQw;
        private ah dwn;
        private o oof;
        private View oog;
        private View ooh;
        private int ooi;
        private int ooj;
        private int ook;
        private int ool;
        private int oom;
        private boolean oon;
        private a ooo = new a();
        private OnTouchListener oop = new OnTouchListener(this) {
            final /* synthetic */ b oot;

            {
                this.oot = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.oot.ooo != null) {
                    this.oot.ooo.onTouch(this.oot.Hq, motionEvent);
                }
                return false;
            }
        };
        private View ooq;
        private int oor = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
        private com.tencent.mm.sdk.platformtools.ah.a oos = new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ b oot;

            {
                this.oot = r1;
            }

            public final boolean oU() {
                if (!(this.oot.ooq == null || this.oot.oof == null)) {
                    this.oot.oof.showAsDropDown(this.oot.ooq, this.oot.ook, this.oot.ool);
                }
                return false;
            }
        };

        private void dismiss() {
            if (this.oof != null) {
                this.oof.dismiss();
            }
        }

        public final boolean d(View view, MotionEvent motionEvent) {
            int i = 8;
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof dl)) {
                v.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
                return false;
            }
            boolean z;
            dl dlVar = (dl) view.getTag();
            String str = dlVar.userName;
            String xF = k.xF();
            if (t.kS(xF) || xF.equals(str)) {
                v.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
            Context context = view.getContext();
            if (this.oof == null) {
                Resources resources = context.getResources();
                this.ooi = (int) ((resources.getDimension(2131492962) * 2.0f) + resources.getDimension(2131493157));
                this.Hq = View.inflate(context, 2130903295, null);
                this.oog = this.Hq.findViewById(2131756094);
                this.ooh = this.Hq.findViewById(2131756095);
                this.ooh.setOnClickListener(this);
                this.oog.setOnClickListener(this);
                this.ooh.setOnTouchListener(this.oop);
                this.oog.setOnTouchListener(this.oop);
                this.oof = new o(this.Hq, -2, this.ooi, false);
                this.oof.setOutsideTouchable(true);
                Rect rect = new Rect();
                if (context instanceof Activity) {
                    ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                }
                this.dQw = rect.top;
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    this.ooj = context.getResources().getDimensionPixelSize(2131493014);
                } else {
                    this.ooj = context.getResources().getDimensionPixelSize(2131493015);
                }
                this.oof.setBackgroundDrawable(new ColorDrawable(16777215));
                this.oom = 0;
                this.dwn = new ah(Looper.getMainLooper(), this.oos, false);
                v.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
            }
            o oVar = this.oof;
            switch (motionEvent.getAction()) {
                case 9:
                    this.ooq = view;
                    view.setOnTouchListener(this);
                    if (oVar.isShowing()) {
                        oVar.dismiss();
                    }
                    if (!this.oon) {
                        this.ooh.setTag(dlVar);
                        this.oog.setTag(dlVar);
                        boolean z2 = (k.xQ() & 1048576) == 0;
                        j.sV();
                        boolean brh = c.sN() != 2 ? com.tencent.mm.ay.c.brh() : (k.xQ() & 4194304) == 0;
                        if (brh || z2) {
                            int i2;
                            View view2 = this.ooh;
                            if (brh) {
                                i2 = 0;
                            } else {
                                i2 = 8;
                            }
                            view2.setVisibility(i2);
                            View view3 = this.oog;
                            if (z2 && !brh) {
                                i = 0;
                            }
                            view3.setVisibility(i);
                            int[] iArr = new int[2];
                            view.getLocationInWindow(iArr);
                            int i3 = iArr[1];
                            view.getWidth();
                            i2 = view.getHeight();
                            this.ool = this.oom;
                            if (i3 > (this.dQw + this.ooj) + this.ooi) {
                                this.ool = ((-i2) - this.ooi) - this.oom;
                            }
                            this.ook = 0;
                            if (this.ool >= 0) {
                                this.Hq.setBackgroundResource(2130837989);
                            } else {
                                this.Hq.setBackgroundResource(2130837990);
                            }
                            this.dwn.ea((long) this.oor);
                            break;
                        }
                        return false;
                    }
                    break;
                case 10:
                    this.oon = false;
                    this.ooq = null;
                    break;
            }
            return true;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 1:
                    this.oon = true;
                    break;
                case 3:
                    break;
            }
            dismiss();
            return false;
        }

        public final void onClick(View view) {
            dl dlVar = (dl) view.getTag();
            if (view == this.ooh) {
                ay.k(view.getContext(), dlVar.userName, 3);
            } else {
                ay.k(view.getContext(), dlVar.userName, 2);
            }
            dismiss();
        }
    }

    static /* synthetic */ void k(Context context, String str, int i) {
        com.tencent.mm.sdk.c.b qiVar = new qi();
        qiVar.brC.bdn = 5;
        qiVar.brC.bdo = str;
        qiVar.brC.context = context;
        qiVar.brC.brx = i;
        com.tencent.mm.sdk.c.a.nhr.z(qiVar);
        g.iuh.h(11033, Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0));
    }

    public static void cN(View view) {
        com.tencent.mm.ui.chatting.ds.b bVar = ooe;
        if (view == null || bVar == null) {
            v.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
        } else if (VERSION.SDK_INT >= 14) {
            ds bGo = ds.bGo();
            if (VERSION.SDK_INT >= 14 && bGo.oyF == null) {
                bGo.oyF = new com.tencent.mm.ui.chatting.ds.a(bVar);
            }
            Object obj = bGo.oyF;
            if (obj != null && VERSION.SDK_INT >= 14 && (obj instanceof OnHoverListener)) {
                view.setOnHoverListener((OnHoverListener) obj);
            }
        }
    }

    public static void dismiss() {
        try {
            if (ooe != null) {
                ooe.dismiss();
            }
        } catch (Exception e) {
            v.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", e.getMessage());
        }
    }
}
