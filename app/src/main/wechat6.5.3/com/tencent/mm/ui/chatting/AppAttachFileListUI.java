package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

public class AppAttachFileListUI extends MMActivity implements com.tencent.mm.storage.au.a {
    private OnScrollListener eVr = new OnScrollListener(this) {
        final /* synthetic */ AppAttachFileListUI ojG;

        {
            this.ojG = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && !this.ojG.ojD && this.ojG.ojC && absListView.getLastVisiblePosition() == this.ojG.ojB.getCount()) {
                v.d("MicroMsg.AppAttachFileListUI", "need to add item");
                int e = this.ojG.ojF;
                new a().execute(new Integer[]{Integer.valueOf(e), Integer.valueOf(20)});
                AppAttachFileListUI.f(this.ojG);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private OnItemClickListener ezi = new OnItemClickListener(this) {
        final /* synthetic */ AppAttachFileListUI ojG;

        {
            this.ojG = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent(this.ojG, AppAttachDownloadUI.class);
            intent.putExtra("app_msg_id", ((c) this.ojG.ojy.get(i)).bmk.field_msgId);
            intent.setFlags(67108864);
            this.ojG.startActivity(intent);
        }
    };
    private ListView ojA;
    private b ojB;
    private boolean ojC = true;
    private boolean ojD = false;
    private View ojE;
    private int ojF;
    private ArrayList<c> ojy;
    private HashSet<Long> ojz;

    private class a extends AsyncTask<Integer, Integer, List<at>> {
        final /* synthetic */ AppAttachFileListUI ojG;

        private a(AppAttachFileListUI appAttachFileListUI) {
            this.ojG = appAttachFileListUI;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            Integer[] numArr = (Integer[]) objArr;
            int intValue = numArr[0].intValue();
            int intValue2 = numArr[1].intValue();
            String xF = k.xF();
            ak.yW();
            List J = com.tencent.mm.model.c.wJ().J(xF, intValue, intValue2);
            AppAttachFileListUI.a(this.ojG, intValue2);
            return J;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            List list = (List) obj;
            super.onPostExecute(list);
            AppAttachFileListUI.g(this.ojG);
            this.ojG.cn(list);
            this.ojG.ojB.notifyDataSetChanged();
        }
    }

    private class b extends BaseAdapter {
        final /* synthetic */ AppAttachFileListUI ojG;

        private b(AppAttachFileListUI appAttachFileListUI) {
            this.ojG = appAttachFileListUI;
        }

        public final int getCount() {
            return this.ojG.ojy.size();
        }

        public final Object getItem(int i) {
            return this.ojG.ojy.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            String str;
            if (view == null) {
                view = this.ojG.getLayoutInflater().inflate(2130903096, viewGroup, false);
                Assert.assertNotNull(view);
                dVar = new d();
                dVar.ojI = (MMImageView) view.findViewById(2131755343);
                dVar.ojJ = (TextView) view.findViewById(2131755344);
                dVar.ojK = (TextView) view.findViewById(2131755346);
                dVar.ojL = (TextView) view.findViewById(2131755345);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            Assert.assertNotNull(dVar);
            c cVar = (c) this.ojG.ojy.get(i);
            dVar.ojJ.setText(cVar.ojH.title);
            if (cVar.bmk.field_isSend == 1) {
                str = "自己";
            } else {
                str = l.er(cVar.ojH.bhM);
            }
            dVar.ojK.setText(String.format("大小：%s，来自：%s", new Object[]{be.aw((long) cVar.ojH.cob), str}));
            dVar.ojL.setText(o.c(this.ojG, cVar.bmk.field_createTime, true));
            dVar.ojI.setImageResource(p.Gt(cVar.ojH.coc));
            return view;
        }
    }

    private class c {
        public at bmk;
        final /* synthetic */ AppAttachFileListUI ojG;
        public com.tencent.mm.q.a.a ojH;

        private c(AppAttachFileListUI appAttachFileListUI) {
            this.ojG = appAttachFileListUI;
        }
    }

    private class d {
        final /* synthetic */ AppAttachFileListUI ojG;
        public MMImageView ojI;
        public TextView ojJ;
        public TextView ojK;
        public TextView ojL;

        private d(AppAttachFileListUI appAttachFileListUI) {
            this.ojG = appAttachFileListUI;
        }
    }

    static /* synthetic */ int a(AppAttachFileListUI appAttachFileListUI, int i) {
        int i2 = appAttachFileListUI.ojF + i;
        appAttachFileListUI.ojF = i2;
        return i2;
    }

    static /* synthetic */ void f(AppAttachFileListUI appAttachFileListUI) {
        v.d("MicroMsg.AppAttachFileListUI", "start to load");
        appAttachFileListUI.ojD = true;
        appAttachFileListUI.ojE.setVisibility(0);
    }

    static /* synthetic */ void g(AppAttachFileListUI appAttachFileListUI) {
        appAttachFileListUI.ojD = false;
        appAttachFileListUI.ojE.setVisibility(8);
        v.d("MicroMsg.AppAttachFileListUI", "stop to load");
    }

    protected final int getLayoutId() {
        return 2130903097;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131232769);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppAttachFileListUI ojG;

            {
                this.ojG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ojG.finish();
                return true;
            }
        });
        this.ojA = (ListView) findViewById(2131755347);
        this.ojE = getLayoutInflater().inflate(2130903095, null);
        this.ojA.addFooterView(this.ojE);
        this.ojE.setVisibility(8);
        this.ojy = new ArrayList();
        this.ojz = new HashSet();
        String xF = k.xF();
        ak.yW();
        List J = com.tencent.mm.model.c.wJ().J(xF, 0, 20);
        this.ojF += 20;
        cn(J);
        this.ojB = new b();
        this.ojA.setAdapter(this.ojB);
        this.ojA.setOnItemClickListener(this.ezi);
        this.ojA.setOnScrollListener(this.eVr);
        ak.yW();
        com.tencent.mm.model.c.wJ().a((com.tencent.mm.storage.au.a) this, getMainLooper());
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        ak.yW();
        com.tencent.mm.model.c.wJ().a((com.tencent.mm.storage.au.a) this);
        super.onDestroy();
    }

    private void cn(List<at> list) {
        if (list.size() < 20) {
            this.ojC = false;
            this.ojA.removeFooterView(this.ojE);
        }
        for (at atVar : list) {
            c V = V(atVar);
            if (V != null && V.ojH.type == 6 && this.ojz.add(Long.valueOf(atVar.field_msgId))) {
                this.ojy.add(V);
            }
        }
        v.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", Integer.valueOf(list.size()), Integer.valueOf(this.ojy.size()));
    }

    private c V(at atVar) {
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(atVar.field_content);
        if (dV == null) {
            return null;
        }
        c cVar = new c();
        cVar.bmk = atVar;
        cVar.ojH = dV;
        return cVar;
    }

    public final void a(au auVar, com.tencent.mm.storage.au.c cVar) {
        if ("insert".equals(cVar.nws)) {
            v.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
            for (int size = cVar.nwt.size() - 1; size >= 0; size--) {
                at atVar = (at) cVar.nwt.get(size);
                if (atVar.bvY()) {
                    c V = V(atVar);
                    if (V != null && V.ojH.type == 6) {
                        this.ojy.add(0, V);
                    }
                }
            }
            if (this.ojB != null) {
                this.ojB.notifyDataSetChanged();
            }
        }
    }
}
