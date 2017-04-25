package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.e.a.it;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class d extends h {
    private static HashMap<String, Boolean> ipU = new HashMap();
    public c ipV = new c<it>(this) {
        final /* synthetic */ d ipW;

        {
            this.ipW = r2;
            this.nhz = it.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            it itVar = (it) bVar;
            final com.tencent.mm.plugin.record.a.b bVar2 = new com.tencent.mm.plugin.record.a.b();
            bVar2.field_dataId = itVar.bjj.field_dataId;
            bVar2.field_favLocalId = itVar.bjj.field_favLocalId;
            bVar2.field_offset = itVar.bjj.field_offset;
            bVar2.field_totalLen = itVar.bjj.field_totalLen;
            bVar2.field_status = itVar.bjj.field_status;
            final b bVar3 = (b) this.ipW.iqk;
            if (bVar2.field_favLocalId == bVar3.ipT.field_localId) {
                v.d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", new Object[]{Long.valueOf(bVar2.field_favLocalId), bVar2.field_dataId, Integer.valueOf(bVar2.field_status)});
                if (4 == bVar2.field_status) {
                    d.ipU.put(be.ah(bVar2.field_dataId, "null"), Boolean.valueOf(true));
                }
                if (bVar2.isFinished()) {
                    this.ipW.iqg.postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 ipZ;

                        public final void run() {
                            if (bVar3.ipT != null) {
                                com.tencent.mm.plugin.record.a.c cs = com.tencent.mm.plugin.record.a.d.cs(bVar3.ipT.field_localId);
                                a bVar = new b();
                                bVar.ipT = cs;
                                bVar.ipS = cs.field_favProto.mtR;
                                this.ipZ.ipW.a(bVar);
                            }
                            View view = (View) com.tencent.mm.plugin.record.ui.b.c.iqW.get(bVar2.field_dataId);
                            String str = "MicroMsg.FavRecordAdapter";
                            String str2 = "view is null %s";
                            Object[] objArr = new Object[1];
                            objArr[0] = Boolean.valueOf(view == null);
                            v.d(str, str2, objArr);
                            if (view != null) {
                                com.tencent.mm.plugin.record.ui.a.b bVar2 = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
                                str2 = com.tencent.mm.plugin.record.a.d.a(bVar2);
                                v.d("MicroMsg.FavRecordAdapter", "dataItemId: %s", new Object[]{bVar2.bdE.luu});
                                if (bVar2.bdE.luu.equals(bVar2.field_dataId)) {
                                    objArr = new Object[4];
                                    com.tencent.mm.plugin.record.a.b bVar3 = bVar2;
                                    objArr[2] = Float.valueOf(Math.max(0.0f, Math.min(99.0f, ((float) bVar3.field_offset) / ((float) bVar3.field_totalLen)) * 100.0f));
                                    objArr[3] = Boolean.valueOf(bVar2.isFinished());
                                    v.d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", objArr);
                                    ImageView imageView = (ImageView) view.findViewById(2131755281);
                                    MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(2131758183);
                                    a aVar = (a) view.findViewById(2131755052);
                                    imageView.setVisibility(8);
                                    mMPinProgressBtn.setVisibility(8);
                                    v.i("MicroMsg.FavRecordAdapter", "setVideoPath " + str2);
                                    aVar.fy(true);
                                    aVar.ag(str2, false);
                                }
                            }
                        }
                    }, 200);
                }
                this.ipW.aJQ();
            }
            return false;
        }
    };

    public d(Context context, h.a aVar) {
        super(context, aVar);
    }

    public final void a(a aVar) {
        v.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", new Object[]{Long.valueOf(((b) aVar).ipT.field_localId), Integer.valueOf(((b) aVar).ipT.field_itemStatus)});
        this.iqk = aVar;
        this.ipS.clear();
        this.ipS.addAll(aVar.ipS);
        notifyDataSetChanged();
    }

    public final void b(com.tencent.mm.plugin.record.ui.a.b bVar) {
        v.d("MicroMsg.FavRecordAdapter", "setupRecord %s", new Object[]{Long.valueOf(((b) this.iqk).ipT.field_localId)});
        bVar.aKG = 1;
        bVar.ipT = ((b) this.iqk).ipT;
    }
}
