package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.fj;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.HashMap;

public class SnsNotInterestUI extends MMPreference implements e {
    private static final String[] jQP = new String[]{"sns_expose_reason_not_fav", "sns_expose_reason_too_freq", "sns_expose_reason_too_many_same_content", "sns_expose_reason_marketing", "sns_expose_reason_content_sexy", "sns_expose_reason_rumour", "sns_expose_reason_other"};
    private static final int[] jQQ = new int[]{1, 2, 4, 8, 16, 32, 64};
    private static final int[] jQU = new int[]{2131235399, 2131235404, 2131235405, 2131235398, 2131235397, 2131235402, 2131235400};
    private p dFI = null;
    private f ezq;
    private String hZU = null;
    private HashMap<String, Boolean> jQR = new HashMap(jQP.length);
    private HashMap<Integer, Boolean> jQS = new HashMap(jQQ.length);
    private HashMap<String, Integer> jQT = new HashMap(jQQ.length);
    private TextView jQV;
    private EditText jQW;
    private ListView jQX;
    private LinearLayout jQY;
    private int jQZ;
    private int jRa;
    private long jRb;
    private boolean jRc = false;
    private boolean jRd = false;
    com.tencent.mm.plugin.sns.e.p jRe = null;

    static /* synthetic */ void b(SnsNotInterestUI snsNotInterestUI) {
        snsNotInterestUI.jRa = 0;
        for (Integer intValue : snsNotInterestUI.jQS.keySet()) {
            int intValue2 = intValue.intValue();
            if (((Boolean) snsNotInterestUI.jQS.get(Integer.valueOf(intValue2))).booleanValue()) {
                if (snsNotInterestUI.jRa == 0) {
                    snsNotInterestUI.jRa = intValue2;
                } else {
                    snsNotInterestUI.jRa |= intValue2;
                }
            }
        }
        if (snsNotInterestUI.jRb != 0 && snsNotInterestUI.jQZ != 0) {
            ActionBarActivity actionBarActivity = snsNotInterestUI.nDR.nEl;
            snsNotInterestUI.getString(2131231164);
            snsNotInterestUI.dFI = g.a(actionBarActivity, snsNotInterestUI.getString(2131231182), true, new OnCancelListener(snsNotInterestUI) {
                final /* synthetic */ SnsNotInterestUI jRf;

                {
                    this.jRf = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(this.jRf.jRe);
                }
            });
            v.d("MicroMsg.SnsNotInterestUI", "start send not inteset, snsId:%d, scene:%d, type:%d, isNeedSupplement:%b", new Object[]{Long.valueOf(snsNotInterestUI.jRb), Integer.valueOf(snsNotInterestUI.jQZ), Integer.valueOf(snsNotInterestUI.jRa), Boolean.valueOf(snsNotInterestUI.jRd)});
            snsNotInterestUI.jRe = new com.tencent.mm.plugin.sns.e.p(snsNotInterestUI.jRb, snsNotInterestUI.jQZ, snsNotInterestUI.jRa, snsNotInterestUI.jRd ? snsNotInterestUI.jQW.getText().toString() : null);
            ak.vy().a(snsNotInterestUI.jRe, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jQZ = getIntent().getIntExtra("sns_info_not_interest_scene", 0);
        this.jRb = getIntent().getLongExtra("sns_info_svr_id", 0);
        if (this.jRb != 0) {
            String str = ad.aSE().dd(this.jRb).field_userName;
            if (str != null) {
                ak.yW();
                u LW = c.wH().LW(str);
                if (LW.bBZ == 2) {
                    jQU[1] = 2131235403;
                } else if (LW.bBZ == 1) {
                    jQU[1] = 2131235404;
                }
            }
        }
        ak.vy().a(218, this);
        aXj();
        NI();
    }

    private void aXj() {
        int i = 0;
        for (Object put : jQP) {
            this.jQR.put(put, Boolean.valueOf(false));
        }
        for (int valueOf : jQQ) {
            this.jQS.put(Integer.valueOf(valueOf), Boolean.valueOf(false));
        }
        while (i < jQQ.length) {
            this.jQT.put(jQP[i], Integer.valueOf(jQQ[i]));
            i++;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        aXj();
        ak.vy().b(218, this);
        fj fjVar = new fj();
        fjVar.beJ.beK = this.jRc;
        fjVar.beJ.beL = this.jRb;
        a.nhr.z(fjVar);
    }

    protected final void NI() {
        super.NI();
        vD(2131235408);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsNotInterestUI jRf;

            {
                this.jRf = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jRf.finish();
                return true;
            }
        });
        this.jQV = (TextView) findViewById(2131759339);
        this.jQW = (EditText) findViewById(2131759340);
        this.jQX = (ListView) findViewById(16908298);
        this.jQY = (LinearLayout) findViewById(2131759338);
        this.jQY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsNotInterestUI jRf;

            {
                this.jRf = r1;
            }

            public final void onClick(View view) {
                this.jRf.jQY.requestFocus();
                this.jRf.axg();
            }
        });
        this.jQW.setVisibility(8);
        this.jQV.setVisibility(8);
        this.ezq = this.ocZ;
        if (this.ezq == null) {
            v.e("MicroMsg.SnsNotInterestUI", "initPref error, PreferenceScreen is null!");
        } else {
            if (this.ezq.Ow("sns_expose_desc") == null) {
                PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(this);
                preferenceTitleCategory.setTitle(2131235395);
                preferenceTitleCategory.setKey("sns_expose_desc");
                this.ezq.a(preferenceTitleCategory);
            }
            for (int i = 0; i < jQP.length; i++) {
                String str = jQP[i];
                int i2 = jQU[i];
                if (this.ezq.Ow(str) == null) {
                    Preference preference = new Preference(this);
                    preference.setTitle(i2);
                    preference.setKey(str);
                    preference.setLayoutResource(2130903996);
                    preference.setWidgetLayoutResource(2130904004);
                    this.ezq.a(preference);
                }
            }
        }
        a(0, getString(2131231489), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsNotInterestUI jRf;

            {
                this.jRf = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsNotInterestUI.b(this.jRf);
                return true;
            }
        }, b.nET);
        U(0, false);
    }

    protected final int getLayoutId() {
        return 2130904449;
    }

    public final int Oo() {
        return -1;
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference == null) {
            return false;
        }
        String str = preference.dnU;
        if (!this.jQR.containsKey(str)) {
            return false;
        }
        boolean z;
        boolean booleanValue = ((Boolean) this.jQR.get(str)).booleanValue();
        if (booleanValue) {
            preference.setWidgetLayoutResource(2130904004);
        } else {
            preference.setWidgetLayoutResource(2130904003);
        }
        fVar.notifyDataSetChanged();
        if (booleanValue) {
            z = false;
        } else {
            z = true;
        }
        this.jQR.put(str, Boolean.valueOf(z));
        this.jQS.put(Integer.valueOf(((Integer) this.jQT.get(str)).intValue()), Boolean.valueOf(z));
        v.d("MicroMsg.SnsNotInterestUI", "click: %s, notInterestType: %d, isCheck: %b", new Object[]{str, Integer.valueOf(r0), Boolean.valueOf(z)});
        for (Boolean booleanValue2 : this.jQR.values()) {
            if (booleanValue2.booleanValue()) {
                booleanValue = true;
                break;
            }
        }
        booleanValue = false;
        if (booleanValue) {
            U(0, true);
        } else {
            U(0, false);
        }
        if (z && str.equals("sns_expose_reason_other")) {
            this.jQW.setVisibility(0);
            this.jQV.setVisibility(0);
            this.jQW.requestFocus();
            this.jRd = true;
            aJs();
        } else if (((Boolean) this.jQR.get("sns_expose_reason_other")).booleanValue()) {
            this.jQX.requestFocus();
            axg();
        } else {
            this.jQW.setVisibility(8);
            this.jQV.setVisibility(8);
            this.jQX.requestFocus();
            this.jRd = false;
            axg();
        }
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.SnsNotInterestUI", "onSceneEnd, errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar.getType() == 218) {
            this.dFI.dismiss();
            this.dFI = null;
            if (((com.tencent.mm.plugin.sns.e.p) kVar).type != 9) {
                return;
            }
            if (i == 0 && i2 == 0) {
                this.jRc = true;
                Toast.makeText(this, 2131235407, 1).show();
                finish();
                return;
            }
            this.jRc = false;
            Toast.makeText(this, 2131235396, 1).show();
        }
    }
}
