package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.j;

public class IPCallAllRecordUI extends MMActivity {
    private String bpN;
    private String bpP;
    private ListView gKv;
    private boolean gKw = false;

    private class a extends j<k> {
        final /* synthetic */ IPCallAllRecordUI gKx;

        class a {
            TextView dtE;
            final /* synthetic */ a gKA;
            TextView gKy;
            TextView gKz;

            a(a aVar) {
                this.gKA = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (k) obj;
            if (obj == null) {
                obj = new k();
            }
            obj.b(cursor);
            return obj;
        }

        public a(IPCallAllRecordUI iPCallAllRecordUI, Context context) {
            this.gKx = iPCallAllRecordUI;
            super(context, null);
            iQ(true);
        }

        public final void Ol() {
            Cursor cursor = null;
            if (!be.kS(this.gKx.bpN)) {
                String a = this.gKx.bpN;
                if (!be.kS(a)) {
                    c uK = i.aur().uK(a);
                    if (!(uK == null || uK.nmb == -1)) {
                        cursor = i.aus().cc(uK.nmb);
                    }
                }
            } else if (!be.kS(this.gKx.bpP)) {
                cursor = i.aus().uO(this.gKx.bpP);
            }
            setCursor(cursor);
        }

        protected final void Om() {
            avc();
            Ol();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.gKx.getLayoutInflater().inflate(2130903829, viewGroup, false);
                aVar = new a(this);
                aVar.gKy = (TextView) view.findViewById(2131757607);
                aVar.gKz = (TextView) view.findViewById(2131757608);
                aVar.dtE = (TextView) view.findViewById(2131757609);
                view.setTag(aVar);
            }
            k kVar = (k) getItem(i);
            aVar = (a) view.getTag();
            aVar.gKz.setText(com.tencent.mm.plugin.ipcall.b.a.vp(kVar.field_phonenumber));
            if (kVar.field_duration > 0) {
                aVar.dtE.setText(com.tencent.mm.plugin.ipcall.b.c.cf(kVar.field_duration));
            } else {
                aVar.dtE.setText(com.tencent.mm.plugin.ipcall.b.c.ml(kVar.field_status));
            }
            aVar.gKy.setText(com.tencent.mm.plugin.ipcall.b.c.cd(kVar.field_calltime));
            return view;
        }
    }

    protected final int NO() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bpP = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
        this.bpN = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
        this.gKw = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
        vD(2131233381);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallAllRecordUI gKx;

            {
                this.gKx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gKx.finish();
                return true;
            }
        });
        this.gKv = (ListView) findViewById(2131757518);
        this.gKv.setAdapter(new a(this, this));
    }

    protected final int getLayoutId() {
        return 2130903816;
    }
}
