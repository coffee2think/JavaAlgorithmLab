package dev.coffee2think.programmers.lv0.q120880;

import java.util.Arrays;

/**
 * date: 2026-09-30
 * source: https://school.programmers.co.kr/learn/courses/30/lessons/120880
 */
public class Solution {

    public int[] solutionBinarySearch1(int[] numlist, int n) {
        Arrays.sort(numlist);

        int origin = Arrays.binarySearch(numlist, n);
        int current = 0;
        int left, right;

        if (origin < 0) {
            right = -(origin + 1);
            left = right - 1;

            if (left < 0) {
                origin = right;
            } else if (right >= numlist.length) {
                origin = left;
            } else {
                int distanceLeft = n - numlist[left];
                int distanceRight = numlist[right] - n;

                origin = distanceRight <= distanceLeft ? right : left;
            }
        }

        left = origin - 1;
        right = origin + 1;

        int[] result = new int[numlist.length];
        result[current++] = numlist[origin];

        while (current < numlist.length) {
            if (left >= 0 && right < numlist.length) {
                if (numlist[right] - n <= n - numlist[left]) {
                    result[current++] = numlist[right++];
                } else {
                    result[current++] = numlist[left--];
                }
            } else if (left < 0) {
                result[current++] = numlist[right++];
            } else {
                result[current++] = numlist[left--];
            }
        }

        return result;
    }

    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // target이 arr에 없을 경우
        if (right < 0) return left;
        if (left >= arr.length) return right;
        return arr[left] - target <= target - arr[right] ? left : right;
    }

    public int[] solutionBinarySearch2(int[] numlist, int n) {
        Arrays.sort(numlist);

        int right = lowerBound(numlist, n);
        int left = right - 1;

        int[] result = new int[numlist.length];
        int current = 0;

        while (left >= 0 && right < numlist.length) {
            int leftDistance = n - numlist[left];
            int rightDistance = numlist[right] - n;

            // 거리가 같으면 더 큰 값인 오른쪽을 선택
            if (rightDistance <= leftDistance) {
                result[current++] = numlist[right++];
            } else {
                result[current++] = numlist[left--];
            }
        }

        // 왼쪽에 남은 값 처리
        while (left >= 0) {
            result[current++] = numlist[left--];
        }

        // 오른쪽에 남은 값 처리
        while (right < numlist.length) {
            result[current++] = numlist[right++];
        }

        return result;
    }

    public int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }


    public int[] solutionIntegerSort(int[] numlist, int n) {
        Integer[] integerArr = new Integer[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            integerArr[i] = numlist[i];
        }

        Arrays.sort(integerArr, (i1, i2) -> {
            int distance1 = Math.abs(i1 - n);
            int distance2 = Math.abs(i2 - n);

            if (distance1 == distance2) { // 거리가 같은 경우, 값 내림차순
                return Integer.compare(i2, i1);
            }

            return Integer.compare(distance1, distance2); // 거리가 다른 경우, 거리 오름차순
        });

        int[] answer = new int[integerArr.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = integerArr[i];
        }

        return answer;
    }
}
