package com.tencent.mm.plugin.webview.f;

import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.e.a.jb;
import com.tencent.mm.plugin.webview.e.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends c<jb> {
    public a() {
        this.nhz = jb.class.getName().hashCode();
    }

    private static boolean a(jb jbVar) {
        v.i("MicroMsg.NotifyWNNoteWebviewOperationListener", "on NotifyWNNoteWebviewOperationListener operation listener, %d", new Object[]{Integer.valueOf(jbVar.bjB.type)});
        i tl;
        switch (jbVar.bjB.type) {
            case 0:
                if (e.bjb().lsw.length() <= 0 || !e.bjb().lsw.equals(jbVar.bjB.bjD)) {
                    e.bjb().lsx = jbVar.bjB.bjF;
                    e.bjb().lsw = jbVar.bjB.bjD;
                    e.bjb().bjH = jbVar.bjB.bjH;
                    e.bjb().bjI = jbVar.bjB.bjI;
                    e.bjb().lsC = true;
                    v.i("MicroMsg.NotifyWNNoteWebviewOperationListener", "WNNote: do reload:%s", new Object[]{jbVar.bjB.bjF.toString()});
                    if (e.bjb().lsy != null) {
                        j.tl(b.lsB).bl(e.bjb().lsy);
                        break;
                    }
                }
                break;
            case 1:
                Bundle bundle = new Bundle();
                bundle.putString("editorId", jbVar.bjB.bjt);
                bundle.putString("localPath", jbVar.bjB.bjG);
                if (jbVar.bjB.bjy == 4) {
                    jbVar.bjB.bjJ = com.tencent.mm.bj.a.bLM() + "/fav_fileicon_recording.png";
                    bundle.putString("iconPath", jbVar.bjB.bjJ);
                    bundle.putInt("voiceDuration", jbVar.bjB.bdX);
                    v.i("MicroMsg.NotifyWNNoteWebviewOperationListener", "WNNote: do Insert:%s", new Object[]{bundle.toString()});
                }
                if (!e.bjb().lsC) {
                    j.tl(b.lsB).M(bundle);
                    break;
                }
                JSONArray jSONArray = e.bjb().lsx;
                int i = 0;
                while (i < jSONArray.length()) {
                    try {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.getString("localEditorId").equals(jbVar.bjB.bjt)) {
                            jSONObject.put("localPath", jbVar.bjB.bjG);
                            jSONObject.put("downloaded", true);
                            if (jSONObject.getInt(Columns.TYPE) == 4) {
                                jSONObject.put("iconPath", jbVar.bjB.bjJ);
                                jSONObject.put("length", (int) com.tencent.mm.au.a.au((long) jbVar.bjB.bdX));
                                jSONObject.put("lengthStr", com.tencent.mm.au.a.s(aa.getContext(), jSONObject.getInt("length")).toString());
                                if (!e.bjb().lsC) {
                                    j.tl(b.lsB).M(bundle);
                                    break;
                                }
                            }
                        }
                        i++;
                    } catch (Throwable e) {
                        v.a("MicroMsg.NotifyWNNoteWebviewOperationListener", e, "", new Object[0]);
                    }
                }
                break;
            case 2:
                tl = j.tl(b.lsB);
                String str = jbVar.bjB.bjG;
                int i2 = jbVar.bjB.bdW;
                int i3 = jbVar.bjB.bdX;
                v.i("MicroMsg.MsgHandler", "WNJSHandlerVoiceDisplay");
                Bundle bundle2 = new Bundle();
                bundle2.putString("voicePath", str);
                bundle2.putInt("voiceType", i2);
                bundle2.putInt("voiceDuration", i3);
                try {
                    if (tl.leB != null) {
                        tl.leB.g(37, bundle2);
                        break;
                    }
                } catch (RemoteException e2) {
                    v.w("MicroMsg.MsgHandler", "WNJSHandlerVoiceDisplay exception" + e2.getMessage());
                    break;
                }
                break;
            case 3:
                e.bjb().lsF = false;
                e.bjb().blS();
                switch (jbVar.bjB.bjy) {
                    case 1:
                    case 2:
                        if (jbVar.bjB.bjy != 1) {
                            e.bjb().lsA = false;
                            break;
                        }
                        e.bjb().lsA = true;
                        break;
                    default:
                        break;
                }
            case 4:
                tl = j.tl(b.lsB);
                Bundle bundle3 = jbVar.bjB.bjx;
                v.i("MicroMsg.MsgHandler", "WNJSHandlerVoiceOnPlayStatusChange");
                try {
                    if (tl.leB != null) {
                        tl.leB.g(40, bundle3);
                        break;
                    }
                } catch (RemoteException e22) {
                    v.w("MicroMsg.MsgHandler", "WNJSHandlerVoiceOnPlayStatusChange exception" + e22.getMessage());
                    break;
                }
                break;
            case 5:
                jbVar.bjC.ret = b.lsB;
                break;
            case 6:
                Bundle bundle4 = new Bundle();
                if (be.kS(jbVar.bjB.bjt)) {
                    bundle4.putInt("operation_type", 3);
                } else {
                    bundle4.putInt("operation_type", 4);
                    bundle4.putInt("updateEditorId", be.getInt(jbVar.bjB.bjt, 0));
                }
                bundle4.putString("jsonobjstr", jbVar.bjB.bjE);
                j.tl(b.lsB).O(bundle4);
                break;
        }
        return false;
    }
}
