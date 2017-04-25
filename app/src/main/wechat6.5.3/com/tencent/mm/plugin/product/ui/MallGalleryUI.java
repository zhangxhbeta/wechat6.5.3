package com.tencent.mm.plugin.product.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.pluginsdk.model.d;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import java.util.List;

@a(3)
public class MallGalleryUI extends MallBaseUI {
    private final String TAG = "MicroMsg.MallGalleryUI";
    private ViewPager hRI;
    private g hRJ;
    private List<String> hRK;
    private int hRL = 0;
    private boolean hRM;

    static /* synthetic */ void c(MallGalleryUI mallGalleryUI) {
        mallGalleryUI.hRM = !mallGalleryUI.hRM;
        if (mallGalleryUI.hRM) {
            mallGalleryUI.bzZ();
        } else {
            mallGalleryUI.nDR.bAj();
        }
    }

    protected final int getLayoutId() {
        return 2130904178;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hRK = getIntent().getStringArrayListExtra("keys_img_urls");
        this.nDR.bAj();
        this.hRM = false;
        NI();
    }

    protected void onResume() {
        super.onResume();
        this.hRJ.aW(this.hRK);
        this.hRJ.notifyDataSetChanged();
        if (this.hRK != null) {
            this.hRK.size();
        }
    }

    protected final void NI() {
        this.hRI = (ViewPager) findViewById(2131758588);
        this.hRI.yk = new e(this) {
            final /* synthetic */ MallGalleryUI hRN;

            {
                this.hRN = r1;
            }

            public final void W(int i) {
                v.d("MicroMsg.MallGalleryUI", "Page Selected postion: %d", new Object[]{Integer.valueOf(i)});
                this.hRN.hRL = i;
                if (this.hRN.hRM) {
                    this.hRN.nDR.bAj();
                    this.hRN.hRM = false;
                }
            }

            public final synchronized void a(int i, float f, int i2) {
            }

            public final void X(int i) {
            }
        };
        this.hRJ = new g(this);
        this.hRJ.hSi = new g.a(this) {
            final /* synthetic */ MallGalleryUI hRN;

            {
                this.hRN = r1;
            }

            public final void aGu() {
                MallGalleryUI.c(this.hRN);
            }
        };
        this.hRI.a(this.hRJ);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MallGalleryUI hRN;

            {
                this.hRN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hRN.finish();
                return false;
            }
        });
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ MallGalleryUI hRN;

            {
                this.hRN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String[] stringArray;
                if (c.EH("favorite")) {
                    stringArray = this.hRN.getResources().getStringArray(2131296263);
                } else {
                    stringArray = this.hRN.getResources().getStringArray(2131296264);
                }
                g.a(this.hRN.nDR.nEl, null, stringArray, null, false, new g.c(this) {
                    final /* synthetic */ AnonymousClass4 hRO;

                    {
                        this.hRO = r1;
                    }

                    public final void gT(int i) {
                        MallGalleryUI mallGalleryUI;
                        String aGt;
                        switch (i) {
                            case 0:
                                mallGalleryUI = this.hRO.hRN;
                                Intent intent = new Intent();
                                intent.putExtra("Retr_Msg_content", "");
                                intent.putExtra("Retr_Msg_Type", 0);
                                if (be.kS(mallGalleryUI.aGt())) {
                                    v.e("MicroMsg.MallGalleryUI", "url is null or nil");
                                    return;
                                }
                                intent.putExtra("Retr_File_Name", mallGalleryUI.aGt());
                                intent.putExtra("Retr_go_to_chattingUI", false);
                                intent.putExtra("Retr_show_success_tips", true);
                                c.a(mallGalleryUI, ".ui.transmit.MsgRetransmitUI", intent);
                                return;
                            case 1:
                                mallGalleryUI = this.hRO.hRN;
                                aGt = mallGalleryUI.aGt();
                                if (be.kS(aGt)) {
                                    v.w("MicroMsg.MallGalleryUI", "save error.");
                                    return;
                                }
                                v.d("MicroMsg.MallGalleryUI", "can save. img path: %s", new Object[]{aGt});
                                l.h(aGt, mallGalleryUI);
                                return;
                            case 2:
                                mallGalleryUI = this.hRO.hRN;
                                aGt = mallGalleryUI.aGt();
                                if (be.kS(aGt)) {
                                    v.w("MicroMsg.MallGalleryUI", "file path invalid");
                                    return;
                                }
                                v.d("MicroMsg.MallGalleryUI", "file path valid");
                                bp bpVar = new bp();
                                d.a(bpVar, 9, aGt);
                                bpVar.aZd.aZl = 4;
                                bpVar.aZd.aXH = mallGalleryUI;
                                com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
    }

    final String aGt() {
        String str;
        if (this.hRK == null || this.hRK.size() < this.hRL + 1) {
            v.e("MicroMsg.MallGalleryUI", "data not ready.retransmit failed");
            str = null;
        } else {
            str = (String) this.hRK.get(this.hRL);
        }
        if (!be.kS(str)) {
            return c.xK(str);
        }
        v.w("MicroMsg.MallGalleryUI", "invoke error. No current url");
        return null;
    }
}
