package com.tencent.mm.compatible.d;

import com.tencent.mm.compatible.h.a;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

final class q {
    q() {
    }

    public static boolean a(String str, n nVar, b bVar, a aVar, j jVar, v vVar, aa aaVar, x xVar, s sVar, u uVar, y yVar, t tVar) {
        try {
            v.d("MicroMsg.DeviceInfoParser", "xml: " + str);
            Map q = bf.q(str, "deviceinfoconfig");
            if (q == null) {
                v.i("MicroMsg.DeviceInfoParser", "hy: null device config");
                return false;
            }
            if (q.get(".deviceinfoconfig.voip.cpu.armv7") != null) {
                nVar.cer = be.getInt((String) q.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
                nVar.ceq = true;
            }
            if (q.get(".deviceinfoconfig.voip.cpu.armv6") != null) {
                nVar.ces = be.getInt((String) q.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
                nVar.ceq = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.num") != null) {
                bVar.ccA = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.num"), 0);
                bVar.ccB = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.surface") != null) {
                bVar.ccC = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.surface"), 0);
                bVar.ccD = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.format") != null) {
                bVar.ccE = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.format"), 0);
                bVar.ccF = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.enable") != null) {
                bVar.ccI.cdf = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
                bVar.ccJ = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.fps") != null) {
                bVar.ccI.cdg = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
                bVar.ccJ = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.orien") != null) {
                bVar.ccI.cdh = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
                bVar.ccJ = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.rotate") != null) {
                bVar.ccI.cdi = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
                bVar.ccJ = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.isleft") != null) {
                bVar.ccI.cdj = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
                bVar.ccJ = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.width") != null) {
                bVar.ccI.width = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.width"), 0);
                bVar.ccJ = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.height") != null) {
                bVar.ccI.height = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.height"), 0);
                bVar.ccJ = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.enable") != null) {
                bVar.ccG.cdf = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
                bVar.ccH = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.fps") != null) {
                bVar.ccG.cdg = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
                bVar.ccH = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.orien") != null) {
                bVar.ccG.cdh = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
                bVar.ccH = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.rotate") != null) {
                bVar.ccG.cdi = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
                bVar.ccH = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.isleft") != null) {
                bVar.ccG.cdj = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
                bVar.ccH = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.width") != null) {
                bVar.ccG.width = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.width"), 0);
                bVar.ccH = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.height") != null) {
                bVar.ccG.height = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.height"), 0);
                bVar.ccH = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null) {
                bVar.ccL = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
                bVar.ccK = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null) {
                bVar.ccM = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
                bVar.ccK = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null) {
                bVar.ccN = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
                bVar.ccK = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null) {
                bVar.ccO = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
                bVar.ccK = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                bVar.ccP = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                bVar.ccQ = true;
                bVar.ccK = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                bVar.ccS = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                bVar.ccR = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
                bVar.ccT = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
                bVar.ccU = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.mAutofocusTimeInterval") != null) {
                bVar.cde = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.mAutofocusTimeInterval"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                bVar.ccP = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                bVar.ccQ = true;
                bVar.ccK = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                bVar.ccS = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                bVar.ccR = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
                bVar.ccV = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
                bVar.ccW = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
                bVar.ccX = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
                bVar.ccY = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
                bVar.ccZ = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
                bVar.cda = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
                bVar.cdb = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
                bVar.cdc = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
                bVar.cdd = be.getInt((String) q.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.streamtype") != null) {
                aVar.cbs = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
                aVar.cbr = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.smode") != null) {
                aVar.cbt = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.smode"), 0);
                aVar.cbr = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.omode") != null) {
                aVar.cbu = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.omode"), 0);
                aVar.cbr = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.ospeaker") != null) {
                aVar.cbv = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
                aVar.cbr = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.operating") != null) {
                aVar.cbw = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.operating"), 0);
                aVar.cbr = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.moperating") != null) {
                aVar.cbx = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.moperating"), 0);
                aVar.cbr = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.mstreamtype") != null) {
                aVar.cby = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
                aVar.cbr = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
                aVar.cbz = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                aVar.cbA = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
                aVar.cbB = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
                aVar.cbC = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.volummode") != null) {
                aVar.cbD = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.volummode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
                aVar.cbP = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.micmode") != null) {
                aVar.cbO = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.micmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
                aVar.cbQ = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
                aVar.cbR = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
                aVar.cbS = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
                aVar.cbT = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
                aVar.cbU = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
                aVar.cbW = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
                aVar.cbX = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
                aVar.cbY = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
                aVar.cbZ = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
                aVar.cca = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
                aVar.ccb = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
                aVar.ccc = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
                aVar.ccd = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
                aVar.cce = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
                aVar.ccf = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
                aVar.ccg = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
                aVar.cch = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
                aVar.cbE = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
                aVar.cbF = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
                aVar.cbG = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
                aVar.cbH = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
                aVar.cbK = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
                aVar.cbL = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
                aVar.cbM = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
                aVar.cbN = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
                aVar.cci = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
                aVar.ccj = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null) {
                aVar.ccl[0] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null) {
                aVar.ccl[1] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null) {
                aVar.ccl[2] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null) {
                aVar.ccl[3] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null) {
                aVar.ccl[4] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null) {
                aVar.ccl[5] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null) {
                aVar.ccl[6] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null) {
                aVar.ccl[7] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null) {
                aVar.ccl[8] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null) {
                aVar.ccl[9] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null) {
                aVar.ccl[10] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null) {
                aVar.ccl[11] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null) {
                aVar.ccl[12] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null) {
                aVar.ccl[13] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null) {
                aVar.ccl[14] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0);
                aVar.cck = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctoff") != null && be.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1) {
                aVar.cck = 0;
            }
            if (q.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
                aVar.cbI = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
                aVar.cbJ = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
                aVar.ccm[0] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
                aVar.ccm[1] = (short) be.getInt((String) q.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
                aVar.ccw = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
                aVar.ccx = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
                aVar.ccy = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
                aVar.ccz = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
                aVar.cco = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                aVar.cbA = be.getInt((String) q.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.speakermode") != null) {
                aVar.ccq = be.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
                aVar.ccp = true;
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.phonemode") != null) {
                aVar.ccr = be.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
                aVar.ccp = true;
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null) {
                aVar.ccs = be.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
                aVar.ccp = true;
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.streamtype") != null) {
                aVar.cct = be.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
                aVar.ccp = true;
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null) {
                aVar.ccu = be.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
                aVar.ccp = true;
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null) {
                aVar.ccv = be.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
                aVar.ccp = true;
            }
            if (q.get(".deviceinfoconfig.voip.common.js") != null) {
                jVar.cdu = true;
                jVar.cdv = be.getInt((String) q.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.js") != null) {
                jVar.cdm = be.getInt((String) q.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
                jVar.cdn = be.getInt((String) q.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
                jVar.cdo = be.getInt((String) q.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
                jVar.cdq = be.getInt((String) q.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
                jVar.cdp = be.getInt((String) q.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
                jVar.cdr = be.getInt((String) q.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
                jVar.cdt = be.getInt((String) q.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
                jVar.cds = be.getInt((String) q.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.app") != null) {
                jVar.cdw = be.getInt((String) q.get(".deviceinfoconfig.voip.common.app"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
                jVar.cdP = be.getInt((String) q.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
                jVar.cdQ = be.getInt((String) q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
                jVar.cdR = be.getInt((String) q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
                jVar.cdS = be.getInt((String) q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.vmfd") != null) {
                jVar.cdx = be.getInt((String) q.get(".deviceinfoconfig.voip.common.vmfd"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
                jVar.cdy = be.getInt((String) q.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
                jVar.cdz = be.getInt((String) q.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
                jVar.cdA = be.getInt((String) q.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.linespe") != null) {
                jVar.cdB = be.getInt((String) q.get(".deviceinfoconfig.voip.common.linespe"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.fixspan") != null) {
                jVar.cdM = be.getInt((String) q.get(".deviceinfoconfig.voip.common.fixspan"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.extvideo") != null) {
                jVar.cdC = be.getInt((String) q.get(".deviceinfoconfig.voip.common.extvideo"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
                jVar.cdD = be.getInt((String) q.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
                jVar.cdE = be.getInt((String) q.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
                jVar.cdH = be.getInt((String) q.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
                jVar.cdG = be.getInt((String) q.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                jVar.cdI = be.getInt((String) q.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                jVar.cdJ = be.getInt((String) q.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
                jVar.cdF = be.getInt((String) q.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                jVar.cdI = be.getInt((String) q.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                jVar.cdJ = be.getInt((String) q.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.base") != null) {
                jVar.cdT = (String) q.get(".deviceinfoconfig.voip.common.base");
            }
            if (q.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
                jVar.cdU = (String) q.get(".deviceinfoconfig.voip.common.packageinfo");
            }
            if (q.get(".deviceinfoconfig.voip.common.classloader") != null) {
                jVar.cdV = (String) q.get(".deviceinfoconfig.voip.common.classloader");
            }
            if (q.get(".deviceinfoconfig.voip.common.resources") != null) {
                jVar.cdW = (String) q.get(".deviceinfoconfig.voip.common.resources");
            }
            if (q.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
                jVar.cdK = be.getInt((String) q.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
                jVar.cdX = (String) q.get(".deviceinfoconfig.voip.common.extstoragedir");
            }
            if (q.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
                jVar.cdY = (String) q.get(".deviceinfoconfig.voip.common.extpubdir");
            }
            if (q.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
                jVar.cdZ = (String) q.get(".deviceinfoconfig.voip.common.extdatadir");
            }
            if (q.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
                jVar.cea = (String) q.get(".deviceinfoconfig.voip.common.extrootdir");
            }
            if (q.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
                jVar.ceb = (String) q.get(".deviceinfoconfig.voip.common.extstoragestate");
            }
            if (q.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
                jVar.cec = (String) q.get(".deviceinfoconfig.voip.common.extcachedir");
            }
            if (q.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
                jVar.cdL = be.getInt((String) q.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
            }
            if (q.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
                jVar.ced = (String) q.get(".deviceinfoconfig.voip.common.loadDrawable");
            }
            if (q.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
                jVar.cee = (String) q.get(".deviceinfoconfig.voip.common.loadXmlResourceParser");
            }
            if (q.get(".deviceinfoconfig.voip.common.sensorNearFar") != null && 1 == be.getInt((String) q.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0)) {
                SensorController.nln = true;
            }
            if (q.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
                SensorController.nlo = be.getDouble((String) q.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0d);
            }
            if (q.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
                jVar.cef = (String) q.get(".deviceinfoconfig.voip.common.sightFullType");
            }
            if (q.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
                jVar.ceg = be.getInt((String) q.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
            }
            if (q.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
                jVar.ceh = be.getInt((String) q.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
            }
            if (q.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null) {
                jVar.cei = be.getInt((String) q.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
                a.az(jVar.cei == 1);
            }
            if (q.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
                jVar.cej = be.getInt((String) q.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
            }
            if (q.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
                jVar.cdN = be.getInt((String) q.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
            }
            if (q.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
                jVar.cdO = be.getDouble((String) q.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0d);
            }
            if (q.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
                jVar.cek = be.getInt((String) q.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null) {
                vVar.cfc = be.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) == 1;
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
                vVar.cfd = be.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
                vVar.cfe = be.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
                vVar.cff = be.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
                vVar.cfh = be.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
                vVar.cfi = be.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
                vVar.cfj = be.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
                vVar.cfk = be.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
                vVar.cfl = be.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
                vVar.cfm = be.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.webview.notifythread") != null) {
                aaVar.cfx = be.getInt((String) q.get(".deviceinfoconfig.voip.webview.notifythread"), 0) == 1;
            }
            if (q.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null) {
                aaVar.cfy = be.getInt((String) q.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) == 1;
                v.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", Boolean.valueOf(aaVar.cfy));
                aa.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", aaVar.cfy).commit();
            }
            String str2 = (String) q.get(".deviceinfoconfig.voip.sensor.stepCounterRateUs");
            if (str2 != null) {
                xVar.cfo = be.getInt(str2, 800000);
                r.ar(100, xVar.cfo);
                v.i("MicroMsg.DeviceInfoParser", "setSensoInfo(rateUs : %d).", Integer.valueOf(xVar.cfo));
            }
            str2 = (String) q.get(".deviceinfoconfig.voip.sensor.stepCounterSaveInterval");
            if (str2 != null) {
                xVar.cfp = be.getInt(str2, 60000);
                r.ar(MMGIFException.D_GIF_ERR_OPEN_FAILED, xVar.cfp);
                v.i("MicroMsg.DeviceInfoParser", "setSensoInfo(saveInterval : %d).", Integer.valueOf(xVar.cfp));
            }
            str2 = (String) q.get(".deviceinfoconfig.voip.sensor.stepCounterMaxStep5m");
            if (str2 != null) {
                xVar.cfr = be.getInt(str2, 1000);
                r.ar(MMGIFException.D_GIF_ERR_READ_FAILED, xVar.cfr);
                v.i("MicroMsg.DeviceInfoParser", "setSensoInfo(maxStep5m : %d).", Integer.valueOf(xVar.cfr));
            }
            str2 = (String) q.get(".deviceinfoconfig.voip.sensor.stepCounterSwitch");
            if (str2 != null) {
                xVar.cfs = be.getInt(str2, 0);
                r.ar(MMGIFException.D_GIF_ERR_NOT_GIF_FILE, xVar.cfs);
                v.i("MicroMsg.DeviceInfoParser", "setSensoInfo(switch : %d).", Integer.valueOf(xVar.cfs));
            }
            str2 = (String) q.get(".deviceinfoconfig.voip.sensor.stepExtSwitch");
            if (str2 != null) {
                xVar.cft = be.getInt(str2, 0);
                r.ar(MMGIFException.D_GIF_ERR_NO_SCRN_DSCR, xVar.cft);
                v.i("MicroMsg.DeviceInfoParser", "setSensoInfo(ext switch : %d).", Integer.valueOf(xVar.cft));
            }
            jVar.dump();
            int i = be.getInt((String) q.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
            int i2 = be.getInt((String) q.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
            v.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", Integer.valueOf(i));
            if (sVar != null) {
                sVar.dS(i);
                sVar.dR(i2);
            }
            v.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", Integer.valueOf(be.getInt((String) q.get(".deviceinfoconfig.soter.isSupport"), 0)));
            if (yVar != null) {
                yVar.ax(i2 == 1);
            }
            v.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", (String) q.get(".deviceinfoconfig.freeWifi.operations.bizUserName"));
            if (uVar != null) {
                uVar.ds(str2);
            }
            v.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", bf.q(str, "manufacturerName"));
            if (uVar != null) {
                uVar.i(r2);
            }
            v.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", Integer.valueOf(be.getInt((String) q.get(".deviceinfoconfig.style.swipback"), 0)));
            if (uVar != null) {
                uVar.dT(i2);
            }
            i = be.getInt((String) q.get(".deviceinfoconfig.mmsight.recordertype"), -1);
            int i3 = be.getInt((String) q.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
            int i4 = be.getInt((String) q.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
            int i5 = be.getInt((String) q.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
            int i6 = be.getInt((String) q.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
            int i7 = be.getInt((String) q.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
            i2 = be.getInt((String) q.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
            if (tVar != null) {
                tVar.ceR = i;
                tVar.ceS = i3;
                tVar.ceT = i4;
                tVar.ceU = i5;
                tVar.ceV = i6;
                tVar.ceW = i7;
                tVar.ceX = i2;
                v.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", tVar.toString());
            }
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.DeviceInfoParser", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return false;
        }
    }
}
