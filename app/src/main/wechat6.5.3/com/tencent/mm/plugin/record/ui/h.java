package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.record.ui.b.c;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.plugin.record.ui.b.e;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import java.util.LinkedList;
import java.util.List;

public abstract class h extends BaseAdapter {
    ListView Eq;
    protected Context context;
    private Runnable fNf = new Runnable(this) {
        final /* synthetic */ h iqm;

        {
            this.iqm = r1;
        }

        public final void run() {
            v.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
            this.iqm.notifyDataSetChanged();
        }
    };
    protected List<pw> ipS = new LinkedList();
    protected ac iqg = null;
    private SparseArray<b> iqh = new SparseArray();
    boolean iqi = false;
    private boolean iqj = false;
    protected a iqk;
    protected a iql;
    private int padding = com.tencent.mm.bd.a.fromDPToPix(this.context, 35);

    public interface a {

        public static class a {
            public pw bdE;
            public ImageView bdF;
            public int bdG;
            public int height;
            public long iqn;
            public int width;
        }

        public static class b {
            public pw bdE;
            public boolean bdH;
            public boolean bdI;
            public long iqn;
            public int maxWidth;
        }

        public static class c {
            public pw bdE;
            public long iqn;
        }

        Bitmap a(b bVar);

        Bitmap a(c cVar);

        void a(a aVar);

        void aJH();
    }

    public interface b {
        void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar);

        View cq(Context context);

        void destroy();
    }

    public abstract void a(a aVar);

    public abstract void b(com.tencent.mm.plugin.record.ui.a.b bVar);

    public /* synthetic */ Object getItem(int i) {
        return oN(i);
    }

    public h(Context context, a aVar) {
        this.context = context;
        this.iqg = new ac(this, Looper.getMainLooper()) {
            final /* synthetic */ h iqm;

            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    v.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
                    this.iqm.notifyDataSetChanged();
                }
            }
        };
        this.iql = aVar;
    }

    public final void aJP() {
        this.iqh.put(0, new d());
        this.iqh.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.iql, this.Eq));
        this.iqh.put(2, new e());
        this.iqh.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.iql, this.iqg));
        this.iqh.put(4, new c(this.iql));
    }

    public final void destroy() {
        for (int i = 0; i < this.iqh.size(); i++) {
            b bVar = (b) this.iqh.valueAt(i);
            if (bVar != null) {
                bVar.destroy();
            }
        }
        if (this.iql != null) {
            this.iql.aJH();
            this.iql = null;
        }
    }

    public int getItemViewType(int i) {
        return l(oN(i));
    }

    private static int l(pw pwVar) {
        switch (pwVar.aKG) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 3;
        }
    }

    public int getViewTypeCount() {
        return 5;
    }

    public int getCount() {
        return this.ipS == null ? 0 : this.ipS.size();
    }

    private pw oN(int i) {
        if (this.ipS != null && i >= 0 && i < this.ipS.size()) {
            return (pw) this.ipS.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.record.ui.a.b aVar;
        pw oN = oN(i);
        b bVar = (b) this.iqh.get(l(oN));
        if (view == null) {
            view = bVar.cq(this.context);
        }
        switch (oN.aKG) {
            case 2:
                aVar = new com.tencent.mm.plugin.record.ui.a.a();
                break;
            case am.CTRL_INDEX /*15*/:
                aVar = new com.tencent.mm.plugin.record.ui.a.c();
                break;
            default:
                aVar = new com.tencent.mm.plugin.record.ui.a.b();
                break;
        }
        aVar.bdE = oN;
        b(aVar);
        bVar.a(view, i, aVar);
        ImageView imageView = (ImageView) view.findViewById(2131755070);
        TextView textView = (TextView) view.findViewById(2131758842);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(textView.getContext(), oN.msO, textView.getTextSize()));
        textView = (TextView) view.findViewById(2131758843);
        v.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[]{oN.msQ});
        if (oN.msQ != null) {
            if (this.iqi) {
                String str = oN.msQ;
                textView.setText(str.substring(str.indexOf("-") + 1));
            } else {
                String[] split = oN.msQ.split(" ");
                if (split.length < 2) {
                    textView.setText(oN.msQ);
                } else {
                    textView.setText(split[1]);
                }
            }
        }
        if (i == 0) {
            py pyVar = oN.msM.msY;
            imageView.setVisibility(0);
            if (pyVar.mtv) {
                yA(pyVar.mtu);
                if (com.tencent.mm.modelbiz.a.e.hS(pyVar.mtu)) {
                    n.GL().a(com.tencent.mm.modelbiz.a.e.hW(pyVar.mtu), imageView);
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.m(imageView, pyVar.mtu);
                }
            } else if (!pyVar.mtq || (k.xF().equals(pyVar.bhM) && pyVar.bhM.equals(pyVar.toUser))) {
                imageView.setVisibility(8);
                view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                this.iqj = true;
            } else {
                yA(pyVar.bhM);
                com.tencent.mm.pluginsdk.ui.a.b.m(imageView, pyVar.bhM);
            }
        } else if (i <= 0 || this.iqj) {
            imageView.setVisibility(8);
            view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
        } else {
            String str2 = "";
            py pyVar2 = oN.msM.msY;
            if (oN(i - 1).msM.msY.mtv) {
                str2 = oN(i - 1).msM.msY.mtu;
            } else if (oN(i - 1).msM.msY.mtq) {
                str2 = oN(i - 1).msM.msY.bhM;
            }
            imageView.setVisibility(0);
            String str3;
            if (oN.msM.msY.mtv) {
                str3 = oN.msM.msY.mtu;
                if (str2.equals(str3)) {
                    imageView.setVisibility(4);
                } else {
                    yA(str3);
                    if (com.tencent.mm.modelbiz.a.e.hS(pyVar2.mtu)) {
                        n.GL().a(com.tencent.mm.modelbiz.a.e.hW(pyVar2.mtu), imageView);
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.m(imageView, str3);
                    }
                }
            } else if (oN.msM.msY.mtq) {
                str3 = oN.msM.msY.bhM;
                if (str2.equals(str3)) {
                    imageView.setVisibility(4);
                } else {
                    yA(str3);
                    com.tencent.mm.pluginsdk.ui.a.b.m(imageView, str3);
                }
            } else {
                imageView.setVisibility(4);
            }
        }
        if (i == getCount() - 1) {
            view.findViewById(2131755071).setVisibility(8);
        } else {
            view.findViewById(2131755071).setVisibility(0);
        }
        return view;
    }

    private static void yA(String str) {
        if (!m.eC(str)) {
            com.tencent.mm.u.h hVar = new com.tencent.mm.u.h();
            hVar.username = str;
            com.tencent.mm.u.n.Bo().a(hVar);
        }
    }

    protected final void aJQ() {
        this.iqg.post(this.fNf);
    }
}
