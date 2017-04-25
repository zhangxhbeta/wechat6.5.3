package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.emoji.d.g;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.ui.base.v;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i extends v implements OnClickListener {
    public static int eZM = 60;
    public LinkedList<com.tencent.mm.plugin.emoji.model.a> eZL;
    private int eZN = 0;
    public boolean eZO = false;
    public ArrayList<String> eZP = new ArrayList();
    private com.tencent.mm.ae.a.c.i eZQ = new com.tencent.mm.ae.a.c.i(this) {
        final /* synthetic */ i eZR;

        {
            this.eZR = r1;
        }

        public final void a(String str, Bitmap bitmap, Object... objArr) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", new Object[]{str});
            this.eZR.mHandler.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 eZS;

                {
                    this.eZS = r1;
                }

                public final void run() {
                    this.eZS.eZR.notifyDataSetChanged();
                }
            });
        }
    };
    private Context mContext;
    private ac mHandler = new ac();

    class a {
        final /* synthetic */ i eZR;
        StoreBannerEmojiView eZT;
        ImageView eZU;

        public a(i iVar, View view) {
            this.eZR = iVar;
            this.eZT = (StoreBannerEmojiView) view.findViewById(2131756697);
            this.eZU = (ImageView) view.findViewById(2131756698);
            this.eZT.gDc = 0;
        }
    }

    public i(Context context, LinkedList<com.tencent.mm.plugin.emoji.model.a> linkedList) {
        if (linkedList == null) {
            throw new IllegalAccessError("must has emoji banner list");
        }
        this.mContext = context;
        this.eZL = new LinkedList();
        this.eZL.addAll(linkedList);
    }

    public final void B(LinkedList<com.tencent.mm.plugin.emoji.model.a> linkedList) {
        this.eZL.clear();
        this.eZL.addAll(linkedList);
        notifyDataSetChanged();
    }

    public final int getCount() {
        if (this.eZL == null) {
            return 0;
        }
        return this.eZL.size() != 1 ? this.eZL.size() * eZM : 1;
    }

    public final void notifyDataSetChanged() {
        if (this.eZO) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
            return;
        }
        this.eZN = getCount();
        super.notifyDataSetChanged();
    }

    public final int j(Object obj) {
        if (this.eZN <= 0) {
            return super.j(obj);
        }
        this.eZN--;
        return -2;
    }

    public final View c(int i, View view) {
        if (this.eZL == null) {
            return null;
        }
        a aVar;
        int size = i % this.eZL.size();
        a aVar2;
        if (view == null) {
            com.tencent.mm.sdk.platformtools.v.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
            view = View.inflate(this.mContext, 2130903516, null);
            aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar2 = (a) view.getTag();
            int i2 = EmojiStoreVpHeader.aG(this.mContext)[0];
            aVar2.eZT.setLayoutParams(new LayoutParams(i2, ((i2 * 3) / 8) + 1));
            aVar = aVar2;
        }
        view.setTag(2131755028, Integer.valueOf(size));
        view.setOnClickListener(this);
        com.tencent.mm.plugin.emoji.model.a aVar3 = (com.tencent.mm.plugin.emoji.model.a) this.eZL.get(size);
        if (aVar3 == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
            return null;
        }
        String str;
        String str2;
        if (aVar3.fcF) {
            str = aVar3.fcD.mpS.mpT;
            if (be.kS(aVar3.fcD.mpU)) {
                str2 = "H5";
            } else {
                str2 = "Toptic";
            }
        } else {
            str = aVar3.fcE.mpS.mpT;
            str2 = aVar3.fcE.mpR.mdM;
        }
        if (!(aVar3 == null || be.kS(str))) {
            com.tencent.mm.bd.a.getDensity(this.mContext);
            c a = EmojiLogic.a(str2, 8, str, true);
            if (a != null) {
                aVar.eZT.bN(a.dR(a.field_groupId, a.EB()), null);
            } else if (this.eZP.contains(str)) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
                aVar.eZT.bN("-", null);
            } else {
                n.GL().a(str, null, g.b(str2, str, new Object[]{str2, "BANNER"}), this.eZQ);
                this.eZP.add(str);
            }
        }
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", new Object[]{Integer.valueOf(size), Integer.valueOf(i), str});
        return view;
    }

    public final void onClick(View view) {
        com.tencent.mm.plugin.emoji.model.a aVar = (com.tencent.mm.plugin.emoji.model.a) this.eZL.get(((Integer) view.getTag(2131755028)).intValue());
        if (aVar == null) {
            return;
        }
        if (aVar.fcF) {
            com.tencent.mm.plugin.emoji.d.n.a(this.mContext, aVar.fcD, true);
            return;
        }
        ol olVar = aVar.fcE.mpR;
        if (olVar != null) {
            String str = "MicroMsg.emoji.EmojiStoreVpHeaderAdapter";
            String str2 = "productId %s";
            Object[] objArr = new Object[1];
            objArr[0] = olVar == null ? "" : olVar.mdM;
            com.tencent.mm.sdk.platformtools.v.d(str, str2, objArr);
            com.tencent.mm.plugin.report.service.g.iuh.h(11929, new Object[]{Integer.valueOf(0)});
            com.tencent.mm.plugin.emoji.d.n.a(this.mContext, olVar, 15, -1, -1, "", 8);
        }
    }
}
