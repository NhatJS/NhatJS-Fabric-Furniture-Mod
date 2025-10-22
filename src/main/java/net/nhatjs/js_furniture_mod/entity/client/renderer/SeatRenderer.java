package net.nhatjs.js_furniture_mod.entity.client.renderer;

import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.entity.client.SeatBlockEntity;

public class SeatRenderer extends EntityRenderer<SeatBlockEntity> {
    public SeatRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Override
    public Identifier getTexture(SeatBlockEntity entity) {
        return null;
    }

    @Override
    public boolean shouldRender(SeatBlockEntity entity, Frustum frustum, double x, double y, double z) {
        return true;
    }
}