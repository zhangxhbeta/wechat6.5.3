package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class by extends a {
    private static final int CTRL_INDEX = 7;
    public static final String NAME = "insertVideoPlayer";

    by() {
    }

    protected final View a(h hVar, JSONObject jSONObject) {
        String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH);
        if (be.kS(optString)) {
            v.e("MicroMsg.jsApiInsertVideoPlayer", "get filePath error!");
            return null;
        }
        File file = new File(optString);
        if (file.exists()) {
            MediaController mediaController = new MediaController(hVar.getContext());
            View videoView = new VideoView(hVar.getContext());
            videoView.setVideoPath(file.getAbsolutePath());
            videoView.setMediaController(mediaController);
            mediaController.setMediaPlayer(videoView);
            videoView.start();
            return videoView;
        }
        v.e("MicroMsg.jsApiInsertVideoPlayer", "file(%s) not exist!", new Object[]{optString});
        return null;
    }

    protected final String a(h hVar, boolean z, int i, String str) {
        if (z) {
            Map hashMap = new HashMap();
            hashMap.put("videoPlayerId", Integer.valueOf(i));
            return c("ok", hashMap);
        }
        return c("fail" + (TextUtils.isEmpty(str) ? "" : ":" + str), null);
    }

    protected final int d(JSONObject jSONObject) {
        return jSONObject.getInt("videoPlayerId");
    }

    protected final void b(h hVar, int i, View view, JSONObject jSONObject) {
        a(hVar, i, true).l("video_view", view);
    }
}
