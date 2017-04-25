package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.e.a.nm;
import com.tencent.mm.e.a.nw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.t;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;
import java.util.List;

public class SnsPermissionUI extends MMPreference implements e {
    public p dwg = null;
    private f dxf;
    private long jRA = 0;
    private boolean jRw = false;
    private u jRx = null;
    private boolean jRy = false;
    private boolean jRz = false;
    private int scene = 0;
    private String userName = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(291, this);
        this.userName = getIntent().getStringExtra("sns_permission_userName");
        this.jRw = getIntent().getBooleanExtra("sns_permission_anim", false);
        this.jRA = getIntent().getLongExtra("sns_permission_snsinfo_svr_id", 0);
        this.scene = getIntent().getIntExtra("sns_permission_block_scene", 0);
        v.d("MicroMsg.SnsPermissionUI", "SnsPermissionUI, scene:%d", new Object[]{Integer.valueOf(this.scene)});
        ak.yW();
        this.jRx = c.wH().LX(this.userName);
        if (this.jRx == null) {
            v.e("MicroMsg.SnsPermissionUI", "the error cause by get contact by %s", new Object[]{this.userName});
            finish();
        }
        this.jRx.setUsername(this.userName);
        NI();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        v.d("MicroMsg.SnsPermissionUI", "dispatchKeyEvent");
        setResult(-1, new Intent());
        finish();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        a.drq.ow();
        ak.vy().b(291, this);
        if (this.jRA != 0 && this.jRA != -1) {
            nm nmVar = new nm();
            nmVar.boE.boF = this.jRz;
            nmVar.boE.beL = this.jRA;
            com.tencent.mm.sdk.c.a.nhr.z(nmVar);
        }
    }

    public final int Oo() {
        return 2131099738;
    }

    protected final void NI() {
        this.dxf = this.ocZ;
        vD(2131235498);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsPermissionUI jRB;

            {
                this.jRB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jRB.axg();
                this.jRB.setResult(-1, new Intent());
                this.jRB.finish();
                return true;
            }
        });
        aXk();
    }

    private void aXk() {
        ak.yW();
        this.jRx = c.wH().LX(this.userName);
        this.jRx.setUsername(this.userName);
        boolean tO = this.jRx.tO();
        boolean Cc = Cc(this.userName);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("sns_outside_permiss");
        checkBoxPreference.ocf = tO;
        int i = this.jRx.bBZ;
        v.d("MicroMsg.SnsPermissionUI", "sex:%d", new Object[]{Integer.valueOf(i)});
        if (i == 1) {
            checkBoxPreference.setTitle(2131235496);
        } else if (i == 2) {
            checkBoxPreference.setTitle(2131235495);
        }
        checkBoxPreference = (CheckBoxPreference) this.dxf.Ow("sns_black_permiss");
        if (i == 1) {
            checkBoxPreference.setTitle(2131235379);
        } else if (i == 2) {
            checkBoxPreference.setTitle(2131235378);
        }
        checkBoxPreference.ocf = Cc;
        if (!com.tencent.mm.i.a.ei(this.jRx.field_type)) {
            this.dxf.Ox("sns_black_permiss");
        }
        this.dxf.notifyDataSetChanged();
    }

    private static boolean Cc(String str) {
        q df = ad.aSI().df(5);
        if (be.kS(df.field_memberList)) {
            return false;
        }
        return be.g(df.field_memberList.split(",")).contains(str);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.SnsPermissionUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + kVar.getType());
        if (kVar.getType() == 291) {
            v.d("MicroMsg.SnsPermissionUI", "tipDialog " + (this.dwg == null));
            if (this.dwg != null) {
                this.dwg.dismiss();
                this.dwg = null;
            }
            aXk();
            if (this.jRy) {
                this.jRz = true;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        nw nwVar;
        if (str.equals("sns_outside_permiss")) {
            nwVar = new nw();
            nwVar.boQ.boS = true;
            nwVar.boQ.boR = false;
            nwVar.boQ.username = this.userName;
            com.tencent.mm.sdk.c.a.nhr.z(nwVar);
            if (this.jRx.tO()) {
                m.i(this.jRx);
            } else {
                m.h(this.jRx);
            }
            return true;
        } else if (!str.equals("sns_black_permiss")) {
            return false;
        } else {
            int i;
            nwVar = new nw();
            nwVar.boQ.boS = false;
            nwVar.boQ.boR = true;
            nwVar.boQ.username = this.userName;
            com.tencent.mm.sdk.c.a.nhr.z(nwVar);
            boolean Cc = Cc(this.userName);
            String str2 = this.userName;
            if (Cc) {
                i = 2;
            } else {
                i = 1;
            }
            if (i == 1 && 5 == 5) {
                this.jRy = true;
                this.jRz = false;
            } else {
                this.jRy = false;
                this.jRz = false;
            }
            List linkedList = new LinkedList();
            linkedList.add(str2);
            final t tVar = new t(i, 5, "", linkedList.size(), linkedList, this.scene);
            ak.vy().a(tVar, 0);
            getString(2131231164);
            this.dwg = g.a(this, getString(2131235539), true, new OnCancelListener(this) {
                final /* synthetic */ SnsPermissionUI jRB;

                public final void onCancel(DialogInterface dialogInterface) {
                    this.jRB.onStop();
                    ak.vy().c(tVar);
                }
            });
            return true;
        }
    }
}
