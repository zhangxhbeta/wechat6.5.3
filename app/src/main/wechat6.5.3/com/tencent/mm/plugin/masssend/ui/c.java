package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.k;
import com.tencent.mm.as.m;
import com.tencent.mm.as.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c extends j<com.tencent.mm.plugin.masssend.a.a> {
    private static short hjP = (short) 1;
    private static short hjQ = (short) 2;
    private static short hjR = (short) 3;
    private static short hjS = (short) 4;
    private MMActivity aWn;
    int eKW;
    int emv;
    private LayoutInflater gwU;
    private short[] hjT;
    private List<String> hjU;
    String hjV = "";
    e hjW;

    class a implements OnClickListener {
        private String aST;
        final /* synthetic */ c hjX;
        private int hjw;

        public a(c cVar, String str, int i) {
            this.hjX = cVar;
            this.aST = str;
            this.hjw = i;
        }

        public final void onClick(View view) {
            v.v("MicroMsg.HistoryAdapter", "image clicked:" + this.aST);
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                StringBuilder stringBuilder = new StringBuilder();
                ak.yW();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.wP()).append(this.aST).toString();
                if (stringBuilder2 == null || stringBuilder2.equals("") || !com.tencent.mm.a.e.aR(stringBuilder2)) {
                    v.d("MicroMsg.HistoryAdapter", "showImg : imgPath is null");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("key_compress_type", this.hjw);
                intent.putExtra("key_favorite", false);
                intent.putExtra("key_image_path", stringBuilder2);
                com.tencent.mm.plugin.masssend.a.drp.c(this.hjX.aWn, intent);
                return;
            }
            s.ey(this.hjX.aWn);
        }
    }

    class b implements OnClickListener {
        final /* synthetic */ c hjX;
        private String id;

        public b(c cVar, String str) {
            this.hjX = cVar;
            this.id = str;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.masssend.a.a wk = h.azf().wk(this.id);
            Intent intent = new Intent(this.hjX.aWn, MassSendMsgUI.class);
            intent.putExtra("mass_send_contact_list", wk.aza());
            intent.putExtra("mass_send_again", true);
            this.hjX.aWn.startActivity(intent);
        }
    }

    class c implements OnClickListener {
        private String aST;
        final /* synthetic */ c hjX;
        private int hjv;
        private int length;
        private int size;

        public c(c cVar, String str, int i, int i2, int i3) {
            this.hjX = cVar;
            this.aST = str;
            this.hjv = i;
            this.length = i3;
            this.size = i2;
        }

        public final void onClick(View view) {
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                boolean z = this.hjv == 2;
                k.KV();
                v.i("MicroMsg.HistoryAdapter", "video clicked, path:%s, isExport:%b, typeQt:%b", new Object[]{this.aST, Boolean.valueOf(z), Boolean.valueOf(m.kX(o.lc(this.aST)))});
                com.tencent.mm.plugin.masssend.a.drp.a(z, r2, this.hjX.aWn, this.aST, this.length, this.size);
                return;
            }
            s.ey(this.hjX.aWn);
        }
    }

    class d implements OnClickListener {
        final /* synthetic */ c hjX;
        private String id;

        public d(c cVar, String str) {
            this.hjX = cVar;
            this.id = str;
        }

        public final void onClick(View view) {
            v.v("MicroMsg.HistoryAdapter", "voice clicked:" + this.id);
            if (this.hjX.hjW != null) {
                this.hjX.hjV = this.hjX.hjW.wo(this.id);
                this.hjX.notifyDataSetChanged();
            }
        }
    }

    interface e {
        String wo(String str);
    }

    static class f {
        ImageView fNK;
        TextView grr;
        TextView hjY;
        TextView hjZ;
        TextView hka;
        TextView hkb;
        TextView hkc;
        AnimImageView hkd;
        View hke;
        short hkf;

        f() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.plugin.masssend.a.a) obj;
        if (obj == null) {
            obj = new com.tencent.mm.plugin.masssend.a.a();
        }
        obj.b(cursor);
        return obj;
    }

    public c(Context context) {
        super(context, new com.tencent.mm.plugin.masssend.a.a());
        this.aWn = (MMActivity) context;
        this.hjU = new LinkedList();
        this.eKW = 10;
        this.emv = this.eKW;
        this.gwU = q.em(context);
    }

    protected final void Om() {
        Ol();
    }

    public final boolean abO() {
        return this.eKW >= this.emv;
    }

    public final void Ol() {
        int i = 0;
        Cursor rawQuery = h.azf().cuX.rawQuery("SELECT count(*) FROM massendinfo", null);
        if (rawQuery.moveToLast()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        this.emv = i;
        com.tencent.mm.plugin.masssend.a.b azf = h.azf();
        int i2 = this.eKW;
        String str = "select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   ORDER BY createtime ASC  LIMIT " + i2 + " offset (SELECT count(*) FROM massendinfo ) -" + i2;
        v.v("MicroMsg.MasSendInfoStorage", "getCursor sql:" + str);
        setCursor(azf.cuX.rawQuery(str, null));
        i = getCount();
        if (i > 0) {
            this.hjT = new short[i];
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object obj;
        com.tencent.mm.plugin.masssend.a.a aVar;
        CharSequence charSequence;
        com.tencent.mm.plugin.masssend.a.a aVar2 = (com.tencent.mm.plugin.masssend.a.a) getItem(i);
        if (i != 0) {
            long j = ((com.tencent.mm.plugin.masssend.a.a) getItem(i - 1)).dhH;
            aVar2 = (com.tencent.mm.plugin.masssend.a.a) getItem(i);
            long j2 = aVar2.dhH;
            obj = j2 - j < 60000 ? 1 : null;
            Object obj2 = (j2 - j) / 180000 < 1 ? 1 : null;
            if (obj == null && obj2 == null) {
                this.hjT[i] = (short) 1;
                aVar = aVar2;
            } else {
                this.hjT[i] = (short) 2;
                aVar = aVar2;
            }
        } else {
            this.hjT[i] = (short) 1;
            aVar = aVar2;
        }
        obj = (this.hjT[i] != (short) 1 || aVar.dhH <= 1000) ? null : 1;
        f fVar;
        switch (aVar.msgType) {
            case 1:
                fVar = new f();
                if (view == null || ((f) view.getTag()).hkf != hjP) {
                    view = this.gwU.inflate(2130903954, null);
                    fVar.hjY = (TextView) view.findViewById(2131758164);
                    fVar.hjZ = (TextView) view.findViewById(2131758165);
                    fVar.hka = (TextView) view.findViewById(2131758168);
                    fVar.hkc = (TextView) view.findViewById(2131758167);
                    fVar.grr = (TextView) view.findViewById(2131758162);
                    fVar.hke = view.findViewById(2131758163);
                    fVar.hkf = hjP;
                    view.setTag(fVar);
                    break;
                }
            case 3:
                fVar = new f();
                if (view == null || ((f) view.getTag()).hkf != hjQ) {
                    view = this.gwU.inflate(2130903953, null);
                    fVar.hjY = (TextView) view.findViewById(2131758164);
                    fVar.hjZ = (TextView) view.findViewById(2131758165);
                    fVar.fNK = (ImageView) view.findViewById(2131758166);
                    fVar.hkc = (TextView) view.findViewById(2131758167);
                    fVar.grr = (TextView) view.findViewById(2131758162);
                    fVar.hke = view.findViewById(2131758163);
                    fVar.hkf = hjQ;
                    view.setTag(fVar);
                    break;
                }
            case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                fVar = new f();
                if (view == null || ((f) view.getTag()).hkf != hjS) {
                    view = this.gwU.inflate(2130903956, null);
                    fVar.hjY = (TextView) view.findViewById(2131758164);
                    fVar.hjZ = (TextView) view.findViewById(2131758165);
                    fVar.hkb = (TextView) view.findViewById(2131758171);
                    fVar.hka = (TextView) view.findViewById(2131758172);
                    fVar.hkd = (AnimImageView) view.findViewById(2131758173);
                    fVar.hkc = (TextView) view.findViewById(2131758167);
                    fVar.grr = (TextView) view.findViewById(2131758162);
                    fVar.hke = view.findViewById(2131758163);
                    fVar.hkf = hjS;
                    view.setTag(fVar);
                    break;
                }
            case 43:
                fVar = new f();
                if (view == null || ((f) view.getTag()).hkf != hjR) {
                    view = this.gwU.inflate(2130903955, null);
                    fVar.hjY = (TextView) view.findViewById(2131758164);
                    fVar.hjZ = (TextView) view.findViewById(2131758165);
                    fVar.fNK = (ImageView) view.findViewById(2131758166);
                    fVar.hkb = (TextView) view.findViewById(2131758169);
                    fVar.hkc = (TextView) view.findViewById(2131758167);
                    fVar.grr = (TextView) view.findViewById(2131758162);
                    fVar.hke = view.findViewById(2131758163);
                    fVar.hkf = hjR;
                    view.setTag(fVar);
                    break;
                }
        }
        f fVar2 = (f) view.getTag();
        if (obj != null) {
            fVar2.grr.setVisibility(0);
            fVar2.grr.setText(com.tencent.mm.pluginsdk.j.o.c(this.aWn, aVar.dhH, false));
        } else {
            fVar2.grr.setVisibility(8);
        }
        switch (aVar.msgType) {
            case 1:
                fVar2 = (f) view.getTag();
                fVar2.hka.setText(aVar.ayY());
                com.tencent.mm.pluginsdk.ui.d.e.e(fVar2.hka, 1);
                break;
            case 3:
                fVar2 = (f) view.getTag();
                ak.yW();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    h.azf();
                    Bitmap wj = com.tencent.mm.plugin.masssend.a.b.wj(aVar.ayY());
                    if (wj != null) {
                        fVar2.fNK.setImageBitmap(wj);
                    } else {
                        h.azf();
                        fVar2.fNK.setImageBitmap(com.tencent.mm.plugin.masssend.a.b.b(aVar.ayZ(), com.tencent.mm.bd.a.getDensity(fVar2.fNK.getContext())));
                    }
                } else {
                    fVar2.fNK.setImageDrawable(com.tencent.mm.bd.a.a(this.aWn, 2130838791));
                }
                fVar2.fNK.setOnClickListener(new a(this, aVar.ayY(), aVar.hjw));
                break;
            case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                fVar2 = (f) view.getTag();
                float au = com.tencent.mm.modelvoice.q.au((long) aVar.hjs);
                if (aVar.ayX().equals(this.hjV)) {
                    fVar2.hkd.setVisibility(0);
                    fVar2.hkd.bBG();
                    fVar2.hka.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                } else {
                    fVar2.hkd.setVisibility(8);
                    fVar2.hkd.aJV();
                    fVar2.hka.setCompoundDrawablesWithIntrinsicBounds(null, null, this.aWn.getResources().getDrawable(2131165396), null);
                }
                fVar2.hkb.setText(this.aWn.getString(2131232930, new Object[]{Integer.valueOf((int) au)}));
                fVar2.hka.setWidth(com.tencent.mm.bd.a.fromDPToPix(fVar2.hka.getContext(), iF((int) au)));
                fVar2.hkd.setWidth(com.tencent.mm.bd.a.fromDPToPix(fVar2.hka.getContext(), iF((int) au)));
                fVar2.hka.setOnClickListener(new d(this, aVar.ayX()));
                break;
            case 43:
                f fVar3 = (f) view.getTag();
                k.KV();
                Bitmap a = n.GH().a(o.ld(aVar.ayY()), com.tencent.mm.bd.a.getDensity(fVar3.fNK.getContext()), this.aWn);
                if (a == null) {
                    ak.yW();
                    if (com.tencent.mm.model.c.isSDCardAvailable()) {
                        fVar3.fNK.setImageDrawable(com.tencent.mm.bd.a.a(this.aWn, 2131689779));
                    } else {
                        fVar3.fNK.setImageDrawable(com.tencent.mm.bd.a.a(this.aWn, 2131165999));
                    }
                } else {
                    fVar3.fNK.setImageBitmap(a);
                }
                fVar3.fNK.setOnClickListener(new c(this, aVar.ayY(), aVar.hjv, aVar.aPV, aVar.hjs));
                if (aVar.hjv != 2) {
                    fVar3.hkb.setVisibility(0);
                    fVar3.hkb.setText(be.gH(aVar.hjs));
                    break;
                }
                fVar3.hkb.setVisibility(8);
                break;
        }
        fVar2 = (f) view.getTag();
        fVar2.hjY.setText(this.aWn.getResources().getQuantityString(2131361808, aVar.hjr, new Object[]{Integer.valueOf(aVar.hjr)}));
        if (this.hjU.contains(aVar.ayX())) {
            fVar2.hjZ.setSingleLine(false);
            fVar2.hjZ.setEllipsize(null);
        } else {
            fVar2.hjZ.setSingleLine(true);
            fVar2.hjZ.setEllipsize(TruncateAt.END);
        }
        TextView textView = fVar2.hjZ;
        MMActivity mMActivity = this.aWn;
        ArrayList arrayList = new ArrayList();
        if (aVar.aza() == null || aVar.aza().equals("")) {
            charSequence = "";
        } else {
            List g;
            String[] split = aVar.aza().split(";");
            if (split == null || split.length <= 0) {
                Object obj3 = arrayList;
            } else {
                g = be.g(split);
            }
            if (g == null) {
                charSequence = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i2 = 0; i2 < g.size(); i2++) {
                    String er = l.er((String) g.get(i2));
                    if (i2 == g.size() - 1) {
                        stringBuilder.append(er);
                    } else {
                        stringBuilder.append(er + ", ");
                    }
                }
                charSequence = stringBuilder.toString();
            }
        }
        textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(mMActivity, charSequence, fVar2.hjZ.getTextSize()));
        int textSize = (int) fVar2.hjZ.getTextSize();
        String charSequence2 = fVar2.hjZ.getText().toString();
        com.tencent.mm.bd.a.fromDPToPix(this.aWn, 255);
        Paint paint = new Paint();
        paint.setTextSize((float) textSize);
        paint.measureText(charSequence2);
        fVar2.hkc.setOnClickListener(new b(this, aVar.ayX()));
        return view;
    }

    public final void wn(String str) {
        this.hjV = str;
        notifyDataSetChanged();
    }

    private static int iF(int i) {
        if (i <= 2) {
            return 100;
        }
        if (i < 10) {
            return ((i - 2) * 8) + 100;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 8) + 100;
        }
        return 204;
    }
}
