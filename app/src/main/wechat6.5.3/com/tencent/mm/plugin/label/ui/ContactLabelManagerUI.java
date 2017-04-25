package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI extends ContactLabelBaseUI implements OnCreateContextMenuListener, OnItemClickListener, d, e {
    private ListView Eq;
    private int VU;
    private l eIV;
    private View fil;
    private b gQn = b.Normal;
    private View gQo;
    private View gQp;
    private a gQq;
    private ArrayList<w> gQr = new ArrayList();
    private HashMap<Integer, Integer> gQs = new HashMap();
    private boolean gQt = true;
    private OnClickListener gQu = new OnClickListener(this) {
        final /* synthetic */ ContactLabelManagerUI gQx;

        {
            this.gQx = r1;
        }

        public final void onClick(View view) {
            ContactLabelManagerUI.b(this.gQx);
        }
    };
    private com.tencent.mm.sdk.h.g.a gQv = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ ContactLabelManagerUI gQx;

        {
            this.gQx = r1;
        }

        public final void a(String str, i iVar) {
            if (!be.kS(str)) {
                this.gQx.dS(false);
            }
        }
    };
    private com.tencent.mm.sdk.h.j.b gQw = new com.tencent.mm.sdk.h.j.b(this) {
        final /* synthetic */ ContactLabelManagerUI gQx;

        {
            this.gQx = r1;
        }

        public final void a(int i, j jVar, Object obj) {
            v.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", new Object[]{Integer.valueOf(i), obj});
            if (this.gQx.mHandler != null) {
                this.gQx.mHandler.removeMessages(5001);
                this.gQx.mHandler.sendEmptyMessageDelayed(5001, 400);
            }
        }
    };
    private ac mHandler = new ac(this) {
        final /* synthetic */ ContactLabelManagerUI gQx;

        {
            this.gQx = r1;
        }

        public final void handleMessage(Message message) {
            v.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", new Object[]{Integer.valueOf(message.what)});
            switch (message.what) {
                case 5001:
                    this.gQx.dS(false);
                    return;
                case 5002:
                    this.gQx.vz(this.gQx.getString(2131231182));
                    return;
                case 5003:
                    this.gQx.avM();
                    return;
                default:
                    return;
            }
        }
    };

    class a extends BaseAdapter {
        final /* synthetic */ ContactLabelManagerUI gQx;
        ArrayList<w> mData;

        a(ContactLabelManagerUI contactLabelManagerUI) {
            this.gQx = contactLabelManagerUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return mm(i);
        }

        public final int getCount() {
            return this.mData == null ? 0 : this.mData.size();
        }

        public final w mm(int i) {
            return (this.mData == null || i > this.mData.size()) ? null : (w) this.mData.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.gQx).inflate(2130903418, viewGroup, false);
                cVar = new c(view);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            w mm = mm(i);
            cVar.gRs.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.gQx.nDR.nEl, mm.field_labelName, this.gQx.VU));
            if (this.gQx.gQs == null || !this.gQx.gQs.containsKey(Integer.valueOf(mm.field_labelID))) {
                cVar.gRt.setVisibility(0);
                cVar.gRt.setText("(0)");
            } else {
                cVar.gRt.setVisibility(0);
                cVar.gRt.setText("(" + this.gQx.gQs.get(Integer.valueOf(mm.field_labelID)) + ")");
            }
            return view;
        }
    }

    public enum b {
        Normal,
        Empty
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI, b bVar) {
        contactLabelManagerUI.gQn = bVar;
        switch (contactLabelManagerUI.gQn) {
            case Normal:
                contactLabelManagerUI.fil.setVisibility(0);
                contactLabelManagerUI.gQo.setVisibility(8);
                return;
            case Empty:
                contactLabelManagerUI.fil.setVisibility(8);
                contactLabelManagerUI.gQo.setVisibility(0);
                return;
            default:
                v.w("MicroMsg.Label.ContactLabelManagerUI", "unkonw mode:%s", new Object[]{contactLabelManagerUI.gQn});
                return;
        }
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI, w wVar) {
        if (wVar == null) {
            v.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteScene] can not do scene. lable is null");
            return;
        }
        contactLabelManagerUI.vz(contactLabelManagerUI.getString(2131233456));
        ak.vy().a(new com.tencent.mm.plugin.label.a.b(wVar.field_labelID), 0);
    }

    static /* synthetic */ void b(ContactLabelManagerUI contactLabelManagerUI) {
        if (contactLabelManagerUI.gQr == null || contactLabelManagerUI.gQr.isEmpty()) {
            g.iuh.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        } else {
            g.iuh.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        }
        v.i("MicroMsg.Label.ContactLabelManagerUI", "dz[dealAddLabel]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", r.s(new int[]{r.oHJ, 1024}));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelManagerUI.getString(2131233452));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 5);
        c.a(contactLabelManagerUI, ".ui.contact.SelectContactUI", intent, 7001);
    }

    protected final int getLayoutId() {
        return 2130903419;
    }

    protected final void NI() {
        this.VU = com.tencent.mm.bd.a.N(this.nDR.nEl, 2131493169);
        Fd(getString(2131233453));
        a(0, getString(2131233462), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelManagerUI gQx;

            {
                this.gQx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelManagerUI.b(this.gQx);
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelManagerUI gQx;

            {
                this.gQx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gQx.finish();
                return false;
            }
        });
        this.gQq = new a(this);
        this.fil = findViewById(2131756497);
        this.gQo = findViewById(2131756499);
        this.gQp = findViewById(2131756500);
        this.gQp.setOnClickListener(this.gQu);
        this.Eq = (ListView) findViewById(2131756498);
        this.eIV = new l(this);
        this.eIV.a(this.Eq, this, this);
        this.Eq.setAdapter(this.gQq);
        this.Eq.setOnItemClickListener(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ ContactLabelManagerUI gQx;

            {
                this.gQx = r1;
            }

            public final void run() {
                ak.vy().a(new com.tencent.mm.plugin.label.a.c(), 0);
            }
        });
        com.tencent.mm.plugin.label.e.avK().c(this.gQv);
    }

    protected void onResume() {
        ak.vy().a(636, this);
        ak.yW();
        com.tencent.mm.model.c.wH().a(this.gQw);
        dS(true);
        super.onResume();
    }

    protected void onPause() {
        ak.vy().b(636, this);
        ak.yW();
        com.tencent.mm.model.c.wH().b(this.gQw);
        super.onPause();
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.label.e.avK().d(this.gQv);
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.gQq != null && i >= 0) {
            w mm = this.gQq.mm(i);
            if (mm != null) {
                String str = mm.field_labelID;
                String str2 = mm.field_labelName;
                Intent intent = new Intent();
                intent.putExtra("label_id", str);
                intent.putExtra("label_name", str2);
                intent.setClass(this, ContactLabelEditUI.class);
                startActivity(intent);
                if (!be.kS(str)) {
                    return;
                }
                if (this.gQr == null || this.gQr.isEmpty()) {
                    g.iuh.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                    return;
                }
                g.iuh.h(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = ((AdapterContextMenuInfo) contextMenuInfo).position;
        if (this.gQq != null && i >= 0) {
            w mm = this.gQq.mm(i);
            if (mm != null) {
                contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.e.a(view.getContext(), mm.field_labelName));
                contextMenu.add(0, 0, 0, getString(2131231020));
                contextMenu.add(0, 1, 1, getString(2131231030));
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public final void c(MenuItem menuItem, int i) {
        int i2 = ((AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        if (this.gQq != null && i2 >= 0) {
            final w mm = this.gQq.mm(i2);
            switch (i) {
                case 0:
                    com.tencent.mm.ui.base.g.b(this, getString(2131233455), "", getString(2131231020), getString(2131231010), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ContactLabelManagerUI gQx;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (mm == null) {
                                return;
                            }
                            if (mm.field_isTemporary) {
                                this.gQx.vD(mm.field_labelID);
                            } else {
                                ContactLabelManagerUI.a(this.gQx, mm);
                            }
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ContactLabelManagerUI gQx;

                        {
                            this.gQx = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                case 1:
                    Intent intent = new Intent();
                    intent.setClass(this, ContactLabelEditUI.class);
                    intent.putExtra("label_id", mm.field_labelID);
                    intent.putExtra("label_name", mm.field_labelName);
                    startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 636:
                if (i == 0 && i2 == 0) {
                    vD(((com.tencent.mm.plugin.label.a.b) kVar).gPS);
                    return;
                }
                v.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
                avR();
                return;
            default:
                v.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
                return;
        }
    }

    private synchronized void dS(final boolean z) {
        v.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", new Object[]{String.valueOf(z)});
        if (z && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(5002, 400);
        }
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ ContactLabelManagerUI gQx;

            public final void run() {
                this.gQx.gQr = com.tencent.mm.plugin.label.e.avK().bvu();
                if (this.gQx.gQr == null || this.gQx.gQr.size() <= 0) {
                    v.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
                    if (this.gQx.gQt) {
                        g.iuh.h(11346, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                        this.gQx.gQt = false;
                    }
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 gQz;

                        {
                            this.gQz = r1;
                        }

                        public final void run() {
                            ContactLabelManagerUI.a(this.gQz.gQx, b.Empty);
                            if (z && this.gQz.gQx.mHandler != null) {
                                this.gQz.gQx.mHandler.removeMessages(5002);
                                this.gQz.gQx.mHandler.sendEmptyMessageDelayed(5003, 0);
                            }
                        }
                    });
                    return;
                }
                v.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
                if (this.gQx.gQt) {
                    g.iuh.h(11346, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                    this.gQx.gQt = false;
                }
                if (this.gQx.gQr != null && this.gQx.gQr.size() > 0) {
                    int size = this.gQx.gQr.size();
                    com.tencent.mm.plugin.label.e.avK().avF();
                    for (int i = 0; i < size; i++) {
                        int i2 = ((w) this.gQx.gQr.get(i)).field_labelID;
                        ArrayList LN = com.tencent.mm.plugin.label.e.avK().LN(String.valueOf(i2));
                        if (LN == null || LN.size() <= 0) {
                            this.gQx.gQs.put(Integer.valueOf(i2), Integer.valueOf(0));
                        } else {
                            this.gQx.gQs.put(Integer.valueOf(i2), Integer.valueOf(LN.size()));
                        }
                    }
                }
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 gQz;

                    {
                        this.gQz = r1;
                    }

                    public final void run() {
                        ContactLabelManagerUI.a(this.gQz.gQx, b.Normal);
                        a h = this.gQz.gQx.gQq;
                        h.mData = this.gQz.gQx.gQr;
                        h.notifyDataSetChanged();
                        this.gQz.gQx.gQq.notifyDataSetInvalidated();
                        if (z && this.gQz.gQx.mHandler != null) {
                            this.gQz.gQx.mHandler.removeMessages(5002);
                            this.gQz.gQx.mHandler.sendEmptyMessageDelayed(5003, 400);
                        }
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|updateData";
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 7001:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    v.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
                    if (!be.kS(stringExtra)) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this, ContactLabelEditUI.class);
                        intent2.putExtra("Select_Contact", stringExtra);
                        startActivity(intent2);
                        break;
                    }
                    break;
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private void vD(String str) {
        if (com.tencent.mm.plugin.label.e.avK().hc(str)) {
            avM();
            dS(false);
            return;
        }
        v.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
        avR();
    }

    private void avR() {
        avM();
        rI(getString(2131232273));
    }
}
