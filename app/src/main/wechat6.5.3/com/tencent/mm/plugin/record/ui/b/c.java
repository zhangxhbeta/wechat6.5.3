package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.a.s;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c implements b {
    public static Map<String, View> iqW = new HashMap();
    private OnClickListener fQr = new OnClickListener(this) {
        final /* synthetic */ c iqX;

        {
            this.iqX = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            if (bVar.aKG == 0) {
                if (m.d(bVar.bdE, bVar.bao)) {
                    v.i("MicroMsg.SightViewWrapper", "onclick: play sight");
                    intent = new Intent(view.getContext(), RecordMsgFileUI.class);
                    intent.putExtra("message_id", bVar.bao);
                    intent.putExtra("record_xml", bVar.bmh);
                    intent.putExtra("record_data_id", bVar.bdE.luu);
                    view.getContext().startActivity(intent);
                    return;
                }
                g yx = s.aJE().yx(m.c(bVar.bdE.luu, bVar.bao, true));
                String str = "MicroMsg.SightViewWrapper";
                String str2 = "onclick: cdnInfo status %s";
                Object[] objArr = new Object[1];
                objArr[0] = yx == null ? "null" : Integer.valueOf(yx.field_status);
                v.i(str, str2, objArr);
                if (!(yx == null || 2 == yx.field_status || 3 == yx.field_status)) {
                    if (4 == yx.field_status) {
                        com.tencent.mm.ui.base.g.bf(view.getContext(), view.getResources().getString(2131232718));
                        return;
                    } else if (yx.field_status == 0 || 1 == yx.field_status) {
                        return;
                    }
                }
                m.a(bVar.bdE, bVar.bao, true);
            } else if (bVar.aKG == 1) {
                ez ezVar;
                v.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(bVar.ipT.field_id), Long.valueOf(bVar.ipT.field_localId), Integer.valueOf(bVar.ipT.field_itemStatus)});
                if (bVar.ipT.isDone()) {
                    ezVar = new ez();
                    ezVar.bdQ.type = 14;
                    ezVar.bdQ.bdS = bVar.bdE;
                    a.nhr.z(ezVar);
                    v.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", new Object[]{Integer.valueOf(ezVar.bdR.ret)});
                    if (ezVar.bdR.ret == 1) {
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.ipT.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.bdE.luu);
                        intent.putExtra("key_detail_can_delete", false);
                        com.tencent.mm.ay.c.b(view.getContext(), "favorite", ".ui.detail.FavoriteFileDetailUI", intent);
                        return;
                    } else if (be.kS(bVar.bdE.mrS)) {
                        v.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
                        return;
                    } else {
                        v.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
                    }
                } else if (bVar.ipT.alD() || bVar.ipT.alB()) {
                    v.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
                } else if (bVar.ipT.alC() || bVar.ipT.alA()) {
                    v.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                    return;
                } else {
                    v.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                }
                ezVar = new ez();
                ezVar.bdQ.aZa = bVar.ipT.field_localId;
                if (bVar.ipT.alB()) {
                    v.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
                    ezVar.bdQ.type = 15;
                    a.nhr.z(ezVar);
                    return;
                }
                v.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
                ezVar.bdQ.type = 16;
                a.nhr.z(ezVar);
            }
        }
    };
    private h.a iql;

    public c(h.a aVar) {
        this.iql = aVar;
    }

    public final View cq(Context context) {
        View inflate = View.inflate(context, 2130904258, null);
        ((com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(2131755052)).pv(com.tencent.mm.bd.a.fromDPToPix(context, 260));
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        view.setTag(bVar);
        view.setOnClickListener(this.fQr);
        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(2131755052);
        ImageView imageView = (ImageView) view.findViewById(2131755281);
        MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(2131758183);
        aVar.iO(i);
        com.tencent.mm.plugin.record.ui.a.c cVar = (com.tencent.mm.plugin.record.ui.a.c) bVar;
        h.a aVar2 = this.iql;
        Map map = iqW;
        com.tencent.mm.plugin.record.ui.h.a.c cVar2 = new com.tencent.mm.plugin.record.ui.h.a.c();
        cVar2.bdE = cVar.bdE;
        String c;
        if (cVar.aKG == 0) {
            cVar2.iqn = cVar.bao;
            if (m.d(cVar.bdE, cVar.bao)) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(8);
                c = m.c(cVar.bdE, cVar.bao);
                if (!c.equals(aVar.aOV())) {
                    aVar.s(aVar2.a(cVar2));
                }
                aVar.ag(c, false);
                return;
            }
            g yx = s.aJE().yx(m.c(cVar.bdE.luu, cVar.bao, true));
            if (yx == null || 2 == yx.field_status) {
                imageView.setImageResource(2131165914);
            } else if (3 == yx.field_status || 4 == yx.field_status) {
                imageView.setImageResource(2130839161);
            } else if (yx.field_status == 0 || 1 == yx.field_status) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.setProgress((int) ((((float) yx.field_offset) / ((float) Math.max(1, yx.field_totalLen))) * 100.0f));
                aVar.clear();
                aVar.s(aVar2.a(cVar2));
                return;
            } else {
                imageView.setImageResource(2131165914);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.s(aVar2.a(cVar2));
        } else if (cVar.aKG == 1) {
            map.put(cVar.bdE.luu, view);
            v.d("MicroMsg.SightRecordData", "dataId %s, status %s", new Object[]{Long.valueOf(cVar.ipT.field_localId), Integer.valueOf(cVar.ipT.field_itemStatus)});
            cVar2.iqn = cVar.ipT.field_localId;
            ez ezVar = new ez();
            ezVar.bdQ.type = 14;
            ezVar.bdQ.bdS = cVar.bdE;
            a.nhr.z(ezVar);
            if (cVar.ipT.isDone() || ezVar.bdR.ret == 1) {
                if (ezVar.bdR.ret == 1) {
                    imageView.setVisibility(8);
                    mMPinProgressBtn.setVisibility(8);
                    ezVar.bdQ.type = 2;
                    a.nhr.z(ezVar);
                    c = ezVar.bdR.path;
                    if (be.kS(c)) {
                        v.w("MicroMsg.SightRecordData", "videoPath is null!");
                        return;
                    }
                    if (!c.equals(aVar.aOV())) {
                        aVar.s(aVar2.a(cVar2));
                    }
                    aVar.ag(c, false);
                    return;
                } else if (be.kS(cVar.bdE.mrS)) {
                    imageView.setImageResource(2130839161);
                } else {
                    v.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
                    imageView.setImageResource(2131165914);
                }
            } else if (cVar.ipT.alD() || cVar.ipT.alB()) {
                imageView.setImageResource(2131165914);
            } else if (cVar.ipT.alC()) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.bKj();
                aVar.clear();
                aVar.s(aVar2.a(cVar2));
                return;
            } else {
                v.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                imageView.setImageResource(2131165914);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.s(aVar2.a(cVar2));
        }
    }

    public final void destroy() {
        this.iql = null;
    }
}
