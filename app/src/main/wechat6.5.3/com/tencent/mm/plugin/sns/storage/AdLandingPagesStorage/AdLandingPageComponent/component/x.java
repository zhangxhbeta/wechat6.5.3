package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class x extends c {
    private Runnable djm;
    TextView eux;

    public x(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
    }

    protected final int aGY() {
        return 2130904428;
    }

    public final void aTU() {
        super.aTU();
        if (!e.remove(this.djm)) {
            e.H(this.djm);
        }
    }

    protected final void aTS() {
        if (((p) this.jxU).aYp != 1) {
            this.eux.setText(((p) this.jxU).jvX);
        } else if (!be.kS(((p) this.jxU).jvX)) {
            final String replace = ((p) this.jxU).jvX.replace("<icon", "<img");
            e.remove(this.djm);
            this.djm = new Runnable(this) {
                final /* synthetic */ x jAg;

                public final void run() {
                    final Spanned fromHtml = Html.fromHtml(replace, new ImageGetter(this) {
                        final /* synthetic */ AnonymousClass1 jAh;

                        {
                            this.jAh = r1;
                        }

                        public final Drawable getDrawable(String str) {
                            String cI = d.cI("adId", str);
                            if (be.kS(cI) || !FileOp.aR(cI)) {
                                d.a("adId", str, false, 0, 0, new a(this) {
                                    final /* synthetic */ AnonymousClass1 jAi;

                                    {
                                        this.jAi = r1;
                                    }

                                    public final void aRx() {
                                    }

                                    public final void aTV() {
                                    }

                                    public final void Bg(String str) {
                                        try {
                                            final Spanned fromHtml = Html.fromHtml(replace, new ImageGetter(this) {
                                                final /* synthetic */ AnonymousClass1 jAj;

                                                {
                                                    this.jAj = r1;
                                                }

                                                public final Drawable getDrawable(String str) {
                                                    String cI = d.cI("adId", str);
                                                    if (be.kS(cI) || !FileOp.aR(cI)) {
                                                        return null;
                                                    }
                                                    Drawable createFromPath = Drawable.createFromPath(cI);
                                                    createFromPath.setBounds(0, 0, createFromPath.getIntrinsicHeight() != 0 ? (createFromPath.getIntrinsicWidth() * ((int) ((p) this.jAj.jAi.jAh.jAg.jxU).cmK)) / createFromPath.getIntrinsicHeight() : createFromPath.getIntrinsicWidth(), createFromPath.getIntrinsicHeight() != 0 ? (int) ((p) this.jAj.jAi.jAh.jAg.jxU).cmK : createFromPath.getIntrinsicHeight());
                                                    return createFromPath;
                                                }
                                            }, null);
                                            ad.o(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 jAj;

                                                public final void run() {
                                                    this.jAj.jAi.jAh.jAg.eux.setText(fromHtml);
                                                }
                                            });
                                        } catch (Exception e) {
                                            v.e("MicroMsg.Sns.AdLandingPageTextComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                                        }
                                    }
                                });
                                return null;
                            }
                            int intrinsicWidth;
                            int i;
                            Drawable createFromPath = Drawable.createFromPath(cI);
                            if (createFromPath.getIntrinsicHeight() != 0) {
                                intrinsicWidth = (createFromPath.getIntrinsicWidth() * ((int) ((p) this.jAh.jAg.jxU).cmK)) / createFromPath.getIntrinsicHeight();
                            } else {
                                intrinsicWidth = createFromPath.getIntrinsicWidth();
                            }
                            if (createFromPath.getIntrinsicHeight() != 0) {
                                i = (int) ((p) this.jAh.jAg.jxU).cmK;
                            } else {
                                i = createFromPath.getIntrinsicHeight();
                            }
                            createFromPath.setBounds(0, 0, intrinsicWidth, i);
                            return createFromPath;
                        }
                    }, null);
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 jAh;

                        public final void run() {
                            this.jAh.jAg.eux.setText(fromHtml);
                        }
                    });
                }
            };
            e.a(this.djm, "");
        }
        if (((p) this.jxU).textAlignment == 0) {
            this.eux.setGravity(3);
        } else if (((p) this.jxU).textAlignment == 1) {
            this.eux.setGravity(17);
        } else if (((p) this.jxU).textAlignment == 2) {
            this.eux.setGravity(5);
        }
        if (((p) this.jxU).jvY == null || ((p) this.jxU).jvY.length() <= 0) {
            this.eux.setTextColor(Color.parseColor("#FFFFFF"));
        } else {
            try {
                this.eux.setTextColor(Color.parseColor(((p) this.jxU).jvY));
            } catch (Exception e) {
                v.e("MicroMsg.Sns.AdLandingPageTextComponent", "parse the color is error : " + ((p) this.jxU).jvY);
            }
        }
        if (((p) this.jxU).cmK > 0.0f) {
            this.eux.setTextSize(0, ((p) this.jxU).cmK);
        }
        TextPaint paint = this.eux.getPaint();
        if (((p) this.jxU).jvZ) {
            paint.setFakeBoldText(true);
        }
        if (((p) this.jxU).jwa) {
            paint.setTextSkewX(-0.25f);
        }
        if (((p) this.jxU).jwb) {
            paint.setUnderlineText(true);
        }
        if (((p) this.jxU).maxLines > 0) {
            this.eux.setMaxLines(((p) this.jxU).maxLines);
        }
    }

    @TargetApi(17)
    public final View aTM() {
        View view = this.dtW;
        view.setBackgroundColor(this.backgroundColor);
        view.findViewById(2131759255).setBackgroundColor(this.backgroundColor);
        view.findViewById(2131759256).setBackgroundColor(this.backgroundColor);
        this.eux = (TextView) view.findViewById(2131759256);
        return view;
    }

    public final void aTO() {
        super.aTO();
    }

    public final void aTP() {
        super.aTP();
    }
}
