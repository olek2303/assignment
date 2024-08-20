import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Main {
    public static void main(String[] args) {

        Block block1 = new SimpleBlock("plastic", "blue");
        Block block2 = new SimpleBlock("plastic", "red");
        Block block3 = new SimpleBlock("wood", "brown");
        Block block4 = new SimpleBlock("wood", "white");

        List<Block> compositeBlocks = new ArrayList<>();
        compositeBlocks.add(block1);
        compositeBlocks.add(block2);
        CompositeBlock compositeBlock = new SimpleCompositeBlock(compositeBlocks);

        List<Block> wallBlocks = new ArrayList<>();
        wallBlocks.add(compositeBlock);
        wallBlocks.add(block3);
        wallBlocks.add(block4);


        Wall wall = new Wall(wallBlocks);

        System.out.println("This wall has " + wall.count() + " blocks");
        List<Block> plasticBlocks = wall.findBlocksByMaterial("plastic");
        System.out.println("Plastic blocks: " + plasticBlocks);

        Optional<Block> blueBlock = wall.findBlockByColor("blue");
        blueBlock.ifPresent(block -> System.out.println("Found blue block: " + block));




    }
}