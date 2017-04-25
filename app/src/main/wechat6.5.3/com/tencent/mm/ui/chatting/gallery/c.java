package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.c.i;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.j;
import java.util.HashMap;
import java.util.Map;

public final class c extends j<at> implements OnClickListener {
    private static Map<String, Integer> fLE;
    private static Map<String, Integer> oAs;
    private LayoutInflater CE;
    public boolean cWm = false;
    String eSI;
    protected com.tencent.mm.ae.a.a.c eSp = null;
    boolean lKa;
    private boolean lVu;
    Context mContext;
    long oAp;
    private final ImageGalleryGridUI oAq;
    boolean oAr = false;

    protected static class a {
        public CheckBox gfb;
        public View gfc;
        public ImageView iQA;
        public View oAA;
        public View oAB;
        public ImageView oAv;
        public View oAw;
        public TextView oAx;
        public TextView oAy;
        public ImageView oAz;

        protected a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        at atVar = new at();
        atVar.b(cursor);
        return atVar;
    }

    public c(Context context, at atVar, String str) {
        super(context, atVar);
        this.oAq = (ImageGalleryGridUI) context;
        this.eSI = str;
        this.lKa = e.hC(this.eSI);
        if (this.lKa) {
            this.oAp = atVar.field_bizChatId;
        }
        ak.yW();
        this.lVu = com.tencent.mm.model.c.isSDCardAvailable();
        this.CE = LayoutInflater.from(context);
        com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
        aVar.cPx = 1;
        aVar.cPR = true;
        aVar.cPz = com.tencent.mm.bd.a.dv(context) / 3;
        aVar.cPy = com.tencent.mm.bd.a.dv(context) / 3;
        aVar.cPL = 2131689919;
        this.eSp = aVar.GU();
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final void Ol() {
        if (this.lKa) {
            setCursor(ak.yW().cqY.J(this.eSI, this.oAp));
            return;
        }
        ak.yW();
        setCursor(com.tencent.mm.model.c.wJ().MM(this.eSI));
    }

    protected final void Om() {
        if (this.lKa) {
            setCursor(ak.yW().cqY.J(this.eSI, this.oAp));
            return;
        }
        ak.yW();
        setCursor(com.tencent.mm.model.c.wJ().MM(this.eSI));
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.CE.inflate(2130903786, viewGroup, false);
            aVar = new a();
            aVar.iQA = (ImageView) view.findViewById(2131757436);
            aVar.oAw = view.findViewById(2131757440);
            aVar.oAx = (TextView) view.findViewById(2131757437);
            aVar.oAx.setVisibility(8);
            aVar.oAv = (ImageView) view.findViewById(2131757439);
            aVar.oAy = (TextView) view.findViewById(2131757442);
            aVar.oAw.setVisibility(8);
            aVar.oAA = view.findViewById(2131757443);
            aVar.oAA.setVisibility(8);
            aVar.oAB = view.findViewById(2131757438);
            aVar.oAB.setVisibility(8);
            aVar.oAz = (ImageView) view.findViewById(2131757445);
            aVar.gfb = (CheckBox) view.findViewById(2131757446);
            aVar.gfc = view.findViewById(2131757447);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.oAA.setVisibility(8);
        aVar.oAw.setVisibility(8);
        aVar.oAB.setVisibility(8);
        aVar.oAx.setVisibility(8);
        at atVar = (at) getItem(i);
        if (atVar != null) {
            if (!this.lVu) {
                aVar.iQA.setImageResource(2130838791);
            } else if (this.oAq instanceof ImageGalleryGridUI) {
                String str = atVar.field_content;
                com.tencent.mm.q.a.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.q.a.a.B(str, atVar.field_reserved);
                }
                if (this.oAq.oAC == i) {
                    aVar.oAz.setVisibility(0);
                    if (!b.aK(atVar) || aVar2 == null || aVar2.type == 3) {
                        if (aVar2 != null && aVar2.type == 3) {
                            aVar.oAv.setImageDrawable(this.oAq.getResources().getDrawable(e(aVar2)));
                        }
                        n.GL().a(aS(atVar), aVar.iQA, this.eSp, new i(this) {
                            final /* synthetic */ c oAt;

                            {
                                this.oAt = r1;
                            }

                            public final void a(String str, Bitmap bitmap, Object... objArr) {
                                ad.o(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 oAu;

                                    {
                                        this.oAu = r1;
                                    }

                                    public final void run() {
                                    }
                                });
                            }
                        });
                    } else {
                        aVar.oAv.setImageDrawable(this.oAq.getResources().getDrawable(e(aVar2)));
                        aVar.iQA.setImageResource(f(aVar2));
                    }
                } else {
                    aVar.oAz.setVisibility(0);
                    aVar.oAz.setBackgroundResource(2130838415);
                    if (!b.aK(atVar) || aVar2 == null || aVar2.type == 3) {
                        if (aVar2 != null && aVar2.type == 3) {
                            aVar.oAv.setImageDrawable(this.oAq.getResources().getDrawable(e(aVar2)));
                        }
                        n.GL().a(aS(atVar), aVar.iQA, this.eSp);
                    } else {
                        aVar.oAv.setImageDrawable(this.oAq.getResources().getDrawable(e(aVar2)));
                        aVar.iQA.setImageResource(f(aVar2));
                    }
                }
                aVar.iQA.setPadding(0, 0, 0, 0);
                int measuredWidth = aVar.iQA.getMeasuredWidth();
                int measuredHeight = aVar.iQA.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = aVar.oAz.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.oAz.setLayoutParams(layoutParams);
                }
                if (b.aI(atVar)) {
                    if (aVar != null) {
                        aVar.oAw.setVisibility(0);
                        com.tencent.mm.as.n bb = i.bb(atVar);
                        if (bb != null) {
                            aVar.oAy.setText(t.gH(bb.dhK));
                        }
                    }
                } else if (b.aJ(atVar)) {
                    aVar.oAA.setVisibility(0);
                } else if (b.aK(atVar) && aVar != null) {
                    aVar.oAB.setVisibility(0);
                    aVar.oAx.setVisibility(0);
                    if (aVar2 != null) {
                        v.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", t.ma(aVar2.title));
                        if (aVar2.type != 24) {
                            aVar.oAx.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.mContext, t.ma(aVar2.title), aVar.oAx.getTextSize()));
                        } else {
                            aVar.oAx.setText(com.tencent.mm.pluginsdk.ui.d.e.a(aVar.oAx.getContext(), aVar.oAx.getContext().getString(2131232755), aVar.oAx.getTextSize()));
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("the context should be ImageGalleryGridUI");
            }
            aVar.gfb.setChecked(a.oBx.aZ(atVar));
            aVar.gfb.setTag(atVar);
            aVar.gfc.setTag(aVar);
            aVar.gfc.setOnClickListener(this);
            if (a.oBx.oBv) {
                aVar.gfb.setVisibility(0);
                aVar.gfc.setVisibility(0);
                aVar.oAz.setVisibility(0);
            } else {
                aVar.gfb.setVisibility(8);
                aVar.gfc.setVisibility(8);
                aVar.oAz.setVisibility(8);
            }
        }
        return view;
    }

    private static int e(com.tencent.mm.q.a.a aVar) {
        if (aVar == null) {
            v.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131165241");
            return 2131165242;
        } else if (aVar.type == 5 || aVar.type == 7 || aVar.type == 15) {
            return 2131165243;
        } else {
            if (aVar.type == 3) {
                return 2131165233;
            }
            if (aVar.type != 6 || !fLE.containsKey(t.ma(aVar.coc))) {
                return 2131165242;
            }
            v.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + fLE.get(t.ma(aVar.coc)));
            return ((Integer) fLE.get(t.ma(aVar.coc))).intValue();
        }
    }

    private static int f(com.tencent.mm.q.a.a aVar) {
        if (aVar == null) {
            v.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:2131689517");
            return 2131689517;
        } else if (aVar.type == 5 || aVar.type == 7 || aVar.type == 15) {
            return 2131689518;
        } else {
            if (aVar.type != 6 || !oAs.containsKey(t.ma(aVar.coc))) {
                return 2131689517;
            }
            v.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + oAs.get(t.ma(aVar.coc)));
            return ((Integer) oAs.get(t.ma(aVar.coc))).intValue();
        }
    }

    private static String aS(at atVar) {
        String ld;
        if (atVar.bwn() || atVar.bwo()) {
            k.KV();
            ld = o.ld(atVar.field_imgPath);
        } else {
            ld = n.GH().x(atVar.field_imgPath, false);
            if (!(t.kS(ld) || ld.endsWith("hd") || !FileOp.aR(ld + "hd"))) {
                ld = ld + "hd";
            }
        }
        v.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", ld);
        if (!atVar.bwr()) {
            return ld;
        }
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(atVar.field_content);
        String str = null;
        if (!(dV == null || dV.aXa == null || dV.aXa.length() <= 0)) {
            b Gu = am.Wf().Gu(dV.aXa);
            if (Gu != null) {
                str = Gu.field_fileFullPath;
            }
        }
        if (str != null) {
            return str;
        }
        return ld;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.oAr = false;
    }

    public final void onClick(View view) {
        a aVar = (a) view.getTag();
        if (aVar.gfb != null) {
            at atVar = (at) aVar.gfb.getTag();
            if (atVar != null) {
                g bGE = a.oBx;
                if (bGE.aZ(atVar)) {
                    bGE.aY(atVar);
                } else {
                    bGE.aX(atVar);
                }
                if (a.oBx.aZ(atVar)) {
                    aVar.gfb.setChecked(true);
                    aVar.oAz.setBackgroundResource(2131689781);
                } else {
                    aVar.gfb.setChecked(false);
                    aVar.oAz.setBackgroundResource(2130838415);
                }
                if (!this.cWm && a.oBx.ozS.size() > 1) {
                    g.iuh.a(219, 20, 1, true);
                    this.cWm = true;
                }
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        fLE = hashMap;
        hashMap.put("avi", Integer.valueOf(2131165245));
        fLE.put("m4v", Integer.valueOf(2131165245));
        fLE.put("vob", Integer.valueOf(2131165245));
        fLE.put("mpeg", Integer.valueOf(2131165245));
        fLE.put("mpe", Integer.valueOf(2131165245));
        fLE.put("asx", Integer.valueOf(2131165245));
        fLE.put("asf", Integer.valueOf(2131165245));
        fLE.put("f4v", Integer.valueOf(2131165245));
        fLE.put("flv", Integer.valueOf(2131165245));
        fLE.put("mkv", Integer.valueOf(2131165245));
        fLE.put("wmv", Integer.valueOf(2131165245));
        fLE.put("wm", Integer.valueOf(2131165245));
        fLE.put("3gp", Integer.valueOf(2131165245));
        fLE.put("mp4", Integer.valueOf(2131165245));
        fLE.put("rmvb", Integer.valueOf(2131165245));
        fLE.put("rm", Integer.valueOf(2131165245));
        fLE.put("ra", Integer.valueOf(2131165245));
        fLE.put("ram", Integer.valueOf(2131165245));
        fLE.put("mp3pro", Integer.valueOf(2131165233));
        fLE.put("vqf", Integer.valueOf(2131165233));
        fLE.put("cd", Integer.valueOf(2131165233));
        fLE.put("md", Integer.valueOf(2131165233));
        fLE.put("mod", Integer.valueOf(2131165233));
        fLE.put("vorbis", Integer.valueOf(2131165233));
        fLE.put("au", Integer.valueOf(2131165233));
        fLE.put("amr", Integer.valueOf(2131165233));
        fLE.put("silk", Integer.valueOf(2131165233));
        fLE.put("wma", Integer.valueOf(2131165233));
        fLE.put("mmf", Integer.valueOf(2131165233));
        fLE.put("mid", Integer.valueOf(2131165233));
        fLE.put("midi", Integer.valueOf(2131165233));
        fLE.put("mp3", Integer.valueOf(2131165233));
        fLE.put("aac", Integer.valueOf(2131165233));
        fLE.put("ape", Integer.valueOf(2131165233));
        fLE.put("aiff", Integer.valueOf(2131165233));
        fLE.put("aif", Integer.valueOf(2131165233));
        fLE.put("doc", Integer.valueOf(2131165249));
        fLE.put("docx", Integer.valueOf(2131165249));
        fLE.put("ppt", Integer.valueOf(2131165237));
        fLE.put("pptx", Integer.valueOf(2131165237));
        fLE.put("xls", Integer.valueOf(2131165229));
        fLE.put("xlsx", Integer.valueOf(2131165229));
        fLE.put("pdf", Integer.valueOf(2131165235));
        fLE.put("unknown", Integer.valueOf(2131165242));
        hashMap = new HashMap();
        oAs = hashMap;
        hashMap.put("doc", Integer.valueOf(2131689513));
        oAs.put("docx", Integer.valueOf(2131689513));
        oAs.put("ppt", Integer.valueOf(2131689516));
        oAs.put("pptx", Integer.valueOf(2131689516));
        oAs.put("xls", Integer.valueOf(2131689519));
        oAs.put("xlsx", Integer.valueOf(2131689519));
        oAs.put("pdf", Integer.valueOf(2131689515));
        oAs.put("unknown", Integer.valueOf(2131689517));
        oAs.put("mp3pro", Integer.valueOf(2131689514));
        oAs.put("vqf", Integer.valueOf(2131689514));
        oAs.put("cd", Integer.valueOf(2131689514));
        oAs.put("md", Integer.valueOf(2131689514));
        oAs.put("mod", Integer.valueOf(2131689514));
        oAs.put("vorbis", Integer.valueOf(2131689514));
        oAs.put("au", Integer.valueOf(2131689514));
        oAs.put("amr", Integer.valueOf(2131689514));
        oAs.put("silk", Integer.valueOf(2131689514));
        oAs.put("wma", Integer.valueOf(2131689514));
        oAs.put("mmf", Integer.valueOf(2131689514));
        oAs.put("mid", Integer.valueOf(2131689514));
        oAs.put("midi", Integer.valueOf(2131689514));
        oAs.put("mp3", Integer.valueOf(2131689514));
        oAs.put("aac", Integer.valueOf(2131689514));
        oAs.put("ape", Integer.valueOf(2131689514));
        oAs.put("aiff", Integer.valueOf(2131689514));
        oAs.put("aif", Integer.valueOf(2131689514));
    }
}
