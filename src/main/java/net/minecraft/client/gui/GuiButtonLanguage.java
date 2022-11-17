package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class GuiButtonLanguage extends GuiButton
{
    private static final String __OBFID = "CL_00000672";

    public GuiButtonLanguage(int p_i1041_1_, int p_i1041_2_, int p_i1041_3_)
    {
        super(p_i1041_1_, p_i1041_2_, p_i1041_3_, 20, 20, "");
    }

    /**
     * Draws this button to the screen.
     */
    public void drawButton(Minecraft mc, int MouseX, int MouseY)
    {
        if (this.field_146125_m)
        {
            mc.getTextureManager().bindTexture(GuiButton.BUTTON_TEXTURES);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            boolean var4 = MouseX >= this.x && MouseY >= this.y && MouseX < this.x + this.width && MouseY < this.y + this.height;
            int var5 = 106;

            if (var4)
            {
                var5 += this.height;
            }

            this.drawTexturedModalRect(this.x, this.y, 0, var5, this.width, this.height);
        }
    }
}
