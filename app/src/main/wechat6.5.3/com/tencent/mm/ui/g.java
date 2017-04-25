package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ae.n;
import com.tencent.mm.ae.o;
import com.tencent.mm.ar.l;
import com.tencent.mm.e.a.bt;
import com.tencent.mm.e.a.fu;
import com.tencent.mm.e.a.gq;
import com.tencent.mm.e.a.hi;
import com.tencent.mm.e.a.hl;
import com.tencent.mm.e.a.ho;
import com.tencent.mm.e.a.kg;
import com.tencent.mm.e.a.lg;
import com.tencent.mm.e.a.li;
import com.tencent.mm.e.a.mz;
import com.tencent.mm.e.a.na;
import com.tencent.mm.e.a.nd;
import com.tencent.mm.e.a.or;
import com.tencent.mm.e.a.po;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.plugin.ipcall.d;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.j.al;
import com.tencent.mm.pluginsdk.j.r;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.account.FacebookFriendUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindgooglecontact.BindGoogleContactIntroUI;
import com.tencent.mm.ui.bindgooglecontact.GoogleFriendUI;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.ui.friend.FriendSnsPreference;
import com.tencent.mm.ui.tools.s;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends a implements ae, af, a, b {
    private f dxf;
    private CheckBox hEZ;
    private h hFb = null;
    c jmu = new c<or>(this) {
        final /* synthetic */ g nAK;

        {
            this.nAK = r2;
            this.nhz = or.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            v.i("MicroMsg.FindMoreFriendsUI", "mark sns read %d", Integer.valueOf(((or) bVar).bpY.bdf));
            if (((or) bVar).bpY.bdf == 9) {
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass9 nAS;

                    {
                        this.nAS = r1;
                    }

                    public final void run() {
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(68377, SQLiteDatabase.KeyEmpty);
                        if (this.nAS.nAK.dxf != null) {
                            this.nAS.nAK.dxf.notifyDataSetChanged();
                        }
                    }
                });
            }
            return true;
        }
    };
    private com.tencent.mm.pluginsdk.d.a lPq = new com.tencent.mm.pluginsdk.d.a(this) {
        final /* synthetic */ g nAK;

        {
            this.nAK = r1;
        }

        public final void w(com.tencent.mm.sdk.c.b bVar) {
            v.d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", bVar);
            if (bVar instanceof hl) {
                this.nAK.blU();
            }
        }
    };
    private ac mHandler = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ g nAK;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.nAK.dxf != null) {
                        this.nAK.iK(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private boolean nAA = false;
    private boolean nAB = false;
    private boolean nAC = true;
    private String nAD;
    c nAE = new c<hi>(this) {
        final /* synthetic */ g nAK;

        {
            this.nAK = r2;
            this.nhz = hi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (al.lyl != null) {
                com.tencent.mm.plugin.report.service.g.iuh.h(11178, be.ma(r0.aZr()), r0.aZs().aZd(), Integer.valueOf(g.bzj()));
            }
            this.nAK.iK(true);
            return true;
        }
    };
    c nAF = new c<bt>(this) {
        final /* synthetic */ g nAK;

        {
            this.nAK = r2;
            this.nhz = bt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            v.i("MicroMsg.FindMoreFriendsUI", "dynamic config file change");
            this.nAK.mHandler.sendEmptyMessage(1);
            return true;
        }
    };
    private com.tencent.mm.pluginsdk.d.a nAG = new com.tencent.mm.pluginsdk.d.a(this) {
        final /* synthetic */ g nAK;

        {
            this.nAK = r1;
        }

        public final void w(com.tencent.mm.sdk.c.b bVar) {
            if (bVar instanceof fu) {
                g.e(this.nAK);
            }
        }
    };
    private com.tencent.mm.pluginsdk.d.a nAH = new com.tencent.mm.pluginsdk.d.a(this) {
        final /* synthetic */ g nAK;

        {
            this.nAK = r1;
        }

        public final void w(com.tencent.mm.sdk.c.b bVar) {
            if (bVar instanceof na) {
                this.nAK.blU();
            }
        }
    };
    private c nAI = new c<mz>(this) {
        final /* synthetic */ g nAK;

        {
            this.nAK = r2;
            this.nhz = mz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (((mz) bVar) instanceof mz) {
                this.nAK.blU();
            }
            return false;
        }
    };
    o.a nAJ = new o.a(this) {
        final /* synthetic */ g nAK;

        {
            this.nAK = r1;
        }

        public final void g(final String str, final Bitmap bitmap) {
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass15 nAU;

                public final void run() {
                    IconPreference iconPreference = (IconPreference) this.nAU.nAK.dxf.Ow("jd_market_entrance");
                    if (iconPreference != null) {
                        if (str.equals(this.nAU.nAK.nAx)) {
                            iconPreference.drawable = new BitmapDrawable(this.nAU.nAK.nDR.nEl.getResources(), bitmap);
                            this.nAU.nAK.nAx = null;
                        } else if (str.equals(this.nAU.nAK.nAy)) {
                            iconPreference.J(bitmap);
                            this.nAU.nAK.nAy = null;
                        }
                        this.nAU.nAK.dxf.notifyDataSetChanged();
                    }
                }
            });
        }
    };
    private View nAt;
    private boolean nAu = false;
    private String nAv = SQLiteDatabase.KeyEmpty;
    private int nAw = 0;
    private String nAx = null;
    private String nAy = null;
    private boolean nAz = false;

    static /* synthetic */ void e(g gVar) {
        gVar.bzl();
        gVar.dxf.notifyDataSetChanged();
    }

    public final int Oo() {
        com.tencent.mm.ay.c.brh();
        return 2131099695;
    }

    public final boolean aXG() {
        return false;
    }

    public final boolean Sk() {
        return true;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        v.i("MicroMsg.FindMoreFriendsUI", "onActivityCreated");
        this.dxf = this.ocZ;
    }

    private void blU() {
        String str;
        f fVar;
        f fVar2;
        boolean z;
        IconPreference iconPreference;
        boolean z2;
        String str2;
        boolean z3;
        String str3;
        int Kw;
        int Kw2;
        String ah;
        Boolean valueOf;
        int xJ;
        r rVar;
        if (com.tencent.mm.ay.c.EH("sns")) {
            this.dxf.aO("album_dyna_photo_ui_title", false);
            FriendSnsPreference friendSnsPreference = (FriendSnsPreference) this.dxf.Ow("album_dyna_photo_ui_title");
            if (friendSnsPreference != null) {
                z3 = (k.xQ() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0;
                if (z3) {
                    friendSnsPreference.drawable = com.tencent.mm.bd.a.a(this.nDR.nEl, 2131165561);
                    ak.yW();
                    boolean c = be.c((Boolean) com.tencent.mm.model.c.vf().get(48, null));
                    friendSnsPreference.wG(8);
                    friendSnsPreference.wM(8);
                    if (c) {
                        friendSnsPreference.wG(0);
                        friendSnsPreference.aO(getString(2131231102), 2130838762);
                    }
                    ak.yW();
                    this.nAv = (String) com.tencent.mm.model.c.vf().get(68377, null);
                    v.i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", be.ah(this.nAv, SQLiteDatabase.KeyEmpty));
                    friendSnsPreference.wL(0);
                    if (be.kS(this.nAv)) {
                        ak.yW();
                        if (((Boolean) com.tencent.mm.model.c.vf().get(589825, Boolean.valueOf(false))).booleanValue()) {
                            friendSnsPreference.wJ(2131165761);
                            friendSnsPreference.wK(0);
                            friendSnsPreference.wM(8);
                        } else {
                            friendSnsPreference.wK(8);
                        }
                    } else {
                        friendSnsPreference.wK(0);
                        ak.yW();
                        friendSnsPreference.wM(be.a((Boolean) com.tencent.mm.model.c.vf().get(68384, null), true) ? 0 : 8);
                        str = this.nAv;
                        friendSnsPreference.fgy = null;
                        friendSnsPreference.fgz = -1;
                        friendSnsPreference.oNV = str;
                        if (friendSnsPreference.fgD != null) {
                            com.tencent.mm.pluginsdk.ui.a.b.m(friendSnsPreference.fgD, str);
                        }
                    }
                    if (j.ak.lyg != null) {
                        this.nAw = j.ak.lyg.Kw();
                    }
                    if (this.nAw != 0) {
                        friendSnsPreference.wG(0);
                        friendSnsPreference.aO(this.nAw, s.eN(this.nDR.nEl));
                    }
                    friendSnsPreference.wI(8);
                    friendSnsPreference.wH(8);
                    com.tencent.mm.sdk.c.a.nhr.z(new po());
                }
                fVar = this.dxf;
                str3 = "album_dyna_photo_ui_title";
                if (z3) {
                    fVar2 = fVar;
                    str = str3;
                    z = false;
                } else {
                    fVar2 = fVar;
                    str = str3;
                    z = true;
                }
            }
            if (com.tencent.mm.ay.c.EH("nearby")) {
                fVar2 = this.dxf;
                str = "find_friends_by_near";
                z = true;
            } else {
                this.dxf.aO("find_friends_by_near", false);
                iconPreference = (IconPreference) this.dxf.Ow("find_friends_by_near");
                if (iconPreference != null) {
                    com.tencent.mm.sdk.c.b hoVar;
                    hoVar = new ho();
                    hoVar.bhk.bdf = 7;
                    com.tencent.mm.sdk.c.a.nhr.z(hoVar);
                    if (hoVar.bhl.aYN) {
                        iconPreference.wK(0);
                        iconPreference.wJ(2130838665);
                        iconPreference.fgG = new LayoutParams(-2, -2);
                        iconPreference.fgG.addRule(13);
                        if (iconPreference.fgD != null) {
                            iconPreference.fgD.setLayoutParams(iconPreference.fgG);
                        }
                    } else {
                        iconPreference.wK(8);
                    }
                    Kw = l.KE().Kw();
                    if (com.tencent.mm.aw.a.bmn()) {
                        if (Kw <= 0) {
                            iconPreference.wG(0);
                            iconPreference.aO(String.valueOf(Kw), s.eN(this.nDR.nEl));
                        } else {
                            iconPreference.wG(8);
                            iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                        }
                    } else if (Kw <= 0) {
                        iconPreference.wI(0);
                    } else {
                        iconPreference.wI(8);
                    }
                    if (k.yo().booleanValue()) {
                        ak.yW();
                        this.nAB = be.c((Boolean) com.tencent.mm.model.c.vf().get(340232, null));
                        if (!this.nAB) {
                            iconPreference.wI(0);
                        }
                    }
                    z = (k.xQ() & 512) != 0;
                    fVar2 = this.dxf;
                    str = "find_friends_by_near";
                    if (z) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (com.tencent.mm.ay.c.EH("shake")) {
                    fVar2 = this.dxf;
                    str = "find_friends_by_shake";
                    z = true;
                } else {
                    this.dxf.aO("find_friends_by_shake", false);
                    iconPreference = (IconPreference) this.dxf.Ow("find_friends_by_shake");
                    if (iconPreference != null) {
                        z2 = (k.xQ() & FileUtils.S_IRUSR) != 0;
                        if (z2) {
                            Kw2 = l.KF().Kw() + j.a.bmq().aNH();
                            if (Kw2 <= 0) {
                                iconPreference.wG(0);
                                iconPreference.aO(String.valueOf(Kw2), 2130839356);
                            } else {
                                iconPreference.wG(8);
                                iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                            }
                            iconPreference.wK(8);
                            j.a.bmq().aNI();
                            if (j.a.bmq().aNJ()) {
                                z3 = false;
                            } else {
                                z3 = com.tencent.mm.p.c.us().ay(262154, 266258);
                            }
                            if (z3) {
                                iconPreference.wI(8);
                            } else {
                                ak.yW();
                                str = (String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, SQLiteDatabase.KeyEmpty);
                                if (TextUtils.isEmpty(str)) {
                                    iconPreference.wI(8);
                                    iconPreference.wG(0);
                                    iconPreference.aO(str, 2130839356);
                                } else if (Kw2 <= 0) {
                                    iconPreference.wI(0);
                                } else {
                                    iconPreference.wI(0);
                                    iconPreference.wG(8);
                                    iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                                }
                            }
                            ak.yW();
                            ah = be.ah((String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), SQLiteDatabase.KeyEmpty);
                            ak.yW();
                            valueOf = Boolean.valueOf(be.a((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
                            ak.yW();
                            Kw = ((Integer) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
                            if (valueOf.booleanValue() || ah == null || ah.equals(SQLiteDatabase.KeyEmpty) || Kw2 > 0 || z3) {
                                iconPreference.wH(8);
                            } else if (Kw == 0) {
                                iconPreference.wI(8);
                                iconPreference.wH(0);
                                String[] split = ah.split(",");
                                if (split.length > 0) {
                                    iconPreference.L(split[0], -1, Color.parseColor("#8c8c8c"));
                                }
                                iconPreference.jy(true);
                                iconPreference.wL(8);
                            } else if (Kw == 1) {
                                iconPreference.wH(8);
                                iconPreference.wG(0);
                                iconPreference.ocE = true;
                            }
                            if (k.yo().booleanValue()) {
                                ak.yW();
                                this.nAA = be.c((Boolean) com.tencent.mm.model.c.vf().get(340231, null));
                                if (!this.nAA) {
                                    iconPreference.wI(0);
                                }
                            }
                        }
                        fVar = this.dxf;
                        str3 = "find_friends_by_shake";
                        if (z2) {
                            fVar2 = fVar;
                            str = str3;
                            z = true;
                        } else {
                            fVar2 = fVar;
                            str = str3;
                            z = false;
                        }
                    }
                    if (com.tencent.mm.ay.c.EH("bottle")) {
                        v.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                        this.dxf.aO("voice_bottle", true);
                    } else {
                        this.dxf.aO("voice_bottle", false);
                        if (((IconPreference) this.dxf.Ow("voice_bottle")) != null) {
                            if ((k.xQ() & 64) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            this.nAu = z;
                            v.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.nAu));
                            fVar = this.dxf;
                            str2 = "voice_bottle";
                            if (this.nAu) {
                                z = true;
                            } else {
                                z = false;
                            }
                            fVar.aO(str2, z);
                            if (this.nAu) {
                                iconPreference = (IconPreference) this.dxf.Ow("voice_bottle");
                                if (iconPreference != null) {
                                    Kw = com.tencent.mm.model.g.xD();
                                    if (Kw > 0) {
                                        iconPreference.aO(String.valueOf(Kw), s.eN(this.nDR.nEl));
                                    }
                                    xJ = k.xJ();
                                    if (Kw > 0 || (WXMediaMessage.THUMB_LENGTH_LIMIT & xJ) != 0) {
                                        iconPreference.wG(8);
                                    } else {
                                        iconPreference.wG(0);
                                    }
                                }
                            }
                        }
                    }
                    if (com.tencent.mm.ay.c.EH("game")) {
                        this.dxf.aO("more_tab_game_recommend", true);
                    } else {
                        this.dxf.aO("more_tab_game_recommend", false);
                        rVar = j.a.lxN;
                        if (rVar != null) {
                            if (rVar.bY(this.nDR.nEl)) {
                                this.dxf.aO("more_tab_game_recommend", true);
                            } else {
                                bzl();
                            }
                        }
                    }
                    if (com.tencent.mm.ay.c.EH("scanner")) {
                        this.dxf.aO("find_friends_by_qrcode", true);
                    } else {
                        this.dxf.aO("find_friends_by_qrcode", false);
                    }
                    this.dxf.aO("find_friends_by_facebook", true);
                    fVar = this.dxf;
                    str2 = "find_friends_by_google_account";
                    if (be.He()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    fVar.aO(str2, z);
                    iK(false);
                    this.dxf.aO("settings_emoji_store", true);
                    this.dxf.notifyDataSetChanged();
                    if (d.atT()) {
                        this.dxf.aO("ip_call_entrance", true);
                        return;
                    }
                    this.dxf.aO("ip_call_entrance", false);
                    iconPreference = (IconPreference) this.dxf.Ow("ip_call_entrance");
                    ak.yW();
                    if (((Integer) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)) {
                        ak.yW();
                        if (!((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                            iconPreference.wG(8);
                            iconPreference.wL(8);
                            ak.yW();
                            str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                            if (be.kS(str)) {
                                iconPreference.L(str, -1, -7566196);
                                iconPreference.jy(true);
                                iconPreference.wH(0);
                                iconPreference.wG(8);
                            } else {
                                iconPreference.wH(8);
                                iconPreference.jy(false);
                            }
                            this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
                        }
                    }
                    iconPreference.wG(0);
                    iconPreference.aO(getString(2131231102), 2130838762);
                    iconPreference.wL(8);
                    ak.yW();
                    str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                    if (be.kS(str)) {
                        iconPreference.wH(8);
                        iconPreference.jy(false);
                    } else {
                        iconPreference.L(str, -1, -7566196);
                        iconPreference.jy(true);
                        iconPreference.wH(0);
                        iconPreference.wG(8);
                    }
                    this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
                }
                fVar2.aO(str, z);
                if (com.tencent.mm.ay.c.EH("bottle")) {
                    this.dxf.aO("voice_bottle", false);
                    if (((IconPreference) this.dxf.Ow("voice_bottle")) != null) {
                        if ((k.xQ() & 64) != 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        this.nAu = z;
                        v.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.nAu));
                        fVar = this.dxf;
                        str2 = "voice_bottle";
                        if (this.nAu) {
                            z = false;
                        } else {
                            z = true;
                        }
                        fVar.aO(str2, z);
                        if (this.nAu) {
                            iconPreference = (IconPreference) this.dxf.Ow("voice_bottle");
                            if (iconPreference != null) {
                                Kw = com.tencent.mm.model.g.xD();
                                if (Kw > 0) {
                                    iconPreference.aO(String.valueOf(Kw), s.eN(this.nDR.nEl));
                                }
                                xJ = k.xJ();
                                if (Kw > 0) {
                                }
                                iconPreference.wG(8);
                            }
                        }
                    }
                } else {
                    v.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                    this.dxf.aO("voice_bottle", true);
                }
                if (com.tencent.mm.ay.c.EH("game")) {
                    this.dxf.aO("more_tab_game_recommend", false);
                    rVar = j.a.lxN;
                    if (rVar != null) {
                        if (rVar.bY(this.nDR.nEl)) {
                            bzl();
                        } else {
                            this.dxf.aO("more_tab_game_recommend", true);
                        }
                    }
                } else {
                    this.dxf.aO("more_tab_game_recommend", true);
                }
                if (com.tencent.mm.ay.c.EH("scanner")) {
                    this.dxf.aO("find_friends_by_qrcode", false);
                } else {
                    this.dxf.aO("find_friends_by_qrcode", true);
                }
                this.dxf.aO("find_friends_by_facebook", true);
                fVar = this.dxf;
                str2 = "find_friends_by_google_account";
                if (be.He()) {
                    z = false;
                } else {
                    z = true;
                }
                fVar.aO(str2, z);
                iK(false);
                this.dxf.aO("settings_emoji_store", true);
                this.dxf.notifyDataSetChanged();
                if (d.atT()) {
                    this.dxf.aO("ip_call_entrance", true);
                    return;
                }
                this.dxf.aO("ip_call_entrance", false);
                iconPreference = (IconPreference) this.dxf.Ow("ip_call_entrance");
                ak.yW();
                if (((Integer) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)) {
                    ak.yW();
                    if (!((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                        iconPreference.wG(8);
                        iconPreference.wL(8);
                        ak.yW();
                        str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                        if (be.kS(str)) {
                            iconPreference.L(str, -1, -7566196);
                            iconPreference.jy(true);
                            iconPreference.wH(0);
                            iconPreference.wG(8);
                        } else {
                            iconPreference.wH(8);
                            iconPreference.jy(false);
                        }
                        this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
                    }
                }
                iconPreference.wG(0);
                iconPreference.aO(getString(2131231102), 2130838762);
                iconPreference.wL(8);
                ak.yW();
                str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                if (be.kS(str)) {
                    iconPreference.wH(8);
                    iconPreference.jy(false);
                } else {
                    iconPreference.L(str, -1, -7566196);
                    iconPreference.jy(true);
                    iconPreference.wH(0);
                    iconPreference.wG(8);
                }
                this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
            }
            fVar2.aO(str, z);
            if (com.tencent.mm.ay.c.EH("shake")) {
                this.dxf.aO("find_friends_by_shake", false);
                iconPreference = (IconPreference) this.dxf.Ow("find_friends_by_shake");
                if (iconPreference != null) {
                    if ((k.xQ() & FileUtils.S_IRUSR) != 0) {
                    }
                    if (z2) {
                        Kw2 = l.KF().Kw() + j.a.bmq().aNH();
                        if (Kw2 <= 0) {
                            iconPreference.wG(8);
                            iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                        } else {
                            iconPreference.wG(0);
                            iconPreference.aO(String.valueOf(Kw2), 2130839356);
                        }
                        iconPreference.wK(8);
                        j.a.bmq().aNI();
                        if (j.a.bmq().aNJ()) {
                            z3 = false;
                        } else {
                            z3 = com.tencent.mm.p.c.us().ay(262154, 266258);
                        }
                        if (z3) {
                            iconPreference.wI(8);
                        } else {
                            ak.yW();
                            str = (String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, SQLiteDatabase.KeyEmpty);
                            if (TextUtils.isEmpty(str)) {
                                iconPreference.wI(8);
                                iconPreference.wG(0);
                                iconPreference.aO(str, 2130839356);
                            } else if (Kw2 <= 0) {
                                iconPreference.wI(0);
                                iconPreference.wG(8);
                                iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                            } else {
                                iconPreference.wI(0);
                            }
                        }
                        ak.yW();
                        ah = be.ah((String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), SQLiteDatabase.KeyEmpty);
                        ak.yW();
                        valueOf = Boolean.valueOf(be.a((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
                        ak.yW();
                        Kw = ((Integer) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
                        if (valueOf.booleanValue()) {
                        }
                        iconPreference.wH(8);
                        if (k.yo().booleanValue()) {
                            ak.yW();
                            this.nAA = be.c((Boolean) com.tencent.mm.model.c.vf().get(340231, null));
                            if (this.nAA) {
                                iconPreference.wI(0);
                            }
                        }
                    }
                    fVar = this.dxf;
                    str3 = "find_friends_by_shake";
                    if (z2) {
                        fVar2 = fVar;
                        str = str3;
                        z = false;
                    } else {
                        fVar2 = fVar;
                        str = str3;
                        z = true;
                    }
                }
                if (com.tencent.mm.ay.c.EH("bottle")) {
                    v.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                    this.dxf.aO("voice_bottle", true);
                } else {
                    this.dxf.aO("voice_bottle", false);
                    if (((IconPreference) this.dxf.Ow("voice_bottle")) != null) {
                        if ((k.xQ() & 64) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.nAu = z;
                        v.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.nAu));
                        fVar = this.dxf;
                        str2 = "voice_bottle";
                        if (this.nAu) {
                            z = true;
                        } else {
                            z = false;
                        }
                        fVar.aO(str2, z);
                        if (this.nAu) {
                            iconPreference = (IconPreference) this.dxf.Ow("voice_bottle");
                            if (iconPreference != null) {
                                Kw = com.tencent.mm.model.g.xD();
                                if (Kw > 0) {
                                    iconPreference.aO(String.valueOf(Kw), s.eN(this.nDR.nEl));
                                }
                                xJ = k.xJ();
                                if (Kw > 0) {
                                }
                                iconPreference.wG(8);
                            }
                        }
                    }
                }
                if (com.tencent.mm.ay.c.EH("game")) {
                    this.dxf.aO("more_tab_game_recommend", true);
                } else {
                    this.dxf.aO("more_tab_game_recommend", false);
                    rVar = j.a.lxN;
                    if (rVar != null) {
                        if (rVar.bY(this.nDR.nEl)) {
                            this.dxf.aO("more_tab_game_recommend", true);
                        } else {
                            bzl();
                        }
                    }
                }
                if (com.tencent.mm.ay.c.EH("scanner")) {
                    this.dxf.aO("find_friends_by_qrcode", true);
                } else {
                    this.dxf.aO("find_friends_by_qrcode", false);
                }
                this.dxf.aO("find_friends_by_facebook", true);
                fVar = this.dxf;
                str2 = "find_friends_by_google_account";
                if (be.He()) {
                    z = true;
                } else {
                    z = false;
                }
                fVar.aO(str2, z);
                iK(false);
                this.dxf.aO("settings_emoji_store", true);
                this.dxf.notifyDataSetChanged();
                if (d.atT()) {
                    this.dxf.aO("ip_call_entrance", false);
                    iconPreference = (IconPreference) this.dxf.Ow("ip_call_entrance");
                    ak.yW();
                    if (((Integer) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)) {
                        ak.yW();
                        if (!((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                            iconPreference.wG(8);
                            iconPreference.wL(8);
                            ak.yW();
                            str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                            if (be.kS(str)) {
                                iconPreference.L(str, -1, -7566196);
                                iconPreference.jy(true);
                                iconPreference.wH(0);
                                iconPreference.wG(8);
                            } else {
                                iconPreference.wH(8);
                                iconPreference.jy(false);
                            }
                            this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
                        }
                    }
                    iconPreference.wG(0);
                    iconPreference.aO(getString(2131231102), 2130838762);
                    iconPreference.wL(8);
                    ak.yW();
                    str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                    if (be.kS(str)) {
                        iconPreference.wH(8);
                        iconPreference.jy(false);
                    } else {
                        iconPreference.L(str, -1, -7566196);
                        iconPreference.jy(true);
                        iconPreference.wH(0);
                        iconPreference.wG(8);
                    }
                    this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
                }
                this.dxf.aO("ip_call_entrance", true);
                return;
            }
            fVar2 = this.dxf;
            str = "find_friends_by_shake";
            z = true;
            fVar2.aO(str, z);
            if (com.tencent.mm.ay.c.EH("bottle")) {
                this.dxf.aO("voice_bottle", false);
                if (((IconPreference) this.dxf.Ow("voice_bottle")) != null) {
                    if ((k.xQ() & 64) != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.nAu = z;
                    v.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.nAu));
                    fVar = this.dxf;
                    str2 = "voice_bottle";
                    if (this.nAu) {
                        z = false;
                    } else {
                        z = true;
                    }
                    fVar.aO(str2, z);
                    if (this.nAu) {
                        iconPreference = (IconPreference) this.dxf.Ow("voice_bottle");
                        if (iconPreference != null) {
                            Kw = com.tencent.mm.model.g.xD();
                            if (Kw > 0) {
                                iconPreference.aO(String.valueOf(Kw), s.eN(this.nDR.nEl));
                            }
                            xJ = k.xJ();
                            if (Kw > 0) {
                            }
                            iconPreference.wG(8);
                        }
                    }
                }
            } else {
                v.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                this.dxf.aO("voice_bottle", true);
            }
            if (com.tencent.mm.ay.c.EH("game")) {
                this.dxf.aO("more_tab_game_recommend", false);
                rVar = j.a.lxN;
                if (rVar != null) {
                    if (rVar.bY(this.nDR.nEl)) {
                        bzl();
                    } else {
                        this.dxf.aO("more_tab_game_recommend", true);
                    }
                }
            } else {
                this.dxf.aO("more_tab_game_recommend", true);
            }
            if (com.tencent.mm.ay.c.EH("scanner")) {
                this.dxf.aO("find_friends_by_qrcode", false);
            } else {
                this.dxf.aO("find_friends_by_qrcode", true);
            }
            this.dxf.aO("find_friends_by_facebook", true);
            fVar = this.dxf;
            str2 = "find_friends_by_google_account";
            if (be.He()) {
                z = false;
            } else {
                z = true;
            }
            fVar.aO(str2, z);
            iK(false);
            this.dxf.aO("settings_emoji_store", true);
            this.dxf.notifyDataSetChanged();
            if (d.atT()) {
                this.dxf.aO("ip_call_entrance", true);
                return;
            }
            this.dxf.aO("ip_call_entrance", false);
            iconPreference = (IconPreference) this.dxf.Ow("ip_call_entrance");
            ak.yW();
            if (((Integer) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)) {
                ak.yW();
                if (!((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                    iconPreference.wG(8);
                    iconPreference.wL(8);
                    ak.yW();
                    str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                    if (be.kS(str)) {
                        iconPreference.L(str, -1, -7566196);
                        iconPreference.jy(true);
                        iconPreference.wH(0);
                        iconPreference.wG(8);
                    } else {
                        iconPreference.wH(8);
                        iconPreference.jy(false);
                    }
                    this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
                }
            }
            iconPreference.wG(0);
            iconPreference.aO(getString(2131231102), 2130838762);
            iconPreference.wL(8);
            ak.yW();
            str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
            if (be.kS(str)) {
                iconPreference.wH(8);
                iconPreference.jy(false);
            } else {
                iconPreference.L(str, -1, -7566196);
                iconPreference.jy(true);
                iconPreference.wH(0);
                iconPreference.wG(8);
            }
            this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
        }
        fVar2 = this.dxf;
        str = "album_dyna_photo_ui_title";
        z = true;
        fVar2.aO(str, z);
        if (com.tencent.mm.ay.c.EH("nearby")) {
            this.dxf.aO("find_friends_by_near", false);
            iconPreference = (IconPreference) this.dxf.Ow("find_friends_by_near");
            if (iconPreference != null) {
                hoVar = new ho();
                hoVar.bhk.bdf = 7;
                com.tencent.mm.sdk.c.a.nhr.z(hoVar);
                if (hoVar.bhl.aYN) {
                    iconPreference.wK(0);
                    iconPreference.wJ(2130838665);
                    iconPreference.fgG = new LayoutParams(-2, -2);
                    iconPreference.fgG.addRule(13);
                    if (iconPreference.fgD != null) {
                        iconPreference.fgD.setLayoutParams(iconPreference.fgG);
                    }
                } else {
                    iconPreference.wK(8);
                }
                Kw = l.KE().Kw();
                if (com.tencent.mm.aw.a.bmn()) {
                    if (Kw <= 0) {
                        iconPreference.wG(8);
                        iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                    } else {
                        iconPreference.wG(0);
                        iconPreference.aO(String.valueOf(Kw), s.eN(this.nDR.nEl));
                    }
                } else if (Kw <= 0) {
                    iconPreference.wI(8);
                } else {
                    iconPreference.wI(0);
                }
                if (k.yo().booleanValue()) {
                    ak.yW();
                    this.nAB = be.c((Boolean) com.tencent.mm.model.c.vf().get(340232, null));
                    if (this.nAB) {
                        iconPreference.wI(0);
                    }
                }
                if ((k.xQ() & 512) != 0) {
                }
                fVar2 = this.dxf;
                str = "find_friends_by_near";
                if (z) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (com.tencent.mm.ay.c.EH("shake")) {
                fVar2 = this.dxf;
                str = "find_friends_by_shake";
                z = true;
            } else {
                this.dxf.aO("find_friends_by_shake", false);
                iconPreference = (IconPreference) this.dxf.Ow("find_friends_by_shake");
                if (iconPreference != null) {
                    if ((k.xQ() & FileUtils.S_IRUSR) != 0) {
                    }
                    if (z2) {
                        Kw2 = l.KF().Kw() + j.a.bmq().aNH();
                        if (Kw2 <= 0) {
                            iconPreference.wG(0);
                            iconPreference.aO(String.valueOf(Kw2), 2130839356);
                        } else {
                            iconPreference.wG(8);
                            iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                        }
                        iconPreference.wK(8);
                        j.a.bmq().aNI();
                        if (j.a.bmq().aNJ()) {
                            z3 = com.tencent.mm.p.c.us().ay(262154, 266258);
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            ak.yW();
                            str = (String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, SQLiteDatabase.KeyEmpty);
                            if (TextUtils.isEmpty(str)) {
                                iconPreference.wI(8);
                                iconPreference.wG(0);
                                iconPreference.aO(str, 2130839356);
                            } else if (Kw2 <= 0) {
                                iconPreference.wI(0);
                            } else {
                                iconPreference.wI(0);
                                iconPreference.wG(8);
                                iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                            }
                        } else {
                            iconPreference.wI(8);
                        }
                        ak.yW();
                        ah = be.ah((String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), SQLiteDatabase.KeyEmpty);
                        ak.yW();
                        valueOf = Boolean.valueOf(be.a((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
                        ak.yW();
                        Kw = ((Integer) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
                        if (valueOf.booleanValue()) {
                        }
                        iconPreference.wH(8);
                        if (k.yo().booleanValue()) {
                            ak.yW();
                            this.nAA = be.c((Boolean) com.tencent.mm.model.c.vf().get(340231, null));
                            if (this.nAA) {
                                iconPreference.wI(0);
                            }
                        }
                    }
                    fVar = this.dxf;
                    str3 = "find_friends_by_shake";
                    if (z2) {
                        fVar2 = fVar;
                        str = str3;
                        z = true;
                    } else {
                        fVar2 = fVar;
                        str = str3;
                        z = false;
                    }
                }
                if (com.tencent.mm.ay.c.EH("bottle")) {
                    v.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                    this.dxf.aO("voice_bottle", true);
                } else {
                    this.dxf.aO("voice_bottle", false);
                    if (((IconPreference) this.dxf.Ow("voice_bottle")) != null) {
                        if ((k.xQ() & 64) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.nAu = z;
                        v.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.nAu));
                        fVar = this.dxf;
                        str2 = "voice_bottle";
                        if (this.nAu) {
                            z = true;
                        } else {
                            z = false;
                        }
                        fVar.aO(str2, z);
                        if (this.nAu) {
                            iconPreference = (IconPreference) this.dxf.Ow("voice_bottle");
                            if (iconPreference != null) {
                                Kw = com.tencent.mm.model.g.xD();
                                if (Kw > 0) {
                                    iconPreference.aO(String.valueOf(Kw), s.eN(this.nDR.nEl));
                                }
                                xJ = k.xJ();
                                if (Kw > 0) {
                                }
                                iconPreference.wG(8);
                            }
                        }
                    }
                }
                if (com.tencent.mm.ay.c.EH("game")) {
                    this.dxf.aO("more_tab_game_recommend", true);
                } else {
                    this.dxf.aO("more_tab_game_recommend", false);
                    rVar = j.a.lxN;
                    if (rVar != null) {
                        if (rVar.bY(this.nDR.nEl)) {
                            this.dxf.aO("more_tab_game_recommend", true);
                        } else {
                            bzl();
                        }
                    }
                }
                if (com.tencent.mm.ay.c.EH("scanner")) {
                    this.dxf.aO("find_friends_by_qrcode", true);
                } else {
                    this.dxf.aO("find_friends_by_qrcode", false);
                }
                this.dxf.aO("find_friends_by_facebook", true);
                fVar = this.dxf;
                str2 = "find_friends_by_google_account";
                if (be.He()) {
                    z = true;
                } else {
                    z = false;
                }
                fVar.aO(str2, z);
                iK(false);
                this.dxf.aO("settings_emoji_store", true);
                this.dxf.notifyDataSetChanged();
                if (d.atT()) {
                    this.dxf.aO("ip_call_entrance", false);
                    iconPreference = (IconPreference) this.dxf.Ow("ip_call_entrance");
                    ak.yW();
                    if (((Integer) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)) {
                        ak.yW();
                        if (!((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                            iconPreference.wG(8);
                            iconPreference.wL(8);
                            ak.yW();
                            str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                            if (be.kS(str)) {
                                iconPreference.L(str, -1, -7566196);
                                iconPreference.jy(true);
                                iconPreference.wH(0);
                                iconPreference.wG(8);
                            } else {
                                iconPreference.wH(8);
                                iconPreference.jy(false);
                            }
                            this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
                        }
                    }
                    iconPreference.wG(0);
                    iconPreference.aO(getString(2131231102), 2130838762);
                    iconPreference.wL(8);
                    ak.yW();
                    str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                    if (be.kS(str)) {
                        iconPreference.wH(8);
                        iconPreference.jy(false);
                    } else {
                        iconPreference.L(str, -1, -7566196);
                        iconPreference.jy(true);
                        iconPreference.wH(0);
                        iconPreference.wG(8);
                    }
                    this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
                }
                this.dxf.aO("ip_call_entrance", true);
                return;
            }
            fVar2.aO(str, z);
            if (com.tencent.mm.ay.c.EH("bottle")) {
                this.dxf.aO("voice_bottle", false);
                if (((IconPreference) this.dxf.Ow("voice_bottle")) != null) {
                    if ((k.xQ() & 64) != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.nAu = z;
                    v.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.nAu));
                    fVar = this.dxf;
                    str2 = "voice_bottle";
                    if (this.nAu) {
                        z = false;
                    } else {
                        z = true;
                    }
                    fVar.aO(str2, z);
                    if (this.nAu) {
                        iconPreference = (IconPreference) this.dxf.Ow("voice_bottle");
                        if (iconPreference != null) {
                            Kw = com.tencent.mm.model.g.xD();
                            if (Kw > 0) {
                                iconPreference.aO(String.valueOf(Kw), s.eN(this.nDR.nEl));
                            }
                            xJ = k.xJ();
                            if (Kw > 0) {
                            }
                            iconPreference.wG(8);
                        }
                    }
                }
            } else {
                v.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                this.dxf.aO("voice_bottle", true);
            }
            if (com.tencent.mm.ay.c.EH("game")) {
                this.dxf.aO("more_tab_game_recommend", false);
                rVar = j.a.lxN;
                if (rVar != null) {
                    if (rVar.bY(this.nDR.nEl)) {
                        bzl();
                    } else {
                        this.dxf.aO("more_tab_game_recommend", true);
                    }
                }
            } else {
                this.dxf.aO("more_tab_game_recommend", true);
            }
            if (com.tencent.mm.ay.c.EH("scanner")) {
                this.dxf.aO("find_friends_by_qrcode", false);
            } else {
                this.dxf.aO("find_friends_by_qrcode", true);
            }
            this.dxf.aO("find_friends_by_facebook", true);
            fVar = this.dxf;
            str2 = "find_friends_by_google_account";
            if (be.He()) {
                z = false;
            } else {
                z = true;
            }
            fVar.aO(str2, z);
            iK(false);
            this.dxf.aO("settings_emoji_store", true);
            this.dxf.notifyDataSetChanged();
            if (d.atT()) {
                this.dxf.aO("ip_call_entrance", true);
                return;
            }
            this.dxf.aO("ip_call_entrance", false);
            iconPreference = (IconPreference) this.dxf.Ow("ip_call_entrance");
            ak.yW();
            if (((Integer) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)) {
                ak.yW();
                if (!((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                    iconPreference.wG(8);
                    iconPreference.wL(8);
                    ak.yW();
                    str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                    if (be.kS(str)) {
                        iconPreference.L(str, -1, -7566196);
                        iconPreference.jy(true);
                        iconPreference.wH(0);
                        iconPreference.wG(8);
                    } else {
                        iconPreference.wH(8);
                        iconPreference.jy(false);
                    }
                    this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
                }
            }
            iconPreference.wG(0);
            iconPreference.aO(getString(2131231102), 2130838762);
            iconPreference.wL(8);
            ak.yW();
            str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
            if (be.kS(str)) {
                iconPreference.wH(8);
                iconPreference.jy(false);
            } else {
                iconPreference.L(str, -1, -7566196);
                iconPreference.jy(true);
                iconPreference.wH(0);
                iconPreference.wG(8);
            }
            this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
        }
        fVar2 = this.dxf;
        str = "find_friends_by_near";
        z = true;
        fVar2.aO(str, z);
        if (com.tencent.mm.ay.c.EH("shake")) {
            this.dxf.aO("find_friends_by_shake", false);
            iconPreference = (IconPreference) this.dxf.Ow("find_friends_by_shake");
            if (iconPreference != null) {
                if ((k.xQ() & FileUtils.S_IRUSR) != 0) {
                }
                if (z2) {
                    Kw2 = l.KF().Kw() + j.a.bmq().aNH();
                    if (Kw2 <= 0) {
                        iconPreference.wG(8);
                        iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                    } else {
                        iconPreference.wG(0);
                        iconPreference.aO(String.valueOf(Kw2), 2130839356);
                    }
                    iconPreference.wK(8);
                    j.a.bmq().aNI();
                    if (j.a.bmq().aNJ()) {
                        z3 = false;
                    } else {
                        z3 = com.tencent.mm.p.c.us().ay(262154, 266258);
                    }
                    if (z3) {
                        iconPreference.wI(8);
                    } else {
                        ak.yW();
                        str = (String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, SQLiteDatabase.KeyEmpty);
                        if (TextUtils.isEmpty(str)) {
                            iconPreference.wI(8);
                            iconPreference.wG(0);
                            iconPreference.aO(str, 2130839356);
                        } else if (Kw2 <= 0) {
                            iconPreference.wI(0);
                            iconPreference.wG(8);
                            iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                        } else {
                            iconPreference.wI(0);
                        }
                    }
                    ak.yW();
                    ah = be.ah((String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), SQLiteDatabase.KeyEmpty);
                    ak.yW();
                    valueOf = Boolean.valueOf(be.a((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
                    ak.yW();
                    Kw = ((Integer) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
                    if (valueOf.booleanValue()) {
                    }
                    iconPreference.wH(8);
                    if (k.yo().booleanValue()) {
                        ak.yW();
                        this.nAA = be.c((Boolean) com.tencent.mm.model.c.vf().get(340231, null));
                        if (this.nAA) {
                            iconPreference.wI(0);
                        }
                    }
                }
                fVar = this.dxf;
                str3 = "find_friends_by_shake";
                if (z2) {
                    fVar2 = fVar;
                    str = str3;
                    z = false;
                } else {
                    fVar2 = fVar;
                    str = str3;
                    z = true;
                }
            }
            if (com.tencent.mm.ay.c.EH("bottle")) {
                v.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                this.dxf.aO("voice_bottle", true);
            } else {
                this.dxf.aO("voice_bottle", false);
                if (((IconPreference) this.dxf.Ow("voice_bottle")) != null) {
                    if ((k.xQ() & 64) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.nAu = z;
                    v.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.nAu));
                    fVar = this.dxf;
                    str2 = "voice_bottle";
                    if (this.nAu) {
                        z = true;
                    } else {
                        z = false;
                    }
                    fVar.aO(str2, z);
                    if (this.nAu) {
                        iconPreference = (IconPreference) this.dxf.Ow("voice_bottle");
                        if (iconPreference != null) {
                            Kw = com.tencent.mm.model.g.xD();
                            if (Kw > 0) {
                                iconPreference.aO(String.valueOf(Kw), s.eN(this.nDR.nEl));
                            }
                            xJ = k.xJ();
                            if (Kw > 0) {
                            }
                            iconPreference.wG(8);
                        }
                    }
                }
            }
            if (com.tencent.mm.ay.c.EH("game")) {
                this.dxf.aO("more_tab_game_recommend", true);
            } else {
                this.dxf.aO("more_tab_game_recommend", false);
                rVar = j.a.lxN;
                if (rVar != null) {
                    if (rVar.bY(this.nDR.nEl)) {
                        this.dxf.aO("more_tab_game_recommend", true);
                    } else {
                        bzl();
                    }
                }
            }
            if (com.tencent.mm.ay.c.EH("scanner")) {
                this.dxf.aO("find_friends_by_qrcode", true);
            } else {
                this.dxf.aO("find_friends_by_qrcode", false);
            }
            this.dxf.aO("find_friends_by_facebook", true);
            fVar = this.dxf;
            str2 = "find_friends_by_google_account";
            if (be.He()) {
                z = true;
            } else {
                z = false;
            }
            fVar.aO(str2, z);
            iK(false);
            this.dxf.aO("settings_emoji_store", true);
            this.dxf.notifyDataSetChanged();
            if (d.atT()) {
                this.dxf.aO("ip_call_entrance", false);
                iconPreference = (IconPreference) this.dxf.Ow("ip_call_entrance");
                ak.yW();
                if (((Integer) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)) {
                    ak.yW();
                    if (!((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                        iconPreference.wG(8);
                        iconPreference.wL(8);
                        ak.yW();
                        str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                        if (be.kS(str)) {
                            iconPreference.L(str, -1, -7566196);
                            iconPreference.jy(true);
                            iconPreference.wH(0);
                            iconPreference.wG(8);
                        } else {
                            iconPreference.wH(8);
                            iconPreference.jy(false);
                        }
                        this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
                    }
                }
                iconPreference.wG(0);
                iconPreference.aO(getString(2131231102), 2130838762);
                iconPreference.wL(8);
                ak.yW();
                str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                if (be.kS(str)) {
                    iconPreference.wH(8);
                    iconPreference.jy(false);
                } else {
                    iconPreference.L(str, -1, -7566196);
                    iconPreference.jy(true);
                    iconPreference.wH(0);
                    iconPreference.wG(8);
                }
                this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
            }
            this.dxf.aO("ip_call_entrance", true);
            return;
        }
        fVar2 = this.dxf;
        str = "find_friends_by_shake";
        z = true;
        fVar2.aO(str, z);
        if (com.tencent.mm.ay.c.EH("bottle")) {
            this.dxf.aO("voice_bottle", false);
            if (((IconPreference) this.dxf.Ow("voice_bottle")) != null) {
                if ((k.xQ() & 64) != 0) {
                    z = false;
                } else {
                    z = true;
                }
                this.nAu = z;
                v.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.nAu));
                fVar = this.dxf;
                str2 = "voice_bottle";
                if (this.nAu) {
                    z = false;
                } else {
                    z = true;
                }
                fVar.aO(str2, z);
                if (this.nAu) {
                    iconPreference = (IconPreference) this.dxf.Ow("voice_bottle");
                    if (iconPreference != null) {
                        Kw = com.tencent.mm.model.g.xD();
                        if (Kw > 0) {
                            iconPreference.aO(String.valueOf(Kw), s.eN(this.nDR.nEl));
                        }
                        xJ = k.xJ();
                        if (Kw > 0) {
                        }
                        iconPreference.wG(8);
                    }
                }
            }
        } else {
            v.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
            this.dxf.aO("voice_bottle", true);
        }
        if (com.tencent.mm.ay.c.EH("game")) {
            this.dxf.aO("more_tab_game_recommend", false);
            rVar = j.a.lxN;
            if (rVar != null) {
                if (rVar.bY(this.nDR.nEl)) {
                    bzl();
                } else {
                    this.dxf.aO("more_tab_game_recommend", true);
                }
            }
        } else {
            this.dxf.aO("more_tab_game_recommend", true);
        }
        if (com.tencent.mm.ay.c.EH("scanner")) {
            this.dxf.aO("find_friends_by_qrcode", false);
        } else {
            this.dxf.aO("find_friends_by_qrcode", true);
        }
        this.dxf.aO("find_friends_by_facebook", true);
        fVar = this.dxf;
        str2 = "find_friends_by_google_account";
        if (be.He()) {
            z = false;
        } else {
            z = true;
        }
        fVar.aO(str2, z);
        iK(false);
        this.dxf.aO("settings_emoji_store", true);
        this.dxf.notifyDataSetChanged();
        if (d.atT()) {
            this.dxf.aO("ip_call_entrance", true);
            return;
        }
        this.dxf.aO("ip_call_entrance", false);
        iconPreference = (IconPreference) this.dxf.Ow("ip_call_entrance");
        ak.yW();
        if (((Integer) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)) {
            ak.yW();
            if (!((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                iconPreference.wG(8);
                iconPreference.wL(8);
                ak.yW();
                str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                if (be.kS(str)) {
                    iconPreference.L(str, -1, -7566196);
                    iconPreference.jy(true);
                    iconPreference.wH(0);
                    iconPreference.wG(8);
                } else {
                    iconPreference.wH(8);
                    iconPreference.jy(false);
                }
                this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
            }
        }
        iconPreference.wG(0);
        iconPreference.aO(getString(2131231102), 2130838762);
        iconPreference.wL(8);
        ak.yW();
        str = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
        if (be.kS(str)) {
            iconPreference.wH(8);
            iconPreference.jy(false);
        } else {
            iconPreference.L(str, -1, -7566196);
            iconPreference.jy(true);
            iconPreference.wH(0);
            iconPreference.wG(8);
        }
        this.dxf.a(new PreferenceSmallCategory(this.nDR.nEl));
    }

    private void iK(boolean z) {
        String value;
        if (u.bsV()) {
            value = com.tencent.mm.h.j.sU().getValue("JDEntranceConfigName");
        } else if (u.bsW()) {
            value = com.tencent.mm.h.j.sU().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = com.tencent.mm.h.j.sU().getValue("JDEntranceConfigNameEN");
        }
        String value2 = com.tencent.mm.h.j.sU().getValue("JDEntranceConfigIconUrl");
        Object obj = 1;
        j.s sVar = al.lyl;
        if (sVar != null) {
            String aZr = sVar.aZr();
            if (!(be.kS(value) || be.kS(value2) || be.kS(aZr))) {
                Object obj2;
                CharSequence charSequence;
                IconPreference iconPreference;
                Bitmap gu;
                Bitmap gu2;
                com.tencent.mm.plugin.subapp.jdbiz.b bVar = (com.tencent.mm.plugin.subapp.jdbiz.b) sVar.aZs();
                if ((bVar.kfc < System.currentTimeMillis() / 1000 ? 1 : null) != null) {
                    if (bVar.kfd == 0 || bVar.kfd >= System.currentTimeMillis() / 1000) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        if (!be.kS(bVar.iconUrl)) {
                            value2 = bVar.iconUrl;
                        }
                        if (!be.kS(bVar.title)) {
                            charSequence = bVar.title;
                            iconPreference = (IconPreference) this.dxf.Ow("jd_market_entrance");
                            n.GG();
                            gu = com.tencent.mm.ae.b.gu(value2);
                            if (gu == null) {
                                iconPreference.drawable = new BitmapDrawable(this.nDR.nEl.getResources(), gu);
                                this.nAx = null;
                            } else {
                                iconPreference.drawable = com.tencent.mm.bd.a.a(this.nDR.nEl, 2131165639);
                                n.GK().a(value2, this.nAJ);
                                this.nAx = value2;
                            }
                            iconPreference.setTitle(charSequence);
                            iconPreference.wG(8);
                            iconPreference.wI(8);
                            iconPreference.wH(8);
                            iconPreference.jy(false);
                            iconPreference.wL(8);
                            if (sVar.aZj() && bVar.Iz() && !bVar.aZc()) {
                                if (!be.kS(bVar.keY)) {
                                    iconPreference.wG(8);
                                    iconPreference.wI(8);
                                    iconPreference.L(bVar.keY, -1, -7566196);
                                    iconPreference.wH(0);
                                }
                                if (!be.kS(bVar.keZ)) {
                                    n.GG();
                                    gu2 = com.tencent.mm.ae.b.gu(bVar.keZ);
                                    iconPreference.wL(0);
                                    iconPreference.wK(0);
                                    iconPreference.wM(0);
                                    iconPreference.jy(false);
                                    if (gu2 == null) {
                                        this.nAy = null;
                                        iconPreference.J(gu2);
                                    } else {
                                        n.GK().a(bVar.keZ, this.nAJ);
                                        this.nAy = bVar.keZ;
                                    }
                                } else if (!be.kS(bVar.keY)) {
                                    iconPreference.jy(true);
                                } else if (bVar.keX) {
                                    iconPreference.wI(0);
                                    iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                                    iconPreference.wG(8);
                                }
                            }
                            this.dxf.aO("jd_market_entrance", false);
                            if (z) {
                                this.dxf.notifyDataSetChanged();
                            }
                            if (!this.nAz) {
                                com.tencent.mm.plugin.report.service.g.iuh.h(11178, aZr, sVar.aZs().aZd(), Integer.valueOf(bzj()));
                                this.nAz = true;
                            }
                            obj = null;
                        }
                    }
                }
                obj2 = value;
                iconPreference = (IconPreference) this.dxf.Ow("jd_market_entrance");
                n.GG();
                gu = com.tencent.mm.ae.b.gu(value2);
                if (gu == null) {
                    iconPreference.drawable = com.tencent.mm.bd.a.a(this.nDR.nEl, 2131165639);
                    n.GK().a(value2, this.nAJ);
                    this.nAx = value2;
                } else {
                    iconPreference.drawable = new BitmapDrawable(this.nDR.nEl.getResources(), gu);
                    this.nAx = null;
                }
                iconPreference.setTitle(charSequence);
                iconPreference.wG(8);
                iconPreference.wI(8);
                iconPreference.wH(8);
                iconPreference.jy(false);
                iconPreference.wL(8);
                if (be.kS(bVar.keY)) {
                    iconPreference.wG(8);
                    iconPreference.wI(8);
                    iconPreference.L(bVar.keY, -1, -7566196);
                    iconPreference.wH(0);
                }
                if (!be.kS(bVar.keZ)) {
                    n.GG();
                    gu2 = com.tencent.mm.ae.b.gu(bVar.keZ);
                    iconPreference.wL(0);
                    iconPreference.wK(0);
                    iconPreference.wM(0);
                    iconPreference.jy(false);
                    if (gu2 == null) {
                        n.GK().a(bVar.keZ, this.nAJ);
                        this.nAy = bVar.keZ;
                    } else {
                        this.nAy = null;
                        iconPreference.J(gu2);
                    }
                } else if (!be.kS(bVar.keY)) {
                    iconPreference.jy(true);
                } else if (bVar.keX) {
                    iconPreference.wI(0);
                    iconPreference.aO(SQLiteDatabase.KeyEmpty, -1);
                    iconPreference.wG(8);
                }
                this.dxf.aO("jd_market_entrance", false);
                if (z) {
                    this.dxf.notifyDataSetChanged();
                }
                if (this.nAz) {
                    com.tencent.mm.plugin.report.service.g.iuh.h(11178, aZr, sVar.aZs().aZd(), Integer.valueOf(bzj()));
                    this.nAz = true;
                }
                obj = null;
            }
        }
        if (obj != null) {
            this.dxf.aO("jd_market_entrance", true);
        }
    }

    private static int bzj() {
        j.s sVar = al.lyl;
        if (sVar == null) {
            return 1;
        }
        j.h aZs = sVar.aZs();
        if (!sVar.aZj() || !aZs.Iz() || aZs.aZc()) {
            return 1;
        }
        if ("3".equals(aZs.aZg()) && !be.kS(aZs.aZh())) {
            return 6;
        }
        if (!be.kS(aZs.aZe())) {
            return 3;
        }
        if (aZs.aZf()) {
            return 2;
        }
        return 1;
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        if ("album_dyna_photo_ui_title".equals(preference.dnU)) {
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                boolean z;
                com.tencent.mm.plugin.report.service.f.oR(10);
                ak.yW();
                this.nAv = (String) com.tencent.mm.model.c.vf().get(68377, null);
                intent = new Intent();
                com.tencent.mm.modelsns.a aVar = new com.tencent.mm.modelsns.a(701, 1);
                aVar.bg(!be.kS(this.nAv));
                aVar.kj(this.nAw);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.putExtra("is_from_find_more", true);
                String str = "enter_by_red";
                if (!be.kS(this.nAv) || this.nAw > 0) {
                    z = true;
                } else {
                    z = false;
                }
                intent.putExtra(str, z);
                ak.yW();
                intent.putExtra("is_sns_notify_open", be.a((Boolean) com.tencent.mm.model.c.vf().get(68384, null), true));
                intent.putExtra("sns_unread_count", j.ak.lyg.Kw());
                if (!be.kS(this.nAv)) {
                    ak.yW();
                    intent.putExtra("new_feed_id", be.ah((String) com.tencent.mm.model.c.vf().get(68418, null), SQLiteDatabase.KeyEmpty));
                }
                aVar.b(intent, "enter_log");
                com.tencent.mm.sdk.c.b gqVar = new gq();
                com.tencent.mm.sdk.c.a.nhr.z(gqVar);
                if (gqVar.bgh.bgi) {
                    z = true;
                } else {
                    if (be.kS(this.nAv)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (j.ak.lyg != null) {
                        this.nAw = j.ak.lyg.Kw();
                        if (this.nAw > 0) {
                            z = false;
                        }
                    }
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(68377, SQLiteDatabase.KeyEmpty);
                }
                ak.yW();
                com.tencent.mm.model.c.vf().set(589825, Boolean.valueOf(false));
                intent.putExtra("sns_resume_state", z);
                com.tencent.mm.ay.c.b(this.nDR.nEl, "sns", ".ui.SnsTimeLineUI", intent);
                com.tencent.mm.plugin.report.service.g.iuh.Y(10958, "1");
                return true;
            }
            com.tencent.mm.ui.base.s.ey(this.nDR.nEl);
            return true;
        } else if ("find_friends_by_near".equals(preference.dnU)) {
            if (!this.nAB && k.yo().booleanValue()) {
                r0 = (IconPreference) fVar.Ow("find_friends_by_near");
                if (r0 != null) {
                    r0.wI(8);
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(340232, Boolean.valueOf(true));
                    ak.yW();
                    com.tencent.mm.model.c.vf().iB(true);
                    com.tencent.mm.plugin.report.service.g.iuh.a(232, 3, 1, false);
                }
            }
            v.i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(bzo(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)));
            if (!com.tencent.mm.pluginsdk.i.a.a(bzo(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)) {
                return true;
            }
            bzk();
            return true;
        } else if ("find_friends_by_shake".equals(preference.dnU)) {
            if (!this.nAA && k.yo().booleanValue()) {
                r0 = (IconPreference) fVar.Ow("find_friends_by_shake");
                if (r0 != null) {
                    r0.wI(8);
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(340231, Boolean.valueOf(true));
                    ak.yW();
                    com.tencent.mm.model.c.vf().iB(true);
                    com.tencent.mm.plugin.report.service.g.iuh.a(232, 4, 1, false);
                }
            }
            com.tencent.mm.plugin.report.service.g.iuh.Y(10958, "3");
            ak.yW();
            String ah = be.ah((String) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), SQLiteDatabase.KeyEmpty);
            ak.yW();
            Boolean valueOf = (!Boolean.valueOf(be.a((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false)).booleanValue() || ah == null || ah.equals(SQLiteDatabase.KeyEmpty)) ? Boolean.valueOf(false) : Boolean.valueOf(true);
            if (valueOf.booleanValue()) {
                com.tencent.mm.plugin.report.service.g.iuh.h(12653, Integer.valueOf(2), Integer.valueOf(2));
            }
            com.tencent.mm.sdk.c.a.nhr.z(new lg());
            com.tencent.mm.ay.c.w(this.nDR.nEl, "shake", ".ui.ShakeReportUI");
            return true;
        } else if ("voice_bottle".equals(preference.dnU)) {
            com.tencent.mm.plugin.report.service.g.iuh.Y(10958, "5");
            bf zO = bf.zO();
            if (be.a(Integer.valueOf(zO.bBZ), 0) <= 0 || be.kS(zO.getProvince())) {
                com.tencent.mm.ay.c.w(this.nDR.nEl, "bottle", ".ui.BottleWizardStep1");
                return true;
            }
            com.tencent.mm.ay.c.w(this.nDR.nEl, "bottle", ".ui.BottleBeachUI");
            return true;
        } else if ("find_friends_by_qrcode".equals(preference.dnU)) {
            if (com.tencent.mm.as.u.bi(this.nDR.nEl) || com.tencent.mm.ah.a.aT(this.nDR.nEl)) {
                return true;
            }
            com.tencent.mm.plugin.report.service.g.iuh.Y(10958, "2");
            r0 = new Intent();
            r0.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
            com.tencent.mm.plugin.report.service.g.iuh.h(11265, Integer.valueOf(2));
            com.tencent.mm.ay.c.b(this.nDR.nEl, "scanner", ".ui.BaseScanUI", r0);
            return true;
        } else if (preference.dnU.equals("more_tab_game_recommend")) {
            com.tencent.mm.plugin.report.service.g.iuh.Y(10958, "6");
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                intent = new Intent();
                intent.putExtra("from_find_more_friend", this.nAC);
                intent.putExtra("game_report_from_scene", 901);
                if (this.nAC) {
                    com.tencent.mm.sdk.c.b kgVar = new kg();
                    com.tencent.mm.sdk.c.a.nhr.z(kgVar);
                    r0 = (IconPreference) fVar.Ow("more_tab_game_recommend");
                    if (!(kgVar.blk.bll == null || r0 == null)) {
                        n.GL().cOJ.a(new com.tencent.mm.ae.a.c(r0.fgD, kgVar.blk.bll));
                    }
                }
                com.tencent.mm.ay.c.b(this.nDR.nEl, "game", ".ui.GameCenterUI", intent);
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ g nAK;

                    {
                        this.nAK = r1;
                    }

                    public final void run() {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(d.d.nzM, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                        this.nAK.sendBroadcast(intent);
                    }
                }, 100);
                return true;
            }
            com.tencent.mm.ui.base.s.ey(this.nDR.nEl);
            return true;
        } else if ("find_friends_by_micromsg".equals(preference.dnU)) {
            com.tencent.mm.ay.c.b(this.nDR.nEl, "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
            return true;
        } else if ("find_friends_by_mobile".equals(preference.dnU)) {
            if (m.EY() != m.a.SUCC) {
                r0 = new Intent(this.nDR.nEl, BindMContactIntroUI.class);
                r0.putExtra("key_upload_scene", 6);
                MMWizardActivity.w(this.nDR.nEl, r0);
                return true;
            }
            startActivity(new Intent(this.nDR.nEl, MobileFriendUI.class));
            return true;
        } else if ("find_friends_by_facebook".equals(preference.dnU)) {
            startActivity(new Intent(this.nDR.nEl, FacebookFriendUI.class));
            return true;
        } else if ("find_friends_by_google_account".equals(preference.dnU)) {
            if (com.tencent.mm.modelfriend.n.Fg()) {
                r0 = new Intent(this.nDR.nEl, GoogleFriendUI.class);
                r0.putExtra("enter_scene", 1);
                startActivity(r0);
                return true;
            }
            r0 = new Intent(this.nDR.nEl, BindGoogleContactIntroUI.class);
            r0.putExtra("enter_scene", 1);
            MMWizardActivity.w(this.nDR.nEl, r0);
            return true;
        } else if ("settings_mm_card_package".equals(preference.dnU)) {
            com.tencent.mm.ay.c.w(this.nDR.nEl, "card", ".ui.CardHomePageUI");
            return true;
        } else if (preference.dnU.equals("jd_market_entrance")) {
            com.tencent.mm.pluginsdk.wallet.f.ux(9);
            j.s sVar = al.lyl;
            if (sVar != null) {
                r0 = al.lyl.aZr();
                com.tencent.mm.plugin.report.service.g.iuh.h(11179, r0, sVar.aZs().aZd(), Integer.valueOf(bzj()));
                sVar.aZm();
                sVar.aZl();
                ((IconPreference) preference).aO(SQLiteDatabase.KeyEmpty, -1);
                if (!be.kS(r0)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", r0);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("KPublisherId", "jd_store");
                    com.tencent.mm.ay.c.b(this.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                }
            } else {
                r0 = null;
            }
            v.i("MicroMsg.FindMoreFriendsUI", "jump to url: " + r0);
            return true;
        } else if ("ip_call_entrance".equals(preference.dnU)) {
            int i;
            r0 = (IconPreference) fVar.Ow("ip_call_entrance");
            r0.wI(8);
            r0.wH(8);
            r0.jy(false);
            r0.wL(8);
            ak.yW();
            r0 = (String) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
            ak.yW();
            if (!((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                ak.yW();
                if (((Integer) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0) && be.kS(r0)) {
                    i = 0;
                    ak.yW();
                    if (((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                        com.tencent.mm.plugin.ipcall.a.e.h.C(1, -1, -1);
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false));
                    }
                    ak.yW();
                    if (((Integer) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() < com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(13254, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)));
                    }
                    if (!be.kS(r0)) {
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
                    }
                    if (i != 0) {
                        com.tencent.mm.sdk.c.a.nhr.z(new po());
                    }
                    if (com.tencent.mm.ah.a.Hv()) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(12061, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                        com.tencent.mm.ay.c.b(this.nDR.nEl, "ipcall", ".ui.IPCallAddressUI", new Intent());
                        return true;
                    }
                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, 2131233933, 0, null, null);
                    return true;
                }
            }
            i = true;
            ak.yW();
            if (((Boolean) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                com.tencent.mm.plugin.ipcall.a.e.h.C(1, -1, -1);
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false));
            }
            ak.yW();
            if (((Integer) com.tencent.mm.model.c.vf().get(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() < com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)) {
                com.tencent.mm.plugin.report.service.g.iuh.h(13254, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(com.tencent.mm.h.j.sU().getInt("WCOEntranceRedDot", 0)));
            }
            if (be.kS(r0)) {
                ak.yW();
                com.tencent.mm.model.c.vf().a(t.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, SQLiteDatabase.KeyEmpty);
            }
            if (i != 0) {
                com.tencent.mm.sdk.c.a.nhr.z(new po());
            }
            if (com.tencent.mm.ah.a.Hv()) {
                com.tencent.mm.plugin.report.service.g.iuh.h(12061, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                com.tencent.mm.ay.c.b(this.nDR.nEl, "ipcall", ".ui.IPCallAddressUI", new Intent());
                return true;
            }
            com.tencent.mm.ui.base.g.a(this.nDR.nEl, 2131233933, 0, null, null);
            return true;
        } else if (!"app_brand_entrance".equals(preference.dnU)) {
            return false;
        } else {
            com.tencent.mm.ay.c.w(this.nDR.nEl, "appbrand", ".ui.AppBrandLauncherUI");
            return true;
        }
    }

    public final void bzk() {
        com.tencent.mm.plugin.report.service.g.iuh.Y(10958, "4");
        ak.yW();
        if (be.c((Boolean) com.tencent.mm.model.c.vf().get(4103, null))) {
            bf zP = bf.zP();
            if (zP == null) {
                com.tencent.mm.ay.c.w(this.nDR.nEl, "nearby", ".ui.NearbyPersonalInfoUI");
                return;
            }
            String ma = be.ma(zP.getProvince());
            int a = be.a(Integer.valueOf(zP.bBZ), 0);
            if (be.kS(ma) || a == 0) {
                com.tencent.mm.ay.c.w(this.nDR.nEl, "nearby", ".ui.NearbyPersonalInfoUI");
                return;
            }
            ak.yW();
            Boolean bool = (Boolean) com.tencent.mm.model.c.vf().get(4104, null);
            if (bool == null || !bool.booleanValue()) {
                LauncherUI launcherUI = (LauncherUI) this.nDR.nEl;
                if (launcherUI != null) {
                    launcherUI.NX("tab_find_friend");
                }
                com.tencent.mm.aw.a.cU(this.nDR.nEl);
                return;
            }
            if (this.nAt == null) {
                this.nAt = View.inflate(this.nDR.nEl, 2130903854, null);
                this.hEZ = (CheckBox) this.nAt.findViewById(2131757691);
                this.hEZ.setChecked(false);
            }
            if (this.hFb == null) {
                this.hFb = com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131231164), this.nAt, new OnClickListener(this) {
                    final /* synthetic */ g nAK;

                    {
                        this.nAK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (this.nAK.hEZ != null) {
                            ak.yW();
                            com.tencent.mm.model.c.vf().set(4104, Boolean.valueOf(!this.nAK.hEZ.isChecked()));
                        }
                        LauncherUI launcherUI = (LauncherUI) this.nAK.nDR.nEl;
                        if (launcherUI != null) {
                            launcherUI.NX("tab_find_friend");
                        }
                        com.tencent.mm.aw.a.cU(this.nAK.nDR.nEl);
                    }
                }, null);
                return;
            } else {
                this.hFb.show();
                return;
            }
        }
        com.tencent.mm.ay.c.w(this.nDR.nEl, "nearby", ".ui.NearbyFriendsIntroUI");
    }

    private void bzl() {
        IconPreference iconPreference = (IconPreference) this.dxf.Ow("more_tab_game_recommend");
        if (iconPreference != null) {
            final com.tencent.mm.sdk.c.b kgVar = new kg();
            com.tencent.mm.sdk.c.a.nhr.z(kgVar);
            iconPreference.wI(8);
            String str = kgVar.blk.blm;
            String str2 = kgVar.blk.appId;
            int i = kgVar.blk.msgType;
            String str3 = kgVar.blk.bln;
            if (kgVar.blk.aXx == 1) {
                iconPreference.aO(getString(2131231102), 2130838762);
                a(iconPreference, 0, 8, 8, false, 8, 8, 8);
                b(str2, i, str, str3, kgVar.blk.aXx);
            } else if (kgVar.blk.aXx == 2) {
                iconPreference.L(dV(kgVar.blk.appName, kgVar.blk.appId), -1, Color.parseColor("#8c8c8c"));
                a(iconPreference, 8, 8, 0, true, 8, 8, 8);
                b(str2, i, str, str3, kgVar.blk.aXx);
            } else if (kgVar.blk.aXx == 3) {
                if (be.kS(kgVar.blk.bll)) {
                    iconPreference.J(com.tencent.mm.pluginsdk.model.app.g.b(kgVar.blk.appId, 1, com.tencent.mm.bd.a.getDensity(this.nDR.nEl)));
                    a(iconPreference, 8, 8, 8, false, 0, 0, 0);
                    return;
                }
                com.tencent.mm.ae.a.a GL = n.GL();
                String str4 = kgVar.blk.bll;
                r6 = iconPreference;
                r7 = str2;
                r8 = i;
                r9 = str;
                r10 = str3;
                GL.a(str4, iconPreference.fgD, new com.tencent.mm.ae.a.c.g(this) {
                    final /* synthetic */ g nAK;

                    public final void jk(String str) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 nAO;

                            {
                                this.nAO = r1;
                            }

                            public final void run() {
                                this.nAO.nAK.nAC = false;
                                g.a((IconPreference) this.nAO.nAK.dxf.Ow("more_tab_game_recommend"), 8, 8, 8, false, 8, 8, 8);
                            }
                        });
                    }

                    public final void a(String str, View view, com.tencent.mm.ae.a.d.b bVar) {
                        if (bVar.status != 0 || bVar.bitmap == null) {
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 nAO;

                                {
                                    this.nAO = r1;
                                }

                                public final void run() {
                                    this.nAO.nAK.nAC = true;
                                    IconPreference iconPreference = (IconPreference) this.nAO.nAK.dxf.Ow("more_tab_game_recommend");
                                    iconPreference.aO(this.nAO.nAK.getString(2131231102), 2130838762);
                                    g.a(iconPreference, 0, 8, 8, false, 8, 8, 8);
                                    this.nAO.nAK.b(r7, r8, r9, r10, 1);
                                }
                            });
                            return;
                        }
                        final Bitmap bitmap = bVar.bitmap;
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 nAO;

                            public final void run() {
                                this.nAO.nAK.nAC = true;
                                r6.J(bitmap);
                                g.a(r6, 8, 8, 8, false, 0, 0, 0);
                                this.nAO.nAK.b(r7, r8, r9, r10, kgVar.blk.aXx);
                            }
                        });
                    }
                });
            } else if (kgVar.blk.aXx == 4) {
                final String dV = dV(kgVar.blk.appName, kgVar.blk.appId);
                if (be.kS(dV)) {
                    this.nAC = true;
                    a(iconPreference, 8, 8, 8, false, 8, 8, 8);
                    return;
                }
                iconPreference.L(dV, -1, Color.parseColor("#8c8c8c"));
                if (be.kS(kgVar.blk.bll)) {
                    iconPreference.J(com.tencent.mm.pluginsdk.model.app.g.b(kgVar.blk.appId, 1, com.tencent.mm.bd.a.getDensity(this.nDR.nEl)));
                    a(iconPreference, 8, 8, 0, false, 0, 0, 0);
                    return;
                }
                com.tencent.mm.ae.a.a GL2 = n.GL();
                String str5 = kgVar.blk.bll;
                r6 = iconPreference;
                r7 = str2;
                r8 = i;
                r9 = str;
                r10 = str3;
                GL2.a(str5, iconPreference.fgD, new com.tencent.mm.ae.a.c.g(this) {
                    final /* synthetic */ g nAK;

                    public final void jk(String str) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 nAP;

                            {
                                this.nAP = r1;
                            }

                            public final void run() {
                                this.nAP.nAK.nAC = false;
                                g.a((IconPreference) this.nAP.nAK.dxf.Ow("more_tab_game_recommend"), 8, 8, 8, false, 8, 8, 8);
                            }
                        });
                    }

                    public final void a(String str, View view, com.tencent.mm.ae.a.d.b bVar) {
                        if (bVar.status != 0 || bVar.bitmap == null) {
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass5 nAP;

                                {
                                    this.nAP = r1;
                                }

                                public final void run() {
                                    this.nAP.nAK.nAC = true;
                                    IconPreference iconPreference = (IconPreference) this.nAP.nAK.dxf.Ow("more_tab_game_recommend");
                                    iconPreference.L(dV, -1, Color.parseColor("#8c8c8c"));
                                    g.a(iconPreference, 8, 8, 0, true, 8, 8, 8);
                                    this.nAP.nAK.b(r7, r8, r9, r10, 2);
                                }
                            });
                            return;
                        }
                        final Bitmap bitmap = bVar.bitmap;
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass5 nAP;

                            public final void run() {
                                this.nAP.nAK.nAC = true;
                                r6.J(bitmap);
                                g.a(r6, 8, 8, 0, false, 0, 0, 0);
                                this.nAP.nAK.b(r7, r8, r9, r10, kgVar.blk.aXx);
                            }
                        });
                    }
                });
            } else if (kgVar.blk.aXx == 5) {
                this.nAC = true;
                a(iconPreference, 8, 0, 8, false, 8, 8, 8);
                b(str2, i, str, str3, kgVar.blk.aXx);
            } else {
                this.nAC = true;
                a(iconPreference, 8, 8, 8, false, 8, 8, 8);
            }
        }
    }

    private void b(String str, int i, String str2, String str3, int i2) {
        if (str2 != null && !str2.equals(this.nAD)) {
            String encode;
            this.nAD = str2;
            com.tencent.mm.sdk.c.b liVar = new li();
            liVar.bmF.scene = 9;
            liVar.bmF.bmG = 901;
            liVar.bmF.action = 1;
            liVar.bmF.appId = str;
            liVar.bmF.msgType = i;
            liVar.bmF.blm = str2;
            liVar.bmF.bln = str3;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("function_type", "resource");
                jSONObject.put("function_value", String.valueOf(i2));
            } catch (JSONException e) {
                v.e("MicroMsg.FindMoreFriendsUI", e.getMessage());
            }
            try {
                encode = URLEncoder.encode(jSONObject.toString(), "utf-8");
            } catch (UnsupportedEncodingException e2) {
                UnsupportedEncodingException unsupportedEncodingException = e2;
                encode = SQLiteDatabase.KeyEmpty;
                v.e("MicroMsg.FindMoreFriendsUI", unsupportedEncodingException.getMessage());
            }
            liVar.bmF.bmH = encode;
            com.tencent.mm.sdk.c.a.nhr.z(liVar);
        }
    }

    private String dV(String str, String str2) {
        return !be.kS(str) ? str : com.tencent.mm.pluginsdk.model.app.g.n(this.nDR.nEl, str2);
    }

    private static void a(IconPreference iconPreference, int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        iconPreference.wG(i);
        iconPreference.wI(i2);
        iconPreference.wH(i3);
        iconPreference.jy(z);
        iconPreference.wL(i4);
        iconPreference.wK(i5);
        iconPreference.wM(i6);
    }

    public final void yI() {
        if ((k.xQ() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            this.nAw++;
            blU();
        }
    }

    public final void yJ() {
        if ((k.xQ() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            blU();
        }
    }

    public final void yK() {
    }

    public final void yM() {
        if (this.dxf != null) {
            blU();
        }
    }

    protected final void bys() {
        v.i("MicroMsg.FindMoreFriendsUI", "on tab create");
        this.dxf = this.ocZ;
        v.i("MicroMsg.FindMoreFriendsUI", "on tab create end");
    }

    protected final void byt() {
        v.i("MicroMsg.FindMoreFriendsUI", "on tab resume");
        com.tencent.mm.pluginsdk.d.a.a(hl.class.getName(), this.lPq);
        com.tencent.mm.pluginsdk.d.a.a(fu.class.getName(), this.nAG);
        com.tencent.mm.pluginsdk.d.a.a(na.class.getName(), this.nAH);
        com.tencent.mm.sdk.c.a.nhr.e(this.nAE);
        com.tencent.mm.sdk.c.a.nhr.e(this.nAF);
        com.tencent.mm.sdk.c.a.nhr.e(this.jmu);
        com.tencent.mm.sdk.c.a.nhr.e(this.nAI);
        l.KF().c(this);
        ak.yW();
        com.tencent.mm.model.c.wK().a(this);
        ak.yW();
        com.tencent.mm.model.c.a(this);
        ak.yW();
        com.tencent.mm.model.c.vf().a(this);
        if (j.ak.lyi != null) {
            j.ak.lyi.a(this);
        }
        blU();
        final View findViewById = findViewById(2131759528);
        if (!(findViewById == null || findViewById.getVisibility() == 8)) {
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ g nAK;

                public final void run() {
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this.nAK.nDR.nEl, 2130968623));
                }
            });
        }
        com.tencent.mm.sdk.c.b ndVar = new nd();
        com.tencent.mm.sdk.c.a.nhr.z(ndVar);
        this.dxf.aO("app_brand_entrance", !ndVar.dRM.dRN);
        v.i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
    }

    protected final void byu() {
        v.i("MicroMsg.FindMoreFriendsUI", "on tab start");
    }

    protected final void byv() {
        v.i("MicroMsg.FindMoreFriendsUI", "on tab pause");
        if (ak.uz()) {
            com.tencent.mm.pluginsdk.d.a.b(hl.class.getName(), this.lPq);
            com.tencent.mm.pluginsdk.d.a.b(fu.class.getName(), this.nAG);
            com.tencent.mm.pluginsdk.d.a.b(na.class.getName(), this.nAH);
            com.tencent.mm.sdk.c.a.nhr.f(this.nAE);
            com.tencent.mm.sdk.c.a.nhr.f(this.nAF);
            com.tencent.mm.sdk.c.a.nhr.f(this.jmu);
            com.tencent.mm.sdk.c.a.nhr.f(this.nAI);
            l.KF().d(this);
            ak.yW();
            com.tencent.mm.model.c.wK().b(this);
            ak.yW();
            com.tencent.mm.model.c.b(this);
            ak.yW();
            com.tencent.mm.model.c.vf().b(this);
            if (this.nAx != null) {
                n.GG().iO(this.nAx);
            }
            if (this.nAy != null) {
                n.GG().iO(this.nAy);
            }
        }
        if (j.ak.lyi != null) {
            j.ak.lyi.b(this);
        }
    }

    protected final void byw() {
        v.i("MicroMsg.FindMoreFriendsUI", "on tab stop");
    }

    protected final void byx() {
        v.i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
    }

    public final void byz() {
        v.i("MicroMsg.FindMoreFriendsUI", "turn to bg");
    }

    public final void byA() {
        v.i("MicroMsg.FindMoreFriendsUI", "turn to fg");
    }

    public final void byC() {
        v.i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
    }

    public final void a(String str, i iVar) {
        blU();
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        blU();
    }

    public final void bzm() {
    }

    public final void yL() {
        if ((k.xQ() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            if (j.ak.lyg != null) {
                this.nAw = j.ak.lyg.Kw();
            }
            blU();
        }
    }
}
