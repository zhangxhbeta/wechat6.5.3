package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.e.s;
import com.tencent.mm.plugin.sns.e.t;
import com.tencent.mm.plugin.sns.e.u;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsTagDetailUI extends MMPreference implements b, e {
    protected String aZy = "";
    protected p dwg = null;
    protected f dxf;
    protected ContactListExpandPreference ePg;
    protected List<String> jTC = new ArrayList();
    protected String jTD = "";
    private boolean jTE = false;
    protected a jTF = new a(this) {
        final /* synthetic */ SnsTagDetailUI jTG;

        {
            this.jTG = r1;
        }

        public final void jo(int i) {
            String tY = this.jTG.ePg.tY(i);
            v.d("MicroMsg.SnsTagDetailUI", "roomPref del " + i + " userName : " + tY);
            ak.yW();
            if (be.ah((String) c.vf().get(2, null), "").equals(tY)) {
                g.f(this.jTG.nDR.nEl, 2131234595, 2131231164);
                return;
            }
            this.jTG.qM(tY);
            if (!(this.jTG.jTD + " " + be.b(this.jTG.jTC, ",")).equals(this.jTG.aZy) || this.jTG.jkF == 0) {
                this.jTG.iT(true);
            } else {
                this.jTG.iT(false);
            }
        }

        public final void jq(int i) {
            v.d("MicroMsg.SnsTagDetailUI", "roomPref add " + i);
            SnsTagDetailUI.a(this.jTG);
        }

        public final void jp(int i) {
            String tY = this.jTG.ePg.tY(i);
            Intent intent = new Intent();
            intent.setClass(this.jTG, SnsUserUI.class);
            Intent e = ad.aSu().e(intent, tY);
            if (e == null) {
                this.jTG.finish();
                return;
            }
            this.jTG.startActivity(e);
            if ((e.getFlags() & 67108864) != 0) {
                this.jTG.finish();
            }
        }

        public final void adp() {
            if (this.jTG.ePg != null) {
                this.jTG.ePg.bpp();
            }
        }
    };
    protected long jkF;
    protected int scene = 0;

    static /* synthetic */ void a(SnsTagDetailUI snsTagDetailUI) {
        String b = be.b(snsTagDetailUI.jTC, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", snsTagDetailUI.getString(2131230883));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", r.s(new int[]{r.oHJ, 1024}));
        intent.putExtra("always_select_contact", b);
        com.tencent.mm.ay.c.a(snsTagDetailUI, ".ui.contact.SelectContactUI", intent, 1);
    }

    protected void aWw() {
        v.d("MicroMsg.SnsTagDetailUI", "Base __onCreate");
        ak.vy().a(290, this);
        ak.vy().a(291, this);
        ak.vy().a(292, this);
        ak.vy().a(293, this);
        ak.yW();
        c.wH().a(this);
        if (ad.aSI().aVi().size() == 0) {
            ak.vy().a(new s(), 0);
            this.jTE = true;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aWw();
        this.scene = getIntent().getIntExtra("k_tag_detail_sns_block_scene", 0);
        this.jkF = getIntent().getLongExtra("k_sns_tag_id", 0);
        if (this.jkF == 4) {
            this.jTD = getString(2131235532);
        } else if (this.jkF == 5) {
            this.jTD = getString(2131235543);
        } else {
            this.jTD = ad.aSI().df(this.jkF).field_tagName;
        }
        if (this.jkF == 0) {
            String stringExtra = getIntent().getStringExtra("k_sns_tag_list");
            this.jTD = be.ah(getIntent().getStringExtra("k_sns_tag_name"), "");
            aa aSs = ad.aSs();
            String xF = k.xF();
            List<String> g = be.g(stringExtra.split(","));
            if (g != null) {
                for (String stringExtra2 : g) {
                    if (!(this.jTC.contains(stringExtra2) || !com.tencent.mm.i.a.ei(aSs.LX(stringExtra2).field_type) || xF.equals(stringExtra2))) {
                        this.jTC.add(stringExtra2);
                    }
                }
            }
        } else {
            this.jTC = aWz();
        }
        if (this.jTD == null || this.jTD.equals("")) {
            this.jTD = getString(2131235531);
            this.jTD = ah.Av(getString(2131235531));
        }
        NI();
        aXs();
        adg();
        if (this.jkF < 6) {
            this.dxf.Ox("delete_tag_name");
            this.dxf.Ox("delete_tag_name_category");
            if (this.jkF > 0) {
                this.dxf.Ox("settings_tag_name");
                this.dxf.Ox("settings_tag_name_category");
            }
        }
        if (this.jkF == 4) {
            this.dxf.Ox("black");
            this.dxf.Ox("group");
        } else if (this.jkF == 5) {
            this.dxf.Ox("outside");
            this.dxf.Ox("group");
        } else {
            this.dxf.Ox("black");
            this.dxf.Ox("outside");
        }
        if (this.jkF == 0) {
            iT(true);
        } else {
            iT(false);
        }
        this.aZy = this.jTD + " " + be.b(this.jTC, ",");
    }

    protected void aWx() {
        v.d("MicroMsg.SnsTagDetailUI", "Base __onDestroy");
        ak.vy().b(290, this);
        ak.vy().b(291, this);
        ak.vy().b(292, this);
        ak.vy().b(293, this);
        if (ak.uz()) {
            ak.yW();
            c.wH().b(this);
        }
    }

    public void onDestroy() {
        if (this.dwg != null) {
            this.dwg.dismiss();
        }
        aWx();
        super.onDestroy();
    }

    public final void a(int i, j jVar, Object obj) {
    }

    public final int Oo() {
        return 2131099740;
    }

    public void onResume() {
        super.onResume();
        aXs();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        if (str.equals("settings_tag_name") && (this.jkF >= 6 || this.jkF == 0)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_mode_name_type", 3);
            intent.putExtra("Contact_Nick", be.ah(this.jTD, " "));
            com.tencent.mm.plugin.sns.b.a.drp.a(intent, this);
        }
        if (str.equals("delete_tag_name")) {
            g.a(this, 2131234928, 2131231164, new OnClickListener(this) {
                final /* synthetic */ SnsTagDetailUI jTG;

                {
                    this.jTG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.jTG.aWy();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ SnsTagDetailUI jTG;

                {
                    this.jTG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        return false;
    }

    protected final void adg() {
        Fd(this.jTD + "(" + this.jTC.size() + ")");
    }

    private void aXs() {
        Preference Ow = this.dxf.Ow("settings_tag_name");
        if (Ow != null) {
            if (this.jTD.length() > 20) {
                this.jTD = this.jTD.substring(0, 20);
            }
            Ow.setSummary(this.jTD);
            this.dxf.notifyDataSetChanged();
        }
    }

    protected void aWy() {
        if (this.jkF != 0) {
            ak.vy().a(new u(this.jkF, this.jTD), 0);
        }
        getString(2131231164);
        this.dwg = g.a(this, getString(2131235539), true, new OnCancelListener(this) {
            final /* synthetic */ SnsTagDetailUI jTG;

            {
                this.jTG = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    protected final void NI() {
        this.dxf = this.ocZ;
        this.ePg = (ContactListExpandPreference) this.dxf.Ow("roominfo_contact_anchor");
        if (this.ePg != null) {
            this.ePg.a(this.dxf, this.ePg.dnU);
            this.ePg.hZ(true).ia(true);
            this.ePg.j(null, this.jTC);
            this.ePg.a(new com.tencent.mm.pluginsdk.ui.applet.f.b(this) {
                final /* synthetic */ SnsTagDetailUI jTG;

                {
                    this.jTG = r1;
                }

                public final boolean jn(int i) {
                    boolean tV;
                    ContactListExpandPreference contactListExpandPreference = this.jTG.ePg;
                    if (contactListExpandPreference.lKE != null) {
                        tV = contactListExpandPreference.lKE.lJM.tV(i);
                    } else {
                        tV = true;
                    }
                    if (!tV) {
                        v.d("MicroMsg.SnsTagDetailUI", "onItemLongClick " + i);
                    }
                    return true;
                }
            });
            this.ePg.a(this.jTF);
        }
        getIntent().getIntExtra("k_sns_from_settings_about_sns", 0);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagDetailUI jTG;

            {
                this.jTG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!(this.jTG.jTD + " " + be.b(this.jTG.jTC, ",")).equals(this.jTG.aZy) || this.jTG.jkF == 0) {
                    g.a(this.jTG, 2131235522, 2131231164, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass5 jTH;

                        {
                            this.jTH = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.jTH.jTG.finish();
                        }
                    }, null);
                } else {
                    this.jTG.finish();
                }
                return true;
            }
        });
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsTagDetailUI jTG;

            {
                this.jTG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jTG.axe();
                return true;
            }
        }, com.tencent.mm.ui.k.b.nET);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!(this.jTD + " " + be.b(this.jTC, ",")).equals(this.aZy) || this.jkF == 0) {
            g.a(this, 2131235522, 2131231164, new OnClickListener(this) {
                final /* synthetic */ SnsTagDetailUI jTG;

                {
                    this.jTG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.jTG.finish();
                }
            }, null);
        } else {
            finish();
        }
        return true;
    }

    protected void axe() {
        if ((this.jTD + " " + be.b(this.jTC, ",")).equals(this.aZy) && this.jkF != 0) {
            finish();
        } else if (ad.aSI().j(this.jkF, this.jTD)) {
            g.A(this, getString(2131235525, new Object[]{this.jTD}), getString(2131231164));
        } else {
            final t tVar = new t(3, this.jkF, this.jTD, this.jTC.size(), this.jTC, this.scene);
            ak.vy().a(tVar, 0);
            getString(2131231164);
            this.dwg = g.a(this, getString(2131235539), true, new OnCancelListener(this) {
                final /* synthetic */ SnsTagDetailUI jTG;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(tVar);
                }
            });
        }
    }

    protected List<String> aWz() {
        List<String> linkedList = new LinkedList();
        q df = ad.aSI().df(this.jkF);
        if (df.field_memberList == null || df.field_memberList.equals("")) {
            return linkedList;
        }
        return be.g(df.field_memberList.split(","));
    }

    protected void qM(String str) {
        if (str != null && !str.equals("")) {
            this.jTC.remove(str);
            if (this.ePg != null) {
                this.ePg.aH(this.jTC);
                this.ePg.notifyChanged();
            }
            if (this.jTC.size() == 0 && this.ePg != null) {
                this.ePg.bpp();
                this.ePg.hZ(true).ia(false);
                this.dxf.notifyDataSetChanged();
            } else if (this.ePg != null) {
                this.ePg.hZ(true).ia(true);
            }
            adg();
        }
    }

    protected void bx(List<String> list) {
        aa aSs = ad.aSs();
        String xF = k.xF();
        for (String str : list) {
            if (!(this.jTC.contains(str) || !com.tencent.mm.i.a.ei(aSs.LX(str).field_type) || xF.equals(str))) {
                this.jTC.add(str);
            }
        }
        if (this.ePg != null) {
            this.ePg.aH(this.jTC);
            this.ePg.notifyChanged();
        }
        if (this.jTC.size() > 0) {
            this.ePg.hZ(true).ia(true);
        } else {
            this.ePg.hZ(true).ia(false);
        }
        adg();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            String stringExtra;
            switch (i) {
                case 1:
                    if (intent != null) {
                        boolean z;
                        String stringExtra2 = intent.getStringExtra("Select_Contact");
                        if (be.ma(k.xF()).equals(stringExtra2)) {
                            z = true;
                        } else if (this.jTC == null) {
                            z = false;
                        } else {
                            z = false;
                            for (String stringExtra3 : this.jTC) {
                                boolean z2;
                                if (stringExtra3.equals(stringExtra2)) {
                                    z2 = true;
                                } else {
                                    z2 = z;
                                }
                                z = z2;
                            }
                        }
                        if (z) {
                            g.A(this, getString(2131230816, new Object[]{Integer.valueOf(0), Integer.valueOf(0)}), getString(2131231164));
                            return;
                        }
                        List g = be.g(stringExtra2.split(","));
                        if (g != null) {
                            bx(g);
                            break;
                        }
                        return;
                    }
                    return;
                case 2:
                    stringExtra3 = intent.getStringExtra("k_sns_tag_name");
                    if (stringExtra3 != null) {
                        this.jTD = stringExtra3;
                    }
                    adg();
                    v.d("MicroMsg.SnsTagDetailUI", "updateName " + this.jTD);
                    break;
                default:
                    return;
            }
            if (!(this.jTD + " " + be.b(this.jTC, ",")).equals(this.aZy) || this.jkF == 0) {
                iT(true);
            } else {
                iT(false);
            }
        }
    }

    public void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.SnsTagDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwg != null) {
            this.dwg.dismiss();
        }
        switch (kVar.getType()) {
            case 290:
                finish();
                return;
            case 291:
                finish();
                return;
            case 292:
                if (this.ePg != null && this.jTE && !(this instanceof SnsBlackDetailUI)) {
                    v.d("MicroMsg.SnsTagDetailUI", "update form net");
                    this.aZy = this.jTD + " " + be.b(((s) kVar).cN(this.jkF), ",");
                    LinkedList linkedList = new LinkedList();
                    List<String> list = this.jTC;
                    this.jTC = aWz();
                    if (list != null) {
                        for (String str2 : list) {
                            if (!this.jTC.contains(str2)) {
                                this.jTC.add(str2);
                            }
                        }
                    }
                    this.ePg.aH(this.jTC);
                    this.ePg.notifyChanged();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
