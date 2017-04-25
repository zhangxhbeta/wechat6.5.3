package com.tencent.mm.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.support.v4.view.l;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bf.g;
import com.tencent.mm.e.a.ab;
import com.tencent.mm.e.a.pm;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.widget.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

public abstract class k {
    public static boolean nDV = false;
    private static boolean nEp = false;
    public ActionBar FG;
    private int PROXIMITY_SCREEN_OFF_WAKE_LOCK = 32;
    String className;
    public AudioManager diI;
    public View dtW;
    private p eSv;
    private int gfR = 0;
    private LayoutInflater gwU;
    protected ac iqg = new ac(Looper.getMainLooper());
    private final long jUw = 300;
    private long jUx = SystemClock.elapsedRealtime();
    Context mContext;
    protected boolean nDQ = false;
    private View nDW;
    public View nDX;
    private View nDY;
    private TextView nDZ;
    private int nEA = -1;
    public int nEB = 0;
    private a nEC;
    private MenuItem nED;
    private Runnable nEE = new Runnable(this) {
        final /* synthetic */ k nEG;

        {
            this.nEG = r1;
        }

        public final void run() {
            this.nEG.nEl.getWindow().setFlags(1024, 1024);
            if (this.nEG.FG != null) {
                this.nEG.FG.hide();
            }
        }
    };
    private Runnable nEF = new Runnable(this) {
        final /* synthetic */ k nEG;

        {
            this.nEG = r1;
        }

        public final void run() {
            if (this.nEG.FG != null) {
                this.nEG.FG.show();
            }
        }
    };
    FrameLayout nEa;
    public boolean nEb = true;
    String nEc = " ";
    int nEd = 0;
    int nEe = 0;
    e nEf = null;
    e nEg = null;
    private e nEh = null;
    private e nEi = null;
    private boolean nEj = false;
    boolean nEk = false;
    public ActionBarActivity nEl;
    private boolean nEm;
    private a nEn = new a();
    LinkedList<a> nEo = new LinkedList();
    ArrayList<Dialog> nEq;
    public View nEr;
    public TextView nEs;
    View nEt;
    ImageView nEu;
    View nEv;
    private TextView nEw;
    private com.tencent.mm.e.a.pm.a nEx = null;
    private c nEy = new c<pm>(this) {
        final /* synthetic */ k nEG;

        {
            this.nEG = r2;
            this.nhz = pm.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            this.nEG.nEx = ((pm) bVar).bqO;
            if (this.nEG.nEx.aXy == 2) {
                this.nEG.a(this.nEG.nEx.aXA, this.nEG.nEx.visible, this.nEG.nEx.url, this.nEG.nEx.desc, false);
            }
            return false;
        }
    };
    private int nEz = 2130903077;
    private WakeLock wakeLock = null;

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ k nEG;
        final /* synthetic */ Runnable nEH;

        AnonymousClass2(k kVar, Runnable runnable) {
            this.nEG = kVar;
            this.nEH = runnable;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.nEG.jUx < 300) {
                this.nEH.run();
            }
            this.nEG.jUx = SystemClock.elapsedRealtime();
        }
    }

    public static final class a {
        boolean aZw = true;
        OnLongClickListener fRk;
        OnMenuItemClickListener iuP;
        int nEM = -1;
        int nEN;
        Drawable nEO;
        View nEP;
        View nEQ;
        int nER = b.nES;
        String text;
        boolean visible = true;
    }

    public enum b {
        ;

        static {
            nES = 1;
            nET = 2;
            nEU = 3;
            nEV = 4;
            nEW = 5;
            nEX = 6;
            nEY = 7;
            nEZ = 8;
            nFa = 9;
            nFb = new int[]{nES, nET, nEU, nEV, nEW, nEX, nEY, nEZ, nFa};
        }
    }

    protected abstract void PK();

    public abstract void aRG();

    protected abstract String avS();

    protected abstract View bAd();

    protected abstract void bB(View view);

    protected abstract boolean bzR();

    protected abstract String getClassName();

    protected abstract int getLayoutId();

    static /* synthetic */ boolean a(k kVar, View view, a aVar) {
        if (kVar.nEb) {
            return aVar.fRk != null ? aVar.fRk.onLongClick(view) : false;
        } else {
            v.w("MicroMsg.MMActivity", "callMenuCallback screen not enable.");
            return true;
        }
    }

    static /* synthetic */ boolean f(k kVar) {
        return (kVar.nEl.getWindow().getAttributes().flags & 1024) != 0;
    }

    static /* synthetic */ void g(k kVar) {
        kVar.nEB = 2;
        kVar.aRG();
    }

    static /* synthetic */ void h(k kVar) {
        kVar.nEB = 1;
        kVar.aRG();
    }

    private void a(int i, final boolean z, final String str, final String str2, boolean z2) {
        v.i("MicroMsg.MMActivity", "initNotifyView viewid %d", Integer.valueOf(i));
        if (!bkk()) {
            return;
        }
        if (!z && this.nDY == null) {
            return;
        }
        if (this.FG == null || this.FG.isShowing()) {
            if (this.nEa == null) {
                this.nEa = (FrameLayout) this.dtW.findViewById(2131758195);
            }
            if (this.nDY != null) {
                this.nEa.removeView(this.nDY);
            }
            if (i <= 0) {
                i = 2130904082;
            }
            this.nDY = this.gwU.inflate(i, null);
            this.nDZ = (TextView) this.nDY.findViewById(2131756613);
            this.nDY.findViewById(2131758301).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ k nEG;

                {
                    this.nEG = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.sdk.c.b abVar = new ab();
                    abVar.aXt.type = 1;
                    com.tencent.mm.sdk.c.a.nhr.z(abVar);
                    this.nEG.nDY.setVisibility(8);
                }
            });
            this.nDY.setVisibility(8);
            this.nDY.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ k nEG;

                public final void onClick(View view) {
                    if (str != null) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        this.nEG.mContext.startActivity(intent);
                    }
                }
            });
            this.nEa.addView(this.nDY, this.nEa.getChildCount(), new LayoutParams(-1, com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.nEl, 47.0f)));
            if (this.nDY == null) {
                return;
            }
            if (z2) {
                this.nDY.setVisibility(z ? 0 : 8);
                String string = this.mContext.getString(2131233289);
                if (be.kS(str2)) {
                    str2 = this.mContext.getString(2131233288);
                }
                if (str != null) {
                    CharSequence spannableString = new SpannableString(str2 + string);
                    spannableString.setSpan(new ForegroundColorSpan(-10119449), str2.length(), string.length() + str2.length(), 33);
                    this.nDZ.setText(spannableString);
                } else {
                    this.nDZ.setText(str2);
                }
                this.nDY.invalidate();
                this.nEa.invalidate();
                return;
            }
            this.nDY.post(new Runnable(this) {
                final /* synthetic */ k nEG;

                public final void run() {
                    this.nEG.nDY.setVisibility(z ? 0 : 8);
                    String string = this.nEG.mContext.getString(2131233289);
                    CharSequence string2 = be.kS(str2) ? this.nEG.mContext.getString(2131233288) : str2;
                    if (str != null) {
                        CharSequence spannableString = new SpannableString(string2 + string);
                        spannableString.setSpan(new ForegroundColorSpan(-10119449), string2.length(), string2.length() + string.length(), 33);
                        this.nEG.nDZ.setText(spannableString);
                    } else {
                        this.nEG.nDZ.setText(string2);
                    }
                    this.nEG.nDY.invalidate();
                    this.nEG.nEa.invalidate();
                }
            });
        }
    }

    private View findViewById(int i) {
        View findViewById = this.dtW.findViewById(i);
        return findViewById != null ? findViewById : this.nEl.findViewById(i);
    }

    public static Locale ed(Context context) {
        String d = u.d(context.getSharedPreferences(aa.bti(), 0));
        Resources resources = aa.getResources();
        if (d.equals("language_default")) {
            u.a(context, Locale.ENGLISH);
            if (resources instanceof com.tencent.mm.be.a) {
                ((com.tencent.mm.be.a) resources).brX();
            }
            return Locale.getDefault();
        }
        Locale Ke = u.Ke(d);
        u.a(context, Ke);
        if (resources instanceof com.tencent.mm.be.a) {
            ((com.tencent.mm.be.a) resources).brX();
        }
        return Ke;
    }

    public ActionBar cV() {
        return this.nEl.cU().cV();
    }

    public final void a(Context context, ActionBarActivity actionBarActivity) {
        this.mContext = actionBarActivity;
        this.nEl = actionBarActivity;
        PK();
        this.className = getClass().getName();
        v.ar(3, this.className);
        ed(context);
        this.diI = (AudioManager) this.mContext.getSystemService("audio");
        int layoutId = getLayoutId();
        this.gwU = LayoutInflater.from(this.mContext);
        this.dtW = this.gwU.inflate(2130903965, null);
        this.nDW = this.dtW.findViewById(2131758196);
        this.nEa = (FrameLayout) this.dtW.findViewById(2131758195);
        this.gfR = this.mContext.getResources().getDimensionPixelSize(2131493193);
        if (layoutId != -1) {
            this.nDX = bAd();
            if (this.nDX == null) {
                this.nDX = this.gwU.inflate(getLayoutId(), null);
            } else if (this.nDX.getParent() != null) {
                ((ViewGroup) this.nDX.getParent()).removeView(this.nDX);
            }
            this.nEa.addView(this.nDX, 0);
        }
        bB(this.dtW);
        if (bzR()) {
            int dimensionPixelSize;
            w.c(w.a(this.nEl.getWindow(), this.nDX), this.nDX);
            ((ViewGroup) this.nDX.getParent()).removeView(this.nDX);
            ((ViewGroup) this.nEl.getWindow().getDecorView()).addView(this.nDX, 0);
            layoutId = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 25);
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493014);
            } else {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493015);
            }
            this.nDX.setPadding(this.nDX.getPaddingLeft(), dimensionPixelSize + (layoutId + this.nDX.getPaddingTop()), this.nDX.getPaddingRight(), this.nDX.getPaddingBottom());
        }
        this.FG = cV();
        v.d("MicroMsg.MMActivity", "onCreate, before.");
        W(actionBarActivity);
        if (this.nEa == null || !(this.nEa instanceof LayoutListenerView)) {
            v.w("MicroMsg.MMActivity", "layoutListenerView is not right");
        } else {
            ((LayoutListenerView) this.nEa).nDH = new com.tencent.mm.ui.LayoutListenerView.a(this) {
                final /* synthetic */ k nEG;
                private final int nEJ = com.tencent.mm.bd.a.fromDPToPix(this.nEG.mContext, 100);

                {
                    this.nEG = r3;
                }

                public final void onSizeChanged(int i, int i2, int i3, int i4) {
                    if (!k.f(this.nEG) && i != 0 && i2 != 0 && i3 != 0 && i4 != 0 && i == i3) {
                        if (i2 > i4 && i2 - i4 > this.nEJ) {
                            k.g(this.nEG);
                        } else if (i4 > i2 && i4 - i2 > this.nEJ) {
                            k.h(this.nEG);
                        }
                    }
                }
            };
        }
        com.tencent.mm.sdk.c.b abVar = new ab();
        abVar.aXt.type = 2;
        com.tencent.mm.sdk.c.a.nhr.z(abVar);
        if (abVar.aXu.aXy == 2) {
            a(abVar.aXu.aXA, abVar.aXu.visible, abVar.aXu.url, abVar.aXu.desc, true);
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = actionBarActivity.getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(actionBarActivity.getResources().getColor(2131690051));
        }
    }

    public boolean Sk() {
        return false;
    }

    final void W(Activity activity) {
        if (this.FG != null && !Sk()) {
            if (VERSION.SDK_INT < 11) {
                this.FG.setBackgroundDrawable(new ColorDrawable(this.mContext.getResources().getColor(2131689500)));
            }
            v.d("MicroMsg.MMActivity", "onCreate, after");
            this.FG.setLogo(new ColorDrawable(this.nEl.getResources().getColor(17170445)));
            this.FG.cQ();
            this.FG.setDisplayHomeAsUpEnabled(false);
            this.FG.cP();
            this.FG.cR();
            this.FG.cO();
            if (this.nEA == -1) {
                this.FG.setCustomView(q.em(this.nEl).inflate(this.nEz, new LinearLayout(this.nEl), false));
            } else {
                this.FG.setCustomView(q.em(this.nEl).inflate(this.nEA, new LinearLayout(this.nEl), false));
            }
            this.nEs = (TextView) findViewById(16908308);
            this.nEw = (TextView) findViewById(16908309);
            this.nEr = findViewById(com.tencent.mm.bi.a.c.divider);
            this.nEt = findViewById(2131755284);
            this.nEu = (ImageView) findViewById(2131755285);
            if (this.nEu != null) {
                this.nEu.setContentDescription(this.nEl.getString(2131230906));
            }
            this.nEv = findViewById(2131755283);
            if (this.nEs != null) {
                this.nEs.setText(2131230720);
            }
            if (activity.getClass().getName() == "WebViewUI") {
                if (this.nEv != null) {
                    this.nEv.setVisibility(8);
                }
                if (this.nEu != null) {
                    this.nEu.setVisibility(0);
                }
                if (this.nEt != null) {
                    this.nEt.setVisibility(0);
                }
            } else if (activity instanceof MMActivity) {
                if (this.nEv != null) {
                    this.nEv.setVisibility(8);
                }
                if (this.nEu != null) {
                    this.nEu.setVisibility(0);
                }
                if (this.nEt != null) {
                    this.nEt.setVisibility(0);
                }
                if (this.nEs != null) {
                    this.nEs.setVisibility(0);
                }
            } else {
                if (this.nEv != null) {
                    this.nEv.setVisibility(0);
                }
                if (this.nEu != null) {
                    this.nEu.setVisibility(8);
                }
                if (this.nEt != null) {
                    this.nEt.setVisibility(8);
                }
            }
        }
    }

    public final void ca(boolean z) {
        this.nEb = z;
        if (this.nDW == null && this.dtW != null) {
            this.nDW = this.dtW.findViewById(2131758196);
        }
        if (this.nDW == null) {
            v.e("MicroMsg.MMActivity", "jacks error npe translayer !");
            return;
        }
        boolean z2;
        this.nDW.setFocusable(!z);
        View view = this.nDW;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        view.setFocusableInTouchMode(z2);
        if (!z) {
            Context context = this.nEl;
            if (this.wakeLock == null) {
                nDV = true;
                this.wakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(this.PROXIMITY_SCREEN_OFF_WAKE_LOCK, "screen Lock");
                this.wakeLock.acquire();
            }
        } else if (this.wakeLock != null && this.wakeLock.isHeld()) {
            nDV = false;
            this.wakeLock.release();
            this.wakeLock = null;
        }
    }

    public final void onStart() {
        this.nDQ = this.mContext.getSharedPreferences(aa.bti(), 0).getBoolean("settings_landscape_mode", false);
        if (this.nDQ) {
            this.nEl.setRequestedOrientation(-1);
        } else {
            this.nEl.setRequestedOrientation(1);
        }
    }

    public final boolean bAe() {
        return this.nDQ;
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82 || keyEvent.getAction() != 1) {
            return false;
        }
        if (this.nEC == null || !this.nEC.aZw) {
            return true;
        }
        a(this.nED, this.nEC);
        return true;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        int streamMaxVolume;
        int streamVolume;
        if (i == 25 && this.diI != null) {
            streamMaxVolume = this.diI.getStreamMaxVolume(3);
            streamVolume = this.diI.getStreamVolume(3);
            streamMaxVolume /= 7;
            if (streamMaxVolume == 0) {
                streamMaxVolume = 1;
            }
            this.diI.setStreamVolume(3, streamVolume - streamMaxVolume, 5);
            return true;
        } else if (i == 24 && this.diI != null) {
            streamMaxVolume = this.diI.getStreamMaxVolume(3);
            streamVolume = this.diI.getStreamVolume(3);
            if (streamVolume >= streamMaxVolume) {
                v.i("MicroMsg.MMActivity", "has set the max volume");
                return true;
            }
            streamMaxVolume /= 7;
            if (streamMaxVolume == 0) {
                streamMaxVolume = 1;
            }
            this.diI.setStreamVolume(3, streamMaxVolume + streamVolume, 5);
            return true;
        } else if (!this.nEm || this.eSv == null || !this.eSv.onKeyDown(i, keyEvent)) {
            return false;
        } else {
            v.d("MicroMsg.MMActivity", "match search view on key down");
            return true;
        }
    }

    public boolean bkk() {
        return true;
    }

    public final void onResume() {
        iW(true);
        com.tencent.mm.sdk.c.a.nhr.e(this.nEy);
        com.tencent.mm.sdk.c.b abVar = new ab();
        abVar.aXt.type = 2;
        com.tencent.mm.sdk.c.a.nhr.z(abVar);
        if (abVar.aXu.aXy == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            a(abVar.aXu.aXA, abVar.aXu.visible, abVar.aXu.url, abVar.aXu.desc, true);
            v.v("MicroMsg.INIT", "KEVIN MMActivity onResume initNotifyView:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final void onDestroy() {
        if (this.nEq != null) {
            int size = this.nEq.size();
            for (int i = 0; i < size; i++) {
                Dialog dialog = (Dialog) this.nEq.get(i);
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
            this.nEq.clear();
            this.nEq = null;
        }
    }

    private void iW(boolean z) {
        if (nEp || !z) {
            w.a(z, new Intent().putExtra("classname", getClassName() + avS()));
        } else {
            w.a(z, new Intent().putExtra("classname", getClassName()).putExtra("main_process", false));
        }
    }

    public static void bzT() {
        nEp = true;
    }

    public final void onPause() {
        iW(false);
        com.tencent.mm.sdk.c.a.nhr.f(this.nEy);
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        v.d("MicroMsg.MMActivity", "on create option menu, menuCache size:%d", Integer.valueOf(this.nEo.size()));
        if (this.FG == null || this.nEo.size() == 0) {
            v.w("MicroMsg.MMActivity", "error, mActionBar is null or cache size:%d", Integer.valueOf(this.nEo.size()));
            return false;
        }
        int dimensionPixelSize;
        this.nEC = null;
        this.nED = null;
        int height = this.FG.getHeight();
        if (height == 0) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493014);
            } else {
                dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493015);
            }
        } else {
            dimensionPixelSize = height;
        }
        Iterator it = this.nEo.iterator();
        while (it.hasNext()) {
            final a aVar = (a) it.next();
            if (aVar.nEM == 16908332) {
                v.v("MicroMsg.MMActivity", "match back option menu, continue");
            } else if (aVar.nEM == 2131755061) {
                r1 = "MicroMsg.MMActivity";
                String str = "match search menu, enable search view[%B], search view helper is null[%B]";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(this.nEm);
                objArr[1] = Boolean.valueOf(this.eSv == null);
                v.v(r1, str, objArr);
                if (this.nEm && this.eSv != null) {
                    this.eSv.a(this.nEl, menu);
                }
            } else {
                final MenuItem add = menu.add(0, aVar.nEM, 0, aVar.text);
                r1 = getClass().getName();
                if (add == null) {
                    v.w("MicroMsg.MenuItemUtil", "fixTitleCondensed fail, item is null");
                } else if (add.getTitleCondensed() == null) {
                    v.w("MicroMsg.MenuItemUtil", "%s title condensed is null, fix it", r1);
                    add.setTitleCondensed(SQLiteDatabase.KeyEmpty);
                } else if (!(add.getTitleCondensed() instanceof String)) {
                    v.w("MicroMsg.MenuItemUtil", "%s title condensed is not String type, cur type[%s], cur value[%s], fix it", r1, add.getTitleCondensed().getClass().getName(), add.getTitleCondensed());
                    add.setTitleCondensed(add.getTitleCondensed().toString());
                }
                OnClickListener anonymousClass10 = new OnClickListener(this) {
                    final /* synthetic */ k nEG;

                    public final void onClick(View view) {
                        this.nEG.a(add, aVar);
                    }
                };
                OnLongClickListener anonymousClass11 = new OnLongClickListener(this) {
                    final /* synthetic */ k nEG;

                    public final boolean onLongClick(View view) {
                        return k.a(this.nEG, view, aVar);
                    }
                };
                if (aVar.nEN == 0 && aVar.nEO == null) {
                    TextView textView;
                    if (aVar.nEP == null) {
                        aVar.nEP = View.inflate(this.mContext, 2130903072, null);
                    }
                    if (aVar.nER == b.nEU) {
                        aVar.nEP.findViewById(2131755265).setVisibility(8);
                        aVar.nEP.findViewById(com.tencent.mm.bi.a.c.divider).setVisibility(8);
                        textView = (TextView) aVar.nEP.findViewById(2131755266);
                        textView.setBackgroundResource(2130837801);
                        textView.setPadding(this.gfR, 0, this.gfR, 0);
                    } else if (aVar.nER == b.nET) {
                        aVar.nEP.findViewById(2131755265).setVisibility(8);
                        aVar.nEP.findViewById(com.tencent.mm.bi.a.c.divider).setVisibility(8);
                        textView = (TextView) aVar.nEP.findViewById(2131755266);
                        textView.setBackgroundResource(2130837799);
                        textView.setPadding(this.gfR, 0, this.gfR, 0);
                    } else if (aVar.nER == b.nEV) {
                        aVar.nEP.findViewById(2131755265).setVisibility(8);
                        aVar.nEP.findViewById(com.tencent.mm.bi.a.c.divider).setVisibility(8);
                        textView = (TextView) aVar.nEP.findViewById(2131755266);
                        ((TextView) aVar.nEP.findViewById(2131755266)).setTextColor(-8393929);
                        textView.setBackgroundResource(2130839174);
                        textView.setPadding(this.gfR, 0, this.gfR, 0);
                        aVar.nEP.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
                    } else if (aVar.nER == b.nEW || aVar.nER == b.nEX || aVar.nER == b.nEY || aVar.nER == b.nFa) {
                        aVar.nEP.findViewById(2131755266).setVisibility(8);
                        aVar.nEP.findViewById(com.tencent.mm.bi.a.c.divider).setVisibility(8);
                        textView = (TextView) aVar.nEP.findViewById(2131755265);
                        if (aVar.nER == b.nEX) {
                            textView.setTextColor(this.nEl.getResources().getColor(2131690009));
                        } else if (aVar.nER == b.nEY) {
                            textView.setTextColor(this.nEl.getResources().getColor(2131690123));
                        } else if (aVar.nER == b.nFa) {
                            textView.setTextColor(this.nEl.getResources().getColor(2131689846));
                        }
                    } else if (aVar.nER == b.nEZ) {
                        aVar.nEP.findViewById(2131755265).setVisibility(8);
                        aVar.nEP.findViewById(com.tencent.mm.bi.a.c.divider).setVisibility(8);
                        textView = (TextView) aVar.nEP.findViewById(2131755266);
                        textView.setBackgroundResource(2130837804);
                        textView.setPadding(this.gfR, 0, this.gfR, 0);
                        textView.setTextColor(-2601405);
                    } else {
                        aVar.nEP.findViewById(2131755266).setVisibility(8);
                        aVar.nEP.findViewById(com.tencent.mm.bi.a.c.divider).setVisibility(0);
                        textView = (TextView) aVar.nEP.findViewById(2131755265);
                    }
                    textView.setVisibility(0);
                    textView.setText(aVar.text);
                    textView.setOnClickListener(anonymousClass10);
                    textView.setOnLongClickListener(anonymousClass11);
                    textView.setEnabled(aVar.aZw);
                    l.a(add, aVar.nEP);
                } else if (aVar.fRk != null) {
                    View imageButton;
                    int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(this.mContext, 56);
                    if (aVar.nEQ == null) {
                        imageButton = new ImageButton(this.mContext);
                        imageButton.setLayoutParams(new ViewGroup.LayoutParams(fromDPToPix, dimensionPixelSize));
                        imageButton.setBackgroundResource(2130837603);
                        imageButton.setMinimumHeight(dimensionPixelSize);
                        imageButton.setMinimumWidth(fromDPToPix);
                        aVar.nEQ = imageButton;
                    } else {
                        imageButton = aVar.nEQ;
                    }
                    if (aVar.nEO != null) {
                        ((ImageButton) imageButton).setImageDrawable(aVar.nEO);
                    } else {
                        ((ImageButton) imageButton).setImageResource(aVar.nEN);
                    }
                    l.a(add, imageButton);
                    ViewGroup.LayoutParams layoutParams = imageButton.getLayoutParams();
                    layoutParams.width = fromDPToPix;
                    layoutParams.height = dimensionPixelSize;
                    imageButton.setOnClickListener(anonymousClass10);
                    imageButton.setOnLongClickListener(anonymousClass11);
                    imageButton.setEnabled(aVar.aZw);
                    imageButton.setContentDescription(aVar.text);
                } else if (aVar.nEO != null) {
                    add.setIcon(aVar.nEO);
                } else {
                    add.setIcon(aVar.nEN);
                }
                add.setEnabled(aVar.aZw);
                add.setVisible(aVar.visible);
                l.a(add, 2);
                if (aVar.nEN == 2130838681) {
                    this.nEC = aVar;
                    this.nED = add;
                }
                v.v("MicroMsg.MMActivity", "set %d %s option menu enable %B, visible %B", Integer.valueOf(aVar.nEM), aVar.text, Boolean.valueOf(aVar.aZw), Boolean.valueOf(aVar.visible));
            }
        }
        return true;
    }

    public final boolean onPrepareOptionsMenu(Menu menu) {
        v.d("MicroMsg.MMActivity", "on prepare option menu");
        if (this.nEm && this.eSv != null) {
            this.eSv.a(this.nEl, menu);
        }
        return true;
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        v.v("MicroMsg.MMActivity", "on options item selected");
        if (!this.nEb) {
            v.w("MicroMsg.MMActivity", "onOptionsItemSelected screen not enable.");
            return true;
        } else if (menuItem.getItemId() == this.nEn.nEM && this.nEn.aZw) {
            a(menuItem, this.nEn);
            return true;
        } else {
            Iterator it = this.nEo.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (menuItem.getItemId() == aVar.nEM) {
                    v.d("MicroMsg.MMActivity", "on option menu %d click", Integer.valueOf(menuItem.getItemId()));
                    a(menuItem, aVar);
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean bAf() {
        if (this.nEn == null || !this.nEn.aZw) {
            return false;
        }
        a(null, this.nEn);
        return true;
    }

    private void a(MenuItem menuItem, a aVar) {
        if (!this.nEb) {
            v.w("MicroMsg.MMActivity", "callMenuCallback screen not enable.");
        } else if (aVar.iuP != null) {
            aVar.iuP.onMenuItemClick(menuItem);
        }
    }

    public final void iR(boolean z) {
        if (z) {
            if (this.FG != null) {
                this.FG.hide();
            }
            this.iqg.removeCallbacks(this.nEF);
            this.iqg.removeCallbacks(this.nEE);
            this.iqg.postDelayed(this.nEE, 256);
            return;
        }
        this.nEl.getWindow().clearFlags(1024);
        this.iqg.removeCallbacks(this.nEE);
        this.iqg.removeCallbacks(this.nEF);
        this.iqg.postDelayed(this.nEF, 256);
    }

    public final void Fd(String str) {
        if (this.FG != null) {
            this.nEc = str;
            bAg();
            NZ(str);
        }
    }

    public final void H(CharSequence charSequence) {
        if (this.FG != null) {
            this.nEc = charSequence.toString();
            this.nEs.setText(charSequence);
            NZ(charSequence.toString());
        }
    }

    protected final void NZ(String str) {
        com.tencent.mm.ui.a.a bAK = a.nHA;
        Activity activity = this.nEl;
        if (!bAK.bAJ() && !be.kS(str) && activity != null) {
            activity.getWindow().getDecorView().setContentDescription(activity.getString(2131231968) + str);
        }
    }

    public final void vD(int i) {
        Fd(this.mContext.getString(i));
    }

    public final void NY(String str) {
        if (this.FG != null) {
            if (str == null) {
                this.nEw.setVisibility(8);
                return;
            }
            this.nEw.setText(str);
            if (com.tencent.mm.bd.a.dt(this.nEl)) {
                this.nEw.setTextSize(1, 14.0f);
                this.nEs.setTextSize(1, 18.0f);
            }
            this.nEw.setVisibility(0);
            NZ(str);
        }
    }

    public final void vE(int i) {
        if (this.FG != null) {
            this.nEw.setText(this.mContext.getString(i));
            if (com.tencent.mm.bd.a.dt(this.nEl)) {
                this.nEw.setTextSize(1, 14.0f);
                this.nEs.setTextSize(1, 18.0f);
            }
            this.nEw.setVisibility(0);
            NZ(this.mContext.getString(i));
        }
    }

    final e dc(int i, int i2) {
        Drawable drawable = this.mContext.getResources().getDrawable(i2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        e eVar = new e(drawable);
        eVar.pbC = (drawable.getIntrinsicHeight() - i) / 2;
        return eVar;
    }

    final void bAg() {
        String str;
        int i;
        String str2;
        int i2;
        String str3;
        int i3;
        String str4 = "%s";
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131492967);
        if (this.nEd != 0) {
            str4 = "# " + str4;
        }
        if (this.nEe != 0) {
            str = str4 + " #";
            i = 1;
        } else {
            str = str4;
            i = 0;
        }
        if (this.nEj) {
            str2 = str + " #";
            i2 = i + 2;
            i = 1;
        } else {
            str2 = str;
            i2 = i;
            i = 0;
        }
        if (this.nEk) {
            str3 = str2 + " #";
            i3 = i2 + 2;
            i2 = i + 2;
            i = 1;
        } else {
            str3 = str2;
            i3 = i2;
            i2 = i;
            i = 0;
        }
        CharSequence format = String.format(str3, new Object[]{this.nEc});
        v.v("MicroMsg.MMActivity", "span title format %s", str3);
        CharSequence e = g.buU().e(this.mContext, format, dimensionPixelSize);
        if (this.nEd != 0) {
            e.setSpan(this.nEf, 0, 1, 33);
        }
        if (this.nEe != 0) {
            int length = e.length() - i3;
            e.setSpan(this.nEg, length, length + 1, 33);
        }
        if (this.nEj) {
            if (this.nEh == null) {
                this.nEh = dc(dimensionPixelSize, 2131165370);
            }
            length = e.length() - i2;
            e.setSpan(this.nEh, length, length + 1, 33);
        }
        if (this.nEk) {
            if (this.nEi == null) {
                this.nEi = dc(dimensionPixelSize, 2131165371);
            }
            i = e.length() - i;
            e.setSpan(this.nEi, i, i + 1, 33);
        }
        this.nEs.setText(e);
    }

    public void aR() {
        this.nEl.aR();
    }

    public boolean bAh() {
        return false;
    }

    public final void iS(boolean z) {
        if (this.nEn != null && this.nEn.aZw != z) {
            this.nEn.aZw = z;
            aR();
        }
    }

    final void a(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.nEo.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.aZw != z2) {
                    aVar.aZw = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.nEo.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.nEM != i || aVar.aZw == z2) {
                    z4 = z3;
                } else {
                    aVar.aZw = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        if (!(this.eSv == null ? false : this.eSv.oUn)) {
            aR();
        }
        v.v("MicroMsg.MMActivity", "enable option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    final void b(boolean z, int i, boolean z2) {
        boolean z3;
        boolean z4;
        Iterator it;
        a aVar;
        if (z) {
            it = this.nEo.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.visible != z2) {
                    aVar.visible = z2;
                    z4 = true;
                } else {
                    z4 = z3;
                }
                z3 = z4;
            }
        } else {
            it = this.nEo.iterator();
            z3 = false;
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (aVar.nEM != i || aVar.visible == z2) {
                    z4 = z3;
                } else {
                    aVar.visible = z2;
                    z4 = true;
                }
                z3 = z4;
            }
        }
        z4 = this.eSv == null ? false : this.eSv.oUn;
        if (z3 && !z4) {
            aR();
        }
        v.i("MicroMsg.MMActivity", "show option menu, target id %d, changed %B, searching %B", Integer.valueOf(i), Boolean.valueOf(z3), Boolean.valueOf(z4));
    }

    public final void a(boolean z, p pVar) {
        v.v("MicroMsg.MMActivity", "add search menu");
        a aVar = new a();
        aVar.nEM = 2131755061;
        aVar.text = this.mContext.getString(2131231148);
        aVar.nEN = 2131165207;
        aVar.iuP = null;
        aVar.fRk = null;
        vH(aVar.nEM);
        this.nEo.add(0, aVar);
        this.nEm = z;
        this.eSv = pVar;
        aR();
    }

    public final void a(int i, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, int i2) {
        a(i, 0, str, onMenuItemClickListener, null, i2);
    }

    public final void a(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i2, SQLiteDatabase.KeyEmpty, onMenuItemClickListener, null, b.nES);
    }

    public final void a(int i, String str, Drawable drawable, OnMenuItemClickListener onMenuItemClickListener) {
        int i2 = b.nES;
        a aVar = new a();
        aVar.nEM = 0;
        aVar.nEO = drawable;
        aVar.text = str;
        aVar.iuP = onMenuItemClickListener;
        aVar.fRk = null;
        aVar.nER = i2;
        vJ(aVar.nEM);
        this.nEo.add(aVar);
        new ac().postDelayed(new Runnable(this) {
            final /* synthetic */ k nEG;

            {
                this.nEG = r1;
            }

            public final void run() {
                this.nEG.aR();
            }
        }, 200);
    }

    public final void a(int i, int i2, int i3, OnMenuItemClickListener onMenuItemClickListener) {
        a(i, i3, this.mContext.getString(i2), onMenuItemClickListener, null, b.nES);
    }

    public final void a(final OnMenuItemClickListener onMenuItemClickListener, int i) {
        if (this.FG != null) {
            if (onMenuItemClickListener == null) {
                this.FG.setDisplayHomeAsUpEnabled(false);
            } else {
                this.FG.setDisplayHomeAsUpEnabled(false);
                if (this.nEt != null) {
                    this.nEt.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ k nEG;

                        public final void onClick(View view) {
                            onMenuItemClickListener.onMenuItemClick(null);
                        }
                    });
                }
            }
            if (!(this.nEu == null || i == 0)) {
                this.nEu.setImageResource(i);
            }
            this.nEn.nEM = 16908332;
            this.nEn.iuP = onMenuItemClickListener;
        }
    }

    public final void bAi() {
        if (!this.nEo.isEmpty()) {
            this.nEo.clear();
            aR();
        }
    }

    private boolean vJ(int i) {
        for (int i2 = 0; i2 < this.nEo.size(); i2++) {
            if (((a) this.nEo.get(i2)).nEM == i) {
                v.d("MicroMsg.MMActivity", "match menu, id %d, remove it", Integer.valueOf(i));
                this.nEo.remove(i2);
                return true;
            }
        }
        return false;
    }

    public final boolean vH(int i) {
        for (int i2 = 0; i2 < this.nEo.size(); i2++) {
            if (((a) this.nEo.get(i2)).nEM == i) {
                v.d("MicroMsg.MMActivity", "match menu, id %d, remove it", Integer.valueOf(i));
                this.nEo.remove(i2);
                aR();
                return true;
            }
        }
        return false;
    }

    public final void a(int i, int i2, String str, OnMenuItemClickListener onMenuItemClickListener, OnLongClickListener onLongClickListener, int i3) {
        a aVar = new a();
        aVar.nEM = i;
        aVar.nEN = i2;
        aVar.text = str;
        aVar.iuP = onMenuItemClickListener;
        aVar.fRk = onLongClickListener;
        aVar.nER = i3;
        if (aVar.nEN == 2130838681 && be.kS(str)) {
            aVar.text = this.mContext.getString(2131233584);
        }
        vJ(aVar.nEM);
        this.nEo.add(aVar);
        new ac().postDelayed(new Runnable(this) {
            final /* synthetic */ k nEG;

            {
                this.nEG = r1;
            }

            public final void run() {
                this.nEG.aR();
            }
        }, 200);
    }

    public final a vK(int i) {
        Iterator it = this.nEo.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.nEM == i) {
                return aVar;
            }
        }
        return null;
    }

    public final void bAj() {
        boolean z = true;
        String str = "MicroMsg.MMActivity";
        String str2 = "hideTitleView hasTitle:%b";
        Object[] objArr = new Object[1];
        if (this.FG == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.v(str, str2, objArr);
        if (this.FG != null) {
            this.FG.hide();
        }
    }

    public final void vI(int i) {
        this.nEj = i == 0;
        bAg();
    }

    public final boolean ale() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        View currentFocus = this.nEl.getCurrentFocus();
        if (currentFocus == null) {
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            v.e("MicroMsg.MMActivity", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        v.v("MicroMsg.MMActivity", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
        return hideSoftInputFromWindow;
    }

    public final boolean cw(View view) {
        if (view == null) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.mContext.getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            v.e("MicroMsg.MMActivity", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        return hideSoftInputFromWindow;
    }

    public final void aJs() {
        Activity activity = this.nEl;
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }
}
