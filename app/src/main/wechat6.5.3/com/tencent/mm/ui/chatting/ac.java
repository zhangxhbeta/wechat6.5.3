package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.ToneGenerator;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.kx;
import com.tencent.mm.e.a.qh;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.h;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class ac implements b {
    public static boolean onf = true;
    private u euW;
    private ToneGenerator ewH;
    private Vibrator ewK;
    private final ah exb = new ah(new a(this) {
        final /* synthetic */ ac onr;

        {
            this.onr = r1;
        }

        public final boolean oU() {
            this.onr.hjH.uh(this.onr.oni.getMaxAmplitude());
            return true;
        }
    }, true);
    private final ah exc = new ah(new a(this) {
        final /* synthetic */ ac onr;

        {
            this.onr = r1;
        }

        public final boolean oU() {
            long pr = this.onr.oni.pr();
            v.d("MicroMsg.ChattingFooterEventImpl", "ms " + pr);
            if (pr >= 50000 && pr <= 60000) {
                if (!this.onr.onq) {
                    be.dV(this.onr.ols.nDR.nEl);
                    this.onr.onq = true;
                }
                int i = (int) ((60000 - pr) / 1000);
                this.onr.hjH.HG(this.onr.ols.bAp().getQuantityString(2131361794, i, new Object[]{Integer.valueOf(i)}));
            }
            if (pr < 60000) {
                return true;
            }
            v.v("MicroMsg.ChattingFooterEventImpl", "record stop on countdown");
            this.onr.bEm();
            this.onr.hjH.anf();
            ao.T(this.onr.ols.nDR.nEl, 2131235667);
            return false;
        }
    }, true);
    private final h.a exf = new h.a(this) {
        final /* synthetic */ ac onr;

        {
            this.onr = r1;
        }

        public final void onError() {
            this.onr.oni.reset();
            this.onr.exb.QI();
            this.onr.exc.QI();
            ab.Kj("keep_app_silent");
            this.onr.hjH.anf();
            this.onr.onh.oqd.bDS();
            v.v("MicroMsg.ChattingFooterEventImpl", "record stop on error");
            this.onr.ols.iT(true);
            this.onr.ols.iS(true);
            Toast.makeText(this.onr.ols.nDR.nEl, this.onr.ols.nDR.nEl.getString(2131231870), 0).show();
        }
    };
    private ChatFooter hjH;
    private final h.b hjM = new h.b(this) {
        final /* synthetic */ ac onr;

        {
            this.onr = r1;
        }

        public final void Bw() {
            this.onr.hjH.bpK();
        }
    };
    private AppPanel.a hku = new AppPanel.a(this) {
        l hXb = null;
        final /* synthetic */ ac onr;

        {
            this.onr = r2;
        }

        public final void azq() {
            if (!com.tencent.mm.ah.a.aT(this.onr.ols.nDR.nEl)) {
                com.tencent.mm.sdk.c.b qhVar = new qh();
                com.tencent.mm.sdk.c.a.nhr.z(qhVar);
                if (this.onr.bEn().equals(qhVar.bry.bdo) || !(qhVar.bry.brA || qhVar.bry.brB)) {
                    if (1 == j.sU().getInt("EnableVoiceVoipFromPlugin", 0)) {
                        if (this.hXb == null) {
                            this.hXb = new l(this.onr.ols.nDR.nEl);
                            this.hXb.jXn = new c(this) {
                                final /* synthetic */ AnonymousClass12 ont;

                                {
                                    this.ont = r1;
                                }

                                public final void a(com.tencent.mm.ui.base.l lVar) {
                                    lVar.dg(2, 2131231059);
                                    lVar.dg(1, 2131231061);
                                }
                            };
                            this.hXb.jXo = new d(this) {
                                final /* synthetic */ AnonymousClass12 ont;

                                {
                                    this.ont = r1;
                                }

                                public final void c(MenuItem menuItem, int i) {
                                    switch (menuItem.getItemId()) {
                                        case 1:
                                            this.ont.onr.aGP();
                                            return;
                                        case 2:
                                            this.ont.onr.aGQ();
                                            return;
                                        default:
                                            return;
                                    }
                                }
                            };
                        }
                        this.hXb.aXZ();
                    } else {
                        this.onr.bEr();
                    }
                    g.iuh.h(11033, Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0));
                    return;
                }
                Toast.makeText(this.onr.ols.nDR.nEl, qhVar.bry.brz ? 2131231572 : 2131231573, 0).show();
                v.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            }
        }

        public final void azr() {
            if (!com.tencent.mm.ah.a.aT(this.onr.ols.nDR.nEl)) {
                com.tencent.mm.sdk.c.b qhVar = new qh();
                com.tencent.mm.sdk.c.a.nhr.z(qhVar);
                if (this.onr.bEn().equals(qhVar.bry.bdo) || !(qhVar.bry.brA || qhVar.bry.brB)) {
                    this.onr.bEq();
                    return;
                }
                Toast.makeText(this.onr.ols.nDR.nEl, qhVar.bry.brz ? 2131231572 : 2131231573, 0).show();
                v.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
            }
        }

        public final void azs() {
            if (!com.tencent.mm.as.u.bj(this.onr.ols.nDR.nEl) && !com.tencent.mm.ah.a.aT(this.onr.ols.nDR.nEl)) {
                v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.onr.ols.bzo(), "android.permission.RECORD_AUDIO", 81, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.onr.ols.bzo());
                if (com.tencent.mm.pluginsdk.i.a.a(this.onr.ols.bzo(), "android.permission.RECORD_AUDIO", 81, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                    this.onr.bEs();
                }
            }
        }

        public final void azt() {
            p f = this.onr.ols;
            com.tencent.mm.ui.base.g.a(f.nDR.nEl, null, !f.bFQ() ? new String[]{f.vN(2131233540)} : new String[]{f.vN(2131233540), f.vN(2131233541)}, null, new com.tencent.mm.ui.base.g.c(f) {
                final /* synthetic */ a ovO;

                {
                    this.ovO = r1;
                }

                public final void gT(int i) {
                    switch (i) {
                        case 0:
                            v.d("MicroMsg.ChattingUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ovO.bzo(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null)));
                            if (com.tencent.mm.pluginsdk.i.a.a(this.ovO.bzo(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null)) {
                                this.ovO.bFO();
                                return;
                            }
                            return;
                        case 1:
                            v.d("MicroMsg.ChattingUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ovO.bzo(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null)));
                            if (com.tencent.mm.pluginsdk.i.a.a(this.ovO.bzo(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null)) {
                                this.ovO.bFP();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
            });
        }

        public final void azu() {
            p f = this.onr.ols;
            Intent intent = new Intent(f.nDR.nEl, SelectContactUI.class);
            intent.putExtra("list_attr", r.s(r.oHM, 2048));
            intent.putExtra("list_type", 4);
            intent.putExtra("received_card_name", f.bEn());
            intent.putExtra("block_contact", f.bEn());
            intent.putExtra("Add_SendCard", true);
            intent.putExtra("titile", f.vN(2131230883));
            f.startActivityForResult(intent, 223);
        }

        public final void mS(int i) {
            switch (i) {
                case 0:
                    File file = new File(e.cgg);
                    if (file.exists() || file.mkdir()) {
                        v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.onr.ols.bzo(), "android.permission.CAMERA", 20, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.onr.ols.bzo());
                        if (com.tencent.mm.pluginsdk.i.a.a(this.onr.ols.bzo(), "android.permission.CAMERA", 20, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                            this.onr.bEt();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(this.onr.ols.nDR.nEl, this.onr.ols.getString(2131231905), 1).show();
                    return;
                case 1:
                    String string = this.onr.ols.NV(aa.bti()).getString("gallery", "1");
                    f.oR(19);
                    if (string.equalsIgnoreCase("0")) {
                        com.tencent.mm.pluginsdk.ui.tools.l.k(this.onr.ols);
                    } else {
                        string = this.onr.ols.bFR();
                        String bEn = this.onr.ols.bEn();
                        if (this.onr.onn && ac.onf) {
                            com.tencent.mm.pluginsdk.ui.tools.l.a(this.onr.ols, 3, string, bEn);
                        } else if (u.dW(bEn)) {
                            com.tencent.mm.pluginsdk.ui.tools.l.b(this.onr.ols, 12, string, bEn);
                        } else {
                            com.tencent.mm.pluginsdk.ui.tools.l.b(this.onr.ols, 3, string, bEn);
                        }
                    }
                    g.iuh.h(13822, Integer.valueOf(2), Integer.valueOf(1));
                    ad.g(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 ont;

                        {
                            this.ont = r1;
                        }

                        public final void run() {
                            this.ont.onr.hjH.bqg();
                        }
                    }, 1000);
                    return;
                default:
                    return;
            }
        }

        public final void c(com.tencent.mm.pluginsdk.model.app.f fVar) {
            p f = this.onr.ols;
            if (fVar == null) {
                v.e("MicroMsg.ChattingUI", "onAppSelected, info is null, %s", be.bur());
                return;
            }
            if (!(fVar == null || !com.tencent.mm.pluginsdk.model.app.f.lAm.equals(fVar.field_appId) || f.irY == null)) {
                f.irY.aj(2, ChattingUI.a.osT);
            }
            if (fVar.bnl()) {
                f.p(fVar);
            } else if (fVar.field_status == 3) {
                v.e("MicroMsg.ChattingUI", "onAppSeleted fail, app is in blacklist, packageName = " + fVar.field_packageName);
            } else if (!f.ouR.dY(fVar.field_packageName, fVar.field_openId) && fVar.field_status == 5) {
                v.d("MicroMsg.ChattingUI", "SuggestionApp appSuggestionIntroUrl = %s", fVar.bxw);
                if (!be.kS(fVar.bxw)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", fVar.bxw);
                    com.tencent.mm.ay.c.b(f.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        }

        public final void azv() {
            com.tencent.mm.ay.c.b(this.onr.ols.nDR.nEl, "subapp", ".ui.openapi.AddAppUI", new Intent());
        }

        public final void azw() {
            Intent intent = new Intent();
            Iterable arrayList = new ArrayList();
            arrayList.add("3");
            if (com.tencent.mm.modelbiz.e.hC(this.onr.euW.field_username)) {
                arrayList.add("4");
                arrayList.add("7");
                arrayList.add("9");
                arrayList.add("10");
                arrayList.add("11");
                arrayList.add("12");
                arrayList.add("13");
                arrayList.add("15");
                arrayList.add("16");
                arrayList.add("17");
                arrayList.add("18");
            }
            intent.putExtra("key_to_user", this.onr.euW.field_username);
            intent.putExtra("key_fav_item_id", TextUtils.join(",", arrayList));
            com.tencent.mm.ay.c.b(this.onr.ols.nDR.nEl, "favorite", ".ui.FavSelectUI", intent);
        }

        public final void azx() {
            Intent intent = new Intent();
            intent.putExtra("service_app_talker_user", this.onr.bEn());
            com.tencent.mm.ay.c.a(this.onr.ols, "subapp", ".ui.openapi.ServiceAppUI", intent, 222);
        }

        public final void azy() {
            Intent intent = new Intent();
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("preceding_scence", 13);
            com.tencent.mm.ay.c.b(this.onr.ols.nDR.nEl, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            g.iuh.h(12065, Integer.valueOf(4));
        }

        public final void azz() {
            if (!com.tencent.mm.as.u.bi(this.onr.ols.bzo()) && !com.tencent.mm.as.u.bj(this.onr.ols.bzo()) && !com.tencent.mm.ah.a.aT(this.onr.ols.bzo())) {
                this.onr.bEp();
            }
        }

        public final void azA() {
            g.iuh.h(12097, Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
            g.iuh.h(11850, Integer.valueOf(4), Integer.valueOf(1));
            if (this.onr.onl) {
                g.iuh.h(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2));
                Intent intent = new Intent();
                int el = i.el(this.onr.bEn());
                intent.putExtra("key_way", 1);
                intent.putExtra("key_chatroom_num", el);
                intent.putExtra("key_type", 1);
                intent.putExtra("key_from", 1);
                intent.putExtra("key_username", this.onr.bEn());
                intent.putExtra("pay_channel", 14);
                com.tencent.mm.ay.c.b(this.onr.ols.nDR.nEl, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                return;
            }
            ak.yW();
            Integer num = (Integer) com.tencent.mm.model.c.vf().get(t.a.USERINFO_LUCKY_MONEY_NEWYEAR_SWITCH_INT_SYNC, Integer.valueOf(0));
            ak.yW();
            Integer num2 = (Integer) com.tencent.mm.model.c.vf().get(t.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(0));
            if (num.intValue() == 1 || num2.intValue() == 1) {
                if ((k.xM() == 0 ? 1 : 0) != 0) {
                    com.tencent.mm.ui.base.g.a(this.onr.ols.nDR.nEl, null, new String[]{this.onr.ols.getString(2131233632), this.onr.ols.getString(2131233667)}, null, new com.tencent.mm.ui.base.g.c(this) {
                        final /* synthetic */ AnonymousClass12 ont;

                        {
                            this.ont = r1;
                        }

                        public final void gT(int i) {
                            Intent intent = new Intent();
                            switch (i) {
                                case 0:
                                    g.iuh.h(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(3));
                                    intent.putExtra("key_username", this.ont.onr.bEn());
                                    intent.putExtra("key_way", 0);
                                    intent.putExtra("pay_channel", 11);
                                    com.tencent.mm.ay.c.b(this.ont.onr.ols.nDR.nEl, "luckymoney", ".ui.LuckyMoneyNewYearSendUI", intent);
                                    return;
                                case 1:
                                    g.iuh.h(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
                                    intent.putExtra("key_way", 0);
                                    intent.putExtra("key_type", 0);
                                    intent.putExtra("key_from", 1);
                                    intent.putExtra("key_username", this.ont.onr.bEn());
                                    intent.putExtra("pay_channel", 11);
                                    com.tencent.mm.ay.c.b(this.ont.onr.ols.nDR.nEl, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                    return;
                }
            }
            g.iuh.h(11701, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1));
            intent = new Intent();
            intent.putExtra("key_way", 0);
            intent.putExtra("key_type", 0);
            intent.putExtra("key_from", 1);
            intent.putExtra("key_username", this.onr.bEn());
            intent.putExtra("pay_channel", 11);
            com.tencent.mm.ay.c.b(this.onr.ols.nDR.nEl, "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
        }

        public final void azB() {
            ak.yW();
            com.tencent.mm.model.c.vf().set(81, Boolean.valueOf(false));
            if (com.tencent.mm.sdk.platformtools.ak.isNetworkConnected(this.onr.ols.nDR.nEl)) {
                this.onr.bEo();
            } else {
                com.tencent.mm.ah.a.a(this.onr.ols.nDR.nEl, 2131235928, null);
            }
        }

        public final void azC() {
            Intent intent = new Intent();
            intent.putExtra("enterprise_scene", 4);
            intent.putExtra("enterprise_biz_name", this.onr.bEn());
            intent.putExtra("biz_chat_chat_id", this.onr.ols.bFS());
            com.tencent.mm.ay.c.b(this.onr.ols.nDR.nEl, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent);
        }

        public final void azD() {
            if (this.onr.onl) {
                Intent intent = new Intent();
                intent.putExtra("enter_scene", 1);
                intent.putExtra("chatroom_name", this.onr.bEn());
                com.tencent.mm.ay.c.b(this.onr.ols.nDR.nEl, "aa", ".ui.LaunchAAUI", intent);
                g.iuh.h(13721, Integer.valueOf(1), Integer.valueOf(1));
            }
        }
    };
    private Object lock = new Object();
    private boolean nQK;
    private ChattingUI.a ols;
    ListView ong;
    private cp onh;
    private h oni;
    private String onj;
    private String onk;
    private boolean onl;
    private boolean onm;
    boolean onn;
    private volatile boolean ono = false;
    private volatile boolean onp = false;
    private boolean onq = false;

    class AnonymousClass11 implements Runnable {
        final /* synthetic */ boolean dtR = true;
        final /* synthetic */ ac onr;
        final /* synthetic */ boolean ons;

        AnonymousClass11(ac acVar, boolean z, boolean z2) {
            this.onr = acVar;
            this.ons = z2;
        }

        public final void run() {
            int lastVisiblePosition = this.onr.ong.getLastVisiblePosition();
            int count = this.onr.ong.getCount() - 1;
            v.v("MicroMsg.ChattingFooterEventImpl", "last visible/adapter=" + lastVisiblePosition + "/" + count + " " + this.dtR);
            if (lastVisiblePosition >= count - 1 || this.dtR) {
                lastVisiblePosition = this.onr.onh.getCount();
                if (lastVisiblePosition <= 1 || !((at) this.onr.onh.getItem(lastVisiblePosition - 2)).isSystem()) {
                    ChattingUI.c.a(this.onr.ong, count, this.ons);
                    return;
                }
                ChattingUI.c.a(this.onr.ong, count - 1, 0, this.ons);
            }
        }
    }

    static /* synthetic */ void k(ac acVar) {
        acVar.ols.iT(false);
        acVar.ols.iS(false);
        if (acVar.oni != null) {
            ab.Ki("keep_app_silent");
            acVar.hjH.HG(acVar.ols.getString(2131231734));
            acVar.oni.by(acVar.bEn());
            acVar.onk = acVar.oni.getFileName();
            acVar.oni.a(acVar.hjM);
            acVar.ewK.vibrate(50);
            acVar.onh.notifyDataSetChanged();
            acVar.jG(true);
            acVar.oni.a(acVar.exf);
            return;
        }
        v.e("MicroMsg.ChattingFooterEventImpl", "startRecording recorder is null and stop recod");
    }

    public ac(ListView listView, cp cpVar, ChattingUI.a aVar, ChatFooter chatFooter, String str) {
        this.ong = listView;
        this.onh = cpVar;
        this.ols = aVar;
        this.hjH = chatFooter;
        this.onj = str;
        ak.yW();
        this.euW = com.tencent.mm.model.c.wH().LX(str);
        this.onl = aVar.bEn().endsWith("@chatroom");
        this.onm = m.ey(aVar.bEn());
        boolean z = this.onl || this.onm;
        this.nQK = z;
        this.ewK = (Vibrator) aVar.nDR.nEl.getSystemService("vibrator");
        if (m.eY(this.onj)) {
            this.oni = new com.tencent.mm.plugin.subapp.c.i();
            v.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new VoiceRemindRecorder().");
        } else {
            String str2 = this.onj;
            if (m.fl(str2)) {
                z = true;
            } else {
                ak.yW();
                com.tencent.mm.e.b.ab LX = com.tencent.mm.model.c.wH().LX(str2);
                if (LX != null && LX.bvm()) {
                    BizInfo hw = com.tencent.mm.modelbiz.e.hw(LX.field_username);
                    if (hw != null) {
                        ExtInfo aX = hw.aX(false);
                        if (aX != null) {
                            if (aX.cBx != null) {
                                aX.cBB = "1".equals(aX.cBx.optString("CanReceiveSpeexVoice"));
                            }
                            if (aX.cBB) {
                                v.i("MicroMsg.BizInfoStorageLogic", "bizinfo name=" + LX.field_username + " canReceiveSpeexVoice");
                                z = true;
                            }
                        }
                    }
                }
                z = false;
            }
            if (z) {
                this.oni = new com.tencent.mm.c.b.h(this.ols.nDR.nEl, true);
                v.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, use Speex");
            } else {
                this.oni = new com.tencent.mm.c.b.h(this.ols.nDR.nEl, false);
                v.i("MicroMsg.ChattingFooterEventImpl", "initRecorder new SceneVoiceRecorder, not use Speex");
            }
        }
        this.oni.a(this.hjM);
        this.oni.a(this.exf);
        chatFooter.a(this.hku);
    }

    public final boolean azh() {
        synchronized (this.lock) {
            this.ono = true;
        }
        if (this.onp) {
            this.onp = false;
            releaseWakeLock();
            if (bEm()) {
                this.hjH.anf();
                v.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request resetRcdStatus");
            } else {
                this.hjH.bpI();
                v.i("MicroMsg.ChattingFooterEventImpl", "record stop on stop request setRcdTooShort");
            }
            this.onh.oqd.bDS();
            this.ols.xm(4);
            this.ols.stopSignalling();
            wZ(1);
            this.ols.jK(false);
            return true;
        }
        v.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        return false;
    }

    public final boolean azj() {
        v.v("MicroMsg.ChattingFooterEventImpl", "record cancel on cancel request");
        synchronized (this.lock) {
            this.ono = true;
        }
        if (this.onp) {
            this.onp = false;
            releaseWakeLock();
            this.ols.iT(true);
            this.ols.iS(true);
            if (this.oni != null) {
                this.oni.cancel();
                this.exb.QI();
                this.exc.QI();
            }
            this.hjH.anf();
            this.onh.oqd.bDS();
            this.ols.xm(4);
            this.ols.stopSignalling();
            wZ(1);
            this.ols.jK(false);
            return true;
        }
        v.i("MicroMsg.ChattingFooterEventImpl", "jacks in voice rcd stop but not begin.");
        return false;
    }

    public final boolean azk() {
        if (com.tencent.mm.as.u.bj(this.ols.nDR.nEl) || com.tencent.mm.ah.a.aT(this.ols.nDR.nEl)) {
            v.d("MicroMsg.ChattingFooterEventImpl", "voip is running, cann't record voice");
            return false;
        }
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            if (!com.tencent.mm.compatible.e.b.se()) {
                com.tencent.mm.ui.base.g.a(this.ols.nDR.nEl, this.ols.getString(2131231161), this.ols.getString(2131231098), this.ols.getString(2131231100), true, new OnClickListener(this) {
                    final /* synthetic */ ac onr;

                    {
                        this.onr = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.compatible.e.b.ay(this.onr.ols.nDR.nEl);
                    }
                });
            }
            if (this.oni != null) {
                if (this.ewH == null) {
                    try {
                        this.ewH = new ToneGenerator(3, (int) ((((float) this.ols.nDR.diI.getStreamMaxVolume(3)) / ((float) this.ols.nDR.diI.getStreamVolume(3))) * 100.0f));
                        v.i("MicroMsg.ChattingFooterEventImpl", "init tone");
                    } catch (Exception e) {
                        v.e("MicroMsg.ChattingFooterEventImpl", "init tone failed");
                    }
                }
                if (this.ewH != null) {
                    this.ewH.startTone(24);
                    v.i("MicroMsg.ChattingFooterEventImpl", "start tone");
                }
                this.ong.postDelayed(new Runnable(this) {
                    final /* synthetic */ ac onr;

                    {
                        this.onr = r1;
                    }

                    public final void run() {
                        if (this.onr.ewH != null) {
                            this.onr.ewH.stopTone();
                            v.i("MicroMsg.ChattingFooterEventImpl", "stopTone");
                        }
                    }
                }, 200);
            }
            synchronized (this.lock) {
                this.ono = false;
            }
            new com.tencent.mm.sdk.platformtools.ac(Looper.myLooper()).postDelayed(new Runnable(this) {
                final /* synthetic */ ac onr;

                {
                    this.onr = r1;
                }

                public final void run() {
                    synchronized (this.onr.lock) {
                        if (this.onr.ono) {
                            v.i("MicroMsg.ChattingFooterEventImpl", "jacks already stop before begin!!");
                            return;
                        }
                        this.onr.onp = true;
                        this.onr.exb.ea(100);
                        this.onr.onq = false;
                        this.onr.exc.ea(200);
                        this.onr.hjH.ug(this.onr.ong.getHeight());
                        this.onr.onh.oqd.bDR();
                        ac.k(this.onr);
                        this.onr.ong.setKeepScreenOn(true);
                        this.onr.ols.xm(3);
                        this.onr.ols.keepSignalling();
                        ac.wZ(0);
                        this.onr.ols.jK(true);
                    }
                }
            }, 200);
            return true;
        }
        s.ey(this.ols.nDR.nEl);
        v.e("MicroMsg.ChattingFooterEventImpl", "onVoiceRcdStartRequest isSDCardAvailable() failed and return.");
        return false;
    }

    public final boolean wm(String str) {
        jG(false);
        bEl();
        return this.ols.OV(str);
    }

    public final void azl() {
        jG(false);
        bEl();
    }

    public final void azm() {
        jG(false);
        bEl();
    }

    public final void azn() {
        jG(false);
        bEl();
    }

    private void bEl() {
        this.ong.smoothScrollBy(0, 0);
    }

    @SuppressLint({"NewApi"})
    @Deprecated
    private void jG(boolean z) {
        this.ong.postDelayed(new AnonymousClass11(this, true, z), 10);
    }

    private void releaseWakeLock() {
        this.ong.setKeepScreenOn(false);
    }

    private boolean bEm() {
        this.ols.iT(true);
        this.ols.iS(true);
        if (this.oni != null) {
            boolean z;
            boolean ph;
            at atVar;
            long R;
            if (this.oni.pq()) {
                z = this.euW.field_username.equals("medianote") && (k.xJ() & 16384) == 0;
                if (z) {
                    z = true;
                    ph = this.oni.ph();
                    this.exb.QI();
                    this.exc.QI();
                    if (z) {
                        atVar = new at();
                        atVar.cH("medianote");
                        atVar.setType(34);
                        atVar.di(1);
                        atVar.cI(this.onk);
                        atVar.dh(2);
                        atVar.setContent(n.b(k.xF(), (long) this.oni.pp(), false));
                        atVar.z(aw.fN("medianote"));
                        if (this.oni.pt() == 2) {
                            atVar.cN("SOURCE_SILK_FILE");
                        }
                        ak.yW();
                        R = com.tencent.mm.model.c.wJ().R(atVar);
                        if (R > 0) {
                            v.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
                        } else {
                            v.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = " + R);
                        }
                    }
                    ab.Kj("keep_app_silent");
                    return ph;
                }
            }
            z = false;
            ph = this.oni.ph();
            this.exb.QI();
            this.exc.QI();
            if (z) {
                atVar = new at();
                atVar.cH("medianote");
                atVar.setType(34);
                atVar.di(1);
                atVar.cI(this.onk);
                atVar.dh(2);
                atVar.setContent(n.b(k.xF(), (long) this.oni.pp(), false));
                atVar.z(aw.fN("medianote"));
                if (this.oni.pt() == 2) {
                    atVar.cN("SOURCE_SILK_FILE");
                }
                ak.yW();
                R = com.tencent.mm.model.c.wJ().R(atVar);
                if (R > 0) {
                    v.i("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg success, msgId = " + R);
                } else {
                    v.e("MicroMsg.ChattingFooterEventImpl", "insertLocalMsg fail");
                }
            }
            ab.Kj("keep_app_silent");
            return ph;
        }
        v.i("MicroMsg.ChattingFooterEventImpl", "stopRecording recorder == null");
        return false;
    }

    public final String bEn() {
        if (this.euW == null || !u.ew(this.euW.field_username)) {
            return this.euW == null ? null : this.euW.field_username;
        } else {
            return this.onj;
        }
    }

    public final void release() {
        if (this.ewH != null) {
            v.i("MicroMsg.ChattingFooterEventImpl", "release");
            this.ewH.release();
            this.ewH = null;
        }
    }

    public final void onPause() {
        if (this.ewH != null) {
            v.i("MicroMsg.ChattingFooterEventImpl", "release");
            this.ewH.release();
            this.ewH = null;
        }
        bEm();
        this.exb.QI();
        this.exc.QI();
    }

    public final void eg(boolean z) {
        if (z) {
            this.ols.keepSignalling();
        } else {
            this.ols.stopSignalling();
        }
    }

    private static void wZ(int i) {
        com.tencent.mm.sdk.c.b kxVar = new kx();
        kxVar.bmt.state = i;
        com.tencent.mm.sdk.c.a.nhr.z(kxVar);
    }

    public final void bEo() {
        v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.CAMERA", 22, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.ols.bzo());
        if (com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.CAMERA", 22, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
            v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 22, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.ols.bzo());
            if (com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 22, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk");
                Intent intent = new Intent();
                if (com.tencent.mm.pluginsdk.j.a.lxQ.vJ(bEn())) {
                    v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but now is in share location!");
                    Toast.makeText(aa.getContext(), 2131233931, 0).show();
                    return;
                }
                if (bEn() != null) {
                    boolean z;
                    List<String> wJ = com.tencent.mm.pluginsdk.j.a.lxR.wJ(bEn());
                    ak.yW();
                    String str = (String) com.tencent.mm.model.c.vf().get(2, null);
                    boolean wH = com.tencent.mm.pluginsdk.j.a.lxR.wH(bEn());
                    for (String str2 : wJ) {
                        if (str != null && str.equals(str2)) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (wJ.size() < 9 || z) {
                        if (z) {
                            if (com.tencent.mm.pluginsdk.j.a.lxR.aCc()) {
                                v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in it!");
                                Toast.makeText(aa.getContext(), aa.getContext().getString(2131233928), 0).show();
                                return;
                            }
                            v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, already inlist, but in fact not multitalking now!");
                        }
                        if (com.tencent.mm.pluginsdk.j.a.lxR.aCu()) {
                            v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but already in VoIP or multitalk!");
                            Toast.makeText(aa.getContext(), aa.getContext().getString(2131233928), 0).show();
                            return;
                        } else if (wH) {
                            v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but this group already in multitalk, alter take in or not tips!");
                            com.tencent.mm.ui.base.g.b(this.ols.nDR.nEl, this.ols.getString(2131233959), SQLiteDatabase.KeyEmpty, this.ols.getString(2131233912), this.ols.getString(2131233910), new OnClickListener(this) {
                                final /* synthetic */ ac onr;

                                {
                                    this.onr = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (!com.tencent.mm.pluginsdk.j.a.lxR.wH(this.onr.bEn())) {
                                        Toast.makeText(aa.getContext(), aa.getContext().getString(2131233954), 0).show();
                                    } else if (!com.tencent.mm.pluginsdk.j.a.lxR.wO(this.onr.bEn())) {
                                        Toast.makeText(aa.getContext(), aa.getContext().getString(2131233921), 0).show();
                                    }
                                }
                            }, null);
                            return;
                        }
                    }
                    v.i("MicroMsg.ChattingFooterEventImpl", "onEnterMultiTalk, but > max 9 members!");
                    Toast.makeText(aa.getContext(), aa.getContext().getString(2131233942, new Object[]{Integer.valueOf(9)}), 0).show();
                    return;
                }
                intent.putExtra("chatroomName", bEn());
                intent.putExtra("key_need_gallery", true);
                intent.putExtra("titile", this.ols.getString(2131233949));
                com.tencent.mm.ay.c.b(this.ols.nDR.nEl, "multitalk", ".ui.MultiTalkSelectContactUI", intent);
            }
        }
    }

    public final void bEp() {
        v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.CAMERA", 18, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.ols.bzo());
        if (com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.CAMERA", 18, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
            v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 18, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.ols.bzo());
            if (!com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 18, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                return;
            }
            if (com.tencent.mm.sdk.b.b.bsI() || q.drf) {
                l lVar = new l(this.ols.nDR.nEl);
                lVar.jXn = new c(this) {
                    final /* synthetic */ ac onr;

                    {
                        this.onr = r1;
                    }

                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.d(1, this.onr.ols.getString(2131231049));
                        lVar.d(4, "Sight");
                        lVar.d(5, "拍摄参数设置面板");
                    }
                };
                lVar.jXo = new d(this) {
                    final /* synthetic */ ac onr;

                    {
                        this.onr = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                Intent intent = new Intent();
                                g.iuh.h(13822, Integer.valueOf(1), Integer.valueOf(1));
                                com.tencent.mm.pluginsdk.ui.tools.l.a(this.onr.ols, intent, this.onr.bEn());
                                return;
                            case 4:
                                this.onr.ols.bFq();
                                return;
                            case 5:
                                com.tencent.mm.ay.c.b(this.onr.ols.nDR.nEl, "mmsight", ".ui.SightSettingsUI", new Intent());
                                return;
                            default:
                                return;
                        }
                    }
                };
                lVar.aXZ();
            } else if (u.dW(bEn())) {
                com.tencent.mm.pluginsdk.ui.tools.l.a(this.ols, 226, new Intent(), 1, bEn(), 2);
            } else if (q.drg) {
                this.ols.bFq();
            } else {
                g.iuh.h(13822, Integer.valueOf(1), Integer.valueOf(1));
                com.tencent.mm.pluginsdk.ui.tools.l.a(this.ols, new Intent(), bEn());
            }
        }
    }

    public final void bEq() {
        v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 83, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.ols.bzo());
        if (com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 83, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
            if (this.hjH.bqe()) {
                this.hjH.bqg();
            }
            com.tencent.mm.sdk.c.b qiVar = new qi();
            qiVar.brC.bdn = 5;
            qiVar.brC.bdo = bEn();
            qiVar.brC.context = this.ols.nDR.nEl;
            qiVar.brC.brx = 3;
            com.tencent.mm.sdk.c.a.nhr.z(qiVar);
            g.iuh.h(11033, Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(0));
        }
    }

    public final void bEr() {
        v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.CAMERA", 21, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.ols.bzo());
        if (com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.CAMERA", 21, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
            v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 21, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.ols.bzo());
            if (com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 21, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                if (this.hjH.bqe()) {
                    this.hjH.bqg();
                }
                com.tencent.mm.sdk.c.b qiVar = new qi();
                qiVar.brC.bdn = 5;
                qiVar.brC.bdo = bEn();
                qiVar.brC.context = this.ols.nDR.nEl;
                qiVar.brC.brx = 2;
                com.tencent.mm.sdk.c.a.nhr.z(qiVar);
            }
        }
    }

    public final void aGP() {
        v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 82, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.ols.bzo());
        if (com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 82, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
            com.tencent.mm.sdk.c.b qiVar = new qi();
            qiVar.brC.bdn = 5;
            qiVar.brC.bdo = bEn();
            qiVar.brC.context = this.ols.nDR.nEl;
            qiVar.brC.brx = 4;
            if (this.hjH.bqe()) {
                this.hjH.bqg();
            }
            com.tencent.mm.sdk.c.a.nhr.z(qiVar);
        }
    }

    public final void aGQ() {
        v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.CAMERA", 19, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.ols.bzo());
        if (com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.CAMERA", 19, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
            v.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 19, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)), be.bur(), this.ols.bzo());
            if (com.tencent.mm.pluginsdk.i.a.a(this.ols.bzo(), "android.permission.RECORD_AUDIO", 19, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty)) {
                com.tencent.mm.sdk.c.b qiVar = new qi();
                qiVar.brC.bdn = 5;
                qiVar.brC.bdo = bEn();
                qiVar.brC.context = this.ols.nDR.nEl;
                qiVar.brC.brx = 2;
                if (this.hjH.bqe()) {
                    this.hjH.bqg();
                }
                com.tencent.mm.sdk.c.a.nhr.z(qiVar);
            }
        }
    }

    public final void bEs() {
        this.ols.jP(false);
        this.hjH.bqg();
    }

    public final void bEt() {
        if (!com.tencent.mm.pluginsdk.ui.tools.l.a(this.ols, e.cgg, "microMsg." + System.currentTimeMillis() + ".jpg")) {
            Toast.makeText(this.ols.nDR.nEl, this.ols.getString(2131234875), 1).show();
        }
    }
}
