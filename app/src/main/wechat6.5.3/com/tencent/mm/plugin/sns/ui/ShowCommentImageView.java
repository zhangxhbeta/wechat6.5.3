package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;

public class ShowCommentImageView extends ImageView {
    private static Bitmap jJS;
    private static Bitmap jJT;
    private static Field jJU;
    private static Field jJV;
    private static boolean jJW = false;
    private boolean jJR = false;

    public ShowCommentImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ShowCommentImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private static void init() {
        if (jJU == null || jJV == null) {
            try {
                jJU = View.class.getDeclaredField("mDrawingCache");
                jJV = View.class.getDeclaredField("mUnscaledDrawingCache");
                jJU.setAccessible(true);
                jJV.setAccessible(true);
                jJW = true;
            } catch (Exception e) {
                v.e("MicroMsg.ShowCommentImageView", "init error: %s", new Object[]{e.getMessage()});
                jJW = false;
            }
        }
    }

    public void buildDrawingCache(boolean z) {
        if (jJW) {
            if (this.jJR) {
                s(z, true);
            } else if (gr(z)) {
                super.buildDrawingCache(z);
                return;
            } else {
                Bitmap bitmap = z ? jJT : jJS;
                if (bitmap == null || bitmap.isRecycled()) {
                    Field field;
                    super.buildDrawingCache(z);
                    if (z) {
                        try {
                            field = jJU;
                        } catch (Exception e) {
                            v.e("MicroMsg.ShowCommentImageView", "getStaticDrawingCache error: %s", new Object[]{e.getMessage()});
                            return;
                        }
                    }
                    field = jJV;
                    bitmap = (Bitmap) field.get(this);
                    String str = "MicroMsg.ShowCommentImageView";
                    String str2 = "getStaticDrawingCache, autoScale: %s, cache==null: %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Boolean.valueOf(bitmap == null);
                    v.d(str, str2, objArr);
                    if (bitmap == null) {
                        return;
                    }
                    if (z) {
                        jJT = bitmap;
                        return;
                    } else {
                        jJS = bitmap;
                        return;
                    }
                }
                s(z, false);
                return;
            }
        }
        super.buildDrawingCache(z);
    }

    private boolean gr(boolean z) {
        if (!jJW) {
            return false;
        }
        Field field;
        if (z) {
            try {
                field = jJU;
            } catch (Throwable e) {
                v.a("MicroMsg.ShowCommentImageView", e, "", new Object[0]);
                v.e("MicroMsg.ShowCommentImageView", "checkIfCanReuseDrawingCache error: %s", new Object[]{e.getMessage()});
                return false;
            }
        }
        field = jJV;
        return ((Bitmap) field.get(this)) != null;
    }

    private void s(boolean z, boolean z2) {
        if (z) {
            try {
                Field field = jJU;
            } catch (Exception e) {
                v.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        field = jJV;
        if (z2) {
            field.set(this, null);
            return;
        }
        boolean z3;
        if (z) {
            Object obj = jJT;
        } else {
            Bitmap bitmap = jJS;
        }
        String str = "MicroMsg.ShowCommentImageView";
        String str2 = "setDrawingCache, autoScale: %s, cache==null: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        if (obj == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        objArr[1] = Boolean.valueOf(z3);
        v.d(str, str2, objArr);
        if (obj != null) {
            field.set(this, obj);
        }
    }

    protected void onDetachedFromWindow() {
        try {
            jJU.set(this, null);
            jJV.set(this, null);
        } catch (Exception e) {
            v.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[]{e.getMessage()});
        }
        super.onDetachedFromWindow();
    }

    public void destroyDrawingCache() {
        super.destroyDrawingCache();
    }

    public void setOnClickListener(final OnClickListener onClickListener) {
        super.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShowCommentImageView jJY;

            public final void onClick(View view) {
                this.jJY.jJR = true;
                onClickListener.onClick(view);
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            postDelayed(new Runnable(this) {
                final /* synthetic */ ShowCommentImageView jJY;

                {
                    this.jJY = r1;
                }

                public final void run() {
                    this.jJY.jJR = false;
                }
            }, 100);
        } else {
            this.jJR = true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
