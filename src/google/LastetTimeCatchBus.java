package google;/*
https://leetcode.com/problems/the-latest-time-to-catch-a-bus/
More formally when a bus arrives, either:

If capacity or fewer passengers are waiting for a bus, they will all get on the bus, or
The capacity passengers with the earliest arrival times will get on the bus.
Return the latest time you may arrive at the bus station to catch a bus. You cannot arrive at the same time as another passenger.

Note: The arrays buses and passengers are not necessarily sorted.

Input: buses = [10,20], passengers = [2,17,18,19], capacity = 2
Output: 16
Explanation: Suppose you arrive at time 16.
At time 10, the first bus departs with the 0th passenger.
At time 20, the second bus departs with you and the 1st passenger.
Note that you may not arrive at the same time as another passenger, which is why you must arrive before the 1st passenger to catch the bus.
 */

import java.util.Arrays;

public class LastetTimeCatchBus {
    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        // Board all passengers
        int bus = 0, people = 0, count = 0;
        while (people < passengers.length) {
            count = 0;
            while (capacity > count) {
                if (people == passengers.length) {
                    break;
                }
                if (passengers[people] <= buses[bus]) {
                    people++;
                    count++;
                } else {
                    break;
                }
            }
            bus++;
            if (bus == buses.length) {
                break;
            }
        }

        people--;
        bus--;
        int lastTime;

        // Đủ xe bus
        if (bus == buses.length - 1) {
            if (count < capacity) {    // Dư chỗ
                lastTime = buses[bus];
            } else {                   // Thiếu chỗ
                lastTime = passengers[people];
            }
        } else {                       // Dư xe bus
            lastTime = buses[buses.length - 1];
        }
        while (people >= 0 && passengers[people] >= lastTime) {
            people--;
            lastTime--;
        }
        return lastTime;
    }

    public static void main(String[] args) {
//        int[] buses = new int[]{4};
//        int[] buses = new int[]{10, 20};
        int[] buses = new int[]{10, 20, 30, 40};

//        int[] passengers = new int[]{3};
        int[] passengers = new int[]{2, 17, 18, 19};
//        int[] passengers = new int[]{2, 17, 18, 19, 30, 100};
        System.out.println(latestTimeCatchTheBus(buses, passengers, 2));
    }
}