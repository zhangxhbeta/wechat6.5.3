package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.ajh;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;

public class ReaderAppSubscribeUI extends MMActivity {
    private ListView ilo;
    private a ilp;

    static class a extends BaseAdapter {
        private final Context context;
        final int[] ilr = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
        int ils;
        private String[] ilt = null;
        int ilu = 0;

        static class a {
            TextView dtY;
            CheckBox dua;

            a() {
            }
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.ilt[i];
        }

        public a(Context context, int i) {
            this.context = context;
            this.ils = i;
            this.ilt = context.getString(2131234322).split(";");
            this.ilu = oE(i);
        }

        public final int getCount() {
            return this.ilt.length;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(this.context, 2130904238, null);
                aVar2.dtY = (TextView) view.findViewById(2131758785);
                aVar2.dua = (CheckBox) view.findViewById(2131758786);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.dtY.setText(this.ilt[i]);
            aVar.dua.setChecked((this.ils & this.ilr[i]) != 0);
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        private int oE(int i) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.ilr.length) {
                if ((this.ilr[i2] & i) != 0) {
                    i3++;
                }
                i2++;
            }
            return i3;
        }
    }

    protected final int getLayoutId() {
        return 2130904239;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.yW();
        c.vf().set(868518890, "in");
        vD(2131232130);
        NI();
    }

    protected final void NI() {
        ak.yW();
        this.ilp = new a(this, be.f((Integer) c.vf().get(868518889, null)));
        this.ilo = (ListView) findViewById(2131758787);
        this.ilo.setAdapter(this.ilp);
        this.ilo.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ReaderAppSubscribeUI ilq;

            {
                this.ilq = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                a a = this.ilq.ilp;
                if ((a.ils & a.ilr[i]) != 0) {
                    a.ils &= a.ilr[i] ^ -1;
                    a.ilu--;
                    if (a.ilu < 0) {
                        a.ilu = 0;
                    }
                    a.notifyDataSetChanged();
                } else if (a.ilu < 3) {
                    a.ils |= a.ilr[i];
                    a.ilu++;
                    if (a.ilu > a.ilr.length) {
                        a.ilu = a.ilr.length;
                    }
                    a.notifyDataSetChanged();
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    g.f(this.ilq, 2131232131, 2131231164);
                }
            }
        });
        this.ilp.notifyDataSetChanged();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppSubscribeUI ilq;

            {
                this.ilq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ilq.oD(this.ilq.ilp.ils);
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener(this) {
            final /* synthetic */ ReaderAppSubscribeUI ilq;

            {
                this.ilq = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.ilq.ilo);
            }
        };
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.ilp != null) {
            oD(this.ilp.ils);
        }
        return true;
    }

    private void oD(int i) {
        ak.yW();
        c.vf().set(868518889, Integer.valueOf(i));
        ajh com_tencent_mm_protocal_c_ajh = new ajh();
        com_tencent_mm_protocal_c_ajh.mJD = i;
        ak.yW();
        c.wG().b(new com.tencent.mm.ak.j.a(43, com_tencent_mm_protocal_c_ajh));
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "newsapp");
        intent.addFlags(67108864);
        com.tencent.mm.plugin.readerapp.a.a.drp.d(intent, this);
        finish();
    }

    protected void onResume() {
        super.onResume();
        this.ilp.notifyDataSetChanged();
    }
}
