package com.tencent.mm.ui.account.bind;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ak.j.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.HashMap;
import java.util.Map.Entry;

public class BindMobileStatusUI extends MMWizardActivity {
    private SharedPreferences cnm;
    private Button emR;
    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Integer> euP = new HashMap();
    private ImageView nMR;
    private TextView nMS;
    private TextView nMT;
    private ImageView nMU;
    private ImageView nMV;
    private Boolean nMW = Boolean.valueOf(true);
    private Boolean nMX = Boolean.valueOf(true);
    private RelativeLayout nMY;
    private RelativeLayout nMZ;
    private BindWordingContent nNa;
    private int nNb;
    private boolean nNc;
    private boolean nNd;
    private SparseArray<String> nNe = new SparseArray(3);
    private int status;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = k.xJ();
        this.nNe.put(8, "settings_find_me_by_mobile");
        this.nNe.put(7, "settings_recommend_mobilefriends_to_me");
        this.nNe.put(32, "settings_autoadd_mobilefriends");
        e(false, 512, 8);
        e(false, 256, 7);
        vD(2131231428);
        this.nNa = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.nNb = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.nNc = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.nNd = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        NI();
    }

    protected final int getLayoutId() {
        return 2130903166;
    }

    protected void onPause() {
        ak.yW();
        c.vf().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.euP.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            rc rcVar = new rc();
            rcVar.muR = intValue;
            rcVar.muS = intValue2;
            ak.yW();
            c.wG().b(new a(23, rcVar));
            v.d("MicroMsg.BindMobileStatusUI", "switch  " + intValue + " " + intValue2);
        }
        this.euP.clear();
        super.onPause();
    }

    private boolean e(boolean z, int i, int i2) {
        v.d("MicroMsg.BindMobileStatusUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.euP.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        String str = (String) this.nNe.get(i2);
        if (!(this.cnm == null || str == null || str.length() <= 0)) {
            Boolean valueOf = Boolean.valueOf(z);
            if (i2 == 8 || i2 == 7) {
                valueOf = Boolean.valueOf(!z);
            }
            this.cnm.edit().putBoolean(str, valueOf.booleanValue()).commit();
        }
        return true;
    }

    protected final void NI() {
        boolean z = true;
        this.nMR = (ImageView) findViewById(2131755585);
        this.nMT = (TextView) findViewById(2131755586);
        this.nMS = (TextView) findViewById(2131755587);
        this.emR = (Button) findViewById(2131755588);
        this.nMU = (ImageView) findViewById(2131755590);
        this.nMV = (ImageView) findViewById(2131755592);
        this.nMY = (RelativeLayout) findViewById(2131755589);
        this.nMZ = (RelativeLayout) findViewById(2131755591);
        switch (this.nNb) {
            case 0:
                boolean z2;
                this.nMY.setVisibility(8);
                this.nMZ.setVisibility(8);
                if (this.nNc) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                e(z2, 512, 8);
                if (this.nNd) {
                    z = false;
                }
                e(z, 256, 7);
                break;
            case 1:
                this.nMY.setVisibility(0);
                this.nMY.setBackgroundResource(2130837714);
                this.nMZ.setVisibility(8);
                break;
        }
        if (this.nNa != null) {
            switch (this.nNa.cYh.intValue()) {
                case 2:
                    this.nMS.setVisibility(8);
                    break;
            }
        }
        this.emR.setVisibility(8);
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ BindMobileStatusUI nNf;

            {
                this.nNf = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nNf.bAv();
                return false;
            }
        });
        if (m.EY() == m.a.cHR || m.EY() == m.a.cHS) {
            this.nMR.setImageResource(2130837710);
            ak.yW();
            String str = (String) c.vf().get(6, null);
            if (str == null || str.equals("")) {
                ak.yW();
                c.vf().get(4097, null);
            }
        } else {
            this.nMR.setImageResource(2130837707);
            this.nMS.setVisibility(8);
            this.nMT.setText(getString(2131231388));
        }
        this.nMU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMobileStatusUI nNf;

            {
                this.nNf = r1;
            }

            public final void onClick(View view) {
                boolean z = true;
                this.nNf.nMW = Boolean.valueOf(!this.nNf.nMW.booleanValue());
                if (this.nNf.nMW.booleanValue()) {
                    this.nNf.nMU.setImageResource(2131165400);
                } else {
                    this.nNf.nMU.setImageResource(2131165403);
                }
                BindMobileStatusUI bindMobileStatusUI = this.nNf;
                if (this.nNf.nMW.booleanValue()) {
                    z = false;
                }
                bindMobileStatusUI.e(z, 512, 8);
            }
        });
        this.nMV.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMobileStatusUI nNf;

            {
                this.nNf = r1;
            }

            public final void onClick(View view) {
                boolean z = true;
                this.nNf.nMX = Boolean.valueOf(!this.nNf.nMX.booleanValue());
                if (this.nNf.nMX.booleanValue()) {
                    this.nNf.nMV.setImageResource(2131165400);
                } else {
                    this.nNf.nMV.setImageResource(2131165403);
                }
                BindMobileStatusUI bindMobileStatusUI = this.nNf;
                if (this.nNf.nMX.booleanValue()) {
                    z = false;
                }
                bindMobileStatusUI.e(z, 256, 7);
                if (!this.nNf.nMX.booleanValue()) {
                    this.nNf.e(false, 2097152, 32);
                }
            }
        });
        this.emR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BindMobileStatusUI nNf;

            {
                this.nNf = r1;
            }

            public final void onClick(View view) {
                this.nNf.bAv();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        bAv();
        return true;
    }

    public static void b(Context context, boolean z, boolean z2) {
        boolean z3 = false;
        int i = 1;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        sharedPreferences.edit().putBoolean("settings_find_me_by_mobile", !z).commit();
        Editor edit = sharedPreferences.edit();
        String str = "settings_recommend_mobilefriends_to_me";
        if (!z2) {
            z3 = true;
        }
        edit.putBoolean(str, z3).commit();
        int xJ = k.xJ();
        xJ = z ? xJ | 512 : xJ & -513;
        xJ = z2 ? xJ | 256 : xJ & -257;
        ak.yW();
        c.vf().set(7, Integer.valueOf(xJ));
        rc rcVar = new rc();
        rcVar.muR = 8;
        if (z2) {
            xJ = 1;
        } else {
            xJ = 2;
        }
        rcVar.muS = xJ;
        ak.yW();
        c.wG().b(new a(23, rcVar));
        rc rcVar2 = new rc();
        rcVar2.muR = 7;
        if (!z) {
            i = 2;
        }
        rcVar.muS = i;
        ak.yW();
        c.wG().b(new a(23, rcVar2));
        com.tencent.mm.plugin.a.a.drq.ow();
    }
}
