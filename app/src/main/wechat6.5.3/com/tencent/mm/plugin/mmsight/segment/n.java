package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

@TargetApi(18)
public final class n extends a {
    private int hoh;
    private a hso;
    private a hsp;

    public final void a(String str, String str2, VideoTransPara videoTransPara) {
        super.a(str, str2, videoTransPara);
    }

    public final int k(long j, long j2) {
        int aAO = h.aAO();
        g.iuh.a(440, 165, 1, false);
        if (aAO == 1) {
            g.iuh.a(440, 166, 1, false);
        } else if (aAO == 2) {
            g.iuh.a(440, 167, 1, false);
        } else if (aAO == 3) {
            g.iuh.a(440, 168, 1, false);
        }
        aAO = super.k(j, j2);
        if (aAO == -1) {
            int aAO2 = h.aAO();
            g.iuh.a(440, 169, 1, false);
            if (aAO2 == 1) {
                g.iuh.a(440, 170, 1, false);
            } else if (aAO2 == 2) {
                g.iuh.a(440, 171, 1, false);
            } else if (aAO2 == 3) {
                g.iuh.a(440, 172, 1, false);
            }
        }
        return aAO;
    }

    protected final int a(MediaExtractor mediaExtractor, List<a> list, List<a> list2) {
        this.hso = (a) list2.get(0);
        if (!(list == null || list.size() == 0)) {
            this.hsp = (a) list.get(0);
        }
        if (a(mediaExtractor, this.hqs <= 0 ? 1048576 : this.hqs, this.hoh, this.hqm) != -1) {
            return 0;
        }
        v.e("VideoClipperAPI18", "transcodeAndMux error");
        release();
        return -1;
    }

    private int a(MediaExtractor mediaExtractor, int i, int i2, String str) {
        Throwable e;
        v.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(88) ");
        h hVar = null;
        try {
            h hVar2 = new h();
            try {
                int i3;
                hVar2.hlp = this.hqq;
                hVar2.hlq = this.hqr;
                VideoTransPara videoTransPara = this.hqu;
                v.i("MicroMsg.MediaCodecFFMpegTranscoder", "setVideoPara: %s", new Object[]{videoTransPara});
                hVar2.hlv = videoTransPara;
                if (this.hqv == 90 || this.hqv == 270) {
                    hVar2.bR(videoTransPara.height, videoTransPara.width);
                } else {
                    hVar2.bR(videoTransPara.width, videoTransPara.height);
                }
                hVar2.hqy = str;
                v.i("MicroMsg.MediaCodecFFMpegTranscoder", "setSrcVideoRotate: %s", new Object[]{Integer.valueOf(this.hqv)});
                hVar2.cdi = i3;
                v.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(101) ");
                try {
                    v.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(118) ");
                    mediaExtractor.selectTrack(this.hso.index);
                    mediaExtractor.seekTo(this.hqq * 1000, 0);
                    try {
                        VideoTransPara videoTransPara2 = this.hqu;
                        this.hoh = MP4MuxerJNI.initDataBuf(videoTransPara2.duration > 0 ? videoTransPara2.duration : 10);
                        long Nj = be.Nj();
                        int i4 = this.hso.index;
                        hVar2.hqN = mediaExtractor;
                        hVar2.hqO = i4;
                        if (hVar2.e(this.hso.hpY) < 0) {
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.hoh);
                                mediaExtractor.release();
                                h.hoF.wc();
                            } catch (Exception e2) {
                            }
                            throw new k("init decoder error");
                        }
                        e.a(new Runnable(hVar2) {
                            final /* synthetic */ h hqR;

                            {
                                this.hqR = r1;
                            }

                            public final void run() {
                                if (!be.kS(this.hqR.hqy)) {
                                    v.i("MicroMsg.MediaCodecFFMpegTranscoder", "src file: %s", new Object[]{SightVideoJNI.getSimpleMp4Info(this.hqR.hqy)});
                                }
                            }
                        }, "MediaCodecFFMpegTranscoder_dumpSrcVideoInfo");
                        hVar2.hqP.t(new Runnable(hVar2) {
                            final /* synthetic */ h hqR;

                            {
                                this.hqR = r1;
                            }

                            public final void run() {
                                h hVar = this.hqR;
                                v.i("MicroMsg.MediaCodecFFMpegTranscoder", "waitEncoderFinish: %s %s", new Object[]{hVar.hqK, hVar.hqL});
                                if (hVar.hqK != null && hVar.hqL != null) {
                                    hVar.hqK.hqS = true;
                                    try {
                                        hVar.hqL.join();
                                        e.remove(hVar.hqK);
                                    } catch (Throwable e) {
                                        v.a("MicroMsg.MediaCodecFFMpegTranscoder", e, "waitEncoderFinish, join error: %s", new Object[]{e.getMessage()});
                                    }
                                }
                            }
                        });
                        long az = be.az(Nj);
                        mediaExtractor.unselectTrack(this.hso.index);
                        boolean z = false;
                        if (this.hsp != null) {
                            long Nj2 = be.Nj();
                            z = a(mediaExtractor, i, i2);
                            v.i("VideoClipperAPI18", "process audio used %sms, compressAudio: %s", new Object[]{Long.valueOf(be.az(Nj2)), Boolean.valueOf(z)});
                        }
                        long Nj3 = be.Nj();
                        String aAF = aAF();
                        v.i("VideoClipperAPI18", "process video used %sms", new Object[]{Long.valueOf(az)});
                        v.i("VideoClipperAPI18", "start muxing, tempPath: %s", new Object[]{aAF});
                        int aAO = h.aAO();
                        if (aAO == 1) {
                            g.iuh.a(440, 150, 1, false);
                            g.iuh.a(440, 151, az, false);
                        } else if (aAO == 2) {
                            g.iuh.a(440, 155, 1, false);
                            g.iuh.a(440, 156, az, false);
                        } else if (aAO == 3) {
                            g.iuh.a(440, 159, 1, false);
                            g.iuh.a(440, 160, az, false);
                        }
                        i4 = 1;
                        aAO = videoTransPara2.audioSampleRate;
                        int i5 = videoTransPara2.cGk;
                        if (!z) {
                            try {
                                i4 = this.hsp.hpY.getInteger("channel-count");
                                aAO = this.hsp.hpY.getInteger("sample-rate");
                                i5 = i4;
                                int i6 = aAO;
                                aAO = this.hsp.hpY.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                                i3 = i6;
                            } catch (Exception e3) {
                                v.e("VideoClipperAPI18", "get audio channel count error: %s", new Object[]{e3.getMessage()});
                            }
                            v.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(aAO)});
                            if (MP4MuxerJNI.muxingForX264(i3, 1024, 2, i5, aAF, (float) videoTransPara2.cdg, (int) (this.hqr - this.hqq), null, 0) >= 0) {
                                v.e("VideoClipperAPI18", "muxingForX264 failed! %d", new Object[]{Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, 1024, 2, i5, aAF, (float) videoTransPara2.cdg, (int) (this.hqr - this.hqq), null, 0))});
                                throw new k("muxingForX264 failed!");
                            }
                            if (this.hqv <= 0) {
                                SightVideoJNI.tagRotateVideo(aAF(), this.hql, this.hqv);
                            } else {
                                FileOp.ab(aAF(), this.hql);
                            }
                            v.i("VideoClipperAPI18", "mux and tagRotate used %sms", new Object[]{Long.valueOf(be.az(Nj3))});
                            Nj = be.Nj();
                            SightVideoJNI.tagMP4Dscp(this.hql, CaptureMMProxy.getInstance().getWeixinMeta());
                            v.i("VideoClipperAPI18", "tagMP4Dscp used %sms", new Object[]{Long.valueOf(be.az(Nj))});
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.hoh);
                                mediaExtractor.release();
                                h.hoF.wc();
                            } catch (Exception e4) {
                            }
                            try {
                                hVar2.release();
                            } catch (Exception e5) {
                            }
                            return 0;
                        }
                        i3 = aAO;
                        aAO = i5;
                        i5 = i4;
                        v.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i3), Integer.valueOf(aAO)});
                        if (MP4MuxerJNI.muxingForX264(i3, 1024, 2, i5, aAF, (float) videoTransPara2.cdg, (int) (this.hqr - this.hqq), null, 0) >= 0) {
                            if (this.hqv <= 0) {
                                FileOp.ab(aAF(), this.hql);
                            } else {
                                SightVideoJNI.tagRotateVideo(aAF(), this.hql, this.hqv);
                            }
                            v.i("VideoClipperAPI18", "mux and tagRotate used %sms", new Object[]{Long.valueOf(be.az(Nj3))});
                            Nj = be.Nj();
                            SightVideoJNI.tagMP4Dscp(this.hql, CaptureMMProxy.getInstance().getWeixinMeta());
                            v.i("VideoClipperAPI18", "tagMP4Dscp used %sms", new Object[]{Long.valueOf(be.az(Nj))});
                            MP4MuxerJNI.releaseDataBuf(this.hoh);
                            mediaExtractor.release();
                            h.hoF.wc();
                            hVar2.release();
                            return 0;
                        }
                        v.e("VideoClipperAPI18", "muxingForX264 failed! %d", new Object[]{Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, 1024, 2, i5, aAF, (float) videoTransPara2.cdg, (int) (this.hqr - this.hqq), null, 0))});
                        throw new k("muxingForX264 failed!");
                    } catch (Throwable e6) {
                        v.w("VideoClipperAPI18", "The source video file is malformed %s", new Object[]{e6.getMessage()});
                        throw new RuntimeException(e6);
                    } catch (Throwable th) {
                        try {
                            MP4MuxerJNI.releaseDataBuf(this.hoh);
                            mediaExtractor.release();
                            h.hoF.wc();
                        } catch (Exception e7) {
                        }
                    }
                } catch (Throwable e62) {
                    try {
                        v.a("VideoClipperAPI18", e62, "Transcode and mux failed %s", new Object[]{e62.getMessage()});
                        return -1;
                    } finally {
                        try {
                            hVar2.release();
                        } catch (Exception e8) {
                        }
                    }
                }
            } catch (Exception e9) {
                e62 = e9;
                hVar = hVar2;
                v.a("VideoClipperAPI18", e62, "trascodeAndMux error", new Object[0]);
                if (hVar != null) {
                    hVar.release();
                }
                return -1;
            }
        } catch (Exception e10) {
            e62 = e10;
            v.a("VideoClipperAPI18", e62, "trascodeAndMux error", new Object[0]);
            if (hVar != null) {
                hVar.release();
            }
            return -1;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.media.MediaExtractor r13, int r14, int r15) {
        /*
        r12 = this;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r11 = 0;
        r10 = 1;
        r9 = 0;
        r0 = r12.hsp;
        if (r0 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r9;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = r12.hsp;
        r0 = r0.index;
        r13.selectTrack(r0);
        r0 = r12.hqq;
        r0 = r0 * r6;
        r13.seekTo(r0, r9);
        r1 = java.nio.ByteBuffer.allocateDirect(r14);
        r0 = r12.hsp;	 Catch:{ Exception -> 0x00ec }
        r0 = r0.hpY;	 Catch:{ Exception -> 0x00ec }
        r2 = "channel-count";
        r0.getInteger(r2);	 Catch:{ Exception -> 0x00ec }
    L_0x0026:
        r0 = "VideoClipperAPI18";
        r2 = "audio channel count";
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        r0 = com.tencent.mm.plugin.mmsight.model.CaptureMMProxy.getInstance();
        r2 = com.tencent.mm.storage.t.a.ntK;
        r3 = java.lang.Integer.valueOf(r9);
        r0 = r0.get(r2, r3);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 != r10) goto L_0x0140;
    L_0x0045:
        r1 = new com.tencent.mm.plugin.mmsight.c;
        r0 = r12.hsp;
        r3 = r0.hpY;
        r4 = r12.hqq;
        r6 = r12.hqr;
        r8 = r12.hqu;
        r2 = r13;
        r1.<init>(r2, r3, r4, r6, r8);
        r1.hlw = r10;
        r0 = r1.hlu;	 Catch:{ Exception -> 0x0100 }
        r0 = android.media.MediaCodec.createDecoderByType(r0);	 Catch:{ Exception -> 0x0100 }
        r1.hln = r0;	 Catch:{ Exception -> 0x0100 }
        r0 = r1.hln;	 Catch:{ Exception -> 0x0100 }
        r2 = r1.hlr;	 Catch:{ Exception -> 0x0100 }
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r0.configure(r2, r3, r4, r5);	 Catch:{ Exception -> 0x0100 }
        r0 = r1.hln;	 Catch:{ Exception -> 0x0100 }
        r0.start();	 Catch:{ Exception -> 0x0100 }
        r0 = r1.hln;	 Catch:{ Exception -> 0x0100 }
        r0 = r0.getOutputFormat();	 Catch:{ Exception -> 0x0100 }
        r1.hlr = r0;	 Catch:{ Exception -> 0x0100 }
    L_0x0076:
        r0 = new android.media.MediaFormat;	 Catch:{ Exception -> 0x0114 }
        r0.<init>();	 Catch:{ Exception -> 0x0114 }
        r1.hls = r0;	 Catch:{ Exception -> 0x0114 }
        r0 = r1.hls;	 Catch:{ Exception -> 0x0114 }
        r2 = "mime";
        r3 = "audio/mp4a-latm";
        r0.setString(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.hls;	 Catch:{ Exception -> 0x0114 }
        r2 = "aac-profile";
        r3 = 2;
        r0.setInteger(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.hls;	 Catch:{ Exception -> 0x0114 }
        r2 = "sample-rate";
        r3 = r1.hlv;	 Catch:{ Exception -> 0x0114 }
        r3 = r3.audioSampleRate;	 Catch:{ Exception -> 0x0114 }
        r0.setInteger(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.hls;	 Catch:{ Exception -> 0x0114 }
        r2 = "channel-count";
        r3 = 1;
        r0.setInteger(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.hls;	 Catch:{ Exception -> 0x0114 }
        r2 = "bitrate";
        r3 = r1.hlv;	 Catch:{ Exception -> 0x0114 }
        r3 = r3.cGk;	 Catch:{ Exception -> 0x0114 }
        r0.setInteger(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.hls;	 Catch:{ Exception -> 0x0114 }
        r2 = "max-input-size";
        r3 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r0.setInteger(r2, r3);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.hlu;	 Catch:{ Exception -> 0x0114 }
        r0 = android.media.MediaCodec.createEncoderByType(r0);	 Catch:{ Exception -> 0x0114 }
        r1.hlo = r0;	 Catch:{ Exception -> 0x0114 }
        r0 = r1.hlo;	 Catch:{ Exception -> 0x0114 }
        r2 = r1.hls;	 Catch:{ Exception -> 0x0114 }
        r3 = 0;
        r4 = 0;
        r5 = 1;
        r0.configure(r2, r3, r4, r5);	 Catch:{ Exception -> 0x0114 }
        r0 = r1.hln;	 Catch:{ Exception -> 0x0114 }
        r0.start();	 Catch:{ Exception -> 0x0114 }
    L_0x00d3:
        r0 = "MicroMsg.MediaCodecAACTranscoder";
        r2 = "init finish, canEncodeDecodeBothExist: %s";
        r3 = new java.lang.Object[r10];
        r4 = r1.hlw;
        r4 = java.lang.Boolean.valueOf(r4);
        r3[r9] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r0, r2, r3);
        r1.azL();
        r0 = r10;
        goto L_0x000a;
    L_0x00ec:
        r0 = move-exception;
        r0 = "VideoClipperAPI18";
        r2 = "get channel count error: %s";
        r3 = new java.lang.Object[r10];
        r4 = java.lang.Integer.valueOf(r10);
        r3[r9] = r4;
        com.tencent.mm.sdk.platformtools.v.e(r0, r2, r3);
        goto L_0x0026;
    L_0x0100:
        r0 = move-exception;
        r2 = "MicroMsg.MediaCodecAACTranscoder";
        r3 = "init decoder error: %s";
        r4 = new java.lang.Object[r10];
        r5 = r0.getMessage();
        r4[r9] = r5;
        com.tencent.mm.sdk.platformtools.v.a(r2, r0, r3, r4);
        goto L_0x0076;
    L_0x0114:
        r0 = move-exception;
        r2 = "MicroMsg.MediaCodecAACTranscoder";
        r3 = "init encoder error: %s";
        r4 = new java.lang.Object[r10];
        r0 = r0.getMessage();
        r4[r9] = r0;
        com.tencent.mm.sdk.platformtools.v.e(r2, r3, r4);
        r1.hlw = r9;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1.hlx = r0;
        r0 = r1.hlo;
        r0.release();
        r1.hlo = r11;
        goto L_0x00d3;
    L_0x0137:
        r1.position(r9);
        com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI.writeAACData(r15, r1, r0);
        r13.advance();
    L_0x0140:
        r1.clear();
        r0 = r13.readSampleData(r1, r9);
        r2 = "VideoClipperAPI18";
        r3 = "sampleSize: %d";
        r4 = new java.lang.Object[r10];
        r5 = java.lang.Integer.valueOf(r0);
        r4[r9] = r5;
        com.tencent.mm.sdk.platformtools.v.d(r2, r3, r4);
        if (r0 > 0) goto L_0x016e;
    L_0x015a:
        r1 = "VideoClipperAPI18";
        r2 = "VideoClipperAPI18.muxAudio size = %d. Saw eos.";
        r3 = new java.lang.Object[r10];
        r0 = java.lang.Integer.valueOf(r0);
        r3[r9] = r0;
        com.tencent.mm.sdk.platformtools.v.i(r1, r2, r3);
    L_0x016b:
        r0 = r9;
        goto L_0x000a;
    L_0x016e:
        r2 = r13.getSampleTime();
        r4 = r12.hqr;
        r4 = r4 * r6;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 >= 0) goto L_0x016b;
    L_0x0179:
        r2 = r13.getSampleTrackIndex();
        r3 = r12.hsp;
        r3 = r3.index;
        if (r2 == r3) goto L_0x0137;
    L_0x0183:
        r0 = "VideoClipperAPI18";
        r1 = "track index not match! break";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x016b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.n.a(android.media.MediaExtractor, int, int):boolean");
    }

    public final int wA(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable th;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                String extractMetadata;
                mediaMetadataRetriever.setDataSource(str);
                if (d.dW(17)) {
                    extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    extractMetadata = SightVideoJNI.getMp4Rotate(str);
                }
                v.d("VideoClipperAPI18", "findRotationMessage sDegree = " + extractMetadata);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
                v.d("VideoClipperAPI18", "findRotationMessage sHeight = " + extractMetadata2);
                v.d("VideoClipperAPI18", "findRotationMessage sWidth = " + extractMetadata3);
                int i = be.getInt(extractMetadata, 0);
                mediaMetadataRetriever.release();
                return i;
            } catch (Throwable th2) {
                th = th2;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }
}
