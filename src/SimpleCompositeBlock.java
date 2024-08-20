import java.util.List;

public class SimpleCompositeBlock implements CompositeBlock {

    public List<Block> blocks;

    public SimpleCompositeBlock(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }

    @Override
    public String getColor() {
        return null;
    }

    @Override
    public String getMaterial() {
        return null;
    }

}
