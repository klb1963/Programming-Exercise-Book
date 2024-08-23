package excepton;

public class ExceptionAppl {
    public static void main(String[] args) {
        int a = 0;
        int b = 8;
        try {
            int x = solution(a, b);
            System.out.println("Solution = " + x);
        } catch (NoSolutionException e) {
            System.out.println("No solution");
        } catch (SolutionAnyNumberException e) {
//            e.printStackTrace();
            System.out.println("Solution any number");
            return;
        }  finally {
            System.out.println("Bye, bye");
        }

        System.out.println("Math is great!");

    }

    public static int solution(int a, int b) throws NoSolutionException {
        if (a == 0 && b != 0) {
            throw new NoSolutionException("No solution");
        }
        if (a == 0 && b == 0) {
            throw new SolutionAnyNumberException();
        }
        int res = b / a;
        return res;
    }
}
