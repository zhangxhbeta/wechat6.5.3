package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.ah;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.ui.SnsInfoFlip.c;
import com.tencent.mm.plugin.sns.ui.r.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnsUploadBrowseUI extends SnsBaseGalleryUI implements a {
    private int jMc = 0;
    private ArrayList<String> jXP = new ArrayList();
    private HashMap<Integer, Boolean> jXQ = new HashMap();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    public void onDestroy() {
        if (this.jMb != null) {
            this.jMb.aWV();
            this.jMb.onDestroy();
        }
        ad.aSB().M(this);
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.jMb != null) {
            this.jMb.aWU();
        }
    }

    protected void onPause() {
        if (this.jMb != null) {
            this.jMb.onPause();
        }
        super.onPause();
    }

    protected final int getLayoutId() {
        return 2130904439;
    }

    public final void aYa() {
        Intent intent = new Intent();
        List<b> list = this.jMb.cwd;
        if (list != null) {
            this.jXP.clear();
            for (b bVar : list) {
                Object substring;
                String str = ad.xi() + bVar.boL.gID;
                if (bVar.boL.gID.startsWith("pre_temp_extend_pic")) {
                    substring = bVar.boL.gID.substring(19);
                } else {
                    String str2 = str;
                }
                this.jXP.add(substring);
            }
            intent.putExtra("sns_gallery_temp_paths", this.jXP);
            intent.putExtra("sns_update_preview_image_count", this.jXQ.size());
            this.jXQ.clear();
            setResult(-1, intent);
            finish();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        v.d("MicroMsg.SnsUploadBrowseUI", "dispatchKeyEvent");
        aYa();
        return true;
    }

    protected final void NI() {
        String ah = be.ah(getIntent().getStringExtra("sns_gallery_userName"), "");
        this.jXP = getIntent().getStringArrayListExtra("sns_gallery_temp_paths");
        if (this.jXP != null) {
            this.jMc = getIntent().getIntExtra("sns_gallery_position", 0);
            this.jMb = new SnsInfoFlip(this);
            this.jMb.jOS = false;
            this.jMb.jOR = true;
            ad.xi();
            this.jMb.a(ah.bn(this.jXP), ah, this.jMc, this.jLW, this);
            this.jMb.jPi = new c(this) {
                final /* synthetic */ SnsUploadBrowseUI jXR;

                {
                    this.jXR = r1;
                }

                public final void ra(int i) {
                    this.jXR.jXQ.put(Integer.valueOf(i), Boolean.valueOf(true));
                }
            };
            addView(this.jMb);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ SnsUploadBrowseUI jXR;

                {
                    this.jXR = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.jXR.aYa();
                    return true;
                }
            });
            a(0, 2131231020, 2130838680, new OnMenuItemClickListener(this) {
                final /* synthetic */ SnsUploadBrowseUI jXR;

                {
                    this.jXR = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    g.a(this.jXR, 2131235417, 2131231164, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 jXS;

                        {
                            this.jXS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (this.jXS.jXR.jMb.aWW() == 0) {
                                this.jXS.jXR.aYa();
                            }
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 jXS;

                        {
                            this.jXS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return true;
                }
            });
        }
    }

    public final void aY(String str, int i) {
        if (this.jMb != null) {
            this.jMb.aWU();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.SnsUploadBrowseUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
        }
    }

    protected final int NO() {
        return 4;
    }

    public final void aZ(String str, int i) {
    }
}
