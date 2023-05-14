package xyz.chz.bfm.ui.activity.Config;

import java.io.IOException;
import java.util.UUID;

public class Conpig {

    public class MainConfig {
        private long port;
        private long socksPort;
        private long mixedPort;
        private long redirPort;
        private long tproxyPort;
        private boolean allowLAN;
        private String bindAddress;
        private String findProcessMode;
        private String globalClientFingerprint;
        private String mode;
        private GeoxURL geoxURL;
        private String logLevel;
        private boolean ipv6;
        private String externalController;
        private String externalControllerTLS;
        private String secret;
        private boolean tcpConcurrent;
        private String externalUI;
        private String interfaceName;
        private long routingMark;
        private Object experimental;
        private Object hosts;
        private String chzDev;
        private String dev;
        private String alphaChzDev;
        private Tun tun;
        private Ebpf ebpf;
        private Sniffer sniffer;
        private TuicServer tuicServer;
        private TunnelElement[] tunnels;
        private Profile profile;
        private DNS dns;
        private ProxyElement[] proxies;
        private ProxyGroup[] proxyGroups;
        private ProxyProviders proxyProviders;
        private RuleProviders ruleProviders;
        private String[] rules;
        private SubRules subRules;
        private TLSClass tls;
        private Listener[] listeners;

        public long getPort() {
            return port;
        }

        public void setPort(long value) {
            this.port = value;
        }

        public long getSocksPort() {
            return socksPort;
        }

        public void setSocksPort(long value) {
            this.socksPort = value;
        }

        public long getMixedPort() {
            return mixedPort;
        }

        public void setMixedPort(long value) {
            this.mixedPort = value;
        }

        public long getRedirPort() {
            return redirPort;
        }

        public void setRedirPort(long value) {
            this.redirPort = value;
        }

        public long getTproxyPort() {
            return tproxyPort;
        }

        public void setTproxyPort(long value) {
            this.tproxyPort = value;
        }

        public boolean getAllowLAN() {
            return allowLAN;
        }

        public void setAllowLAN(boolean value) {
            this.allowLAN = value;
        }

        public String getBindAddress() {
            return bindAddress;
        }

        public void setBindAddress(String value) {
            this.bindAddress = value;
        }

        public String getFindProcessMode() {
            return findProcessMode;
        }

        public void setFindProcessMode(String value) {
            this.findProcessMode = value;
        }

        public String getGlobalClientFingerprint() {
            return globalClientFingerprint;
        }

        public void setGlobalClientFingerprint(String value) {
            this.globalClientFingerprint = value;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String value) {
            this.mode = value;
        }

        public GeoxURL getGeoxURL() {
            return geoxURL;
        }

        public void setGeoxURL(GeoxURL value) {
            this.geoxURL = value;
        }

        public String getLogLevel() {
            return logLevel;
        }

        public void setLogLevel(String value) {
            this.logLevel = value;
        }

        public boolean getIpv6() {
            return ipv6;
        }

        public void setIpv6(boolean value) {
            this.ipv6 = value;
        }

        public String getExternalController() {
            return externalController;
        }

        public void setExternalController(String value) {
            this.externalController = value;
        }

        public String getExternalControllerTLS() {
            return externalControllerTLS;
        }

        public void setExternalControllerTLS(String value) {
            this.externalControllerTLS = value;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String value) {
            this.secret = value;
        }

        public boolean getTCPConcurrent() {
            return tcpConcurrent;
        }

        public void setTCPConcurrent(boolean value) {
            this.tcpConcurrent = value;
        }

        public String getExternalUI() {
            return externalUI;
        }

        public void setExternalUI(String value) {
            this.externalUI = value;
        }

        public String getInterfaceName() {
            return interfaceName;
        }

        public void setInterfaceName(String value) {
            this.interfaceName = value;
        }

        public long getRoutingMark() {
            return routingMark;
        }

        public void setRoutingMark(long value) {
            this.routingMark = value;
        }

        public Object getExperimental() {
            return experimental;
        }

        public void setExperimental(Object value) {
            this.experimental = value;
        }

        public Object getHosts() {
            return hosts;
        }

        public void setHosts(Object value) {
            this.hosts = value;
        }

        public String getChzDev() {
            return chzDev;
        }

        public void setChzDev(String value) {
            this.chzDev = value;
        }

        public String getDev() {
            return dev;
        }

        public void setDev(String value) {
            this.dev = value;
        }

        public String getAlphaChzDev() {
            return alphaChzDev;
        }

        public void setAlphaChzDev(String value) {
            this.alphaChzDev = value;
        }

        public Tun getTun() {
            return tun;
        }

        public void setTun(Tun value) {
            this.tun = value;
        }

        public Ebpf getEbpf() {
            return ebpf;
        }

        public void setEbpf(Ebpf value) {
            this.ebpf = value;
        }

        public Sniffer getSniffer() {
            return sniffer;
        }

        public void setSniffer(Sniffer value) {
            this.sniffer = value;
        }

        public TuicServer getTuicServer() {
            return tuicServer;
        }

        public void setTuicServer(TuicServer value) {
            this.tuicServer = value;
        }

        public TunnelElement[] getTunnels() {
            return tunnels;
        }

        public void setTunnels(TunnelElement[] value) {
            this.tunnels = value;
        }

        public Profile getProfile() {
            return profile;
        }

        public void setProfile(Profile value) {
            this.profile = value;
        }

        public DNS getDNS() {
            return dns;
        }

        public void setDNS(DNS value) {
            this.dns = value;
        }

        public ProxyElement[] getProxies() {
            return proxies;
        }

        public void setProxies(ProxyElement[] value) {
            this.proxies = value;
        }

        public ProxyGroup[] getProxyGroups() {
            return proxyGroups;
        }

        public void setProxyGroups(ProxyGroup[] value) {
            this.proxyGroups = value;
        }

        public ProxyProviders getProxyProviders() {
            return proxyProviders;
        }

        public void setProxyProviders(ProxyProviders value) {
            this.proxyProviders = value;
        }

        public RuleProviders getRuleProviders() {
            return ruleProviders;
        }

        public void setRuleProviders(RuleProviders value) {
            this.ruleProviders = value;
        }

        public String[] getRules() {
            return rules;
        }

        public void setRules(String[] value) {
            this.rules = value;
        }

        public SubRules getSubRules() {
            return subRules;
        }

        public void setSubRules(SubRules value) {
            this.subRules = value;
        }

        public TLSClass getTLS() {
            return tls;
        }

        public void setTLS(TLSClass value) {
            this.tls = value;
        }

        public Listener[] getListeners() {
            return listeners;
        }

        public void setListeners(Listener[] value) {
            this.listeners = value;
        }
    }

    public class DNS {
        private boolean enable;
        private boolean preferH3;
        private String listen;
        private boolean ipv6;
        private String[] defaultNameserver;
        private String enhancedMode;
        private String fakeIPRange;
        private boolean useHosts;
        private String[] fakeIPFilter;
        private String[] nameserver;
        private String[] fallback;
        private String[] proxyServerNameserver;
        private FallbackFilter fallbackFilter;
        private NameserverPolicy nameserverPolicy;

        public boolean getEnable() {
            return enable;
        }

        public void setEnable(boolean value) {
            this.enable = value;
        }

        public boolean getPreferH3() {
            return preferH3;
        }

        public void setPreferH3(boolean value) {
            this.preferH3 = value;
        }

        public String getListen() {
            return listen;
        }

        public void setListen(String value) {
            this.listen = value;
        }

        public boolean getIpv6() {
            return ipv6;
        }

        public void setIpv6(boolean value) {
            this.ipv6 = value;
        }

        public String[] getDefaultNameserver() {
            return defaultNameserver;
        }

        public void setDefaultNameserver(String[] value) {
            this.defaultNameserver = value;
        }

        public String getEnhancedMode() {
            return enhancedMode;
        }

        public void setEnhancedMode(String value) {
            this.enhancedMode = value;
        }

        public String getFakeIPRange() {
            return fakeIPRange;
        }

        public void setFakeIPRange(String value) {
            this.fakeIPRange = value;
        }

        public boolean getUseHosts() {
            return useHosts;
        }

        public void setUseHosts(boolean value) {
            this.useHosts = value;
        }

        public String[] getFakeIPFilter() {
            return fakeIPFilter;
        }

        public void setFakeIPFilter(String[] value) {
            this.fakeIPFilter = value;
        }

        public String[] getNameserver() {
            return nameserver;
        }

        public void setNameserver(String[] value) {
            this.nameserver = value;
        }

        public String[] getFallback() {
            return fallback;
        }

        public void setFallback(String[] value) {
            this.fallback = value;
        }

        public String[] getProxyServerNameserver() {
            return proxyServerNameserver;
        }

        public void setProxyServerNameserver(String[] value) {
            this.proxyServerNameserver = value;
        }

        public FallbackFilter getFallbackFilter() {
            return fallbackFilter;
        }

        public void setFallbackFilter(FallbackFilter value) {
            this.fallbackFilter = value;
        }

        public NameserverPolicy getNameserverPolicy() {
            return nameserverPolicy;
        }

        public void setNameserverPolicy(NameserverPolicy value) {
            this.nameserverPolicy = value;
        }
    }

    public class FallbackFilter {
        private boolean geoip;
        private String geoipCode;
        private String[] geosite;
        private String[] ipcidr;
        private String[] domain;

        public boolean getGeoip() {
            return geoip;
        }

        public void setGeoip(boolean value) {
            this.geoip = value;
        }

        public String getGeoipCode() {
            return geoipCode;
        }

        public void setGeoipCode(String value) {
            this.geoipCode = value;
        }

        public String[] getGeosite() {
            return geosite;
        }

        public void setGeosite(String[] value) {
            this.geosite = value;
        }

        public String[] getIpcidr() {
            return ipcidr;
        }

        public void setIpcidr(String[] value) {
            this.ipcidr = value;
        }

        public String[] getDomain() {
            return domain;
        }

        public void setDomain(String[] value) {
            this.domain = value;
        }
    }

    public class NameserverPolicy {
        private String wwwBaiduCOM;
        private String internalCropCOM;
        private String geositeCN;

        public String getWWWBaiduCOM() {
            return wwwBaiduCOM;
        }

        public void setWWWBaiduCOM(String value) {
            this.wwwBaiduCOM = value;
        }

        public String getInternalCropCOM() {
            return internalCropCOM;
        }

        public void setInternalCropCOM(String value) {
            this.internalCropCOM = value;
        }

        public String getGeositeCN() {
            return geositeCN;
        }

        public void setGeositeCN(String value) {
            this.geositeCN = value;
        }
    }

    public class Ebpf {
        private String[] autoRedir;
        private String[] redirectToTun;

        public String[] getAutoRedir() {
            return autoRedir;
        }

        public void setAutoRedir(String[] value) {
            this.autoRedir = value;
        }

        public String[] getRedirectToTun() {
            return redirectToTun;
        }

        public void setRedirectToTun(String[] value) {
            this.redirectToTun = value;
        }
    }

    public class GeoxURL {
        private String geoip;
        private String geosite;
        private String mmdb;

        public String getGeoip() {
            return geoip;
        }

        public void setGeoip(String value) {
            this.geoip = value;
        }

        public String getGeosite() {
            return geosite;
        }

        public void setGeosite(String value) {
            this.geosite = value;
        }

        public String getMmdb() {
            return mmdb;
        }

        public void setMmdb(String value) {
            this.mmdb = value;
        }
    }

    public class Listener {
        private String name;
        private String type;
        private Long port;
        private String listen;
        private Rule rule;
        private ProxyUnion proxy;
        private Boolean udp;
        private String password;
        private String cipher;
        private User[] users;
        private String[] network;
        private String target;
        private String stack;
        private String[] dnsHijack;
        private Boolean autoDetectInterface;
        private Boolean autoRoute;
        private Long mtu;
        private String[] inet4Address;
        private String[] inet6Address;
        private StrictRoute strictRoute;
        private Boolean endpointIndependentNat;
        private long[] includeUid;
        private String[] includeUidRange;
        private long[] excludeUid;
        private String[] excludeUidRange;
        private long[] includeAndroidUser;
        private String[] includePackage;
        private String[] excludePackage;

        public String getName() {
            return name;
        }

        public void setName(String value) {
            this.name = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String value) {
            this.type = value;
        }

        public Long getPort() {
            return port;
        }

        public void setPort(Long value) {
            this.port = value;
        }

        public String getListen() {
            return listen;
        }

        public void setListen(String value) {
            this.listen = value;
        }

        public Rule getRule() {
            return rule;
        }

        public void setRule(Rule value) {
            this.rule = value;
        }

        public ProxyUnion getProxy() {
            return proxy;
        }

        public void setProxy(ProxyUnion value) {
            this.proxy = value;
        }

        public Boolean getUDP() {
            return udp;
        }

        public void setUDP(Boolean value) {
            this.udp = value;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String value) {
            this.password = value;
        }

        public String getCipher() {
            return cipher;
        }

        public void setCipher(String value) {
            this.cipher = value;
        }

        public User[] getUsers() {
            return users;
        }

        public void setUsers(User[] value) {
            this.users = value;
        }

        public String[] getNetwork() {
            return network;
        }

        public void setNetwork(String[] value) {
            this.network = value;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String value) {
            this.target = value;
        }

        public String getStack() {
            return stack;
        }

        public void setStack(String value) {
            this.stack = value;
        }

        public String[] getDNSHijack() {
            return dnsHijack;
        }

        public void setDNSHijack(String[] value) {
            this.dnsHijack = value;
        }

        public Boolean getAutoDetectInterface() {
            return autoDetectInterface;
        }

        public void setAutoDetectInterface(Boolean value) {
            this.autoDetectInterface = value;
        }

        public Boolean getAutoRoute() {
            return autoRoute;
        }

        public void setAutoRoute(Boolean value) {
            this.autoRoute = value;
        }

        public Long getMTU() {
            return mtu;
        }

        public void setMTU(Long value) {
            this.mtu = value;
        }

        public String[] getInet4Address() {
            return inet4Address;
        }

        public void setInet4Address(String[] value) {
            this.inet4Address = value;
        }

        public String[] getInet6Address() {
            return inet6Address;
        }

        public void setInet6Address(String[] value) {
            this.inet6Address = value;
        }

        public StrictRoute getStrictRoute() {
            return strictRoute;
        }

        public void setStrictRoute(StrictRoute value) {
            this.strictRoute = value;
        }

        public Boolean getEndpointIndependentNat() {
            return endpointIndependentNat;
        }

        public void setEndpointIndependentNat(Boolean value) {
            this.endpointIndependentNat = value;
        }

        public long[] getIncludeUid() {
            return includeUid;
        }

        public void setIncludeUid(long[] value) {
            this.includeUid = value;
        }

        public String[] getIncludeUidRange() {
            return includeUidRange;
        }

        public void setIncludeUidRange(String[] value) {
            this.includeUidRange = value;
        }

        public long[] getExcludeUid() {
            return excludeUid;
        }

        public void setExcludeUid(long[] value) {
            this.excludeUid = value;
        }

        public String[] getExcludeUidRange() {
            return excludeUidRange;
        }

        public void setExcludeUidRange(String[] value) {
            this.excludeUidRange = value;
        }

        public long[] getIncludeAndroidUser() {
            return includeAndroidUser;
        }

        public void setIncludeAndroidUser(long[] value) {
            this.includeAndroidUser = value;
        }

        public String[] getIncludePackage() {
            return includePackage;
        }

        public void setIncludePackage(String[] value) {
            this.includePackage = value;
        }

        public String[] getExcludePackage() {
            return excludePackage;
        }

        public void setExcludePackage(String[] value) {
            this.excludePackage = value;
        }
    }

    public class ProxyUnion {
        public TuicServer tuicServerValue;
        public String stringValue;
    }

    public class TuicServer {
        private String[] token;
        private String certificate;
        private String privateKey;
        private String congestionController;
        private long maxIdleTime;
        private long authenticationTimeout;
        private String[] alpn;
        private long maxUDPRelayPacketSize;
        private Boolean enable;
        private String listen;

        public String[] getToken() {
            return token;
        }

        public void setToken(String[] value) {
            this.token = value;
        }

        public String getCertificate() {
            return certificate;
        }

        public void setCertificate(String value) {
            this.certificate = value;
        }

        public String getPrivateKey() {
            return privateKey;
        }

        public void setPrivateKey(String value) {
            this.privateKey = value;
        }

        public String getCongestionController() {
            return congestionController;
        }

        public void setCongestionController(String value) {
            this.congestionController = value;
        }

        public long getMaxIdleTime() {
            return maxIdleTime;
        }

        public void setMaxIdleTime(long value) {
            this.maxIdleTime = value;
        }

        public long getAuthenticationTimeout() {
            return authenticationTimeout;
        }

        public void setAuthenticationTimeout(long value) {
            this.authenticationTimeout = value;
        }

        public String[] getAlpn() {
            return alpn;
        }

        public void setAlpn(String[] value) {
            this.alpn = value;
        }

        public long getMaxUDPRelayPacketSize() {
            return maxUDPRelayPacketSize;
        }

        public void setMaxUDPRelayPacketSize(long value) {
            this.maxUDPRelayPacketSize = value;
        }

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean value) {
            this.enable = value;
        }

        public String getListen() {
            return listen;
        }

        public void setListen(String value) {
            this.listen = value;
        }
    }

    public enum Rule {
        SUB_RULE_NAME1;

        public String toValue() {
            switch (this) {
                case SUB_RULE_NAME1:
                    return "sub-rule-name1";
            }
            return null;
        }

        public static Rule forValue(String value) throws IOException {
            if (value.equals("sub-rule-name1")) return SUB_RULE_NAME1;
            throw new IOException("Cannot deserialize Rule");
        }
    }

    public class StrictRoute {
        private String[] inet4RouteAddress;
        private String[] inet6RouteAddress;

        public String[] getInet4RouteAddress() {
            return inet4RouteAddress;
        }

        public void setInet4RouteAddress(String[] value) {
            this.inet4RouteAddress = value;
        }

        public String[] getInet6RouteAddress() {
            return inet6RouteAddress;
        }

        public void setInet6RouteAddress(String[] value) {
            this.inet6RouteAddress = value;
        }
    }

    public class User {
        private long username;
        private UUID uuid;
        private long alterID;

        public long getUsername() {
            return username;
        }

        public void setUsername(long value) {
            this.username = value;
        }

        public UUID getUUID() {
            return uuid;
        }

        public void setUUID(UUID value) {
            this.uuid = value;
        }

        public long getAlterID() {
            return alterID;
        }

        public void setAlterID(long value) {
            this.alterID = value;
        }
    }

    public class Profile {
        private boolean storeSelected;
        private boolean storeFakeIP;

        public boolean getStoreSelected() {
            return storeSelected;
        }

        public void setStoreSelected(boolean value) {
            this.storeSelected = value;
        }

        public boolean getStoreFakeIP() {
            return storeFakeIP;
        }

        public void setStoreFakeIP(boolean value) {
            this.storeFakeIP = value;
        }
    }

    public class ProxyElement {
        private String name;
        private String type;
        private Server server;
        private long port;
        private String cipher;
        private Password password;
        private Boolean udp;
        private Boolean udpOverTCP;
        private String ipVersion;
        private String plugin;
        private PluginOpts pluginOpts;
        private String uuid;
        private Long alterID;
        private TLSUnion tls;
        private Fingerprint fingerprint;
        private String clientFingerprint;
        private Boolean skipCERTVerify;
        private String servername;
        private String network;
        private WsOpts wsOpts;
        private H2Opts h2Opts;
        private HTTPOpts httpOpts;
        private GrpcOpts grpcOpts;
        private String username;
        private String sni;
        private Password psk;
        private Long version;
        private Object obfsOpts;
        private String mode;
        private String host;
        private String[] alpn;
        private String path;
        private ProxyHeaders headers;
        private String flow;
        private Boolean flowShow;
        private String proxyAuthStr;
        private String authStr;
        private String obfs;
        private String protocol;
        private String up;
        private String down;
        private Long proxyRecvWindowConn;
        private Long recvWindowConn;
        private Long proxyRecvWindow;
        private Long recvWindow;
        private String ca;
        private String proxyCAStr;
        private String caStr;
        private Boolean disableMTUDiscovery;
        private Boolean fastOpen;
        private String ip;
        private String ipv6;
        private String privateKey;
        private String publicKey;
        private String token;
        private Long heartbeatInterval;
        private Boolean disableSni;
        private Boolean reduceRtt;
        private Long requestTimeout;
        private String udpRelayMode;
        private String congestionController;
        private Long maxUDPRelayPacketSize;
        private Long maxOpenStreams;
        private String obfsParam;
        private String protocolParam;

        public String getName() {
            return name;
        }

        public void setName(String value) {
            this.name = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String value) {
            this.type = value;
        }

        public Server getServer() {
            return server;
        }

        public void setServer(Server value) {
            this.server = value;
        }

        public long getPort() {
            return port;
        }

        public void setPort(long value) {
            this.port = value;
        }

        public String getCipher() {
            return cipher;
        }

        public void setCipher(String value) {
            this.cipher = value;
        }

        public Password getPassword() {
            return password;
        }

        public void setPassword(Password value) {
            this.password = value;
        }

        public Boolean getUDP() {
            return udp;
        }

        public void setUDP(Boolean value) {
            this.udp = value;
        }

        public Boolean getUDPOverTCP() {
            return udpOverTCP;
        }

        public void setUDPOverTCP(Boolean value) {
            this.udpOverTCP = value;
        }

        public String getIPVersion() {
            return ipVersion;
        }

        public void setIPVersion(String value) {
            this.ipVersion = value;
        }

        public String getPlugin() {
            return plugin;
        }

        public void setPlugin(String value) {
            this.plugin = value;
        }

        public PluginOpts getPluginOpts() {
            return pluginOpts;
        }

        public void setPluginOpts(PluginOpts value) {
            this.pluginOpts = value;
        }

        public String getUUID() {
            return uuid;
        }

        public void setUUID(String value) {
            this.uuid = value;
        }

        public Long getAlterID() {
            return alterID;
        }

        public void setAlterID(Long value) {
            this.alterID = value;
        }

        public TLSUnion getTLS() {
            return tls;
        }

        public void setTLS(TLSUnion value) {
            this.tls = value;
        }

        public Fingerprint getFingerprint() {
            return fingerprint;
        }

        public void setFingerprint(Fingerprint value) {
            this.fingerprint = value;
        }

        public String getClientFingerprint() {
            return clientFingerprint;
        }

        public void setClientFingerprint(String value) {
            this.clientFingerprint = value;
        }

        public Boolean getSkipCERTVerify() {
            return skipCERTVerify;
        }

        public void setSkipCERTVerify(Boolean value) {
            this.skipCERTVerify = value;
        }

        public String getServername() {
            return servername;
        }

        public void setServername(String value) {
            this.servername = value;
        }

        public String getNetwork() {
            return network;
        }

        public void setNetwork(String value) {
            this.network = value;
        }

        public WsOpts getWsOpts() {
            return wsOpts;
        }

        public void setWsOpts(WsOpts value) {
            this.wsOpts = value;
        }

        public H2Opts getH2Opts() {
            return h2Opts;
        }

        public void setH2Opts(H2Opts value) {
            this.h2Opts = value;
        }

        public HTTPOpts getHTTPOpts() {
            return httpOpts;
        }

        public void setHTTPOpts(HTTPOpts value) {
            this.httpOpts = value;
        }

        public GrpcOpts getGrpcOpts() {
            return grpcOpts;
        }

        public void setGrpcOpts(GrpcOpts value) {
            this.grpcOpts = value;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String value) {
            this.username = value;
        }

        public String getSni() {
            return sni;
        }

        public void setSni(String value) {
            this.sni = value;
        }

        public Password getPsk() {
            return psk;
        }

        public void setPsk(Password value) {
            this.psk = value;
        }

        public Long getVersion() {
            return version;
        }

        public void setVersion(Long value) {
            this.version = value;
        }

        public Object getObfsOpts() {
            return obfsOpts;
        }

        public void setObfsOpts(Object value) {
            this.obfsOpts = value;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String value) {
            this.mode = value;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String value) {
            this.host = value;
        }

        public String[] getAlpn() {
            return alpn;
        }

        public void setAlpn(String[] value) {
            this.alpn = value;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String value) {
            this.path = value;
        }

        public ProxyHeaders getHeaders() {
            return headers;
        }

        public void setHeaders(ProxyHeaders value) {
            this.headers = value;
        }

        public String getFlow() {
            return flow;
        }

        public void setFlow(String value) {
            this.flow = value;
        }

        public Boolean getFlowShow() {
            return flowShow;
        }

        public void setFlowShow(Boolean value) {
            this.flowShow = value;
        }

        public String getProxyAuthStr() {
            return proxyAuthStr;
        }

        public void setProxyAuthStr(String value) {
            this.proxyAuthStr = value;
        }

        public String getAuthStr() {
            return authStr;
        }

        public void setAuthStr(String value) {
            this.authStr = value;
        }

        public String getObfs() {
            return obfs;
        }

        public void setObfs(String value) {
            this.obfs = value;
        }

        public String getProtocol() {
            return protocol;
        }

        public void setProtocol(String value) {
            this.protocol = value;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String value) {
            this.up = value;
        }

        public String getDown() {
            return down;
        }

        public void setDown(String value) {
            this.down = value;
        }

        public Long getProxyRecvWindowConn() {
            return proxyRecvWindowConn;
        }

        public void setProxyRecvWindowConn(Long value) {
            this.proxyRecvWindowConn = value;
        }

        public Long getRecvWindowConn() {
            return recvWindowConn;
        }

        public void setRecvWindowConn(Long value) {
            this.recvWindowConn = value;
        }

        public Long getProxyRecvWindow() {
            return proxyRecvWindow;
        }

        public void setProxyRecvWindow(Long value) {
            this.proxyRecvWindow = value;
        }

        public Long getRecvWindow() {
            return recvWindow;
        }

        public void setRecvWindow(Long value) {
            this.recvWindow = value;
        }

        public String getCA() {
            return ca;
        }

        public void setCA(String value) {
            this.ca = value;
        }

        public String getProxyCAStr() {
            return proxyCAStr;
        }

        public void setProxyCAStr(String value) {
            this.proxyCAStr = value;
        }

        public String getCAStr() {
            return caStr;
        }

        public void setCAStr(String value) {
            this.caStr = value;
        }

        public Boolean getDisableMTUDiscovery() {
            return disableMTUDiscovery;
        }

        public void setDisableMTUDiscovery(Boolean value) {
            this.disableMTUDiscovery = value;
        }

        public Boolean getFastOpen() {
            return fastOpen;
        }

        public void setFastOpen(Boolean value) {
            this.fastOpen = value;
        }

        public String getIP() {
            return ip;
        }

        public void setIP(String value) {
            this.ip = value;
        }

        public String getIpv6() {
            return ipv6;
        }

        public void setIpv6(String value) {
            this.ipv6 = value;
        }

        public String getPrivateKey() {
            return privateKey;
        }

        public void setPrivateKey(String value) {
            this.privateKey = value;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public void setPublicKey(String value) {
            this.publicKey = value;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String value) {
            this.token = value;
        }

        public Long getHeartbeatInterval() {
            return heartbeatInterval;
        }

        public void setHeartbeatInterval(Long value) {
            this.heartbeatInterval = value;
        }

        public Boolean getDisableSni() {
            return disableSni;
        }

        public void setDisableSni(Boolean value) {
            this.disableSni = value;
        }

        public Boolean getReduceRtt() {
            return reduceRtt;
        }

        public void setReduceRtt(Boolean value) {
            this.reduceRtt = value;
        }

        public Long getRequestTimeout() {
            return requestTimeout;
        }

        public void setRequestTimeout(Long value) {
            this.requestTimeout = value;
        }

        public String getUDPRelayMode() {
            return udpRelayMode;
        }

        public void setUDPRelayMode(String value) {
            this.udpRelayMode = value;
        }

        public String getCongestionController() {
            return congestionController;
        }

        public void setCongestionController(String value) {
            this.congestionController = value;
        }

        public Long getMaxUDPRelayPacketSize() {
            return maxUDPRelayPacketSize;
        }

        public void setMaxUDPRelayPacketSize(Long value) {
            this.maxUDPRelayPacketSize = value;
        }

        public Long getMaxOpenStreams() {
            return maxOpenStreams;
        }

        public void setMaxOpenStreams(Long value) {
            this.maxOpenStreams = value;
        }

        public String getObfsParam() {
            return obfsParam;
        }

        public void setObfsParam(String value) {
            this.obfsParam = value;
        }

        public String getProtocolParam() {
            return protocolParam;
        }

        public void setProtocolParam(String value) {
            this.protocolParam = value;
        }
    }

    public enum Fingerprint {
        XXXX;

        public String toValue() {
            switch (this) {
                case XXXX:
                    return "xxxx";
            }
            return null;
        }

        public static Fingerprint forValue(String value) throws IOException {
            if (value.equals("xxxx")) return XXXX;
            throw new IOException("Cannot deserialize Fingerprint");
        }
    }

    public class GrpcOpts {
        private Password grpcServiceName;

        public Password getGrpcServiceName() {
            return grpcServiceName;
        }

        public void setGrpcServiceName(Password value) {
            this.grpcServiceName = value;
        }
    }

    public enum Password {
        EXAMPLE,
        PASSWORD,
        YOURPSK;

        public String toValue() {
            switch (this) {
                case EXAMPLE:
                    return "example";
                case PASSWORD:
                    return "password";
                case YOURPSK:
                    return "yourpsk";
            }
            return null;
        }

        public static Password forValue(String value) throws IOException {
            if (value.equals("example")) return EXAMPLE;
            if (value.equals("password")) return PASSWORD;
            if (value.equals("yourpsk")) return YOURPSK;
            throw new IOException("Cannot deserialize Password");
        }
    }

    public class H2Opts {
        private String[] host;
        private String path;

        public String[] getHost() {
            return host;
        }

        public void setHost(String[] value) {
            this.host = value;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String value) {
            this.path = value;
        }
    }

    public class ProxyHeaders {
        private String host;

        public String getHost() {
            return host;
        }

        public void setHost(String value) {
            this.host = value;
        }
    }

    public class HTTPOpts {
        private String method;
        private String[] path;
        private HTTPOptsHeaders headers;

        public String getMethod() {
            return method;
        }

        public void setMethod(String value) {
            this.method = value;
        }

        public String[] getPath() {
            return path;
        }

        public void setPath(String[] value) {
            this.path = value;
        }

        public HTTPOptsHeaders getHeaders() {
            return headers;
        }

        public void setHeaders(HTTPOptsHeaders value) {
            this.headers = value;
        }
    }

    public class HTTPOptsHeaders {
        private String[] connection;

        public String[] getConnection() {
            return connection;
        }

        public void setConnection(String[] value) {
            this.connection = value;
        }
    }

    public class PluginOpts {
        private String mode;
        private String host;
        private Boolean tls;
        private Fingerprint fingerprint;
        private Boolean skipCERTVerify;
        private String path;
        private Boolean mux;
        private PluginOptsHeaders headers;
        private String password;

        public String getMode() {
            return mode;
        }

        public void setMode(String value) {
            this.mode = value;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String value) {
            this.host = value;
        }

        public Boolean getTLS() {
            return tls;
        }

        public void setTLS(Boolean value) {
            this.tls = value;
        }

        public Fingerprint getFingerprint() {
            return fingerprint;
        }

        public void setFingerprint(Fingerprint value) {
            this.fingerprint = value;
        }

        public Boolean getSkipCERTVerify() {
            return skipCERTVerify;
        }

        public void setSkipCERTVerify(Boolean value) {
            this.skipCERTVerify = value;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String value) {
            this.path = value;
        }

        public Boolean getMux() {
            return mux;
        }

        public void setMux(Boolean value) {
            this.mux = value;
        }

        public PluginOptsHeaders getHeaders() {
            return headers;
        }

        public void setHeaders(PluginOptsHeaders value) {
            this.headers = value;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String value) {
            this.password = value;
        }
    }

    public class PluginOptsHeaders {
        private String custom;

        public String getCustom() {
            return custom;
        }

        public void setCustom(String value) {
            this.custom = value;
        }
    }

    public enum Server {
        SERVER,
        SERVER_COM,
        THE_1621591921,
        WWW_EXAMPLE_COM;

        public String toValue() {
            switch (this) {
                case SERVER:
                    return "server";
                case SERVER_COM:
                    return "server.com";
                case THE_1621591921:
                    return "162.159.192.1";
                case WWW_EXAMPLE_COM:
                    return "www.example.com";
            }
            return null;
        }

        public static Server forValue(String value) throws IOException {
            if (value.equals("server")) return SERVER;
            if (value.equals("server.com")) return SERVER_COM;
            if (value.equals("162.159.192.1")) return THE_1621591921;
            if (value.equals("www.example.com")) return WWW_EXAMPLE_COM;
            throw new IOException("Cannot deserialize Server");
        }
    }

    public class TLSUnion {
        public Boolean boolValue;
        public String stringValue;
    }

    public class WsOpts {
        private String path;
        private ProxyHeaders headers;
        private Long maxEarlyData;
        private String earlyDataHeaderName;

        public String getPath() {
            return path;
        }

        public void setPath(String value) {
            this.path = value;
        }

        public ProxyHeaders getHeaders() {
            return headers;
        }

        public void setHeaders(ProxyHeaders value) {
            this.headers = value;
        }

        public Long getMaxEarlyData() {
            return maxEarlyData;
        }

        public void setMaxEarlyData(Long value) {
            this.maxEarlyData = value;
        }

        public String getEarlyDataHeaderName() {
            return earlyDataHeaderName;
        }

        public void setEarlyDataHeaderName(String value) {
            this.earlyDataHeaderName = value;
        }
    }

    public class ProxyGroup {
        private String name;
        private String type;
        private String[] proxies;
        private Long tolerance;
        private Boolean lazy;
        private String url;
        private Long interval;
        private String strategy;
        private Boolean disableUDP;
        private String interfaceName;
        private Long routingMark;
        private String filter;
        private String[] use;

        public String getName() {
            return name;
        }

        public void setName(String value) {
            this.name = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String value) {
            this.type = value;
        }

        public String[] getProxies() {
            return proxies;
        }

        public void setProxies(String[] value) {
            this.proxies = value;
        }

        public Long getTolerance() {
            return tolerance;
        }

        public void setTolerance(Long value) {
            this.tolerance = value;
        }

        public Boolean getLazy() {
            return lazy;
        }

        public void setLazy(Boolean value) {
            this.lazy = value;
        }

        public String getURL() {
            return url;
        }

        public void setURL(String value) {
            this.url = value;
        }

        public Long getInterval() {
            return interval;
        }

        public void setInterval(Long value) {
            this.interval = value;
        }

        public String getStrategy() {
            return strategy;
        }

        public void setStrategy(String value) {
            this.strategy = value;
        }

        public Boolean getDisableUDP() {
            return disableUDP;
        }

        public void setDisableUDP(Boolean value) {
            this.disableUDP = value;
        }

        public String getInterfaceName() {
            return interfaceName;
        }

        public void setInterfaceName(String value) {
            this.interfaceName = value;
        }

        public Long getRoutingMark() {
            return routingMark;
        }

        public void setRoutingMark(Long value) {
            this.routingMark = value;
        }

        public String getFilter() {
            return filter;
        }

        public void setFilter(String value) {
            this.filter = value;
        }

        public String[] getUse() {
            return use;
        }

        public void setUse(String[] value) {
            this.use = value;
        }
    }

    public class ProxyProviders {
        private Provider1 provider1;
        private Test test;

        public Provider1 getProvider1() {
            return provider1;
        }

        public void setProvider1(Provider1 value) {
            this.provider1 = value;
        }

        public Test getTest() {
            return test;
        }

        public void setTest(Test value) {
            this.test = value;
        }
    }

    public class Provider1 {
        private String type;
        private String url;
        private long interval;
        private String path;
        private HealthCheck healthCheck;
        private String behavior;

        public String getType() {
            return type;
        }

        public void setType(String value) {
            this.type = value;
        }

        public String getURL() {
            return url;
        }

        public void setURL(String value) {
            this.url = value;
        }

        public long getInterval() {
            return interval;
        }

        public void setInterval(long value) {
            this.interval = value;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String value) {
            this.path = value;
        }

        public HealthCheck getHealthCheck() {
            return healthCheck;
        }

        public void setHealthCheck(HealthCheck value) {
            this.healthCheck = value;
        }

        public String getBehavior() {
            return behavior;
        }

        public void setBehavior(String value) {
            this.behavior = value;
        }
    }

    public class HealthCheck {
        private boolean enable;
        private long interval;
        private Boolean lazy;
        private String url;

        public boolean getEnable() {
            return enable;
        }

        public void setEnable(boolean value) {
            this.enable = value;
        }

        public long getInterval() {
            return interval;
        }

        public void setInterval(long value) {
            this.interval = value;
        }

        public Boolean getLazy() {
            return lazy;
        }

        public void setLazy(Boolean value) {
            this.lazy = value;
        }

        public String getURL() {
            return url;
        }

        public void setURL(String value) {
            this.url = value;
        }
    }

    public class Test {
        private String type;
        private String path;
        private HealthCheck healthCheck;

        public String getType() {
            return type;
        }

        public void setType(String value) {
            this.type = value;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String value) {
            this.path = value;
        }

        public HealthCheck getHealthCheck() {
            return healthCheck;
        }

        public void setHealthCheck(HealthCheck value) {
            this.healthCheck = value;
        }
    }

    public class RuleProviders {
        private Provider1 rule1;
        private Provider1 rule2;

        public Provider1 getRule1() {
            return rule1;
        }

        public void setRule1(Provider1 value) {
            this.rule1 = value;
        }

        public Provider1 getRule2() {
            return rule2;
        }

        public void setRule2(Provider1 value) {
            this.rule2 = value;
        }
    }

    public class Sniffer {
        private boolean enable;
        private boolean forceDNSMapping;
        private boolean parsePureIP;
        private boolean overrideDestination;
        private Sniff sniff;
        private String[] forceDomain;
        private String[] skipDomain;
        private String[] sniffing;
        private String[] portWhitelist;

        public boolean getEnable() {
            return enable;
        }

        public void setEnable(boolean value) {
            this.enable = value;
        }

        public boolean getForceDNSMapping() {
            return forceDNSMapping;
        }

        public void setForceDNSMapping(boolean value) {
            this.forceDNSMapping = value;
        }

        public boolean getParsePureIP() {
            return parsePureIP;
        }

        public void setParsePureIP(boolean value) {
            this.parsePureIP = value;
        }

        public boolean getOverrideDestination() {
            return overrideDestination;
        }

        public void setOverrideDestination(boolean value) {
            this.overrideDestination = value;
        }

        public Sniff getSniff() {
            return sniff;
        }

        public void setSniff(Sniff value) {
            this.sniff = value;
        }

        public String[] getForceDomain() {
            return forceDomain;
        }

        public void setForceDomain(String[] value) {
            this.forceDomain = value;
        }

        public String[] getSkipDomain() {
            return skipDomain;
        }

        public void setSkipDomain(String[] value) {
            this.skipDomain = value;
        }

        public String[] getSniffing() {
            return sniffing;
        }

        public void setSniffing(String[] value) {
            this.sniffing = value;
        }

        public String[] getPortWhitelist() {
            return portWhitelist;
        }

        public void setPortWhitelist(String[] value) {
            this.portWhitelist = value;
        }
    }

    public class Sniff {
        private TLS tls;
        private HTTP http;

        public TLS getTLS() {
            return tls;
        }

        public void setTLS(TLS value) {
            this.tls = value;
        }

        public HTTP getHTTP() {
            return http;
        }

        public void setHTTP(HTTP value) {
            this.http = value;
        }
    }

    public class HTTP {
        private Port[] ports;
        private boolean overrideDestination;

        public Port[] getPorts() {
            return ports;
        }

        public void setPorts(Port[] value) {
            this.ports = value;
        }

        public boolean getOverrideDestination() {
            return overrideDestination;
        }

        public void setOverrideDestination(boolean value) {
            this.overrideDestination = value;
        }
    }

    public class Port {
        public Long integerValue;
        public String stringValue;
    }

    public class TLS {
        private long[] ports;

        public long[] getPorts() {
            return ports;
        }

        public void setPorts(long[] value) {
            this.ports = value;
        }
    }

    public class SubRules {
        private String[] subRuleName1;
        private String[] subRuleName2;

        public String[] getSubRuleName1() {
            return subRuleName1;
        }

        public void setSubRuleName1(String[] value) {
            this.subRuleName1 = value;
        }

        public String[] getSubRuleName2() {
            return subRuleName2;
        }

        public void setSubRuleName2(String[] value) {
            this.subRuleName2 = value;
        }
    }

    public class TLSClass {
        private String certificate;
        private String privateKey;
        private CustomCertificate[] customCertificates;

        public String getCertificate() {
            return certificate;
        }

        public void setCertificate(String value) {
            this.certificate = value;
        }

        public String getPrivateKey() {
            return privateKey;
        }

        public void setPrivateKey(String value) {
            this.privateKey = value;
        }

        public CustomCertificate[] getCustomCertificates() {
            return customCertificates;
        }

        public void setCustomCertificates(CustomCertificate[] value) {
            this.customCertificates = value;
        }
    }

    public class CustomCertificate {
        private String certificate;
        private String privateKey;

        public String getCertificate() {
            return certificate;
        }

        public void setCertificate(String value) {
            this.certificate = value;
        }

        public String getPrivateKey() {
            return privateKey;
        }

        public void setPrivateKey(String value) {
            this.privateKey = value;
        }
    }

    public class Tun {
        private boolean enable;
        private String stack;
        private String[] dnsHijack;
        private boolean autoDetectInterface;
        private boolean autoRoute;
        private long mtu;
        private boolean strictRoute;
        private String[] inet4RouteAddress;
        private String[] inet6RouteAddress;
        private boolean endpointIndependentNat;
        private long[] includeUid;
        private String[] includeUidRange;
        private long[] excludeUid;
        private String[] excludeUidRange;
        private long[] includeAndroidUser;
        private String[] includePackage;
        private String[] excludePackage;

        public boolean getEnable() {
            return enable;
        }

        public void setEnable(boolean value) {
            this.enable = value;
        }

        public String getStack() {
            return stack;
        }

        public void setStack(String value) {
            this.stack = value;
        }

        public String[] getDNSHijack() {
            return dnsHijack;
        }

        public void setDNSHijack(String[] value) {
            this.dnsHijack = value;
        }

        public boolean getAutoDetectInterface() {
            return autoDetectInterface;
        }

        public void setAutoDetectInterface(boolean value) {
            this.autoDetectInterface = value;
        }

        public boolean getAutoRoute() {
            return autoRoute;
        }

        public void setAutoRoute(boolean value) {
            this.autoRoute = value;
        }

        public long getMTU() {
            return mtu;
        }

        public void setMTU(long value) {
            this.mtu = value;
        }

        public boolean getStrictRoute() {
            return strictRoute;
        }

        public void setStrictRoute(boolean value) {
            this.strictRoute = value;
        }

        public String[] getInet4RouteAddress() {
            return inet4RouteAddress;
        }

        public void setInet4RouteAddress(String[] value) {
            this.inet4RouteAddress = value;
        }

        public String[] getInet6RouteAddress() {
            return inet6RouteAddress;
        }

        public void setInet6RouteAddress(String[] value) {
            this.inet6RouteAddress = value;
        }

        public boolean getEndpointIndependentNat() {
            return endpointIndependentNat;
        }

        public void setEndpointIndependentNat(boolean value) {
            this.endpointIndependentNat = value;
        }

        public long[] getIncludeUid() {
            return includeUid;
        }

        public void setIncludeUid(long[] value) {
            this.includeUid = value;
        }

        public String[] getIncludeUidRange() {
            return includeUidRange;
        }

        public void setIncludeUidRange(String[] value) {
            this.includeUidRange = value;
        }

        public long[] getExcludeUid() {
            return excludeUid;
        }

        public void setExcludeUid(long[] value) {
            this.excludeUid = value;
        }

        public String[] getExcludeUidRange() {
            return excludeUidRange;
        }

        public void setExcludeUidRange(String[] value) {
            this.excludeUidRange = value;
        }

        public long[] getIncludeAndroidUser() {
            return includeAndroidUser;
        }

        public void setIncludeAndroidUser(long[] value) {
            this.includeAndroidUser = value;
        }

        public String[] getIncludePackage() {
            return includePackage;
        }

        public void setIncludePackage(String[] value) {
            this.includePackage = value;
        }

        public String[] getExcludePackage() {
            return excludePackage;
        }

        public void setExcludePackage(String[] value) {
            this.excludePackage = value;
        }
    }

    public class TunnelElement {
        public TunnelClass tunnelClassValue;
        public String stringValue;
    }

    public class TunnelClass {
        private String[] network;
        private String address;
        private String target;
        private String proxy;

        public String[] getNetwork() {
            return network;
        }

        public void setNetwork(String[] value) {
            this.network = value;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String value) {
            this.address = value;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String value) {
            this.target = value;
        }

        public String getProxy() {
            return proxy;
        }

        public void setProxy(String value) {
            this.proxy = value;
        }
    }
}
