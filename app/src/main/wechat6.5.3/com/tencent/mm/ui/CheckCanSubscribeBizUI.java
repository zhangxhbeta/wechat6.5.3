package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.mm.e.a.fz;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.jx;
import com.tencent.mm.protocal.c.jy;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI extends MMActivity implements a, b, e {
    private String appId;
    private int bbT;
    private String bbU;
    private String bcB;
    private boolean cvW = false;
    private String extInfo;
    private int fromScene;
    private String hUb;
    private int nzB;
    private LinkedList<arf> nzC;
    private boolean nzD = false;
    private boolean nzE = false;
    private boolean nzF = false;
    private boolean nzG = false;
    private String nzH;
    private int nzI = 0;
    private int scene;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nDR.bAj();
        if (!ak.uN() || ak.uG()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            return;
        }
        ak.vy().a(605, (e) this);
        ak.yW();
        c.wH().a(this);
        u.Dy().c(this);
        if (byN()) {
            String str = this.appId;
            String str2 = this.bcB;
            String str3 = this.extInfo;
            int i = this.nzB;
            LinkedList linkedList = this.nzC;
            String str4 = this.bbU;
            int i2 = this.bbT;
            int i3 = this.scene;
            com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
            aVar.czn = new jx();
            aVar.czo = new jy();
            aVar.uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
            aVar.czm = 605;
            com.tencent.mm.v.b Bv = aVar.Bv();
            jx jxVar = (jx) Bv.czk.czs;
            jxVar.gkz = str;
            jxVar.gom = str2;
            jxVar.gor = str3;
            jxVar.mmp = i;
            jxVar.mmq = linkedList;
            jxVar.mmr = null;
            jxVar.mms = str4;
            jxVar.mcP = i2;
            jxVar.maG = i3;
            v.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i3));
            com.tencent.mm.v.u.a(Bv, new com.tencent.mm.v.u.a(this) {
                final /* synthetic */ CheckCanSubscribeBizUI nzJ;

                {
                    this.nzJ = r1;
                }

                public final int a(int i, int i2, String str, com.tencent.mm.v.b bVar, k kVar) {
                    jy jyVar = (jy) bVar.czl.czs;
                    this.nzJ.hUb = jyVar.mmt;
                    if (i == 0 && i2 == 0 && !be.kS(jyVar.mmt) && !be.kS(jyVar.gom)) {
                        this.nzJ.bcB = jyVar.gom;
                        this.nzJ.nzH = jyVar.mmu;
                        this.nzJ.byO();
                    } else if (o.a.a(this.nzJ, i, i2, str, 7)) {
                        this.nzJ.setResult(5);
                        this.nzJ.finish();
                    } else {
                        this.nzJ.byQ();
                        this.nzJ.setResult(3);
                        this.nzJ.finish();
                    }
                    return 0;
                }
            });
            return;
        }
        setResult(2);
        byR();
        finish();
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.nzC != null) {
            this.nzC.clear();
        }
        if (ak.uz()) {
            ak.vy().b(605, (e) this);
            u.Dy().d(this);
            ak.yW();
            c.wH().b(this);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130903841;
    }

    private boolean byN() {
        Intent intent = getIntent();
        if (intent == null) {
            v.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
            return false;
        }
        this.appId = intent.getStringExtra("appId");
        this.bcB = intent.getStringExtra("toUserName");
        if (be.kS(this.bcB)) {
            v.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
            return false;
        }
        this.extInfo = intent.getStringExtra("extInfo");
        this.bbT = intent.getIntExtra("source", -1);
        this.scene = intent.getIntExtra("scene", 0);
        this.nzI = intent.getIntExtra("jump_profile_type", 0);
        switch (this.bbT) {
            case 1:
                if (!be.kS(this.appId)) {
                    this.fromScene = 68;
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("androidPackNameList");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        this.nzC = new LinkedList();
                        for (int i = 0; i < stringArrayListExtra.size(); i++) {
                            String str = (String) stringArrayListExtra.get(i);
                            if (!be.kS(str)) {
                                v.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", Integer.valueOf(i), str);
                                this.nzC.add(m.lY(str));
                            }
                        }
                        if (this.nzC.size() != 0) {
                            this.nzB = this.nzC.size();
                            break;
                        }
                        v.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
                        return false;
                    }
                    v.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
                    return false;
                }
                v.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
                return false;
                break;
            case 2:
                this.fromScene = 69;
                break;
            default:
                v.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", Integer.valueOf(this.bbT));
                return false;
        }
        this.bbU = intent.getStringExtra("fromURL");
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (kVar.getType() == 605) {
            return;
        }
        if (kVar.getType() == 233) {
            ak.vy().b(233, (e) this);
            if (i == 0 && i2 == 0) {
                l lVar = (l) kVar;
                int IV = lVar.IV();
                v.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", Integer.valueOf(IV));
                if (IV == 15) {
                    v.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", Integer.valueOf(IV), lVar.IT());
                    com.tencent.mm.sdk.c.b fzVar = new fz();
                    fzVar.bfx.actionCode = IV;
                    fzVar.bfx.bfz = r1;
                    fzVar.bfx.context = this;
                    com.tencent.mm.sdk.c.a.nhr.a(fzVar, Looper.myLooper());
                    finish();
                    return;
                }
                byQ();
                return;
            }
            byQ();
            return;
        }
        v.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", Integer.valueOf(kVar.getType()));
    }

    private synchronized void byO() {
        v.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.nzD);
        Intent intent;
        if (this.scene == 1) {
            intent = new Intent();
            intent.putExtra("rawUrl", this.nzH);
            com.tencent.mm.ay.c.b((Context) this, "webview", ".ui.tools.WebViewUI", intent);
            finish();
        } else if (this.scene == 0 && this.nzI == 1) {
            if (this.nzF) {
                v.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
            } else {
                this.nzF = true;
                ak.vy().a(233, (e) this);
                ak.vy().a(new l(this.extInfo, null, 4), 0);
            }
        } else if (byP() && this.nzD) {
            if (!this.nzF) {
                v.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
                intent = new Intent().putExtra("Chat_User", this.bcB);
                intent.putExtra("finish_direct", true);
                if (be.kS(this.bcB)) {
                    com.tencent.mm.ui.contact.e.a(intent, this.bcB);
                }
                intent.setClass(this, ChattingUI.class);
                if (!this.nzE) {
                    setResult(-1);
                    this.nzF = true;
                    startActivity(intent);
                    finish();
                }
            }
        } else if (this.nzD && !this.nzF) {
            v.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
            ak.yW();
            ab LX = c.wH().LX(this.bcB);
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_Scene", this.fromScene);
            intent2.putExtra("Verify_ticket", this.hUb);
            if (LX != null) {
                intent2.putExtra("Contact_Alias", LX.pD());
                intent2.putExtra("Contact_Nick", LX.field_nickname);
                intent2.putExtra("Contact_Signature", LX.bCj);
                intent2.putExtra("Contact_RegionCode", LX.bCq);
                intent2.putExtra("Contact_Sex", LX.bBZ);
                intent2.putExtra("Contact_VUser_Info", LX.bCp);
                intent2.putExtra("Contact_VUser_Info_Flag", LX.field_verifyFlag);
                intent2.putExtra("Contact_KWeibo_flag", LX.field_weiboFlag);
                intent2.putExtra("Contact_KWeibo", LX.bCo);
                intent2.putExtra("Contact_KWeiboNick", LX.field_weiboNickname);
            }
            com.tencent.mm.ui.contact.e.j(intent2, this.bcB);
            if (!this.nzE) {
                setResult(-1);
                this.nzF = true;
                com.tencent.mm.ay.c.b((Context) this, "profile", ".ui.ContactInfoUI", intent2);
                finish();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean byP() {
        /*
        r7 = this;
        r0 = 0;
        r1 = 1;
        monitor-enter(r7);
        com.tencent.mm.model.ak.yW();	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.model.c.wH();	 Catch:{ all -> 0x008c }
        r3 = r7.bcB;	 Catch:{ all -> 0x008c }
        r4 = r2.LX(r3);	 Catch:{ all -> 0x008c }
        if (r4 == 0) goto L_0x0017;
    L_0x0012:
        r2 = r4.chr;	 Catch:{ all -> 0x008c }
        r2 = (int) r2;	 Catch:{ all -> 0x008c }
        if (r2 != 0) goto L_0x00b4;
    L_0x0017:
        r2 = "MicroMsg.CheckCanSubscribeBizUI";
        r3 = "contact is null.";
        com.tencent.mm.sdk.platformtools.v.w(r2, r3);	 Catch:{ all -> 0x008c }
        r2 = r1;
    L_0x0021:
        r3 = 0;
        if (r2 != 0) goto L_0x002a;
    L_0x0024:
        r3 = r7.bcB;	 Catch:{ all -> 0x008c }
        r3 = com.tencent.mm.modelbiz.e.hw(r3);	 Catch:{ all -> 0x008c }
    L_0x002a:
        if (r3 == 0) goto L_0x0032;
    L_0x002c:
        r5 = r3.Ct();	 Catch:{ all -> 0x008c }
        if (r5 == 0) goto L_0x0050;
    L_0x0032:
        r2 = "MicroMsg.CheckCanSubscribeBizUI";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008c }
        r6 = "BizInfo(";
        r5.<init>(r6);	 Catch:{ all -> 0x008c }
        r3 = r5.append(r3);	 Catch:{ all -> 0x008c }
        r5 = ") is null or should update.";
        r3 = r3.append(r5);	 Catch:{ all -> 0x008c }
        r3 = r3.toString();	 Catch:{ all -> 0x008c }
        com.tencent.mm.sdk.platformtools.v.e(r2, r3);	 Catch:{ all -> 0x008c }
        r2 = r1;
    L_0x0050:
        r3 = r7.nzG;	 Catch:{ all -> 0x008c }
        if (r3 == 0) goto L_0x007b;
    L_0x0054:
        if (r4 != 0) goto L_0x0065;
    L_0x0056:
        r1 = 0;
        r7.nzD = r1;	 Catch:{ all -> 0x008c }
        r1 = 5;
        r7.setResult(r1);	 Catch:{ all -> 0x008c }
        r7.byR();	 Catch:{ all -> 0x008c }
        r7.finish();	 Catch:{ all -> 0x008c }
    L_0x0063:
        monitor-exit(r7);
        return r0;
    L_0x0065:
        r2 = 1;
        r7.nzD = r2;	 Catch:{ all -> 0x008c }
        r2 = 1;
        r7.cvW = r2;	 Catch:{ all -> 0x008c }
        r2 = r4.field_type;	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.i.a.ei(r2);	 Catch:{ all -> 0x008c }
        if (r2 == 0) goto L_0x0063;
    L_0x0073:
        r0 = 1;
        r7.nzD = r0;	 Catch:{ all -> 0x008c }
        r0 = 1;
        r7.cvW = r0;	 Catch:{ all -> 0x008c }
        r0 = r1;
        goto L_0x0063;
    L_0x007b:
        if (r2 == 0) goto L_0x009f;
    L_0x007d:
        r1 = r7.nzD;	 Catch:{ all -> 0x008c }
        if (r1 == 0) goto L_0x008f;
    L_0x0081:
        r1 = 5;
        r7.setResult(r1);	 Catch:{ all -> 0x008c }
        r7.byR();	 Catch:{ all -> 0x008c }
        r7.finish();	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x008c:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x008f:
        r1 = com.tencent.mm.model.ab.a.crZ;	 Catch:{ all -> 0x008c }
        r2 = r7.bcB;	 Catch:{ all -> 0x008c }
        r3 = "";
        r4 = new com.tencent.mm.ui.CheckCanSubscribeBizUI$1;	 Catch:{ all -> 0x008c }
        r4.<init>(r7);	 Catch:{ all -> 0x008c }
        r1.a(r2, r3, r4);	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x009f:
        r2 = r4.field_type;	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.i.a.ei(r2);	 Catch:{ all -> 0x008c }
        if (r2 != 0) goto L_0x0073;
    L_0x00a7:
        r1 = "MicroMsg.CheckCanSubscribeBizUI";
        r2 = "is not contact.";
        com.tencent.mm.sdk.platformtools.v.w(r1, r2);	 Catch:{ all -> 0x008c }
        r1 = 1;
        r7.nzD = r1;	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x00b4:
        r2 = r0;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.CheckCanSubscribeBizUI.byP():boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            this.nzE = true;
            if (this.nzF) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void byQ() {
        Toast.makeText(this, getString(2131235774), 1).show();
        akh();
    }

    private void byR() {
        Toast.makeText(this, 2131234453, 1).show();
        akh();
    }

    private void akh() {
        if (this.bbT == 1) {
            LauncherUI.ej(this);
        }
    }

    public final void a(final String str, i iVar) {
        new ac().post(new Runnable(this) {
            final /* synthetic */ CheckCanSubscribeBizUI nzJ;

            public final void run() {
                v.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + this.nzJ.bcB + ", userName = " + str);
                if (this.nzJ.bcB.equals(str)) {
                    this.nzJ.nzD = true;
                    if (!this.nzJ.cvW) {
                        this.nzJ.byO();
                    }
                }
            }
        });
    }

    public final void a(int i, j jVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            v.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), jVar, obj);
            return;
        }
        a((String) obj, null);
    }
}
