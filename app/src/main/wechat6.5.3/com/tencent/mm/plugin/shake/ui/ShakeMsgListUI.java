package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class ShakeMsgListUI extends MMActivity {
    private int aGx = 0;
    private long bgU;
    private int cPY;
    private d eus = new d(this) {
        final /* synthetic */ ShakeMsgListUI iRo;

        {
            this.iRo = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            g a = this.iRo.iRl;
            v.i("MicroMsg.ShakeMessageStorage", "delBySvrId = " + a.cie.delete(a.getTableName(), "svrid = '" + String.valueOf(this.iRo.bgU) + "'", null));
            this.iRo.iRm.a(null, null);
        }
    };
    private int hFR = 0;
    private int hFS = 0;
    private TextView hfJ;
    private g iRl = null;
    private d iRm;
    private ListView iRn;
    private int mType;

    static /* synthetic */ int d(ShakeMsgListUI shakeMsgListUI) {
        int i = shakeMsgListUI.aGx + 8;
        shakeMsgListUI.aGx = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("shake_msg_type", 0);
        this.iRl = k.aNP();
        this.hFS = this.iRl.Kw();
        this.aGx = this.hFS == 0 ? 8 : this.hFS;
        this.hFR = this.iRl.getCount();
        this.cPY = getIntent().getIntExtra("shake_msg_from", 1);
        if (this.cPY == 1) {
            com.tencent.mm.plugin.report.service.g.iuh.h(11313, new Object[]{Integer.valueOf(this.hFS), e.aOL()});
        } else {
            com.tencent.mm.plugin.report.service.g.iuh.h(11315, new Object[]{Integer.valueOf(this.hFS), e.aOL()});
        }
        g gVar = this.iRl;
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(1));
        gVar.cie.update(gVar.getTableName(), contentValues, "status!=? ", new String[]{"1"});
        NI();
    }

    protected void onResume() {
        super.onResume();
        if (this.hFR != this.iRl.getCount()) {
            this.hFR = this.iRl.getCount();
            if (this.hFR == 0) {
                aOw();
            }
            this.iRm.Ol();
        }
        this.iRm.notifyDataSetChanged();
    }

    public void onDestroy() {
        this.iRm.avc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904372;
    }

    protected final void NI() {
        Fd(getIntent().getStringExtra("shake_msg_list_title"));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeMsgListUI iRo;

            {
                this.iRo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iRo.axg();
                this.iRo.finish();
                return true;
            }
        });
        a(0, getString(2131231012), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeMsgListUI iRo;

            {
                this.iRo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.iRo.nDR.nEl, true, this.iRo.getString(2131235258), "", this.iRo.getString(2131234729), this.iRo.getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 iRp;

                    {
                        this.iRp = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        g a = this.iRp.iRo.iRl;
                        a.cie.delete(a.getTableName(), null, null);
                        this.iRp.iRo.iRm.Ol();
                        this.iRp.iRo.aOw();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 iRp;

                    {
                        this.iRp = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
        this.hfJ = (TextView) findViewById(2131756760);
        if (this.hFR == 0) {
            aOw();
        }
        this.iRn = (ListView) findViewById(2131759134);
        final View inflate = getLayoutInflater().inflate(2130904286, null);
        inflate.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ShakeMsgListUI iRo;

            public final void onClick(View view) {
                ShakeMsgListUI.d(this.iRo);
                this.iRo.iRm.pr(this.iRo.aGx);
                if (this.iRo.hFR <= this.iRo.aGx) {
                    this.iRo.iRn.removeFooterView(inflate);
                }
            }
        });
        if (this.hFR > 0 && this.aGx < this.hFR) {
            this.iRn.addFooterView(inflate);
        }
        this.iRm = new d(this);
        this.iRm.iRi = this.aGx;
        this.iRn.setAdapter(this.iRm);
        this.iRn.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ShakeMsgListUI iRo;

            {
                this.iRo = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                f fVar = (f) this.iRo.iRm.getItem(i);
                if (!be.kS(fVar.field_tag)) {
                    com.tencent.mm.plugin.report.service.g.iuh.Y(11316, this.iRo.cPY + "," + fVar.field_tag);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", fVar.field_tag);
                    c.b(this.iRo.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        final l lVar = new l(this);
        this.iRn.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ ShakeMsgListUI iRo;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.iRo.iRn.getHeaderViewsCount()) {
                    v.w("MicroMsg.ShakeMsgListUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.iRo.nDR.nEl, this.iRo.eus);
                }
                return true;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.bgU = ((f) this.iRm.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, 2131231020);
    }

    private void aOw() {
        this.hfJ.setText(2131235259);
        this.hfJ.setVisibility(0);
        iT(false);
    }
}
