package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.k;
import com.tencent.mm.plugin.shake.d.a.c;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.plugin.shake.d.a.o;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ShakeTvHistoryListUI extends MMActivity {
    private d eus = new d(this) {
        final /* synthetic */ ShakeTvHistoryListUI iST;

        {
            this.iST = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    int i2;
                    g.iuh.h(12662, new Object[]{Integer.valueOf(1), be.ma(this.iST.username)});
                    o aNQ = k.aNQ();
                    String d = this.iST.username;
                    if (be.kS(d)) {
                        i2 = -1;
                    } else {
                        i2 = aNQ.cie.delete(aNQ.getTableName(), "username = '" + d + "'", null);
                        v.d("MicroMsg.ShakeTvHistoryStorage", "delMsgByUserName = " + i2);
                    }
                    if (i2 < 0) {
                        v.i("MicroMsg.ShakeTvHistoryListUI", "delete tv history fail, ret[%d]", new Object[]{Integer.valueOf(i2)});
                    } else {
                        ak.vy().a(new c(1, this.iST.username), 0);
                    }
                    this.iST.iSR.a(null, null);
                    return;
                default:
                    return;
            }
        }
    };
    private a iSR;
    private ListView iSS;
    private String username;

    class a extends j<n> {
        private LayoutInflater CE;
        final /* synthetic */ ShakeTvHistoryListUI iST;

        class a {
            TextView eXB;
            TextView hfA;
            MMImageView iSV;
            final /* synthetic */ a iSW;

            a(a aVar) {
                this.iSW = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (n) obj;
            if (obj == null) {
                obj = new n();
            }
            obj.b(cursor);
            return obj;
        }

        public a(ShakeTvHistoryListUI shakeTvHistoryListUI, Context context) {
            this.iST = shakeTvHistoryListUI;
            super(context, new n());
            this.CE = LayoutInflater.from(context);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            if (view == null) {
                view = this.CE.inflate(2130904375, viewGroup, false);
                aVar = new a(this);
                aVar.iSV = (MMImageView) view.findViewById(2131759178);
                aVar.eXB = (TextView) view.findViewById(2131759179);
                aVar.hfA = (TextView) view.findViewById(2131759180);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            n nVar = (n) getItem(i);
            e.a(aVar.iSV, nVar.field_iconurl, 0, true);
            aVar.eXB.setText(nVar.field_title);
            TextView textView = aVar.hfA;
            ActionBarActivity actionBarActivity = this.iST.nDR.nEl;
            long j = nVar.field_createtime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                charSequence = "";
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > 86400000) {
                    timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    charSequence = (timeInMillis <= 0 || timeInMillis > 86400000) ? com.tencent.mm.pluginsdk.j.o.F(actionBarActivity.getString(2131232879), j / 1000) : actionBarActivity.getString(2131232911);
                } else {
                    charSequence = com.tencent.mm.pluginsdk.j.o.F(actionBarActivity.getString(2131232889), j / 1000);
                }
            }
            textView.setText(charSequence);
            return view;
        }

        public final void Ol() {
            setCursor(k.aNQ().aOu());
            super.notifyDataSetChanged();
        }

        protected final void Om() {
            Ol();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onDestroy() {
        this.iSR.avc();
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131235287);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeTvHistoryListUI iST;

            {
                this.iST = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iST.axg();
                this.iST.finish();
                return true;
            }
        });
        a(0, getString(2131231012), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeTvHistoryListUI iST;

            {
                this.iST = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.iST.nDR.nEl, true, this.iST.getString(2131235286), "", this.iST.getString(2131234729), this.iST.getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 iSU;

                    {
                        this.iSU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        g gVar = g.iuh;
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(2);
                        o aNQ = k.aNQ();
                        List<n> arrayList = new ArrayList();
                        Cursor aOu = aNQ.aOu();
                        if (aOu != null) {
                            while (aOu.moveToNext()) {
                                n nVar = new n();
                                nVar.b(aOu);
                                arrayList.add(nVar);
                            }
                            aOu.close();
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (n nVar2 : arrayList) {
                            stringBuilder.append(nVar2.field_username);
                            stringBuilder.append("|");
                        }
                        objArr[1] = stringBuilder.toString();
                        gVar.h(12662, objArr);
                        k.aNQ().cie.delete("shaketvhistory", null, null);
                        ak.vy().a(new c(2, null), 0);
                        this.iSU.iST.iSR.Ol();
                        this.iSU.iST.iT(false);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 iSU;

                    {
                        this.iSU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
        this.iSS = (ListView) findViewById(2131759181);
        this.iSR = new a(this, this);
        this.iSS.setAdapter(this.iSR);
        this.iSS.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ShakeTvHistoryListUI iST;

            {
                this.iST = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.plugin.shake.d.a.k.a((n) this.iST.iSR.getItem(i), this.iST.nDR.nEl, 2);
            }
        });
        final l lVar = new l(this);
        this.iSS.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ ShakeTvHistoryListUI iST;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.iST.iSS.getHeaderViewsCount()) {
                    lVar.a(view, i, j, this.iST.nDR.nEl, this.iST.eus);
                }
                return true;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.username = ((n) this.iSR.getItem(adapterContextMenuInfo.position)).field_username;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, 2131231020);
    }

    protected final int getLayoutId() {
        return 2130904376;
    }
}
