package edu.luc.cs.cs271.lab2;

import java.util.List;
import java.util.Optional;

public class Search {

  /** Looks for the position of the named team in an array. */
  public static Optional<Integer> findTeamPosition(final Team[] arr, final String key) {
    // Gets the array size
    final int size = arr.length;
    // Runs through a for loop to check
    for (int i = 0; i < size; i++) {
      // Gets the current item at index and compare name to key
      if (arr[i].getName().equals(key)) {
        // Return the index of where the item with key is located
        return Optional.of(i);
      }
    }
    // If it does not exist in the array then return an index of -1
    return Optional.empty();
  }

  /** Looks for the position of the named team in a list. */
  public static Optional<Integer> findTeamPosition(final List<Team> list, final String key)
  {
    int k = 0;
    for(int i =1; i<(list.size()+1); i++) {
      if (list.get(i-1).equals(key)) {
        k=i;
      }
    }
    if(k != 0)
      return Optional.of(k-1);
    else
      return Optional.empty();
  }

  /**
   * Looks for the position of the poorest team that has at least
   * the specified funding level.
   * @pre arr is sorted
   * @post arr[result].funding >= minFunding && for all 0 <= i < result : arr[i].funding < minFunding
   */
  public static Optional<Integer> findTeamMinFunding(final Team[] arr, final int minFunding) {
    for (int i = 0; i < arr.length; i++)
    {
      if (arr[i].getFunding() >= minFunding)
        return Optional.of(i);
    }
    return Optional.empty();
  }

  /**
   * Looks for the position of the poorest team that has at least
   * the specified funding level.
   * Uses binary search: Initially consider the entire index range,
   * then repeatedly eliminate the wrong half of the array until
   * zero or one items are left.
   * @pre arr is sorted
   * @post arr[result].funding >= minFunding && for all 0 <= i < result : arr[i].funding < minFunding
   */
  public static Optional<Integer> findTeamMinFundingFast(final Team[] arr, final int minFunding) {
    // Gets the array size
    final int size = arr.length;
    // Initially consider the entire index range of the array
    int low = 0;
    int high = size - 1;
    int middle;
    do{
      middle =(high+low)/2;
      if(arr[middle].getFunding()> minFunding)
        high = middle;
      else
        low = middle;
    }while (low < high-1);
    // Keep going as long as there is more than one item to be checked
    // Eliminate the wrong half of the array
    // Return current item only if it meets the condition!
    if (low <= high && arr[low].getFunding() >= minFunding) {
      return Optional.of(low);
    } else {
      return Optional.empty();
    }
  }
}