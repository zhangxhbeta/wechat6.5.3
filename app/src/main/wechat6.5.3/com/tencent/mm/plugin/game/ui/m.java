package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.a.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.game.c.au;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.c.n.g;
import com.tencent.mm.plugin.game.c.o;
import com.tencent.mm.plugin.game.c.r;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.j;
import java.util.LinkedList;

public final class m extends j<n> {
    private static w gvv;
    private int aWI = 0;
    int eKW = 15;
    int emv = 0;
    private int gjl = 0;
    private long gvA = 0;
    private int gvB = 0;
    private o gvC;
    private f<String, Bitmap> gvD;
    private OnClickListener gvw;
    private OnClickListener gvx;
    private v gvy;
    private v gvz;
    private Context mContext;

    static class a {
        public TextView dMQ;
        public TextView euh;
        public LinearLayout gvF;
        public ImageView gvG;
        public LinearLayout gvH;
        public ImageView gvI;
        public TextView gvJ;
        public LinearLayout gvK;
        public TextView gvL;
        public ImageView gvM;
        public ImageView gvN;
        public TextView gvO;
        public TextView gvP;
        public LinearLayout gvQ;
        public GameMessageListContainerView gvR;

        a() {
        }
    }

    protected final /* bridge */ /* synthetic */ Object asw() {
        return (n) this.nDI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return lC(i);
    }

    public m(Context context, n nVar, int i) {
        int i2 = 0;
        super(context, nVar);
        this.mContext = context;
        this.gjl = i;
        Cursor rawQuery = au.asc().rawQuery("select count(*) from GameRawMessage where " + r.m(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1" + " and isHidden = 0", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        this.emv = i2;
        this.aWI = au.asc().arA();
        gvv = new w();
        this.gvw = new n(context, i);
        this.gvx = new o(context, i);
        this.gvy = new v(context);
        this.gvy.bI(i, 1);
        this.gvz = new v(context);
        this.gvz.bI(i, 2);
        this.gvC = new o(context, this.gjl);
        i2 = c.getScreenWidth(this.mContext);
        this.gvB = com.tencent.mm.bd.a.P(this.mContext, ((i2 - (this.mContext.getResources().getDimensionPixelSize(2131492971) * 2)) - this.mContext.getResources().getDimensionPixelSize(2131493117)) - this.mContext.getResources().getDimensionPixelSize(2131493152)) / 34;
        this.gvD = new f(30);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = View.inflate(this.context, 2130903744, null);
            aVar.gvG = (ImageView) view.findViewById(2131756771);
            aVar.gvF = (LinearLayout) view.findViewById(2131757343);
            aVar.gvH = (LinearLayout) view.findViewById(2131757344);
            aVar.euh = (TextView) view.findViewById(2131756539);
            aVar.gvI = (ImageView) view.findViewById(2131757213);
            aVar.dMQ = (TextView) view.findViewById(2131757003);
            aVar.gvJ = (TextView) view.findViewById(2131757345);
            aVar.gvK = (LinearLayout) view.findViewById(2131757347);
            aVar.gvL = (TextView) view.findViewById(2131757349);
            aVar.gvM = (ImageView) view.findViewById(2131757348);
            aVar.gvN = (ImageView) view.findViewById(2131757350);
            aVar.gvO = (TextView) view.findViewById(2131757351);
            aVar.gvP = (TextView) view.findViewById(2131757352);
            aVar.gvR = (GameMessageListContainerView) view.findViewById(2131757346);
            aVar.gvQ = (LinearLayout) view.findViewById(2131757353);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        n lC = lC(i);
        if (lC == null || !lC.giX) {
            if (lC != null) {
                lC.arp();
                aVar.gvF.setVisibility(0);
                aVar.gvQ.setVisibility(8);
                aVar.gvO.setText(b.f(this.context, lC.field_createTime * 1000));
                CharSequence charSequence;
                g gVar;
                if (lC.field_msgType != 100) {
                    Object obj;
                    int size;
                    String str;
                    aVar.dMQ.setVisibility(8);
                    aVar.gvJ.setVisibility(8);
                    aVar.gvK.setVisibility(8);
                    aVar.gvM.setVisibility(8);
                    aVar.gvN.setVisibility(8);
                    aVar.gvP.setVisibility(8);
                    aVar.gvP.setEnabled(false);
                    aVar.gvN.setEnabled(false);
                    aVar.gvG.setEnabled(false);
                    aVar.euh.setEnabled(false);
                    aVar.gvR.setVisibility(8);
                    aVar.gvI.setVisibility(8);
                    charSequence = null;
                    if (!be.bP(lC.gil)) {
                        gVar = (g) lC.gil.get(0);
                        ak.yW();
                        u LX = com.tencent.mm.model.c.wH().LX(gVar.userName);
                        if (LX != null) {
                            charSequence = LX.tU();
                        }
                        if (be.kS(charSequence)) {
                            charSequence = gVar.aGX;
                        }
                        if (!be.kS(gVar.gji)) {
                            obj = 1;
                            size = lC.gil.size();
                            if (!be.kS(lC.gij) && (lC.giz & 1) == 0) {
                                aVar.gvP.setText(lC.gij);
                                aVar.gvP.setVisibility(0);
                                if ((lC.giz & 2) <= 0) {
                                    aVar.gvP.setTextColor(this.context.getResources().getColor(2131689746));
                                    aVar.gvP.setBackgroundResource(2130838297);
                                    aVar.gvP.setOnClickListener(this.gvw);
                                    aVar.gvP.setTag(lC);
                                    aVar.gvP.setEnabled(true);
                                } else {
                                    aVar.gvP.setTextColor(this.context.getResources().getColor(2131689734));
                                    aVar.gvP.setBackgroundResource(0);
                                    aVar.gvP.setOnClickListener(null);
                                    aVar.gvP.setEnabled(false);
                                }
                            }
                            if (lC.field_msgType != 10 || lC.field_msgType == 11) {
                                if (!be.kS(lC.dFj)) {
                                    aVar.euh.setText(e.a(this.context, lC.dFj, aVar.euh.getTextSize()), BufferType.SPANNABLE);
                                    aVar.euh.setVisibility(0);
                                } else if (be.kS(charSequence)) {
                                    aVar.euh.setText(e.a(this.context, charSequence, aVar.euh.getTextSize()));
                                    aVar.euh.setVisibility(0);
                                } else {
                                    aVar.euh.setVisibility(8);
                                }
                            } else if (be.kS(charSequence)) {
                                aVar.euh.setVisibility(8);
                            } else {
                                aVar.euh.setText(e.a(this.context, charSequence, aVar.euh.getTextSize()));
                                aVar.euh.setVisibility(0);
                                if (obj != null) {
                                    aVar.euh.setOnClickListener(this.gvy);
                                    aVar.euh.setTag(lC);
                                    aVar.euh.setEnabled(true);
                                }
                            }
                            switch (lC.field_msgType) {
                                case 2:
                                    c(aVar.gvG, lC.gif);
                                    str = "礼物";
                                    if (lC.giw.contains("爱心")) {
                                        str = "爱心";
                                    } else if (lC.giw.contains("体力")) {
                                        str = "体力";
                                    }
                                    if (size <= 1) {
                                        aVar.dMQ.setText(this.context.getResources().getString(2131233111, new Object[]{String.valueOf(size), str}));
                                    } else {
                                        aVar.dMQ.setText(this.context.getResources().getString(2131233112, new Object[]{str}));
                                    }
                                    aVar.dMQ.setVisibility(0);
                                    a(lC, aVar);
                                    break;
                                case 5:
                                    if (be.bP(lC.gil)) {
                                        aVar.gvG.setVisibility(0);
                                        if (be.kS(((g) lC.gil.get(0)).gjh)) {
                                            c(aVar.gvG, ((g) lC.gil.get(0)).gjh);
                                        } else {
                                            a(aVar.gvG, ((g) lC.gil.get(0)).userName);
                                        }
                                        if (!be.kS(((g) lC.gil.get(0)).gji)) {
                                            aVar.gvG.setOnClickListener(this.gvz);
                                            aVar.gvG.setTag(lC);
                                            aVar.gvG.setEnabled(true);
                                        }
                                    } else {
                                        aVar.gvG.setVisibility(8);
                                    }
                                    if (size <= 1) {
                                        aVar.dMQ.setText(this.context.getResources().getString(2131233109, new Object[]{String.valueOf(size)}));
                                        a(lC, aVar);
                                    } else {
                                        aVar.dMQ.setText(this.context.getResources().getString(2131233110));
                                    }
                                    aVar.gvK.setVisibility(0);
                                    aVar.dMQ.setVisibility(0);
                                    aVar.gvL.setText(lC.giH);
                                    aVar.gvK.setOnClickListener(this.gvx);
                                    aVar.gvK.setTag(Long.valueOf(lC.field_msgId));
                                    if (!be.kS(lC.giJ)) {
                                        aVar.gvM.setVisibility(0);
                                        c(aVar.gvM, lC.giJ);
                                        break;
                                    }
                                    break;
                                case 6:
                                    if (be.bP(lC.gil)) {
                                        aVar.gvG.setVisibility(0);
                                        if (be.kS(((g) lC.gil.get(0)).gjh)) {
                                            c(aVar.gvG, ((g) lC.gil.get(0)).gjh);
                                        } else {
                                            a(aVar.gvG, ((g) lC.gil.get(0)).userName);
                                        }
                                        if (!be.kS(((g) lC.gil.get(0)).gji)) {
                                            aVar.gvG.setOnClickListener(this.gvz);
                                            aVar.gvG.setTag(lC);
                                            aVar.gvG.setEnabled(true);
                                        }
                                    } else {
                                        aVar.gvG.setVisibility(8);
                                    }
                                    aVar.gvK.setVisibility(0);
                                    aVar.gvK.setOnClickListener(this.gvx);
                                    aVar.gvK.setTag(Long.valueOf(lC.field_msgId));
                                    if (lC.giS == 1) {
                                        if (lC.giS == 2) {
                                            if (lC.giS == 3) {
                                                aVar.dMQ.setVisibility(0);
                                                if (size <= 1) {
                                                    aVar.dMQ.setText(this.context.getResources().getString(2131233107, new Object[]{String.valueOf(size)}));
                                                    a(lC, aVar);
                                                } else {
                                                    aVar.dMQ.setText(this.context.getResources().getString(2131233108));
                                                }
                                                aVar.gvL.setText(lC.giG);
                                                break;
                                            }
                                        }
                                        aVar.gvJ.setVisibility(0);
                                        aVar.gvJ.setText(e.a(this.context, lC.giD, aVar.gvJ.getTextSize()));
                                        aVar.gvL.setText(lC.giE);
                                        break;
                                    }
                                    aVar.gvJ.setVisibility(0);
                                    aVar.gvJ.setText(e.a(this.context, lC.giD, aVar.gvJ.getTextSize()));
                                    aVar.gvL.setText(lC.giG);
                                    break;
                                    break;
                                case 10:
                                case 11:
                                    if (be.kS(lC.gif)) {
                                        c(aVar.gvG, lC.gif);
                                        aVar.gvG.setVisibility(0);
                                    } else {
                                        v.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                        aVar.gvG.setVisibility(8);
                                    }
                                    if (!be.kS(lC.fgr)) {
                                        if (be.kS(lC.gir)) {
                                            aVar.gvJ.setText(lC.fgr);
                                            aVar.gvJ.setVisibility(0);
                                        } else {
                                            aVar.gvK.setVisibility(0);
                                            aVar.gvL.setText(lC.fgr);
                                            aVar.gvK.setOnClickListener(this.gvx);
                                            aVar.gvK.setTag(Long.valueOf(lC.field_msgId));
                                        }
                                    }
                                    if (!be.kS(lC.gir)) {
                                        c(aVar.gvN, lC.gir);
                                        aVar.gvN.setTag(Long.valueOf(lC.field_msgId));
                                        aVar.gvN.setOnTouchListener(gvv);
                                        aVar.gvN.setOnClickListener(this.gvx);
                                        aVar.gvN.setVisibility(0);
                                        aVar.gvN.setEnabled(true);
                                        break;
                                    }
                                    break;
                                default:
                                    v.e("MicroMsg.GameMessageAdapter", "error msgtype: " + lC.field_msgType);
                                    break;
                            }
                        }
                    }
                    obj = null;
                    size = lC.gil.size();
                    aVar.gvP.setText(lC.gij);
                    aVar.gvP.setVisibility(0);
                    if ((lC.giz & 2) <= 0) {
                        aVar.gvP.setTextColor(this.context.getResources().getColor(2131689734));
                        aVar.gvP.setBackgroundResource(0);
                        aVar.gvP.setOnClickListener(null);
                        aVar.gvP.setEnabled(false);
                    } else {
                        aVar.gvP.setTextColor(this.context.getResources().getColor(2131689746));
                        aVar.gvP.setBackgroundResource(2130838297);
                        aVar.gvP.setOnClickListener(this.gvw);
                        aVar.gvP.setTag(lC);
                        aVar.gvP.setEnabled(true);
                    }
                    if (lC.field_msgType != 10) {
                    }
                    if (!be.kS(lC.dFj)) {
                        aVar.euh.setText(e.a(this.context, lC.dFj, aVar.euh.getTextSize()), BufferType.SPANNABLE);
                        aVar.euh.setVisibility(0);
                    } else if (be.kS(charSequence)) {
                        aVar.euh.setVisibility(8);
                    } else {
                        aVar.euh.setText(e.a(this.context, charSequence, aVar.euh.getTextSize()));
                        aVar.euh.setVisibility(0);
                    }
                    switch (lC.field_msgType) {
                        case 2:
                            c(aVar.gvG, lC.gif);
                            str = "礼物";
                            if (lC.giw.contains("爱心")) {
                                str = "爱心";
                            } else if (lC.giw.contains("体力")) {
                                str = "体力";
                            }
                            if (size <= 1) {
                                aVar.dMQ.setText(this.context.getResources().getString(2131233112, new Object[]{str}));
                            } else {
                                aVar.dMQ.setText(this.context.getResources().getString(2131233111, new Object[]{String.valueOf(size), str}));
                            }
                            aVar.dMQ.setVisibility(0);
                            a(lC, aVar);
                            break;
                        case 5:
                            if (be.bP(lC.gil)) {
                                aVar.gvG.setVisibility(8);
                            } else {
                                aVar.gvG.setVisibility(0);
                                if (be.kS(((g) lC.gil.get(0)).gjh)) {
                                    a(aVar.gvG, ((g) lC.gil.get(0)).userName);
                                } else {
                                    c(aVar.gvG, ((g) lC.gil.get(0)).gjh);
                                }
                                if (be.kS(((g) lC.gil.get(0)).gji)) {
                                    aVar.gvG.setOnClickListener(this.gvz);
                                    aVar.gvG.setTag(lC);
                                    aVar.gvG.setEnabled(true);
                                }
                            }
                            if (size <= 1) {
                                aVar.dMQ.setText(this.context.getResources().getString(2131233110));
                            } else {
                                aVar.dMQ.setText(this.context.getResources().getString(2131233109, new Object[]{String.valueOf(size)}));
                                a(lC, aVar);
                            }
                            aVar.gvK.setVisibility(0);
                            aVar.dMQ.setVisibility(0);
                            aVar.gvL.setText(lC.giH);
                            aVar.gvK.setOnClickListener(this.gvx);
                            aVar.gvK.setTag(Long.valueOf(lC.field_msgId));
                            if (be.kS(lC.giJ)) {
                                aVar.gvM.setVisibility(0);
                                c(aVar.gvM, lC.giJ);
                                break;
                            }
                            break;
                        case 6:
                            if (be.bP(lC.gil)) {
                                aVar.gvG.setVisibility(8);
                            } else {
                                aVar.gvG.setVisibility(0);
                                if (be.kS(((g) lC.gil.get(0)).gjh)) {
                                    a(aVar.gvG, ((g) lC.gil.get(0)).userName);
                                } else {
                                    c(aVar.gvG, ((g) lC.gil.get(0)).gjh);
                                }
                                if (be.kS(((g) lC.gil.get(0)).gji)) {
                                    aVar.gvG.setOnClickListener(this.gvz);
                                    aVar.gvG.setTag(lC);
                                    aVar.gvG.setEnabled(true);
                                }
                            }
                            aVar.gvK.setVisibility(0);
                            aVar.gvK.setOnClickListener(this.gvx);
                            aVar.gvK.setTag(Long.valueOf(lC.field_msgId));
                            if (lC.giS == 1) {
                                if (lC.giS == 2) {
                                    if (lC.giS == 3) {
                                        aVar.dMQ.setVisibility(0);
                                        if (size <= 1) {
                                            aVar.dMQ.setText(this.context.getResources().getString(2131233108));
                                        } else {
                                            aVar.dMQ.setText(this.context.getResources().getString(2131233107, new Object[]{String.valueOf(size)}));
                                            a(lC, aVar);
                                        }
                                        aVar.gvL.setText(lC.giG);
                                        break;
                                    }
                                }
                                aVar.gvJ.setVisibility(0);
                                aVar.gvJ.setText(e.a(this.context, lC.giD, aVar.gvJ.getTextSize()));
                                aVar.gvL.setText(lC.giE);
                                break;
                            }
                            aVar.gvJ.setVisibility(0);
                            aVar.gvJ.setText(e.a(this.context, lC.giD, aVar.gvJ.getTextSize()));
                            aVar.gvL.setText(lC.giG);
                            break;
                            break;
                        case 10:
                        case 11:
                            if (be.kS(lC.gif)) {
                                v.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                aVar.gvG.setVisibility(8);
                            } else {
                                c(aVar.gvG, lC.gif);
                                aVar.gvG.setVisibility(0);
                            }
                            if (be.kS(lC.fgr)) {
                                if (be.kS(lC.gir)) {
                                    aVar.gvK.setVisibility(0);
                                    aVar.gvL.setText(lC.fgr);
                                    aVar.gvK.setOnClickListener(this.gvx);
                                    aVar.gvK.setTag(Long.valueOf(lC.field_msgId));
                                } else {
                                    aVar.gvJ.setText(lC.fgr);
                                    aVar.gvJ.setVisibility(0);
                                }
                            }
                            if (be.kS(lC.gir)) {
                                c(aVar.gvN, lC.gir);
                                aVar.gvN.setTag(Long.valueOf(lC.field_msgId));
                                aVar.gvN.setOnTouchListener(gvv);
                                aVar.gvN.setOnClickListener(this.gvx);
                                aVar.gvN.setVisibility(0);
                                aVar.gvN.setEnabled(true);
                                break;
                            }
                            break;
                        default:
                            v.e("MicroMsg.GameMessageAdapter", "error msgtype: " + lC.field_msgType);
                            break;
                    }
                }
                if (lC.giP != null) {
                    c(aVar.gvG, lC.giP.gje);
                    aVar.gvG.setVisibility(0);
                    if (be.kS(lC.giP.gjd)) {
                        aVar.euh.setVisibility(8);
                    } else {
                        aVar.euh.setText(lC.giP.gjd);
                        aVar.euh.setVisibility(0);
                    }
                    if (be.kS(lC.giP.gjf)) {
                        aVar.gvI.setVisibility(8);
                    } else {
                        c(aVar.gvI, lC.giP.gjf);
                        aVar.gvI.setVisibility(0);
                    }
                    if (be.kS(lC.giP.giZ)) {
                        aVar.euh.setEnabled(false);
                        aVar.gvG.setEnabled(false);
                    } else {
                        aVar.euh.setEnabled(true);
                        aVar.gvG.setEnabled(true);
                        com.tencent.mm.plugin.game.c.o.a aVar2 = new com.tencent.mm.plugin.game.c.o.a(lC, lC.giP.giZ, 1);
                        com.tencent.mm.plugin.game.c.o.a aVar3 = new com.tencent.mm.plugin.game.c.o.a(lC, lC.giP.giZ, 2);
                        aVar.euh.setTag(aVar2);
                        aVar.euh.setOnClickListener(this.gvC);
                        aVar.gvG.setTag(aVar3);
                        aVar.gvG.setOnClickListener(this.gvC);
                    }
                } else if (be.bP(lC.gil)) {
                    aVar.gvG.setVisibility(8);
                    aVar.euh.setVisibility(8);
                    aVar.gvI.setVisibility(8);
                } else {
                    gVar = (g) lC.gil.get(0);
                    if (be.kS(gVar.aGX)) {
                        ak.yW();
                        u LX2 = com.tencent.mm.model.c.wH().LX(gVar.userName);
                        charSequence = (LX2 == null || be.kS(LX2.tU())) ? gVar.userName : LX2.tU();
                    } else {
                        charSequence = gVar.aGX;
                    }
                    if (be.kS(gVar.gjk)) {
                        aVar.euh.setEnabled(false);
                        aVar.gvG.setEnabled(false);
                    } else {
                        aVar.euh.setEnabled(true);
                        aVar.gvG.setEnabled(true);
                        com.tencent.mm.plugin.game.c.o.a aVar4 = new com.tencent.mm.plugin.game.c.o.a(lC, gVar.gjk, 1);
                        com.tencent.mm.plugin.game.c.o.a aVar5 = new com.tencent.mm.plugin.game.c.o.a(lC, gVar.gjk, 2);
                        aVar.euh.setTag(aVar4);
                        aVar.euh.setOnClickListener(this.gvC);
                        aVar.gvG.setTag(aVar5);
                        aVar.gvG.setOnClickListener(this.gvC);
                    }
                    if (be.kS(charSequence)) {
                        aVar.euh.setVisibility(8);
                    } else {
                        aVar.euh.setText(e.a(this.context, charSequence, aVar.euh.getTextSize()), BufferType.SPANNABLE);
                        aVar.euh.setVisibility(0);
                    }
                    aVar.gvG.setVisibility(0);
                    if (be.kS(gVar.gjh)) {
                        a(aVar.gvG, gVar.userName);
                    } else {
                        c(aVar.gvG, gVar.gjh);
                    }
                    if (be.kS(gVar.gjj)) {
                        aVar.gvI.setVisibility(8);
                    } else {
                        c(aVar.gvI, gVar.gjj);
                        aVar.gvI.setVisibility(0);
                    }
                }
                if (be.kS(lC.giL)) {
                    aVar.dMQ.setVisibility(8);
                } else {
                    if (lC.gil.size() > 1) {
                        aVar.dMQ.setText(this.context.getResources().getString(2131233113, new Object[]{Integer.valueOf(lC.gil.size())}) + lC.giL);
                    } else {
                        aVar.dMQ.setText(lC.giL);
                    }
                    aVar.dMQ.setVisibility(0);
                }
                if (be.kS(lC.giM)) {
                    aVar.gvJ.setVisibility(8);
                } else {
                    aVar.gvJ.setText(e.a(this.context, lC.giM, aVar.gvJ.getTextSize()));
                    aVar.gvJ.setVisibility(0);
                }
                a(lC, aVar);
                if (be.kS(lC.giQ.gjc)) {
                    aVar.gvK.setVisibility(8);
                } else {
                    aVar.gvK.setVisibility(0);
                    if (be.kS(lC.giQ.giZ)) {
                        aVar.gvK.setEnabled(false);
                    } else {
                        aVar.gvK.setTag(new com.tencent.mm.plugin.game.c.o.a(lC, lC.giQ.giZ, 3));
                        aVar.gvK.setOnClickListener(this.gvC);
                        aVar.gvK.setEnabled(true);
                    }
                    aVar.gvL.setText(e.a(this.context, lC.giQ.gjc, aVar.gvL.getTextSize()));
                    if (be.kS(lC.giQ.giY)) {
                        aVar.gvM.setVisibility(8);
                    } else {
                        c(aVar.gvM, lC.giQ.giY);
                        aVar.gvM.setVisibility(0);
                    }
                }
                if (be.kS(lC.giN)) {
                    aVar.gvN.setVisibility(8);
                } else {
                    c(aVar.gvN, lC.giN);
                    aVar.gvN.setVisibility(0);
                    if (be.kS(lC.giO)) {
                        aVar.gvN.setEnabled(false);
                    } else {
                        aVar.gvN.setTag(new com.tencent.mm.plugin.game.c.o.a(lC, lC.giO, 3));
                        aVar.gvN.setOnClickListener(this.gvC);
                        aVar.gvN.setEnabled(true);
                    }
                }
                if (be.kS(lC.giR.mName)) {
                    aVar.gvP.setVisibility(8);
                } else {
                    aVar.gvP.setText(lC.giR.mName);
                    aVar.gvP.setVisibility(0);
                    if (be.kS(lC.giR.giZ)) {
                        aVar.gvP.setEnabled(false);
                    } else {
                        aVar.gvP.setTag(new com.tencent.mm.plugin.game.c.o.a(lC, lC.giR.giZ, 5));
                        aVar.gvP.setOnClickListener(this.gvC);
                        aVar.gvP.setEnabled(true);
                    }
                }
            }
        } else {
            aVar.gvF.setVisibility(8);
            aVar.gvQ.setVisibility(0);
        }
        return view;
    }

    private void a(n nVar, a aVar) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i < nVar.gil.size(); i++) {
            linkedList.add(nVar.gil.get(i));
        }
        aVar.gvR.a(nVar, linkedList, this.gvB, this.gjl, this.gvD);
    }

    private void a(ImageView imageView, String str) {
        if (be.kS(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.m(imageView, str);
        } else if (this.gvD.aI(str)) {
            Bitmap bitmap = (Bitmap) this.gvD.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                b(imageView, str);
            } else {
                imageView.setImageBitmap(bitmap);
            }
        } else {
            b(imageView, str);
        }
    }

    private void b(ImageView imageView, String str) {
        Bitmap f = com.tencent.mm.plugin.game.e.e.asK().f(imageView, str);
        if (f != null) {
            this.gvD.put(str, f);
        }
    }

    private void c(ImageView imageView, String str) {
        if (this.gvD.aI(str)) {
            Bitmap bitmap = (Bitmap) this.gvD.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                d(imageView, str);
                return;
            } else {
                imageView.setImageBitmap(bitmap);
                return;
            }
        }
        d(imageView, str);
    }

    private void d(ImageView imageView, final String str) {
        com.tencent.mm.plugin.game.e.e.a.a aVar = new com.tencent.mm.plugin.game.e.e.a.a();
        aVar.cPq = false;
        com.tencent.mm.plugin.game.e.e.asK().a(imageView, str, aVar.asL(), new com.tencent.mm.plugin.game.e.e.b(this) {
            final /* synthetic */ m gvE;

            public final void m(Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.gvE.gvD.put(str, bitmap);
                }
            }
        });
    }

    public final void Ol() {
        setCursor(au.asc().rawQuery("select * from GameRawMessage where " + r.m(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1" + " and isHidden = 0" + " order by isRead, createTime desc limit " + this.eKW, new String[0]));
        this.eKW = getCount();
        if (this.nDK != null) {
            this.nDK.Oi();
        }
        super.notifyDataSetChanged();
    }

    protected final void Om() {
        avc();
        Ol();
    }

    private static n a(n nVar, Cursor cursor) {
        if (nVar == null) {
            nVar = new n();
        }
        nVar.b(cursor);
        return nVar;
    }

    public final boolean abO() {
        return this.eKW >= this.emv;
    }

    public final int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        if (this.count <= 0) {
            return 0;
        }
        return this.count + asv();
    }

    public final boolean lB(int i) {
        return this.emv > this.aWI && this.aWI > 0 && i == this.aWI;
    }

    protected final int asv() {
        return (this.emv <= this.aWI || this.aWI <= 0) ? 0 : 1;
    }

    private n lC(int i) {
        if (lB(i)) {
            return (n) this.nDI;
        }
        n nVar;
        if (this.nDJ != null) {
            nVar = (n) this.nDJ.get(Integer.valueOf(i));
            if (nVar != null) {
                return nVar;
            }
        }
        Object obj = (this.emv <= this.aWI || this.aWI <= 0 || i <= this.aWI) ? null : 1;
        int i2;
        if (obj != null) {
            i2 = i - 1;
        } else {
            i2 = i;
        }
        if (i < 0 || !getCursor().moveToPosition(r0)) {
            return null;
        }
        if (this.nDJ == null) {
            return a((n) this.nDI, getCursor());
        }
        nVar = a(null, getCursor());
        this.nDJ.put(Integer.valueOf(i), nVar);
        return nVar;
    }
}
