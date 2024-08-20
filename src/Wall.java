import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {

        List<Block> result = new ArrayList<>();
        findBlockByMaterialRecursive(blocks, material, result);
        return result;

    }

    private void findBlockByMaterialRecursive(List<Block> blocks, String material, List<Block> result) {

        for (Block block : blocks) {
            // Check if our block is a CompositeBlock
            // If it is we need to check new List<Block>
            if (block instanceof CompositeBlock) {
                findBlockByMaterialRecursive(((CompositeBlock) block).getBlocks(), material, result);
            }
            String blockMaterial = block.getMaterial();
            if (blockMaterial != null && blockMaterial.equals(material)) {
                result.add(block);
            }
        }

    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return findBlockByColorRecursive(blocks, color);
    }

    private Optional<Block> findBlockByColorRecursive(List<Block> blocks, String color) {

        for(Block block : blocks) {
            if (block instanceof CompositeBlock) {
                Optional<Block> result = findBlockByColorRecursive(((CompositeBlock) block).getBlocks(), color);
                if (result.isPresent()) {
                    return result;
                }
            }
            String blockColor = block.getColor();
            if (blockColor != null && blockColor.equals(color)) {
                return Optional.of(block);
            }
        }

        return Optional.empty();

    }

    @Override
    public int count() {
        return countRecursive(blocks);
    }

    private int countRecursive(List<Block> blocks) {

        int count = 0;
        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                count += countRecursive(((CompositeBlock) block).getBlocks());
            } else {
                count++;
            }
        }

        return count;

    }
}
