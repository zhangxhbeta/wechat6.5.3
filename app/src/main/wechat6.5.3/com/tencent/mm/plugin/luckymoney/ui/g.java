package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.luckymoney.c.ag;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class g {

    public static final class c {
        public boolean hgO = false;
        public int hgP = 0;
        public int resourceId = 0;
        public int textColor = Integer.MIN_VALUE;
        public int textSize = Integer.MIN_VALUE;
    }

    interface d {
        void a(Context context, ViewGroup viewGroup, ag agVar);
    }

    static class a implements d {
        c hgJ;

        a() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final ag agVar) {
            if (be.kS(agVar.name)) {
                v.w("MicroMsg.LuckyMoneyOperationViewMgr", "BannerPicOperationView attach iconUrl null");
                viewGroup.setVisibility(8);
                return;
            }
            View imageView = new ImageView(context);
            imageView.setScaleType(ScaleType.FIT_XY);
            n.e(imageView, agVar.name);
            if (!be.kS(agVar.content)) {
                imageView.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a hgL;

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(agVar.hcu)});
                        if (this.hgL.hgJ != null) {
                            com.tencent.mm.protocal.g.cq(this.hgL.hgJ.hgP, 1);
                        }
                        com.tencent.mm.wallet_core.ui.e.l(context, agVar.content, true);
                    }
                });
            }
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            viewGroup.addView(imageView);
            viewGroup.setVisibility(0);
            com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(agVar.hcu)});
            if (this.hgJ != null) {
                com.tencent.mm.protocal.g.cq(this.hgJ.hgP, 0);
            }
        }
    }

    static class b implements d {
        c hgJ;

        b() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final ag agVar) {
            if (!be.kS(agVar.name)) {
                View textView = new TextView(context);
                if (this.hgJ == null || this.hgJ.textColor == Integer.MIN_VALUE) {
                    textView.setTextColor(context.getResources().getColor(2131690102));
                } else {
                    textView.setTextColor(this.hgJ.textColor);
                }
                if (this.hgJ == null || this.hgJ.textSize == Integer.MIN_VALUE) {
                    textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(2131493128));
                } else {
                    textView.setTextSize(0, (float) this.hgJ.textSize);
                }
                textView.setGravity(17);
                textView.setText(agVar.name);
                if (!be.kS(agVar.content)) {
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ b hgM;

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(agVar.hcu)});
                            if (agVar.hcv != 1) {
                                new com.tencent.mm.pluginsdk.ui.applet.b(context, agVar.content, 0, new com.tencent.mm.pluginsdk.ui.applet.b.a(this) {
                                    final /* synthetic */ AnonymousClass1 hgN;

                                    {
                                        this.hgN = r1;
                                    }

                                    public final void mH(int i) {
                                        switch (i) {
                                            case ai.CTRL_INDEX /*-2*/:
                                            case 1:
                                                com.tencent.mm.wallet_core.ui.e.bj(context, agVar.content);
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                }).show();
                            } else {
                                com.tencent.mm.wallet_core.ui.e.L(context, agVar.content);
                            }
                        }
                    });
                }
                viewGroup.addView(textView, new LayoutParams(-2, -2));
                viewGroup.setVisibility(0);
                com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(agVar.hcu)});
            }
        }
    }

    static class e implements d {
        c hgJ;

        e() {
        }

        public final void a(final Context context, ViewGroup viewGroup, final ag agVar) {
            if (!be.kS(agVar.name)) {
                View inflate = LayoutInflater.from(context).inflate(2130903903, viewGroup, true);
                TextView textView = (TextView) inflate.findViewById(2131757941);
                ImageView imageView = (ImageView) inflate.findViewById(2131757940);
                if (be.kS(agVar.iconUrl)) {
                    imageView.setVisibility(8);
                } else {
                    n.e(imageView, agVar.iconUrl);
                    imageView.setVisibility(0);
                }
                if (!(this.hgJ == null || this.hgJ.textColor == Integer.MIN_VALUE)) {
                    textView.setTextColor(this.hgJ.textColor);
                }
                if (this.hgJ == null || this.hgJ.textSize == Integer.MIN_VALUE) {
                    textView.setTextSize(0, (float) context.getResources().getDimensionPixelSize(2131493128));
                } else {
                    textView.setTextSize(0, (float) this.hgJ.textSize);
                }
                textView.setGravity(17);
                textView.setText(agVar.name);
                if (!be.kS(agVar.content)) {
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ e hgQ;

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(agVar.hcu)});
                            if (this.hgQ.hgJ != null) {
                                com.tencent.mm.protocal.g.cq(this.hgQ.hgJ.hgP, 1);
                            }
                            if (this.hgQ.hgJ != null && this.hgQ.hgJ.hgO) {
                                com.tencent.mm.plugin.report.service.g.iuh.h(13051, new Object[]{Integer.valueOf(this.hgQ.hgJ.hgP), Integer.valueOf(2), "", "", "", agVar.content, agVar.type, "", "", Integer.valueOf(this.hgQ.hgJ.resourceId)});
                            }
                            if (agVar.type.equals("Native")) {
                                v.i("MicroMsg.LuckyMoneyOperationViewMgr", "go native:" + agVar.content);
                                if ("weixin://festival/gotoshake".equalsIgnoreCase(agVar.content)) {
                                    v.i("MicroMsg.LuckyMoneyOperationViewMgr", " go new year shake");
                                    return;
                                }
                                return;
                            }
                            com.tencent.mm.wallet_core.ui.e.l(context, agVar.content, true);
                        }
                    });
                }
                viewGroup.setVisibility(0);
                com.tencent.mm.plugin.report.service.g.iuh.h(11701, new Object[]{Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(agVar.hcu)});
                if (this.hgJ != null) {
                    com.tencent.mm.protocal.g.cq(this.hgJ.hgP, 0);
                }
            }
        }
    }

    public static void a(Context context, ViewGroup viewGroup, ag agVar, c cVar) {
        if (agVar != null) {
            a(context, viewGroup, agVar, cVar, agVar.type);
        }
    }

    public static void a(Context context, ViewGroup viewGroup, ag agVar, c cVar, String str) {
        if (viewGroup != null && agVar != null) {
            if (agVar.cdf == 0) {
                v.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + agVar.cdf);
                viewGroup.setVisibility(8);
            } else if (!agVar.type.equalsIgnoreCase(str)) {
                v.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + agVar.type + ", " + str);
                viewGroup.setVisibility(8);
            } else if (str.equalsIgnoreCase("Text") || str.equalsIgnoreCase("Native")) {
                r0 = new e();
                r0.hgJ = cVar;
                r0.a(context, viewGroup, agVar);
            } else if (str.equalsIgnoreCase("Pic")) {
                r0 = new a();
                r0.hgJ = cVar;
                r0.a(context, viewGroup, agVar);
            } else if (str.equalsIgnoreCase("Appid")) {
                r0 = new b();
                r0.hgJ = cVar;
                r0.a(context, viewGroup, agVar);
            }
        }
    }
}
