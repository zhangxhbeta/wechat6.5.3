package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.SensorController.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.g;
import com.tencent.mm.v.g.b;
import junit.framework.Assert;

public class MassSendHistoryUI extends MMActivity implements a, g.a, b {
    private static SensorController evt;
    private com.tencent.mm.c.a.a aSS;
    private boolean evw = true;
    private View gMz;
    private ListView hkg;
    private c hkh;
    private Button hki;
    private Button hkj;
    private MMPullDownView hkk;
    private boolean hkl = false;
    private LinearLayout hkm;
    private d hkn = new d(this) {
        final /* synthetic */ MassSendHistoryUI hko;

        {
            this.hko = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            if (menuItem.getItemId() == 1) {
                com.tencent.mm.plugin.masssend.a.a aVar = (com.tencent.mm.plugin.masssend.a.a) this.hko.hkh.getItem(menuItem.getGroupId());
                if (aVar != null) {
                    if (aVar.ayX().equals(this.hko.hkh.hjV)) {
                        this.hko.XV();
                    }
                    com.tencent.mm.plugin.masssend.a.b azf = h.azf();
                    String ayX = aVar.ayX();
                    Cursor rawQuery = azf.cuX.rawQuery("select * from massendinfo ORDER BY createtime DESC  limit 2", null);
                    if (rawQuery != null) {
                        if (rawQuery.getCount() == 0) {
                            rawQuery.close();
                        } else if (rawQuery.getCount() == 1) {
                            rawQuery.moveToFirst();
                            r3 = new com.tencent.mm.plugin.masssend.a.a();
                            r3.b(rawQuery);
                            rawQuery.close();
                            r2 = new ab();
                            r2.setUsername("masssendapp");
                            r2.setContent(aa.getContext().getResources().getString(2131232084));
                            r2.s(r3.dhH);
                            r2.di(0);
                            r2.df(0);
                            ak.yW();
                            c.wK().a(r2, "masssendapp", true);
                        } else {
                            rawQuery.moveToPosition(1);
                            r3 = new com.tencent.mm.plugin.masssend.a.a();
                            r3.b(rawQuery);
                            rawQuery.close();
                            r2 = new ab();
                            r2.setUsername("masssendapp");
                            r2.setContent(com.tencent.mm.plugin.masssend.a.b.a(r3));
                            r2.s(r3.dhH);
                            r2.di(0);
                            r2.df(0);
                            ak.yW();
                            c.wK().a(r2, "masssendapp", true);
                        }
                    }
                    if (azf.cuX.delete("massendinfo", "clientid= ?", new String[]{ayX}) > 0) {
                        azf.Ls();
                    }
                }
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131233815);
        if (evt == null) {
            evt = new SensorController(getApplicationContext());
        }
        NI();
        this.aSS = new com.tencent.mm.c.a.a(this);
        this.aSS.aTk = this;
        this.aSS.aTj = this;
        this.hkh.hjW = new e(this) {
            final /* synthetic */ MassSendHistoryUI hko;

            {
                this.hko = r1;
            }

            public final String wo(String str) {
                ak.yW();
                if (c.isSDCardAvailable()) {
                    String ma = be.ma(str);
                    if (!this.hko.aSS.isPlaying() || !ma.equals(this.hko.hkh.hjV)) {
                        return !this.hko.wp(ma) ? "" : ma;
                    } else {
                        MassSendHistoryUI.evt.btX();
                        this.hko.releaseWakeLock();
                        this.hko.aSS.stop();
                        return "";
                    }
                }
                s.ey(this.hko);
                return "";
            }
        };
    }

    protected void onResume() {
        super.onResume();
        h.azf().c(this.hkh);
        this.hkh.a(null, null);
        this.hkg.setSelection(this.hkh.getCount() - 1);
    }

    protected void onPause() {
        super.onPause();
        ak.yX().re();
        h.azf().d(this.hkh);
        evt.btX();
    }

    protected void onDestroy() {
        this.hkh.avc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903952;
    }

    protected final void NI() {
        this.hkl = getIntent().getBooleanExtra("finish_direct", false);
        v.d("MicroMsg.MassSendHistoryUI", "isFromSearch  " + this.hkl);
        this.hkm = (LinearLayout) findViewById(2131758160);
        this.hkg = (ListView) findViewById(2131758157);
        this.hkg.setTranscriptMode(0);
        this.hkk = (MMPullDownView) findViewById(2131758156);
        this.hkk.nWT = new MMPullDownView.g(this) {
            final /* synthetic */ MassSendHistoryUI hko;

            {
                this.hko = r1;
            }

            public final boolean azp() {
                int i = 0;
                if (this.hko.hkh.abO()) {
                    this.hko.hkg.setSelectionFromTop(0, this.hko.hkk.nWV);
                } else {
                    c b = this.hko.hkh;
                    if (!b.abO()) {
                        b.eKW += 10;
                        if (b.eKW <= b.emv) {
                            i = 10;
                        } else {
                            b.eKW = b.emv;
                            i = b.emv % 10;
                        }
                    }
                    v.v("MicroMsg.MassSendHistoryUI", "onLoadData add count:" + i);
                    this.hko.hkh.a(null, null);
                    this.hko.hkg.setSelectionFromTop(i, this.hko.hkk.nWV);
                }
                return true;
            }
        };
        this.hkk.jr(true);
        this.hkk.nXf = new MMPullDownView.c(this) {
            final /* synthetic */ MassSendHistoryUI hko;

            {
                this.hko = r1;
            }

            public final boolean agv() {
                if (this.hko.hkg.getChildAt(this.hko.hkg.getChildCount() - 1).getBottom() > this.hko.hkg.getHeight() || this.hko.hkg.getLastVisiblePosition() != this.hko.hkg.getAdapter().getCount() - 1) {
                    return false;
                }
                return true;
            }
        };
        this.hkk.nXg = new MMPullDownView.d(this) {
            final /* synthetic */ MassSendHistoryUI hko;

            {
                this.hko = r1;
            }

            public final boolean agu() {
                View childAt = this.hko.hkg.getChildAt(this.hko.hkg.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    return false;
                }
                return true;
            }
        };
        this.hkk.jp(true);
        this.hkh = new c(this);
        this.hkh.nDK = new j.a(this) {
            final /* synthetic */ MassSendHistoryUI hko;

            {
                this.hko = r1;
            }

            public final void Oi() {
                this.hko.hkk.jo(this.hko.hkh.abO());
                if (this.hko.hkh.getCount() == 0) {
                    this.hko.hkk.setVisibility(8);
                    this.hko.gMz.setVisibility(0);
                    this.hko.hkm.setVisibility(8);
                    return;
                }
                this.hko.hkk.setVisibility(0);
                this.hko.gMz.setVisibility(8);
                this.hko.hkm.setVisibility(0);
            }

            public final void Oj() {
            }
        };
        this.gMz = findViewById(2131758158);
        this.hkg.setAdapter(this.hkh);
        this.hkg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MassSendHistoryUI hko;

            {
                this.hko = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                v.v("MicroMsg.MassSendHistoryUI", "onItemClick");
            }
        });
        this.hkg.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ MassSendHistoryUI hko;

            {
                this.hko = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                v.v("MicroMsg.MassSendHistoryUI", "onTouch");
                return false;
            }
        });
        this.hki = (Button) findViewById(2131758161);
        this.hki.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MassSendHistoryUI hko;

            {
                this.hko = r1;
            }

            public final void onClick(View view) {
                this.hko.startActivity(new Intent(this.hko, MassSendSelectContactUI.class));
            }
        });
        this.hkj = (Button) findViewById(2131758159);
        this.hkj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MassSendHistoryUI hko;

            {
                this.hko = r1;
            }

            public final void onClick(View view) {
                this.hko.startActivity(new Intent(this.hko, MassSendSelectContactUI.class));
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MassSendHistoryUI hko;

            {
                this.hko = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.hko.hkl) {
                    this.hko.finish();
                } else {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.masssend.a.drp.t(intent, this.hko);
                    this.hko.finish();
                }
                return true;
            }
        });
        a(0, 2131231153, 2131165208, new OnMenuItemClickListener(this) {
            final /* synthetic */ MassSendHistoryUI hko;

            {
                this.hko = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", "masssendapp");
                com.tencent.mm.plugin.masssend.a.drp.d(intent, this.hko);
                return true;
            }
        });
        new l(this).a(this.hkg, this, this.hkn);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.hkl) {
            finish();
        } else {
            Intent intent = new Intent();
            intent.addFlags(67108864);
            com.tencent.mm.plugin.masssend.a.drp.t(intent, this);
            finish();
        }
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        v.v("MicroMsg.MassSendHistoryUI", "onCreateContextMenu");
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        String[] split = ((com.tencent.mm.plugin.masssend.a.a) this.hkh.getItem(adapterContextMenuInfo.position)).aza().split(";");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : split) {
            ak.yW();
            u LX = c.wH().LX(str);
            if (LX != null) {
                stringBuilder.append(LX.tU() + ";");
            }
        }
        contextMenu.setHeaderTitle(stringBuilder.toString());
        contextMenu.add(adapterContextMenuInfo.position, 1, 0, getString(2131231829));
    }

    protected final void releaseWakeLock() {
        this.hkg.setKeepScreenOn(false);
    }

    public final void bZ(boolean z) {
        if (this.aSS != null) {
            if (this.aSS.isPlaying()) {
                this.aSS.ak(z);
                ak.yX().d(z, false);
                this.evw = z;
                if (!z) {
                    if (wp(this.hkh.hjV)) {
                        this.hkh.wn(this.hkh.hjV);
                        return;
                    } else {
                        this.hkh.wn("");
                        return;
                    }
                }
                return;
            }
            this.aSS.ak(true);
            ak.yX().d(true, false);
            this.evw = true;
        }
    }

    private boolean wp(String str) {
        Assert.assertTrue(str != null);
        evt.a(this);
        com.tencent.mm.plugin.masssend.a.a wk = h.azf().wk(str);
        ak.yW();
        if (c.isSDCardAvailable() || be.kS(wk.ayY())) {
            if (this.aSS == null) {
                this.aSS = new com.tencent.mm.c.a.a(this);
            }
            this.aSS.stop();
            if (this.aSS.h(wk.ayY(), this.evw)) {
                ak.yX().d(this.evw, false);
                this.aSS.aTk = this;
                this.aSS.aTj = this;
                return true;
            }
            Toast.makeText(this, getString(2131231868), 0).show();
            return false;
        }
        s.ey(this);
        return false;
    }

    private void XV() {
        evt.btX();
        this.aSS.stop();
        this.hkh.wn("");
        releaseWakeLock();
    }

    public final void pa() {
        XV();
    }

    public final void onError() {
        XV();
    }
}
