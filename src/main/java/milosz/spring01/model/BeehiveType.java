package milosz.spring01.model;

public enum BeehiveType {

    WOOD("WOOD"),
    POLYURETHAN("POLYURETHAN");

    private final String name;

    public static final BeehiveType[] ALL = { POLYURETHAN, WOOD };

    private BeehiveType(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
