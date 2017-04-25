package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.modelstat.j;
import com.tencent.mm.modelstat.l;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SettingsNetStatUI extends MMPreference {
    private f dxf;
    private long period;

    public final int Oo() {
        return 2131099727;
    }

    protected final boolean On() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onResume() {
        super.onResume();
        aNl();
    }

    protected final void NI() {
        vD(2131235174);
        l Km = p.Km();
        int buk = (int) (be.buk() / 86400000);
        if (Km.gm(buk) == null) {
            j jVar = new j();
            jVar.dcz = buk;
            jVar.id = -1;
            Km.b(jVar);
        }
        this.dxf = this.ocZ;
        this.period = p.Km().Kd();
        Preference Ow = this.dxf.Ow("settings_netstat_info");
        String format = new SimpleDateFormat(getString(2131232879), Locale.US).format(new Date(this.period));
        Ow.setTitle(getString(2131235172, new Object[]{format}));
        v.i("MicroMsg.SettingsNetStatUI", "title datatime = " + format);
        v.d("MicroMsg.SettingsNetStatUI", "title datatime = " + format);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsNetStatUI iMw;

            {
                this.iMw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMw.axg();
                this.iMw.finish();
                return true;
            }
        });
        a(0, getString(2131235175), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsNetStatUI iMw;

            {
                this.iMw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.a(this.iMw.nDR.nEl, 2131235176, 2131235177, new OnClickListener(this.iMw) {
                    final /* synthetic */ SettingsNetStatUI iMw;

                    {
                        this.iMw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        l Km = p.Km();
                        int buk = (int) (be.buk() / 86400000);
                        ar arVar = Km.ddn;
                        synchronized (arVar) {
                            arVar.gJW.trimToSize(-1);
                            arVar.nkG.clear();
                            arVar.aSW.QI();
                            arVar.nkI.QI();
                            arVar.aSZ = true;
                        }
                        Km.cuX.delete("netstat", null, null);
                        j jVar = new j();
                        jVar.dcz = buk;
                        jVar.id = -1;
                        Km.b(jVar);
                        this.iMw.aNl();
                    }
                }, new OnClickListener(this.iMw) {
                    final /* synthetic */ SettingsNetStatUI iMw;

                    {
                        this.iMw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
    }

    private void aNl() {
        j gn = p.Km().gn((int) (this.period / 86400000));
        if (gn == null) {
            gn = new j();
        }
        this.period = p.Km().Kd();
        Object[] objArr = new Object[]{""};
        this.dxf.Ow("settings_netstat_info").setTitle(getString(2131235172, new Object[]{DateFormat.format(getString(2131232879, objArr), this.period).toString()}));
        Preference Ow = this.dxf.Ow("settings_netstat_mobile");
        v.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic mobile out:%d in:%d", new Object[]{Integer.valueOf(gn.dcU), Integer.valueOf(gn.dcI)});
        Ow.setSummary(i(this, ((long) gn.dcU) + ((long) gn.dcI)));
        Ow = this.dxf.Ow("settings_netstat_wifi");
        v.i("MicroMsg.SettingsNetStatUI", "dknetflow updateFlowStatistic wifi out:%d in:%d", new Object[]{Integer.valueOf(gn.dcV), Integer.valueOf(gn.dcJ)});
        Ow.setSummary(i(this, ((long) gn.dcV) + ((long) gn.dcJ)));
        ((NetStatPreference) this.dxf.Ow("settings_netstat_mobile_detail")).iJI = false;
        ((NetStatPreference) this.dxf.Ow("settings_netstat_wifi_detail")).iJI = true;
        this.dxf.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    private static String i(Context context, long j) {
        return context.getString(2131235171, new Object[]{be.aw(j)});
    }
}
