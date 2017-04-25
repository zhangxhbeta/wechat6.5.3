package com.tencent.mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMTextureView;

public class ObservableTextureView extends MMTextureView implements SurfaceTextureListener {
    protected SurfaceTexture hCc;
    protected b kog;
    private boolean koh = false;

    public ObservableTextureView(Context context) {
        super(context);
        init();
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init() {
        setSurfaceTextureListener(this);
        this.hCc = getSurfaceTexture();
    }

    public boolean isAvailable() {
        return this.koh;
    }

    public final void a(b bVar) {
        this.kog = bVar;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        v.i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
        bCE();
        this.koh = true;
        if (this.kog != null) {
            this.kog.a(surfaceTexture);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        v.d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        v.i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
        this.koh = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
