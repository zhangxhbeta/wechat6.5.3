package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.d.g;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.c.oi;
import com.tencent.mm.protocal.c.vr;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.IOException;
import java.util.LinkedList;

public class EmojiStoreV2RewardDetailUI extends MMActivity implements OnScrollListener, e {
    private ListView Eq;
    private View PH;
    private String fdK;
    private String fdV;
    private int ffG = -1;
    private vv fii;
    private ac fnw = new ac(this) {
        final /* synthetic */ EmojiStoreV2RewardDetailUI foD;

        {
            this.foD = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    if (this.foD.fow != null) {
                        this.foD.fow.setVisibility(8);
                        return;
                    }
                    return;
                case 1002:
                    if (this.foD.fow != null) {
                        this.foD.fow.setVisibility(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private l foA;
    private boolean foB = false;
    private com.tencent.mm.plugin.emoji.ui.v2.MMLoadScrollView.a foC = new com.tencent.mm.plugin.emoji.ui.v2.MMLoadScrollView.a(this) {
        final /* synthetic */ EmojiStoreV2RewardDetailUI foD;

        {
            this.foD = r1;
        }

        public final void aie() {
            v.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "onBottom");
            this.foD.cF(true);
        }
    };
    private String fop;
    private String foq;
    private ImageView for;
    private TextView fos;
    private TextView fot;
    private TextView fou;
    private View fov;
    private View fow;
    private a fox;
    private vr foy;
    private byte[] foz;

    class a extends BaseAdapter {
        private Bitmap aQs = null;
        private int eZD;
        int eZE;
        private int eZz = 1;
        int fnm;
        final /* synthetic */ EmojiStoreV2RewardDetailUI foD;
        private LinkedList<oi> foE;
        boolean foF = false;
        private Context mContext;

        public final /* synthetic */ Object getItem(int i) {
            return kc(i);
        }

        public a(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI, Context context) {
            this.foD = emojiStoreV2RewardDetailUI;
            this.mContext = context;
            this.fnm = com.tencent.mm.bd.a.N(emojiStoreV2RewardDetailUI.nDR.nEl, 2131493425);
            int dv = com.tencent.mm.bd.a.dv(emojiStoreV2RewardDetailUI.nDR.nEl) - (com.tencent.mm.bd.a.N(emojiStoreV2RewardDetailUI.nDR.nEl, 2131493135) * 2);
            int i = this.fnm;
            int N = com.tencent.mm.bd.a.N(emojiStoreV2RewardDetailUI.nDR.nEl, 2131493144);
            int i2 = dv / (i + N);
            if ((dv - (i2 * i)) - (N * (i2 - 1)) > i) {
                i2++;
            }
            this.eZz = i2;
            this.eZD = com.tencent.mm.bd.a.dv(this.mContext);
            this.eZE = (int) (((float) (this.eZD - (this.eZz * this.fnm))) / (((float) this.eZz) + 1.0f));
            try {
                this.aQs = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), com.tencent.mm.bd.a.getDensity(null), 0, 0);
            } catch (IOException e) {
                v.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[]{be.bur()});
            }
        }

        public final void C(LinkedList<oi> linkedList) {
            if (this.foE == null) {
                this.foE = new LinkedList();
            }
            if (this.foF) {
                this.foE.clear();
                this.foF = false;
            }
            this.foE.addAll(linkedList);
            notifyDataSetChanged();
        }

        public final int getCount() {
            int size = this.foE == null ? 0 : this.foE.size();
            if (size > 0) {
                return (int) Math.ceil((double) (((float) size) / ((float) this.eZz)));
            }
            return size;
        }

        private oi kc(int i) {
            if (this.foE != null) {
                if (i < (this.foE == null ? 0 : this.foE.size())) {
                    return (oi) this.foE.get(i);
                }
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null || view.getTag() == null) {
                view = new LinearLayout(this.mContext);
                LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
                view.setBackgroundResource(2130839576);
                view.setOrientation(0);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, this.eZE);
                bVar = new b(this.foD);
                bVar.eZK = view;
                view.setTag(bVar);
                for (int i2 = 0; i2 < this.eZz; i2++) {
                    LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.fnm, this.fnm);
                    layoutParams2.leftMargin = this.eZE;
                    bVar.eZK.addView(new SquareImageView(this.mContext), i2, layoutParams2);
                }
            } else {
                bVar = (b) view.getTag();
            }
            for (int i3 = 0; i3 < this.eZz; i3++) {
                SquareImageView squareImageView = (SquareImageView) bVar.eZK.getChildAt(i3);
                oi kc = kc((this.eZz * i) + i3);
                if (kc != null) {
                    squareImageView.setVisibility(0);
                    if (be.kS(kc.mqz)) {
                        squareImageView.setImageBitmap(this.aQs);
                    } else {
                        n.GL().a(kc.mqz, squareImageView, g.n(this.foD.fdK, kc.mqz, this.fnm));
                    }
                } else {
                    squareImageView.setVisibility(8);
                }
            }
            return view;
        }
    }

    class b {
        LinearLayout eZK;
        final /* synthetic */ EmojiStoreV2RewardDetailUI foD;

        b(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI) {
            this.foD = emojiStoreV2RewardDetailUI;
        }
    }

    protected final int getLayoutId() {
        return 2130903503;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fdK = getIntent().getStringExtra("extra_id");
        this.fdV = getIntent().getStringExtra("extra_name");
        this.fop = getIntent().getStringExtra("extra_iconurl");
        this.foq = getIntent().getStringExtra("name");
        NI();
        this.fii = com.tencent.mm.plugin.emoji.model.g.afx().fcm.NL(this.fdK);
        aid();
        n.GL().a(this.fop, this.for, g.bl(this.fdK, this.fop));
        this.fos.setText(this.fdV);
        this.fot.setText(this.foq);
        if (this.foy != null) {
            this.fox.C(this.foy.myf);
            this.fox.foF = true;
        }
        if (this.fii != null) {
            this.fou.setText(getString(2131232398, new Object[]{Integer.valueOf(this.fii.mye)}));
        }
        ak.vy().a(299, this);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(299, this);
        n.GL().ba(0);
    }

    protected final void NI() {
        vD(2131232397);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2RewardDetailUI foD;

            {
                this.foD = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.foD.finish();
                return false;
            }
        });
        this.PH = q.em(this.nDR.nEl).inflate(2130903504, null);
        this.for = (ImageView) this.PH.findViewById(2131756687);
        this.fos = (TextView) this.PH.findViewById(2131756720);
        this.fot = (TextView) this.PH.findViewById(2131756692);
        this.fou = (TextView) this.PH.findViewById(2131756721);
        this.fov = findViewById(2131755452);
        this.Eq = (ListView) findViewById(2131756718);
        this.fow = q.em(this.nDR.nEl).inflate(2130903487, null);
        this.fow.setVisibility(8);
        this.Eq.addHeaderView(this.PH);
        this.Eq.addFooterView(this.fow);
        this.fox = new a(this, this);
        this.Eq.setAdapter(this.fox);
        this.Eq.setOnScrollListener(this);
    }

    private void aid() {
        this.foA = new l(this.fdK, this.foz);
        ak.vy().a(this.foA, 0);
    }

    private void cF(boolean z) {
        if (!this.foB && this.ffG != 0) {
            aid();
            this.foB = true;
            if (z) {
                this.fnw.sendEmptyMessageDelayed(1002, 200);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = true;
        this.foB = false;
        if (this.fow != null) {
            this.fow.setVisibility(8);
            this.fnw.removeMessages(1002);
            this.fnw.sendEmptyMessageDelayed(1001, 200);
        }
        switch (kVar.getType()) {
            case 299:
                l lVar = (l) kVar;
                if (i == 0 || i == 4) {
                    this.foz = lVar.fek;
                    if (i2 == 0) {
                        this.ffG = 0;
                        if (lVar.afO() != null) {
                            this.fox.C(lVar.afO().myf);
                            return;
                        }
                        return;
                    } else if (i2 == 2) {
                        this.ffG = 2;
                        if (lVar.afO() != null) {
                            this.fox.C(lVar.afO().myf);
                        }
                        if (!(this.fox == null || this.PH == null)) {
                            a aVar = this.fox;
                            v.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "item:%d header:%d window:%d", new Object[]{Integer.valueOf(aVar.eZE + aVar.fnm), Integer.valueOf(this.PH.getHeight()), Integer.valueOf(com.tencent.mm.bd.a.dw(this))});
                            if (com.tencent.mm.bd.a.dw(this) > ((aVar.eZE + aVar.fnm) * this.fox.getCount()) + this.PH.getHeight()) {
                                z = false;
                            }
                        }
                        if (!z) {
                            cF(false);
                            return;
                        }
                        return;
                    } else if (i2 == 3) {
                        this.ffG = 1;
                        this.foz = null;
                        this.fox.foF = true;
                        cF(false);
                        return;
                    } else {
                        return;
                    }
                }
                v.w("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "unknow errType:%d", new Object[]{Integer.valueOf(i)});
                return;
            default:
                return;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.ffG == 0 || this.foB) {
            v.d("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "No More List.");
            return;
        }
        cF(true);
        v.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "[onScrollStateChanged] loadMoreData.");
        n.GL().ba(i);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    protected final int NO() {
        return 1;
    }
}
