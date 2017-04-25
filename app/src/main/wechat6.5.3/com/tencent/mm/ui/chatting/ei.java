package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.a.b;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.chatting.ad.a;

final class ei extends a {
    TextView lts;
    ImageView okm;
    TextView oks;
    TextView ozq;
    TextView ozr;
    AnimImageView ozs;
    FrameLayout ozt;
    FrameLayout ozu;
    ImageView ozv;
    AnimImageView ozw;
    ProgressBar ozx;
    TextView ozy;
    Animation ozz;

    public ei(int i) {
        super(i);
    }

    public final a q(View view, boolean z) {
        super.cM(view);
        this.eTg = (TextView) view.findViewById(2131755027);
        this.iJL = (TextView) view.findViewById(2131755341);
        this.ozr = (TextView) view.findViewById(2131756228);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        this.oky = (ImageView) view.findViewById(2131756230);
        this.lts = (TextView) view.findViewById(2131755342);
        this.ozt = (FrameLayout) view.findViewById(2131756227);
        this.ozq = (TextView) view.findViewById(2131756225);
        this.ozs = (AnimImageView) view.findViewById(2131756229);
        this.ozs.bBF();
        if (z) {
            this.type = 6;
            this.ozs.nSh = true;
            this.oks = (TextView) view.findViewById(2131756107);
            this.ozw = (AnimImageView) view.findViewById(2131756226);
            this.ozw.nSh = true;
            this.ozw.bBF();
        } else {
            this.ozu = (FrameLayout) view.findViewById(2131756270);
            this.ozv = (ImageView) view.findViewById(2131756271);
            this.ozx = (ProgressBar) view.findViewById(2131756269);
            this.ieT = (ProgressBar) view.findViewById(2131756257);
            this.ozy = (TextView) view.findViewById(2131756268);
            this.ozs.nSh = false;
            this.type = 7;
            this.okm = (ImageView) view.findViewById(2131756258);
        }
        return this;
    }

    public static void a(ei eiVar, at atVar, int i, ChattingUI.a aVar, boolean z) {
        if (eiVar != null) {
            float f;
            String str;
            com.tencent.mm.ui.a.a bAK;
            View view;
            int i2;
            int max;
            b bVar;
            n nVar = new n(atVar.field_content);
            float au = q.au(nVar.time);
            if (aVar.onh.oqd == null || atVar.field_msgId != aVar.onh.oqd.olq) {
                eiVar.ozs.setVisibility(8);
                eiVar.ozs.aJV();
            } else {
                eiVar.ozs.setVisibility(0);
                eiVar.ozs.bBG();
            }
            if (atVar.field_isSend == 0) {
                if (nVar.time == 0) {
                    a(eiVar, 8, 0, true);
                    eiVar.ozw.aJV();
                    eiVar.ozw.setVisibility(8);
                    eiVar.oky.setVisibility(8);
                    au = 0.0f;
                    eiVar.ozr.setWidth(com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, iF(0)));
                    eiVar.lts.setText(aVar.getString(2131232930, Integer.valueOf(0)));
                    eiVar.ozs.setWidth(com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, iF(0)));
                } else if (nVar.time == -1) {
                    a(eiVar, 8, 0, true);
                    eiVar.ozw.aJV();
                    eiVar.ozw.setVisibility(8);
                    eiVar.ozr.setWidth(80);
                    eiVar.lts.setVisibility(8);
                    eiVar.ozs.setWidth(com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, iF((int) au)));
                } else {
                    a(eiVar, 8, 0, true);
                    eiVar.ozw.aJV();
                    eiVar.ozw.setVisibility(8);
                    eiVar.lts.setVisibility(0);
                    eiVar.ozr.setWidth(com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, iF((int) au)));
                    eiVar.lts.setText(aVar.getString(2131232930, Integer.valueOf((int) au)));
                    eiVar.ozs.setWidth(com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, iF((int) au)));
                }
            }
            if (1 == atVar.field_isSend) {
                if (atVar.field_status == 1) {
                    a(eiVar, 0, 8, false);
                    eiVar.ozu.setVisibility(8);
                    eiVar.bGr();
                    f = au;
                } else if (nVar.time == -1) {
                    a(eiVar, 8, 0, false);
                    eiVar.ozr.setWidth(80);
                    eiVar.lts.setVisibility(8);
                    eiVar.ozu.setVisibility(8);
                    eiVar.ozs.setWidth(com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, iF((int) au)));
                    eiVar.bGr();
                    f = au;
                } else if (atVar.field_status == 7) {
                    a(eiVar, 8, 8, false);
                    eiVar.lts.setVisibility(8);
                    eiVar.ozu.setVisibility(0);
                    eiVar.bGr();
                    if (eiVar.ozv != null) {
                        eiVar.ozz = AnimationUtils.loadAnimation(eiVar.kad.getContext(), 2130968695);
                        eiVar.ozv.startAnimation(eiVar.ozz);
                    }
                    f = au;
                } else {
                    a(eiVar, 8, 0, false);
                    eiVar.ozu.setVisibility(8);
                    eiVar.lts.setVisibility(0);
                    eiVar.bGr();
                    if (nVar.time == 0) {
                        au = 0.0f;
                    }
                    eiVar.ozr.setWidth(com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, iF((int) au)));
                    eiVar.lts.setText(aVar.getString(2131232930, Integer.valueOf((int) au)));
                    eiVar.ozs.setWidth(com.tencent.mm.bd.a.fromDPToPix(aVar.nDR.nEl, iF((int) au)));
                }
                if (aVar.onh.ilw != null) {
                    eiVar.lts.setTextColor(aVar.onh.ilw.lGi);
                    if (aVar.onh.ilw.lGj) {
                        eiVar.lts.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                    } else {
                        eiVar.lts.setShadowLayer(2.0f, 1.2f, 1.2f, aVar.onh.ilw.lGk);
                    }
                    if (aVar.onh.ilw.lGl) {
                        eiVar.lts.setBackgroundColor(0);
                    } else {
                        eiVar.lts.setBackgroundResource(2130838027);
                    }
                }
                eiVar.ozr.setTag(new dl(atVar, aVar.nQK, i, null, 0, (byte) 0));
                eiVar.ozr.setOnClickListener(aVar.onh.oqh);
                eiVar.ozr.setOnLongClickListener(aVar.onh.oqj);
                if ((atVar.bNn & 1) != 1) {
                    eiVar.ozq.setVisibility(0);
                    if (atVar.field_isSend != 0) {
                        eiVar.ozs.setBackgroundResource(2130837966);
                        eiVar.ozr.setBackgroundResource(2130837966);
                    } else {
                        eiVar.ozy.setBackgroundResource(2130838033);
                        eiVar.ozs.setBackgroundResource(2130838033);
                        eiVar.ozr.setBackgroundResource(2130838033);
                    }
                } else {
                    eiVar.ozq.setVisibility(8);
                    if (atVar.field_isSend != 0) {
                        eiVar.ozs.setBackgroundResource(2130837949);
                        eiVar.ozr.setBackgroundResource(2130837949);
                    } else {
                        eiVar.ozy.setBackgroundResource(2130838028);
                        eiVar.ozs.setBackgroundResource(2130838028);
                        eiVar.ozr.setBackgroundResource(2130838028);
                    }
                }
                if (z) {
                    str = aVar.onh.cyO;
                } else {
                    str = aVar.onh.bdo;
                }
                bAK = a.nHA;
                view = eiVar.ozr;
                i2 = (int) f;
                aVar.er(str);
                if (!(!bAK.bAJ() || bAK.aHq == null || view == null)) {
                    max = Math.max(i2, 1);
                    bVar = new b();
                    bVar.Of(bAK.aHq.getResources().getQuantityString(2131361795, max, new Object[]{Integer.valueOf(max)}));
                    bVar.cy(view);
                }
                eiVar.lts.setContentDescription(" ");
            }
            f = au;
            if (aVar.onh.ilw != null) {
                eiVar.lts.setTextColor(aVar.onh.ilw.lGi);
                if (aVar.onh.ilw.lGj) {
                    eiVar.lts.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                } else {
                    eiVar.lts.setShadowLayer(2.0f, 1.2f, 1.2f, aVar.onh.ilw.lGk);
                }
                if (aVar.onh.ilw.lGl) {
                    eiVar.lts.setBackgroundColor(0);
                } else {
                    eiVar.lts.setBackgroundResource(2130838027);
                }
            }
            eiVar.ozr.setTag(new dl(atVar, aVar.nQK, i, null, 0, (byte) 0));
            eiVar.ozr.setOnClickListener(aVar.onh.oqh);
            eiVar.ozr.setOnLongClickListener(aVar.onh.oqj);
            if ((atVar.bNn & 1) != 1) {
                eiVar.ozq.setVisibility(8);
                if (atVar.field_isSend != 0) {
                    eiVar.ozy.setBackgroundResource(2130838028);
                    eiVar.ozs.setBackgroundResource(2130838028);
                    eiVar.ozr.setBackgroundResource(2130838028);
                } else {
                    eiVar.ozs.setBackgroundResource(2130837949);
                    eiVar.ozr.setBackgroundResource(2130837949);
                }
            } else {
                eiVar.ozq.setVisibility(0);
                if (atVar.field_isSend != 0) {
                    eiVar.ozy.setBackgroundResource(2130838033);
                    eiVar.ozs.setBackgroundResource(2130838033);
                    eiVar.ozr.setBackgroundResource(2130838033);
                } else {
                    eiVar.ozs.setBackgroundResource(2130837966);
                    eiVar.ozr.setBackgroundResource(2130837966);
                }
            }
            if (z) {
                str = aVar.onh.cyO;
            } else {
                str = aVar.onh.bdo;
            }
            bAK = a.nHA;
            view = eiVar.ozr;
            i2 = (int) f;
            aVar.er(str);
            max = Math.max(i2, 1);
            bVar = new b();
            bVar.Of(bAK.aHq.getResources().getQuantityString(2131361795, max, new Object[]{Integer.valueOf(max)}));
            bVar.cy(view);
            eiVar.lts.setContentDescription(" ");
        }
    }

    private void bGr() {
        if (this.ozz != null) {
            this.ozz.cancel();
            this.ozz = null;
        }
    }

    private static void a(ei eiVar, int i, int i2, boolean z) {
        eiVar.oky.setVisibility(i2);
        eiVar.lts.setVisibility(i2);
        eiVar.ozt.setVisibility(i2);
        if (z) {
            eiVar.ozw.setVisibility(i);
            eiVar.oks.setVisibility(i2);
            return;
        }
        eiVar.ozy.setVisibility(i);
    }

    private static int iF(int i) {
        if (i <= 2) {
            return 80;
        }
        if (i < 10) {
            return ((i - 2) * 9) + 80;
        }
        if (i < 60) {
            return (((i / 10) + 7) * 9) + 80;
        }
        return 204;
    }
}
