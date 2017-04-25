package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Toast;
import com.tencent.mm.ak.r;
import com.tencent.mm.e.a.gd;
import com.tencent.mm.e.a.ik;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.e.a.mv;
import com.tencent.mm.e.a.pd;
import com.tencent.mm.e.a.pw;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.h;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.pluginsdk.j.v;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.RoomCardPreference;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.afy;
import com.tencent.mm.protocal.c.aio;
import com.tencent.mm.protocal.c.ur;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.o;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ChatroomInfoUI extends MMPreference implements v, com.tencent.mm.sdk.h.g.a, b, e {
    private static boolean ePH = false;
    private boolean bhx;
    private SharedPreferences cnm = null;
    private ProgressDialog dwR = null;
    private f dxf;
    private boolean eJx;
    int ePA;
    String ePB;
    private p ePC = null;
    private c ePD = new c<jp>(this) {
        final /* synthetic */ ChatroomInfoUI ePK;

        {
            this.ePK = r2;
            this.nhz = jp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            jp jpVar = (jp) bVar;
            CharSequence charSequence = jpVar.bka.bkc;
            int i = jpVar.bka.ret;
            if (i == 0 || charSequence == null) {
                if (i == 0 && this.ePK.ePy) {
                    if (this.ePK.ePA == 27) {
                        com.tencent.mm.sdk.c.a.nhr.z(new pw());
                        this.ePK.euW.bS(this.ePK.ePB);
                        ak.yW();
                        com.tencent.mm.model.c.wH().M(this.ePK.euW);
                        this.ePK.adl();
                    } else if (this.ePK.ePA == 48 && this.ePK.ePs != null) {
                        this.ePK.ePs.field_chatroomname = this.ePK.ePn;
                        this.ePK.ePs.field_selfDisplayName = this.ePK.ePG;
                        ak.yW().wO().a(this.ePK.ePs, new String[0]);
                        this.ePK.adi();
                    }
                }
            } else if (this.ePK.ePz != null && this.ePK.ePA == 27) {
                ak.yW();
                com.tencent.mm.model.c.wG().c(this.ePK.ePz);
            } else if (this.ePK.ePF != null && this.ePK.ePA == 48) {
                ak.yW();
                com.tencent.mm.model.c.wG().c(this.ePK.ePF);
                Toast.makeText(this.ePK.nDR.nEl, charSequence, 1).show();
            }
            if (this.ePK.ePC != null) {
                this.ePK.ePC.dismiss();
            }
            return false;
        }
    };
    private String ePE = "";
    private com.tencent.mm.ak.j.a ePF;
    private String ePG;
    private String ePI = null;
    private com.tencent.mm.pluginsdk.d.b ePJ = new com.tencent.mm.pluginsdk.d.b(this) {
        final /* synthetic */ ChatroomInfoUI ePK;

        {
            this.ePK = r2;
        }

        public final void a(int i, int i2, String str, com.tencent.mm.sdk.c.b bVar) {
            if (bVar instanceof ik) {
                ik ikVar = (ik) bVar;
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
                if (this.ePK.dwR != null) {
                    this.ePK.dwR.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    if (i == 0 && i2 == 0 && this.ePK.ePg != null) {
                        ArrayList ag = ChatroomInfoUI.ag(ikVar.biQ.biC);
                        ContactListExpandPreference m = this.ePK.ePg;
                        if (m.lKE != null) {
                            com.tencent.mm.pluginsdk.ui.applet.e eVar = m.lKE.lJM;
                            eVar.W(ag);
                            eVar.notifyChanged();
                        }
                        if (this.ePK.dxf != null) {
                            this.ePK.dxf.notifyDataSetChanged();
                        }
                        this.ePK.Fd(this.ePK.getResources().getQuantityString(2131361816, ag.size(), new Object[]{Integer.valueOf(ag.size())}));
                    }
                    this.ePK.adg();
                } else if (i2 == -21) {
                    g.a(this.ePK, this.ePK.getString(2131234606), this.ePK.getString(2131231164), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass23 ePX;

                        {
                            this.ePX = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ePX.ePK.finish();
                        }
                    });
                } else {
                    g.A(this.ePK, this.ePK.getString(2131234608), this.ePK.getString(2131231164));
                }
            }
        }
    };
    private boolean ePa;
    private RoomCardPreference ePb;
    private SignaturePreference ePc;
    private Preference ePd;
    private NormalIconPreference ePe;
    private NormalIconPreference ePf;
    private ContactListExpandPreference ePg;
    private CheckBoxPreference ePh;
    private CheckBoxPreference ePi;
    private CheckBoxPreference ePj;
    private SignaturePreference ePk;
    private CheckBoxPreference ePl;
    private boolean ePm;
    private String ePn;
    private boolean ePo;
    private boolean ePp = false;
    private int ePq;
    private boolean ePr = false;
    private o ePs = null;
    private int ePt = -1;
    private d ePu = new d(new OnScrollListener(this) {
        final /* synthetic */ ChatroomInfoUI ePK;

        {
            this.ePK = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean ePv = false;
    private c ePw = new c<gd>(this) {
        final /* synthetic */ ChatroomInfoUI ePK;

        {
            this.ePK = r2;
            this.nhz = gd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (((gd) bVar) instanceof gd) {
                this.ePK.ada();
            }
            return false;
        }
    };
    int ePx = -1;
    private boolean ePy = false;
    private com.tencent.mm.ak.j.a ePz;
    private u euW;
    private boolean eut = false;
    private ac handler = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ ChatroomInfoUI ePK;

        public final void handleMessage(Message message) {
            ChatroomInfoUI.a(this.ePK);
        }
    };

    static class a implements OnCancelListener {
        a() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            ChatroomInfoUI.ePH = true;
        }
    }

    static /* synthetic */ void a(ik ikVar) {
        ikVar.biP.bin = true;
        com.tencent.mm.sdk.c.a.nhr.z(ikVar);
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI) {
        chatroomInfoUI.adg();
        String LE = ak.yW().wO().LE(chatroomInfoUI.ePn);
        if (chatroomInfoUI.ePI != null && !chatroomInfoUI.ePI.equals(LE)) {
            chatroomInfoUI.adn();
        }
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI, String str) {
        com.tencent.mm.plugin.report.service.g.iuh.a(219, 4, 1, true);
        chatroomInfoUI.ePG = str;
        String xF = k.xF();
        aio com_tencent_mm_protocal_c_aio = new aio();
        com_tencent_mm_protocal_c_aio.moN = chatroomInfoUI.ePn;
        com_tencent_mm_protocal_c_aio.gln = xF;
        com_tencent_mm_protocal_c_aio.mlX = be.ma(str);
        chatroomInfoUI.ePF = new com.tencent.mm.ak.j.a(48, com_tencent_mm_protocal_c_aio);
        chatroomInfoUI.ePA = 48;
        ActionBarActivity actionBarActivity = chatroomInfoUI.nDR.nEl;
        chatroomInfoUI.getString(2131231164);
        chatroomInfoUI.ePC = g.a(actionBarActivity, chatroomInfoUI.getString(2131232013), false, null);
        chatroomInfoUI.ePy = true;
        ak.yW();
        com.tencent.mm.model.c.wG().b(chatroomInfoUI.ePF);
    }

    static /* synthetic */ boolean a(ChatroomInfoUI chatroomInfoUI, int i, int i2, String str) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "pre is " + chatroomInfoUI.ePq);
        chatroomInfoUI.ePq = i.el(chatroomInfoUI.ePn);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "now is " + chatroomInfoUI.ePq);
        if (chatroomInfoUI.dwR != null) {
            chatroomInfoUI.dwR.dismiss();
        }
        com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
        if (dm == null) {
            return false;
        }
        dm.a(chatroomInfoUI, null, null);
        return true;
    }

    static /* synthetic */ void x(ChatroomInfoUI chatroomInfoUI) {
        ak.yW();
        long j = com.tencent.mm.model.c.wJ().MH(chatroomInfoUI.ePn).field_msgSvrId;
        ak.yW();
        com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.d(chatroomInfoUI.ePn, j));
        chatroomInfoUI.eut = false;
        chatroomInfoUI.getString(2131231164);
        final p a = g.a(chatroomInfoUI, chatroomInfoUI.getString(2131231182), true, new OnCancelListener(chatroomInfoUI) {
            final /* synthetic */ ChatroomInfoUI ePK;

            {
                this.ePK = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.ePK.eut = true;
            }
        });
        if (h.ed(chatroomInfoUI.ePn)) {
            com.tencent.mm.plugin.chatroom.a.drq.bq(chatroomInfoUI.ePn);
        }
        aw.a(chatroomInfoUI.ePn, new com.tencent.mm.model.aw.a(chatroomInfoUI) {
            final /* synthetic */ ChatroomInfoUI ePK;

            public final boolean zp() {
                return this.ePK.eut;
            }

            public final void zo() {
                if (a != null) {
                    a.dismiss();
                }
            }
        });
        ak.yW();
        com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.b(chatroomInfoUI.ePn));
        ak.yW();
        com.tencent.mm.model.c.wK().Mf(chatroomInfoUI.ePn);
        ak.yW();
        com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.c(chatroomInfoUI.ePn));
        ak.yW();
        r wG = com.tencent.mm.model.c.wG();
        ak.yW();
        wG.b(new com.tencent.mm.ak.p((String) com.tencent.mm.model.c.vf().get(2, null), chatroomInfoUI.ePn));
        String str = chatroomInfoUI.ePn;
        if (str.toLowerCase().endsWith("@chatroom")) {
            ak.yW();
            aa wH = com.tencent.mm.model.c.wH();
            if (wH.LZ(str)) {
                wH.Mc(str);
            } else {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom RoomName not exist:[" + str + "]");
            }
            i.ei(str);
        } else {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomMembersLogic", "deleteWholeChatroom: room:[" + str + "]");
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.plugin.chatroom.a.drp.t(intent, chatroomInfoUI.nDR.nEl);
        chatroomInfoUI.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(223, this);
        ak.vy().a(179, this);
        ak.vy().a(480, this);
        ak.vy().a(610, this);
        com.tencent.mm.pluginsdk.d.b.a(ik.class.getName(), this.ePJ);
        this.ePw.bsL().c(this);
        this.ePD.bsL().c(this);
        ak.yW();
        com.tencent.mm.model.c.wH().a(this);
        ak.yW().wO().c(this);
        if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
            com.tencent.mm.pluginsdk.j.a.lxG.a(this);
        }
        this.ePn = getIntent().getStringExtra("RoomInfo_Id");
        ak.yW();
        this.euW = com.tencent.mm.model.c.wH().LX(this.ePn);
        this.bhx = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ePa = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.ePE = getPackageName() + "_preferences";
        if (this.bhx) {
            this.ePs = ak.yW().wO().LC(this.ePn);
        }
        NI();
        if (this.bhx) {
            final AnonymousClass22 anonymousClass22 = new com.tencent.mm.model.ab.c.a(this) {
                final /* synthetic */ ChatroomInfoUI ePK;

                {
                    this.ePK = r1;
                }

                public final void p(final String str, boolean z) {
                    if (z && this.ePK.ePn.equals(str)) {
                        ak.vA().x(new Runnable(this) {
                            final /* synthetic */ AnonymousClass22 ePW;

                            public final void run() {
                                com.tencent.mm.storage.p wO = ak.yW().wO();
                                String str = str;
                                wO.cie.dF("chatroom", "update chatroom set modifytime = " + System.currentTimeMillis() + " where chatroomname = '" + be.lZ(str) + "'");
                            }

                            public final String toString() {
                                return super.toString() + "|getContactCallBack";
                            }
                        });
                    }
                }
            };
            if (this.ePs == null) {
                com.tencent.mm.model.ab.a.crZ.a(this.ePn, "", anonymousClass22);
            } else if (System.currentTimeMillis() - this.ePs.field_modifytime >= 86400000) {
                ak.vA().x(new Runnable(this) {
                    final /* synthetic */ ChatroomInfoUI ePK;

                    public final void run() {
                        com.tencent.mm.model.ab.a.crZ.a(this.ePK.ePs.field_chatroomname, "", anonymousClass22);
                    }

                    public final String toString() {
                        return super.toString() + "|getContactCallBack2";
                    }
                });
            }
        }
    }

    private void ada() {
        new com.tencent.mm.plugin.chatroom.c.c(this.ePn).Bt().a((com.tencent.mm.vending.e.b) this).a(new com.tencent.mm.vending.c.a<com.tencent.mm.v.a.a<ur>, com.tencent.mm.v.a.a<ur>>(this) {
            final /* synthetic */ ChatroomInfoUI ePK;

            {
                this.ePK = r1;
            }

            public final /* synthetic */ Object aq(Object obj) {
                String str = null;
                com.tencent.mm.v.a.a aVar = (com.tencent.mm.v.a.a) obj;
                if (ChatroomInfoUI.a(this.ePK, aVar.errType, aVar.errCode, aVar.biS)) {
                    return null;
                }
                int i = aVar.errType;
                int i2 = aVar.errCode;
                if (i != 0 || i2 != 0) {
                    return null;
                }
                if (i == 0 && i2 == 0) {
                    int i3 = -1;
                    long j = -1;
                    String str2 = "";
                    if (i == 0 && i2 == 0) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ChatroomInfoUI", "dz[onSceneEnd : get announcement successfully!]");
                        str = ((ur) aVar.bra).mxl;
                        int i4 = ((ur) aVar.bra).mxm;
                        long j2 = (long) ((ur) aVar.bra).mxo;
                        str2 = ((ur) aVar.bra).mxn;
                        i3 = i4;
                        j = j2;
                    }
                    String b = this.ePK.ePn;
                    str = be.ma(str);
                    com.tencent.mm.storage.p wO = ak.yW().wO();
                    o LC = wO.LC(b);
                    if (LC != null) {
                        LC.field_chatroomVersion = i3;
                        LC.field_chatroomnoticePublishTime = j;
                        LC.field_chatroomnoticeEditor = str2;
                        LC.field_chatroomnotice = str;
                        wO.b(LC);
                    }
                }
                return aVar;
            }
        }).b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.v.a.a<ur>>(this) {
            final /* synthetic */ ChatroomInfoUI ePK;

            {
                this.ePK = r1;
            }

            public final /* synthetic */ Object aq(Object obj) {
                com.tencent.mm.v.a.a aVar = (com.tencent.mm.v.a.a) obj;
                if (aVar == null) {
                    return phb;
                }
                int i = aVar.errType;
                int i2 = aVar.errCode;
                if (i == 0 && i2 == 0) {
                    if (this.ePK.ePs != null) {
                        this.ePK.ePq = this.ePK.ePs.DM().size();
                    }
                    if ((!this.ePK.ePp && this.ePK.ePq >= com.tencent.mm.pluginsdk.ui.applet.e.lJW) || (this.ePK.ePp && this.ePK.ePq >= com.tencent.mm.pluginsdk.ui.applet.e.lJW - 1)) {
                        this.ePK.dxf.aO("see_room_member", false);
                        this.ePK.ePd.setTitle(this.ePK.getString(2131234860));
                    }
                }
                this.ePK.adk();
                this.ePK.adl();
                this.ePK.adg();
                return phb;
            }
        });
    }

    public void onResume() {
        super.onResume();
        ak.vy().a(120, this);
        this.dxf.notifyDataSetChanged();
        if (i.eg(this.ePn)) {
            ada();
        }
        adk();
        adg();
        adj();
        if (this.bhx) {
            adl();
            adi();
        }
        adh();
        String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
        if (!this.ePv) {
            if (!be.kS(stringExtra)) {
                qJ(stringExtra);
            }
            this.ePv = true;
        }
        if (!be.kS(stringExtra) && stringExtra.equals("room_notify_new_notice") && !this.ePv) {
            qJ("room_card");
            this.ePv = true;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ePg.notifyChanged();
    }

    private void qJ(String str) {
        final int Oy = this.dxf.Oy(str);
        this.gMx.smoothScrollToPosition(Oy);
        new ac().postDelayed(new Runnable(this) {
            final /* synthetic */ ChatroomInfoUI ePK;

            public final void run() {
                View a = ((com.tencent.mm.ui.base.preference.a) this.ePK.dxf).a(Oy, this.ePK.gMx);
                if (a != null) {
                    com.tencent.mm.ui.g.a.b(this.ePK.nDR.nEl, a);
                }
            }
        }, 10);
    }

    public void onPause() {
        super.onPause();
        ak.vy().b(120, this);
        if (this.ePr && this.bhx && this.ePs != null) {
            i.a(this.ePn, this.ePs, this.ePm);
        }
    }

    public void onDestroy() {
        if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
            com.tencent.mm.pluginsdk.j.a.lxG.a(this);
        }
        com.tencent.mm.ui.g.a.dismiss();
        ak.vy().b(223, this);
        ak.vy().b(179, this);
        ak.vy().b(480, this);
        ak.vy().b(610, this);
        com.tencent.mm.sdk.c.a.nhr.f(this.ePD);
        com.tencent.mm.sdk.c.a.nhr.f(this.ePw);
        com.tencent.mm.pluginsdk.d.b.b(ik.class.getName(), this.ePJ);
        if (ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.wH().b(this);
            ak.yW().wO().d(this);
        }
        if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
            com.tencent.mm.pluginsdk.j.a.lxG.b(this);
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        final String stringExtra;
        switch (i) {
            case 1:
                if (intent != null) {
                    stringExtra = intent.getStringExtra("Select_Contact");
                    o LC = ak.yW().wO().LC(this.ePn);
                    if (LC == null) {
                        return;
                    }
                    if (LC.bvf() != 2 || this.ePp) {
                        m(stringExtra, null, 2131230828);
                        return;
                    } else {
                        com.tencent.mm.pluginsdk.ui.applet.c.a(this.nDR, getString(2131234554), getString(2131234346), getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                            final /* synthetic */ ChatroomInfoUI ePK;

                            public final void a(boolean z, String str, int i) {
                                if (z) {
                                    this.ePK.m(stringExtra, str, 2131233332);
                                }
                            }
                        });
                        return;
                    }
                }
                return;
            case 2:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            case 4:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("room_name");
                    if (!be.kS(stringExtra)) {
                        com.tencent.mm.sdk.c.a.nhr.z(new pw());
                        this.euW.bS(stringExtra);
                        ak.yW();
                        com.tencent.mm.model.c.wH().M(this.euW);
                        adl();
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (i2 == 0) {
                    this.ePx = -1;
                    return;
                }
                return;
            case 7:
                if (intent != null) {
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (stringExtra != null && !stringExtra.equals("")) {
                        final com.tencent.mm.plugin.chatroom.c.g gVar = new com.tencent.mm.plugin.chatroom.c.g(this.ePn, be.g(stringExtra.split(",")));
                        getString(2131231164);
                        this.dwR = g.a(this, getString(2131234578), true, new OnCancelListener(this) {
                            final /* synthetic */ ChatroomInfoUI ePK;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(gVar);
                            }
                        });
                        ak.vy().a(gVar, 0);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int Oo() {
        return 2131099712;
    }

    protected final void NI() {
        this.dxf = this.ocZ;
        String str;
        if (this.bhx) {
            u LX;
            o LC;
            if (this.ePq == 0) {
                Fd(getString(2131234689));
            } else {
                if (this.ePs != null) {
                    this.ePq = this.ePs.DM().size();
                }
                Fd(getString(2131232864, new Object[]{getString(2131234689), Integer.valueOf(this.ePq)}));
            }
            str = null;
            if (this.ePs != null) {
                str = this.ePs.field_roomowner;
                this.ePq = this.ePs.DM().size();
            }
            if (be.kS(str)) {
                this.ePo = false;
                this.ePp = false;
            } else {
                this.ePo = true;
                this.ePp = str.equals(k.xF());
            }
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
            this.ePg = (ContactListExpandPreference) this.dxf.Ow("roominfo_contact_anchor");
            this.ePg.a(this.dxf, this.ePg.dnU);
            this.ePf = (NormalIconPreference) this.dxf.Ow("del_selector_btn");
            this.ePe = (NormalIconPreference) this.dxf.Ow("add_selector_btn");
            this.ePc = (SignaturePreference) this.dxf.Ow("room_name");
            this.ePb = (RoomCardPreference) this.dxf.Ow("room_card");
            this.ePd = this.dxf.Ow("see_room_member");
            this.ePh = (CheckBoxPreference) this.dxf.Ow("room_notify_new_msg");
            this.ePi = (CheckBoxPreference) this.dxf.Ow("room_save_to_contact");
            this.ePj = (CheckBoxPreference) this.dxf.Ow("room_placed_to_the_top");
            this.ePk = (SignaturePreference) this.dxf.Ow("room_nickname");
            this.ePg.hZ(true).ia(true).bpq();
            if (!this.ePp) {
                this.dxf.aO("del_selector_btn", true);
            } else if (i.el(this.ePn) > 2) {
                this.dxf.aO("manage_room", false);
                this.ePg.bpo();
                if (this.ePs != null) {
                    this.ePg.HA(this.ePs.field_roomowner);
                    if (!be.kS(this.ePs.field_roomowner)) {
                        this.ePg.lKE.lJM.lKu = true;
                    }
                }
                this.ePg.bpn();
                this.ePg.bpr();
                this.dxf.aO("add_selector_btn", true);
                this.dxf.aO("del_selector_btn", true);
                this.dxf.aO("room_name", false);
                this.dxf.aO("room_qr_code", false);
                this.dxf.aO("chatroom_info_chexboxes", true);
                this.dxf.aO("room_card", false);
                this.dxf.aO("room_upgrade_entry", true);
                if ((!this.ePp || this.ePq < com.tencent.mm.pluginsdk.ui.applet.e.lJW) && (!this.ePp || this.ePq < com.tencent.mm.pluginsdk.ui.applet.e.lJW - 1)) {
                    this.dxf.aO("see_room_member", true);
                } else {
                    this.dxf.aO("see_room_member", false);
                    this.ePd.setTitle(getString(2131234860, new Object[]{Integer.valueOf(this.ePq)}));
                }
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
                if (this.cnm == null) {
                    this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                if (this.ePj != null) {
                    if (this.euW == null) {
                        ak.yW();
                        this.cnm.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.wK().Mn(this.euW.field_username)).commit();
                    } else {
                        this.cnm.edit().putBoolean("room_placed_to_the_top", false).commit();
                    }
                }
                this.dxf.notifyDataSetChanged();
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
                if (this.cnm == null) {
                    this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                if (this.ePi != null) {
                    ak.yW();
                    LX = com.tencent.mm.model.c.wH().LX(this.ePn);
                    if (LX != null) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                        if (this.cnm == null) {
                            this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
                        }
                        LC = ak.yW().wO().LC(this.ePn);
                        if (LC != null) {
                            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                        } else {
                            this.ePm = LC.bvh();
                            this.ePl = (CheckBoxPreference) this.dxf.Ow("room_msg_show_username");
                            if (this.ePl != null) {
                                this.cnm.edit().putBoolean("room_msg_show_username", this.ePm).commit();
                            }
                            this.dxf.notifyDataSetChanged();
                        }
                        ak.yW();
                        this.ePt = com.tencent.mm.model.c.wJ().Nc(this.ePn);
                    } else {
                        this.cnm.edit().putBoolean("room_save_to_contact", com.tencent.mm.i.a.ei(LX.field_type)).commit();
                    }
                }
                this.dxf.notifyDataSetChanged();
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                if (this.cnm == null) {
                    this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                LC = ak.yW().wO().LC(this.ePn);
                if (LC != null) {
                    this.ePm = LC.bvh();
                    this.ePl = (CheckBoxPreference) this.dxf.Ow("room_msg_show_username");
                    if (this.ePl != null) {
                        this.cnm.edit().putBoolean("room_msg_show_username", this.ePm).commit();
                    }
                    this.dxf.notifyDataSetChanged();
                } else {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                }
                ak.yW();
                this.ePt = com.tencent.mm.model.c.wJ().Nc(this.ePn);
            }
            this.dxf.aO("manage_room", true);
            this.ePg.bpo();
            if (this.ePs != null) {
                this.ePg.HA(this.ePs.field_roomowner);
                if (be.kS(this.ePs.field_roomowner)) {
                    this.ePg.lKE.lJM.lKu = true;
                }
            }
            this.ePg.bpn();
            this.ePg.bpr();
            this.dxf.aO("add_selector_btn", true);
            this.dxf.aO("del_selector_btn", true);
            this.dxf.aO("room_name", false);
            this.dxf.aO("room_qr_code", false);
            this.dxf.aO("chatroom_info_chexboxes", true);
            this.dxf.aO("room_card", false);
            this.dxf.aO("room_upgrade_entry", true);
            if (this.ePp) {
            }
            this.dxf.aO("see_room_member", true);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
            if (this.cnm == null) {
                this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.ePj != null) {
                if (this.euW == null) {
                    this.cnm.edit().putBoolean("room_placed_to_the_top", false).commit();
                } else {
                    ak.yW();
                    this.cnm.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.wK().Mn(this.euW.field_username)).commit();
                }
            }
            this.dxf.notifyDataSetChanged();
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
            if (this.cnm == null) {
                this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.ePi != null) {
                ak.yW();
                LX = com.tencent.mm.model.c.wH().LX(this.ePn);
                if (LX != null) {
                    this.cnm.edit().putBoolean("room_save_to_contact", com.tencent.mm.i.a.ei(LX.field_type)).commit();
                } else {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                    if (this.cnm == null) {
                        this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
                    }
                    LC = ak.yW().wO().LC(this.ePn);
                    if (LC != null) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                    } else {
                        this.ePm = LC.bvh();
                        this.ePl = (CheckBoxPreference) this.dxf.Ow("room_msg_show_username");
                        if (this.ePl != null) {
                            this.cnm.edit().putBoolean("room_msg_show_username", this.ePm).commit();
                        }
                        this.dxf.notifyDataSetChanged();
                    }
                    ak.yW();
                    this.ePt = com.tencent.mm.model.c.wJ().Nc(this.ePn);
                }
            }
            this.dxf.notifyDataSetChanged();
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
            if (this.cnm == null) {
                this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            LC = ak.yW().wO().LC(this.ePn);
            if (LC != null) {
                this.ePm = LC.bvh();
                this.ePl = (CheckBoxPreference) this.dxf.Ow("room_msg_show_username");
                if (this.ePl != null) {
                    this.cnm.edit().putBoolean("room_msg_show_username", this.ePm).commit();
                }
                this.dxf.notifyDataSetChanged();
            } else {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
            }
            ak.yW();
            this.ePt = com.tencent.mm.model.c.wJ().Nc(this.ePn);
        } else if (this.ePa) {
            this.ePp = false;
            Fd(getString(2131234609));
            this.ePg = (ContactListExpandPreference) this.dxf.Ow("roominfo_contact_anchor");
            this.ePg.a(this.dxf, this.ePg.dnU);
            this.ePg.hZ(false).ia(false);
            this.ePg.a(new com.tencent.mm.pluginsdk.ui.applet.f.b(this) {
                final /* synthetic */ ChatroomInfoUI ePK;

                {
                    this.ePK = r1;
                }

                public final boolean jn(int i) {
                    return true;
                }
            });
            this.dxf.removeAll();
            this.dxf.a(new PreferenceCategory(this));
            this.dxf.a(this.ePg);
            str = this.ePn;
            final ik ikVar = new ik();
            ikVar.biP.bhm = str;
            com.tencent.mm.sdk.c.a.nhr.z(ikVar);
            getString(2131231164);
            this.dwR = g.a(this, getString(2131234607), true, new OnCancelListener(this) {
                final /* synthetic */ ChatroomInfoUI ePK;

                public final void onCancel(DialogInterface dialogInterface) {
                    ChatroomInfoUI.a(ikVar);
                }
            });
            this.dxf.notifyDataSetChanged();
        }
        if (this.ePg != null) {
            if (!this.bhx && this.ePa) {
                this.ePg.X(new ArrayList());
            }
            this.gMx.setOnScrollListener(this.ePu);
            this.ePg.a(this.ePu);
            this.ePg.a(new com.tencent.mm.pluginsdk.ui.applet.f.b(this) {
                final /* synthetic */ ChatroomInfoUI ePK;

                {
                    this.ePK = r1;
                }

                public final boolean jn(int i) {
                    return true;
                }
            });
            ContactListExpandPreference contactListExpandPreference = this.ePg;
            View.OnClickListener anonymousClass3 = new View.OnClickListener(this) {
                final /* synthetic */ ChatroomInfoUI ePK;

                {
                    this.ePK = r1;
                }

                public final void onClick(View view) {
                }
            };
            if (contactListExpandPreference.lKE != null) {
                contactListExpandPreference.lKE.iqU = anonymousClass3;
            }
            this.ePg.a(new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a(this) {
                final /* synthetic */ ChatroomInfoUI ePK;

                {
                    this.ePK = r1;
                }

                public final void jo(int i) {
                    this.ePK.add();
                }

                public final void jp(int i) {
                    String tY = this.ePK.ePg.tY(i);
                    String ma = be.ma(this.ePK.ePg.ua(i));
                    if (be.kS(ma)) {
                        ak.yW();
                        ba Nw = com.tencent.mm.model.c.wI().Nw(tY);
                        if (!(Nw == null || be.kS(Nw.field_encryptUsername))) {
                            ma = Nw.field_conRemark;
                        }
                    }
                    if (!be.kS(tY)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", tY);
                        intent.putExtra("Contact_RemarkName", ma);
                        if (this.ePK.bhx && this.ePK.ePs != null) {
                            intent.putExtra("Contact_RoomNickname", this.ePK.ePs.er(tY));
                        }
                        intent.putExtra("Contact_Nick", be.ma(this.ePK.ePg.tZ(i)));
                        intent.putExtra("Contact_RoomMember", true);
                        intent.putExtra("room_name", this.ePK.euW.field_username);
                        ak.yW();
                        u LX = com.tencent.mm.model.c.wH().LX(tY);
                        if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                            mv mvVar = new mv();
                            mvVar.bof.intent = intent;
                            mvVar.bof.username = tY;
                            com.tencent.mm.sdk.c.a.nhr.z(mvVar);
                        }
                        if (this.ePK.bhx) {
                            com.tencent.mm.plugin.report.service.g.iuh.a(219, 9, 1, true);
                            if (LX != null && LX.bvm()) {
                                com.tencent.mm.plugin.report.service.g.iuh.Y(10298, LX.field_username + ",14");
                            }
                            intent.putExtra("Contact_Scene", 14);
                        } else if (this.ePK.ePa) {
                            intent.putExtra("Contact_Scene", 44);
                            if (!k.eo(LX.field_username)) {
                                intent.putExtra("Contact_IsLBSFriend", true);
                            }
                        }
                        intent.putExtra("Is_RoomOwner", this.ePK.ePp);
                        intent.putExtra("Contact_ChatRoomId", this.ePK.ePn);
                        com.tencent.mm.plugin.chatroom.a.drp.d(intent, this.ePK);
                    }
                }

                public final void adp() {
                    if (this.ePK.ePg != null) {
                        this.ePK.ePg.bpp();
                    }
                }

                public final void jq(int i) {
                    this.ePK.adc();
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ChatroomInfoUI ePK;

            {
                this.ePK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ePK.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = null;
        int i = 1;
        String str2 = preference.dnU;
        int i2;
        Intent intent;
        if (str2.equals("room_name")) {
            str2 = j.sU().getValue("ChatRoomOwnerModTopic");
            if (be.kS(str2)) {
                i2 = 0;
            } else {
                i2 = be.KL(str2);
            }
            if (be.kS(this.ePs.field_roomowner) || r0 <= 0 || this.ePp || r0 >= this.ePq) {
                str2 = "";
                if (adm()) {
                    str2 = this.euW.tU();
                }
                intent = new Intent();
                intent.setClass(this, ModRemarkRoomNameUI.class);
                intent.putExtra("room_name", str2);
                intent.putExtra("RoomInfo_Id", this.ePn);
                startActivityForResult(intent, 4);
                com.tencent.mm.plugin.report.service.g.iuh.a(219, 3, 1, true);
            } else {
                g.a(this, getString(2131234666, new Object[]{ade()}), null, getString(2131231075), new OnClickListener(this) {
                    final /* synthetic */ ChatroomInfoUI ePK;

                    {
                        this.ePK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        } else if (str2.equals("room_upgrade_entry")) {
            bz(this);
        } else if (str2.equals("room_qr_code")) {
            com.tencent.mm.plugin.report.service.g.iuh.a(219, 5, 1, true);
            r0 = new Intent();
            r0.putExtra("from_userName", this.ePn);
            com.tencent.mm.ay.c.b(this, "setting", ".ui.setting.SelfQRCodeUI", r0);
        } else if (str2.equals("room_card")) {
            if (!be.kS(i.en(this.ePn)) || this.ePp) {
                Intent intent2 = new Intent();
                intent2.setClass(this, RoomCardUI.class);
                intent2.putExtra("RoomInfo_Id", this.ePn);
                intent2.putExtra("room_name", this.ePb.lQt.toString());
                this.ePq = i.ej(this.ePn).size();
                intent2.putExtra("room_member_count", this.ePq);
                intent2.putExtra("room_owner_name", ade());
                intent2.putExtra("room_notice", i.en(this.ePn));
                String str3 = "room_notice_publish_time";
                o LC = ak.yW().wO().LC(this.ePn);
                intent2.putExtra(str3, LC == null ? -1 : LC.field_chatroomnoticePublishTime);
                str2 = "room_notice_editor";
                o LC2 = ak.yW().wO().LC(this.ePn);
                if (LC2 != null) {
                    str = LC2.field_chatroomnoticeEditor;
                }
                intent2.putExtra(str2, str);
                intent2.putExtra("Is_RoomOwner", this.ePp);
                startActivityForResult(intent2, 6);
            } else {
                g.b(this, getString(2131234568), null, getString(2131234569), null, null, null);
            }
        } else if (str2.equals("room_notify_new_msg")) {
            this.eJx = !this.eJx;
            if (this.bhx) {
                i2 = this.eJx ? 0 : 1;
                ak.yW();
                com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.k(this.ePn, i2));
                ak.yW();
                this.euW = com.tencent.mm.model.c.wH().LX(this.ePn);
                this.euW.cZ(i2);
                ak.yW();
                com.tencent.mm.model.c.wH().a(this.ePn, this.euW);
            }
            r0 = com.tencent.mm.modelstat.b.daJ;
            str = this.ePn;
            boolean z = this.eJx;
            if (r0.JV() && r0.bc(str)) {
                IMBehavior iMBehavior = new IMBehavior();
                iMBehavior.opType = 1;
                iMBehavior.chattingOp = new IMBehaviorChattingOP();
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                if (!z) {
                    i = 2;
                }
                iMBehaviorChattingOP.changeNotifyStatus = i;
                r0.daI.oplist_.add(iMBehavior);
            }
            adj();
        } else if (str2.equals("room_save_to_contact")) {
            if (this.cnm == null) {
                this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            ak.yW();
            u LX = com.tencent.mm.model.c.wH().LX(this.ePn);
            if (LX != null) {
                boolean ei = com.tencent.mm.i.a.ei(LX.field_type);
                this.cnm.edit().putBoolean("room_save_to_contact", !ei).commit();
                if (ei) {
                    LX.tq();
                    m.r(LX);
                    g.bf(this, getString(2131234642));
                    com.tencent.mm.modelstat.b.daJ.D(this.ePn, false);
                } else {
                    m.o(LX);
                    g.bf(this, getString(2131234657));
                    com.tencent.mm.modelstat.b.daJ.D(this.ePn, true);
                }
                this.dxf.notifyDataSetChanged();
            }
        } else if (str2.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.ePE, 0);
            if (this.euW != null) {
                ak.yW();
                if (com.tencent.mm.model.c.wK().Mn(this.euW.field_username)) {
                    m.m(this.euW.field_username, true);
                    com.tencent.mm.modelstat.b.daJ.c(false, this.ePn, false);
                } else {
                    m.l(this.euW.field_username, true);
                    com.tencent.mm.modelstat.b.daJ.c(false, this.ePn, true);
                }
                ak.yW();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.model.c.wK().Mn(this.euW.field_username)).commit();
            }
        } else if (str2.equals("room_chatting_images")) {
            com.tencent.mm.plugin.report.service.g.iuh.a(219, 12, 1, true);
            r0 = new Intent();
            r0.setClassName(this, "com.tencent.mm.ui.chatting.gallery.ImageGalleryGridUI");
            r0.addFlags(67108864);
            r0.putExtra("kintent_intent_source", 1);
            r0.putExtra("kintent_talker", this.ePn);
            r0.putExtra("kintent_image_count", this.ePt);
            if (this.ePt > 0) {
                ak.yW();
                r0.putExtra("kintent_image_index", com.tencent.mm.model.c.wJ().Nb(this.ePn) - 1);
            }
            com.tencent.mm.plugin.report.service.g.iuh.h(11627, new Object[]{Integer.valueOf(1)});
            startActivity(r0);
        } else if (str2.equals("room_nickname")) {
            str = adb();
            if (be.kS(str)) {
                str = k.xH();
            }
            g.a(this.nDR.nEl, getString(2131234623), str, getString(2131234597), 32, new g.b(this) {
                final /* synthetic */ ChatroomInfoUI ePK;

                public final boolean r(CharSequence charSequence) {
                    String charSequence2 = charSequence == null ? "" : charSequence.toString();
                    String sL = com.tencent.mm.h.b.sL();
                    if (be.kS(sL) || !charSequence2.matches(".*[" + sL + "].*")) {
                        if (!(charSequence2 == null || charSequence2.equals(str))) {
                            ChatroomInfoUI.a(this.ePK, charSequence2);
                        }
                        return true;
                    }
                    g.bf(this.ePK.nDR.nEl, this.ePK.getString(2131233303, new Object[]{sL}));
                    return false;
                }
            });
        } else if (str2.equals("room_msg_show_username")) {
            getSharedPreferences(this.ePE, 0).edit().putBoolean("room_msg_show_username", !this.ePm).commit();
            this.ePm = !this.ePm;
            this.ePr = true;
        } else if (str2.equals("room_set_chatting_background")) {
            r0 = new Intent();
            r0.putExtra("isApplyToAll", false);
            r0.putExtra("username", this.euW.field_username);
            com.tencent.mm.ay.c.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", r0, 2);
        } else if (str2.equals("room_search_chatting_content")) {
            r0 = new Intent();
            r0.putExtra("detail_username", this.ePn);
            com.tencent.mm.ay.c.b(this, "search", ".ui.FTSChattingTalkerUI", r0);
        } else if (str2.equals("room_clear_chatting_history")) {
            g.a(this.nDR.nEl, getString(2131232872), "", getString(2131231012), getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ ChatroomInfoUI ePK;

                {
                    this.ePK = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ChatroomInfoUI.ePH = false;
                    ChatroomInfoUI chatroomInfoUI = this.ePK;
                    this.ePK.getString(2131231164);
                    final p a = g.a(chatroomInfoUI, this.ePK.getString(2131231182), true, new a());
                    if (h.ed(this.ePK.euW.field_username)) {
                        com.tencent.mm.plugin.chatroom.a.drq.bq(this.ePK.euW.field_username);
                    }
                    aw.a(this.ePK.euW.field_username, new com.tencent.mm.model.aw.a(this) {
                        final /* synthetic */ AnonymousClass10 ePN;

                        public final boolean zp() {
                            return ChatroomInfoUI.ePH;
                        }

                        public final void zo() {
                            if (a != null) {
                                a.dismiss();
                            }
                        }
                    });
                }
            }, null, 2131689512);
        } else if (str2.equals("room_report_it")) {
            r0 = new Intent();
            r0.putExtra("k_username", this.ePn);
            r0.putExtra("showShare", false);
            r0.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(36)}));
            com.tencent.mm.ay.c.b(this, "webview", ".ui.tools.WebViewUI", r0);
            r0 = com.tencent.mm.modelstat.b.daJ;
            String str4 = this.ePn;
            if (r0.JV() && r0.bc(str4)) {
                IMBehavior iMBehavior2 = new IMBehavior();
                iMBehavior2.opType = 1;
                iMBehavior2.chattingOp = new IMBehaviorChattingOP();
                iMBehavior2.chattingOp.expose = 1;
                r0.daI.oplist_.add(iMBehavior2);
            }
        } else if (str2.equals("room_del_quit")) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", " quit " + this.ePn);
            pd pdVar = new pd();
            pdVar.bqt.bqv = true;
            com.tencent.mm.sdk.c.a.nhr.z(pdVar);
            final boolean z2 = !be.kS(this.ePn) && this.ePn.equals(pdVar.bqu.bqx);
            if (z2) {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.ePn);
            } else if (this.ePp && this.ePs.DM().size() > 2) {
                g.a(this, "", new String[]{getString(2131234633)}, getString(2131231010), new g.c(this) {
                    final /* synthetic */ ChatroomInfoUI ePK;

                    {
                        this.ePK = r1;
                    }

                    public final void gT(int i) {
                        switch (i) {
                            case 0:
                                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
                                ChatroomInfoUI.x(this.ePK);
                                if (com.tencent.mm.pluginsdk.j.a.lxR != null) {
                                    com.tencent.mm.pluginsdk.j.a.lxR.wG(this.ePK.ePn);
                                    return;
                                }
                                return;
                            default:
                                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                                return;
                        }
                    }
                });
            }
            g.a(this.nDR.nEl, getString(2131232274), "", getString(2131231107), getString(2131231010), new OnClickListener(this) {
                final /* synthetic */ ChatroomInfoUI ePK;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.ePK.ePn == null || this.ePK.ePn.length() <= 0) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                        return;
                    }
                    if (z2) {
                        pd pdVar = new pd();
                        pdVar.bqt.bqw = true;
                        com.tencent.mm.sdk.c.a.nhr.z(pdVar);
                    }
                    ak.yW();
                    if (com.tencent.mm.model.c.wH().LZ(this.ePK.ePn)) {
                        ChatroomInfoUI.x(this.ePK);
                        if (com.tencent.mm.pluginsdk.j.a.lxR != null) {
                            com.tencent.mm.pluginsdk.j.a.lxR.wG(this.ePK.ePn);
                            return;
                        }
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + this.ePK.ePn + "] is not exist");
                }
            }, null, 2131689512);
        } else if (str2.equals("add_selector_btn")) {
            adc();
        } else if (str2.equals("del_selector_btn")) {
            add();
        } else if (str2.equals("see_room_member")) {
            intent = new Intent();
            intent.setClass(this.nDR.nEl, SeeRoomMemberUI.class);
            intent.putExtra("Block_list", k.xF());
            List ej = i.ej(this.ePn);
            if (ej != null) {
                this.ePq = ej.size();
            }
            intent.putExtra("Chatroom_member_list", be.b(ej, ","));
            intent.putExtra("RoomInfo_Id", this.ePn);
            intent.putExtra("room_owner_name", this.ePs.field_roomowner);
            intent.putExtra("Is_RoomOwner", this.ePp);
            intent.putExtra("room_member_count", this.ePq);
            intent.putExtra("Add_address_titile", getString(2131234661));
            if (this.bhx) {
                intent.putExtra("Contact_Scene", 14);
            } else if (this.ePa) {
                intent.putExtra("Contact_Scene", 44);
                if (!k.eo(this.euW.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            str = "offset";
            View childAt = this.gMx.getChildAt(0);
            intent.putExtra(str, childAt == null ? 0 : -childAt.getTop());
            intent.putExtra("first_pos", this.gMx.getFirstVisiblePosition());
            intent.putExtra("room_name", this.euW.field_username);
            startActivityForResult(intent, 5);
            this.ePx = 5;
        } else if (str2.equals("manage_room")) {
            r0 = new Intent();
            r0.setClass(this.nDR.nEl, ManageChatroomUI.class);
            r0.putExtra("RoomInfo_Id", this.ePn);
            r0.putExtra("room_owner_name", this.ePs.field_roomowner);
            startActivity(r0);
        }
        return false;
    }

    private String adb() {
        if (this.ePs == null) {
            return "";
        }
        return this.ePs.field_selfDisplayName;
    }

    private void adc() {
        List ej;
        if (this.bhx) {
            com.tencent.mm.plugin.report.service.g.iuh.a(219, 7, 1, true);
            ej = i.ej(this.ePn);
            String b = be.b(ej, ",");
            if (ej != null) {
                this.ePq = ej.size();
            }
            Intent intent = new Intent();
            intent.putExtra("titile", getString(2131230883));
            intent.putExtra("list_type", 1);
            intent.putExtra("list_attr", com.tencent.mm.ui.contact.r.oHJ);
            intent.putExtra("always_select_contact", b);
            intent.putExtra("scene", 3);
            com.tencent.mm.ay.c.a(this, ".ui.contact.SelectContactUI", intent, 1);
            return;
        }
        com.tencent.mm.plugin.report.service.g.iuh.Y(10170, "1");
        ej = new LinkedList();
        ej.add(this.ePn);
        ej.add(k.xF());
        String b2 = be.b(ej, ",");
        Intent intent2 = new Intent();
        intent2.putExtra("titile", getString(2131230881));
        intent2.putExtra("list_type", 0);
        intent2.putExtra("list_attr", com.tencent.mm.ui.contact.r.oHK);
        intent2.putExtra("always_select_contact", b2);
        com.tencent.mm.ay.c.a(this, ".ui.contact.SelectContactUI", intent2);
    }

    private void add() {
        com.tencent.mm.plugin.report.service.g.iuh.a(219, 8, 1, true);
        List ej = i.ej(this.ePn);
        String b = be.b(ej, ",");
        this.ePq = ej.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", this.ePn);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", b);
        intent.putExtra("room_member_count", this.ePq);
        intent.putExtra("Is_RoomOwner", this.ePp);
        intent.putExtra("list_attr", com.tencent.mm.ui.contact.r.oHJ);
        intent.putExtra("room_name", this.euW.field_username);
        intent.putExtra("room_owner_name", this.ePs.field_roomowner);
        intent.setClass(this, SelectDelRoomMemberUI.class);
        startActivityForResult(intent, 7);
    }

    private void m(String str, String str2, int i) {
        if (m.ev(str)) {
            boolean z;
            if (be.ma(k.xF()).equals(str)) {
                z = true;
            } else {
                List<String> ej = i.ej(this.ePn);
                if (ej == null) {
                    z = false;
                } else {
                    z = false;
                    for (String equals : ej) {
                        boolean z2;
                        if (equals.equals(str)) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        z = z2;
                    }
                }
            }
            if (z) {
                g.A(this, getString(2131230816), getString(2131231164));
                return;
            }
            List g = be.g(str.split(","));
            if (g != null) {
                final com.tencent.mm.plugin.chatroom.c.d dVar = new com.tencent.mm.plugin.chatroom.c.d(this.ePn, g, str2);
                getString(2131231164);
                this.dwR = g.a(this, getString(i), true, new OnCancelListener(this) {
                    final /* synthetic */ ChatroomInfoUI ePK;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(dVar);
                    }
                });
                ak.vy().a(dVar, 0);
                return;
            }
            return;
        }
        g.A(this, getString(2131234616), getString(2131231164));
    }

    private void a(int i, com.tencent.mm.plugin.chatroom.c.d dVar) {
        Object obj = null;
        String str = "";
        String str2 = "";
        String string = com.tencent.mm.sdk.platformtools.aa.getContext().getString(2131231758);
        final List list = dVar.eOM;
        final List list2 = dVar.eOO;
        final List list3 = dVar.bix;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            o LD = ak.yW().wO().LD(this.ePn);
            if (i == -116 && adf() && !be.kS(LD.field_roomowner)) {
                str = getString(2131234613);
                str2 = getString(2131234612);
                obj = 1;
            }
            if (i == -23) {
                str = getString(2131234619);
                str2 = getString(2131234618);
            }
            if (i == -109) {
                str = getString(2131234615);
                str2 = getString(2131234614);
            }
            if (i == -122) {
                str = getString(2131234619);
                str2 = getString(2131234617, new Object[]{ade(), Integer.valueOf(LD.bvg())});
            }
            list = dVar.eON;
            if (list3 == null || list3.size() <= 0 || (list3.size() != dVar.bhN && (list == null || list.size() <= 0 || dVar.bhN != list3.size() + list.size()))) {
                list = dVar.eON;
                if (list != null && list.size() > 0) {
                    str2 = str2 + getString(2131232876, new Object[]{be.b(ah(list), string)});
                }
                list = dVar.biw;
                if (list != null && list.size() > 0) {
                    str = getString(2131230814);
                    str2 = str2 + getString(2131232886, new Object[]{be.b(ah(list), string)});
                }
                list = dVar.biu;
                if (list != null && list.size() > 0) {
                    str = getString(2131230814);
                    str2 = str2 + getString(2131232877, new Object[]{be.b(ah(list), string)});
                }
                Collection collection = dVar.eOO;
                list2 = new ArrayList();
                if (!(list3 == null || list3.isEmpty())) {
                    list2.addAll(list3);
                }
                if (collection != null && collection.size() > 0) {
                    list2.addAll(collection);
                }
                if (i != -2028) {
                    d(dVar.biB, list3);
                }
                str2 = str2 + getString(2131232863, new Object[]{be.b(ah(list2), string)});
                if (list3 != null && list3.isEmpty()) {
                    str2 = null;
                }
                if (str2 != null && str2.length() > 0) {
                    if (obj != null) {
                        g.a(this, str2, str, new OnClickListener(this) {
                            final /* synthetic */ ChatroomInfoUI ePK;

                            {
                                this.ePK = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.ePK.bz(this.ePK);
                            }
                        }, null);
                        return;
                    } else {
                        g.A(this, str2, str);
                        return;
                    }
                }
                return;
            }
            List linkedList = new LinkedList();
            for (int i2 = 0; i2 < list3.size(); i2++) {
                linkedList.add(list3.get(i2));
            }
            str2 = "";
            String string2 = com.tencent.mm.sdk.platformtools.aa.getContext().getString(2131231758);
            if (!(list == null || list.isEmpty())) {
                str2 = getString(2131232862, new Object[]{be.b(ah(list), string2)}) + "\n";
            }
            if (!linkedList.isEmpty()) {
                str2 = str2 + getString(2131232863, new Object[]{be.b(ah(linkedList), string2)});
            }
            g.a(this, str2, "", getString(2131232855), new OnClickListener(this) {
                final /* synthetic */ ChatroomInfoUI ePK;

                {
                    this.ePK = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.ePK.adn();
                }
            });
            d(dVar.biB, linkedList);
            return;
        }
        string = getString(2131230815);
        String string3 = getString(2131233304);
        String string4 = getString(2131231010);
        final com.tencent.mm.plugin.chatroom.c.d dVar2 = dVar;
        AnonymousClass18 anonymousClass18 = new OnClickListener(this) {
            final /* synthetic */ ChatroomInfoUI ePK;

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.ePK.d(dVar2.biB, list3);
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.addAll(list2);
                final com.tencent.mm.plugin.chatroom.c.k kVar = new com.tencent.mm.plugin.chatroom.c.k(this.ePK.ePn, arrayList);
                ak.vy().a(kVar, 0);
                ChatroomInfoUI chatroomInfoUI = this.ePK;
                ChatroomInfoUI chatroomInfoUI2 = this.ePK;
                this.ePK.getString(2131231164);
                chatroomInfoUI.dwR = g.a(chatroomInfoUI2, this.ePK.getString(2131234605), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass18 ePV;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ak.vy().c(kVar);
                    }
                });
            }
        };
        g.b(this, string, null, string3, string4, anonymousClass18, new OnClickListener(this) {
            final /* synthetic */ ChatroomInfoUI ePK;

            {
                this.ePK = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private String ade() {
        String str;
        String str2 = null;
        ak.yW();
        u LX = com.tencent.mm.model.c.wH().LX(this.ePs.field_roomowner);
        if (LX == null || ((int) LX.chr) <= 0) {
            str = null;
        } else {
            str = LX.field_conRemark;
        }
        if (be.kS(str)) {
            str = this.ePs.field_roomowner;
            if (this.ePs != null) {
                str2 = this.ePs.er(str);
            }
        } else {
            str2 = str;
        }
        if (be.kS(str2) && LX != null && ((int) LX.chr) > 0) {
            str2 = LX.tT();
        }
        if (be.kS(str2)) {
            return this.ePs.field_roomowner;
        }
        return str2;
    }

    private static boolean adf() {
        return be.getInt(j.sU().getValue("ChatroomGlobalSwitch"), 1) == 1;
    }

    private void bz(Context context) {
        if (context != null && adf()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", getString(2131231754, new Object[]{com.tencent.mm.sdk.platformtools.u.bsY()}));
            intent.putExtra("geta8key_username", k.xF());
            intent.putExtra("showShare", false);
            com.tencent.mm.ay.c.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    private void d(String str, List<String> list) {
        if (list != null && list.size() > 0) {
            List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            h.a(str, linkedList, getString(2131231757), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
    }

    private void adg() {
        if (this.bhx) {
            this.ePq = i.el(this.ePn);
            if (this.ePq == 0) {
                Fd(getString(2131234689));
                return;
            }
            Fd(getString(2131232864, new Object[]{getString(2131234689), Integer.valueOf(this.ePq)}));
        }
    }

    private void adh() {
        if (this.ePg == null) {
            return;
        }
        if (this.bhx) {
            List ej;
            this.ePI = ak.yW().wO().LE(this.ePn);
            ej = i.ej(this.ePn);
            if (ej != null) {
                this.ePq = ej.size();
            } else {
                this.ePq = 0;
            }
            if (this.ePq <= 1) {
                this.dxf.aO("del_selector_btn", true);
                this.ePg.hZ(true).ia(false).bpq();
            } else {
                this.ePg.hZ(true).ia(this.ePp).bpq();
            }
            this.ePg.j(this.ePn, ej);
            return;
        }
        ej = new LinkedList();
        ej.add(this.ePn);
        this.ePg.j(this.ePn, ej);
    }

    private void adi() {
        if (this.euW != null) {
            CharSequence adb = adb();
            if (be.kS(adb)) {
                adb = k.xH();
            }
            if (be.kS(adb)) {
                this.ePk.setSummary("");
            } else {
                SignaturePreference signaturePreference = this.ePk;
                if (adb.length() <= 0) {
                    adb = getString(2131235144);
                }
                signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.e.a(this, adb));
            }
            if (this.dxf != null) {
                this.dxf.notifyDataSetChanged();
            }
        }
    }

    private void adj() {
        if (this.cnm == null) {
            this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.bhx) {
            this.eJx = this.euW.bCh == 0;
        } else if (!this.ePa) {
            this.eJx = this.euW.tM();
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

    private void adk() {
        if (this.euW != null && this.ePb != null) {
            CharSequence en = i.en(this.ePn);
            if (en == null || en.length() <= 0) {
                this.ePb.fJm = false;
            } else {
                this.ePb.fJm = true;
                this.ePb.lQu = com.tencent.mm.pluginsdk.ui.d.e.a(this, en);
            }
            ak.yW();
            this.euW = com.tencent.mm.model.c.wH().LX(this.ePn);
            if (adm()) {
                en = this.euW.tU();
                RoomCardPreference roomCardPreference = this.ePb;
                if (en.length() <= 0) {
                    en = getString(2131235144);
                }
                roomCardPreference.lQt = com.tencent.mm.pluginsdk.ui.d.e.a(this, en);
            } else {
                this.ePb.lQt = getString(2131234603);
            }
            this.dxf.notifyDataSetChanged();
        }
    }

    private void adl() {
        if (this.euW != null && this.ePc != null) {
            ak.yW();
            this.euW = com.tencent.mm.model.c.wH().LX(this.ePn);
            if (adm()) {
                CharSequence tU = this.euW.tU();
                SignaturePreference signaturePreference = this.ePc;
                if (tU.length() <= 0) {
                    tU = getString(2131235144);
                }
                signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.e.a(this, tU));
                if (this.dxf != null) {
                    this.dxf.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.ePc.setSummary(getString(2131234603));
        }
    }

    private boolean adm() {
        String str = this.euW.field_nickname;
        if (be.kS(str) || str.length() > 50) {
            return false;
        }
        return true;
    }

    public static ArrayList<u> ag(List<afy> list) {
        ArrayList<u> arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (afy com_tencent_mm_protocal_c_afy : list) {
            u uVar = new u();
            uVar.setUsername(com_tencent_mm_protocal_c_afy.gln);
            uVar.bS(com_tencent_mm_protocal_c_afy.efy);
            arrayList.add(uVar);
        }
        return arrayList;
    }

    private static List<String> ah(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!ak.uz()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            ak.yW();
            u LX = com.tencent.mm.model.c.wH().LX(obj2);
            if (!(LX == null || ((int) LX.chr) == 0)) {
                obj2 = LX.tU();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "pre is " + this.ePq);
        this.ePq = i.el(this.ePn);
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "now is " + this.ePq);
        if (this.dwR != null) {
            this.dwR.dismiss();
        }
        com.tencent.mm.f.a dm = com.tencent.mm.f.a.dm(str);
        if (dm != null) {
            dm.a(this, null, null);
        } else if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0) {
                switch (kVar.getType()) {
                    case 120:
                        a(i2, (com.tencent.mm.plugin.chatroom.c.d) kVar);
                        adn();
                        break;
                    case 179:
                        adn();
                        break;
                    case 610:
                        if (this.ePx != 5) {
                            g.A(this, getString(2131233324), null);
                            break;
                        }
                        break;
                }
                if (this.ePs != null) {
                    this.ePq = this.ePs.DM().size();
                }
                if ((!this.ePp && this.ePq >= com.tencent.mm.pluginsdk.ui.applet.e.lJW) || (this.ePp && this.ePq >= com.tencent.mm.pluginsdk.ui.applet.e.lJW - 1)) {
                    this.dxf.aO("see_room_member", false);
                    this.ePd.setTitle(getString(2131234860));
                }
            }
            adg();
        } else {
            if (kVar.getType() == 120 && this.ePx != 5) {
                a(i2, (com.tencent.mm.plugin.chatroom.c.d) kVar);
                adn();
            }
            if (kVar.getType() == 179 && this.ePx != 5 && i2 == -66) {
                g.A(this, getString(2131232275), getString(2131231164));
                adn();
            }
            if (kVar.getType() == 610 && this.ePx != 5) {
                g.A(this, getString(2131233323), getString(2131231164));
            }
        }
    }

    private void adn() {
        if (this.ePg != null) {
            if (this.bhx) {
                adh();
            } else if (!this.ePa) {
                List linkedList = new LinkedList();
                linkedList.add(this.ePn);
                this.ePg.j(this.ePn, linkedList);
            }
            this.ePg.notifyChanged();
        }
        if (!this.ePp || i.el(this.ePn) <= 2) {
            this.dxf.aO("manage_room", true);
        } else {
            this.dxf.aO("manage_room", false);
        }
        if ((this.ePp || this.ePq < com.tencent.mm.pluginsdk.ui.applet.e.lJW) && (!this.ePp || this.ePq < com.tencent.mm.pluginsdk.ui.applet.e.lJW - 1)) {
            this.dxf.aO("see_room_member", true);
        } else {
            this.dxf.aO("see_room_member", false);
            this.ePd.setTitle(getString(2131234860, new Object[]{Integer.valueOf(this.ePq)}));
        }
        this.dxf.notifyDataSetChanged();
    }

    public final void a(int i, com.tencent.mm.sdk.h.j jVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), jVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
        if (!be.kS(str)) {
            if (str.endsWith("@chatroom")) {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "event:" + str);
                if (this.bhx && str.equals(this.ePn)) {
                    ak.vA().x(new Runnable(this) {
                        final /* synthetic */ ChatroomInfoUI ePK;

                        {
                            this.ePK = r1;
                        }

                        public final void run() {
                            this.ePK.ePs = ak.yW().wO().LC(this.ePK.ePn);
                            if (this.ePK.ePs == null) {
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomInfoUI", "member is null");
                            } else if (be.kS(this.ePK.ePs.field_roomowner)) {
                                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
                            } else {
                                this.ePK.handler.sendEmptyMessage(0);
                                this.ePK.ePp = this.ePK.ePs.field_roomowner.equals(k.xF());
                                this.ePK.ePg.HA(this.ePK.ePs.field_roomowner);
                            }
                        }

                        public final String toString() {
                            return super.toString() + "|onNotifyChange";
                        }
                    });
                }
                adn();
                return;
            }
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ChatroomInfoUI", "event:" + str + " cancel");
        }
    }

    public final void y(String str, String str2, String str3) {
        if (str.equals(this.ePn) && this.ePg != null) {
            this.ePg.notifyChanged();
        }
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
