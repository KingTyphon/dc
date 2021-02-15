package net.util.capabilities.slayer;

import net.util.capabilities.slayer.ISlayerCapability;

public class SlayerCapability implements ISlayerCapability {
  private int breath=0;

  @Override
  public int getBreath(){
    return breath;
  }
  @Override
  public void setBreath(int breath) {
    this.breath = breath;

    if(this.breath < 0)
      this.breath = 0;
  }
  @Override
  public boolean isSlayer() {
    return false;
  }
}
