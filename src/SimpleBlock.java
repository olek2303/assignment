public class SimpleBlock implements Block {
    private String material;
    private String color;

    public SimpleBlock(String material, String color) {
        this.material = material;
        this.color = color;
    }

    @Override
    public String toString() {
        return "block: " + material + " " + color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
