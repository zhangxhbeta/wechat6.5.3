package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ak.j.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class NearbyPersonalInfoUI extends MMPreference {
    private int bBZ = -1;
    private f dxf;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131234011);
        this.dxf = this.ocZ;
        ((KeyValuePreference) this.dxf.Ow("settings_signature")).ocP = false;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyPersonalInfoUI hFO;

            {
                this.hFO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hFO.finish();
                return true;
            }
        });
        a(0, getString(2131231103), new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyPersonalInfoUI hFO;

            {
                this.hFO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                bf zO;
                if (this.hFO.bBZ != -1) {
                    zO = bf.zO();
                    zO.bBZ = this.hFO.bBZ;
                    bf.a(zO);
                }
                zO = bf.zP();
                if (zO == null) {
                    g.a(this.hFO.nDR.nEl, 2131234012, 2131231164, new OnClickListener(this.hFO) {
                        final /* synthetic */ NearbyPersonalInfoUI hFO;

                        {
                            this.hFO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    String ma = be.ma(zO.getProvince());
                    be.ma(zO.getCity());
                    int i = zO.bBZ;
                    if (be.kS(ma) || i == 0) {
                        g.a(this.hFO.nDR.nEl, 2131234012, 2131231164, /* anonymous class already generated */);
                    } else {
                        this.hFO.startActivity(new Intent(this.hFO, NearbyFriendsUI.class));
                        bf zO2 = bf.zO();
                        if (i != -1) {
                            zO2.bBZ = i;
                        }
                        ak.yW();
                        c.wG().b(new a(1, bf.a(zO2)));
                        this.hFO.finish();
                    }
                }
                return true;
            }
        });
        ((ChoicePreference) this.dxf.Ow("settings_sex")).ock = new Preference.a(this) {
            final /* synthetic */ NearbyPersonalInfoUI hFO;

            {
                this.hFO = r1;
            }

            public final boolean a(Preference preference, Object obj) {
                String str = (String) obj;
                if ("male".equalsIgnoreCase(str)) {
                    this.hFO.bBZ = 1;
                } else if ("female".equalsIgnoreCase(str)) {
                    this.hFO.bBZ = 2;
                }
                return false;
            }
        };
        ak.yW();
        int a = be.a((Integer) c.vf().get(12290, null), 0);
        ChoicePreference choicePreference = (ChoicePreference) this.dxf.Ow("settings_sex");
        choicePreference.setTitle(Html.fromHtml(getString(2131235140) + "<font color='red'>*</font>"));
        switch (a) {
            case 1:
                choicePreference.setValue("male");
                return;
            case 2:
                choicePreference.setValue("female");
                return;
            default:
                choicePreference.setValue("unknown");
                return;
        }
    }

    public void onResume() {
        bf zO = bf.zO();
        String province = zO.getProvince();
        String city = zO.getCity();
        Preference Ow = this.dxf.Ow("settings_district");
        Ow.setSummary(l.eu(province) + " " + city);
        Ow.setTitle(Html.fromHtml(getString(2131235002) + "<font color='red'>*</font>"));
        Preference Ow2 = this.dxf.Ow("settings_signature");
        ak.yW();
        CharSequence ma = be.ma((String) c.vf().get(12291, null));
        if (ma.length() <= 0) {
            ma = getString(2131235144);
        }
        Ow2.setSummary(e.a(this, ma));
        super.onResume();
    }

    public final int Oo() {
        return 2131099704;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if ("settings_district".equals(str)) {
            com.tencent.mm.plugin.nearby.a.drp.b(null, this);
            return true;
        } else if (!"settings_signature".equals(str)) {
            return false;
        } else {
            com.tencent.mm.plugin.nearby.a.drp.c(null, this);
            overridePendingTransition(2130968646, 2130968645);
            return true;
        }
    }
}
