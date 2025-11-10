import java.util.Objects;

public class Product implements Comparable<Product> {

    private final String name;
    private final String category;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("{name=%s, category=%s}", name, category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof Product)) return false;
        Product otherProduct = (Product) other;
        return Objects.equals(this.name, otherProduct.name)
                && Objects.equals(this.category, otherProduct.category);
    }

    @Override
    public int compareTo(Product o) {
        if (o == null) throw new NullPointerException("Cannot compare to null");
        int compareName = this.name.compareTo(o.name);
        if (compareName != 0) return compareName;
        return this.category.compareTo(o.category);
    }
}
