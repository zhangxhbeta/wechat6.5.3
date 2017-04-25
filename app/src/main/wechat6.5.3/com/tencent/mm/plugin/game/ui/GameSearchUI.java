package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.aj;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.ui.r.c;
import com.tencent.mm.plugin.game.ui.s.a;
import com.tencent.mm.protocal.c.rd;
import com.tencent.mm.protocal.c.rf;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.protocal.c.rj;
import com.tencent.mm.protocal.c.rk;
import com.tencent.mm.protocal.c.rl;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class GameSearchUI extends MMActivity implements b, e {
    private static final Pattern cVE = Pattern.compile("\\s+");
    private p eSv;
    private ProgressBar elJ;
    private int fromScene;
    private ViewGroup gxR;
    private TextView gxS;
    private ListView gxT;
    private ListView gxU;
    private r gxV;
    private s gxW;
    private String gxX;
    private String gxY;
    private k gxZ;
    private k gya;
    private boolean gyb = false;
    private OnItemClickListener gyc = new OnItemClickListener(this) {
        final /* synthetic */ GameSearchUI gye;

        {
            this.gye = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            r c = this.gye.gxV;
            c cVar = (i < 0 || i >= c.getCount()) ? null : ((r.b) c.getItem(i)).gxH;
            if (cVar != null) {
                Map hashMap;
                if (cVar.actionType == 1 && !be.kS(cVar.appId)) {
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", cVar.appId);
                    bundle.putInt("game_report_from_scene", cVar.bmG);
                    int a = com.tencent.mm.plugin.game.e.c.a(this.gye, cVar.appId, null, bundle);
                    hashMap = new HashMap();
                    hashMap.put("function_type", "search");
                    hashMap.put("funtion_value", cVar.gxJ);
                    hashMap.put("keyword", this.gye.gxX);
                    af.a(this.gye, 14, cVar.bmG, cVar.position, a, cVar.appId, this.gye.fromScene, af.s(hashMap));
                } else if (cVar.actionType == 2 && !be.kS(cVar.gxI)) {
                    com.tencent.mm.plugin.game.e.c.n(this.gye, cVar.gxI, "game_center_detail");
                    hashMap = new HashMap();
                    hashMap.put("function_type", "search");
                    hashMap.put("funtion_value", cVar.gxJ);
                    hashMap.put("keyword", this.gye.gxX);
                    af.a(this.gye, 14, cVar.bmG, cVar.position, 7, 0, cVar.appId, this.gye.fromScene, cVar.gxD, String.valueOf(cVar.gxE), null, af.s(hashMap));
                }
            }
        }
    };
    private OnItemClickListener gyd = new OnItemClickListener(this) {
        final /* synthetic */ GameSearchUI gye;

        {
            this.gye = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            a lE = ((s) adapterView.getAdapter()).lE(i);
            if (!be.kS(lE.text)) {
                if (be.kS(lE.appId)) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(lE.text);
                    this.gye.c(linkedList, 2);
                    this.gye.lF(1);
                    return;
                }
                switch (lE.actionType) {
                    case 1:
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", lE.appId);
                        bundle.putInt("game_report_from_scene", 1402);
                        int a = com.tencent.mm.plugin.game.e.c.a(this.gye, lE.appId, null, bundle);
                        af.a(this.gye, 14, 1402, i, a, lE.appId, this.gye.fromScene, null);
                        return;
                    case 2:
                        com.tencent.mm.plugin.game.e.c.n(this.gye.nDR.nEl, lE.gxK, "game_center_detail");
                        af.a(this.gye, 14, 1402, i, 7, lE.appId, this.gye.fromScene, null);
                        return;
                    default:
                        v.e("MicroMsg.GameSearchUI", "unknowed actionType : " + lE.actionType);
                        return;
                }
            }
        }
    };

    public final void Oh() {
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        if (ak.uz()) {
            ak.vy().a(1328, this);
            ak.vy().a(1329, this);
            this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
            NI();
            af.a((Context) this, 14, 1401, 0, 2, this.fromScene, null);
            v.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        v.e("MicroMsg.GameSearchUI", "account not ready");
        finish();
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameSearchUI gye;

            {
                this.gye = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gye.onBackPressed();
                return true;
            }
        });
        this.eSv = new p();
        this.eSv.kj(true);
        this.eSv.oUs = this;
        this.gxR = (ViewGroup) findViewById(2131756019);
        this.elJ = (ProgressBar) findViewById(2131757380);
        this.gxS = (TextView) findViewById(2131755704);
        this.gxT = (ListView) findViewById(2131757378);
        this.gxV = new r(this);
        this.gxT.setAdapter(this.gxV);
        this.gxT.setOnItemClickListener(this.gyc);
        this.gxT.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ GameSearchUI gye;

            {
                this.gye = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.gye.gxT.clearFocus();
                this.gye.axg();
                return false;
            }
        });
        this.gxU = (ListView) findViewById(2131757379);
        this.gxW = new s(this);
        this.gxU.setAdapter(this.gxW);
        this.gxU.setOnItemClickListener(this.gyd);
        this.gxU.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ GameSearchUI gye;

            {
                this.gye = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.gye.gxU.clearFocus();
                this.gye.axg();
                return false;
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.eSv.a(this, menu);
        this.eSv.setHint(au.asa());
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.eSv.a(this, menu);
        return true;
    }

    protected final int getLayoutId() {
        return 2130903757;
    }

    private void lF(int i) {
        switch (i) {
            case 0:
                this.gxR.setVisibility(8);
                this.gxS.setVisibility(8);
                this.gxT.setVisibility(8);
                this.gxU.setVisibility(8);
                this.elJ.setVisibility(8);
                return;
            case 1:
                axg();
                this.eSv.clearFocus();
                this.gxR.setVisibility(8);
                this.gxS.setVisibility(8);
                this.gxT.setVisibility(8);
                this.gxU.setVisibility(8);
                this.elJ.setVisibility(0);
                return;
            case 2:
                this.gxR.setVisibility(8);
                if (this.gxV.getCount() > 0) {
                    this.gxS.setVisibility(8);
                    this.gxT.setVisibility(0);
                } else {
                    this.gxS.setVisibility(0);
                    this.gxT.setVisibility(8);
                }
                this.gxU.setVisibility(8);
                this.elJ.setVisibility(8);
                return;
            case 3:
                this.gxR.setVisibility(0);
                this.gxS.setVisibility(8);
                this.gxT.setVisibility(8);
                this.gxU.setVisibility(8);
                this.elJ.setVisibility(8);
                return;
            case 4:
                this.gxR.setVisibility(8);
                this.gxS.setVisibility(0);
                this.gxT.setVisibility(8);
                this.gxU.setVisibility(8);
                this.elJ.setVisibility(8);
                return;
            case 5:
                this.gxR.setVisibility(8);
                this.gxS.setVisibility(8);
                this.gxT.setVisibility(8);
                this.gxU.setVisibility(0);
                this.elJ.setVisibility(8);
                return;
            case 6:
                this.gxR.setVisibility(8);
                this.gxS.setVisibility(8);
                this.gxT.setVisibility(8);
                this.gxU.setVisibility(8);
                this.elJ.setVisibility(0);
                return;
            default:
                return;
        }
    }

    private void c(LinkedList<String> linkedList, int i) {
        if (this.gya != null) {
            ak.vy().c(this.gya);
        }
        if (this.gxZ != null) {
            ak.vy().c(this.gxZ);
        }
        ak.vy().a(new aj(u.bsY(), linkedList, com.tencent.mm.plugin.game.c.e.arh()), 0);
        Iterator it = linkedList.iterator();
        this.gxX = "";
        while (it.hasNext()) {
            this.gxX += " " + ((String) it.next());
        }
        this.gxX = this.gxX.trim();
        if (i == 1 || i == 2) {
            this.gyb = true;
            this.eSv.Pw(this.gxX);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!kVar.czH) {
            switch (kVar.getType()) {
                case 1328:
                    if (i == 0 && i2 == 0) {
                        ri riVar = (ri) ((aj) kVar).fut.czl.czs;
                        LinkedList linkedList = riVar != null ? riVar.mvf : null;
                        if (linkedList != null) {
                            r.b m;
                            this.gxY = this.gxX;
                            r rVar = this.gxV;
                            String str2 = this.gxY;
                            if (rVar.eUn == null) {
                                rVar.eUn = new ArrayList();
                            }
                            rVar.gur = 0;
                            rVar.gxg = 0;
                            rVar.gxh = 0;
                            rVar.gxi = 0;
                            rVar.gxj = 0;
                            rVar.aWL = false;
                            rVar.gxf = false;
                            rVar.eUn.clear();
                            rVar.gxl = false;
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                rj rjVar = (rj) it.next();
                                int i3 = 0;
                                Object obj = (rjVar.mvg == null || rjVar.mvg.size() == 0) ? 1 : null;
                                Object obj2 = (rjVar.mvh == null || rjVar.mvh.size() == 0) ? 1 : null;
                                Object obj3 = (rjVar.mvk == null || rjVar.mvk.size() == 0) ? 1 : null;
                                obj = (obj == null || obj2 == null || obj3 == null) ? null : 1;
                                if (obj == null) {
                                    Iterator it2;
                                    r.b bVar;
                                    c cVar;
                                    int i4;
                                    rVar.eUn.add(r.b.R(0, rjVar.aXz));
                                    if (!rVar.gxl) {
                                        ((r.b) rVar.eUn.get(rVar.eUn.size() - 1)).gxF = true;
                                        rVar.gxl = true;
                                    }
                                    if (rjVar.type == 4 && rjVar.mvk != null) {
                                        it2 = rjVar.mvk.iterator();
                                        while (it2.hasNext()) {
                                            rk rkVar = (rk) it2.next();
                                            bVar = new r.b();
                                            bVar.type = 3;
                                            bVar.appId = rkVar.mvl.glj;
                                            bVar.name = rkVar.mvl.gkB;
                                            bVar.gxy = rkVar.mvl.mnX;
                                            bVar.iconUrl = rkVar.mvl.gnp;
                                            bVar.gxz = rkVar.mvl.gkD;
                                            bVar.gxA = rkVar.mvl.muT;
                                            bVar.actionType = rkVar.mvl.muU;
                                            bVar.gxB = rkVar.mvl.muV;
                                            bVar.gxC = rkVar.mvm;
                                            bVar.gxH = new c(rkVar.mvl.muU, 4, rkVar.mvl.glj, rkVar.mvl.muV);
                                            bVar.aXp = str2;
                                            bVar.gxH.gxJ = "3";
                                            cVar = bVar.gxH;
                                            i4 = rVar.gxh;
                                            rVar.gxh = i4 + 1;
                                            cVar.position = i4 + 601;
                                            rVar.eUn.add(bVar);
                                        }
                                    }
                                    if ((rjVar.type == 1 || rjVar.type == 2) && rjVar.mvg != null) {
                                        it2 = rjVar.mvg.iterator();
                                        while (it2.hasNext()) {
                                            rd rdVar = (rd) it2.next();
                                            bVar = new r.b();
                                            bVar.type = 1;
                                            bVar.appId = rdVar.glj;
                                            bVar.name = rdVar.gkB;
                                            bVar.gxy = rdVar.mnX;
                                            bVar.iconUrl = rdVar.gnp;
                                            bVar.gxz = rdVar.gkD;
                                            bVar.gxA = rdVar.muT;
                                            bVar.actionType = rdVar.muU;
                                            bVar.gxB = rdVar.muV;
                                            bVar.gxH = new c(rdVar.muU, 1, rdVar.glj, rdVar.muV);
                                            bVar.aXp = str2;
                                            if (rjVar.type == 1) {
                                                rVar.aWL = true;
                                                cVar = bVar.gxH;
                                                i4 = rVar.gur;
                                                rVar.gur = i4 + 1;
                                                cVar.position = i4 + 1;
                                            } else if (rjVar.type == 2) {
                                                rVar.gxf = true;
                                                cVar = bVar.gxH;
                                                i4 = rVar.gxg;
                                                rVar.gxg = i4 + 1;
                                                cVar.position = i4 + 1;
                                            }
                                            bVar.gxH.gxJ = "1";
                                            rVar.eUn.add(bVar);
                                        }
                                    } else if (rjVar.type == 3 && rjVar.mvh != null) {
                                        it2 = rjVar.mvh.iterator();
                                        int i5 = 0;
                                        while (it2.hasNext()) {
                                            rl rlVar = (rl) it2.next();
                                            r.b bVar2 = new r.b();
                                            bVar2.type = 2;
                                            bVar2.name = rlVar.aXz;
                                            bVar2.gxy = rlVar.gkC;
                                            bVar2.iconUrl = rlVar.hOx;
                                            bVar2.gxB = rlVar.muV;
                                            bVar2.gxD = rlVar.mvn;
                                            bVar2.gxE = rlVar.mvo;
                                            bVar2.appId = rlVar.glj;
                                            bVar2.cuQ = rlVar.hNZ;
                                            bVar2.dhH = (long) rlVar.mkB;
                                            bVar2.gxH = new c(rlVar.muV, (byte) 0);
                                            bVar2.aXp = str2;
                                            bVar2.gxH.appId = bVar2.appId;
                                            bVar2.gxH.gxD = bVar2.gxD;
                                            bVar2.gxH.gxE = bVar2.gxE;
                                            bVar2.gxH.gxJ = "2";
                                            cVar = bVar2.gxH;
                                            int i6 = rVar.gxi;
                                            rVar.gxi = i6 + 1;
                                            cVar.position = i6 + 301;
                                            rVar.eUn.add(bVar2);
                                            i5 = bVar2.gxD;
                                        }
                                        i3 = i5;
                                    }
                                    if (!(be.kS(rjVar.mvi) || be.kS(rjVar.mvj))) {
                                        if (rjVar.type == 3) {
                                            r.b m2 = r.b.m(4, rjVar.mvi, rjVar.mvj);
                                            m2.gxH.appId = "wx62d9035fd4fd2059";
                                            m2.gxH.gxJ = "2";
                                            m2.gxH.position = 600;
                                            m2.gxH.gxD = i3;
                                            rVar.eUn.add(m2);
                                        }
                                        if (rjVar.type == 1) {
                                            m = r.b.m(5, rjVar.mvi, rjVar.mvj);
                                            m.gxH.appId = "wx62d9035fd4fd2059";
                                            m.gxH.gxJ = "1";
                                            m.gxH.position = 300;
                                            rVar.eUn.add(m);
                                        }
                                    }
                                } else if (rjVar.type == 1) {
                                    rVar.eUn.add(r.b.R(6, !be.kS(str2) ? rVar.context.getString(2131233128, new Object[]{str2}) : rVar.context.getString(2131233127)));
                                    rVar.gxl = true;
                                }
                            }
                            Iterator it3 = rVar.eUn.iterator();
                            while (it3.hasNext()) {
                                m = (r.b) it3.next();
                                if (rVar.aWL) {
                                    m.gxH.bmG = 1403;
                                } else if (rVar.gxf) {
                                    m.gxH.bmG = 1404;
                                } else {
                                    m.gxH.bmG = 1405;
                                }
                            }
                            rVar.notifyDataSetChanged();
                        }
                    }
                    lF(2);
                    return;
                case 1329:
                    if (i == 0 && i2 == 0) {
                        this.gxW.a(((com.tencent.mm.plugin.game.c.ak) kVar).aXp, ((rf) ((com.tencent.mm.plugin.game.c.ak) kVar).fut.czl.czs).aXz, ((rf) ((com.tencent.mm.plugin.game.c.ak) kVar).fut.czl.czs).mvc);
                        lF(5);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void onDestroy() {
        v.i("MicroMsg.GameSearchUI", "onDestroy");
        super.onDestroy();
        ak.vy().b(1328, this);
        ak.vy().b(1329, this);
    }

    public final void Og() {
    }

    public final void Of() {
        axg();
        onBackPressed();
    }

    public final void ml(String str) {
        if (this.gyb) {
            this.gyb = false;
        } else if (be.kS(str)) {
            if (this.gya != null) {
                ak.vy().c(this.gya);
            }
            if (this.gxZ != null) {
                ak.vy().c(this.gxZ);
            }
            ak.vy().a(new com.tencent.mm.plugin.game.c.ak(u.bsY(), str, com.tencent.mm.plugin.game.c.e.arh()), 0);
        } else {
            LinkedList linkedList = new LinkedList();
            String[] split = cVE.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            c(linkedList, 0);
            lF(6);
        }
    }

    public final boolean mk(String str) {
        if (!be.kS(str)) {
            LinkedList linkedList = new LinkedList();
            String[] split = cVE.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            c(linkedList, 0);
            lF(1);
        }
        return true;
    }
}
