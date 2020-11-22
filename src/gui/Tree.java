package gui;

public enum Tree {
    WILLOW;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
