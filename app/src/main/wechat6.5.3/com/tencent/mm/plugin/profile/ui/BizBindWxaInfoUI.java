package com.tencent.mm.plugin.profile.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.t.a.b;
import com.tencent.mm.t.a.c;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class BizBindWxaInfoUI extends MMActivity {
    private TextView hTL;
    private ListView hTM;

    private static class a extends BaseAdapter {
        private LayoutInflater CE;
        private List<WxaEntryInfo> hOR = new LinkedList();

        private static class a {
            TextView dtB;
            ImageView hEP;

            private a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return og(i);
        }

        public a(LayoutInflater layoutInflater, List<WxaEntryInfo> list) {
            this.CE = layoutInflater;
            if (list != null) {
                this.hOR.addAll(list);
            }
        }

        public final int getCount() {
            return this.hOR.size();
        }

        private WxaEntryInfo og(int i) {
            return (WxaEntryInfo) this.hOR.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.CE.inflate(2130903103, viewGroup, false);
                a aVar2 = new a();
                aVar2.hEP = (ImageView) view.findViewById(2131755225);
                aVar2.dtB = (TextView) view.findViewById(2131755366);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            WxaEntryInfo og = og(i);
            b.AL().a(aVar.hEP, og.iconUrl, com.tencent.mm.t.a.a.AK(), c.cxH);
            aVar.dtB.setText(be.ma(og.title));
            return view;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BizBindWxaInfoUI hTN;

            {
                this.hTN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hTN.finish();
                return false;
            }
        });
        vD(2131232000);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
        View inflate = getLayoutInflater().inflate(2130903179, null);
        this.hTL = (TextView) inflate.findViewById(2131755634);
        TextView textView = this.hTL;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(parcelableArrayListExtra != null ? parcelableArrayListExtra.size() : 0);
        textView.setText(getString(2131231486, objArr));
        this.hTM = (ListView) findViewById(2131755635);
        this.hTM.addHeaderView(inflate);
        this.hTM.setAdapter(new a(getLayoutInflater(), parcelableArrayListExtra));
        this.hTM.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BizBindWxaInfoUI hTN;

            {
                this.hTN = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                WxaEntryInfo wxaEntryInfo = (WxaEntryInfo) adapterView.getAdapter().getItem(i);
                ok okVar = new ok();
                okVar.bpu.userName = wxaEntryInfo.username;
                okVar.bpu.scene = 1020;
                okVar.bpu.aWP = wxaEntryInfo.username;
                com.tencent.mm.sdk.c.a.nhr.z(okVar);
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903180;
    }
}
