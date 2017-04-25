package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.a.h;
import com.tencent.mm.plugin.emoji.d.n;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.f.b;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class a extends p implements OnScrollListener, OnItemClickListener, com.tencent.mm.plugin.emoji.a.h.a, com.tencent.mm.plugin.emoji.model.f.a, b, com.tencent.mm.pluginsdk.model.f.a, com.tencent.mm.sdk.h.g.a, c, d, e, com.tencent.mm.v.e {
    ListView Eq;
    private ActionBar FG;
    private View dZV;
    private ProgressDialog eZg;
    com.tencent.mm.plugin.emoji.a.a.a fcY;
    EmojiStoreVpHeader ffA;
    private MMPullDownView ffD;
    private TextView ffE;
    private int ffG = -1;
    private boolean ffH;
    private View ffI;
    private byte[] ffJ;
    private final int ffN = 131074;
    private final int ffO = 131075;
    private final int ffP = 131076;
    private final String ffQ = "product_id";
    private final String ffR = "progress";
    private final String ffS = "status";
    private m ffT;
    private int ffU;
    private com.tencent.mm.plugin.emoji.model.e ffV;
    private f ffW;
    private com.tencent.mm.sdk.c.c ffY = new com.tencent.mm.sdk.c.c<cb>(this) {
        final /* synthetic */ a fny;

        {
            this.fny = r2;
            this.nhz = cb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            cb cbVar = (cb) bVar;
            if (cbVar != null) {
                a aVar = this.fny;
                String str = cbVar.aZC.aZD;
                int i = cbVar.aZC.status;
                int i2 = cbVar.aZC.progress;
                v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), cbVar.aZC.aZE});
                if (!(aVar.fcY == null || aVar.fcY.eZW == null)) {
                    if (i == 6) {
                        Message obtain = Message.obtain();
                        obtain.getData().putString("product_id", str);
                        obtain.getData().putInt("progress", i2);
                        obtain.what = 131075;
                        aVar.h(obtain);
                    } else {
                        v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "product status:%d", new Object[]{Integer.valueOf(i)});
                        Message obtain2 = Message.obtain();
                        obtain2.getData().putString("product_id", str);
                        obtain2.getData().putInt("status", i);
                        obtain2.what = 131076;
                        aVar.h(obtain2);
                    }
                    com.tencent.mm.plugin.emoji.a.a.f qY = aVar.fcY.eZW.qY(str);
                    if (qY != null) {
                        qY.fal = r4;
                    }
                }
            }
            return false;
        }
    };
    private g ffZ;
    private boolean fga = false;
    private LinkedList<oa> fgb = new LinkedList();
    private LinkedList<oc> fgc = new LinkedList();
    private final int fnq = 131077;
    private com.tencent.mm.ui.b fnr;
    public EmojiStoreV2HotBarView fns;
    private boolean fnt = false;
    private boolean fnu = false;
    private boolean fnv = false;
    private ac fnw = new ac(this) {
        final /* synthetic */ a fny;

        {
            this.fny = r1;
        }

        public final void handleMessage(Message message) {
            a aVar = this.fny;
            String string;
            switch (message.what) {
                case 131074:
                    if (aVar.fcY != null) {
                        aVar.fcY.notifyDataSetChanged();
                        return;
                    }
                    return;
                case 131075:
                    if (aVar.fcY != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            aVar.fcY.ao(string, message.getData().getInt("progress"));
                            return;
                        }
                        return;
                    }
                    return;
                case 131076:
                    if (aVar.fcY != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            aVar.fcY.an(string, message.getData().getInt("status"));
                            return;
                        }
                        return;
                    }
                    return;
                case 131077:
                    if (aVar.ffA != null) {
                        aVar.ffA.ahf();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private OnMenuItemClickListener fnx = new OnMenuItemClickListener(this) {
        final /* synthetic */ a fny;

        {
            this.fny = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.fny.bzo().finish();
            return false;
        }
    };

    public abstract com.tencent.mm.plugin.emoji.a.a.a age();

    public abstract int agm();

    public abstract boolean ahY();

    public abstract boolean ahZ();

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onAttach");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(1);
        this.FG = ((ActionBarActivity) bzo()).cU().cV();
        View inflate = q.em(this.nDR.nEl).inflate(2130903073, null);
        this.fnr = new com.tencent.mm.ui.b(inflate);
        this.FG.setLogo(new ColorDrawable(getResources().getColor(17170445)));
        this.FG.cQ();
        this.FG.setDisplayHomeAsUpEnabled(false);
        this.FG.cP();
        this.FG.cR();
        this.FG.setCustomView(inflate);
        this.FG.show();
        this.fnr.dtY.setText(2131232365);
        this.fnr.i(new OnClickListener(this) {
            final /* synthetic */ a fny;

            {
                this.fny = r1;
            }

            public final void onClick(View view) {
                if (this.fny.nDR.nEb && this.fny.fnx != null) {
                    this.fny.fnx.onMenuItemClick(null);
                }
            }
        });
        iU(true);
        a(0, 2131165208, new OnMenuItemClickListener(this) {
            final /* synthetic */ a fny;

            {
                this.fny = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.setClass(this.fny.bzo(), EmojiMineUI.class);
                this.fny.startActivity(intent);
                return false;
            }
        });
        com.tencent.mm.sdk.c.a.nhr.e(this.ffY);
        com.tencent.mm.plugin.emoji.model.g.afx().fci.c(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onCreateView");
        return layoutInflater.inflate(getLayoutId(), viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.fnv = true;
        this.fcY = age();
        this.fcY.eZX = this;
        this.dZV = findViewById(2131755597);
        this.ffE = (TextView) this.dZV.findViewById(2131756681);
        this.ffI = bzo().getLayoutInflater().inflate(2130903487, null);
        this.ffI.setVisibility(8);
        this.ffA = new EmojiStoreVpHeader(this.nDR.nEl);
        this.Eq = (ListView) findViewById(16908298);
        this.Eq.addHeaderView(this.ffA);
        if (!ahZ()) {
            this.fns = new EmojiStoreV2HotBarView(this.nDR.nEl);
            EmojiStoreV2HotBarView emojiStoreV2HotBarView = this.fns;
            if (emojiStoreV2HotBarView.fol != null) {
                emojiStoreV2HotBarView.fol.setVisibility(8);
            }
            emojiStoreV2HotBarView = this.fns;
            if (emojiStoreV2HotBarView.foj != null) {
                int N = com.tencent.mm.bd.a.N(emojiStoreV2HotBarView.getContext(), 2131493143);
                int N2 = com.tencent.mm.bd.a.N(emojiStoreV2HotBarView.getContext(), 2131493152);
                int N3 = com.tencent.mm.bd.a.N(emojiStoreV2HotBarView.getContext(), 2131493168);
                emojiStoreV2HotBarView.foj.setPadding(N3, N, N3, N2);
            }
            this.Eq.addHeaderView(this.fns);
        }
        this.Eq.addFooterView(this.ffI);
        this.Eq.setAdapter(this.fcY);
        if (ahZ()) {
            this.Eq.setOnItemClickListener(this);
        } else {
            ((h) this.fcY).eZG = this;
        }
        this.Eq.setOnScrollListener(this);
        this.Eq.setLongClickable(false);
        this.Eq.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ a fny;

            {
                this.fny = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.fcY.eZV = this.Eq;
        this.ffD = (MMPullDownView) findViewById(2131756685);
        if (this.ffD != null) {
            this.ffD.jr(false);
            this.ffD.nXg = this;
            this.ffD.nWU = this;
            this.ffD.nXf = this;
            this.ffD.jq(false);
            this.ffD.jp(false);
            this.ffD.nXq = true;
        }
        if (this.fnt) {
            ahV();
        }
    }

    public void onStart() {
        super.onStart();
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStart");
    }

    public void onResume() {
        super.onResume();
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
        ak.vy().a(411, this);
        ak.vy().a(423, this);
        if (this.fnt) {
            if (this.fnw != null) {
                this.fnw.sendEmptyMessageDelayed(131077, 4000);
            }
            if (!(this.fcY == null || this.fcY.eZW == null)) {
                this.fcY.eZW.aeO();
                this.fcY.acO();
            }
            ak.yW();
            if (((Boolean) com.tencent.mm.model.c.vf().get(208900, Boolean.valueOf(false))).booleanValue()) {
                afo();
                ak.yW();
                com.tencent.mm.model.c.vf().set(208900, Boolean.valueOf(false));
            }
        }
    }

    public final void setUserVisibleHint(boolean z) {
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "setUserVisibleHint :%b", new Object[]{Boolean.valueOf(z)});
        super.setUserVisibleHint(z);
        this.fnt = z;
        if (!this.fnu && this.fnv) {
            ahV();
        }
    }

    public void onPause() {
        super.onPause();
        ak.vy().b(411, this);
        ak.vy().b(423, this);
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onPause");
        if (this.ffA != null) {
            this.ffA.ahg();
        }
        if (this.fnw != null) {
            this.fnw.removeMessages(131077);
        }
    }

    public void onStop() {
        super.onStop();
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onResume");
    }

    public void onDestroy() {
        super.onDestroy();
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDestroy");
        if (this.fcY != null) {
            this.fcY.clear();
            this.fcY = null;
        }
        if (this.ffA != null) {
            this.ffA.ahg();
            this.ffA.clear();
        }
        com.tencent.mm.sdk.c.a.nhr.f(this.ffY);
        com.tencent.mm.plugin.emoji.model.g.afx().fci.d(this);
    }

    public void onDetach() {
        super.onDetach();
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onDetach");
    }

    private void ahV() {
        int i = 0;
        this.fnu = true;
        this.ffW = new f();
        this.ffW.fda = bzo();
        this.ffW.fdb = this;
        this.ffW.fcY = this.fcY;
        if (ahZ()) {
            this.ffW.fdc = 1;
        } else {
            this.ffW.fdc = 2;
        }
        this.ffW.fdf = this;
        this.ffU = bzo().getIntent().getIntExtra("preceding_scence", 5);
        vt vo = com.tencent.mm.plugin.emoji.model.g.afx().fck.vo(agm());
        com.tencent.mm.plugin.emoji.model.e a = m.a(vo);
        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
        String str2 = "load cache type: %d, size: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(agm());
        objArr[1] = Integer.valueOf(vo == null ? 0 : vo.myh);
        v.d(str, str2, objArr);
        if (a != null && a.fcT.size() > 0) {
            int size;
            int i2;
            int i3;
            this.fga = true;
            this.dZV.setVisibility(8);
            this.ffD.setVisibility(0);
            a(this.ffG, a);
            if (vo != null) {
                size = vo.myt == null ? 0 : vo.myt.size();
                i2 = vo.myq;
                int i4 = vo.myr;
                i3 = i2;
                i2 = size;
                size = i4;
            } else {
                size = 0;
                i3 = 0;
                i2 = 0;
            }
            v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "load cache hotcount:%d type:%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(agm())});
            if (this.fcY != null && ahZ()) {
                this.fcY.jD(i3 + i2);
                this.fcY.jE(size);
            }
            agl();
            i = 1;
        }
        if (i == 0 || this.fnw == null) {
            cD(true);
        } else {
            this.fnw.postDelayed(new Runnable(this) {
                final /* synthetic */ a fny;

                {
                    this.fny = r1;
                }

                public final void run() {
                    this.fny.cD(false);
                }
            }, 3000);
        }
    }

    public final void cD(boolean z) {
        v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "loadNetWork force:%b isNeedToRefresh:%b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(ahX())});
        if (!z) {
            ahX();
        }
        af(this.ffJ);
        ahW();
    }

    private void af(byte[] bArr) {
        int agm = agm();
        int i = this.ffU == 1 ? 1 : 2;
        if (bArr != null) {
            v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer %s", new Object[]{bArr.toString()});
            this.ffT = new m(agm, bArr, i);
            return;
        }
        v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[refreshNetSceneGetEmotionList] request buffer is null.");
        this.ffT = new m(agm, i);
    }

    private void ahW() {
        ak.vy().a(this.ffT, 0);
    }

    private static boolean ahX() {
        ak.yW();
        ((Long) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noH, Long.valueOf(0))).longValue();
        return true;
    }

    private void a(int i, com.tencent.mm.plugin.emoji.model.e eVar) {
        int i2;
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "");
        int i3;
        switch (i) {
            case -1:
                this.ffV = eVar;
                i2 = 1;
                i3 = 1;
                break;
            case 0:
                this.ffV = eVar;
                i2 = 0;
                i3 = 0;
                break;
            case 1:
                this.ffV = eVar;
                i2 = 0;
                i3 = 1;
                break;
            case 2:
                if (this.ffV == null) {
                    this.ffV = new com.tencent.mm.plugin.emoji.model.e();
                }
                this.ffV.jM(eVar.fcS);
                this.ffV.ak(eVar.fcT);
                i2 = 0;
                i3 = 1;
                break;
            default:
                i2 = 0;
                i3 = 0;
                break;
        }
        if (this.ffV != null) {
            this.ffV.afn();
        }
        if (!(this.ffV == null || !ahY() || r3 == 0)) {
            com.tencent.mm.plugin.emoji.model.e eVar2 = this.ffV;
            ActionBarActivity actionBarActivity = this.nDR.nEl;
            eVar2.fcS++;
            List list = eVar2.fcT;
            ol olVar = new ol();
            olVar.mdM = com.tencent.mm.storage.a.a.nwJ;
            olVar.gnp = "";
            olVar.mqd = actionBarActivity.getString(2131232422);
            olVar.mqe = actionBarActivity.getString(2131232420);
            olVar.mqf = actionBarActivity.getString(2131232418);
            olVar.mqg = "";
            olVar.mqh = 0;
            olVar.mqi = 1;
            olVar.mql = "";
            olVar.mqm = 0;
            olVar.mqn = actionBarActivity.getString(2131232419);
            olVar.mqK = 0;
            olVar.mqq = "";
            olVar.mqo = "";
            olVar.mqp = "";
            olVar.mqL = "";
            olVar.mqu = actionBarActivity.getString(2131232421);
            olVar.mqM = "";
            list.add(new com.tencent.mm.plugin.emoji.a.a.f(olVar));
            v.d("MicroMsg.emoji.EmotionListModel", "remove tuzi form store");
        }
        if (this.ffV != null && r3 != 0) {
            if (i2 != 0) {
                if (this.ffV == null) {
                    v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "update store ui header failed. ");
                } else {
                    this.fgb = (LinkedList) this.ffV.fcV;
                    this.fgc = (LinkedList) this.ffV.fcW;
                    if (this.fgb != null) {
                        this.ffA.b(this.fgb, this.fgc);
                    } else if (this.ffV.fcU != null) {
                        this.fgb = new LinkedList();
                        this.fgb.add(this.ffV.fcU);
                        this.ffA.b(this.fgb, this.fgc);
                    }
                }
            }
            if (this.fcY != null) {
                this.fcY.b(this.ffV);
            }
        }
    }

    private void agl() {
        com.tencent.mm.plugin.emoji.a.a.b.a(this.fcY.eZW, (com.tencent.mm.pluginsdk.model.f.a) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
        switch (kVar.getType()) {
            case 411:
                m mVar = (m) kVar;
                if (mVar != null && mVar.mType == agm()) {
                    int i3;
                    int i4;
                    int i5 = 0;
                    if (mVar == null || mVar.afP() == null) {
                        i3 = 0;
                        i4 = 0;
                        i5 = 0;
                    } else {
                        if (this.fcY.aeK() <= 0 && ahZ()) {
                            if (mVar.afP().myt == null) {
                                i5 = 0;
                            } else {
                                i5 = mVar.afP().myt.size();
                            }
                            this.fcY.jF(i5);
                        }
                        i3 = mVar.afP().myq;
                        i4 = i5;
                        i5 = mVar.afP().myr;
                    }
                    v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onSceneEnd setSize:%d hotcount:%d recentHotCount:%d type:%d getSceneType:%d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(r4), Integer.valueOf(mVar.mType)});
                    if (this.fcY != null && this.fcY.aeJ() <= 0 && ahZ()) {
                        this.fcY.jD(i3 + this.fcY.aeK());
                        this.fcY.jE(i5);
                    }
                    this.ffH = false;
                    this.ffI.setVisibility(8);
                    Object obj = (i == 0 || i == 4) ? 1 : null;
                    if (obj != null) {
                        this.dZV.setVisibility(8);
                        this.ffD.setVisibility(0);
                        m mVar2 = (m) kVar;
                        com.tencent.mm.plugin.emoji.model.e a = m.a(mVar2.afP());
                        this.ffJ = mVar2.fek;
                        vt afP;
                        if (i2 == 0) {
                            afP = mVar2.afP();
                            a(this.ffG, a);
                            d(afP);
                            this.ffG = 0;
                        } else if (i2 == 2) {
                            afP = mVar2.afP();
                            a(this.ffG, a);
                            agl();
                            d(afP);
                            this.ffG = 2;
                        } else if (i2 == 3) {
                            a(this.ffG, a);
                            this.ffG = 1;
                        } else {
                            this.dZV.setVisibility(0);
                            this.ffD.setVisibility(8);
                            this.ffE.setText(2131232382);
                        }
                    } else if (!this.fga) {
                        this.dZV.setVisibility(0);
                        this.ffD.setVisibility(8);
                        this.ffE.setText(2131232383);
                    }
                    if (ahZ()) {
                        if (!(mVar.afP() == null || mVar.afP().myt == null || mVar.afP().myt.size() <= 0)) {
                            for (i3 = 0; i3 < mVar.afP().myt.size(); i3++) {
                                com.tencent.mm.plugin.report.service.g.iuh.h(13223, new Object[]{Integer.valueOf(0), Integer.valueOf(((oc) mVar.afP().myt.get(i3)).aRI), ((oc) mVar.afP().myt.get(i3)).aXz, Integer.valueOf(0)});
                            }
                        }
                        if (mVar.afP().myr > 0 && mVar.afP().myi != null && mVar.afP().myi.size() > mVar.afP().myq + mVar.afP().myr) {
                            for (i3 = 0; i3 < mVar.afP().myr; i3++) {
                                com.tencent.mm.plugin.report.service.g.iuh.h(13223, new Object[]{Integer.valueOf(0), ((ol) mVar.afP().myi.get(mVar.afP().myq + i3)).mdM, ((ol) mVar.afP().myi.get(mVar.afP().myq + i3)).mqd, Integer.valueOf(1)});
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            default:
                v.w("MicroMsg.emoji.EmojiStoreV2BaseFragment", "unknow scene type.");
                return;
        }
    }

    public final boolean agi() {
        v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onBottomLoadData] startLoadRemoteEmoji.");
        cE(true);
        return true;
    }

    public final boolean agu() {
        return false;
    }

    public final boolean agv() {
        return false;
    }

    private void d(final vt vtVar) {
        if (this.ffG == -1) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ a fny;

                public final void run() {
                    int i = 0;
                    if (vtVar != null) {
                        String str = "MicroMsg.emoji.EmojiStoreV2BaseFragment";
                        String str2 = "jacks save EmoijStoreUI Cache: list:%d, size: %d, type: %d";
                        Object[] objArr = new Object[3];
                        objArr[0] = Integer.valueOf(vtVar == null ? 0 : vtVar.myh);
                        if (!(vtVar == null || vtVar.mcz == null)) {
                            i = vtVar.mcz.aHr();
                        }
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = Integer.valueOf(this.fny.agm());
                        v.d(str, str2, objArr);
                        com.tencent.mm.plugin.emoji.model.g.afx().fck.a(this.fny.agm(), vtVar);
                    }
                }
            });
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        if (aVar.aey() == 9) {
            rK(getString(2131231169));
        }
        if (!ahZ()) {
            this.ffW.fdc = 2;
        } else if (aVar.kB >= 0 && aVar.kB < this.fcY.aeI()) {
            this.ffW.fdc = 3;
        } else if (aVar.kB < this.fcY.aeI() || aVar.kB >= this.fcY.aeJ() + this.fcY.aeI()) {
            this.ffW.fdc = 1;
        } else {
            this.ffW.fdc = 19;
        }
        this.ffW.a(aVar);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        int headerViewsCount = i - this.Eq.getHeaderViewsCount();
        if (headerViewsCount >= 0 && headerViewsCount < this.fcY.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f jG = this.fcY.jG(headerViewsCount);
            a(jG, headerViewsCount);
            if (ahZ() && this.fcY.aeJ() > 0 && headerViewsCount >= this.fcY.aeI() && headerViewsCount < this.fcY.aeI() + this.fcY.aeJ() && jG.fai != null) {
                com.tencent.mm.plugin.report.service.g.iuh.h(13223, new Object[]{Integer.valueOf(1), jG.fai.mdM, jG.fai.mqd, Integer.valueOf(1), Integer.valueOf(0)});
            }
        }
    }

    public final void jH(int i) {
        if (i >= 0 && i < ((h) this.fcY).aeM()) {
            a(this.fcY.jG(i), i);
        }
    }

    private void a(com.tencent.mm.plugin.emoji.a.a.f fVar, int i) {
        if (fVar == null) {
            v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "item is null.");
        } else if (fVar.fah == com.tencent.mm.plugin.emoji.a.a.f.a.faq) {
            oc ocVar = fVar.faj;
            if (ocVar == null) {
                v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "banner set is null. do nothing");
            } else {
                n.a(this.nDR.nEl, ocVar, false);
            }
        } else {
            ol olVar = fVar.fai;
            if (olVar == null) {
                v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "summary is null. do nothing");
                return;
            }
            int i2;
            if (!ahZ()) {
                i2 = 2;
            } else if (i >= 0 && i < this.fcY.aeI()) {
                i2 = 3;
            } else if (i < this.fcY.aeI() || i >= this.fcY.aeJ() + this.fcY.aeI()) {
                i2 = 1;
            } else {
                i2 = 19;
            }
            n.a(this.nDR.nEl, olVar, i2, fVar.mStatus, fVar.rT, bzo().getIntent().getStringExtra("to_talker_name"), 5);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.ffG == 0 || this.ffH) {
            v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "No More List.");
            return;
        }
        cE(true);
        v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
        if (this.ffW != null) {
            this.ffW.onActivityResult(i, i2, intent);
        } else {
            v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "mPayOrDownloadComponent have no init.");
        }
    }

    public final void B(String str, String str2, String str3) {
        this.ffZ = new g(str, str2, str3);
        ak.vy().a(this.ffZ, 0);
    }

    public final void afo() {
        this.ffJ = null;
        this.ffG = -1;
        cE(false);
    }

    private void cE(boolean z) {
        if (this.ffH) {
            v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "isLoading");
            return;
        }
        this.ffH = true;
        if (z) {
            this.ffI.setVisibility(0);
        }
        af(this.ffJ);
        ahW();
        v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[startLoadRemoteEmoji] doScene GetEmotionListNetScene");
        if (!z) {
            rK(getString(2131231182));
        }
    }

    public final void h(Message message) {
        if (this.fnw != null) {
            this.fnw.sendMessage(message);
        }
    }

    private void rK(String str) {
        if (isFinishing()) {
            v.i("MicroMsg.emoji.EmojiStoreV2BaseFragment", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        FragmentActivity bzo = bzo();
        getString(2131231164);
        this.eZg = com.tencent.mm.ui.base.g.a(bzo, str, true, new OnCancelListener(this) {
            final /* synthetic */ a fny;

            {
                this.fny = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                a.agp();
            }
        });
    }

    protected static void agp() {
    }

    public final void y(ArrayList<o> arrayList) {
        v.d("MicroMsg.emoji.EmojiStoreV2BaseFragment", "google [onQueryFinish]");
        if (this.fcY != null) {
            if (this.fnw != null) {
                this.fnw.sendEmptyMessageDelayed(131074, 50);
            }
            com.tencent.mm.plugin.emoji.a.a.b.a((ArrayList) arrayList, this.fcY.eZW);
        }
    }

    public final void a(String str, i iVar) {
        if (!TextUtils.isEmpty(str) && str.equals("delete_group") && this.fnw != null) {
            this.fnw.sendEmptyMessageDelayed(131074, 50);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.ffA != null) {
            this.ffA.requestLayout();
        }
        setRequestedOrientation(1);
    }
}
