package company.google;/*
https://leetcode.com/problems/my-calendar-i/
You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
 */

import java.util.ArrayList;
import java.util.List;

public class MyCalendar1 {
    static class MyCalendar {
        public List<List<Integer>> events = new ArrayList<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            for (List<Integer> event : events) {
                if (start > event.get(0)) {
                    if (start < event.get(1)) {
                        return false;
                    }
                } else if (start == event.get(0)) {
                    return false;
                } else {
                    if (end > event.get(0)) {
                        return false;
                    }
                }
            }
            events.add(List.of(start, end));
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
//        System.out.println(myCalendar.book(37, 50));
//        System.out.println(myCalendar.book(33, 50));

//        System.out.println(myCalendar.book(37, 50));
//        System.out.println(myCalendar.book(40, 50));

//        System.out.println(myCalendar.book(25, 32));
//        System.out.println(myCalendar.book(19, 25));

//        System.out.println(myCalendar.book(10, 20));
//        System.out.println(myCalendar.book(15, 25));
//        System.out.println(myCalendar.book(20, 30));
//
//        System.out.println(myCalendar.book(5, 10));
//        System.out.println(myCalendar.book(15, 20));
//        System.out.println(myCalendar.book(30, 35));

//        System.out.println(myCalendar.book(5, 10));
//        System.out.println(myCalendar.book(8, 15));
//        System.out.println(myCalendar.book(9, 20));
//        System.out.println(myCalendar.book(10, 15));

//        System.out.println(myCalendar.book(5, 10));
//        System.out.println(myCalendar.book(10, 15));
//        System.out.println(myCalendar.book(15, 20));

//        System.out.println(myCalendar.book(10, 20));
//        System.out.println(myCalendar.book(5, 10));
//        System.out.println(myCalendar.book(5, 10));
//        System.out.println(myCalendar.book(10, 15));

        System.out.println(myCalendar.book(15, 17));
        System.out.println(myCalendar.book(6, 12));
        System.out.println(myCalendar.book(13, 15));
        System.out.println(myCalendar.book(16, 20));
        System.out.println(myCalendar.book(17, 20));
        System.out.println(myCalendar.book(30, 40));
        System.out.println(myCalendar.book(20, 27));
        System.out.println(myCalendar.book(35, 50));
        System.out.println(myCalendar.book(20, 21));
        System.out.println(myCalendar.book(27, 30));
        System.out.println(myCalendar.book(1, 5));
    }
}