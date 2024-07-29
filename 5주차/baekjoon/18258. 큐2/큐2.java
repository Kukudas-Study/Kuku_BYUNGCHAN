import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 큐2 {
    public static void main(String[] args) throws IOException, Exception {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int commandCnt = Integer.parseInt(br.readLine());
            StringTokenizer st = null;
            // 입력값 배열 선언 및 초기화
            List<List<String>> commands = new ArrayList<>(new ArrayList<>());

            for (int i = 0; i < commandCnt; i++) {
                st = new StringTokenizer(br.readLine());

                List<String> command = new ArrayList<>();

                while (st.hasMoreTokens()) {
                    command.add(st.nextToken());
                }
                commands.add(command);
            }
            // 큐 선언 및 초기화
            Queue queue = new Queue();

            try {
                // command 를 순차적으로 수행
                for (int i = 0; i < commands.size(); i++) {
                    List<String> command = commands.get(i);
                    String commandName = command.get(0);
                    // 큐에 정의된 메소드 중 입력받은 명령과 일치하는 메소드만 호출
                    // 입력받은 명령에 따라 매개변수가 없는 경우와 1개 있는 경우로 나눠짐.
                    if (command.size() == 1) {
                        Method method = Queue.class.getDeclaredMethod(commandName);
                        method.invoke(queue);
                    } else if (command.size() == 2) {
                        int param = Integer.parseInt(command.get(1));
                        // 주의! 리플렉션 호출 시 매개변수의 타입을 반드시 명시해야 함.
                        Method method = Queue.class.getDeclaredMethod(commandName, int.class);
                        // push 명령에 대해 NoSuchMethodException 발생
                        // 적절한 매개변수를 제공하지 않으면 NoSuchMethodException이 발생할 수 있습니다.
                        method.invoke(queue, param);
                    }
                }
            } catch (Exception e) {
                System.out.println("command 수행 도중 예외 발생?");
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println("예외 발생?");
            e.getStackTrace();
        }
    }

    public static class Queue {
        private List<Integer> arr;

        public Queue() {
            arr = new ArrayList<Integer>();
        }

        public void push(int X) {
            arr.add(X);
        }

        public void pop() {
            if (arr.size() == 0) {
                System.out.println(-1);
                return;
            }
            int removedNum = arr.remove(0);
            System.out.println(removedNum);
        }

        public void size() {
            System.out.println(arr.size());
        }

        public void empty() {
            if (arr.size() == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        public void front() {
            if (arr.size() == 0) {
                System.out.println(-1);
                return;
            }
            System.out.println(arr.get(0));
        }

        public void back() {
            if (arr.size() == 0) {
                System.out.println(-1);
                return;
            }
            System.out.println(arr.get(arr.size() - 1));
        }
    }
}
