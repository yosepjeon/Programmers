package Level2.거리두기확인하기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        Solution solution = new Solution();

        int[] answer = solution.solution(places);
        List<Integer> result = new ArrayList<>();
        for (int element : answer) {
            result.add(element);
        }

        System.out.println(result);
    }
}

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int caseLen = places.length;

        for (int i = 0; i < 5; i++) {
            char[][] map = new char[5][5];
            List<Participant> participants = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                char[] carr = places[i][j].toCharArray();

                for (int k = 0; k < 5; k++) {
                    if (carr[k] == 'P') {
                        participants.add(new Participant(j, k));
                    }

                    map[j][k] = carr[k];
                }
            }

            answer[i] = validate(participants, map);
        }

        return answer;
    }

    public int validate(List<Participant> participants, char[][] map) {
        for (Participant participant : participants) {
            Queue<Element> queue = new LinkedList<>();
            boolean[][] isVisited = new boolean[5][5];

            Element element = new Element(participant.row, participant.col);
            isVisited[element.row][element.col] = true;
            queue.add(element);

            while (!queue.isEmpty()) {
                Element polledElement = queue.poll();

                if (map[polledElement.row][polledElement.col] == 'P' && polledElement.count > 0 && polledElement.count <= 2) {
                    return 0;
                }

                if (polledElement.row - 1 >= 0
                        && (map[polledElement.row - 1][polledElement.col] == 'O' || map[polledElement.row - 1][polledElement.col] == 'P')
                        && !isVisited[polledElement.row - 1][polledElement.col]) {
                    isVisited[polledElement.row - 1][polledElement.col] = true;
                    queue.add(new Element(polledElement.row - 1, polledElement.col, polledElement.count + 1));
                }

                if (polledElement.row + 1 < 5
                        && (map[polledElement.row + 1][polledElement.col] == 'O' || map[polledElement.row + 1][polledElement.col] == 'P')
                        && !isVisited[polledElement.row + 1][polledElement.col]) {
                    isVisited[polledElement.row + 1][polledElement.col] = true;
                    queue.add(new Element(polledElement.row + 1, polledElement.col, polledElement.count + 1));
                }

                if (polledElement.col - 1 >= 0
                        && (map[polledElement.row][polledElement.col - 1] == 'O' || map[polledElement.row][polledElement.col - 1] == 'P')
                        && !isVisited[polledElement.row][polledElement.col - 1]) {
                    isVisited[polledElement.row][polledElement.col - 1] = true;
                    queue.add(new Element(polledElement.row, polledElement.col - 1, polledElement.count + 1));
                }

                if (polledElement.col + 1 < 5
                        && (map[polledElement.row][polledElement.col + 1] == 'O' || map[polledElement.row][polledElement.col + 1] == 'P')
                        && !isVisited[polledElement.row][polledElement.col + 1]) {
                    isVisited[polledElement.row][polledElement.col + 1] = true;
                    queue.add(new Element(polledElement.row, polledElement.col + 1, polledElement.count + 1));
                }
            }
        }

        return 1;
    }

    class Participant {
        int row, col;

        public Participant(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    class Element {
        int row, col;
        int count = 0;

        public Element(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Element(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
