package com.tencent.mm.plugin.game.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.game.d.p;
import com.tencent.mm.plugin.game.d.q;
import com.tencent.mm.plugin.game.d.r;
import com.tencent.mm.plugin.game.d.s;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.f.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.v.b;
import com.tencent.mm.v.k;
import com.tencent.mm.v.u;

@a(7)
public class CreateOrJoinChatroomUI extends MMBaseActivity {
    private String dzg;
    private ProgressDialog eLA = null;
    private String gpe;
    private String gpf;
    private String gpg;
    private String gph;
    private String gpi;
    private String gpj;
    private int gpk = 1;
    private String uT;

    static /* synthetic */ void a(CreateOrJoinChatroomUI createOrJoinChatroomUI, String str) {
        Intent intent = new Intent();
        String n = g.n(createOrJoinChatroomUI, createOrJoinChatroomUI.dzg);
        intent.putExtra("action", createOrJoinChatroomUI.uT);
        intent.putExtra("app_name", n);
        intent.putExtra("rawUrl", str);
        c.b(createOrJoinChatroomUI, "webview", ".ui.tools.game.GameChattingRoomWebViewUI", intent, 5);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        v.i("MicroMsg.CreateOrJoinChatroomUI", "onCreate");
        Intent intent = getIntent();
        this.uT = intent.getStringExtra("action");
        this.gpe = intent.getStringExtra("package_name");
        this.dzg = intent.getStringExtra("key_app_id");
        this.gpf = intent.getStringExtra("key_transaction");
        this.gpg = intent.getStringExtra("group_id");
        this.gph = intent.getStringExtra("chatroom_name");
        this.gpi = intent.getStringExtra("chatroom_nickname");
        this.gpj = intent.getStringExtra("ext_msg");
        if (be.kS(this.uT) || be.kS(this.dzg) || be.kS(this.gpg)) {
            v.e("MicroMsg.CreateOrJoinChatroomUI", "Invalid args");
            finish();
            return;
        }
        this.eLA = com.tencent.mm.ui.base.g.a(this, getBaseContext().getString(2131235775), true, null);
        b.a aVar;
        b Bv;
        if (this.uT.equals("action_create")) {
            v.i("MicroMsg.CreateOrJoinChatroomUI", "createChatroom, appid = %s, groupId = %s, ChatRoomName = %s", new Object[]{this.dzg, this.gpg, this.gph});
            aVar = new b.a();
            aVar.czn = new p();
            aVar.czo = new q();
            aVar.uri = "/cgi-bin/mmgame-bin/gamecreatechatroom";
            aVar.czm = 1205;
            Bv = aVar.Bv();
            p pVar = (p) Bv.czk.czs;
            pVar.gkz = this.dzg;
            pVar.glp = this.gpg;
            pVar.glq = new com.tencent.mm.ba.b(this.gph == null ? new byte[0] : this.gph.getBytes());
            pVar.glr = new com.tencent.mm.ba.b(this.gpi == null ? new byte[0] : this.gpi.getBytes());
            u.a(Bv, new u.a(this) {
                final /* synthetic */ CreateOrJoinChatroomUI gpl;

                {
                    this.gpl = r1;
                }

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    q qVar = (q) bVar.czl.czs;
                    if (i == 0 && i2 == 0) {
                        v.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", new Object[]{qVar.gls});
                        this.gpl.asn();
                        CreateOrJoinChatroomUI.a(this.gpl, r0);
                    } else {
                        v.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 4) {
                            this.gpl.lv(qVar.fvC);
                        } else {
                            this.gpl.lv(-1);
                        }
                        this.gpl.asn();
                        this.gpl.finish();
                    }
                    return 0;
                }
            });
        } else if (this.uT.equals("action_join")) {
            aVar = new b.a();
            aVar.czn = new r();
            aVar.czo = new s();
            aVar.uri = "/cgi-bin/mmgame-bin/gamejoinchatroom";
            aVar.czm = 1206;
            Bv = aVar.Bv();
            r rVar = (r) Bv.czk.czs;
            rVar.gkz = this.dzg;
            rVar.glp = this.gpg;
            rVar.glr = new com.tencent.mm.ba.b(this.gpi == null ? new byte[0] : this.gpi.getBytes());
            u.a(Bv, new u.a(this) {
                final /* synthetic */ CreateOrJoinChatroomUI gpl;

                {
                    this.gpl = r1;
                }

                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    s sVar = (s) bVar.czl.czs;
                    if (i == 0 && i2 == 0) {
                        v.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", new Object[]{sVar.glt});
                        this.gpl.asn();
                        CreateOrJoinChatroomUI.a(this.gpl, r0);
                    } else {
                        v.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 4) {
                            this.gpl.lv(sVar.fvC);
                        } else {
                            this.gpl.lv(-1);
                        }
                        this.gpl.asn();
                        this.gpl.finish();
                    }
                    return 0;
                }
            });
        }
    }

    protected void onDestroy() {
        asn();
        super.onDestroy();
    }

    private void asn() {
        if (this.eLA != null && this.eLA.isShowing()) {
            this.eLA.cancel();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 5) {
            if (i2 == 4) {
                lv(0);
            } else if (i2 == 5) {
                if (intent != null) {
                    j.a.lxU.b(this, intent.getStringExtra("rawUrl"), true, null);
                }
            } else if (i2 == 0) {
                lv(-2);
            }
        }
        finish();
    }

    private void lv(int i) {
        f aC = g.aC(this.dzg, true);
        Bundle bundle = new Bundle();
        if (this.uT.equals("action_create")) {
            com.tencent.mm.sdk.f.c.a aVar = new com.tencent.mm.sdk.f.c.a();
            if (aC != null) {
                aVar.bfm = aC.field_openId;
            }
            aVar.lBj = this.gpf;
            aVar.beZ = this.gpj;
            aVar.errCode = i;
            aVar.t(bundle);
        } else if (this.uT.equals("action_join")) {
            d.a aVar2 = new d.a();
            if (aC != null) {
                aVar2.bfm = aC.field_openId;
            }
            aVar2.lBj = this.gpf;
            aVar2.beZ = this.gpj;
            aVar2.errCode = i;
            aVar2.t(bundle);
        }
        com.tencent.mm.sdk.a.a.a aVar3 = new com.tencent.mm.sdk.a.a.a();
        aVar3.nhj = this.gpe;
        aVar3.nhl = bundle;
        com.tencent.mm.pluginsdk.model.app.p.R(bundle);
        com.tencent.mm.pluginsdk.model.app.p.S(bundle);
        com.tencent.mm.sdk.a.a.a(aa.getContext(), aVar3);
    }
}
