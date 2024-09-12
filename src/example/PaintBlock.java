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
import arc.graphics.g2d.TextureRegion;
import arc.graphics.g2d.Draw;
import mindustry.world.Block;
import mindustry.world.meta.BlockGroup;

public class PaintBlock extends Block {

    // Load the custom texture from the atlas
    TextureRegion paintTexture;

    public PaintBlock(String name) {
        super(name);
        group = BlockGroup.production; // Change the block group as needed
        update = true; // To ensure it updates regularly
    }

    @Override
    public void load() {
        super.load();
        // Load the custom texture from the atlas
        paintTexture = Core.atlas.find("example-java-mod-frog");
    }

    @Override
    public void draw() {
        super.draw();
        // Draw the block's default texture
        Draw.rect(region, x, y);

        // Draw the custom "painted" texture on top
        if (paintTexture != null) {
            Draw.rect(paintTexture, x, y);
        }
    }
}

