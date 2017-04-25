package com.tencent.mm.ui.bizchat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Toast;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.pw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.d.a;
import com.tencent.mm.modelbiz.a.d.a.b;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.a.x;
import com.tencent.mm.modelbiz.k;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.gu;
import com.tencent.mm.protocal.c.gw;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.protocal.c.lw;
import com.tencent.mm.protocal.c.lx;
import com.tencent.mm.protocal.c.ra;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BizChatroomInfoUI extends MMPreference implements k, e {
    private static boolean ePH = false;
    private SharedPreferences cnm = null;
    private ProgressDialog dwR = null;
    private f dxf;
    private boolean eJx;
    private SignaturePreference ePc;
    private ContactListExpandPreference ePg;
    private CheckBoxPreference ePh;
    private CheckBoxPreference ePi;
    private CheckBoxPreference ePj;
    private boolean ePp = false;
    private int ePq;
    private d ePu = new d(new OnScrollListener(this) {
        final /* synthetic */ BizChatroomInfoUI oiM;

        {
            this.oiM = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            n.GL().ba(i);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean ePv = false;
    private boolean eut = false;
    private long ezh;
    private String ezn;
    private int fromScene;
    private j hVf = null;
    private c ogZ = null;
    private a ohG = new a(this) {
        final /* synthetic */ BizChatroomInfoUI oiM;

        {
            this.oiM = r1;
        }

        public final void a(b bVar) {
            if (bVar != null && bVar.cDQ != null && bVar.cDF == this.oiM.ezh && bVar.cDP != a.a.cDM) {
                v.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
                this.oiM.ogZ = u.DA().Z(this.oiM.ezh);
                this.oiM.bDE();
                if (this.oiM.ogZ.DO()) {
                    u.DE();
                    h.b(this.oiM.ogZ.field_bizChatServId, this.oiM.ezn, true);
                }
            }
        }
    };
    private String oiG;
    private boolean oiH = false;
    private boolean oiI;
    private boolean oiJ;
    private int oiK;
    private j oiL = null;

    static /* synthetic */ void a(BizChatroomInfoUI bizChatroomInfoUI, int i) {
        boolean z = true;
        j tX = bizChatroomInfoUI.ePg.tX(i);
        if (tX == null) {
            String str = "MicroMsg.BizChatroomInfoUI";
            String str2 = "onItemNormalClick userInfo == null:%s";
            Object[] objArr = new Object[1];
            if (tX != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.w(str, str2, objArr);
            return;
        }
        v.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick field_userId:%s", tX.field_userId);
        String str3 = tX.field_userId;
        gx gxVar = new gx();
        gw gwVar = new gw();
        gwVar.mhK = str3;
        gxVar.mhL.add(gwVar);
        bizChatroomInfoUI.a(null, gxVar);
    }

    static /* synthetic */ boolean a(BizChatroomInfoUI bizChatroomInfoUI, String str, CharSequence charSequence) {
        String trim = charSequence == null ? SQLiteDatabase.KeyEmpty : charSequence.toString().trim();
        if (trim.equals(str)) {
            v.d("MicroMsg.BizChatroomInfoUI", "same room name return");
            return true;
        } else if (trim.length() == 0) {
            g.bf(bizChatroomInfoUI.nDR.nEl, bizChatroomInfoUI.getString(2131234574));
            return false;
        } else {
            com.tencent.mm.sdk.c.a.nhr.z(new pw());
            bizChatroomInfoUI.oiG = bizChatroomInfoUI.ogZ.field_chatName;
            bizChatroomInfoUI.oiK = bizChatroomInfoUI.ogZ.field_bitFlag;
            bizChatroomInfoUI.ogZ.field_chatName = trim;
            u.DA().b(bizChatroomInfoUI.ogZ);
            gu guVar = new gu();
            guVar.mhD = bizChatroomInfoUI.ogZ.field_bizChatServId;
            guVar.name = trim;
            guVar.mhF = bizChatroomInfoUI.oiK;
            u.DE();
            h.a(bizChatroomInfoUI.ogZ.field_brandUserName, guVar, (k) bizChatroomInfoUI);
            bizChatroomInfoUI.adl();
            bizChatroomInfoUI.dxf.notifyDataSetChanged();
            return true;
        }
    }

    static /* synthetic */ void c(BizChatroomInfoUI bizChatroomInfoUI) {
        Intent intent = new Intent();
        if (bizChatroomInfoUI.oiH) {
            if (be.kS(bizChatroomInfoUI.ogZ.field_addMemberUrl)) {
                v.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
                Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(2131231495), 0).show();
                return;
            }
            intent.putExtra("rawUrl", bizChatroomInfoUI.ogZ.field_addMemberUrl);
        } else if (bizChatroomInfoUI.hVf == null || be.kS(bizChatroomInfoUI.hVf.field_addMemberUrl)) {
            v.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
            Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(2131231495), 0).show();
            return;
        } else {
            intent.putExtra("rawUrl", bizChatroomInfoUI.hVf.field_addMemberUrl);
        }
        intent.putExtra("useJs", true);
        com.tencent.mm.ay.c.b(bizChatroomInfoUI.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent, 1);
    }

    static /* synthetic */ void d(BizChatroomInfoUI bizChatroomInfoUI) {
        v.i("MicroMsg.BizChatroomInfoUI", "deleteChatroom");
        u.DE();
        ak.vy().a(new com.tencent.mm.modelbiz.a.u(bizChatroomInfoUI.ezn, bizChatroomInfoUI.ogZ.field_bizChatServId), 0);
        bizChatroomInfoUI.eut = false;
        bizChatroomInfoUI.getString(2131231164);
        final ProgressDialog a = g.a((Context) bizChatroomInfoUI, bizChatroomInfoUI.getString(2131231182), true, new OnCancelListener(bizChatroomInfoUI) {
            final /* synthetic */ BizChatroomInfoUI oiM;

            {
                this.oiM = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.oiM.eut = true;
            }
        });
        com.tencent.mm.model.f.a(bizChatroomInfoUI.ezn, bizChatroomInfoUI.ezh, new aw.a(bizChatroomInfoUI) {
            final /* synthetic */ BizChatroomInfoUI oiM;

            public final boolean zp() {
                return this.oiM.eut;
            }

            public final void zo() {
                if (a != null) {
                    u.DB().U(this.oiM.ezh);
                    u.DA().U(this.oiM.ezh);
                    a.dismiss();
                }
            }
        });
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Contact_User", bizChatroomInfoUI.ezn);
        com.tencent.mm.ay.c.b(bizChatroomInfoUI.nDR.nEl, "brandservice", ".ui.BizChatConversationUI", intent);
        bizChatroomInfoUI.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        u.DA().a(this.ohG, Looper.getMainLooper());
        this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
        this.ezn = getIntent().getStringExtra("Chat_User");
        this.ezh = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.ogZ = u.DA().Z(this.ezh);
        if (this.ogZ != null) {
            this.oiG = this.ogZ.field_chatName;
            this.oiH = com.tencent.mm.modelbiz.a.e.hT(this.ogZ.field_bizChatServId);
            if (!this.oiH) {
                this.hVf = u.DC().ig(this.ogZ.field_bizChatServId);
            }
            this.oiL = u.DC().ih(this.ezn);
        }
        NI();
        if (this.ogZ != null && this.ogZ.field_bizChatServId != null && this.ezn != null) {
            if (this.ogZ.DN()) {
                u.DE();
                h.b(this.ogZ.field_bizChatServId, this.ezn, true);
                return;
            }
            u.DE();
            h.a(this.ogZ.field_bizChatServId, this.ezn, (k) this);
        }
    }

    public void onResume() {
        adl();
        adg();
        adj();
        aGJ();
        bDD();
        adh();
        this.dxf.notifyDataSetChanged();
        super.onResume();
        if (!this.ePv) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!be.kS(stringExtra)) {
                final int Oy = this.dxf.Oy(stringExtra);
                setSelection(Oy - 3);
                new ac().postDelayed(new Runnable(this) {
                    final /* synthetic */ BizChatroomInfoUI oiM;

                    public final void run() {
                        View a = ((com.tencent.mm.ui.base.preference.a) this.oiM.dxf).a(Oy, this.oiM.gMx);
                        if (a != null) {
                            com.tencent.mm.ui.g.a.b(this.oiM.nDR.nEl, a);
                        }
                    }
                }, 10);
            }
            this.ePv = true;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        com.tencent.mm.ui.g.a.dismiss();
        com.tencent.mm.ui.g.a.dismiss();
        u.DA().a(this.ohG);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    boolean OG;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        v.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        v.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", string);
                        if (this.oiH) {
                            OG = OG(string);
                        } else {
                            ra raVar = new ra();
                            c cVar = new c();
                            cVar.field_addMemberUrl = this.oiL != null ? this.oiL.field_addMemberUrl : null;
                            cVar.field_brandUserName = this.ezn;
                            if (com.tencent.mm.modelbiz.a.e.a(cVar, string, this.hVf.field_userId, raVar)) {
                                u.DE();
                                final com.tencent.mm.modelbiz.a.n a = h.a(this.ezn, raVar, (k) this);
                                getString(2131231164);
                                this.dwR = g.a((Context) this, getString(2131230828), true, new OnCancelListener(this) {
                                    final /* synthetic */ BizChatroomInfoUI oiM;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ak.vy().c(a);
                                    }
                                });
                                OG = true;
                            } else {
                                OG = false;
                            }
                        }
                    } else {
                        OG = false;
                    }
                    if (!OG) {
                        Toast.makeText(this, getString(2131234570), 0).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean OG(String str) {
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                gx gxVar = new gx();
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar;
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("id");
                    j ig = u.DC().ig(string);
                    if (ig == null) {
                        ig = new j();
                        ig.field_userId = string;
                        jVar = ig;
                    } else {
                        jVar = ig;
                    }
                    jVar.field_userName = jSONObject.getString("nick_name");
                    jVar.field_brandUserName = this.ezn;
                    jVar.field_headImageUrl = jSONObject.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject.getString("profile_url");
                    jVar.field_UserVersion = jSONObject.getInt("ver");
                    jVar.field_addMemberUrl = this.oiL != null ? this.oiL.field_addMemberUrl : null;
                    if (!u.DC().b(jVar)) {
                        u.DC().a(jVar);
                    }
                    gw gwVar = new gw();
                    gwVar.mhK = jVar.field_userId;
                    gxVar.mhL.add(gwVar);
                }
                a(gxVar, null);
                return true;
            } catch (Throwable e) {
                v.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", e.getMessage());
                v.a("MicroMsg.BizChatroomInfoUI", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return false;
    }

    private void a(gx gxVar, gx gxVar2) {
        v.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
        String string = gxVar == null ? getString(2131234578) : getString(2131230828);
        u.DE();
        final x a = h.a(this.ogZ.field_brandUserName, this.ogZ.field_bizChatServId, gxVar, gxVar2, this);
        getString(2131231164);
        this.dwR = g.a((Context) this, string, true, new OnCancelListener(this) {
            final /* synthetic */ BizChatroomInfoUI oiM;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(a);
            }
        });
    }

    public final int Oo() {
        return 2131099658;
    }

    protected final void NI() {
        this.dxf = this.ocZ;
        String str = null;
        if (this.ogZ != null) {
            str = this.ogZ.field_ownerUserId;
            this.ePq = this.ogZ.DM().size();
        }
        if (be.kS(str)) {
            this.ePp = false;
        } else {
            this.ePp = str.equals(u.DC().ii(this.ezn));
        }
        v.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
        this.ePg = (ContactListExpandPreference) this.dxf.Ow("roominfo_contact_anchor");
        this.ePg.a(this.dxf, this.ePg.dnU);
        this.ePc = (SignaturePreference) this.dxf.Ow("room_name");
        this.ePh = (CheckBoxPreference) this.dxf.Ow("room_notify_new_msg");
        this.ePj = (CheckBoxPreference) this.dxf.Ow("room_placed_to_the_top");
        this.ePi = (CheckBoxPreference) this.dxf.Ow("room_save_to_contact");
        ContactListExpandPreference contactListExpandPreference = this.ePg;
        boolean z = this.oiH;
        if (contactListExpandPreference.lKE != null) {
            contactListExpandPreference.lKE.lJM.lKc = z;
        }
        contactListExpandPreference = this.ePg;
        z = this.ePp;
        if (contactListExpandPreference.lKE != null) {
            contactListExpandPreference.lKE.lJM.lKb = z;
        }
        if (this.ePp) {
            this.ePg.hZ(true).ia(true);
        } else {
            this.ePg.hZ(true).ia(false);
        }
        this.ePg.bpo();
        if (this.ogZ != null) {
            this.ePg.HA(this.ogZ.field_ownerUserId);
        }
        this.ePg.bpn();
        this.ePg.bpr();
        if (!this.oiH) {
            this.dxf.aO("room_save_to_contact", true);
            this.dxf.aO("room_name", true);
            this.dxf.aO("room_del_quit", true);
        }
        bDD();
        aGJ();
        adj();
        if (this.ePg != null) {
            this.gMx.setOnScrollListener(this.ePu);
            this.ePg.a(this.ePu);
            this.ePg.a(new ContactListExpandPreference.a(this) {
                final /* synthetic */ BizChatroomInfoUI oiM;

                {
                    this.oiM = r1;
                }

                public final void jo(int i) {
                    BizChatroomInfoUI.a(this.oiM, i);
                }

                public final void jp(int i) {
                    boolean z = true;
                    j tX = this.oiM.ePg.tX(i);
                    if (tX == null || be.kS(tX.field_profileUrl)) {
                        String str = "MicroMsg.BizChatroomInfoUI";
                        String str2 = "onItemNormalClick userInfo == null:%s";
                        Object[] objArr = new Object[1];
                        if (tX != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        v.w(str, str2, objArr);
                        return;
                    }
                    v.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", tX.field_profileUrl);
                    u.DE();
                    h.a(tX.field_userId, tX.field_brandUserName, this.oiM);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", tX.field_profileUrl);
                    intent.putExtra("useJs", true);
                    com.tencent.mm.ay.c.b(this.oiM.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                }

                public final void adp() {
                    if (this.oiM.ePg != null) {
                        this.oiM.ePg.bpp();
                    }
                }

                public final void jq(int i) {
                    BizChatroomInfoUI.c(this.oiM);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BizChatroomInfoUI oiM;

            {
                this.oiM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oiM.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.dnU;
        if (str.equals("room_name")) {
            String str2 = SQLiteDatabase.KeyEmpty;
            if (adm()) {
                str2 = this.ogZ.field_chatName;
            }
            g.a(this.nDR.nEl, getString(2131234625), str2, SQLiteDatabase.KeyEmpty, 32, new g.b(this) {
                final /* synthetic */ BizChatroomInfoUI oiM;

                public final boolean r(CharSequence charSequence) {
                    return BizChatroomInfoUI.a(this.oiM, str2, charSequence);
                }
            });
        } else if (str.equals("room_notify_new_msg")) {
            this.eJx = !this.eJx;
            p(this.eJx, 1);
            adj();
        } else if (str.equals("room_chatting_images")) {
            int O = ak.yW().cqY.O(this.ezn, this.ezh);
            Intent intent = new Intent();
            intent.setClassName(this, "com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI");
            intent.putExtra("kintent_intent_source", 1);
            intent.putExtra("kintent_talker", this.ezn);
            intent.putExtra("kintent_image_count", O);
            if (O > 0) {
                ak.yW();
                intent.putExtra("kintent_image_index", com.tencent.mm.model.c.wJ().Nb(this.ezn) - 1);
            }
            intent.putExtra("key_biz_chat_id", this.ezh);
            intent.putExtra("key_is_biz_chat", true);
            startActivity(intent);
        } else if (str.equals("room_placed_to_the_top")) {
            if (this.oiJ) {
                z = false;
            }
            this.oiJ = z;
            p(this.oiJ, 16);
            if (this.ogZ != null) {
                if (this.oiJ) {
                    u.DB().X(this.ogZ.field_bizChatLocalId);
                } else {
                    u.DB().Y(this.ogZ.field_bizChatLocalId);
                }
            }
        } else if (str.equals("room_del_quit")) {
            v.d("MicroMsg.BizChatroomInfoUI", " quit " + this.ezh);
            g.a(this.nDR.nEl, getString(2131232274), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                final /* synthetic */ BizChatroomInfoUI oiM;

                {
                    this.oiM = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BizChatroomInfoUI.d(this.oiM);
                }
            }, null);
        } else if (str.equals("room_save_to_contact")) {
            if (this.oiI) {
                z = false;
            }
            this.oiI = z;
            p(this.oiI, 8);
            bDD();
        }
        return false;
    }

    private void p(boolean z, int i) {
        this.oiK = this.ogZ.field_bitFlag;
        this.oiG = this.ogZ.field_chatName;
        if (this.oiH) {
            c cVar;
            if (z) {
                cVar = this.ogZ;
                cVar.field_bitFlag |= i;
            } else {
                cVar = this.ogZ;
                cVar.field_bitFlag &= i ^ -1;
            }
            v.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", Integer.valueOf(this.ogZ.field_bitFlag));
            u.DA().b(this.ogZ);
        } else {
            j jVar;
            if (z) {
                jVar = this.hVf;
                jVar.field_bitFlag |= i;
            } else {
                jVar = this.hVf;
                jVar.field_bitFlag &= i ^ -1;
            }
            u.DC().b(this.hVf);
            this.ogZ.field_bitFlag = this.hVf.field_bitFlag;
            u.DA().b(this.ogZ);
        }
        gu guVar = new gu();
        guVar.mhD = this.ogZ.field_bizChatServId;
        guVar.mhF = this.ogZ.field_bitFlag;
        u.DE();
        h.a(this.ogZ.field_brandUserName, guVar, (k) this);
    }

    private void adh() {
        if (this.ePg != null) {
            List ab;
            if (this.oiH) {
                ab = com.tencent.mm.modelbiz.a.e.ab(this.ezh);
            } else {
                ab = new LinkedList();
                ab.add(this.ogZ.field_bizChatServId);
            }
            if (ab != null) {
                this.ePq = ab.size();
            } else {
                this.ePq = 0;
            }
            if (this.ePq <= 1) {
                this.ePg.hZ(true).ia(false);
            } else {
                this.ePg.hZ(true).ia(this.ePp);
            }
            this.ePg.j(this.ezn, ab);
        }
    }

    private void bDD() {
        v.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
        if (this.cnm == null) {
            this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.oiH) {
            this.oiI = this.ogZ.fe(8);
            this.oiK = this.ogZ.field_bitFlag;
        } else {
            this.oiI = this.hVf.fe(8);
            this.oiK = this.hVf.field_bitFlag;
        }
        if (this.oiI) {
            if (this.ePi != null) {
                this.cnm.edit().putBoolean("room_save_to_contact", true).commit();
            }
        } else if (this.ePi != null) {
            this.cnm.edit().putBoolean("room_save_to_contact", false).commit();
        }
        this.dxf.notifyDataSetChanged();
    }

    private void aGJ() {
        v.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
        if (this.cnm == null) {
            this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.oiH) {
            this.oiJ = this.ogZ.fe(16);
            this.oiK = this.ogZ.field_bitFlag;
        } else {
            this.oiJ = this.hVf.fe(16);
            this.oiK = this.hVf.field_bitFlag;
        }
        if (this.ePj != null) {
            this.cnm.edit().putBoolean("room_placed_to_the_top", this.oiJ).commit();
        }
        this.dxf.notifyDataSetChanged();
    }

    private void adj() {
        if (this.cnm == null) {
            this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.oiH) {
            this.eJx = this.ogZ.fe(1);
            this.oiK = this.ogZ.field_bitFlag;
        } else {
            this.eJx = this.hVf.fe(1);
            this.oiK = this.hVf.field_bitFlag;
        }
        if (this.eJx) {
            vI(0);
            if (this.ePh != null) {
                this.cnm.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            vI(8);
            if (this.ePh != null) {
                this.cnm.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.dxf.notifyDataSetChanged();
    }

    private void adl() {
        if (this.ogZ != null && this.ePc != null) {
            if (adm()) {
                CharSequence charSequence = this.ogZ.field_chatName;
                if (charSequence != null && charSequence.length() > 50) {
                    charSequence = charSequence.substring(0, 32);
                }
                v.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", charSequence);
                SignaturePreference signaturePreference = this.ePc;
                if (charSequence == null || charSequence.length() <= 0) {
                    charSequence = getString(2131235144);
                }
                signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, charSequence));
                return;
            }
            this.ePc.setSummary(getString(2131234603));
        }
    }

    private void adg() {
        if (this.oiH) {
            this.ePq = com.tencent.mm.modelbiz.a.e.aa(this.ezh);
            if (this.ePq != 0) {
                Fd(getString(2131232864, new Object[]{getString(2131234689), Integer.valueOf(this.ePq)}));
                return;
            }
        }
        Fd(getString(2131234689));
    }

    private boolean adm() {
        if (be.kS(this.oiH ? this.ogZ.field_chatName : this.hVf.field_userName)) {
            return false;
        }
        return true;
    }

    public final void a(int i, com.tencent.mm.v.k kVar) {
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (kVar.getType() == 1355) {
            lx DR = ((com.tencent.mm.modelbiz.a.n) kVar).DR();
            lw DS = ((com.tencent.mm.modelbiz.a.n) kVar).DS();
            c hR = u.DA().hR(DR.moz.muP.mhD);
            if (hR == null) {
                Toast.makeText(aa.getContext(), getString(2131234570), 0).show();
            } else if (this.fromScene == 2) {
                r2 = new Intent();
                r2.addFlags(67108864);
                r2.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                r2.putExtra("Contact_User", DS.mhJ);
                r2.putExtra("biz_chat_chat_id", hR.field_bizChatLocalId);
                com.tencent.mm.ay.c.a((Context) this, ".ui.bizchat.BizChatConversationUI", r2);
            } else {
                r2 = new Intent();
                r2.addFlags(67108864);
                r2.putExtra("Chat_User", DS.mhJ);
                r2.putExtra("key_biz_chat_id", hR.field_bizChatLocalId);
                r2.putExtra("finish_direct", true);
                r2.putExtra("key_need_send_video", false);
                r2.putExtra("key_is_biz_chat", true);
                com.tencent.mm.plugin.chatroom.a.drp.e(r2, (Context) this);
            }
        } else if (kVar.getType() == 1356) {
            if (i != 0) {
                bDF();
            }
        } else if (kVar.getType() == 1353 && i >= 0 && this.hVf != null) {
            this.hVf = u.DC().ig(this.hVf.field_userId);
            bDE();
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar == null) {
            v.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", Integer.valueOf(i), Integer.valueOf(i2), str);
            return;
        }
        v.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType()));
        this.ePq = com.tencent.mm.modelbiz.a.e.aa(this.ezh);
        v.d("MicroMsg.BizChatroomInfoUI", "now is " + this.ePq);
        if (this.dwR != null) {
            this.dwR.dismiss();
        }
        com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
        if (dm != null) {
            dm.a(this, null, null);
        } else if (i == 0 && i2 == 0) {
            kVar.getType();
        } else {
            v.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
            bDF();
        }
    }

    private void bDE() {
        if (this.ePg != null) {
            adl();
            adg();
            adj();
            adh();
            bDD();
            aGJ();
            this.ePg.notifyChanged();
        }
        this.dxf.notifyDataSetChanged();
    }

    private void bDF() {
        v.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
        this.ogZ.field_chatName = this.oiG;
        this.ogZ.field_bitFlag = this.oiK;
        this.eJx = this.ogZ.fe(1);
        this.oiI = this.ogZ.fe(8);
        this.oiJ = this.ogZ.fe(16);
        u.DA().b(this.ogZ);
        if (this.oiJ) {
            u.DB().X(this.ogZ.field_bizChatLocalId);
        } else if (!this.oiJ) {
            u.DB().Y(this.ogZ.field_bizChatLocalId);
        }
        this.cnm.edit().putBoolean("room_placed_to_the_top", u.DB().W(this.ogZ.field_bizChatLocalId)).commit();
        adl();
        adj();
        aGJ();
        bDD();
        Toast.makeText(this, getString(2131234571), 0).show();
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
