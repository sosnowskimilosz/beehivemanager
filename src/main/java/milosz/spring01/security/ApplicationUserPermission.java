package milosz.spring01.security;

public enum ApplicationUserPermission {
    BEEHIVE_READ("beehive:read"),
    BEEHIVE_WRITE("beehive:write"),
    USER_READ("user:read");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
