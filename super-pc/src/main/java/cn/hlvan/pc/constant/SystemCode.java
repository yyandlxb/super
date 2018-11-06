package cn.hlvan.pc.constant;

public enum SystemCode {
    SSO_AUTH("认证授权"),
    COLLECTION("代收款");

    private String name;

    SystemCode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class System{
        public static final String SSO_AUTH = "SSO_AUTH";
        public static final String COLLECTION = "COLLECTION";
    }
}
