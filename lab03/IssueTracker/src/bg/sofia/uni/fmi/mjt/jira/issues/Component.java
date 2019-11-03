package bg.sofia.uni.fmi.mjt.jira.issues;

import org.jetbrains.annotations.Contract;

public class Component {
    private String name;
    private String shortName;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Contract(pure = true)
    public Component() {}

    @Contract(pure = true)
    public Component(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Component)) {
            return false;
        }

        Component c = (Component) o;
        return c.getName() == ((Component) o).getName() && c.getShortName() == ((Component) o).getShortName();
    }
}
