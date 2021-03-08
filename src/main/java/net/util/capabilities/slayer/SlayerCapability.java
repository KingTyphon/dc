package net.util.capabilities.slayer;

public class SlayerCapability implements ISlayerCapability {

  private int breath;

  @Override
  public int getBreath(){
    return breath;
  }
  @Override
  public void setBreath(int breath) {
    this.breath = breath;
  }
  @Override
  public boolean isSlayer() {
    return false;
  }
}
