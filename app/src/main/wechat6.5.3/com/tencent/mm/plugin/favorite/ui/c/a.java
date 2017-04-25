package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.s;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import java.util.Map;

public abstract class a {
    protected g fJV = null;
    public final a fSl = new a();

    public static class a {
        public String eSD;
        public boolean eyB;
        public boolean fPo;
        public Map<Long, i> fPp;
        public boolean fPw;
        public c fSn;
        public long lastUpdateTime;

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
            stringBuilder.append("isSearching:").append(this.eyB).append('\n');
            stringBuilder.append("search str:").append(this.eSD).append('\n');
            return stringBuilder.toString();
        }
    }

    public static class b {
        public ImageView dtX;
        public CheckBox dua;
        public TextView eTg;
        public TextView eVA;
        public i fLP;
        public TextView fSo;
        public LinearLayout fSp;
        public TextView fSq;
    }

    public interface c {
        void bO(long j);
    }

    public abstract View a(View view, ViewGroup viewGroup, i iVar);

    public abstract void bS(View view);

    public a(g gVar) {
        this.fJV = gVar;
    }

    protected final View a(View view, b bVar, i iVar) {
        if (view == null) {
            throw new NullPointerException("base item view is null");
        }
        bVar.dtX = (ImageView) view.findViewById(2131755031);
        if (bVar.dtX == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_avatar");
        }
        bVar.eVA = (TextView) view.findViewById(2131755042);
        if (bVar.eVA == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_name");
        }
        bVar.eTg = (TextView) view.findViewById(2131755049);
        if (bVar.eTg == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_time");
        }
        bVar.dua = (CheckBox) view.findViewById(2131755032);
        if (bVar.dua == null) {
            throw new IllegalArgumentException("base item view do not contain id named checkbox");
        }
        bVar.fSo = (TextView) view.findViewById(2131755041);
        bVar.dua.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ a fSm;

            {
                this.fSm = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (compoundButton.getTag() != null) {
                    i iVar = (i) compoundButton.getTag();
                    if (z) {
                        this.fSm.fSl.fPp.put(Long.valueOf(iVar.field_localId), h.alu().bB(iVar.field_localId));
                    } else {
                        this.fSm.fSl.fPp.remove(Long.valueOf(iVar.field_localId));
                    }
                    if (this.fSm.fSl.fSn != null) {
                        this.fSm.fSl.fSn.bO(iVar.field_localId);
                    }
                }
            }
        });
        bVar.fLP = iVar;
        view.setTag(bVar);
        bVar.fSp = (LinearLayout) view.findViewById(2131756945);
        bVar.fSq = (TextView) view.findViewById(2131756946);
        bVar.fSq.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a fSm;

            {
                this.fSm = r1;
            }

            public final void onClick(View view) {
                v.d("MicroMsg.FavBaseListItem", "manual restart upload");
                if (view.getTag() instanceof i) {
                    com.tencent.mm.plugin.favorite.b.v.l((i) view.getTag());
                }
            }
        });
        return view;
    }

    protected final void a(b bVar, i iVar) {
        bVar.fLP = iVar;
        qg qgVar = bVar.fLP.field_favProto.mtP;
        if (qgVar == null || be.kS(qgVar.mtu)) {
            com.tencent.mm.pluginsdk.ui.a.b.o(bVar.dtX, bVar.fLP.field_fromUser);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.o(bVar.dtX, qgVar.mtu);
        }
        if (this.fSl.fPw) {
            bVar.eTg.setText(com.tencent.mm.plugin.favorite.c.bx(bVar.fLP.field_datatotalsize));
        } else {
            bVar.eTg.setText(s.e(bVar.eTg.getContext(), bVar.fLP.field_updateTime));
        }
        Context context = bVar.eVA.getContext();
        ak.yW();
        u LW = com.tencent.mm.model.c.wH().LW(bVar.fLP.field_fromUser);
        if (LW == null || !LW.field_username.equals(bVar.fLP.field_fromUser)) {
            v.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[]{bVar.fLP.field_fromUser});
            bVar.eVA.setText("");
            com.tencent.mm.model.ab.a.crZ.a(bVar.fLP.field_fromUser, "", null);
        } else {
            CharSequence er;
            if (m.dE(bVar.fLP.field_fromUser)) {
                qgVar = bVar.fLP.field_favProto.mtP;
                er = k.xF().equals(qgVar.bhM) ? l.er(qgVar.toUser) : l.er(qgVar.bhM);
            } else {
                er = l.a(LW, LW.field_username);
            }
            bVar.eVA.setText(e.a(context, er, bVar.eVA.getTextSize()));
        }
        v.d("MicroMsg.FavBaseListItem", "status %s", new Object[]{Integer.valueOf(bVar.fLP.field_itemStatus)});
        if (bVar.fLP.alB()) {
            bVar.fSp.setVisibility(0);
        } else {
            bVar.fSp.setVisibility(8);
        }
        bVar.dua.setTag(iVar);
        if (this.fSl.fPo || this.fSl.fPw) {
            boolean z;
            bVar.dua.setVisibility(0);
            CheckBox checkBox = bVar.dua;
            if (this.fSl.fPp.get(Long.valueOf(iVar.field_localId)) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
        } else {
            bVar.dua.setVisibility(8);
        }
        if (iVar.field_tagProto.mub == null || iVar.field_tagProto.mub.isEmpty()) {
            bVar.fSo.setVisibility(8);
        } else {
            bVar.fSo.setVisibility(0);
            bVar.fSo.setText(e.a(bVar.fSo.getContext(), com.tencent.mm.plugin.favorite.b.v.a(bVar.fSo.getContext(), iVar.field_tagProto.mub), bVar.fSo.getTextSize()));
        }
        bVar.fSq.setTag(iVar);
    }
}
