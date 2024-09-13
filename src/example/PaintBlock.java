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
import mindustry.gen.Building;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.type.Category;

public class PaintBlock extends GenericCrafter {

    TextureRegion paintTexture;

    public PaintBlock(String name) {
        super(name);
        category = Category.crafting;
    }

    @Override
    public void load() {
        super.load();
        paintTexture = Core.atlas.find("example-java-mod-frog");
    }

    @Override
    public void init() {
        super.init();
        buildType = () -> new Building() {
            @Override
            public void draw() {
                super.draw();
                if (paintTexture != null) {
                    Draw.rect(paintTexture, tile.drawx(), tile.drawy());
                }
            }
        };
    }
}
