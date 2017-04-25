package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.bt;
import com.tencent.mm.e.a.fl;
import com.tencent.mm.e.a.hw;
import com.tencent.mm.e.a.id;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.e.a.jq;
import com.tencent.mm.e.a.kl;
import com.tencent.mm.e.a.km;
import com.tencent.mm.e.a.kz;
import com.tencent.mm.e.a.la;
import com.tencent.mm.e.a.ln;
import com.tencent.mm.e.a.ox;
import com.tencent.mm.e.a.w;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j.v;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.h.j.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.AbstractTabChildActivity.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.account.RegByFacebookSetPwdUI;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.d.i;
import com.tencent.mm.ui.d.k;
import com.tencent.mm.ui.d.n;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.x;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.mmdb.database.SQLiteDebug;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import junit.framework.Assert;

public class d extends a implements af, v, b, com.tencent.mm.u.d.a, e, f {
    public static int oMA = -1;
    private static boolean oMC = false;
    private int bCd;
    private String bdo = SQLiteDatabase.KeyEmpty;
    private c dHB = new c<id>(this) {
        final /* synthetic */ d oMF;

        {
            this.oMF = r2;
            this.nhz = id.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            switch (((id) bVar).bif.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 7:
                    this.oMF.bIx();
                    if (this.oMF.oLX != null) {
                        this.oMF.oLX.notifyDataSetChanged();
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    private ProgressDialog dwR = null;
    com.tencent.mm.pluginsdk.ui.d ePu = new com.tencent.mm.pluginsdk.ui.d(new OnScrollListener(this) {
        final /* synthetic */ d oMF;

        {
            this.oMF = r1;
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i >= 2 && !this.oMF.oEh) {
                this.oMF.oEh = true;
            }
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2) {
                com.tencent.mm.bh.c.byp().bX(d.class.getName() + ".Listview", 4);
            }
            if (i != 0) {
                this.oMF.bIr();
            } else if (this.oMF.oLV != null) {
                d.a(this.oMF, -1);
            }
        }
    });
    private boolean eut = false;
    private l eyZ;
    private c faM = null;
    private boolean gYJ = false;
    private com.tencent.mm.ui.base.n.d hkn = new com.tencent.mm.ui.base.n.d(this) {
        final /* synthetic */ d oMF;

        {
            this.oMF = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            int i2 = 4;
            switch (menuItem.getItemId()) {
                case 4:
                    d.a(this.oMF, this.oMF.bdo);
                    i2 = 1;
                    break;
                case 5:
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "placed to the top");
                    m.l(this.oMF.bdo, true);
                    ak.yW();
                    ab LX = com.tencent.mm.model.c.wH().LX(this.oMF.bdo);
                    if (LX != null && LX.bvm()) {
                        g.iuh.h(13307, LX.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
                    }
                    com.tencent.mm.ui.base.g.bf(this.oMF.nDR.nEl, this.oMF.getString(2131233707));
                    com.tencent.mm.modelstat.b.daJ.c(true, this.oMF.bdo, true);
                    break;
                case 6:
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "unplaced to the top");
                    m.m(this.oMF.bdo, true);
                    ak.yW();
                    ab LX2 = com.tencent.mm.model.c.wH().LX(this.oMF.bdo);
                    if (LX2 != null && LX2.bvm()) {
                        g.iuh.h(13307, LX2.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
                    }
                    com.tencent.mm.ui.base.g.bf(this.oMF.nDR.nEl, this.oMF.getString(2131233708));
                    com.tencent.mm.modelstat.b.daJ.c(true, this.oMF.bdo, false);
                    i2 = 5;
                    break;
                case 7:
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "jacks mark read: %s", this.oMF.bdo);
                    ak.yW();
                    com.tencent.mm.model.c.wK().Mj(this.oMF.bdo);
                    MMAppMgr.cancelNotification(this.oMF.bdo);
                    ae.z(this.oMF.bdo, 1);
                    com.tencent.mm.modelstat.b.daJ.C(this.oMF.bdo, false);
                    i2 = 3;
                    break;
                case 8:
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "jacks set unread: %s", this.oMF.bdo);
                    ak.yW();
                    j wK = com.tencent.mm.model.c.wK();
                    String v = this.oMF.bdo;
                    if (v == null || v.length() <= 0) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.ConversationStorage", "update conversation failed");
                    } else {
                        com.tencent.mm.e.b.af Mh = wK.Mh(v);
                        if (Mh != null && ((Mh.field_unReadCount <= 0 || !v.equals(Mh.field_username)) && wK.cie.dF("rconversation", "update " + ac.Me(v) + " set unReadCount = 1, atCount" + " = 0, attrflag = " + (Mh.field_attrflag | 1048576) + " where username = \"" + be.lZ(v) + "\""))) {
                            wK.b(3, wK, v);
                        }
                    }
                    com.tencent.mm.modelstat.b.daJ.C(this.oMF.bdo, true);
                    i2 = 2;
                    break;
                case 9:
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "jacks clear history: %s", this.oMF.bdo);
                    this.oMF.bdo.endsWith("@chatroom");
                    d.c(this.oMF, this.oMF.bdo);
                    i2 = -1;
                    break;
                case 10:
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "delete biz service: %s", this.oMF.bdo);
                    ak.yW();
                    com.tencent.mm.ui.tools.b.a(com.tencent.mm.modelbiz.e.hw(this.oMF.bdo), this.oMF.nDR.nEl, com.tencent.mm.model.c.wH().LX(this.oMF.bdo), 1);
                    break;
            }
            i2 = -1;
            if (i2 > 0) {
                g.iuh.h(11090, Integer.valueOf(i2));
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "jacks kv long click: %d", Integer.valueOf(i2));
            }
        }
    };
    private com.tencent.mm.network.m ixZ = new com.tencent.mm.network.m.a(this) {
        private final ah oME = new ah(new ah.a(this) {
            final /* synthetic */ AnonymousClass1 oMG;

            {
                this.oMG = r1;
            }

            public final boolean oU() {
                this.oMG.oMF.bIw();
                return false;
            }
        }, false);
        final /* synthetic */ d oMF;

        {
            this.oMF = r4;
        }

        public final void cI(int i) {
            if (this.oME != null) {
                this.oME.ea(10);
            }
        }
    };
    c nAF = new c<bt>(this) {
        final /* synthetic */ d oMF;

        {
            this.oMF = r2;
            this.nhz = bt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "dynamic config file change");
            this.oMF.bCd = t.getInt(com.tencent.mm.h.j.sU().getValue("InviteFriendsControlFlags"), 0);
            if ((this.oMF.bCd & 1) > 0 && this.oMF.oLV != null) {
                this.oMF.oLV.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass18 oML;

                    {
                        this.oML = r1;
                    }

                    public final void run() {
                        this.oML.oMF.oEq.setVisibility(0);
                        this.oML.oMF.oEq.setPadding(0, 0, 0, 0);
                    }
                });
            }
            return true;
        }
    };
    private IdleHandler nBU;
    private TextView nIp;
    private TextView oDZ;
    private boolean oEh = false;
    private View oEq;
    private Runnable oEz = new Runnable(this) {
        final /* synthetic */ d oMF;

        {
            this.oMF = r1;
        }

        public final void run() {
            d.F(this.oMF);
        }
    };
    private com.tencent.mm.storage.ab oFp = null;
    private h oLT = null;
    private boolean oLU;
    private ListView oLV;
    private TextView oLW;
    public b oLX;
    private com.tencent.mm.ui.d.m oLY = null;
    private boolean oLZ = false;
    c oMB = new c<hw>(this) {
        private final long INTERVAL;
        final /* synthetic */ d oMF;
        long oMN;
        int oMO;

        {
            this.oMF = r3;
            this.INTERVAL = 3000;
            this.oMN = 0;
            this.oMO = -1;
            this.nhz = hw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "trigger double tab");
            this.oMF.oLV.postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass24 oMP;

                {
                    this.oMP = r1;
                }

                public final void run() {
                    int firstVisiblePosition;
                    int i;
                    int i2;
                    int abs;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.oMP.oMN >= 3000 || this.oMP.oMO < 0) {
                        firstVisiblePosition = (this.oMP.oMF.oLV.getFirstVisiblePosition() - this.oMP.oMF.oLV.getHeaderViewsCount()) + 1;
                        if (firstVisiblePosition < 0) {
                            i = 0;
                        } else {
                            i = firstVisiblePosition;
                        }
                    } else {
                        i = this.oMP.oMO;
                    }
                    b e = this.oMP.oMF.oLX;
                    if (d.oMA > 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    int count = e.getCount();
                    if (count > 0) {
                        for (abs = Math.abs((i + 1) % count); abs != i; abs = (abs + 1) % count) {
                            com.tencent.mm.storage.ab abVar = (com.tencent.mm.storage.ab) e.en(abs);
                            if (abVar != null && abVar.field_unReadCount > 0) {
                                if (i2 == 0) {
                                    i2 = abs;
                                    break;
                                } else if (b.a(abVar, e.j(abVar)) == 2) {
                                    i2 = abs;
                                    break;
                                }
                            }
                        }
                    }
                    i2 = -1;
                    if (i2 < 0) {
                        BackwardSupportUtil.c.a(this.oMP.oMF.oLV);
                    } else {
                        ListView c = this.oMP.oMF.oLV;
                        abs = this.oMP.oMF.oLV.getHeaderViewsCount() + i2;
                        if (c != null) {
                            if (VERSION.SDK_INT >= 11) {
                                ay ayVar = new ay();
                                int firstVisiblePosition2 = c.getFirstVisiblePosition();
                                if (firstVisiblePosition2 < abs && firstVisiblePosition2 + 10 < abs) {
                                    c.setSelectionFromTop(abs - 10, 0);
                                } else if (firstVisiblePosition2 > abs && firstVisiblePosition2 - 10 > abs) {
                                    c.setSelectionFromTop(abs + 10, 0);
                                }
                                if (VERSION.SDK_INT >= 11) {
                                    c.smoothScrollToPositionFromTop(abs, 0);
                                }
                            } else {
                                ax axVar = new ax();
                                c.setSelectionFromTop(abs, 0);
                            }
                        }
                    }
                    this.oMP.oMN = currentTimeMillis;
                    AnonymousClass24 anonymousClass24 = this.oMP;
                    if (i2 < 0) {
                        firstVisiblePosition = 0;
                    } else {
                        firstVisiblePosition = i2;
                    }
                    anonymousClass24.oMO = firstVisiblePosition;
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "headerCount %d, scroll from %d to %d", Integer.valueOf(this.oMP.oMF.oLV.getHeaderViewsCount()), Integer.valueOf(i), Integer.valueOf(i2));
                }
            }, 100);
            return false;
        }
    };
    private com.tencent.mm.sdk.platformtools.ac oMD = new com.tencent.mm.sdk.platformtools.ac(this) {
        final /* synthetic */ d oMF;

        {
            this.oMF = r1;
        }

        public final void handleMessage(Message message) {
            if (this.oMF.oLX != null) {
                this.oMF.oLX.clearCache();
                this.oMF.oLX.notifyDataSetChanged();
            }
        }
    };
    private n oMa = null;
    private com.tencent.mm.pluginsdk.ui.b.b oMb = null;
    private com.tencent.mm.pluginsdk.ui.b.b oMc = null;
    private com.tencent.mm.ui.d.l oMd = null;
    private i oMe = null;
    public k oMf = null;
    private com.tencent.mm.pluginsdk.ui.b.a oMg = null;
    private LinearLayout oMh = null;
    private boolean oMi = false;
    private boolean oMj = false;
    private boolean oMk = false;
    private int oMl = 0;
    private com.tencent.mm.ui.d.a oMm = null;
    private com.tencent.mm.modelmulti.f oMn = null;
    private com.tencent.mm.compatible.util.g.a oMo = new com.tencent.mm.compatible.util.g.a();
    private boolean oMp;
    private c oMq = new c<jq>(this) {
        final /* synthetic */ d oMF;

        {
            this.oMF = r2;
            this.nhz = jq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (this.oMF.oMb != null) {
                this.oMF.oMb.view.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass12 oMK;

                    {
                        this.oMK = r1;
                    }

                    public final void run() {
                        if (this.oMK.oMF.oMb.Ui() && this.oMK.oMF.oLV.getVisibility() != 0) {
                            this.oMK.oMF.oLV.setVisibility(0);
                            this.oMK.oMF.oLW.setVisibility(8);
                        }
                    }
                });
            }
            return false;
        }
    };
    private c oMr = new c<la>(this) {
        final /* synthetic */ d oMF;

        {
            this.oMF = r2;
            this.nhz = la.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (this.oMF.oLX != null) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass23 oMM;

                    {
                        this.oMM = r1;
                    }

                    public final void run() {
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "refresh main ui unread count.");
                        this.oMM.oMF.oLX.notifyDataSetChanged();
                        d.f(this.oMM.oMF);
                    }
                });
            }
            return true;
        }
    };
    private c oMs = new c<kz>(this) {
        final /* synthetic */ d oMF;

        {
            this.oMF = r2;
            this.nhz = kz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            if (this.oMF.oLX != null) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass34 oMQ;

                    {
                        this.oMQ = r1;
                    }

                    public final void run() {
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "refresh main ui multitalk icon.");
                        this.oMQ.oMF.oLX.notifyDataSetChanged();
                    }
                });
            }
            return true;
        }
    };
    private com.tencent.mm.sdk.platformtools.ac oMt = new com.tencent.mm.sdk.platformtools.ac(this) {
        final /* synthetic */ d oMF;

        {
            this.oMF = r1;
        }

        public final void handleMessage(Message message) {
            Object obj = message.obj;
        }
    };
    private int oMu = -1;
    private boolean oMv = false;
    private ad oMw;
    private Runnable oMx;
    private HashMap<String, Integer> oMy = new HashMap();
    private int oMz = -1;
    private WakeLock wakeLock = null;

    static /* synthetic */ void F(d dVar) {
        LauncherUI launcherUI = (LauncherUI) dVar.nDR.nEl;
        if (launcherUI == null || launcherUI.nBM == 0) {
            BackwardSupportUtil.c.a(dVar.oLV);
            new com.tencent.mm.sdk.platformtools.ac().postDelayed(new Runnable(dVar) {
                final /* synthetic */ d oMF;

                {
                    this.oMF = r1;
                }

                public final void run() {
                    this.oMF.oLV.setSelection(0);
                }
            }, 300);
        }
    }

    static /* synthetic */ void a(d dVar, int i) {
        if (i < 0) {
            i = SQLiteDebug.MAIN_THREAD_SLOW_QUERY_THRESHOLD;
        }
        dVar.bIr();
        if (dVar.oMw == null) {
            dVar.oMw = new ad("pre load mainui avatar");
        }
        dVar.oMv = false;
        ad adVar = dVar.oMw;
        Runnable anonymousClass3 = new Runnable(dVar) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void run() {
                if (!this.oMF.oMv) {
                    int lastVisiblePosition = this.oMF.oLV.getLastVisiblePosition();
                    int firstVisiblePosition = this.oMF.oLV.getFirstVisiblePosition();
                    int i = lastVisiblePosition - firstVisiblePosition;
                    if (firstVisiblePosition != this.oMF.oMu) {
                        this.oMF.oMu = firstVisiblePosition;
                        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "Jacks PreLod to Show, fistVisibleItem: %d, visibleItemCout: %d", Integer.valueOf(firstVisiblePosition), Integer.valueOf(i));
                        int i2 = lastVisiblePosition + 1;
                        while (i2 < this.oMF.oLX.getCount() && i2 < (i * 1) + lastVisiblePosition) {
                            this.oMF.oLX.xV(i2);
                            i2++;
                        }
                        i2 = firstVisiblePosition - 1;
                        while (i2 >= 0 && i2 > firstVisiblePosition - (i * 1)) {
                            this.oMF.oLX.xV(i2);
                            i2--;
                        }
                    }
                }
            }
        };
        dVar.oMx = anonymousClass3;
        adVar.f(anonymousClass3, (long) i);
    }

    static /* synthetic */ void a(d dVar, final String str) {
        bx MH;
        Context context;
        if (m.dE(str)) {
            ak.yW();
            MH = com.tencent.mm.model.c.wJ().MH(str);
            ak.yW();
            com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.d(str, MH.field_msgSvrId));
            dVar.eut = false;
            context = dVar.nDR.nEl;
            dVar.getString(2131231164);
            dVar.dwR = com.tencent.mm.ui.base.g.a(context, dVar.getString(2131231182), true, new OnCancelListener(dVar) {
                final /* synthetic */ d oMF;

                {
                    this.oMF = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.oMF.eut = true;
                }
            });
            if (com.tencent.mm.model.h.ed(str)) {
                o.Hp().a(new com.tencent.mm.modelmulti.b.a(str, 0, 0, 0, 0));
            }
            aw.a(str, new aw.a(dVar) {
                final /* synthetic */ d oMF;

                public final boolean zp() {
                    return this.oMF.eut || this.oMF.dwR == null || !this.oMF.dwR.isShowing();
                }

                public final void zo() {
                    ak.yW();
                    ab LX = com.tencent.mm.model.c.wH().LX(str);
                    LX.tu();
                    if (com.tencent.mm.i.a.ei(LX.field_type)) {
                        m.m(LX.field_username, false);
                    } else {
                        ak.yW();
                        com.tencent.mm.model.c.wH().a(str, LX);
                    }
                    ak.yW();
                    com.tencent.mm.model.c.wK().Mf(str);
                    if (this.oMF.dwR != null) {
                        this.oMF.dwR.dismiss();
                        this.oMF.dwR = null;
                    }
                }
            });
        } else if (m.eT(str)) {
            ak.yW();
            com.tencent.mm.model.c.wK().Mg(str);
            com.tencent.mm.sdk.c.b kmVar = new km();
            kmVar.blJ.opType = 4;
            kmVar.blJ.blO = 20;
            com.tencent.mm.sdk.c.a.nhr.z(kmVar);
        } else if (m.eJ(str)) {
            ak.yW();
            com.tencent.mm.model.c.wK().Mg(str);
        } else if (m.eM(str)) {
            ak.yW();
            com.tencent.mm.model.c.wK().Mf(str);
        } else if (com.tencent.mm.modelbiz.e.hC(str)) {
            dVar.eut = false;
            context = dVar.nDR.nEl;
            dVar.getString(2131231164);
            dVar.dwR = com.tencent.mm.ui.base.g.a(context, dVar.getString(2131231182), true, new OnCancelListener(dVar) {
                final /* synthetic */ d oMF;

                {
                    this.oMF = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.oMF.eut = true;
                }
            });
            aw.a(str, new aw.a(dVar) {
                final /* synthetic */ d oMF;

                public final boolean zp() {
                    return this.oMF.eut || this.oMF.dwR == null || !this.oMF.dwR.isShowing();
                }

                public final void zo() {
                    com.tencent.mm.modelbiz.a.e.v(str, false);
                    if (this.oMF.dwR != null) {
                        this.oMF.dwR.dismiss();
                        this.oMF.dwR = null;
                    }
                }
            });
        } else {
            ak.yW();
            MH = com.tencent.mm.model.c.wJ().MH(str);
            ak.yW();
            com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.d(str, MH.field_msgSvrId));
            dVar.eut = false;
            context = dVar.nDR.nEl;
            dVar.getString(2131231164);
            dVar.dwR = com.tencent.mm.ui.base.g.a(context, dVar.getString(2131231182), true, new OnCancelListener(dVar) {
                final /* synthetic */ d oMF;

                {
                    this.oMF = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.oMF.eut = true;
                }
            });
            aw.a(str, new aw.a(dVar) {
                final /* synthetic */ d oMF;

                {
                    this.oMF = r1;
                }

                public final boolean zp() {
                    return this.oMF.eut || this.oMF.dwR == null || !this.oMF.dwR.isShowing();
                }

                public final void zo() {
                    if (this.oMF.dwR != null) {
                        this.oMF.dwR.dismiss();
                        this.oMF.dwR = null;
                    }
                }
            });
            ak.yW();
            ab LX = com.tencent.mm.model.c.wH().LX(str);
            LX.tu();
            LX.tv();
            if (LX.bvm() && com.tencent.mm.modelbiz.e.hx(str)) {
                g.iuh.h(13773, Integer.valueOf(0), Integer.valueOf(dVar.oFp.field_unReadCount), Integer.valueOf(1), dVar.oFp.field_username);
            }
            com.tencent.mm.ba.a com_tencent_mm_protocal_c_ais = new ais();
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "oplog modContact user:%s remark:%s type:%d ", LX.field_username, LX.field_conRemark, Integer.valueOf(LX.field_type));
            com_tencent_mm_protocal_c_ais.moM = new arf().JF(t.ma(LX.field_username));
            com_tencent_mm_protocal_c_ais.mEj = new arf().JF(t.ma(LX.field_nickname));
            com_tencent_mm_protocal_c_ais.moC = new arf().JF(t.ma(LX.pE()));
            com_tencent_mm_protocal_c_ais.moD = new arf().JF(t.ma(LX.pF()));
            com_tencent_mm_protocal_c_ais.cHc = LX.bBZ;
            com_tencent_mm_protocal_c_ais.mnV = 36735;
            com_tencent_mm_protocal_c_ais.mnW = LX.field_type;
            com_tencent_mm_protocal_c_ais.mIO = new arf().JF(t.ma(LX.field_conRemark));
            com_tencent_mm_protocal_c_ais.mIP = new arf().JF(t.ma(LX.field_conRemarkPYShort));
            com_tencent_mm_protocal_c_ais.mIQ = new arf().JF(t.ma(LX.field_conRemarkPYFull));
            com_tencent_mm_protocal_c_ais.mob = LX.bCe;
            com_tencent_mm_protocal_c_ais.mIX = new arf().JF(t.ma(LX.field_domainList));
            com_tencent_mm_protocal_c_ais.mof = LX.bCh;
            com_tencent_mm_protocal_c_ais.cHg = LX.bCi;
            com_tencent_mm_protocal_c_ais.cHf = t.ma(LX.bCj);
            com_tencent_mm_protocal_c_ais.cHe = t.ma(LX.getCityCode());
            com_tencent_mm_protocal_c_ais.cHd = t.ma(LX.bvq());
            com_tencent_mm_protocal_c_ais.mFw = t.ma(LX.bCo);
            com_tencent_mm_protocal_c_ais.mFy = LX.field_weiboFlag;
            com_tencent_mm_protocal_c_ais.mIT = 0;
            com_tencent_mm_protocal_c_ais.mbY = new are();
            com_tencent_mm_protocal_c_ais.cHl = t.ma(LX.getCountryCode());
            ak.yW();
            com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.j.a(2, com_tencent_mm_protocal_c_ais));
            ak.yW();
            com.tencent.mm.model.c.wH().a(str, LX);
            ak.yW();
            com.tencent.mm.e.b.af Mh = com.tencent.mm.model.c.wK().Mh(str);
            ak.yW();
            com.tencent.mm.model.c.wK().Mf(str);
            if (Mh != null && (Mh.el(4194304) || (LX.bvm() && !com.tencent.mm.i.a.ei(LX.field_type) && Mh.field_conversationTime < u.DK()))) {
                ak.vy().a(new com.tencent.mm.modelsimple.i(str), 0);
            }
        }
        if (m.eK(str)) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "del all qmessage");
            aw.zm();
            ak.yW();
            com.tencent.mm.model.c.wK().Mg("@qqim");
        } else if (m.eI(str)) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "del all tmessage");
            aw.zn();
            ak.yW();
            com.tencent.mm.model.c.wK().Mg("@t.qq.com");
        }
    }

    static /* synthetic */ void bIA() {
        if (ak.uz() && com.tencent.mm.modelfriend.m.EY() == com.tencent.mm.modelfriend.m.a.SUCC && !com.tencent.mm.modelfriend.m.EX()) {
            ak.vy().a(new com.tencent.mm.modelfriend.ac(com.tencent.mm.modelfriend.m.Ff(), com.tencent.mm.modelfriend.m.Fe()), 0);
        }
    }

    static /* synthetic */ void c(d dVar, int i) {
        int i2 = 1;
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "summerinit setShowView count[%d], stack[%s]", Integer.valueOf(i), t.Nm());
        if (i <= 0 && i <= 0) {
            int i3 = (dVar.oMa == null || !dVar.oMa.agO()) ? 0 : 1;
            if (dVar.oMb == null || !dVar.oMb.refresh()) {
                i2 = 0;
            }
            if (i3 == 0 && r1 == 0) {
                dVar.oLW.setVisibility(0);
                dVar.oLV.setVisibility(8);
                return;
            }
        }
        dVar.oLV.setVisibility(0);
        dVar.oLW.setVisibility(8);
    }

    static /* synthetic */ void c(d dVar, String str) {
        dVar.eut = false;
        Context context = dVar.nDR.nEl;
        dVar.getString(2131231164);
        final ProgressDialog a = com.tencent.mm.ui.base.g.a(context, dVar.getString(2131231182), true, new OnCancelListener(dVar) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.oMF.eut = true;
            }
        });
        aw.a(str, new aw.a(dVar) {
            final /* synthetic */ d oMF;

            public final boolean zp() {
                return this.oMF.eut;
            }

            public final void zo() {
                if (a != null) {
                    a.dismiss();
                }
            }
        });
    }

    static /* synthetic */ void f(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        LauncherUI launcherUI = (LauncherUI) dVar.bzo();
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck postSetLauncherUIUnReadCount  resetStatus %d", Integer.valueOf(dVar.oMz));
        switch (dVar.oMz) {
            case 1:
                return;
            case 2:
                int i = 0;
                for (Entry entry : dVar.oMy.entrySet()) {
                    int i2;
                    String str = (String) entry.getKey();
                    int intValue = ((Integer) entry.getValue()).intValue();
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck postSetLauncherUIUnReadCount  username %s, preunread %d", str, Integer.valueOf(intValue));
                    com.tencent.mm.e.b.af Pn = dVar.Pn(str);
                    if (Pn == null || x.bAI().contains(str)) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck postSetLauncherUIUnReadCount  cov == null username %s, change %d", str, Integer.valueOf(0 - intValue));
                        i2 = intValue;
                    } else {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck postSetLauncherUIUnReadCount  cov != null username %s, change %d", str, Integer.valueOf((Pn.field_unReadCount - intValue) + 0));
                        i2 = intValue;
                    }
                    if (i2 != 0 && dVar.oLX.Pl(str)) {
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck postSetLauncherUIUnReadCount  username %s isWithoutItemCache", str);
                        ak.yW();
                        ab LX = com.tencent.mm.model.c.wH().LX(str);
                        if (LX != null) {
                            if (m.dE(str)) {
                                if (LX.bCh == 0) {
                                }
                            } else if (LX.tM()) {
                            }
                        }
                    }
                    com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck postSetLauncherUIUnReadCount  real change usename %s, change %d, totalchange %d", str, Integer.valueOf(i2), Integer.valueOf(i + i2));
                    i = intValue;
                }
                oMA += i;
                launcherUI.vy(oMA);
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_PART totalUnReadCount %d, change %d, usetime %d,", Integer.valueOf(oMA), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return;
            default:
                oMA = launcherUI.bzJ();
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck postSetLauncherUIUnReadCount UNREAD_RESET_ALL totalUnReadCount %d, usetime %d,", Integer.valueOf(oMA), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return;
        }
    }

    static /* synthetic */ void n(d dVar) {
        dVar.oMz = -1;
        dVar.oMy.clear();
        if (dVar.oLX == null || oMA < 0 || !dVar.oLX.ub()) {
            dVar.oMz = 0;
        } else if (dVar.oLX.oLg) {
            dVar.oMz = 0;
        } else if (dVar.oLX.oLe) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck preSetLauncherUIUnReadCount has contact change");
            dVar.oMz = 0;
            dVar.oLX.oLe = false;
        } else {
            HashSet hashSet = (HashSet) dVar.oLX.oLf.clone();
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck preSetLauncherUIUnReadCount  events size %d", Integer.valueOf(hashSet.size()));
            if (hashSet.contains("floatbottle")) {
                dVar.oMz = 0;
                return;
            }
            hashSet.remove("officialaccounts");
            if (hashSet.isEmpty()) {
                dVar.oMz = 1;
                return;
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                boolean z;
                String str = (String) it.next();
                b bVar = dVar.oLX;
                if (bVar.Pl(str)) {
                    z = false;
                } else {
                    d dVar2 = (d) bVar.ohm.get(str);
                    z = dVar2 == null ? false : m.dE(str) ? dVar2.oKH : dVar2.oKE;
                }
                if (!z) {
                    com.tencent.mm.e.b.af Pn = dVar.Pn(str);
                    if (Pn == null) {
                        dVar.oMy.put(str, Integer.valueOf(0));
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck preSetLauncherUIUnReadCount  cov == null username %s, unreadcount %d", str, Integer.valueOf(0));
                    } else {
                        dVar.oMy.put(str, Integer.valueOf(Pn.field_unReadCount));
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck preSetLauncherUIUnReadCount  cov != null username %s, unreadcount %d", str, Integer.valueOf(Pn.field_unReadCount));
                    }
                }
            }
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "unreadcheck preSetLauncherUIUnReadCount  preUnReadCount size %d", Integer.valueOf(dVar.oMy.size()));
            if (dVar.oMy.isEmpty()) {
                dVar.oMz = 1;
            } else if (dVar.oMy.size() > 20) {
                dVar.oMz = 0;
            } else {
                dVar.oMz = 2;
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903917;
    }

    public final boolean aXG() {
        return false;
    }

    public final boolean Sk() {
        return true;
    }

    public final void onResume() {
        super.onResume();
        com.tencent.mm.sdk.c.a.nhr.e(this.nAF);
    }

    public final void onPause() {
        super.onPause();
        com.tencent.mm.sdk.c.a.nhr.f(this.nAF);
    }

    private void bIq() {
        bIx();
        com.tencent.mm.sdk.c.a.nhr.e(this.dHB);
    }

    private void bIr() {
        if (!this.oMv) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "Jacks cancel PreLoad.");
            this.oMv = true;
        }
        if (this.oMw != null && this.oMx != null) {
            this.oMw.btx().removeCallbacks(this.oMx);
        }
    }

    private com.tencent.mm.storage.ab Pn(String str) {
        if (this.oLX != null) {
            return (com.tencent.mm.storage.ab) this.oLX.am(str);
        }
        return null;
    }

    public static void bIs() {
        com.tencent.mm.plugin.report.service.f.oS(8);
    }

    public final void onStart() {
        super.onStart();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        bIw();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = 1;
        ak.yW();
        ab LX = com.tencent.mm.model.c.wH().LX(this.bdo);
        if (LX == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.MainUI", "onCreateContextMenu, contact is null, talker = " + this.bdo);
            return;
        }
        CharSequence tU = LX.tU();
        if (tU.toLowerCase().endsWith("@chatroom") && t.kS(LX.field_nickname)) {
            tU = getString(2131231879);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.e.a(this.nDR.nEl, tU));
        if (((this.oFp != null ? 1 : 0) & m.b(this.oFp)) != 0) {
            String str = this.bdo;
            ak.yW();
            com.tencent.mm.e.b.af Mh = com.tencent.mm.model.c.wK().Mh(str);
            if (Mh == null) {
                i = 0;
            } else if (Mh.field_unReadCount > 0 || Mh.el(1048576)) {
                i = 0;
            }
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 8, 0, 2131233705);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 7, 0, 2131233703);
            }
        }
        if (this.oFp != null && m.a(this.oFp)) {
            ak.yW();
            if (com.tencent.mm.model.c.wK().Mn(this.bdo)) {
                contextMenu.add(adapterContextMenuInfo.position, 6, 0, 2131233706);
            } else if (LX.bvm()) {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, 2131232190);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, 2131233704);
            }
        }
        if (LX.bvm() && com.tencent.mm.i.a.ei(LX.field_type) && !m.fo(LX.field_username) && !m.eP(LX.field_username)) {
            BizInfo hw = com.tencent.mm.modelbiz.e.hw(LX.field_username);
            if (hw != null && hw.Cw()) {
                contextMenu.add(adapterContextMenuInfo.position, 10, 0, 2131233702);
            }
        }
        if (this.oFp != null && this.oFp.field_conversationTime != -1) {
            if (m.eK(this.bdo)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, 2131233712);
            } else if (m.eI(this.bdo)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, 2131233713);
            } else if (m.eJ(this.bdo)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, 2131233711);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, 2131233710);
            }
        }
    }

    private boolean bIt() {
        if (!com.tencent.mm.modelmulti.l.Hm()) {
            return false;
        }
        if (this.oLT != null && this.oLT.isShowing()) {
            return false;
        }
        ak.yW();
        boolean wz = com.tencent.mm.model.c.wz();
        if (wz && !this.oLU) {
            this.oMp = wz;
        }
        if (this.oMp) {
            this.oLT = new h.a(this.nDR.nEl).wm(2131232268).Oq(this.nDR.nEl.getString(2131232267)).jk(false).wp(2131232269).a(new OnClickListener(this) {
                final /* synthetic */ d oMF;

                {
                    this.oMF = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oMF.oLT.dismiss();
                    this.oMF.bIu();
                }
            }).wq(2131232266).b(new OnClickListener(this) {
                final /* synthetic */ d oMF;

                {
                    this.oMF = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oMF.oLT.dismiss();
                    this.oMF.oLU = true;
                    this.oMF.oMp = false;
                    this.oMF.bIu();
                }
            }).RX();
            this.oLT.show();
        } else {
            bIu();
        }
        return true;
    }

    public final void bIu() {
        if (this.oLZ) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "summerinit doInit but hasTryDoInitButFailed true ret");
            return;
        }
        if (!this.wakeLock.isHeld()) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MainUI", "tryDoInit wakelock.acquire!");
            this.wakeLock.acquire();
        }
        if (this.oMn == null) {
            this.oMn = new com.tencent.mm.modelmulti.f(this);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "dkinit doInit t:%d initScene:%d", Long.valueOf(this.oMo.sn()), Integer.valueOf(this.oMn.hashCode()));
            this.oMo.cgu = SystemClock.elapsedRealtime();
            ak.vy().a(this.oMn, 0);
        }
        if (this.oLX != null) {
            this.oLX.gVJ = true;
        }
        ad.o(new Runnable(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void run() {
                int i;
                String str = "MicroMsg.MainUI";
                String str2 = "dkinit showProgressDlg t:%d initScene:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(this.oMF.oMo.sn());
                if (this.oMF.oMn == null) {
                    i = -2;
                } else {
                    i = this.oMF.oMn.hashCode();
                }
                objArr[1] = Integer.valueOf(i);
                com.tencent.mm.sdk.platformtools.v.d(str, str2, objArr);
                if (this.oMF.oMn != null) {
                    if (this.oMF.dwR != null && this.oMF.dwR.isShowing()) {
                        this.oMF.dwR.dismiss();
                    }
                    d dVar;
                    Context context;
                    if (this.oMF.oMp) {
                        dVar = this.oMF;
                        context = this.oMF.nDR.nEl;
                        this.oMF.getString(2131231164);
                        dVar.dwR = com.tencent.mm.ui.base.g.a(context, this.oMF.getString(2131234368), false, null);
                    } else {
                        dVar = this.oMF;
                        context = this.oMF.nDR.nEl;
                        this.oMF.getString(2131231164);
                        dVar.dwR = com.tencent.mm.ui.base.g.a(context, this.oMF.getString(2131231085), false, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass36 oMR;

                            {
                                this.oMR = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(this.oMR.oMF.oMn);
                            }
                        });
                    }
                    ak.vA().btu();
                }
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar.getType() == 138 || kVar.getType() == 139) {
            int i3;
            String str2 = "MicroMsg.MainUI";
            String str3 = "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = str;
            objArr[3] = Integer.valueOf(kVar.getType());
            objArr[4] = Integer.valueOf(hashCode());
            if (this.oMn == null) {
                i3 = -2;
            } else {
                i3 = this.oMn.hashCode();
            }
            objArr[5] = Integer.valueOf(i3);
            com.tencent.mm.sdk.platformtools.v.i(str2, str3, objArr);
            if (this.oMn != null && kVar.getType() == 139) {
                this.oMn = null;
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MainUI", "summerinit dkinit Kevin init FINISH : %d ", Long.valueOf(this.oMo.sn()));
                com.tencent.mm.model.ab.a.crZ.a(null, null, null);
                if (this.oLX != null) {
                    this.oLX.gVJ = false;
                    this.oLX.bIh();
                    if (bzo() != null) {
                        oMA = ((LauncherUI) bzo()).bzJ();
                    }
                }
                if (this.wakeLock.isHeld()) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MainUI", "onSceneEnd wakelock.release!");
                    this.wakeLock.release();
                }
                ak.vA().btw();
                if (this.oMp) {
                    com.tencent.mm.plugin.dbbackup.d dVar = (com.tencent.mm.plugin.dbbackup.d) ak.yP().fY("plugin.dbbackup");
                    if (dVar != null) {
                        com.tencent.mm.plugin.dbbackup.b anonymousClass5 = new com.tencent.mm.plugin.dbbackup.d.AnonymousClass5(dVar, new com.tencent.mm.plugin.dbbackup.b(this) {
                            final /* synthetic */ d oMF;

                            {
                                this.oMF = r1;
                            }

                            public final void gu(final int i) {
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass37 oMS;

                                    public final void run() {
                                        Context context = this.oMS.oMF.nDR.nEl;
                                        if (i == -2) {
                                            Toast.makeText(context, 2131234370, 1).show();
                                        } else if (i == 0) {
                                            Toast.makeText(context, 2131234371, 0).show();
                                        } else {
                                            Toast.makeText(context, 2131234367, 1).show();
                                        }
                                        if (this.oMS.oMF.dwR != null) {
                                            this.oMS.oMF.dwR.dismiss();
                                            this.oMS.oMF.dwR = null;
                                        }
                                        this.oMS.oMF.oMp = false;
                                        if (this.oMS.oMF.oLX != null) {
                                            this.oMS.oMF.oLX.bIh();
                                        }
                                    }
                                });
                                if (i == 0) {
                                    ak.yW();
                                    com.tencent.mm.model.c.wA();
                                }
                            }
                        });
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.SubCoreDBBackup", "Database recover started.");
                        g.iuh.a(181, 28, 1, false);
                        anonymousClass5.gu(-1);
                    }
                } else if (this.dwR != null) {
                    this.dwR.dismiss();
                    this.dwR = null;
                }
            }
            if (com.tencent.mm.ui.o.a(bzo(), i, i2, new Intent().setClass(this.nDR.nEl, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "summerinit onSceneEnd accountExpired ret");
            } else if (ak.uz()) {
                if (!this.oMi) {
                    this.oMi = true;
                    ak.yW();
                    str2 = (String) com.tencent.mm.model.c.vf().get(5, null);
                    ak.yW();
                    if (!((((Integer) com.tencent.mm.model.c.vf().get(57, Integer.valueOf(0))).intValue() != 0 ? 1 : null) == null || str2 == null)) {
                        com.tencent.mm.ui.base.g.b(this.nDR.nEl, getString(2131234414, str2), getString(2131231164), getString(2131234416), getString(2131234415), new OnClickListener(this) {
                            final /* synthetic */ d oMF;

                            {
                                this.oMF = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.oMF.startActivity(new Intent(this.oMF.nDR.nEl, RegByFacebookSetPwdUI.class));
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ d oMF;

                            {
                                this.oMF = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                    }
                }
                if (i == 4 && i2 == -17 && !oMC) {
                    o.Ho().fP(7);
                    oMC = true;
                }
                if (T(i, i2, kVar.getType())) {
                    com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MainUI", "summerinit onSceneEnd checkUpdate ret");
                    return;
                }
                if (kVar.getType() == 139) {
                    if (i == 3 && i2 == -1) {
                        this.oLZ = true;
                        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "summerinit onSceneEnd -1 show tryNewInitBanner[%s]", this.oMa);
                        if (this.oMa != null) {
                            this.oMa.nRy = true;
                            bIw();
                            return;
                        }
                    } else if (this.oMa != null) {
                        this.oMa.nRy = false;
                    }
                }
                if (!com.tencent.mm.ui.o.a.a(this.nDR.nEl, i, i2, str, 4)) {
                    if (kVar.getType() == 139) {
                        new com.tencent.mm.sdk.platformtools.ac().post(new Runnable(this) {
                            final /* synthetic */ d oMF;

                            {
                                this.oMF = r1;
                            }

                            public final void run() {
                                o.Ho().fP(5);
                            }
                        });
                        if ((com.tencent.mm.model.k.xL() & FileUtils.S_IWUSR) != 0) {
                            ak.yW();
                            if (com.tencent.mm.model.c.wK().Mh("masssendapp") == null) {
                                com.tencent.mm.storage.ab abVar = new com.tencent.mm.storage.ab();
                                abVar.setUsername("masssendapp");
                                abVar.setContent(aa.getContext().getResources().getString(2131232084));
                                abVar.s(t.Ni() + 2000);
                                abVar.di(0);
                                abVar.df(0);
                                ak.yW();
                                com.tencent.mm.model.c.wK().d(abVar);
                                i3 = com.tencent.mm.model.k.xL() & -129;
                                ak.yW();
                                com.tencent.mm.model.c.vf().set(40, Integer.valueOf(i3));
                            }
                        }
                    }
                    if (kVar.getType() == 138 || kVar.getType() == 139) {
                        ad.o(new Runnable(this) {
                            final /* synthetic */ d oMF;

                            {
                                this.oMF = r1;
                            }

                            public final void run() {
                                com.tencent.mm.sdk.c.b flVar = new fl();
                                flVar.beP.data = "MAIN_UI_EVENT_INIT_FINALLY";
                                com.tencent.mm.sdk.c.a.nhr.z(flVar);
                            }
                        });
                        bIw();
                    }
                }
            } else {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MainUI", "summerinit onSceneEnd not set uin");
            }
        } else if (kVar.getType() != MMGIFException.D_GIF_ERR_EOF_TOO_SOON) {
            T(i, i2, kVar.getType());
        } else {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "onSceneEnd from GetUpdateInfo, ignore it.");
        }
    }

    public final void bIv() {
        if (ak.uz() && this.oMf != null) {
            this.oMf.blU();
        }
    }

    private boolean T(int i, int i2, int i3) {
        ak.yW();
        long e = t.e((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_UPDATE_UPDATE_FLAG_LONG, null));
        ak.yW();
        long e2 = t.e((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_UPDATE_UPDATE_TIME_LONG, null));
        ak.yW();
        long e3 = t.e((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_UPDATE_UPDATE_VERION_LONG, null));
        ak.yW();
        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf(0));
        ak.yW();
        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf(0));
        if (e3 == ((long) com.tencent.mm.protocal.d.lWh) && t.ax(e2) < 3600) {
            if (e == 1) {
                if (com.tencent.mm.ui.o.a(this.nDR.nEl, 4, -17)) {
                    return true;
                }
            } else if (e == 2 && com.tencent.mm.ui.o.a(this.nDR.nEl, 4, -16)) {
                return true;
            }
        }
        if (i == 4 && (i2 == -16 || i2 == -17)) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "trigger check update: errCode:%d, sceneType:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (q.dpW) {
                aa.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", (t.Nh() - 86400) - 1).commit();
            }
            if (com.tencent.mm.ui.o.a(this.nDR.nEl, i, i2)) {
                return true;
            }
        }
        return false;
    }

    public final void a(int i, int i2, com.tencent.mm.v.k kVar) {
        if (kVar != null && kVar.getType() == 139) {
            final int i3 = (int) (i2 != 0 ? (((long) i) * 100) / ((long) i2) : 0);
            ad.o(new Runnable(this) {
                final /* synthetic */ d oMF;

                public final void run() {
                    if (!this.oMF.oMp && this.oMF.dwR != null) {
                        this.oMF.dwR.setMessage(this.oMF.getString(2131231085) + i3 + "%");
                    }
                }
            });
        }
    }

    public final void gM(String str) {
        if (ak.uz() && !ak.uG() && t.ma(str).length() > 0 && str.equals(com.tencent.mm.model.k.xF())) {
            bIw();
        }
    }

    public final void a(int i, j jVar, Object obj) {
        if (ak.uz()) {
            ak.yW();
            if (jVar == com.tencent.mm.model.c.vf()) {
                int az = t.az(obj);
                if (8193 == az) {
                    bIw();
                }
                if (42 == az) {
                    bIw();
                }
            }
        }
    }

    private void bIw() {
        int i = 1;
        if (ak.uz() && this.oMm != null && this.oMm.nQk != null) {
            int i2;
            if (this.oMc != null) {
                this.oMc.refresh();
            }
            if (ak.uz() && this.oMn == null && this.oMe != null) {
                i iVar = this.oMe;
                if (iVar.hasInit) {
                    ad.B(iVar.nQO);
                    ad.g(iVar.nQO, 500);
                } else {
                    iVar.aqp();
                }
            }
            if (ak.uz() && this.oLY != null && this.oLY.agO() && this.oMa != null) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "summerinit resetTips but netWarnBanner showing so set tryNewInitBanner gone");
                this.oMa.setVisibility(8);
            }
            if (!ak.uz() || this.oLY == null || !this.oLY.agO() || this.oMm == null) {
                i2 = 1;
            } else {
                this.oMm.setVisibility(8);
                i2 = 0;
            }
            if (ak.uz() && this.oMa != null && this.oMa.agO()) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "summerinit resetTips tryNewInitBanner update true");
                if (this.oMm != null) {
                    this.oMm.setVisibility(8);
                    i2 = 0;
                }
            }
            if (!(!this.gYJ || this.oMj || this.oLY == null)) {
                this.oLY.setVisibility(8);
            }
            if (i2 != 0) {
                com.tencent.mm.pluginsdk.m.a.a dk = com.tencent.mm.pluginsdk.m.a.a.dk(this.nDR.nEl);
                if (this.oMm != null && this.oMm.nQk != null) {
                    if (dk != null) {
                        this.oMm.nQk.nQp = dk;
                        this.oMm.nQk.Ol();
                        com.tencent.mm.ui.d.a aVar = this.oMm;
                        if (aVar.nQk == null || aVar.nQk.getCount() <= 0 || aVar.nQk.vY(0).a(aVar.nQm) != 0) {
                            i = 0;
                        }
                        if (i != 0) {
                            this.oMm.setVisibility(0);
                            return;
                        }
                    }
                    this.oMm.setVisibility(8);
                }
            }
        }
    }

    private void bIx() {
        int i = 8;
        if (this.oMd == null) {
            return;
        }
        if (com.tencent.mm.ai.b.HC()) {
            ajr HE = com.tencent.mm.ai.b.HE();
            com.tencent.mm.ui.d.l lVar = this.oMd;
            CharSequence charSequence = getString(2131233965) + getString(2131233966) + HE.mJY;
            if (lVar.nRl != null) {
                lVar.nRl.setText(charSequence);
            }
            lVar = this.oMd;
            if (!HE.mKp) {
                i = 0;
            }
            lVar.setVisibility(i);
            return;
        }
        this.oMd.setVisibility(8);
    }

    public final void y(String str, String str2, String str3) {
        this.oLX.notifyDataSetChanged();
    }

    public final void yM() {
        bIw();
    }

    protected final void bys() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "on tab create");
        long currentTimeMillis = System.currentTimeMillis();
        setMenuVisibility(true);
        ak.vA().btw();
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.MainUI", "main ui init view");
        if (this.oLV != null) {
            this.oLV.setAdapter(null);
            if (!(this.oMb == null || this.oMb.view == null)) {
                this.oLV.removeHeaderView(this.oMb.view);
            }
            if (!(this.oLY == null || this.oLY.view == null)) {
                this.oLV.removeHeaderView(this.oLY.view);
            }
            if (!(this.oMa == null || this.oMa.view == null)) {
                this.oLV.removeHeaderView(this.oMa.view);
            }
            if (!(this.oMd == null || this.oMd.view == null)) {
                this.oLV.removeHeaderView(this.oMd.view);
            }
            if (!(this.oMm == null || this.oMm.view == null)) {
                this.oLV.removeHeaderView(this.oMm.view);
            }
            if (!(this.oMg == null || this.oMg.getView() == null)) {
                this.oLV.removeFooterView(this.oMg.getView());
            }
            if (this.oMh != null) {
                this.oLV.removeHeaderView(this.oMh);
            }
            if (!(this.oMe == null || this.oMe.view == null)) {
                this.oLV.removeHeaderView(this.oMe.view);
            }
            if (!(this.oMf == null || this.oMf.view == null)) {
                this.oLV.removeHeaderView(this.oMf.view);
            }
            if (!(this.oMc == null || this.oMc.view == null)) {
                this.oLV.removeHeaderView(this.oMc.view);
            }
        }
        this.oLW = (TextView) findViewById(2131757996);
        this.oDZ = (TextView) findViewById(2131755321);
        this.oDZ.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void onClick(View view) {
            }
        });
        this.oLV = (ListView) findViewById(2131757995);
        this.oLV.setDrawingCacheEnabled(false);
        this.oLV.setScrollingCacheEnabled(false);
        this.oLV.post(new Runnable(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void run() {
                if (!aa.btf()) {
                    aa.iv(true);
                    ad.g(new Runnable(this) {
                        final /* synthetic */ AnonymousClass5 oMH;

                        {
                            this.oMH = r1;
                        }

                        public final void run() {
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "APPHasInitEvent begin");
                            com.tencent.mm.sdk.c.a.nhr.z(new com.tencent.mm.e.a.a());
                        }
                    }, 100);
                }
                d.bIs();
            }
        });
        this.nIp = (TextView) findViewById(2131757997);
        this.oLX = new b(this.nDR.nEl, new com.tencent.mm.ui.e.a(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void Oj() {
                com.tencent.mm.plugin.report.service.f.oR(12);
                d.n(this.oMF);
            }

            public final void Oi() {
                d.f(this.oMF);
                if (this.oMF.oLX != null) {
                    b e = this.oMF.oLX;
                    if (!(e.ohm == null || e.oLf == null || e.oLf.isEmpty())) {
                        if (e.oLg) {
                            e.ohm.clear();
                            e.oLg = false;
                        } else {
                            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", Integer.valueOf(e.oLf.size()));
                            Iterator it = e.oLf.iterator();
                            while (it.hasNext()) {
                                e.ohm.remove(it.next());
                            }
                        }
                        e.oLf.clear();
                    }
                }
                this.oMF.oLV.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 oMI;

                    {
                        this.oMI = r1;
                    }

                    public final void run() {
                        d.c(this.oMI.oMF, this.oMI.oMF.oLX.getCount());
                        com.tencent.mm.plugin.report.service.f.oS(12);
                    }
                });
            }
        });
        this.oLX.a(new MMSlideDelView.c(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final int bN(View view) {
                return this.oMF.oLV.getPositionForView(view);
            }
        });
        this.oLX.a(new MMSlideDelView.f(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void p(View view, int i) {
                this.oMF.oLV.performItemClick(view, i, 0);
            }
        });
        this.oLX.a(new MMSlideDelView.e(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void aE(Object obj) {
                if (obj == null) {
                    com.tencent.mm.sdk.platformtools.v.e("MicroMsg.MainUI", "onItemDel object null");
                } else {
                    d.a(this.oMF, obj.toString());
                }
            }
        });
        this.oMb = (com.tencent.mm.pluginsdk.ui.b.b) com.tencent.mm.ui.d.e.a(this.nDR.nEl, com.tencent.mm.ui.d.e.a.nQA, null);
        this.oLY = (com.tencent.mm.ui.d.m) com.tencent.mm.ui.d.e.a(this.nDR.nEl, com.tencent.mm.ui.d.e.a.nQz, null);
        this.oMa = (n) com.tencent.mm.ui.d.e.a(this.nDR.nEl, com.tencent.mm.ui.d.e.a.nQF, null);
        this.oMd = (com.tencent.mm.ui.d.l) com.tencent.mm.ui.d.e.a(this.nDR.nEl, com.tencent.mm.ui.d.e.a.nQy, null);
        this.oMe = (i) com.tencent.mm.ui.d.e.a(this.nDR.nEl, com.tencent.mm.ui.d.e.a.nQx, null);
        this.oMm = (com.tencent.mm.ui.d.a) com.tencent.mm.ui.d.e.a(this.nDR.nEl, com.tencent.mm.ui.d.e.a.nQC, null);
        this.oMf = (k) com.tencent.mm.ui.d.e.a(this.nDR.nEl, com.tencent.mm.ui.d.e.a.nQE, null);
        if (!(this.oLY == null || this.oLY.view == null)) {
            this.oLV.addHeaderView(this.oLY.view);
        }
        if (!(this.oMa == null || this.oMa.view == null)) {
            this.oLV.addHeaderView(this.oMa.view);
            this.oMa.nRz = new n.a(this) {
                final /* synthetic */ d oMF;

                {
                    this.oMF = r1;
                }

                public final void bzb() {
                    this.oMF.oLZ = false;
                    this.oMF.bIu();
                }
            };
        }
        if (!(this.oMb == null || this.oMb.view == null)) {
            this.oLV.addHeaderView(this.oMb.view);
        }
        if (!(this.oMd == null || this.oMd.view == null)) {
            this.oLV.addHeaderView(this.oMd.view);
        }
        if (!(this.oMm == null || this.oMm.view == null)) {
            this.oLV.addHeaderView(this.oMm.view);
        }
        if (!(this.oMe == null || this.oMe.view == null)) {
            this.oLV.addHeaderView(this.oMe.view);
        }
        if (!(this.oMf == null || this.oMf.view == null)) {
            this.oLV.addHeaderView(this.oMf.view);
        }
        this.oMc = com.tencent.mm.ui.appbrand.c.er(this.nDR.nEl);
        if (!(this.oMc == null || this.oMc.view == null)) {
            this.oLV.addHeaderView(this.oMc.view);
        }
        this.oMh = new LinearLayout(this.nDR.nEl);
        this.oLV.addHeaderView(this.oMh);
        this.oMh.setVisibility(8);
        bIq();
        av.zh().cte = new av.b(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void zk() {
                this.oMF.oLV.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass11 oMJ;

                    {
                        this.oMJ = r1;
                    }

                    public final void run() {
                        if (this.oMJ.oMF.oMh != null) {
                            this.oMJ.oMF.oMh.setVisibility(8);
                            this.oMJ.oMF.oMh.removeAllViews();
                        }
                        com.tencent.mm.pluginsdk.ui.b.a a = com.tencent.mm.ui.d.e.a(this.oMJ.oMF.bzo(), com.tencent.mm.ui.d.e.a.nQD, null);
                        if (a == null) {
                            a = com.tencent.mm.ui.d.e.a(this.oMJ.oMF.bzo(), com.tencent.mm.ui.d.e.a.nQu, null);
                        }
                        if (a != null && a.getView() != null) {
                            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", a, a.getView());
                            this.oMJ.oMF.oMh.setVisibility(0);
                            this.oMJ.oMF.oMh.addView(a.getView(), new LayoutParams(-1, -2));
                        }
                    }
                });
            }
        };
        av.zh().cte.zk();
        this.oEq = View.inflate(this.nDR.nEl, 2130903809, null);
        this.bCd = t.getInt(com.tencent.mm.h.j.sU().getValue("InviteFriendsControlFlags"), 0);
        this.oLV.addFooterView(this.oEq, null, true);
        this.oEq.setVisibility(8);
        this.oEq.setPadding(0, -com.tencent.mm.bd.a.fromDPToPix(this.nDR.nEl, 2131493167), 0, 0);
        if ((this.bCd & 1) > 0) {
            this.oEq.setVisibility(0);
            this.oEq.setPadding(0, 0, 0, 0);
        }
        this.oEq.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Invite_friends", true);
                com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "subapp", ".ui.pluginapp.AddMoreFriendsUI", intent);
                g.iuh.a(224, 0, 1, false);
            }
        });
        this.oLV.setOnScrollListener(this.ePu);
        this.oLX.oKf = this.ePu;
        oMA = ((LauncherUI) bzo()).bzJ();
        this.oLV.setAdapter(this.oLX);
        ad.o(new Runnable(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void run() {
                d.a(this.oMF, 0);
            }
        });
        this.eyZ = new l(this.nDR.nEl);
        this.oLV.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                boolean z = false;
                if (i >= this.oMF.oLV.getHeaderViewsCount()) {
                    int headerViewsCount = i - this.oMF.oLV.getHeaderViewsCount();
                    com.tencent.mm.storage.ab abVar = (com.tencent.mm.storage.ab) this.oMF.oLX.en(headerViewsCount);
                    if (abVar == null) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.MainUI", "null user at position = " + headerViewsCount);
                        return;
                    }
                    boolean z2;
                    if (m.eI(abVar.field_username)) {
                        if (com.tencent.mm.model.k.xY()) {
                            com.tencent.mm.ay.c.w(this.oMF.nDR.nEl, "tmessage", ".ui.TConversationUI");
                            z2 = false;
                        } else {
                            com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                            z2 = false;
                        }
                    } else if (m.eK(abVar.field_username)) {
                        if (com.tencent.mm.model.k.xR()) {
                            com.tencent.mm.ay.c.w(this.oMF.nDR.nEl, "qmessage", ".ui.QConversationUI");
                            z2 = false;
                        } else {
                            com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                            z2 = false;
                        }
                    } else if (m.eJ(abVar.field_username)) {
                        if (com.tencent.mm.model.k.xX()) {
                            com.tencent.mm.ay.c.w(this.oMF.nDR.nEl, "bottle", ".ui.BottleConversationUI");
                            z2 = false;
                        } else {
                            com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                            z2 = false;
                        }
                    } else if (m.eO(abVar.field_username)) {
                        MMAppMgr.cancelNotification(abVar.field_username);
                        com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                        z2 = false;
                    } else {
                        if (m.eG(abVar.field_username)) {
                            com.tencent.mm.kernel.g.vx();
                            if (be.f((Integer) com.tencent.mm.kernel.g.vw().vf().get(17, null)) == 1) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                                z2 = false;
                            }
                        } else if (m.eT(abVar.field_username)) {
                            if (com.tencent.mm.model.k.yd()) {
                                r1 = new Intent();
                                r1.addFlags(67108864);
                                r1.putExtra("type", 20);
                                com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "readerapp", ".ui.ReaderAppUI", r1);
                                z2 = false;
                            } else {
                                com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                                z2 = false;
                            }
                        } else if (m.fb(abVar.field_username)) {
                            if (com.tencent.mm.model.k.ye()) {
                                r1 = new Intent();
                                r1.addFlags(67108864);
                                r1.putExtra("type", 11);
                                com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "readerapp", ".ui.ReaderAppUI", r1);
                                z2 = false;
                            } else {
                                com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                                z2 = false;
                            }
                        } else if (m.eL(abVar.field_username)) {
                            com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                            z2 = false;
                        } else if (m.eM(abVar.field_username)) {
                            if (com.tencent.mm.model.k.yg()) {
                                com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "masssend", ".ui.MassSendHistoryUI", new Intent().addFlags(67108864));
                                z2 = false;
                            } else {
                                com.tencent.mm.ay.c.b(this.oMF.nDR.nEl, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", abVar.field_username));
                                z2 = false;
                            }
                        } else if (m.fa(abVar.field_username)) {
                            if (com.tencent.mm.model.ab.a.csd != null) {
                                com.tencent.mm.model.ab.a.csd.fE(abVar.field_username);
                            }
                            z2 = true;
                        } else if (m.fc(abVar.field_username)) {
                            this.oMF.startActivity(new Intent(this.oMF.nDR.nEl, BizConversationUI.class));
                            z2 = false;
                        } else if (m.eD(abVar.field_username) && com.tencent.mm.modelbiz.e.hB(abVar.field_username)) {
                            if (m.eC(abVar.field_username)) {
                                r1 = new Intent(this.oMF.nDR.nEl, EnterpriseConversationUI.class);
                                r1.putExtra("enterprise_biz_name", abVar.field_username);
                                r1.putExtra("enterprise_biz_display_name", com.tencent.mm.model.l.er(abVar.field_username));
                                r1.putExtra("enterprise_from_scene", 1);
                                this.oMF.startActivity(r1);
                                z2 = false;
                            } else {
                                com.tencent.mm.ui.base.g.bf(this.oMF.nDR.nEl, this.oMF.getString(2131232471));
                                return;
                            }
                        } else if (m.eD(abVar.field_username) && com.tencent.mm.modelbiz.e.hC(abVar.field_username)) {
                            if (m.eC(abVar.field_username)) {
                                r1 = new Intent(this.oMF.nDR.nEl, BizChatConversationUI.class);
                                r1.putExtra("Contact_User", abVar.field_username);
                                r1.putExtra("biz_chat_from_scene", 1);
                                r1.addFlags(67108864);
                                this.oMF.startActivity(r1);
                                z2 = false;
                            } else {
                                com.tencent.mm.ui.base.g.bf(this.oMF.nDR.nEl, this.oMF.getString(2131232471));
                                return;
                            }
                        } else if (m.fm(abVar.field_username)) {
                            r1 = new Intent();
                            r1.setClassName(this.oMF.nDR.nEl, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
                            r1.putExtra("Contact_User", abVar.field_username);
                            r1.putExtra("app_brand_conversation_from_scene", 1);
                            r1.addFlags(67108864);
                            this.oMF.startActivity(r1);
                            z2 = false;
                        }
                        z2 = true;
                    }
                    if (z2) {
                        com.tencent.mm.plugin.report.service.f.oR(9);
                        LauncherUI launcherUI = (LauncherUI) this.oMF.nDR.nEl;
                        String str = "Launcher should not be empty.";
                        if (launcherUI != null) {
                            z = true;
                        }
                        Assert.assertTrue(str, z);
                        launcherUI.a(abVar.field_username, null, true);
                    }
                }
            }
        });
        this.oLV.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.oMF.oLV.getHeaderViewsCount()) {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "on long click header view");
                } else {
                    this.oMF.oFp = (com.tencent.mm.storage.ab) this.oMF.oLX.en(i - this.oMF.oLV.getHeaderViewsCount());
                    if (this.oMF.oFp == null) {
                        com.tencent.mm.sdk.platformtools.v.e("MicroMsg.MainUI", "headercount:%d, postion:%d", Integer.valueOf(this.oMF.oLV.getHeaderViewsCount()), Integer.valueOf(i));
                    } else {
                        this.oMF.bdo = this.oMF.oFp.field_username;
                        this.oMF.eyZ.a(view, i, j, this.oMF, this.oMF.hkn);
                    }
                }
                return true;
            }
        });
        this.oLV.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.oMF.ale();
                        break;
                }
                if (this.oMF.oLX != null) {
                    this.oMF.oLX;
                }
                return false;
            }
        });
        this.oMi = false;
        this.oEh = false;
        this.gYJ = false;
        this.oMj = false;
        this.oMl = 0;
        this.nBU = new IdleHandler(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final boolean queueIdle() {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "dkuploadAddrBook idleHandler");
                d.bIA();
                Looper.myQueue().removeIdleHandler(this.oMF.nBU);
                return false;
            }
        };
        this.ixZ = new com.tencent.mm.network.m.a(this) {
            private final ah oME = new ah(new ah.a(this) {
                final /* synthetic */ AnonymousClass51 oMU;

                {
                    this.oMU = r1;
                }

                public final boolean oU() {
                    this.oMU.oMF.bIw();
                    return false;
                }
            }, false);
            final /* synthetic */ d oMF;

            {
                this.oMF = r4;
            }

            public final void cI(int i) {
                if (this.oME != null) {
                    this.oME.ea(10);
                }
            }
        };
        this.oLV.setSelection(0);
        this.wakeLock = ((PowerManager) this.nDR.nEl.getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
        ak.vy().a(-1, (e) this);
        ak.yW();
        com.tencent.mm.model.c.a(this);
        ak.a(this.ixZ);
        Looper.myQueue().addIdleHandler(this.nBU);
        com.tencent.mm.sdk.c.a.nhr.e(this.oMB);
        ak.aL(false);
        com.tencent.mm.sdk.c.a.nhr.e(this.oMq);
        com.tencent.mm.sdk.c.a.nhr.e(this.oMr);
        com.tencent.mm.sdk.c.a.nhr.e(this.oMs);
        ak.yW();
        com.tencent.mm.model.c.wK().a(this.oLX);
        ak.yW();
        com.tencent.mm.model.c.wH().a(this.oLX);
        b bVar = this.oLX;
        if (bVar.oKl == null) {
            bVar.oKl = new c<w>(bVar) {
                final /* synthetic */ b oLm;

                {
                    this.oLm = r2;
                    this.nhz = w.class.getName().hashCode();
                }

                public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                    this.oLm.oKi = true;
                    return false;
                }
            };
        }
        com.tencent.mm.sdk.c.a.nhr.e(bVar.oKl);
        this.oLX.oLc = new b.b(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void bIj() {
                this.oMF.oLX.clearCache();
                ak.yW();
                com.tencent.mm.model.c.wK().a(this.oMF.oLX);
                ak.yW();
                com.tencent.mm.model.c.wH().a(this.oMF.oLX);
            }
        };
        if (this.faM == null) {
            this.faM = new c<kl>(this) {
                final /* synthetic */ d oMF;

                {
                    this.oMF = r2;
                    this.nhz = kl.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
                    this.oMF.oMD.sendEmptyMessage(0);
                    return false;
                }
            };
        }
        com.tencent.mm.sdk.c.a.nhr.e(this.faM);
        com.tencent.mm.ae.a GJ = com.tencent.mm.ae.n.GJ();
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + GJ.cKR + " to 2130837919");
        GJ.cKR = 2130837919;
        com.tencent.mm.ae.n.GJ().start();
        r4 = new Object[4];
        ak.yW();
        r4[2] = Integer.valueOf(com.tencent.mm.model.c.ww());
        r4[3] = Integer.valueOf(com.tencent.mm.protocal.d.lWh);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d diff:%d uin:%d ver:%x", r4);
        this.oLV.postDelayed(new Runnable(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void run() {
                if (this.oMF.bzo() != null) {
                    this.oMF.bzo().aR();
                }
            }
        }, 200);
    }

    public final void bIy() {
        if (this.oLX != null) {
            this.oLX.onResume();
        }
    }

    public final void bIz() {
        if (this.oLX != null) {
            this.oLX.onPause();
        }
    }

    protected final void byt() {
        LauncherUI launcherUI;
        long Ni = t.Ni();
        com.tencent.mm.u.n.AX().d(this);
        if (oMA < 0) {
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "onTabResume totalUnReadCount %d", Integer.valueOf(oMA));
            if (this.oLX != null) {
                this.oLX.bIh();
            }
        }
        bIy();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.oMm != null) {
            com.tencent.mm.ui.d.a aVar = this.oMm;
            aVar.nQk = new com.tencent.mm.ui.d.b((Context) aVar.lKT.get());
            aVar.nQn = new com.tencent.mm.ui.d.a.a(aVar) {
                final /* synthetic */ a nQo;

                {
                    this.nQo = r1;
                }

                public final void dX(String str, String str2) {
                    com.tencent.mm.pluginsdk.m.a.a.bon();
                    ak.yW();
                    com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.o(2, str));
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.ADBanner", "jump to " + str2);
                    com.tencent.mm.pluginsdk.j.a.lxU.a((Context) this.nQo.lKT.get(), str2, true);
                }

                public final void Ex(String str) {
                    com.tencent.mm.pluginsdk.m.a.a.bon();
                    ak.yW();
                    com.tencent.mm.model.c.wG().b(new com.tencent.mm.ak.o(3, str));
                }
            };
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "KEVIN initTips: " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        bIq();
        ak.yW();
        this.oEh = t.c((Boolean) com.tencent.mm.model.c.vf().get(12296, null));
        if (this.oMb != null) {
            this.oMb.Uj();
            if (this.oMb.refresh() && this.oLV.getVisibility() != 0) {
                this.oLV.setVisibility(0);
                this.oLW.setVisibility(8);
            }
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "KEVIN bakBannerView : " + (System.currentTimeMillis() - currentTimeMillis) + ", show slide tips (" + this.oEh + ")");
        av();
        ak.yW();
        com.tencent.mm.model.c.vf().a(this);
        if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
            com.tencent.mm.pluginsdk.j.a.lxG.a(this);
        }
        String str = "MicroMsg.MainUI";
        String str2 = "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d tip:%d initscene:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(t.ay(Ni));
        int i = this.dwR == null ? -1 : this.dwR.isShowing() ? 1 : 0;
        objArr[1] = Integer.valueOf(i);
        if (this.oMn == null) {
            i = -2;
        } else {
            i = this.oMn.hashCode();
        }
        objArr[2] = Integer.valueOf(i);
        com.tencent.mm.sdk.platformtools.v.i(str, str2, objArr);
        bIt();
        ad.g(new Runnable(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void run() {
                p pVar = this.oMF;
                if (com.tencent.mm.ui.o.el(pVar.nDR.nEl)) {
                    g.iuh.a(405, 41, 1, true);
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "we got a install");
                } else if (com.tencent.mm.ui.o.Y(pVar.nDR.nEl)) {
                    com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "we got an unfinished silence download");
                }
            }
        }, 100);
        if (ak.uz() && this.oMn == null) {
            com.tencent.mm.sdk.c.a.nhr.a(new ox(), Looper.getMainLooper());
        }
        e.eE(this.nDR.nEl);
        Context bzo = bzo();
        if (!(bzo == null || bzo.isFinishing())) {
            launcherUI = (LauncherUI) bzo;
            int tX = com.tencent.mm.l.a.tX();
            h.a aVar2;
            if (tX == 1) {
                Ni = PreferenceManager.getDefaultSharedPreferences(bzo).getLong("db_check_tip_time", 0);
                boolean z = System.currentTimeMillis() - Ni > 86400000 || Ni > System.currentTimeMillis();
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.LauncherUI", "checkDBSize isTimeOut %b ", Boolean.valueOf(z));
                if (z) {
                    aVar2 = new h.a(bzo);
                    aVar2.wm(2131231922);
                    aVar2.Oq(bzo.getString(2131231921));
                    aVar2.jk(false);
                    aVar2.wp(2131231918).a(new OnClickListener(launcherUI) {
                        final /* synthetic */ LauncherUI nCs;

                        {
                            this.nCs = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    aVar2.RX().show();
                }
                com.tencent.mm.l.a.b(bzo, System.currentTimeMillis());
            } else if (tX == 2) {
                ak.hold();
                aVar2 = new h.a(bzo);
                aVar2.wm(2131231920);
                aVar2.Oq(bzo.getString(2131231919));
                aVar2.jk(false);
                aVar2.wp(2131231917).a(new OnClickListener(launcherUI) {
                    final /* synthetic */ LauncherUI nCs;

                    {
                        this.nCs = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ak.fH(SQLiteDatabase.KeyEmpty);
                        MMAppMgr.iX(true);
                    }
                });
                aVar2.RX().show();
                com.tencent.mm.l.a.b(bzo, System.currentTimeMillis());
                g.iuh.a(282, 2, 1, false);
            }
        }
        if (bzo().getIntent().getBooleanExtra("resend_fail_messages", false)) {
            ad.g(new Runnable(this) {
                final /* synthetic */ d oMF;

                {
                    this.oMF = r1;
                }

                public final void run() {
                    com.tencent.mm.ui.base.g.b(this.oMF.bzo(), this.oMF.getString(2131234092), SQLiteDatabase.KeyEmpty, this.oMF.getString(2131234093), this.oMF.getString(2131231010), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass43 oMT;

                        {
                            this.oMT = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.c.a.nhr.z(new ln());
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass43 oMT;

                        {
                            this.oMT = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.c.a.nhr.z(new jc());
                        }
                    });
                }
            }, 500);
            bzo().getIntent().putExtra("resend_fail_messages", false);
        }
        launcherUI = (LauncherUI) this.nDR.nEl;
        if (launcherUI != null) {
            launcherUI.P(this.oEz);
        }
        bIv();
    }

    private void av() {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "KEVIN setShowTitle: " + (System.currentTimeMillis() - System.currentTimeMillis()));
        ad.o(new Runnable(this) {
            final /* synthetic */ d oMF;

            {
                this.oMF = r1;
            }

            public final void run() {
                com.tencent.mm.sdk.c.b flVar = new fl();
                flVar.beP.data = "MAIN_UI_EVENT_UPDATE_VIEW";
                com.tencent.mm.sdk.c.a.nhr.z(flVar);
            }
        });
        bIw();
    }

    protected final void byu() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "on tab start");
        av();
    }

    protected final void byv() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "on tab pause");
        if (this.oMb != null) {
            this.oMb.Uk();
        }
        if (this.wakeLock.isHeld()) {
            com.tencent.mm.sdk.platformtools.v.w("MicroMsg.MainUI", "onTabPause wakelock.release!");
            this.wakeLock.release();
        }
        if (ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.vf().b(this);
            com.tencent.mm.sdk.platformtools.v.v("MicroMsg.MainUI", "on pause");
        }
        ale();
        if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
            com.tencent.mm.pluginsdk.j.a.lxG.b(this);
        }
        if (ak.uz()) {
            com.tencent.mm.u.n.AX().e(this);
        }
        bIz();
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.INIT", "KEVIN mainui onTabPause  ");
        e.bIB();
        LauncherUI launcherUI = (LauncherUI) this.nDR.nEl;
        if (launcherUI != null) {
            launcherUI.Q(this.oEz);
        }
    }

    protected final void byw() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "on tab stop");
    }

    protected final void byx() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", Boolean.valueOf(ak.uz()));
        if (this.oMb != null) {
            this.oMb.Uk();
            this.oMb = null;
        }
        if (this.oMf != null && ak.uz()) {
            com.tencent.mm.as.k.KV().a(this.oMf);
            this.oMf = null;
        }
        if (this.oMc != null) {
            this.oMc.destroy();
            this.oMc = null;
        }
        if (this.oMa != null) {
            this.oMa.destroy();
            this.oMa = null;
        }
        ak.vy().b(-1, (e) this);
        if (ak.uz()) {
            ak.yW();
            com.tencent.mm.model.c.b(this);
            if (this.oLX != null) {
                ak.yW();
                com.tencent.mm.model.c.wK().b(this.oLX);
                ak.yW();
                com.tencent.mm.model.c.wH().b(this.oLX);
            }
        }
        if (this.oLX != null) {
            b bVar = this.oLX;
            if (bVar.oKl != null) {
                com.tencent.mm.sdk.c.a.nhr.f(bVar.oKl);
                bVar.oKl = null;
            }
            this.oLX.oLc = null;
            com.tencent.mm.ui.e eVar = this.oLX;
            eVar.oLc = null;
            if (eVar.ohm != null) {
                eVar.ohm.clear();
                eVar.ohm = null;
            }
            eVar.iJ(true);
            eVar.byT();
        }
        if (this.faM != null) {
            com.tencent.mm.sdk.c.a.nhr.f(this.faM);
            this.faM = null;
        }
        if (ak.uz()) {
            t.Nk();
        }
        if (com.tencent.mm.pluginsdk.j.a.lxG != null) {
            com.tencent.mm.pluginsdk.j.a.lxG.b(this);
        }
        ak.b(this.ixZ);
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.dHB);
        com.tencent.mm.sdk.c.a.nhr.f(this.oMB);
        com.tencent.mm.sdk.c.a.nhr.f(this.oMq);
        com.tencent.mm.sdk.c.a.nhr.f(this.oMr);
        com.tencent.mm.sdk.c.a.nhr.f(this.oMs);
        if (this.oMt != null) {
            this.oMt.removeCallbacksAndMessages(null);
            this.oMt = null;
        }
    }

    public final void byz() {
        if (this.oMm != null) {
            this.oMm.nQk = null;
        }
        if (this.oLY != null) {
            com.tencent.mm.ui.d.m mVar = this.oLY;
            mVar.edj.setBackgroundResource(0);
            mVar.eZn.setImageResource(0);
            mVar.nRq.setImageResource(0);
            mVar.nRr.setImageResource(0);
            mVar.nRp.setImageDrawable(null);
        }
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.INIT", "KEVIN mainui turnTobg");
    }

    public final void byA() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.MainUI", "turn to fg");
        if (this.oMm != null) {
            com.tencent.mm.ui.d.a aVar = this.oMm;
            aVar.nQk = new com.tencent.mm.ui.d.b((Context) aVar.lKT.get());
        }
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.INIT", "KEVIN mainui turnToFg");
    }

    public final void byy() {
        BackwardSupportUtil.c.a(this.oLV);
    }

    public final void bzm() {
        String str = "MicroMsg.MainUI";
        String str2 = "dkinit onTabSwitchIn tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = this.dwR == null ? -1 : this.dwR.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(this.oMn == null ? -2 : this.oMn.hashCode());
        com.tencent.mm.sdk.platformtools.v.i(str, str2, objArr);
        if (this.wakeLock != null) {
            bIt();
        }
        if (this.nDR != null) {
            this.nDR.onResume();
        }
    }

    public final void ml(String str) {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.MainUI", "onSearchChange");
        String lZ = t.lZ(str);
        this.gYJ = true;
        if (str.compareTo(SQLiteDatabase.KeyEmpty) == 0) {
            this.oMj = true;
        }
        this.oMt.removeMessages(4660);
        if (this.oMj) {
            b bVar = this.oLX;
            bVar.dwS = SQLiteDatabase.KeyEmpty.trim();
            if (bVar.dwS == null || bVar.dwS.length() <= 0) {
                bVar.gYJ = false;
            } else {
                bVar.gYJ = true;
            }
            bVar.o(null, 1);
            return;
        }
        this.oMt.sendMessageDelayed(this.oMt.obtainMessage(4660, lZ), 300);
    }

    public final void Of() {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.MainUI", "onQuitSearch");
        this.oMk = true;
        ml(SQLiteDatabase.KeyEmpty);
        LauncherUI launcherUI = (LauncherUI) this.nDR.nEl;
        if (launcherUI != null) {
            launcherUI.iO(true);
        }
        if (this.oDZ != null) {
            this.oDZ.setVisibility(8);
        }
        if (this.oLY != null) {
            this.oLY.agO();
        }
        bIx();
    }

    public final void Og() {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.MainUI", "onEnterSearch");
        g.iuh.Y(10919, "2");
        if (this.oLY != null) {
            this.oLY.setVisibility(8);
        }
        if (this.oMa != null) {
            this.oMa.setVisibility(8);
        }
        if (this.oMd != null) {
            this.oMd.setVisibility(8);
        }
        LauncherUI launcherUI = (LauncherUI) this.nDR.nEl;
        if (launcherUI != null) {
            launcherUI.iO(false);
        }
        if (this.oDZ != null) {
            this.oDZ.setVisibility(0);
        }
    }

    public final void Yt() {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.MainUI", "onVoiceSearchStart");
        ale();
    }

    public final void Yu() {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.MainUI", "onVoiceSearchCancel");
    }

    public final void a(boolean z, String[] strArr, long j, int i) {
        com.tencent.mm.sdk.platformtools.v.v("MicroMsg.MainUI", "onVoiceReturn");
        if (z) {
            Intent intent = new Intent(this.nDR.nEl, VoiceSearchResultUI.class);
            intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
            intent.putExtra("VoiceSearchResultUI_VoiceId", j);
            intent.putExtra("VoiceSearchResultUI_ShowType", i);
            this.nDR.nEl.startActivity(intent);
            return;
        }
        intent = new Intent(this.nDR.nEl, VoiceSearchResultUI.class);
        intent.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
        intent.putExtra("VoiceSearchResultUI_Error", this.nDR.nEl.getString(2131232875));
        intent.putExtra("VoiceSearchResultUI_VoiceId", j);
        intent.putExtra("VoiceSearchResultUI_ShowType", i);
        this.nDR.nEl.startActivity(intent);
    }

    public final boolean mk(String str) {
        return false;
    }

    public final void hY(boolean z) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "visible " + z);
        if (z) {
            int firstVisiblePosition = this.oLV.getFirstVisiblePosition();
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.MainUI", "getFirstVisiblePosition  " + firstVisiblePosition);
            if (firstVisiblePosition > 0) {
                this.oLV.post(new Runnable(this) {
                    final /* synthetic */ d oMF;

                    {
                        this.oMF = r1;
                    }

                    public final void run() {
                        this.oMF.oLV.setSelection(0);
                    }
                });
            }
        }
    }

    public final void onDestroy() {
        bIr();
        super.onDestroy();
    }
}
