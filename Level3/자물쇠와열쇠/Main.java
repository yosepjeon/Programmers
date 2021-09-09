package Level3.자물쇠와열쇠;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int M, N;
        int[][] key;
        int[][] lock;

        M = scr.nextInt();
        key = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                key[i][j] = scr.nextInt();
            }
        }

        N = scr.nextInt();
        lock = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                lock[i][j] = scr.nextInt();
            }
        }

        Solution solution = new Solution();

        System.out.println(solution.solution(key, lock));
    }
}

class Solution {
    static int len;
    static int keyLen;
    static int lockLen;
    static int[][] map;

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;

        keyLen = key.length;
        lockLen = lock.length;
        len = keyLen + (2 * (keyLen - 1));

        map = new int[len][len];
        int lockZeroCnt = 0;

        for (int i = 0; i < lockLen; i++) {
            for (int j = 0; j < lockLen; j++) {
                map[i + (lockLen - 1)][j + (lockLen - 1)] = lock[i][j];

                if (lock[i][j] == 0) {
                    lockZeroCnt++;
                }
            }
        }

//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println(lockZeroCnt);
//
//        System.out.println("key");
//        for (int i = 0; i < keyLen; i++) {
//            for (int j = 0; j < keyLen; j++) {
//                System.out.print(key[i][j] + " ");
//            }
//            System.out.println();
//        }

        // 오른쪽 이동
        moveDown:
        for (int down = 0; down <= len - keyLen; down++) {
            // 아래 이동
            moveRight:
            for (int right = 0; right <= len - keyLen; right++) {
                // 90도 회전
                rotate:
                for (int rotate = 0; rotate < 4; rotate++) {
                    if (check(down, right, lockZeroCnt, key)) {
                        return true;
                    }

                    key = rotateKey(key, keyLen);
                }
            }
        }

//		for (int i = 0; i < len; i++) {
//			for (int j = 0; j < len; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}

        return false;
    }

    public boolean check(int down, int right, int lockZeroCnt, int[][] key) {
        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                if (map[down + i][right + j] + key[i][j] > 1) {
//                    System.out.println("#" + (map[down + i][right + j] + key[i][j]));
                    return false;
                }

                if (
                        (lockLen - 1 <= down + i && i + down <= len - lockLen) &&
                        (lockLen - 1 <= j + right && j + right <= len - lockLen) &&
                                map[down + i][right + j] == 0 &&
                                key[i][j] == 1
                ) {
//                    System.out.println(i + "," + j);
                	lockZeroCnt--;
                }
            }
        }

//        System.out.println("lockZeroCnt= " + lockZeroCnt);
        return lockZeroCnt == 0 ? true : false;
    }

    public int[][] rotateKey(int[][] key, int keyLen) {
        int[][] rotatedMap = new int[keyLen][keyLen];

        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < keyLen; j++) {
                rotatedMap[i][j] = key[keyLen - 1 - j][i];
            }
        }

//        System.out.println("rotated key");
//        for (int i = 0; i < keyLen; i++) {
//            for (int j = 0; j < keyLen; j++) {
//                System.out.print(rotatedMap[i][j] + " ");
//            }
//            System.out.println();
//        }

        return rotatedMap;
    }
}

//		3
//		0 0 0
//		1 0 0
//		0 1 1
//		3
//		1 1 1
//		1 1 0
//		1 0 1
