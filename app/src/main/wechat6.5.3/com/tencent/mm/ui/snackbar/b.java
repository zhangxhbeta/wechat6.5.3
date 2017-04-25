package com.tencent.mm.ui.snackbar;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ac;

public final class b {
    ac mHandler = new ac();
    View mParentView;
    SnackContainer oPX;
    b oPY;
    c oPZ;
    private final OnClickListener oQa = new OnClickListener(this) {
        final /* synthetic */ b oQb;

        {
            this.oQb = r1;
        }

        public final void onClick(View view) {
            if (this.oQb.oPY != null && this.oQb.oPX.isShowing()) {
                this.oQb.oPY.bkH();
            }
            this.oQb.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 oQd;

                {
                    this.oQd = r1;
                }

                public final void run() {
                    this.oQd.oQb.oPX.hide();
                }
            }, 100);
        }
    };

    public static class a {
        private Context mContext;
        String mMessage;
        String oPS;
        private int oPT = 0;
        private Parcelable oPU;
        private short oPV = (short) 3500;
        b oQe;
        int oQf = 0;
        private int xc = -1;

        public a(Activity activity) {
            this.mContext = activity.getApplicationContext();
            this.oQe = new b(activity, this.oQf);
        }

        public a(Context context, View view) {
            this.mContext = context;
            this.oQe = new b(context, view, this.oQf);
        }

        public final a a(Short sh) {
            this.oPV = sh.shortValue();
            return this;
        }

        public final b bIP() {
            Snack snack = new Snack(this.mMessage, this.oPS != null ? this.oPS.toUpperCase() : null, this.oPT, this.oPU, this.oPV, this.xc != -1 ? this.xc : this.mContext.getResources().getColor(2131690123));
            b bVar = this.oQe;
            ViewParent viewParent = bVar.oPX;
            View view = bVar.mParentView;
            c cVar = bVar.oPZ;
            if (!(view.getParent() == null || view.getParent() == viewParent)) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            a aVar = new a(snack, view, cVar);
            viewParent.oQg.offer(aVar);
            if (viewParent.oQg.size() == 1) {
                viewParent.a(aVar, false);
            }
            return this.oQe;
        }
    }

    public interface b {
        void bkH();
    }

    public interface c {
        void aEU();

        void blD();

        void onHide();
    }

    public b(Activity activity, int i) {
        View childAt = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        if (childAt == null) {
            childAt = activity.findViewById(16908290);
        }
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        layoutInflater.inflate(2130904413, (ViewGroup) childAt);
        a((ViewGroup) childAt, layoutInflater.inflate(2130904414, (ViewGroup) childAt, false), i);
    }

    public b(Context context, View view, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        layoutInflater.inflate(2130904413, (ViewGroup) view);
        a((ViewGroup) view, layoutInflater.inflate(2130904414, (ViewGroup) view, false), i);
    }

    private void a(ViewGroup viewGroup, View view, int i) {
        this.oPX = (SnackContainer) viewGroup.findViewById(2131759225);
        if (this.oPX == null) {
            this.oPX = new SnackContainer(viewGroup);
        }
        this.mParentView = view;
        if (i == 36) {
            this.oPX.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ b oQb;

                {
                    this.oQb = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (a.aQa() && this.oQb.oPX.isShowing()) {
                        a.kc(false);
                        this.oQb.mHandler.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 oQc;

                            {
                                this.oQc = r1;
                            }

                            public final void run() {
                                this.oQc.oQb.oPX.hide();
                            }
                        }, 100);
                    }
                    return true;
                }
            });
        }
        ((TextView) view.findViewById(2131759228)).setOnClickListener(this.oQa);
    }
}
