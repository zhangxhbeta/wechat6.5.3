package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.c.o;
import com.tencent.mm.plugin.game.c.q;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.j.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public class GameMessageUI extends MMActivity implements OnItemClickListener, e {
    private int bZA = 0;
    private int exT;
    private OnScrollListener gpO = new OnScrollListener(this) {
        final /* synthetic */ GameMessageUI gwk;

        {
            this.gwk = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !this.gwk.gwb.abO()) {
                m b = this.gwk.gwb;
                if (!b.abO()) {
                    b.eKW += 15;
                    if (b.eKW > b.emv) {
                        b.eKW = b.emv;
                    }
                } else if (b.nDK != null) {
                    b.nDK.Oi();
                }
                this.gwk.gwb.a(null, null);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ListView gwa;
    private m gwb;
    private TextView gwc;
    private View gwd;
    private int gwe = 1;
    private boolean gwf = false;
    private boolean gwg = false;
    private String gwh = "";
    private OnClickListener gwi;
    private OnClickListener gwj;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(573, this);
        this.bZA = getIntent().getIntExtra("game_unread_msg_count", 0);
        this.gwh = getIntent().getStringExtra("game_manage_url");
        NI();
        au.asd();
        q.arv();
    }

    protected void onResume() {
        super.onResume();
        this.gwb.notifyDataSetChanged();
        if (this.gwg && this.gwd != null) {
            this.gwa.removeHeaderView(this.gwd);
        }
    }

    protected final void NI() {
        vD(2131233103);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GameMessageUI gwk;

            {
                this.gwk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gwk.goBack();
                return true;
            }
        });
        a(0, getString(2131231012), new OnMenuItemClickListener(this) {
            final /* synthetic */ GameMessageUI gwk;

            {
                this.gwk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gwk.gwi = new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 gwl;

                    {
                        this.gwl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        au.asc().dF("GameRawMessage", "delete from GameRawMessage");
                        this.gwl.gwk.gwb.Om();
                        this.gwl.gwk.gwb.notifyDataSetChanged();
                    }
                };
                this.gwk.gwj = new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 gwl;

                    {
                        this.gwl = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                };
                g.a(this.gwk.nDR.nEl, 2131233065, 0, this.gwk.gwi, this.gwk.gwj);
                return false;
            }
        });
        this.exT = getIntent().getIntExtra("game_report_from_scene", 0);
        this.gwa = (ListView) findViewById(2131757341);
        this.gwa.setOnItemClickListener(this);
        if (this.bZA > 20) {
            if (getSharedPreferences("game_center_pref", 0).getBoolean("show_message_tips", true)) {
                this.gwd = View.inflate(this, 2130903746, null);
                this.gwd.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ GameMessageUI gwk;

                    {
                        this.gwk = r1;
                    }

                    public final void onClick(View view) {
                        if (!be.kS(this.gwk.gwh)) {
                            c.W(this.gwk.nDR.nEl, this.gwk.gwh);
                            af.a(this.gwk.nDR.nEl, 13, 1302, 1, 7, this.gwk.exT, null);
                        }
                        this.gwk.gwg = true;
                    }
                });
                this.gwa.addHeaderView(this.gwd);
                this.gwd.setVisibility(0);
                getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_message_tips", false).apply();
            } else if (this.gwd != null) {
                this.gwd.setVisibility(8);
            }
        }
        n nVar = new n();
        nVar.giX = true;
        this.gwb = new m(this, nVar, this.exT);
        this.gwb.iQ(true);
        lD(8);
        this.gwb.nDK = new a(this) {
            final /* synthetic */ GameMessageUI gwk;

            {
                this.gwk = r1;
            }

            public final void Oj() {
            }

            public final void Oi() {
                if (this.gwk.gwb.getCount() == 0) {
                    this.gwk.gwa.setVisibility(8);
                    this.gwk.lD(0);
                    this.gwk.iT(false);
                    return;
                }
                this.gwk.gwa.setVisibility(0);
                this.gwk.lD(8);
                this.gwk.iT(true);
            }
        };
        this.gwa.setOnScrollListener(this.gpO);
        this.gwa.setAdapter(this.gwb);
        af.a(this.nDR.nEl, 13, 1300, 0, 1, 0, null, this.exT, 0, null, null, null);
    }

    private void lD(int i) {
        if (this.gwc == null) {
            this.gwc = (TextView) findViewById(2131757342);
        }
        this.gwc.setVisibility(i);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        au.asc().arz();
        finish();
    }

    protected final int getLayoutId() {
        return 2130903743;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.gwb != null) {
            this.gwb.avc();
        }
        ak.vy().b(573, this);
        boolean dF = au.asc().dF("GameRawMessage", "delete from GameRawMessage where createTime < (" + "select createTime from GameRawMessage order by createTime desc limit 9999,1" + ")");
        v.i("MicroMsg.GameMessageStorage", "clearMessageStorage: [%b], [%s]", new Object[]{Boolean.valueOf(dF), r1});
        au.asc().arz();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        n nVar = (n) adapterView.getAdapter().getItem(i);
        if (nVar == null) {
            v.e("MicroMsg.GameMessageUI", "get message null: position:[%d]", new Object[]{Integer.valueOf(i)});
            return;
        }
        nVar.arp();
        int a;
        if (nVar.field_msgType == 100) {
            if (!be.kS(nVar.giK)) {
                n.c cVar = (n.c) nVar.giq.get(nVar.giK);
                if (cVar != null) {
                    a = o.a(this, nVar, cVar, nVar.field_appId, 1301);
                    if (a != 0) {
                        af.a(this.nDR.nEl, 13, 1301, 4, a, 0, nVar.field_appId, this.exT, nVar.giT, nVar.field_gameMsgId, nVar.giU, null);
                    }
                }
            }
        } else if (nVar.giV == 0) {
            switch (nVar.field_msgType) {
                case 2:
                case 5:
                    if (com.tencent.mm.pluginsdk.model.app.g.o(this, nVar.field_appId)) {
                        com.tencent.mm.plugin.game.c.e.R(this, nVar.field_appId);
                        a = 3;
                    } else {
                        r0 = new Bundle();
                        r0.putCharSequence("game_app_id", nVar.field_appId);
                        r0.putInt("game_report_from_scene", 1301);
                        a = c.a(this, nVar.field_appId, null, r0);
                    }
                    af.a(this.nDR.nEl, 13, 1301, 4, a, 0, nVar.field_appId, this.exT, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                    return;
                case 6:
                    if (!be.kS(nVar.giF)) {
                        c.W(this, nVar.giF);
                        af.a(this.nDR.nEl, 13, 1301, 4, 7, 0, nVar.field_appId, this.exT, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                        return;
                    }
                    return;
                case 10:
                case 11:
                    if (!be.kS(nVar.gid)) {
                        c.W(this, nVar.gid);
                        af.a(this.nDR.nEl, 13, 1301, 4, 7, 0, nVar.field_appId, this.exT, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (nVar.giV) {
                case 1:
                    if (be.kS(nVar.field_appId)) {
                        v.e("MicroMsg.GameMessageUI", "appid is null");
                        return;
                    }
                    r0 = new Bundle();
                    r0.putCharSequence("game_app_id", nVar.field_appId);
                    r0.putInt("game_report_from_scene", 1301);
                    af.a(this.nDR.nEl, 13, 1301, 4, c.a(this, nVar.field_appId, null, r0), 0, nVar.field_appId, this.exT, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                    return;
                case 2:
                    if (com.tencent.mm.pluginsdk.model.app.g.o(this, nVar.field_appId)) {
                        com.tencent.mm.plugin.game.c.e.R(this, nVar.field_appId);
                        a = 3;
                    } else {
                        r0 = new Bundle();
                        r0.putCharSequence("game_app_id", nVar.field_appId);
                        r0.putInt("game_report_from_scene", 1301);
                        a = c.a(this, nVar.field_appId, null, r0);
                    }
                    af.a(this.nDR.nEl, 13, 1301, 4, a, 0, nVar.field_appId, this.exT, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                    return;
                case 3:
                    if (be.kS(nVar.giW)) {
                        v.e("MicroMsg.GameMessageUI", "jumpurl is null");
                        return;
                    }
                    c.W(this, nVar.giW);
                    af.a(this.nDR.nEl, 13, 1301, 4, 7, 0, nVar.field_appId, this.exT, nVar.field_msgType, nVar.field_gameMsgId, nVar.giU, null);
                    return;
                default:
                    v.e("MicroMsg.GameMessageUI", "unknowed jumptype : " + nVar.giV);
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.GameMessageUI", "onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType())});
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 573) {
                lD(8);
                this.gwb.a(null, null);
            }
        } else if (this.gwb.getCount() > 0) {
            v.i("MicroMsg.GameMessageUI", "has local message, do not show error tips");
        } else if (!com.tencent.mm.plugin.game.a.a.drq.a(this, i, i2, str)) {
            Toast.makeText(this, getString(2131233083, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }
}
