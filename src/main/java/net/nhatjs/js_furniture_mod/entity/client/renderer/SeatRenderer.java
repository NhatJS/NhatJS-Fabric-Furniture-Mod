package net.nhatjs.js_furniture_mod.entity.client.renderer;

import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.nhatjs.js_furniture_mod.entity.client.SeatBlockEntity;

public class SeatRenderer extends EntityRenderer<SeatBlockEntity, EntityRenderState> {
    public SeatRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

    @Override
    public boolean shouldRender(SeatBlockEntity entity, Frustum frustum, double x, double y, double z) {
        return true;
    }
}