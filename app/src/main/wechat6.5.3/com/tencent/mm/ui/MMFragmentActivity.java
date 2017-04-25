package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.a.a.f;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.u;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.j;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MMFragmentActivity extends ActionBarActivity implements com.tencent.mm.ui.widget.SwipeBackLayout.a, com.tencent.mm.ui.widget.j.a, com.tencent.mm.vending.e.b {
    String className;
    public boolean dNj;
    private com.tencent.mm.vending.a.a nFA = new com.tencent.mm.vending.a.a();
    private a nFB = new a();
    private View nFC = null;
    public SwipeBackLayout nFw;
    ArrayList<WeakReference<p>> nFy = new ArrayList();
    private b nFz;

    public static class a {
        public static int nFE;
        public static int nFF;
        public static int nFG;
        public static int nFH;
        public static int nFI = nFE;
        public static int nFJ = nFF;
        public static int nFK = nFG;
        public static int nFL = nFH;

        static {
            int i;
            int i2 = 2130968589;
            int sh = com.tencent.mm.compatible.h.a.sh() & d.dW(19);
            nFE = sh != 0 ? 2130968680 : 2130968641;
            if (sh != 0) {
                i = 2130968677;
            } else {
                i = 2130968589;
            }
            nFF = i;
            if (sh != 0) {
                i2 = 2130968676;
            }
            nFG = i2;
            if (sh != 0) {
                i = 2130968681;
            } else {
                i = 2130968642;
            }
            nFH = i;
        }

        public static void bAs() {
            int i = 2130968589;
            u uVar = p.ceF;
            boolean sa = u.sa();
            v.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle swipbackType = " + sa);
            if (sa) {
                int i2;
                boolean sh = com.tencent.mm.compatible.h.a.sh() & d.dW(19);
                v.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle supportSwipe = " + sh);
                nFE = sh ? 2130968680 : 2130968641;
                if (sh) {
                    i2 = 2130968677;
                } else {
                    i2 = 2130968589;
                }
                nFF = i2;
                if (sh) {
                    i = 2130968676;
                }
                nFG = i;
                nFH = sh ? 2130968681 : 2130968642;
                nFI = nFE;
                nFJ = nFF;
                nFK = nFG;
                nFL = nFH;
            }
        }
    }

    private final class b {
        PendingIntent ako;
        final /* synthetic */ MMFragmentActivity nFD;
        NfcAdapter nFM;
        IntentFilter[] nFN;
        String[][] nFO;

        private b(MMFragmentActivity mMFragmentActivity) {
            this.nFD = mMFragmentActivity;
        }
    }

    public void a(com.tencent.mm.vending.e.a aVar) {
        this.nFA.pfU.a(aVar);
    }

    public void onCreate(Bundle bundle) {
        this.className = getClass().getName();
        v.ar(3, this.className);
        super.onCreate(bundle);
        this.nFz = new b();
        b bVar = this.nFz;
        bVar.nFM = NfcAdapter.getDefaultAdapter(bVar.nFD);
        Intent intent = new Intent();
        intent.setClassName(aa.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
        intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        bVar.ako = PendingIntent.getActivity(bVar.nFD, 0, intent, 0);
        try {
            new IntentFilter("android.nfc.action.NDEF_DISCOVERED").addDataType("*/*");
            new IntentFilter("android.nfc.action.TECH_DISCOVERED").addDataScheme("vnd.android.nfc");
            bVar.nFN = new IntentFilter[]{r1, r2, new IntentFilter("android.nfc.action.TAG_DISCOVERED")};
            String[][] strArr = new String[1][];
            strArr[0] = new String[]{NfcA.class.getName(), IsoDep.class.getName()};
            bVar.nFO = strArr;
        } catch (Throwable e) {
            throw new RuntimeException("fail", e);
        }
    }

    public void onDestroy() {
        this.nFA.pfU.dead();
        super.onDestroy();
    }

    public void onStop() {
        this.nFA.pfW.dead();
        super.onStop();
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        v.ar(2, this.className);
        super.onPause();
        if (bAm()) {
            if (this.nFw != null) {
                this.nFw.hVC = false;
            }
            if (!isFinishing()) {
                j.a(this);
            }
        }
        if (this.nFz != null) {
            b bVar = this.nFz;
            if (bVar.nFM != null) {
                try {
                    bVar.nFM.disableForegroundDispatch(bVar.nFD);
                } catch (IllegalStateException e) {
                    v.e("MicroMsg.MMFragmentActivity", "lo-nfc-onPause: exp:" + e.getLocalizedMessage());
                }
            }
        }
        this.nFA.pfV.dead();
    }

    public void onResume() {
        v.ar(1, this.className);
        super.onResume();
        if (bAm()) {
            j.b(this);
            I(1.0f);
            if (this.nFw != null) {
                this.nFw.hVC = true;
                this.nFw.paQ = false;
            }
        }
        if (this.nFz != null) {
            b bVar = this.nFz;
            if (bVar.nFM != null) {
                try {
                    bVar.nFM.enableForegroundDispatch(bVar.nFD, bVar.ako, bVar.nFN, bVar.nFO);
                } catch (IllegalStateException e) {
                    v.e("MicroMsg.MMFragmentActivity", "lo-nfc-onResume: exp:" + e.getLocalizedMessage());
                }
            }
        }
    }

    public p bzM() {
        int size = this.nFy.size();
        if (size == 0) {
            return null;
        }
        p pVar = (p) ((WeakReference) this.nFy.get(size - 1)).get();
        if (pVar == null || !pVar.isShowing()) {
            return null;
        }
        return pVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (VERSION.SDK_INT < 11) {
            super.onSaveInstanceState(bundle);
        }
    }

    private void X(Intent intent) {
        ComponentName component = intent == null ? null : intent.getComponent();
        if (component != null) {
            Object obj;
            String className = component.getClassName().startsWith(component.getPackageName()) ? component.getClassName() : component.getPackageName() + component.getClassName();
            if ((com.tencent.mm.ui.base.b.On(className) & 2) == 0) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                super.overridePendingTransition(a.nFI, a.nFJ);
                return;
            }
            Object obj2;
            if ((com.tencent.mm.ui.base.b.On(className) & 4) != 0) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                com.tencent.mm.ui.base.b.ev(this);
            } else {
                com.tencent.mm.ui.base.b.ex(this);
            }
        }
    }

    public void finish() {
        Object obj;
        Object obj2 = 1;
        super.finish();
        if ((com.tencent.mm.ui.base.b.r(getClass()) & 2) == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            super.overridePendingTransition(a.nFK, a.nFL);
            return;
        }
        if ((com.tencent.mm.ui.base.b.r(getClass()) & 4) == 0) {
            obj2 = null;
        }
        if (obj2 == null) {
            com.tencent.mm.ui.base.b.ew(this);
        } else {
            com.tencent.mm.ui.base.b.ex(this);
        }
    }

    @TargetApi(16)
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        super.startActivities(intentArr, bundle);
        X(null);
    }

    @TargetApi(11)
    public void startActivities(Intent[] intentArr) {
        super.startActivities(intentArr);
        X(null);
    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        X(intent);
    }

    @TargetApi(16)
    public void startActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
        X(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
        X(intent);
    }

    @TargetApi(16)
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
        X(intent);
    }

    public final void a(Fragment fragment, Intent intent, int i) {
        super.a(fragment, intent, i);
        X(intent);
    }

    private boolean bAm() {
        if (d.dW(19) && com.tencent.mm.compatible.h.a.sh() && aXG() && com.tencent.mm.ui.base.b.s(getClass())) {
            return true;
        }
        return false;
    }

    public boolean aXG() {
        return true;
    }

    public boolean Sd() {
        return true;
    }

    public final boolean bAr() {
        if (d.dW(19)) {
            if (com.tencent.mm.ui.base.b.s(getClass()) && Sd()) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ MMFragmentActivity nFD;

                    {
                        this.nFD = r1;
                    }

                    public final void run() {
                        com.tencent.mm.ui.base.b.aa(this.nFD);
                    }
                });
            } else {
                boolean z;
                if ((com.tencent.mm.ui.base.b.r(getClass()) & 16) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ MMFragmentActivity nFD;

                        {
                            this.nFD = r1;
                        }

                        public final void run() {
                            com.tencent.mm.ui.base.b.aa(this.nFD);
                        }
                    });
                }
            }
        }
        if (!bAm()) {
            return false;
        }
        bRC();
        return true;
    }

    public void bRC() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        this.nFw = (SwipeBackLayout) LayoutInflater.from(this).inflate(2130904532, viewGroup, false);
        this.nFw.init();
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getWindow().getDecorView().setBackgroundDrawable(null);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
        viewGroup2.setBackgroundResource(2131690078);
        viewGroup.removeView(viewGroup2);
        this.nFw.addView(viewGroup2);
        this.nFw.Hq = viewGroup2;
        viewGroup.addView(this.nFw);
        this.nFw.peB = this;
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if ("layout_inflater".equals(str)) {
            return q.b((LayoutInflater) systemService);
        }
        return systemService;
    }

    public Resources getResources() {
        if (getAssets() == null || aa.getResources() == null) {
            return super.getResources();
        }
        return aa.getResources();
    }

    public void I(float f) {
        v.v("ashutest", "ashutest::on swipe %f, duration %d", Float.valueOf(f), Long.valueOf(240));
        if (this.nFC == null) {
            this.nFC = w.a(getWindow(), cU().cV().getCustomView());
        }
        View view = this.nFC;
        if (Float.compare(1.0f, f) <= 0) {
            com.tencent.mm.ui.tools.j.m(view, 0.0f);
        } else {
            com.tencent.mm.ui.tools.j.m(view, (((float) (view.getWidth() / 4)) * (1.0f - f)) * -1.0f);
        }
    }

    public void c(boolean z, int i) {
        long j = 120;
        v.v("ashutest", "ashutest:: on settle %B, speed %d", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.nFC == null) {
            this.nFC = w.a(getWindow(), cU().cV().getCustomView());
        }
        View view = this.nFC;
        if (z) {
            if (i <= 0) {
                j = 240;
            }
            com.tencent.mm.ui.tools.j.a(view, j, 0.0f, null);
            return;
        }
        if (i <= 0) {
            j = 240;
        }
        com.tencent.mm.ui.tools.j.a(view, j, (float) ((view.getWidth() * -1) / 4), null);
    }

    public void Rj() {
        if (!isFinishing()) {
            finish();
        }
        this.dNj = false;
    }

    public void onCancel() {
        this.dNj = false;
    }

    public void Rk() {
        this.dNj = true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!bAm() || keyEvent.getKeyCode() != 4 || !this.nFw.bKu()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        v.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
        return true;
    }

    public boolean Ri() {
        return false;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (cU().cV() != null) {
            ViewGroup viewGroup = (ViewGroup) findViewById(f.Ji);
            if (viewGroup != null) {
                View findViewById = viewGroup.findViewById(f.IU);
                if (findViewById != null && (findViewById instanceof Toolbar)) {
                    Toolbar toolbar = (Toolbar) findViewById;
                    LayoutParams layoutParams = toolbar.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = com.tencent.mm.compatible.util.a.e(this);
                    }
                    toolbar.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public final void aR() {
        if (bzM() != null) {
            Object obj;
            p bzM = bzM();
            if (bzM.nDR.bAh()) {
                bzM.nDR.aR();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                return;
            }
        }
        super.aR();
    }
}
