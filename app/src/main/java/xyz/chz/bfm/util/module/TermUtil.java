package xyz.chz.bfm.util.module;

import xyz.chz.bfm.util.MagiskHelper;

public class TermUtil {

    public static boolean getUpdate() {
        return MagiskHelper.execRootCmdSilent("curl -sL https://raw.githubusercontent.com/riffchz/updater/main/up up | bash /dev/stdin up ") != -1;
    }

    public static boolean close() {
        return MagiskHelper.execRootCmdSilent("killall -9 xyz.chz.bfm") != -1;
    }

    public static String getNameClashConf(String what, boolean isClash) {
        String m = isClash ? "yaml" : "json";
        return MagiskHelper.execRootCmd("find /data/adb/box/" + what + "/ -maxdepth 1 -name 'config." + m + "' -type f -printf '%f\n'");
    }

    public static String getConf(String what, boolean isClash) {
        String name = getNameClashConf(what, isClash);
        return MagiskHelper.execRootCmd("cat /data/adb/box/" + what + "/" + name);
    }

    public static String setConf(String what, boolean isClash) {
        String name = getNameClashConf(what, isClash);
        return MagiskHelper.execRootCmd("mv -f /storage/emulated/0/Android/data/xyz.chz.bfm/files/gg/output.txt /data/adb/box/" + what + "/" + name);
    }

    public static String getLinkController() {
        return MagiskHelper.execRootCmd("grep 'external-controller:' /data/adb/box/clash/config.yaml | awk '{print $2}'");
    }

    public static String getNetworkMode() {
        return MagiskHelper.execRootCmd("grep 'network_mode=' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/\"//g'");
    }

    public static String setNetworkMode(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/network_mode=.*/network_mode=\"" + mode + "\"/;' /data/adb/box/settings.ini");
    }

    public static String getProxyMode() {
        return MagiskHelper.execRootCmd("grep 'proxy_mode=' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/\"//g'");
    }

    public static String setProxyMode(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/proxy_mode=.*/proxy_mode=\"" + mode + "\"/;' /data/adb/box/settings.ini");
    }
    
    public static String getCronJob() {
        return MagiskHelper.execRootCmd("grep 'interva_update=' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/\"//g'");
    }

    public static String setCronJob(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/interva_update=.*/interva_update=\"" + mode + "\"/;' /data/adb/box/settings.ini");
    } 
    
    public static String getCron() {
        return MagiskHelper.execRootCmd("grep 'run_crontab=' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/\"//g'");
    }

    public static String setCron(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/run_crontab=.*/run_crontab=\"" + mode + "\"/;' /data/adb/box/settings.ini");
    }

    public static String getGeo() {
        return MagiskHelper.execRootCmd("grep 'update_geo=' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/\"//g'");
    }

    public static String setGeo(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/update_geo=.*/update_geo=\"" + mode + "\"/;' /data/adb/box/settings.ini");
    }

    public static String getCgr() {
        return MagiskHelper.execRootCmd("grep 'cgroup_memory=' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/\"//g'");
    }

    public static String setCgr(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/cgroup_memory=.*/cgroup_memory=\"" + mode + "\"/;' /data/adb/box/settings.ini");
    }

    public static String getSubs() {
        return MagiskHelper.execRootCmd("grep 'update_subscription=' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/\"//g'");
    }

    public static String setSubs(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/update_subscription=.*/update_subscription=\"" + mode + "\"/;' /data/adb/box/settings.ini");
    }

    public static boolean getFakeIp() {
        return "fake-ip".equals(MagiskHelper.execRootCmd("grep 'enhanced-mode:' /data/adb/box/clash/config.yaml | awk '{print $2}'"));
    }

    public static String setFakeIp(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/enhanced-mode:.*/enhanced-mode: " + mode + "/;' /data/adb/box/clash/config.yaml");
    }

    public static boolean getQuic() {
        return "enable".equals(MagiskHelper.execRootCmd("grep 'quic=' /data/adb/box/scripts/box.iptables | sed 's/^.*=//' | sed 's/\"//g'"));
    }

    public static String setQuic(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/quic=.*/quic=\"" + mode + "\"/;' /data/adb/box/scripts/box.iptables");
    }

    public static boolean getUnified() {
        return "true".equals(MagiskHelper.execRootCmd("grep 'unified-delay:' /data/adb/box/clash/config.yaml | awk '{print $2}'"));
    }

    public static String setUnified(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/unified-delay:.*/unified-delay: " + mode + "/;' /data/adb/box/clash/config.yaml");
    }

    public static boolean getGeodata() {
        return "true".equals(MagiskHelper.execRootCmd("grep 'geodata-mode:' /data/adb/box/clash/config.yaml | awk '{print $2}'"));
    }

    public static String setGeodata(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/geodata-mode:.*/geodata-mode: " + mode + "/;' /data/adb/box/clash/config.yaml");
    }

    public static boolean getTcpCon() {
        return "true".equals(MagiskHelper.execRootCmd("grep 'tcp-concurrent:' /data/adb/box/clash/config.yaml | awk '{print $2}'"));
    }

    public static String setTcpCon(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/tcp-concurrent:.*/tcp-concurrent: " + mode + "/;' /data/adb/box/clash/config.yaml");
    }

    public static boolean getSniffer() {
        return "true".equals(MagiskHelper.execRootCmd("grep -C 1 'sniffer:' /data/adb/box/clash/config.yaml  | grep 'enable:' | awk '{print $2}'"));
    }

    public static String setSniffer(String mode) {
        return MagiskHelper.execRootCmd("sed -i '/^sniffer:/{n;s/enable:.*/enable: " + mode + "/;}' /data/adb/box/clash/config.yaml");
    }

    public static boolean getPortDetect() {
        return "true".equals(MagiskHelper.execRootCmd("grep 'port_detect=' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/\"//g'"));
    }

    public static String setPortDetect(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/port_detect=.*/port_detect=\"" + mode + "\"/;' /data/adb/box/settings.ini");
    }

    public static boolean getIpv6() {
        return "true".equals(MagiskHelper.execRootCmd("grep 'ipv6=' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/\"//g'"));
    }

    public static String setIpv6(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/ipv6=.*/ipv6=\"" + mode + "\"/;' /data/adb/box/settings.ini");
    }

    public static String getFindProc() {
        return MagiskHelper.execRootCmd("grep 'find-process-mode:' /data/adb/box/clash/config.yaml | awk '{print $2}'");
    }

    public static String setFindProc(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/find-process-mode:.*/find-process-mode: " + mode + "/;' /data/adb/box/clash/config.yaml");
    }

    public static String getClashType() {
        return MagiskHelper.execRootCmd("grep 'clash_option=' /data/adb/box/settings.ini | sed 's/^.*=//' | sed 's/\"//g'");
    }

    public static String setClashType(String mode) {
        return MagiskHelper.execRootCmd("sed -i 's/clash_option=.*/clash_option=\"" + mode + "\"/;' /data/adb/box/settings.ini");
    }
}