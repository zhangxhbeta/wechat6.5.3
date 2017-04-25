package com.tencent.mm.booter.notification.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import java.nio.charset.Charset;

public final class f {
    boolean bZS;
    MediaPlayer bZT;
    @SuppressLint({"HandlerLeak"})
    private ac bZU;
    private Context context;

    private static class a {
        private static final f bZX = new f();
    }

    private f() {
        String str = null;
        this.bZS = false;
        this.bZT = null;
        this.bZU = new ac(this, Looper.getMainLooper()) {
            final /* synthetic */ f bZV;

            public final void handleMessage(Message message) {
                v.i("MicroMsg.Notification.Tool.Sound", "play sound handler, try to stop notify mediaplayer");
                try {
                    if (this.bZV.bZS && this.bZV.bZT != null && this.bZV.bZT.isPlaying()) {
                        this.bZV.bZT.stop();
                        this.bZV.bZT.release();
                        this.bZV.bZS = false;
                    }
                } catch (IllegalStateException e) {
                    v.w("MicroMsg.Notification.Tool.Sound", "Exception in playSoundHander %s", e.getMessage());
                }
            }
        };
        this.context = aa.getContext();
        String str2 = t.cng + "deviceconfig.cfg";
        v.i("MicroMsg.ServerConfigInfoStorage", "readConfigFromLocalFile, path: %s, isExist: %s", str2, Boolean.valueOf(e.aR(str2)));
        if (e.aR(str2)) {
            byte[] d = e.d(str2, 0, -1);
            if (!be.bl(d)) {
                str2 = new String(d, Charset.defaultCharset());
                if (!be.kS(str2)) {
                    str = str2;
                }
            }
        }
        p.dr(str);
    }

    public final synchronized void di(String str) {
        if (this.context == null) {
            this.context = aa.getContext();
        }
        if (this.context == null) {
            v.w("MicroMsg.Notification.Tool.Sound", "playSound:context is null!!");
        } else {
            Uri defaultUri;
            if (be.kS(str)) {
                defaultUri = RingtoneManager.getDefaultUri(2);
            } else {
                defaultUri = Uri.parse(str);
            }
            try {
                this.bZU.removeMessages(305419896);
                this.bZU.sendEmptyMessageDelayed(305419896, 8000);
                if (this.bZS) {
                    try {
                        if (this.bZT != null && this.bZT.isPlaying()) {
                            this.bZT.stop();
                            this.bZT.release();
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.Notification.Tool.Sound", "try to release player before playSound error: %s", e.getMessage());
                    }
                    this.bZS = false;
                }
                this.bZT = new MediaPlayer();
                this.bZT.setDataSource(this.context, defaultUri);
                final AudioManager audioManager = (AudioManager) this.context.getSystemService("audio");
                if (audioManager.getStreamVolume(5) != 0) {
                    if (audioManager.isWiredHeadsetOn()) {
                        d.qW();
                        v.d("MicroMsg.Notification.Tool.Sound", "headset on, selected stream type: %s", Integer.valueOf(0));
                        int streamVolume = audioManager.getStreamVolume(5);
                        int streamMaxVolume = audioManager.getStreamMaxVolume(5);
                        audioManager.setSpeakerphoneOn(false);
                        v.i("MicroMsg.Notification.Tool.Sound", "notificationSetMode: %s", Integer.valueOf(p.ceJ.cek));
                        if (p.ceJ.cek == 1) {
                            v.i("MicroMsg.Notification.Tool.Sound", "notification set mode enable, set mode now");
                            if (audioManager.getMode() == 0) {
                                audioManager.setMode(3);
                            }
                            this.bZT.setOnCompletionListener(new OnCompletionListener(this) {
                                final /* synthetic */ f bZV;

                                public final void onCompletion(MediaPlayer mediaPlayer) {
                                    v.i("MicroMsg.Notification.Tool.Sound", "play sound finish, player: %s", this.bZV.bZT);
                                    audioManager.setMode(0);
                                    if (this.bZV.bZT != null) {
                                        this.bZV.bZT.release();
                                    }
                                }
                            });
                            this.bZT.setOnErrorListener(new OnErrorListener(this) {
                                final /* synthetic */ f bZV;

                                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                    v.i("MicroMsg.Notification.Tool.Sound", "play sound error, player: %s", this.bZV.bZT);
                                    audioManager.setMode(0);
                                    if (this.bZV.bZT != null) {
                                        this.bZV.bZT.release();
                                    }
                                    return false;
                                }
                            });
                        } else {
                            this.bZT.setOnCompletionListener(new OnCompletionListener(this) {
                                final /* synthetic */ f bZV;

                                {
                                    this.bZV = r1;
                                }

                                public final void onCompletion(MediaPlayer mediaPlayer) {
                                    v.i("MicroMsg.Notification.Tool.Sound", "play sound finish, player: %s", this.bZV.bZT);
                                    if (this.bZV.bZT != null) {
                                        this.bZV.bZT.release();
                                    }
                                }
                            });
                            this.bZT.setOnErrorListener(new OnErrorListener(this) {
                                final /* synthetic */ f bZV;

                                {
                                    this.bZV = r1;
                                }

                                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                    v.i("MicroMsg.Notification.Tool.Sound", "play sound error, player: %s", this.bZV.bZT);
                                    if (this.bZV.bZT != null) {
                                        this.bZV.bZT.release();
                                    }
                                    return false;
                                }
                            });
                        }
                        this.bZT.setAudioStreamType(0);
                        this.bZT.setLooping(true);
                        this.bZT.prepare();
                        this.bZT.setVolume(((float) streamVolume) / ((float) streamMaxVolume), ((float) streamVolume) / ((float) streamMaxVolume));
                        this.bZT.setLooping(false);
                        this.bZT.start();
                        this.bZS = true;
                    } else {
                        v.d("MicroMsg.Notification.Tool.Sound", "getStreamVolume =  %d, soundUri = %s", Integer.valueOf(audioManager.getStreamVolume(5)), str);
                        this.bZT.setOnCompletionListener(new OnCompletionListener(this) {
                            final /* synthetic */ f bZV;

                            {
                                this.bZV = r1;
                            }

                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                v.i("MicroMsg.Notification.Tool.Sound", "play sound finish, player: %s", this.bZV.bZT);
                                if (this.bZV.bZT != null) {
                                    this.bZV.bZT.release();
                                }
                            }
                        });
                        this.bZT.setOnErrorListener(new OnErrorListener(this) {
                            final /* synthetic */ f bZV;

                            {
                                this.bZV = r1;
                            }

                            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                v.i("MicroMsg.Notification.Tool.Sound", "play sound error, player: %s", this.bZV.bZT);
                                if (this.bZV.bZT != null) {
                                    this.bZV.bZT.release();
                                }
                                return false;
                            }
                        });
                        this.bZT.setAudioStreamType(5);
                        this.bZT.setLooping(true);
                        this.bZT.prepare();
                        this.bZT.setLooping(false);
                        this.bZT.start();
                        this.bZS = true;
                    }
                }
            } catch (Exception e2) {
                v.e("MicroMsg.Notification.Tool.Sound", "playSound error: %s", e2.getMessage());
            }
        }
    }
}
