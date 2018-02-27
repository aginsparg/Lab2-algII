package edu.luc.cs.cs271.lab2;

public class stopDuplicates {


    public static void printInfo(final Team team, final int pos)
    {
        System.out.println("Name: " + team.getName());
        System.out.println("Head coach: " + team.getHeadcoach());
        System.out.println("Funding: " + team.getFunding());
        System.out.println("Array index: " + pos);
        System.out.println("Ranking: " + (pos + 1));
    }
}