package com.tencent.mm.plugin.shake.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.bm;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.fz;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.o;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.protocal.c.qf;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qj;
import com.tencent.mm.protocal.c.zn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TVInfoUI extends MMPreference implements a, e {
    private long bao;
    private TextView dtB;
    protected ProgressDialog dwR = null;
    protected f dxf;
    private boolean iBU = false;
    private ImageView iSX;
    private String iSY = "";
    private TextView iSZ;
    private c.a iTa;
    private b iTb;
    private boolean izA = false;

    static /* synthetic */ void a(TVInfoUI tVInfoUI) {
        String str = "";
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        linkedList.add(tVInfoUI.getString(2131236667));
        linkedList2.add(Integer.valueOf(0));
        linkedList.add(tVInfoUI.getString(2131236668));
        linkedList2.add(Integer.valueOf(1));
        if (tVInfoUI.getIntent().getBooleanExtra("key_is_favorite_item", false)) {
            str = tVInfoUI.getIntent().getBooleanExtra("key_can_delete_favorite_item", true) ? tVInfoUI.getString(2131231020) : "";
        } else {
            linkedList.add(tVInfoUI.getString(2131234180));
            linkedList2.add(Integer.valueOf(2));
        }
        g.a(tVInfoUI, "", linkedList, linkedList2, str, false, new d(tVInfoUI) {
            final /* synthetic */ TVInfoUI iTd;

            {
                this.iTd = r1;
            }

            public final void bw(int i, int i2) {
                switch (i2) {
                    case -1:
                        g.a(this.iTd.nDR.nEl, this.iTd.nDR.nEl.getString(2131231021), null, null, this.iTd.nDR.nEl.getString(2131231020), new d(this) {
                            final /* synthetic */ AnonymousClass6 iTe;

                            {
                                this.iTe = r1;
                            }

                            public final void bw(int i, int i2) {
                                switch (i2) {
                                    case -1:
                                        bm bmVar = new bm();
                                        bmVar.aYY.aZa = this.iTe.iTd.getIntent().getLongExtra("key_favorite_local_id", -1);
                                        com.tencent.mm.sdk.c.a.nhr.z(bmVar);
                                        v.d("MicroMsg.TVInfoUI", "do del fav tv, local id %d, result %B", new Object[]{Long.valueOf(bmVar.aYY.aZa), Boolean.valueOf(bmVar.aYZ.aYN)});
                                        if (bmVar.aYZ.aYN) {
                                            this.iTe.iTd.finish();
                                            return;
                                        }
                                        return;
                                    default:
                                        v.d("MicroMsg.TVInfoUI", "do del cancel");
                                        return;
                                }
                            }
                        });
                        return;
                    case 0:
                        TVInfoUI.b(this.iTd);
                        return;
                    case 1:
                        TVInfoUI.c(this.iTd);
                        return;
                    case 2:
                        TVInfoUI.d(this.iTd);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void a(TVInfoUI tVInfoUI, c.a aVar) {
        if (aVar != null && aVar.iEd != null && aVar.iEd.size() != 0 && tVInfoUI.dxf != null) {
            tVInfoUI.dxf.removeAll();
            for (int i = 0; i < aVar.iEd.size(); i++) {
                com.tencent.mm.plugin.shake.e.a aVar2 = (com.tencent.mm.plugin.shake.e.a) aVar.iEd.get(i);
                if (!(aVar2 == null || aVar2.cZq == null || aVar2.cZq.size() == 0)) {
                    for (int i2 = 0; i2 < aVar2.cZq.size(); i2++) {
                        String str = ((i * 100) + i2);
                        com.tencent.mm.plugin.shake.e.a.a aVar3 = (com.tencent.mm.plugin.shake.e.a.a) aVar2.cZq.get(i2);
                        Preference preference;
                        if (aVar3.type == 2) {
                            preference = new Preference(tVInfoUI);
                            preference.setKey(str);
                            preference.setLayoutResource(2130904559);
                            preference.setTitle(be.kS(aVar3.title) ? tVInfoUI.getResources().getString(2131235292) : aVar3.title);
                            preference.setSummary(String.format(tVInfoUI.getResources().getString(2131235291), new Object[]{Integer.valueOf(ba.CTRL_INDEX)}));
                        } else if (aVar3.iTl == null || aVar3.iTl.size() <= 0) {
                            preference = new Preference(tVInfoUI);
                            preference.setKey(str);
                            preference.setLayoutResource(2130904559);
                            preference.setTitle(aVar3.title);
                            preference.setSummary(aVar3.gmB);
                            tVInfoUI.dxf.a(preference);
                        } else {
                            List arrayList = new ArrayList();
                            int i3 = 0;
                            while (i3 < aVar3.iTl.size() && i3 < 3 && (i3 != 2 || aVar3.title.length() <= 4)) {
                                arrayList.add(aVar3.iTl.get(i3));
                                i3++;
                            }
                            TVThumbPreference tVThumbPreference = new TVThumbPreference(tVInfoUI);
                            tVThumbPreference.setKey(str);
                            tVThumbPreference.iTi = arrayList;
                            tVThumbPreference.setTitle(aVar3.title);
                            tVThumbPreference.ezq = tVInfoUI.dxf;
                            tVInfoUI.dxf.a(tVThumbPreference);
                        }
                    }
                }
            }
            tVInfoUI.dxf.notifyDataSetChanged();
        }
    }

    static /* synthetic */ void a(TVInfoUI tVInfoUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("show_bottom", false);
        intent.putExtra("geta8key_scene", 10);
        com.tencent.mm.plugin.shake.a.drp.j(intent, tVInfoUI);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI) {
        if (tVInfoUI.iTa == null) {
            v.w("MicroMsg.TVInfoUI", "shareToFriend, but tv is null");
            return;
        }
        com.tencent.mm.plugin.report.service.g.iuh.h(10987, new Object[]{Integer.valueOf(4), "", "", ""});
        String a = c.a(tVInfoUI.nDR.nEl, tVInfoUI.iTa);
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", a);
        intent.putExtra("Retr_Msg_Type", 2);
        if (tVInfoUI.iTb != null && tVInfoUI.izA) {
            intent.putExtra("Retr_Msg_thumb_path", tVInfoUI.iTb.MU());
        }
        intent.putExtra("Retr_go_to_chattingUI", false);
        intent.putExtra("Retr_show_success_tips", true);
        com.tencent.mm.plugin.shake.a.drp.l(intent, tVInfoUI);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI, c.a aVar) {
        if (aVar != null && !be.kS(aVar.field_thumburl)) {
            tVInfoUI.iTb = new b(aVar);
            tVInfoUI.iSY = tVInfoUI.iTb.MW();
            Bitmap a = j.a(tVInfoUI.iTb);
            v.d("MicroMsg.TVInfoUI", "initHeaderImg photo = %s", new Object[]{a});
            if (a != null) {
                tVInfoUI.iSX.setImageBitmap(a);
                tVInfoUI.izA = true;
                tVInfoUI.aLA();
                return;
            }
            tVInfoUI.iSX.setImageDrawable(tVInfoUI.getResources().getDrawable(2131165985));
        }
    }

    static /* synthetic */ void c(TVInfoUI tVInfoUI) {
        if (tVInfoUI.iTa == null) {
            v.w("MicroMsg.TVInfoUI", "shareToTimeLine, but tv is null");
            return;
        }
        com.tencent.mm.plugin.report.service.g.iuh.h(10987, new Object[]{Integer.valueOf(3), "", "", ""});
        Intent intent = new Intent();
        if (be.kS(tVInfoUI.iTa.field_topic)) {
            intent.putExtra("KContentObjDesc", tVInfoUI.iTa.field_subtitle);
        } else {
            intent.putExtra("KContentObjDesc", tVInfoUI.iTa.field_topic);
        }
        intent.putExtra("Ksnsupload_title", tVInfoUI.iTa.field_title);
        intent.putExtra("Ksnsupload_link", tVInfoUI.iTa.field_shareurl);
        intent.putExtra("Ksnsupload_appname", tVInfoUI.getString(2131234798));
        if (k.aNM()) {
            intent.putExtra("Ksnsupload_appid", "wxaf060266bfa9a35c");
        }
        intent.putExtra("Ksnsupload_imgurl", tVInfoUI.iTa.field_thumburl);
        if (tVInfoUI.iTb != null && tVInfoUI.izA) {
            intent.putExtra("KsnsUpload_imgPath", tVInfoUI.iTb.MU());
        }
        intent.putExtra("Ksnsupload_type", 5);
        intent.putExtra("KUploadProduct_UserData", c.b(tVInfoUI.iTa));
        String fz = o.fz("shake_tv");
        o.yx().n(fz, true).l("prePublishId", "shake_tv");
        intent.putExtra("reportSessionId", fz);
        com.tencent.mm.ay.c.b(tVInfoUI, "sns", ".ui.SnsUploadUI", intent);
    }

    static /* synthetic */ void d(TVInfoUI tVInfoUI) {
        if (tVInfoUI.iTa == null) {
            v.w("MicroMsg.TVInfoUI", "do favorite, but tv is null");
            return;
        }
        com.tencent.mm.plugin.report.service.g.iuh.h(10987, new Object[]{Integer.valueOf(5), "", "", ""});
        bp bpVar = new bp();
        qf qfVar = new qf();
        qg qgVar = new qg();
        qj qjVar = new qj();
        qgVar.Jn(com.tencent.mm.model.k.xF());
        qgVar.Jo(com.tencent.mm.model.k.xF());
        qgVar.uN(8);
        qgVar.dV(be.Ni());
        if (k.aNM()) {
            qgVar.Jt("wxaf060266bfa9a35c");
        }
        qjVar.Jw(tVInfoUI.iTa.field_title);
        if (be.kS(tVInfoUI.iTa.field_topic)) {
            qjVar.Jx(tVInfoUI.iTa.field_subtitle);
        } else {
            qjVar.Jx(tVInfoUI.iTa.field_topic);
        }
        qjVar.Jz(c.b(tVInfoUI.iTa));
        qjVar.Jy(tVInfoUI.iTa.field_thumburl);
        bpVar.aZd.title = tVInfoUI.iTa.field_title;
        bpVar.aZd.desc = tVInfoUI.iTa.field_topic;
        bpVar.aZd.aZf = qfVar;
        bpVar.aZd.type = 15;
        qfVar.a(qgVar);
        qfVar.b(qjVar);
        bpVar.aZd.aZl = 12;
        bpVar.aZd.aXH = tVInfoUI;
        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
    }

    protected final int getLayoutId() {
        return 2130904557;
    }

    public final int Oo() {
        return 2131099741;
    }

    public final int YA() {
        return 2130904558;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j.b(this);
        NI();
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(552, this);
    }

    protected void onPause() {
        ak.vy().b(552, this);
        super.onPause();
    }

    protected void onDestroy() {
        j.c(this);
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131234795);
        this.dxf = this.ocZ;
        this.dtB = (TextView) findViewById(2131759595);
        this.iSZ = (TextView) findViewById(2131759594);
        String stringExtra = getIntent().getStringExtra("key_TV_xml");
        if (be.kS(stringExtra)) {
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_TV_xml_bytes");
            if (byteArrayExtra != null) {
                stringExtra = new String(byteArrayExtra);
            }
        }
        v.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", new Object[]{stringExtra});
        this.iTa = c.zy(stringExtra);
        if (this.iTa == null) {
            v.e("MicroMsg.TVInfoUI", "initView(), tv == null");
            finish();
            return;
        }
        a(this.iTa);
    }

    private void a(final c.a aVar) {
        if (aVar == null) {
            v.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
            finish();
            return;
        }
        this.dtB.setText(aVar.field_title);
        if (be.kS(aVar.field_topic)) {
            this.iSZ.setVisibility(8);
        } else {
            this.iSZ.setText(aVar.field_topic);
        }
        this.iSX = (ImageView) findViewById(2131759592);
        if (!be.kS(aVar.field_playurl)) {
            ImageView imageView = (ImageView) findViewById(2131759593);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ TVInfoUI iTd;

                public final void onClick(View view) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(10987, new Object[]{Integer.valueOf(2), aVar.field_playstatid, "", ""});
                    TVInfoUI.a(this.iTd, aVar.field_playurl);
                }
            });
            this.iSX.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ TVInfoUI iTd;

                public final void onClick(View view) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(10987, new Object[]{Integer.valueOf(2), aVar.field_playstatid, "", ""});
                    TVInfoUI.a(this.iTd, aVar.field_playurl);
                }
            });
        }
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ TVInfoUI iTd;

            {
                this.iTd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                TVInfoUI.a(this.iTd);
                return true;
            }
        });
        if (!(be.kS(aVar.field_id) || this.iBU || getIntent().getBooleanExtra("key_TV_come_from_shake", false))) {
            v.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", new Object[]{aVar.field_id, Integer.valueOf(getIntent().getIntExtra("key_TV_getProductInfoScene", 0))});
            ak.vy().a(new com.tencent.mm.plugin.shake.d.a.b(aVar.field_id, r0), 0);
            this.iBU = true;
        }
        this.iSX.setVisibility(0);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ TVInfoUI iTd;

            {
                this.iTd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iTd.finish();
                return true;
            }
        });
        v.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
        ad.o(new Runnable(this) {
            final /* synthetic */ TVInfoUI iTd;

            public final void run() {
                TVInfoUI.a(this.iTd, aVar);
                TVInfoUI.b(this.iTd, aVar);
            }
        });
    }

    private void aLA() {
        this.bao = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0);
        if (this.bao > 0 && ak.uz()) {
            ak.yW();
            at ek = com.tencent.mm.model.c.wJ().ek(this.bao);
            if (ek.field_msgId > 0) {
                ek.cI(this.iTb.MU());
                ak.yW();
                com.tencent.mm.model.c.wJ().a(this.bao, ek);
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        v.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", new Object[]{preference.dnU});
        if (this.iTa == null || this.iTa.iEd == null) {
            v.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.dnU).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            v.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2)});
            if (i < 0 || i >= this.iTa.iEd.size()) {
                v.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.iTa.iEd.size())});
                return false;
            }
            com.tencent.mm.plugin.shake.e.a aVar = (com.tencent.mm.plugin.shake.e.a) this.iTa.iEd.get(i);
            if (aVar == null) {
                v.w("MicroMsg.TVInfoUI", "actionList == null");
                return false;
            } else if (i2 < 0 || i2 >= aVar.cZq.size()) {
                v.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(aVar.cZq.size())});
                return false;
            } else {
                com.tencent.mm.plugin.shake.e.a.a aVar2 = (com.tencent.mm.plugin.shake.e.a.a) aVar.cZq.get(i2);
                if (aVar2 == null) {
                    v.w("MicroMsg.TVInfoUI", "action == null");
                    return false;
                }
                v.v("MicroMsg.TVInfoUI", "action type:" + aVar2.type + ", target:" + aVar2.iTk + ", targetDesc:" + aVar2.iTm + ", targetDesc2:" + aVar2.iTn);
                Intent intent;
                if (aVar2.type == 3) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", aVar2.iTk);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("geta8key_scene", 10);
                    intent.putExtra("srcUsername", aVar2.iTn);
                    com.tencent.mm.plugin.shake.a.drp.j(intent, this);
                } else if (aVar2.type == 4) {
                    ak.yW();
                    u LX = com.tencent.mm.model.c.wH().LX(aVar2.iTk);
                    if (LX != null) {
                        Intent intent2 = new Intent();
                        if (com.tencent.mm.i.a.ei(LX.field_type) && LX.bvm()) {
                            com.tencent.mm.modelbiz.u.Dy().ho(aVar2.iTk);
                            if (aVar2.iTm.equals("1")) {
                                intent2.putExtra("Chat_User", aVar2.iTk);
                                intent2.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.shake.a.drp.e(intent2, this);
                            }
                        }
                        intent2.putExtra("Contact_User", aVar2.iTk);
                        intent2.putExtra("force_get_contact", true);
                        com.tencent.mm.ay.c.b(this, "profile", ".ui.ContactInfoUI", intent2);
                    }
                } else if (aVar2.type == 5) {
                    fz fzVar = new fz();
                    fzVar.bfx.actionCode = 11;
                    fzVar.bfx.bfz = aVar2.iTk;
                    fzVar.bfx.context = this;
                    fzVar.bpT = null;
                    com.tencent.mm.sdk.c.a.nhr.a(fzVar, Looper.myLooper());
                } else if (aVar2.type == 6) {
                    intent = new Intent();
                    intent.putExtra("key_product_id", aVar2.iTk);
                    intent.putExtra("key_product_scene", 9);
                    com.tencent.mm.ay.c.b(this, "product", ".ui.MallProductUI", intent);
                }
                return true;
            }
        } catch (Throwable e) {
            v.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            v.a("MicroMsg.TVInfoUI", e, "", new Object[0]);
            return false;
        }
    }

    public final void k(final String str, final Bitmap bitmap) {
        if (str != null) {
            String str2 = "MicroMsg.TVInfoUI";
            String str3 = "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bitmap == null);
            v.d(str2, str3, objArr);
            try {
                ad.o(new Runnable(this) {
                    final /* synthetic */ TVInfoUI iTd;

                    public final void run() {
                        if (this.iTd.iSY != null && this.iTd.iSY.equals(str)) {
                            if (!(this.iTd.iSX == null || bitmap == null)) {
                                this.iTd.iSX.setImageBitmap(bitmap);
                                this.iTd.aLA();
                            }
                            this.iTd.izA = true;
                        }
                    }
                });
                return;
            } catch (Throwable e) {
                v.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", new Object[]{e.getLocalizedMessage()});
                v.a("MicroMsg.TVInfoUI", e, "", new Object[0]);
                return;
            }
        }
        v.e("MicroMsg.TVInfoUI", "onUpdate pic, url  is null ");
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar == null) {
            v.w("MicroMsg.TVInfoUI", "scene == null");
        } else if (kVar.getType() != 552) {
        } else {
            if (i != 0 || i2 != 0) {
                v.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                Toast.makeText(this, 2131234796, 0).show();
            } else if (this.iTa == null) {
                v.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
            } else {
                com.tencent.mm.plugin.shake.d.a.b bVar = (com.tencent.mm.plugin.shake.d.a.b) kVar;
                zn znVar = (bVar.cif == null || bVar.cif.czl.czs == null) ? null : (zn) bVar.cif.czl.czs;
                if (znVar == null) {
                    v.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
                } else if (znVar.mii != null) {
                    v.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + znVar.mii);
                    c.a zy = c.zy(znVar.mii);
                    if (this.iTa != null && this.iTa.field_xml != null && zy != null && zy.field_xml != null && !this.iTa.field_xml.equals(zy.field_xml)) {
                        this.iTa = zy;
                        a(this.iTa);
                    }
                }
            }
        }
    }
}
