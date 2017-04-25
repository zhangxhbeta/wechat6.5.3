package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.pe;
import com.tencent.mm.model.ai;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.a.a;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.b;
import com.tencent.mm.u.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.f;

public class PreviewHdHeadImg extends MMActivity {
    private GetHdHeadImageGalleryView hhc;
    private final int iJS = 1;
    private final int iJT = 2;
    private e iJU;
    private String iJV;
    private String username;

    static /* synthetic */ void b(PreviewHdHeadImg previewHdHeadImg) {
        String str = com.tencent.mm.compatible.util.e.cgg + "hdImg_" + g.m(previewHdHeadImg.username.getBytes()) + System.currentTimeMillis() + ".jpg";
        FileOp.deleteFile(str);
        FileOp.p(previewHdHeadImg.iJV, str);
        d.c(str, previewHdHeadImg.nDR.nEl);
        Toast.makeText(previewHdHeadImg.nDR.nEl, previewHdHeadImg.nDR.nEl.getString(2131233186, new Object[]{com.tencent.mm.compatible.util.e.cgg}), 1).show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final int getLayoutId() {
        return 2130903772;
    }

    protected final void NI() {
        vD(2131234981);
        this.username = k.xF();
        this.hhc = (GetHdHeadImageGalleryView) findViewById(2131755843);
        this.hhc.username = this.username;
        aMQ();
        a(0, 2130838681, new OnMenuItemClickListener(this) {
            final /* synthetic */ PreviewHdHeadImg iJW;

            {
                this.iJW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                f fVar = new f(this.iJW, f.pbS, false);
                fVar.jXn = new c(this) {
                    final /* synthetic */ AnonymousClass1 iJX;

                    {
                        this.iJX = r1;
                    }

                    public final void a(l lVar) {
                        lVar.dg(1, 2131234982);
                        if (b.a(this.iJX.iJW.username, true, -1) != null) {
                            lVar.dg(2, 2131233185);
                        }
                    }
                };
                fVar.jXo = new n.d(this) {
                    final /* synthetic */ AnonymousClass1 iJX;

                    {
                        this.iJX = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                a.drq.c(this.iJX.iJW);
                                return;
                            case 2:
                                PreviewHdHeadImg.b(this.iJX.iJW);
                                return;
                            default:
                                return;
                        }
                    }
                };
                fVar.bKh();
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ PreviewHdHeadImg iJW;

            {
                this.iJW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iJW.finish();
                return true;
            }
        });
    }

    private void aMQ() {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            Bitmap a = b.a(this.username, true, -1);
            if (a == null) {
                a = BitmapFactory.decodeResource(getResources(), 2130838080);
            }
            if (a == null || a.isRecycled()) {
                v.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", new Object[]{this.username});
            } else {
                v.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", new Object[]{this.username});
                this.hhc.setThumbImage(a);
            }
            com.tencent.mm.u.n.AX();
            Bitmap gJ = com.tencent.mm.u.d.gJ(this.username);
            if (gJ == null || gJ.isRecycled()) {
                this.iJU = new e();
                this.iJU.a(this.username, new e.b(this) {
                    final /* synthetic */ PreviewHdHeadImg iJW;

                    public final int aG(int i, int i2) {
                        this.iJW.iJU.Bb();
                        v.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.u.n.AX();
                            Bitmap gJ = com.tencent.mm.u.d.gJ(this.iJW.username);
                            if (gJ != null) {
                                PreviewHdHeadImg previewHdHeadImg = this.iJW;
                                com.tencent.mm.u.n.AX();
                                previewHdHeadImg.b(gJ, com.tencent.mm.u.d.s(this.iJW.username, true));
                            } else {
                                this.iJW.b(a, null);
                            }
                        } else {
                            this.iJW.b(a, null);
                        }
                        return 0;
                    }
                });
                return;
            }
            v.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", new Object[]{this.username});
            com.tencent.mm.u.n.AX();
            b(gJ, com.tencent.mm.u.d.s(this.username, true));
            return;
        }
        s.ey(this.nDR.nEl);
        b(com.tencent.mm.u.n.AX().aM(this.nDR.nEl), null);
    }

    private void b(Bitmap bitmap, String str) {
        try {
            Bitmap createBitmap;
            if (bitmap.getWidth() < 480) {
                float width = (float) (480 / bitmap.getWidth());
                Matrix matrix = new Matrix();
                matrix.postScale(width, width);
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } else {
                createBitmap = bitmap;
            }
            v.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight())});
            this.hhc.B(createBitmap);
            this.hhc.iJV = str;
            this.iJV = str;
        } catch (Throwable e) {
            v.a("MicroMsg.PreviewHdHeadImg", e, "", new Object[0]);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_Filter", true);
                        com.tencent.mm.u.n.AX();
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.u.d.s(k.xF() + ".crop", true));
                        intent2.putExtra("CropImage_ImgPath", null);
                        h hVar = com.tencent.mm.plugin.setting.a.drp;
                        ak.yW();
                        hVar.a(this, intent, intent2, com.tencent.mm.model.c.wP(), 4, null);
                        return;
                    }
                    return;
                case 4:
                    new ac(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ PreviewHdHeadImg iJW;

                        {
                            this.iJW = r1;
                        }

                        public final void run() {
                            pe peVar = new pe();
                            peVar.bqy.bqA = true;
                            com.tencent.mm.sdk.c.a.nhr.z(peVar);
                        }
                    });
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                        if (stringExtra == null) {
                            v.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
                            return;
                        } else {
                            new com.tencent.mm.pluginsdk.model.n(this.nDR.nEl, stringExtra).a(1, new Runnable(this) {
                                final /* synthetic */ PreviewHdHeadImg iJW;

                                {
                                    this.iJW = r1;
                                }

                                public final void run() {
                                    v.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", new Object[]{Boolean.valueOf(ak.uz()), k.xF()});
                                    if (ak.uz()) {
                                        ai.cse.fG(b.r(k.xF(), false));
                                    }
                                    this.iJW.aMQ();
                                }
                            });
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 2 || i == 4) {
            new ac(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ PreviewHdHeadImg iJW;

                {
                    this.iJW = r1;
                }

                public final void run() {
                    pe peVar = new pe();
                    peVar.bqy.bqA = true;
                    com.tencent.mm.sdk.c.a.nhr.z(peVar);
                }
            });
        }
    }
}
