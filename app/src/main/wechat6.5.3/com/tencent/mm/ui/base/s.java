package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class s extends Toast {
    public final ah aSW = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ s nYM;

        {
            this.nYM = r1;
        }

        public final boolean oU() {
            if (this.nYM.dfS == -1) {
                this.nYM.show();
                return true;
            }
            this.nYM.eKW = this.nYM.eKW - 1;
            if (this.nYM.eKW >= 0) {
                this.nYM.show();
                return true;
            }
            this.nYM.cancel();
            return false;
        }
    }, true);
    private final Context context;
    private View dIN;
    public long dfS;
    public int eKW;
    private final TextView gLf;
    private int level;

    private static class a {
        private static Toast nYO = null;
        public static int nYP = 0;

        public static void Y(Context context, int i) {
            Context applicationContext = context.getApplicationContext();
            if (nYP != i) {
                nYO = null;
                nYP = i;
            }
            if (nYO == null) {
                nYO = Toast.makeText(applicationContext, SQLiteDatabase.KeyEmpty, 1);
            }
            View inflate = View.inflate(applicationContext, 2130904305, null);
            if (i == 1) {
                ((TextView) inflate.findViewById(2131758994)).setText(2131233826);
            } else if (i == 3) {
                ((TextView) inflate.findViewById(2131758994)).setText(2131233827);
            } else {
                ((TextView) inflate.findViewById(2131758994)).setText(2131233828);
            }
            nYO.setView(inflate);
            nYO.show();
        }
    }

    public s(Context context) {
        super(context);
        this.context = context;
        reset();
        this.dIN = View.inflate(context, 2130904549, null);
        setView(this.dIN);
        setGravity(55, 0, b.a(context, 40.0f));
        setDuration(0);
        this.gLf = (TextView) this.dIN.findViewById(2131759573);
        switch (this.level) {
            case 1:
                this.gLf.setTextColor(-1);
                return;
            case 2:
                this.gLf.setTextColor(this.context.getResources().getColor(2131690077));
                return;
            default:
                return;
        }
    }

    public final void setText(CharSequence charSequence) {
        this.gLf.setText(charSequence);
    }

    public final void setText(int i) {
        this.gLf.setText(i);
    }

    public final void reset() {
        this.level = 1;
        this.dfS = 2000;
        this.eKW = ((int) (this.dfS / 70)) + 1;
    }

    public static o a(Activity activity, String str, long j) {
        View inflate = View.inflate(activity, 2130904549, null);
        ((TextView) inflate.findViewById(2131759573)).setText(str);
        final o oVar = new o(inflate);
        oVar.setWidth(-1);
        oVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        oVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, rect.top + bv(activity));
        new ac() {
            public final void handleMessage(Message message) {
                oVar.dismiss();
                super.handleMessage(message);
            }
        }.sendEmptyMessageDelayed(0, j);
        return oVar;
    }

    private static int bv(Context context) {
        if ((context instanceof ActionBarActivity) && ((ActionBarActivity) context).cU().cV() != null) {
            return ((ActionBarActivity) context).cU().cV().getHeight();
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return context.getResources().getDimensionPixelSize(2131493014);
        }
        return context.getResources().getDimensionPixelSize(2131493015);
    }

    public static o a(Activity activity, int i, String str) {
        View inflate = View.inflate(activity, 2130903860, null);
        TextView textView = (TextView) inflate.findViewById(2131757702);
        textView.setText(str);
        textView.setOnClickListener(null);
        ImageView imageView = (ImageView) inflate.findViewById(2131757701);
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageResource(i);
        }
        final o oVar = new o(inflate);
        oVar.setWidth(-1);
        oVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        int bv = bv(activity);
        if (i2 == 0) {
            i2 = X(activity, 25);
        }
        oVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, i2 + bv);
        ac anonymousClass3 = new ac() {
            public final void handleMessage(Message message) {
                oVar.dismiss();
                super.handleMessage(message);
            }
        };
        ImageButton imageButton = (ImageButton) inflate.findViewById(2131757703);
        imageButton.setVisibility(8);
        imageButton.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                oVar.dismiss();
            }
        });
        anonymousClass3.sendEmptyMessageDelayed(0, 2000);
        return oVar;
    }

    public static void ey(Context context) {
        if (h.getExternalStorageState().equals("mounted_ro")) {
            a.Y(context, 3);
        } else {
            a.Y(context, 1);
        }
    }

    public static void ez(Context context) {
        a.Y(context, 2);
    }

    public static int eA(Context context) {
        return X(context, 25);
    }

    public static int X(Context context, int i) {
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            i = context.getResources().getDimensionPixelSize(be.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
        } catch (Throwable e) {
            v.a("MicroMsg.MMToast", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return i;
    }
}
