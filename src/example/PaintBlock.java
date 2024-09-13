/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example;

/**
 *
 * @author Artemik
 */
import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.util.io.Reads;
import arc.util.io.Writes;
import mindustry.gen.Building;
import mindustry.world.Block;

public class PaintBlock extends Block {

    TextureRegion paintTexture;

    public PaintBlock(String name) {
        super(name);
    }

    @Override
    public void load() {
        super.load();
        paintTexture = Core.atlas.find("example-java-mod-frog");  // Load custom texture
    }

    // Custom Building class to handle entity behavior
    public class PaintBlockEntity extends Building {

        boolean isPainted = false;

        @Override
        public void draw() {
            super.draw();
            if (isPainted && paintTexture != null) {
                // Draw custom texture on top of the block
                Draw.rect(paintTexture, tile.drawx(), tile.drawy());
            }
        }

        @Override
        public void write(Writes write) {
            super.write(write);
            // Save the painted state
            write.bool(isPainted);
        }

        @Override
        public void read(Reads read, byte revision) {
            super.read(read, revision);
            // Load the painted state
            isPainted = read.bool();
        }

        public void paintBlock() {
            // Function to paint the block
            isPainted = true;
        }
    }
}