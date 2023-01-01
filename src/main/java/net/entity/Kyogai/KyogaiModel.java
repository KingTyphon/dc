package net.entity.Kyogai;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class KyogaiModel extends ModelBase {
    private final ModelRenderer Head;
    private final ModelRenderer Body;
    private final ModelRenderer tambourine_body;
    private final ModelRenderer tambourine_r1;
    private final ModelRenderer tambourine_r2;
    private final ModelRenderer tambourine_r3;
    private final ModelRenderer tambourine_r4;
    private final ModelRenderer tambourine_r5;
    private final ModelRenderer tambourine_r6;
    private final ModelRenderer tambourine_r7;
    private final ModelRenderer tambourine_r8;
    private final ModelRenderer tambourine_body2;
    private final ModelRenderer tambourine_r9;
    private final ModelRenderer tambourine_r10;
    private final ModelRenderer tambourine_r11;
    private final ModelRenderer tambourine_r12;
    private final ModelRenderer tambourine_r13;
    private final ModelRenderer tambourine_r14;
    private final ModelRenderer tambourine_r15;
    private final ModelRenderer tambourine_r16;
    private final ModelRenderer tambourine_r17;
    private final ModelRenderer RightArm;
    private final ModelRenderer tambourine_right_arm;
    private final ModelRenderer tambourine_r18;
    private final ModelRenderer tambourine_r19;
    private final ModelRenderer tambourine_r20;
    private final ModelRenderer tambourine_r21;
    private final ModelRenderer tambourine_r22;
    private final ModelRenderer tambourine_r23;
    private final ModelRenderer tambourine_r24;
    private final ModelRenderer tambourine_r25;
    private final ModelRenderer LeftArm;
    private final ModelRenderer tambourine_left_arm;
    private final ModelRenderer tambourine_left_arm_r1;
    private final ModelRenderer tambourine_left_arm_r2;
    private final ModelRenderer tambourine_left_arm_r3;
    private final ModelRenderer tambourine_left_arm_r4;
    private final ModelRenderer tambourine_left_arm_r5;
    private final ModelRenderer tambourine_left_arm_r6;
    private final ModelRenderer tambourine_left_arm_r7;
    private final ModelRenderer tambourine_left_arm_r8;
    private final ModelRenderer RightLeg;
    private final ModelRenderer tambourine_right_leg;
    private final ModelRenderer tambourine_r26;
    private final ModelRenderer tambourine_r27;
    private final ModelRenderer tambourine_r28;
    private final ModelRenderer tambourine_r29;
    private final ModelRenderer tambourine_r30;
    private final ModelRenderer tambourine_r31;
    private final ModelRenderer tambourine_r32;
    private final ModelRenderer tambourine_r33;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer tambourine_left_leg;
    private final ModelRenderer tambourine_r34;
    private final ModelRenderer tambourine_r35;
    private final ModelRenderer tambourine_r36;
    private final ModelRenderer tambourine_r37;
    private final ModelRenderer tambourine_r38;
    private final ModelRenderer tambourine_r39;
    private final ModelRenderer tambourine_r40;
    private final ModelRenderer tambourine_r41;

    public KyogaiModel() {
        textureWidth = 128;
        textureHeight = 128;

        Head = new ModelRenderer(this);
        Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        Head.cubeList.add(new ModelBox(Head, 0, 16, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));
        Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F, false));

        Body = new ModelRenderer(this);
        Body.setRotationPoint(0.0F, 24.0F, 0.0F);
        Body.cubeList.add(new ModelBox(Body, 0, 32, -4.0F, -24.0F, -2.0F, 8, 12, 4, 0.0F, false));
        Body.cubeList.add(new ModelBox(Body, 28, 28, -4.0F, -24.0F, -2.0F, 8, 12, 4, 0.25F, false));

        tambourine_body = new ModelRenderer(this);
        tambourine_body.setRotationPoint(0.2222F, -17.3444F, -4.1379F);
        Body.addChild(tambourine_body);
        tambourine_body.cubeList.add(new ModelBox(tambourine_body, 12, 123, -2.2222F, -1.5556F, 0.1379F, 4, 4, 1, 0.0F, false));

        tambourine_r1 = new ModelRenderer(this);
        tambourine_r1.setRotationPoint(-1.5689F, 0.4444F, 1.4085F);
        tambourine_body.addChild(tambourine_r1);
        setRotationAngle(tambourine_r1, 0.3927F, 0.0F, 1.5708F);
        tambourine_r1.cubeList.add(new ModelBox(tambourine_r1, 0, 119, -1.0F, -0.5F, -0.5F, 2, 1, 2, 0.0F, false));

        tambourine_r2 = new ModelRenderer(this);
        tambourine_r2.setRotationPoint(-6.2222F, -20.494F, -6.1987F);
        tambourine_body.addChild(tambourine_r2);
        setRotationAngle(tambourine_r2, 0.3927F, 0.0F, 0.0F);
        tambourine_r2.cubeList.add(new ModelBox(tambourine_r2, 0, 116, 5.0F, 23.0F, -2.0F, 2, 1, 2, 0.0F, false));

        tambourine_r3 = new ModelRenderer(this);
        tambourine_r3.setRotationPoint(-6.2222F, 21.3829F, -6.1987F);
        tambourine_body.addChild(tambourine_r3);
        setRotationAngle(tambourine_r3, -0.3927F, 0.0F, 0.0F);
        tambourine_r3.cubeList.add(new ModelBox(tambourine_r3, 0, 125, 5.0F, -24.0F, -2.0F, 2, 1, 2, 0.0F, false));

        tambourine_r4 = new ModelRenderer(this);
        tambourine_r4.setRotationPoint(1.1245F, 0.4444F, 1.4085F);
        tambourine_body.addChild(tambourine_r4);
        setRotationAngle(tambourine_r4, -0.3927F, 0.0F, 1.5708F);
        tambourine_r4.cubeList.add(new ModelBox(tambourine_r4, 0, 122, -1.0F, -0.5F, -0.5F, 2, 1, 2, 0.0F, false));

        tambourine_r5 = new ModelRenderer(this);
        tambourine_r5.setRotationPoint(-0.7222F, 0.6791F, 2.4857F);
        tambourine_body.addChild(tambourine_r5);
        setRotationAngle(tambourine_r5, 0.0F, 0.0F, 1.5708F);
        tambourine_r5.cubeList.add(new ModelBox(tambourine_r5, 8, 116, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_r6 = new ModelRenderer(this);
        tambourine_r6.setRotationPoint(-0.4569F, -0.0556F, 2.4857F);
        tambourine_body.addChild(tambourine_r6);
        setRotationAngle(tambourine_r6, 0.0F, 0.0F, -3.1416F);
        tambourine_r6.cubeList.add(new ModelBox(tambourine_r6, 8, 119, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_r7 = new ModelRenderer(this);
        tambourine_r7.setRotationPoint(-0.7222F, -0.7902F, 2.4857F);
        tambourine_body.addChild(tambourine_r7);
        setRotationAngle(tambourine_r7, 0.0F, 0.0F, 1.5708F);
        tambourine_r7.cubeList.add(new ModelBox(tambourine_r7, 8, 125, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_r8 = new ModelRenderer(this);
        tambourine_r8.setRotationPoint(1.0124F, -0.0556F, 2.4857F);
        tambourine_body.addChild(tambourine_r8);
        setRotationAngle(tambourine_r8, 0.0F, 0.0F, -3.1416F);
        tambourine_r8.cubeList.add(new ModelBox(tambourine_r8, 8, 122, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_body2 = new ModelRenderer(this);
        tambourine_body2.setRotationPoint(0.2222F, -17.3444F, -4.1379F);
        Body.addChild(tambourine_body2);


        tambourine_r9 = new ModelRenderer(this);
        tambourine_r9.setRotationPoint(-1.5689F, 0.4444F, 6.8673F);
        tambourine_body2.addChild(tambourine_r9);
        setRotationAngle(tambourine_r9, -0.3927F, 0.0F, 1.5708F);
        tambourine_r9.cubeList.add(new ModelBox(tambourine_r9, 0, 119, -1.0F, -0.5F, -1.5F, 2, 1, 2, 0.0F, false));

        tambourine_r10 = new ModelRenderer(this);
        tambourine_r10.setRotationPoint(-6.2222F, -20.494F, 14.4745F);
        tambourine_body2.addChild(tambourine_r10);
        setRotationAngle(tambourine_r10, -0.3927F, 0.0F, 0.0F);
        tambourine_r10.cubeList.add(new ModelBox(tambourine_r10, 0, 116, 5.0F, 23.0F, 0.0F, 2, 1, 2, 0.0F, false));

        tambourine_r11 = new ModelRenderer(this);
        tambourine_r11.setRotationPoint(-0.2222F, 0.4444F, 7.6379F);
        tambourine_body2.addChild(tambourine_r11);
        setRotationAngle(tambourine_r11, 0.0F, 3.1416F, 0.0F);
        tambourine_r11.cubeList.add(new ModelBox(tambourine_r11, 12, 123, -2.0F, -2.0F, -0.5F, 4, 4, 1, 0.0F, false));

        tambourine_r12 = new ModelRenderer(this);
        tambourine_r12.setRotationPoint(-6.2222F, 21.3829F, 14.4745F);
        tambourine_body2.addChild(tambourine_r12);
        setRotationAngle(tambourine_r12, 0.3927F, 0.0F, 0.0F);
        tambourine_r12.cubeList.add(new ModelBox(tambourine_r12, 0, 125, 5.0F, -24.0F, 0.0F, 2, 1, 2, 0.0F, false));

        tambourine_r13 = new ModelRenderer(this);
        tambourine_r13.setRotationPoint(1.1245F, 0.4444F, 6.8673F);
        tambourine_body2.addChild(tambourine_r13);
        setRotationAngle(tambourine_r13, 0.3927F, 0.0F, 1.5708F);
        tambourine_r13.cubeList.add(new ModelBox(tambourine_r13, 0, 122, -1.0F, -0.5F, -1.5F, 2, 1, 2, 0.0F, false));

        tambourine_r14 = new ModelRenderer(this);
        tambourine_r14.setRotationPoint(-0.7222F, 0.6791F, 5.7901F);
        tambourine_body2.addChild(tambourine_r14);
        setRotationAngle(tambourine_r14, 0.0F, 0.0F, 1.5708F);
        tambourine_r14.cubeList.add(new ModelBox(tambourine_r14, 8, 116, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_r15 = new ModelRenderer(this);
        tambourine_r15.setRotationPoint(-0.4569F, -0.0556F, 5.7901F);
        tambourine_body2.addChild(tambourine_r15);
        setRotationAngle(tambourine_r15, 0.0F, 0.0F, -3.1416F);
        tambourine_r15.cubeList.add(new ModelBox(tambourine_r15, 8, 119, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_r16 = new ModelRenderer(this);
        tambourine_r16.setRotationPoint(-0.7222F, -0.7902F, 5.7901F);
        tambourine_body2.addChild(tambourine_r16);
        setRotationAngle(tambourine_r16, 0.0F, 0.0F, 1.5708F);
        tambourine_r16.cubeList.add(new ModelBox(tambourine_r16, 8, 125, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_r17 = new ModelRenderer(this);
        tambourine_r17.setRotationPoint(1.0124F, -0.0556F, 5.7901F);
        tambourine_body2.addChild(tambourine_r17);
        setRotationAngle(tambourine_r17, 0.0F, 0.0F, -3.1416F);
        tambourine_r17.cubeList.add(new ModelBox(tambourine_r17, 8, 122, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        RightArm = new ModelRenderer(this);
        RightArm.setRotationPoint(0.0F, 24.0F, 0.0F);
        RightArm.cubeList.add(new ModelBox(RightArm, 0, 48, -8.0F, -24.0F, -2.0F, 4, 12, 4, 0.0F, false));
        RightArm.cubeList.add(new ModelBox(RightArm, 52, 52, -8.0F, -24.0F, -2.0F, 4, 12, 4, 0.25F, false));

        tambourine_right_arm = new ModelRenderer(this);
        tambourine_right_arm.setRotationPoint(-7.4467F, -21.5F, -3.0294F);
        RightArm.addChild(tambourine_right_arm);
        tambourine_right_arm.cubeList.add(new ModelBox(tambourine_right_arm, 12, 123, -0.6533F, -2.0F, -1.2706F, 4, 4, 1, 0.0F, false));

        tambourine_r18 = new ModelRenderer(this);
        tambourine_r18.setRotationPoint(0.0F, 0.0F, 0.0F);
        tambourine_right_arm.addChild(tambourine_r18);
        setRotationAngle(tambourine_r18, 0.3927F, 0.0F, 1.5708F);
        tambourine_r18.cubeList.add(new ModelBox(tambourine_r18, 0, 119, -1.0F, -0.5F, -0.5F, 2, 1, 2, 0.0F, false));

        tambourine_r19 = new ModelRenderer(this);
        tambourine_r19.setRotationPoint(-4.6533F, -20.9385F, -7.6072F);
        tambourine_right_arm.addChild(tambourine_r19);
        setRotationAngle(tambourine_r19, 0.3927F, 0.0F, 0.0F);
        tambourine_r19.cubeList.add(new ModelBox(tambourine_r19, 0, 116, 5.0F, 23.0F, -2.0F, 2, 1, 2, 0.0F, false));

        tambourine_r20 = new ModelRenderer(this);
        tambourine_r20.setRotationPoint(-4.6533F, 20.9385F, -7.6072F);
        tambourine_right_arm.addChild(tambourine_r20);
        setRotationAngle(tambourine_r20, -0.3927F, 0.0F, 0.0F);
        tambourine_r20.cubeList.add(new ModelBox(tambourine_r20, 0, 125, 5.0F, -24.0F, -2.0F, 2, 1, 2, 0.0F, false));

        tambourine_r21 = new ModelRenderer(this);
        tambourine_r21.setRotationPoint(2.6934F, 0.0F, 0.0F);
        tambourine_right_arm.addChild(tambourine_r21);
        setRotationAngle(tambourine_r21, -0.3927F, 0.0F, 1.5708F);
        tambourine_r21.cubeList.add(new ModelBox(tambourine_r21, 0, 122, -1.0F, -0.5F, -0.5F, 2, 1, 2, 0.0F, false));

        tambourine_r22 = new ModelRenderer(this);
        tambourine_r22.setRotationPoint(0.8467F, 0.2346F, 1.0772F);
        tambourine_right_arm.addChild(tambourine_r22);
        setRotationAngle(tambourine_r22, 0.0F, 0.0F, 1.5708F);
        tambourine_r22.cubeList.add(new ModelBox(tambourine_r22, 8, 116, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_r23 = new ModelRenderer(this);
        tambourine_r23.setRotationPoint(1.1121F, -0.5F, 1.0772F);
        tambourine_right_arm.addChild(tambourine_r23);
        setRotationAngle(tambourine_r23, 0.0F, 0.0F, -3.1416F);
        tambourine_r23.cubeList.add(new ModelBox(tambourine_r23, 8, 119, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_r24 = new ModelRenderer(this);
        tambourine_r24.setRotationPoint(0.8467F, -1.2346F, 1.0772F);
        tambourine_right_arm.addChild(tambourine_r24);
        setRotationAngle(tambourine_r24, 0.0F, 0.0F, 1.5708F);
        tambourine_r24.cubeList.add(new ModelBox(tambourine_r24, 8, 125, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_r25 = new ModelRenderer(this);
        tambourine_r25.setRotationPoint(2.5814F, -0.5F, 1.0772F);
        tambourine_right_arm.addChild(tambourine_r25);
        setRotationAngle(tambourine_r25, 0.0F, 0.0F, -3.1416F);
        tambourine_r25.cubeList.add(new ModelBox(tambourine_r25, 8, 122, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        LeftArm = new ModelRenderer(this);
        LeftArm.setRotationPoint(0.0F, 24.0F, 0.0F);
        LeftArm.cubeList.add(new ModelBox(LeftArm, 20, 44, 4.0F, -24.0F, -2.0F, 4, 12, 4, 0.0F, false));
        LeftArm.cubeList.add(new ModelBox(LeftArm, 32, 0, 4.0F, -24.0F, -2.0F, 4, 12, 4, 0.25F, false));

        tambourine_left_arm = new ModelRenderer(this);
        tambourine_left_arm.setRotationPoint(4.7533F, -21.5F, -3.0294F);
        LeftArm.addChild(tambourine_left_arm);
        tambourine_left_arm.cubeList.add(new ModelBox(tambourine_left_arm, 12, 123, -0.6533F, -2.0F, -1.2706F, 4, 4, 1, 0.0F, false));

        tambourine_left_arm_r1 = new ModelRenderer(this);
        tambourine_left_arm_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        tambourine_left_arm.addChild(tambourine_left_arm_r1);
        setRotationAngle(tambourine_left_arm_r1, 0.3927F, 0.0F, 1.5708F);
        tambourine_left_arm_r1.cubeList.add(new ModelBox(tambourine_left_arm_r1, 0, 119, -1.0F, -0.5F, -0.5F, 2, 1, 2, 0.0F, false));

        tambourine_left_arm_r2 = new ModelRenderer(this);
        tambourine_left_arm_r2.setRotationPoint(-4.6533F, -20.9385F, -7.6072F);
        tambourine_left_arm.addChild(tambourine_left_arm_r2);
        setRotationAngle(tambourine_left_arm_r2, 0.3927F, 0.0F, 0.0F);
        tambourine_left_arm_r2.cubeList.add(new ModelBox(tambourine_left_arm_r2, 0, 116, 5.0F, 23.0F, -2.0F, 2, 1, 2, 0.0F, false));

        tambourine_left_arm_r3 = new ModelRenderer(this);
        tambourine_left_arm_r3.setRotationPoint(-4.6533F, 20.9385F, -7.6072F);
        tambourine_left_arm.addChild(tambourine_left_arm_r3);
        setRotationAngle(tambourine_left_arm_r3, -0.3927F, 0.0F, 0.0F);
        tambourine_left_arm_r3.cubeList.add(new ModelBox(tambourine_left_arm_r3, 0, 125, 5.0F, -24.0F, -2.0F, 2, 1, 2, 0.0F, false));

        tambourine_left_arm_r4 = new ModelRenderer(this);
        tambourine_left_arm_r4.setRotationPoint(2.6934F, 0.0F, 0.0F);
        tambourine_left_arm.addChild(tambourine_left_arm_r4);
        setRotationAngle(tambourine_left_arm_r4, -0.3927F, 0.0F, 1.5708F);
        tambourine_left_arm_r4.cubeList.add(new ModelBox(tambourine_left_arm_r4, 0, 122, -1.0F, -0.5F, -0.5F, 2, 1, 2, 0.0F, false));

        tambourine_left_arm_r5 = new ModelRenderer(this);
        tambourine_left_arm_r5.setRotationPoint(0.8467F, 0.2346F, 1.0772F);
        tambourine_left_arm.addChild(tambourine_left_arm_r5);
        setRotationAngle(tambourine_left_arm_r5, 0.0F, 0.0F, 1.5708F);
        tambourine_left_arm_r5.cubeList.add(new ModelBox(tambourine_left_arm_r5, 8, 116, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_left_arm_r6 = new ModelRenderer(this);
        tambourine_left_arm_r6.setRotationPoint(1.1121F, -0.5F, 1.0772F);
        tambourine_left_arm.addChild(tambourine_left_arm_r6);
        setRotationAngle(tambourine_left_arm_r6, 0.0F, 0.0F, -3.1416F);
        tambourine_left_arm_r6.cubeList.add(new ModelBox(tambourine_left_arm_r6, 8, 119, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_left_arm_r7 = new ModelRenderer(this);
        tambourine_left_arm_r7.setRotationPoint(0.8467F, -1.2346F, 1.0772F);
        tambourine_left_arm.addChild(tambourine_left_arm_r7);
        setRotationAngle(tambourine_left_arm_r7, 0.0F, 0.0F, 1.5708F);
        tambourine_left_arm_r7.cubeList.add(new ModelBox(tambourine_left_arm_r7, 8, 125, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        tambourine_left_arm_r8 = new ModelRenderer(this);
        tambourine_left_arm_r8.setRotationPoint(2.5814F, -0.5F, 1.0772F);
        tambourine_left_arm.addChild(tambourine_left_arm_r8);
        setRotationAngle(tambourine_left_arm_r8, 0.0F, 0.0F, -3.1416F);
        tambourine_left_arm_r8.cubeList.add(new ModelBox(tambourine_left_arm_r8, 8, 122, 0.0F, -1.5F, -0.5F, 1, 2, 1, 0.0F, false));

        RightLeg = new ModelRenderer(this);
        RightLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
        RightLeg.cubeList.add(new ModelBox(RightLeg, 56, 0, -3.9F, -12.0F, -2.0F, 4, 12, 4, 0.0F, false));
        RightLeg.cubeList.add(new ModelBox(RightLeg, 52, 28, -3.9F, -12.0F, -2.0F, 4, 12, 4, 0.25F, false));

        tambourine_right_leg = new ModelRenderer(this);
        tambourine_right_leg.setRotationPoint(-11.2222F, -14.5444F, -4.1379F);
        RightLeg.addChild(tambourine_right_leg);
        setRotationAngle(tambourine_right_leg, 0.0F, 1.5708F, 0.0F);
        tambourine_right_leg.cubeList.add(new ModelBox(tambourine_right_leg, 12, 123, -6.1379F, 3.0444F, 5.6222F, 4, 4, 1, 0.0F, true));

        tambourine_r26 = new ModelRenderer(this);
        tambourine_r26.setRotationPoint(-2.7912F, 5.3444F, 8.5928F);
        tambourine_right_leg.addChild(tambourine_r26);
        setRotationAngle(tambourine_r26, 0.3927F, 0.0F, -1.5708F);
        tambourine_r26.cubeList.add(new ModelBox(tambourine_r26, 0, 119, -0.7F, -1.1506F, -2.0706F, 2, 1, 2, 0.0F, true));

        tambourine_r27 = new ModelRenderer(this);
        tambourine_r27.setRotationPoint(1.8621F, -15.594F, 0.9856F);
        tambourine_right_leg.addChild(tambourine_r27);
        setRotationAngle(tambourine_r27, 0.3927F, 0.0F, 0.0F);
        tambourine_r27.cubeList.add(new ModelBox(tambourine_r27, 0, 116, -7.0F, 22.0723F, -3.4558F, 2, 1, 2, 0.0F, true));

        tambourine_r28 = new ModelRenderer(this);
        tambourine_r28.setRotationPoint(1.8621F, 26.2829F, 0.9856F);
        tambourine_right_leg.addChild(tambourine_r28);
        setRotationAngle(tambourine_r28, -0.3927F, 0.0F, 0.0F);
        tambourine_r28.cubeList.add(new ModelBox(tambourine_r28, 0, 125, -7.0F, -23.6266F, -3.6854F, 2, 1, 2, 0.0F, true));

        tambourine_r29 = new ModelRenderer(this);
        tambourine_r29.setRotationPoint(-5.4846F, 5.3444F, 8.5928F);
        tambourine_right_leg.addChild(tambourine_r29);
        setRotationAngle(tambourine_r29, -0.3927F, 0.0F, -1.5708F);
        tambourine_r29.cubeList.add(new ModelBox(tambourine_r29, 0, 122, -0.7F, 0.1506F, -2.0706F, 2, 1, 2, 0.0F, true));

        tambourine_r30 = new ModelRenderer(this);
        tambourine_r30.setRotationPoint(-3.6379F, 5.5791F, 9.67F);
        tambourine_right_leg.addChild(tambourine_r30);
        setRotationAngle(tambourine_r30, 0.0F, 0.0F, -1.5708F);
        tambourine_r30.cubeList.add(new ModelBox(tambourine_r30, 8, 116, -0.7F, -1.5F, -2.2F, 1, 2, 1, 0.0F, true));

        tambourine_r31 = new ModelRenderer(this);
        tambourine_r31.setRotationPoint(-3.9033F, 4.8444F, 9.67F);
        tambourine_right_leg.addChild(tambourine_r31);
        setRotationAngle(tambourine_r31, 0.0F, 0.0F, 3.1416F);
        tambourine_r31.cubeList.add(new ModelBox(tambourine_r31, 8, 119, -1.0F, -1.2F, -2.2F, 1, 2, 1, 0.0F, true));

        tambourine_r32 = new ModelRenderer(this);
        tambourine_r32.setRotationPoint(-3.6379F, 4.1098F, 9.67F);
        tambourine_right_leg.addChild(tambourine_r32);
        setRotationAngle(tambourine_r32, 0.0F, 0.0F, -1.5708F);
        tambourine_r32.cubeList.add(new ModelBox(tambourine_r32, 8, 125, -0.7F, -1.5F, -2.2F, 1, 2, 1, 0.0F, true));

        tambourine_r33 = new ModelRenderer(this);
        tambourine_r33.setRotationPoint(-5.3725F, 4.8444F, 9.67F);
        tambourine_right_leg.addChild(tambourine_r33);
        setRotationAngle(tambourine_r33, 0.0F, 0.0F, 3.1416F);
        tambourine_r33.cubeList.add(new ModelBox(tambourine_r33, 8, 122, -1.0F, -1.2F, -2.2F, 1, 2, 1, 0.0F, true));

        LeftLeg = new ModelRenderer(this);
        LeftLeg.setRotationPoint(0.0F, 24.0F, 0.0F);
        LeftLeg.cubeList.add(new ModelBox(LeftLeg, 44, 12, -0.1F, -12.0F, -2.0F, 4, 12, 4, 0.0F, false));
        LeftLeg.cubeList.add(new ModelBox(LeftLeg, 36, 44, -0.1F, -12.0F, -2.0F, 4, 12, 4, 0.25F, false));

        tambourine_left_leg = new ModelRenderer(this);
        tambourine_left_leg.setRotationPoint(11.2222F, -15.3444F, -4.1379F);
        LeftLeg.addChild(tambourine_left_leg);
        setRotationAngle(tambourine_left_leg, 0.0F, -1.5708F, 0.0F);
        tambourine_left_leg.cubeList.add(new ModelBox(tambourine_left_leg, 12, 123, 2.1379F, 3.8444F, 5.6222F, 4, 4, 1, 0.0F, false));

        tambourine_r34 = new ModelRenderer(this);
        tambourine_r34.setRotationPoint(2.7912F, 5.3444F, 8.5928F);
        tambourine_left_leg.addChild(tambourine_r34);
        setRotationAngle(tambourine_r34, 0.3927F, 0.0F, 1.5708F);
        tambourine_r34.cubeList.add(new ModelBox(tambourine_r34, 0, 119, -0.5F, -1.1506F, -2.0706F, 2, 1, 2, 0.0F, false));

        tambourine_r35 = new ModelRenderer(this);
        tambourine_r35.setRotationPoint(-1.8621F, -15.594F, 0.9856F);
        tambourine_left_leg.addChild(tambourine_r35);
        setRotationAngle(tambourine_r35, 0.3927F, 0.0F, 0.0F);
        tambourine_r35.cubeList.add(new ModelBox(tambourine_r35, 0, 116, 5.0F, 22.8114F, -3.7619F, 2, 1, 2, 0.0F, false));

        tambourine_r36 = new ModelRenderer(this);
        tambourine_r36.setRotationPoint(-1.8621F, 26.2829F, 0.9856F);
        tambourine_left_leg.addChild(tambourine_r36);
        setRotationAngle(tambourine_r36, -0.3927F, 0.0F, 0.0F);
        tambourine_r36.cubeList.add(new ModelBox(tambourine_r36, 0, 125, 5.0F, -22.8875F, -3.3793F, 2, 1, 2, 0.0F, false));

        tambourine_r37 = new ModelRenderer(this);
        tambourine_r37.setRotationPoint(5.4846F, 5.3444F, 8.5928F);
        tambourine_left_leg.addChild(tambourine_r37);
        setRotationAngle(tambourine_r37, -0.3927F, 0.0F, 1.5708F);
        tambourine_r37.cubeList.add(new ModelBox(tambourine_r37, 0, 122, -0.5F, 0.1506F, -2.0706F, 2, 1, 2, 0.0F, false));

        tambourine_r38 = new ModelRenderer(this);
        tambourine_r38.setRotationPoint(3.6379F, 5.5791F, 9.67F);
        tambourine_left_leg.addChild(tambourine_r38);
        setRotationAngle(tambourine_r38, 0.0F, 0.0F, 1.5708F);
        tambourine_r38.cubeList.add(new ModelBox(tambourine_r38, 8, 116, 0.5F, -1.5F, -2.2F, 1, 2, 1, 0.0F, false));

        tambourine_r39 = new ModelRenderer(this);
        tambourine_r39.setRotationPoint(3.9033F, 4.8444F, 9.67F);
        tambourine_left_leg.addChild(tambourine_r39);
        setRotationAngle(tambourine_r39, 0.0F, 0.0F, -3.1416F);
        tambourine_r39.cubeList.add(new ModelBox(tambourine_r39, 8, 119, 0.0F, -2.0F, -2.2F, 1, 2, 1, 0.0F, false));

        tambourine_r40 = new ModelRenderer(this);
        tambourine_r40.setRotationPoint(3.6379F, 4.1098F, 9.67F);
        tambourine_left_leg.addChild(tambourine_r40);
        setRotationAngle(tambourine_r40, 0.0F, 0.0F, 1.5708F);
        tambourine_r40.cubeList.add(new ModelBox(tambourine_r40, 8, 125, 0.5F, -1.5F, -2.2F, 1, 2, 1, 0.0F, false));

        tambourine_r41 = new ModelRenderer(this);
        tambourine_r41.setRotationPoint(5.3725F, 4.8444F, 9.67F);
        tambourine_left_leg.addChild(tambourine_r41);
        setRotationAngle(tambourine_r41, 0.0F, 0.0F, -3.1416F);
        tambourine_r41.cubeList.add(new ModelBox(tambourine_r41, 8, 122, 0.0F, -2.0F, -2.2F, 1, 2, 1, 0.0F, false));
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        Head.render(f5);
        Body.render(f5);
        RightArm.render(f5);
        LeftArm.render(f5);
        RightLeg.render(f5);
        LeftLeg.render(f5);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
