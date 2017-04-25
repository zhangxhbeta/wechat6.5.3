package com.tencent.mm.platformtools;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.Time;
import com.tencent.mm.ay.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.d.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class k {

    static class AnonymousClass1 implements a {
        final /* synthetic */ String dpk;
        final /* synthetic */ Bundle dpl;
        final /* synthetic */ String dpm;
        final /* synthetic */ String dpn;
        final /* synthetic */ int dpo;
        final /* synthetic */ String val$jumpUrl;

        public AnonymousClass1(String str, String str2, Bundle bundle, String str3, String str4, int i) {
            this.val$jumpUrl = str;
            this.dpk = str2;
            this.dpl = bundle;
            this.dpm = str3;
            this.dpn = str4;
            this.dpo = i;
        }

        public final void onDone() {
            Time time = new Time();
            time.setToNow();
            if (com.tencent.mm.h.a.au(time.hour, time.minute)) {
                try {
                    Context context = aa.getContext();
                    boolean sx = com.tencent.mm.h.a.sx();
                    boolean sv = com.tencent.mm.h.a.sv();
                    v.d("MiroMsg.NotificationUtil", "shake " + sx + "sound " + sv);
                    if (sx) {
                        v.i("MiroMsg.NotificationUtil", "notification.shake:  notifyEngageRemind isShake~: true");
                        be.j(context, true);
                    }
                    if (sv) {
                        String sw = com.tencent.mm.h.a.sw();
                        Uri defaultUri = sw == c.cgI ? RingtoneManager.getDefaultUri(2) : Uri.parse(sw);
                        MediaPlayer mediaPlayer = new MediaPlayer();
                        try {
                            mediaPlayer.setDataSource(context, defaultUri);
                            mediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                                public final void onCompletion(MediaPlayer mediaPlayer) {
                                    try {
                                        mediaPlayer.release();
                                    } catch (Throwable e) {
                                        v.a("MiroMsg.NotificationUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    }
                                }
                            });
                            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                            if (audioManager.getStreamVolume(5) != 0) {
                                if (audioManager.isWiredHeadsetOn()) {
                                    int streamVolume = audioManager.getStreamVolume(8);
                                    int streamMaxVolume = audioManager.getStreamMaxVolume(8);
                                    int streamVolume2 = audioManager.getStreamVolume(5);
                                    if (streamVolume2 <= streamMaxVolume) {
                                        streamMaxVolume = streamVolume2;
                                    }
                                    audioManager.setStreamVolume(8, streamMaxVolume, 0);
                                    mediaPlayer.setAudioStreamType(8);
                                    mediaPlayer.setLooping(true);
                                    mediaPlayer.prepare();
                                    mediaPlayer.setLooping(false);
                                    mediaPlayer.start();
                                    audioManager.setStreamVolume(8, streamVolume, 0);
                                    v.d("MiroMsg.NotificationUtil", "oldVolume is %d, toneVolume is %d", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
                                } else {
                                    mediaPlayer.setAudioStreamType(5);
                                    mediaPlayer.setLooping(true);
                                    mediaPlayer.prepare();
                                    mediaPlayer.setLooping(false);
                                    mediaPlayer.start();
                                }
                            }
                        } catch (Throwable e) {
                            v.a("MiroMsg.NotificationUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                } catch (Throwable e2) {
                    v.a("MiroMsg.NotificationUtil", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            } else {
                v.i("MiroMsg.NotificationUtil", "no shake & sound notification during background deactive time");
            }
            Intent intent = new Intent();
            intent.setClassName(aa.getPackageName(), aa.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
            intent.putExtra("rawUrl", this.val$jumpUrl);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.setFlags(872415232);
            v.d("MiroMsg.NotificationUtil", "bizFrom: %s, data: %s", this.dpk, this.dpl);
            if (!(this.dpk == null || this.dpl == null)) {
                intent.putExtra("bizofstartfrom", this.dpk);
                intent.putExtra("startwebviewparams", this.dpl);
            }
            Notification notification = new Builder(aa.getContext()).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(this.dpm).setContentText(this.dpn).setContentIntent(PendingIntent.getActivity(aa.getContext(), 0, intent, 134217728)).getNotification();
            notification.icon = com.tencent.mm.ax.a.bmo();
            notification.flags |= 16;
            ((NotificationManager) aa.getContext().getSystemService("notification")).notify(this.dpo, notification);
        }
    }
}
