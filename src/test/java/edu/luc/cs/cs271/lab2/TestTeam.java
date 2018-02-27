package edu.luc.cs.cs271.lab2;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestTeam {

  Team makeTeamFixture(final String name, final String headcoach, final int funding) {
    return new Team(name, headcoach, funding);
  }

  @Test
  public void testConstructorValidName() {
    try {
      new Team(null, "Klinsmann", 500);
      fail("should have thrown IllegalArgumentException");
    } catch (final Throwable ex) {
      // if we landed here, we're good!
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorValidHeadcoach()
  {
    new Team("USA", null, 500);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorValidFunding()
  {
    new Team("USA", "Klinsmann", 0);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testConstructorValidFundingII()
  {
    new Team("USA", "Klinsmann", -200);
  }


  @Test
  public void testGetName() {
    final String name = "USA";
    final Team t = makeTeamFixture(name, "Klinsmann", 500);
    assertEquals(name, t.getName());
  }

  @Test
  public void testGetHeadcoach()
  {
    final String headcoach = "Kilinsmann";
    final Team t = makeTeamFixture("USA", headcoach, 500);
    assertEquals(headcoach, t.getHeadcoach());
  }

  @Test
  public void testGetFunding()
  {
    final int funding = 500;
    final Team t = makeTeamFixture("USA", "Kilinsmann", funding);
    assertEquals(funding, t.getFunding());
  }
}