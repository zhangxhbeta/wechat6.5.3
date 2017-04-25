package com.tencent.mm.plugin.mmsight.ui.cameraglview;

import android.graphics.Point;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class b implements Renderer {
    static float[] hxH = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    static float[] hxI = new float[]{-1.0f, -0.5f, 1.0f, -0.5f, -1.0f, 0.5f, 1.0f, 0.5f};
    private static final float[] hxJ = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private int cdi = 0;
    boolean fJu = false;
    private int hpW = 0;
    private int hpX = 0;
    private boolean hpg = false;
    private int hxK = 0;
    private int hxL = 0;
    private byte[] hxM = null;
    ByteBuffer hxN;
    ByteBuffer hxO;
    private int hxP;
    private int hxQ;
    private int hxR;
    private int hxS;
    private int hxT;
    private int hxU;
    private int hxV;
    private int hxW;
    private FloatBuffer hxX;
    private FloatBuffer hxY;
    private float[] hxZ = new float[16];
    public boolean hya = false;
    private float[] hyb = hxH;

    public b() {
        Point azJ = com.tencent.mm.plugin.mmsight.b.azJ();
        float f = (((float) azJ.x) / ((float) azJ.y)) / 2.0f;
        hxI = new float[]{-1.0f, -f, 1.0f, -f, -1.0f, f, 1.0f, f};
    }

    public final void a(byte[] bArr, int i, int i2, int i3, boolean z) {
        try {
            int i4;
            if (this.hpX == i2 && this.hpW == i && this.cdi == i3 && this.hpg == z) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if (i4 != 0) {
                v.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(true), this});
            }
            this.hxM = bArr;
            this.hpW = i;
            this.hpX = i2;
            this.cdi = i3;
            this.hpg = z;
            if (i4 != 0) {
                this.hxN = ByteBuffer.allocateDirect(i2 * i);
                this.hxO = ByteBuffer.allocateDirect((i * i2) / 2);
                this.hxN.order(ByteOrder.nativeOrder());
                this.hxO.order(ByteOrder.nativeOrder());
                if (z) {
                    this.hyb = hxI;
                } else {
                    this.hyb = hxH;
                }
                if (this.hyb != null) {
                    this.hxX.put(this.hyb);
                    this.hxX.position(0);
                }
            }
            if (this.hxN != null && this.hxO != null) {
                this.hxN.put(bArr, 0, i * i2);
                this.hxN.position(0);
                this.hxO.put(bArr, i * i2, (i * i2) / 2);
                this.hxO.position(0);
            }
        } catch (Exception e) {
            v.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int i;
        v.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated this %s", new Object[]{this});
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glDisable(2929);
        String str = "#ifdef GL_ES                                       \nprecision highp float;                             \n#endif                                             \nvarying vec2 v_texCoord;                           \nuniform sampler2D y_texture;                       \nuniform sampler2D uv_texture;                      \nvoid main (void) {                                 \n   float r, g, b, y, u, v;                         \n   y = texture2D(y_texture, v_texCoord).r;         \n   u = texture2D(uv_texture, v_texCoord).a;        \n   v = texture2D(uv_texture, v_texCoord).r;        \n   u = u - 0.5;                                    \n   v = v - 0.5;                                    \n   r = y + 1.370705 * v;                           \n   g = y - 0.337633 * u - 0.698001 * v;            \n   b = y + 1.732446 * u;                           \n   gl_FragColor = vec4(r, g, b, 1.0);              \n}                                                  \n";
        int[] iArr = new int[1];
        int aF = c.aF("attribute vec4 a_position;                         \nattribute vec2 a_texCoord;                         \nvarying vec2 v_texCoord;                           \nuniform mat4 uMatrix;                              \nvoid main() {                                      \n   gl_Position = uMatrix * a_position;             \n   v_texCoord = a_texCoord;                        \n}                                                  \n", 35633);
        if (aF == 0) {
            v.e("MicroMsg.MMSightCameraGLUtil", "load vertex shader failed");
            i = 0;
        } else {
            int aF2 = c.aF(str, 35632);
            if (aF2 == 0) {
                v.e("MicroMsg.MMSightCameraGLUtil", "load fragment shader failed");
                i = 0;
            } else {
                i = GLES20.glCreateProgram();
                GLES20.glAttachShader(i, aF);
                GLES20.glAttachShader(i, aF2);
                GLES20.glLinkProgram(i);
                GLES20.glGetProgramiv(i, 35714, iArr, 0);
                if (iArr[0] <= 0) {
                    v.e("MicroMsg.MMSightCameraGLUtil", "link program failed");
                    i = 0;
                } else {
                    GLES20.glDeleteShader(aF);
                    GLES20.glDeleteShader(aF2);
                }
            }
        }
        this.hxR = i;
        if (this.hxR == 0) {
            v.e("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, load program failed!");
        }
        this.hxT = GLES20.glGetAttribLocation(this.hxR, "a_position");
        this.hxS = GLES20.glGetAttribLocation(this.hxR, "a_texCoord");
        this.hxU = GLES20.glGetUniformLocation(this.hxR, "y_texture");
        this.hxV = GLES20.glGetUniformLocation(this.hxR, "uv_texture");
        this.hxW = GLES20.glGetUniformLocation(this.hxR, "uMatrix");
        this.hxP = c.aBL();
        this.hxQ = c.aBL();
        this.hxX = ByteBuffer.allocateDirect(this.hyb.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.hxX.put(this.hyb);
        this.hxX.position(0);
        this.hxY = ByteBuffer.allocateDirect(hxJ.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.hxY.put(hxJ);
        this.hxY.position(0);
        v.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceCreated, yTextureId: %s, uvTextureId: %s this %s", new Object[]{Integer.valueOf(this.hxP), Integer.valueOf(this.hxQ), this});
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        v.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged, surfaceWidth: %s, height: %s this %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), this});
        if (i != this.hxK || i2 != this.hxL) {
            v.i("MicroMsg.MMSightCameraGLRenderer", "onSurfaceChanged change viewpoint");
            GLES20.glViewport(0, 0, i, i2);
            this.hxK = i;
            this.hxL = i2;
        }
    }

    public final void onDrawFrame(GL10 gl10) {
        be.Nj();
        this.fJu = true;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
        if (this.hya) {
            v.i("MicroMsg.MMSightCameraGLRenderer", "clearFrameRequest");
            this.hya = false;
            this.fJu = false;
            return;
        }
        if (!(this.hxR == 0 || this.hxP == -1 || this.hxQ == -1 || this.hpW <= 0 || this.hpX <= 0 || this.hxM == null)) {
            GLES20.glUseProgram(this.hxR);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.hxP);
            GLES20.glTexImage2D(3553, 0, 6409, this.hpW, this.hpX, 0, 6409, 5121, this.hxN);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.hxU, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.hxQ);
            GLES20.glTexImage2D(3553, 0, 6410, this.hpW / 2, this.hpX / 2, 0, 6410, 5121, this.hxO);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glUniform1i(this.hxV, 1);
            Matrix.setIdentityM(this.hxZ, 0);
            Matrix.setRotateM(this.hxZ, 0, (float) this.cdi, 0.0f, 0.0f, -1.0f);
            GLES20.glUniformMatrix4fv(this.hxW, 1, false, this.hxZ, 0);
            this.hxX.position(0);
            GLES20.glVertexAttribPointer(this.hxT, 2, 5126, false, 0, this.hxX);
            GLES20.glEnableVertexAttribArray(this.hxT);
            this.hxY.position(0);
            GLES20.glVertexAttribPointer(this.hxS, 2, 5126, false, 0, this.hxY);
            GLES20.glEnableVertexAttribArray(this.hxS);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.hxT);
            GLES20.glDisableVertexAttribArray(this.hxS);
            GLES20.glBindTexture(3553, 0);
        }
        this.fJu = false;
    }
}
