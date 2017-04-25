package com.tencent.mm.plugin.backup.moveui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.e.b.af;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.b.a;
import com.tencent.mm.plugin.backup.g.y;
import com.tencent.mm.plugin.backup.movemodel.b.AnonymousClass4;
import com.tencent.mm.plugin.backup.movemodel.b.c;
import com.tencent.mm.plugin.backup.movemodel.g;
import com.tencent.mm.plugin.backup.moveui.BakMoveChooseUI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class BakMoveChooseUI extends MMActivity implements c {
    public static boolean edp = false;
    public static boolean elR = false;
    private ProgressBar edA;
    private TextView edB;
    private View edu;
    private TextView edv;
    private CheckBox edw;
    private TextView edx;
    private TextView edy;
    private Button edz;
    private a elO;
    private ListView elP;
    private View elQ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131231271);
        this.elP = (ListView) findViewById(2131755520);
        this.elQ = q.em(this).inflate(2130903148, null);
        this.elP.addFooterView(this.elQ);
        this.elO = new a(this);
        this.elP.setAdapter(this.elO);
        this.elP.setEmptyView(findViewById(2131755521));
        this.edu = findViewById(2131755528);
        this.edv = (TextView) findViewById(2131755524);
        this.edw = (CheckBox) findViewById(2131755526);
        this.edx = (TextView) findViewById(2131755527);
        this.edy = (TextView) findViewById(2131755442);
        this.edA = (ProgressBar) findViewById(2131755522);
        this.edz = (Button) findViewById(2131755525);
        this.edB = (TextView) findViewById(2131755523);
        g UR = b.UR();
        if (UR.ekY != null) {
            UR.ekY.QI();
        }
        b.UR();
        if (!g.Wk()) {
            UR = b.UR();
            elR = true;
            b.a(new a(UR) {
                final /* synthetic */ g ekZ;

                {
                    this.ekZ = r1;
                }

                public final void run() {
                    BakMoveChooseUI.elR = false;
                    if (this.eiS) {
                        e.a(new Runnable(this.ekZ) {
                            final /* synthetic */ g ekZ;

                            {
                                this.ekZ = r1;
                            }

                            public final void run() {
                                if (this.ekZ.egg != null) {
                                    this.ekZ.egg.cAv = true;
                                }
                                this.ekZ.egg = new b(null, this.ekZ);
                                b b = this.ekZ.egg;
                                PLong pLong = new PLong();
                                PInt pInt = new PInt();
                                b.ekr = new ArrayList();
                                y yVar = new y();
                                yVar.begin();
                                long currentTimeMillis = System.currentTimeMillis();
                                b.efQ = g.Wi();
                                if (b.efQ == null) {
                                    b.efQ = new LinkedList();
                                    Cursor b2 = b.Vd().wK().b(m.crA, com.tencent.mm.plugin.backup.g.g.Vw(), "*");
                                    if (b2.getCount() == 0) {
                                        if (b.ekp != null) {
                                            b.handler.post(new Runnable(b) {
                                                final /* synthetic */ b ekt;

                                                {
                                                    this.ekt = r1;
                                                }

                                                public final void run() {
                                                    this.ekt.ekp.p(this.ekt.ekr);
                                                }
                                            });
                                        }
                                        v.i("MicroMsg.BakCalculatorMove", "empty conversation!");
                                        b2.close();
                                        yVar.end();
                                        return;
                                    }
                                    b2.moveToFirst();
                                    v.i("MicroMsg.BakCalculatorMove", "calcItemsToChoose userCnt at conv:%d", Integer.valueOf(b2.getCount()));
                                    while (!b.cAv) {
                                        af abVar = new ab();
                                        abVar.b(b2);
                                        if (!be.kS(abVar.field_username)) {
                                            v.i("MicroMsg.BakCalculatorMove", "calcItemsToChoose user:%s msgCnt:%d", abVar.field_username, Integer.valueOf(b.Vd().wJ().MW(abVar.field_username)));
                                            if (b.Vd().wJ().MW(abVar.field_username) > 0) {
                                                ak.yW();
                                                if (!u.vd(com.tencent.mm.model.c.wH().LX(abVar.field_username).field_verifyFlag)) {
                                                    b.efQ.add(abVar.field_username);
                                                }
                                            }
                                        }
                                        if (!b2.moveToNext()) {
                                            b2.close();
                                            g.Y(b.efQ);
                                        }
                                    }
                                    b2.close();
                                    return;
                                }
                                String str = (String) b.Vd().vf().get(2, null);
                                long size = (long) b.efQ.size();
                                PLong pLong2 = new PLong();
                                if (g.Wj() == null) {
                                    for (String a : b.efQ) {
                                        if (b.a(pLong, pInt, str, size, pLong2, a)) {
                                            return;
                                        }
                                    }
                                } else {
                                    pLong2.value = (long) g.Wj().size();
                                    if (b.ekp != null) {
                                        b.handler.post(new AnonymousClass4(b, pLong2.value, size));
                                    }
                                    for (String a2 : b.efQ) {
                                        Object obj;
                                        Iterator it = g.Wj().iterator();
                                        while (it.hasNext()) {
                                            a aVar = (a) it.next();
                                            if (aVar.username.equals(a2)) {
                                                b.ekr.add(aVar.Wg());
                                                obj = 1;
                                                break;
                                            }
                                        }
                                        obj = null;
                                        if (obj == null) {
                                            if (b.a(pLong, pInt, str, size, pLong2, a2)) {
                                                return;
                                            }
                                        }
                                    }
                                }
                                v.i("MicroMsg.BakCalculatorMove", "calcItemsToChoose all, userSize:%d", Integer.valueOf(b.ekr.size()));
                                if (!(1 == b.eak || 2 != b.eak || b.ekp == null)) {
                                    b.handler.post(new Runnable(b) {
                                        final /* synthetic */ b ekt;

                                        {
                                            this.ekt = r1;
                                        }

                                        public final void run() {
                                            this.ekt.ekp.p(this.ekt.ekr);
                                        }
                                    });
                                }
                                yVar.end();
                                v.d("MicroMsg.BakCalculatorMove", "calcItemsToChoose loading time:" + (System.currentTimeMillis() - currentTimeMillis));
                            }
                        }, "BakMoveChooseServer.calculateToChoose");
                    } else {
                        v.e("MicroMsg.BakMoveChooseServer", "init TempDB error");
                    }
                }
            }, false);
        }
        if (!com.tencent.mm.sdk.platformtools.u.bsU()) {
            this.edv.setTextSize(1, 14.0f);
            this.edx.setTextSize(1, 14.0f);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BakMoveChooseUI elS;

            {
                this.elS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!BakMoveChooseUI.elR) {
                    this.elS.finish();
                }
                return false;
            }
        });
        this.edz.setEnabled(false);
        this.edz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakMoveChooseUI elS;

            {
                this.elS = r1;
            }

            public final void onClick(View view) {
                ArrayList arrayList;
                PLong pLong = new PLong();
                PInt pInt = new PInt();
                a a = this.elS.elO;
                if (a.edo.size() <= 0) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    pLong.value = 0;
                    pInt.value = 0;
                    ArrayList Tu = g.Tu();
                    if (Tu != null) {
                        for (int i = 0; i < a.getCount(); i++) {
                            if (a.edo.contains(Integer.valueOf(i))) {
                                arrayList2.add(((com.tencent.mm.plugin.backup.movemodel.a) Tu.get(i)).username);
                                pLong.value += ((com.tencent.mm.plugin.backup.movemodel.a) Tu.get(i)).beE;
                                pInt.value = (int) (((long) pInt.value) + ((com.tencent.mm.plugin.backup.movemodel.a) Tu.get(i)).dnm);
                            }
                        }
                    }
                    v.i("MicroMsg.BakMoveChooseAdapter", "finishSelected usernameSize:%d, addupSize:%d, count:%d", Integer.valueOf(arrayList2.size()), Long.valueOf(pLong.value), Integer.valueOf(pInt.value));
                    arrayList = arrayList2;
                }
                Intent intent = new Intent(this.elS, BakMoveWaitUI.class);
                intent.putStringArrayListExtra("selected_records_username", arrayList);
                intent.putExtra("selected_records_addupsize", pLong.value);
                intent.putExtra("selected_records_count", pInt.value);
                if (BakMoveChooseUI.edp) {
                    com.tencent.mm.plugin.report.service.g.iuh.a(103, 13, 1, false);
                }
                com.tencent.mm.plugin.report.service.g.iuh.a(103, 12, 1, false);
                this.elS.startActivity(intent);
            }
        });
        this.edu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BakMoveChooseUI elS;

            {
                this.elS = r1;
            }

            public final void onClick(View view) {
                int i = 0;
                if (g.Wk()) {
                    a a = this.elS.elO;
                    if (a.edo.size() == a.getCount()) {
                        a.edo.clear();
                        BakMoveChooseUI.edp = false;
                    } else {
                        while (i < a.getCount()) {
                            a.edo.add(Integer.valueOf(i));
                            i++;
                        }
                        BakMoveChooseUI.edp = true;
                    }
                    a.notifyDataSetChanged();
                    a.elM.a(a.edo);
                }
            }
        });
        b.UR().ekX = this;
        if (g.Wk()) {
            if (g.Tu().size() == 0) {
                this.edy.setVisibility(0);
            }
            this.elP.removeFooterView(this.elQ);
            this.edB.setVisibility(8);
            this.edv.setVisibility(0);
            return;
        }
        this.edw.setClickable(false);
        this.edv.setVisibility(8);
        if (g.Tu().size() == 0) {
            this.edA.setVisibility(0);
            this.edB.setVisibility(8);
            return;
        }
        this.edA.setVisibility(4);
        this.edB.setVisibility(0);
    }

    public final void a(HashSet<Integer> hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < g.Tu().size()) {
                j = ((com.tencent.mm.plugin.backup.movemodel.a) g.Tu().get(intValue)).beE + j;
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || j > 0) {
            this.edv.setVisibility(0);
            this.edv.setText(getString(2131231270, new Object[]{be.aw(j)}));
            this.edz.setEnabled(true);
            if (g.Wk() && hashSet.size() == this.elO.getCount()) {
                this.edw.setChecked(true);
                return;
            } else {
                this.edw.setChecked(false);
                return;
            }
        }
        this.edv.setVisibility(8);
        this.edv.setText(SQLiteDatabase.KeyEmpty);
        this.edz.setEnabled(false);
        this.edw.setChecked(false);
    }

    protected final int getLayoutId() {
        return 2130903151;
    }

    public final void a(long j, long j2, ArrayList<com.tencent.mm.plugin.backup.movemodel.a> arrayList, boolean z) {
        this.edB.setVisibility(0);
        this.edB.setText("加载中...(" + j + "/" + j2 + ")");
        if (z) {
            this.edA.setVisibility(4);
            this.elO.notifyDataSetChanged();
        }
    }

    public final void p(ArrayList<com.tencent.mm.plugin.backup.movemodel.a> arrayList) {
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                this.edA.setVisibility(8);
                this.edy.setVisibility(0);
                return;
            }
            this.elO.notifyDataSetChanged();
            this.edw.setClickable(true);
            this.edA.setVisibility(4);
            this.edy.setVisibility(0);
            this.edB.setVisibility(8);
            this.elP.removeFooterView(this.elQ);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (!elR) {
            finish();
        }
        return true;
    }
}
