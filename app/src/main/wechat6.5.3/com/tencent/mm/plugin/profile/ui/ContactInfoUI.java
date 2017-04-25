package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.ar.h;
import com.tencent.mm.ar.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public class ContactInfoUI extends MMPreference implements a, b, bb.a {
    private f dxf;
    private String ePn = "";
    private u euW;
    private com.tencent.mm.pluginsdk.c.a hTX;
    private boolean hTY;
    private boolean hTZ;
    private int hUa;
    private String hUb;
    private byte[] hUc;
    private boolean hUd = false;
    String hUe = null;
    private String hUf = "";
    private boolean hUg = false;

    public final int Oo() {
        return 2131099688;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hUe = getIntent().getStringExtra("Contact_Search_Mobile");
        ak.yW();
        c.wH().a(this);
        ak.yW();
        c.wI().a(this);
        NI();
    }

    public void onDestroy() {
        ak.yW();
        c.wH().b(this);
        ak.yW();
        c.wI().b(this);
        if (this.hTX != null) {
            this.hTX.XS();
        }
        if (j.ak.lye != null) {
            j.ak.lye.M(this);
        }
        super.onDestroy();
    }

    public void onResume() {
        d.a(3, "ContactInfoUI" + avS(), hashCode());
        com.tencent.mm.modelbiz.u.Dy().c(this);
        super.onResume();
        View focusedChild = ((ViewGroup) this.nDR.dtW).getFocusedChild();
        if (focusedChild != null) {
            focusedChild.clearFocus();
            v.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[]{Integer.valueOf(focusedChild.getId())});
        }
    }

    protected void onRestart() {
        super.onRestart();
        this.hUg = false;
    }

    public void onPause() {
        d.a(4, "ContactInfoUI" + avS(), hashCode());
        com.tencent.mm.modelbiz.u.Dy().d(this);
        super.onPause();
        ak.vA().A(new Runnable(this) {
            final /* synthetic */ ContactInfoUI hUh;

            {
                this.hUh = r1;
            }

            public final void run() {
                ak.yW();
                c.vf().iB(true);
            }
        });
    }

    protected final String avS() {
        if (this.euW == null || ((int) this.euW.chr) == 0 || be.kS(this.euW.field_username)) {
            return "";
        }
        v.i("MicroMsg.ContactInfoUI", "getIdentString %s", new Object[]{this.euW.field_username});
        if (e.hC(this.euW.field_username)) {
            return "_EnterpriseChat";
        }
        if (e.hB(this.euW.field_username)) {
            return "_EnterpriseFatherBiz";
        }
        if (e.hA(this.euW.field_username)) {
            return "_EnterpriseChildBiz";
        }
        if (this.euW.bvm()) {
            return "_bizContact";
        }
        if (m.dE(this.euW.field_username)) {
            return "_chatroom";
        }
        if (m.ew(this.euW.field_username)) {
            return "_bottle";
        }
        if (m.ex(this.euW.field_username)) {
            return "_QQ";
        }
        if (m.fn(this.euW.field_username)) {
            return "_" + this.euW.field_username;
        }
        return "";
    }

    protected final void NI() {
        String str;
        this.dxf = this.ocZ;
        this.dxf.removeAll();
        this.hUa = getIntent().getIntExtra("Contact_Scene", 9);
        this.hUb = getIntent().getStringExtra("Verify_ticket");
        this.hTY = getIntent().getBooleanExtra("Chat_Readonly", false);
        this.hTZ = getIntent().getBooleanExtra("User_Verify", false);
        this.ePn = getIntent().getStringExtra("Contact_ChatRoomId");
        String ma = be.ma(getIntent().getStringExtra("Contact_User"));
        String ma2 = be.ma(getIntent().getStringExtra("Contact_Alias"));
        String ma3 = be.ma(getIntent().getStringExtra("Contact_Encryptusername"));
        if (ma.endsWith("@stranger")) {
            ma3 = ma;
        }
        ak.yW();
        this.euW = c.wH().LX(ma);
        if (this.euW != null) {
            this.euW.nul = ma;
        }
        com.tencent.mm.plugin.profile.a.drq.a(this.euW);
        String stringExtra = getIntent().getStringExtra("Contact_Nick");
        int intExtra = getIntent().getIntExtra("Contact_Sex", 0);
        String stringExtra2 = getIntent().getStringExtra("Contact_Province");
        String stringExtra3 = getIntent().getStringExtra("Contact_City");
        String stringExtra4 = getIntent().getStringExtra("Contact_Signature");
        int intExtra2 = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
        String stringExtra5 = getIntent().getStringExtra("Contact_VUser_Info");
        String stringExtra6 = getIntent().getStringExtra("Contact_Distance");
        int intExtra3 = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
        String stringExtra7 = getIntent().getStringExtra("Contact_KWeibo");
        String stringExtra8 = getIntent().getStringExtra("Contact_KWeiboNick");
        String stringExtra9 = getIntent().getStringExtra("Contact_KFacebookName");
        long longExtra = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.hUf = getIntent().getStringExtra("Contact_BrandIconURL");
        String stringExtra10 = getIntent().getStringExtra("Contact_RegionCode");
        this.hUc = getIntent().getByteArrayExtra("Contact_customInfo");
        boolean booleanExtra = getIntent().getBooleanExtra("force_get_contact", false);
        if (booleanExtra) {
            v.d("MicroMsg.ContactInfoUI", "initView, forceAddContact, user = " + ma);
            if (this.euW == null || !com.tencent.mm.i.a.ei(this.euW.field_type)) {
                ab.a.crZ.I(ma, "");
            } else {
                ab.a.crZ.I(ma, this.ePn);
            }
        }
        if (this.euW != null && ((int) this.euW.chr) > 0 && (!m.fo(this.euW.field_username) || (u.LJ(this.euW.field_username) && !m.eB(this.euW.field_username)))) {
            BizInfo hw = e.hw(this.euW.field_username);
            Object obj = (this.euW.bvm() && com.tencent.mm.modelbiz.a.Cq()) ? 1 : null;
            if (hw == null || (hw.Ct() && obj == null)) {
                v.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[]{Integer.valueOf(intExtra2)});
                ab.a.crZ.I(this.euW.field_username, com.tencent.mm.i.a.ei(this.euW.field_type) ? "" : this.ePn);
                com.tencent.mm.u.b.gC(this.euW.field_username);
            } else if (this.euW.bvp() && obj == null) {
                v.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[]{Integer.valueOf(this.euW.bCr)});
                ab.c cVar = ab.a.crZ;
                String str2 = this.euW.field_username;
                if (com.tencent.mm.i.a.ei(this.euW.field_type)) {
                    str = "";
                } else {
                    str = this.ePn;
                }
                cVar.I(str2, str);
                com.tencent.mm.u.b.gC(this.euW.field_username);
            }
        }
        int intExtra4 = getIntent().getIntExtra("Contact_verify_Scene", 9);
        if (this.euW == null || ((int) this.euW.chr) == 0 || be.ma(this.euW.field_username).length() <= 0) {
            this.euW = new u();
            this.euW.setUsername(ma);
            this.euW.bP(ma2);
            this.euW.bS(stringExtra);
            this.euW.bT(getIntent().getStringExtra("Contact_PyInitial"));
            this.euW.bU(getIntent().getStringExtra("Contact_QuanPin"));
            this.euW.cV(intExtra);
            this.euW.cg(stringExtra2);
            this.euW.ch(stringExtra3);
            this.euW.cf(stringExtra4);
            this.euW.cR(intExtra2);
            this.euW.ck(stringExtra5);
            this.euW.ci(stringExtra6);
            this.euW.db(intExtra4);
            this.euW.cj(stringExtra7);
            this.euW.cQ(intExtra3);
            this.euW.bV(stringExtra8);
            this.euW.r(longExtra);
            this.euW.ca(stringExtra9);
            this.euW.cl(stringExtra10);
            if (!be.kS(this.hUe) && this.hUa == 15) {
                ak.yW();
                ba Nw = c.wI().Nw(ma);
                ba baVar = new ba(ma);
                baVar.field_conRemark = Nw.field_conRemark;
                baVar.field_conDescription = Nw.field_conDescription;
                baVar.field_contactLabels = Nw.field_contactLabels;
                baVar.field_conPhone = this.hUe;
                ak.yW();
                c.wI().c(baVar);
                this.hUe = null;
            }
        } else {
            if (this.euW.bBZ == 0) {
                this.euW.cV(intExtra);
            }
            if (!(stringExtra2 == null || stringExtra2.equals(""))) {
                this.euW.cg(stringExtra2);
            }
            if (!(stringExtra3 == null || stringExtra3.equals(""))) {
                this.euW.ch(stringExtra3);
            }
            if (stringExtra10 != null) {
                if (!stringExtra10.equals("")) {
                    this.euW.cl(stringExtra10);
                }
            }
            if (!(stringExtra4 == null || stringExtra4.equals(""))) {
                this.euW.cf(stringExtra4);
            }
            if (intExtra2 != 0) {
                this.euW.cR(intExtra2);
            }
            if (!(stringExtra5 == null || stringExtra5.equals(""))) {
                this.euW.ck(stringExtra5);
            }
            if (!(stringExtra == null || stringExtra.equals(""))) {
                this.euW.bS(stringExtra);
            }
            v.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[]{be.ma(this.hUe)});
            if (!be.kS(this.hUe) && this.hUa == 15) {
                obj = 1;
                stringExtra = this.euW.bCz;
                if (stringExtra != null) {
                    for (String str3 : this.euW.bCz.split(",")) {
                        if (str3.equals(this.hUe)) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                    }
                }
                if (obj != null) {
                    this.euW.cs(stringExtra + this.hUe + ",");
                    this.hUe = null;
                }
                v.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[]{be.ma(this.euW.bCz)});
                this.euW.setSource(15);
            }
            this.euW.ci(stringExtra6);
            this.euW.db(intExtra4);
            this.euW.r(longExtra);
            this.euW.ca(stringExtra9);
        }
        if (!be.kS(ma3)) {
            this.euW.bY(ma3);
        }
        if (this.euW == null) {
            v.e("MicroMsg.ContactInfoUI", "contact = null");
        } else {
            ba Nw2;
            if (!be.kS(ma3)) {
                ak.yW();
                Nw2 = c.wI().Nw(ma3);
                if (!(Nw2 == null || be.kS(Nw2.field_encryptUsername))) {
                    this.euW.bQ(Nw2.field_conRemark);
                }
            }
            if (!be.kS(ma)) {
                ak.yW();
                Nw2 = c.wI().Nw(ma);
                if (!(Nw2 == null || be.kS(Nw2.field_encryptUsername))) {
                    this.euW.bQ(Nw2.field_conRemark);
                }
            }
        }
        getIntent().putExtra("Contact_User", this.euW.field_username);
        if (!booleanExtra && ((int) this.euW.chr) <= 0 && this.euW.bvm() && (this.hUa == 17 || this.hUa == 41)) {
            v.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[]{this.euW.field_username});
            ab.a.crZ.I(this.euW.field_username, "");
            com.tencent.mm.u.b.gC(this.euW.field_username);
        }
        if (this.euW.field_username.equals(k.xF())) {
            u uVar;
            ak.yW();
            long j = be.getLong((String) c.vf().get(65825, null), 0);
            if (j > 0) {
                this.euW.r(j);
                uVar = this.euW;
                ak.yW();
                uVar.ca((String) c.vf().get(65826, null));
            }
            uVar = this.euW;
            ak.yW();
            uVar.co((String) c.vf().get(286721, null));
            uVar = this.euW;
            ak.yW();
            uVar.cp((String) c.vf().get(286722, null));
            uVar = this.euW;
            ak.yW();
            uVar.cq((String) c.vf().get(286723, null));
        }
        if (this.euW.field_username != null && this.euW.field_username.equals(u.LM(k.xF()))) {
            bf zO = bf.zO();
            str3 = be.ma(zO.getProvince());
            ma2 = be.ma(zO.getCity());
            if (!be.kS(str3)) {
                this.euW.cg(str3);
            }
            if (!be.kS(ma2)) {
                this.euW.ch(ma2);
            }
            if (!be.kS(zO.bfd)) {
                this.euW.cl(RegionCodeDecoder.Y(zO.bfd, zO.cvf, zO.cve));
            }
            int a = be.a(Integer.valueOf(zO.bBZ), 0);
            ma3 = be.ma(zO.bCj);
            this.euW.cV(a);
            this.euW.cf(ma3);
        }
        if (be.kS(this.euW.field_username)) {
            v.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[]{ma});
            finish();
            return;
        }
        vD(m.fn(this.euW.field_username) ? 2131235104 : 2131232194);
        if (m.dE(this.euW.field_username)) {
            vD(2131232147);
        }
        str3 = this.hUf;
        if (m.ez(this.euW.field_username)) {
            this.hTX = com.tencent.mm.ay.c.J(this, "sport");
        } else if (m.eG(this.euW.field_username)) {
            this.hTX = com.tencent.mm.ay.c.J(this, "qqmail");
        } else if (m.eH(this.euW.field_username)) {
            this.hTX = new c(this);
            vD(2131235104);
        } else if (m.eJ(this.euW.field_username)) {
            this.hTX = com.tencent.mm.ay.c.J(this, "bottle");
            vD(2131235104);
        } else if (m.eI(this.euW.field_username)) {
            this.hTX = com.tencent.mm.ay.c.J(this, "tmessage");
            vD(2131235104);
        } else if (m.eK(this.euW.field_username)) {
            this.hTX = com.tencent.mm.ay.c.x(this, "qmessage", "widget_type_plugin");
            vD(2131235104);
        } else if (u.LJ(this.euW.field_username)) {
            this.hTX = com.tencent.mm.ay.c.x(this, "qmessage", "widget_type_contact");
        } else if (m.eA(this.euW.field_username)) {
            this.hTX = new g(this);
        } else if (m.eO(this.euW.field_username)) {
            this.hTX = new l(this);
        } else if (u.ew(this.euW.field_username)) {
            this.hTX = new b(this);
        } else if (m.eQ(this.euW.field_username)) {
            this.hTX = com.tencent.mm.ay.c.J(this, "nearby");
        } else if (m.eR(this.euW.field_username)) {
            this.hTX = com.tencent.mm.ay.c.J(this, "shake");
        } else if (m.eS(this.euW.field_username)) {
            this.hTX = new i(this);
        } else if (m.eT(this.euW.field_username)) {
            this.hTX = com.tencent.mm.ay.c.x(this, "readerapp", "widget_type_news");
        } else if (m.fb(this.euW.field_username)) {
            this.hTX = com.tencent.mm.ay.c.x(this, "readerapp", "widget_type_weibo");
        } else if (m.eU(this.euW.field_username)) {
            this.hTX = new n(this);
        } else if (m.eL(this.euW.field_username)) {
            this.hTX = new d(this);
        } else if (m.ff(this.euW.field_username)) {
            this.hTX = new f(this);
            if (n.aP(this)) {
                startActivityForResult(new Intent("com.tencent.mm.gms.CHECK_GP_SERVICES"), 1005);
            }
        } else if (m.eM(this.euW.field_username)) {
            this.hTX = com.tencent.mm.ay.c.J(this, "masssend");
        } else if (m.eN(this.euW.field_username)) {
            this.hTX = new e(this);
        } else if (this.euW.bvm()) {
            mc mcVar;
            try {
                mcVar = this.hUc == null ? null : (mc) new mc().az(this.hUc);
            } catch (Throwable e) {
                v.a("MicroMsg.ContactInfoUI", e, "", new Object[0]);
                mcVar = null;
            }
            a aVar = new a(this, str3, mcVar);
            if (!be.kS(this.hUb)) {
                aVar.hUb = this.hUb;
            }
            this.hTX = aVar;
        } else if (m.eV(this.euW.field_username)) {
            this.hTX = new o(this);
        } else if (m.eW(this.euW.field_username)) {
            this.hTX = new m(this);
        } else if (m.eX(this.euW.field_username)) {
            this.hTX = new h(this);
        } else {
            this.hTX = new j(this);
        }
        if (this.hTX != null) {
            this.hTX.a(this.dxf, this.euW, this.hTY, this.hUa);
            str3 = be.ma(ah.FL().iA(this.euW.field_username).EJ()).replace(" ", "");
            if (!this.hUg && com.tencent.mm.i.a.ei(this.euW.field_type) && (this.hTX instanceof j)) {
                int i;
                int i2;
                if (be.kS(this.euW.bCz)) {
                    i = 0;
                } else {
                    i = this.euW.bCz.split(",").length;
                }
                if (be.kS(str3)) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                i2 += i;
                g gVar = g.iuh;
                Object[] objArr = new Object[4];
                objArr[0] = this.euW.field_username;
                objArr[1] = Integer.valueOf(1);
                if (be.kS(str3)) {
                    i = 0;
                } else {
                    i = 1;
                }
                objArr[2] = Integer.valueOf(i);
                if (i2 >= 5) {
                    i = 5;
                } else {
                    i = i2;
                }
                objArr[3] = Integer.valueOf(i);
                gVar.h(12040, objArr);
                this.hUg = true;
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactInfoUI hUh;

            {
                this.hUh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.hUh.hUd) {
                    if ((m.eS(this.hUh.euW.field_username) && !k.ya()) || ((m.eK(this.hUh.euW.field_username) && !k.xW()) || ((m.eM(this.hUh.euW.field_username) && !k.yg()) || (m.eG(this.hUh.euW.field_username) && !k.yi())))) {
                        Intent intent = new Intent();
                        intent.addFlags(67108864);
                        com.tencent.mm.plugin.profile.a.drp.t(intent, this.hUh);
                    }
                    this.hUh.finish();
                } else {
                    this.hUh.finish();
                }
                return true;
            }
        });
        com.tencent.mm.u.n.Bq().gE(this.euW.field_username);
        if ((m.eS(this.euW.field_username) && k.ya()) || ((m.eK(this.euW.field_username) && k.xW()) || ((m.eM(this.euW.field_username) && k.yg()) || (m.eG(this.euW.field_username) && k.yi())))) {
            this.hUd = true;
        } else {
            this.hUd = false;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hTX != null) {
            this.hTX.onActivityResult(i, i2, intent);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        v.i("MicroMsg.ContactInfoUI", str + " item has been clicked!");
        if (this.hTX != null) {
            this.hTX.pz(str);
        }
        return false;
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            v.d("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), jVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(final String str, i iVar) {
        new ac().post(new Runnable(this) {
            final /* synthetic */ ContactInfoUI hUh;

            public final void run() {
                v.d("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[]{Boolean.valueOf(this.hUh.hTZ), this.hUh.euW.field_username, str});
                if (this.hUh.euW != null && !be.kS(this.hUh.euW.field_username)) {
                    if (this.hUh.euW.field_username.equals(str) || this.hUh.euW.field_username.equals(u.LM(str))) {
                        if (this.hUh.hTX != null) {
                            this.hUh.hTX.XS();
                            this.hUh.dxf.removeAll();
                        }
                        this.hUh.NI();
                    }
                }
            }
        });
    }

    public final void a(final ba baVar) {
        ad.o(new Runnable(this) {
            final /* synthetic */ ContactInfoUI hUh;

            public final void run() {
                if (this.hUh.euW != null && baVar != null && !be.kS(this.hUh.euW.field_username) && this.hUh.euW.field_username.equals(baVar.field_encryptUsername) && !m.fo(this.hUh.euW.field_username)) {
                    this.hUh.euW.bQ(baVar.field_conRemark);
                    this.hUh.getIntent().putExtra("Contact_User", this.hUh.euW.field_username);
                    if (this.hUh.hTX != null) {
                        this.hUh.hTX.XS();
                        this.hUh.dxf.removeAll();
                    }
                    this.hUh.NI();
                }
            }
        });
    }

    public final void xM(String str) {
        com.tencent.mm.ar.f[] fVarArr;
        h[] hVarArr;
        com.tencent.mm.pluginsdk.ui.preference.b[] a;
        com.tencent.mm.ar.j[] jVarArr;
        if (this.hUa == 18) {
            v.d("MicroMsg.ContactInfoUI", "initAddContent, scene is lbs");
            h[] kK = l.KE().kK(this.euW.field_username);
            fVarArr = null;
            hVarArr = kK;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(aa.getContext(), kK);
            jVarArr = null;
        } else if (aw.eM(this.hUa)) {
            v.d("MicroMsg.ContactInfoUI", "initAddContent, scene is shake");
            com.tencent.mm.ar.j[] kP = l.KF().kP(this.euW.field_username);
            fVarArr = null;
            hVarArr = null;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(aa.getContext(), kP);
            jVarArr = kP;
        } else {
            com.tencent.mm.ar.f[] kF = l.KC().kF(str);
            fVarArr = kF;
            hVarArr = null;
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(aa.getContext(), kF);
            jVarArr = null;
        }
        if (a != null) {
            int i = 0;
            int length = a.length;
            int i2 = 0;
            while (i2 < length) {
                int i3;
                com.tencent.mm.pluginsdk.ui.preference.b bVar = a[i2];
                at atVar = new at();
                atVar.setContent(bVar.cqK);
                int fp = m.fp(bVar.username);
                if (fVarArr != null) {
                    i3 = i + 1;
                    atVar.z(fVarArr[i].field_createTime);
                } else if (hVarArr != null) {
                    i3 = i + 1;
                    atVar.z(hVarArr[i].field_createtime * 1000);
                } else if (jVarArr != null) {
                    i3 = i + 1;
                    atVar.z(jVarArr[i].field_createtime * 1000);
                } else {
                    i3 = i;
                }
                atVar.cH(bVar.username);
                atVar.setType(fp);
                if (bVar.cFQ) {
                    atVar.dh(2);
                    atVar.di(1);
                } else {
                    atVar.dh(6);
                    atVar.di(0);
                }
                ak.yW();
                long R = c.wJ().R(atVar);
                Assert.assertTrue(R != -1);
                v.i("MicroMsg.ContactInfoUI", "new msg inserted to db , local id = " + R);
                i2++;
                i = i3;
            }
            at atVar2 = new at();
            if (fVarArr != null) {
                atVar2.z(fVarArr[fVarArr.length - 1].field_createTime + 1);
            } else if (hVarArr != null) {
                atVar2.z((hVarArr[hVarArr.length - 1].field_createtime * 1000) + 1);
            } else if (jVarArr != null) {
                atVar2.z((jVarArr[jVarArr.length - 1].field_createtime * 1000) + 1);
            }
            atVar2.cH(str);
            atVar2.setContent(getString(2131235699));
            atVar2.setType(10000);
            atVar2.di(0);
            atVar2.dh(6);
            ak.yW();
            c.wJ().R(atVar2);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.ContactInfoUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        NormalUserFooterPreference normalUserFooterPreference;
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    normalUserFooterPreference = (NormalUserFooterPreference) this.dxf.Ow("contact_info_footer_normal");
                    if (normalUserFooterPreference != null) {
                        normalUserFooterPreference.aGQ();
                        return;
                    }
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? 2131234160 : 2131234163;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(i2), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ ContactInfoUI hUh;

                        {
                            this.hUh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.hUh.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ ContactInfoUI hUh;

                        {
                            this.hUh = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            case 82:
                if (iArr[0] == 0) {
                    normalUserFooterPreference = (NormalUserFooterPreference) this.dxf.Ow("contact_info_footer_normal");
                    if (normalUserFooterPreference != null) {
                        normalUserFooterPreference.aGP();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.g.a(this, getString(2131234162), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                    final /* synthetic */ ContactInfoUI hUh;

                    {
                        this.hUh = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.hUh.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, null);
                return;
            default:
                return;
        }
    }
}
