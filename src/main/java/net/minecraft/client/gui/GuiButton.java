package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiButton extends Gui
{
    protected static final ResourceLocation BUTTON_TEXTURES = new ResourceLocation("textures/gui/widgets.png");
    protected int width;
    protected int height;
    public int x;
    public int y;

    /** The string displayed on this control. */
    public String displayString;
    public int id;
    public boolean enabled;
    public boolean field_146125_m;
    protected boolean field_146123_n;
    private static final String __OBFID = "CL_00000668";

    public GuiButton(int id, int x, int y, String displayString)
    {
        this(id, x, y, 200, 20, displayString);
    }

    public GuiButton(int id, int x, int y, int width, int height, String displayString)
    {
        this.enabled = true;
        this.field_146125_m = true;
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.displayString = displayString;
    }

    public int getHoverState(boolean p_146114_1_)
    {
        byte var2 = 1;

        if (!this.enabled)
        {
            var2 = 0;
        }
        else if (p_146114_1_)
        {
            var2 = 2;
        }

        return var2;
    }

    /**
     * Draws this button to the screen.
     */
    public void drawButton(Minecraft mc, int MouseX, int MouseY)
    {
        if (this.field_146125_m)
        {
            FontRenderer var4 = mc.fontRenderer;
            mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_146123_n = MouseX >= this.x && MouseY >= this.y && MouseX < this.x + this.width && MouseY < this.y + this.height;
            int var5 = this.getHoverState(this.field_146123_n);
            GL11.glEnable(GL11.GL_BLEND);
            OpenGlHelper.glBlendFunc(770, 771, 1, 0);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            this.drawTexturedModalRect(this.x, this.y, 0, 46 + var5 * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + var5 * 20, this.width / 2, this.height);
            this.mouseDragged(mc, MouseX, MouseY);
            int var6 = 14737632;

            if (!this.enabled)
            {
                var6 = 10526880;
            }
            else if (this.field_146123_n)
            {
                var6 = 16777120;
            }

            this.drawCenteredString(var4, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, var6);
        }
    }

    /**
     * Fired when the mouse button is dragged. Equivalent of MouseListener.mouseDragged(MouseEvent e).
     */
    protected void mouseDragged(Minecraft p_146119_1_, int p_146119_2_, int p_146119_3_) {}

    /**
     * Fired when the mouse button is released. Equivalent of MouseListener.mouseReleased(MouseEvent e).
     */
    public void mouseReleased(int p_146118_1_, int p_146118_2_) {}

    /**
     * Returns true if the mouse has been pressed on this control. Equivalent of MouseListener.mousePressed(MouseEvent
     * e).
     */
    public boolean mousePressed(Minecraft p_146116_1_, int p_146116_2_, int p_146116_3_)
    {
        return this.enabled && this.field_146125_m && p_146116_2_ >= this.x && p_146116_3_ >= this.y && p_146116_2_ < this.x + this.width && p_146116_3_ < this.y + this.height;
    }

    public boolean func_146115_a()
    {
        return this.field_146123_n;
    }

    public void func_146111_b(int p_146111_1_, int p_146111_2_) {}

    public void func_146113_a(SoundHandler soundHandler)
    {
        soundHandler.playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1.0F));
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
    }
}
