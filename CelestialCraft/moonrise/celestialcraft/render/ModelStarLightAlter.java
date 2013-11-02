// Date: 2013-11-02 �ㅽ썑 7:19:12
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package moonrise.celestialcraft.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class ModelStarLightAlter extends ModelBase
{
  //fields
    ModelRenderer base1;
    ModelRenderer base2;
    ModelRenderer base3;
    ModelRenderer pole1;
    ModelRenderer pole2;
    ModelRenderer pole3;
    ModelRenderer pole4;
    ModelRenderer float1;
    ModelRenderer float2;
    ModelRenderer float3;
    ModelRenderer float4;
    ModelRenderer float5;
    ModelRenderer float6;
    ModelRenderer float7;
    ModelRenderer float8;
    ModelRenderer float9;
    ModelRenderer float10;
    ModelRenderer float11;
    ModelRenderer float12;
    ModelRenderer floatcore;
  
  public ModelStarLightAlter()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      base1 = new ModelRenderer(this, 0, 0);
      base1.addBox(0F, -1F, 0F, 16, 2, 16);
      base1.setRotationPoint(0F, 0F, 0F);
      base1.setTextureSize(32, 32);
      base1.mirror = true;
      setRotation(base1, 0F, 0F, 0F);
      base2 = new ModelRenderer(this, 0, 0);
      base2.addBox(0F, 0F, 0F, 12, 1, 12);
      base2.setRotationPoint(2F, -2F, 2F);
      base2.setTextureSize(32, 32);
      base2.mirror = true;
      setRotation(base2, 0F, 0F, 0F);
      base3 = new ModelRenderer(this, 0, 0);
      base3.addBox(-4F, 0F, -4F, 8, 1, 8);
      base3.setRotationPoint(8F, -3F, 8F);
      base3.setTextureSize(32, 32);
      base3.mirror = true;
      setRotation(base3, 0F, 0.7853982F, 0F);
      pole1 = new ModelRenderer(this, 0, 0);
      pole1.addBox(1F, -12F, 1F, 1, 11, 1);
      pole1.setRotationPoint(0F, 0F, 0F);
      pole1.setTextureSize(32, 32);
      pole1.mirror = true;
      setRotation(pole1, 0F, 0F, 0F);
      pole2 = new ModelRenderer(this, 0, 0);
      pole2.addBox(14F, -12F, 14F, 1, 11, 1);
      pole2.setRotationPoint(0F, 0F, 0F);
      pole2.setTextureSize(32, 32);
      pole2.mirror = true;
      setRotation(pole2, 0F, 0F, 0F);
      pole3 = new ModelRenderer(this, 0, 0);
      pole3.addBox(1F, -12F, 14F, 1, 11, 1);
      pole3.setRotationPoint(0F, 0F, 0F);
      pole3.setTextureSize(32, 32);
      pole3.mirror = true;
      setRotation(pole3, 0F, 0F, 0F);
      pole4 = new ModelRenderer(this, 0, 0);
      pole4.addBox(14F, -12F, 1F, 1, 11, 1);
      pole4.setRotationPoint(0F, 0F, 0F);
      pole4.setTextureSize(32, 32);
      pole4.mirror = true;
      setRotation(pole4, 0F, 0F, 0F);
      float1 = new ModelRenderer(this, 0, 0);
      float1.addBox(-3.5F, -3.5F, -3.5F, 7, 1, 1);
      float1.setRotationPoint(8F, -10F, 8F);
      float1.setTextureSize(32, 32);
      float1.mirror = true;
      setRotation(float1, 0.8028515F, 0.9773844F, 0.6108652F);
      float2 = new ModelRenderer(this, 0, 0);
      float2.addBox(-3.5F, 2.5F, 2.5F, 7, 1, 1);
      float2.setRotationPoint(8F, -10F, 8F);
      float2.setTextureSize(32, 32);
      float2.mirror = true;
      setRotation(float2, 0.8028515F, 0.9773844F, 0.6108652F);
      float3 = new ModelRenderer(this, 0, 0);
      float3.addBox(-3.5F, 2.5F, -3.5F, 7, 1, 1);
      float3.setRotationPoint(8F, -10F, 8F);
      float3.setTextureSize(32, 32);
      float3.mirror = true;
      setRotation(float3, 0.8028515F, 0.9773844F, 0.6108652F);
      float4 = new ModelRenderer(this, 0, 0);
      float4.addBox(-3.5F, -3.5F, 2.5F, 7, 1, 1);
      float4.setRotationPoint(8F, -10F, 8F);
      float4.setTextureSize(32, 32);
      float4.mirror = true;
      setRotation(float4, 0.8028515F, 0.9773844F, 0.6108652F);
      float5 = new ModelRenderer(this, 0, 0);
      float5.addBox(-3.5F, -3.5F, -3.5F, 1, 7, 1);
      float5.setRotationPoint(8F, -10F, 8F);
      float5.setTextureSize(32, 32);
      float5.mirror = true;
      setRotation(float5, 0.8028515F, 0.9773844F, 0.6108652F);
      float6 = new ModelRenderer(this, 0, 0);
      float6.addBox(-3.5F, -3.5F, 2.5F, 1, 7, 1);
      float6.setRotationPoint(8F, -10F, 8F);
      float6.setTextureSize(32, 32);
      float6.mirror = true;
      setRotation(float6, 0.8028515F, 0.9773844F, 0.6108652F);
      float7 = new ModelRenderer(this, 0, 0);
      float7.addBox(2.5F, -3.5F, -3.5F, 1, 7, 1);
      float7.setRotationPoint(8F, -10F, 8F);
      float7.setTextureSize(32, 32);
      float7.mirror = true;
      setRotation(float7, 0.8028515F, 0.9773844F, 0.6108652F);
      float8 = new ModelRenderer(this, 0, 0);
      float8.addBox(2.5F, -3.5F, 2.5F, 1, 7, 1);
      float8.setRotationPoint(8F, -10F, 8F);
      float8.setTextureSize(32, 32);
      float8.mirror = true;
      setRotation(float8, 0.8028515F, 0.9773844F, 0.6108652F);
      float9 = new ModelRenderer(this, 0, 0);
      float9.addBox(-3.5F, -3.5F, -3.5F, 1, 1, 7);
      float9.setRotationPoint(8F, -10F, 8F);
      float9.setTextureSize(32, 32);
      float9.mirror = true;
      setRotation(float9, 0.8028515F, 0.9773844F, 0.6108652F);
      float10 = new ModelRenderer(this, 0, 0);
      float10.addBox(2.5F, -3.5F, -3.5F, 1, 1, 7);
      float10.setRotationPoint(8F, -10F, 8F);
      float10.setTextureSize(32, 32);
      float10.mirror = true;
      setRotation(float10, 0.8028515F, 0.9773844F, 0.6108652F);
      float11 = new ModelRenderer(this, 0, 0);
      float11.addBox(-3.5F, 2.5F, -3.5F, 1, 1, 7);
      float11.setRotationPoint(8F, -10F, 8F);
      float11.setTextureSize(32, 32);
      float11.mirror = true;
      setRotation(float11, 0.8028515F, 0.9773844F, 0.6108652F);
      float12 = new ModelRenderer(this, 0, 0);
      float12.addBox(2.5F, 2.5F, -3.5F, 1, 1, 7);
      float12.setRotationPoint(8F, -10F, 8F);
      float12.setTextureSize(32, 32);
      float12.mirror = true;
      setRotation(float12, 0.8028515F, 0.9773844F, 0.6108652F);
      floatcore = new ModelRenderer(this, 0, 0);
      floatcore.addBox(-1F, -1F, -1F, 2, 2, 2);
      floatcore.setRotationPoint(8F, -10F, 8F);
      floatcore.setTextureSize(32, 32);
      floatcore.mirror = true;
      setRotation(floatcore, 0F, 0F, 0F);
  }
  
  public void render(float f5)
  {
    base1.render(f5);
    base2.render(f5);
    base3.render(f5);
    pole1.render(f5);
    pole2.render(f5);
    pole3.render(f5);
    pole4.render(f5);
    float1.render(f5);
    float2.render(f5);
    float3.render(f5);
    float4.render(f5);
    float5.render(f5);
    float6.render(f5);
    float7.render(f5);
    float8.render(f5);
    float9.render(f5);
    float10.render(f5);
    float11.render(f5);
    float12.render(f5);
    floatcore.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}