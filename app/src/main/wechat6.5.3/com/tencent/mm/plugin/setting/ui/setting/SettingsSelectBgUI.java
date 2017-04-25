package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.al.b;
import com.tencent.mm.al.j;
import com.tencent.mm.al.k;
import com.tencent.mm.al.m;
import com.tencent.mm.al.n;
import com.tencent.mm.al.t;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.List;

public class SettingsSelectBgUI extends MMActivity implements e {
    private boolean iLV;
    private a iMP;
    private GridView iMQ;
    private j iMR;
    private List<j> iMS = new ArrayList();
    private ah iMT = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ SettingsSelectBgUI iMU;

        {
            this.iMU = r1;
        }

        public final boolean oU() {
            if (this.iMU.findViewById(2131759092).getWidth() <= 0) {
                return true;
            }
            SettingsSelectBgUI.a(this.iMU);
            return false;
        }
    }, true);
    private String username;

    class a extends com.tencent.mm.ui.j<m> {
        private Context context;
        private int eOr;
        final /* synthetic */ SettingsSelectBgUI iMU;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (m) obj;
            if (obj == null) {
                obj = new m();
            }
            obj.b(cursor);
            return obj;
        }

        public a(SettingsSelectBgUI settingsSelectBgUI, Context context, int i) {
            this.iMU = settingsSelectBgUI;
            super(context, new m());
            this.context = context;
            this.eOr = i;
        }

        public final int getCount() {
            return getCursor().getCount() + 2;
        }

        protected final void Om() {
            Ol();
        }

        public final void Ol() {
            n HS = t.HS();
            setCursor(HS.cuX.rawQuery(new StringBuilder("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=1").toString(), null));
            super.notifyDataSetChanged();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = View.inflate(this.context, 2130904362, null);
                view.setLayoutParams(new LayoutParams(this.eOr, this.eOr));
                c cVar2 = new c();
                cVar2.iNx = (LinearLayout) view.findViewById(2131759094);
                cVar2.iNy = (LinearLayout) view.findViewById(2131759097);
                cVar2.iNz = (LinearLayout) view.findViewById(2131759098);
                cVar2.iNA = (LinearLayout) view.findViewById(2131759099);
                cVar2.iNB = (LinearLayout) view.findViewById(2131759100);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            ak.yW();
            int a = be.a((Integer) c.vf().get(12311, null), -2);
            com.tencent.mm.al.a jt = t.HT().jt(this.iMU.username);
            if (i != 0) {
                if (i != 1) {
                    Bitmap JV;
                    m mVar = (m) getItem(i - 2);
                    t.HS();
                    ak.yW();
                    if (c.isSDCardAvailable()) {
                        JV = d.JV(n.HO() + n.aL(mVar.id, mVar.cUv));
                    } else {
                        JV = BitmapFactory.decodeResource(this.iMU.getResources(), 2130838792);
                    }
                    if (JV != null) {
                        ((ImageView) view.findViewById(2131759093)).setImageBitmap(d.a(JV, true, 10.0f));
                        switch (mVar.status) {
                            case 1:
                                if (!this.iMU.iLV && jt != null && jt.cTU != mVar.id) {
                                    cVar.zo("downloaded");
                                    break;
                                }
                                cVar.zo("using");
                                break;
                                break;
                            case 2:
                                if (!this.iMU.iLV && jt != null && jt.cTU == mVar.id) {
                                    cVar.zo("using");
                                    break;
                                }
                                cVar.zo("downloaded");
                                break;
                                break;
                            case 3:
                                cVar.zo("downloading");
                                break;
                            case 4:
                                cVar.zo("canceling");
                                break;
                            case 5:
                                cVar.zo("undownloaded");
                                break;
                            default:
                                break;
                        }
                    }
                }
                if (!(this.iMU.iLV && a == 0) && (!(!this.iMU.iLV && a == 0 && jt == null) && (jt == null || jt.cTU != 0))) {
                    cVar.zo("downloaded");
                } else {
                    cVar.zo("using");
                }
                ((ImageView) view.findViewById(2131759093)).setImageBitmap(d.a(BitmapFactory.decodeResource(this.context.getResources(), 2130837983), true, 10.0f));
            } else {
                if (!(this.iMU.iLV && a == -2) && (!(!this.iMU.iLV && a == -2 && jt == null) && (jt == null || jt.cTU != -2))) {
                    cVar.zo("downloaded");
                } else {
                    cVar.zo("using");
                }
                ((ImageView) view.findViewById(2131759093)).setImageBitmap(d.a(BitmapFactory.decodeResource(this.context.getResources(), 2130837984), true, 10.0f));
            }
            return view;
        }
    }

    static /* synthetic */ void a(SettingsSelectBgUI settingsSelectBgUI) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) settingsSelectBgUI.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        settingsSelectBgUI.iMP = new a(settingsSelectBgUI, settingsSelectBgUI, ((displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels) - 60) / 3);
        settingsSelectBgUI.iMQ = (GridView) settingsSelectBgUI.findViewById(2131759092);
        t.HS().c(settingsSelectBgUI.iMP);
        settingsSelectBgUI.iMQ.setAdapter(settingsSelectBgUI.iMP);
        settingsSelectBgUI.iMQ.setOnItemClickListener(new OnItemClickListener(settingsSelectBgUI) {
            final /* synthetic */ SettingsSelectBgUI iMU;

            {
                this.iMU = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    SettingsSelectBgUI.a(this.iMU, -2);
                    this.iMU.iMP.Ol();
                    if (!this.iMU.iLV) {
                        this.iMU.setResult(-1);
                        this.iMU.finish();
                    }
                } else if (i == 1) {
                    SettingsSelectBgUI.a(this.iMU, 0);
                    this.iMU.iMP.Ol();
                    if (!this.iMU.iLV) {
                        this.iMU.setResult(-1);
                        this.iMU.finish();
                    }
                } else {
                    ak.yW();
                    if (c.isSDCardAvailable()) {
                        m mVar = (m) adapterView.getItemAtPosition(i - 2);
                        if (mVar == null) {
                            v.e("MicroMsg.SettingsSelectBgUI", "onItemClick fail, info is null, position = " + i);
                            return;
                        }
                        n HS;
                        switch (mVar.status) {
                            case 1:
                            case 2:
                                SettingsSelectBgUI.a(this.iMU, mVar.id);
                                if (this.iMU.iLV) {
                                    mVar.status = 1;
                                    HS = t.HS();
                                    HS.fS(mVar.cUv);
                                    mVar.status = 1;
                                    HS.b(mVar);
                                } else {
                                    this.iMU.iMP.Ol();
                                }
                                if (!this.iMU.iLV) {
                                    this.iMU.setResult(-1);
                                    this.iMU.finish();
                                    return;
                                }
                                return;
                            case 3:
                                if (this.iMU.iMR != null && this.iMU.iMR.cUo == mVar.id) {
                                    ak.vy().c(this.iMU.iMR);
                                    t.HS().aO(this.iMU.iMR.cUo, 1);
                                    this.iMU.bj(this.iMU.iMS);
                                }
                                SettingsSelectBgUI.e(mVar.id, this.iMU.iMS);
                                HS = t.HS();
                                mVar.status = 4;
                                HS.b(mVar);
                                final int i2 = mVar.id;
                                new ac(this) {
                                    final /* synthetic */ AnonymousClass3 iMX;

                                    public final void handleMessage(Message message) {
                                        HS.aO(i2, 1);
                                    }
                                }.sendEmptyMessageDelayed(0, 1000);
                                return;
                            case 4:
                                t.HS().aO(mVar.id, 1);
                                return;
                            case 5:
                                if (this.iMU.iMR == null) {
                                    this.iMU.iMR = new j(mVar.id, 1);
                                    ak.vy().a(this.iMU.iMR, 0);
                                    return;
                                }
                                this.iMU.iMS.add(new j(mVar.id, 1));
                                return;
                            default:
                                return;
                        }
                    }
                    Toast.makeText(this.iMU, 2131235139, 1).show();
                }
            }
        });
    }

    static /* synthetic */ void a(SettingsSelectBgUI settingsSelectBgUI, int i) {
        ak.yW();
        c.vf().set(66820, Integer.valueOf(i));
        g.iuh.h(10198, new Object[]{Integer.valueOf(i)});
        v.i("MicroMsg.SettingsSelectBgUI", "set chating bg id:%d", new Object[]{Integer.valueOf(i)});
        if (settingsSelectBgUI.iLV) {
            ak.yW();
            c.vf().set(12311, Integer.valueOf(i));
            t.HS().fS(1);
            return;
        }
        b HT = t.HT();
        com.tencent.mm.al.a jt = HT.jt(settingsSelectBgUI.username);
        if (jt == null) {
            jt = new com.tencent.mm.al.a();
            jt.username = settingsSelectBgUI.username;
            jt.cTU = i;
            HT.a(jt);
            return;
        }
        jt.cTU = i;
        HT.b(jt);
    }

    static /* synthetic */ void e(int i, List list) {
        for (j jVar : list) {
            if (jVar.cUo == i) {
                t.HS().aO(jVar.cUo, 1);
                list.remove(jVar);
                return;
            }
        }
    }

    protected final int getLayoutId() {
        return 2130904361;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        ak.vy().a(159, this);
        ak.vy().a(160, this);
        ak.yW();
        if (c.isSDCardAvailable()) {
            ak.vy().a(new k(1), 0);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.iMR != null) {
            ak.vy().c(this.iMR);
            t.HS().aO(this.iMR.cUo, 1);
        }
        List<j> list = this.iMS;
        for (j jVar : list) {
            t.HS().aO(jVar.cUo, 1);
        }
        list.clear();
        ak.vy().b(159, this);
        ak.vy().b(160, this);
        this.iMP.avc();
        t.HS().d(this.iMP);
    }

    protected final void NI() {
        vD(2131234996);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsSelectBgUI iMU;

            {
                this.iMU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMU.finish();
                return true;
            }
        });
        this.iLV = getIntent().getBooleanExtra("isApplyToAll", true);
        this.username = getIntent().getStringExtra("username");
        this.iMT.ea(20);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if ((kVar instanceof com.tencent.mm.v.m) && ((com.tencent.mm.v.m) kVar).BI() == 1) {
            int type = kVar.getType();
            if (type == 159 || type == 160) {
                if (type == 160) {
                    bj(this.iMS);
                }
                if (i == 0 && i2 != 0) {
                    return;
                }
                return;
            }
            return;
        }
        v.d("MicroMsg.SettingsSelectBgUI", "another scene");
    }

    private void bj(List<j> list) {
        if (list.size() > 0) {
            this.iMR = (j) list.remove(0);
            ak.vy().a(this.iMR, 0);
            return;
        }
        this.iMR = null;
    }
}
