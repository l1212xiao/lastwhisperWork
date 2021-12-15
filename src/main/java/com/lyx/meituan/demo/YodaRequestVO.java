package com.lyx.meituan.demo;

import com.lyx.utils.FastJsonUtils;

/**
 * @author lvyunxiao
 * @date 2021/11/25
 * @description yoda接入请求参数业务模型
 */
public class YodaRequestVO {

    /**
     * 可选验证方式的集合，例如短信验证
     **/
    private Integer id;

    /**
     * 用户uuid
     **/
    private String uuid;

    /**
     * 用户ip
     **/
    private String ip;

    /**
     * user agent信息
     **/
    private String ua;

    /**
     * 业务方ID
     **/
    private Integer partner;

    /**
     * 平台号ID
     **/
    private Integer platform;

    /**
     * 移动端的版本
     **/
    private String version;

    /**
     * 客户端类型
     **/
    private Integer app;

    /**
     * 账号体系
     **/
    private Integer accountSystem;

    /**
     * C端，用户账号id
     **/
    private Long user;

    /**
     * 需要验证的手机号
     **/
    private String mobile;

    /**
     * 用户输入的短信验证码
     **/
    private String smscode;

    /**
     * 是否支持yoda滑块模块，影响人机识别策略，true表示支持。此为true
     **/
    private Boolean moduleEnable;

    /**
     * 在短信平台申请的短信模板编号，模板要求必须预留code和action两个同名参数位
     **/
    private Integer smsTypeId;

    /**
     * 短信模板中其余的业务信息参数，格式为json map，key与字段参数名保持一致。
     **/
    private String smsContentPair;

    /**
     * 国际通道时使用
     **/
    private String mobileInterCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUa() {
        return ua;
    }

    public void setUa(String ua) {
        this.ua = ua;
    }

    public Integer getPartner() {
        return partner;
    }

    public void setPartner(Integer partner) {
        this.partner = partner;
    }

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getApp() {
        return app;
    }

    public void setApp(Integer app) {
        this.app = app;
    }

    public Integer getAccountSystem() {
        return accountSystem;
    }

    public void setAccountSystem(Integer accountSystem) {
        this.accountSystem = accountSystem;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmscode() {
        return smscode;
    }

    public void setSmscode(String smscode) {
        this.smscode = smscode;
    }

    public Boolean getModuleEnable() {
        return moduleEnable;
    }

    public void setModuleEnable(Boolean moduleEnable) {
        this.moduleEnable = moduleEnable;
    }

    public Integer getSmsTypeId() {
        return smsTypeId;
    }

    public void setSmsTypeId(Integer smsTypeId) {
        this.smsTypeId = smsTypeId;
    }

    public String getSmsContentPair() {
        return smsContentPair;
    }

    public void setSmsContentPair(String smsContentPair) {
        this.smsContentPair = smsContentPair;
    }

    public String getMobileInterCode() {
        return mobileInterCode;
    }

    public void setMobileInterCode(String mobileInterCode) {
        this.mobileInterCode = mobileInterCode;
    }

    @Override
    public String toString() {
        return "YodaRequestVO{" +
            "id=" + id +
            ", uuid='" + uuid + '\'' +
            ", ip='" + ip + '\'' +
            ", ua='" + ua + '\'' +
            ", partner=" + partner +
            ", platform=" + platform +
            ", version='" + version + '\'' +
            ", app=" + app +
            ", accountSystem=" + accountSystem +
            ", user=" + user +
            ", mobile='" + mobile + '\'' +
            ", smscode='" + smscode + '\'' +
            ", moduleEnable=" + moduleEnable +
            ", smsTypeId=" + smsTypeId +
            ", smsContentPair='" + smsContentPair + '\'' +
            ", mobileInterCode='" + mobileInterCode + '\'' +
            '}';
    }


    public static final class YodaRequestVOBuilder {

        private Integer id;
        private String uuid;
        private String ip;
        private String ua;
        private Integer partner;
        private Integer platform;
        private String version;
        private Integer app;
        private Integer accountSystem;
        private Long user;
        private String mobile;
        private String smscode;
        private Boolean moduleEnable;
        private Integer smsTypeId;
        private String smsContentPair;
        private String mobileInterCode;

        private YodaRequestVOBuilder() {
        }

        public static YodaRequestVOBuilder anYodaRequestVO() {
            return new YodaRequestVOBuilder();
        }

        public YodaRequestVOBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public YodaRequestVOBuilder uuid(String uuid) {
            this.uuid = uuid;
            return this;
        }

        public YodaRequestVOBuilder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public YodaRequestVOBuilder ua(String ua) {
            this.ua = ua;
            return this;
        }

        public YodaRequestVOBuilder partner(Integer partner) {
            this.partner = partner;
            return this;
        }

        public YodaRequestVOBuilder platform(Integer platform) {
            this.platform = platform;
            return this;
        }

        public YodaRequestVOBuilder version(String version) {
            this.version = version;
            return this;
        }

        public YodaRequestVOBuilder app(Integer app) {
            this.app = app;
            return this;
        }

        public YodaRequestVOBuilder accountSystem(Integer accountSystem) {
            this.accountSystem = accountSystem;
            return this;
        }

        public YodaRequestVOBuilder user(Long user) {
            this.user = user;
            return this;
        }

        public YodaRequestVOBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public YodaRequestVOBuilder smscode(String smscode) {
            this.smscode = smscode;
            return this;
        }

        public YodaRequestVOBuilder moduleEnable(Boolean moduleEnable) {
            this.moduleEnable = moduleEnable;
            return this;
        }

        public YodaRequestVOBuilder smsTypeId(Integer smsTypeId) {
            this.smsTypeId = smsTypeId;
            return this;
        }

        public YodaRequestVOBuilder smsContentPair(String smsContentPair) {
            this.smsContentPair = smsContentPair;
            return this;
        }

        public YodaRequestVOBuilder mobileInterCode(String mobileInterCode) {
            this.mobileInterCode = mobileInterCode;
            return this;
        }

        public YodaRequestVO build() {
            YodaRequestVO yodaRequestVO = new YodaRequestVO();
            yodaRequestVO.setId(id);
            yodaRequestVO.setUuid(uuid);
            yodaRequestVO.setIp(ip);
            yodaRequestVO.setUa(ua);
            yodaRequestVO.setPartner(partner);
            yodaRequestVO.setPlatform(platform);
            yodaRequestVO.setVersion(version);
            yodaRequestVO.setApp(app);
            yodaRequestVO.setAccountSystem(accountSystem);
            yodaRequestVO.setUser(user);
            yodaRequestVO.setMobile(mobile);
            yodaRequestVO.setSmscode(smscode);
            yodaRequestVO.setModuleEnable(moduleEnable);
            yodaRequestVO.setSmsTypeId(smsTypeId);
            yodaRequestVO.setSmsContentPair(smsContentPair);
            yodaRequestVO.setMobileInterCode(mobileInterCode);
            return yodaRequestVO;
        }
    }

    public static void main(String[] args) {
        final YodaRequestVO vo = YodaRequestVOBuilder.anYodaRequestVO()
            .id(4)
            .partner(426)
            .platform(1)
            .accountSystem(2)
            .moduleEnable(true)
            .smsTypeId(121147)
            .smsContentPair("{\"type\":\"买赔确认\"}")
            .build();
        System.out.println(FastJsonUtils.toJSONStr(vo));
    }
}
