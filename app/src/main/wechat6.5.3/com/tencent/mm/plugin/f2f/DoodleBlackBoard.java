package com.tencent.mm.plugin.f2f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.pluginsdk.j.m;
import com.tencent.mm.sdk.platformtools.ad;

public class DoodleBlackBoard extends TextureView implements SurfaceTextureListener {
    private boolean aHp = false;
    int fET;
    int fEU;
    private Bitmap fIN;
    private Paint fIO;
    private Path fIP = new Path();
    private ad fIQ = null;
    Rect fIR = new Rect();
    private RectF fIS = new RectF();
    private Canvas fIT = null;
    private m fIU = null;

    public void setLayoutParams(android.view.ViewGroup.LayoutParams r8) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1439)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1461)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r6 = 480; // 0x1e0 float:6.73E-43 double:2.37E-321;
        r5 = 384; // 0x180 float:5.38E-43 double:1.897E-321;
        r4 = 0;
        r3 = 0;
        super.setLayoutParams(r8);
        r0 = r8.height;
        r7.fEU = r0;
        r0 = r8.width;
        r7.fET = r0;
        r0 = new android.graphics.RectF;
        r1 = r7.fET;
        r1 = (float) r1;
        r2 = r7.fEU;
        r2 = (float) r2;
        r0.<init>(r4, r4, r1, r2);
        r7.fIS = r0;
        r0 = "MicroMsg.DoodleBlackBoard";
        r1 = new java.lang.StringBuilder;
        r2 = "view size ";
        r1.<init>(r2);
        r2 = r7.fEU;
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = r7.fET;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r1);
        r0 = r7.fEU;
        if (r0 <= 0) goto L_0x005e;
    L_0x0047:
        r0 = r7.fET;
        if (r0 <= 0) goto L_0x005e;
    L_0x004b:
        r0 = r7.fIN;
        if (r0 != 0) goto L_0x005e;
    L_0x004f:
        r0 = android.graphics.Bitmap.Config.ARGB_8888;
        r0 = android.graphics.Bitmap.createBitmap(r6, r5, r0);
        r7.fIN = r0;
        r0 = new android.graphics.Rect;
        r0.<init>(r3, r3, r6, r5);
        r7.fIR = r0;
    L_0x005e:
        r1 = r7.lockCanvas();
        r0 = 0;
        r2 = android.graphics.PorterDuff.Mode.CLEAR;	 Catch:{ Exception -> 0x007c, all -> 0x0083 }
        r1.drawColor(r0, r2);	 Catch:{ Exception -> 0x007c, all -> 0x0083 }
        r0 = r7.fIN;	 Catch:{ Exception -> 0x007c, all -> 0x0083 }
        if (r0 == 0) goto L_0x0076;	 Catch:{ Exception -> 0x007c, all -> 0x0083 }
    L_0x006c:
        r0 = r7.fIN;	 Catch:{ Exception -> 0x007c, all -> 0x0083 }
        r2 = r7.fIR;	 Catch:{ Exception -> 0x007c, all -> 0x0083 }
        r3 = r7.fIS;	 Catch:{ Exception -> 0x007c, all -> 0x0083 }
        r4 = 0;	 Catch:{ Exception -> 0x007c, all -> 0x0083 }
        r1.drawBitmap(r0, r2, r3, r4);	 Catch:{ Exception -> 0x007c, all -> 0x0083 }
    L_0x0076:
        if (r1 == 0) goto L_0x007b;
    L_0x0078:
        r7.unlockCanvasAndPost(r1);
    L_0x007b:
        return;
    L_0x007c:
        r0 = move-exception;
        if (r1 == 0) goto L_0x007b;
    L_0x007f:
        r7.unlockCanvasAndPost(r1);
        goto L_0x007b;
    L_0x0083:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0089;
    L_0x0086:
        r7.unlockCanvasAndPost(r1);
    L_0x0089:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.f2f.DoodleBlackBoard.setLayoutParams(android.view.ViewGroup$LayoutParams):void");
    }

    public DoodleBlackBoard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DoodleBlackBoard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.fIU = new m("doodlef2f");
        setOpaque(false);
        setSurfaceTextureListener(this);
        this.fIO = new Paint();
        this.fIO.setColor(-1);
        this.fIO.setStyle(Style.STROKE);
        this.fIO.setStrokeWidth(5.0f);
        this.fIO.setAntiAlias(true);
        this.fIO.setShadowLayer(10.0f, 0.0f, 0.0f, getResources().getColor(2131689704));
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
