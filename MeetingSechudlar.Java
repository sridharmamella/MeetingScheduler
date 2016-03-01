package com.company;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


public class MeetingSchedular {

   public static void main(String[] args) {
      /*
       * int[] meetings = new int[args.length]; for (int i = 0; i < args.length; i++) { String[] splits = args[i].split(
       * " "); String timeSlot = splits[splits.length - 1]; meetings[i] = Integer.parseInt(timeSlot.substring(0,
       * timeSlot.length() - 3)); }
       */

      int[] meetings = { 60, 30, 30, 45, 45, 30, 60, 30, 30, 45, 60, 45, 45, 60, 60, 60, 45, 30 };

      int[] scheduleSlotOneOfRoom1 = generateSubsets(meetings, 120);// 3hr slot
      int[] meetingToBePlanned = getUnplannedMeetings(scheduleSlotOneOfRoom1, meetings);
      int[] scheduleSlotOneOfRoom2 = generateSubsets(meetingToBePlanned, 120);// 3hr slot
      meetingToBePlanned = getUnplannedMeetings(scheduleSlotOneOfRoom2, meetingToBePlanned);
      int[] scheduleSlotTwoOfRoom1 = generateSubsets(meetingToBePlanned, 240); // 4hr slot
      meetingToBePlanned = getUnplannedMeetings(scheduleSlotTwoOfRoom1, meetingToBePlanned);
      int[] scheduleSlotTwoOfRoom2 = generateSubsets(meetingToBePlanned, 240); // 4hr slot

      System.out.println("Bookings slot one of Room1");
      for (int slot : scheduleSlotOneOfRoom1) {
         if (slot != 0)
            System.out.print(slot + " ");
      }
      System.out.println("");
      System.out.println("Bookings slot one of Room2");
      for (int slot : scheduleSlotOneOfRoom2) {
         if (slot != 0)
            System.out.print(slot + " ");
      }
      System.out.println("");
      System.out.println("Bookings slot Two of Room1");

      for (int slot : scheduleSlotTwoOfRoom1) {
         if (slot != 0)
            System.out.print(slot + " ");
      }
      System.out.println("");
      System.out.println("Bookings slot two of Room2");

      for (int slot : scheduleSlotTwoOfRoom2) {
         if (slot != 0)
            System.out.print(slot + " ");
      }

   }
    public static int[] generateSubsets(int s[], int target_sum) {
      int[] tuplet_vector = new int[s.length];
      return subset_sum(s, tuplet_vector, s.length, 0, 0, 0, target_sum);
   }

   public static int[] subset_sum(int s[], int t[], int s_size, int t_size, int sum, int ite, int target_sum) {

      if (target_sum == sum) {
         return t;
      } else {
         for (int i = ite; i < s_size; i++) {
            t[t_size] = s[i];
            return subset_sum(s, t, s_size, t_size + 1, sum + s[i], i + 1, target_sum);
         }
      }
      return null;
   }

    /*
   * remove already planned meeting from meeting and returns the unplanned list
   */
    public static int[] getUnplannedMeetings(int[] plannedMeetings, int[] meetings) {
        // List<Integer>unplannedMeetings = new ArrayList<>();
        int[] unplannedMeetings = new int[meetings.length];
        int index = 0;
        List planned = Arrays.asList(plannedMeetings);
        for (int i = 0; i < meetings.length; i++) {
            if (planned.contains(meetings[i])) {
                planned.remove(meetings[i]);
            } else {
                unplannedMeetings[index++] = meetings[i];
            }
        }
        return unplannedMeetings;
    }
}
