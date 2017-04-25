package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.la;
import com.tencent.mm.e.a.m;
import com.tencent.mm.e.a.pz;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.atk;
import com.tencent.mm.protocal.c.ayy;
import com.tencent.mm.protocal.c.yv;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.t.d;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.DataSetObserver;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class ServiceNotifySettingsUI extends MMActivity implements e {
    private ListView Eq;
    private String dQM;
    private MMSwitchBtn kIS;
    private int mMode;
    private a nGP;
    private p nGQ;
    private DataSetObserver nGR;

    private static class a extends BaseAdapter {
        private String dQM;
        private LayoutInflater dY;
        private Context mContext;
        private int mMode;
        private OnClickListener mOnClickListener;
        LinkedList<a> nGY = new LinkedList();
        LinkedList<a> nGZ = new LinkedList();
        private c nHa;

        private static class a {
            String title;
            String url;
            String username;

            private a() {
            }
        }

        private static class b {
            TextView dtB;
            ImageView dtz;
            TextView nHe;

            private b() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return vQ(i);
        }

        public a(Context context, LayoutInflater layoutInflater, final int i, String str) {
            this.mContext = context;
            this.mMode = i;
            this.dQM = str;
            this.dY = layoutInflater;
            this.mOnClickListener = new OnClickListener(this) {
                final /* synthetic */ a nHc;

                public final void onClick(View view) {
                    final String str = (String) view.getTag();
                    if (!TextUtils.isEmpty(str)) {
                        g.a(view.getContext(), i == 1 ? 2131234126 : 2131234129, 0, i == 1 ? 2131234127 : 2131231107, 2131231565, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 nHd;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                int i2 = 0;
                                while (i2 < this.nHd.nHc.nGY.size()) {
                                    a aVar = (a) this.nHd.nHc.nGY.get(i2);
                                    if (aVar == null || !str.equals(aVar.username)) {
                                        i2++;
                                    } else {
                                        this.nHd.nHc.nGZ.add(this.nHd.nHc.nGY.remove(i2));
                                        this.nHd.nHc.notifyDataSetChanged();
                                        com.tencent.mm.sdk.c.b mVar = new m();
                                        mVar.aWJ.aWH = str;
                                        com.tencent.mm.sdk.c.a.nhr.z(mVar);
                                        String ma = be.ma(mVar.aWK.appId);
                                        if (i == 1) {
                                            v.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, appId %s, mSceneId %s", Integer.valueOf(13798), Integer.valueOf(4), ma, this.nHd.nHc.dQM);
                                            com.tencent.mm.plugin.report.service.g.iuh.h(13798, Integer.valueOf(4), ma, Integer.valueOf(0), this.nHd.nHc.dQM, Long.valueOf(be.Nh()));
                                            return;
                                        }
                                        com.tencent.mm.plugin.report.service.g.iuh.h(13796, Integer.valueOf(12), ma, SQLiteDatabase.KeyEmpty, Integer.valueOf(0), Long.valueOf(be.Nh()));
                                        return;
                                    }
                                }
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 nHd;

                            {
                                this.nHd = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }, 2131689767);
                    }
                }
            };
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPP = true;
            aVar.cPM = com.tencent.mm.t.a.a.AK();
            this.nHa = aVar.GU();
        }

        public final int getCount() {
            return this.nGY.size();
        }

        private a vQ(int i) {
            return (a) this.nGY.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            a vQ = vQ(i);
            if (view == null) {
                view = this.dY.inflate(2130904346, viewGroup, false);
                b bVar2 = new b();
                bVar2.dtz = (ImageView) view.findViewById(2131759063);
                bVar2.dtB = (TextView) view.findViewById(2131755634);
                bVar2.nHe = (TextView) view.findViewById(2131759064);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            n.GL().a(vQ.url, bVar.dtz, this.nHa);
            bVar.dtB.setText(vQ.title);
            if (this.mMode == 1) {
                bVar.nHe.setText(this.mContext.getString(2131234123));
            } else {
                bVar.nHe.setText(this.mContext.getString(2131234124));
            }
            bVar.nHe.setTag(vQ.username);
            bVar.nHe.setOnClickListener(this.mOnClickListener);
            return view;
        }
    }

    static /* synthetic */ void a(ServiceNotifySettingsUI serviceNotifySettingsUI, LinkedList linkedList) {
        Collection linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            atk com_tencent_mm_protocal_c_atk = (atk) it.next();
            a aVar = new a();
            aVar.username = com_tencent_mm_protocal_c_atk.username;
            aVar.title = com_tencent_mm_protocal_c_atk.cID;
            aVar.url = com_tencent_mm_protocal_c_atk.mRC;
            linkedList2.add(aVar);
        }
        a aVar2 = serviceNotifySettingsUI.nGP;
        aVar2.nGY.clear();
        if (!linkedList2.isEmpty()) {
            aVar2.nGY.addAll(linkedList2);
        }
        serviceNotifySettingsUI.nGP.notifyDataSetChanged();
    }

    protected final int getLayoutId() {
        return 2130904347;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mMode = intent.getIntExtra("mode", 0);
        this.dQM = intent.getStringExtra("scene_id");
        intent.putExtra("scene_id", this.dQM);
        Object stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE);
        if (TextUtils.isEmpty(stringExtra)) {
            vD(2131234131);
        } else {
            Fd(stringExtra);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ServiceNotifySettingsUI nGS;

            {
                this.nGS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nGS.finish();
                return false;
            }
        });
        this.kIS = (MMSwitchBtn) findViewById(2131755241);
        this.Eq = (ListView) findViewById(2131755705);
        ((TextView) findViewById(2131759066)).setText(this.mMode == 1 ? 2131234115 : 2131234112);
        ((TextView) findViewById(2131759065)).setText(this.mMode == 1 ? 2131234116 : 2131234118);
        this.nGP = new a(this, getLayoutInflater(), this.mMode, this.dQM);
        this.Eq.setAdapter(this.nGP);
        getString(2131231164);
        this.nGQ = g.a((Context) this, getString(2131231182), true, new OnCancelListener(this) {
            final /* synthetic */ ServiceNotifySettingsUI nGS;

            {
                this.nGS = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.nGS.finish();
            }
        });
        this.nGR = new DataSetObserver(this) {
            final /* synthetic */ ServiceNotifySettingsUI nGS;

            {
                this.nGS = r1;
            }

            public final void onChanged() {
                this.nGS.findViewById(2131759066).setVisibility(this.nGS.nGP.isEmpty() ? 4 : 0);
            }
        };
        this.nGP.registerDataSetObserver(this.nGR);
        int i = 3;
        if (this.mMode == 1) {
            i = 12;
        }
        ak.vy().a(1145, (e) this);
        ak.vy().a(new com.tencent.mm.t.e(i), 0);
        this.kIS.kq(bAE());
    }

    protected void onDestroy() {
        int i;
        int i2 = 3;
        ak.vy().b(1145, (e) this);
        final boolean bAE = bAE();
        final boolean z = this.kIS.pdq != bAE;
        final LinkedList linkedList = new LinkedList();
        if (z) {
            int i3;
            boolean z2;
            ayy com_tencent_mm_protocal_c_ayy = new ayy();
            if (this.kIS.pdq) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            com_tencent_mm_protocal_c_ayy.mVZ = i3;
            if (this.mMode == 1) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            com_tencent_mm_protocal_c_ayy.efm = i3;
            linkedList.add(com_tencent_mm_protocal_c_ayy);
            if (bAE) {
                z2 = false;
            } else {
                z2 = true;
            }
            com.tencent.mm.storage.t.a aVar = com.tencent.mm.storage.t.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
            if (this.mMode == 1) {
                aVar = com.tencent.mm.storage.t.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
            }
            ak.yW();
            com.tencent.mm.model.c.vf().a(aVar, Boolean.valueOf(z2));
            com.tencent.mm.sdk.c.a.nhr.z(new la());
            if (this.mMode == 1) {
                if (com_tencent_mm_protocal_c_ayy.mVZ == 1) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                v.d("MicroMsg.ServiceNotifySettingsUI", "stev report(%s), eventId : %s, mSceneId %s", Integer.valueOf(13798), Integer.valueOf(i3), this.dQM);
                com.tencent.mm.plugin.report.service.g.iuh.h(13798, Integer.valueOf(i3), SQLiteDatabase.KeyEmpty, Integer.valueOf(0), this.dQM, Long.valueOf(be.Nh()));
            } else {
                i3 = com_tencent_mm_protocal_c_ayy.mVZ == 1 ? 11 : 10;
                com.tencent.mm.plugin.report.service.g.iuh.h(13796, Integer.valueOf(i3), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, Integer.valueOf(0), Long.valueOf(be.Nh()));
            }
        }
        if (this.mMode == 1) {
            i = 2;
        } else {
            i = 1;
        }
        LinkedList linkedList2 = this.nGP.nGZ;
        if (!(linkedList2 == null || linkedList2.isEmpty())) {
            if (this.mMode != 1) {
                i2 = 1;
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                ayy com_tencent_mm_protocal_c_ayy2 = new ayy();
                com_tencent_mm_protocal_c_ayy2.mWa = aVar2.username;
                com_tencent_mm_protocal_c_ayy2.efm = i2;
                com_tencent_mm_protocal_c_ayy2.mVZ = 1;
                linkedList.add(com_tencent_mm_protocal_c_ayy2);
                b pzVar = new pz();
                pzVar.brl.aWH = aVar2.username;
                pzVar.brl.action = 2;
                pzVar.brl.brn = i;
                com.tencent.mm.sdk.c.a.nhr.z(pzVar);
            }
        }
        if (!linkedList.isEmpty()) {
            ak.vy().a(1176, new e(this) {
                final /* synthetic */ ServiceNotifySettingsUI nGS;

                public final void a(int i, int i2, String str, k kVar) {
                    ak.vy().b(1176, (e) this);
                    v.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(BatchSwitchServiceNotifyOption), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i != 0 || i2 != 0) {
                        s.makeText(this.nGS, 2131234130, 0).show();
                        if (z) {
                            ak.yW();
                            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, Boolean.valueOf(bAE));
                            com.tencent.mm.sdk.c.a.nhr.z(new la());
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            ayy com_tencent_mm_protocal_c_ayy = (ayy) it.next();
                            b pzVar = new pz();
                            pzVar.brl.aWH = com_tencent_mm_protocal_c_ayy.mWa;
                            pzVar.brl.action = 1;
                            pzVar.brl.brn = i;
                            com.tencent.mm.sdk.c.a.nhr.z(pzVar);
                        }
                    }
                }
            });
            ak.vy().a(new d(linkedList), 0);
        }
        if (this.nGP != null) {
            this.nGP.unregisterDataSetObserver(this.nGR);
        }
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.nGQ != null) {
            this.nGQ.dismiss();
        }
        v.i("MicroMsg.ServiceNotifySettingsUI", "onSceneEnd(GetServiceNotifyOptions), errType : %s, errCode : %s, errMsg : %s.", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            final yv AH = ((com.tencent.mm.t.e) kVar).AH();
            if (this.mMode == 1) {
                this.kIS.kq(AH.mAK);
            } else {
                this.kIS.kq(AH.mgd);
            }
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ServiceNotifySettingsUI nGS;

                public final void run() {
                    if (this.nGS.mMode == 1) {
                        ServiceNotifySettingsUI.a(this.nGS, AH.mAL);
                    } else {
                        ServiceNotifySettingsUI.a(this.nGS, AH.mge);
                    }
                }
            });
            return;
        }
        s.makeText(this, 2131234121, 0).show();
    }

    private boolean bAE() {
        com.tencent.mm.storage.t.a aVar = com.tencent.mm.storage.t.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC;
        if (this.mMode == 1) {
            aVar = com.tencent.mm.storage.t.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC;
        }
        ak.yW();
        return com.tencent.mm.model.c.vf().b(aVar, true);
    }
}
