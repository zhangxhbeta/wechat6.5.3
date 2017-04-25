package com.tencent.mm.plugin.mmsight.segment.mp.inner;

import android.media.AudioTrack;
import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class a {
    private static final String TAG = a.class.getSimpleName();
    public static long htk = Long.MIN_VALUE;
    int aTB;
    private AudioTrack diO;
    MediaFormat hoj;
    private byte[] htl;
    int htm = 8192;
    int htn;
    b hto = new b();
    int htp;
    a htq;
    private long htr;
    int hts = 0;
    int htt = 3;
    private float htu = 1.0f;
    private float htv = 1.0f;
    long htw;
    long htx;

    private class a extends Thread {
        private boolean doh = true;
        final Object hty = new Object();
        final /* synthetic */ a htz;

        a(a aVar) {
            this.htz = aVar;
            super(a.TAG);
        }

        final void ep(boolean z) {
            this.doh = z;
            synchronized (this) {
                notify();
            }
        }

        public final void run() {
            while (!isInterrupted()) {
                try {
                    a aAY;
                    synchronized (this) {
                        while (this.doh) {
                            wait();
                        }
                    }
                    synchronized (this.hty) {
                        while (true) {
                            aAY = this.htz.hto.aAY();
                            if (aAY != null) {
                                break;
                            }
                            this.hty.wait();
                        }
                    }
                    a.a(this.htz, aAY.htD, aAY.presentationTimeUs);
                    this.htz.hto.a(aAY);
                } catch (InterruptedException e) {
                    interrupt();
                }
            }
        }
    }

    private static class b {
        private int aGp;
        private Queue<a> htA = new LinkedList();
        private List<a> htB = new ArrayList();
        int htC;

        private static class a {
            ByteBuffer htD;
            long presentationTimeUs;

            a(int i) {
                this.htD = ByteBuffer.allocate(i);
            }
        }

        b() {
        }

        final synchronized void a(ByteBuffer byteBuffer, long j) {
            a aVar;
            if (byteBuffer.remaining() > this.aGp) {
                this.htB.clear();
                this.aGp = byteBuffer.remaining();
            }
            if (this.htB.isEmpty()) {
                aVar = new a(byteBuffer.remaining());
            } else {
                aVar = (a) this.htB.remove(0);
            }
            aVar.htD.limit(byteBuffer.remaining());
            aVar.htD.mark();
            aVar.htD.put(byteBuffer);
            aVar.htD.reset();
            aVar.presentationTimeUs = j;
            this.htA.add(aVar);
            this.htC = aVar.htD.remaining() + this.htC;
        }

        final synchronized a aAY() {
            a aVar;
            aVar = (a) this.htA.poll();
            if (aVar != null) {
                this.htC -= aVar.htD.remaining();
            }
            return aVar;
        }

        final synchronized void a(a aVar) {
            if (aVar.htD.capacity() == this.aGp) {
                aVar.htD.rewind();
                this.htB.add(aVar);
            }
        }

        final synchronized void flush() {
            while (true) {
                a aVar = (a) this.htA.poll();
                if (aVar != null) {
                    a(aVar);
                } else {
                    this.htC = 0;
                }
            }
        }
    }

    static /* synthetic */ void a(a aVar, ByteBuffer byteBuffer, long j) {
        int remaining = byteBuffer.remaining();
        if (aVar.htl == null || aVar.htl.length < remaining) {
            aVar.htl = new byte[remaining];
        }
        byteBuffer.get(aVar.htl, 0, remaining);
        aVar.htr = j;
        aVar.diO.write(aVar.htl, 0, remaining);
    }

    public final void c(MediaFormat mediaFormat) {
        int i;
        if (isInitialized()) {
            boolean z = (this.hoj.getInteger("channel-count") == mediaFormat.getInteger("channel-count") && this.hoj.getInteger("sample-rate") == mediaFormat.getInteger("sample-rate") && this.hoj.getString("mime").equals(mediaFormat.getString("mime"))) ? false : true;
            if (z) {
                z = isPlaying();
                en(true);
                eo(false);
                boolean z2 = z;
            } else {
                this.hoj = mediaFormat;
                return;
            }
        }
        this.htq = new a(this);
        this.htq.ep(true);
        this.htq.start();
        z2 = false;
        this.hoj = mediaFormat;
        int integer = mediaFormat.getInteger("channel-count");
        this.htn = integer * 2;
        this.aTB = mediaFormat.getInteger("sample-rate");
        switch (integer) {
            case 1:
                i = 4;
                break;
            case 2:
                i = 12;
                break;
            case 4:
                i = 204;
                break;
            case 6:
                i = 252;
                break;
            case 8:
                i = 1020;
                break;
            default:
                i = 1;
                break;
        }
        this.htp = integer * this.htm;
        this.diO = new AudioTrack(this.htt, this.aTB, i, 2, this.htp, 1, this.hts);
        this.hts = this.diO.getAudioSessionId();
        this.htt = this.diO.getStreamType();
        u(this.htu, this.htv);
        this.htw = htk;
        if (z2) {
            play();
        }
    }

    public final boolean isInitialized() {
        return this.diO != null;
    }

    public final void play() {
        if (isInitialized()) {
            this.diO.play();
            this.htq.ep(false);
            return;
        }
        throw new IllegalStateException();
    }

    public final void en(boolean z) {
        if (isInitialized()) {
            this.htq.ep(true);
            if (this.diO.getState() == 1) {
                this.diO.pause();
            }
            if (z) {
                flush();
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final void flush() {
        if (isInitialized()) {
            boolean isPlaying = isPlaying();
            if (isPlaying) {
                this.diO.pause();
            }
            this.diO.flush();
            this.hto.flush();
            this.htw = htk;
            if (isPlaying) {
                this.diO.play();
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    final void eo(boolean z) {
        if (isInitialized()) {
            if (z) {
                this.htq.interrupt();
            }
            this.diO.stop();
            this.diO.release();
        }
        this.diO = null;
    }

    public final long aAW() {
        return (long) ((((double) (this.hto.htC / this.htn)) / ((double) this.aTB)) * 1000000.0d);
    }

    final long aAX() {
        return (long) ((((double) (4294967295L & ((long) this.diO.getPlaybackHeadPosition()))) / ((double) this.aTB)) * 1000000.0d);
    }

    public final void R(float f) {
        if (isInitialized()) {
            this.diO.setPlaybackRate((int) (((float) this.aTB) * f));
            return;
        }
        throw new IllegalStateException();
    }

    private boolean isPlaying() {
        this.diO.pause();
        return this.diO.getPlayState() == 3;
    }

    public final void u(float f, float f2) {
        this.htu = f;
        this.htv = f2;
        if (this.diO != null) {
            this.diO.setStereoVolume(f, f2);
        }
    }
}
