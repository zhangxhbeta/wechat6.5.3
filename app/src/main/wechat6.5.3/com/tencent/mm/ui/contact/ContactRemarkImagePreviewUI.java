package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.a.a.f;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.pluginsdk.model.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.io.File;

public class ContactRemarkImagePreviewUI extends MMActivity {
    private MMGestureGallery eIS;
    private View oFq;
    private String oFr;
    private boolean oFs;
    private boolean oFt;
    private a oFu;
    private String username;

    class a extends BaseAdapter {
        String imagePath;
        final /* synthetic */ ContactRemarkImagePreviewUI oFv;

        a(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
            this.oFv = contactRemarkImagePreviewUI;
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return this.imagePath;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = View.inflate(this.oFv, 2130903424, null);
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) inflate.findViewById(f.Jm);
            inflate.setLayoutParams(new LayoutParams(-1, -1));
            multiTouchImageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            Bitmap c = b.c(this.imagePath, com.tencent.mm.bd.a.getDensity(this.oFv));
            if (c != null) {
                int width = this.oFv.oFq.getWidth();
                int height = this.oFv.oFq.getHeight();
                Matrix matrix = new Matrix();
                matrix.reset();
                float width2 = ((float) c.getWidth()) / ((float) c.getHeight());
                float height2 = ((float) c.getHeight()) / ((float) c.getWidth());
                v.v("MicroMsg.ImagePreviewUI", "whDiv is " + width2 + " hwDiv is " + height2);
                if (height2 >= 2.0f && c.getHeight() >= 480) {
                    height2 = ((float) width) / ((float) c.getWidth());
                    if (((double) (((float) c.getWidth()) / ((float) width))) > 1.0d) {
                        matrix.postScale(height2, height2);
                        c.getHeight();
                        matrix.postTranslate((((float) width) - (height2 * ((float) c.getWidth()))) / 2.0f, 0.0f);
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        matrix.postTranslate((float) ((width - c.getWidth()) / 2), 0.0f);
                    }
                } else if (width2 < 2.0f || c.getWidth() < 480) {
                    width2 = ((float) width) / ((float) c.getWidth());
                    height2 = ((float) height) / ((float) c.getHeight());
                    if (width2 >= height2) {
                        width2 = height2;
                    }
                    height2 = ((float) c.getWidth()) / ((float) width);
                    float height3 = ((float) c.getHeight()) / ((float) height);
                    if (height2 <= height3) {
                        height2 = height3;
                    }
                    if (((double) height2) > 1.0d) {
                        matrix.postScale(width2, width2);
                    } else {
                        width2 = 1.0f;
                    }
                    matrix.postTranslate((((float) width) - (((float) c.getWidth()) * width2)) / 2.0f, (((float) height) - (width2 * ((float) c.getHeight()))) / 2.0f);
                } else {
                    width2 = ((float) c.getHeight()) / 480.0f;
                    height2 = 480.0f / ((float) c.getHeight());
                    if (((double) width2) > 1.0d) {
                        matrix.postScale(width2, height2);
                        matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        width2 = (float) ((height - c.getHeight()) / 2);
                        v.d("MicroMsg.ImagePreviewUI", " offsety " + width2);
                        matrix.postTranslate(0.0f, width2);
                    }
                }
                multiTouchImageView.setImageMatrix(matrix);
                multiTouchImageView.di(c.getWidth(), c.getHeight());
                multiTouchImageView.setImageBitmap(c);
            }
            return inflate;
        }
    }

    static /* synthetic */ void d(ContactRemarkImagePreviewUI contactRemarkImagePreviewUI) {
        bp bpVar = new bp();
        d.a(bpVar, 6, contactRemarkImagePreviewUI.oFr);
        bpVar.aZd.aXH = contactRemarkImagePreviewUI;
        bpVar.aZd.aZl = 46;
        com.tencent.mm.sdk.c.a.nhr.z(bpVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.username = getIntent().getStringExtra("Contact_User");
        this.oFr = getIntent().getStringExtra("remark_image_path");
        this.oFs = getIntent().getBooleanExtra("view_temp_remark_image", false);
        this.oFt = getIntent().getBooleanExtra("view_only", false);
        if (be.kS(this.username)) {
            finish();
        } else {
            NI();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903423;
    }

    protected final void NI() {
        this.oFq = findViewById(2131756512);
        this.eIS = (MMGestureGallery) findViewById(2131755843);
        vD(2131233881);
        this.eIS.setVerticalFadingEdgeEnabled(false);
        this.eIS.setHorizontalFadingEdgeEnabled(false);
        k.bw(this.eIS);
        this.oFu = new a(this);
        this.oFu.imagePath = this.oFr;
        this.eIS.setAdapter(this.oFu);
        this.eIS.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ContactRemarkImagePreviewUI oFv;

            {
                this.oFv = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.oFv.bAa()) {
                    this.oFv.nDR.bAj();
                } else {
                    this.oFv.bzZ();
                }
            }
        });
        a(0, 2131165201, new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactRemarkImagePreviewUI oFv;

            {
                this.oFv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.f fVar = new com.tencent.mm.ui.widget.f(this.oFv, com.tencent.mm.ui.widget.f.pbS, false);
                fVar.jXn = new c(this) {
                    final /* synthetic */ AnonymousClass1 oFw;

                    {
                        this.oFw = r1;
                    }

                    public final void a(l lVar) {
                        if (!this.oFw.oFv.oFt) {
                            lVar.d(0, this.oFw.oFv.getString(2131231020));
                        }
                        lVar.d(1, this.oFw.oFv.getString(2131234727));
                        if (com.tencent.mm.ay.c.EH("favorite")) {
                            lVar.d(2, this.oFw.oFv.getString(2131234180));
                        }
                    }
                };
                fVar.jXo = new n.d(this) {
                    final /* synthetic */ AnonymousClass1 oFw;

                    {
                        this.oFw = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (this.oFw.oFv.oFs) {
                                    new File(this.oFw.oFv.oFr).delete();
                                    this.oFw.oFv.jU(true);
                                    return;
                                }
                                this.oFw.oFv.jU(true);
                                return;
                            case 1:
                                com.tencent.mm.pluginsdk.ui.tools.l.h(this.oFw.oFv.oFr, this.oFw.oFv);
                                return;
                            case 2:
                                ContactRemarkImagePreviewUI.d(this.oFw.oFv);
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
            final /* synthetic */ ContactRemarkImagePreviewUI oFv;

            {
                this.oFv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oFv.jU(false);
                return false;
            }
        });
    }

    private void jU(boolean z) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("response_delete", true);
            setResult(-1, intent);
        }
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        jU(false);
        return true;
    }
}
