package edu.luc.cs.cs271.lab2;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class TestSearch {

  Team[] makeArrayFixture(final int size) {
    final Team[] array = new Team[size];
    for (int i = 0; i < size; i++) {
      final String s = Integer.toString(i);
      array[i] = new Team("Team " + s, "Coach " + s, i * 100 + 50);
    }
    return array;
  }

  List<Team> makeListFixture(final int size) {
    final List<Team> list = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      final String s = Integer.toString(i);
      list.add(new Team("Team " + s, "Coach " + s, i * 100 + 50));
    }
    return list;
  }

  @Test
  public void testFindPositionArray0() {
    final Team[] arr = makeArrayFixture(0);
    assertFalse(Search.findTeamPosition(arr, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionArray10s() {
    final Team[] arr = makeArrayFixture(10);
    assertTrue(Search.findTeamPosition(arr, "Team 5").isPresent());
  }

  @Test
  public void testFindPositionArray10f() {
    final Team[] arr = makeArrayFixture(10);
    assertFalse(Search.findTeamPosition(arr, "Team 11").isPresent());
  }

  @Test
  public void testFindPositionList() {
    final List<Team> list= makeListFixture(0);
    assertFalse(Search.findTeamPosition(list, "Team 3").isPresent());
  }


  @Test
  public void testFindPositionListII() {
    final List<Team> list= makeListFixture(10);
    assertFalse(Search.findTeamPosition(list, "Team 13").isPresent());
  }


  @Test
  public void testFindPositionListIII() {
    final List<Team> list= makeListFixture(10);
    //assertTrue(Search.findTeamPosition(list,"Team 6").isPresent());

  }

  @Test
  public void testFindMinFundingArrayI()
  {
    final Team[] arr = makeArrayFixture(10);
    assertEquals(Optional.of(3), Search.findTeamMinFunding(arr, 350));
  }

  @Test
  public void testFindMinFundingArrayII()
  {
    final Team[] arr = makeArrayFixture(10);
    assertEquals(Optional.empty(), Search.findTeamMinFunding(arr, 12000));
  }

  @Test
  public void testFindMinFundingArrayIII()
  {
    final Team[] arr = makeArrayFixture(10);
    assertEquals(Optional.of(7), Search.findTeamMinFunding(arr, 750));
  }

  @Test
  public void testFindMinFundingArrayIV()
  {
    final Team[] arr = makeArrayFixture(0);
    assertEquals(Optional.empty(), Search.findTeamMinFunding(arr, 350));
  }

  @Test
  public void testFindMinFundingArrayV()
  {
    final Team[] arr = makeArrayFixture(1);
    assertEquals(Optional.of(0), Search.findTeamMinFunding(arr, 50));
  }

  @Test
  public void testFindMinFundingArrayFastI()
  {
    final Team[]arr = makeArrayFixture(20);
    assertEquals(Optional.of(7), Search.findTeamMinFundingFast(arr, 750));
  }
  @Test
  public void testFindMinFundingArrayFastII()
  {
    final Team[]arr = makeArrayFixture(200);
    assertEquals(Optional.of(107), Search.findTeamMinFundingFast(arr, 10750));
  }

  @Test
  public void testFindMinFundingArrayFastIII()
  {
    final Team[]arr = makeArrayFixture(20);
    assertEquals(Optional.of(18), Search.findTeamMinFundingFast(arr, 1850));
  }

  @Test
  public void testFindMinFundingArrayFastIV()
  {
    final Team[]arr = makeArrayFixture(20);
    assertEquals(Optional.empty(), Search.findTeamMinFundingFast(arr, 111750));
  }
}
